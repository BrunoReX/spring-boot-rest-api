package demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.dto.RoleDTO;
import demo.model.Role;
import demo.repository.RoleRepository;
import demo.service.impl.RoleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
	@Mock
	private RoleRepository roleRepository;

	@InjectMocks
	private RoleServiceImpl roleService;

	@Test
	public void RoleService_CreateRole_ReturnsRoleDTO() {
		Role role = new Role((long) 1, "ADMIN");

		RoleDTO roleDTO = new RoleDTO(role);

		when(roleRepository.save(Mockito.any(Role.class))).thenReturn(role);

		RoleDTO savedRoleDTO = roleService.createRole(roleDTO);

		Assertions.assertThat(savedRoleDTO.getName()).isEqualTo(role.getName());
	}

	@Test
	public void RoleService_GetRoles_ReturnsListRoleDTO() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role((long) 1, "ADMIN"));
		roles.add(new Role((long) 2, "USER"));

		when(roleRepository.findAll()).thenReturn(roles);

		RoleDTO roleResponse_0 = roleService.getRoles().get(0);
		RoleDTO roleResponse_1 = roleService.getRoles().get(1);

		Assertions.assertThat(roleResponse_0.getId()).isEqualByComparingTo(roles.get(0).getId());
		Assertions.assertThat(roleResponse_1.getName()).isEqualTo(roles.get(1).getName());
	}

}

package demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dto.RoleDTO;
import demo.dto.UserRoleDTO;
import demo.model.Role;
import demo.model.UserRole;
import demo.repository.RoleRepository;
import demo.repository.UserRoleRepository;
import demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	private List<UserRole> userRolesDTOtoUserRoles(List<UserRoleDTO> userRolesDTO) {
		List<UserRole> userRoles = new ArrayList<UserRole>();

		if (userRolesDTO != null) {
			for (int i = 0; i < userRolesDTO.size(); i++) {
				UserRoleDTO userRoleDTO = userRolesDTO.get(i);
				UserRole userRole = userRoleRepository.getReferenceById(userRoleDTO.getId());

				if (userRole != null) {
					userRoles.add(userRole);
				}
			}
		}

		return userRoles;
	}

	private Role roleDTOtoRole(RoleDTO roleDTO) {
		Role role = new Role();
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setRoles(userRolesDTOtoUserRoles(roleDTO.getRoles()));

		return role;
	}

	@Override
	public List<RoleDTO> getRoles() {
		List<Role> roles = roleRepository.findAll();
		List<RoleDTO> rolesDTO = RoleDTO.convertList(roles);

		return rolesDTO;
	}

	@Override
	public RoleDTO getRole(Long id) {
		Role role = roleRepository.getReferenceById(id);

		return new RoleDTO(role);
	}

	@Override
	public boolean deleteRole(RoleDTO roleDTO) {
		roleRepository.delete(roleDTOtoRole(roleDTO));

		return true;
	}

	@Override
	public RoleDTO createRole(RoleDTO roleDTO) {
		Role role = new Role();
		role.setName(roleDTO.getName());

		Role newRole = roleRepository.save(role);

		RoleDTO respRoleDTO = new RoleDTO(newRole);
		return respRoleDTO;
	}
}

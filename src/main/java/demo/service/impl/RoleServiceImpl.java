package demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dto.RoleDTO;
import demo.model.Role;
import demo.repository.RoleRepository;
import demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<RoleDTO> getRoles() {
		List<Role> roles = roleRepository.findAll();
		List<RoleDTO> rolesDTO = RoleDTO.convertList(roles);

		return rolesDTO;
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

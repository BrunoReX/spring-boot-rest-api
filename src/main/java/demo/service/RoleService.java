package demo.service;

import java.util.List;

import demo.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getRoles();

	RoleDTO getRole(Long id);

	RoleDTO createRole(RoleDTO roleDTO);

	boolean deleteRole(RoleDTO roleDTO);
}

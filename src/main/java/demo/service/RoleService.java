package demo.service;

import java.util.List;

import demo.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getRoles();
	RoleDTO createRole(RoleDTO roleDTO);
}

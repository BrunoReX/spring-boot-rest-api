package demo.service;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import demo.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getRoles();

	RoleDTO getRole(Long id);

	RoleDTO createRole(RoleDTO roleDTO) throws ResponseStatusException;

	RoleDTO updateRole(RoleDTO roleDTO);

	boolean deleteRole(RoleDTO roleDTO);
}

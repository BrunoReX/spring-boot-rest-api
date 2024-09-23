package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.RoleDTO;
import demo.service.RoleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<List<RoleDTO>> getRoles() {
		List<RoleDTO> roles = roleService.getRoles();

		return ResponseEntity.ok(roles);
	}

	@PostMapping("/roles/add")
	public ResponseEntity<RoleDTO> addRole(@RequestBody @Valid RoleDTO roleDTO) {
		RoleDTO respRoleDTO = roleService.createRole(roleDTO);

		return ResponseEntity.ok(respRoleDTO);
	}
}

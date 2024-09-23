package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.UserDTO;
import demo.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> usersDTO = userService.getUsers();
		
		return ResponseEntity.ok(usersDTO);
	}
	
	@PostMapping("/users/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDTO) {
		UserDTO respUserDTO = userService.createUser(userDTO);
		
		return ResponseEntity.ok(respUserDTO);
	}
}

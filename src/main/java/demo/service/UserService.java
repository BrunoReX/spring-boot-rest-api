package demo.service;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import demo.dto.UserDTO;

public interface UserService {
	List<UserDTO> getUsers();

	UserDTO getUser(Long id);

	UserDTO createUser(UserDTO userDTO) throws ResponseStatusException;

	UserDTO updateUser(UserDTO userDTO);

	boolean deleteUser(UserDTO userDTO);
}

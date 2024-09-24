package demo.service;

import java.util.List;

import demo.dto.UserDTO;

public interface UserService {
	List<UserDTO> getUsers();

	UserDTO getUser(Long id);

	UserDTO createUser(UserDTO userDTO);

	boolean deleteUser(UserDTO userDTO);
}

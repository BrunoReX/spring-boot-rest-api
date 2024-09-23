package demo.service;

import java.util.List;

import demo.dto.UserDTO;

public interface UserService {
	List<UserDTO> getUsers();
	UserDTO createUser(UserDTO userDTO);
}

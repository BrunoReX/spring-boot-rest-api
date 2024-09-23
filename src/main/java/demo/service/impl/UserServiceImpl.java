package demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dto.UserDTO;
import demo.model.Role;
import demo.model.User;
import demo.model.UserRole;
import demo.repository.RoleRepository;
import demo.repository.UserRepository;
import demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	private User userDTOtoUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFullName(userDTO.getFullName());
		user.setPassword(userDTO.getPassword());
		user.setUserName(userDTO.getUserName());

		List<UserRole> userRoles = new ArrayList<UserRole>();

		if (userDTO.getRoles() != null) {
			for (int i = 0; i < userDTO.getRoles().size(); i++) {
				Long userRoleId = userDTO.getRoles().get(i).getRoleId();
				Role role = roleRepository.getReferenceById(userRoleId);

				UserRole userRole = new UserRole();
				userRole.setUser_info(user);
				userRole.setRole(role);

				if (userRole != null) {
					userRoles.add(userRole);
				}
			}
		}

		user.setRoles(userRoles);

		return user;
	}

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = UserDTO.convertList(users);

		return usersDTO;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = userDTOtoUser(userDTO);
		User newUser = userRepository.save(user);

		UserDTO respUserDTO = new UserDTO(newUser);

		return respUserDTO;
	}
}

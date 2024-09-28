package demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import demo.dto.UserDTO;
import demo.dto.UserRoleDTO;
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

	private List<UserRole> userRolesDTOtoUserRoles(List<UserRoleDTO> userRolesDTO, User user) {
		List<UserRole> userRoles = new ArrayList<UserRole>();

		if (userRolesDTO != null) {
			for (int i = 0; i < userRolesDTO.size(); i++) {
				Long userRoleId = userRolesDTO.get(i).getRoleId();
				Role role = roleRepository.getReferenceById(userRoleId);

				if (role != null) {
					UserRole userRole = new UserRole();
					userRole.setUser_info(user);
					userRole.setRole(role);
					userRoles.add(userRole);
				}
			}
		}

		return userRoles;
	}

	private User userDTOtoUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFullName(userDTO.getFullName());
		user.setPassword(userDTO.getPassword());
		user.setUserName(userDTO.getUserName());
		user.setRoles(userRolesDTOtoUserRoles(userDTO.getRoles(), user));

		return user;
	}

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = UserDTO.convertList(users);

		return usersDTO;
	}

	@Override
	public UserDTO getUser(Long id) {
		User user = userRepository.getReferenceById(id);

		return new UserDTO(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws ResponseStatusException {
		// Validar valores como apenas espaços
		if (StringUtils.isAnyBlank(userDTO.getFullName(), userDTO.getUserName(), userDTO.getPassword())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Empty values are not allowed!");
		}

		User user = userDTOtoUser(userDTO);
		User newUser = userRepository.save(user);

		UserDTO respUserDTO = new UserDTO(newUser);

		return respUserDTO;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		User updatedUser = userDTOtoUser(userDTO);
		User origUser = userRepository.getReferenceById(userDTO.getId());

		// Checar se senha foi alterada
		// Se não, utilizar senha original
		if (StringUtils.isBlank(updatedUser.getPassword())) {
			updatedUser.setPassword(origUser.getPassword());
		}

		// Não aceitar valores em branco ou apenas espaços
		if (StringUtils.isBlank(updatedUser.getFullName())) {
			updatedUser.setFullName(origUser.getFullName());
		}

		if (StringUtils.isBlank(updatedUser.getUserName())) {
			updatedUser.setUserName(origUser.getUserName());
		}

		User respUser = userRepository.save(updatedUser);
		UserDTO respUserDTO = new UserDTO(respUser);

		return respUserDTO;
	}

	@Override
	public boolean deleteUser(UserDTO userDTO) {
		userRepository.delete(userDTOtoUser(userDTO));

		return true;
	}
}

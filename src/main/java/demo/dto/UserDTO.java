package demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import demo.model.User;
import demo.model.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotEmpty
	private String fullName;

	@NotEmpty
	private String userName;

	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private List<UserRoleDTO> roles;

	public UserDTO(User user) {
		this.id = user.getId();
		this.fullName = user.getFullName();
		this.userName = user.getUserName();
		this.password = user.getPassword();

		List<UserRole> userRoles = user.getRoles();
		this.roles = UserRoleDTO.convertList(userRoles);
	}

	public static List<UserDTO> convertList(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		if (users != null) {
			for (int i = 0; i < users.size(); i++) {
				usersDTO.add(new UserDTO(users.get(i)));
			}
		}

		return usersDTO;
	}
}

package demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import demo.model.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private Long roleId;
	
	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	private String roleName;
	
	public UserRoleDTO(UserRole userRole) {
		this.id = userRole.getId();
		this.roleId = userRole.getRole().getId();
		this.roleName = userRole.getRole().getName();
	}
	
	public static List<UserRoleDTO> convertList(List<UserRole> userRoles) {
		List<UserRoleDTO> userRolesDTO = new ArrayList<UserRoleDTO>();
		
		for (int i = 0; i < userRoles.size(); i++) {
			userRolesDTO.add(new UserRoleDTO(userRoles.get(i)));
		}
		
		return userRolesDTO;
	}
}

package demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import demo.model.Role;
import demo.model.UserRole;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotEmpty
	@Column(unique = true)
	private String name;

	@JsonIgnore
	private List<UserRoleDTO> roles;

	public RoleDTO(Role role) {
		this.id = role.getId();
		this.name = role.getName();

		List<UserRole> roleRoles = role.getRoles();
		this.roles = UserRoleDTO.convertList(roleRoles);
	}

	public static List<RoleDTO> convertList(List<Role> roles) {
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();

		if (roles != null) {
			for (int i = 0; i < roles.size(); i++) {
				rolesDTO.add(new RoleDTO(roles.get(i)));
			}
		}

		return rolesDTO;
	}
}

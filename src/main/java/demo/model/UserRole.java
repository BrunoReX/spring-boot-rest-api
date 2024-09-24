package demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_role")
@SequenceGenerator(sequenceName = "user_role_entity_seq", name = "user_role_entity_seq", allocationSize = 1)
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_entity_seq")
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user_info", referencedColumnName = "id")
	private User user_info;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_role", referencedColumnName = "id")
	private Role role;
}

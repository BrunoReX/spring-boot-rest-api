package demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_info")
@SequenceGenerator(sequenceName="user_info_entity_seq", name="user_info_entity_seq", allocationSize=1)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_info_entity_seq")
	private Long id;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	@Column(unique=true)
	private String userName;
	
	@NotEmpty
	private String password;
	
	@OneToMany(mappedBy = "user_info", cascade = CascadeType.ALL)
	private List<UserRole> roles;
}

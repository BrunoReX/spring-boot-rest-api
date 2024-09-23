package demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.SequenceGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "role")
@SequenceGenerator(sequenceName="role_entity_seq", name="role_entity_seq", allocationSize=1)
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_entity_seq")
	private Long id;
		
	@NotEmpty
	@Column(unique=true)
	private String name;
}

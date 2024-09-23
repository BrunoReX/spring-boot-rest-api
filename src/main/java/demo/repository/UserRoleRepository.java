package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}

package emsi.iir4.devoirfinal.repository;

import emsi.iir4.devoirfinal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String name);
}

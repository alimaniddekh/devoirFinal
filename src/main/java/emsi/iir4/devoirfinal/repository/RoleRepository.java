package emsi.iir4.devoirfinal.repository;

import emsi.iir4.devoirfinal.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
	public Role findByNom(String nom);

}

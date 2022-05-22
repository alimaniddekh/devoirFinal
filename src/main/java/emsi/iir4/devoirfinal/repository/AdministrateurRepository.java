package emsi.iir4.devoirfinal.repository;

import emsi.iir4.devoirfinal.models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

}

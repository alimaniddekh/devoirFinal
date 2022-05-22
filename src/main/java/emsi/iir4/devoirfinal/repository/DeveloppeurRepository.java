package emsi.iir4.devoirfinal.repository;

import java.util.List;

import emsi.iir4.devoirfinal.models.Developpeur;
import emsi.iir4.devoirfinal.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloppeurRepository extends JpaRepository<Developpeur, Integer> {

	@Query("select d from Developpeur d JOIN d.ticks t where t.idT=:idT")
	List<Ticket> devTick(@Param("idT") int idT);
}

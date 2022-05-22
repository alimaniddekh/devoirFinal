package emsi.iir4.devoirfinal.repository;

import java.util.List;

import emsi.iir4.devoirfinal.models.Client;
import emsi.iir4.devoirfinal.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("select c from Client c JOIN c.ticks t where t.idT=:idT")
	List<Ticket> TickClient(@Param("idT") int idT);

	
}

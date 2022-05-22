package emsi.iir4.devoirfinal.repository;

import java.util.List;

import emsi.iir4.devoirfinal.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("select t from Ticket t where t.attr=false")
    public List<Ticket> ticketNonAttribue();
}

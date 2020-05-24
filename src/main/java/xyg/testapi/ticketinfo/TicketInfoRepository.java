package xyg.testapi.ticketinfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketInfoRepository extends JpaRepository<TicketInfo, Long>{
	public Optional<TicketInfo> findByIncident(String incident);
	//public Optional<TicketInfo> findByServername(String servername);
	@Query(value="select * from ticketinfo where servername=?1 and ostype=?2",nativeQuery=true)
    public Optional<TicketInfo> findByServername(String servername, String ostype);
	
	
	
}
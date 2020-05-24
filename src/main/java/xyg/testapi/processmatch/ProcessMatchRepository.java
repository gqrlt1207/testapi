package xyg.testapi.processmatch;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessMatchRepository extends JpaRepository<ProcessMatch, Long>{
	//public Optional<ProcessMatch> findByIncident(String incident);
	//public Optional<TicketInfo> findByServername(String servername);
	@Query(value="select * from processmatch where alerttype=?1 and ostype=?2",nativeQuery=true)
    public Optional<ProcessMatch> findByComposition(String alerttype,String ostype);
	public Optional<ProcessMatch> findByBonitaprocess(String bonitaprocess);
	
		
}
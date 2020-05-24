package xyg.testapi.userinfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	//public Optional<UserInfo> findByIncident(String incident);
	//public Optional<TicketInfo> findByServername(String servername);
	//@Query(value="select * from ticketinfo where servername=?1 and ostype=?2",nativeQuery=true)
    //public Optional<UserInfo> findByServername(String servername, String ostype);
	public Optional<UserInfo> findByUsername(String username);
	public Optional<UserInfo> findByFirstname(String firstname);
	public Optional<UserInfo> findByLastname(String lastname);
	
	
	
}
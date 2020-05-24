package xyg.testapi.ticketinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
//@RequiredArgsConstructor

public class TicketInfoService {
	
	@Autowired
    private final TicketInfoRepository ticketInfoRepository;
	
    
  public TicketInfoService(TicketInfoRepository ticketInfoRepository) {
      this.ticketInfoRepository = ticketInfoRepository;
    }

    public List<TicketInfo> findAll() {
    	System.out.println("Start fetching all data from ticketinfo!!");
    	Stream.of(ticketInfoRepository.findAll()).forEach(System.out::println);
        return ticketInfoRepository.findAll();
    }
    
    public Optional<TicketInfo> findById(Long id) {
    	System.out.println("Received id in service class : " + id);
        return ticketInfoRepository.findById(id);
    }
    
    
    public Optional<TicketInfo> findByIncident(String incident){
    	return ticketInfoRepository.findByIncident(incident);
    }
    
    public Optional<TicketInfo> findByServername(String servername, String ostype){
    	System.out.println(servername + " " + ostype);
    	return ticketInfoRepository.findByServername(servername,ostype);
    }
    
    
    public TicketInfo save(TicketInfo id) {
        return ticketInfoRepository.save(id);
    }

    public void deleteById(Long id) {
        ticketInfoRepository.deleteById(id);
    }
}


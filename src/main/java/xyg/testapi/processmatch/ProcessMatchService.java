package xyg.testapi.processmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
//@RequiredArgsConstructor

public class ProcessMatchService {
	
	@Autowired
    private final ProcessMatchRepository processMatchRepository;
	
    
  public ProcessMatchService(ProcessMatchRepository processMatchRepository) {
      this.processMatchRepository = processMatchRepository;
    }

    public List<ProcessMatch> findAll() {
    	System.out.println("Start fetching all data from userinfo!!");
    	Stream.of(processMatchRepository.findAll()).forEach(System.out::println);
        return processMatchRepository.findAll();
    }
    
    public Optional<ProcessMatch> findById(Long id) {
    	System.out.println("Received id in service class : " + id);
        return processMatchRepository.findById(id);
    }
    
    
    public Optional<ProcessMatch> findByBonitaprocess(String bonitaprocess){
    	return processMatchRepository.findByBonitaprocess(bonitaprocess);
    }
    
    public Optional<ProcessMatch> findByComposition(String alerttype,String ostype){
    	System.out.println(alerttype+" "+ostype);
    	return processMatchRepository.findByComposition(alerttype,ostype);
    }
    
        
    public ProcessMatch save(ProcessMatch id) {
        return processMatchRepository.save(id);
    }

    public void deleteById(Long id) {
        processMatchRepository.deleteById(id);
    }
}


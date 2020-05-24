package xyg.testapi.processmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"},maxAge = 4800, allowCredentials = "false") 
@RestController
@RequestMapping("/api/v1/process")

//@RequiredArgsConstructor
public class ProcessMatchAPI {
	
	@Autowired
    private final ProcessMatchService processMatchService;
        
    public ProcessMatchAPI(ProcessMatchService processMatchService) {
        this.processMatchService = processMatchService;
    }

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<ProcessMatch>> findAll() {
        return ResponseEntity.ok(processMatchService.findAll());
    }
    
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity create(@Valid @RequestBody ProcessMatch tinfo) {
        return ResponseEntity.ok(processMatchService.save(tinfo));
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public ResponseEntity<ProcessMatch> findById(@PathVariable Long id) {
    	System.out.println("Id is " + id);
        Optional<ProcessMatch> stock = processMatchService.findById(id);
        if (!stock.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        
            return ResponseEntity.ok(stock.get());
    }
    
    
    @GetMapping(path="/process={process}",produces = "application/json")
    public ResponseEntity<ProcessMatch> findByBonitaprocess(@PathVariable String process) {
    	System.out.println("process is " + process);
        Optional<ProcessMatch> stock = processMatchService.findByBonitaprocess(process);
              
        return ResponseEntity.ok(stock.get());
    }
    
    @GetMapping(path="/compoinfo={compoinfo}",produces = "application/json")
    public ResponseEntity<ProcessMatch> findByComposition(@PathVariable String compoinfo) {
    	String[] str = compoinfo.split(":");
    	String alerttype = str[0];
    	String ostype = str[1];
    	System.out.println("received data: " + alerttype + " " + ostype);
        Optional<ProcessMatch> stock = processMatchService.findByComposition(alerttype,ostype);
              
        return ResponseEntity.ok(stock.get());
    }
    
    
    @PutMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProcessMatch> update(@PathVariable Long id, @Valid @RequestBody ProcessMatch product) {
        if (!processMatchService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(processMatchService.save(product));
    }
    
    @CrossOrigin(origins = {"http://localhost:4200"},maxAge = 4800, allowCredentials = "false")
    @DeleteMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!processMatchService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        processMatchService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}



package xyg.testapi.ticketinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/ticket")

//@RequiredArgsConstructor
public class TicketInfoAPI {
	
	@Autowired
    private final TicketInfoService ticketInfoService;
        
    public TicketInfoAPI(TicketInfoService ticketInfoService) {
        this.ticketInfoService = ticketInfoService;
    }

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<TicketInfo>> findAll() {
        return ResponseEntity.ok(ticketInfoService.findAll());
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity create(@Valid @RequestBody TicketInfo tinfo) {
        return ResponseEntity.ok(ticketInfoService.save(tinfo));
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public ResponseEntity<TicketInfo> findById(@PathVariable Long id) {
    	System.out.println("Id is " + id);
        Optional<TicketInfo> stock = ticketInfoService.findById(id);
        if (!stock.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        
            return ResponseEntity.ok(stock.get());
    }
    
    
    @GetMapping(path="/incident={incident}",produces = "application/json")
    public ResponseEntity<TicketInfo> findByIncident(@PathVariable String incident) {
    	System.out.println("Incident is " + incident);
        Optional<TicketInfo> stock = ticketInfoService.findByIncident(incident);
              
        return ResponseEntity.ok(stock.get());
    }
    
    @GetMapping(path="/compoinfo={compoinfo}",produces = "application/json")
    public ResponseEntity<TicketInfo> findByServername(@PathVariable String compoinfo) {
    	String[] str = compoinfo.split(":");
    	String servername = str[0];
    	String ostype = str[1];
    	System.out.println("received data: " + servername + " " + ostype);
        Optional<TicketInfo> stock = ticketInfoService.findByServername(servername,ostype);
              
        return ResponseEntity.ok(stock.get());
    }
    
    
    @PutMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<TicketInfo> update(@PathVariable Long id, @Valid @RequestBody TicketInfo product) {
        if (!ticketInfoService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ticketInfoService.save(product));
    }

    @DeleteMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!ticketInfoService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        ticketInfoService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}


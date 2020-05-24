package xyg.testapi.userinfo;

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
@RequestMapping("/api/v1/userinfo")

//@RequiredArgsConstructor
public class UserInfoAPI {
	
	@Autowired
    private final UserInfoService userInfoService;
        
    public UserInfoAPI(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<UserInfo>> findAll() {
        return ResponseEntity.ok(userInfoService.findAll());
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity create(@Valid @RequestBody UserInfo tinfo) {
        return ResponseEntity.ok(userInfoService.save(tinfo));
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public ResponseEntity<UserInfo> findById(@PathVariable Long id) {
    	System.out.println("Id is " + id);
        Optional<UserInfo> stock = userInfoService.findById(id);
        if (!stock.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        
            return ResponseEntity.ok(stock.get());
    }
    
    
    @GetMapping(path="/username={username}",produces = "application/json")
    public ResponseEntity<UserInfo> findByUsername(@PathVariable String username) {
    	System.out.println("username is " + username);
        Optional<UserInfo> stock = userInfoService.findByUsername(username);
              
        return ResponseEntity.ok(stock.get());
    }
    
    @GetMapping(path="/firstname={firstname}",produces = "application/json")
    public ResponseEntity<UserInfo> findByFirstname(@PathVariable String firstname) {
    	System.out.println("received data: " + firstname);
        Optional<UserInfo> stock = userInfoService.findByFirstname(firstname);
              
        return ResponseEntity.ok(stock.get());
    }
    
    @GetMapping(path="/lastname={lastname}",produces = "application/json")
    public ResponseEntity<UserInfo> findByLastname(@PathVariable String lastname) {
    	System.out.println("received data: " + lastname);
        Optional<UserInfo> stock = userInfoService.findByLastname(lastname);
              
        return ResponseEntity.ok(stock.get());
    }
    
    @PutMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserInfo> update(@PathVariable Long id, @Valid @RequestBody UserInfo product) {
        if (!userInfoService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userInfoService.save(product));
    }

    @DeleteMapping(path="/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userInfoService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        userInfoService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}

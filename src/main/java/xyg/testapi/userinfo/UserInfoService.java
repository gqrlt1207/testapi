package xyg.testapi.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
//@RequiredArgsConstructor

public class UserInfoService {
	
	@Autowired
    private final UserInfoRepository userInfoRepository;
	
    
  public UserInfoService(UserInfoRepository userInfoRepository) {
      this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfo> findAll() {
    	System.out.println("Start fetching all data from userinfo!!");
    	Stream.of(userInfoRepository.findAll()).forEach(System.out::println);
        return userInfoRepository.findAll();
    }
    
    public Optional<UserInfo> findById(Long id) {
    	System.out.println("Received id in service class : " + id);
        return userInfoRepository.findById(id);
    }
    
    
    public Optional<UserInfo> findByUsername(String username){
    	return userInfoRepository.findByUsername(username);
    }
    
    public Optional<UserInfo> findByFirstname(String firstname){
    	System.out.println(firstname);
    	return userInfoRepository.findByFirstname(firstname);
    }
    
    public Optional<UserInfo> findByLastname(String lastname){
    	System.out.println(lastname);
    	return userInfoRepository.findByFirstname(lastname);
    }
    
    public UserInfo save(UserInfo id) {
        return userInfoRepository.save(id);
    }

    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }
}



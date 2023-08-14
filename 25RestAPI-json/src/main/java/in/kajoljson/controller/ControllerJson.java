package in.kajoljson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.kajoljson.DAO.*;
import java.util.*;  
@RestController
public class ControllerJson {

	private Map<Integer,User>storage1=new HashMap<>();
	
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody User user)
	{
		storage1.put(user.getId(), user);
		
		return new ResponseEntity<String>("data save",HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public User getData(@RequestParam("id") Integer id)
	{
      if(storage1.containsKey(id))
    	  return storage1.get(id);
      return null;
	}
}

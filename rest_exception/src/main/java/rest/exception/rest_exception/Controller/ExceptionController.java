package rest.exception.rest_exception.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rest.exception.rest_exception.EXceptionDAO.UserNotFoundException;

@RestController
public class ExceptionController {

	@GetMapping("/welcome")
	public String welcome()
	{
		int i=1/0;
		return "Welcome";
	}
	
	@GetMapping("/user/{userid}")
	public String getuser(@PathVariable("userid")  Integer id) throws Exception
	{
	   if(id==100)
		   return "kajol";
	   else if(id==200)
		   return "akhil";
	   else
		   throw new UserNotFoundException("user note found");
	}
}
 
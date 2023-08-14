package in.actuator.springbootactuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

	@GetMapping("/")
	public String welcome()
	{
		return "hello here......";
	}
}

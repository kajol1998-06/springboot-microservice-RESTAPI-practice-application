package in.RESTAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.RESTAPI.DAO.Passenger;
import in.RESTAPI.DAO.Ticket;
import in.RESTAPI.Service.BookingServiceImpl;

@RestController
public class BookingController {

	@Autowired
	BookingServiceImpl services;

	@PostMapping(value="/book",
			     consumes= {"application/json"})
	public ResponseEntity<Ticket> Bookingticket(@RequestBody Passenger passenger)
	{
		Ticket t=new Ticket();
		t=services.bookTicket(passenger);
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
	//query peram ("localhost:8080/get?id=2")
//	@GetMapping(value="/get",
//			    produces="application/json")
//	public Ticket getTicket(@RequestParam("id") Integer id)
//	{
//		return services.getTicket(id);
//	}

	//path veriable ("localhost:8080/get/2")
	@GetMapping(value="/get/{id}",
		    produces={"application/json"}
	)
	public Ticket getTicket(@PathVariable("id") Integer id)
	{
		return services.getTicket(id);
	}

}

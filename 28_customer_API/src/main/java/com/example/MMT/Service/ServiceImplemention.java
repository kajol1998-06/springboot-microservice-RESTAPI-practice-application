package com.example.MMT.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.MMT.DAO.Passenger;
import com.example.MMT.DAO.Ticket;

@Service
public class ServiceImplemention implements BookTicketService {

	@Override
	public Ticket getBook(Passenger p) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket>r=rt.postForEntity("http://localhost:8080/book", rt, Ticket.class);
		Ticket t=r.getBody();
		return t;
	}

	@Override
	public Ticket getTicket(Integer i) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket>r=rt.getForEntity("http://localhost:8080/get/{id}", Ticket.class, i);
		Ticket t=r.getBody();
		return t;
	}

}

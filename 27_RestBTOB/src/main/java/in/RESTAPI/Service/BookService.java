package in.RESTAPI.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.RESTAPI.DAO.Passenger;
import in.RESTAPI.DAO.Ticket;

@Service
public class BookService implements BookingServiceImpl {

	public Map<Integer,Ticket>ticketstorage=new HashMap<>();
	Integer ticketnumber=1;
	@Override
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		Ticket t=new Ticket();
	    BeanUtils.copyProperties(passenger,t);
	    t.setPrice(500);
	    t.setStatus("confirm");
	    t.setTicketNumber(ticketnumber);
	    ticketstorage.put(ticketnumber, t);
	    ticketnumber++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		// TODO Auto-generated method stub
		if(ticketstorage.containsKey(ticketNumber))
			return ticketstorage.get(ticketNumber);
		return null;
	}

}

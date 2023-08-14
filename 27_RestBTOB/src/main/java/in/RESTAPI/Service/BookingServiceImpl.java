package in.RESTAPI.Service;

import in.RESTAPI.DAO.Passenger;
import in.RESTAPI.DAO.Ticket;

public interface BookingServiceImpl {

	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketNumber);

}

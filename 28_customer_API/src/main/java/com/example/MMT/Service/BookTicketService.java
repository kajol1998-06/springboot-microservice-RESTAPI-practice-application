package com.example.MMT.Service;

import com.example.MMT.DAO.Passenger;
import com.example.MMT.DAO.Ticket;

public interface BookTicketService {
	
	public Ticket getBook(Passenger p);
	public Ticket getTicket(Integer i);

}

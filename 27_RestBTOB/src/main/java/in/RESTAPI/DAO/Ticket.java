package in.RESTAPI.DAO;

import lombok.Data;

@Data
public class Ticket {


    private String name;
    private String from;
    private String to;
    private String date;
    private Integer trainNumber;
    private double price;
    private Integer ticketNumber;
    private String status;

}

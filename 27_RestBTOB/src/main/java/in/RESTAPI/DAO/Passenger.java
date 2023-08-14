package in.RESTAPI.DAO;

import lombok.Data;

@Data
public class Passenger {

    private String name;
    private String from;
    private String to;
    private String date;
    private Integer trainNumber;
}

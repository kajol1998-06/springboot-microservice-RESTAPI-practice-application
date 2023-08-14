package rest.exception.rest_exception.EXceptionDAO;


import java.time.LocalDate;

import lombok.Data;

@Data
public class ErrorInfo {
	
	String msg;
	String code;
	LocalDate time;

}

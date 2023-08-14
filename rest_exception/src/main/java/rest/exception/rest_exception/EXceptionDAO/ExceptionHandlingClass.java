package rest.exception.rest_exception.EXceptionDAO;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingClass {

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ErrorInfo> Exceptionhandle(Exception e)
	{
		ErrorInfo er=new ErrorInfo();
		er.setMsg(e.getMessage());
		er.setCode("SBL10003R");
		er.setTime(LocalDate.now());
		
		return new ResponseEntity<>(er,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
}

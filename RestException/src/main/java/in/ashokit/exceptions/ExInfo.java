package in.ashokit.exceptions;

import java.time.LocalDate;

public class ExInfo {
	
	String message;
	String excode;
	LocalDate date;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExcode() {
		return excode;
	}
	public void setExcode(String excode) {
		this.excode = excode;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	


}

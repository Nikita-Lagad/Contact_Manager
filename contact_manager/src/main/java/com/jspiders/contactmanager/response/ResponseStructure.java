package com.jspiders.contactmanager.response;

import lombok.Data;

@Data
public class ResponseStructure <T>{
	
	public String message;
	public T data;
	public int status;
	
	

}

package com.project.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvicer {
	
	@ExceptionHandler(IdnotFoundException.class)
	public ResponseEntity<Object> isException(IdnotFoundException e) 
	{
		Map<String, Object> errmsg=new HashMap<>();
		 errmsg.put("Message", e.getMessage());
		 errmsg.put("error", "Id Not Found...!");
		
		 return new ResponseEntity<Object>(errmsg,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<Object> isProductException(ProductIdNotFoundException e)
	{
		Map<String,Object> errmsg=new HashMap<>();
		errmsg.put("error", "Product_Id Not Found...");
		errmsg.put("Message", e.getMessage());
		return new ResponseEntity<Object>(errmsg,HttpStatus.NOT_FOUND);
	}

}

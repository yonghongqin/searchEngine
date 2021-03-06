package com.amdocs.optima.searchEngine.framework;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.amdocs.optima.searchEngine.base.utils.IndexManager;


@ControllerAdvice
public class GlobalExceptionHandler {
    
	private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler({Exception.class,RuntimeException.class})
    public String handleException(HttpServletRequest request, Exception ex) {
        log.error("Exception:" + ex.getStackTrace());
        ex.printStackTrace();
        return "GlobalError";
    }
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="404")
    public String handle404Exception(HttpServletRequest request, Exception ex) {
        log.error("Exception:" + ex.getStackTrace());
        ex.printStackTrace();
        return "GlobalError";
    }

//	@ExceptionHandler(SQLException.class)
//	public String handleSQLException(HttpServletRequest request, Exception ex){
//		log.info("SQLException Occured:: URL="+request.getRequestURL());
//		return "database_error";
//	}
//	
//	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
//	@ExceptionHandler(IOException.class)
//	public void handleIOException(){
//		log.error("IOException handler executed");
//		//returning 404 error code
//	}
}

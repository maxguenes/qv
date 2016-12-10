package com.techbeat.qv.web.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.Status;
import com.techbeat.qv.models.exceptions.InsufficientStockException;
import com.techbeat.qv.models.exceptions.QVException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleSQLException(HttpServletRequest request, SQLException ex){
		logger.error("SQL Exception handled", ex);
		return "database_error";
	}
	
	@ExceptionHandler(HibernateException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Check object constraints")
	public String handleHibernateException(HttpServletRequest request, HibernateException ex){
		logger.error("Hibernate exception handled", ex);
		return "Malformed object";
	}
	
	@ExceptionHandler(InsufficientStockException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Insuficient Stock")
	public ProductOrder handleInsufficientStockException(HttpServletRequest request, InsufficientStockException ex){
		return new ProductOrder(Status.INSUFFICIENT_STOCK);
	}
	
	@ExceptionHandler(QVException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public String handleQVException(HttpServletRequest request, QVException ex){
		return ex.getMessage();
	}
	
}
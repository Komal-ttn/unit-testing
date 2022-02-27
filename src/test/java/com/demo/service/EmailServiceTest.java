package com.demo.service;
import com.demo.domain.Order;
import com.demo.service.EmailService;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
	
	@Mock
	Order order;                //Order order=mock(Order.class);
	
	
	@InjectMocks
	EmailService email;       //EmailService email=new EmailService(order);
	
	 @Rule
	  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_GetInstanceOfEmailService() {  
		//Given
		
		//When
		EmailService EmailServiceInstance=EmailService.getInstance();  //Return type EmailService
		//Then
		assertTrue(EmailServiceInstance instanceof EmailService);
		
	}
	/*
	 * void sendEmail(Order order) {
        order.setCustomerNotified(false);
        throw new RuntimeException("An Exception Occurred");
    }
	 * 
	 */
	
	@Test
	public void test_sendEmailVoidTypeWhichThrowsException() {
		//Given
	
	    exception.expectMessage("An Exception Occurred");
	       
		//When
		exception.expect(RuntimeException.class);
		//Then
	    Order orderDetails=new Order(10,"Maggie",200);
		email.sendEmail(orderDetails);
	}
	/*
	 *   boolean sendEmail(Order order, String cc) {
        order.setCustomerNotified(true);
        return true;
    }
}
	 */
	@Test
	public void test_sendEmailBooleanTypeWhichReturnsTrue() {
		
		 Order orderDetails1=new Order(10,"Maggie",200);	
		 
		 assertTrue(
				 email.sendEmail(orderDetails1, "Komal"));
		 
		// assertFalse(email.sendEmail(orderDetails1,"Maria"));  //Will fail the test
	
		
		
	}

	
	

}
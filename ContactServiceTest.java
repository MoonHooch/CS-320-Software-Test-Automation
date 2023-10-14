// Author: Christian Delegas
// Date: 10/03/2023
// Class: CS-320-R1873 Software Test Automation & QA
// Project One

package ChristianDelegasCS320.CS320_Module_Six_Project_DELEGAS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class ContactServiceTest {

	@Test
	@DisplayName("Contact service unique ID increment test")
	void contactServiceUniqueId() {
		ContactService cs = new ContactService();
		assertTrue(cs.nextContactId == 1L);
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		assertTrue(cs.nextContactId == 2L);
	}
	
	@Test
	@DisplayName("Contact service delete contact test")
	void contactServiceDeleteContact() {
		ContactService cs = new ContactService();
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		assertNotNull(cs.findContact("1"));
		cs.deleteContact("1");
		assertNull(cs.findContact("1"));
	}
	
	@Test
	@DisplayName("Contact service update first name test")
	void contactServiceUpdateFirstName() {
		ContactService cs = new ContactService();
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		cs.updateContact("1", "Chuck", "Dickens", "2241233212", "48 Doughty Street");
		assertTrue(cs.findContact("1").getFirstName().equals("Chuck"));
	}
	
	@Test
	@DisplayName("Contact service update last name test")
	void contactServiceUpdateLastName() {
		ContactService cs = new ContactService();
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		cs.updateContact("1", "Charles", "Richards", "2241233212", "48 Doughty Street");
		assertTrue(cs.findContact("1").getLastName().equals("Richards"));
	}
	
	@Test
	@DisplayName("Contact service update phone number test")
	void contactServiceUpdatePhone() {
		ContactService cs = new ContactService();
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		cs.updateContact("1", "Charles", "Richards", "9999999999", "48 Doughty Street");
		assertTrue(cs.findContact("1").getPhone().equals("9999999999"));
	}
	
	@Test
	@DisplayName("Contact service update address")
	void contactServiceUpdateAddress() {
		ContactService cs = new ContactService();
		cs.addContact("Charles", "Dickens", "2241233212", "48 Doughty Street");
		cs.updateContact("1", "Charles", "Richards", "9999999999", "16 Young Street");
		assertTrue(cs.findContact("1").getAddress().equals("16 Young Street"));
	}
	
	@Test
	@DisplayName("Contact service validator with invalid ID test")
	public void validatorInvalidIdTest() {
		ContactService cs = new ContactService();;
		// 0 characters
	    try {
	    	cs.isValidInput("", "Charlesssss", "Dickens", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	    
	    // 11 characters
	    try {
	    	cs.isValidInput("10000000000", "Charles", "Dickens", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	} 
	
	@Test
	@DisplayName("Contact service validator with invalid first name test")
	public void validatorInvalidFirstNameTest() {
		ContactService cs = new ContactService();;
		// 0 characters
	    try {
	    	cs.isValidInput("1", "", "Dickens", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	    // 11 characters
	    try {
	    	cs.isValidInput("1", "Charlesssss", "Dickens", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	}
	    
	@Test
	@DisplayName("Contact service validator with invalid last name test")
	public void validatorInvalidLastNameTest() {
		ContactService cs = new ContactService();;
		// 0 characters
	    try {
	    	cs.isValidInput("1", "Charles", "", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	    // 11 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickensssss", "2241233212", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	} 
	
	@Test
	@DisplayName("Contact service validator with invalid phone test")
	public void validatorInvalidPhoneTest() {
		ContactService cs = new ContactService();;
		// 0 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickens", "", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
		// 9 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickens", "224123321", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	    // 11 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickens", "22412332121", "48 Doughty Street");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	}
	@Test
	@DisplayName("Contact service validator with invalid address test")
	public void validatorInvalidAddressTest() {
		ContactService cs = new ContactService();;
		// 0 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickens", "2241233212", "");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	    // 31 characters
	    try {
	    	cs.isValidInput("1", "Charles", "Dickens", "2241233212", "48 Doughty Street              ");
	        fail("Expected IllegalArgumentException, but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	    }
	} 
}

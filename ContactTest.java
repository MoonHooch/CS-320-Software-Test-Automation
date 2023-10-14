// Author: Christian Delegas
// Date: 10/03/2023
// Class: CS-320-R1873 Software Test Automation & QA
// Project One

package ChristianDelegasCS320.CS320_Module_Six_Project_DELEGAS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {

	
	@Test
	@DisplayName("Contact constructor with valid inputs test")
	void contactConstructorTest() {
		Contact contact = new Contact("1000000001", "Charles", "Dickens", "2241233212", "48 Doughty Street");
		assertTrue(contact.getContactId().equals("1000000001"));
		assertTrue(contact.getFirstName().equals("Charles"));
		assertTrue(contact.getLastName().equals("Dickens"));
		assertTrue(contact.getPhone().equals("2241233212"));
		assertTrue(contact.getAddress().equals("48 Doughty Street"));
	}
	
	
	@Test
	@DisplayName("Contact constructor invalid first name boundary test")
	void contactFirstNameBoundary() {
		// 0 character test
		try {
			new Contact("1000000001", "", "Dickens", "2241233212", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		// 11 character test
		try {
			new Contact("1000000001", "Charlesssss", "Dickens", "2241233212", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		
	}
	
	@Test
	@DisplayName("Contact constructor invalid last name boundary test")
	void contactLastNameBoundary() {
		// 0 character test
		try {
			new Contact("1000000001", "Charles", "", "2241233212", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		// 11 character test
		try {
			new Contact("1000000001", "Charles", "Dickensssss", "2241233212", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		
	}
	
	@Test
	@DisplayName("Contact constructor invalid phone boundary test")
	void contactPhoneBoundary() {
		// 0 character test
		try {
			new Contact("1000000001", "Charles", "Dickens", "", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		// 9 character test
		try {
			new Contact("1000000001", "Charles", "Dickens", "123451234", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		// 11 character test
		try {
			new Contact("1000000001", "Charles", "Dickens", "12345123451", "48 Doughty Street");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		
	}
	
	@Test
	@DisplayName("Contact constructor invalid address boundary test")
	void contactAddressBoundary() {
		// 0 character test
		try {
			new Contact("1000000001", "Charles", "Dickens", "1234567890", "");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
		// 31 character test
		try {
			new Contact("1000000001", "Charles", "Dickens", "1234567890", "48 Doughty Street              ");
			fail("Expected IllegalArgumentException, but no exception was thrown.");
		} catch (IllegalArgumentException e) {
		}
	}
}



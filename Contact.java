// Author: Christian Delegas
// Date: 10/03/2023
// Class: CS-320-R1873 Software Test Automation & QA
// Project One

package ChristianDelegasCS320.CS320_Module_Six_Project_DELEGAS;

public class Contact {
	final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Input validation step
		if (!isValidInput(contactId, firstName, lastName, phone, address)) {
			throw new IllegalArgumentException("Could not create contact!");
		}
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

// Input validation
	public boolean isValidInput(String contactId, String firstName, String lastName, String phone, String address) {
		boolean isValid = true;
		// Contact ID
		if (contactId.length() > 10 || contactId == null) {
			isValid = false;
			throw new IllegalArgumentException("Contact ID must be between 0 and 10 characters!");
		}
		// First name
		if (firstName.length() > 10 || firstName.length() <= 0 || firstName == null) {
			isValid = false;
			throw new IllegalArgumentException("First name must be between 0 and 10 characters!");
		}
		// Last name
		if (lastName.length() > 10 || lastName.length() <= 0 || lastName == null) {
			isValid = false;
			throw new IllegalArgumentException("Last name must be between 0 and 10 characters!");
		}
		// Phone
		if (phone.length() != 10 || phone == null) {
			isValid = false;
			throw new IllegalArgumentException("Phone number must be exactly 10 digits!");
		}
		// Address
		if (address.length() > 30 || address.length() <= 0 || address == null) {
			isValid = false;
			throw new IllegalArgumentException("Address cannot exceed 30 characters in length!");
		}
		return isValid;
	}
}
	

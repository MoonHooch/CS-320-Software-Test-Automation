// Author: Christian Delegas
// Date: 10/03/2023
// Class: CS-320-R1873 Software Test Automation & QA
// Project One

package ChristianDelegasCS320.CS320_Module_Six_Project_DELEGAS;

import java.util.ArrayList;


public class ContactService {
	private ArrayList<Contact> contacts;
	long nextContactId = 1L;
	final long totalId = 9999999999L;
	
	// Constructor
	public ContactService() {
		contacts = new ArrayList<>();
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
	
	// Creates and adds new contacts to list
	public void addContact(String firstName, String lastName, String phone, String address) {
		// Generates a unique contact ID for each contact 
		if (nextContactId < totalId) {
			String contactId = String.valueOf(nextContactId);
			// Increments for unique ID
			nextContactId++;
			// Validation step to prevent shared contact IDs
			if (findContact(contactId) != null) {
				throw new IllegalArgumentException("Contact ID " + contactId + " already in use!");
			}
				// Adds the contact to the contact list
				Contact contact = new Contact(contactId, firstName, lastName, phone, address);
				contacts.add(contact);
			}
		}
	
	// Removes a contact from the list
    public void deleteContact(String contactId) {
    	Contact contactToDelete = findContact(contactId);
    	// Contact doesn't exist
        if (contactToDelete == null) {
        	System.out.println("Contact couldn't be found!");
        }
        // Contact exists
        else {
        	contacts.remove(contactToDelete);
        	System.out.println("Contact deleted!");
        }
    }
    
    public Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }
	
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {    	
    	// Validates input
    	if (isValidInput(contactId, firstName, lastName, phone, address)) {
	    	// Searches for contact by ID
	        for (Contact contact : contacts) {
	            if (contact.getContactId().equals(contactId)) {
	                contact.setFirstName(firstName);
	                contact.setLastName(lastName);
	                contact.setPhone(phone);
	                contact.setAddress(address);
	                return; 
	            }
            }
        }
    }
	
	
}

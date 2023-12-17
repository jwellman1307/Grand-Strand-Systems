package Contact;

public class Contact {
	
	private static final int CONTACT_PHONENUM_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH = 10;
	private static final byte CONTACT_FNAME_LENGTH = 10;
	private static final byte CONTACT_LNAME_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;
	private static final String INITIALIZER = "INITIAL";
	private static final String INITIALIZER_NUM = "1234567890";
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact() {
		this.contactId = INITIALIZER;
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId) {
		updateContactId(contactId);
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		this.lastName = INITIALIZER;
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}
	
	public final String getContactId() {
		return contactId;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	
	public final String getLastName() {
		return lastName;
	}
	
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	
	public final String getAddress() {
		return address;
	}
	
	public void updateFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("name cannot be empty.");
		}
		
		else if (firstName.length() > CONTACT_FNAME_LENGTH) {
			throw new IllegalArgumentException("First name cannot be longer than ten characters.");
		}
		
		else {
			this.firstName = firstName;
		}
	}
	
	
	public void updateLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("name cannot be empty.");
		}
		
		else if (lastName.length() > CONTACT_LNAME_LENGTH) {
			throw new IllegalArgumentException("Name cannot be longer than ten characters.");
		}
		
		else {
			this.lastName = lastName;
		}
	}
	
	public void updatePhoneNumber(String phoneNumber) {
		String regex = "[0-9]+";
		if(phoneNumber == null) {
			throw new IllegalArgumentException("Phone number cannot be empty.");
		}
		
		else if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
			throw new IllegalArgumentException("Phone number must be ten characters.");
		}
		
		else if(!phoneNumber.matches(regex)) {
			throw new IllegalArgumentException("Phone number must be digits.");
		}
		
		else {
			this.phoneNumber = phoneNumber;
		}
	}
	
	public void updateAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("Address cannot be empty.");
		}
		
		else if (address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
		}
		
		else {
			this.address = address;
		}
	}
	
	public void updateContactId(String contactId) {
		if(contactId == null) {
			throw new IllegalArgumentException("Id cannot be empty.");
		}
		
		else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Id cannot be longer than ten characters.");
		}
		
		else {
			this.contactId = contactId;
		}
	}
	
}
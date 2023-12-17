package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
	
	@BeforeEach
	void setUp() {
		contactId = "a123456789";
		firstNameTest = "July";
		lastNameTest = "Wellman";
		phoneNumberTest = "1234567890";
		addressTest = "1234 South Street";
		tooLongContactId = "12345678910";
		tooLongFirstName = "A really long first name";
		tooLongLastName = "A really long last name";
		tooLongPhoneNumber = "12345678910";
		tooShortPhoneNumber = "123456789";
		tooLongAddress = "A really long address that is more than thirty characters in length";
	}
	
	@Test
	void contactTest() {
		Contact contact = new Contact();
		assertAll("constructor",() -> assertNotNull(contact.getContactId()),
								() -> assertNotNull(contact.getFirstName()),
								() -> assertNotNull(contact.getLastName()),
								() -> assertNotNull(contact.getPhoneNumber()),
								() -> assertNotNull(contact.getAddress()));
								
	}
	
	@Test
	void contactIdTest() {
		Contact contact = new Contact(contactId);
		assertAll("one",() -> assertEquals(contactId, contact.getContactId()),
						() -> assertNotNull(contact.getFirstName()),
						() -> assertNotNull(contact.getLastName()),
						() -> assertNotNull(contact.getPhoneNumber()),
						() -> assertNotNull(contact.getAddress()));
								
	}
	
	@Test
	void contactIdAndFirstNameContactTest() {
		Contact contact = new Contact(contactId,firstNameTest);
		assertAll("constructor two",() -> assertEquals(contactId, contact.getContactId()),
									() -> assertEquals(firstNameTest, contact.getFirstName()),
									() -> assertNotNull(contact.getLastName()),
									() -> assertNotNull(contact.getPhoneNumber()),
									() -> assertNotNull(contact.getAddress()));
								
	}
	
	@Test
	void contactIdAndFullNameContactTest() {
		Contact contact = new Contact(contactId,firstNameTest, lastNameTest);
		assertAll("constructor three",() -> assertEquals(contactId, contact.getContactId()),
									  () -> assertEquals(firstNameTest, contact.getFirstName()),
									  () -> assertEquals(lastNameTest, contact.getLastName()),
									  () -> assertNotNull(contact.getPhoneNumber()),
									  () -> assertNotNull(contact.getAddress()));
								
	}
	
	@Test
	void contactIdFullNamePhoneNumberContactTest() {
		Contact contact = new Contact(contactId,firstNameTest, lastNameTest, phoneNumberTest);
		assertAll("constructor four",() -> assertEquals(contactId, contact.getContactId()),
									 () -> assertEquals(firstNameTest, contact.getFirstName()),
									 () -> assertEquals(lastNameTest, contact.getLastName()),
									 () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
									 () -> assertNotNull(contact.getAddress()));
								
	}
	
	@Test
	void contactIdFullNamePhoneNumberAddressContactTest() {
		Contact contact = new Contact(contactId,firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertAll("constructor four",() -> assertEquals(contactId, contact.getContactId()),
									 () -> assertEquals(firstNameTest, contact.getFirstName()),
									 () -> assertEquals(lastNameTest, contact.getLastName()),
									 () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
									 () -> assertEquals(addressTest, contact.getAddress()));
								
	}
	
	@Test 
	void updateFirstNameTest() {
		Contact contact = new Contact();
		contact.updateFirstName(firstNameTest);
		assertAll("first name", () ->assertEquals(firstNameTest, contact.getFirstName()),
								() ->assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null)),
								() ->assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(tooLongFirstName)));
	}
	
	@Test 
	void updateLastNameTest() {
		Contact contact = new Contact();
		contact.updateLastName(lastNameTest);
		assertAll("last name", () ->assertEquals(lastNameTest, contact.getLastName()),
							   () ->assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null)),
							   () ->assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(tooLongLastName)));
	}
	
	@Test 
	void updatePhoneNumberTest() {
		Contact contact = new Contact();
		contact.updatePhoneNumber(phoneNumberTest);
		assertAll("Phone Number", () ->assertEquals(phoneNumberTest, contact.getPhoneNumber()),
								  () ->assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null)),
								  () ->assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
								  () ->assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
								  () ->assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(contactId)));
	}
	
	@Test 
	void updateAddressTest() {
		Contact contact = new Contact();
		contact.updateAddress(addressTest);
		assertAll("address", () ->assertEquals(addressTest, contact.getAddress()),
							 () ->assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)),
							 () ->assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(tooLongAddress)));
	}
	
	@Test 
	void updateContactIdTest() {
		Contact contact = new Contact();
		contact.updateContactId(contactId);
		assertAll("Contact Id", () ->assertEquals(contactId, contact.getContactId()),
								() ->assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null)),
								() ->assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(tooLongContactId)));
	}
}
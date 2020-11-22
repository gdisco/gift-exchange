package com.candybutton.christmas.giftexchange.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.candybutton.christmas.giftexchange.Person;

public class PersonTest {
	
	// GIFT CATEGORIES
	private static final int WANT = 0;
	private static final int NEED = 1;
	
	public static Person person;
	
	@Before
	public void setup() {
		person = new Person(1, "Alice");
		person.addToBlockList("Bob");
	}
	
	@Test
	public void addRecipient_givenOne_returnsTrue() {
		Person recipient = new Person(2, "Eve");
		List<Person>expectedResult = new ArrayList<Person>();
		expectedResult.add(recipient);
		
		boolean result = person.addRecipient(recipient, WANT);
		
		assertEquals(result, true);
		assertEquals(person.getRecipients(), expectedResult);
	}
	
	@Test
	public void addRecipient_givenTwo_returnsTrue() {
		Person recipient = new Person(2, "Eve");
		Person recipient2 = new Person(3, "Eve2");
		List<Person>expectedResult = new ArrayList<Person>();
		expectedResult.add(recipient);
		expectedResult.add(recipient2);
		
		boolean result = person.addRecipient(recipient, WANT);
		boolean result2 = person.addRecipient(recipient2, NEED);
		
		assertEquals(result, true);
		assertEquals(result2, true);
		assertEquals(person.getRecipients(), expectedResult);
		System.out.println(person);
	}
	
	@Test
	public void addRecipient_givenDuplicate_returnsFalse() {
		Person recipient = new Person(2, "Eve");
		List<Person>expectedResult = new ArrayList<Person>();
		expectedResult.add(recipient);
		
		boolean result = person.addRecipient(recipient, WANT);
		boolean result2 = person.addRecipient(recipient, NEED);
		
		assertEquals(result, true);
		assertEquals(result2, false);
		assertEquals(person.getRecipients(), expectedResult);
	}
	
	@Test
	public void addRecipient_givenSelf_returnsFalse() {
		Person recipient = new Person(2, "Eve");
		List<Person>expectedResult = new ArrayList<Person>();
		expectedResult.add(recipient);
		
		boolean result = person.addRecipient(recipient, WANT);
		boolean result2 = person.addRecipient(person, NEED);
		
		assertEquals(result, true);
		assertEquals(result2, false);
		assertEquals(person.getRecipients(), expectedResult);
	}
	
	@Test
	public void addRecipient_givenSigOtherName_returnsFalse() {
		Person sigOther = new Person(2, "Bob");
		List<Person>expectedResult = new ArrayList<Person>();
		
		boolean result = person.addRecipient(sigOther, WANT);
		
		assertEquals(result, false);
		assertEquals(person.getRecipients(), expectedResult);
	}
	
	@Test
	public void twoPersonObjects_identicalAttributes_Equal() {
		Person a = new Person(1, "Alice");
		Person b = new Person(1, "Alice");
		a.addToBlockList("Bob");
		b.addToBlockList("Bob");
		assert (a.equals(b));
	}
	
	@Test
	public void twoPersonObjects_differentNames_notEqual() {
		Person a = new Person(1, "Alice");
		Person b = new Person(1, "Bob");
		assert !(a.equals(b));
	}
}

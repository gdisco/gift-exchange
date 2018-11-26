package com.candybutton.christmas.giftexchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Person {
	private int id;
	private String name;
	private Optional<String> sigOtherName;
	private List<Person> recipients;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
		this.recipients = new ArrayList<Person>();
		this.sigOtherName = Optional.empty();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSigOtherName(String p) {
		this.sigOtherName = Optional.of(p);
	}
	
	public List<Person> getRecipients() {
		return recipients;
	}
	
	// Adds the recipientId to the Person's
	// recipientList for the given gift category. Returns true if successful,
	// false if the recipient is invalid
	public boolean addRecipient(Person person, int category) {
		if (isValidRecipient(person, category)) {
			if (recipients.size() > category) {
				recipients.remove(category);
			}
			recipients.add(category, person);
			return true;
		} else {
			return false;			
		}
	}
	
	// Returns true if and only if the recipientId
	// is not already in the Peron's recipientList,
	// (up to the given gift category),
	// AND is not the person's significant other,
	// AND the recipientId is not equal to the Person's id.
	private boolean isValidRecipient(Person newRecipient, int category) {
		boolean isValid = true;
		if (this.id == newRecipient.id) {
			isValid = false; 
		} else if (this.sigOtherName.isPresent() && this.sigOtherName.get().equals(newRecipient.getName())) {
			isValid = false;
		} else {
			for (int i = 0; i < category; i++) {
				if (this.recipients.get(i).id == newRecipient.id) {
					isValid = false;
				}
			}
		}
		return isValid;
	}
	
	@Override
	public String toString() {
		return id + "-" + name + ": " + recipients.stream().map(r -> r.id + "-" + r.name).collect(Collectors.joining(","));
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Person)) { 
            return false; 
        } 
          
        Person p = (Person) o; 
		return id == p.id && name.equals(p.name) && sigOtherName.equals(p.sigOtherName);
	}
	
	//Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + sigOtherName.hashCode();
        result = 31 * result + id;
        return result;
    }
}

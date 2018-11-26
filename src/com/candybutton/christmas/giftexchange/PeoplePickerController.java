package com.candybutton.christmas.giftexchange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.candybutton.christmas.giftexchange.PeoplePickerUtils.*;

/* PeoplePicker.java
 * Divides up the family for the annual gift exchange
 */
public class PeoplePickerController {
	
	public GiftingCategoryPersonFormatter categoryFormatter;
	public String peopleFile;
	
	public final String OUTDIR = "/Users/discog/Desktop/ButtonChristmasGiftExchange";
	
	public void pickPeople() throws IOException {
		List<Person> people = readPeople(peopleFile);
		
		for (int category = 0; category < this.categoryFormatter.getNumCategories(); category++) {
			boolean roundSuccess;
			do {
				roundSuccess = true;
				int[] shuffledIds = shuffle(people.size());
				for (int i = 0; i < people.size(); i++) {
					Person proposedRecipient = people.get(shuffledIds[i]);
					boolean success = people.get(i).addRecipient(proposedRecipient, category);
					roundSuccess = roundSuccess && success;
				}
			} while (roundSuccess == false);
		}
	
		
		try {
			writePeople(people, this.categoryFormatter, OUTDIR);
		} catch (Exception e) {
			System.out.println("Borked");
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
			
		PeoplePickerController controller = new PeoplePickerController();	
		
		// Look ma, I can inject dependencies.
		controller.categoryFormatter = new GiftingCategoryPersonFormatterExperience();
		controller.peopleFile = args[0];
		controller.pickPeople();
		
		System.out.println("Done! outdir is: " + controller.OUTDIR);
	}
}

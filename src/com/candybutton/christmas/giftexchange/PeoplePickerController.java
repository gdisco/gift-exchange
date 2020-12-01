package com.candybutton.christmas.giftexchange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.candybutton.christmas.giftexchange.PeoplePickerUtils.*;

/* PeoplePicker.java
 * Divides up participants for a gift exchange
 */
public class PeoplePickerController {
	
	public GiftingCategoryPersonFormatter categoryFormatter;
	public String peopleFile;
	
	public final String OUTDIR = ".";
	
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

		// Good lord will somebody please turn this into a sensible config file
		if (args.length == 0) {
			System.out.println("Missing Participants file, see README and PeopleFile.txt for an example");
			return;
 		} else if (args.length == 1) {
			System.out.println("Using default gift categories wear/read/want/need");
			controller.categoryFormatter = new GiftingCategoryPersonFormatterClassic();
		} else if (args.length >= 2) {
			String category = args[1];
			if (category.toLowerCase().equals("experience")) {
				System.out.println("Using gift categories wear/read/want/experience");
				controller.categoryFormatter = new GiftingCategoryPersonFormatterExperience();
			} else if (category.toLowerCase().equals("pandemic")) {
				System.out.println("Using gift categories eat/want/feat/flaunt");
				controller.categoryFormatter = new GiftingCategoryPersonFormatterPandemic();
			} else {
				System.out.println("Using default gift categories wear/read/want/need");
				controller.categoryFormatter = new GiftingCategoryPersonFormatterClassic();
                        }
		}

		controller.peopleFile = args[0];
		controller.pickPeople();
		
		System.out.println("Done! Output files are in: " + System.getProperty("user.dir"));
	}
}

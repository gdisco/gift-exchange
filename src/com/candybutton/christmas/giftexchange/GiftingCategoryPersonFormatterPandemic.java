package com.candybutton.christmas.giftexchange;

public class GiftingCategoryPersonFormatterPandemic extends GiftingCategoryPersonFormatter {
	private static final String[] CATEGORIES = {
			"Something to eat",
			"Something they want",
			"Pandemic feat ('experience' but Pandemic-friendly)",
			"Something to flaunt ('wear' but could be anything worth showing off)"
	};
	
	// I18N is for grown-ups
	public String formatMessage(Person person) {
		StringBuilder message = new StringBuilder();
		message.append(person.getName());
		message.append(", here are your gift recipients:\n");
		for (int i = 0; i < CATEGORIES.length; i++) {
			message.append('\t');
			message.append(CATEGORIES[i]);
			message.append(": ");
			message.append(person.getRecipients().get(i).getName());
			message.append("\n");
		}
		message.append("These gift recipients have been automatically generated via bespoke hacker magic, I have not seen the results.\n");
		message.append("Merry Christmas!\n");
		message.append("Garrett\n\n");
		return message.toString();
	}
	
	public int getNumCategories() {
		return CATEGORIES.length;
	}
}

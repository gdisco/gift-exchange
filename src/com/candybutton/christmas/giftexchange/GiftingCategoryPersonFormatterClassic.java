package com.candybutton.christmas.giftexchange;

public class GiftingCategoryPersonFormatterClassic extends GiftingCategoryPersonFormatter {
	private static final String[] CATEGORIES = {
			"Something they want",
			"Something they need",
			"Something to wear",
			"Something to read"
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
		message.append("These results have been automatically generated via made-from-scratch hacker magic, I have not seen the results.\n");
		message.append("Happy Gifting!\n");
		message.append("Garrett\n\n");
		return message.toString();
	}
	
	public int getNumCategories() {
		return CATEGORIES.length;
	}
}

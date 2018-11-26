package com.candybutton.christmas.giftexchange;

public abstract class GiftingCategoryPersonFormatter {
	// Given a Person, returns a pretty-formatted
	// string mapping their Recipients to 
	// human-readable gift categories.
	public abstract String formatMessage(Person person);
	
	public abstract int getNumCategories();
}

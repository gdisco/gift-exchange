package com.candybutton.christmas.giftexchange.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.candybutton.christmas.giftexchange.PeoplePickerUtils;

public class PeoplePickerUtilsTest {
	
	@Test
	public void shuffle_givenN_returnsLengthN() {
		// This doesn't really test anything, just prints
		// out the "shuffled" array for visual inspection.
		int[] shuffled = PeoplePickerUtils.shuffle(11);
		for (int i = 0; i < 11; i++) {
			System.out.print(shuffled[i] + ", ");
		}
		assertEquals(shuffled.length, 11);
	}
}

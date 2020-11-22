package com.candybutton.christmas.giftexchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PeoplePickerUtils {
	
	/* ReadPeople:
	 * Given a list of names in "peopleFile", return a list of people,
	 * with the strings as names and sequential ids.
	 */
	public static List<Person> readPeople(String peopleFile) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(peopleFile));
		List<Person> people = new ArrayList<Person>();

		try {
			int id = 0;
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				String[] names = line.split(":");
				Person p = new Person(id++, names[0]);
				if (names.length > 1) {
					String[] blocked = names[1].split(",");
					for (String name : blocked) {
						p.addToBlockList(name);
					}
				}
				people.add(p);
			}
		} finally {
			reader.close();
		}

		return people;
	}
	
	/* WritePeople:
	 * Given a List of Person objects and a category map, write each 
	 * person's recipients to a human-readable text file named "<name>.txt" 
	 * in the outdir directory.
	 */
	public static void writePeople(List<Person> people, 
	                               GiftingCategoryPersonFormatter categoryFormatter, 
	                               String outdir) throws FileNotFoundException, IOException {
		for (Person person : people) {
			File f = new File(outdir + "/" + person.getName() + ".txt");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f), "UTF8");			
			String message = categoryFormatter.formatMessage(person);
			out.append(message);
			out.flush();
			out.close();
		}
	}
	
	/* Shuffle: 
	 * Returns a shuffled array of the integers 0 - (n - 1)
	 * (uses Knuth shuffle algorithm).
	 */
	public static int[] shuffle(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
		for (int i = n - 1; i >= 0; i--) {
			int j = (int) (Math.random() * i);
			swap(array, i, j);
		}
		return array;
	}
	
	/* Swap:
	 * Given two indices a and b, swaps their position in 
	 * array in-place.
	 */
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}

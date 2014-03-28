package edu.gac.MCS270.AddressBook;

import static org.junit.Assert.*;
import edu.gac.MCS270.AddressBook.shared.EntryData;

public class Test {

	public void testDoesMatch() {
		EntryData entry = new EntryData("sergio", "1najera1", "800 street", "new prague",
				"MN", 16071, "srn@yahoo.com", 655555515);
		EntryData entry2 = new EntryData("sergio", "2najera2", "800 street", "new prague",
				"MN", 26072, "srn@yahoo.com", 655555515);
		EntryData entry3 = new EntryData("sergio", "3najera3", "800 street", "new prague",
				"MN", 36073, "srn@yahoo.com", 655555515);
		
		assert (entry.getLastName().compareTo(entry2.getLastName()) == 0);
		assert (entry.getLastName().compareTo(entry3.getLastName()) != 0);
		assert (entry2.getLastName().compareTo(entry3.getLastName()) != 0);


		
	}
	
	}


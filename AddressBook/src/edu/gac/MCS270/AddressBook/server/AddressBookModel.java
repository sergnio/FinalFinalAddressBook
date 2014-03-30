package edu.gac.MCS270.AddressBook.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import edu.gac.MCS270.AddressBook.shared.EntryData;

public class AddressBookModel {
	static final PersistenceManagerFactory pmf = PMF.get();

	public String getMailing() {
		List<EntryData> entries = getEntryData();
		String mailing = "";
		for(EntryData entry : entries) {
			mailing += entry.stringRep();
		}
		return mailing;
	}
	
	// stores entries in the database 
		public static void storeEntry(EntryData entry) {
			PersistenceManager pm = pmf.getPersistenceManager();
			pm.makePersistent(entry);
		}
	
	//Do the search -- iterate through all of the entries
		//add the ones that meet the search query
		
		public static List<EntryData> getSearchData(String search) {
	   		List<EntryData> entries = getEntryData();
	   		List<EntryData> searching = new ArrayList();
	        	for (EntryData entry : entries){
	        		if(entry.getFirstName().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(entry.getLastName().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(entry.getAddress().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(entry.getCity().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(entry.getState().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(String.valueOf(entry.getZip()).contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(entry.getEmail().contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}else if(String.valueOf(entry.getPhone()).contains(search)){
	        			searching.add(entry);
	        			continue;
	        		}
	        	}
	        	return new ArrayList<EntryData>(searching);
	        }

		public static List<EntryData> getEntryData() {
			PersistenceManager pm = pmf.getPersistenceManager();
	        Query query = pm.newQuery(EntryData.class);
	        List<EntryData> entries = (List<EntryData>) query.execute();
	        return new ArrayList<EntryData>(entries);
		}

		public static List<EntryData> getLNSortedSearchData() {
			
		   	List<EntryData> entries = getEntryData();
		   	List<EntryData> sorted = new ArrayList();
			for (EntryData entry : entries){
		   		sorted.add(entry);
		   	}
			Collections.sort(entries, EntryData.COMPARE_BY_NAME);
			return entries;
		}

		public static List<EntryData> getZipSortedSearchData() {
			List<EntryData> entries = getEntryData();
			Collections.sort(entries, EntryData.COMPARE_BY_ZIP); 
			    return entries;
		}

		public static void deleteEntry(EntryData entry) {
			PersistenceManager pm = pmf.getPersistenceManager();
			try {
				pm.currentTransaction().begin();
				
				pm.deletePersistent(pm.getObjectById(EntryData.class, entry.getID()));
				pm.currentTransaction().commit();
				}
			finally {
				if(pm.currentTransaction().isActive()) {
					pm.currentTransaction().rollback();
					
				}if(!pm.isClosed()) {
					pm.close();
				}
			}
			
		}
	
	
	
}
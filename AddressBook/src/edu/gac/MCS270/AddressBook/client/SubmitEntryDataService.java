package edu.gac.MCS270.AddressBook.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.MCS270.AddressBook.shared.EntryData;


@RemoteServiceRelativePath("submitentry") 
public interface SubmitEntryDataService extends RemoteService {
	
	
	public String submitEntryDataToServer(EntryData entry);

	public String deleteEntryDataFromServer(EntryData entry);

}

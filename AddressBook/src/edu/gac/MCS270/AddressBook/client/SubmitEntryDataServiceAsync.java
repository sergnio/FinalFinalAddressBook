package edu.gac.MCS270.AddressBook.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.MCS270.AddressBook.shared.EntryData;

public interface SubmitEntryDataServiceAsync {
	
	void submitEntryDataToServer(EntryData entry, AsyncCallback<String> callback);

	void deleteEntryDataFromServer(EntryData entry,
			AsyncCallback<String> asyncCallback);

}

package edu.gac.MCS270.AddressBook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.MCS270.AddressBook.shared.EntryData;


public interface GetEntryDataServiceAsync {
	public void getEntryDataFromServer(AsyncCallback<List<EntryData>> asyncCallback);

	public void getLNSortedEntryDataFromServer(AsyncCallback<List<EntryData>> asyncCallback);

	public void getZipSortedEntryDataFromServer(AsyncCallback<List<EntryData>> asyncCallback);

	void getSearchDataFromServer(String SearchTerm,
			AsyncCallback<List<EntryData>> callback);

}

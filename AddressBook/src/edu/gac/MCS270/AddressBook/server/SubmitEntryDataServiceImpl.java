package edu.gac.MCS270.AddressBook.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.gac.MCS270.AddressBook.client.SubmitEntryDataService;
import edu.gac.MCS270.AddressBook.shared.EntryData;

@SuppressWarnings("serial")
public class SubmitEntryDataServiceImpl extends RemoteServiceServlet implements
		SubmitEntryDataService {

	@Override
	public String submitEntryDataToServer(EntryData entry) {
		AddressBookModel.storeEntry(entry);
		return "Entry submitted!";
	}

	@Override
	public String deleteEntryDataFromServer(EntryData entry) {
		AddressBookModel.deleteEntry(entry);
		return "Entry deleted!";
	}

}

package edu.gac.MCS270.AddressBook.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.gac.MCS270.AddressBook.client.GetEntryDataService;
import edu.gac.MCS270.AddressBook.shared.EntryData;

@SuppressWarnings("serial")
public class GetEntryDataServiceImpl extends RemoteServiceServlet implements GetEntryDataService {

	@Override
	public List<EntryData> getEntryDataFromServer() {
		return AddressBookModel.getEntryData();
	}

	public List<EntryData> getLNSortedEntryDataFromServer() { 
		return AddressBookModel.getLNSortedSearchData();
	}

	@Override
	public List<EntryData> getZipSortedEntryDataFromServer() {
		return AddressBookModel.getZipSortedSearchData();
	}

	@Override
	public List<EntryData> getSearchDataFromServer(String SearchTerm) {
			return AddressBookModel.getSearchData(SearchTerm);
	}
	
}

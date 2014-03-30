package edu.gac.MCS270.AddressBook.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.MCS270.AddressBook.shared.EntryData;

public class AddressBook implements EntryPoint {

	private final AddressBookView abView = new AddressBookView();
	private final SubmitEntryDataServiceAsync submitEntryDataService = 
			GWT.create(SubmitEntryDataService.class);
	private final GetEntryDataServiceAsync entryDataService =
			GWT.create(GetEntryDataService.class);
	
	public void onModuleLoad() {
		abView.setController(this);
		abView.viewMainPage();
	}
	
	// controller method for retrieving data from server to display print mailing list
	public void printMailingListFromServer() {
		entryDataService.getEntryDataFromServer(new AsyncCallback<List<EntryData>>() {
			public void onFailure(Throwable caught) {

				return;
			}
			
			public void onSuccess(List<EntryData> result) {
			
				abView.viewMailingList(result);
			}
		});
	}
	
	
	
	// servlet call to get search results
		public void handleInfoSearchRequest(String info) {
			entryDataService.getSearchDataFromServer(info, 
	                new AsyncCallback<List<EntryData>>() {
	                        public void onFailure(Throwable caught) {
	                                return;
	                        }

	                        @Override
	                        public void onSuccess(List<EntryData> data) {
	                                abView.viewAddressBookEntries(data);
	                        }
	                });
		}
	
		
		// controller method for retrieving data from server that are already sorted by last name
	public void getSortedEntriesByLastNameFromServer() {
		
		entryDataService.getLNSortedEntryDataFromServer(
                new AsyncCallback<List<EntryData>>() {
                        public void onFailure(Throwable caught) {
                                return;
                        }

                        @Override
                        public void onSuccess(List<EntryData> data) { 
                                abView.viewAddressBookEntries(data);
                        }
                });
	}

	
	// controller method for retrieving data from server that are already sorted by zip
	public void getSortedEntriesByZipFromServer() {
		entryDataService.getZipSortedEntryDataFromServer(
                new AsyncCallback<List<EntryData>>() {
                        public void onFailure(Throwable caught) {
                                return;
                        }

                        @Override
                        public void onSuccess(List<EntryData> data) {
                                abView.viewAddressBookEntries(data);
                        }
                });
	}
	
	// controller method for sending data to database
	public void addAddressHandler(EntryData entries){
	new AsyncCallback<List<EntryData>>(){
			public void onFailure(Throwable caught){
				return;
			}

			@Override
			public void onSuccess(List<EntryData> entries) {
				abView.sendSuccessfulAddMessage();
				abView.viewAddressBookEntries(entries);
			}
		};
	}		

		public void handleEntrySubmit(EntryData entry) {
			submitEntryDataService.submitEntryDataToServer(entry,
					new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					return;
				
			}
			// @Override
			public void onSuccess(String result) {
				abView.sendSuccessfulAddMessage();
			}
		});
	}
		// controller method for retrieving data from server with all the contacts/entries
		public void viewContactsFromServer() {
			entryDataService.getEntryDataFromServer(new AsyncCallback<List<EntryData>>() {
				public void onFailure(Throwable caught) {

					return;
				}
				
				public void onSuccess(List<EntryData> result) {

					abView.viewAddressBookEntries(result);
				}
			});
		}

		
		// controller method for deleting an entry from the database
		public void handleDeleteEntryFromServer(EntryData entry) {
			submitEntryDataService.deleteEntryDataFromServer(entry,
					new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					return;
				}
				
				public void onSuccess(String result) {
					abView.sendSuccessfulDeleteMessage();
				}
			
		});


		}
}
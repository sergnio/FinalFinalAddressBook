package edu.gac.MCS270.AddressBook.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.gac.MCS270.AddressBook.shared.EntryData;

public class AddressBookView {
	
	private AddressBook controller;
	final PopupPanel mailingInfoPopup = new PopupPanel();	
	
	public AddressBookView() {}
	
	public AddressBook getController() {
		return controller; 
	}
	
	public void setController(AddressBook controller) {
		this.controller = controller;
	}
	
	public void viewMainPage(){
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		rootPanel.add(mainPage());
	}
	public FlowPanel mainPage() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		
		// need moar style over all the panels
		HorizontalPanel titlePanel = new HorizontalPanel();
		titlePanel.setStyleName("titlePanel");
		
		VerticalPanel menuBar = makeMenuBar();
		menuBar.setStyleName("menuBar");
		
		FlowPanel mainPanel = new FlowPanel();
		mainPanel.setStyleName("workingSpacePanel");
		// need plz
		//HorizontalPanel footerPanel = new HorizontalPanel();
		
		rootPanel.add(titlePanel);
		rootPanel.add(menuBar);
		rootPanel.add(mainPanel);

		return mainPanel;				
		
	}
	
	
	public void viewAddressBookEntries(List<EntryData> entries) {
		FlowPanel workingSpace = mainPage();
		if (entries != null) {
			makeAddressEntryTable(workingSpace, entries);
		}
		else {
			return;
		}
		
	}
	
	public void viewCreateAdressBookEntryForm() {
		FlowPanel workingSpace = mainPage();
		
		//might need to change to horizontal panel
		final FlowPanel addAddressPanel = new FlowPanel();
		VerticalPanel addressPanel = new VerticalPanel();
		addressPanel.addStyleName("AddContactPanel");
		addAddressPanel.add(addressPanel);
		
		// creates new horizontal panel for the text above the blank text box 
		HorizontalPanel firstNameLabelPanel = new HorizontalPanel();
		Label firstNameLabel = new Label("First Name");
		firstNameLabelPanel.add(firstNameLabel);
		workingSpace.add(firstNameLabelPanel);
		
		HorizontalPanel firstNameTextBoxPanel = new HorizontalPanel();
		final TextBox firstNameTextBox = new TextBox();
		firstNameTextBoxPanel.add(firstNameTextBox);
		workingSpace.add(firstNameTextBoxPanel);
		
		// Last name textbox
		HorizontalPanel lastNameLabelPanel = new HorizontalPanel();
		Label lastNameLabel = new Label("Last Name");
		lastNameLabelPanel.add(lastNameLabel);
		workingSpace.add(lastNameLabelPanel);
		
		HorizontalPanel lastNameTextBoxPanel = new HorizontalPanel();
		final TextBox lastNameTextBox = new TextBox();
		lastNameTextBoxPanel.add(lastNameTextBox);
		workingSpace.add(lastNameTextBoxPanel);		
		
		HorizontalPanel addressLabelPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address");
		addressLabelPanel.add(addressLabel);
		workingSpace.add(addressLabelPanel);
		
		HorizontalPanel addressTextBoxPanel = new HorizontalPanel();
		final TextBox addressTextBox = new TextBox();
		addressTextBoxPanel.add(addressTextBox);
		workingSpace.add(addressTextBoxPanel);
		
		HorizontalPanel cityLabelPanel = new HorizontalPanel();
		Label cityLabel = new Label("City");
		cityLabelPanel.add(cityLabel);
		workingSpace.add(cityLabelPanel);
		
		HorizontalPanel cityTextBoxPanel = new HorizontalPanel();
		final TextBox cityTextBox = new TextBox();
		cityTextBoxPanel.add(cityTextBox);
		workingSpace.add(cityTextBoxPanel);
		
		HorizontalPanel stateLabelPanel = new HorizontalPanel();
		Label stateLabel = new Label("State");
		stateLabelPanel.add(stateLabel);
		workingSpace.add(stateLabelPanel);
		
		HorizontalPanel stateTextBoxPanel = new HorizontalPanel();
		final TextBox stateTextBox = new TextBox();
		stateTextBoxPanel.add(stateTextBox);
		workingSpace.add(stateTextBoxPanel);
		
		HorizontalPanel zipLabelPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip");
		zipLabelPanel.add(zipLabel);
		workingSpace.add(zipLabelPanel);
		
		HorizontalPanel zipTextBoxPanel = new HorizontalPanel();
		final TextBox zipTextBox = new TextBox();
		zipTextBoxPanel.add(zipTextBox);
		workingSpace.add(zipTextBoxPanel);
		
		//email textbox
		HorizontalPanel emailLabelPanel = new HorizontalPanel();
		Label emailLabel = new Label("Email");
		emailLabelPanel.add(emailLabel);
		workingSpace.add(emailLabelPanel);
		
		HorizontalPanel emailTextBoxPanel = new HorizontalPanel();
		final TextBox emailTextBox = new TextBox();
		emailTextBoxPanel.add(emailTextBox);
		workingSpace.add(emailTextBoxPanel);
		
		HorizontalPanel phoneLabelPanel = new HorizontalPanel();
		Label phoneLabel = new Label("Phone");
		phoneLabelPanel.add(phoneLabel);
		workingSpace.add(phoneLabelPanel);
		
		HorizontalPanel phoneTextBoxPanel = new HorizontalPanel();
		final TextBox phoneTextBox = new TextBox();
		phoneTextBoxPanel.add(phoneTextBox);
		workingSpace.add(phoneTextBoxPanel);
		
		firstNameTextBox.setName("First Name");
		lastNameTextBox.setName("Last Name");
		addressTextBox.setName("Address");
		cityTextBox.setName("City");
		stateTextBox.setName("State");
		zipTextBox.setName("Zip");
		emailTextBox.setName("Email");
		phoneTextBox.setName("Phone");
		
		
		// adding clicker handler for submitting and storing the information
		Button submitButton = new Button("Submit");
		submitButton.setText("Submit");
		submitButton.addClickHandler(new ClickHandler() {
			//Add contact click handler
			@Override
			public void onClick(ClickEvent event) {
				controller.handleEntrySubmit(new EntryData(firstNameTextBox.getText(), 
						lastNameTextBox.getText(), addressTextBox.getText(), cityTextBox.getText(),
						stateTextBox.getText(), Integer.parseInt(zipTextBox.getText()), emailTextBox.getText(),
						Integer.parseInt(phoneTextBox.getText())));
			}
			
		});
		workingSpace.add(submitButton);
	}
	
	public void viewSingleAddressBookEntry(final EntryData entry) {
		FlowPanel workingSpace = mainPage();
		
		HorizontalPanel firstNameLabelPanel = new HorizontalPanel();
		Label firstNameLabel = new Label("First Name " + entry.getFirstName());
		firstNameLabelPanel.add(firstNameLabel);
		workingSpace.add(firstNameLabelPanel);
		
		HorizontalPanel lastNameLabelPanel = new HorizontalPanel();
		Label lastNameLabel = new Label("Last Name " + entry.getLastName());
		lastNameLabelPanel.add(lastNameLabel);
		workingSpace.add(lastNameLabelPanel);
		
		HorizontalPanel addressLabelPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address " + entry.getAddress());
		addressLabelPanel.add(addressLabel);
		workingSpace.add(addressLabelPanel);
		
		HorizontalPanel cityLabelPanel = new HorizontalPanel();
		Label cityLabel = new Label("City " + entry.getCity());
		cityLabelPanel.add(cityLabel);
		workingSpace.add(cityLabelPanel);
		
		HorizontalPanel stateLabelPanel = new HorizontalPanel();
		Label stateLabel = new Label("State " + entry.getState());
		stateLabelPanel.add(stateLabel);
		workingSpace.add(stateLabelPanel);
		
		HorizontalPanel zipLabelPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip " + entry.getZip());
		zipLabelPanel.add(zipLabel);
		workingSpace.add(zipLabelPanel);
		
		HorizontalPanel emailLabelPanel = new HorizontalPanel();
		Label emailLabel = new Label("Email " + entry.getEmail());
		emailLabelPanel.add(emailLabel);
		workingSpace.add(emailLabelPanel);
		
		HorizontalPanel phoneLabelPanel = new HorizontalPanel();
		Label phoneLabel = new Label("Phone " + entry.getPhone());
		phoneLabelPanel.add(phoneLabel);
		workingSpace.add(phoneLabelPanel);
		
		
		//Delete Button
		Button deleteContactButton = new Button("Delete");
		deleteContactButton.setText("Delete");
		
		//Add Clickhandler for Delete
		deleteContactButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event){
				controller.handleDeleteEntryFromServer(entry);
			}
		});
	}
	
		// MAKES MENU BAR EVERY SINGLE TIME
	public VerticalPanel makeMenuBar() {
		VerticalPanel leftColumn = new VerticalPanel();
		// NEED TO STYLE vertical panel (for size)
		
		Button homeButton = new Button("Home");
		homeButton.setText("Home");
		homeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.viewContactsFromServer();
			}
		});
		
		// creates new button for adding entry
		Button addEntryButton = new Button("Add entry");
		addEntryButton.setText("Add Entry");
		addEntryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				viewCreateAdressBookEntryForm();
			}
		});
		
		// make moar
		Button sortByLastNameButton = new Button("Sort by last name");
		sortByLastNameButton.setText("Sort by last name");
		sortByLastNameButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.getSortedEntriesByLastNameFromServer();
			}
		});
		
		Button sortByZipButton = new Button("Sort by zip");
		sortByZipButton.setText("Sort by zip");
		sortByZipButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.getSortedEntriesByZipFromServer();
			}
		});
		
		Button searchForEntryButton = new Button("Search for entry");
		searchForEntryButton.setText("Search for entry");
		searchForEntryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchForEntriesInServer();
			}
			private void searchForEntriesInServer() {

				VerticalPanel content = new VerticalPanel();
				content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

				HorizontalPanel inputRow = new HorizontalPanel();
				Label searchTermLabel = new Label("Search Title Term: ");
				final TextBox searchTermTextBox = new TextBox();
				inputRow.add(searchTermLabel);
				inputRow.add(searchTermTextBox);

				HorizontalPanel btnRow = new HorizontalPanel();
				btnRow.setStyleName("search-button-row");
				Button cancelBtn = new Button("Cancel");
				cancelBtn.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						mailingInfoPopup.hide();
					}
				});
				Button searchBtn = new Button("Search");
				searchBtn.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						controller.handleInfoSearchRequest(searchTermTextBox.getText());
						mailingInfoPopup.hide();
					}
				});
				btnRow.add(cancelBtn);
				btnRow.add(new Label(""));
				btnRow.add(searchBtn);

				content.add(inputRow);
				content.add(btnRow);
				mailingInfoPopup.setWidget(content);
				mailingInfoPopup.center();

			
			}
			
		});
		
		
		Button printMailingListButton = new Button("Print mailing list");
		printMailingListButton.setText("Print mailing list");
		printMailingListButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.printMailingListFromServer();
			}
		});		
		
				
		
		// adds these buttons to the left column on every page
		leftColumn.add(homeButton);
		leftColumn.add(addEntryButton);
		leftColumn.add(sortByLastNameButton);
		leftColumn.add(sortByZipButton);
		leftColumn.add(searchForEntryButton);
		leftColumn.add(printMailingListButton);
		
		return leftColumn;
	}
		
		
	
	
	// makes every row when viewing the address entries
	private void makeAddressEntryTable(FlowPanel flowPanel, List<EntryData> entries) {
		for(EntryData entry: entries) {
			flowPanel.add(makeAddressEntryRow(entry));
		}
	}
	
	
	// Creates the row for displaying each entry (the entry's name, and the two buttons for more info
	// and to delete the entry.)
	private HorizontalPanel makeAddressEntryRow(final EntryData entry) {
		HorizontalPanel entryRowPanel = new HorizontalPanel();
		Label entryName = new Label(entry.getFirstName() + " " + entry.getLastName());
//		entryInformation.addStyleName("entryInformation");
		// info button 
		Button infoButton = new Button();
		infoButton.setText("More Info");
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				viewSingleAddressBookEntry(entry);
			}
		});
		// delete button
		Button deleteButton = new Button();
		deleteButton.setText("DELETE");
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.handleDeleteEntryFromServer(entry);
			}
		});
		
		// adds the info and delete buttons and name of the entry to the panel
		entryRowPanel.add(entryName);
		entryRowPanel.add(infoButton);
		entryRowPanel.add(deleteButton);
		
		return entryRowPanel;
	}
	
	// creates a popup mailing window
	protected void viewMailingList (List<EntryData> entries) {
		FlowPanel workingSpace = mainPage();
		VerticalPanel mailingInfoPanel = new VerticalPanel();
		for (EntryData e : entries) {
			mailingInfoPanel.add(createMailingLabel(e));
		}
		workingSpace.add(mailingInfoPanel);
		
	}
	
	public VerticalPanel createMailingLabel(EntryData entry) {
		VerticalPanel workingSpace = new VerticalPanel();
		
		HorizontalPanel firstNameLabelPanel = new HorizontalPanel();
		Label firstNameLabel = new Label("First Name " + entry.getFirstName());
		firstNameLabelPanel.add(firstNameLabel);
		workingSpace.add(firstNameLabelPanel);
		
		HorizontalPanel lastNameLabelPanel = new HorizontalPanel();
		Label lastNameLabel = new Label("Last Name " + entry.getLastName());
		lastNameLabelPanel.add(lastNameLabel);
		workingSpace.add(lastNameLabelPanel);
		
		HorizontalPanel addressLabelPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address " + entry.getAddress());
		addressLabelPanel.add(addressLabel);
		workingSpace.add(addressLabelPanel);
		
		HorizontalPanel cityLabelPanel = new HorizontalPanel();
		Label cityLabel = new Label("City " + entry.getCity());
		cityLabelPanel.add(cityLabel);
		workingSpace.add(cityLabelPanel);
		
		HorizontalPanel stateLabelPanel = new HorizontalPanel();
		Label stateLabel = new Label("State " + entry.getState());
		stateLabelPanel.add(stateLabel);
		workingSpace.add(stateLabelPanel);
		
		HorizontalPanel zipLabelPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip " + entry.getZip());
		zipLabelPanel.add(zipLabel);
		workingSpace.add(zipLabelPanel);
		
		HorizontalPanel emailLabelPanel = new HorizontalPanel();
		Label emailLabel = new Label("Email " + entry.getEmail());
		emailLabelPanel.add(emailLabel);
		workingSpace.add(emailLabelPanel);
		
		HorizontalPanel phoneLabelPanel = new HorizontalPanel();
		Label phoneLabel = new Label("Phone " + entry.getPhone());
		phoneLabelPanel.add(phoneLabel);
		workingSpace.add(phoneLabelPanel);
		
		HorizontalPanel blankLabelPanel = new HorizontalPanel();
		Label blankLabel = new Label("-----------");
		blankLabelPanel.add(blankLabel);
		workingSpace.add(blankLabelPanel);		
		
		return workingSpace;
	}
	
	public void sendSuccessfulDeleteMessage() {
		Window.alert("Contact was Deleted");
	}
	
	public void sendSuccessfulAddMessage() {
		Window.alert("Entry was stored!");
	}
}
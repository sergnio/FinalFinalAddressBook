package edu.gac.MCS270.AddressBook.shared;

import java.io.Serializable;
import java.util.Comparator;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class EntryData implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String address;
	@Persistent
	private String city;
	@Persistent
	private String state;
	@Persistent
	private int zip;
	@Persistent
	private String email;
	@Persistent
	private int phone;
	
	
	public EntryData() {}

	public EntryData(String firstName, String lastName, String add, String c, String s, int  z, String em, int  ph){
		this.firstName = firstName;
		this.lastName = lastName;
		address = add;
		city = c;
		state = s;
		zip = z;
		email = em;
		phone = ph;

	}

	// Getters and Setters
	public String getFirstName(){
		return firstName;	
	}
	public String getLastName(){
		return lastName;
	}
	public String getAddress(){
		return address;
	}
	public String getCity(){
		return city;
	}
	public String getState(){
		return state;
	}
	public int getZip(){
		return zip;
	}
	public String getEmail(){
		return email;
	}
	public int getPhone(){
		return phone;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setAddress(String add){
		address = add;
	}
	public void setCity(String c){
		city = c;
	}
	public void setState(String s){
		state = s;
	}
	public void setZip(int  z){
		zip = z;
	}
	public void setEmail(String e){
		email = e;
	}
	public void setPhone(int ph){
		phone = ph;
	}

	public Long getID() {
		return id;
	}

	public String stringRep() {	
		return "Name: " + firstName + " " + lastName +
				"\n Address: " + address +
				"\n          " + city+", " + state + " " + zip +
				"\n E-mail: " + email +
				"\n Phone:  " + phone;
	}


	
	public static Comparator<EntryData> COMPARE_BY_NAME = new Comparator<EntryData>() {
        public int compare(EntryData one, EntryData other) {
            return one.lastName.compareTo(other.lastName);
        }
    };

   
    public static Comparator<EntryData> COMPARE_BY_ZIP = new Comparator<EntryData>() {
		public int compare(EntryData one, EntryData other) {
			String stringZipOne = String.valueOf(one.zip);
			String stringZipOther = String.valueOf(other.zip);
			return stringZipOne.compareTo(stringZipOther);
		}
	};




}
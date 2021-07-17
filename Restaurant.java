package project3;

/**
 * This class represents a restaurant. 
 * It uses either names, zip codes or 
 * names, zip codes, addresses, and phone numbers as representations of the class.
 * 
 * @author Yi Yang
 *
 */
import java.util.*;



public class Restaurant implements Comparable<Restaurant> {
	private String name;
	private String zip;
	private String address;
	private String phone;
	private ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();
	/**
	 * Constructs a new Restaurant object with a given name and zip code.
	 * @param name the name of the Restaurant
	 * @param zip the zip code of the Restaurant
	 * @throws IllegalArgumentException if the name is empty or null, or if the zip code
	 * is not a 5 digit number.
	 */
	public Restaurant (String name, String zip) throws IllegalArgumentException{
		if (name.equals(null) || name.equals(""))
			throw new IllegalArgumentException("Invalid name.");
		else if (zip.length()!=5)
			throw new IllegalArgumentException("Invalid zip code.");
		else if (zip.matches("\\d{5}")==false)
			throw new IllegalArgumentException("Invalid zip code.");
		else
			this.name=name;
			this.zip=zip;
	}
	/**
	 * Constructs a new Restaurant object with a given name, zip code, address and phone number
	 * @param name the name of the Restaurant
	 * @param zip the zip code of the Restaurant
	 * @param address the address of the Restaurant
	 * @param phone the phone number of the Restaurant
	 * @throws IllegalArgumentException if the name is empty or null, or if the zip code 
	 * is not a 5 digit number.
	 */
	public Restaurant (String name, String zip, String address, String phone) throws IllegalArgumentException {
		if (name.equals(null) || name.equals(""))
			throw new IllegalArgumentException("Invalid name.");
		else if (zip.length()!=5)
			throw new IllegalArgumentException("Invalid zip code.");
		else if (zip.matches("\\d{5}")==false)
			throw new IllegalArgumentException("Invalid zip code.");
		else if (address.equals(null) || address.equals(""))
			address="N/A";
		else if (phone.equals(null)|| phone.equals(""))
			phone="N/A";
		else
			this.name=name;
			this.zip=zip;
			this.address=address;
			this.phone=phone;
	}
	/**
	 * Returns the name of the Restaurant.
	 * @return the name of the Restaurant object
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the Restaurant.
	 * @param name name of the Restaurant object
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * Returns the zip of the Restaurant.
	 * @return the zip of the Restaurant object
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * Sets the zip of the Restaurant.
	 * @param zip zip of the Restaurant object
	 */
	public void setZip(String zip) {
		this.zip=zip;
	}
	/**
	 * Returns the address of the Restaurant.
	 * @return the address of the Restaurant object
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Sets the address of the Restaurant.
	 * @param address address of the Restaurant object
	 */
	public void setAddress(String address) {
		this.address=address;
	}
	/**
	 * Returns the phone number of the Restaurant.
	 * @return the phone number of the Restaurant object
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Sets the phone number of the Restaurant.
	 * @param phone phone number of the Restaurant object
	 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	/**
	 * Adds the inspection to a given Restaurant.
	 * @param inspect the said inspection details
	 * @throws IllegalArgumentException if the inspection is null
	 */
	public void addInspection(Inspection inspect) throws IllegalArgumentException {
		if (inspect.equals(null))
			throw new IllegalArgumentException("Invalid inspection.");
		else
			inspectionList.add(inspect);
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Restaurant restaurant1) {
		if (this.name.compareToIgnoreCase(restaurant1.name)==0) 
			return this.zip.compareTo(restaurant1.zip);
		
		else
			return this.name.compareToIgnoreCase(restaurant1.name);
			
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if  (this==obj)
			return true;
		if (obj==null)
			return false;
		if (!(obj instanceof Restaurant))
			return false;
		Restaurant other = (Restaurant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}
	/**
	 * Returns the string representation of the Restaurant.
	 * @return the string representation of the Restaurant
	 */
	public String toString() {
		return (name+"\n-----------\naddress	:"+address+"\nzip	:"+zip
				+"\nphone	:"+phone+"\nrecent inspection results:\n"
				+inspectionList.toString());
	}
}

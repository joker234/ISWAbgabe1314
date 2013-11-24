package movieManagement;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String place;
	private int duration;
	private Language language;
	private String description;
	private Country location;
	private Customer loaningCustomer;
	private int ID;
	private static int IDRunner=0;
	/**
	 * @param iDRunner the iDRunner to set
	 */
	public static void setIDRunner(int iDRunner) {
		IDRunner = iDRunner;
	}

	/**
	 * @return the iDRunner
	 */
	public static int getIDRunner() {
		return IDRunner;
	}

	private static final String[] columnNames = {"ID",
		"Name",
		"Time",
		"Language",
		"Description",
	"Place"};


	/**
	 * @return the columnnames
	 */
	public static String[] getColumnnames() {
		return columnNames;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}



	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	public Movie(String name, int dur, Language lang, String desc, Country loc, String place) {
		this.name = name;
		this.duration = dur;
		this.language = lang;
		this.description = desc;
		this.location = loc;
		this.place= place;
		this.ID=IDRunner;
		IDRunner++;
	}

	/**
	 * @return the loaningCustomer
	 */
	public Customer getLoaningCustomer() {
		return loaningCustomer;
	}

	/**
	 * @param loaningCustomer the loaningCustomer to set
	 */
	public void setLoaningCustomer(Customer loaningCustomer) {
		this.loaningCustomer = loaningCustomer;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getLocation() {
		return location;
	}

	public void setLocation(Country location) {
		this.location = location;
	}

	/**
	 * Set the Xth field of a Movie.
	 * @param field
	 */
	public void setX(Object value, int field){
		switch(field){
		case 0:
			//return mymovie.setID();
			break;
		case 1:
			this.setName((String) value);
			break;
		case 2:
			this.setDuration((int) value);
			break;
		case 3:
			this.setLanguage((Language) value);
			break;
		case 4:
			this.setDescription((String)value);
			break;
		case 5:
			this.setPlace((String)value);
			break;
		}
	}

	/**
	 * Get the Xth field of a Movie.
	 * @param field
	 * @return fieldth field
	 */
	public Object getX(int field){
		switch(field){
		case 0:
			return this.getID();
		case 1:
			return this.getName();
		case 2:
			return this.getDuration();
		case 3:
			return this.getLanguage();
		case 4:
			return this.getDescription();
		case 5:
			return this.getPlace();
		}
		return null;

	}
}

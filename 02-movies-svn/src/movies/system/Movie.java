package movies.system;

import java.io.Serializable;

public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String name;
	int duration;
	Language language;
	String description;
	Country location;
	Customer loaningCustomer;
	
	public Movie(String name, int dur, Language lang, String desc, Country loc) {
		this.name = name;
		this.duration = dur;
		this.language = lang;
		this.description = desc;
		this.location = loc;
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
}

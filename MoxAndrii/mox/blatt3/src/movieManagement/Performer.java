package movieManagement;

/**
* MovieManager
*
* Version 1.0 Moritz Nöltner
*
* You don't want to copy this.
* But if, for whatever reason, you still want to, feel free.
*/



/**
* MovieManager
*
* You don't want to copy this.
* But if, for whatever reason, you still want to, feel free.
* 
* @version 22.10.2013
* @author mox
* @project noeltner-a23
*/
public class Performer {

	/**
	 * The first name of the performer.
	 */
	private String firstname;

	/**
	 * The last name of the performer.
	 */
	private String lastname;

	/**
	 * The gender of the performer.
	 */
	private Gender gender;

	/**
	 * Wether the performer is outstanding.
	 */
	private Boolean outstanding=false;
	
	/**
	 * Constructor.
	 * @param firstname the performer's first name
	 * @param lastname the performer's last name
	 * @param gender the performer's gender
	 */
	public Performer(String firstname, String lastname, Gender gender)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
	}

	/**
	 * Gets the performer's first name.
	 * @return the performer's first name
	 */
	public String getFirstname()					{ return firstname; }
	
	/**
	 * Gets the performer's last name.
	 * @return the performer's last name
	 */
	public String getLastname()						{ return lastname; }
	
	/**
	 * Gets the performer's gender.
	 * @return the performer's gender
	 */
	public Gender getGender()						{ return gender; }
	/**
	 * Queries whether the performer is outstanding.
	 * @return whether the performer is outstanding
	 */
	public Boolean isOutstanding()					{ return outstanding; }
	//public Movie getMovie()						{ return movie; }
	
	/**
	 * Sets the first name of the performer.
	 * @param firstname the performer's first name
	 */
	public void setFirstname(String firstname)		{ this.firstname = firstname; }
	
	/**
	 * Sets the last name of the performer.
	 * @param lastname the performer's last name
	 */
	public void setLastname(String lastname)		{ this.lastname = lastname; }
	
	/**
	 * Sets the gender of the performer.
	 * @param gender the performer's gender
	 */
	public void setGender(Gender gender)			{ this.gender = gender; }
	
	/**
	 * Marks the performer as outstanding or not.
	 * @param outstanding whether the performer is outstanding
	 */
	public void setOutstanding(Boolean outstanding)	{ this.outstanding = outstanding; }
	//public void setMovie(Movie movie)				{ this.movie = movie; }
	
	/**
	 * Returns a string representing the object.
	 * @return String representing the object
	 */
	public String toString()
	{
		return "Performer: " + this.firstname + " " + this.lastname + " is " + (this.outstanding? "an": "no") + " outstanding " + this.gender + " actor";
	}

}

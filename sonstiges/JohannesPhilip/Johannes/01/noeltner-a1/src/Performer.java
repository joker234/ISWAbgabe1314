
public class Performer {
	private String firstname;
	private String lastname;
	private Gender gender;
	private Movie movie;
	
	public String getFirstname()				{ return firstname; }
	public String getLastname()					{ return lastname; }
	public Gender getGender()					{ return gender; }
	public Movie getMovie()						{ return movie; }
	public void setFirstname(String firstname)	{ this.firstname = firstname; }
	public void setLastname(String lastname)	{ this.lastname = lastname; }
	public void setGender(Gender gender)		{ this.gender = gender; }
	public void setMovie(Movie movie)			{ this.movie = movie; }

	public Performer(String firstname, String lastname, Gender gender)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
	}
	public Performer(String firstname, String lastname, Gender gender, Movie movie)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
		this.movie=movie;
	}
}

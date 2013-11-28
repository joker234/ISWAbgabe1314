package movies.plain;

/**
 * The Class Performer.
 *
 * @author Alexander Delater
 */
public class Performer {
	
	/** The outstanding. */
	private boolean outstanding;
	
	/** The name. */
	private String name;
	
	/** The gender. */
	private Gender gender;
	
	/** The movie. */
	private Movie movie;
	
	/** The rating. */
	private int rating; 

	/**
	 * Instantiates a new performer.
	 *
	 * @param nameIn the name in
	 * @param genderIn the gender in
	 * @param ratingIn the rating in
	 */
	public Performer(String nameIn, Gender genderIn, int ratingIn) {
		this.name = nameIn;
		this.gender = Gender.MALE;
		this.outstanding = false;
		this.rating = ratingIn;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getgender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param genderIn the new gender
	 */
	public void setGender(Gender genderIn) {
		this.gender = genderIn;
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(final int rating) {
		this.rating = rating;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param nameIn the new name
	 */
	public void setName(final String nameIn) {
		this.name = nameIn;
	}
	
	/**
	 * Gets the movie.
	 *
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Sets the movie.
	 *
	 * @param movieIn the new movie
	 */
	public void setMovie(final Movie movieIn) {
		this.movie = movieIn;
	}
	
	/**
	 * Checks if is outstanding.
	 *
	 * @return true, if is outstanding
	 */
	public boolean isOutstanding() {
		return outstanding;
	}

	/**
	 * Sets the outstanding.
	 *
	 * @param outstandingIn the new outstanding
	 */
	public void setOutstanding(final boolean outstandingIn) {
		this.outstanding = outstandingIn;
	}
	
	/**
	 * Show information.
	 */
	public void showInformation() {
		System.out.println("Name: " + name); 
	    System.out.println("Gender: " + gender);
		System.out.println("Outstanding: " + outstanding);
	}
}

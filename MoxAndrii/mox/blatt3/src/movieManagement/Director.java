/**
 * 
 */
package movieManagement;

/**
 * @author mox
 *
 */
public class Director extends Performer {
	
	/**
	 * The number of movies the Director has directed.
	 */
	private int movieCount;

	/**
	 * @return the movieCount
	 */
	public int getMovieCount() {
		return movieCount;
	}

	/**
	 * @param movieCount the movieCount to set
	 */
	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}



	/**
	 * Constructor.
	 * @param firstname the performer's first name
	 * @param lastname the performer's last name
	 * @param gender the performer's gender
	 * @param movieCount the number of movies this director has directed
	 */
	public Director(String firstname, String lastname, Gender gender, int movieCount) {
		super(firstname, lastname, gender);
		this.movieCount = movieCount;
	}

}

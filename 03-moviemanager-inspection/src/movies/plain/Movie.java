package movies.plain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The Class Movie.
 *
 * @author Alexander Delater
 */
public class Movie {
	
	/** The title. */
	private String title;
	
	/** The time. */
	private int time;
	
	/** The rating. */
	private int rating;
	
	/** The number. */
	private final int number;
	
	/** The nextnumber. */
	private static int nextnumber;
	
	/** The performers. */
	private final Set<Performer> performers;
	
	/** The director. */
	private Director director;

	/**
	 * Instantiates a new movie.
	 *
	 * @param titleIn the title in
	 * @param timeIn the time in
	 * @param ratingIn the rating in
	 */
	public Movie(final String titleIn, final int timeIn, final int ratingIn) {
		this.title = titleIn;
		this.time = timeIn;
		this.rating = ratingIn;
		this.number = nextnumber++;
		performers = new HashSet<Performer>();
	}
	
	/**
	 * Instantiates a new movie.
	 *
	 * @param titleIn the title in
	 * @param timeIn the time in
	 * @param ratingIn the rating in
	 * @param direc the direc
	 */
	public Movie(final String titleIn, final int timeIn, final int ratingIn, final Director direc) {
	    this(titleIn, timeIn, ratingIn);
	    this.director = direc;
	}

	/**
	 * Adds the performer.
	 *
	 * @param performer the performer
	 */
	public void addPerformer(final Performer performer) {
//		performer.setMovie(this);
//		performers.add(performer);
	}

	/**
	 * Gets the performer.
	 *
	 * @param name the name
	 * @return the performer
	 */
	public Performer getPerformer(final String name) {
		Performer temp = null; 
		for (Performer performer : performers) {
			if (performer.getName().equals(name)) {
				temp = performer;
			}
		}
		return temp;
	}
	
	/**
	 * Gets the all outstanding performers.
	 *
	 * @return the all outstanding performers
	 */
	public Set<Performer> getAllOutstandingPerformers() {
		final HashSet<Performer> temp = new HashSet<Performer>();
		for (Performer performer : performers) {
			if (performer.isOutstanding()) {
				temp.add(performer);
			}
		}
		return temp;
	}

	/**
	 * Gets the movie performers.
	 *
	 * @return the movie performers
	 */
	public Set<Performer> getPerformers() {
		return performers;
	}

	/**
	 * Delete movie performers.
	 *
	 * @param performer the performer
	 * @return true, if successful
	 */
	public boolean deletePerformers(final Performer performer) {
		return performers.remove(performer);
	}

	/**
	 * Delete all movie performers.
	 *
	 * @return true, if successful
	 */
	public boolean deleteAllPerformers() {
		return performers.removeAll(performers);
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param titleIn the new title
	 */
	public void setTitle(final String titleIn) {
		this.title = titleIn;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param timeIn the new time
	 */
	public void setTime(final int timeIn) {
		this.time = timeIn;
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
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Gets the director.
	 *
	 * @return the director
	 */
	public Director getDirector() {
	    return null;
	}
	
	/**
	 * Sets the director.
	 *
	 * @param direc the new director
	 */
	public void setDirector(final Director direc) {
	    this.director = direc;
	}

	/**
	 * Show information.
	 */
	public void showInformation() {
		System.out.println("Title: " + this.title);
		System.out.println("Time: " + this.time); 
		System.out.println("Number: " + this.number);
	}
	
	/**
	 * Gets the rating performers.
	 *
	 * @return the rating performers
	 */
	public ArrayList<Integer> getRatingPerformers() {
		ArrayList<Integer> ratingPerformers = new ArrayList<Integer>();
		for (Performer p : performers) {
			ratingPerformers.add(new Integer(p.getRating()));
		}
		return ratingPerformers;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Movie movie1 = new Movie("Testfilm 1", 10, 3);
		final Movie movie2 = new Movie("Testfilm 2", 20, 5);
		final Performer performer1 = new Performer("John Doe", Gender.MALE, 3);
		final Performer performer2 = new Performer("Jane Doe", Gender.FEMALE, 2);
		performer1.setMovie(movie1);
		performer2.setMovie(movie2);
		movie1.showInformation();
		movie2.showInformation();
	}
}

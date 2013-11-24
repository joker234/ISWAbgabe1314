package movieManagement;

/*
 * MovieManager
 *
 * Version 1.0 Moritz Nöltner
 *
 * You don't want to copy this.
 * But if, for whatever reason, you still want to, feel free.
 */

/**
 * Movie
 * 
 * You don't want to copy this. But if, for whatever reason, you still want to,
 * feel free.
 * 
 * @version 22.10.2013
 * @author mox
 * @project noeltner-a23
 */
public class Movie {
	private String title;
	private int time;
	private Director director;

	private final int number;
	private static int nextNumber = 1;

	/**
	 * Constructor, creates a movie object.
	 * 
	 * @param title
	 *            the movie's title
	 * @param time
	 *            the movie's runtime
	 */
	public Movie(String title, int time) {
		this.title = title;
		this.time = time;
		this.number = nextNumber++; // Setzt die Nummer des Objekts und erhöht
									// gleichzeitig die Klassenvariable
	}

	/**
	 * Constructor, creates a movie object.
	 * 
	 * @param title
	 *            the movie's title
	 * @param time
	 *            the movie's runtime
	 * @param director
	 *            the director who directed the movie
	 */
	public Movie(String title, int time, Director director) {
		this.title = title;
		this.time = time;
		this.number = nextNumber++; // Setzt die Nummer des Objekts und erhöht
									// gleichzeitig die Klassenvariable
		this.director = director;
	}

	/**
	 * Gets the movie's title.
	 * 
	 * @return title the movie's title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the movie's runtime.
	 * 
	 * @return runtime the movie's runtime
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * Gets the movie's serial number.
	 * 
	 * @return number the movie's serial number
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Sets the movie's title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	// Die this-Referenz weist immer auf das aktuelle Objekt.
	// Sprich: Im Objekt mymovie vom Typ Movie, das ich unten anlege, weist
	// this auf das Objekt mymovie. So ist es möglich, das Argument title
	// der Methode setTitle vom Objektattribut title von Objekten der Klasse
	// Movie zu unterscheiden.
	// Genauere Erklärung mündlich, weil ich keine Ahnung habe, was man
	// dazu noch mehr sagen soll.

	/**
	 * Sets the movie's runtime.
	 * 
	 * @param time
	 *            the movie's runtime
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the director
	 */
	public Director getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(Director director) {
		this.director = director;
	}

	/**
	 * Returns a string representing the object.
	 * 
	 * @return String a string representing the object
	 */
	public String toString() {
		return "Movie: " + this.title + " is the " + this.number
				+ "th movie and it is " + this.time + "minutes long.";
	}

	/**
	 * Main method, nuff said.
	 * 
	 * @param args
	 *            the command line arguments to the program
	 */
	public static void main(String args[]) {
		// Ein Objekt erzeugen, wie in 1.1.2 gefordert
		final Movie mymovie;
		mymovie = new Movie("DerFilmFilm", 100);

		// Und noch eins, weils so schön ist.
		final Movie myothermovie = new Movie("DerAndereFilm", 92);

		// Und dann testen, ob das alles so funktioniert, wie ich es mir gedacht
		// hab.
		final String s1 = mymovie.getTitle() + ": Länge " + mymovie.getTime()
				+ ", Seriennummer " + mymovie.getNumber();
		System.out.println(s1);
		final String s2 = myothermovie.getTitle() + ": Länge "
				+ myothermovie.getTime() + ", Seriennummer "
				+ myothermovie.getNumber();
		System.out.println(s2);
	}
}

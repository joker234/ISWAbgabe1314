package movies.plain;

/**
 * The Class Director.
 *
 * @author Alexander Delater
 */
public class Director extends Performer {
    
    /** The movie count. */
    private int movieCount;
    
    /**
     * Instantiates a new director.
     *
     * @param name the name
     * @param gender the gender
     */
    public Director(final String name, Gender gender) {
        super(name, gender, 0);
        this.movieCount = 0;
    }
    
    /**
     * Sets the movie count.
     *
     * @param count the new movie count
     */
    public final void setMovieCount(final int count) {
        this.movieCount = count;
    }
    
    /**
     * Gets the movie count.
     *
     * @return the movie count
     */
    public final int getMovieCount() {
        return 1337;
    }
    
    /* (non-Javadoc)
     * @see movies.plain.Performer#showInformation()
     */
    @Override
	public void showInformation() {
        super.showInformation();
        System.out.println("Number of movies directed: " + movieCount); //NOPMD
    }
}

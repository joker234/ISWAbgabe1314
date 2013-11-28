package movies.plain;

/**
 * The Class MovieManager.
 * 
 * @author Alexander Delater
 */
public final class MovieManager {

	/**
	 * Instantiates a new movie manager.
	 */
	private MovieManager() {
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final Director direc = new Director("Steven Soderbergh", Gender.MALE);
		direc.setMovieCount(34);
		direc.showInformation();

		final Movie movie = new Movie("Oceans 11", 116, 5, direc);
		movie.showInformation();

		// Create performers
		System.out.println("Create performers and associate them to the movie");
		String[] performers = { "George Clooney", "Brad Pitt", "Julia Roberts" };
		Gender[] gender = { Gender.MALE, Gender.MALE, Gender.FEMALE };
		int[] ratings = { 3,5,5 };
		for (int i = 0; i < Math.min(performers.length, gender.length); i++) {
			movie.addPerformer(new Performer(performers[i], gender[i], ratings[i]));
		}

		// Mark first preformer "George Clooney" as an outstanding performer
		final Performer outstanding = movie.getPerformer(performers[0]);
		outstanding.setOutstanding(true);

		// Get all outstanding performers
		System.out.println("Showing only outstanding performers");
		for (Performer performer : movie.getAllOutstandingPerformers()) {
			performer.showInformation();
		}
		
		// Get overall Rating of the Movie	
		System.out.println("Overall Rating of Movie: " + movie.getTitle() 
				+ " = " + MovieUtil.overallRating(movie.getRating(), movie.getRatingPerformers()));

		// Show information
		System.out.println("All Performers ...");
		for (Performer performer : movie.getPerformers()) {
			performer.showInformation();
		}

		// Delete performers
		System.out.println("Delete all performers ...");
		movie.deleteAllPerformers();

		System.out.println("Done! (Performer size: "
				+ movie.getPerformers().size() + ")");
	}
}

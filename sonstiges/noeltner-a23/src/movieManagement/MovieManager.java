package movieManagement;
/*
* MovieManager
*
* Version 1.0 Moritz Nöltner
*
* You don't want to copy this.
* But if, for whatever reason, you still want to, feel free.
*/

// We will map Actors to each Movie, therefore a HashMap seems suited


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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
public class MovieManager {
	/**
	 * The mapping between Movies and Performers.
	 */
	private final Map<Movie, ArrayList<Performer>> map;
	
	/**
	 * The constuctor, creates a MovieManager objekt.
	 */
	public MovieManager()
	{
		map=new HashMap<Movie, ArrayList<Performer>>();
	}
	

	/**
	 * Adds a performer to the Database.
	 * @param movie the movie to add to
	 * @param performer the performer to add
	 */
	public void addPerformer(Movie movie, Performer performer){
		List<Performer> performers = map.get(movie);
		if(performers == null)
		{
			performers = new ArrayList<Performer>();
		}
		// Any one actor can only play in a movie once.
		if(!performers.contains(performer))
		{
			performers.add(performer);
			map.put(movie, (ArrayList<Performer>)performers);
		}
	}

	/**
	 * Remove all performers from a movie.
	 * @param movie the movie, whose performers should be removed
	 */
	public void clearPerformers(Movie movie){
		final List<Performer> performers = map.get(movie);
		if(performers != null)
		{
		performers.clear();
		map.put(movie, (ArrayList<Performer>)performers);
		}
	}
	/**
	 * Gets all the Performers for one Movie.
	 * @param movie the movie, who's performers to list
	 * @return a list of all performers
	 */
	public List<Performer> getPerformers(Movie movie){
		return map.get(movie);
	}

	/**
	 * Gets the n-th performer for one Movie, there is no warranty that the sorting won't change.
	 * @param movie the movie, who's outstanding performers to list
	 * @param index the index-th performer will be listed
	 * @return the movie's performer
	 */
	public Performer getPerformer(Movie movie, int index){
		final List<Performer> performers = this.getPerformers(movie);
		if(performers != null && performers.size() > index)
		{
			return performers.get(index);
		}
		return null;
	}
	
	/**
	 * Gets all the oputstanding Performers for one Movie.
	 * @param movie the movie, who's outstanding performers to list
	 * @return the movie's outstanding performers
	 */
	public List<Performer> getOutstandingPerformers(Movie movie){
		final List<Performer> performers = this.getPerformers(movie);
		final List<Performer> returnList = new ArrayList<Performer>();
		
		for(Performer performer : performers)
		{
			if(performer.isOutstanding()) {
				returnList.add(performer);
			}
		}
		return returnList;
	}
	
	/**
	 * Checks, whether somebody is starring in a movie.
	 * @param movie the movie whose performers to search
	 * @param name ther performer's name
	 * @return whether the name was found to be a performer in the movie
	 */
	public Boolean searchPerformer(Movie movie, String name) {
		final List<Performer> performers = this.getPerformers(movie);

		for(Performer performer : performers)
		{
			if(performer.getFirstname().equalsIgnoreCase(name) && performer.getLastname().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The main method, nuff said.
	 * @param args the command line arguments to the program
	 */
	public static void main(String args[])
	{
		System.out.println("Let's create some actors:");
		final Performer performer1=new Performer("Max", "Mustermann", Gender.Male);
		final Performer performer2=new Performer("Anna", "Musterfrau", Gender.Female);
		System.out.println(performer1);
		System.out.println(performer2);
		System.out.println("");
		System.out.println("Now, let's have them marry:");
		performer1.setLastname(performer2.getLastname());
		System.out.println(performer1);
		System.out.println(performer2);
		System.out.println("");
		System.out.println("Well, marriage is nice, but sometimes, things change. In our case, Max finds, he is really a female:");
		performer1.setGender(Gender.Female);
		performer1.setFirstname("Julia");
		System.out.println(performer1);
		System.out.println("");
		System.out.println("Anna, who is now a wife to a wife, becomes quite a bit frustrated. To distract herself, she increases her acting training:");
		performer2.setOutstanding(true);
		System.out.println(performer2);
		System.out.println("");
		System.out.println("There is a new movie, starring our couple.");
		final Movie movie=new Movie("Mustermovie", 92);
		System.out.println(movie);
		System.out.println("");
		System.out.println("Let's add it to a database:");
		System.out.println("So first, let's create such a database...");
		final MovieManager movman=new MovieManager();
		System.out.println("...and add the new movie to it:");
		movman.addPerformer(movie, performer1);
		movman.addPerformer(movie, performer2);
		System.out.println("");
		System.out.println("Now, let's check the movie was added correctly, by checking which actors contributed to it:");
		System.out.println(movman.getPerformers(movie));
		System.out.println("");
		System.out.println("Lets check, if Max is also starring in the movie: " + movman.searchPerformer(movie, "Max"));
		System.out.println("");
		System.out.println("But is the movie good? Better check if there are any outstanding actors in it:");
		System.out.println(movman.getOutstandingPerformers(movie));
		System.out.println("Well, it looks promising, let's watch it");
		System.out.println("...");
		System.out.println("");
		System.out.println("...");
		System.out.println("");
		System.out.println("...");
		System.out.println("");
		System.out.println("Now guess what: There was a mistake. Our movie was an animal film and there was not even one actor in it. Better remove the actors in our database");
		movman.clearPerformers(movie);
		System.out.println(movman.getPerformers(movie));
		System.out.println("Now! This looks better!");
		System.out.println("Thanks for your time!");
	}
}

/*
 * ArrayList:
 * - Implementiert ein Array -> Schneller Indexzugriff
 * - Langsame Suche nach Schlüsseln
 * - Implementiert nicht direkt eine Map -> Zuordnung müsste extern geschehen
 * 
 * HashSet:
 * - Implementiert eine gehashte Menge -> Schneller Schlüsselzugriff
 * - Keine Reihenfolge definierbar
 * - Implementiert nicht direkt eine Map -> Zuordnung müsste extern geschehen
 * 
 * HashMap:
 * - Implementierte eine gehashte Zuordnung -> Schneller Schlüsseszugriff
 * - Keine Reihenfolge definierbar
 * - Zugriff und Suche nach Wert langsam
 */
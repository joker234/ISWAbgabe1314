/**
 * 
 */
package movieManagement;

import java.util.List;
import java.util.LinkedList;
/**
 * @author mox, andrii
 *
 */
public class Customer {
	public String name;
	List<Movie> loanedMovies;

	public boolean loanMovie(Movie movie) {
		if(loanedMovies.size() < 5) {		
			if (movie.getLoaningCustomer() == null) {
				loanedMovies.add(movie);
				movie.setLoaningCustomer(this);
				return true;
			}
			else {
				System.out.println("Film ist schon an KundIn " + movie.getLoaningCustomer() + " verliehen");
				return false;

			}
		}
		else { 
			System.out.println("Kunde " + this + " hat schon 5 Filme ausgeliehen");
			return false;
		}
	}


	public String toString() {
		return this.name;
	}

	public Customer(String name) {
		this.name=name;
		this.loanedMovies=new LinkedList<Movie>();
	}
	
	public static void main(String args[])
	{
		Customer kunde1=new Customer("mox");
		Customer kunde2=new Customer("andrii");
		

		Movie film1=new Movie("Film1", 1, Language.GER, "beschreibung1", Country.GER, "Place1");
		Movie film2=new Movie("Film2", 2, Language.GER, "beschreibung2", Country.GER, "Place2");
		Movie film3=new Movie("Film3", 3, Language.GER, "beschreibung3", Country.GER, "Place3");
		Movie film4=new Movie("Film4", 4, Language.GER, "beschreibung4", Country.GER, "Place4");
		Movie film5=new Movie("Film5", 5, Language.GER, "beschreibung5", Country.GER, "Place5");
		Movie film6=new Movie("Film6", 6, Language.GER, "beschreibung6", Country.GER, "Place6");
		Movie film7=new Movie("Film7", 7, Language.GER, "beschreibung7", Country.GER, "Place7");
		

		kunde1.loanMovie(film1);
		kunde2.loanMovie(film1);
		
		kunde2.loanMovie(film2);
		kunde2.loanMovie(film3);
		kunde2.loanMovie(film4);
		kunde2.loanMovie(film5);
		kunde2.loanMovie(film6);
		kunde2.loanMovie(film7);

	}
	
}

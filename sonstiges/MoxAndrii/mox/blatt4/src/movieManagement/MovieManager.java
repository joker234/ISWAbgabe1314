package movieManagement;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MovieManager {

	//HashMap<String, Movie> movies; // Der benutzt halt keine ArrayList, aber so what. Ich hab wirklich keine Lust, das nochmal neu zu machen!
	List<Movie> movies;

	public MovieManager() {
		//movies = new HashMap<String, Movie>();
		movies = new ArrayList<Movie>();
		loadMovies();
	}

	public void saveMovies() {
		OutputStream fos = null;
		ObjectOutputStream outstream = null;
		try {
			fos = new FileOutputStream("mngr_data");
			outstream = new ObjectOutputStream(fos);

			//for(Movie mov : movies.values()) {
			for(Movie mov : movies) {
				outstream.writeObject(mov);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				outstream.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadMovies() {
		movies.clear(); // use with care in case of unsaved movies
		InputStream fis = null;
		ObjectInputStream instream = null;
		try {
			fis = new FileInputStream("mngr_data");
			instream = new ObjectInputStream(fis);

			int max=0;
			while(true) {
				Movie readMov = (Movie)instream.readObject();
				if(readMov != null) {
					//movies.put(readMov.getName(), readMov);
					movies.add(readMov);
					if(readMov.getID()>max)
					{
						max = readMov.getID();
						Movie.setIDRunner(max+1);
					}
				}
				else {
					break;
				}
			}
		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(instream != null)
					instream.close();
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addMovie(Movie movie) {
		//movies.put(movie.getName(), movie);
		movies.add(movie);
		this.saveMovies();
	}

//	public void modMovie(String name, Language language) {
//		movies.get(name).setLanguage(language);
//	}
//
//	public void modMovie(String name, String description) {
//		movies.get(name).setDescription(description);
//	}
//
//	public void modMovie(String name, Country location) {
//		movies.get(name).setLocation(location);
//	}

	public void remMovie(String name) {
		for(Movie mov : movies)
		{
			if(mov.getName().equals(name))
				movies.remove(mov);
		}
		this.saveMovies();
	}

	public void removeMovie(int n)
	{
		movies.remove(n);
		this.saveMovies();
	}

	//public HashMap<String, Movie> getMovies() {
	public List<Movie> getMovies() {
		//return movies;
		return (List<Movie>) movies;
	}

	public Movie getMovie(String movieName) {
		//return movies.get(movieName);

		for(Movie mov : movies)
		{
			if(mov.getName().equals(movieName))
				return mov;
		}
		return null;
	}

	public Movie getMovie(int n){
		//return (Movie)movies.values().toArray()[n];
		return (Movie)movies.toArray()[n];
	}

	public int size() {
		return movies.size();
	}
}

package movies.system;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

public class MovieManager {
	
	HashMap<String, Movie> movies;
	
	public MovieManager() {
		movies = new HashMap<String, Movie>();
		loadMovies();
	}
	
	public void saveMovies() {
		OutputStream fos = null;
		ObjectOutputStream outstream = null;
		try {
			fos = new FileOutputStream("mngr_data");
			outstream = new ObjectOutputStream(fos);

			for(Movie mov : movies.values()) {
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

			while(true) {
				Movie readMov = (Movie)instream.readObject();
				if(readMov != null) {
					movies.put(readMov.getName(), readMov);
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
		movies.put(movie.getName(), movie);	
	}
	
	public void modMovie(String name, Language language) {
		movies.get(name).setLanguage(language);
	}
	
	public void modMovie(String name, String description) {
		movies.get(name).setDescription(description);
	}
	
	public void modMovie(String name, Country location) {
		movies.get(name).setLocation(location);
	}
	
	public void remMovie(String name) {
		movies.remove(name);
	}
	
	public HashMap<String, Movie> getMovies() {
		return movies;
	}
	
	public Movie getMovie(String movieName) {
		return movies.get(movieName);
	}
}

package movies.ui;

import java.io.*;

import movies.system.Country;
import movies.system.Language;
import movies.system.Movie;
import movies.system.MovieManager;


public class Console {
	
	private static String input = "";
	private static BufferedReader reader;
	private static MovieManager manager = new MovieManager();
	private static Cmd[] curCmds;
	
	static {
		// create input stream handling
		reader = new BufferedReader
				(new InputStreamReader(System.in));
	}

	private static void exit() {
		print("saving movies...");
		manager.saveMovies();
		print("saving complete.");
		System.exit(0);
	}
	
	private static void print(String line) {
		System.out.println(line);
	}
	
	/*
	private static void printHelpAll() {
		print("These are all commands");
		for(Cmd cmds : Cmd.values()) {
			print(cmds.name + " - " + cmds.description);
		}
	}
	*/
	
	private static void printHelp() {
		print("These are the currently available commands");
		for(int i = 0; i < curCmds.length; ++i) {
			print(curCmds[i].name + " - " + curCmds[i].description);
		}
	}
	
	public static String readCmd() throws IOException {
		// check for general purpose commands
		while(true) {
			input = reader.readLine();
			if(input.equals(Cmd.EXIT.name) || input.equals(Cmd.QUIT.name)) {
				exit();
			}
			else if(input.equals(Cmd.HELP.name) || input.equals(Cmd.H.name)) {
				printHelp();
			}
			else {
				break;
			}
		}
		return input;
	}
	
	private static Language getLanguage() throws IOException {
		while(true) {
			curCmds = new Cmd[]{Cmd.EXIT, Cmd.QUIT, Cmd.HELP, Cmd.H, Cmd.BACK, Cmd.B};
			print("available languages are:");
			for(Language lang : Language.values()) {
				print("\"" + lang.name + "\" or \"" + lang.abbreviation + "\"");
			}
			input = readCmd();
			
			// allow going back from language selection
			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				break;
			}
			
			// check if entered input is a valid language
			Language language = null;
			for(Language lang : Language.values()) {
				if(input.equals(lang.name) || input.equals(lang.abbreviation)) {
					language = lang;
				}
			}
			
			if(language != null) {
				return language;
			}
			else {
				print("sorry, the language does not exist, please enter a new one");
			}
		}
		return null;
	}
	
	private static Country getLocation() throws IOException {
		while(true) {
			curCmds = new Cmd[]{Cmd.EXIT, Cmd.QUIT, Cmd.HELP, Cmd.H, Cmd.BACK, Cmd.B};
			print("available locations are:");
			for(Country loc : Country.values()) {
				print("\"" + loc.name + "\" or \"" + loc.abbreviation + "\"");
			}
			input = readCmd();
			
			// allow going back from location selection
			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				break;
			}
			
			// check if entered input is a valid location
			Country location = null;
			for(Country loc : Country.values()) {
				if(input.equals(loc.name) || input.equals(loc.abbreviation)) {
					location = loc;
				}
			}
			
			if(location != null) {
				return location;
			}
			else {
				print("sorry, the location does not exist, please enter a new one");
			}
		}
		return null;
	}
	
	
	private static boolean createMovie() throws IOException {
		print("please enter the movie's name");
		input = readCmd(); // read movie name
		if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
			return false;
		}
		String newName = input;
		
		int newDur = 0;
		while(true) {
			print("please enter the movie's duration in hours");
			input = readCmd(); // read movie duration
			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				print("cancelled movie creation");
				return false;
			}

			try {
				newDur = Integer.parseInt(input);
				break;
			}
			catch(NumberFormatException formatEx) {
				print("sorry, your entry was not a valid number");
				print("you can enter \"back\" to cancel movie creation");
			}
		}
		
		print("please enter the movie's language");
		Language newLang = getLanguage();
		if(newLang == null) {
			return false;
		}
				
		print("please enter the movie's description");
		input = readCmd(); // read movie name
		if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
			return false;
		}
		String newDesc = input;
				
		print("please enter the movie's location");
		Country newLoc = getLocation();
		if(newLoc == null) {
			return false;
		}
				
		manager.addMovie(new Movie(newName, newDur, newLang, newDesc, newLoc));
		return true;
	}
	
	public static void showAllMovies() throws IOException {
		
		while(true) {
			// show all movies
			int movieCount = manager.getMovies().size();
			String[] movieNames = new String[movieCount];
			movieNames = (String[]) (manager.getMovies().keySet().toArray(movieNames));
			
			print("manager contains " + movieCount + " movies, listing all:");
			for(String name : movieNames) {
				print(name);
			}
			
			print("Please enter the movie's name that u want to use");
			print("or you can enter \"back\" to go back");
			curCmds = new Cmd[]{Cmd.EXIT, Cmd.QUIT, Cmd.HELP, Cmd.H, Cmd.BACK, Cmd.B};
			input = readCmd();
			
			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				break;
			}
			
			String selectedMovie = "";
			for(int i = 0; i < movieCount; ++i) {
				if(input.equals(movieNames[i])) {
					selectedMovie = movieNames[i];
					break;
				}
			}
			if(selectedMovie == "") {
				print("Sorry, the movie you entered does not exist");
				continue;
			}
			else {
				usingMovie(selectedMovie);
			}
		}
	}
	
	private static void modifyMovie(String movieName) throws IOException {
		while(true) {
			curCmds = new Cmd[]{Cmd.BACK, Cmd.B};
			print("modifying movie: \"" + movieName + "\"available options are:");
			print("language");
			print("description");
			print("location");
			print("use \"back\" to return to selection");
			input = readCmd();

			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				break;
			}
			else if(input.equals("language")) {
				print("please enter the movie's language");
				Language newLang = getLanguage();
				if(newLang == null) {
					break;
				}
				manager.getMovie(movieName).setLanguage(newLang);
			}
			else if(input.equals("description")) {
				print("please enter the movie's description");
				input = readCmd(); // read movie name
				if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
					break;
				}
				manager.getMovie(movieName).setDescription(input);
			}
			else if(input.equals("location")) {
				print("please enter the movie's location");
				Country newLoc = getLocation();
				if(newLoc == null) {
					break;
				}
				manager.getMovie(movieName).setLocation(newLoc);
			}
		}
	}
	
	private static void removeMovie(String movieName) {
		manager.remMovie(movieName);
		print("removed movie \"" + movieName + "\"");
	}
	
	private static void showMovie(String movieName) {
		Movie curMovie = manager.getMovie(movieName);
		print("showing details on movie: " + movieName);
		print("duration: " + curMovie.getDuration());
		print("language: " + curMovie.getLanguage().name);
		print("description: " + curMovie.getDescription());
		print("location: " + curMovie.getLocation().name);
	}
	
	private static void usingMovie(String movieName) throws IOException{
		while(true) {
			print("You selected \"" + movieName + "\"");
			print("You can now modify, delete or view this movie, check \"help\" for commands");
			curCmds = new Cmd[]{Cmd.EXIT, Cmd.QUIT, Cmd.HELP, Cmd.H, Cmd.BACK, Cmd.B,
					Cmd.MODMOV, Cmd.REMMOV, Cmd.SHOWMOV};
			input = readCmd();

			if(input.equals(Cmd.BACK.name) || input.equals(Cmd.B.name)) {
				break;
			}
			else if(input.equals(Cmd.MODMOV.name)) {
				modifyMovie(movieName);
			}
			else if(input.equals(Cmd.REMMOV.name)) {
				removeMovie(movieName);
			}
			else if(input.equals(Cmd.SHOWMOV.name)) {
				showMovie(movieName);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		
		print("This is great the movie manager, please enter a command");
		while(true) {			
			print("You can check all available commands by entering \"help\"");
			curCmds = new Cmd[]{Cmd.EXIT, Cmd.QUIT, Cmd.HELP, Cmd.H, Cmd.SHOWALL, Cmd.ADDMOV};
			input = readCmd();
			
			if(input.equals(Cmd.SHOWALL.name)) {
				showAllMovies();
			}
			else if(input.equals(Cmd.ADDMOV.name)) {
				if(createMovie() == false) {
					print("canceled movie creation");
				}
				else {
					print("movie successfully created");
				}
			}
			else {
				print("sorry, \"" + input + "\" is an unkown command");
			}
		}

	}

}

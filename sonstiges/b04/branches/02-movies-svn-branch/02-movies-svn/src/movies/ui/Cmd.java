package movies.ui;

public enum Cmd {
	EXIT("exit", "saves and then exits the program"),
	QUIT("quit", "alias for exit"),
	
	BACK("back", "goes back one step"),
	B("b", "alias for back"),
	
	HELP("help", "prints the command list"),
	H	("h", "alias for help"),
	
	SHOWALL("showall", "shows all movies available in movie manager"),
	
	ADDMOV("addmov", "adds movie to movie manager"),
	MODMOV("modmov", "modifies movie information"),
	REMMOV("remmov", "removes movie from movie manager"),
	SHOWMOV("showmov", "shows all data on a movie");
	
	String name;
	String description;
	
	Cmd(String name, String description) {
		this.name = name;
		this.description = description;
	}
}

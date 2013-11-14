package movieManagement;

public enum Language {
	GER("German", "ger"),
	EN ("English", "en"),
	JP ("Japanese", "jp");
	
	public final String name;
	public final String abbreviation;
	
	private Language(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}
}

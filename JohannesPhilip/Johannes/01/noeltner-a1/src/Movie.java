
public class Movie {
	private String title;
	private int time;
	private int number;
	private static int nextNumber=1;
	
	public Movie(String title, int time)
	{
		this.title=title;
		this.time=time;
		this.number=nextNumber++; // Setzt die Nummer des Objekts und erhöht gleichzeitig die Klassenvariable
	}
	
	public String getTitle()			{ return this.title; }
	public int getTime()				{ return this.time; }
	public int getNumber()				{ return this.number; }
	
	public void setTitle(String title)	{ this.title=title; }
	// Die this-Referenz weist immer auf das aktuelle Objekt.
	// Sprich: Im Objekt mymovie vom Typ Movie, das ich unten anlege, weist
	// this auf das Objekt mymovie. So ist es möglich, das Argument title
	// der Methode setTitle vom Objektattribut title von Objekten der Klasse
	// Movie zu unterscheiden.
	// Genauere Erklärung mündlich, weil ich keine Ahnung habe, was man
	// dazu noch mehr sagen soll.
	public void setTime(int time)		{ this.time=time; }
	
	public static void main(String args[]) {
		// Ein Objekt erzeugen, wie in 1.1.2 gefordert
		Movie mymovie;
		mymovie = new Movie("DerFilmFilm", 100);
		
		// Und noch eins, weils so schön ist.
		Movie myothermovie=new Movie("DerAndereFilm", 92);
		
		// Und dann testen, ob das alles so funktioniert, wie ich es mir gedacht hab.
		String s1=mymovie.getTitle() + ": Länge " + mymovie.getTime() + ", Seriennummer " + mymovie.getNumber();
		System.out.println(s1);
		String s2=myothermovie.getTitle() + ": Länge " + myothermovie.getTime() + ", Seriennummer " + myothermovie.getNumber();
		System.out.println(s2);
	}
}

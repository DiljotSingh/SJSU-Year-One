
import java.util.ArrayList;
import java.util.TreeSet;
//Models a class called TreeFilmArchive which is a TreeSet of Movie objects and implements the FilmArchive interface
public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {
	/**
	 * Returns the TreeFilmArchive contents in an ArrayList 
	 * @return sortedArrayList the ArrayList with the sorted contents
	 */
	public ArrayList<Movie> getSorted() {
		ArrayList<Movie> sortedArrayList = new ArrayList<Movie>(this); //Passes this class's sorted contents into an ArrayList
		return sortedArrayList; // returns that ArrayList
	}
	// Main method that tests adding Movies to a TreeFilmArchive, printing them, sorting them, and then printing them again

	public static void main(String[] args) {
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}
}

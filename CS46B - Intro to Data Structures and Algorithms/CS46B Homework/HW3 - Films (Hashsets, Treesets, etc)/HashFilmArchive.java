
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/*
 * Models a class called HashFilmArchive which is a HashSet of Movie objects and implements FilmArchive
 */
public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {
	/*
	 * Constructs a TreeSet that sorts this HashSet (this), and then transfers those stored contents into an ArrayLis which is returned
	 * @return sortedArrayList the sorted ArrayList
	 */
	
	public ArrayList<Movie> getSorted() {

		TreeSet<Movie> sortedSet = new TreeSet<Movie>(this); //Sorts this HashSet with a TreeSet
		ArrayList<Movie> sortedArrayList = new ArrayList<Movie>(sortedSet); //Puts the sorted set in the ArrayList
		return sortedArrayList;
	}
	// Main method that tests adding Movies to a HashFilmArchive, printing them, sorting them, and then printing them again

	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}
}

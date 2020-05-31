
import java.util.ArrayList;

//Interface FilmArchive which has two methods and is implemented by ListFilm, HashFilm, and TreeFilm
public interface FilmArchive {
	/*
	 * getSorted() takes no args and returns ArrayList<Movie>. Implementations
	 * should return an array list whose members are unique according to deep
	 * equality, and sorted according to the criteria in Movie’s compareTo() method.
	 */
	ArrayList<Movie> getSorted();

	/*
	 * add() takes one arg of type Movie and returns a boolean. If add() is called
	 * where the arg already appears (according to deep-equality) in the film
	 * archive, the method should return false and do nothing else; if the arg of
	 * add() does not yet appear in the archive, it should be added as described
	 * below and the method should return true.
	 */
	boolean add(Movie m);

}

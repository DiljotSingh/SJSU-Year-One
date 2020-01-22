package movies;

import java.util.ArrayList;
import java.util.TreeSet;
/*
 * Models a class called ListFilmArchive which is an ArrayList of Movie objects and implements the FilmArchive interface
 */
public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	/**
	 * Adds this Movie to the ArrayList if is already not present; returns true if
	 * the movie was added, false if not
	 */
	public boolean add(Movie m) {
		
		for (Movie d : this) // loops through all the Movies in ListFilmArchive
		{
			if (d.equals(m)) { 
				return false;
			}
		}
		super.add(m); // adds the arg Movie m if it is not already in the ArrayList
		return true;
		
	}

	/**
	 * Constructs a TreeSet that sorts this ArrayList then returns the sorted
	 * contents in another ArrayList
	 * @return sortedArrayList the ArrayList that was sorted using a TreeSet
	 */
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> sortedSet = new TreeSet<Movie>(this);
		ArrayList<Movie> sortedArrayList = new ArrayList<Movie>(sortedSet);
		return sortedArrayList;

	}
	// Main method that tests adding Movies to a ListFilmArchive, printing them, sorting them, and then printing them again
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m : Movie.getTestMovies()) {

			archive.add(m);
		}
		for (Movie m : archive) {
			System.out.println(m);
		}

		System.out.println("**************");
		for (Movie m : archive.getSorted()) {
			System.out.println(m);
		}
	}
}

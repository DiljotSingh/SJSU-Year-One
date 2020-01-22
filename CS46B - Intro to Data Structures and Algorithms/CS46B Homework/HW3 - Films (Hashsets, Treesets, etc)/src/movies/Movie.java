package movies;

/**
 * Models a Movie that has a title and year of production
 */
public class Movie implements Comparable<Movie> {
	private String title;
	private int year;

	/**
	 * Constructs a Movie with a title and year
	 * 
	 * @param title the title of this movie
	 * @param year the year this movie was made
	 */
	public Movie(String theTitle, int theYear) {
		title = theTitle;
		year = theYear;
	}

	/**
	 * Compares this Movie to another Movie (otherMovie) based on title then year
	 * 
	 * @param Movie otherMovie, the other movie to compare to
	 * @return value the value -1, 0, or 1, depending on whether this Movie should
	 *         come before or after the otherMovie based on title then year
	 */
	public int compareTo(Movie otherMovie) {

		int value = title.compareTo(otherMovie.title); // compares the titles
		if (value == 0) { // if the titles are the same (value == 0) then compares years
			value = (int)Double.compare(year, otherMovie.year); // compares years
		}
		return value; //returns the final value, based on comparing titles and year
	}

	/*
	 * Gets the title of this Movie
	 * 
	 * @return String title the title of this movie
	 */
	public String getTitle() {
		return title;

	}

	/**
	 * Gets the year of the Movie
	 * 
	 * @return year the year this movie was made
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Checks if this Movie is equal to another movie based on whether they have the
	 * same title and year of production or not
	 * 
	 * @param Movie otherMovie, the other movie to check for equality
	 * @return true if they have the same title and year, false if not
	 */
	public boolean equals(Movie otherMovie) {
		return this.compareTo(otherMovie) == 0;
	}
	/**
	 * Returns a description of this movie in a readable format, displaying title then year
	 */
	public String toString() {
		return "Movie " + title + " " + "(" + year + ")";
	}
	/**
	 * Constructs an Array of movies with titles and years which can be used to test the various methods implemented
	 * @return movies the Array of movies constructed
	 */
	public static Movie[] getTestMovies() {
		Movie[] movies = new Movie[10];
		movies[0] = new Movie("The Secret Life of Pets", 2000);
		movies[1] = new Movie("The Secret Life of Pets", 2001);
		movies[2] = new Movie("Dog", 1999);
		movies[3] = new Movie("Cat", 1999);
		movies[4] = new Movie("Bingo", 2012);
		movies[5] = new Movie("Bingo", 2012);
		movies[6] = new Movie("Hello", 2015);
		movies[7] = new Movie("Bye", 2016);
		movies[8] = new Movie("Diljot Superstar", 2018);
		movies[9] = new Movie("Aquaman", 2018);
		return movies;
	}
	
	/**
	 * Returns a hashCode that tries to avoid as many collisions as possible by getting the hashCode of the title and adding it to the year of the movie
	 */
	public int hashCode() {
		return title.hashCode() + year;
	}
	

}

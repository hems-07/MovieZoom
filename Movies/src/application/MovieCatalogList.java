package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MovieCatalogList {
	ArrayList<Movie> movies;
	
	public MovieCatalogList() {
		movies = new ArrayList<>();
		
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void dropMovie(String movieName) {
		Movie removeMovie = null;
		for (Movie movie: movies) {
			if (movie.title.equalsIgnoreCase(movieName)){
				removeMovie = movie;
			}
		}
		movies.remove(removeMovie);
	}
	
	public void updateMovie(Movie movieNew, Movie movieOld) {
		int index = movies.indexOf(movieOld);
		movies.remove(movieOld);
		movies.add(index, movieNew);
	}
	
	public ArrayList<String> searchByCategory(String genre) {
		ArrayList<String> mov = new ArrayList<>();
		for (Movie m: movies) {
			if (m.genre.equalsIgnoreCase(genre)) {
				mov.add(m.title);
			}
		}
		return mov;
	}
	
	public ArrayList<String> searchByDirector(String director) {
		ArrayList<String> mov = new ArrayList<>();
		for (Movie m: movies) {
			if (m.director.equalsIgnoreCase(director)) {
				//System.out.println(director + " | " + m.title);
				mov.add(m.title);
			}
		}
		return mov;
	}
	
	public ArrayList<String> searchByRating(String rating) {
		ArrayList<String> mov = new ArrayList<>();
		for (Movie m: movies) {
			if (m.rating.equalsIgnoreCase(rating)) {
				mov.add(m.title);
			}
		}
		return mov;
	}
	
	public ArrayList<String> searchByYear (String year) {
		ArrayList<String> mov = new ArrayList<>();
		for (Movie m: movies) {
			if (m.year.equalsIgnoreCase(year)) {
				mov.add(m.title);
			}
		}
		return mov;
	}
	
	public ArrayList<Movie> sortByUserRating() {
		ArrayList<Movie> sortArray = movies;
		Collections.sort(sortArray, new SortHandle(1));
		return sortArray;
	}
	
	public ArrayList<Movie> sortByTapeNumber() {
		ArrayList<Movie> sortArray = movies;
		Collections.sort(sortArray, new SortHandle(2));
		return sortArray;
	}
	
	public ArrayList<String> getMovieNames() {
		ArrayList<String> movieNames = new ArrayList<>();
		for (Movie movie: movies) {
			movieNames.add(movie.title);
		}
		Collections.sort(movieNames, new AlphanumericComparator());
		return movieNames;
	}
	
	public ArrayList<String> getGenreNames() {
        Set<String> uniqueGenres = new HashSet<>();
        for (Movie movie : movies) {
            uniqueGenres.add(movie.genre);
        }
        ArrayList<String> sortedGenres = new ArrayList<>(uniqueGenres);
        Collections.sort(sortedGenres, new AlphanumericComparator());
        return sortedGenres;
    }

    public ArrayList<String> getRatingNames() {
        Set<String> uniqueRatings = new HashSet<>();
        for (Movie movie : movies) {
            uniqueRatings.add(movie.rating);
        }
        ArrayList<String> sortedRatings = new ArrayList<>(uniqueRatings);
        Collections.sort(sortedRatings, new AlphanumericComparator());
        return sortedRatings;
    }

    public ArrayList<String> getDirectorNames() {
        Set<String> uniqueDirectors = new HashSet<>();
        for (Movie movie : movies) {
            uniqueDirectors.add(movie.director);
        }
        ArrayList<String> sortedDirectors = new ArrayList<>(uniqueDirectors);
        Collections.sort(sortedDirectors, new AlphanumericComparator());
        return sortedDirectors;
    }

    public ArrayList<String> getYears() {
        Set<String> uniqueYears = new HashSet<>();
        for (Movie movie : movies) {
            uniqueYears.add(movie.year);
        }
        ArrayList<String> sortedYears = new ArrayList<>(uniqueYears);
        Collections.sort(sortedYears, new AlphanumericComparator());
        return sortedYears;
    }
	
	public String getMovieDetail(String movieName) {
		for (Movie movie: movies) {
			if (movie.title.equalsIgnoreCase(movieName)) {
				return movie.toString();
			}
		}
		return null;
	}
	@Override
	public String toString() {
		String finalResult = "";
		for (Movie m: movies) {
			finalResult += m.toString();
			finalResult += "\n";
		}
		return "CATALOG" + finalResult;
	}
	

}
class SortHandle implements Comparator<Movie> {
	int handle;
	public SortHandle (int handle) {
		this.handle = handle;
	}
	@Override
	public int compare(Movie m1, Movie m2) {
		return handle == 1 ? (Integer.parseInt(m1.userRating) - Integer.parseInt(m2.userRating)) : (Integer.parseInt(m1.tapeNumber) - Integer.parseInt(m2.tapeNumber));
	}
}

class AlphanumericComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        return compareAlphanumeric(str1, str2);
    }

    private int compareAlphanumeric(String str1, String str2) {
        String[] parts1 = str1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String[] parts2 = str2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        int minSize = Math.min(parts1.length, parts2.length);

        for (int i = 0; i < minSize; i++) {
            if (Character.isDigit(parts1[i].charAt(0)) && Character.isDigit(parts2[i].charAt(0))) {
                // Compare numeric parts as integers
                int num1 = Integer.parseInt(parts1[i]);
                int num2 = Integer.parseInt(parts2[i]);
                int numComparison = Integer.compare(num1, num2);
                if (numComparison != 0) {
                    return numComparison;
                }
            } else {
                // Compare non-numeric parts as strings
                int strComparison = parts1[i].compareTo(parts2[i]);
                if (strComparison != 0) {
                    return strComparison;
                }
            }
        }

        // If the common parts are equal, compare based on length
        return Integer.compare(str1.length(), str2.length());
    }
}

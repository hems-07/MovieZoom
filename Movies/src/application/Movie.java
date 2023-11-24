package application;

public class Movie {
	/*
	 *  i.	String – title 
		ii.	String – director 
		iii.	int       – year
		iv.	String – genre 
		v.	int       – user Rating
		vi.	String – rating
		vii.	String – comments 
		viii.	String – source
		ix.	int       – tapeNumber

	 */
	public String title;
	String director;
	String year;
	String genre;
	String source;
	String tapeNumber;
	String rating;
	String userRating;
	String comments;
	
	public Movie(String title, String director, String year, String genre, String rating,
			String source, String tapeNumber) {
		
		this.title = title;
		this.director = director;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
		this.source = source;
		this.tapeNumber = tapeNumber;
		this.userRating = "10";
		this.comments = "GOOD";
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
	    return "------------------------------------" +
	           "\n       Movie Details" +
	           "\n------------------------------------" +
	           "\nTitle         :" + title +
	           "\nDirector      :" + director +
	           "\nYear          :" + year +
	           "\nGenre         :" + genre +
	           "\nSource        :" + source +
	           "\nTape Number   :" + tapeNumber +
	           "\nRating        :" + rating +
	           "\nUser Rating   :" + userRating +
	           "\nComments      :" + comments +
	           "\n------------------------------------";
	}

	
	

}

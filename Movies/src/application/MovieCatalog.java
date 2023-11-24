package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieCatalog extends Application {

  Stage window;
  Scene mainScene, addScene, deleteScene, updateScene, sortScene;
  public static MovieCatalogList movies;
  

  public static void main(String[] args) {
	movies = new MovieCatalogList();  	
	
	addInitialMovies();
	
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;

    /*
    // Create buttons
    Button addButton = new Button("Add Movie");
    Button deleteButton = new Button("Delete Movie");
    Button updateButton = new Button("Update Movie");
    Button sortButton = new Button("Sort Movies");

    // Set actions on button click
    
    addButton.setOnAction(e -> window.setScene(addScene));
    deleteButton.setOnAction(e -> window.setScene(deleteScene)); 
    updateButton.setOnAction(e -> window.setScene(updateScene));
    sortButton.setOnAction(e -> window.setScene(sortScene));
	*/
    
    // Layout
    //VBox layout = new VBox(10);
    Parent layout = FXMLLoader.load(getClass().getResource("MovieCatalogMain.fxml"));
    //layout.getChildren().addAll(addButton, deleteButton, updateButton, sortButton);
    
    // Main scene
    mainScene = new Scene(layout, 700, 550);
    window.setScene(mainScene);
    window.setTitle("Home");
    window.show();
    // Other scenes would be created here
  }
  
  public static void addInitialMovies() {
	  Movie movie1 = new Movie("Inception", "Christopher Nolan", "2010", "Sci-Fi", "PG-13", "Blu-ray", "B001");
	  Movie movie2 = new Movie("Titanic", "James Cameron", "1997", "Drama", "PG-13", "DVD", "B002");
	  Movie movie3 = new Movie("The Shawshank Redemption", "Frank Darabont", "1994", "Drama", "R", "Digital", "B003");
	  Movie movie4 = new Movie("Oppenheimer", "Christopher Nolan", "2010", "Sci-Fi", "PG-13", "Streaming", "B004");
	  Movie movie5 = new Movie("The Godfather", "Francis Ford Coppola", "1972", "Crime", "R", "VHS", "B005");
	  Movie movie6 = new Movie("Avatar", "James Cameron", "1997", "Drama", "PG-13", "Blu-ray", "B006");
	  Movie movie7 = new Movie("Thor Love and Thunder", "Frank Darabont", "1994", "Drama", "R", "DVD", "B007");
	  Movie movie8 = new Movie("The Dark Knight", "Christopher Nolan", "2008", "Action", "PG-13", "Streaming", "B008");
	  Movie movie9 = new Movie("Forrest Gump", "Robert Zemeckis", "1994", "Drama", "PG-13", "Blu-ray", "B009");
	  Movie movie10 = new Movie("Pulp Fiction", "Quentin Tarantino", "1994", "Crime", "R", "VHS", "B010");
	  Movie movie11 = new Movie("Interstellar", "Christopher Nolan", "2008", "Action", "PG-13", "DVD", "B011");
	  Movie movie12 = new Movie("Doctor Strange", "Lana Wachowski", "1999", "Sci-Fi", "R", "Streaming", "B012");
	  Movie movie13 = new Movie("Harry Potter", "Robert Zemeckis", "1994", "Drama", "PG-13", "Digital", "B013");
	  Movie movie14 = new Movie("The Marvels", "Quentin Tarantino", "1994", "Crime", "R", "Blu-ray", "B014");
	  Movie movie15 = new Movie("The Matrix", "Lana Wachowski", "1999", "Sci-Fi", "R", "DVD", "B015");


	  movies.addMovie(movie1);
	  movies.addMovie(movie2);
	  movies.addMovie(movie3);
	  movies.addMovie(movie4);
	  movies.addMovie(movie5);
	  movies.addMovie(movie6);
	  movies.addMovie(movie7);
	  movies.addMovie(movie8);
	  movies.addMovie(movie9);
	  movies.addMovie(movie10);
	  movies.addMovie(movie11);
	  movies.addMovie(movie12);
	  movies.addMovie(movie13);
	  movies.addMovie(movie14);
	  movies.addMovie(movie15);

  }
}
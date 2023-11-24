package searchMovie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import application.MovieCatalog;

public class SearchMovieController {

    @FXML
    private ComboBox<String> optionsComboBox;

    @FXML
    private ComboBox<String> categoryBox;

    @FXML
    private ComboBox<String> movieBox;

    @FXML
    private TextArea displayTextField;

    String selectedOption;
    String selectedOptionCategory;

    @FXML
    private void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("GENRE", "RATING", "DIRECTOR", "YEAR");
        optionsComboBox.setItems(options);
        
        setCategory();
    }

    @FXML
    private void setCategory() {
        selectedOption = optionsComboBox.getValue();
        //System.out.println("HERE" + selectedOption);
        if (selectedOption != null && selectedOption.equalsIgnoreCase("genre")) {
        	//System.out.println("GOT IN");
            ObservableList<String> Options = FXCollections.observableArrayList(MovieCatalog.movies.getGenreNames());
            //System.out.println(MovieCatalog.movies.getGenreNames().toString());
            categoryBox.setItems(Options);
        }
        else if (selectedOption != null && selectedOption.equalsIgnoreCase("rating")) {
        	ObservableList<String> Options = FXCollections.observableArrayList(MovieCatalog.movies.getRatingNames());
            categoryBox.setItems(Options);
        }
        else if (selectedOption != null && selectedOption.equalsIgnoreCase("director")) {
        	ObservableList<String> Options = FXCollections.observableArrayList(MovieCatalog.movies.getDirectorNames());
            categoryBox.setItems(Options);
        }
        else if (selectedOption != null && selectedOption.equalsIgnoreCase("year")) {
        	ObservableList<String> Options = FXCollections.observableArrayList(MovieCatalog.movies.getYears());
            categoryBox.setItems(Options);
        }
        
        setMovies();
    }

    @FXML
    private void setMovies() {
        selectedOptionCategory = categoryBox.getValue();

        if (selectedOptionCategory != null && selectedOption.equalsIgnoreCase("genre")) {
            ObservableList<String> movieOptions = FXCollections.observableArrayList(MovieCatalog.movies.searchByCategory(selectedOptionCategory));
            movieBox.setItems(movieOptions);

            String selectedMovie = movieBox.getValue();
            displaySelectedMovie(selectedMovie);
        }
        else if (selectedOptionCategory != null && selectedOption.equalsIgnoreCase("rating")) {
            ObservableList<String> movieOptions = FXCollections.observableArrayList(MovieCatalog.movies.searchByRating(selectedOptionCategory));
            movieBox.setItems(movieOptions);

            String selectedMovie = movieBox.getValue();
            displaySelectedMovie(selectedMovie);
        }
        else if (selectedOptionCategory != null && selectedOption.equalsIgnoreCase("director")) {
            ObservableList<String> movieOptions = FXCollections.observableArrayList(MovieCatalog.movies.searchByDirector(selectedOptionCategory));
            movieBox.setItems(movieOptions);

            String selectedMovie = movieBox.getValue();
            displaySelectedMovie(selectedMovie);
        }
        else if (selectedOptionCategory != null && selectedOption.equalsIgnoreCase("year")) {
            ObservableList<String> movieOptions = FXCollections.observableArrayList(MovieCatalog.movies.searchByYear(selectedOptionCategory));
            movieBox.setItems(movieOptions);

            String selectedMovie = movieBox.getValue();
            displaySelectedMovie(selectedMovie);
        }
    }

    private void displaySelectedMovie(String selectedMovie) {
        if (selectedMovie != null) {
            String movieInformation = MovieCatalog.movies.getMovieDetail(selectedMovie);
            displayTextField.setText(movieInformation);
            displayTextField.setDisable(true);
        }
    }
    
    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
    	// Load the FXML file for the first scene
        Parent root = FXMLLoader.load(getClass().getResource("/application/MovieCatalogMain.fxml"));
        Scene scene = new Scene(root);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("HOME");

    }

}

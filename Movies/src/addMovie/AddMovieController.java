package addMovie;

import java.io.IOException;

import application.Movie;
import application.MovieCatalog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMovieController {
	
	@FXML
    private Button backButton;

    @FXML
    private TextField movieNameField;

    @FXML
    private TextField directorNameField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField sourceField;

    @FXML
    private TextField tapeNumberField;

    @FXML
    private TextField ratingField;

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

    @FXML
    private void handleSubmitButton(ActionEvent event) {
        // Handle submit button click here
        String movieName = movieNameField.getText();
        String directorName = directorNameField.getText();
        String genre = genreField.getText();
        String year = yearField.getText();
        String source = sourceField.getText();
        String tapeNumber = tapeNumberField.getText();
        String rating = ratingField.getText();
        
        Movie movie = new Movie(movieName, directorName, year, genre, rating, source, tapeNumber);
        MovieCatalog.movies.addMovie(movie);
        //System.out.println("Movie added!\n"+MovieCatalog.movies.toString());
        // Do something with the entered data (e.g., print it)
        clear();
    }
    
    @FXML
    private void clear() {
    	movieNameField.clear();
    	directorNameField.clear();
    	genreField.clear();
    	yearField.clear();
    	sourceField.clear();
    	tapeNumberField.clear();
    	ratingField.clear();
    }

	
}

package giveRating;

import java.io.IOException;
import java.util.ArrayList;

import application.Movie;
import application.MovieCatalog;
import application.MovieCatalogList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class GiveRatingController {

    @FXML
    private ComboBox<String> selectMovieComboBox;

    @FXML
    private TilePane ratingsTilePane;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private Label topMoviesLabel;

    @FXML
    private TextArea yourTopMoviesTextArea;

    @FXML
    private Button backButton;

    @FXML
    private Button closeButton;

    private MovieCatalogList movies = MovieCatalog.movies; // Assuming you have a Movie class

    @FXML
    private void initialize() {
        // Initialize ComboBox with movie names
        ArrayList<String> movieNames = movies.getMovieNames(); // Your list of movie names
        selectMovieComboBox.getItems().addAll(movieNames);

        // Initialize ratings checkboxes
        initRatingsCheckBoxes();
        updateTopMoviesTextArea();
        
    }

    private void initRatingsCheckBoxes() {
    	ratingsTilePane.getChildren().clear();
        for (int i = 1; i <= 5; i++) {
            CheckBox checkBox = new CheckBox(Integer.toString(i));
            checkBox.setOnAction(event -> handleRatingCheckBox(checkBox));
            ratingsTilePane.getChildren().add(checkBox);
        }
    }

    private void handleRatingCheckBox(CheckBox selectedCheckBox) {
        // Unselect other checkboxes
        ratingsTilePane.getChildren().forEach(node -> {
            if (node instanceof CheckBox && node != selectedCheckBox) {
                ((CheckBox) node).setSelected(false);
            }
        });
    }

    @FXML
    private void handleSubmitButton() {
        String selectedMovie = selectMovieComboBox.getValue();
        String selectedRating = getSelectedRating();
        String comments = commentsTextArea.getText();

        // Perform actions with the selected movie, rating, and comments
        // You can create a Movie object and add it to your movies list

        // For example:
        movies.getMovie(selectedMovie).setUserRating(selectedRating);
        movies.getMovie(selectedMovie).setComments(comments);
        commentsTextArea.clear();
        // Update the display or perform any other necessary actions
        updateTopMoviesTextArea();
    }

    private String getSelectedRating() {
        for (Node node : ratingsTilePane.getChildren()) {
            if (node instanceof CheckBox && ((CheckBox) node).isSelected()) {
                return ((CheckBox) node).getText();
            }
        }
        return null;
    }
    
    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
    	// Load the FXML file for the first scene
        Parent root = FXMLLoader.load(getClass().getResource("/application/MovieCatalogMain.fxml"));
        Scene scene = new Scene(root,700,450);
        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("HOME");
    }
    
    
    private void updateTopMoviesTextArea() {
        
        String topMoviesText = "";
        ArrayList<Movie> sortedMovies = movies.sortByUserRating();
        for (Movie movie : sortedMovies) {
        	if (movies.getMovie(movie.title).getUserRating() != "0") {
        		topMoviesText += movie.title + "\n";
        	}
        }
        
        //topMoviesText += movies.getMovieNames();
        yourTopMoviesTextArea.setText(topMoviesText);
    }
    
    
}

package deleteMovie;

import java.io.IOException;

import application.MovieCatalog;
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

public class DeleteMovieController {
	
	@FXML
	private ComboBox<String> movieBox;
	
	 @FXML
	private TextArea displayTextField;
	
	@FXML
	private void initialize() {
		ObservableList<String> movieOptions = FXCollections.observableArrayList(MovieCatalog.movies.getMovieNames());
		movieBox.setItems(movieOptions);	
		
		String selectedMovie = movieBox.getValue();
		displaySelectMovie(selectedMovie);
	}
	
	private void displaySelectMovie(String selectedMovie) {
		String movieInformation = MovieCatalog.movies.getMovieDetail(selectedMovie);
	    displayTextField.setText(movieInformation);
	    displayTextField.setDisable(true);
	}
	
	@FXML
	private void handleMovieSelection() {
	    String selectedMovie = movieBox.getValue();
	    
	    MovieCatalog.movies.dropMovie(selectedMovie);
	    System.out.println(MovieCatalog.movies.toString());
	    
	    //movieBox.setValue("Choose Movie");
	    initialize();
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

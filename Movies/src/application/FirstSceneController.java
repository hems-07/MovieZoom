package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstSceneController {

    @FXML
    private void handleNextSceneButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/addMovie/AddMovies.fxml"));
        Scene scene = new Scene(root);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ADD MOVIE");
        
    }
    
    @FXML
    private void handleDeleteButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/deleteMovie/DeleteMovies.fxml"));
        Scene scene = new Scene(root);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DELETE MOVIE");
        
    }
    
    @FXML
    private void handleSearchButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/searchMovie/SelectMovies.fxml"));
        Scene scene = new Scene(root);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("SEARCH MOVIE");
        
    }
    
    @FXML
    private void handleBackButton(ActionEvent event) throws Exception {
        // Load the FXML file for the first scene
        Parent root = FXMLLoader.load(getClass().getResource("MovieCatalogMain.fxml"));
        Scene scene = new Scene(root);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("HOME");
    }
}

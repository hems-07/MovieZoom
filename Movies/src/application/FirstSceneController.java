package application;

import javafx.application.Platform;
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
        Scene scene = new Scene(root, 700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ADD MOVIE");
        
    }
    
    @FXML
    private void handleDeleteButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/deleteMovie/DeleteMovies.fxml"));
        Scene scene = new Scene(root,700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DELETE MOVIE");
        
    }
    
    @FXML
    private void handleSearchButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/searchMovie/SelectMovies.fxml"));
        Scene scene = new Scene(root,700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("SEARCH MOVIE");
        
    }
    
    @FXML
    private void handleRatingButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/giveRating/GiveRatings.fxml"));
        Scene scene = new Scene(root,700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("RATE MOVIES");
        
    }
    
    @FXML
    private void handleUpdateButton(ActionEvent event) throws Exception {
        // Load the FXML file for the second scene
        Parent root = FXMLLoader.load(getClass().getResource("/updateMovie/UpdateMovies.fxml"));
        Scene scene = new Scene(root,700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("UPDATE MOVIE");
        
    }
    
    @FXML
    private void handleBackButton(ActionEvent event) throws Exception {
        // Load the FXML file for the first scene
        Parent root = FXMLLoader.load(getClass().getResource("MovieCatalogMain.fxml"));
        Scene scene = new Scene(root ,700,450);

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("HOME");
    }
    
    @FXML
    private void handleExitButton() {
        // You can perform any cleanup or additional actions before closing the application

        // Close the application
        Platform.exit();
    }
}

package app;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class mdmController {
    private Stage stage;

    @FXML
    private Button mdmsumbit;
    @FXML
    Label mdmmsg;

    @FXML
    public void  onmdmclick(){
        mdmmsg.setText("details sumbitted.");


    }

    @FXML
    private Button mdmback;
    @FXML
    public void mdmbackclick() throws IOException {
        stage = (Stage) mdmback.getScene().getWindow();
        AnchorPane root;
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Home");

        stage.setScene(scene);
    }
}
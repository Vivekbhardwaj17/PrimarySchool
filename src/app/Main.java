package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 1500, 700));
        primaryStage.show();

//        Parent root1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
//        primaryStage.setTitle("HelloHome");
//        primaryStage.setScene(new Scene(root1, 300, 275));
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

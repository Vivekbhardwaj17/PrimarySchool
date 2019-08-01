package app;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
      private String pass;
      @FXML
      private Label errmsg;
    @FXML
    public void onLogin() throws SQLException,ClassNotFoundException, IOException,Exception {
          errmsg.setVisible(false);
        Connection con=MySql.con;
        PreparedStatement st=con.prepareStatement("select * from login where username=?");
        st.setString(1,userName.getText());
       ResultSet rs= st.executeQuery();
       while (rs.next()) {
            pass = rs.getString(2);
           System.out.println(pass);
       }
        if (password.getText().equals(pass) ){

            stage = (Stage) login.getScene().getWindow();
            AnchorPane root;
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Menu");

            stage.setScene(scene);
        } else {
            System.out.println("Wrong username or password");
            errmsg.setText("Wrong username or password");
            errmsg.setVisible(true);
            password.setText("");
        }


    }
    @FXML
    Button nwuser;
    @FXML
    Label addmsg;
    @FXML
    public void savenwUser(){

        try {
            Connection con=MySql.con;
            PreparedStatement st1=con.prepareStatement("insert into login values (?,?)");
            st1.setString(1,userName.getText());
            System.out.println(userName.getText());
            st1.setString(2,password.getText());
            System.out.println(password.getText());

            st1.executeUpdate();
            addmsg.setText("New user added.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
@FXML
private Button mdmbtn;
    @FXML
    public void onmdm() throws IOException {
        stage = (Stage) mdmbtn.getScene().getWindow();
        AnchorPane root;
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("mdm.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Home");

        stage.setScene(scene);
    }
@FXML
private DatePicker date;
   private LocalDate localDate1;
    @FXML
    private ChoiceBox choicebox;
    @FXML
    public void ondatepicker(){
        localDate1=date.getValue();
        int weekday = localDate1.getDayOfWeek().getValue();
        if (weekday == 1)
           choicebox.setId("monday");
//        else if (weekday == 2)
//            nameField.setText("Tuesday");
//        else if (weekday == 3)
//            nameField.setText("wednesday");
//        else if (weekday == 4)
//            nameField.setText("thursday");
//        else if (weekday == 5)
//            nameField.setText("friday");
//        else if (weekday == 6)
//            nameField.setText("satday");
//        else if (weekday == 7)
//            nameField.setText("sunday");

    }


    @FXML
    private Button menuBack;

   @FXML
    public void onMenuBack() throws IOException {

       stage = (Stage) menuBack.getScene().getWindow();
       AnchorPane root;
       root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
       Scene scene = new Scene(root);
       stage.setTitle("Home");

       stage.setScene(scene);
    }
     @FXML
     private Button forgtPass;
     @FXML
     public void onforgtPass() throws IOException {

         stage = (Stage) forgtPass.getScene().getWindow();
         AnchorPane root;
         root = (AnchorPane) FXMLLoader.load(getClass().getResource("forgetPassword.fxml"));
         Scene scene = new Scene(root);
         stage.setTitle("Password");

         stage.setScene(scene);
     }



private ResultSet rs;
    public void onnewUser() throws SQLException, IOException {

        stage = (Stage) login.getScene().getWindow();
        AnchorPane root;
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("newUser.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New User");

        stage.setScene(scene);
        try {
            Connection con = MySql.con;
            PreparedStatement st1 = con.prepareStatement("insert into login values (?,?)");
            //st1.setString(1,tf1.getText());

            st1.setString(1, userName.getText());

            st1.setString(2, password.getText());


            rs = st1.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).matches(userName.getText())) {


                }
            }

        }catch (Exception e){}
    }
@FXML
  Button nwUsrBackButton;
    @FXML
    public void onnwUserBackButton() throws IOException {
        stage = (Stage) nwUsrBackButton.getScene().getWindow();
        AnchorPane root;
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
          stage.setTitle("Home");

        stage.setScene(scene);
    }
















    private Stage stage;
    @FXML
    private TextField nameField;
    //    @FXML
//    private ChoiceBox choiceBox;
//    @FXML
//    public void  onButtonClick()
//    {
//        System.out.println("submit all details."+nameField.getText());
//    }
    @FXML
    private DatePicker datePicker;
    String day = "";
    String input_date;
    LocalDate localDate;

    @FXML
    public void datepicker1() {

        localDate = datePicker.getValue();

        System.out.println("Thank you" + "MDM details of" + localDate + " is saved. ");
        input_date = localDate.toString();

        day = input_date.substring(8, 10);
        if (day.equals("01"))
            System.out.println("Monday");


    }


    @FXML
    public void textField() {
        int weekday = localDate.getDayOfWeek().getValue();
        if (weekday == 1)
            nameField.setText("Monday");
        else if (weekday == 2)
            nameField.setText("Tuesday");
        else if (weekday == 3)
            nameField.setText("wednesday");
        else if (weekday == 4)
            nameField.setText("thursday");
        else if (weekday == 5)
            nameField.setText("friday");
        else if (weekday == 6)
            nameField.setText("satday");
        else if (weekday == 7)
            nameField.setText("sunday");

    }

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    public void onChoicebox() {
        String monday = "aalo sabji";

        int weekday = localDate.getDayOfWeek().getValue();

        //  choiceBox.setValue("roti sabji ");

        // System.out.println("You selected"+choiceBox.isPressed());
    }

    @FXML
    private Button button;

    @FXML
    private void clickbutton() throws IOException {
        stage = (Stage) button.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("mdm.fxml"));
        Scene scene = new Scene(root);
       // stage.setTitle("new window");

        stage.setScene(scene);

        System.out.println("Login.fxml opened");
    }

//

//    public void  clickbutton() throws SQLException, ClassNotFoundException, IOException {
//
//
//
//        Connection con=MySql.con;
//        PreparedStatement st1=con.prepareStatement("insert into MDM values (?)");
//        //st1.setString(1,tf1.getText());
//        st1.setString(1,String.valueOf(localDate.getDayOfWeek().getValue()));
//        st1.executeUpdate();
//
//
//
//
//
//    }
}






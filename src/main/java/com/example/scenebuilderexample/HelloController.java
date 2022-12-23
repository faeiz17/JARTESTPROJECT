package com.example.scenebuilderexample;
import java.awt.*;
import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javax.print.attribute.standard.Media;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


import static javafx.scene.paint.Color.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    public HelloController() throws IOException {
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    File file1 = new File("C:\\Users\\UltraBook\\Desktop\\Need Fir Soeed Leaked\\userinfo.txt");
    FileWriter fwriter = new FileWriter(file1, true);
    File file2 = new File("C:\\Users\\UltraBook\\IdeaProjects\\scenebuilderexample\\src\\main\\resources\\com\\example\\scenebuilderexample\\frgt.txt");
    FileWriter fwriter2 = new FileWriter(file2, true);

    Label message = new Label();
    private Stage stage;
    private Scene scene;
    private Parent root;

    public TextField username;
    public TextField password;


    public static void showAlert(Alert.AlertType alertType, String title, String message, Color rgb) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }


    public TextField signusername;

    public TextField signpassword;
    public TextField signemail;
    public TextField signcnfrmpassword;
    public TextField forgetpf;


    public void signup(ActionEvent event) throws IOException {


        fwriter.write(signemail.getText() + "\t" + signpassword.getText() + "\n");

        fwriter.close();
        fwriter2.write(signusername.getText() + "\t" + forgetpf.getText() + "\n");

        fwriter2.close();

    }

    public void loginchecker(ActionEvent event) throws IOException, InterruptedException {

        boolean matched = false;
        String uname = username.getText().toString();
        System.out.println(uname);

        String pwd = password.getText().toString();
        System.out.println(pwd);

        FileReader fr = new FileReader(file1);
        BufferedReader br = new BufferedReader(fr);
        String line = null;

        while ((line = br.readLine()) != null) {


            if (line.equals(uname + "\t" + pwd)) {
//                System.out.println(line);
                matched = true;

                break;

            }
        }
        fr.close();
        br.close();

        if (matched==true) {


            Parent root = FXMLLoader.load(getClass().getResource("sceneloading.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if ( username.getText().isEmpty() || password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the required fields", rgb(255, 0, 0));

        } if(matched==false) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Incorrect Password", rgb(255, 0, 0));

        }
    }
    public void frgtchecker(ActionEvent event) throws IOException, InterruptedException {

        boolean matched = false;
        String uname = username.getText().toString();
//        myLabel.setText(username.getText().toString());

        String frgtpf = forgetpf.getText().toString();

        FileReader fr = new FileReader(file2);
        BufferedReader br = new BufferedReader(fr);
        String line = null;


        while ((line = br.readLine()) != null) {
//br.skip(7);
            System.out.println(line);

            System.out.println(line);

            if (line.equals(uname + "\t" + frgtpf)) {
                System.out.println(line);
                matched = true;

                break;

            }
        }
        fr.close();
        br.close();

        if (username.getText().isEmpty() || forgetpf.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the required fields", rgb(255, 0, 0));
        }
        if (matched) {


            Parent root = FXMLLoader.load(getClass().getResource("sceneloading.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if ((matched == false) || username.getText().isEmpty() || forgetpf.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the required fields", rgb(255, 0, 0));
            switchToScene2(event);
        } else {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Incorrect Password", rgb(255, 0, 0));

        }
    }
    public TextField bookingsemail;

    public TextField getBookingsemail() {
        return bookingsemail;
    }

    public void setBookingsemail(TextField bookingsemail) {
        this.bookingsemail = username;
    }

    public void switchToScene3(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    public void switchToscenebugatti(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("scenebugatti.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }


    public void switchToScene4(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene5(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToscenepagani(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("scenepagani.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneSU(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("SceneSU.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToscenesuv(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("scenesuv.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTotusconscene(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("tusconscene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToscenebookings(ActionEvent event) throws IOException, InterruptedException {


        root = FXMLLoader.load(getClass().getResource("scenebookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void switchTomerciscene(ActionEvent event) throws IOException, InterruptedException {

        root = FXMLLoader.load(getClass().getResource("merciscene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public Rectangle rectangle;

    public void openLink(ActionEvent event) throws URISyntaxException, InterruptedException, IOException {

        Desktop.getDesktop().browse(new URI("https://www.youtube.com/"));
    }
//javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle();

//    {
//
//        Rectangle rect = new Rectangle (100, 40, 100, 100);
//    FadeTransition ft = new FadeTransition(Duration.millis(3000), rect);
//        ft.setFromValue(1.0);
//        ft.setToValue(0.3);
//        ft.setCycleCount(4);
//        ft.setAutoReverse(true);
//
//        ft.play();}

    public void switchToscenecomingsoon(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("scenecomingsoon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchTosceneferrari(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("sceneferrari.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToscenesedan(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("scenesedan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToscenecivic(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("scenecivic.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToscenecorolla(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("scenecrolla.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchTosceneaboutus(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("sceneaboutus.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchTothankyou(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("thankyou.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchTosceneforget(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("sceneforget.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchTosceneloading(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("sceneloading.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public ImageView myImageView;
    public ImageView myImageViewmain;


    Image myImage1 = new Image(getClass().getResourceAsStream("super car.jpg"));
    Image myImagesuv = new Image(getClass().getResourceAsStream("SUVCHANGE.jpg"));
    Image myImagesedan = new Image(getClass().getResourceAsStream("sedanchange.jpg"));
    Image myImagetesla = new Image(getClass().getResourceAsStream("teslalog.jpg"));
    Image myImageabtus = new Image(getClass().getResourceAsStream("peakpx.jpg"));
    Image myImagepagani = new Image(getClass().getResourceAsStream("paganichange.jpg"));
    Image myImageferrari = new Image(getClass().getResourceAsStream("ferrarichange.jpg"));
    Image myImagebugatti = new Image(getClass().getResourceAsStream("bugattichange.jpg"));
    Image myImagetucson = new Image(getClass().getResourceAsStream("tucsonchange.jpg"));
    Image myImageamg = new Image(getClass().getResourceAsStream("amgchange.jpg"));
    Image myImagecivic = new Image(getClass().getResourceAsStream("civicchange.jpg"));
    Image myImagecorola = new Image(getClass().getResourceAsStream("corolachange.jpg"));
    Image myImagemain = new Image(getClass().getResourceAsStream("main.jpg"));
    Image myImage2 = new Image(getClass().getResourceAsStream("bugattifirstpage.jpg"));


    public void change(MouseEvent MOUSE_ENTERED) {

        myImageView.setImage(myImage1);
        myImageView.setFitHeight(700);
        myImageView.setFitWidth(1200);

    }
    public void changesuv(MouseEvent MOUSE_ENTERED) {

        myImageView.setImage(myImagesuv);

    }
    public void changesedan(MouseEvent MOUSE_ENTERED) {

        myImageView.setImage(myImagesedan);

    }
    public void changeabtus(MouseEvent MOUSE_ENTERED) {

        myImageView.setImage(myImageabtus);

    }
    public void changepaggani(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImagepagani);

    }
    public void changeferrari(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImageferrari);

    }
    public void changebugatti(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImagebugatti);

    }
    public void changetucson(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImagetucson);

    }
    public void changeamg(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImageamg);

    }
    public void changecivc(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImagecivic);

    }
    public void changecorola(MouseEvent MOUSE_ENTERED) {

        myImageViewmain.setImage(myImagecorola);

    }
    public void changetesla(MouseEvent MOUSE_ENTERED) {

        myImageView.setImage(myImagetesla);
        myImageView.setX(450);

    }

    public void change2(MouseEvent MOUSE_EXITED) {


        myImageView.setImage(myImage2);
        myImageView.setX(0);
    }
    public void changemain(MouseEvent MOUSE_EXITED) {


        myImageViewmain.setImage(myImagemain);
        myImageViewmain.setX(0);
    }



public Label myLabel;
    public ChoiceBox choiceBox;
    public ChoiceBox choiceBox2;
    public ChoiceBox choiceBox3;


    public void initialize2(MouseEvent MOUSE_ENTERED) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("PAGANI", "FERRARI", "BUGATTI","TUCSON","MERCEDES","CIVIC","COROLLA");

        choiceBox.setItems(list);
        choiceBox.setOnAction(this::getCar);


    }
    public void initialize3(MouseEvent MOUSE_ENTERED) {
        ObservableList<String> list2 = FXCollections.observableArrayList();
        list2.addAll("What’s your favorite sport?", "Who is the person you admire?", "What is the name of your favorite book?","What is your favorite movie?","What is your favorite movie/TV personality?","What is your favorite song?","What is the name of your pet?");

        choiceBox2.setItems(list2);

    }
    public void initialize4(MouseEvent MOUSE_ENTERED) {
        ObservableList<String> list3 = FXCollections.observableArrayList();
        list3.addAll("What’s your favorite sport?", "Who is the person you admire?", "What is the name of your favorite book?","What is your favorite movie?","What is your favorite movie/TV personality?","What is your favorite song?","What is the name of your pet?");

        choiceBox3.setItems(list3);

    }

    private void getCar(javafx.event.Event event) {
        String myCar = choiceBox.getValue().toString();
        if (myCar=="PAGANI"){
        myLabel.setText("US$2,400,000");
    }else if (myCar =="FERRARI"){

            myLabel.setText("US$322,986.");
        }
        else if (myCar =="BUGATTI"){


            myLabel.setText("US$3,300,000");
        }
        else if (myCar =="TUCSON"){

            myLabel.setText("US$25,350");
        }
        else if (myCar =="MERCEDES"){

            myLabel.setText("US$61,750");
        }
        else if (myCar =="CIVIC"){
            myLabel.setText("US$27,921");
        }

        else if (myCar =="COROLLA"){
            myLabel.setText("US$21,550");
        }}}

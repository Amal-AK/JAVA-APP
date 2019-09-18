package sample.view;
import javafx.fxml.Initializable;
import sample.model.*;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.*;
import javafx.stage.*;
import java.lang.Object ;
import static javafx.fxml.FXMLLoader.load;

public class Controller  {
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwd;
    @FXML
    private Label message;




    public void colorinput1() {
        username.setStyle("-fx-text-inner-color: white;-fx-border-width : 0 0 2 0 ; -fx-background-color :transparent ;-fx-border-color:white") ;}

    public void colorinput2() {
        passwd.setStyle("-fx-text-inner-color: white;-fx-border-width : 0 0 2 0 ; -fx-background-color :transparent ;-fx-border-color:white")  ;}

    @FXML
    public void login(javafx.event.ActionEvent actionEvent) throws IOException {

        try {
            if(Main.trainner.checkLogin(username.getText())) {
                try {
                    if(Main.trainner.checkPass(passwd.getText())){
                        Parent root = load(getClass().getResource("../view/compte.fxml"));
                        Stage primaryStage = new Stage();
                        primaryStage.setTitle("Génerer Quiz");
                        primaryStage.setScene(new Scene(root, 800, 500));
                        Main.stage.hide();
                        Main.stage = primaryStage ;
                        primaryStage.show();
                    }

                }catch (LoginException e){
                    String s=  "-fx-background-color: #FFCDD2;";
                    message.setStyle(s);
                    message.setText("Erreur ! veuillez vérifier votre mot de passe");
                }

            }
        }
        catch (LoginException e){
            String style = "-fx-background-color: #FFCDD2;";
            message.setStyle(style);
            message.setText("Erreur ! veuillez vérifier votre Email");
        }
    }


}

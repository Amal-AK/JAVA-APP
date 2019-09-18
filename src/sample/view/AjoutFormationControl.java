
package sample.view;
import javafx.scene.layout.Pane;
import sample.model.*;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.*;
import javafx.stage.*;
import static javafx.fxml.FXMLLoader.load;


public class AjoutFormationControl {
     @FXML
     private Pane divv ;
    @FXML
    private void initialize() {
       int y=10 ;
        String message = "Le nom de la formation : " + Main.trainner.getFormation().getNom();
        Label label = new Label() ;
        label.setText(message);
        label.setLayoutY(y) ;
        y=y+40 ;
        label.setLayoutX(10) ;
        String style = "-fx-font-size : 15px";
        label.setStyle(style);
        divv.getChildren().add(label) ;


         message = "La description de la formation : " + Main.trainner.getFormation().getDescription();
         label = new Label() ;
        label.setText(message);
        label.setLayoutY(y) ;
        y=y+40 ;
        label.setLayoutX(10) ;
        style = "-fx-font-size : 15px";
        label.setStyle(style);
        divv.getChildren().add(label) ;




    }
    public void creerFormation() throws IOException {
        Parent root = load(getClass().getResource("../view/creerFormation.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Creer une formation");
        primaryStage.setScene(new Scene(root, 800, 500));
        Main.stage.hide();
        primaryStage.show();
        Main.stage = primaryStage ;


    }

    public void genererQuiz() throws IOException{
        Parent root = load(getClass().getResource("../view/compte.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Creer une formation");
        primaryStage.setScene(new Scene(root, 800, 500));
        Main.stage.hide();
        primaryStage.show();
        Main.stage = primaryStage ;
    }


}

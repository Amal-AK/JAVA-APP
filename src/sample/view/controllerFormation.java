package sample.view;
import javafx.scene.control.Label;
import sample.model.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import static javafx.fxml.FXMLLoader.load;

public class controllerFormation {



    public void genererQuiz() throws IOException{
        Parent root = load(getClass().getResource("../view/compte.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Creer une formation");
        primaryStage.setScene(new Scene(root, 800, 500));
        Main.stage.hide();
        primaryStage.show();
        Main.stage = primaryStage ;
    }

    @FXML
    private DatePicker ddFormation ;
    @FXML
    private DatePicker dfFormation ;
    @FXML
    private TextField nomFormation ;
    @FXML
    private TextArea description  ;
    @FXML
    private Label erreur;

    @FXML

    public void AjoutFormation() throws infoException , IOException , dateException {

       try {

           Main.trainner.creerFormation(nomFormation.getText(),description.getText(),ddFormation.toString(),dfFormation.toString()) ;
           Parent root = load(getClass().getResource("../view/formation.fxml"));
           Stage primaryStage = new Stage();
           primaryStage.setTitle("Formation");
           primaryStage.setScene(new Scene(root, 800, 500));
           Main.stage.hide();
           primaryStage.show();
           Main.stage = primaryStage ;
       }
       catch (dateException e) {
           String style = "-fx-background-color: #FFCDD2;";
           erreur.setStyle(style);
           erreur.setText("Les dates ne sont pas valides ! ");
       }
       
       catch (infoException e) {
           String style = "-fx-background-color: #FFCDD2;";
           erreur.setStyle(style);
           erreur.setText("Erreur ! veuillez remplir touts les champs ");

       }

    }



}

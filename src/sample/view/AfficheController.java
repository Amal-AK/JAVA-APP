package sample.view;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sample.model.Main;
import java.io.IOException;
import static javafx.fxml.FXMLLoader.load;


public class AfficheController {



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


    public AfficheController() {

    }
    @FXML
    private Pane div ;
    @FXML
    private void initialize() {
        String message=" " ;
        int y=0 ;
        for(int i=0 ; i< Main.trainner.lastQuiz().getQst().size() ; i++) {
            message = " - "+(Main.trainner.lastQuiz().getQst().get(i).getEnonce()) ;
            Label label = new Label() ;
            label.setText(message);
            label.setLayoutY(y) ;
            y=y+20 ;
            String style = "-fx-font-size : 16px";
            label.setStyle(style);
            div.getChildren().add(label) ;
            if(Main.trainner.lastQuiz().getQst().get(i).getClass().getName()=="sample.model.Qcm") {

                Qcm qst = (Qcm)  Main.trainner.lastQuiz().getQst().get(i) ;
                for(int k=0 ; k< qst.getProp().size() ; k++ ) {

                    message = (k+1)+" ) "+qst.getProp().get(k) ;
                    label = new Label() ;
                    label.setText(message);
                    label.setLayoutY(y) ;
                    y=y+20 ;
                    label.setLayoutX(40) ;
                    style = "-fx-font-size : 15px";
                    label.setStyle(style);
                    div.getChildren().add(label) ;
                }

            }


            if(Main.trainner.lastQuiz().getQst().get(i).getClass().getName()=="sample.model.Qcu") {

                Qcu qst = (Qcu)  Main.trainner.lastQuiz().getQst().get(i) ;
                for(int k=0 ; k< qst.getProp().size() ; k++ ) {

                    message = (k+1)+" ) "+qst.getProp().get(k) ;
                    label = new Label() ;
                    label.setText(message);
                    label.setLayoutY(y) ;
                    y=y+20 ;
                    label.setLayoutX(40) ;
                    style = "-fx-font-size : 15px";
                    label.setStyle(style);
                    div.getChildren().add(label) ;
                }

            }
        }


    }




}

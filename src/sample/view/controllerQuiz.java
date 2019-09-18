package sample.view;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.*;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.*;
import java.util.ArrayList;
import javafx.stage.Stage;
import static javafx.fxml.FXMLLoader.load;

public class controllerQuiz {
    @FXML
    private TextField nameQuiz;
    @FXML
    private DatePicker ddQuiz;
    @FXML
    private DatePicker dfQuiz;

    @FXML
    private CheckBox No1 ;
    @FXML
    private CheckBox No2 ;
    @FXML
    private CheckBox No3;


    @FXML
    private TextField qst1;
    @FXML
    private TextField qst2;
    @FXML
    private TextField qst3;
      @FXML
      private Label errNotion ;

    @FXML
    private Button creer ;

    public void generer() throws IOException , dateException , notionException{

        try {
            if(ddQuiz.getValue()==null || dfQuiz.getValue()==null) throw new dateException() ;
            Quiz quiz = new Quiz(nameQuiz.getText(), ddQuiz.getValue().toString() ,dfQuiz.getValue().toString()) ;

            ArrayList<Integer>  Nb =  new ArrayList<>() ;
            ArrayList<Notion> notion = new ArrayList() ;
            if(Main.trainner.getFormation().getNotions().size()==0) throw new notionException() ;
            if(No1.isSelected()) {
                notion.add( Main.trainner.getFormation().getNotions().get(0));
                Nb.add( Integer.parseInt(qst1.getText())) ;
            }
            if(No2.isSelected()) {
                notion.add( Main.trainner.getFormation().getNotions().get(1));
                Nb.add( Integer.parseInt(qst2.getText())) ;
            }
            if(No3.isSelected()) {
                notion.add( Main.trainner.getFormation().getNotions().get(2));
                Nb.add( Integer.parseInt(qst3.getText())) ;
            }
            if(notion.size()==0) {
                String style = "-fx-background-color: #FFCDD2;";
                errNotion.setStyle(style);
                errNotion.setText("Veuillez ajouter au moins une notion ! ");

            }else
            {
                Main.trainner.genererQuiz( quiz, notion, Nb);
                Parent root = load(getClass().getResource("../view/quiz.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Afficher Quiz");
                primaryStage.setScene(new Scene(root, 800, 500));
                Main.stage.hide();
                primaryStage.show();
                Main.stage = primaryStage;


            }

        }catch (dateException e) {
            String style = "-fx-background-color: #FFCDD2;";
            errNotion.setStyle(style);
            errNotion.setText("Les dates ne sont pas valides ! ");
        }
        catch (infoException e){
            String style = "-fx-background-color: #FFCDD2;";
            errNotion.setStyle(style);
            errNotion.setText("veuillez compléter les champs ! ");
        }
        catch (notionException e){
            String style = "-fx-background-color: #FFCDD2;";
            errNotion.setStyle(style);
            errNotion.setText("La formation actuelle ne contient aucune question ! ");
        }


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






}

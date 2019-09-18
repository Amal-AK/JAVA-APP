package sample.model;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {
        static public Formateur trainner;
        static public Stage stage  ;
        @Override
        public void start(Stage primaryStage) throws Exception{
        Parent root = load(getClass().getResource("../view/login.fxml"));
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

        Main.stage =  primaryStage ;

    }


        public static void main(String[] args) {

        Quiz quiz = new Quiz()  ;
        ///////////////////////////////////cr�ation d'un formateur //////////////////////////////////

        System.out.println("************************************** Creer un compte formateur ***********************************" );
        Formateur formateur= new Formateur("ha_akli@esi.dz" , "12345678") ;
        formateur.afficherFormateur();


        //////////////////////////////////////// creer une formation //////////////////////////////////////////////

        System.out.println ("\n\n*********************** Creation d'un formation et affichage de ses details **************************** ")  ;
       try {
           formateur.creerFormation("Formation en programmation c", "C'est une formation qui nous permet de developper nos competences de programmation ", "2019-10-01", "2019-11-01");

        formateur.getFormation( ).afficherFormation();
       }

       catch (infoException e ) {
            System.out.println("Erreur des infos de le formation ");
       }
       catch (dateException e) {
        System.out.println("Erreur des dates ");
       }


        System.out.println("\n**************************************** Creation et Ajout des notions ************************************") ;
        formateur.getFormation().ajouterNotion("Les variables ");
        formateur.getFormation().ajouterNotion("Les boucles");
        formateur.getFormation().ajouterNotion("Les tableaux");

        System.out.println("\n\t Voici la liste des notions de la formation actuelle") ;
        formateur.getFormation().afficherListeNotion();

        /////////////////////////////mise à jour du nom de la notion///////////////////////////////////////////////////


        System.out.println("\n\n\t\tMise à jour de nom de la notion  1 : ") ;
        formateur.getFormation().getNotions().get(0).miseAjour("Les types des variables ")  ;
        formateur.getFormation().afficherListeNotion();



        //////////////////////////////////////////////gestion des apprenants////////////////////////////////////////////////////

        System.out.println("\n*********************************Gestion des apprenants **************************************************\n\n Ajout des apprennats au groupe du formateur" );

        ///////////////////////////////////////////////////Ajout des apprenants///////////////////////////////////

        Apprenant apprenant1 =  formateur.ajouterCompte("Akli","Melissa","08/08/2000","Mezrara") ;
        Apprenant apprenant2 =  formateur.ajouterCompte("Moussaoui","Djamila","20/01/1999" , "Frikat") ;
        Apprenant apprenant3  =  formateur.ajouterCompte("Rabhi","Ouiza","08/08/1998","Draa El Mizane") ;

        /////////////////////////////parcourir le groupe du formateur //////////////////////////////////////////

        formateur.ListeApprenants();
        System.out.println("\n\n Suppression des apprenants:") ;
        formateur.supprimerCompte(apprenant2);

        /////////////////////////////parcourir la liste des apprenants //////////////////////////////////////////////


        formateur.ListeApprenants();
        //////////////////////////////////////Mise à jour des apprenants ///////////////////////////////////////

        System.out.println("\n\n Mise à jour des apprenants: \n Voici la liste des choix :") ;
        System.out.println("\n\n\t 1) Mise à jour de Nom \n\t 2) Mise à jour de Prï¿½nom \n\t 3) Mise à jour de l'adresse  ") ;
        System.out.println("\n\n Mise à jour de nom de l'apprenant:"+apprenant1.getNom()+" " +apprenant1.getPrenom()) ;

        /////////////////////////////////////////////modifier le nom ////////////////////////////////////////////
        formateur.modifierCompte(apprenant1, 1, "Hamani");
        apprenant1.afficherApprenant();
        System.out.println("\n\n Mise à jour de l'adresse de l'apprenant:"+apprenant3.getNom()+" " +apprenant1.getPrenom()) ;

        ///////////////////////////////////////////modifier l'adresse////////////////////////////////////////////
        formateur.modifierCompte(apprenant3, 3, "Tizi Ouzou");
        apprenant3.afficherApprenant();



        /////////////////////////////////////Ajout des questions //////////////////////////////////////////////////////////////////

        System.out.println("\n************************************* Ajout des question pour chaque notion ********************************") ;


        // question de type qcu
        ArrayList<String> RepQcu0 =  new ArrayList<String>(Arrays.asList("long")) ;
        ArrayList<String>  PropQcu0 = new ArrayList<String>(Arrays.asList("float" ,"int","long" )) ;
        Qcu qcu0= new Qcu(RepQcu0, "Quel est le type de variable qui occupe le plus grand espace ?" ,PropQcu0) ;
        formateur.getFormation().getNotions().get(0).ajouterQuestion(qcu0);


        // question ouverte
        ArrayList<String> RepQo0 =  new ArrayList<String>(Arrays.asList("non")) ;
        Qo qo0=new Qo("A ce que le langage c admet un type boolean ? ",RepQo0) ;
        formateur.getFormation().getNotions().get(0).ajouterQuestion(qo0);

        /* question de type qcm */

        ArrayList<String> Rep =  new ArrayList<String>(Arrays.asList("Les listes lineaires chainees" , "Les tableaux")) ;
        ArrayList<String>  Prop = new ArrayList<String>(Arrays.asList("Les listes lineaires chainees" , "Les boucles " , "Les fonction" , "Les tableaux") ) ;
        Qcm qc = new Qcm(Rep , "Quelles sont les structures de donnees citees  ?" ,Prop) ;
        formateur.getFormation().getNotions().get(1).ajouterQuestion(qc);

        // question de type qcu
        ArrayList<String> RepQcu =  new ArrayList<String>(Arrays.asList("la taille fixee")) ;
        ArrayList<String>  PropQcu = new ArrayList<String>(Arrays.asList("la taille fixee" ,"la difficulte d'utilisation" )) ;
        Qcu qcu= new Qcu(RepQcu, "Quels sont les Inconvenients des tableaux ?" ,PropQcu) ;
        formateur.getFormation().getNotions().get(1).ajouterQuestion(qcu);


        // question ouverte
        ArrayList<String> RepQo =  new ArrayList<String>(Arrays.asList("2dimensions")) ;
        Qo qo=new Qo("Comment s'appelle un tableau de tableau? ",RepQo) ;
        formateur.getFormation().getNotions().get(1).ajouterQuestion(qo);



        //notion 2
        ArrayList<String> Rep1 =  new ArrayList<String>(Arrays.asList("pour les taches repititives","pour faciliter le code")) ;
        ArrayList<String>  Prop1 = new ArrayList<String>(Arrays.asList("pour extraire du code","pour les taches repititives","pour faciliter le code" ,"pour gagner de l'espace memoire")) ;
        Qcm qc1 = new Qcm(Rep1 , "Pour quoi on utilise les boucles  ?" ,Prop1) ;
        formateur.getFormation().getNotions().get(2).ajouterQuestion(qc1);


        // question de type qcu
        ArrayList<String> RepQcu1 =  new ArrayList() ;
        RepQcu1.add("la boucle repeat") ;
        ArrayList<String>  PropQcu1 = new ArrayList<String>(Arrays.asList("la boucle for","la boucle repeat","la boucle while")) ;
        Qcu qcu1= new Qcu(RepQcu1, "Quelle est la boucle qui s'execute au moins une fois ?" ,PropQcu1) ;
        formateur.getFormation().getNotions().get(2).ajouterQuestion(qcu1);


        ArrayList<String> RepQo1 =  new ArrayList<String>(Arrays.asList("s'arrete"));
        Qo qo1=new Qo("Que ce passe pour le programme si il rencontre une boucle infinie? ",RepQo1) ;
        formateur.getFormation().getNotions().get(2).ajouterQuestion(qo1);


        /////////////////////parcourir les notions et leurs questions ///////////////////////////////////////////////////////

        formateur.getFormation().afficherNotions();



        System.out.println("\n***************************************** Creer et generer un Quiz **************************") ;

        ////////////crï¿½er le quiz/////////////////////////////////////////////////////////////////////////////////
        try{
          quiz = new Quiz("quiz1", "2019-11-01","2019-12-01") ;

        }catch (dateException e) {
         System.out.println();
        }catch (infoException e) {
         System.out.println();
        }


        ////////////////////////////Ajouter des notions au quiz////////////////////////////////////////////////////////////
        ArrayList<Notion> notion = new ArrayList() ;
        notion.add( formateur.getFormation().getNotions().get(0));
        notion.add( formateur.getFormation().getNotions().get(1));
        notion.add( formateur.getFormation().getNotions().get(2));

     ///////////////////////////////le nombre des questions dans chaque notion dans le quiz //////////////////////////////////
        ArrayList<Integer> tab = new ArrayList<Integer>(Arrays.asList(2 ,2 ,2)) ;


        ///////////////////generer un quiz //////////////////////////////////////////////////////////////////////
        formateur.genererQuiz( quiz, notion, tab);
        quiz.afficherQuiz();

        //////////////////////ajouter le quiz à la formation /////////////////////////////////////////////////////
        formateur.getFormation().getQuizs().add(quiz) ;

        /////////////////////////////////////modifier le quiz /////////////////////////////////
        System.out.println("\n***************************************** Modifier un Quiz *********************************************") ;
        formateur.getFormation().modifierQuiz(quiz, "Quiz final", "20/02/2019", "19/03/2019");
        formateur.getFormation().getQuizs().get(0).afficherQuiz();

        ///////////////////////////ajouter une question au quiz/////////////////////////////////
        System.out.println("\n***************************************** Ajouter une question *****************************************") ;
        //l utilisateur choisi la notion sur quelle doit porter la question
        formateur.getFormation().ajouterQuestion(quiz, formateur.getFormation().getNotions().get(0));

        ////////////////////////parcourir le quiz///////////////////////////////////////////////
        formateur.getFormation().getQuizs().get(0).listQST();


        ///////////////////////////supprimer une question du quiz /////////////////////////////////
        System.out.println("\n***************************************** Supprimer une question *************************************") ;
        formateur.getFormation().supprimerQuestion(quiz, quiz.getQst().get(0));
        formateur.getFormation().getQuizs().get(0).listQST();

        ///////////////////////////////////// changer une question dans le quiz ///////////////////
        System.out.println("\n***************************************** Changer une question *************************************") ;
        formateur.getFormation().changerQuestion(quiz, 0 );

        ///////////////////////////////////afficher les questions d'un quiz /////////////////////////////////
        formateur.getFormation().getQuizs().get(0).listQST();


        ///////////////////////////////// Afficher la liste des quizs d'un apprenats ////////////////////////////////////////

        System.out.println("\n*******************************Afficher la liste des quizs d'un apprenats ********************************") ;
        apprenant1.afficherQuizs();
        System.out.println("\n Choisir un quiz :  ");




        /////////////////////////////////répondre à un quiz /////////////////////////////////////////
        System.out.println("\n***************************************** Répondre à un quiz ********************************************") ;
        ArrayList<Integer> tabNB =  new ArrayList<Integer>(Arrays.asList(0,1,2,3)) ;
        // tabNB contient les numéro des questions à répondre pour le test
        reponseQuiz rep =   apprenant1.repondreQuiz(1,tabNB  );


        ArrayList<Integer> tabNB1 =  new ArrayList<Integer>(Arrays.asList(0,1,2)) ;
        reponseQuiz rep1 =   apprenant3.repondreQuiz(1,tabNB1);


        //////////////////////////////////afficher les réponses de l'apprenats ///////////////////////////
        System.out.println("\n\n--------------------------------------Une copie de vos réponses------------------------------------- ") ;
        apprenant1.getQuizNonAcomplis().get(0).afficherReponse();
        System.out.println("\n\n--------------------------------------La correction du quiz---------------------------------------- ") ;
        rep.repQuiz();

        System.out.println("\n\n-----------------------Consulter l'activité d'un apprenant avant l'évaluation-------------------------------- ") ;
        formateur.consulterAct(apprenant1);
        /////////////////////////////////l'évaluation ////////////////////////////////////////////
        System.out.println("\n\n-------------------------------------------L'évaluation-------------------------------------------- ") ;
        apprenant1.evaluer(rep);
        System.out.println("\n\n----------------------------------Consulter l'activité de touts les apprenants-------------------------------- ") ;
        formateur.consulterAct(apprenant1);

        formateur.consulterAct(apprenant3);


        trainner = formateur ;
       launch(args);


    }
}

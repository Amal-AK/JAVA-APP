package sample.model;
import java.util.ArrayList;

public class Qo extends Question {

	
      public Qo (String qst , ArrayList<String> rep) {
    	  this.enonce = qst ; 
    	  this.reponseCorrecte= rep ; 
	
      }; 
      
     
     
   
 	public void repondre( reponseQuiz repQuiz) {
 		ArrayList<String> ls = new ArrayList() ;  
		ls.add("rien") ; //liste des reponses
 		reponseQst rep = new reponseQst(this) ; 
		rep.setReponse(ls); 
		rep.setQst(this);
		repQuiz.getCopieRep().add(rep)  ; 
 	}
	public void afficherQuestion() {
		System.out.println("\t"+this.getEnonce());

	}


}

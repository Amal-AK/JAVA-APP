package sample.model;
import java.util.*;

public class Qcu extends Question {

	
	protected ArrayList<String> listePropositions;
	private String Reponse;

	public Qcu (ArrayList<String> reponses , String qst , ArrayList<String> propositions) {
		this.reponseCorrecte = reponses ; 
		this.enonce =  qst ; 
		this.listePropositions = propositions ; 
	}
	public void afficherQuestion() {
		System.out.println("\t"+this.getEnonce());
		for (int i = 0; i < this.listePropositions.size(); i++) {
			System.out.println("\t\t"+(i+1)+")"+this.listePropositions.get(i)+".");
		}
		
	}
	public void repondre(reponseQuiz repQuiz ) {
 		ArrayList<String> ls = new ArrayList() ; 
		ls.add(this.getProp().get(0));
 		reponseQst rep = new reponseQst(this) ; 
		rep.setReponse(ls); 
		rep.setQst(this);
		repQuiz.getCopieRep().add(rep)  ; 
 	}



	public ArrayList<String> getProp() {
		return listePropositions ; 
	}

	

}

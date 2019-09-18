package sample.model;
import java.util.*;
public class Qcm extends Question {

	private ArrayList<String> listePropositions = new ArrayList();
	private ArrayList<String> choixReponse = new ArrayList();


	
	public Qcm (ArrayList<String> reponses , String qst , ArrayList<String> propositions) {
		this.reponseCorrecte = reponses ; 
		this.enonce =  qst ; 
		this.listePropositions = propositions ; 
	}

	
	 
 	public void repondre(reponseQuiz repQuiz ) {
 		ArrayList<String> ls = new ArrayList() ;
 		// les réponses seront récupérer de l utilisateur , ici un test statique
		ls.add(this.getProp().get(0));
		ls.add(this.getProp().get(1));
 		reponseQst rep = new reponseQst(this) ; 
		rep.setReponse(ls); 
		rep.setQst(this);
		repQuiz.getCopieRep().add(rep)  ; 
 	}

	public void afficherQuestion() {
		System.out.println("\t"+this.getEnonce());
		for (int i = 0; i < this.listePropositions.size(); i++) {
			System.out.println("\t\t"+(i+1)+")"+this.listePropositions.get(i)+".");
		}
		
	}

	
	
	public ArrayList<String> getProp() {
		return listePropositions ; 
	}

	

}

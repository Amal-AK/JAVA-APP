package sample.model;
import java.util.ArrayList;

public class reponseQuiz {
	private float tauxReussite;
	private float tauxAcomplissement;
	private Quiz quiz ; 
	private ArrayList<reponseQst> copieReponse= new ArrayList();
	
	public Quiz getQuiz() {
		return this.quiz ; 
	}
	public reponseQuiz(Quiz q) {
		this.quiz= q; 
	}
	public float getTauxR() {
		return this.tauxReussite ; 
	}
	
	public float getTauxAcc() {
		return this.tauxAcomplissement ; 
	}
	
	public void setCopie(ArrayList<reponseQst> q) {
		this.copieReponse = q ; 
	}
	
	
	public void afficherReponse() {
		  for(int k = 0 ; k<this.copieReponse.size();k++) {
		    	System.out.println("\n\n\t Vos reponses a la question : "+this.copieReponse.get(k).getQst().enonce);
		    	for(int z=0 ; z< this.copieReponse.get(k).getRep().size();z++) {
		    		System.out.println("\t"+this.copieReponse.get(k).getRep().get(z)); 
		    	}; 
		    }
	}
	public void setTauxAcc(float f) {
	    this.tauxAcomplissement = f  ; 
	}
	public void setTauxR(float f) {
	    this.tauxReussite = f  ; 
	}
	public ArrayList<reponseQst> getCopieRep() {
		return this.copieReponse; 
	}
	
	public void repQuiz ( ) {
		for(int i =0 ; i<this.quiz.getQst().size();i++) {
			System.out.println("\n Les reponses correctes de la question : "+this.quiz.getQst().get(i).enonce);
			for(int j=0 ; j<this.quiz.getQst().get(i).getReponseCorrecte().size() ;j++) {
				System.out.println("\t"+this.quiz.getQst().get(i).getReponseCorrecte().get(j));
			}
		}
		
	}
	public float evaluationQuiz( ) {
		float somme=0  ; 
		float x = 100 / quiz.getQst().size()  ; 
		for(int i =0 ; i<copieReponse.size();i++) {
			
			ArrayList<String> rep = copieReponse.get(i).getQst().getReponseCorrecte(); 
			somme= somme + copieReponse.get(i).evaluerQst(x) ; 
		};
		this.tauxReussite = somme ; 
		return somme ; 
		
		
		
		
	}; 


}

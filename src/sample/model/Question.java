package sample.model;
import java.util.*;
public abstract class Question {
	
	
	protected String enonce;
	protected boolean repond;
	protected ArrayList<String> reponseCorrecte = new ArrayList();
	
   
	public abstract void afficherQuestion();
	public abstract void repondre( reponseQuiz repQuiz);
   
	
    public ArrayList<String> getReponseCorrecte() {
		return reponseCorrecte;
	}
	public void setReponseCorrecte(ArrayList<String> reponseCorrecte) {
		this.reponseCorrecte = reponseCorrecte;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	
	public boolean isRepond() {
		return repond;
	}
	public void setRepond(boolean repond) {
		this.repond = repond;
	}



}

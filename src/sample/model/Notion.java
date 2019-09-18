package sample.model;
import java.util.*;
public class Notion {
	
	private String nameNotion;
	private ArrayList<Question> TabQuestions = new ArrayList(); 
	
	public Notion(){}
	public Notion (String name ) {
		this.nameNotion = name ; 
	}
	
	
	 public void setNotion(String s)
	 {
		 nameNotion=s;
	 }
	 public String getNotion()
	 {
		 return nameNotion;
	 }

	 public ArrayList<Question> getQst()
	 {
		 return this.TabQuestions;
	 }
	 
	 
	 public void miseAjour(String nom) {
		 this.nameNotion = nom ; 	 
	 }
	    
	 public void ajouterQuestion( Question Qst ) {
		 if(!TabQuestions.contains(Qst))
			 	TabQuestions.add(Qst);
	 }

	 public void supprimerQuestion(Question Qst){
		 TabQuestions.remove(Qst);
	 } 
	

}

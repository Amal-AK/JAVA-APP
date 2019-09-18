package sample.model;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Quiz  {
	
	private String nom;
	private String dateOuverture;
	private String dateExpiration;
	private ArrayList <Question> ensembleQuestion = new ArrayList();
	private float pourcentage ; 
	private boolean valide;
	private ArrayList<Notion> notionsChoisies;
	
	public Quiz (){}
	public Quiz (String name,String dd , String df) throws dateException , infoException {
		if ((dd.compareTo(df))>0) throw new dateException() ;
		String s =LocalDate.now().toString();
		if(s.compareTo(dd)>0) throw new dateException();
        if (name.length()==0) throw new infoException() ;
		this.nom=name ; 
		this.dateOuverture=dd ; 
		this.dateExpiration= df ; 
		
		
	}
	
	///////////////////////////////////////////getter////////////////////////////////////
	
	public String getDD() {
		return this.dateOuverture ; 
	}
	public String getDF() {
		return this.dateOuverture ; 
	}
	public ArrayList<Question> getQst() {
		return this.ensembleQuestion; 
	}
	 public ArrayList<Notion> getNotion( ){
		 return this.notionsChoisies ; 
	 }
	 
	 
	 //////////////////////////////////////////////setter//////////////////////////////////
	
	 public void setNotion(ArrayList<Notion> tab){
		 this.notionsChoisies = tab  ; 
	 }
	 
	
	public void setQst(ArrayList<Question> tab ) {
	    this.ensembleQuestion = tab; 
	}
	
	public void setName(String name) {
		this.nom= name ; 
	}
	public String getName() {
		return this.nom ; 
	}
	public void setDD(String date) {
		this.dateOuverture= date; 
	}
	public void setDF(String date) {
		 this.dateOuverture=date ; 
	}


	
	///////////////////////////////////////////m�thodes//////////////////////////////////////////////
	
	 public void afficherQuiz () {
		 System.out.print("\n\t nom : "+nom+"\n\t dateOuverture : "+dateOuverture+"\n\t dateExpiration : "+ dateExpiration);
		 
		 
	 }
	 public void listQST() {
		 if(this.ensembleQuestion != null ) {
			 for(int i =0 ; i<this.ensembleQuestion.size() ; i++)
			 this.ensembleQuestion.get(i).afficherQuestion(); ; 
		 }
		 
	 }
	 public void validerQuiz() {this.valide=true ;}

	 


	 public  ArrayList<Question> sortList(){
		 return this.ensembleQuestion ; 
		 
	 }
	 
	 
		


	
}

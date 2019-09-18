package sample.model;
import java.util.*;
public class Formation {
	
	private String nom;
	private String description;
	private String dateDebut;
	private String dateFin;
	private ArrayList<Notion> notionsEnseignees = new ArrayList(); 
	private ArrayList<Quiz> listeQuiz = new ArrayList();


	////////////////////////////getters///////////////////////////////////////////////////////
	public ArrayList<Quiz> getQuizs() {
		return this.listeQuiz ; 
	}
	public String getNom() {
		return this.nom ;
	}
	public String getDescription() {
		return this.description ;
	}
	public String getdd() {
		return this.dateDebut ;
	}
	public String getdf() {
		return this.dateFin ;
	}
	
	public ArrayList<Notion> getNotions (){
		return this.notionsEnseignees ; 
	}
	
	
	
	////////////////////////////////////m�thodes/////////////////////////////////////////////
	
	// r�cup�rer les liste des apprenants et trier 
	public Formation(String nom, String description, String dateDebut, String dateFin)  {
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	
	}
	
	public void afficherListeNotion ( ) {
		if(this.notionsEnseignees != null ) {
			for(int i=0 ; i<this.notionsEnseignees.size() ; i++)
			System.out.println("\n\t La notion "+i+" : " +this.notionsEnseignees.get(i).getNotion()) ; 
		}
		
	}
	
	public void afficherFormation() {
		System.out.println("- Le nom de la formation: "+this.nom);
		System.out.println("- La date de debut: "+this.dateDebut);
		System.out.println("- La date de fin  "+this.dateFin);
		if(this.notionsEnseignees != null) 	System.out.println("- Le nombre des notions ajoutees \n\t"+this.notionsEnseignees.size());
		else System.out.println("- Le nombre des notions ajoutees est  : 0 " ) ;
		System.out.println("- La description de la formation : \n\t"+this.description);
	}

	
	public void ajouterNotion(String name) {
		Notion n = new Notion(name) ; 
		notionsEnseignees.add(n);
	}

	public void visualiserQuiz (Quiz quiz ){
		System.out.println(quiz);
		
	}
	 public void modifierQuiz (Quiz quiz ,String titre,String dateOvrtr,String dateExp) {
		 quiz.setName(titre); 
		 quiz.setDD(dateOvrtr);
		 quiz.setDF(dateExp);
		 
	 } 
	 
	 public void ajouterQuestion (Quiz quiz , Notion notionObj) {
		 quiz.getNotion().add(notionObj);
		 int j = notionObj.getQst().size() ; 
		 int k = 0 + (int)(Math.random() * (((j-1) - 0) + 1)); 
			if(!quiz.getQst().contains(notionObj.getQst().get(k))) {
				
				quiz.getQst().add(notionObj.getQst().get(k)); 
				}
	 }
	



	public void changerQuestion (Quiz quiz ,int index ) {
		Notion n = new Notion();
		for(int i = 0 ; i<this.getNotions().size(); i++) {
			if(this.getNotions().get(i).getQst().contains(quiz.getQst().get(index))) {
				n= this.getNotions().get(i) ;
			}
		}
		boolean bol = false ;
		int j = 0 ;
		do {
			if(! quiz.getQst().contains(n.getQst().get(j))) {
				quiz.getQst().set(index, n.getQst().get(j)) ;
				bol=true ;
			}else j++ ;

		}while(bol==false || j<n.getQst().size()) ;

	}
	  
	 
	 public void afficherNotions () {
		  if(this.notionsEnseignees!=null) {
		    	 for(int i=0 ; i<this.notionsEnseignees.size() ;i++) {
		    		 System.out.println("\n\t\t Ajouter des question a la notion : "+this.notionsEnseignees.get(i).getNotion());
		    	     for(int j=0 ; j<this.notionsEnseignees.get(i).getQst().size();j++) {
		    	    	 this.notionsEnseignees.get(i).getQst().get(j).afficherQuestion();
		    	     }
		    	 }
		     }
		     
	 }
	 
	 public void supprimerQuestion (Quiz quiz,  Question qst) {
		 quiz.getQst().remove(qst);}
	public void supprimerQuiz(Quiz quiz){} 
	public void sauveguarderQuiz (Quiz quiz){}

	
}

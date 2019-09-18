package sample.model;
import java.time.LocalDate;
import java.util.*;

public class Formateur extends Utilisateur  {
	
	private ArrayList<Apprenant> listeApprenant = new ArrayList<Apprenant>();
	private Formation formation;



	public Formateur (String log , String pass ) {
		super(log,pass) ; 
		
	      
	}


	/////////////////////////////////////getter///////////////////////////////////////////////
	
	
	public Formation getFormation () {
		return this.formation ; 
	}
	
	public ArrayList<Apprenant> getListe () {
		return this.listeApprenant ; 
	}

	
	
	
	////////////////////////////////////méthodes///////////////////////////////////////////////
	
	public void ListeApprenants( ) {
		  if(this.listeApprenant!= null) {
		    	 System.out.println("\tVoici la liste des apprennats de formateur actuel : " );
		    	 for (int i=0 ; i<this.listeApprenant.size() ; i++) {
		    		 System.out.println("\n\t 1) L'apprennant "+(i+1));
		    		 this.listeApprenant.get(i).afficherApprenant();
		    	 }
		     }
		     
	}

	public boolean checkLogin(String login) throws LoginException {
		if( ! (this.getLogin().equals(login))) throw new LoginException();
		else return true ;

	}

	public boolean checkPass(String passwd) throws LoginException {
		if( ! (this.getpass().equals(passwd))) throw new LoginException();
		else return true ;

	}
	
	  public void consulterAct (Apprenant a) {
		System.out.println("\nConsulter l'apprenant : "+a.getNom()+" "+a.getPrenom()) ; 
		if(a.getQuizAcomplis()!= null) {
		System.out.println("Le nombre des quizs acomplis est :  "+a.getQuizAcomplis().size());
          for(int i=0 ; i<a.getQuizAcomplis().size() ; i++) {
        	  System.out.println("\t Le nom de quiz : "+a.getQuizAcomplis().get(i).getQuiz().getName()) ;
        	  System.out.println("\t Le taux de réussite : "+a.getQuizAcomplis().get(i).getTauxR()+"%");
          }
		}
		else 	System.out.println("Le nombre des quizs acomplis est : 0 %");
		
		if(a.getQuizNonAcomplis()!= null) {
			System.out.println("Le nombre des quizs non acomplis est :  "+a.getQuizNonAcomplis().size());
			 for(int i=0 ; i<a.getQuizNonAcomplis().size() ; i++) {
	        	  System.out.println("\t Le nom de quiz : "+a.getQuizNonAcomplis().get(i).getQuiz().getName()) ;
	        	  System.out.println("\t Le taux d'acomplissement: "+a.getQuizNonAcomplis().get(i).getTauxAcc()+"%");
	          }
			}
			else 	System.out.println("Le nombre des quizs non acomplis est : 0 % ");
	    }
	
	  
	  
	
	
	public Apprenant ajouterCompte (String nom , String prenom , String date , String adresse)
	{
		Apprenant a = new Apprenant(nom ,prenom,date,adresse) ; 
		listeApprenant.add(a);
		return a;
	}
	
	
	public void supprimerCompte ( Apprenant user) {
		listeApprenant.remove(user);
		user=null;
		
	}
	
	
	public void modifierCompte (Apprenant user , int index ,String info) {
		switch(index) {
		case 1 : 
			user.setNom(info);
			break ; 
		case 2 :
			user.setPrenom(info);
			break ; 
		case 3 : 
			user.setAdresse(info);
		}
		
		
	}
	
	
	public void afficherFormateur () {
		 System.out.println ("Le login est : "+ this.getLogin()) ; 
		 System.out.println ("Le Mot de passe est : "+this.getpass()) ;
	}
	
	public Formation creerFormation(String nom , String description , String Ddebut , String Dfin) throws infoException , dateException {
		if ((Ddebut.compareTo(Dfin))>0) throw new dateException() ;
		String s = LocalDate.now().toString();
		if(s.compareTo(Ddebut)>0) throw new dateException();
		if(nom.length()==0 || description.length()==0 ) throw new infoException() ;
		Formation f = new Formation(nom,description,Ddebut,Dfin);
		this.formation = f ;
		return f;
	} 

	
	public Quiz genererQuiz( Quiz quiz , ArrayList <Notion> tabNotion , ArrayList<Integer> tabNb) {
		quiz.setNotion(tabNotion);
		for(int i=0 ; i<tabNotion.size() ; i++) {

			int j=tabNb.get(i) ;
			for(int x= 0 ; x< j ; x++ ) {
				boolean bol = false ;
				do {

				int k = 0 + (int)(Math.random() * (((j-1) - 0) + 1));
				if(!quiz.getQst().contains(tabNotion.get(i).getQst().get(k))) {
					quiz.getQst().add(tabNotion.get(i).getQst().get(k)) ;
					bol=true ; 
				}else {
				    k = 0 + (int)(Math.random() * (((j-1) - 0) + 1));
				}
			}while(bol==false) ; 
				}
				
		}

		  if(this.listeApprenant!= null) {
		    	 for (int i=0 ; i<this.listeApprenant.size() ; i++) {
		    		  reponseQuiz rep = new reponseQuiz(quiz) ; 
		    		  rep.setTauxAcc(0);
		    		  rep.setTauxR(0);
		    		 this.listeApprenant.get(i).getQuizNonAcomplis().add(rep);
		    	 }
		     }
		  this.getFormation().getQuizs().add(quiz) ;
		
		return quiz ; 
	}



	public ArrayList<Apprenant> classement (reponseQuiz q) {
		ArrayList<Apprenant>  tab = new ArrayList() ;
		for(int i=0 ; i<listeApprenant.size() ; i++) {
			if(listeApprenant.get(i).getQuizAcomplis().contains(q)) {
				tab.add(listeApprenant.get(i)) ; // ajouter tous les étudiants ayyant répondu au quiz à tab
			}
		}
        //trier le tablleau selon le tuax de réussite
		Collections.sort(tab, new Comparator<Apprenant>() {
			@Override
			public int compare(Apprenant a1, Apprenant a2) {
				if(a1.getQuizAcomplis().get(a1.getQuizAcomplis().indexOf(q)).getTauxR() < a2.getQuizAcomplis().get(a1.getQuizAcomplis().indexOf(q)).getTauxR()) return -1 ;
				if(a1.getQuizAcomplis().get(a1.getQuizAcomplis().indexOf(q)).getTauxR() > a2.getQuizAcomplis().get(a1.getQuizAcomplis().indexOf(q)).getTauxR()) return 1 ;
                return 0 ;
			}
		});
		return  tab ;


	}

	public Quiz lastQuiz() {
		return this.getFormation().getQuizs().get(this.getFormation().getQuizs().size()-1) ;
	}
	public void modifierPasswd(String newPasswd)
	{
	     this.Setpass(newPasswd ) ; 
	}
	

}

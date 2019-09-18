package sample.model;
import java.util.*;
public class Apprenant extends Utilisateur {

	
	
	private String nom; 
	private String prenom ;
	private String adresse;
	private String dateNaissance;
	private ArrayList<reponseQuiz> quizAcomplis = new ArrayList();
	private ArrayList<reponseQuiz> quizNonAcomplis= new ArrayList();

  
	//constructor  
	public Apprenant(String nom,String prenom,String dateNaissance ,String adresse)
	{   
		super("" , "") ; 
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.adresse=adresse;
		String pass = this.genererLogin() ; 
		String log = this.genererLogin()  ; 
		this.Setpass(pass) ; 
		this.SetLogin(log) ; 
		
		
		
	}
	
	/////////////////////////////////setter///////////////////////////////////////////////////////
	
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	public void setQuizNonAcomplis(ArrayList<reponseQuiz> tab){
		 this.quizNonAcomplis= tab; 
	}
	
	///////////////////////////////////getter///////////////////////////////////////////////////
	
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	

	public String getAdresse()  {
		return adresse;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	
	public ArrayList<reponseQuiz> getQuizAcomplis(){
		return quizAcomplis;
	}
	public ArrayList<reponseQuiz> getQuizNonAcomplis(){
		return this.quizNonAcomplis;
	}
	
	////////////////////////////////////m�thodes ////////////////////////////////////////////////
	
	
	//afficher le groupe des apprenants 
	public void afficherApprenant () {
		System.out.println("Nom : "+this.nom);
		System.out.println("Prenom : "+this.prenom);
		System.out.println("Adresse: "+this.adresse);
		System.out.println("Date de naissance : "+this.dateNaissance);
		if(quizAcomplis!= null) {
		System.out.println("Le nombre des quizs acomplis est :  "+this.quizAcomplis.size());

		}
		else 	System.out.println("Le nombre des quizs acomplis est : 0 ");
		
		if(quizNonAcomplis!= null) {
			System.out.println("Le nombre des quizs acomplis est :  "+this.quizAcomplis.size());
			}
			else 	System.out.println("Le nombre des quizs non acomplis est : 0 ");
		
	}
	
	
	
    // répondre à un quiz d(index indexQuiz parmi les quiz non acomplis
	public reponseQuiz  repondreQuiz(int indexQuiz , ArrayList<Integer> tab) {
		float acc= 0 ; 
		float taux = 100 / this.quizNonAcomplis.get(indexQuiz-1).getQuiz().getQst().size() ; 
		Quiz q = this.quizNonAcomplis.get(indexQuiz-1).getQuiz() ; 
		reponseQuiz repQuiz = this.quizNonAcomplis.get(indexQuiz-1) ;
		
		for(int i =0; i< tab.size() ; i++) {
		  q.getQst().get(tab.get(i)).repondre( repQuiz);
		  acc=acc+taux ; 
	     }	 
		repQuiz.setTauxAcc(acc);
		return repQuiz ; 
		
	}
	
	
	public String genererLogin() 
	{
		return this.prenom.charAt(0)+nom;
	}
	public String genererPasswd()
	{
		return nom+dateNaissance;
	}
	 
	// evaluer les réponses à un quiz
	public void evaluer(reponseQuiz q)
	{
		
		float t = q.evaluationQuiz() ; 
		this.quizAcomplis.add(q) ; 
		this.quizNonAcomplis.remove(this.quizNonAcomplis.indexOf(q)) ; 

		   System.out.println("\n\n\t\t Votre taux de réussite est : "+t+"%" );
	}
	
     // affihcer tt les quiz acomplis et non acomplis d un apprenants 
	
	public void afficherQuizs() {
	if(this.quizAcomplis.size()!=0) {
		System.out.println("\n\n\t Les quizs acomplis : ") ; 
		for(int i = 0 ; i<this.quizAcomplis.size() ; i++) {
			System.out.println("\n\t\t "+(i+1)+" ) quiz : "+this.quizAcomplis.get(i).getQuiz().getName()) ; 
			System.out.println("\t\t Le taux de réussite "+this.quizAcomplis.get(i).getTauxR()+" %") ;
		}
	}else System.out.println("\n\n\t Les quizs acomplis : 0 ") ;
		if(this.quizNonAcomplis.size()!=0 ) {
			System.out.println("\n\n\t Les quizs non acomplis : ");
			for (int i = 0; i < this.quizNonAcomplis.size(); i++) {
				System.out.println("\n\t\t " + (i + 1) + " ) quiz : " + this.quizNonAcomplis.get(i).getQuiz().getName());
				System.out.println("\t\t Le taux d'acomplissement " + this.quizNonAcomplis.get(i).getTauxAcc() + " %");
			}
		}else System.out.println("\n\n\t Les quizs non acomplis : 0 ");
	
}
	

	public void modifierPasswd(String newPasswd)
	{
	     this.Setpass(newPasswd ) ; 
	}
	

}

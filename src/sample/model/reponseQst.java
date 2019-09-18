package sample.model;
import java.util.ArrayList;

public class reponseQst {
	private ArrayList<String> reponse= new ArrayList();
	private Question qst ; 

	
	public reponseQst (Question qs) {
		this.qst = qs ; 
	}
	public void setReponse (ArrayList<String> reponse) {
		this.reponse = reponse ;
		
	};
	public void setQst(Question question) {
		this.qst = question ; 
	}
	public ArrayList<String> getRep() {
		return this.reponse ; 
	}
	public Question getQst() {
		return this.qst ; 
	}

	
	public float evaluerQst(float x) {
		if(this.qst.getClass().getName()=="sample.model.Qo") {
			String rep = this.reponse.get(0) ;
			if(! qst.getReponseCorrecte().contains(rep)) x= 0 ;

		}
		if(this.qst.getClass().getName()=="sample.model.Qcu") {
			String rep = this.reponse.get(0) ; 
			if(! qst.getReponseCorrecte().contains(rep)) x= 0 ;	
		}
		if(this.qst.getClass().getName()=="sample.model.Qcm") {
			float somme=0 , y= 0 ;
			Qcm q= (Qcm)qst ; 
			y= x/ q.getProp().size() ; 
			ArrayList<String> rep = this.reponse ; 
			for(int j = 0 ; j<rep.size();j++) {
			if(! qst.getReponseCorrecte().contains(rep.get(j))) somme=somme+y ; 
			else somme=somme-y ; 
			}
			for(int k = 0 ; k<q.getProp().size();k++) {
				if(qst.getReponseCorrecte().contains(q.getProp().get(k))) {
					if(! this.reponse.contains(q.getProp().get(k))) somme=somme-y ; 
				
				}else {
					if(! this.reponse.contains(q.getProp().get(k))) somme=somme+y ; 
				}
				
				}
			if(somme<0) somme=0 ; 
			x=somme ; 
		}
		System.out.println("\nLe pourcentage oubtenu sur : '"+this.qst.enonce +" ' est : "+x+" %") ; 
		
		return x ; 
		
	}
}

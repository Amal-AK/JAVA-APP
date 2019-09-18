
package sample.model;
public abstract class Utilisateur {
	
	
	private String login;	
	private String passwd;	
	
	
	public Boolean authentification(String log,String psswd)
	{
		if(this.getLogin().equals(log)&& this.getpass().equals(psswd)) {

				return true;
		}

		return false;
	}

	public void modifierPasswd(String newPasswd)
	{
		passwd=newPasswd;
	}
	
	public String getLogin() {
		return this.login ; 
	
	}
	public String getpass() {
		return this.passwd ; 
	
	}
	public String Setpass( String pass) {
		return this.passwd = pass; 
	
	}
	public String SetLogin( String pass) {
		return this.passwd = pass; 
	
	}
	 public Utilisateur(String log , String pass) {
		 this.login = log ; 
		 this.passwd = pass ; 
	 }; 
	
	
	

	
	

}

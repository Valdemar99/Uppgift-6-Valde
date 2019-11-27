//Har lagt till en konstruktor för Person längst ned


import java.util.ArrayList;
public class Person {


	private String pNbr;
	private String name;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public void setPnbr(String newPnr) {
		pNbr = newPnr;
	}
	public String getPnbr() {
		return pNbr;
	}
	public void setName(String newName) {
		name=newName;
	}
	public String getName() {
		return name;
	}
	public void setAccounts(ArrayList<Account> newAccount) {
		accounts = newAccount;
	}
	public ArrayList<Account> getAccounts(){
		return accounts;
	}

	public void addAccount(Account aBankAccount) {
		accounts.add(aBankAccount);
	}
	
	//Sökfunktion - hitta konto med givet kontonummer
	public Account findAccount(String nbr) {        
        for(Account tmp : this.getAccounts()) {            
            if(nbr.equals(tmp.getNbr())) {
                return tmp;
                }
            }
        return null;
    
    }
	
	//Ta bort konto hos person
	public Account removeAccount(String nbr) {
		Account a = this.findAccount(nbr);
		accounts.remove(a);
		return a; 
	}




	
	public Person(String pNbr, String name) {
		this.setPnbr(pNbr);
		this.setName(name);



	}
}



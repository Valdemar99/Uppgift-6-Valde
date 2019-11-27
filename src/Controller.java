import java.util.ArrayList;

import javax.swing.JFrame;
public class Controller {



	PersonRegister personregister;
	Person person;
	Account account;
	JFrame frame;

	public Controller(PersonRegister personregister, JFrame frame) {
		this.personregister = personregister;
		this.frame = frame;
	}

	public void addPerson(String pNbr, String name){
		Person tmpPerson = new Person(pNbr, name);
		personregister.addPerson(tmpPerson);
	}
	public void removePerson(String pNbrRemove) {
		personregister.removePerson(pNbrRemove);
	}
	public String[] findPerson(String pNbrfind) {
		Person p = personregister.findPerson(pNbrfind);
		String[] pPers = null; 

		if(p != null) {
			pPers = new String[2];
			pPers[0] = p.getPnbr();
			pPers[1] = p.getName();            
		}
		return pPers;
	}
	
	//Metoder för klassen Person och klassen Account (lägg till konto)
	
	//Lägg till konto hos en befintlig person
	public void addAccount(String accountNumber, double saldo, String pNbr) {
		
		//Skapar en person som hittas med sökfunktionen. Skapar även ett konto.
		person = personregister.findPerson(pNbr);
		account = new Account();
		
		//Sätter kontons saldo, nummer, ägare. Konton läggs till i kundens lista av konton
		account.setBalance(saldo);
		account.setNbr(accountNumber);
		account.setOwner(person);
		person.addAccount(account);
	}
	
	//Radera konto hos person utifrån ett givet personnummer och kontonummer
	public void removeAccount(String pNbr, String accountNbr) {
		
		//Sätter värdet på "person" till att vara den hittade personen. Därefter raderas konton.
		person = personregister.findPerson(pNbr);
		person.removeAccount(accountNbr);
		
	}




}


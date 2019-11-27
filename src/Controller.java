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




}


import java.util.ArrayList;
public class PersonRegister {

    private ArrayList<Person> personRegister = new ArrayList<Person>();
    

    
    public void setPersonregister(ArrayList<Person> newPersonregister) {
        personRegister = newPersonregister;
    }
    public ArrayList<Person> getPersonregister() {
        return personRegister;
    }
    public void addPerson(Person pPerson){
        personRegister.add(pPerson);
    }

    public Person findPerson(String pNbr) {        
        for(Person tmp : personRegister ) {            
            if(pNbr.equals(tmp.getPnbr())) {
                return tmp;
                }
            }
        return null;
    
    }
    public Person removePerson(String pNbr) {
        Person p = this.findPerson(pNbr);
        personRegister.remove(p);
        return p; 
        }


}

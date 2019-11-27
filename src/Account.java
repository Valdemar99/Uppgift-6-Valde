
public class Account {
	private String nbr;
	private double balance;
	private Person owner;

	public void setNbr(String newNbr) {
		nbr=newNbr;
	}
	public String getNbr() {
		return nbr;
	}
	public void setBalance(double newBalance) {
		balance=newBalance;
	}
	public double getBalance() {
		return balance;
	}
	public void setOwner(Person newOwner) {
		owner = newOwner;
	}
	public Person getOwner() {
		return owner;
	}
	public void credit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		balance -= amount;

	}

}

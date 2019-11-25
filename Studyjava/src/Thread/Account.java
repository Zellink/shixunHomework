package Thread;

class Acc {
	  int balance;
	 Acc(){
		balance = 0; 
	 }
	 public synchronized void deposit(int val)
	 {
	 int newBal;
	 newBal = balance + val;
	 balance = newBal;
	 }
	 public synchronized void withdraw(int val)
	 {
	 int newBal;
	 newBal = balance - val;
	 balance = newBal;
	 }
	 public void add(int val) {
		 synchronized(this) {
			 balance += val;
		 }
	 }
}

public class Account{   //synchronized  
	public static void main(String args[]) {
		Acc a = new Acc();
		a.add(100);
		System.out.println( a.balance );
	}
}
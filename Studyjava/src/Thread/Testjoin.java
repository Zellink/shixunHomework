package Thread;

class ToJoin extends Thread{
	 public ToJoin(String nm){ super(nm); }
	 public void run(){
	 try{ Thread.sleep(2000); } catch (InterruptedException e){ }
	 System.out.println(Thread.currentThread().getName()+" awake!");
	 }
	}
	class Joiner implements Runnable{
	 private ToJoin tojoin;
	 public Joiner(ToJoin t){ this.tojoin=t; }
	 public void run(){
	 try{ this.tojoin.join(); } catch (InterruptedException e){ }
	 System.out.println(this.tojoin.getName()+" join2 finished");
	 }
	}
	public class Testjoin{
	 public static void main(String[] args){
		 System.out.println(Thread.currentThread( ).getName( )+"Thread");
	 ToJoin t1=new ToJoin("t1");
	 //
	 new Thread(new Joiner(t1)).start();
	 t1.start();
	 try {
		t1.join(); 
	 }
	 catch(InterruptedException e) {
		 e.printStackTrace();
	 }
	 //t1.join( );
	 System.out.println(Thread.currentThread( ).getName( )+" finished!");
	 }
	} //又例：Joining.java
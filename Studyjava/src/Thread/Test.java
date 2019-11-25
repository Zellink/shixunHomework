package Thread;

public class Test implements Runnable{
	 private static int idcnt=1;
	 private final int threadid=idcnt++;
	 int counter=3;
	 public void run(){
	while(counter>=0){
	 try{
	Thread.sleep(1000);
	 } catch (Exception e){ 
		 e.printStackTrace();
		 }
	System.out.println("#"+threadid+
	(counter>0?"->"+counter:"->run!"));
	counter--;
	  }
	}
	public static void main(String[] args){
	Thread t1=new Thread(new Test());
	Thread t2=new Thread(new Test());
	Thread t3 = new Thread(new Test());
	t3.start( );
	t1.start();
	t2.start();

	System.out.println("waiting for run...");
	    }
	}
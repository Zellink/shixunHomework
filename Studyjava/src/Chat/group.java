package Chat;

public class group {
	int port;
	String password;
	String groupowner;
	String groupname;
	String question=null;
	public group(int por,String paw,String gon,String gna,String que){
		port = por;
		password = paw;
		groupowner = gon;
		groupname = gna;
		question =que;
		
	}
	public String toString() {
			return port+"  "+password +"  "+groupowner+"  "+groupname+"  "+question;
		}
}

package Chat;

public class group {
	int port;
	String password;
	String groupowner;
	String groupname;
	public group(int por,String paw,String gon,String gna){
		port = por;
		password = paw;
		groupowner = gon;
		groupname = gna;
		
	}
	public String toString() {
			return port+"  "+password +"  "+groupowner+"  "+groupname;
		}
}

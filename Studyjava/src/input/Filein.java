package input;

import java.io.*;
public class Filein {
	public static void main(String [] args) throws IOException{
		File f = new File("new.txt");
		FileOutputStream o = new FileOutputStream(f);
		OutputStreamWriter output = new OutputStreamWriter(o);
		output.append("中文输入");
		output.append("\r\nas");
		output.flush( );
		//output.close( );
		o.close( );
		FileInputStream i = new FileInputStream(f);
		InputStreamReader input = new InputStreamReader(i);
		StringBuffer str = new StringBuffer();
		while(input.ready( )) {
			str.append((char)input.read( ));
		}
		System.out.println(str);
	}
}

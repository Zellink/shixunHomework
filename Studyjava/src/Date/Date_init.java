package Date;

import java.util.Calendar;

import java.util.Date;

 

public class Date_init {

 

/**

 * @param args

 */

public static void main(String[] args) {

Date date=null;

String dateStr="2010-9-10";

String[] dateDivide=dateStr.split("-");

if(dateDivide.length==3){
	String s = "4/20/2018";
	String [] arr = s.split("/");
	
         int year = Integer.parseInt(arr [2].trim());//去掉空格

     int month = Integer.parseInt(arr [0].trim());

     int day = Integer.parseInt(arr [1].trim());

     Calendar c = Calendar.getInstance();//获取一个日历实例

     c.set(year, month, day);//设定日历的日期

     date = c.getTime();
     System.out.println();
     System.out.println( date.getMonth() +"/"+date.getDate( )+"/"+date.getYear( ));
     System.out.println( date.getMonth() +"/"+date.getDate( )+"/"+date.getYear( ));
     System.out.println( date.getMonth() +"/"+date.getDate( )+"/"+date.getYear( ));
     //System.out.printf("%d/%d/%d",date.getMonth( ),date.getDay( ),date.getYear( )+1900 );
     

}

            System.out.println(date);

}

 

}
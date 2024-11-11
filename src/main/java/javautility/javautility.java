package javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	
	public int getrandomnu() {
		Random random= new Random();
		int randomnumber=random.nextInt(5000);
		return randomnumber;
	}



public String getsystemdateYYYYDDMM() {
	Date dateobj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD");
	String date=sdf.format(dateobj);
	return date;
}
 public String getrequireddate(int days) 
 {
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD");
	 Calendar cal=sdf.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH ,days);
	 String reqdate=sdf.format(cal.getTime());
	 return reqdate;
	 
 }
}
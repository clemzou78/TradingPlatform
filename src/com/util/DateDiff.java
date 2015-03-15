package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDiff {

	public static String format(Date dateFin) {
		Calendar d=Calendar.getInstance();
		d.setTime(dateFin);
		
		Calendar d2=Calendar.getInstance();
		
		long reste = d.getTimeInMillis()-d2.getTimeInMillis();
		d2.setTimeInMillis(reste);
		d2.add(Calendar.HOUR_OF_DAY, -1);
		reste=reste/1000;

	
		System.out.println(d2);
		
		int days = (int) (reste/86400);
		return days +"j," + d2.get(Calendar.HOUR_OF_DAY)+"h," + d2.get(Calendar.MINUTE)+"m,"+d2.get(Calendar.SECOND)+"s";
		
	}
}

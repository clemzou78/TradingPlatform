package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDiff {

	public static String format(Date dateFin) {
		Calendar d=Calendar.getInstance();
		d.setTime(dateFin);
		
		Calendar d2=Calendar.getInstance();
		
		long reste = d2.getTimeInMillis()-d.getTimeInMillis();
		reste=reste/1000;
		d2.set(Calendar.SECOND, (int) reste);
		
		int days = (int) (reste/216000);
		return days +"j," + d2.get(Calendar.HOUR_OF_DAY)+"h," + d2.get(Calendar.MINUTE)+"m,"+d2.get(Calendar.SECOND)+"s";
		
	}
}

package br.com.fico.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {

	private static final SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String toDate(Calendar date){
        return sdfDate.format(date.getTime());
	}
	
}

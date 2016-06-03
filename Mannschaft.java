package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class Mannschaft {
	FileWriter writer;
	File file;
	
	/*Unter Verwendung des SDF & GregorianCalender erstelle ich mir ein Zufallsdatum,
	dass ich für die Geburtsdaten verwende.
	*/
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	GregorianCalendar von = new GregorianCalendar();
	GregorianCalendar bis = new GregorianCalendar();
	GregorianCalendar zufall = new GregorianCalendar();
	
	
	public void mannschaft(){
		file = new File("insertMannschaft.sql");
		
		try {
			von.setTime(df.parse("2016-04-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bis.setTime(df.parse("2016-10-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long l = von.getTimeInMillis();
		long l1 = bis.getTimeInMillis();
		long lg = (l1 - l);
		try{
			writer = new FileWriter(file,true);
		
		for (int i = 10000; i < 200000; i++) {
			if (i % 2 == 1) {
				i++;
				Random random = new Random();
				long gesamt= Math.abs(random.nextLong() % lg) + l;
				zufall.setTimeInMillis(gesamt);
				writer.write("INSERT INTO mannschaft VALUES ('bez"+i+"','klasse"+1+"','"+df.format(zufall.getTime())+"');");
				writer.write(System.getProperty("line.separator"));

			}
			 
			}
		
	}catch (IOException e) {
		e.printStackTrace();
		}
	}
	public static void main (String[]args){
		Mannschaft m = new Mannschaft();
		m.mannschaft();
	}
}
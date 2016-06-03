package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class Trainer {
	FileWriter writer;
	File file;
	
	/*Unter Verwendung des SDF & GregorianCalender erstelle ich mir ein Zufallsdatum,
	dass ich für die Daten der Spieler verwende. 
	*/
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	GregorianCalendar von = new GregorianCalendar();
	GregorianCalendar bis = new GregorianCalendar();
	GregorianCalendar zufallVon = new GregorianCalendar();
	GregorianCalendar zufallBis = new GregorianCalendar();
	
	
	double gehaltMin = 2000;
	double gehaltMax = 5000;
	
	public void trainer(){
		//Erstellung des Files
		file = new File("insertTrainer.sql");
		
		/*
		 * Ich setze mir das von & das bis Datum, anschließend hole ich mir 
		 * die Millisekunden der Daten und dann lass ich mir eine Random 
		 * Anzahl der Millisekunden mittels Random berechnen, die zwischen der 
		 * Anzahl der Millisekunden der beiden Daten liegt
		 */
		try {
			von.setTime(df.parse("1950-01-01"));
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
		
		try {
			writer = new FileWriter(file, true);

			for (int i = 10000; i < 200000; i++) {
				Random randomVon = new Random();
				Random randomBis = new Random();
			long gesamtVon= Math.abs(randomVon.nextLong() % lg) + l;
			long gesamtBis= Math.abs(randomBis.nextLong() % lg) + l;
				
				//System.out.println(Math.abs(random.nextLong() % lg) + l);
				
				//System.out.println(df.format(zufall.getTime()));	
				Random r = new Random();
				double randomGehalt=r.nextDouble();
				if (i % 2 == 1) {
				i++;
				if (gesamtVon < gesamtBis){
					zufallVon.setTimeInMillis(gesamtVon);
					zufallBis.setTimeInMillis(gesamtBis);
					writer.write("INSERT INTO trainer VALUES('" + i + "','" + randomGehalt +"','" +df.format(zufallVon.getTime())+"','"+df.format(zufallBis.getTime())+"');");
					writer.write(System.getProperty("line.separator"));

				}else{
					long temp = gesamtBis;
					long temp2 = gesamtVon;
					gesamtVon = temp;
					gesamtBis = temp2;
					zufallVon.setTimeInMillis(gesamtVon);
					zufallBis.setTimeInMillis(gesamtBis);
					writer.write("INSERT INTO trainer VALUES('" + i + "','" + randomGehalt +"','" +df.format(zufallVon.getTime())+"','"+df.format(zufallBis.getTime())+"');");
					writer.write(System.getProperty("line.separator"));
					
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Trainer t = new Trainer();
		t.trainer();
	}
}

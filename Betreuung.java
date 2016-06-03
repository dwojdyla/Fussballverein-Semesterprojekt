package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class Betreuung {
	FileWriter writer;
	File file;
	public void Betreuung(){
		
		
		
		

			//Erstellung des SQL Files
			file = new File("insertBetreuung.sql");	
			/*
			 * Ich setze mir das von & das bis Datum, anschließend hole ich mir 
			 * die Millisekunden der Daten und dann lass ich mir eine Random 
			 * Anzahl der Millisekunden mittels Random berechnen, die zwischen der 
			 * Anzahl der Millisekunden der beiden Daten liegt
			*/
			
			
			try {
				writer = new FileWriter(file, true);

			/*
			 * Nun schreibe ich mit per For-Schleife 100000 INSERTS in die SQL Datei.
			 * Mit der if, bekomme ich nur gerade Zahlen. 
			 */
			for (int i = 10000; i < 200000; i++) {
				if (i % 2 == 1) {
					i++;
					
			
				//System.out.println(Math.abs(random.nextLong() % lg) + l);
				
				//System.out.println(df.format(zufall.getTime()));	
				writer.write("INSERT INTO person VALUES ('"+i+"','','','','');");
				writer.write(System.getProperty("line.separator"));
				
				}
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	
}

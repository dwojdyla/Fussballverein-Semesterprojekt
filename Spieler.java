package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;


import wojdyla.TableViewSample.Position;

public class Spieler {
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
		
		double gehaltMin = 700;
		double gehaltMax = 30000;
		
	public void spieler(){
		//Erstellung des FIles
		file = new File("insertSpieler.sql");
		/*
		 * Ich setze mir das von & das bis Datum, anschließend hole ich mir 
		 * die Millisekunden der Daten und dann lass ich mir eine Random 
		 * Anzahl der Millisekunden mittels Random berechnen, die zwischen der 
		 * Anzahl der Millisekunden der beiden Daten liegt
		 */
		try {
			von.setTime(df.parse("1930-01-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bis.setTime(df.parse("2005-01-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Long l = von.getTimeInMillis();
		Long l1 = bis.getTimeInMillis();
		long lg = (l1 - l);
		try {
			writer = new FileWriter(file, true);
			/*
			 * Nun schreibe ich mit per For-Schleife 100000 INSERTS in die SQL Datei.
			 * Mit der if, bekomme ich nur gerade Zahlen. 
			 */
			
		
						for (int j=10000; j< 200000;j++){
							Random randomVon = new Random();
							Random randomBis = new Random();
							long gesamtVon= Math.abs(randomVon.nextLong() % lg) + l;
							long gesamtBis= Math.abs(randomBis.nextLong() % lg) + l;
							
							//System.out.println(Math.abs(random.nextLong() % lg) + l);
							
							//System.out.println(df.format(zufall.getTime()));	
							Random r = new Random();
							double randomGehalt=r.nextLong();
							if (j % 2 == 1) {
							j++;
							if (gesamtVon < gesamtBis){
								zufallVon.setTimeInMillis(gesamtVon);
								zufallBis.setTimeInMillis(gesamtBis);
					System.out.println("INSERT INTO spieler VALUES ('"+j+"','"+zufallsPosition()+"','"+randomGehalt+"','"+df.format(zufallVon.getTime())+"','"+df.format(zufallBis.getTime())+"');");
					writer.write(System.getProperty("line.separator"));
							}else{
								long temp = gesamtBis;
								long temp2 = gesamtVon;
								gesamtVon = temp;
								gesamtBis = temp2;
								zufallVon.setTimeInMillis(gesamtVon);
								zufallBis.setTimeInMillis(gesamtBis);
								writer.write("INSERT INTO spieler VALUES ('"+j+"','"+zufallsPosition()+"','"+randomGehalt+"','"+df.format(zufallVon.getTime())+"','"+df.format(zufallBis.getTime())+"');");
								writer.write(System.getProperty("line.separator"));
								
							}
							}
							
					
				 
				}	
			
	}catch (IOException e) {
		e.printStackTrace();
		}
			
	}//VOID
			
	/*
	 * Ich hab das mit der Position ein bisschen unprofessionell gelöst,
	 * da ich jetzt zB zu viele Tormänner habe. ich wüsste aber nicht wie 
	 * ich das Problem lösen soll		
	 */
	public enum position {
		Tormann, Verteidiger, Mittelfeldspieler, Stürmer
	}
	private static Position zufallsPosition() {
		int pick = new Random().nextInt(Position.values().length);
		return Position.values()[pick];
	}
	public static void main (String[]args){
	Spieler s = new Spieler();
	s.spieler();
	
	}
}
		

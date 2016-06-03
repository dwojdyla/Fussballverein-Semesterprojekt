package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;



public class Standort {
	FileWriter writer;
	File file;
	
	public void standort(){
		file = new File("insertStandort.sql");
		
		int postleitzahl[] = { 1010, 1020, 1030, 1040, 1050, 1060, 1070,
				1080, 1090, 1100, 1110, 1120, 1130, 1140, 1150, 1160, 1170,
				1180, 1190, 1200, 1210, 1220, 1230 };
		
			
			
		
		try {
			writer = new FileWriter(file, true);
			

			for (int i=10000; i < 100000; i++) {
					i++;
					int random = (postleitzahl[new Random()
					.nextInt(postleitzahl.length)]);
						writer.write("INSERT INTO standort VALUES ('"+i+"','land"+i+"','"+random+"','"+ zufallsOrt()+"');");
						writer.write(System.getProperty("line.separator"));
						
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public enum Ort{
		
			Vienna,
			Graz,
			Salzburg,
			Muenchen,
			Bremen,
			Wolfsburg,
			Hamburg,
			Zuerich,
			Basel,
			Genf,
			Amsterdam,
			Utrecht,
			Rotterdam
		
			
	}
	private static Ort zufallsOrt() {
		int pick = new Random().nextInt(Ort.values().length);
		return Ort.values()[pick];
	}
	public static void main(String [] args){
		Standort s = new Standort();
		s.standort();
	}
}

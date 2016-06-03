package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Mitglied {
	FileWriter writer;
	File file;
	
	double beitragMin = 20;
	double beitragMax = 40000;
	public void mitglied(){
		file = new File("insertMitglied.sql");

		try {
			writer = new FileWriter(file, true);

			for (int i = 1000; i < 200000; i++) {
				if (i % 2 == 1) {
					i++;

				
					Random r = new Random();
					double randomBeitrag=r.nextDouble();
					
					writer.write("INSERT INTO mitglied  VALUES "
							+ "('" + i + "','" + randomBeitrag + "');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[]args){
		Mitglied m = new Mitglied();
		m.mitglied();
	}
}

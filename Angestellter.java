package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Angestellter {	
	FileWriter writer;
	File file;
	Person p = new Person();
	
	public void angestellter(){
		//Neues File erstellen
		file = new File ("insertAngestellter.sql");
		
		
		try{
			writer = new FileWriter(file,true);
			
		for(int i=10000; i<200000; i++){
			if (i % 2 ==1){
				i++;
				/*Ich erstelle mir Random Werte, für den Gehalt und für die Überstunden
				 * Gehalt sollte double sein, aber ich lass es bei Int, damit die 
				 * Gehälter keine Kommastellen haben. 
				 * 
				*/
				int number = (int) ((Math.random() * (5000 - 800 + 1)) + 800);
				int ueberstunden = (int) ((Math.random() * (20 - 10 + 1)) + 10);
				
				writer.write("INSERT INTO angestellter VALUES ('"+i+"','"+number+"','"+ueberstunden+"','"+p.zufallsVorname()+"."+p.zufallsNachname()+"@verein.at');");
				writer.write(System.getProperty("line.separator"));

			}
		}
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
public static void main(String [] args){
	Angestellter a= new Angestellter();
	a.angestellter();
	}
}


package wojdyla;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import java.util.Random;


public class ZuffalsDatum {
	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar g = new GregorianCalendar();
		GregorianCalendar g1 = new GregorianCalendar();
		GregorianCalendar g2 = new GregorianCalendar();
		
		
		g.setTime(df.parse("1930-01-01"));
		g1.setTime(df.parse("2005-01-01"));
		

		Long l = g.getTimeInMillis();
		Long l1 = g1.getTimeInMillis();
		long lg = (l1 - l);
		
		//System.out.println(lg);
		Random random = new Random();
		for(int i = 0; i <5 ; i++){
			long gesamt= Math.abs(random.nextLong() % lg) + l;
			//System.out.println(Math.abs(random.nextLong() % lg) + l);
			g2.setTimeInMillis(gesamt);
			System.out.println(df.format(g2.getTime()));	
		}
		
		
		

	}
}

package wojdyla;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TableViewSample {
	FileWriter writer;
	File file;

	public void person() {
		file = new File("insertPerson.sql");
		int unten = 70;
		int oben = 99;
		int unten2 = 1;
		int oben2 = 12;
		int unten3 = 1;
		int oben3 = 31;

		try {
			writer = new FileWriter(file, true);

			for (int i = 10000; i < 100; i++) {
				if (i % 2 == 1) {
					int z = (int) ((Math.random() * (oben3 - unten3 + 1)) + unten3);
					int z2 = (int) ((Math.random() * (oben2 - unten2 + 1)) + unten2);
					int z3 = (int) ((Math.random() * (oben - unten + 1)) + unten);
					int x = i;
					x++;

					writer.write("INSERT INTO person (persnr, vname, nname, geschlecht, gebdat) VALUES "
							+ "('"
							+ x
							+ " '"
							+ "personvorname"
							+ x
							+ "', '"
							+ "personnachname"
							+ x
							+ "', '"
							+ zufallsGeschlecht()
							+ "', '"
							+ z
							+ "-"
							+ z2
							+ "-19" + z3 + ");");
					writer.write(System.getProperty("line.separator"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void standort() {

		file = new File("insertStandort.sql");

		try {
			writer = new FileWriter(file, true);
			int postleitzahl[] = { 1010, 1020, 1030, 1040, 1050, 1060, 1070,
					1080, 1090, 1100, 1110, 1120, 1130, 1140, 1150, 1160, 1170,
					1180, 1190, 1200, 1210, 1220, 1230 };

			for (int i = 1; i < 10; i++) {
				if (i % 2 == 1) {
					i++;
					for (int j = 0; j < postleitzahl.length; j++) {
						int random = (postleitzahl[new Random()
								.nextInt(postleitzahl.length)]);

						writer.write("INSERT INTO standort (sid, land, postleitzahlt, ort) VALUES "
								+ "('"
								+ i
								+ " ', "
								+ "'land"
								+ i
								+ "', '"
								+ random + "' " + "'ort" + i + "');");
						writer.write(System.getProperty("line.separator"));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void spieler() {
		file = new File("insertSpieler.sql");

		try {
			writer = new FileWriter(file, true);

			for (int i = 1000; i < 10; i++) {
				if (i % 2 == 1) {
					i++;

					// double gehalt = generator.nextDouble() * 20000.00;
					int number = (int) ((Math.random() * (20000 - 800 + 1)) + 800);
					// double gehalt= number/10.00;

					writer.write("INSERT INTO spieler (persnr, position, gehalt, von, bis) VALUES "
							+ "('"
							+ i
							+ "', '"
							+ zufallsPosition()
							+ "','"
							+ number + "', '" + i + "', " + "'ort" + i + "');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void angestellter() {
		file = new File("insertAngestellte.sql");

		try {
			writer = new FileWriter(file, true);

			for (int i = 1; i < 10; i++) {
				if (i % 2 == 1) {
					i++;
					int number = (int) ((Math.random() * (5000 - 800 + 1)) + 800);
					int ueberstunden = (int) ((Math.random() * (20 - 10 + 1)) + 10);

					writer.write("INSERT INTO angestellter (persnr, gehalt, ueberstunden, e_mail) VALUES "
							+ "('"
							+ i
							+ "', '"
							+ number
							+ "','"
							+ ueberstunden
							+ "', 'vorname.nachname" + i + "@verein.at');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void trainer() {
		file = new File("insertTraniner.sql");

		try {
			writer = new FileWriter(file, true);

			for (int i = 1000; i < 10; i++) {
				if (i % 2 == 1) {
					i++;

					// double gehalt = generator.nextDouble() * 20000.00;
					int number = (int) ((Math.random() * (20000 - 800 + 1)) + 800);
					// double gehalt= number/10.00;

					writer.write("INSERT INTO trainer (persnr, gehalt, von, bis) VALUES "
							+ "('" + i + "','" + number + "');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mitglied() {
		file = new File("insertMitglied.sql");

		try {
			writer = new FileWriter(file, true);

			for (int i = 1000; i < 10; i++) {
				if (i % 2 == 1) {
					i++;

					// double gehalt = generator.nextDouble() * 20000.00;
					int number = (int) ((Math.random() * (5000 - 0 + 1)) + 0);
					// double gehalt= number/10.00;

					writer.write("INSERT INTO mitglied (persnr,beitrag) VALUES "
							+ "('" + i + "','" + number + "');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void mannschaft() {
		file = new File("insertMannschaft.sql");
		int unten = 16;
		int oben = 20;
		int unten2 = 1;
		int oben2 = 12;
		int unten3 = 1;
		int oben3 = 31;
		try {
			writer = new FileWriter(file, true);

			for (int i = 1000; i < 10; i++) {
				if (i % 2 == 1) {
					i++;
					int z = (int) ((Math.random() * (oben3 - unten3 + 1)) + unten3);
					int z2 = (int) ((Math.random() * (oben2 - unten2 + 1)) + unten2);
					int z3 = (int) ((Math.random() * (oben - unten + 1)) + unten);

					// double gehalt = generator.nextDouble() * 20000.00;
					int number = (int) ((Math.random() * (5000 - 0 + 1)) + 0);
					// double gehalt= number/10.00;

					writer.write("INSERT INTO mannschaft (bezeichnung, klasse, naechstes_spiel) VALUES "
							+ "('mannschaft"
							+ i
							+ "',klasse"
							+ i
							+ "','"
							+ z
							+ "-" + z2 + "-20" + z3 + "');");
					writer.write(System.getProperty("line.separator"));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public enum Position {
		Tormann, Verteidiger, Mittelfeldspieler, Stürmer
	}

	/*
	 * public enum Name{ Georg, Jakob, Fritz, Dominik, Lorennz, Matthias,
	 * Alexander, Michael, Phillip, Marco, Simon, Bennedikt, Paul, Stefan,
	 * 
	 * }
	 */

	public enum Spiel {
		Sieg, Niederlage, Unentschieden
	}

	public enum Geschlecht {
		M, W, N
	}

	private static Position zufallsPosition() {
		int pick = new Random().nextInt(Geschlecht.values().length);
		return Position.values()[pick];
	}

	private static Geschlecht zufallsGeschlecht() {
		int pick = new Random().nextInt(Geschlecht.values().length);
		return Geschlecht.values()[pick];

	}

	public static void main(String[] args) {
		TableViewSample t = new TableViewSample();
		t.person();
		t.standort();
		t.spieler();
		t.angestellter();
		t.trainer();
		t.mitglied();
		t.mannschaft();
	}
}

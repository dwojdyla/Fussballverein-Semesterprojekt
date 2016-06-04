package wojdyla;


import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class connectDatabase {
private Connection conn;
private PGSimpleDataSource d;


public DBConnect() {
	d = new PGSimpleDataSource();
	d.setServerName("192.168.0.28");
	d.setDatabaseName("fussballverein");
	d.setUser("root");
	d.setPassword("root");
	d.setPortNumber(5432);
}

/**
 * Hier verbinde ich mich mit der Datenbank
 */
public void verbinden() {
	try {
		conn = d.getConnection();
	} catch (SQLException e) {
		System.out.println("Konnte nicht verbunden werden!");
		e.printStackTrace(System.err);
	}
}


/**
 * Hier schließe ich die Verbindung
 */

public void schließeVerbindung() {
	try {
		conn.close();
	} catch (SQLException e) {
		System.out.println("Konnte die Connection nicht schließen!");
		e.printStackTrace(System.err);
	}
}
}

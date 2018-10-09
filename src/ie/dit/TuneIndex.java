package ie.dit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class TuneIndex {
	static String driver = "org.sqlite.JDBC";
	String url = "jdbc:sqlite:tunes.sqlite";
	private ArrayList<Tune> tunes = new ArrayList<Tune>();
	
	// static initializer, load when program loads, not when class being initialized
	static
	{
		try
		{
			Class.forName(driver);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Tune findClosest(String notes) {
		int minEd = Integer.MAX_VALUE;
		Tune closest = null;
		
		for (Tune t : tunes) {
			int ed = EditDistance.substringEditDistance(notes, t.getSearchKey());
			if (ed < minEd) {
				minEd = ed;
				closest = t;
			}
		}
		
		return closest;
	}
	
	public Tune[] findCloest(String transcription, int howMany) {
		// iterate over tune array list
		// calculate distance between transcription and tunes
		// put in new array list, sort the array list (Collections.sort)
		// copy the first howMany entries into an array
		// return the array
		ArrayList<Tune> matches = new ArrayList<Tune>();
		
		for (Tune t : tunes) {
			int ed = EditDistance.substringEditDistance(transcription, t.getSearchKey());
			t.setEd(ed);
			t.setConfidence(1.0f - (ed / (float) transcription.length()));
			matches.add(t);
		}
		
		Collections.sort(matches);
		
		Tune[] ret = new Tune[howMany];
		
		for (int i = 0; i < howMany; i++) {
			ret[i] = matches.get(i);
		}
		
		return ret;
	}
	
	public void loadTunes() {
		// ResultSet encapsulates the results of an SQL query
		ResultSet rs;
		
		// Try with resources, catch exceptions for closing resources after exception thrown
		// Connection encapsulates the database connection
		// PreparedStatment encapsulates the SQL statement 
		try (Connection c = DriverManager.getConnection(url);
				PreparedStatement ps = c.prepareStatement(
						"SELECT * FROM TuneIndex where source = ?")) // Prevent SQL Injection attacks, by not appending into the string
		{
			ps.setInt(1, 2); // Set the ? parameter. Indexed from 1
			rs = ps.executeQuery(); // Result of query
			// The rs.next return boolean if there are any rows (same as while row = sql.getRow()..... etc in PHP)
			// Iterate over results
			while (rs.next()) {
				//System.out.println(rs.getString("title"));
				tunes.add(new Tune(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printTunes() {
		for (Tune t : tunes) {
			System.out.println(t);
		}
	}
}

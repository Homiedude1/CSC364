package homework2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Disaster_Relief {

		

		public static void main(String[] args) throws SQLException{
			Connection conn;
			ResultSet rs;
			Statement stmt;
			String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
			String user = "csc254";
			String password = "age126";
			String queryString = "SELECT city, region, country, latitude, longitude FROM cities WHERE longitude > 50 & longitude < 106 LIMIT 40";
			ArrayList<Object> Tables = new ArrayList<Object>();
			
				conn = DriverManager.getConnection(host,user,password);
				if(conn==null)
					System.out.println("connection failed");
				else{
					System.out.println("connection successfull");
				stmt = conn.createStatement();
				stmt.execute(queryString);
				rs = stmt.executeQuery(queryString);
				ResultSetMetaData rsMetaData = rs.getMetaData();				
				int numberOfColumns = rsMetaData.getColumnCount();
				System.out.println("Number of columns: " + numberOfColumns);
				for(int i = 1; i <=numberOfColumns; i++){
					System.out.printf("Column %2d: %s (%s) \n",i,
						rsMetaData.getColumnName(i),
						rsMetaData.getColumnTypeName(i));
				}
				while(rs.next()){
					String name = rs.getString(1);
					String region = rs.getString(2);
					String country = rs.getString(3);
					double latitude = rs.getDouble(4);
					double longitude = rs.getDouble(5 );
					Place place = new Place(name,region,country,longitude,longitude );
					Tables.add(place);
				}
				System.out.println(Tables);
				}
				conn.close();	
				

				} 
				
			
//Class pulled from https://github.com/jasonwinn/haversine All Credit assigned to him

		
}
	


class Harversine{
	private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
	public static String distancehundred(double startLat, double startLong){
		double x = startLat;
		double y = startLong;
		while(Harversine.distance(startLat, startLong,x, y) < 101){
			x = x + .001;
			y = y + .001;

			if(Harversine.distance(startLat, startLong, x, y) >= 99.9 & Harversine.distance(startLat, startLong, x, y) <= 100.1){
				System.out.println(Harversine.distance(36.12, -86.67,x, y));
				String reHundred = x +"  " + y;				
				return reHundred;
			}
		}		
		
		return "Nope";
		
	}
    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {
    	
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
        
    }

    public static double haversin(double val) {
    	double miles = Math.pow(Math.sin(val / 2), 2) / 1.6;    	
        return miles ;
    }
    public static double ifCity() {
    	//if()
    	return 1;
    }
}


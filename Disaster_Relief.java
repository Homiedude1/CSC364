package homework2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Disaster_Relief {
		static Connection conn;
		static ResultSet rs;
		static Statement stmt;
		public static void main(String[] args){
			String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
			String user = "csc254";
			String password = "age126";
			String queryString = "SELECT city, region, country, latitude, longitude From cities where longitude < 0. Limit 25";
			
			try{
				conn = DriverManager.getConnection(host,user,password);
				if(conn==null)
					System.out.println("connection failed");
				else
					System.out.println("connection successfull");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(queryString);
				ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();
				System.out.println("Number of columns: " + numberOfColumns);
				for(int i = 1; i <=numberOfColumns; i++){
					System.out.printf("Column %2d: %s (%s) \n",i,
						rsMetaData.getColumnName(i));
						rsMetaData.getColumnClassName(i);
				}
				conn.close();
				
				while(rs.next()){
					String country = rs.getString(columnLabel:"country");
					String name = rs.getString(columnIndex " city");
					String region = rs.getString(columnLabel "region");
					double lat = rs.getDouble(columnLabel: " latitude");
					
					
				}

			}
			
}

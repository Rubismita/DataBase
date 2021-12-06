package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
		private static String driver="com.mysql.cj.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/rubismita";
		private static String user="root";
		private static String password="rubismita#20";
		
		
		public static void main(String[] args) {
			
			
			try {
				//Step -1 Load the driver 
				Class.forName(driver);
				
				//Step-2 Create database Connection
				Connection connection = DriverManager.getConnection(url, user, password);
				
				//Step-3 Create query statement
				String query="Insert into new_table values(13,'Keerti',222)";
				
				Statement statement = connection.createStatement();
				
				//Step-4 Execute Query
				int status=statement.executeUpdate(query);
				
				System.out.println(status+" record saved into database table");
				
				//Step-5 Close the database Connection
				connection.close();
				
			}
			
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}



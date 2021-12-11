package DatabaseOperations;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchDataFromDB
{
    private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/rubismita_satapathy";
	private static String user="root";
	private static String password="rubismita#20";
          public static void main(String[] args)
		 {
     
		
           try {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


                //Step -1 Load the driver 
				Class.forName(driver);

				//Step-2 Create database Connection
				Connection connection = DriverManager.getConnection(url, user, password);

				//Step-3 Create query statement
				String query=" select * from student_details";

				PreparedStatement ps= connection.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();

				//Step-4 Execute Query
			while (rs.next())
			{
				System.out.println(rs.getInt(1) + "  " + rs.getString(2)+"  " + rs.getString(3));
			}
				
				

				//Step-5 Close the database Connection
				connection.close();

			}

			catch (Exception e) {

				e.printStackTrace();
			}
		}
}


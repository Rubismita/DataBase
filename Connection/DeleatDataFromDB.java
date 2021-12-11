package DatabaseOperations;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleatDataFromDB
{
    private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/rubismita_satapathy";
	private static String user="root";
	private static String password="rubismita#20";
          public static void main(String[] args)
		 {
            int S_ID;
			
           try {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter StudentID: ");
				S_ID=Integer.parseInt(br.readLine());
                
                //Step -1 Load the driver 
				Class.forName(driver);

				//Step-2 Create database Connection
				Connection connection = DriverManager.getConnection(url, user, password);

				//Step-3 Create query statement
				String query="Delete from student_details where S_ID = ?";

				PreparedStatement ps= connection.prepareStatement(query);

				ps.setInt(1, S_ID);
		

				//Step-4 Execute Query
				int status=ps.executeUpdate();

				System.out.println(status+" record deleted from database table");

				//Step-5 Close the database Connection
				connection.close();

			}

			catch (Exception e) {

				e.printStackTrace();
			}
		}
}



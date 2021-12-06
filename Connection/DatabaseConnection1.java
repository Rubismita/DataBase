package DB;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;


	public class DatabaseConnection1{

		private static String driver="com.mysql.cj.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/rubismita";
		private static String user="root";
		private static String password="rubismita#20";
		
		
		public static void main(String[] args) {
			
			int id;
			String name;
			int number;
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("Enter ID: ");
				id=Integer.parseInt(br.readLine());
				
				
				System.out.println("Enter Name: ");
				name=br.readLine();
				
				System.out.println("Enter Number: ");
				number=Integer.parseInt(br.readLine());
				
				//Step -1 Load the driver 
				Class.forName(driver);
				
				//Step-2 Create database Connection
				Connection connection = DriverManager.getConnection(url, user, password);
				
				//Step-3 Create query statement
				String query="Insert into new_table values(?,?,?)";
				
				PreparedStatement ps= connection.prepareStatement(query);
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, number);
				
				//Step-4 Execute Query
				int status=ps.executeUpdate();
				
				System.out.println(status+" record saved into database table");
				
				//Step-5 Close the database Connection
				connection.close();
				
			}
			
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}

	}



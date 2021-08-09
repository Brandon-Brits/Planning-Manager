import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager
{
	private Connection connect;
	String filename = (new File("PlanningManager.accdp")).getAbsolutePath();
	private Object UpcomingSupply;
//Connect To DB
	public DatabaseManager(){
		try{
//Connection
			connect = DriverManager.getConnection("jbdc:ucanaccess://" + filename);
			System.out.println("Connected.");
			}
		catch (SQLException e){
			System.out.println("Could Not Connect: " + e);
			}
		}
	
//Create a new Sales Order

	public void Insert(String sonum, String Pump, String Customer, String Suction, String Delivery, String Chamber, String BRGDE, String BRGNDE, String BalCH, String Shaft, String Simp) throws SQLException{
		Statement statement = connect.createStatement();
		String query = "Insert Into Table(SalesOrder, Pump, Customer, SuctionCover, DeliveryCover, Chamber, BearingHousingDE, BearingHousingNDE, BalanceChamber, Shaft, SuctionImpeller)\n" + "Values " + "('" + sonum + "', '" + Pump + "', '" + Customer + "', '" + Suction + "', '" + Delivery + "', '" + Chamber + "', '" + BRGDE + "', '" + BRGNDE + "', '" + BalCH + "', '" + Shaft + "', '" + Simp + "')";

		System.out.println(query);
		statement.executeUpdate(query);

		}
	public void Finalize(String SalesOrder) throws SQLException{
		String num = SalesOrder;
		Statement statement = connect.createStatement();
		String query = "INSERT INTO TABLE * FROM tblCurrentProject WHERE Sales Order = " +num;
		System.out.println(query);
		statement.executeUpdate(query);
     		}
	
	public void Update(String column, String update, int PID) throws SQLException{
		Statement statement = connect.createStatement();
		String  query = "UPDATE tblCurrentProject Set "+column+" = '"+update+"' WHERE SalesOrder = "+PID+";";
		System.out.println(query);
		statement.executeUpdate(query);
	}

}

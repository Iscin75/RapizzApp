package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAO  {

	protected DAOConnector connector;
	public static DAO me;

	public DAO()
	{
		this.connector = DAOConnector.getConnection();
	}
	
	public ResultSet query(String query) throws SQLException{
		System.out.print( query );
		return connector.query(query);
	}
	
}

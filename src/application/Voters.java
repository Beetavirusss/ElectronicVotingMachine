package application;
import java.sql.SQLException;

public class Voters {

	@SuppressWarnings("unused")
	private String CNIC;
	@SuppressWarnings("unused")
	private String Name;
	@SuppressWarnings("unused")
	private int Age;
	@SuppressWarnings("unused")
	private String Address;
	private static PersHand obj;
	
	
	Voters()
	{
		CNIC="";
		Name="";
		Age=18;
		Address="";
		obj=new MySQL();
	}
	
	public void addVoter(String c, String n, int a, String add) throws ClassNotFoundException, SQLException
	{
		obj.addVoter(c, n, a, add);
	}
	
	
	public boolean castVote(String n) throws ClassNotFoundException, SQLException
	{
		return obj.castVote(n);
		
	}
	
	
}

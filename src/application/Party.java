package application;
import java.sql.SQLException;

public class Party {

	private String Name;
	
	private static PersHand PersHandObject;
	
	Party()
	{
		Name="";
	}
	
	
	public String getName()
	{
		return this.Name;
	}
	
	
	public void add(String n) throws ClassNotFoundException, SQLException
	{
		PersHandObject=new MySQL();
		PersHandObject.addParty(n);
	}
}

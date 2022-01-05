package application;
import java.sql.SQLException;

public class Candidate {

	private String CNIC;
	private String Name;
	private int Votes;
	private Party CandidateParty;
	private String Area;
	private static PersHand PersHandObject;
	
	Candidate()
	{
		CNIC="";
		Name="";
		Votes=0;
		Area="";
	}
	
	
	
	public String getCNIC()
	{
		return this.CNIC;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public int getVotes()
	{
		return this.Votes;
	}
	
	public String getPartyName()
	{
		return this.CandidateParty.getName();
	}
	
	public String getArea()
	{
		return this.Area;
	}
	

	
	public void add(String c, String n, int v, String p, String a ) throws ClassNotFoundException, SQLException
	{
		PersHandObject=new MySQL();
		PersHandObject.addCandidate(c,n,v,p,a);
	}
}

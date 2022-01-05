package application;
import java.sql.*;
class MySQL extends PersHand{
	
	public boolean addCandidate(String c, String n, int v, String p,String a) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Candidate(CNIC,Name,Votes,Party,Area) VALUES(?,?,?,?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,c);
		statement.setString(2, n);
		statement.setInt(3, v);
		statement.setString(4,p);
		statement.setString(5,a);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			return true;
		}
		return false;
	}

	public boolean addParty(String n) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Party(Name) VALUES(?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,n);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			return true;
	
		}
		
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean castVote(String n) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
	//	PreparedStatement pstmt=con.prepareStatement("select* from Candidate Where Name=?");
		//pstmt.setString(1,n);
		//ResultSet rs=pstmt.executeQuery();
		String selectSql = "SELECT * FROM Candidate";
		Statement statement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = statement.executeQuery(selectSql);
		
		
		while(rs.next())
		{
			String temp=rs.getString("Name");
			if (temp.compareToIgnoreCase(n)==0)
			{
				int newcount=rs.getInt(3)+1;
				rs.updateDouble(3, newcount);
				rs.updateRow();
				return true;
			}
		}
		return false;
	}
	
	public boolean addVoter(String c, String n, int a, String add) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Voters(CNIC,Name,Age,Address) VALUES(?,?,?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,c);
		statement.setString(2, n);
		statement.setInt(3, a);
		statement.setString(4,add);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			return true;
		}
		return false;
	}
	
	public String showCandidates() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select Name, Party,Area from Candidate");
		String result="";
		
		while(rs.next())
		{
			result+=rs.getString(1)+"          "+rs.getString(2)+"          "+rs.getString(3)+"\n";
		}
		return result;
	}


	public String displayresults() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select* from Candidate");
		String result="";
		while(rs.next())
		{
			result+=rs.getString(2)+"\n"+rs.getString(4)+"    "+rs.getString(3)+" Votes"+"    "+rs.getString(5)+"\n\n";
		}
		
		return result;
	}
	
}
package application;
import java.sql.SQLException;

public abstract class PersHand {

	PersHand() {
	}
	abstract public boolean addCandidate(String c, String n, int v,String p,String a) throws ClassNotFoundException, SQLException;
	abstract public boolean addParty(String n) throws SQLException, ClassNotFoundException;
	abstract public boolean addVoter(String c, String n, int a, String add) throws ClassNotFoundException, SQLException;
	abstract public boolean castVote(String n) throws ClassNotFoundException, SQLException;
	abstract public String showCandidates() throws ClassNotFoundException, SQLException;
	abstract public String displayresults() throws ClassNotFoundException, SQLException;
	
	
	
}
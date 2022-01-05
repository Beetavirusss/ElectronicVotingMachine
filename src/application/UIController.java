package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UIController {
	
	
	PersHand obj= new MySQL();
	
	@FXML
	private Button htv;
	
	@FXML
	private Button party;
	
	@FXML
	private Button Submit;
	
	@FXML
	private TextField partyname;
	
	@FXML
	private TextField ccnic;
	
	@FXML
	private TextField cname;
	
	@FXML
	private TextField cparty;
	
	@FXML
	private TextField carea;
	
	@FXML
	private TextField vcnic;
	
	@FXML
	private TextField vname;
	
	@FXML
	private TextField vage;
	
	@FXML
	private TextField vadd;
	
	@FXML
	private TextField candnametovote;
	
	
	@FXML
	public void InfoHandle(ActionEvent Event)
	{
		try
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Info.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("How to Vote");
			stage.setScene(new Scene(root_one));
			stage.show();
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void PartyHandle(ActionEvent Event)
	{
		try
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PartyUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add a Party");
			stage.setScene(new Scene(root_one));
			stage.show();
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void PartySubmit(ActionEvent Event) throws IOException
	{
		try
		{
			
			String s="";
			s=partyname.getText();
			if(obj.addParty(s))
			{
			
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PartyNameAddedUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Party Added");
			stage.setScene(new Scene(root_one));
			stage.show();
			}
			
			else
			{
				FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PartyNameAddedFailUI.fxml"));
				Parent root_one = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Party Already Added");
				stage.setScene(new Scene(root_one));
				stage.show();
			}
		}catch(Exception e)
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PartyNameAddedFaildUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Vote Casted");
			stage.setScene(new Scene(root_one));
			stage.show();
			e.printStackTrace();
		}
	}
	
	@FXML
	public void CandHandle(ActionEvent Event)
	{
		try
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("CandidateUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add a Candidate");
			stage.setScene(new Scene(root_one));
			stage.show();
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void CandSubmit(ActionEvent Event)
	{
		try
		{
			
			String cnic=ccnic.getText();
			String name=cname.getText();
			String party=cparty.getText();
			String area=carea.getText();
			if(obj.addCandidate(cnic, name, 0, party, area))
			
			{
			
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("CandidateAddedUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Party Added");
			stage.setScene(new Scene(root_one));
			stage.show();
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void VoterHandle(ActionEvent Event)
	{
		try
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("VoterUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add your information Voter");
			stage.setScene(new Scene(root_one));
			stage.show();
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@FXML
	public void VoterSubmit(ActionEvent Event)
	{
		try
		{
			
			String cnic=vcnic.getText();
			String name=vname.getText();
			String agee=vage.getText();
			String address=vadd.getText();
			 Integer stringtoInteger = Integer.parseInt(agee);
			int age=stringtoInteger.intValue();
			if(age>=18)
			{
				if(obj.addVoter(cnic, name, age, address))
				
				{
				
					FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("VoterAddedUI.fxml"));
					Parent root_one = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle("Cast your Vote");
					stage.setScene(new Scene(root_one));
					String cands=obj.showCandidates();
					stage.setUserData(cands);
					stage.show();
					
				}
				
			}
			
			else if(age<18)
			{
				FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("VoterBelow18UI.fxml"));
				Parent root_one = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Party Added");
				stage.setScene(new Scene(root_one));
				stage.show();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void VoteCasted(ActionEvent Event)
	{
		try
		{
			String candname=candnametovote.getText();
			if(obj.castVote(candname))
			{
			
			
				FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("VoteSubmittedUI.fxml"));
				Parent root_one = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Vote Casted");
				stage.setScene(new Scene(root_one));
				stage.show();
			}	
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void ResultsHandle(ActionEvent Event) throws IOException
	{
		try
		{
			

		       
			String res="RESULTS OF THE ELECTION\n\n______________________________________________________________________________\n\n";
			res+=obj.displayresults();
			Text text= new Text();
			text.setX(150); 
		    text.setY(100); 
		    text.setScaleX(1.5);
		    text.setScaleY(1.5);
		    Group root = new Group(text);   
			text.setText(res);
			Stage stage = new Stage();
			stage.setTitle("Results");
			stage.setScene(new Scene(root,900,700));
			stage.show();
			
	
		}catch(Exception e)
		{
			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PartyNameAddedFaildUI.fxml"));
			Parent root_one = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Vote Casted");
			stage.setScene(new Scene(root_one));
			stage.show();
			
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void ExitHandle(ActionEvent Event)
	{
		try
		{
			System.exit(0);
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}


package Models;

import javax.persistence.Id;

import play.db.ebean.Model;


public class Team extends Model
{
	@Id
	public Long id;
	public String teamName;
	public Double accBalance=150000.00D;
	
	public Team() {
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", accBalance="
				+ accBalance + "]";
	}

	//initializing the constructor
 	public Team (String teamName, Double accBalance)
 	{
 		this.teamName=teamName;
 		this.accBalance=accBalance;
 	}
 	
	public static Model.Finder<Long, Team> find = new 
			Model.Finder<Long,Team>(Long.class, Team.class);

		public static void updateBalance(String teamIn)
 		{
			
			String teamName="";
			teamName=teamIn;
			
 			Team team= find.where()
 					.eq("teamName", teamName)
 					.findUnique();
 			team.accBalance+=110.0;
 			team.save();
 			
 			if (teamName.toUpperCase().equals("SIMBA")) 
				teamName="YANGA";
 			else
 				teamName="SIMBA";
		
 			Team opponnent=find.where()
 					.eq("teamName", teamName)
 					.findUnique();
 			opponnent.accBalance-=110.00;
 			opponnent.save();
 			
 		}
 		

}

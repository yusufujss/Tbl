package Models;
import java.util.*;
import java.lang.*;

import com.sun.xml.internal.bind.v2.runtime.Name;
public class Team extends Models 
{
public String teamName;
public int creditor, debitor;
public Double accBalanceYanga, accBalanceSimba;

 	//initializing the constructor
 	public Team (String teamName, int creditor, debitor, Double accBY, accBS)
 	{
 		teamName=name;
 		this.creditor= creditor;
 		this.debitor= deditor;
 		accBalanceYanga= accBY;
 		accBalanceSimba= accBS;
 	}
 		public static void findByTeamName()
 		{
 			Code codes = new Code("XYZ123");
 			for (Code code:codes)
 			{//need to iterate in the database until ALL names are read
 				if (teamName equals("YANGA")
 				{
 				//populate yanga list
 					code.retrieve();
 				}
 				else 
 				{
 					//populate simba list
 					code.retrieve();
 				}
 			}
 		}
 		public static void findAll()
 		{
 			//fetch all from the database
 		}
 		
 		public static void teamBalance()
 		{
 			accBalanceSimba= 50000000;
 			accBalanceYanga= 50000000;
 			// Iterate in all database entry
 			if (teamName equals("YANGA"))
 			{
 				accBalanceYanga += 110;
 				accBalanceSimba -= 110;
 			}
 			else
 			{
 				accBalanceSimba += 110;
 				accBalanceSimba -= 110;
 			}
 				
 			
 		}
}

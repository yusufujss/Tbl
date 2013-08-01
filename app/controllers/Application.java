package controllers;
	
import Models.AddressBook;
import Models.TblCode;
import Models.Team;
import play.*;
import play.mvc.*;
import views.html.*;
	
	public class Application extends Controller {
	  
	    public static Result index() {
	        return ok();
	      //index.render("TANZANIA BREWERIES LIMITED."
	    }
	    
	    public static Result message(String newSms)
	    {
	    	//recieve in sms
	    	String sms= newSms;
	    	String code="";
	    	String teamSelect="";
	    	
	    	//InSms inSms= new InSms();
	    	sms= sms.trim().toUpperCase();
	    	TblCode tblCode= new TblCode();
	    	//AddressBook addressBook= new AddressBook();
	    	//Team team =new Team();
	    	code= sms.substring(0, 4);
	    	if (TblCode.validateCode(code) !=null)
	    	{
	    		if (tblCode.status.equals("ACTIVE")== true)
	    		{
	    		   TblCode.updateCode(code,"INACTIVE" );
	    		   int i= sms.lastIndexOf(" ");
	    		   if (i != -1)
	    			   teamSelect= sms.substring(i+1);
	    		   else
	    			   teamSelect= sms.substring(5);
	    		   // assuming the number is available
	    		   String phoneNumber="";
	    		  // increment contribution count
	    		   AddressBook.contributionCounter(phoneNumber);
	    		   // check whether its yanga or simba contribution
	    		   if( teamSelect.equals("SIMBA"))
	    			   AddressBook.simbaCounter();
	    		   else
	    			   AddressBook.yangaCounter();
	    		   Team.updateBalance(teamSelect);
	    		   AddressBook.saveUser();
//	    		   return ok (message.render("HONGERA TIMU YAKO YA" + teamSelect + "INA TSHS" + team.accBalance));
	    		return ok();
	    		}
	    		
	    		else
	    			//return ok (message.render("NAMBA ULIYOTUMA IMEKWISHA TUMIKA, ENDELEA KUNYWA BIA USHINDE ZAIDI"));
	    		return ok();
	    	}
	    	
	    	else 
	    		//return ok(message.render("NAMBA ULIYOTUMA HAIPO"));
	    		return ok();
	    }
	    
	    public static Result report()
	    {
	    	return TODO;
	    }
	  
	}

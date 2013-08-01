package Models;

import java.util.List;

import javax.persistence.Id;

import play.db.ebean.Model;

public class AddressBook extends Model
{
	@Id
	public int id;
	public int contributionCount;
	public String msisdn;
	public int yangaVote;
	public int simbaVote;
	public String teamName;
	
	
	
	public AddressBook() {
		super();
		// TODO Auto-generated constructor stub
	}

		public AddressBook(int id, int contributionCount, String msisdn,
			int yangaVote, int simbaVote, String teamName) {
		super();
		this.id = id;
		this.contributionCount = contributionCount;
		this.msisdn = msisdn;
		this.yangaVote = yangaVote;
		this.simbaVote = simbaVote;
		this.teamName = teamName;
	}


		// database virus
		public static Model.Finder<Long, AddressBook> find = new 
				Model.Finder<Long,AddressBook>(Long.class, AddressBook.class);
	
		public static void saveUser()
		{
			AddressBook addressBook =new AddressBook();
			addressBook.save();
		}
	
		public static List<AddressBook> retrieveAll()
		{
			List<AddressBook> addressBook= AddressBook.find.findList();
			return addressBook;
		}
		
		public static List<AddressBook> retrieveByTeamName(String name)
		{
			String teamName= name;
			List<AddressBook> addressBook= find.where()
					.eq("teamName",teamName )
					.findList();
			return addressBook;
		}
		
		public static void contributionCounter(String phone)
		{
			String phoneNumber= phone;
			AddressBook addressBook= new AddressBook();
			List<AddressBook> addressBookPhone= find.where()
					.eq("msisdn",phoneNumber )
					.findList();
			if (addressBookPhone !=null)
				addressBook.contributionCount += 1;
			else
				addressBook.contributionCount =1;
				addressBook.msisdn= phoneNumber;
			
		}
	
		public static void yangaCounter()
		{
			AddressBook addressBook= new AddressBook();
			addressBook.yangaVote += 1;	
		}
		
		public static void simbaCounter()
		{
			AddressBook addressBook= new AddressBook();
			addressBook.simbaVote += 1;	
		}

		@Override
		public String toString() {
			return "AddressBook [id=" + id + ", contributionCount="
					+ contributionCount + ", msisdn=" + msisdn + ", yangaVote="
					+ yangaVote + ", simbaVote=" + simbaVote + ", teamName="
					+ teamName + "]";
		}
		
}

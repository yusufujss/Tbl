package Models;

import java.util.List;

import javax.persistence.Id;

import play.db.ebean.Model;

public class TblCode extends Model
{
	@Id
	public long id;
	public String code;
	public String status="Active";
	
	public TblCode(long id, String code, String status) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
	}

	public TblCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	// database virus
	public static Model.Finder<Long, TblCode> find = new 
			Model.Finder<Long,TblCode>(Long.class, TblCode.class);

	public static TblCode validateCode(String userCode)
	{
		
		String code= userCode;
		TblCode tblCode= find.where()
					.eq("code",code )
					.findUnique();
		return tblCode;
	}
	
	public static void updateCode(String newCode, String newStatus)
	{
		TblCode tblCode= new TblCode();
		tblCode.code= newCode;
		tblCode.status= newStatus;
		tblCode.save();
		
	}
	
	public static List<TblCode> retrieveAll()
	{
		//return all codes
		List<TblCode> code = TblCode.find.findList();
		return code;
		
	}
	
	public static List<TblCode> retrieveByStatus (String codeStatus)
	{
		// return code which are either ACTIVE or INACTIVE
		String status= codeStatus;
		List<TblCode> tblCode= find.where()
					.eq("status",status )
					.findList();
		return tblCode;
	}

	@Override
	public String toString() {
		return "TblCode [id=" + id + ", code=" + code + ", status=" + status
				+ "]";
	}
	
	
}

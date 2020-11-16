package dto;

public class CartDTO {
	private String cpid;
	private String cmid;
	private String cpfilename;
	private String cpsize;
	private int cpbnum;
	private int cpprice;
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getCmid() {
		return cmid;
	}
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}
	public String getCpfilename() {
		return cpfilename;
	}
	public void setCpfilename(String cpfilename) {
		this.cpfilename = cpfilename;
	}
	public String getCpsize() {
		return cpsize;
	}
	public void setCpsize(String cpsize) {
		this.cpsize = cpsize;
	}
	public int getCpbnum() {
		return cpbnum;
	}
	public void setCpbnum(int cpbnum) {
		this.cpbnum = cpbnum;
	}
	public int getCpprice() {
		return cpprice;
	}
	public void setCpprice(int cpprice) {
		this.cpprice = cpprice;
	}
	public CartDTO(String cpid, String cmid, String cpfilename, String cpsize, int cpbnum, int cpprice) {
		super();
		this.cpid = cpid;
		this.cmid = cmid;
		this.cpfilename = cpfilename;
		this.cpsize = cpsize;
		this.cpbnum = cpbnum;
		this.cpprice = cpprice;
	}
	public CartDTO() {
		
	}
	@Override
	public String toString() {
		return "CartDTO [cpid=" + cpid + ", cmid=" + cmid + ", cpfilename=" + cpfilename + ", cpsize=" + cpsize
				+ ", cpbnum=" + cpbnum + ", cpprice=" + cpprice + "]";
	}

}

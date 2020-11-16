package dto;

public class ProductDTO {
	private String pid;
	private String pname;
	private int pprice;
	private String pcontents;
	private String pgender;
	private int pquantity;
	private int phits;
	private String pfilename;
	private String pdate;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public String getPgender() {
		return pgender;
	}
	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getPhits() {
		return phits;
	}
	public void setPhits(int phits) {
		this.phits = phits;
	}
	public String getPfilename() {
		return pfilename;
	}
	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public ProductDTO(String pid, String pname, int pprice, String pcontents, String pgender, int pquantity, int phits,
			String pfilename, String pdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pcontents = pcontents;
		this.pgender = pgender;
		this.pquantity = pquantity;
		this.phits = phits;
		this.pfilename = pfilename;
		this.pdate = pdate;
	}
	public ProductDTO() {
		
	}
	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pcontents=" + pcontents
				+ ", pgender=" + pgender + ", pquantity=" + pquantity + ", phits=" + phits + ", pfilename=" + pfilename
				+ ", pdate=" + pdate + "]";
	}

}

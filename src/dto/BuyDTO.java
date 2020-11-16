package dto;

public class BuyDTO {
	private int bnum;
	private String bmid;
	private String bpid;
	private String bfilename;
	private String bpname;
	private String bsize;
	private int bquantity;
	private int bpprice;
	private String bdate;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getBpid() {
		return bpid;
	}
	public void setBpid(String bpid) {
		this.bpid = bpid;
	}
	public String getBfilename() {
		return bfilename;
	}
	public void setBfilename(String bfilename) {
		this.bfilename = bfilename;
	}
	public String getBpname() {
		return bpname;
	}
	public void setBpname(String bpname) {
		this.bpname = bpname;
	}
	public String getBsize() {
		return bsize;
	}
	public void setBsize(String bsize) {
		this.bsize = bsize;
	}
	public int getBquantity() {
		return bquantity;
	}
	public void setBquantity(int bquantity) {
		this.bquantity = bquantity;
	}
	public int getBpprice() {
		return bpprice;
	}
	public void setBpprice(int bpprice) {
		this.bpprice = bpprice;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public BuyDTO(int bnum, String bmid, String bpid, String bfilename, String bpname, String bsize, int bquantity,
			int bpprice, String bdate) {
		super();
		this.bnum = bnum;
		this.bmid = bmid;
		this.bpid = bpid;
		this.bfilename = bfilename;
		this.bpname = bpname;
		this.bsize = bsize;
		this.bquantity = bquantity;
		this.bpprice = bpprice;
		this.bdate = bdate;
	}
	public BuyDTO() {
		
	}
	@Override
	public String toString() {
		return "BuyDTO [bnum=" + bnum + ", bmid=" + bmid + ", bpid=" + bpid + ", bfilename=" + bfilename + ", bpname="
				+ bpname + ", bsize=" + bsize + ", bquantity=" + bquantity + ", bpprice=" + bpprice + ", bdate=" + bdate
				+ "]";
	}


}

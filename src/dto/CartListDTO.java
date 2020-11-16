package dto;

public class CartListDTO {
	private String cpfilename;
	private String pname;
	private String cpsize;
	private int pprice;
	private int cpbnum;
	private int cpprice;
	private String pid;
	private String mid;
	private int mpoint;
	public String getCpfilename() {
		return cpfilename;
	}
	public void setCpfilename(String cpfilename) {
		this.cpfilename = cpfilename;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCpsize() {
		return cpsize;
	}
	public void setCpsize(String cpsize) {
		this.cpsize = cpsize;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public CartListDTO(String cpfilename, String pname, String cpsize, int pprice, int cpbnum, int cpprice, String pid,
			String mid, int mpoint) {
		super();
		this.cpfilename = cpfilename;
		this.pname = pname;
		this.cpsize = cpsize;
		this.pprice = pprice;
		this.cpbnum = cpbnum;
		this.cpprice = cpprice;
		this.pid = pid;
		this.mid = mid;
		this.mpoint = mpoint;
	}
	public CartListDTO() {
		
	}
	@Override
	public String toString() {
		return "CartListDTO [cpfilename=" + cpfilename + ", pname=" + pname + ", cpsize=" + cpsize + ", pprice="
				+ pprice + ", cpbnum=" + cpbnum + ", cpprice=" + cpprice + ", pid=" + pid + ", mid=" + mid + ", mpoint="
				+ mpoint + "]";
	}
}

package dto;

public class MemberDTO {
	private String mid;
	private String mpassword;
	private String mname;
	private String mbirth;
	private String malladdress;
	private String mpostnum;
	private String maddressroad;
	private String maddressjibun;
	private String maddress;
	private String maddress1;
	private String mphone;
	private String memail;
	private int mpoint;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMalladdress() {
		return malladdress;
	}
	public void setMalladdress(String malladdress) {
		this.malladdress = malladdress;
	}
	public String getMpostnum() {
		return mpostnum;
	}
	public void setMpostnum(String mpostnum) {
		this.mpostnum = mpostnum;
	}
	public String getMaddressroad() {
		return maddressroad;
	}
	public void setMaddressroad(String maddressroad) {
		this.maddressroad = maddressroad;
	}
	public String getMaddressjibun() {
		return maddressjibun;
	}
	public void setMaddressjibun(String maddressjibun) {
		this.maddressjibun = maddressjibun;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMaddress1() {
		return maddress1;
	}
	public void setMaddress1(String maddress1) {
		this.maddress1 = maddress1;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public MemberDTO(String mid, String mpassword, String mname, String mbirth, String malladdress, String mpostnum,
			String maddressroad, String maddressjibun, String maddress, String maddress1, String mphone, String memail,
			int mpoint) {
		super();
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mbirth = mbirth;
		this.malladdress = malladdress;
		this.mpostnum = mpostnum;
		this.maddressroad = maddressroad;
		this.maddressjibun = maddressjibun;
		this.maddress = maddress;
		this.maddress1 = maddress1;
		this.mphone = mphone;
		this.memail = memail;
		this.mpoint = mpoint;
	}
	public MemberDTO() {
		
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mbirth=" + mbirth
				+ ", malladdress=" + malladdress + ", mpostnum=" + mpostnum + ", maddressroad=" + maddressroad
				+ ", maddressjibun=" + maddressjibun + ", maddress=" + maddress + ", maddress1=" + maddress1
				+ ", mphone=" + mphone + ", memail=" + memail + ", mpoint=" + mpoint + "]";
	}
}

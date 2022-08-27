package modal;

public class Address {

	private int addid;
	private String contact;
	private String city;
	private String state;
	private String zip;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addid, String contact, String city, String state, String zip) {
		super();
		this.addid = addid;
		this.contact = contact;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getAddid() {
		return addid;
	}

	public void setAddid(int addid) {
		this.addid = addid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [addid=" + addid + ", contact=" + contact + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}

}

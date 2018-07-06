package kr.co.koscom.dto;

public class MemberDTO {
	public String id;
	public String name;
	public String password;
	public String email;

	public MemberDTO(){
		super();
	}

	public MemberDTO(String id, String name, String password, String email) {
		//super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MembersDTO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}

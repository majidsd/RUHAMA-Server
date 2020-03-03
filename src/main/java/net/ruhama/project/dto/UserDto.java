/**
 * 
 */
package net.ruhama.project.dto;

/**
 * @author ahmedozy
 *
 */
public class UserDto {

	private String fullName;
	private String username;
	private String password;
	private String password2;
	private String role;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String fullName, String username, String password, String password2, String role) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDto [fullName=" + fullName + ", username=" + username + ", password=" + password + ", password2="
				+ password2 + ", role=" + role + "]";
	}
	
	
}

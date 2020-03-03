/**
 * 
 */
package net.ruhama.project.dto;

/**
 * @author ahmedozy
 *
 */
public class AuthorityDto {

	private Integer id;
	private String authorityName;
	private String authorityDescription;
	
	
	
	public AuthorityDto(Integer id, String authorityName, String authorityDescription) {
		super();
		this.id = id;
		this.authorityName = authorityName;
		this.authorityDescription = authorityDescription;
	}
	public AuthorityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityDescription() {
		return authorityDescription;
	}
	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}
	@Override
	public String toString() {
		return "AuthorityDto [id=" + id + ", authorityName=" + authorityName + ", authorityDescription="
				+ authorityDescription + "]";
	}
	
	
}

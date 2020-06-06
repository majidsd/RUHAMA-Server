/**
 * 
 */
package net.ruhama.project.dto;

import java.util.Collection;

import net.ruhama.project.util.UserStatus;

/**
 * @author ahmedozy
 *
 */
public class UserProfileDto {

	private Integer id;
	private String fullName;
	private Integer phoneNumber;
	private Integer walletId;
	private UserStatus status;
	private Collection<AuthorityDto> authorities;
	
	 
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public Collection<AuthorityDto> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<AuthorityDto> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "UserProfileDto [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", walletId="
				+ walletId + ", status=" + status + ", authorities=" + authorities + "]";
	}

}

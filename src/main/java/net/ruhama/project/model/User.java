/**
 * 
 */
package net.ruhama.project.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.ruhama.project.util.UserStatus;

/**
 * @author ahmedozy
 *
 */
@Entity(name = "user")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7687315936258253938L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(nullable = true)
	private String username;
	
	@Column(nullable = true)
	private Integer phoneNumber;
	
	@Column(nullable = true)
	private String password;
	
	@OneToMany
	private Collection<Authority> authorities;
	
	@Column
	private UserStatus status;
	
	@Column(name="created_at", nullable = false)
	private Date created_at;
	
	@Column(name="last_update", nullable = true)
	private Date last_update;
	
	@Column
	private boolean enabled;
	
	public User() {
		this.created_at = new Date();
		this.last_update = new Date();
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
	
	

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAuthorities(Collection<Authority> authorities) {
		this.authorities = authorities;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
	

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Collection<Authority> getAuths() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return status != UserStatus.EXPIRED;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return status != UserStatus.LOCKED;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return status != UserStatus.CREDENTIAL_EXPIRED;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
	
}

/**
 * 
 */
package net.ruhama.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ahmedozy
 *
 */
@Getter @Setter @Entity(name = "user")
public class User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "full_name")
	private String fullName;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(name="created_at", nullable = false)
	private Date created_at;
	@Column(name="last_update", nullable = false)
	private Date last_update;
}

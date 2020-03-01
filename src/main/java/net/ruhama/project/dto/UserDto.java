/**
 * 
 */
package net.ruhama.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ahmedozy
 *
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDto {

	private String fullName;
	private String username;
	private String password;
	private String password2;
	private String role;
}

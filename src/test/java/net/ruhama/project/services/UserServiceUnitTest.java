/**
 * 
 */
package net.ruhama.project.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.ruhama.project.dto.UserDto;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IUserService;

/**
 * @author ahmedozy
 *
 */
@SpringBootTest
public class UserServiceUnitTest {
	@Autowired
	private IUserService userService;
	
	@Test
	public void addUserTest() {
		UserDto userDto = new UserDto("Ahmed Osman Wahbi", "ahmedozy", "password", "password", "admin");
		ObjectResponse<UserDto> response = userService.addUser(userDto);
		System.out.println(response);
	}
}

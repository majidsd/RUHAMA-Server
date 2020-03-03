/**
 * 
 */
package net.ruhama.project.services;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.ruhama.project.dto.AuthorityDto;
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
		UserDto userDto = new UserDto("Ahmed Osman Wahbi", "ahmedozy", "password", "password",  Arrays.asList(new AuthorityDto[] {new AuthorityDto(null,"admin","admin user")}));
		ObjectResponse<UserDto> response = userService.addUser(userDto);
		System.out.println(response);
	}
}

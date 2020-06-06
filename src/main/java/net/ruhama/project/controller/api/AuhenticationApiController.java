/**
 * 
 */
package net.ruhama.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ruhama.project.dto.OtpDto;
import net.ruhama.project.dto.UserProfileDto;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IUserAuthentication;

/**
 * @author ahmedozy
 *
 */
@RestController
public class AuhenticationApiController {

	@Autowired
	private IUserAuthentication userAuthentication;
	
	
	@PostMapping("/api/register")
	public ObjectResponse<OtpDto> register(@RequestBody OtpDto otpDto){
		System.out.println(otpDto);
		ObjectResponse<OtpDto> response = userAuthentication.register(otpDto);
		return response;
	}
	
	@PostMapping("/api/verifyAndLogin")
	public ObjectResponse<UserProfileDto> verifyAndLogin(@RequestBody OtpDto otpDto){
		System.out.println(otpDto);
		ObjectResponse<UserProfileDto> response = userAuthentication.verifyAndLogin(otpDto);
		System.out.println(response);
		return response;
	}
}

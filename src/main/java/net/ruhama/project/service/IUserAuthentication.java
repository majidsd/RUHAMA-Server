/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.OtpDto;
import net.ruhama.project.dto.UserProfileDto;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author ahmedozy
 *
 */
public interface IUserAuthentication {

	public ObjectResponse<OtpDto> register(OtpDto otpDto);
	public ObjectResponse<UserProfileDto> verifyAndLogin(OtpDto otpDto);
}

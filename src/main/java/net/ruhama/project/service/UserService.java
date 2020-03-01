/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.UserDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author ahmedozy
 *
 */
public interface UserService {
	public ObjectResponse<UserDto> addUser(UserDto user);
	public ObjectResponse<UserDto> updateUser(UserDto user);
	public ObjectResponse<UserDto> deleteUser(UserDto user);
	public ObjectResponse<UserDto> getUser(Integer userId);
	public ListResponse<UserDto> getAllUsers();

}

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
public interface IUserService {
	public ObjectResponse<UserDto> addUser(UserDto userDto);
	public ObjectResponse<UserDto> updateUser(UserDto userDto);
	public ObjectResponse<UserDto> deleteUser(UserDto userDto);
	public ObjectResponse<UserDto> getUser(Integer userId);
	public ListResponse<UserDto> getAllUsers();
	public ObjectResponse<UserDto> getUser(String username);

}

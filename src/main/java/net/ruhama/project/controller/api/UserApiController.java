/**
 * 
 */
package net.ruhama.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ruhama.project.dto.UserDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.serviceImp.UserService;

/**
 * @author ahmedozy
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public ListResponse<UserDto> getAllUsers(){
		ListResponse<UserDto> userDtos = userService.getAllUsers();
		return userDtos;
	}
	
	@GetMapping("/get")
	public ObjectResponse<UserDto> getUser(@PathVariable Integer userId){
		ObjectResponse<UserDto> response = userService.getUser(userId);
		return response;
	}
	
	@PostMapping("/save")
	public ObjectResponse<UserDto> saveUser(@RequestBody UserDto userDto){
		ObjectResponse<UserDto> response = userService.addUser(userDto);
		return response;
	}
	
	@DeleteMapping("/delete")
	public ObjectResponse<UserDto> deleteUser(@RequestBody UserDto userDto){
		ObjectResponse<UserDto> response = userService.deleteUser(userDto);
		return response;
	}
}

/**
 * 
 */
package net.ruhama.project.serviceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruhama.project.dto.UserDto;
import net.ruhama.project.model.User;
import net.ruhama.project.repo.UserRepository;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IUserService;

/**
 * @author ahmedozy
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mm;
	
	@Override
	public ObjectResponse<UserDto> addUser(UserDto userDto) {
		User userDao = mm.map(userDto, User.class);
		userDao = userRepo.save(userDao);
		userDto = mm.map(userDao, UserDto.class);
		return new ObjectResponse<UserDto>(100, "Success", userDto);
	}

	@Override
	public ObjectResponse<UserDto> updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResponse<UserDto> deleteUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResponse<UserDto> getUser(Integer userId) {
		User user = userRepo.getOne(userId);
		UserDto userDto = mm.map(user, UserDto.class);
		return new ObjectResponse<UserDto>(100, "Success", userDto);
	}

	@Override
	public ListResponse<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

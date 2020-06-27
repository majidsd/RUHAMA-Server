/**
 * 
 */
package net.ruhama.project.serviceImp;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruhama.project.dto.OtpDto;
import net.ruhama.project.dto.UserProfileDto;
import net.ruhama.project.model.Otp;
import net.ruhama.project.model.User;
import net.ruhama.project.model.Wallet;
import net.ruhama.project.repo.AuthorityRepository;
import net.ruhama.project.repo.OtpRepository;
import net.ruhama.project.repo.UserRepository;
import net.ruhama.project.repo.WalletRepository;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IUserAuthentication;
import net.ruhama.project.util.ResponseEnum;
import net.ruhama.project.util.UserStatus;

/**
 * @author ahmedozy
 *
 */
@Service
public class UserAuthentication implements IUserAuthentication {

	@Autowired
	private OtpRepository otpRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthorityRepository authRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Random random;
	

	// generate otp
	// send the otp via sms (in the first version of the app just return it to the sender)
	@Override
	public ObjectResponse<OtpDto> register(OtpDto otpDto) {
		//mapper.addConverter(stringToInteger());
		Otp otp = mapper.map(otpDto, Otp.class);
		System.out.println("after mapping "+ otp);
		Otp newOtp = otpRepo.findByPhoneNumber(otp.getPhoneNumber());
		if (newOtp == null) {
			otp.setOtp(generateOtp());
			otpRepo.save(otp);
			otpDto.setOtp(otp.getOtp()+"");
		}else {
			otpDto.setOtp(newOtp.getOtp()+"");
		}
		ObjectResponse<OtpDto> response = new ObjectResponse<OtpDto>(ResponseEnum.SUCCESS, otpDto);
		return response;
	}


	//if there is no user with phone create a new user
	//after verify delete otp record
	@Override
	public ObjectResponse<UserProfileDto> verifyAndLogin(OtpDto otpDto) {
		ObjectResponse<UserProfileDto> response;
		Otp otp = otpRepo.findByOtp(Integer.valueOf(otpDto.getOtp()));
		if(null != otp && otpDto.getPhoneNumber().equals(otp.getPhoneNumber().toString())) {
			User user = userRepo.findByPhoneNumber(otp.getPhoneNumber());
			user = createUserIfNotExist(otp, user);
			UserProfileDto userProfileDto = mapper.map(user, UserProfileDto.class);
			userProfileDto.setId(user.getId());
			userProfileDto.setStatus(user.getStatus());
			response = new ObjectResponse<UserProfileDto>(ResponseEnum.SUCCESS, userProfileDto);
			otpRepo.delete(otp);
		} else {
			response = new ObjectResponse<>(ResponseEnum.ITEM_NOT_FOUND);
		}
		return response;
	}


	private User createUserIfNotExist(Otp otp, User user) {
		Wallet wallet;
		if(user == null) {
			user = new User();
			user.setPhoneNumber(otp.getPhoneNumber());
			user.setStatus(UserStatus.ACTIVE);
			if(otp.isAgent()) {
				user.setAuthorities(Arrays.asList(authRepo.findByAuthorityName("USER")));
				
			} else {
				user.setAuthorities(Arrays.asList(authRepo.findByAuthorityName("AGENT")));
			}
			wallet = new Wallet();
			wallet.setCreated_at(new Date());
			wallet.setCurrent_balance(0.0);
			wallet.setLast_update(new Date());
			Wallet savedWallet = walletRepo.save(wallet);
			user.setWallet(savedWallet);
			user = userRepo.save(user);
		}
		return user;
	}
	
	private Integer generateOtp() {
		return random.nextInt(900000)+100000; 
	}

}

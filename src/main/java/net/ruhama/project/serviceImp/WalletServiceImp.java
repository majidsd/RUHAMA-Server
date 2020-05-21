/**
 * 
 */
package net.ruhama.project.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruhama.project.dto.WalletDto;
import net.ruhama.project.dto.WalletHistoryDto;
import net.ruhama.project.model.User;
import net.ruhama.project.model.Wallet;
import net.ruhama.project.repo.UserRepository;
import net.ruhama.project.repo.WalletRepository;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IWalletHistoryService;
import net.ruhama.project.service.IWalletService;
import net.ruhama.project.util.ResponseEnum;
import net.ruhama.project.util.WalletOperations;

/**
 * @author MaJiD
 *
 */
@Service
public class WalletServiceImp implements IWalletService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private IWalletHistoryService walletHistoryService;
	
	@Override
	public ObjectResponse<Wallet> addWallet(WalletDto walletDto) {
		ObjectResponse<Wallet> response;
		Wallet wallet;
		try {
			wallet = new Wallet();
			User owner = userRepository.getOne(walletDto.getOwner_id());
			User creater = userRepository.getOne(walletDto.getCreated_by_id());
			try {
				wallet.setOwner(owner);
				wallet.setCreated_by(creater);
				wallet.setLast_update_by(creater);
				wallet.setCreated_at(new Date());
				wallet.setLast_update(new Date());
				wallet.setCurrent_balance(walletDto.getAmount());
				Wallet savedWallet = walletRepository.save(wallet);
				response = new ObjectResponse<Wallet>(ResponseEnum.SUCCESS, savedWallet);
			} catch (Exception e) {
				e.printStackTrace();
				response = new ObjectResponse<Wallet>(ResponseEnum.DUPLICATED_ITEM, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Wallet>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<Wallet> getWallet(Integer id) {
		ObjectResponse<Wallet> response;
		Wallet wallet = walletRepository.getOne(id);
		if(wallet != null) {
			response = new ObjectResponse<Wallet>(ResponseEnum.SUCCESS, wallet);
		} else {
			response = new ObjectResponse<Wallet>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Double> getBalance(WalletDto walletDto) {
		ObjectResponse<Double> response;
		Wallet wallet = walletRepository.getOne(walletDto.getId());
		if(wallet != null) {
			Double currentBalance = wallet.getCurrent_balance();
			response = new ObjectResponse<Double>(ResponseEnum.SUCCESS, currentBalance);
		} else {
			response = new ObjectResponse<Double>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Wallet> credit(WalletDto walletDto) {
		ObjectResponse<Wallet> response;
		Wallet wallet = walletRepository.getOne(walletDto.getId());
		WalletHistoryDto walletHistoryDto;
		
		if(wallet != null) {
			walletHistoryDto = new WalletHistoryDto();
			walletHistoryDto.setOperation(WalletOperations.CREDIT.getValue());
			walletHistoryDto.setAmount(walletDto.getAmount());
			walletHistoryDto.setCreated_by_id(walletDto.getOwner_id());
			walletHistoryDto.setWallet_id(wallet.getId());
			Double newBalance = wallet.getCurrent_balance() + walletDto.getAmount();
			wallet.setCurrent_balance(newBalance);
			wallet.setLast_update(new Date());
			Wallet updatedWallet = walletRepository.save(wallet);
			walletHistoryDto.setDescrtption("Credit " + walletDto.getAmount() + " And new balance is "+updatedWallet.getCurrent_balance());
			walletHistoryService.addWalletHistory(walletHistoryDto);
			response = new ObjectResponse<Wallet>(ResponseEnum.SUCCESS, updatedWallet);
		}else {
			response = new ObjectResponse<Wallet>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Wallet> debit(WalletDto walletDto) {
		ObjectResponse<Wallet> response;
		Wallet wallet = walletRepository.getOne(walletDto.getId());
		WalletHistoryDto walletHistoryDto;
		
		if(wallet != null) {
			walletHistoryDto = new WalletHistoryDto();
			walletHistoryDto.setOperation(WalletOperations.DEBIT.getValue());
			walletHistoryDto.setAmount(walletDto.getAmount());
			walletHistoryDto.setCreated_by_id(walletDto.getOwner_id());
			walletHistoryDto.setWallet_id(wallet.getId());
			Double newBalance = wallet.getCurrent_balance() - walletDto.getAmount();
			if(newBalance >= 0) {
				wallet.setCurrent_balance(newBalance);
				wallet.setLast_update(new Date());
				Wallet updatedWallet = walletRepository.save(wallet);
				walletHistoryDto.setDescrtption("Debit " + walletDto.getAmount() + " And new balance is "+updatedWallet.getCurrent_balance());
				walletHistoryService.addWalletHistory(walletHistoryDto);
				response = new ObjectResponse<Wallet>(ResponseEnum.SUCCESS, updatedWallet);
			} else {
				response = new ObjectResponse<Wallet>(ResponseEnum.INSUFFICIENT, wallet);
			}
			
		}else {
			response = new ObjectResponse<Wallet>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}


	@Override
	public ListResponse<Wallet> getAllWallets() {
		ListResponse<Wallet> response;
		try {
			response = new ListResponse<Wallet>(ResponseEnum.SUCCESS, walletRepository.findAll());
		} catch (Exception e) {
			response = new ListResponse<Wallet>(ResponseEnum.TRY_AGAIN, null); 
		}
		return response;
	}

}

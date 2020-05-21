/**
 * 
 */
package net.ruhama.project.serviceImp;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruhama.project.dto.WalletHistoryDto;
import net.ruhama.project.model.User;
import net.ruhama.project.model.Wallet;
import net.ruhama.project.model.WalletHistory;
import net.ruhama.project.repo.UserRepository;
import net.ruhama.project.repo.WalletHistoryRepository;
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
public class WalletHistoryServiceImp implements IWalletHistoryService  {
	
	@Autowired
	private IWalletService walletService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WalletHistoryRepository walletHistoryRepository;
	
	@Override
	public ObjectResponse<WalletHistory> addWalletHistory(WalletHistoryDto walletHistoryDto) {
		
		ObjectResponse<WalletHistory> response;
		WalletHistory walletHistory = new WalletHistory();
		try {
			ObjectResponse<Wallet> walletRespone = walletService.getWallet(walletHistoryDto.getWallet_id());
			if(walletRespone.getResponseCode() == ResponseEnum.SUCCESS.getResponseCode() && walletRespone.getDto() != null) {
				User user = userRepository.getOne(walletHistoryDto.getCreated_by_id());
				walletHistory.setAmount(walletHistoryDto.getAmount());
				walletHistory.setWallet(walletRespone.getDto());
				walletHistory.setCreated_at(new Date());
				walletHistory.setCreated_by(user);
				walletHistory.setDescription(walletHistoryDto.getDescrtption());
				walletHistory.setOperation(walletHistoryDto.getOperation());
				walletHistory.setLast_update(new Date());
				walletHistory.setLast_update_by(user);
				WalletHistory addedWalletHistory = walletHistoryRepository.save(walletHistory);
				response = new ObjectResponse<WalletHistory>(ResponseEnum.SUCCESS, addedWalletHistory);
			} else {
				response = new ObjectResponse<WalletHistory>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<WalletHistory>(ResponseEnum.DUPLICATED_ITEM, null);
		}
		return response;
	}

	@Override
	public ListResponse<WalletHistory> getOldCredit(WalletHistoryDto walletHistoryDto) {
		ListResponse<WalletHistory> response;
		try {
			Wallet wallet = walletService.getWallet(walletHistoryDto.getWallet_id()).getDto();
			if(wallet != null) {
				response = new ListResponse<WalletHistory>(ResponseEnum.SUCCESS, walletHistoryRepository.getWalletOperationsHistory(wallet, WalletOperations.CREDIT.getValue()));
			} else {
				response = new ListResponse<WalletHistory>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			response = new ListResponse<WalletHistory>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<WalletHistory> getOldCreditPerPeriod(WalletHistoryDto walletHistoryDto) {
		ListResponse<WalletHistory> response;
		try {
			Wallet wallet = walletService.getWallet(walletHistoryDto.getWallet_id()).getDto();
			if(wallet != null) {
				response = new ListResponse<WalletHistory>(ResponseEnum.SUCCESS, walletHistoryRepository.getWalletOperationsHistoryPerPeriod(wallet, WalletOperations.CREDIT.getValue(), walletHistoryDto.getFrom_date(), walletHistoryDto.getTo_date()));
			} else {
				response = new ListResponse<WalletHistory>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			response = new ListResponse<WalletHistory>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<WalletHistory> getOldDebit(WalletHistoryDto walletHistoryDto) {
		ListResponse<WalletHistory> response;
		try {
			Wallet wallet = walletService.getWallet(walletHistoryDto.getWallet_id()).getDto();
			if(wallet != null) {
				response = new ListResponse<WalletHistory>(ResponseEnum.SUCCESS, walletHistoryRepository.getWalletOperationsHistory(wallet, WalletOperations.DEBIT.getValue()));
			} else {
				response = new ListResponse<WalletHistory>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			response = new ListResponse<WalletHistory>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<WalletHistory> getOldDebitPerPeriod(WalletHistoryDto walletHistoryDto) {
		ListResponse<WalletHistory> response;
		try {
			Wallet wallet = walletService.getWallet(walletHistoryDto.getWallet_id()).getDto();
			if(wallet != null) {
				response = new ListResponse<WalletHistory>(ResponseEnum.SUCCESS, walletHistoryRepository.getWalletOperationsHistoryPerPeriod(wallet, WalletOperations.DEBIT.getValue(), walletHistoryDto.getFrom_date(), walletHistoryDto.getTo_date()));
			} else {
				response = new ListResponse<WalletHistory>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			response = new ListResponse<WalletHistory>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

}

/**
 * 
 */
package net.ruhama.project.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruhama.project.dto.PendingWalletCreditDto;
import net.ruhama.project.dto.WalletDto;
import net.ruhama.project.model.PendingWalletCredit;
import net.ruhama.project.model.User;
import net.ruhama.project.model.Wallet;
import net.ruhama.project.repo.PendingWalletCreditRepository;
import net.ruhama.project.repo.UserRepository;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IPendingWalletCreditService;
import net.ruhama.project.service.IWalletService;
import net.ruhama.project.util.PendingWalletCreditStatus;
import net.ruhama.project.util.ResponseEnum;

/**
 * @author MaJiD
 *
 */
@Service
public class PendingWalletCreditServiceImp implements IPendingWalletCreditService {

	@Autowired
	private PendingWalletCreditRepository pendingWalletCreditRepository;
	
	@Autowired
	private IWalletService walletService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ObjectResponse<PendingWalletCredit> addPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto) {
		ObjectResponse<PendingWalletCredit> response;
		PendingWalletCredit pendingWalletCredit;
		Wallet wallet;
		User user;
		try {
			wallet = walletService.getWallet(pendingWalletCreditDto.getWallet_id()).getDto();
			user = userRepository.getOne(pendingWalletCreditDto.getCreated_by_id());
			Double amount = pendingWalletCreditDto.getAmount();
			if(amount > 0) {
				if(wallet != null && user != null) {
					pendingWalletCredit = new PendingWalletCredit();
					pendingWalletCredit.setAmount(amount);
					pendingWalletCredit.setBank(pendingWalletCreditDto.getBank());
					pendingWalletCredit.setBranch(pendingWalletCreditDto.getBranch());
					pendingWalletCredit.setDescription(pendingWalletCreditDto.getDescription());
					pendingWalletCredit.setReceipt_imgUrl(pendingWalletCreditDto.getReceipt_imgUrl());
					pendingWalletCredit.setReceipt_no(pendingWalletCreditDto.getReceipt_no());
					pendingWalletCredit.setWallet(wallet);
					pendingWalletCredit.setStatus(PendingWalletCreditStatus.NEW.getValue());
					pendingWalletCredit.setCreated_at(new Date());
					pendingWalletCredit.setLast_update(new Date());
					pendingWalletCredit.setCreated_by(user);
					pendingWalletCredit.setLast_update_by(user);
					PendingWalletCredit newPendingWalletCredit = pendingWalletCreditRepository.save(pendingWalletCredit);
					response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, newPendingWalletCredit);
				} else {
					response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.ITEM_NOT_FOUND, null);
				}
			} else {
				response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.NEGATIVE_AMOUNT, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN);
		}
		return response;
	}

	@Override
	public ObjectResponse<PendingWalletCredit> approvePendingWalletCredit(
			PendingWalletCreditDto pendingWalletCreditDto) {
		ObjectResponse<PendingWalletCredit> response;
		PendingWalletCredit pendingWalletCredit;
		try {
			pendingWalletCredit = pendingWalletCreditRepository.getOne(pendingWalletCreditDto.getId());
			if (pendingWalletCredit != null && pendingWalletCredit.getStatus() == PendingWalletCreditStatus.NEW.getValue()) {
				pendingWalletCredit.setStatus(PendingWalletCreditStatus.DONE.getValue());
				pendingWalletCredit.setLast_update(new Date());
				pendingWalletCredit.setLast_update_by(userRepository.getOne(pendingWalletCreditDto.getCreated_by_id()));
				Wallet wallet = walletService.getWallet(pendingWalletCredit.getWallet().getId()).getDto();
				if (wallet != null) {
					WalletDto walletDto = new WalletDto();
					walletDto.setAmount(pendingWalletCredit.getAmount());
					walletDto.setId(wallet.getId());
					walletDto.setCreated_by_id(pendingWalletCreditDto.getCreated_by_id());
					if(walletService.credit(walletDto).getResponseCode() == ResponseEnum.SUCCESS.getResponseCode()) {
						response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, pendingWalletCreditRepository.save(pendingWalletCredit));
					} else {
						response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN, null);
					}
				} else {
					response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.ITEM_NOT_FOUND, null);
				}
			} else {
				response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<PendingWalletCredit> rejectPendingWalletCredit(
			PendingWalletCreditDto pendingWalletCreditDto) {
		ObjectResponse<PendingWalletCredit> response;
		PendingWalletCredit pendingWalletCredit;
		try {
			pendingWalletCredit = pendingWalletCreditRepository.getOne(pendingWalletCreditDto.getId());
			if(pendingWalletCredit != null && pendingWalletCredit.getStatus() == PendingWalletCreditStatus.NEW.getValue()) {
				pendingWalletCredit.setStatus(PendingWalletCreditStatus.REJECTED.getValue());
				pendingWalletCredit.setLast_update(new Date());
				pendingWalletCredit.setLast_update_by(userRepository.getOne(pendingWalletCreditDto.getCreated_by_id()));
				response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, pendingWalletCreditRepository.save(pendingWalletCredit));
			} else {
				response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<PendingWalletCredit> getPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto) {
		ObjectResponse<PendingWalletCredit> response;
		try {
			response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, pendingWalletCreditRepository.getOne(pendingWalletCreditDto.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<PendingWalletCredit> getAllPendingWalletCredits() {
		ListResponse<PendingWalletCredit> response;
		try {
			response = new ListResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, pendingWalletCreditRepository.getWalletsPendingCredit(PendingWalletCreditStatus.NEW.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<PendingWalletCredit> getUserPendingWalletCredits(
			PendingWalletCreditDto pendingWalletCreditDto) {
		ListResponse<PendingWalletCredit> response;
		Wallet wallet;
		try {
			wallet = walletService.getWallet(pendingWalletCreditDto.getWallet_id()).getDto();
			if (wallet != null) {
				response = new ListResponse<PendingWalletCredit>(ResponseEnum.SUCCESS, pendingWalletCreditRepository.getWalletPendingCredit(wallet, PendingWalletCreditStatus.NEW.getValue()));
			} else {
				response = new ListResponse<PendingWalletCredit>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<PendingWalletCredit>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

}

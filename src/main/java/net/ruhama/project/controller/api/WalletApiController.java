/**
 * 
 */
package net.ruhama.project.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ruhama.project.dto.WalletDto;
import net.ruhama.project.dto.WalletHistoryDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IWalletHistoryService;
import net.ruhama.project.service.IWalletService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/wallet")
public class WalletApiController {
	@Autowired
	IWalletService walletService;
	
	@Autowired
	IWalletHistoryService walletHistoryService;

	@GetMapping("/getBalance/{walletId}")
	public ObjectResponse<Double> getBalance(@PathVariable Integer walletId){
		WalletDto walletDto = new WalletDto();
		walletDto.setId(walletId);
		ObjectResponse<Double> response = walletService.getBalance(walletDto); 
		return response;
	}
	
	@PostMapping("/credit")
	public ObjectResponse<WalletDto> creditWallet(@RequestBody WalletDto walletDto){
		ObjectResponse<WalletDto> response = walletService.credit(walletDto);
		return response;
	}
	
	@GetMapping("/getTransactions/{walletId}")
	public ListResponse<WalletHistoryDto> getTransactions(@PathVariable Integer walletId){
		WalletHistoryDto whd = new WalletHistoryDto();
		whd.setWallet_id(walletId);
		ListResponse<WalletHistoryDto> response = walletHistoryService.getOldTransactions(whd);
		return response;
	}
}

/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.WalletDto;
import net.ruhama.project.model.Wallet;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IWalletService {
	
	public ObjectResponse<Wallet> addWallet(WalletDto walletDto);
	
	public ObjectResponse<Wallet> getWallet(Integer id);
	
	public ObjectResponse<Double> getBalance(WalletDto walletDto);
	
	public ObjectResponse<WalletDto> credit(WalletDto walletDto);
	
	public ObjectResponse<Wallet> debit(WalletDto walletDto);
	
	public ListResponse<Wallet> getAllWallets();

}

/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.model.User;
import net.ruhama.project.model.Wallet;

/**
 * @author MaJiD
 *
 */
public interface IWalletService {
	
	public Wallet addWallet(Integer owner_id, Double current_balance, Integer createdByUser_id);
	
	public Double getBalance(Integer owner_id);
	
	public Boolean credit(User owner, Double amount);
	
	public Boolean debit(User owner, Double amount);

}

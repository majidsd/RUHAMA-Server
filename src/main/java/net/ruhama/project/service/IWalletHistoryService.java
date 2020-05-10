/**
 * 
 */
package net.ruhama.project.service;

import java.util.Date;
import java.util.List;

import net.ruhama.project.model.WalletHistory;

/**
 * @author MaJiD
 *
 */
public interface IWalletHistoryService {
	
	public WalletHistory addWalletHistory();
	
	public WalletHistory updateWalletHistory(Integer walletHistory_id, Byte status);
	
	public List<WalletHistory> getOldCredit(Integer owner_id);
	
	public List<WalletHistory> getOldCreditPerPeriod(Integer owner_id, Date start_date, Date end_date);
	
	public List<WalletHistory> getOldDebit(Integer owner_id);
	
	public List<WalletHistory> getOldDebitPerPeriod(Integer owner_id, Date start_date, Date end_date);
	
}

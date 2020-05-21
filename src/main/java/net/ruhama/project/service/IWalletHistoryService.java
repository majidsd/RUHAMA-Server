/**
 * 
 */
package net.ruhama.project.service;


import net.ruhama.project.dto.WalletHistoryDto;
import net.ruhama.project.model.WalletHistory;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IWalletHistoryService {
	
	public ObjectResponse<WalletHistory> addWalletHistory(WalletHistoryDto walletHistoryDto);
	
	public ListResponse<WalletHistory> getOldCredit(WalletHistoryDto walletHistoryDto);
	
	public ListResponse<WalletHistory> getOldCreditPerPeriod(WalletHistoryDto walletHistoryDto);
	
	public ListResponse<WalletHistory> getOldDebit(WalletHistoryDto walletHistoryDto);
	
	public ListResponse<WalletHistory> getOldDebitPerPeriod(WalletHistoryDto walletHistoryDto);
	
}

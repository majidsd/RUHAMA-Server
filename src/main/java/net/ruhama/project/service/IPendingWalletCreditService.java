/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.PendingWalletCreditDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IPendingWalletCreditService {
	
	public ObjectResponse<PendingWalletCreditDto> addPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCreditDto> approvePendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCreditDto> rejectPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCreditDto> getPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ListResponse<PendingWalletCreditDto> getAllPendingWalletCredits();
	
	public ListResponse<PendingWalletCreditDto> getUserPendingWalletCredits(PendingWalletCreditDto pendingWalletCreditDto);

}

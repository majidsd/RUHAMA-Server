/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.PendingWalletCreditDto;
import net.ruhama.project.model.PendingWalletCredit;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IPendingWalletCreditService {
	
	public ObjectResponse<PendingWalletCredit> addPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCredit> approvePendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCredit> rejectPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ObjectResponse<PendingWalletCredit> getPendingWalletCredit(PendingWalletCreditDto pendingWalletCreditDto);
	
	public ListResponse<PendingWalletCredit> getAllPendingWalletCredits();
	
	public ListResponse<PendingWalletCredit> getUserPendingWalletCredits(PendingWalletCreditDto pendingWalletCreditDto);

}

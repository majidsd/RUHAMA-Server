/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.DonationDto;
import net.ruhama.project.model.Donation;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IDonationService {
	
	public ObjectResponse<Donation> donate(DonationDto donationDto);
	
	public ObjectResponse<Donation> transferDonation(DonationDto donationDto);
	
	public ListResponse<Donation> getCaseDonations(DonationDto donationDto);
	
	public ListResponse<Donation> getCaseDonationsPerPeriod(DonationDto donationDto);
	
	public ListResponse<Donation> getUserDonations(DonationDto donationDto);
	
	public ListResponse<Donation> getUserDonationsPerPeriod(DonationDto donationDto);
	
}

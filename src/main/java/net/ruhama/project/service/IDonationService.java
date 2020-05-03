/**
 * 
 */
package net.ruhama.project.service;

import java.util.Date;
import java.util.List;

import net.ruhama.project.model.Donation;

/**
 * @author MaJiD
 *
 */
public interface IDonationService {
	
	public Donation donate(Integer case_id, Integer user_id, Double amount, Integer createdByUser_id);
	
	public Donation transferDonate(Integer donation_id, Integer new_case_id);
	
	public List<Donation> getCaseDonations(Integer case_id);
	
	public List<Donation> getCaseDonationsPerPeriod(Integer case_id, Date start_date, Date end_date);
	
	public List<Donation> getUserDonations(Integer donator_id);
	
	public List<Donation> getUserDonationsPerPeriod(Integer user_id, Date start_date, Date end_date);
	
}

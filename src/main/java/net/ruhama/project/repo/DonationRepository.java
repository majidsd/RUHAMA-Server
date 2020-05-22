/**
 * 
 */
package net.ruhama.project.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ruhama.project.model.Case;
import net.ruhama.project.model.Donation;
import net.ruhama.project.model.User;

/**
 * @author MaJiD
 *
 */
public interface DonationRepository extends JpaRepository<Donation, Integer> {
	
	@Query("FROM Donation where the_case = ?1 ")
	public List<Donation> getCaseDonations(Case the_case);
	
	@Query("FROM Donation where the_case = ?1 and created_at between ?2 and ?3")
	public List<Donation> getCaseDonationsPerPeriod(Case the_case, Date from_date, Date to_date);
	
	@Query("FROM Donation where donator = ?1 ")
	public List<Donation> getUserDonations(User donator);
	
	@Query("FROM Donation where donator = ?1 and created_at between ?2 and ?3")
	public List<Donation> getUserDonationsPerPeriod(User donator, Date from_date, Date to_date);
	
}

/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.Donation;

/**
 * @author MaJiD
 *
 */
public interface DonationRepository extends JpaRepository<Donation, Integer> {
	
	
}

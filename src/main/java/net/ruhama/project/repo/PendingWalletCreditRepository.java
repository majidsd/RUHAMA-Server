/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.PendingWalletCredit;

/**
 * @author MaJiD
 *
 */
public interface PendingWalletCreditRepository extends JpaRepository<PendingWalletCredit, Integer> {

}

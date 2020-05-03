/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.WalletHistory;

/**
 * @author MaJiD
 *
 */
public interface WalletHistoryRepository extends JpaRepository<WalletHistory, Integer> {

}

/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.Wallet;

/**
 * @author MaJiD
 *
 */
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}

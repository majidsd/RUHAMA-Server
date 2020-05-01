/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.Authority;

/**
 * @author ahmedozy
 *
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

	Authority findByAuthorityName(String authorityName);

}

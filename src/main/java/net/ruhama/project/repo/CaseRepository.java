/**
 * 
 */
package net.ruhama.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.Case;
import net.ruhama.project.model.User;

/**
 * @author ahmedozy
 *
 */
public interface CaseRepository extends JpaRepository<Case, Integer> {
	public List<Case> findAllByAgent(User agent);
}

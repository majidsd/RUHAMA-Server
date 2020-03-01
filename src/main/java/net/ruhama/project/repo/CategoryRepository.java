/**
 * 
 */
package net.ruhama.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ruhama.project.model.Category;

/**
 * @author MaJiD
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query("From Category where status = ?1")
	public List<Category> getMyAllCategoriesByStatus(Byte status);
	
}

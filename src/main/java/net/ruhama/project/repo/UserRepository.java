/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruhama.project.model.User;

/**
 * @author ahmedozy
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}

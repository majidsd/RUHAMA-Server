/**
 * 
 */
package net.ruhama.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import net.ruhama.project.model.User;

/**
 * @author ahmedozy
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	User findByPhoneNumber(Integer phoneNumber);

}

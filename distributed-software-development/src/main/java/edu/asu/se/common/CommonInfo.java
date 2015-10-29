package edu.asu.se.common;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< HEAD
public class CommonInfo {

=======
/**
 * 
 * This class consists of all common functionalities that are required in the
 * project.
 *
 */
public class CommonInfo {

	/**
	 * This method will return the user name of the logged in user
	 * 
	 * @return user name of the logged in user
	 */
>>>>>>> master
	public static String getUserName() {
		String userName = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			userName = userDetail.getUsername();
		}
		return userName;
	}
}

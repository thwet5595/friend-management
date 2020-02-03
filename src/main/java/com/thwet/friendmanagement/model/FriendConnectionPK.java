/**
 * 
 */
package com.thwet.friendmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

/**
 * @author Thwet Thwet Mar
 *
 *         Jan 31, 2020
 */
@Embeddable
public class FriendConnectionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -135521895489470892L;

	@Column(name = "USER_EMAIL", nullable = false)
	@Email
	private String userEmail;

	@Column(name = "FRIEND_EMAIL", nullable = false)
	@Email
	private String friendEmail;

	public FriendConnectionPK() {

	}

	public FriendConnectionPK(String userEmail, String friendEmail) {
		super();
		this.userEmail = userEmail;
		this.friendEmail = friendEmail;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the friendEmail
	 */
	public String getFriendEmail() {
		return friendEmail;
	}

	/**
	 * @param friendEmail the friendEmail to set
	 */
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
}

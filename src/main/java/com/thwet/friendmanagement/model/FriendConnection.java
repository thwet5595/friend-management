/**
 * 
 */
package com.thwet.friendmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * @author Thwet Thwet Mar
 *
 *         Jan 31, 2020
 */
@Entity
@Table(name = "FRIENDCONNECTION")
public class FriendConnection {

	/*
	 * @EmbeddedId FriendConnectionPK friendConnectionPK;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_EMAIL", nullable = false)
	@Email
	private String userEmail;

	@Column(name = "FRIEND_EMAIL", nullable = false)
	@Email
	private String friendEmail;

	@Column(name = "ARE_FRIEND", nullable = false)
	private boolean areFriend;

	@Column(name = "IS_BLOCKED", nullable = false)
	private boolean isBlocked;

	@Column(name = "RECEIVE_UPDATE", nullable = false)
	private boolean receiveUpdate;

	/**
	 * 
	 */
	public FriendConnection() {

	}

	public FriendConnection(String userEmail, String friendEmail, boolean areFriend, boolean isBlocked,
			boolean receiveUpdate) {
		super();
		this.userEmail = userEmail;
		this.friendEmail = friendEmail;
		this.areFriend = areFriend;
		this.isBlocked = isBlocked;
		this.receiveUpdate = receiveUpdate;
	}

	public FriendConnection copy(FriendConnection exitFriConnection) {
		FriendConnection newFriConnection = new FriendConnection();
		newFriConnection.setId(exitFriConnection.getId());
		newFriConnection.setUserEmail(exitFriConnection.getUserEmail());
		newFriConnection.setFriendEmail(exitFriConnection.getFriendEmail());
		newFriConnection.setAreFriend(exitFriConnection.isAreFriend());
		newFriConnection.setBlocked(exitFriConnection.isBlocked());
		newFriConnection.setReceiveUpdate(exitFriConnection.isReceiveUpdate());
		return newFriConnection;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the areFriend
	 */
	public boolean isAreFriend() {
		return areFriend;
	}

	/**
	 * @param areFriend
	 *            the areFriend to set
	 */
	public void setAreFriend(boolean areFriend) {
		this.areFriend = areFriend;
	}

	/**
	 * @return the isBlocked
	 */
	public boolean isBlocked() {
		return isBlocked;
	}

	/**
	 * @param isBlocked
	 *            the isBlocked to set
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	/**
	 * @return the receiveUpdate
	 */
	public boolean isReceiveUpdate() {
		return receiveUpdate;
	}

	/**
	 * @param receiveUpdate
	 *            the receiveUpdate to set
	 */
	public void setReceiveUpdate(boolean receiveUpdate) {
		this.receiveUpdate = receiveUpdate;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
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
	 * @param friendEmail
	 *            the friendEmail to set
	 */
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
}

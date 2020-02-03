/**
 * 
 */
package com.thwet.friendmanagement.service;

import java.util.List;

import com.thwet.friendmanagement.model.FriendConnection;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
public interface FriendConnectionService {

	List<FriendConnection> findByUserEmailAndFriendEmail(String userEmail, String friendEmail);

	List<FriendConnection> getFriends(String email);

	List<FriendConnection> checkEmailExitOrNot(String userEmail, String friendEmail);

	FriendConnection findByUserEmail(String userEmail);

	FriendConnection findByFriendEmail(String friendEmail);

	List<FriendConnection> getReceiveUpdate(String email);
}

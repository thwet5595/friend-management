/**
 * 
 */
package com.thwet.friendmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thwet.friendmanagement.exception.CustomException;
import com.thwet.friendmanagement.model.FriendConnection;
import com.thwet.friendmanagement.model.User;
import com.thwet.friendmanagement.repository.FriendConnectionRepository;
import com.thwet.friendmanagement.repository.UserRepository;
import com.thwet.friendmanagement.service.FriendConnectionService;
import com.thwet.friendmanagement.service.FriendManagementService;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
@Service
public class FriendManagementServiceImpl implements FriendManagementService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FriendManagementServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FriendConnectionRepository friendConnectionRepository;
	@Autowired
	private FriendConnectionService friendConnectionService;

	@Override
	public boolean friend(List<String> emailList) throws CustomException {
		if (emailList.get(0).equals(emailList.get(1))) {
			LOGGER.warn("Duplicate email");
			throw new CustomException("Emails are duplicate.");
		}

		List<User> newUsers = emailList.stream().filter(email -> !userRepository.existsById(email)).map(User::new)
				.collect(Collectors.toList());

		if (!newUsers.isEmpty()) {
			userRepository.saveAll(newUsers);
			LOGGER.info("Users saved successfully.", newUsers);
		} else {
			LOGGER.info("Users is empty and saved failured");
		}

		FriendConnection firstConnection = this.createFriendConnection(emailList.get(0), emailList.get(1));

		FriendConnection secondConnection = this.createFriendConnection(emailList.get(1), emailList.get(0));

		if (firstConnection == null) {
			return false;
		}

		if (secondConnection == null) {
			return false;
		}

		friendConnectionRepository.save(firstConnection);
		friendConnectionRepository.save(secondConnection);
		return true;
	}

	@Override
	public List<String> friends(String email) throws CustomException {
		List<String> result = new ArrayList<>();
		List<FriendConnection> friends = null;
		if (userRepository.existsById(email)) {
			friends = friendConnectionService.getFriends(email);
		} else {
			LOGGER.warn("User not found");
			throw new CustomException("User not found.");
		}
		for (FriendConnection friend : friends) {
			result.add(friend.getFriendEmail());
		}
		return result;
	}

	@Override
	public List<String> commonFriends(List<String> emails) throws CustomException {
		if (emails.get(0).equals(emails.get(1))) {
			LOGGER.warn("Email duplicate.");
			throw new CustomException("Email duplicate");
		}

		List<String> friends = new ArrayList<>();

		final Long friendsCount = emails.stream().filter(email -> userRepository.existsById(email)).count();

		if (friendsCount == emails.size()) {
			friends = friendConnectionRepository.getCommonFriendList(emails);
			LOGGER.info("CommonFriends..." + friends.size());
		} else {
			LOGGER.warn("Email not found.");
			throw new CustomException("Email not found.");
		}
		return friends;
	}

	@Override
	public boolean subscribe(String requestor, String target) throws CustomException {
		if (requestor.equalsIgnoreCase(target)) {
			LOGGER.warn("Email duplicate.");
			throw new CustomException("Email duplicate.");
		}

		if (userRepository.existsById(requestor) && userRepository.existsById(target)) {
			FriendConnection friConnectionByUser = friendConnectionService.findByUserEmail(requestor);
			FriendConnection friConnectionByFriend = friendConnectionService.findByFriendEmail(target);

			FriendConnection friConnection = new FriendConnection();
			if (friConnectionByUser != null) {
				friConnection = friConnection.copy(friConnectionByUser);
				friConnection.setReceiveUpdate(true);
			} else if (friConnectionByFriend != null) {
				friConnection = friConnection.copy(friConnectionByFriend);
				friConnection.setReceiveUpdate(true);
			} else {
				friConnection = new FriendConnection(requestor, target, false, false, true);
			}
			friendConnectionRepository.save(friConnection);
		} else {
			LOGGER.warn("Email address not found");
			throw new CustomException("email.addresses.not.found");
		}
		return true;
	}

	@Override
	public boolean block(String requestor, String target) throws CustomException {
		if (requestor.equals(target)) {
			LOGGER.warn("Email duplicate.");
			throw new CustomException("email.addresses.identical");
		}

		if (userRepository.existsById(requestor) && userRepository.existsById(target)) {
			FriendConnection friConnectionByUser = friendConnectionService.findByUserEmail(requestor);
			FriendConnection friConnectionByFriend = friendConnectionService.findByFriendEmail(target);

			FriendConnection friConnection = new FriendConnection();

			if (friConnectionByUser != null) {
				friConnection = friConnection.copy(friConnectionByUser);
				friConnection.setReceiveUpdate(false);
				if (!friConnection.isAreFriend()) {
					friConnection.setBlocked(true);
				}
			} else if (friConnectionByFriend != null) {
				friConnection = friConnection.copy(friConnectionByFriend);
				friConnection.setReceiveUpdate(false);
				if (!friConnection.isAreFriend()) {
					friConnection.setBlocked(true);
				}
			} else {
				friConnection = new FriendConnection(requestor, target, false, true, false);
			}

			friendConnectionRepository.save(friConnection);
		} else {
			LOGGER.warn("Email address not found");
			throw new CustomException("Email address not found.");
		}

		return true;
	}

	@Override
	public List<String> receiveUpdatesList(String email) throws CustomException {
		List<String> updates = new ArrayList<>();
		List<FriendConnection> friConnectionUpdates = null;
		if (userRepository.existsById(email)) {
			friConnectionUpdates = friendConnectionService.getReceiveUpdate(email);
		} else {
			LOGGER.warn("User not found.");
			throw new CustomException("User not found.");
		}
		if(friConnectionUpdates.size() > 0){
			for (FriendConnection friConnection : friConnectionUpdates) {
				updates.add(friConnection.getFriendEmail());
			}
		}

		return updates;
	}

	private FriendConnection createFriendConnection(String userEmail, String friendEmail) {
		FriendConnection friendConnection = null;

		List<FriendConnection> friends = friendConnectionService.findByUserEmailAndFriendEmail(userEmail, friendEmail);
		if (friends.size() != 0) {
			friendConnection = friends.get(0);
			friendConnection.setAreFriend(true);
		} else {
			friendConnection = new FriendConnection(userEmail, friendEmail, true, false, false);
		}
		return friendConnection;
	}
}

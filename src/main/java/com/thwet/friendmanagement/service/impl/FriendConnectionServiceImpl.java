/**
 * 
 */
package com.thwet.friendmanagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.thwet.friendmanagement.model.FriendConnection;
import com.thwet.friendmanagement.repository.FriendConnectionRepository;
import com.thwet.friendmanagement.service.FriendConnectionService;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
@Service
public class FriendConnectionServiceImpl implements FriendConnectionService {
	@Autowired
	private FriendConnectionRepository friendConnectionRepository;

	@Override
	public List<FriendConnection> findByUserEmailAndFriendEmail(String userEmail, String friendEmail) {
		FriendConnection filterBy = new FriendConnection();
		filterBy.setUserEmail(userEmail);
		filterBy.setFriendEmail(friendEmail);
		filterBy.setBlocked(false);

		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.EXACT).withIgnoreCase();

		Example<FriendConnection> example = Example.of(filterBy, matcher);
		return (List<FriendConnection>) friendConnectionRepository.findAll(example);
	}

	@Override
	public List<FriendConnection> getFriends(String email) {
		FriendConnection filterBy = new FriendConnection();
		filterBy.setUserEmail(email);
		filterBy.setAreFriend(true);

		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.EXACT).withIgnoreCase();

		Example<FriendConnection> example = Example.of(filterBy, matcher);
		return (List<FriendConnection>) friendConnectionRepository.findAll(example);
	}

	@Override
	public List<FriendConnection> checkEmailExitOrNot(String userEmail, String friendEmail) {
		FriendConnection filterBy = new FriendConnection();
		filterBy.setUserEmail(userEmail);
		filterBy.setFriendEmail(friendEmail);

		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.EXACT).withIgnoreCase();

		Example<FriendConnection> example = Example.of(filterBy, matcher);
		return (List<FriendConnection>) friendConnectionRepository.findAll(example);
	}

	@Override
	public FriendConnection findByUserEmail(String userEmail) {
		return friendConnectionRepository.findByUserEmail(userEmail);
	}

	@Override
	public FriendConnection findByFriendEmail(String friendEmail) {
		return friendConnectionRepository.findByFriendEmail(friendEmail);
	}

	@Override
	public List<FriendConnection> getReceiveUpdate(String email) {
		FriendConnection filterBy = new FriendConnection();
		filterBy.setUserEmail(email);
		filterBy.setAreFriend(true);
		filterBy.setReceiveUpdate(true);
		filterBy.setBlocked(false);

		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.EXACT).withIgnoreCase();

		Example<FriendConnection> example = Example.of(filterBy, matcher);
		return (List<FriendConnection>) friendConnectionRepository.findAll(example);
	}
}

/**
 * 
 */
package com.thwet.friendmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thwet.friendmanagement.common.request.ReceiveUpdatesFriendRequest;
import com.thwet.friendmanagement.common.request.RequestFriendList;
import com.thwet.friendmanagement.common.request.RequestFriends;
import com.thwet.friendmanagement.common.request.SubscribeFriendRequest;
import com.thwet.friendmanagement.common.response.ResponseFriend;
import com.thwet.friendmanagement.exception.CustomException;
import com.thwet.friendmanagement.service.FriendManagementService;

import io.swagger.annotations.Api;

/**
 * @author Thwet Thwet Mar
 *
 *         Jan 31, 2020
 */
@RequestMapping("api")
@RestController
@Api(value = "FriendManagement API")
public class FriendManagementController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FriendManagementController.class);

	@Autowired
	private FriendManagementService friendManagementService;

	@PostMapping("/friends")
	public ResponseFriend friends(@Valid @RequestBody RequestFriends reqFriend) throws CustomException {
		LOGGER.info("Inside friends().");
		boolean success = friendManagementService.friend(reqFriend.getEmails());
		ResponseFriend resp = new ResponseFriend().setSuccess(success);
		return resp;
	}

	@PostMapping("/list")
	public ResponseFriend friendsList(@Valid @RequestBody RequestFriendList req) throws CustomException {
		LOGGER.info("Inside friendsList().");
		List<String> friendList = friendManagementService.friends(req.getEmail());
		ResponseFriend resp = new ResponseFriend().setSuccess(true).setFriends(friendList).setCount(friendList.size());

		return resp;
	}

	@PostMapping("/common")
	public ResponseFriend commmonFriends(@Valid @RequestBody RequestFriends req) throws CustomException {
		LOGGER.info("Inside commmonFriends().");
		List<String> commonList = friendManagementService.commonFriends(req.getEmails());
		ResponseFriend resp = new ResponseFriend().setSuccess(true).setFriends(commonList).setCount(commonList.size());

		return resp;

	}

	@PostMapping("/subscribe")
	public ResponseFriend subscribe(@Valid @RequestBody SubscribeFriendRequest req) throws CustomException {
		LOGGER.info("Inside subscribe().");
		boolean subscribed = friendManagementService.subscribe(req.getRequestor(), req.getTarget());
		ResponseFriend resp = new ResponseFriend().setSuccess(subscribed);
		return resp;
	}

	@PostMapping("/block")
	public ResponseFriend block(@Valid @RequestBody SubscribeFriendRequest req) throws CustomException {
		LOGGER.info("Inside block().");
		boolean subscribed = friendManagementService.block(req.getRequestor(), req.getTarget());
		ResponseFriend resp = new ResponseFriend().setSuccess(subscribed);
		return resp;
	}

	@PostMapping("/receiveUpdates")
	public ResponseFriend receiveUpdates(@Valid @RequestBody ReceiveUpdatesFriendRequest req)
			throws CustomException {
		LOGGER.info("Inside receiveUpdates().");
		List<String> updateFriends = friendManagementService.receiveUpdatesList(req.getSender());
		ResponseFriend resp = new ResponseFriend().setSuccess(true).setRecipients(updateFriends);
		return resp;
	}
}

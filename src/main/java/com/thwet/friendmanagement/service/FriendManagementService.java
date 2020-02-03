/**
 * 
 */
package com.thwet.friendmanagement.service;

import java.util.List;

import com.thwet.friendmanagement.exception.CustomException;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
public interface FriendManagementService {
	boolean friend(List<String> emailList) throws CustomException;

	List<String> friends(String email) throws CustomException;

	List<String> commonFriends(List<String> emailList) throws CustomException;

	boolean subscribe(String requestor, String target) throws CustomException;

	boolean block(String requestor, String target) throws CustomException;

	List<String> receiveUpdatesList(String email) throws CustomException;
}

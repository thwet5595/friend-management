/**
 * 
 */
package com.thwet.friendmanagement.common.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Thwet Thwet Mar
 *
 * Feb 1, 2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email" })
public class RequestFriendList {

	@JsonProperty("email")
	private String email;

	public RequestFriendList() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
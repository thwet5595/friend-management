/**
 * 
 */
package com.thwet.friendmanagement.common.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestor", "target" })
public class SubscribeFriendRequest {

	@JsonProperty("requestor")
	@Email
	@NotEmpty
	private String requestor;

	@JsonProperty("target")
	@Email
	@NotEmpty
	private String target;

	public String getRequestor() {
		return requestor;
	}

	public SubscribeFriendRequest setRequestor(String requestor) {
		this.requestor = requestor;
		return this;
	}

	public String getTarget() {
		return target;
	}

	public SubscribeFriendRequest setTarget(String target) {
		this.target = target;
		return this;
	}
}
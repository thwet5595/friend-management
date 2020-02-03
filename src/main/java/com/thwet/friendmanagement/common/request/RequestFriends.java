/**
 * 
 */
package com.thwet.friendmanagement.common.request;

import java.util.List;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Thwet Thwet Mar
 *
 * Feb 1, 2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "friends" })
public class RequestFriends {

	@JsonProperty("friends")
	@Size(min = 2, max = 2, message = "size must be 2")
	@ApiModelProperty(notes = "Request friends email")
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public RequestFriends setEmails(List<String> emails) {
		this.emails = emails;
		return this;
	}

	@Override
	public String toString() {
		return "RequestFriends [emails=" + emails + "]";
	}
}

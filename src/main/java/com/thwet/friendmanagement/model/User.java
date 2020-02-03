/**
 * 
 */
package com.thwet.friendmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Thwet Thwet Mar
 *
 *         Jan 31, 2020
 */
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "EMAIL", nullable = false)
	@ApiModelProperty(notes = "User Email")
	private String email;

	public User() {
	}

	public User(String email) {
		super();
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}

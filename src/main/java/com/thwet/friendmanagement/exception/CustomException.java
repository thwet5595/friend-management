/**
 * 
 */
package com.thwet.friendmanagement.exception;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}

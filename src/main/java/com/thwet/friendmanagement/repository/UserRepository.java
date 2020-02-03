/**
 * 
 */
package com.thwet.friendmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thwet.friendmanagement.model.User;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}

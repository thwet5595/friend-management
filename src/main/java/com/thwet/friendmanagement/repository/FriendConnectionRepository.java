/**
 * 
 */
package com.thwet.friendmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import com.thwet.friendmanagement.model.FriendConnection;

/**
 * @author Thwet Thwet Mar
 *
 *         Feb 1, 2020
 */
@Repository
public interface FriendConnectionRepository extends CrudRepository<FriendConnection, Long>,
		QueryByExampleExecutor<FriendConnection>, PagingAndSortingRepository<FriendConnection, Long> {
	@Query("SELECT r.friendEmail " + "FROM FriendConnection r " + "where r.userEmail in :emails "
			+ "and r.areFriend = true " + "group by r.friendEmail " + "having count(r.friendEmail) > 1 ")
	List<String> getCommonFriendList(@Param("emails") List<String> emails);

	FriendConnection findByUserEmail(String userEmail);

	FriendConnection findByFriendEmail(String friendEmail);
}

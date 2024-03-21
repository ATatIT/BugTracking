package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
		
	UserEntity findByEmail(String email);
	
	UserEntity findByEmailAndPass(String email, String password);
	
	List<UserEntity> findByFirstName(String firstName);
	
	List<UserEntity> findByFirstNameAndLastName(String firstName,String lastName);

	List<UserEntity> findByGender(String gender);
	
	
	
	@Query(value = " select u.*  from users u, taskuser tu where u.user_id = tu.userid and tu.task_id = :taskId",nativeQuery = true)
	List<UserEntity> getUserByTaskId(Integer taskId);
	
	// active user 1
	@Query(value = "select u.* from users u, projectuser pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 1",nativeQuery = true)
	List<UserEntity> getUserByProjectId(Integer projectId);
	
	//revoke 2
	@Query(value = "select u.* from users u, projectuser pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 2",nativeQuery = true)
	List<UserEntity> getUserByProjectIdRevoke(Integer projectId);
	
	//hold user 3
	@Query(value = "select u.* from users u, projectuser pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 3",nativeQuery = true)
	List<UserEntity> getUserByProjectIdHold(Integer projectId);
	
	//for pmuser
	@Query(value="select * from users where user_id in (select user_id from projectuser where project_id in (select project_id from projectuser where user_id  = :userId))",nativeQuery = true)
	List<UserEntity> pmTeam(Integer userId);
}

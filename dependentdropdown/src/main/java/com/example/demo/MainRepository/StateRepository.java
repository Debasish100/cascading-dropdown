package com.example.demo.MainRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.MainEntity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	
	/*
	 * @Query(value="SELECT us.sname,us.sid FROM csm.state us "
	 * 
	 * ,nativeQuery=true)
	 * 
	 * List<Object[]> findBycountry(@Param("id")String id);
	 */
	
@Query(value="SELECT us.sname,us.sid FROM csm.state us where us.cname=:id "
			
	 		,nativeQuery=true)

	List<Object[]> findBycountry(@Param("id")String id);
	
	
	

}

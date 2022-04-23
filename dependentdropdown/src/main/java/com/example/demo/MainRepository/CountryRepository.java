package com.example.demo.MainRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.MainEntity.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	
	
	
	  @Query("select cid,countryname from Country" ) 
	  List<Object[]> getCList();
	 
	  
	  @Query(value="SELECT us.statename,us.sid FROM csm.state us; "
		 		+ "where us.countryname=:sid ",nativeQuery=true)
		 List<Object[]> findvillagelist(@Param("sid")String sid);

}

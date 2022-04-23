package com.example.demo.ServiceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainEntity.Country;
import com.example.demo.MainRepository.CountryRepository;
import com.example.demo.MainService.CountryService;


@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository crepo;

	@Override
	public List<Country> getCountryList() {
		/*
		 * List<Country> clist = new ArrayList<Country>(); Country data = null;
		 * 
		 * try {
		 * 
		 * List<Object[]> cvo = crepo.getCList(); for (Object[] obj : cvo) { data = new
		 * Country(); data.setCid((int) obj[0]);
		 * data.setCountryname(String.valueOf(obj[1]));
		 * //data.setName(String.valueOf(obj[1])); clist.add(data); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } return clist;
		 */
		
		
		List<Country> profile = new ArrayList<Country>();
    	// List<Object[]> profile1 = null;
 		try {
 			//profile = aadhaarprofileRepository.gettingDistrictList();
 			profile = crepo.findAll();
 			//System.out.println("###"+profile);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return profile;
	}

	

}

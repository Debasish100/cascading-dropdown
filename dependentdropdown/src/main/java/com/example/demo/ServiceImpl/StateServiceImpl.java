package com.example.demo.ServiceImpl;


import java.math.BigInteger;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.StateRepository;
import com.example.demo.MainService.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	
	@Autowired
	StateRepository srepo;

	@Override
	public String listofstate(String cname) {
		
		
		JSONArray arr = new JSONArray();

		try {

			List<Object[]> object = null;
			object = srepo.findBycountry(cname);
			for (Object[] obj : object) {
				JSONObject json = new JSONObject();
			

			json.put("cname", cname);
			json.put("sname", (String) obj[0]);

			json.put("sid", (Integer) obj[1]);
			
			arr.put(json);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return arr.toString();
		
	}

	
	

}
	




package com.sl.ms.ordermanagement.communicator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sl.ms.ordermanagement.model.AccessTokenParam;
import com.sl.ms.ordermanagement.model.Products;
import com.sl.ms.ordermanagement.model.TokenResponse;

public class RestCommunicator {

	String prouctUrl = "https://balan1990-eval-test.apigee.net/inventorymanagement/dev/supportedproducts";
	
	public Products[] getAvailableProducts() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers1 = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers1);
		ResponseEntity<Products[]> items = restTemplate.exchange(prouctUrl, HttpMethod.GET, entity, Products[].class);
		Products[] productsArray = items.getBody();
		return productsArray;
	}

}

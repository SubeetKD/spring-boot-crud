package com.example.demo.restClient;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.custom.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Takes no input returns the same response to every request.
 * Don't know what to do
 */

@Component
public class RestClient {
	private static final String getAdharURL = "https://run.mocky.io/v3/b0607256-2d85-4617-a287-74dd5553429e";
	
    /*
     *  Get the adhar number of the user. Returns the same number for all the customer.
     */
	public static String getAdhar() throws BusinessException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(RestClient.getAdharURL, String.class);
			String adharNumber = null;
			if (response.getStatusCode() == HttpStatus.OK) {
				ObjectMapper mapper = new ObjectMapper();
				try {
					@SuppressWarnings("unchecked")
					Map<String,String> map = mapper.readValue(response.getBody(), Map.class);
					
					// it worked
					adharNumber = map.get("adharNumber");
				} catch (IOException e) {
					throw new BusinessException("700", "Error at paring respones in business layer. " + e.toString());
				}
			}
			return adharNumber;
		} catch (ResourceAccessException e) {
			throw new BusinessException("701","API request is not successfull. " + e.getMessage());
		}
		
	}
}

package com.kubetestui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KubeTestServiceImpl implements KubeTestService {

	@Autowired
	private RestTemplate template;

	@Value("${kubetest.url.one}")
	private String url1;

	@Value("${kubetest.url.two}")
	private String url2;

	@Override
	public String populateHostData1() {
		ResponseEntity<String> result1 = null;
		try {
			result1 = template.getForEntity(url1, String.class);
		} catch (Exception e) {
			return "KubeTestTwo: => " + "Not Found";
		}

		if (!result1.getBody().contains("Not Found")) {
			return "KubeTestTwo: => " + result1.getBody();
		} else {
			return "KubeTestTwo: => " + "Not Found";
		}
	}

	@Override
	public String populateHostData2() {
		ResponseEntity<String> result2 = null;
		try {
			result2 = template.getForEntity(url2, String.class);
		} catch (Exception e) {
			return "KubeTestTwo: => " + "Not Found";
		}

		if (!result2.getBody().contains("Not Found")) {
			return "KubeTestTwo: => " + result2.getBody();
		} else {
			return "KubeTestTwo: => " + "Not Found";
		}
	}

}

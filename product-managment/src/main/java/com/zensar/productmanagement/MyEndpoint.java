package com.zensar.productmanagement;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myend")
public class MyEndpoint {
	
	@ReadOperation
	public String sayHi() {
		return "<h2> Hi </h2>";
	}

}

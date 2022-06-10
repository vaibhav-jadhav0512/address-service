/**
 * 
 */
package com.address.app.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Vaibhav Jadhav
 *
 */
@FeignClient(name = "user-service", fallback = UserServiceFallBack.class)
public interface UserServiceProxy {

	@GetMapping("/get/user/{id}")
	public String getUserNameById(@PathVariable int id);

}

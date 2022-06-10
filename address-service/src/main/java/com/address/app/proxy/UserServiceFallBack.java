/**
 * 
 */
package com.address.app.proxy;

import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author Vaibhav Jadhav
 *
 */
public class UserServiceFallBack implements FallbackFactory<UserServiceProxy> {

	@Override
	public UserServiceProxy create(Throwable cause) {
		return new UserServiceProxy() {

			@Override
			public String getUserNameById(int id) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}

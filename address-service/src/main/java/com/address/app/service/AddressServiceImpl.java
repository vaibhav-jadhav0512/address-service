package com.address.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.app.dao.AddressDao;
import com.address.app.proxy.UserServiceProxy;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private UserServiceProxy userServiceProxy;

	@Override
	public String getAddressByUserId(int userId) {
		return addressDao.getAddressByUserId(userId);
	}

	@Override
	public String getUserNameById(int id) {
		return userServiceProxy.getUserNameById(id);
	}

}

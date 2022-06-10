/**
 * 
 */
package com.address.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.address.app.exception.AddressNotFoundException;
import com.address.app.queries.AddressServiceQueries;

/**
 * @author Vaibhav Jadhav
 *
 */
@Service
public class AddressDaoImpl implements AddressDao {

	@Autowired
	NamedParameterJdbcTemplate template;

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressDaoImpl.class);

	@Override
	public String getAddressByUserId(int userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", userId);
		String name = null;
		try {
			name = template.queryForObject(AddressServiceQueries.GET_ADDRESS_BY_ID, paramMap, String.class);
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("Address not found");
		}
		if (name == null)
			throw new AddressNotFoundException("Address not found");
		return name;
	}

}

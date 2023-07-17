package com.onlineKart.Utils.idGenerators;

import java.sql.Connection;
import java.sql.ResultSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddressIdGenerator implements IdentifierGenerator{
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "Adrs";
		String suffix = "";
		try {
			   String sql = "SELECT address_id_seq.nextval FROM dual ";
		     
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	

}

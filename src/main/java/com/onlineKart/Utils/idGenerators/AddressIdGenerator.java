package com.onlineKart.Utils.idGenerators;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Value;



public class AddressIdGenerator implements IdentifierGenerator{
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "add_";
		String suffix = "";

		try {
			return prefix+String.valueOf(UniqueIdGenerator.generateUniqueId()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
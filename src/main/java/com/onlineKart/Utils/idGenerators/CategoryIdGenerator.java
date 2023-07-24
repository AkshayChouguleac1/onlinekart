package com.onlineKart.Utils.idGenerators;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CategoryIdGenerator implements IdentifierGenerator{
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "cat_";
		String suffix = "";

		try {
			return prefix+String.valueOf(UniqueIdGenerator.generateUniqueId()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
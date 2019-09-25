package com.javadb.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testConnection() {
		try(Connection con  =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang", "madang")) {
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}

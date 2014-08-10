package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.impl.util.EncriptUtil;

public class TestEncript {

	@Test
	public void test() {
		String encryptPassword = EncriptUtil.encryptPassword("1234");
		
		System.out.println(encryptPassword);
	}

}

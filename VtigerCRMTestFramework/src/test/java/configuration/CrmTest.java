package configuration;

import java.util.Iterator;

import org.testng.annotations.Test;

import base_utility.BaseClass;

public class CrmTest {

//	IC => to execute the same TS multiple times, with same set of data we use IC
	@Test(invocationCount = 5)
	public void add() {
			System.out.println("create city => Noida");	
	}

	@Test(enabled = true)
	public void modify() {
//		System.out.println("create city => Noida");

		System.out.println("Modify city -> Dagri");
	}

	@Test(enabled = false)
	public void delete() {
//		System.out.println("create city => Noida");

//		System.out.println("Modify city -> Dagri");
//
//		System.out.println("Delete city -> Dagri ");
	}
	
//	DP => to execute the same TS multiple times, with same set of data we use DP


}

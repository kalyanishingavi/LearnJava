package com.service;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import com.junit.source.MapService;

public class TestMAp {
	MapService ms;
	@Before
	public void init() {
		ms = new MapService();
	}
	
	@Test
	public void test1() {
		assertEquals("team and Player Added" ,ms.addPlayer("CSK", "MSD"));
		assertEquals("team and Player Added" ,ms.addPlayer("MI", "rohit"));
		assertEquals("Player Added" ,ms.addPlayer("CSK", "Jadeja"));
		assertEquals("Player Added" ,ms.addPlayer("MI", "Hardik"));
		System.out.println(ms.ipl);
	}
	
	@Test
	public void test2() {
		assertEquals("Team not Found" ,ms.removePlayer("CSK", "MSD"));
		ms.addPlayer("CSK", "MSD");
		ms.addPlayer("MI", "rohit");
		assertEquals("Player Removed" ,ms.removePlayer("CSK", "MSD"));
		assertEquals("Player not found" ,ms.removePlayer("CSK", "MSD"));
	}
	
	@Test
	public void test3() {
		Map<String,Integer> map = new HashMap<String, Integer>();
		assertEquals(map ,ms.countPlayers());
		ms.addPlayer("CSK", "MSD");
		ms.addPlayer("MI", "rohit");
		ms.addPlayer("CSK", "Jadeja");
		map.put("CSK" ,2);
		map.put("MI", 1);
		assertEquals(map ,ms.countPlayers());
	}
}

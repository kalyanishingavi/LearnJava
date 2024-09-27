package com.junit.source;
import java.util.*;
import java.util.Map.Entry;
public class MapService {
	public Map<String , ArrayList<String>> ipl= new HashMap<>();
	
	public String addPlayer(String team,String Player) {
		boolean isPresent = ipl.containsKey(team);
		if(isPresent) {
			ArrayList<String> playerList = ipl.get(team);
			playerList.add(Player);
			return "Player Added";
		}
		
		else {
			ArrayList<String> playerList = new ArrayList<>();
			playerList.add(Player);
			ipl.put(team, playerList);
			
			return "team and Player Added";
		}
	}
	
	public String removePlayer(String team,String Player) {
		boolean isPresent = ipl.containsKey(team);
		
		if(isPresent) {
			ArrayList<String> list = ipl.get(team);
			if(list.remove(Player))
				return "Player Removed";
			return "Player not found";
		}
		return "Team not Found";
	}
	
	
	public Map countPlayers() {
		Map<String , Integer> count = new HashMap<>();
		for(String key : ipl.keySet()) {
			ArrayList<String> al = ipl.get(key);
			int num = al.size();
			count.put(key, num);
			
		}
		
//		for (Map.Entry<String, ArrayList<String>> entry: ipl.entrySet()) {
//			count.put(entry.getKey(), entry.getValue().size());
//		}
		return count;
		
	}
	
}

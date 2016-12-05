package stackoverflow;

import java.util.HashMap;
import java.util.Map;

public class LeagueManager {
	Map<String, Player> players = new HashMap<String, Player>();
	public void addPlayer(Player player) {
	    players.put(player.getNick(), player);
	}

	public void removePlayer(Player player) {
	    if (!players.isEmpty()) {
	        players.remove(player.getNick());
	    }
	}

	public Player getPlayer(String name) {
	    if (!players.isEmpty() && players.containsKey(name)) {
	        return (Player) players.get(name);
	    } else {
	        System.out.println("Error: there is no player with nick " + name);
	        return null;
	    }
	}

	public Player[] getAllPlayers() {
	    if (!players.isEmpty()) {
	        return players.values().toArray(new Player[players.size()]);
	    } else {
	        return null;
	    }
	}

	public void addPoints (String name, int points) {
	    if (players.containsKey(name)) {
	        Player pl = (Player) players.get(name);
	        pl.setPoints(points);
	    }
	}
}

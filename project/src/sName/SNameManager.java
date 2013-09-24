package sName;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;
import org.kitteh.tag.TagAPI;

import sName.settings.SSettings;

public class SNameManager
{
	
	HashMap<String, String> m_nameList = new HashMap<String,String>();
	SSettings m_settings;
	ScoreboardManager sb_manager = Bukkit.getScoreboardManager();

	public SNameManager(SSettings settings) {
		m_settings = settings;
	}

	/**
	 * saves names by SSetings delivered to constructor
	 * 
	 * @return return true on success
	 */
	public boolean save() {
		return m_settings.save(this);
	}

	/**
	 * loads names by SSetings delivered to constructor
	 * 
	 * @return return true on success
	 */
	public boolean load() {
		return m_settings.load(this);
	}

	/**
	 * Add player name to database
	 * If playername exist in db it change his alias to new.
	 * @param playerName
	 *            player name to add
	 * @return true if name exist in database
	 */
	public boolean addName(String playerName, String newName) {
		if(!m_nameList.containsValue(newName))
		{
			m_nameList.put(playerName, newName);
			SName.get().getLogger().log(Level.INFO, "Nazwwa gracza " + playerName + " to " + m_nameList.get(playerName));
			Player player = SName.get().getServer().getPlayer(playerName);
			if(player != null)
				setPlayerName( player, newName );
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Gets alias of playername
	 * @param playerName playername which alias will be searched for
	 * @return alias if exist, otherwise returns playername
	 */
	public String getPlayerName( String playerName )
	{
		String alias = m_nameList.get(playerName);
		if(alias != null)
			return alias;
		return playerName;
	}
	
	public HashMap<String, String> getList()
	{
		return m_nameList;
	}
	
	/**
	 * Gets alias of player
	 * @param playerName player which alias will be searched for
	 * @return alias if exist, otherwise returns name of the player
	 */
	public String getPlayerName( Player player )
	{
		SName.get().getLogger().log(Level.INFO, player.getName());
		String alias = m_nameList.get(player.getName());
		if(alias != null)
			return alias;
		return player.getName();
	}
	
	public void setPlayerName(Player player, String newname) {
		SName.get().getLogger().log(Level.INFO,"Zmieniamy nazwe " + player.getName() + " na " + newname);
        player.setDisplayName(newname);
        TagAPI.refreshPlayer(player);
        player.setPlayerListName(newname);
    }
}

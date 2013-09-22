package sName;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.entity.Player;

import sName.settings.SSettings;

public class SNameManager
{
	
	HashMap<String, String> m_nameList = new HashMap<String,String>();
	SSettings m_settings;

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
	 * 
	 * @param playerName
	 *            player name to add
	 * @return true if name exist in database
	 */
	public boolean addName(String playerName, String newName) {
		if (!checkExistance(newName)) {
			SName.get().getLogger().log(Level.INFO,"Playera nie ma w nameManagaerze");
			Player player = null;
			player = SName.get().getServer().getPlayer(playerName);
			
			String oldName = m_nameList.get(playerName);

			if (oldName == null) {
				m_nameList.put(playerName, newName);

			} else {
				oldName = newName;
			}
			if (player != null) {
				SName.get().getLogger().log(Level.INFO,"Zmieniamy nazwe " + player.getName() + " na " + newName);
				
				setPlayerName(player, newName);
			}
			return true;
		}
		return false;
	}

	public boolean deleteName(String newName) {
		return false;
	}

	/**
	 * Check existence of player in database
	 * 
	 * @param playerName
	 *            playerName to check
	 * @return true if original or new name exist in database
	 */
	public boolean checkExistance(String playerName) {
		for (String name : m_nameList.values())
			if ( playerName.equals(name) ) return true;
		return false;
	}
	
	public void setPlayerName(Player player, String newname) {
		SName.get().getLogger().log(Level.INFO,"Zmieniamy nazwe " + player.getName() + " na " + newname);
        player.setDisplayName(newname);
        player.setPlayerListName(newname);
    }
}

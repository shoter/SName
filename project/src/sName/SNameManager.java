package sName;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import sName.data.SPlayerName;
import sName.settings.SSettings;

public class SNameManager
{
	ArrayList<SPlayerName> m_nameList = new ArrayList<SPlayerName>();
	SSettings m_settings;
	
	public SNameManager(SSettings settings)
	{
		m_settings = settings;
	}
	
	/**
	 * saves names by SSetings delivered to constructor
	 * @return return true on success
	 */
	public boolean save()
	{
		return m_settings.save(this);
	}
	
	/**
	 * loads names by SSetings delivered to constructor
	 * @return return true on success
	 */
	public boolean load()
	{
		return m_settings.load(this);
	}
	
	public boolean addName(SPlayerName playerName)
	{
		if(!checkExistance(playerName))
		{
			m_nameList.add(playerName);
			Player player = playerName.getPlayer();
			if(player != null)
			{
				player.setDisplayName(playerName.newName);
			}
		}
		return false;
	}
	
	public boolean deleteName(String newName)
	{
		return false;
	}
	
	/**
	 * Check existence of player in database
	 * @param playerName playerName to check
	 * @return true if original or new name exist in database
	 */
	public boolean checkExistance(SPlayerName playerName)
	{
		for(SPlayerName name : m_nameList)
		{
			if(name.originalPlayerName == playerName.originalPlayerName 
			|| name.newName == name.newName)
				return true;
		}
		return false;
	}
}

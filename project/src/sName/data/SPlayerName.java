package sName.data;

import org.bukkit.entity.Player;

import sName.SName;

public class SPlayerName
{
	public String originalName;
	public String newName;
	
	public SPlayerName(String originalName, String newName)
	{
		this.originalName = originalName;
		this.newName = newName;
	}
	
	public SPlayerName()
	{}
	
	@Override
	public String toString() {
		return originalName+" "+newName;
	}
	
	public static SPlayerName ValueOf(String str)
	{
		SPlayerName retValue = new SPlayerName();
		String[] names = str.split(str);
		if(names.length == 2)
		{
			retValue.originalName = names[0];
			retValue.newName = names[1];
			
			return retValue;
		}
		return null;
	}
	
	public Player getPlayer()
	{
		Player player = SName.get().getServer().getPlayer(originalName);
		return player;
	}
}

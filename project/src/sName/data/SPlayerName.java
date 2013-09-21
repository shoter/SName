package sName.data;

import org.bukkit.entity.Player;

import sName.SName;

public class SPlayerName
{
	public String originalPlayerName;
	public String newName;
	
	@Override
	public String toString() {
		return originalPlayerName+" "+newName;
	}
	
	public static SPlayerName ValueOf(String str)
	{
		SPlayerName retValue = new SPlayerName();
		String[] names = str.split(str);
		if(names.length == 2)
		{
			retValue.originalPlayerName = names[0];
			retValue.newName = names[1];
			
			return retValue;
		}
		return null;
	}
	
	public Player getPlayer()
	{
		Player player = SName.get().getServer().getPlayer(originalPlayerName);
		return player;
	}
}

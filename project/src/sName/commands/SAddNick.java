package sName.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import sName.data.SPlayerName;

public class SAddNick extends SCommand
{

	public SAddNick() {
		super("s_changename", 2);
	}

	@Override
	public void execute(Command command, CommandSender sender, String[] args) {
		String playerName = args[0];
		String newName = args[1];
		if(plugin.getServer().getPlayer(playerName) != null)
		{
			SPlayerName sPlayerName = new SPlayerName( playerName, newName );
			plugin.m_nameManager.addName(sPlayerName);
		}
		
	}

}

package sName.commands;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SAddNick extends SCommand
{

	public SAddNick() {
		super("s_changename", 2);
	}

	@Override
	public void execute(Command command, CommandSender sender, String[] args) {
		String playerName = args[0];
		String newName = args[1];
		plugin.getLogger().log(Level.INFO,"Trying to add nick : " + playerName + " - " + newName);
		plugin.m_nameManager.addName(playerName, newName);
		}
		
	}

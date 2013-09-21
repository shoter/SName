package sName.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SAddNick extends SCommand
{

	public SAddNick(String name, int args_count) {
		super("s_changename", 2);
	}

	@Override
	public void execute(Command command, CommandSender sender, String[] args) {
		String playerName = args[0];
		String newName = args[1];
		if(plugin.getServer().getPlayer(playerName) != null)
		{
			
		}
		
	}

}

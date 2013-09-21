package sName.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import sName.SName;

public abstract class SCommand
{
	protected String name;
	protected int args_count;
	protected static SName plugin;
	/**
	 * 
	 * @param name name that will be used to invoke this command
	 * @param args_count number of the arguments that should be passed to this command
	 */
	public SCommand(String name, int args_count)
	{
		this.name = name;
		this.args_count = args_count;
		if(SCommand.plugin == null)
			SCommand.plugin = SName.get();
	}
	
	/**
	 * Run command if possible
	 * @param command command that player invoked
	 * @param sender who invoke the command
	 * @param args arguments to the command
	 * @return return on success, otherwise false
	 */
	public boolean run(Command command, CommandSender sender, String[] args)
	{
		if(canExecute(command, sender, args))
		{
			execute(command, sender,args);
			return true;
		}
		return false;
	}
	
	
	
	protected boolean canExecute(Command command, CommandSender sender, String[] args)
	{
		return (isSenderGood(sender) && isArgsGood(args) && matches(command));
	} 
	
	/**
	 * Test matching of the commands.
	 * @param command command to match with.
	 * @return true if commands are same.
	 */
	protected boolean matches(Command command)
	{
		return name == command.getName().toString();
	}
	
	protected boolean isSenderGood(CommandSender sender)
	{
		return true;
	}
	
	protected boolean isArgsGood(String[] args)
	{
		return args.length == args_count;
	}
	
	public abstract void execute(Command command, CommandSender sender, String[] args);
	
	
}

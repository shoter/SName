package sName;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.istack.internal.logging.Logger;

import sName.commands.SAddNick;
import sName.commands.SCommand;
import sName.events.ShoterPlayerListener;
import sName.settings.SEmptySettings;

public final class SName extends JavaPlugin {
	
	public ArrayList<SCommand> m_commandsList = new ArrayList<SCommand>();
	public SNameManager m_nameManager;
 
    @Override
    public void onEnable(){
    	plugin_instance = this;
    	m_commandsList.add(new SAddNick());
    	m_nameManager = new SNameManager(new SEmptySettings());
    	getServer().getPluginManager().registerEvents( new ShoterPlayerListener(m_nameManager), this);
    }
 
    @Override
    public void onDisable() {
        
    }
    
    public static SName get()
    {
    	return plugin_instance;
    }
    
    public void load()
    {
    	//TODO
    }
    
    public void save()
    {
    	//TODO
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command,
    		String label, String[] args) {
    	for(SCommand sCommand : m_commandsList)
    	{
    		if(sCommand.run(command, sender, args))
    		{
    			break;
    		}
    	}
    		
    	
    	return super.onCommand(sender, command, label, args);
    }
    
    private static SName plugin_instance;
}
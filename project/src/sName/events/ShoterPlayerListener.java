package sName.events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

import sName.SName;
import sName.SNameManager;

public class ShoterPlayerListener  implements Listener
{
	SNameManager manager;
	
	public ShoterPlayerListener( SNameManager manager )
	{
		this.manager = manager;
	}
	
	@EventHandler( priority = EventPriority.HIGHEST )
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event)
	{
		Iterator it = manager.getList().entrySet().iterator();
		String command = event.getMessage();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next(); 
	        command = command.replaceAll("\\s" + pairs.getValue() + "\\s{0,1}", " " + pairs.getKey()  + " ");
	    }
		event.setMessage(command);
	}
	
	@EventHandler
	public void onChatCommand(AsyncPlayerChatEvent  event)
	{
		String playerAlias = manager.getPlayerName(event.getPlayer());
		String format = event.getFormat();
		format = format.replace("%1$s", playerAlias);
		event.setFormat(format);
		SName.get().getLogger().log(Level.INFO, event.getPlayer().getName() + "-  wiad : " + event.getMessage() + " format : " + event.getFormat());
	}
	
	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event) {
	String playerAlias = manager.getPlayerName(event.getNamedPlayer());	
	if (event.getNamedPlayer().getName().equals(event.getNamedPlayer().getName())) {
		SName.get().getLogger().log(Level.INFO, event.getNamedPlayer() + "Zmieniamy na  " + playerAlias);
		event.setTag(playerAlias);
		}
	}
	
	@EventHandler
	public void onPlayerJoin( PlayerJoinEvent event )
	{
		String playerAlias = manager.getPlayerName(event.getPlayer());	
		if(playerAlias != event.getPlayer().getName())
			manager.setPlayerName(event.getPlayer(), playerAlias);
	}
	
	
}

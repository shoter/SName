package sName.events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
			Map.Entry<String,String> pairs = (Map.Entry<String,String>)it.next(); 
			SName.get().getLogger().log(Level.INFO, "Podmieniam " + pairs.getValue() + " na " + pairs.getKey());
	        command = command.replaceAll("\\s" + pairs.getValue() + "\\s{0,1}", " " + pairs.getKey()  + " ");
	    }
		SName.get().getLogger().log(Level.INFO, "Komenda = " + command);
		event.setMessage(command);
	}
	
	@EventHandler
	public void onChatCommand(AsyncPlayerChatEvent  event)
	{
		String playerAlias = manager.getPlayerName(event.getPlayer());
		event.setFormat("<"+playerAlias+"> %2$s");
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
	
	
}

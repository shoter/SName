package sName.settings;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import sName.SName;
import sName.SNameManager;

public class SConfigSettings extends SSettings
{

	@Override
	public boolean save(SNameManager manager) {
		FileConfiguration config = SName.get().getConfig();
		ConfigurationSection section = config.getConfigurationSection("SName.alias");
		if(section == null)
			section = config.createSection("SName.alias");
		
		Iterator it = manager.getList().entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, String> pairs = (Map.Entry<String, String>) it.next();
			savePair(section.createSection(pairs.getKey()), pairs);
		}
		
		SName.get().saveConfig();
		return true;

	}
	
	protected void savePair(ConfigurationSection section, Map.Entry<String, String> pair)
	{
		SName.get()
		.getLogger()
		.log(Level.INFO,
				"Zapisuje : " + pair.getKey() + " - "
						+ pair.getValue() + " do == " + section.getCurrentPath());
		SName.get().getConfig().set(section.getCurrentPath(), pair.getValue());
	}

	@Override
	public boolean load(SNameManager manager) {
		FileConfiguration config = SName.get().getConfig();
		ConfigurationSection section = config.getConfigurationSection("SName.alias");
		if(section != null)
		{
			Set<String> keys = section.getKeys(false);
			for(String string : keys)
				loadPair(manager, config, string);
		}
		return true;
	}
	
	protected void loadPair(SNameManager manager, FileConfiguration config,  String key)
	{
		String name = config.getString("SName.alias."+key);
		manager.addName(key, name);
	}

}

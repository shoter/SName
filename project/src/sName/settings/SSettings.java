package sName.settings;

import sName.SName;
import sName.SNameManager;

public abstract class SSettings
{
	protected SNameManager manager;
	public SSettings()
	{
		manager = SName.get().m_nameManager;
	}
	
	/**
	 * saves all things connected with plugin
	 * @return true on success
	 */
	public abstract boolean save();
	
	/**
	 * loads all things connected with plugin
	 * manager should be empty
	 * @return true on success
	 */
	public abstract boolean load();
}

package sName.settings;

import sName.SName;
import sName.SNameManager;

public abstract class SSettings
{
	/**
	 * saves all things connected with plugin
	 * @return true on success
	 */
	public abstract boolean save(SNameManager manager);
	
	/**
	 * loads all things connected with plugin
	 * manager should be empty
	 * @return true on success
	 */
	public abstract boolean load(SNameManager manager);
}

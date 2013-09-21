package sName.settings;

import sName.SNameManager;


public class SEmptySettings extends SSettings
{

	@Override
	public boolean save(SNameManager manager) {
		return true;
	}

	@Override
	public boolean load(SNameManager manager) {
		return true;
	}

}

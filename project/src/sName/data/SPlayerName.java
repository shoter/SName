package sName.data;

public class SPlayerName
{
	public String originalPlayerName;
	public String SPlayerName;
	
	@Override
	public String toString() {
		return originalPlayerName+" "+SPlayerName;
	}
	
	public static SPlayerName ValueOf(String str)
	{
		SPlayerName retValue = new SPlayerName();
		String[] names = str.split(str);
		if(names.length == 2)
		{
			retValue.originalPlayerName = names[0];
			retValue.SPlayerName = names[1];
			
			return retValue;
		}
		return null;
	}
}

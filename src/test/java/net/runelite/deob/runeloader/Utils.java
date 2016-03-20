package net.runelite.deob.runeloader;

public class Utils
{
	public static String toExportedName(String attrName)
	{
		if (attrName.startsWith("get"))
		{
			attrName = attrName.substring(3);
			attrName = Character.toLowerCase(attrName.charAt(0)) + attrName.substring(1);
		}

		if (attrName.equalsIgnoreCase("fps"))
			attrName = "FPS";

		return attrName;
	}
}

package net.runelite.rs.api;

import net.runelite.api.EnumDefinition;
import net.runelite.mapping.Import;

public interface RSEnumDefinition extends EnumDefinition, RSDualNode
{
	@Import("keys")
	@Override
	int[] getKeys();

	@Import("intVals")
	@Override
	int[] getIntVals();

	@Import("strVals")
	@Override
	String[] getStringVals();

	@Import("defaultInt")
	int getDefaultInt();

	@Import("defaultStr")
	String getDefaultString();
}

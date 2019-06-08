package net.runelite.rs.api;

import net.runelite.api.widgets.Widget;
import net.runelite.api.ScriptEvent;
import net.runelite.mapping.Import;

public interface RSScriptEvent extends ScriptEvent
{
	@Import("args0")
	Object[] getArguments();

	@Import("args0")
	void setArguments(Object[] args);

	@Import("widget")
	Widget getSource();

	@Import("opIndex")
	int getOp();

	@Import("targetName")
	String getOpbase();
}

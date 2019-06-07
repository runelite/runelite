package rs.api;

import api.ScriptEvent;
import api.widgets.Widget;
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

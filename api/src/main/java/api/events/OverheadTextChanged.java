package api.events;

import api.Actor;
import lombok.Value;

@Value
public class OverheadTextChanged
{
	private final Actor actor;

	private final String overheadText;
}
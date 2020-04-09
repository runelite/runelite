package net.runelite.client.plugins.screenmarkers;

import com.google.gson.Gson;
import java.util.stream.Collectors;
import lombok.Getter;

public class ScreenMarkerItem
{
	@Getter
	private boolean isGroup;

	@Getter
	private String groupMarkers;

	public String serialize()
	{
		Gson gson = new Gson();
		if (this instanceof ScreenMarker)
		{
			this.isGroup = false;
		}
		else if (this instanceof ScreenMarkerGroup)
		{
			this.isGroup = true;
			this.groupMarkers = gson.toJson(((ScreenMarkerGroup) this).getMarkers().stream().map(ScreenMarkerOverlay::getMarker).collect(Collectors.toList()));
		}
		return gson.toJson(this);
	}
}

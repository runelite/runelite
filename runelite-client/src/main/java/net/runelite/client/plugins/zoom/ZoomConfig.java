package net.runelite.client.plugins.zoom;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("zoom")
public interface ZoomConfig extends Config
{
	int OUTER_LIMIT_MIN = -400;
	int OUTER_LIMIT_MAX = 400;

	@ConfigItem(
		keyName = "inner",
		name = "Expand inner zoom limit",
		description = "Configures whether or not the inner zoom limit is reduced",
		position = 1
	)
	default boolean innerLimit()
	{
		return false;
	}

	@Range(
		min = OUTER_LIMIT_MIN,
		max = OUTER_LIMIT_MAX
	)
	@ConfigItem(
		keyName = "outerLimit",
		name = "Expand outer zoom limit",
		description = "Configures how much the outer zoom limit is adjusted",
		position = 2
	)
	default int outerLimit()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "relaxCameraPitch",
		name = "Vertical camera",
		description = "Relax the camera's upper pitch limit",
		position = 3
	)
	default boolean relaxCameraPitch()
	{
		return false;
	}


	@ConfigItem(
		keyName = "controlFunction",
		name = "Control Function",
		description = "Configures the zoom function when control is pressed",
		position = 5
	)
	default ControlFunction controlFunction()
	{
		return ControlFunction.NONE;
	}

	@ConfigItem(
		keyName = "ctrlZoomValue",
		name = "Reset zoom position",
		description = "Position of zoom when it is reset",
		position = 6
	)
	default int ctrlZoomValue()
	{
		return 600;
	}

	@ConfigItem(
		keyName = "zoomIncrement",
		name = "Zoom Speed",
		description = "Speed of zoom",
		position = 7
	)
	default int zoomIncrement()
	{
		return 25;
	}

}
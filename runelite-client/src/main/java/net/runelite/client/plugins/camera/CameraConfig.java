/*
 * Copyright (c) 2018 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.camera;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("zoom") // using the old plugin's group name
public interface CameraConfig extends Config
{
	int OUTER_LIMIT_MIN = -400;
	int OUTER_LIMIT_MAX = 400;
	/**
	 * The largest (most zoomed in) value that can be used without the client crashing.
	 *
	 * Larger values trigger an overflow in the engine's fov to scale code.
	 */
	int INNER_ZOOM_LIMIT = 1004;

	@ConfigSection(
		name = "Mouse Settings",
		description = "Mouse settings",
		position = 10
	)
	String mouseSettingsSection = "mouseSettings";

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
		name = "Expand pitch limit",
		description = "Relax the camera's upper and lower pitch limits. Allows vertical and horizontal camera movement.",
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
		position = 4
	)
	default ControlFunction controlFunction()
	{
		return ControlFunction.NONE;
	}

	@ConfigItem(
		keyName = "ctrlZoomValue",
		name = "Reset zoom position",
		description = "Position of zoom when it is reset",
		position = 5
	)
	@Range(
		min = OUTER_LIMIT_MIN,
		max = INNER_ZOOM_LIMIT
	)
	default int ctrlZoomValue()
	{
		return 512;
	}

	@ConfigItem(
		keyName = "zoomIncrement",
		name = "Zoom Speed",
		description = "Speed of zoom",
		position = 6
	)
	default int zoomIncrement()
	{
		return 25;
	}

	@ConfigItem(
		keyName = "cameraSpeed",
		name = "Camera Speed",
		description = "Speed which the camera moves from input",
		position = 7
	)
	default double cameraSpeed()
	{
		return 1f;
	}

	@ConfigItem(
		keyName = "disableCameraShake",
		name = "Disable Camera Shake",
		description = "Disables camera shake",
		position = 8
	)
	default boolean disableCameraShake()
	{
		return false;
	}

	// region mouse settings
	@ConfigItem(
		keyName = "rightClickMovesCamera",
		name = "Right click moves camera",
		description = "Remaps right click to middle mouse click",
		position = 7,
		section = mouseSettingsSection
	)
	default boolean rightClickMovesCamera()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickObjects",
		name = "Right click objects",
		description = "Right clicking objects opens the menu when 'Right click moves camera' is on",
		position = 8,
		section = mouseSettingsSection
	)
	default boolean rightClickObjects()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rightClickExamine",
		name = "Right click examine",
		description = "Right clicking examinable objects opens the menu when 'Right click moves camera' is on",
		position = 9,
		section = mouseSettingsSection
	)
	default boolean rightClickExamine()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickMenuBlocksCamera",
		name = "Right click menu blocks camera",
		description = "Prevents camera movement when 'Right click moves camera' is on and the right click menu<br>" +
			"is opened due to either 'Right click objects' or 'Right click examine' being on.",
		position = 10,
		section = mouseSettingsSection
	)
	default boolean rightClickMenuBlocksCamera()
	{
		return true;
	}

	@ConfigItem(
		keyName = "middleClickMenu",
		name = "Middle-button opens menu",
		description = "Remaps middle mouse click to right click",
		position = 11,
		section = mouseSettingsSection
	)
	default boolean middleClickMenu()
	{
		return false;
	}

	@ConfigItem(
		keyName = "invertYaw",
		name = "Invert Yaw",
		description = "Makes moving the camera horizontally with the mouse backwards",
		position = 12,
		section = mouseSettingsSection
	)
	default boolean invertYaw()
	{
		return false;
	}

	@ConfigItem(
		keyName = "invertPitch",
		name = "Invert Pitch",
		description = "Makes moving the camera vertically with the mouse backwards",
		position = 13,
		section = mouseSettingsSection
	)
	default boolean invertPitch()
	{
		return false;
	}
	// endregion
}

/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;
import static net.runelite.client.plugins.gpu.GpuPlugin.MAX_DISTANCE;
import static net.runelite.client.plugins.gpu.GpuPlugin.MAX_FOG_DEPTH;
import net.runelite.client.plugins.gpu.config.AnisotropicFilteringMode;
import net.runelite.client.plugins.gpu.config.AntiAliasingMode;

@ConfigGroup("gpu")
public interface GpuPluginConfig extends Config
{
	@ConfigTitleSection(
		keyName = "drawingTitle",
		name = "Drawing",
		description = "",
		position = 1
	)
	default Title drawingTitle()
	{
		return new Title();
	}

	@Range(
		min = 20,
		max = MAX_DISTANCE
	)
	@ConfigItem(
		keyName = "drawDistance",
		name = "Draw Distance",
		description = "Draw distance",
		position = 2,
		titleSection = "drawingTitle"
	)
	default int drawDistance()
	{
		return 25;
	}

	@ConfigItem(
		keyName = "smoothBanding",
		name = "Remove Color Banding",
		description = "Smooths out the color banding that is present in the CPU renderer",
		position = 3,
		titleSection = "drawingTitle"
	)
	default boolean smoothBanding()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "ppTitle",
		name = "Post processing",
		description = "",
		position = 4
	)
	default Title ppTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "antiAliasingMode",
		name = "Anti Aliasing",
		description = "Configures the anti-aliasing mode",
		position = 5,
		titleSection = "ppTitle"
	)
	default AntiAliasingMode antiAliasingMode()
	{
		return AntiAliasingMode.DISABLED;
	}

	@ConfigItem(
		keyName = "anisotropicFilteringMode",
		name = "Anisotropic Filtering",
		description = "Configures the anisotropic filtering mode",
		position = 6,
		titleSection = "ppTitle"
	)
	default AnisotropicFilteringMode anisotropicFilteringMode()
	{
		return AnisotropicFilteringMode.DISABLED;
	}

	@ConfigTitleSection(
		keyName = "fogTitle",
		name = "Fog",
		description = "",
		position = 7
	)
	default Title fogTitle()
	{
		return new Title();
	}

	@Range(
		max = MAX_FOG_DEPTH
	)
	@ConfigItem(
		keyName = "fogDepth",
		name = "Depth",
		description = "Distance from the scene edge the fog starts",
		position = 8,
		titleSection = "fogTitle"
	)
	default int fogDepth()
	{
		return 30;
	}

	@Range(
		max = MAX_FOG_DEPTH
	)
	@ConfigItem(
		keyName = "fogCircularity",
		name = "Roundness",
		description = "Fog circularity in %",
		position = 9,
		titleSection = "fogTitle"
	)
	default int fogCircularity()
	{
		return 30;
	}

	@Range(
		max = MAX_FOG_DEPTH
	)
	@ConfigItem(
		keyName = "fogDensity",
		name = "Density",
		description = "Relative fog thickness",
		position = 10,
		titleSection = "fogTitle"
	)
	default int fogDensity()
	{
		return 10;
	}
}
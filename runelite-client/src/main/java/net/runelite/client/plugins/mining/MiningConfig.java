/*
 * Copyright 2019 Jarred Vardy <jarredvardy@gmail.com>
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
package net.runelite.client.plugins.mining;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("mining")
public interface MiningConfig extends Config
{
	@ConfigItem(
		keyName = "showCoalBagOverlay",
		name = "Show coal bag overlay",
		description = "Overlays how much coal is inside of your coal bag"
	)
	default boolean showCoalBagOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "amountOfCoalInCoalBag",
		name = "",
		description = "To store coal amount between sessions",
		hidden = true
	)
	default int amountOfCoalInCoalBag()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "amountOfCoalInCoalBag",
		name = "",
		description = "Overload to set coal amount",
		hidden = true
	)
	void amountOfCoalInCoalBag(int amount);

	@Alpha
	@ConfigItem(
		keyName = "progressPieColor",
		name = "Main progress pie color",
		description = "Configures the color of the main progress pie"
	)
	default Color progressPieColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		keyName = "progressPieColorMotherlode",
		name = "Motherlode random respawn threshold progress pie color",
		description = "Configures the color of the progress pie after Motherlode respawn threshold"
	)
	default Color progressPieColorMotherlode()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "progressPieInverted",
		name = "Invert progress pie",
		description = "Configures whether the progress pie goes from empty to full or the other way around"
	)
	default boolean progressPieInverted()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 50
	)
	@ConfigItem(
		keyName = "progressPieDiameter",
		name = "Progress pie diameter",
		description = "Configures how big the progress pie is"
	)
	default int progressPieDiameter()
	{
		return 1;
	}
}

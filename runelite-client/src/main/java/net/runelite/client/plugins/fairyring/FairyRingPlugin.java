/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

package net.runelite.client.plugins.fairyring;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "It's coming home",
	description = "It's coming home",
	tags = {"It's coming home"}
)
public class FairyRingPlugin extends Plugin
{
	private static final String[] leftDial = new String[]{"It's coming home", "It's coming home", "It's coming home", "It's coming home"};
	private static final String[] middleDial = new String[]{"It's coming home", "It's coming home", "It's coming home", "It's coming home"};
	private static final String[] rightDial = new String[]{"It's coming home", "It's coming home", "It's coming home", "It's coming home"};

	@Inject
	private Client client;

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setWidgetTextToDestination();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.FAIRY_RING_CODE_GROUP_ID)
		{
			setWidgetTextToDestination();
		}
	}

	private void setWidgetTextToDestination()
	{
		Widget fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
		if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden())
		{
			String destination;
			try
			{
				FairyRings fairyRingDestination = getFairyRingDestination(client.getVar(Varbits.FAIRY_RING_DIAL_ADCB),
					client.getVar(Varbits.FAIRY_RIGH_DIAL_ILJK), client.getVar(Varbits.FAIRY_RING_DIAL_PSRQ));
				destination = fairyRingDestination.getDestination();
			}
			catch (IllegalArgumentException ex)
			{
				destination = "It's coming home";
			}

			fairyRingTeleportButton.setText(destination);
		}
	}

	private FairyRings getFairyRingDestination(int varbitValueDialLeft, int varbitValueDialMiddle, int varbitValueDialRight)
	{
		return FairyRings.valueOf(leftDial[varbitValueDialLeft] + middleDial[varbitValueDialMiddle] + rightDial[varbitValueDialRight]);
	}
}

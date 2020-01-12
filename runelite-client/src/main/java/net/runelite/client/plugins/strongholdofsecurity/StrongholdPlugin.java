/*
 * Copyright (c) 2019, FlaxOnEm <flax.on.em@gmail.com>
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
package net.runelite.client.plugins.strongholdofsecurity;

import net.runelite.api.Client;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.ColorUtil;
import javax.inject.Inject;
import java.awt.Color;

@PluginDescriptor(
	name = "Stronghold",
	description = "Highlights the correct answer to Stronghold of Security questions",
	tags = {"stronghold", "security", "overlay", "answer", "highlight"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
public class StrongholdPlugin extends Plugin
{
	private static final Color ANSWER_COLOR = new Color(230, 0, 230);

	@Inject
	private Client client;

	private boolean queueNPCDialogue;
	private boolean queueNPCOption;
	private String questionCache;

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		switch (widgetLoaded.getGroupId())
		{
			case WidgetID.DIALOG_NPC_GROUP_ID:
				queueNPCDialogue = true;
				break;
			case WidgetID.DIALOG_OPTION_GROUP_ID:
				queueNPCOption = true;
				break;
		}
	}

	@Subscribe
	public void onClientTick(ClientTick t)
	{
		if (queueNPCDialogue)
		{
			queueNPCDialogue = false;
			onNPCDialogue();
		}
		if (queueNPCOption)
		{
			queueNPCOption = false;
			onNPCOption();
		}
	}

	private void onNPCDialogue()
	{
		final Widget debugWidget = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);

		if (debugWidget == null)
		{
			return;
		}

		final String npcText = debugWidget.getText();
		if (StrongholdAnswer.MATCHES.containsKey(npcText))
		{
			questionCache = npcText;
		}
	}

	private void onNPCOption()
	{
		if (questionCache == null)
		{
			return;
		}

		final Widget optionsWidget = client.getWidget(WidgetInfo.DIALOG_OPTION);
		if (optionsWidget == null)
		{
			return;
		}

		final Widget[] widgets = optionsWidget.getParent().getChildren();

		final Widget answerWidget = StrongholdAnswer.findCorrect(questionCache, widgets);
		questionCache = null;
		if (answerWidget == null)
		{
			return;
		}

		final String answerText = answerWidget.getText();
		answerWidget.setText(ColorUtil.wrapWithColorTag(answerText, ANSWER_COLOR));
	}
}

/*
 * Copyright (c) 2019, tha23rd <https://https://github.com/tha23rd>
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
package net.runelite.api.queries;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import net.runelite.api.Client;
import net.runelite.api.QueryResults;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;

public class DialogQuery extends WidgetItemQuery
{

	@Override
	public QueryResults<WidgetItem> result(Client client)
	{
		Collection<WidgetItem> widgetItems = getDialogs(client);
		return new QueryResults<>(widgetItems.stream()
			.filter(Objects::nonNull)
			.filter(predicate)
			.collect(Collectors.toList()));
	}

	private Collection<WidgetItem> getDialogs(Client client)
	{
		boolean npcDialog = false;
		Collection<WidgetItem> widgetItems = new ArrayList<>();
		Widget dialog = client.getWidget(219, 1);
		if (dialog == null || dialog.isHidden())
		{
			dialog = client.getWidget(WidgetInfo.DIALOG_NPC);
			npcDialog = true;
		}
		if (dialog == null || dialog.isHidden())
		{
			dialog = client.getWidget(WidgetInfo.DIALOG_PLAYER);
			npcDialog = true;
		}

		if (dialog != null && !dialog.isHidden())
		{
			Widget[] children = npcDialog ? dialog.getStaticChildren() : dialog.getDynamicChildren();
			for (int i = 1; i < children.length; i++)
			{
				Widget child = children[i];
				// set bounds to same size as default inventory
				Rectangle bounds = child.getBounds();
				bounds.setBounds(bounds.x - 1, bounds.y - 1, 32, 32);
				widgetItems.add(new WidgetItem(child.getId(), child.getItemQuantity(), i - 1, bounds, child, null));
			}
		}
		return widgetItems;
	}

	public WidgetItemQuery textContains(String... texts)
	{
		predicate = and(widgetItem ->
		{
			for (String text : texts)
			{
				if (widgetItem.getWidget() != null)
				{
					String widgetText = widgetItem.getWidget().getText();
					if (widgetText != null && widgetText.contains(text))
					{
						return true;
					}
				}
			}
			return false;
		});
		return this;
	}
}

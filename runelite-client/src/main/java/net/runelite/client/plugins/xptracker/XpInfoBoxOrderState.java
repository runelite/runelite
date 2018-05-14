/*
 * Copyright (c) 2018, Grant <grant.dellar@live.com>
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
package net.runelite.client.plugins.xptracker;

import java.awt.Component;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;

class XpInfoBoxOrderState
{
	private XpTrackerConfig config;
	@Getter
	private List<XpInfoBox> infoBoxes;
	private XpInfoBox previousXpBox;

	XpInfoBoxOrderState(XpTrackerConfig config)
	{
		this.config = config;
	}

	void reorderInfoBoxOrderState()
	{
		if (infoBoxes == null || previousXpBox == null)
		{
			return;
		}

		SkillOrderType skillOrderType = config.skillOrder();

		switch (skillOrderType)
		{
			case LEAST_RECENT:
				infoBoxes.sort(Comparator.comparing(XpInfoBox::getAddedOrder));
				break;

			case MOST_RECENT:
				int newTopBoxIndex = infoBoxes.indexOf(previousXpBox);

				if (newTopBoxIndex > 0)
				{
					XpInfoBox box = infoBoxes.remove(newTopBoxIndex);
					infoBoxes.add(0, box);
				}
				break;

			case ALPHABETICAL:
				infoBoxes.sort(Comparator.comparing(box -> box.getSkill().getName()));
				break;
		}
	}

	void setInfoBoxOrderState(XpInfoBox infoBox, Component[] oldBoxOrder)
	{
		List<XpInfoBox> boxes = new LinkedList<>();

		for (Component component : oldBoxOrder)
		{
			boxes.add((XpInfoBox) component);
		}

		infoBoxes = boxes;
		previousXpBox = infoBox;
	}
}

/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.questhelper.quests.xmarksthespot;

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.Quest;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.questhelper.ItemRequirement;
import net.runelite.client.plugins.questhelper.QuestHelper;
import net.runelite.client.plugins.questhelper.steps.DigStep;
import net.runelite.client.plugins.questhelper.steps.NpcTalkStep;
import net.runelite.client.plugins.questhelper.steps.QuestStep;
import net.runelite.client.plugins.questhelper.QuestDescriptor;

@QuestDescriptor(
	quest = Quest.X_MARKS_THE_SPOT
)
public class XMarksTheSpot extends QuestHelper
{
	@Override
	protected Map<Integer, QuestStep> loadSteps()
	{
		Map<Integer, QuestStep> steps = new HashMap<>();

		steps.put(0, new NpcTalkStep(this, NpcID.VEOS_8484, new WorldPoint(3228, 3242, 0),
			"Talk to Veos in The Sheared Ram pub in Lumbridge to start the quest."));

		steps.put(1, steps.get(0));

		steps.put(2, new DigStep(this, new WorldPoint(3230, 3209, 0),
			"Dig north of Bob's Brilliant Axes, on the west side of the plant against the wall of his house.",
			new ItemRequirement(ItemID.TREASURE_SCROLL)));

		steps.put(3, new DigStep(this, new WorldPoint(3203, 3212, 0),
			"Dig behind Lumbridge Castle, just outside the kitchen door.",
			new ItemRequirement(ItemID.TREASURE_SCROLL_23068)));

		steps.put(4, new DigStep(this, new WorldPoint(3109, 3264, 0),
			"Dig north-west of the Draynor Village jail, just by the wheat farm.",
			new ItemRequirement(ItemID.MYSTERIOUS_ORB_23069)));

		steps.put(5, new DigStep(this, new WorldPoint(3078, 3259, 0),
			"Dig in the pig pen just west where Martin the Master Gardener is.",
			new ItemRequirement(ItemID.TREASURE_SCROLL_23070)));

		steps.put(6, new NpcTalkStep(this, NpcID.VEOS_8484, new WorldPoint(3054, 3245, 0),
			"Talk to Veos directly south of the Rusty Anchor Inn in Port Sarim to finish the quest.",
			new ItemRequirement(ItemID.ANCIENT_CASKET)));

		steps.put(7, new NpcTalkStep(this, NpcID.VEOS_8484, new WorldPoint(3054, 3245, 0),
			"Talk to Veos directly south of the Rusty Anchor Inn in Port Sarim to finish the quest."));

		return steps;
	}
}

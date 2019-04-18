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
package net.runelite.client.plugins.questhelper.quests.ernestthechicken;

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.NpcID;
import net.runelite.api.Quest;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.questhelper.QuestDescriptor;
import net.runelite.client.plugins.questhelper.questhelpers.BasicQuestHelper;
import net.runelite.client.plugins.questhelper.steps.NpcTalkStep;
import net.runelite.client.plugins.questhelper.steps.QuestStep;

@QuestDescriptor(
	quest = Quest.ERNEST_THE_CHICKEN
)
public class ErnestTheChicken extends BasicQuestHelper
{
	@Override
	public Map<Integer, QuestStep> loadSteps()
	{
		Map<Integer, QuestStep> steps = new HashMap<>();

		//TODO fix this step
		steps.put(0, new NpcTalkStep(this, NpcID.WIZARD_MIZGOG, new WorldPoint(3103, 3163, 2),
			"Talk to Wizard Mizgog on the top floor of the Wizards' Tower with the required items to finish the quest."));

		//fish food id: 272 wp: 3108, 3356, 1
		//poison: id: 273: wp: 3097, 3366, 0
		//poisoned fish food: id: 274

		steps.put(1, new ErnestPuzzleStep(this));

		return steps;
	}
}

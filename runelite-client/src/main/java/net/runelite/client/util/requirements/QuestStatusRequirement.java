/*
 * Copyright (c) 2020, Jordan Zomerlei <<https://github.com/JZomerlei>
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

package net.runelite.client.util.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

@Getter
@RequiredArgsConstructor
public class QuestStatusRequirement implements Requirement
{
	private final Quest quest;
	private final QuestState questStatus;

	public QuestStatusRequirement(Quest quest)
	{
		this(quest, QuestState.NOT_STARTED);
	}

	@Override
	public String toString()
	{
		if (questStatus == QuestState.FINISHED)
		{
			return "Completed " + quest.getName();
		}
		else if (questStatus == QuestState.IN_PROGRESS)
		{
			return "Started " + quest.getName();
		}
		else
		{
			return quest.getName();
		}
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		net.runelite.api.QuestState state = quest.getState(client);
		if (state.equals(net.runelite.api.QuestState.FINISHED) && quest.getState(client).equals(net.runelite.api.QuestState.IN_PROGRESS))
		{
			return true;
		}
		return state == quest.getState(client);
	}

}

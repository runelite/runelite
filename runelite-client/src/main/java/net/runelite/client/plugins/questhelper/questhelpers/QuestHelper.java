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
package net.runelite.client.plugins.questhelper.questhelpers;

import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.Collection;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.questhelper.steps.OwnerStep;
import net.runelite.client.plugins.questhelper.steps.QuestStep;

public abstract class QuestHelper implements Module
{
	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Getter
	private QuestStep currentStep;

	@Getter
	@Setter
	private Quest quest;

	@Setter
	private Injector injector;

	@Override
	public void configure(Binder binder)
	{
	}

	public abstract void startUp();

	public abstract void shutDown();

	public abstract boolean updateQuest();

	protected void startUpStep(QuestStep step)
	{
		if (step != null)
		{
			currentStep = step;
			currentStep.startUp();
			eventBus.register(currentStep);
		}
		else
		{
			currentStep = null;
		}
	}

	protected void shutDownStep()
	{
		if (currentStep != null)
		{
			eventBus.unregister(currentStep);
			currentStep.shutDown();
			currentStep = null;
		}
	}

	protected void instantiateSteps(Collection<QuestStep> steps)
	{
		for (QuestStep step : steps)
		{
			instantiateStep(step);
			if (step instanceof OwnerStep)
			{
				instantiateSteps(((OwnerStep) step).getSteps());
			}
		}
	}

	public void instantiateStep(QuestStep questStep)
	{
		try
		{
			injector.injectMembers(questStep);
		}
		catch (CreationException ex)
		{
			ex.printStackTrace();
		}
	}

	public boolean isCompleted()
	{
		return (quest.getState(client) == QuestState.FINISHED);
	}

	public int getVar()
	{
		return quest.getVar(client);
	}
}

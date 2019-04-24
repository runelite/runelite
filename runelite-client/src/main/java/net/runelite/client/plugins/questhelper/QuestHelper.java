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
package net.runelite.client.plugins.questhelper;

import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.questhelper.steps.QuestStep;

public abstract class QuestHelper implements Module
{
	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Getter
	protected QuestStep currentStep;

	protected Map<Integer, QuestStep> steps;
	protected Injector injector;
	@Getter
	@Setter
	private Quest quest;
	protected int var;

	@Override
	public void configure(Binder binder)
	{
	}

	protected void startUp() throws Exception
	{
		steps = loadSteps();
		instantiateSteps();
		var = getVar();
		startUpStep(var);
	}

	protected void shutDown() throws Exception
	{
		steps = null;
		shutDownStep();
	}

	protected void startUpStep(int i) throws Exception
	{
		if (steps.containsKey(i))
		{
			QuestStep step = steps.get(i);
			currentStep = step;
			eventBus.register(currentStep);
			currentStep.startUp();
		}
		else
		{
			currentStep = null;
		}
	}

	protected void shutDownStep() throws Exception
	{
		if (currentStep != null)
		{
			eventBus.unregister(currentStep);
			currentStep.shutDown();
			currentStep = null;
		}
	}

	protected void updateQuest() throws Exception
	{
		shutDownStep();
		if (!isCompleted())
		{
			currentStep = steps.get(getVar());
			currentStep.startUp();
		}
		else
		{
			currentStep = null;
		}
	}

	protected void instantiateSteps()
	{
		for (QuestStep step : steps.values())
		{
			try
			{
				injector.injectMembers(step);
			}
			catch (CreationException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	protected boolean isCompleted()
	{
		return (quest.getState(client) == QuestState.FINISHED);
	}

	protected int getVar()
	{
		return quest.getVar(client);
	}

	protected abstract Map<Integer, QuestStep> loadSteps();
}

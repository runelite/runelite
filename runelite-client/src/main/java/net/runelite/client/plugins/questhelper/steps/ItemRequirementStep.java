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
package net.runelite.client.plugins.questhelper.steps;

import java.awt.Graphics2D;
import java.util.Collection;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.questhelper.ItemRequirements;
import net.runelite.client.plugins.questhelper.QuestHelperPlugin;
import net.runelite.client.plugins.questhelper.questhelpers.QuestHelper;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class ItemRequirementStep extends QuestStep implements OwnerStep
{
	@Inject
	protected Client client;

	@Inject
	protected EventBus eventBus;

	private LinkedHashMap<ItemRequirements, QuestStep> steps;
	private QuestStep currentStep;

	public ItemRequirementStep(QuestHelper questHelper, LinkedHashMap<ItemRequirements, QuestStep> steps)
	{
		super(questHelper, null);
		this.steps = steps;
	}

	@Override
	public void startUp()
	{
		updateSteps();
	}

	@Override
	public void shutDown()
	{
		shutDownStep();
		currentStep = null;
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			updateSteps();
		}
	}

	private void updateSteps()
	{
		for (ItemRequirements itemRequirements : steps.keySet())
		{
			if (itemRequirements != null || !itemRequirements.check(client))
			{
				if (currentStep == null || !steps.get(itemRequirements).equals(currentStep))
				{
					shutDownStep();
					startUpStep(steps.get(itemRequirements));
				}
				break;
			}
		}

		if (steps.containsKey(null))
		{
			shutDownStep();
			startUpStep(steps.get(null));
		}
	}

	private void startUpStep(QuestStep step)
	{
		if (step != null)
		{
			currentStep = step;
			eventBus.register(currentStep);
			currentStep.startUp();
		}
		else
		{
			currentStep = null;
		}
	}

	private void shutDownStep()
	{
		if (currentStep != null)
		{
			eventBus.unregister(currentStep);
			currentStep.shutDown();
			currentStep = null;
		}
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, QuestHelperPlugin plugin)
	{
		currentStep.makeOverlayHint(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		currentStep.makeWorldOverlayHint(graphics, plugin);
	}

	@Override
	public Collection<QuestStep> getSteps()
	{
		return steps.values();
	}
}

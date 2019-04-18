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

import java.awt.Graphics2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ObjectID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.questhelper.QuestHelperPlugin;
import net.runelite.client.plugins.questhelper.Zone;
import net.runelite.client.plugins.questhelper.questhelpers.QuestHelper;
import net.runelite.client.plugins.questhelper.steps.ObjectStep;
import net.runelite.client.plugins.questhelper.steps.OwnerStep;
import net.runelite.client.plugins.questhelper.steps.QuestStep;
import net.runelite.client.plugins.questhelper.steps.TileStep;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class ErnestPuzzleStep extends QuestStep implements OwnerStep
{
	@Inject
	protected Client client;

	@Inject
	protected EventBus eventBus;

	private HashMap<Character, QuestStep> levers = new HashMap<>();
	private HashMap<Integer, QuestStep> doors = new HashMap<>();
	private TileStep oilCan = new TileStep(getQuestHelper(), new WorldPoint(3092, 9755, 0), "Pick up the Oil can");
	private ObjectStep cantFind = new ObjectStep(getQuestHelper(), ObjectID.LADDER_132, new WorldPoint(3117, 9754, 0),
		"Can't find what to do, reenter the basement to restart everything.");
	private Zone[] zones;
	private QuestStep currentStep;
	private WorldPoint lastWorldPoint;
	private boolean hasSet;

	//THIS IS A TEMP SOLUTION I KNOW THIS IS TRASH
	public ErnestPuzzleStep(QuestHelper questHelper)
	{
		super(questHelper, null);
		loadSteps();
	}

	@Override
	public void startUp()
	{
		loadZones();
		updateSteps();
	}

	@Override
	public void shutDown()
	{
		shutDownStep();
		currentStep = null;
		lastWorldPoint = null;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		WorldPoint currentWorldPoint = client.getLocalPlayer().getWorldLocation();
		if (lastWorldPoint == null || !currentWorldPoint.equals(lastWorldPoint))
		{
			updateSteps();
			lastWorldPoint = currentWorldPoint;
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		updateSteps();
	}

	private void updateSteps()
	{
		WorldPoint worldPoint = client.getLocalPlayer().getWorldLocation();
		hasSet = false;
		if (zones[0].contains(worldPoint))
		{
			if (checkLevers(0, 0, 0, 0, 0, 0))
			{
				startUpStep(levers.get('B'));
			}
			else if (checkLevers(0, 1, 0, 0, 0, 0))
			{
				startUpStep(levers.get('A'));
			}
			else if (checkLevers(1, 1, 0, 0, 0, 0))
			{
				startUpStep(doors.get(1));
			}
			else if (checkLevers(1, 1, 0, 1, 0, 0))
			{
				startUpStep(levers.get('A'));
			}
			else if (checkLevers(0, 1, 0, 1, 0, 0))
			{
				startUpStep(levers.get('B'));
			}
			else if (checkLevers(0, 0, 0, 1, 0, 0))
			{
				startUpStep(doors.get(3));
			}
			else if (checkLevers(0, 0, 1, 1, 0, 1))
			{
				startUpStep(doors.get(9));
			}
		}
		else if (zones[1].contains(worldPoint))
		{
			if (checkLevers(1, 1, 0, 0, 0, 0))
			{
				startUpStep(levers.get('D'));
			}
			else if (checkLevers(1, 1, 0, 1, 0, 0))
			{
				startUpStep(doors.get(1));
			}
			else if (checkLevers(0, 0, 0, 1, 1, 1))
			{
				startUpStep(levers.get('C'));
			}
			else if (checkLevers(0, 0, 1, 1, 1, 1))
			{
				startUpStep(doors.get(7));
			}
		}
		else if (zones[2].contains(worldPoint))
		{
			if (checkLevers(0, 0, 0, 1, 0, 0))
			{
				startUpStep(levers.get('E'));
			}
			else if (checkLevers(0, 0, 0, 1, 1, 0))
			{
				startUpStep(levers.get('F'));
			}
			else if (checkLevers(0, 0, 0, 1, 1, 1))
			{
				startUpStep(doors.get(6));
			}
			else if (checkLevers(0, 0, 1, 1, 1, 1))
			{
				startUpStep(levers.get('E'));
			}
			else if (checkLevers(0, 0, 1, 1, 0, 1))
			{
				startUpStep(doors.get(6));
			}
		}
		else if (zones[3].contains(worldPoint))
		{
			if (checkLevers(0, 0, 0, 1, 1, 1))
			{
				startUpStep(doors.get(7));
			}
			else if (checkLevers(0, 0, 1, 1, 1, 1))
			{
				startUpStep(doors.get(6));
			}
			else if (checkLevers(0, 0, 1, 1, 0, 1))
			{
				startUpStep(doors.get(8));
			}
		}
		else if (zones[4].contains(worldPoint))
		{
			if (checkLevers(0, 0, 0, 1, 0, 0))
			{
				startUpStep(doors.get(5));
			}
		}
		else if (zones[5].contains(worldPoint))
		{
			if (checkLevers(0, 0, 0, 1, 0, 0))
			{
				startUpStep(doors.get(4));
			}
			else if (checkLevers(0, 0, 1, 1, 0, 1))
			{
				startUpStep(doors.get(3));
			}
		}
		else if (zones[6].contains(worldPoint))
		{
			startUpStep(oilCan);
		}

		if (!hasSet)
		{
			startUpStep(cantFind);
		}
	}

	private void startUpStep(QuestStep step)
	{
		hasSet = true;
		if (step == null)
		{
			shutDownStep();
			return;
		}

		if (currentStep == null)
		{
			eventBus.register(step);
			step.startUp();
			currentStep = step;
			return;
		}

		if (!step.equals(currentStep))
		{
			shutDownStep();
			eventBus.register(step);
			step.startUp();
			currentStep = step;
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
		if (currentStep == null)
		{
			cantFind.makeOverlayHint(panelComponent, plugin);
			return;
		}
		currentStep.makeOverlayHint(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		if (currentStep == null)
		{
			return;
		}
		currentStep.makeWorldOverlayHint(graphics, plugin);
	}

	private boolean checkLevers(int a, int b, int c, int d, int e, int f)
	{
		if (client.getVar(Varbits.ERNEST_LEVER_A) == a
			&& client.getVar(Varbits.ERNEST_LEVER_B) == b
			&& client.getVar(Varbits.ERNEST_LEVER_C) == c
			&& client.getVar(Varbits.ERNEST_LEVER_D) == d
			&& client.getVar(Varbits.ERNEST_LEVER_E) == e
			&& client.getVar(Varbits.ERNEST_LEVER_F) == f)
		{
			return true;
		}

		return false;
	}

	// All values are based on this https://i.imgur.com/TjpAMAm.png
	private void loadSteps()
	{
		levers.put('A', new ObjectStep(getQuestHelper(), ObjectID.LEVER_A, new WorldPoint(3108, 9745, 0), "Pull lever A"));
		levers.put('B', new ObjectStep(getQuestHelper(), ObjectID.LEVER_B, new WorldPoint(3118, 9752, 0), "Pull lever B"));
		levers.put('C', new ObjectStep(getQuestHelper(), ObjectID.LEVER_C, new WorldPoint(3112, 9760, 0), "Pull lever C"));
		levers.put('D', new ObjectStep(getQuestHelper(), ObjectID.LEVER_D, new WorldPoint(3108, 9767, 0), "Pull lever D"));
		levers.put('E', new ObjectStep(getQuestHelper(), ObjectID.LEVER_E, new WorldPoint(3097, 9767, 0), "Pull lever E"));
		levers.put('F', new ObjectStep(getQuestHelper(), ObjectID.LEVER_F, new WorldPoint(3096, 9765, 0), "Pull lever F"));

		doors.put(1, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3108, 9758, 0), "Open door 1"));
		doors.put(2, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3105, 9760, 0), "Open door 2"));
		doors.put(3, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3102, 9758, 0), "Open door 3"));
		doors.put(4, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3100, 9760, 0), "Open door 4"));
		doors.put(5, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3097, 9763, 0), "Open door 5"));
		doors.put(6, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3100, 9765, 0), "Open door 6"));
		doors.put(7, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3105, 9765, 0), "Open door 7"));
		doors.put(8, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3102, 9763, 0), "Open door 8"));
		doors.put(9, new ObjectStep(getQuestHelper(), ObjectID.DOOR_11449, new WorldPoint(3100, 9755, 0), "Open door 9"));
	}

	// The Indexes of the zones are based on this https://i.imgur.com/TjpAMAm.png
	private void loadZones()
	{
		zones = new Zone[]{
			new Zone(new WorldPoint(3100, 9757, 0), new WorldPoint(3118, 9745, 0)),
			new Zone(new WorldPoint(3105, 9767, 0), new WorldPoint(3312, 9758, 0)),
			new Zone(new WorldPoint(3096, 9767, 0), new WorldPoint(3099, 9763, 0)),
			new Zone(new WorldPoint(3100, 9767, 0), new WorldPoint(3104, 9763, 0)),
			new Zone(new WorldPoint(3096, 9762, 0), new WorldPoint(3099, 9758, 0)),
			new Zone(new WorldPoint(3100, 9762, 0), new WorldPoint(3104, 9758, 0)),
			new Zone(new WorldPoint(3090, 9757, 0), new WorldPoint(3099, 9753, 0))
		};
	}

	@Override
	public Collection<QuestStep> getSteps()
	{
		Set<QuestStep> questSteps = new HashSet<>();
		questSteps.addAll(levers.values());
		questSteps.addAll(doors.values());
		questSteps.add(oilCan);
		questSteps.add(cantFind);
		return questSteps;
	}
}

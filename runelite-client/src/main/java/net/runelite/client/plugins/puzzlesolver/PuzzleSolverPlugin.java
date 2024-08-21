/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.puzzlesolver;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.puzzlesolver.lightbox.Combination;
import net.runelite.client.plugins.puzzlesolver.lightbox.LightBox;
import net.runelite.client.plugins.puzzlesolver.lightbox.LightboxSolution;
import net.runelite.client.plugins.puzzlesolver.lightbox.LightboxSolver;
import net.runelite.client.plugins.puzzlesolver.lightbox.LightboxState;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Puzzle Solver",
	description = "Show you where to click to solve puzzle boxes",
	tags = {"clues", "scrolls", "overlay"}
)
@Slf4j
public class PuzzleSolverPlugin extends Plugin
{
	private static final Color CORRECT_MUSEUM_PUZZLE_ANSWER_COLOR = new Color(0, 248, 128);

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PuzzleSolverOverlay overlay;

	@Inject
	private Client client;

	private LightboxState lightbox;
	private final LightboxState[] changes = new LightboxState[LightBox.COMBINATIONS_POWER];
	private Combination lastClick;
	private boolean lastClickInvalid;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Provides
	PuzzleSolverConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PuzzleSolverConfig.class);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widget)
	{
		if (widget.getGroupId() != InterfaceID.VARROCK_MUSEUM)
		{
			return;
		}

		final Widget questionWidget = client.getWidget(ComponentID.VARROCK_MUSEUM_QUESTION);

		if (questionWidget == null)
		{
			return;
		}

		final Widget answerWidget = VarrockMuseumAnswer.findCorrect(
			client,
			questionWidget.getText(),
			ComponentID.VARROCK_MUSEUM_FIRST_ANSWER,
			ComponentID.VARROCK_MUSEUM_SECOND_ANSWER,
			ComponentID.VARROCK_MUSEUM_THIRD_ANSWER);

		if (answerWidget == null)
		{
			return;
		}

		final String answerText = answerWidget.getText();
		if (answerText.equals(Text.removeTags(answerText)))
		{
			answerWidget.setText(ColorUtil.wrapWithColorTag(answerText, CORRECT_MUSEUM_PUZZLE_ANSWER_COLOR));
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		int widgetId = menuOptionClicked.getParam1();
		if (WidgetUtil.componentToInterface(widgetId) != InterfaceID.LIGHT_BOX)
		{
			return;
		}

		Combination combination;
		if (widgetId == ComponentID.LIGHT_BOX_BUTTON_A)
		{
			combination = Combination.A;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_B)
		{
			combination = Combination.B;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_C)
		{
			combination = Combination.C;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_D)
		{
			combination = Combination.D;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_E)
		{
			combination = Combination.E;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_F)
		{
			combination = Combination.F;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_G)
		{
			combination = Combination.G;
		}
		else if (widgetId == ComponentID.LIGHT_BOX_BUTTON_H)
		{
			combination = Combination.H;
		}
		else
		{
			return;
		}

		if (lastClick != null)
		{
			lastClickInvalid = true;
		}
		else
		{
			lastClick = combination;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Widget lightboxWidget = client.getWidget(ComponentID.LIGHT_BOX_LIGHT_BULB_CONTAINER);
		if (lightboxWidget == null)
		{
			if (lightbox != null)
			{
				lastClick = null;
				lastClickInvalid = false;
				lightbox = null;
				Arrays.fill(changes, null);
			}
			return;
		}

		// get current state from widget
		LightboxState lightboxState = new LightboxState();
		int index = 0;
		for (Widget light : lightboxWidget.getDynamicChildren())
		{
			boolean lit = light.getItemId() == LightBox.LIGHT_BULB_ON;
			lightboxState.setState(index / LightBox.WIDTH, index % LightBox.HEIGHT, lit);
			index++;
		}

		if (lightboxState.equals(lightbox))
		{
			return; // no change
		}

		log.debug("Lightbox changed!");

		LightboxState prev = lightbox;
		lightbox = lightboxState;

		if (lastClick == null || lastClickInvalid)
		{
			lastClick = null;
			lastClickInvalid = false;
			return;
		}

		LightboxState diff = lightboxState.diff(prev);
		changes[lastClick.ordinal()] = diff;

		log.debug("Recorded diff for {}", lastClick);
		lastClick = null;

		// try to solve
		LightboxSolver solver = new LightboxSolver();
		solver.setInitial(lightbox);
		int idx = 0;
		for (LightboxState state : changes)
		{
			if (state != null)
			{
				Combination combination = Combination.values()[idx];
				solver.setSwitchChange(combination, state);
			}
			++idx;
		}

		LightboxSolution solution = solver.solve();
		if (solution != null)
		{
			log.debug("Got solution: {}", solution);
		}

		// Set solution to title
		Widget lightbox = client.getWidget(ComponentID.LIGHT_BOX_LIGHT_BOX);
		if (lightbox != null)
		{
			Widget title = lightbox.getChild(1);
			if (solution != null && solution.numMoves() > 0)
			{
				title.setText("Light box - Solution: " + solution);
			}
			else if (solution != null)
			{
				title.setText("Light box - Solution: solved!");
			}
			else
			{
				title.setText("Light box - Solution: unknown");
			}
		}
	}
}

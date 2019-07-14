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
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_A;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_B;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_C;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_D;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_E;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_F;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_G;
import static net.runelite.api.widgets.WidgetInfo.LIGHT_BOX_BUTTON_H;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
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
@Singleton
public class PuzzleSolverPlugin extends Plugin
{
	private static final Color CORRECT_MUSEUM_PUZZLE_ANSWER_COLOR = new Color(0, 248, 128);

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PuzzleSolverOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private PuzzleSolverConfig config;

	@Inject
	private EventBus eventBus;

	private LightboxState lightbox;
	private final LightboxState[] changes = new LightboxState[LightBox.COMBINATIONS_POWER];
	private Combination lastClick;
	private boolean lastClickInvalid;

	@Getter(AccessLevel.PACKAGE)
	private boolean displaySolution;
	@Getter(AccessLevel.PACKAGE)
	private boolean displayRemainingMoves;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawDots;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	@Provides
	PuzzleSolverConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PuzzleSolverConfig.class);
	}

	private void onWidgetLoaded(WidgetLoaded widget)
	{
		if (widget.getGroupId() != WidgetID.VARROCK_MUSEUM_QUIZ_GROUP_ID)
		{
			return;
		}

		final Widget questionWidget = client.getWidget(WidgetInfo.VARROCK_MUSEUM_QUESTION);

		if (questionWidget == null)
		{
			return;
		}

		final Widget answerWidget = VarrockMuseumAnswer.findCorrect(
			client,
			questionWidget.getText(),
			WidgetInfo.VARROCK_MUSEUM_FIRST_ANSWER,
			WidgetInfo.VARROCK_MUSEUM_SECOND_ANSWER,
			WidgetInfo.VARROCK_MUSEUM_THIRD_ANSWER);

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

	private void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		int widgetId = menuOptionClicked.getActionParam1();
		if (TO_GROUP(widgetId) != WidgetID.LIGHT_BOX_GROUP_ID)
		{
			return;
		}

		Combination combination;
		if (widgetId == LIGHT_BOX_BUTTON_A.getId())
		{
			combination = Combination.A;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_B.getId())
		{
			combination = Combination.B;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_C.getId())
		{
			combination = Combination.C;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_D.getId())
		{
			combination = Combination.D;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_E.getId())
		{
			combination = Combination.E;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_F.getId())
		{
			combination = Combination.F;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_G.getId())
		{
			combination = Combination.G;
		}
		else if (widgetId == LIGHT_BOX_BUTTON_H.getId())
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

	public void onGameTick(GameTick event)
	{
		Widget lightboxWidget = client.getWidget(WidgetInfo.LIGHT_BOX_CONTENTS);
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
		Widget lightbox = client.getWidget(WidgetInfo.LIGHT_BOX);
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

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("puzzlesolver"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.displaySolution = config.displaySolution();
		this.displayRemainingMoves = config.displayRemainingMoves();
		this.drawDots = config.drawDots();
	}
}

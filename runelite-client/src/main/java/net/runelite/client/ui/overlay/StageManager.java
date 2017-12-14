/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay;

import com.google.common.eventbus.Subscribe;
import java.awt.Canvas;
import java.awt.Rectangle;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.events.GameStateChanged;
import net.runelite.client.events.ResizeableChanged;
import net.runelite.ui.Actor;
import net.runelite.ui.Group;
import net.runelite.ui.Stage;
import net.runelite.ui.components.ComponentGroup;
import net.runelite.ui.components.HorizontalGroup;
import net.runelite.ui.components.VerticalGroup;
import net.runelite.ui.util.Align;

@Slf4j
@Singleton
public class StageManager extends Stage {
	private static final int BORDER_TOP = 25;
	private static final int BORDER_LEFT = 5;
	private static final int BORDER_RIGHT = 5;
	private static final int BORDER_BOTTOM = 2;
	private static final int SPACING = 2;

	private final VerticalGroup topLeftGroup = new VerticalGroup();
	private final VerticalGroup topRightGroup = new VerticalGroup();
	private final HorizontalGroup bottomLeftGroup = new HorizontalGroup();
	private final VerticalGroup bottomRightGroup = new VerticalGroup();
	private final ComponentGroup dynamicGroup = new ComponentGroup();

	@Inject
	private Provider<Client> clientProvider;

	public StageManager()
	{
		super();
		getRoot().setVisible(false);

		topLeftGroup.setName(OverlayGroup.TOP_LEFT.name());
		topLeftGroup.setAlign(Align.topLeft);
		topLeftGroup.setPadTop(BORDER_TOP);
		topLeftGroup.setPadLeft(BORDER_LEFT);
		topLeftGroup.setSpace(SPACING);
		topLeftGroup.setFillParent(true);
		addActor(topLeftGroup);

		topRightGroup.setName(OverlayGroup.TOP_RIGHT.name());
		topRightGroup.setAlign(Align.topRight);
		topRightGroup.setPadTop(BORDER_TOP);
		topRightGroup.setPadLeft(BORDER_RIGHT);
		topRightGroup.setSpace(SPACING);
		topRightGroup.setFillParent(true);
		addActor(topRightGroup);

		bottomLeftGroup.setName(OverlayGroup.BOTTOM_LEFT.name());
		bottomLeftGroup.setAlign(Align.bottomLeft);
		bottomLeftGroup.setPadLeft(BORDER_LEFT);
		bottomLeftGroup.setPadBottom(BORDER_BOTTOM);
		bottomLeftGroup.setSpace(SPACING);
		bottomLeftGroup.setFillParent(true);
		addActor(bottomLeftGroup);

		bottomRightGroup.setName(OverlayGroup.BOTTOM_RIGHT.name());
		bottomRightGroup.setAlign(Align.bottomRight);
		bottomRightGroup.setPadRight(BORDER_RIGHT);
		bottomRightGroup.setPadBottom(BORDER_BOTTOM);
		bottomRightGroup.setSpace(SPACING);
		bottomRightGroup.setFillParent(true);
		addActor(bottomRightGroup);

		dynamicGroup.setName(OverlayGroup.DYNAMIC.name());
		dynamicGroup.setFillParent(true);
		addActor(dynamicGroup);
	}

	public Group findGroup(OverlayGroup group)
    {
        final Actor actor = getRoot().findActor(group.name());
        return actor instanceof Group ? (Group) actor : null;
    }

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState().equals(GameState.LOGGED_IN) || event.getGameState().equals(GameState.LOGIN_SCREEN))
		{
			updateStage();
		}
	}

	@Subscribe
	public void onResizableChanged(ResizeableChanged event)
	{
		updateStage();
	}


	private void updateStage()
	{
		final Client client = clientProvider.get();

		if (client == null)
		{
			return;
		}

		final Canvas canvas = client.getCanvas();
		setViewport(new Rectangle(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight()));

		final Widget chatbox = client.getWidget(WidgetInfo.CHATBOX);

		if (chatbox != null)
        {
			Rectangle bounds = chatbox.getBounds();
			bottomLeftGroup.setPadBottom(canvas.getHeight() - bounds.y + BORDER_BOTTOM);
			bottomLeftGroup.invalidateHierarchy();

			bottomRightGroup.setPadRight(canvas.getWidth() - bounds.width - bounds.x + BORDER_RIGHT);
			bottomRightGroup.setPadBottom(canvas.getHeight() - bounds.y + BORDER_BOTTOM);
			bottomRightGroup.invalidateHierarchy();

			topRightGroup.setPadRight(canvas.getWidth() - bounds.width - bounds.x + BORDER_RIGHT);
			topRightGroup.invalidateHierarchy();
		}

		getRoot().setVisible(true);
	}
}

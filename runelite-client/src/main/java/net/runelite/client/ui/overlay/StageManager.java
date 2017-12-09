package net.runelite.client.ui.overlay;

import com.google.common.eventbus.Subscribe;
import java.awt.Canvas;
import java.awt.Graphics2D;
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
import net.runelite.ui.Stage;
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

	@Inject
	private Provider<Client> clientProvider;

	public StageManager()
	{
		super();
		getRoot().setVisible(false);

		topLeftGroup.setName("TOP_LEFT_ROOT");
		topLeftGroup.setAlign(Align.topLeft);
		topLeftGroup.setPadTop(BORDER_TOP);
		topLeftGroup.setPadLeft(BORDER_LEFT);
		topLeftGroup.setSpace(SPACING);
		topLeftGroup.setFillParent(true);
		addActor(topLeftGroup);

		topRightGroup.setName("TOP_RIGHT_ROOT");
		topRightGroup.setAlign(Align.topRight);
		topRightGroup.setPadTop(BORDER_TOP);
		topRightGroup.setPadLeft(BORDER_RIGHT);
		topRightGroup.setSpace(SPACING);
		topRightGroup.setFillParent(true);
		addActor(topRightGroup);

		bottomLeftGroup.setName("BOTTOM_LEFT_ROOT");
		bottomLeftGroup.setAlign(Align.bottomLeft);
		bottomLeftGroup.setPadLeft(BORDER_LEFT);
		bottomLeftGroup.setPadBottom(BORDER_BOTTOM);
		bottomLeftGroup.setSpace(SPACING);
		bottomLeftGroup.setFillParent(true);
		addActor(bottomLeftGroup);

		bottomRightGroup.setName("BOTTOM_RIGHT_ROOT");
		bottomRightGroup.setAlign(Align.bottomRight);
		bottomRightGroup.setPadRight(BORDER_RIGHT);
		bottomRightGroup.setPadBottom(BORDER_BOTTOM);
		bottomRightGroup.setSpace(SPACING);
		bottomRightGroup.setFillParent(true);
		addActor(bottomRightGroup);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState().equals(GameState.LOGGED_IN))
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
		setGraphics((Graphics2D) client.getCanvas().getGraphics());

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

package net.runelite.client.plugins.whalewatchers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import org.apache.commons.lang3.ObjectUtils;

public class WhaleWatchersGloryOverlay extends Overlay
{
	private Client client;
	private final WhaleWatchersConfig config;
	private WhaleWatchersPlugin plugin;
	private PanelComponent panelComponent;

	@Inject
	private ItemManager itemManager;

	@Inject
	public WhaleWatchersGloryOverlay(WhaleWatchersConfig config, Client client, WhaleWatchersPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DETACHED);
		panelComponent = new PanelComponent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		int amuletID = 0;
		try
		{
			amuletID = client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.AMULET);
		}
		catch (NullPointerException e)
		{

		}
		if (config.gloryWarning() && amuletID == ItemID.AMULET_OF_GLORY)
		{
			panelComponent.setBackgroundColor(Color.lightGray);
			final AsyncBufferedImage gloryImage = itemManager.getImage(ItemID.AMULET_OF_GLORY);

			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Uncharged Glory")
				.color(Color.BLACK)
				.build());

			panelComponent.getChildren().add(new ImageComponent(gloryImage));
		}

		return panelComponent.render(graphics);
	}
}

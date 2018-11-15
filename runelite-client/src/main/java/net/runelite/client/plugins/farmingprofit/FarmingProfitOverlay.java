package net.runelite.client.plugins.farmingprofit;

import com.google.common.collect.Multiset;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class FarmingProfitOverlay extends Overlay
{
	private final Client client;
	private final FarmingProfitPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private FarmingProfitOverlay(Client client, FarmingProfitPlugin plugin)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (plugin.isStartedHarvesting())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("HARVESTING")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT HARVESTING")
				.color(Color.RED)
				.build());
		}

		if (plugin.getLatestRun() == null)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("LatestRun is null")
				.color(Color.GREEN)
				.build());
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Latest run ID: null")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(plugin.getLatestRun().toString())
				.color(Color.GREEN)
				.build());
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Latest run ID: " + plugin.getLatestRun().getGameObjClicked())
				.color(Color.GREEN)
				.build());
		}


		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Latest ID: " + plugin.getLatestObjID())
			.color(Color.GREEN)
			.build());
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Stored ID: " + plugin.getStoredObjID())
			.color(Color.GREEN)
			.build());

//		Multiset<Crop> cropInv = plugin.getPrevCropInv();
//		for (Crop crop : cropInv.elementSet())
//		{
//			panelComponent.getChildren().add(TitleComponent.builder()
//				.text(cropInv.count(crop) + "x " + crop.getDisplayName())
//				.color(Color.GREEN)
//				.build());
//		}

		return panelComponent.render(graphics);
	}
}

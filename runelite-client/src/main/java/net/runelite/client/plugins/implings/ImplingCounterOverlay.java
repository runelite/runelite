package net.runelite.client.plugins.implings;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class ImplingCounterOverlay extends Overlay
{
	private final ImplingsPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public ImplingCounterOverlay(final ImplingsPlugin plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isShowSpawn() || plugin.getImplings().isEmpty())
		{
			return null;
		}

		panelComponent.getChildren().clear();

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		for (Map.Entry<ImplingType, Integer> entry : plugin.getImplingCounterMap().entrySet())
		{
			if (plugin.showImplingType(entry.getKey()) && entry.getValue() != 0)
			{
				tableComponent.addRow(entry.getKey().getName(), entry.getValue().toString());
			}
		}

		panelComponent.getChildren().add(tableComponent);
		return panelComponent.render(graphics);
	}
}
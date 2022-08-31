// Decompiled with: CFR 0.151
// Class Version: 11
package net.runelite.client.plugins.zulrah.overlays;

import com.google.common.collect.LinkedHashMultimap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.client.plugins.zulrah.ZulrahConfig;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.constants.ZulrahType;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import org.apache.commons.lang3.tuple.MutablePair;

public class PhaseOverlay
	extends OverlayPanel
{
	private static final int DEFAULT_DIMENSION = 55;
	private static final int GAP = 1;
	private final ZulrahPlugin plugin;
	private final ZulrahConfig config;

	@Inject
	private PhaseOverlay(ZulrahPlugin plugin, ZulrahConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		this.setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.setPriority(OverlayPriority.HIGH);
		this.setResizable(false);
		this.panelComponent.setPreferredSize(new Dimension(56, 56));
		this.panelComponent.setBorder(new Rectangle());
		this.panelComponent.setGap(new Point(1, 1));
		this.panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.phaseDisplayType() == ZulrahConfig.DisplayType.OFF || config.phaseDisplayType() == ZulrahConfig.DisplayType.TILE || plugin.getZulrahNpc() == null || plugin.getZulrahNpc().isDead())
		{
			return null;
		}
		LinkedHashMultimap<ZulrahType, MutablePair<String, Boolean>> zulrahPhases = LinkedHashMultimap.create();
		plugin.getZulrahData().forEach(data -> {
			switch (config.phaseDisplayMode())
			{
				case CURRENT:
				{
					data.getCurrentPhase().ifPresent(phase -> zulrahPhases.put(phase.getZulrahNpc().getType(), new MutablePair<String, Boolean>("Current", false)));
					break;
				}
				case NEXT:
				{
					data.getNextPhase().ifPresent(phase -> zulrahPhases.put(phase.getZulrahNpc().getType(), new MutablePair<String, Boolean>(getNextString(), true)));
					break;
				}
				case BOTH:
				{
					data.getCurrentPhase().ifPresent(phase -> zulrahPhases.put(phase.getZulrahNpc().getType(), new MutablePair<String, Boolean>("Current", false)));
					data.getNextPhase().ifPresent(phase -> zulrahPhases.put(phase.getZulrahNpc().getType(), new MutablePair<String, Boolean>(getNextString(), true)));
					break;
				}
				default:
				{
					throw new IllegalStateException("[PhaseOverlay] Invalid 'phaseDisplayMode' config state");
				}
			}
		});
		if (zulrahPhases.size() <= 0)
		{
			return null;
		}

		List<InfoBoxComponent> components = zulrahPhases.entries().stream().map(this::infoBoxComponent).collect(Collectors.toList());
		components.forEach(i -> panelComponent.getChildren().add(i));
		if (config.phaseRotationName())
		{
			displayRotationName(graphics);
		}
		return super.render(graphics);
	}

	private String getNextString()
	{
		return plugin.getCurrentRotation() != null ? "Next" : "P. Next";
	}

	private InfoBoxComponent infoBoxComponent(Map.Entry<ZulrahType, MutablePair<String, Boolean>> entry)
	{
		InfoBoxComponent infoBox = new InfoBoxComponent();
		infoBox.setText(entry.getValue().getLeft());
		infoBox.setOutline(config.textOutline());
		infoBox.setColor(entry.getValue().getRight() == false ? Color.GREEN : Color.RED);
		infoBox.setImage(entry.getKey().getImage());
		infoBox.setBackgroundColor(entry.getKey().getColorWithAlpha(50));
		return infoBox;
	}

	private void displayRotationName(Graphics2D graphics)
	{
		Rectangle bounds = panelComponent.getBounds();
		String text = plugin.getCurrentRotation() != null ? plugin.getCurrentRotation().getRotationName() : "Unidentified";
		TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(bounds.x + (bounds.width - graphics.getFontMetrics().stringWidth(text)) / 2, bounds.y + 1));
		textComponent.setText(text);
		textComponent.setColor(plugin.getCurrentRotation() != null ? Color.GREEN : Color.YELLOW);
		textComponent.setOutline(config.textOutline());
		textComponent.render(graphics);
	}
}

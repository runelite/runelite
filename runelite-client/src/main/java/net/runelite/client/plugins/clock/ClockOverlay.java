package net.runelite.client.plugins.clock;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import net.runelite.client.plugins.clock.config.HourFormat;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class ClockOverlay extends Overlay
{
	private final ClockConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public ClockOverlay(ClockConfig config)
	{
		setPreferredPosition(OverlayPosition.BOTTOM_LEFT);
		setPriority(OverlayPriority.HIGH);

		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		String timeFormat = "";

		if (config.hourFormat() == HourFormat.TWELVE)
		{
			timeFormat += "hh:mm:ss";

			if (config.showMilliseconds())
			{
				timeFormat += ".S";
			}

			timeFormat += " a";
		}
		else
		{
			timeFormat += "HH:mm:ss";

			if (config.showMilliseconds())
			{
				timeFormat += ".S";
			}
		}

		String time = new SimpleDateFormat(timeFormat).format(
			Calendar.getInstance().getTime()
		);

		switch (config.font())
		{
			case SMALL:
				graphics.setFont(FontManager.getRunescapeSmallFont());
				break;
			case REGULAR:
				graphics.setFont(FontManager.getRunescapeFont());
				break;
			case BOLD:
				graphics.setFont(FontManager.getRunescapeBoldFont());
				break;
		}

		// Clock Title
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Clock")
			.build());

		// Clock Time
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(time)
			.build());

		return panelComponent.render(graphics);
	}
}

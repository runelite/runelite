package net.runelite.client.plugins.statusbars;

import java.awt.Graphics2D;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.statusbars.config.BarAlignment;
import net.runelite.client.plugins.statusbars.config.BarMode;

@RequiredArgsConstructor
class BarGroupRenderer
{
	private StatusBarsConfig config;


	private Map<BarMode, BarRenderer> barRendererModes;

	private BarRenderer leftBar;
	private BarRenderer rightBar;

	void attachRenderers(Map<BarMode, BarRenderer> rendererMap)
	{
		barRendererModes = rendererMap;
	}

	void updateConfig(StatusBarsConfig updatedConfig)
	{
		config = updatedConfig;

		leftBar = barRendererModes.get(config.leftBarMode());
		rightBar = barRendererModes.get(config.rightBarMode());
	}

	/**
	 * Renders the Bars attached to the Target Widget
	 *
	 * @param targetWidget    The widget to attach the Bars to
	 * @param currentViewport Information that helps layout the UI for the currently shown Widget
	 */
	void drawBars(Graphics2D graphics, Widget targetWidget, PossibleViewports currentViewport)
	{
		final Point origin = targetWidget.getCanvasLocation();
		final Point originOffset = currentViewport.getOriginOffset();

		final int targetWidgetHeight = targetWidget.getHeight();
		// Always add the fixed offset value, but the percentage is relative to the attached Widget
		final int barHeight = Math.round(targetWidgetHeight * (config.barHeight() / 100f)) + currentViewport.getBarHeightOffset();

		// If aligning to the bottom, we need to adjust the top position based on the overall height of the bar, minus any Y offsets
		int yOffset = config.barAlignment() == BarAlignment.TOP ? 0 : targetWidgetHeight - barHeight + currentViewport.getBarHeightOffset();

		int barWidth = currentViewport.getForcedBarWidth();
		if (barWidth == -1)
		{
			// Indicates a "not set" value
			barWidth = config.barWidth();
		}

		int barGap = config.barGap();

		int totalGroupWidth = 0;
		if (currentViewport == PossibleViewports.RESIZEABLE_MODERN)
		{
			// In resized/floating, we want to move the entire group to the left so that
			// the rightmost bar will be aligned as we expect
			final int barCount = leftBar == null ? 0 : 1 + (rightBar == null ? 0 : 1);
			totalGroupWidth = (barCount * barWidth) + (Math.max(0, barCount - 1) * barGap);
		}
		else
		{
			// Positions the bars on either side of the Widget
			barGap = targetWidget.getWidth();
		}

		// Combine all our prior adjustments into a single object
		final Point adjustedOrigin = new Point(
			origin.getX() + originOffset.getX() - totalGroupWidth,
			origin.getY() + originOffset.getY() + yOffset
		);

		int currentX = adjustedOrigin.getX(),
			currentY = adjustedOrigin.getY();

		if (leftBar != null)
		{
			leftBar.renderBar(config, graphics, currentX, currentY, barWidth, barHeight);
		}

		if (leftBar != null || currentViewport != PossibleViewports.RESIZEABLE_MODERN)
		{
			// When aligning the bars to a Classic UI panel, we always want to include
			// the barGap so that if only the Right bar is configured, then it will still
			// end up in the correct response
			currentX += barWidth + barGap;
		}

		if (rightBar != null)
		{
			rightBar.renderBar(config, graphics, currentX, currentY, barWidth, barHeight);
		}
	}
}

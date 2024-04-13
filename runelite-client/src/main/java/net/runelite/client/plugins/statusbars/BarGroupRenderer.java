package net.runelite.client.plugins.statusbars;

import java.awt.Graphics2D;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.statusbars.config.BarMode;

@RequiredArgsConstructor
class BarGroupRenderer
{
	private Map<BarMode, BarRenderer> barRenderers;

	void attachRenderers(Map<BarMode, BarRenderer> rendererMap)
	{
		barRenderers = rendererMap;
	}

	/**
	 * Renders one or more Status Bars, as a singular group for placement purposes
	 *
	 * @param config   Plugin configuration which dictates certain settings, such as whether to show restoration bars and
	 *                 whether or not to draw icons.
	 * @param graphics Graphics.
	 */
	void renderBars(StatusBarsConfig config, Graphics2D graphics, Widget targetWidget, PossibleViewports currentViewport)
	{
		// Grab the appropriate renderers for each bar
		BarRenderer leftBar = barRenderers.get(config.leftBarMode()),
			rightBar = barRenderers.get(config.rightBarMode());

		//#region Determine bar positioning values
		final Point origin = targetWidget.getCanvasLocation();
		final Point originOffset = currentViewport.getOriginOffset();

		// Adjust the height and width of our bars as necessary
		int barHeight = targetWidget.getHeight() + currentViewport.getBarHeightOffset();
		int barWidth = currentViewport.getForcedBarWidth();
		if (barWidth <= -1)
		{
			// Indicates a "no force" value, so use the config value
			barWidth = config.barWidth();
		}

		// Adjust the positioning based on offset and total group size
		int barGap = config.barGap();

		int currentX = origin.getX() + originOffset.getX(),
			currentY = origin.getY() + originOffset.getY();

		if (currentViewport != PossibleViewports.RESIZEABLE_MODERN)
		{
			// Fixed/Classic layouts have bars on either side of the interface, so we need to change the
			// barGap to align things properly
			barGap = targetWidget.getWidth();
		}
		else
		{
			// In resized/floating, we want to move the entire group to the left so that
			// the rightmost bar will be aligned as we expect
			int totalGroupWidth = (leftBar != null ? barWidth + barGap : 0) + (rightBar != null ? barWidth : 0);
			currentX -= totalGroupWidth;
		}
		//#endregion

		// Now we can actually render both bars
		if (leftBar != null)
		{
			leftBar.renderBar(config, graphics, currentX, currentY, barWidth, barHeight);

			// Increase the offset by barGap so the next bar is correctly positioned
			currentX += barWidth + barGap;
		}

		if (rightBar != null)
		{
			rightBar.renderBar(config, graphics, currentX, currentY, barWidth, barHeight);
		}

	}
}

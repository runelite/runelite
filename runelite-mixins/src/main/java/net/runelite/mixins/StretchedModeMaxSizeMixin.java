package net.runelite.mixins;


import java.awt.Dimension;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameShell;

@Mixin(RSGameShell.class)
public abstract class StretchedModeMaxSizeMixin implements RSGameShell
{
	@Shadow("client")
	private static RSClient client;

	@Copy("resizeCanvas")
	abstract void rs$resizeCanvas();

	@Replace("resizeCanvas")
	public void rl$resizeCanvas()
	{
		if (client.isStretchedEnabled())
		{
			client.invalidateStretching(false);

			if (client.isResized())
			{
				Dimension realDimensions = client.getRealDimensions();

				setMaxCanvasWidth(realDimensions.width);
				setMaxCanvasHeight(realDimensions.height);
			}
		}

		rs$resizeCanvas();
	}

	@Copy("setMaxCanvasSize")
	abstract void rs$setMaxCanvasSize(int width, int height);

	@Replace("setMaxCanvasSize")
	public void rl$setMaxCanvasSize(int width, int height)
	{
		if (client.isStretchedEnabled() && client.isResized())
		{
			return;
		}

		rs$setMaxCanvasSize(width, height);
	}
}

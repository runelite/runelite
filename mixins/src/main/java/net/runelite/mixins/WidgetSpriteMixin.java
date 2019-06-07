package net.runelite.mixins;

import api.Sprite;
import java.util.Map;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSSprite;
import rs.api.RSWidget;

@Mixin(RSWidget.class)
public abstract class WidgetSpriteMixin implements RSWidget
{
	@Shadow("widgetSpriteOverrides")
	private static Map<Integer, Sprite> widgetSpriteOverrides;

	@Copy("getSprite")
	public RSSprite rs$getWidgetSprite(boolean var1)
	{
		throw new RuntimeException();
	}

	@Replace("getSprite")
	public RSSprite rl$getWidgetSprite(boolean var1)
	{
		if (getSpriteId() != -1)
		{
			Sprite sprite = widgetSpriteOverrides.get(getId());

			if (sprite != null)
			{
				return (RSSprite) sprite;
			}
		}

		return rs$getWidgetSprite(var1);
	}
}
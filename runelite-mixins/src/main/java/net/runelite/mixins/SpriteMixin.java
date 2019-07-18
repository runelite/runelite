package net.runelite.mixins;

import net.runelite.api.Sprite;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSSprite;

@Mixin(RSClient.class)
public abstract class SpriteMixin implements RSClient
{
	@Inject
	private static final Map<Integer, Sprite> spriteOverrides = new HashMap<Integer, Sprite>();

	@Inject
	private static final Map<Integer, Sprite> widgetSpriteOverrides = new HashMap<Integer, Sprite>();

	@Inject
	@Override
	public Map<Integer, Sprite> getSpriteOverrides()
	{
		return spriteOverrides;
	}

	@Inject
	@Override
	public Map<Integer, Sprite> getWidgetSpriteOverrides()
	{
		return widgetSpriteOverrides;
	}
}
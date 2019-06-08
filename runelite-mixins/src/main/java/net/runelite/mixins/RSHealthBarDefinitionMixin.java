package net.runelite.mixins;

import net.runelite.api.HealthBarOverride;
import net.runelite.api.events.PostHealthBar;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSBuffer;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSSprite;

@Mixin(RSHealthBarDefinition.class)
public abstract class RSHealthBarDefinitionMixin implements RSHealthBarDefinition
{
	// Larger values are used for bosses like Corporeal Beast
	private static final int DEFAULT_HEALTH_SCALE = 30;

	@Shadow("client")
	private static RSClient client;

	@Shadow("healthBarOverride")
	private static HealthBarOverride healthBarOverride;

	@Copy("getSprite2")
	abstract RSSprite rs$getHealthBarBackSprite();

	@Replace("getSprite2")
	public RSSprite rl$getHealthBarBackSprite()
	{
		/*
		 * If this combat info already uses sprites for health bars,
		 * use those instead, and don't override.
		 */
		RSSprite pixels = rs$getHealthBarBackSprite();
		if (pixels != null)
		{
			return pixels;
		}

		if (healthBarOverride == null)
		{
			return null;
		}

		return getHealthScale() == DEFAULT_HEALTH_SCALE
			? (RSSprite) healthBarOverride.backSprite
			: (RSSprite) healthBarOverride.backSpriteLarge;
	}

	@Copy("getSprite1")
	abstract RSSprite rs$getHealthBarFrontSprite();

	@Replace("getSprite1")
	public RSSprite rl$getHealthBarFrontSprite()
	{
		/*
		 * If this combat info already uses sprites for health bars,
		 * use those instead, and don't override.
		 */
		RSSprite pixels = rs$getHealthBarFrontSprite();
		if (pixels != null)
		{
			return pixels;
		}

		if (healthBarOverride == null)
		{
			return null;
		}

		// 30 is the default size, large is for bosses like Corporeal Beast
		return getHealthScale() == DEFAULT_HEALTH_SCALE
			? (RSSprite) healthBarOverride.frontSprite
			: (RSSprite) healthBarOverride.frontSpriteLarge;
	}

	@MethodHook(value = "read", end = true)
	@Inject
	public void onRead(RSBuffer buffer)
	{
		PostHealthBar postHealthBar = new PostHealthBar();
		postHealthBar.setHealthBar(this);
		client.getCallbacks().post(postHealthBar);
	}
}

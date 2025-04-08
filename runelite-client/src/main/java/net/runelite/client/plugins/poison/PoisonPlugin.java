/*
 * Copyright (c) 2018 Hydrox6 <ikada@protonmail.ch>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.poison;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.SpriteID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.AlternateSprites;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Poison",
	description = "Tracks current damage values for Poison and Venom",
	tags = {"combat", "poison", "venom", "heart", "hp"}
)
public class PoisonPlugin extends Plugin
{
	static final int POISON_TICK_MILLIS = 18200;
	private static final int VENOM_THRESHOLD = 1000000;
	private static final int VENOM_MAXIUMUM_DAMAGE = 20;

	private static final BufferedImage HEART_DISEASE;
	private static final BufferedImage HEART_POISON;
	private static final BufferedImage HEART_VENOM;

	static
	{
		HEART_DISEASE = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.DISEASE_HEART), 26, 26);
		HEART_POISON = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.POISON_HEART), 26, 26);
		HEART_VENOM = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.VENOM_HEART), 26, 26);
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private PoisonOverlay poisonOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private PoisonConfig config;

	@Getter
	private int lastDamage;
	private boolean envenomed;
	private PoisonInfobox infobox;
	private Instant poisonNaturalCure;
	private Instant nextPoisonTick;
	private BufferedImage heart;

	@Provides
	PoisonConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PoisonConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(poisonOverlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(this::checkHealthIcon);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(poisonOverlay);

		if (infobox != null)
		{
			infoBoxManager.removeInfoBox(infobox);
			infobox = null;
		}

		envenomed = false;
		lastDamage = 0;
		poisonNaturalCure = null;
		nextPoisonTick = null;

		clientThread.invoke(this::resetHealthIcon);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayerID.POISON)
		{
			final int poisonValue = event.getValue();
			nextPoisonTick = Instant.now().plus(Duration.of(POISON_TICK_MILLIS, ChronoUnit.MILLIS));

			final int damage = nextDamage(poisonValue);
			this.lastDamage = damage;

			envenomed = poisonValue >= VENOM_THRESHOLD;

			if (poisonValue < VENOM_THRESHOLD)
			{
				poisonNaturalCure = Instant.now().plus(Duration.of(POISON_TICK_MILLIS * poisonValue, ChronoUnit.MILLIS));
			}
			else
			{
				poisonNaturalCure = null;
			}

			if (config.showInfoboxes())
			{
				if (infobox != null)
				{
					infoBoxManager.removeInfoBox(infobox);
					infobox = null;
				}

				if (damage > 0)
				{
					final BufferedImage image = getSplat(envenomed ? SpriteID.HITSPLAT_DARK_GREEN_VENOM : SpriteID.HITSPLAT_GREEN_POISON, damage);

					if (image != null)
					{
						infobox = new PoisonInfobox(image, this);
						infoBoxManager.addInfoBox(infobox);
					}
				}
			}

			checkHealthIcon();
		}
		else if (event.getVarpId() == VarPlayerID.DISEASE)
		{
			checkHealthIcon();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(PoisonConfig.GROUP))
		{
			return;
		}

		if (!config.showInfoboxes() && infobox != null)
		{
			infoBoxManager.removeInfoBox(infobox);
			infobox = null;
		}

		if (config.changeHealthIcon())
		{
			clientThread.invoke(this::checkHealthIcon);
		}
		else
		{
			clientThread.invoke(this::resetHealthIcon);
		}
	}

	private static int nextDamage(int poisonValue)
	{
		int damage;

		if (poisonValue >= VENOM_THRESHOLD)
		{
			//Venom Damage starts at 6, and increments in twos;
			//The VarPlayer increments in values of 1, however.
			poisonValue -= VENOM_THRESHOLD - 3;
			damage = poisonValue * 2;
			//Venom Damage caps at 20, but the VarPlayer keeps increasing
			if (damage > VENOM_MAXIUMUM_DAMAGE)
			{
				damage = VENOM_MAXIUMUM_DAMAGE;
			}
		}
		else
		{
			damage = (int) Math.ceil(poisonValue / 5.0f);
		}

		return damage;
	}

	private BufferedImage getSplat(int id, int damage)
	{
		//Get a copy of the hitsplat to get a clean one each time
		final BufferedImage rawSplat = spriteManager.getSprite(id, 0);
		if (rawSplat == null)
		{
			return null;
		}

		final BufferedImage splat = new BufferedImage(
			rawSplat.getColorModel(),
			rawSplat.copyData(null),
			rawSplat.getColorModel().isAlphaPremultiplied(),
			null);

		final Graphics g = splat.getGraphics();
		g.setFont(FontManager.getRunescapeSmallFont());

		// Align the text in the centre of the hitsplat
		final FontMetrics metrics = g.getFontMetrics();
		final String text = String.valueOf(damage);
		final int x = (splat.getWidth() - metrics.stringWidth(text)) / 2;
		final int y = (splat.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(damage), x + 1, y + 1);
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(damage), x, y);
		return splat;
	}

	private static String getFormattedTime(Instant endTime)
	{
		final Duration timeLeft = Duration.between(Instant.now(), endTime);
		int seconds = (int) (timeLeft.toMillis() / 1000L);
		int minutes = seconds / 60;
		int secs = seconds % 60;

		return String.format("%d:%02d", minutes, secs);
	}

	String createTooltip()
	{
		String line1 = MessageFormat.format("Next {0} damage: {1}</br>Time until damage: {2}",
			envenomed ? "venom" : "poison", ColorUtil.wrapWithColorTag(String.valueOf(lastDamage), Color.RED), getFormattedTime(nextPoisonTick));
		String line2 = envenomed ? "" : MessageFormat.format("</br>Time until cure: {0}", getFormattedTime(poisonNaturalCure));

		return line1 + line2;
	}

	private void checkHealthIcon()
	{
		if (!config.changeHealthIcon())
		{
			return;
		}

		final BufferedImage newHeart;
		final int poison = client.getVarpValue(VarPlayerID.POISON);

		if (poison >= VENOM_THRESHOLD)
		{
			newHeart = HEART_VENOM;
		}
		else if (poison > 0)
		{
			newHeart = HEART_POISON;
		}
		else if (client.getVarpValue(VarPlayerID.DISEASE) > 0)
		{
			newHeart = HEART_DISEASE;
		}
		else
		{
			resetHealthIcon();
			return;
		}

		// Only update sprites when the heart icon actually changes
		if (newHeart != heart)
		{
			heart = newHeart;
			client.getWidgetSpriteCache().reset();
			client.getSpriteOverrides().put(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, ImageUtil.getImageSpritePixels(heart, client));
		}
	}

	private void resetHealthIcon()
	{
		if (heart == null)
		{
			return;
		}

		client.getWidgetSpriteCache().reset();
		client.getSpriteOverrides().remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON);
		heart = null;
	}
}
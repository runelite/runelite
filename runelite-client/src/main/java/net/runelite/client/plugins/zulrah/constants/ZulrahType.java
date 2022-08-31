package net.runelite.client.plugins.zulrah.constants;

import org.slf4j.LoggerFactory;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import java.awt.image.BufferedImage;
import java.awt.Color;
import net.runelite.api.Skill;
import org.slf4j.Logger;

public enum ZulrahType
{
	RANGE("Range", 2042, Skill.RANGED, Color.YELLOW),
	MELEE("Melee", 2043, Skill.ATTACK, Color.RED),
	MAGIC("Magic", 2044, Skill.MAGIC, Color.CYAN);

	private static final Logger log;
	private final String name;
	private final int npcId;
	private final Skill skill;
	private final Color color;

	public static ZulrahType valueOf(final int npcId)
	{
		switch (npcId)
		{
			case 2042:
			{
				return ZulrahType.RANGE;
			}
			case 2043:
			{
				return ZulrahType.MELEE;
			}
			case 2044:
			{
				return ZulrahType.MAGIC;
			}
			default:
			{
				return null;
			}
		}
	}

	public BufferedImage getImage()
	{
		try
		{
			return ZulrahPlugin.ZULRAH_IMAGES[this.ordinal()];
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			ZulrahType.log.debug("Attempted to get Zulrah Image but was out of bounds... Cause -> {}", ex.getMessage());
			return null;
		}
	}

	public Color getColorWithAlpha(final int alpha)
	{
		return new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), alpha);
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	private ZulrahType(final String name, final int npcId, final Skill skill, final Color color)
	{
		this.name = name;
		this.npcId = npcId;
		this.skill = skill;
		this.color = color;
	}

	public String getName()
	{
		return this.name;
	}

	public int getNpcId()
	{
		return this.npcId;
	}

	public Skill getSkill()
	{
		return this.skill;
	}

	public Color getColor()
	{
		return this.color;
	}

	static
	{
		log = LoggerFactory.getLogger(ZulrahType.class);
	}
}

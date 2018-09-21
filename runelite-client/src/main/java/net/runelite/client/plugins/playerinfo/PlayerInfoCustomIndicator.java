package net.runelite.client.plugins.playerinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.util.ColorUtil;

import java.awt.*;

public class PlayerInfoCustomIndicator extends InfoBox
{
	@AllArgsConstructor
	@Getter
	enum IndicatorType
	{
		HEALTH("Current Hitpoints"),
		PRAYER("Current Prayer Points"),
		ENERGY("Current Run Energy"),
		SPECIAL("Current Special Attack");

		private final String description;
	}

	private final PlayerInfoConfig config;
	private final Client client;
	private final IndicatorType type;

	PlayerInfoCustomIndicator(Image image, PlayerInfoPlugin plugin, PlayerInfoConfig config, Client client, IndicatorType type)
	{
		super(image, plugin);
		this.config = config;
		this.client = client;
		this.type = type;

		setTooltip(type.getDescription());
	}

	@Override
	public String getText()
	{
		switch (type)
		{
			case HEALTH:
				return String.valueOf(client.getBoostedSkillLevel(Skill.HITPOINTS));
			case PRAYER:
				return String.valueOf(client.getBoostedSkillLevel(Skill.PRAYER));
			case ENERGY:
				return String.valueOf(client.getEnergy());
			case SPECIAL:
				return String.valueOf(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) / 10);
		}

		return null;
	}

	@Override
	public Color getTextColor()
	{
		float currLvl = 0;
		switch (type)
		{
			case HEALTH:
				currLvl = client.getBoostedSkillLevel(Skill.HITPOINTS) / (float) client.getRealSkillLevel(Skill.HITPOINTS);
				break;
			case PRAYER:
				currLvl = client.getBoostedSkillLevel(Skill.PRAYER) / (float) client.getRealSkillLevel(Skill.PRAYER);
				break;
			case ENERGY:
				currLvl = client.getEnergy() / 100.0F;
				break;
			case SPECIAL:
				currLvl = client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) / 1000.0F;
		}

		if (currLvl > 1.0)
		{
			return config.colorHigh();
		}
		else if (currLvl > 0.5)
		{
			return ColorUtil.colorLerp(config.colorMed(), config.colorHigh(), (currLvl * 2) - 1.0F);
		}
		else
		{
			return ColorUtil.colorLerp(config.colorLow(), config.colorMed(), (currLvl * 2));
		}
	}

	@Override
	public boolean render()
	{
		switch (type)
		{
			case HEALTH:
				return config.enableHealth();
			case PRAYER:
				return config.enablePrayer();
			case ENERGY:
				return config.enableEnergy();
			case SPECIAL:
				return config.enableSpec();
		}

		return false;
	}
}

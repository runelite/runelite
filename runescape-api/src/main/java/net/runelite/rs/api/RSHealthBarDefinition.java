package net.runelite.rs.api;

import net.runelite.api.HealthBar;
import net.runelite.mapping.Import;

public interface RSHealthBarDefinition extends RSDualNode, HealthBar
{
	@Import("width")
	int getHealthScale();

	@Import("frontSpriteID")
	@Override
	int getHealthBarFrontSpriteId();

	@Import("getFrontSprite")
	RSSprite getHealthBarFrontSprite();

	@Import("getBackSprite")
	RSSprite getHealthBarBackSprite();

	@Import("widthPadding")
	@Override
	void setPadding(int padding);
}

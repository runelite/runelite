package net.runelite.rs.api;

import net.runelite.api.HealthBar;
import net.runelite.mapping.Import;

public interface RSHealthBarDefinition extends RSDualNode, HealthBar
{
	@Import("width")
	int getHealthScale();

	@Import("spriteId1")
	@Override
	int getHealthBarFrontSpriteId();

	@Import("getSprite1")
	RSSprite getHealthBarFrontSprite();

	@Import("getSprite2")
	RSSprite getHealthBarBackSprite();

	@Import("widthPadding")
	@Override
	void setPadding(int padding);
}

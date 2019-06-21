package net.runelite.rs.api;

import net.runelite.api.HealthBar;
import net.runelite.mapping.Import;

public interface RSHealthBar extends RSNode, HealthBar
{
	@Import("updates")
	RSIterableNodeDeque getUpdates(); // "combatinfolist" but only thing it has is getNode so this works

	@Import("definition")
	RSHealthBarDefinition getDefinition();
	
	@Import("healthBarFrontSpriteId")
	@Override
	int getHealthBarFrontSpriteId();

	@Import("getHealthBarFrontSprite")
	@Override
	RSSprite getHealthBarFrontSprite();

	@Import("getHealthBarBackSprite")
	@Override
	RSSprite getHealthBarBackSprite();

	@Import("healthBarPadding")
	@Override
	void setPadding(int padding);
}

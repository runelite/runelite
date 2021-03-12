package net.runelite.client.plugins.banktags.tabs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TopLeftButtonLeftClick
{
	NEW_TAB(1, 2, 3, TabSprites.NEW_TAB.getSpriteId()),
	IMPORT_TAB(2, 1, 3, TabSprites.IMPORT_TAB.getSpriteId()),
	OPEN_TAB_MENU(2, 3, 1, TabSprites.OPEN_TAB_MENU.getSpriteId()),
	;

	public final int newTagIndex;
	public final int importTagIndex;
	public final int openTabMenuIndex;
	public final int spriteId;
}

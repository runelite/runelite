/*******************************************************************************
 * Copyright (c) 2019 openosrs
 * Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 * If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 * ST0NEWALL#9112
 * openosrs Discord: https://discord.gg/Q7wFtCe
 * openosrs website: https://openosrs.com
 ******************************************************************************/

package net.runelite.client.plugins.playerindicators;

import com.google.common.collect.ImmutableList;

public enum PlayerIndicationLocation
{
	/**
	 * Indicates the player by rendering their username above their head
	 */
	ABOVE_HEAD,
	/**
	 * Indicates the player by outlining the player model's hull.
	 * NOTE: this may cause FPS lag if enabled for lots of players
	 */
	HULL,
	/**
	 * Indicates the player by rendering their username on the minimap
	 */
	MINIMAP,
	/**
	 * Indicates the player by colorizing their right click menu
	 */
	MENU,
	/**
	 * Indicates the player by rendering a tile marker underneath them
	 */
	TILE;

	/**
	 *
	 */
	public static final ImmutableList<PlayerIndicationLocation> SCENE_LOCATIONS = ImmutableList.of(ABOVE_HEAD, HULL);
}

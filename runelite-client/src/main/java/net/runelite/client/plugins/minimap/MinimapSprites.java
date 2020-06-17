package net.runelite.client.plugins.minimap;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.game.SpriteOverride;

@RequiredArgsConstructor
public enum MinimapSprites implements SpriteOverride
{
	FIXED_MODE_MINIMAP_LEFT_EDGE(1037, "minimap_left_edge.png"),
	FIXED_MODE_MINIMAP_RIGHT_EDGE(1038, "minimap_right_edge.png"),
	FIXED_MODE_WINDOW_FRAME_EDGE_TOP(1039, "window_frame_edge_top.png"),
	FIXED_MODE_MINIMAP_AND_COMPASS_FRAME(1182, "minimap_and_compass_frame.png"),
	FIXED_MODE_MINIMAP_ALPHA_MASK(-1183, "minimap_alpha_mask.png"),
	FIXED_MODE_MINIMAP_FRAME_BOTTOM(1611, "minimap_frame_bottom.png"),
	;

	@Getter
	private final int spriteId;

	@Getter
	private final String fileName;
}
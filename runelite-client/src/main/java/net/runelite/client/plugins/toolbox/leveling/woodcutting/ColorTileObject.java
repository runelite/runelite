package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import java.awt.Color;
import javax.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.runelite.api.ObjectComposition;
import net.runelite.api.TileObject;

/**
 * Used to denote marked objects and their colors.
 * Note: This is not used for serialization of object indicators; see {@link ObjectPoint}
 */
@Value
@RequiredArgsConstructor
class ColorTileObject
{
    static final int HF_HULL = 0x1;
    static final int HF_OUTLINE = 0x2;
    static final int HF_CLICKBOX = 0x4;
    static final int HF_TILE = 0x8;

    private final TileObject tileObject;
    /**
     * Non-transformed object composition for the object
     */
    private final ObjectComposition composition;
    /**
     * Name to highlight for multilocs
     */
    private final String name;
    @Nullable
    private final Color borderColor;
    @Nullable
    private final Color fillColor;
    byte highlightFlags;
}
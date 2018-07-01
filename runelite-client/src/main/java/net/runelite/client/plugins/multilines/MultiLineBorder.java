package net.runelite.client.plugins.multilines;

import lombok.Value;
import net.runelite.api.Point;

@Value
public class MultiLineBorder {

    private final String id;
    private final Point single;
    private final Point multi;

}

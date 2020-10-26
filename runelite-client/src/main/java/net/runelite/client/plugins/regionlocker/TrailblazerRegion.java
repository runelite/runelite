package net.runelite.client.plugins.regionlocker;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;

@Getter
enum TrailblazerRegion
{
    //<editor-fold desc="Enums">
    KARAMJA("Karamja", "11315, 11314, 10802, 11058, 10801, 11057, 11313, 11569, 11825, 11056, 11312, 11568, 11055, 11311, 11567, 11823, 11054, 11310, 11566, 11822,11053, 11309, 11565, 11821");



    private static final Map<String, TrailblazerRegion> trailblazerRegions;
    static
    {
        ImmutableMap.Builder<String, TrailblazerRegion> builder = new ImmutableMap.Builder<>();

        for (TrailblazerRegion region : values())
        {
            builder.put(region.getName(), region);
        }

        trailblazerRegions = builder.build();
    }

    private final String name;
    private final String regions;

    TrailblazerRegion(String name, String regions)
    {
        this.name = name;
        this.regions = regions;
    }
}

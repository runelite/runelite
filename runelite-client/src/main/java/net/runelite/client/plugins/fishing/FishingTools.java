package net.runelite.client.plugins.fishing;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.game.FishingSpot;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
@SuppressWarnings("SpellCheckingInspection")
@Getter
public enum FishingTools {
    SMALL_FISHING_NET(
            ItemID.SMALL_FISHING_NET,
            ItemID.SMALL_FISHING_NET_6209
    ),
    BIG_FISHING_NET(
            ItemID.BIG_FISHING_NET
    ),
    FISHING_ROD(
            ItemID.FISHING_ROD,
            ItemID.PEARL_FISHING_ROD
    ),
    FLY_FISHING_ROD(
            ItemID.FLY_FISHING_ROD,
            ItemID.PEARL_FLY_FISHING_ROD
    ),
    OILY_FISHING_ROD(
            ItemID.OILY_FISHING_ROD,
            ItemID.OILY_PEARL_FISHING_ROD
    ),
    BARBARIAN_ROD(
            ItemID.BARBARIAN_ROD,
            ItemID.PEARL_BARBARIAN_ROD
    ),
    HARPOON(
            ItemID.HARPOON,
            ItemID.BARBTAIL_HARPOON,
            ItemID.DRAGON_HARPOON,
            ItemID.DRAGON_HARPOON_OR,
            ItemID.INFERNAL_HARPOON,
            ItemID.INFERNAL_HARPOON_OR,
            ItemID.INFERNAL_HARPOON_UNCHARGED,
            ItemID.INFERNAL_HARPOON_UNCHARGED_25367,
            ItemID.CRYSTAL_HARPOON,
            ItemID.CRYSTAL_HARPOON_23864,
            ItemID.CRYSTAL_HARPOON_INACTIVE,
            ItemID.TRAILBLAZER_HARPOON
    ),
    LOBSTER_POT(
            ItemID.LOBSTER_POT
    ),
    KARAMBWAN_VESSEL(
            ItemID.KARAMBWAN_VESSEL,
            ItemID.KARAMBWAN_VESSEL_3159
    ),
    CORMORANTS_GLOVE(
            ItemID.CORMORANTS_GLOVE,
            ItemID.CORMORANTS_GLOVE_22817
    ),
    FISHBOWL_NET(
            ItemID.FISHBOWL_AND_NET
    );
    @Getter
    private final ImmutableSet<Integer> tools;

    FishingTools(Integer... itemIDs){this.tools = ImmutableSet.copyOf(itemIDs);}

    public static FishingTools getToolType(Integer itemID)
    {
     for (FishingTools toolType : FishingTools.values()){
         for (Integer toolID : toolType.getTools()){
             if (toolID.equals(itemID)){
                 return toolType;
             }
         }
     }
     // ItemID provided was not a fishing tool
     return null;
    }
}

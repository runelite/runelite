package net.runelite.client.plugins.alfred.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.coords.WorldPoint;

@Getter
@RequiredArgsConstructor
public enum WorldDestinations {
    DRAYNOR_VILLAGE_BANK("Draynor Village Bank", new WorldPoint(3093, 3244, 0)),
    EDGEVILLE_BANK("Edgeville Bank", new WorldPoint(3094, 3495, 0)),
    LUMBRIDGE_CASTLE("Lumbridge Castle", new WorldPoint(3122, 3218, 0)),
    LUMBRIDGE_CHICKENS("Lumbridge Chickens", new WorldPoint(3234, 3294, 0)),
    LUMBRIDGE_COWS("Lumbridge Cows", new WorldPoint(3258, 3266, 0)),
    LUMBRIDGE_SOUTH_EAST_MINE("Lumbridge Swamp East Mine", new WorldPoint(3227, 3146, 0)),
    LUMBRIDGE_SOUTH_WEST_MINE("Lumbridge Swamp West Mine", new WorldPoint(3147, 3148, 0)),

    VARROCK_CHAMPIONS_GUILD("Varrock Champions Guild", new WorldPoint(3191, 3364, 0)),
    VARROCK_COOKS_GUILD("Varrock Cooks Guild", new WorldPoint(3143, 3442, 0)),
    VARROCK_MAGE_STORE("Varrock Mage Store", new WorldPoint(3252, 3400, 0)),
    VARROCK_EAST_BANK("Varrock East Bank", new WorldPoint(3253, 3422, 0)),
    VARROCK_WEST_BANK("Varrock West Bank", new WorldPoint(3183, 3441, 0)),
    VARROCK_GRAND_EXCHANGE("Varrock Grand Exchange", new WorldPoint(3164, 3486, 0)),
    VARROCK_SOUTH_EAST_MINE("Varrock South East Mine", new WorldPoint(3285, 3364, 0)),
    VARROCK_SOUTH_WEST_MINE("Varrock South West Mine", new WorldPoint(3182, 3445, 0)),

    PORT_SARIM_MAGE_STORE("Port Sarim Mage Store", new WorldPoint(3014, 3258, 0)),
    PORT_SARIM_RING_STORE("Port Sarim Ring Store", new WorldPoint(3013, 3247, 0)),
    PORT_SARIM_FISHING_STORE("Port Sarim Fishing Store", new WorldPoint(3014, 3223, 0)),

    FALADOR_EAST_BANK("Falador East Bank", new WorldPoint(3012, 3356, 0)),
    FALADOR_WEST_BANK("Falador West Bank", new WorldPoint(2945, 3370, 0)),
    FALADOR_PARTY_ROOM("Falador Party Room", new WorldPoint(3045, 3370, 0)),

    AL_KHARID_BANK("Al Kharid Bank", new WorldPoint(3269, 3168, 0)),
    AL_KHARID_MINE("Al Kharid Mine", new WorldPoint(3299, 3287, 0)),

    RIMMINGTON("Rimmington", new WorldPoint(2978, 3238, 0)),
    RIMMINGTON_MINE("Rimmington Mine", new WorldPoint(3045, 3370, 0)),

    BARBARIAN_VILLAGE("Barbarian Village", new WorldPoint(3084, 3419, 0)),
    WIZARDS_TOWER("Wizards Tower", new WorldPoint(3109, 3168, 0)),
    CRAFTING_GUILD("Crafting Guild", new WorldPoint(2933, 3291, 0)),
    DUEL_ARENA_BANK("Duel Arena Bank", new WorldPoint(3384, 3269, 0)),

    NONE("None", new WorldPoint(0, 0, 0));

    private final String name;
    private final WorldPoint worldPoint;

    @Override
    public String toString() {
        return name;
    }
}

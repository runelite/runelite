package net.runelite.client.plugins.tabsviewer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum EquipmentToViewerMap {

    HELM(1, 0, SpriteID.EQUIPMENT_SLOT_HEAD),
    CAPE(3, 1, SpriteID.EQUIPMENT_SLOT_CAPE),
    NECK(4, 2, SpriteID.EQUIPMENT_SLOT_NECK),
    AMMO(5, 13, SpriteID.EQUIPMENT_SLOT_AMMUNITION),
    WEAPON(6, 3, SpriteID.EQUIPMENT_SLOT_WEAPON),
    TORSO(7, 4, SpriteID.EQUIPMENT_SLOT_TORSO),
    SHIELD(8, 5, SpriteID.EQUIPMENT_SLOT_SHIELD),
    LEGS(10, 7, SpriteID.EQUIPMENT_SLOT_LEGS),
    HANDS(12, 9, SpriteID.EQUIPMENT_SLOT_HANDS),
    FEET(13, 10, SpriteID.EQUIPMENT_SLOT_FEET),
    RING(14, 12, SpriteID.EQUIPMENT_SLOT_RING);

    @Getter
    private final int viewerPosition;

    @Getter
    private final int equipmentPosition;

    @Getter
    private final int placeholder;

    private static final Map<Integer, EquipmentToViewerMap> POSITIONS = new HashMap<>();

    static
    {
        for (EquipmentToViewerMap mapping : values())
        {
            POSITIONS.put(mapping.viewerPosition, mapping);
        }
    }

    static EquipmentToViewerMap findMapping(int viewPos)
    {
        return POSITIONS.get(viewPos);
    }
}

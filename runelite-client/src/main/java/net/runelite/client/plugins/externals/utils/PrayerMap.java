package net.runelite.client.plugins.externals.utils;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.api.widgets.WidgetInfo;

public enum PrayerMap {
    THICK_SKIN("Thick Skin", WidgetInfo.PRAYER_THICK_SKIN),
    BURST_OF_STRENGTH("Burst of Strength", WidgetInfo.PRAYER_BURST_OF_STRENGTH),
    CLARITY_OF_THOUGHT("Clarity of Thought", WidgetInfo.PRAYER_CLARITY_OF_THOUGHT),
    SHARP_EYE("Sharp Eye", WidgetInfo.PRAYER_SHARP_EYE),
    MYSTIC_WILL("Mystic Will", WidgetInfo.PRAYER_MYSTIC_WILL),
    ROCK_SKIN("Rock Skin", WidgetInfo.PRAYER_ROCK_SKIN),
    SUPERHUMAN_STRENGTH("Superhuman Strength", WidgetInfo.PRAYER_SUPERHUMAN_STRENGTH),
    IMPROVED_REFLEXES("Improved Reflexes", WidgetInfo.PRAYER_IMPROVED_REFLEXES),
    RAPID_RESTORE("Rapid Restore", WidgetInfo.PRAYER_RAPID_RESTORE),
    RAPID_HEAL("Rapid Heal", WidgetInfo.PRAYER_RAPID_HEAL),
    PROTECT_ITEM("Protect Item", WidgetInfo.PRAYER_PROTECT_ITEM),
    HAWK_EYE("Hawk Eye", WidgetInfo.PRAYER_HAWK_EYE),
    MYSTIC_LORE("Mystic Lore", WidgetInfo.PRAYER_MYSTIC_LORE),
    STEEL_SKIN("Steel Skin", WidgetInfo.PRAYER_STEEL_SKIN),
    ULTIMATE_STRENGTH("Ultimate Strength", WidgetInfo.PRAYER_ULTIMATE_STRENGTH),
    INCREDIBLE_REFLEXES("Incredible Reflexes", WidgetInfo.PRAYER_INCREDIBLE_REFLEXES),
    PROTECT_FROM_MAGIC("Protect from Magic", WidgetInfo.PRAYER_PROTECT_FROM_MAGIC),
    PROTECT_FROM_MISSILES("Protect from Missiles", WidgetInfo.PRAYER_PROTECT_FROM_MISSILES),
    PROTECT_FROM_MELEE("Protect from Melee", WidgetInfo.PRAYER_PROTECT_FROM_MELEE),
    EAGLE_EYE("Eagle Eye", WidgetInfo.PRAYER_EAGLE_EYE),
    MYSTIC_MIGHT("Mystic Might", WidgetInfo.PRAYER_MYSTIC_MIGHT),
    RETRIBUTION("Retribution", WidgetInfo.PRAYER_RETRIBUTION),
    REDEMPTION("Redemption", WidgetInfo.PRAYER_REDEMPTION),
    SMITE("Smite", WidgetInfo.PRAYER_SMITE),
    CHIVALRY("Chivalry", WidgetInfo.PRAYER_CHIVALRY),
    PIETY("Piety", WidgetInfo.PRAYER_PIETY),
    PRESERVE("Preserve", WidgetInfo.PRAYER_PRESERVE),
    RIGOUR("Rigour", WidgetInfo.PRAYER_RIGOUR),
    AUGURY("Augury", WidgetInfo.PRAYER_AUGURY);

    PrayerMap(String name, WidgetInfo info) {
        this.name = name;
        this.info = info;
    }

    private final String name;

    private final WidgetInfo info;

    private static final Map<String, WidgetInfo> map;

    public String getName() {
        return this.name;
    }

    public WidgetInfo getInfo() {
        return this.info;
    }

    static {
        ImmutableMap.Builder<String, WidgetInfo> builder = ImmutableMap.builder();
        for (PrayerMap spells : values())
            builder.put(spells.getName(), spells.getInfo());
        map = (Map<String, WidgetInfo>)builder.build();
    }

    @Nullable
    public static WidgetInfo getWidget(String prayer) {
        return map.getOrDefault(prayer, null);
    }
}

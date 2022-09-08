package net.runelite.client.plugins.externals.utils;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.api.widgets.WidgetInfo;

public enum Spells {
    ANNAKARL_TELEPORT("Annakarl Teleport", WidgetInfo.SPELL_ANNAKARL_TELEPORT),
    BLOOD_BARRAGE("Blood Barrage", WidgetInfo.SPELL_BLOOD_BARRAGE),
    BLOOD_BLITZ("Blood Blitz", WidgetInfo.SPELL_BLOOD_BLITZ),
    BLOOD_BURST("Blood Burst", WidgetInfo.SPELL_BLOOD_BURST),
    BLOOD_RUSH("Blood Rush", WidgetInfo.SPELL_BLOOD_RUSH),
    CARRALLANGAR_TELEPORT("Carrallangar Teleport", WidgetInfo.SPELL_CARRALLANGER_TELEPORT),
    DAREEYAK_TELEPORT("Dareeyak Teleport", WidgetInfo.SPELL_DAREEYAK_TELEPORT),
    GHORROCK_TELEPORT("Ghorrock Teleport", WidgetInfo.SPELL_GHORROCK_TELEPORT),
    ICE_BARRAGE("Ice Barrage", WidgetInfo.SPELL_ICE_BARRAGE),
    ICE_BLITZ("Ice Blitz", WidgetInfo.SPELL_ICE_BLITZ),
    ICE_BURST("Ice Burst", WidgetInfo.SPELL_ICE_BURST),
    ICE_RUSH("Ice Rush", WidgetInfo.SPELL_ICE_RUSH),
    KHARYRLL_TELEPORT("Kharyrll Teleport", WidgetInfo.SPELL_KHARYRLL_TELEPORT),
    LASSAR_TELEPORT("Lassar Teleport", WidgetInfo.SPELL_LASSAR_TELEPORT),
    PADDEWWA_TELEPORT("Paddewwa Teleport", WidgetInfo.SPELL_PADDEWWA_TELEPORT),
    SENNTISTEN_TELEPORT("Senntisten Teleport", WidgetInfo.SPELL_SENNTISTEN_TELEPORT),
    SHADOW_BARRAGE("Shadow Barrage", WidgetInfo.SPELL_SHADOW_BARRAGE),
    SHADOW_BLITZ("Shadow Blitz", WidgetInfo.SPELL_SHADOW_BLITZ),
    SHADOW_BURST("Shadow Burst", WidgetInfo.SPELL_SHADOW_BURST),
    SHADOW_RUSH("Shadow Rush", WidgetInfo.SPELL_SHADOW_RUSH),
    SMOKE_BARRAGE("Smoke Barrage", WidgetInfo.SPELL_SMOKE_BARRAGE),
    SMOKE_BLITZ("Smoke Blitz", WidgetInfo.SPELL_SMOKE_BLITZ),
    SMOKE_BURST("Smoke Burst", WidgetInfo.SPELL_SMOKE_BURST),
    SMOKE_RUSH("Smoke Rush", WidgetInfo.SPELL_SMOKE_RUSH),
    TELEPORT_TO_BOUNTY_TARGET("Teleport to Bounty Target", WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT),
    BAKE_PIE("Bake Pie", WidgetInfo.SPELL_BAKE_PIE),
    BARBARIAN_TELEPORT("Barbarian Teleport", WidgetInfo.SPELL_BARBARIAN_TELEPORT),
    BOOST_POTION_SHARE("Boost Potion Share", WidgetInfo.SPELL_BOOST_POTION_SHARE),
    CATHERBY_TELEPORT("Catherby Teleport", WidgetInfo.SPELL_CATHERBY_TELEPORT),
    CURE_GROUP("Cure Group", WidgetInfo.SPELL_CURE_GROUP),
    CURE_ME("Cure Me", WidgetInfo.SPELL_CURE_ME),
    CURE_OTHER("Cure Other", WidgetInfo.SPELL_CURE_OTHER),
    CURE_PLANT("Cure Plant", WidgetInfo.SPELL_CURE_PLANT),
    DREAM("Dream", WidgetInfo.SPELL_DREAM),
    ENERGY_TRANSFER("Energy Transfer", WidgetInfo.SPELL_ENERGY_TRANSFER),
    FERTILE_SOIL("Fertile Soil", WidgetInfo.SPELL_FERTILE_SOIL),
    FISHING_GUILD_TELEPORT("Fishing Guild Teleport", WidgetInfo.SPELL_FISHING_GUILD_TELEPORT),
    GEOMANCY("Geomancy", WidgetInfo.SPELL_GEOMANCY),
    HEAL_GROUP("Heal Group", WidgetInfo.SPELL_HEAL_GROUP),
    HEAL_OTHER("Heal Other", WidgetInfo.SPELL_HEAL_OTHER),
    HUMIDIFY("Humidify", WidgetInfo.SPELL_HUMIDIFY),
    HUNTER_KIT("Hunter Kit", WidgetInfo.SPELL_HUNTER_KIT),
    ICE_PLATEAU_TELEPORT("Ice Plateau Teleport", WidgetInfo.SPELL_ICE_PLATEAU_TELEPORT),
    KHAZARD_TELEPORT("Khazard Teleport", WidgetInfo.SPELL_KHAZARD_TELEPORT),
    MAGIC_IMBUE("Magic Imbue", WidgetInfo.SPELL_MAGIC_IMBUE),
    MONSTER_EXAMINE("Monster Examine", WidgetInfo.SPELL_MONSTER_EXAMINE),
    MOONCLAN_TELEPORT("Moonclan Teleport", WidgetInfo.SPELL_MOONCLAN_TELEPORT),
    NPC_CONTACT("NPC Contact", WidgetInfo.SPELL_NPC_CONTACT),
    OURANIA_TELEPORT("Ourania Teleport", WidgetInfo.SPELL_OURANIA_TELEPORT),
    PLANK_MAKE("Plank Make", WidgetInfo.SPELL_PLANK_MAKE),
    RECHARGE_DRAGONSTONE("Recharge Dragonstone", WidgetInfo.SPELL_RECHARGE_DRAGONSTONE),
    SPELLBOOK_SWAP("Spellbook Swap", WidgetInfo.SPELL_SPELLBOOK_SWAP),
    SPIN_FLAX("Spin Flax", WidgetInfo.SPELL_SPIN_FLAX),
    STAT_RESTORE_POT_SHARE("Stat Restore Pot Share", WidgetInfo.SPELL_STAT_RESTORE_POT_SHARE),
    STAT_SPY("Stat Spy", WidgetInfo.SPELL_STAT_SPY),
    STRING_JEWELLERY("String Jewellery", WidgetInfo.SPELL_STRING_JEWELLERY),
    SUPERGLASS_MAKE("Superglass Make", WidgetInfo.SPELL_SUPERGLASS_MAKE),
    TAN_LEATHER("Tan Leather", WidgetInfo.SPELL_TAN_LEATHER),
    TELE_GROUP_BARBARIAN("Tele Group Barbarian", WidgetInfo.SPELL_TELE_GROUP_BARBARIAN),
    TELE_GROUP_CATHERBY("Tele Group Catherby", WidgetInfo.SPELL_TELE_GROUP_CATHERBY),
    TELE_GROUP_FISHING_GUILD("Tele Group Fishing Guild", WidgetInfo.SPELL_TELE_GROUP_FISHING_GUILD),
    TELE_GROUP_ICE_PLATEAU("Tele Group Ice Plateau", WidgetInfo.SPELL_TELE_GROUP_ICE_PLATEAU),
    TELE_GROUP_KHAZARD("Tele Group Khazard", WidgetInfo.SPELL_TELE_GROUP_KHAZARD),
    TELE_GROUP_MOONCLAN("Tele Group Moonclan", WidgetInfo.SPELL_TELE_GROUP_MOONCLAN),
    TELE_GROUP_WATERBIRTH("Tele Group Waterbirth", WidgetInfo.SPELL_TELE_GROUP_WATERBIRTH),
    VENGEANCE("Vengeance", WidgetInfo.SPELL_VENGEANCE),
    VENGEANCE_OTHER("Vengeance Other", WidgetInfo.SPELL_VENGEANCE_OTHER),
    WATERBIRTH_TELEPORT("Waterbirth Teleport", WidgetInfo.SPELL_WATERBIRTH_TELEPORT),
    APE_ATOLL_TELEPORT("Ape Atoll Teleport", WidgetInfo.SPELL_TELEPORT_TO_APE_ATOLL),
    ARDOUGNE_TELEPORT("Ardougne Teleport", WidgetInfo.SPELL_ARDOUGNE_TELEPORT),
    BIND("Bind", WidgetInfo.SPELL_BIND),
    BONES_TO_BANANAS("Bones to Bananas", WidgetInfo.SPELL_BONES_TO_BANANAS),
    BONES_TO_PEACHES("Bones to Peaches", WidgetInfo.SPELL_BONES_TO_PEACHES),
    CAMELOT_TELEPORT("Camelot Teleport", WidgetInfo.SPELL_CAMELOT_TELEPORT),
    CHARGE("Charge", WidgetInfo.SPELL_CHARGE),
    CHARGE_AIR_ORB("Charge Air Orb", WidgetInfo.SPELL_CHARGE_AIR_ORB),
    CHARGE_EARTH_ORB("Charge Earth Orb", WidgetInfo.SPELL_CHARGE_EARTH_ORB),
    CHARGE_FIRE_ORB("Charge Fire Orb", WidgetInfo.SPELL_CHARGE_FIRE_ORB),
    CHARGE_WATER_ORB("Charge Water Orb", WidgetInfo.SPELL_CHARGE_WATER_ORB),
    CLAWS_OF_GUTHIX("Claws of Guthix", WidgetInfo.SPELL_CLAWS_OF_GUTHIX),
    CONFUSE("Confuse", WidgetInfo.SPELL_CONFUSE),
    CRUMBLE_UNDEAD("Crumble Undead", WidgetInfo.SPELL_CRUMBLE_UNDEAD),
    CURSE("Curse", WidgetInfo.SPELL_CURSE),
    EARTH_BLAST("Earth Blast", WidgetInfo.SPELL_EARTH_BLAST),
    EARTH_BOLT("Earth Bolt", WidgetInfo.SPELL_EARTH_BOLT),
    EARTH_STRIKE("Earth Strike", WidgetInfo.SPELL_EARTH_STRIKE),
    EARTH_SURGE("Earth Surge", WidgetInfo.SPELL_EARTH_SURGE),
    EARTH_WAVE("Earth Wave", WidgetInfo.SPELL_EARTH_WAVE),
    ENCHANT_CROSSBOW_BOLT("Enchant Crossbow Bolt", WidgetInfo.SPELL_ENCHANT_CROSSBOW_BOLT),
    ENFEEBLE("Enfeeble", WidgetInfo.SPELL_ENFEEBLE),
    ENTANGLE("Entangle", WidgetInfo.SPELL_ENTANGLE),
    FALADOR_TELEPORT("Falador Teleport", WidgetInfo.SPELL_FALADOR_TELEPORT),
    FIRE_BLAST("Fire Blast", WidgetInfo.SPELL_FIRE_BLAST),
    FIRE_BOLT("Fire Bolt", WidgetInfo.SPELL_FIRE_BOLT),
    FIRE_STRIKE("Fire Strike", WidgetInfo.SPELL_FIRE_STRIKE),
    FIRE_SURGE("Fire Surge", WidgetInfo.SPELL_FIRE_SURGE),
    FIRE_WAVE("Fire Wave", WidgetInfo.SPELL_FIRE_WAVE),
    FLAMES_OF_ZAMORAK("Flames of Zamorak", WidgetInfo.SPELL_FLAMES_OF_ZAMORAK),
    HIGH_LEVEL_ALCHEMY("High Level Alchemy", WidgetInfo.SPELL_HIGH_LEVEL_ALCHEMY),
    IBAN_BLAST("Iban Blast", WidgetInfo.SPELL_IBAN_BLAST),
    KOUREND_CASTLE_TELEPORT("Kourend Castle Teleport", WidgetInfo.SPELL_TELEPORT_TO_KOUREND),
    LOW_LEVEL_ALCHEMY("Low Level Alchemy", WidgetInfo.SPELL_LOW_LEVEL_ALCHEMY),
    LUMBRIDGE_TELEPORT("Lumbridge Teleport", WidgetInfo.SPELL_LUMBRIDGE_TELEPORT),
    LVL1_ENCHANT("Lvl-1 Enchant", WidgetInfo.SPELL_LVL_1_ENCHANT),
    LVL2_ENCHANT("Lvl-2 Enchant", WidgetInfo.SPELL_LVL_2_ENCHANT),
    LVL3_ENCHANT("Lvl-3 Enchant", WidgetInfo.SPELL_LVL_3_ENCHANT),
    LVL4_ENCHANT("Lvl-4 Enchant", WidgetInfo.SPELL_LVL_4_ENCHANT),
    LVL5_ENCHANT("Lvl-5 Enchant", WidgetInfo.SPELL_LVL_5_ENCHANT),
    LVL6_ENCHANT("Lvl-6 Enchant", WidgetInfo.SPELL_LVL_6_ENCHANT),
    LVL7_ENCHANT("Lvl-7 Enchant", WidgetInfo.SPELL_LVL_7_ENCHANT),
    MAGIC_DART("Magic Dart", WidgetInfo.SPELL_MAGIC_DART),
    SARADOMIN_STRIKE("Saradomin strike", WidgetInfo.SPELL_SARADOMIN_STRIKE),
    SNARE("Snare", WidgetInfo.SPELL_SNARE),
    STUN("Stun", WidgetInfo.SPELL_STUN),
    SUPERHEAT_ITEM("Superheat Item", WidgetInfo.SPELL_SUPERHEAT_ITEM),
    TELE_BLOCK("Tele Block", WidgetInfo.SPELL_TELE_BLOCK),
    TELEKINETIC_GRAB("Telekinetic Grab", WidgetInfo.SPELL_TELEKINETIC_GRAB),
    TELEOTHER_CAMELOT("Teleother Camelot", WidgetInfo.SPELL_TELEOTHER_CAMELOT),
    TELEOTHER_FALADOR("Teleother Falador", WidgetInfo.SPELL_TELEOTHER_FALADOR),
    TELEOTHER_LUMBRIDGE("Teleother Lumbridge", WidgetInfo.SPELL_TELEOTHER_LUMBRIDGE),
    TELEPORT_TO_HOUSE("Teleport to House", WidgetInfo.SPELL_TELEPORT_TO_HOUSE),
    TROLLHEIM_TELEPORT("Trollheim Teleport", WidgetInfo.SPELL_TROLLHEIM_TELEPORT),
    VARROCK_TELEPORT("Varrock Teleport", WidgetInfo.SPELL_VARROCK_TELEPORT),
    VULNERABILITY("Vulnerability", WidgetInfo.SPELL_VULNERABILITY),
    WATCHTOWER_TELEPORT("Watchtower Teleport", WidgetInfo.SPELL_WATCHTOWER_TELEPORT),
    WATER_BLAST("Water Blast", WidgetInfo.SPELL_WATER_BLAST),
    WATER_BOLT("Water Bolt", WidgetInfo.SPELL_WATER_BOLT),
    WATER_STRIKE("Water Strike", WidgetInfo.SPELL_WATER_STRIKE),
    WATER_SURGE("Water Surge", WidgetInfo.SPELL_WATER_SURGE),
    WATER_WAVE("Water Wave", WidgetInfo.SPELL_WATER_WAVE),
    WEAKEN("Weaken", WidgetInfo.SPELL_WEAKEN),
    WIND_BLAST("Wind Blast", WidgetInfo.SPELL_WIND_BLAST),
    WIND_BOLT("Wind Bolt", WidgetInfo.SPELL_WIND_BOLT),
    WIND_STRIKE("Wind Strike", WidgetInfo.SPELL_WIND_STRIKE),
    WIND_SURGE("Wind Surge", WidgetInfo.SPELL_WIND_SURGE),
    WIND_WAVE("Wind Wave", WidgetInfo.SPELL_WIND_WAVE);

    Spells(String name, WidgetInfo info) {
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
        for (Spells spells : values())
            builder.put(spells.getName(), spells.getInfo());
        map = (Map<String, WidgetInfo>)builder.build();
    }

    @Nullable
    public static WidgetInfo getWidget(String spell) {
        return map.getOrDefault(spell, null);
    }
}

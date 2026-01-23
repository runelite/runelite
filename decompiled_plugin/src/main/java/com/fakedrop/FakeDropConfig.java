package com.fakedrop;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.api.IconID;

@ConfigGroup("fakedrop")
public interface FakeDropConfig extends Config
{
    enum IronmanType
    {
        NONE("None", ""),
        IRONMAN("Ironman", IconID.IRONMAN.toString()),
        HARDCORE("Hardcore", IconID.HARDCORE_IRONMAN.toString()),
        ULTIMATE("Ultimate", IconID.ULTIMATE_IRONMAN.toString()),
        GROUP("Group Ironman", "");

        private final String name;
        private final String icon;

        IronmanType(String name, String icon)
        {
            this.name = name;
            this.icon = icon;
        }

        public String getIcon()
        {
            return icon;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }

    enum Pet
    {
        // Skilling Pets
        ROCKY("Rocky", true, "Thieving", "Varies"),
        BEAVER("Beaver", true, "Woodcutting", "Varies"),
        HERON("Heron", true, "Fishing", "Varies"),
        ROCK_GOLEM("Rock golem", true, "Mining", "Varies"),
        BABY_CHINCHOMPA("Baby chinchompa", true, "Hunter", "Varies"),
        GIANT_SQUIRREL("Giant squirrel", true, "Agility", "Varies"),
        TANGLEROOT("Tangleroot", true, "Farming", "Varies"),
        RIFT_GUARDIAN("Rift guardian", true, "Runecraft", "Varies"),
        SOUP("Soup", true, "Sailing", "Varies"),
        
        // Boss Pets
        LIL_ZIK("Lil' zik", false, null, "1/650"),
        VORKI("Vorki", false, null, "1/3,000"),
        OLMLET("Olmlet", false, null, "1/53"),
        YOUNGLLEF("Youngllef", false, null, "1/800"),
        NEXLING("Nexling", false, null, "1/500"),
        TUMEKEN_GUARDIAN("Tumeken's guardian", false, null, "Varies"),
        SCORPIAS_OFFSPRING("Scorpia's offspring", false, null, "1/2,016"),
        HELLPUPPY("Hellpuppy", false, null, "1/3,000"),
        IKKLE_HYDRA("Ikkle hydra", false, null, "1/3,000"),
        SKOTOS("Skotos", false, null, "1/65"),
        TZREK_JAD("Tzrek-jad", false, null, "1/200"),
        JAL_NIB_REK("Jal-nib-rek", false, null, "1/100"),
        PET_KRAKEN("Pet kraken", false, null, "1/3,000"),
        PRINCE_BLACK_DRAGON("Prince black dragon", false, null, "1/3,000"),
        BABY_MOLE("Baby mole", false, null, "1/3,000"),
        PET_CHAOS_ELEMENTAL("Pet chaos elemental", false, null, "1/300"),
        PET_SNAKELING("Pet snakeling", false, null, "1/4,000"),
        VENENATIS_SPIDERLING("Venenatis spiderling", false, null, "1/1,500"),
        CALLISTO_CUB("Callisto cub", false, null, "1/1,500"),
        VETION_JR("Vet'ion jr.", false, null, "1/1,500"),
        KALPHITE_PRINCESS("Kalphite princess", false, null, "1/3,000"),
        PET_SMOKE_DEVIL("Pet smoke devil", false, null, "1/3,000"),
        PET_DARK_CORE("Pet dark core", false, null, "1/5,000"),
        NOON("Noon", false, null, "1/3,000"),
        LIL_CREATOR("Lil' creator", false, null, "1/400"),
        ABYSSAL_ORPHAN("Abyssal orphan", false, null, "1/2,560"),
        MUPHIN("Muphin", false, null, "1/2,500"),
        WISP("Wisp", false, null, "1/2,000"),
        BARON("Baron", false, null, "1/2,500"),
        BUTCH("Butch", false, null, "1/3,000"),
        LILVIATHAN("Lil'viathan", false, null, "1/2,500"),
        LITTLE_NIGHTMARE("Little nightmare", false, null, "1/800-1/4,000"),
        SMOLCANO("Smolcano", false, null, "1/2,250"),
        SRARACHA("Sraracha", false, null, "1/3,000"),
        TINY_TEMPOR("Tiny tempor", false, null, "1/8,000"),
        PHOENIX("Phoenix", false, null, "1/5,000"),
        ABYSSAL_PROTECTOR("Abyssal protector", false, null, "1/4,000"),
        HERBI("Herbi", false, null, "1/6,500"),
        NID("Nid", false, null, "1/3,000"),
        SCURRY("Scurry", false, null, "1/3,000"),
        CUSTOM("Custom", false, null, "Custom");

        private final String petName;
        private final boolean isSkilling;
        private final String skill; // Only for skilling pets
        private final String defaultRarity;

        Pet(String petName, boolean isSkilling, String skill, String defaultRarity)
        {
            this.petName = petName;
            this.isSkilling = isSkilling;
            this.skill = skill;
            this.defaultRarity = defaultRarity;
        }

        public String getPetName()
        {
            return petName;
        }

        public boolean isSkilling()
        {
            return isSkilling;
        }

        public String getSkill()
        {
            return skill;
        }

        public String getDefaultRarity()
        {
            return defaultRarity;
        }

        @Override
        public String toString()
        {
            if (isSkilling && skill != null)
            {
                return petName + " (" + skill + ")";
            }
            return petName;
        }
    }
    
    // ========== SECTIONS ==========
    @ConfigSection(
            name = "Boss Settings",
            description = "Configure boss information",
            position = 1
    )
    String bossSection = "bossSection";

    @ConfigSection(
            name = "Drop Settings",
            description = "Configure drop information",
            position = 2
    )
    String dropSection = "dropSection";

    @ConfigSection(
            name = "Clan Settings",
            description = "Configure clan announcement settings",
            position = 3
    )
    String clanSection = "clanSection";

    @ConfigSection(
            name = "Pet Settings",
            description = "Configure pet drop information",
            position = 4
    )
    String petSection = "petSection";

    // ========== HOTKEYS ==========
    @ConfigItem(
            keyName = "toggle",
            name = "Trigger Drop",
            description = "Hotkey to announce the fake drop",
            position = -1
    )
    default Keybind toggle()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "quickSwitchMode",
            name = "Quick Switch Mode",
            description = "Hotkey to quickly toggle between Boss and Pet mode",
            position = 0
    )
    default Keybind quickSwitchMode()
    {
        return Keybind.NOT_SET;
    }

    // ========== BOSS SECTION ==========
    @ConfigItem(
            keyName = "bossName",
            name = "Boss Name",
            description = "The name of the boss",
            section = bossSection,
            position = 1
    )
    default String bossName()
    {
        return "Leviathan";
    }

    @ConfigItem(
            keyName = "bossLocation",
            name = "Boss Location",
            description = "The location/full name of the boss for clan broadcast (e.g., 'The Leviathan')",
            section = bossSection,
            position = 2
    )
    default String bossLocation()
    {
        return "The Leviathan";
    }

    @ConfigItem(
            keyName = "killCount",
            name = "Kill Count",
            description = "Your kill count for the boss",
            section = bossSection,
            position = 3
    )
    default int killCount()
    {
        return 215;
    }

    @ConfigItem(
            keyName = "autoIncrementKC",
            name = "Auto-Increment KC",
            description = "Automatically increase kill count by 1 each time you trigger a drop",
            section = bossSection,
            position = 4
    )
    default boolean autoIncrementKC()
    {
        return true;
    }

    @ConfigItem(
            keyName = "timed",
            name = "Show Time",
            description = "Show fight duration and personal best",
            section = bossSection,
            position = 4
    )
    default boolean timed()
    {
        return true;
    }

    @ConfigItem(
            keyName = "killTime",
            name = "Kill Time",
            description = "The duration of the fight",
            section = bossSection,
            position = 5
    )
    default String killTime()
    {
        return "1:21:00";
    }

    @ConfigItem(
            keyName = "personalBest",
            name = "Personal Best",
            description = "Your personal best time",
            section = bossSection,
            position = 6
    )
    default String personalBest()
    {
        return "1:01:00";
    }

    // ========== DROP SECTION ==========
    @ConfigItem(
            keyName = "dropName",
            name = "Drop Name",
            description = "The name of the drop",
            section = dropSection,
            position = 7
    )
    default String dropName()
    {
        return "Virtus robe bottom";
    }

    @Range(min = 0, max = Integer.MAX_VALUE)
    @ConfigItem(
            keyName = "dropValue",
            name = "Drop Value",
            description = "The value of the drop in coins",
            section = dropSection,
            position = 8
    )
    default int dropValue()
    {
        return 31883867;
    }

    @ConfigItem(
            keyName = "randomizeValue",
            name = "Randomize Value",
            description = "Add ±5% randomization to drop value for realism",
            section = dropSection,
            position = 9
    )
    default boolean randomizeValue()
    {
        return false;
    }

    @ConfigItem(
            keyName = "untradeable",
            name = "Untradeable Drop",
            description = "Whether the drop is untradeable",
            section = dropSection,
            position = 9
    )
    default boolean untradeable()
    {
        return false;
    }

    @ConfigItem(
            keyName = "collectionLog",
            name = "Collection Log",
            description = "Show as collection log drop",
            section = dropSection,
            position = 10
    )
    default boolean collectionLog()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showCollectionLogPopup",
            name = "Show Collection Log Popup",
            description = "Display the collection log popup notification",
            section = dropSection,
            position = 11
    )
    default boolean showCollectionLogPopup()
    {
        return true;
    }

    @ConfigItem(
            keyName = "collectionLogCount",
            name = "Collection Log Count",
            description = "Your collection log count (format: obtained/total)",
            section = dropSection,
            position = 12
    )
    default String collectionLogCount()
    {
        return "922/1892";
    }

    // ========== CLAN SECTION ==========
    @ConfigItem(
            keyName = "announceToClan",
            name = "Announce to Clan",
            description = "Automatically announce the drop in clan chat",
            section = clanSection,
            position = 13
    )
    default boolean announceToClan()
    {
        return true;
    }

    @ConfigItem(
            keyName = "clanName",
            name = "Clan Name",
            description = "The name of your clan for the broadcast",
            section = clanSection,
            position = 14
    )
    default String clanName()
    {
        return "Oblivion";
    }

    @Alpha
    @ConfigItem(
            keyName = "clanColor",
            name = "Clan Color",
            description = "Color for the clan name text",
            section = clanSection,
            position = 15
    )
    default Color clanColor()
    {
        return new Color(0, 0, 255);
    }

    @ConfigItem(
            keyName = "ironmanType",
            name = "Ironman Icon",
            description = "Ironman account type icon to display in clan broadcast",
            section = clanSection,
            position = 16
    )
    default IronmanType ironmanType()
    {
        return IronmanType.NONE;
    }

    @ConfigItem(
            keyName = "includeKillCountInClan",
            name = "Include KC in Clan",
            description = "Include kill count in the clan chat announcement",
            section = clanSection,
            position = 17
    )
    default boolean includeKillCountInClan()
    {
        return true;
    }

    // ========== PET SECTION ==========
    @ConfigItem(
            keyName = "isPet",
            name = "Pet Drop",
            description = "Enable pet drop mode (disables regular boss/drop settings)",
            section = petSection,
            position = 18
    )
    default boolean isPet()
    {
        return false;
    }

    @ConfigItem(
            keyName = "selectedPet",
            name = "Pet",
            description = "Select which pet you received",
            section = petSection,
            position = 19
    )
    default Pet selectedPet()
    {
        return Pet.ROCKY;
    }

    @ConfigItem(
            keyName = "customPetName",
            name = "Custom Pet Name",
            description = "Name for custom pet (only used if 'Custom' is selected)",
            section = petSection,
            position = 20
    )
    default String customPetName()
    {
        return "Custom Pet";
    }

    @ConfigItem(
            keyName = "petKillCountOrXP",
            name = "Kill Count / XP",
            description = "Kill count for boss pets or total XP for skilling pets",
            section = petSection,
            position = 21
    )
    @Range(min = 1, max = Integer.MAX_VALUE)
    default int petKillCountOrXP()
    {
        return 13200000;
    }
}

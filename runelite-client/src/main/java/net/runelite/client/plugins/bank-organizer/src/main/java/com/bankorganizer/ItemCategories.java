package com.bankorganizer;

import java.util.*;

public class    ItemCategories
{
    // categoryId → list of lowercase match patterns > expand names and categories - common items for xyz (&xz, yx..)
    public static final Map<Integer, List<String>> CATEGORY_PATTERNS = new HashMap<>();

    static
    {
        CATEGORY_PATTERNS.put(1, Arrays.asList("defender", "full helm", "kiteshield", "plateskirt", "platelegs", "chainbody", "platebody", "initiate", "proselyte", "inquisitor", "rock-shell",
                "sunfire fanatic", "granite", "blood moon", "obsidian", "3rd age longsword", "bandos chestplate", "bandos tassets", "bandos boots", "justiciar", "dragonfire shield",
                "dinh's bulwark", "oathplate", "torva", "warrior helm", "berserker", "neitiznot", "dharok's", "torag's", "verac's", "guthan's", "serpentine helm", "tanzanite helm",
                "magma helm", "dwarven helmet", "fighter hat", "fighter torso", "runner hat", "granite helm", "granite body", "granite legs", "granite shield", "granite gloves", "granite boots",
                "granite maul", "granite longsword", "granite hammer", "granite ring", "dragonstone boots", "dragonstone gauntlets", "climbing boots", "rune boots", "guardian boots", "echo boots",
                "spiked manacles", "dragon boots", "primordial boots", "mace", "tzhaar-ket-em", "warhammer", "tzhaar-ket-om", "elder maul", "abyssal bludgeon", "barrelchest anchro",
                "dual macuahuitl", "glacial temotli", "keris partisan", "sarachnis cudgel", "chainmace", "blade of saeldor", "scimitar", "longsword", "battleaxe", "zombie axe", "claws",
                "halberd", "2h", "godsword", "colossal blade", "saradomin sword", "abyssal tentacle", "abyssal whip", "scythe of vitur", "soulreaper axe", "sulphur blades", "toktz-xil-ek",
                "voidwaker", "silverlight", "darklight", "arclight", "emberlight", "arkan blade", "dagger", "sword", "toktz-xil-ak", "ghrazi rapier", "osmumten's fang", "spear", "hasta",
                "lance", "swift blade", "earthbound tecpatl", "ferocious gloves", "amulet of rancour", "infernal cape"));

        CATEGORY_PATTERNS.put(2, Arrays.asList("air rune", "water rune", " earth rune", "fire rune", "sunfire rune", "mind rune", "body rune", "cosmic rune", "chaos rune",
                "astral rune", "nature rune", "law rune", "death rune", "blood rune", "soul rune", "wrath rune", "mist rune", "dust rune", "mud rune", "smoke rune",
                "steam rune", "lava rune", "aether rune", "staff", "wand", "sceptre", "toktz-mej-tal", "void knight mace","blue moon spear", "trident", "eye of ayak", "tumeken's shadow",
                "wizard hat", "wizard robe", "skeletal", "ancestral", "hat", "ghostly", "mystic", "xerician", "moonclan", "lunar", "splitbark", "swampbark", "bloodbark", "enchanted", "of darkness",
                "elder chaos", "dagon'hai", "infinity", "farseer helm", "blue moon", "ahrim's", "3rd age mage hat", "3rd age robe top", "3rd age amulet", "3rd age robe", "virtus",
                "zamorak monk top", "zamorak monk bottom", "tormented bracelet", "confliction gauntlets", "eternal boots", "wizard boots", "zamorak cape", "saradomin cape", "guthix cape",
                "amulet of magic", "occult necklace", "seers ring", "brimstone ring", "magus ring", "elidinis' ward", "book of the dead", "tome of", "book of darkness", "malediction ward",
                "mage's book", "ancient wyvern shield", "arcane spirit shield"));

        CATEGORY_PATTERNS.put(3, Arrays.asList("leather cowl", "snakeskin bandana", "snakeskin body", "snakeskin boots", "snakeskin chaps", "snakeskin shield", "snakeskin vambraces",
                "coif", "shayzien", "spined", "ranger hat", "archer helm", "hueycoatl hide body", "hueycoatl hide chaps", "karil's", "vambraces", "eclipse moon", "eclipse atlatl", "robin hood hat",
                "3rd age range", "3rd age bow", "crystal helm", "crystal body", "crystal legs", "armadyl helmet", "armadyl chestplate", "armadyl chainskirt", "masori", "hardleather body",
                "studded body", "studded chap", "frog-leather", "rangers' tunic", "d'hide", "mixed hide", "penance skirt", "rangers' tights", "ranger boots", "pegasian boots", "ranging cape",
                "ava's","dizana's", "necklace of anguish", "archers ring", "venator", "hard leather shield", "book of law", "odium ward", "dragonfire ward", "twisted buckler", "chaps",
                "shortbow", "longbow", "composite bow", "rain bow", "seercull", "dark bow", "craw's bow", "webweaver bow", "crystal bow", "scorching bow", "bow of faerdhinen", "venator bow",
                "twisted bow", "bow", "crossbow", "ballista", "dart", "bronze knife", "iron knife", "steel knife", "mithril knife", "adamant knife", "rune knife", "dragon knife",
                "thrownaxe", "chinchompa", "toktz-xil-ul", "hunter's spear", "toxic blowpipe", "tonalztics of ralos", "arrow"));

        CATEGORY_PATTERNS.put(4, Arrays.asList("bar","ore", "coal", "uncut", "opal", "jade", "topaz", "sapphire", "emerald", "ruby", "diamond", "dragonstone", "onyx", "zenyte", "giant seaweed",
                "soda ash", "bucket of sand", "molten glass", "clay", "plank", "logs", "battlestaff", "unpowered orb", "air orb", "water orb", "earth orb", "fire orb", "flax",
                "bow string", "(u)", "amethyst", "(unf)", "arrowtips", "javelin heads", "headless arrow", "bolt tips", "dart tip", "feather"));

        CATEGORY_PATTERNS.put(5, Arrays.asList("potion", "grimy", "guam", "marrentill", "tarromin", "harralander", "ranarr", "toadflax", "irit", "avantoe", "kwuarm", "huasca", "snapdragon", "cadantine",
                "lantadyme", "dwarf weed", "torstol", "super", "eye of newt", "limpwurt root", "red spiders' eggs", "white berries", "snape grass", "mort myre fungus", "aldarium",
                "star flower", "nail beast nails", "yew roots", "lily of the sands", "wine of zamorak", "cactus spine", "potato cactus", "amylase crystal", "jangerberries", "magic roots",
                "cave nightshade", "nightshade", "poison ivy berries", "zulrah's scales", "ancient essence", "araxyte venom sack", "demonic tallow", "unicorn horn", "chocolate bar", "chocolate dust",
                "goat horn dust", "desert goat horn", "kebbit teeth", "gorak claws", "blue dragon scale", "dragon scale dust", "crystal dust", "crushed nest", "lava scale shard", "crushed superior dragon bones",
                "ashes", "volcanic ash", "nihil dust", "saradomin brew", "antidote", "anti-venom", "menaphite remedy","sanfew serum", "antifire potion", "extended antifire"));

        CATEGORY_PATTERNS.put(6, Arrays.asList("Head", "bone", "loop half of key", "tooth half of key", "crystal key", "bones", "bone shards", "ensouled", "zulrah's scale", "long bone",
                "rune full helm", "rune platebody", "rune platelegs", "rune plateskirt", "rune chainbody", "rune sq shield", "rune kiteshield", "rune med helm", "dragon halberd", "rune halberd",
                "rune spear", "rune warhammer", "rune battleaxe", "rune 2h sword", "rune longsword", "rune scimitar", "dragon dagger", "dragon longsword", "dragon scimitar", "dragon spear",
                "granite hammer", "granite maul", "abyssal whip", "dragon javelin heads", "amulet of the damned", "zenyte shard", "ballista spring", "frame", "ballista limbs", "unstrung heavy ballista",
                "dragon bolts (unf)", "ancient shard", "dark totem", "rune javelin heads", "dragon dart tip", "crystal shard", "crystal armour seed", "enhanced crystal weapon seed", "firelighter",
                "rune arrowtips", "dragonhide", "dragon arrowtips", "dragon plateskirt", "dragon platelegs", "dragon chainbody", "dragon med helm", "drake's tooth", "magic fang", "tanzanite fang",
                "serpentine visage", "hilt", "godsword shard", "thread of elidinis", "ancient essence", "dark bow", "hydra's", "hydra leather", "venator shard", "steam battlestaff", "hydra tail",
                "dragon sword", "dragon knife", "dragon thrownaxe", "shield left half", "awakener's orb", "granite gloves", "sunfire splinters", "jar of", "black tourmaline core", "kraken tentacle",
                "champion scroll", "coagulated venom", "egg sac", "charged ice", "rune boots", "dragonstone bolt tips", "skull of vet'ion", "prayer scroll", "eye of the duke", "leviathan's lure",
                "chromium ingot", "quartz", "zamorakian spear", "unsired", "araxyte fang", "noxious", "bryophyta", "tyrannical ring", "claws of callisto", "voicwaker hilt", "eternal crystal",
                "pegasian crystal", "primordial crystal", "smouldering stone", "dragon 2h", "odium shard", "malediction shard", "saradomin's light", "sigil", "holy elixir", "spirit shield", "mokhaiotl cloth",
                "vestige", "echo crystal", "crystal weapon seed", "hueycoatl hide", "draconic visage", "nihil horn", "volatile orb", "harmonised orb", "eldritch orb", "parasitic egg", "hill giant club",
                "element staff crown", "dark claw", "executioner's axe head", "treasonous ring", "fangs of venenatis", "voidwaker gem", "ring of the gods", "voidwaker blade", "skeletal visage",
                "dragonbone necklace", "siren's staff", "contract of", "crystal tool seed", "zolcano shard", "mutagen", "avernic defender hilt", "sanguine dust", "holy ornament kit", "sanguine ornament kit",
                "torn prayer scroll", "metamorphic dust", "twisted ancestral colour kit", "kodai insignia", "breach of the scarab", "eye of the corruptor", "jewel of the sun", "jewel of amascut",
                "eternal gem", "basilisk jaw", "tormented synapse", "oathplate shards", "onyx bolt", "impling jar"));

        CATEGORY_PATTERNS.put(7, Arrays.asList("axe", "pickaxe", "butterfly net", "knife", "chisel", "hammer", "saw", "fishing rod", "fishing bait", "sandworms", "diabolic worms",
                "feather", "bucket", "pot", "fishing net", "rope", "lockpick", "tinderbox", "mould", "costume needle", "harpoon", "nails", "bowl", "karambwan vessel", "fish barrel",
                "farming rake", "seed dibber", "spade", "gricoller's can", "gardening trowel", "compost", "plant cure", "secatures", "infernal"));

        CATEGORY_PATTERNS.put(8, Arrays.asList("raw", "pie", "anchovies", "anglerfish", "baked potato", "bass", "blighted anglerfish", "blighted karambwan", "blighted manta ray",
                "wine", "bread", "cake", "chilli potato", "cod", "cooked", "curry", "dark crab", "egg potato", "giant carp", "herring", "kebab", "lobster", "mackeral", "manta ray",
                "pizza", "monkfish", "mushroom potato", "peach", "pike", "potato with cheese", "premade", "purple sweets", "roast", "salmon", "sardine", "sea turtle", "shark", "shrimp", "spicy",
                "sandwich", "stew", "strange fruit", "swordfish", "trout", "tuna"));

        CATEGORY_PATTERNS.put(9, Arrays.asList("seeds", "seaweed spore", "seed", "plant pot", "watering can", "diving apparatus", "fishbowl helmet", "magic secatures", "empty sack", "basket", "tomatoes",
                "strawberries", "bananas", "apples", "curry leaf", "cabbage", "sweetcorn", "onion", "pineapple", "poison ivy berries", "watermelon", "strawberry", "papaya fruit",
                "coconut", "dragonfruit", "calquat fruit", "mushroom", "jangerberries", "grapes", "saltpetre", "nightshade", "cactus spine", "hops", "potato", "snape grass", "barley",
                "hammerstone", "asgarnian", "jute fibre", "yanillian", "krandorian", "wildblood", "redberries", "cadava berries", "dwellberries", "jangerberries", "white berries",
                "poison ivy berries", "roots", "apple", "banana", "orange", "zamorak's grapes", "potatoes(10)", "onions(10)", "cabbages(10)", "celastrus bark", "acorn", "seedling",
                "sapling", "farming rake", "seed dibber", "spade", "gricoller's can", "gardening trowel", "plant cure", "bottomless bucket", "compost", "mushroom spore"));

        CATEGORY_PATTERNS.put(10, Arrays.asList("graceful", "carpenter", "farmer", "pyromancer", "angler", "spirit angler", "guild hunter", "prospector", "zealot", "raiments of the eye",
                "smiths", "rogue", "lumberjack", "forestry", "ardougne cloak", "desert amulet", "falador shield", "fremennik sea boots", "kandarin headgear", "karamja gloves", "rada's blessing", "explorer's ring", "morytania legs",
                "varrock armour", "western banner", "wilderness sword"));
    }
}
//Add exceptions more exceptions for "tools" Cat7 bucket of ...... pot of ........

//multi-target items - consider: slayer helmet, boots of aranae, void, barrows gloves, anti-dragon shield
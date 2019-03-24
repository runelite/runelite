package net.runelite.client.plugins.damagecounter;

import com.google.inject.Provides;
import lombok.Getter;
import lombok.AccessLevel;
import net.runelite.api.*;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.lang.StrictMath.round;
import static net.runelite.api.Skill.HITPOINTS;

@PluginDescriptor(
        name = "Damage Counter",
        description = "Show damage statistics",
        tags = {"counter", "combat", "damage", "overlay"}
)
public class DamageCounterPlugin extends Plugin {

    @Getter(AccessLevel.PACKAGE)
    private int yourDamage;

    @Getter(AccessLevel.PACKAGE)
    private int totalDamage;

    @Getter(AccessLevel.PACKAGE)
    private final Set<Actor> players = new HashSet<>();

    @Inject
    private Client client;

    //@Inject
    //private OverlayManager overlayManager;

    //@Inject
    //private DamageCounterOverlay overlay;

    @Inject
    private DamageCounterConfig config;
    private int lastHpXp;
    @Provides
    DamageCounterConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(DamageCounterConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        //overlayManager.add(overlay);
        lastHpXp = client.getSkillExperience(HITPOINTS);
    }

    @Override
    protected void shutDown() throws Exception
    {
        //overlayManager.remove(overlay);
        yourDamage = 0;
        players.clear();
    }
    @Subscribe
    public void onExperienceChanged(ExperienceChanged event)
    {
        if (event.getSkill() != HITPOINTS) {
            return;
        }

        // Determine how much EXP was actually gained
        int HpXp = client.getSkillExperience(HITPOINTS);
        int HpGained = HpXp - lastHpXp;
        lastHpXp = HpXp;
        ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
        Item[] items = equipment.getItems();
        int weaponIdx = EquipmentInventorySlot.WEAPON.getSlotIdx();
        Item weapon = items[weaponIdx];
        //if (weapon.getId() == ItemID.TRIDENT_OF_THE_SEAS_E || weapon.getId() == ItemID.TRIDENT_OF_THE_SEAS ||weapon.getId() == ItemID.TRIDENT_OF_THE_SWAMP ||weapon.getId() == ItemID.TRIDENT_OF_THE_SWAMP_E
        //{
        //    HpGained = HpGained + HpGained;
        //}
        double modifier = 1;
        Actor target = client.getLocalPlayer().getInteracting();

        String npcname = null;
        if (target != null)
        {
            npcname = target.getName();
        }

        if (npcname != null)
        {
            modifier = damagemod(npcname);

        }
        yourDamage += round(HpGained / modifier /1.33);
        System.out.println("target: " + npcname);
        System.out.println("xp mod: " + modifier);
        System.out.println("hp xp gain: " + HpGained);
        System.out.println("totalDamage: " + yourDamage);
    }
    public double damagemod(String npcname)
    {
        switch (npcname.toLowerCase())
        {
            case"aberrant spectre": return 1;
            case"abyssal demon": return 1;
            case"abyssal sire": return 1.125;
            case"adamant dragon": return 1.1;
            case"ahrim": return 1.025;
            case"alchemical hydra": return 1.2;
            case"al-kharid warrior": return 1;
            case"ammonite crab": return 1;
            case"ancient wyvern": return 1.05;
            case"ancient zygomite": return 1.025;
            case"archer": return 1;
            case"arrg": return 1.075;
            case"arrg (hard)": return 1.175;
            case"baby black dragon": return 1;
            case"baby blue dragon": return 1;
            case"balfrug kreeyath": return 1;
            case"bandit": return 1.025;
            case"banshee": return 1;
            case"basilisk": return 1;
            case"bat": return 1;
            case"bear cub": return 1;
            case"bedabin nomad fighter": return 1;
            case"big wolf": return 1;
            case"black bear": return 1;
            case"black guard": return 1;
            case"black knight": return 1;
            case"black knight titan": return 1.025;
            case"black knight titan (hard)": return 1.05;
            case"black unicorn": return 1;
            case"blue dragon": return 1.025;
            case"bree": return 1;
            case"brine rat": return 1;
            case"brutal black dragon": return 1.075;
            case"brutal blue dragon": return 1.05;
            case"brutal green dragon": return 1.05;
            case"brutal red dragon": return 1.075;
            case"callisto": return 1.225;
            case"cave crawler": return 1;
            case"cave horror": return 1;
            case"cave kraken": return 1;
            case"cerberus": return 1.15;
            case"chaos druid": return 1;
            case"chaos dwarf": return 1;
            case"chaos elemental": return 1.075;
            case"chaos fanatic": return 1.125;
            case"chicken": return 0.975;
            case"cockatrice": return 1;
            case"commander zilyana": return 1.375;
            case"corporeal beast": return 1.55;
            case"cow": return 0.975;
            case"cow calf": return 0.975;
            case"crazy archaeologist": return 1.25;
            case"dad": return 1.05;
            case"dad (hard)": return 1.1;
            case"dagannoth prime": return 1.3;
            case"dagannoth rex": return 1.3;
            case"dagannoth supreme": return 1;
            case"dark beast": return 1.025;
            case"dark warrior": return 1.1;
            case"dawn": return 1;
            case"deadly red spider": return 1;
            case"demonic gorilla": return 1.075;
            case"deranged archaeologist": return 1.05;
            case"deviant spectre": return 1.025;
            case"dharok": return 1.15;
            case"drake": return 1.075;
            case"druid": return 1;
            case"duck": return 0.975;
            case"dwarf": return 1;
            case"earth warrior": return 1;
            case"elder chaos druid": return 1;
            case"elf warrior": return 1.025;
            case"ent": return 1.025;
            case"farmer": return 1;
            case"fire giant": return 1;
            case"flight kilisa": return 1;
            case"flockleader geerin": return 1;
            case"fortress guard": return 1;
            case"gargoyle": return 1;
            case"general graardor": return 1.325;
            case"giant bat": return 1;
            case"giant mole": return 1.075;
            case"giant spider": return 0.975;
            case"giant scarab": return 1.05;
            case"goblin": return 0.975;
            case"great olm": return 1.575;
            case"great olm (left claw)": return 1;
            case"great olm (right claw)": return 1.325;
            case"greater nechryael": return 1.025;
            case"greater skeleton hellhound": return 1.05;
            case"grizzly bear": return 1;
            case"growler": return 1;
            case"guard dog": return 1;
            case"gunthor the brave": return 1;
            case"guthan": return 1.15;
            case"hero": return 1.025;
            case"hill giant": return 1;
            case"hoop snake": return 1;
            case"hydra": return 1.075;
            case"ice troll king": return 1.075;
            case"ice troll king (hard)": return 1.125;
            case"ice spider": return 1;
            case"ice warrior": return 1;
            case"icefiend": return 1;
            case"imp": return 0.975;
            case"infernal mage": return 1;
            case"iron dragon": return 1.05;
            case"jailer": return 1;
            case"jal-ak": return 1.025;
            case"jal-akrek-xil": return 1;
            case"jal-akrek-mej": return 1;
            case"jal-akrek-ket": return 1;
            case"jal-imkot": return 1;
            case"jal-mejjak": return 1;
            case"jal-mejrah": return 1;
            case"jal-nib": return 0.975;
            case"jal-xil": return 1;
            case"jal-zek": return 1;
            case"jaltok-jad": return 1;
            case"jelly": return 1;
            case"jogre": return 1;
            case"jungle demon": return 1.075;
            case"jungle demon (hard)": return 1.15;
            case"kalphite guardian": return 1;
            case"kalphite queen": return 1.1;//not exact, close enough average b/c of 2 forms
            case"kalphite soldier": return 1;
            case"kalphite worker": return 1;
            case"karil": return 1;
            case"ket-zek": return 1;
            case"king black dragon": return 1.075;
            case"king sand crab": return 1;
            case"king scorpion": return 1;
            case"knight of ardougne": return 1;
            case"kourend guard": return 1;
            case"kourend head guard": return 1;
            case"kraken": return 1;
            case"kree'arra": return 1.4;
            case"k'ril tsutsaroth": return 1.375;
            case"kurask": return 1;
            case"lava dragon": return 1.075;
            case"lizardman brute": return 1;
            case"lizardman shaman": return 1.05;
            case"lobstrosity": return 1;
            case"long-tailed wyvern": return 1.025;
            case"magic axe": return 1;
            case"mammoth": return 1;
            case"man": return 1;
            case"maniacal monkey": return 1;
            case"mithril dragon": return 1.075;
            case"monk": return 1;
            case"monkey": return 1;
            case"monkey guard": return 1.025;
            case"moss giant": return 1.025; //using nmz normal mode not slayer ones
            case"moss giant (hard)": return 1.075;
            case"mourner": return 1.025;
            case"mugger": return 1;
            case"mutated bloodveld": return 1;
            case"nechryael": return 1;
            case"night beast": return 1.175;
            case"obor": return 1.075;
            case"ogre": return 1;
            case"ork": return 1;
            case"paladin": return 1.025;
            case"penguin": return 1;
            case"pirate": return 1;
            case"poison scorpion": return 1;
            case"poison spider": return 1;
            case"possessed pickaxe": return 1;
            case"pyrefiend": return 1;
            case"rat": return 0.975;
            case"revenant imp": return 1;
            case"revenant goblin": return 1;
            case"revenant pyrefiend": return 1;
            case"revenant hobgoblin": return 1.025;
            case"revenant cyclops": return 1.075;
            case"revenant hellhound": return 1.075;
            case"revenant demon": return 1.075;
            case"revenant ork": return 1.1;
            case"revenant dark beast": return 1.125;
            case"revenant knight": return 1.175;
            case"revenant dragon": return 1.2;
            case"red dragon": return 1.025;
            case"robert the strong": return 1.05;
            case"rock crab": return 1;
            case"rune dragon": return 1.1;
            case"rockslug": return 1;
            case"rogue": return 1;
            case"sand crab": return 1;
            case"scarab mage": return 1.025;
            case"scarab swarm": return 1;
            case"scarabs": return 1;
            case"scorpia": return 1.3;
            case"sergeant grimspike": return 1;
            case"sergeant steelwill": return 1;
            case"sergeant strongstack": return 1;
            case"skeletal wyvern": return 1.05;
            case"skeleton": return 1.025;
            case"skotizo": return 1.375;
            case"slagilith": return 1;
            case"slagilith (hard)": return 1.025;
            case"smoke devil": return 1;
            case"snake": return 1;
            case"spider": return 1;
            case"spinolyp": return 1;
            case"spiritual warrior": return 1.025;
            case"spitting wyvern": return 1.025;
            case"starlight": return 1.05;
            case"steel dragon": return 1.05;
            case"suit of armour": return 1;
            case"suqah": return 1.025;
            case"taloned wyvern": return 1.025;
            case"tar monster": return 1;
            case"thermonuclear smoke devil": return 1;
            case"thief": return 1;
            case"thug": return 1;
            case"tok-xil": return 1;
            case"torag": return 1.125;
            case"troll general": return 1.075;
            case"tstanon karlak": return 1;
            case"twisted banshee": return 1;
            case"tzkal-zuk": return 1.575;
            case"tz-kih": return 1;
            case"tztok-jad": return 1;
            case"tzhaar-hur": return 1;
            case"tzhaar-ket": return 1;
            case"tzhaar-xil": return 1;
            case"unicorn": return 1;
            case"venenatis": return 1.525;
            case"verac": return 1.125;
            case"vet'ion": return 1.225;
            case"warped jelly": return 1;
            case"warrior woman": return 1;
            case"waterfiend": return 1;
            case"wingman skree": return 1.025;
            case"witch's experiment 1st": return 1;
            case"witch's experiment 2nd": return 1;
            case"witch's experiment 3rd": return 1;
            case"witch's experiment 4th": return 1;
            case"wolf": return 1;
            case"wyrm": return 1.025;
            case"yak": return 1;
            case"yt-hurkot": return 1;
            case"yt-mejkot": return 1;
            case"zakl'n gritch": return 1;
            case"maiden of sugadint": return 1;
            case"pestilent bloat": return 1.85;
            case"sotetseg": return 1.675;
            case"verzik": return 1.425;
            case"verzik ": return 1.85;
            case"nylocas matomenos": return 1;
            case"xarpus": return 1;
            case"nylocas vasilias": return 1.225;
            default:return 1;
        }

    }
}


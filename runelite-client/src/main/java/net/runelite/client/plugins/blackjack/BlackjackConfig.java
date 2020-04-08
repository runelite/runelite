package net.runelite.client.plugins.blackjack;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("blackjack")
public interface BlackjackConfig extends Config {
    @ConfigItem(
            keyName = "renderStyle",
            name = "Highlight Style",
            description = "Highlight setting",
            position = 1
    )
    default BlackjackRenderStyle renderStyle()
    {
        return BlackjackRenderStyle.HULL;
    }

    @ConfigItem(
            keyName = "npcToBlackjack",
            name = "NPC to Blackjack",
            description = "Select the NPC you will be Blackjacking",
            position = 2
    )
    default BlackjackNPCs npcToBlackjack()
    {
        return BlackjackNPCs.BANDIT;
    }

    @ConfigItem(
            keyName = "awakeStateColor",
            name = "Awake State Color",
            description = "Change the color of the awake state highlight",
            position = 3
    )
    default Color awakeStateColor() {return Color.ORANGE;}

    @ConfigItem(
            keyName = "knockedOutStateColor",
            name = "Knocked-Out State Color",
            description = "Change the color of the knocked-out state highlight",
            position = 4
    )
    default Color knockedOutStateColor() {return Color.GREEN;}

    @ConfigItem(
            keyName = "statusText",
            name = "Draw status text above NPCs",
            description = "Configures whether or not to write if the target NPC is awake or knocked out",
            position = 5
    )
    default boolean statusText()
    {
        return false;
    }
}
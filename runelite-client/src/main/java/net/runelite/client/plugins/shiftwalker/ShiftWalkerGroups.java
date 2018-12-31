package net.runelite.client.plugins.shiftwalker;

import java.util.HashSet;

public final class ShiftWalkerGroups {

    //Specific Targets to limit the walking to
    public static final String BOX_TRAP = "BOX TRAP";

    //Specific menu options to replace
    private static final String BOX_TRAP_DISMANTLE = "DISMANTLE";
    private static final String BOX_TRAP_CHECK = "CHECK";

    private static final String ATTACK_OPTIONS_ATTACK = "ATTACK";

    public static final HashSet<String> BOX_TRAP_KEYWORDS = new HashSet<>();
    public static final HashSet<String> ATTACK_OPTIONS_KEYWORDS = new HashSet<>();

    static {
        BOX_TRAP_KEYWORDS.add(BOX_TRAP_DISMANTLE);
        BOX_TRAP_KEYWORDS.add(BOX_TRAP_CHECK);

        ATTACK_OPTIONS_KEYWORDS.add(ATTACK_OPTIONS_ATTACK);
    }

}

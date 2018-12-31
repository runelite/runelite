package net.runelite.client.plugins.shiftwalker;

import java.util.HashSet;

public final class ShiftWalkerGroups {

    private static final String BOX_TRAP_DISMANTLE = "DISMANTLE";
    private static final String BOX_TRAP_CHECK = "CHECK";

    private static final String ATTACK_OPTIONS_ATTACK = "ATTACK";

    public static final HashSet<String> BOX_TRAPS = new HashSet<>();
    public static final HashSet<String> ATTACK_OPTIONS = new HashSet<>();

    static {
        BOX_TRAPS.add(BOX_TRAP_DISMANTLE);
        BOX_TRAPS.add(BOX_TRAP_CHECK);

        ATTACK_OPTIONS.add(ATTACK_OPTIONS_ATTACK);
    }

}

package net.runelite.client.plugins.runecraftingtracker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static net.runelite.api.AnimationID.*;
import static net.runelite.api.ItemID.*;

public class Rune{
    @Getter @Setter
    double exp;
    @Getter @Setter
    int count;
    @Getter @Setter
    int carried;
    @Getter @Setter
    int crafted;
    @Getter @Setter
    String name;
    @Getter @Setter
    int id;
    public Rune(double exp, String name, int id) {
        this.exp = exp;
        this.count = 0;
        this.carried = 0;
        this.crafted = 0;
        this.name = name;
        this.id = id;
    }
}
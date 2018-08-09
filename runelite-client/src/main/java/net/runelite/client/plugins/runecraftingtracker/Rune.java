package net.runelite.client.plugins.runecraftingtracker;
import lombok.Getter;
import lombok.Setter;

public class Rune{
    @Getter
    double exp;
    @Getter @Setter
    int count;
    @Getter @Setter
    int carried;
    @Getter @Setter
    int crafted;
    @Getter
    String name;
    @Getter
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
package net.runelite.client.plugins.barrowsprayer;

public class BarrowsBrother {
    private int NpcID;
    private int attkSpeed;
    private int attkAnim;
    private String name;

    public BarrowsBrother(int npcID, int attkSpeed, int attkAnim, String name){
        this.NpcID = npcID;
        this.attkSpeed = attkSpeed;
        this.attkAnim = attkAnim;
        this.name = name;
    }

    public int getAttkAnim() {
        return attkAnim;
    }

    public int getAttkSpeed() {
        return attkSpeed;
    }

    public int getNpcID() {
        return NpcID;
    }

    public String getName(){
        return name;
    }
}


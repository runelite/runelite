package net.runelite.client.plugins.easy.util;

public enum GloryMode {
    EDGEVILLE("Edgeville"),
    KARAMJA("Karamja"),
    DRAYNOR_VILLAGE("Draynor Village"),
    AL_KHARID("Al Kharid");

    private final String name;

    GloryMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

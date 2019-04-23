package net.runelite.client.plugins.easyscape;

public enum WealthRingMode {
	MISCELLANIA ("Miscellania"),
	GRAND_EXCHANGE ("Grand Exchange"),
	FALADOR ("Falador"),
	DONDAKAN ("Dondakan");

    private final String name;

    WealthRingMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("d")
	@Export("name")
	public final String name;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 905607023
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}

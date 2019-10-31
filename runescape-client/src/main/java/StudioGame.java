import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		signature = "Lcd;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("c")
	@Export("name")
	public final String name;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1841699431
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}

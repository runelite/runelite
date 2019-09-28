import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("sy")
	@ObfuscatedSignature(
		signature = "Lib;"
	)
	public static class237 field3086;
	@ObfuscatedName("q")
	@Export("name")
	public final String name;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 275633543
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Lig;",
		garbageValue = "-61677673"
	)
	@Export("getInvDefinition")
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}

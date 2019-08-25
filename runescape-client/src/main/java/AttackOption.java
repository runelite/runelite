import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("qz")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 52026669
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("ns")
	@ObfuscatedSignature(
		signature = "[Lhi;"
	)
	static Widget[] field3218;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("VarcInt_cached")
	static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("modIconSprites")
	static IndexedSprite[] modIconSprites;
	@ObfuscatedName("n")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-542237401"
	)
	void method4549(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4550(var1, var2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "-1028868558"
	)
	void method4550(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1686094781"
	)
	static void method4548() {
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			Player.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

	}
}

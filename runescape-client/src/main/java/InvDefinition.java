import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("InvDefinition_archive")
	static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("InvDefinition_cached")
	static EvictingDualNodeHashTable InvDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1030135997
	)
	@Export("size")
	public int size;

	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	InvDefinition() {
		this.size = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1381455080"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "1993704887"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1920949744"
	)
	@Export("HealthBarDefinition_clearCached")
	public static void HealthBarDefinition_clearCached() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "797834957"
	)
	static void method4273() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				class80.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}
}

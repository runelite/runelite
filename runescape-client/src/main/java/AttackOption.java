import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "[Lmy;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 478106921
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -201450723
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1189493177"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lha;I[B[BI)V",
		garbageValue = "304370962"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2626 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2626 = new byte[11][];
			var0.field2629 = new byte[11][];
			var0.field2631 = new int[11];
			var0.field2670 = new int[11];
		}

		var0.field2626[var1] = var2;
		if (var2 != null) {
			var0.field2625 = true;
		} else {
			var0.field2625 = false;

			for (int var4 = 0; var4 < var0.field2626.length; ++var4) {
				if (var0.field2626[var4] != null) {
					var0.field2625 = true;
					break;
				}
			}
		}

		var0.field2629[var1] = var3;
	}
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
public enum class312 implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3813(0, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3809(2, 2),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3815(3, 5),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3812(1, 6),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3810(4, 7),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	field3814(5, 8);

	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 427096005
	)
	final int field3811;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1839498097
	)
	@Export("id")
	final int id;

	class312(int var3, int var4) {
		this.field3811 = var3;
		this.id = var4;
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

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(Lha;Lii;IIZI)V",
		garbageValue = "40878852"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			AbstractWorldMapIcon.insertMenuItem(var7, NPC.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}

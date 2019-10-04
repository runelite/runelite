import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("HealthBar")
public class HealthBar extends Node {
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	@Export("definition")
	HealthBarDefinition definition;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("updates")
	IterableNodeDeque updates;

	@ObfuscatedSignature(
		signature = "(Lip;)V"
	)
	HealthBar(HealthBarDefinition var1) {
		this.updates = new IterableNodeDeque();
		this.definition = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "1"
	)
	@Export("put")
	void put(int var1, int var2, int var3, int var4) {
		HealthBarUpdate var5 = null;
		int var6 = 0;

		for (HealthBarUpdate var7 = (HealthBarUpdate)this.updates.last(); var7 != null; var7 = (HealthBarUpdate)this.updates.previous()) {
			++var6;
			if (var7.cycle == var1) {
				var7.set(var1, var2, var3, var4);
				return;
			}

			if (var7.cycle <= var1) {
				var5 = var7;
			}
		}

		if (var5 == null) {
			if (var6 < 4) {
				this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
			}

		} else {
			IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5);
			if (var6 >= 4) {
				this.updates.last().remove();
			}

		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Lbq;",
		garbageValue = "109"
	)
	@Export("get")
	HealthBarUpdate get(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate)this.updates.last();
		if (var2 != null && var2.cycle <= var1) {
			for (HealthBarUpdate var3 = (HealthBarUpdate)this.updates.previous(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.previous()) {
				var2.remove();
				var2 = var3;
			}

			if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) {
				return var2;
			} else {
				var2.remove();
				return null;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-783831173"
	)
	@Export("isEmpty")
	boolean isEmpty() {
		return this.updates.method4775();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Llb;III)I",
		garbageValue = "-1932083268"
	)
	static int method2034(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IZI)Ljava/lang/String;",
		garbageValue = "878473077"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		if (var1 && var0 >= 0) {
			int var3 = var0;
			String var2;
			if (var1 && var0 >= 0) {
				int var4 = 2;

				for (int var5 = var0 / 10; var5 != 0; ++var4) {
					var5 /= 10;
				}

				char[] var6 = new char[var4];
				var6[0] = '+';

				for (int var7 = var4 - 1; var7 > 0; --var7) {
					int var8 = var3;
					var3 /= 10;
					int var9 = var8 - var3 * 10;
					if (var9 >= 10) {
						var6[var7] = (char)(var9 + 87);
					} else {
						var6[var7] = (char)(var9 + 48);
					}
				}

				var2 = new String(var6);
			} else {
				var2 = Integer.toString(var0, 10);
			}

			return var2;
		} else {
			return Integer.toString(var0);
		}
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(Lby;I)V",
		garbageValue = "1394806934"
	)
	static final void method2032(Actor var0) {
		if (var0.field976 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
			int var1 = var0.field976 - var0.field948;
			int var2 = Client.cycle - var0.field948;
			int var3 = var0.size * -527978816 + var0.field971 * 128;
			int var4 = var0.size * -527978816 + var0.field973 * 128;
			int var5 = var0.field972 * 128 + var0.size * -527978816;
			int var6 = var0.size * -527978816 + var0.field974 * 128;
			var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
			var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
		}

		var0.field949 = 0;
		var0.orientation = var0.field977;
		var0.rotation = var0.orientation;
	}
}

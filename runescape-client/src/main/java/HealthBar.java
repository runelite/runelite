import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cb")
@Implements("HealthBar")
public class HealthBar extends Node {
	@ObfuscatedName("j")
	static byte[][][] field1089;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("pcmPlayerProvider")
	public static PcmPlayerProvider pcmPlayerProvider;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lix;"
	)
	@Export("definition")
	HealthBarDefinition definition;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("updates")
	IterableNodeDeque updates;

	@ObfuscatedSignature(
		signature = "(Lix;)V"
	)
	HealthBar(HealthBarDefinition var1) {
		this.updates = new IterableNodeDeque();
		this.definition = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1491232381"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Lbl;",
		garbageValue = "1"
	)
	@Export("get")
	HealthBarUpdate get(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate)this.updates.last();
		if (var2 != null && var2.cycle <= var1) {
			for (HealthBarUpdate var3 = (HealthBarUpdate)this.updates.previous(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.previous()) {
				var2.remove();
				var2 = var3;
			}

			if (this.definition.int5 + var2.cycle + var2.cycleOffset > var1) {
				return var2;
			} else {
				var2.remove();
				return null;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-796562710"
	)
	@Export("isEmpty")
	boolean isEmpty() {
		return this.updates.method4874();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-60300776"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1113312719"
	)
	static int method2006(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.ADD) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SUB) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == ScriptOpcodes.MULTIPLY) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == ScriptOpcodes.DIV) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOM) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOMINC) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == ScriptOpcodes.INTERPOLATE) {
			class160.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
			return 1;
		} else if (var0 == ScriptOpcodes.ADDPERCENT) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
			return 1;
		} else if (var0 == ScriptOpcodes.SETBIT) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == ScriptOpcodes.CLEARBIT) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == ScriptOpcodes.TESTBIT) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.MOD) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == ScriptOpcodes.POW) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.INVPOW) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == ScriptOpcodes.AND) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == ScriptOpcodes.OR) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SCALE) {
			class160.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (int)(var9 * var13 / var11);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "-65"
	)
	static int method1999(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1895452388"
	)
	static final void method2007(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetYs[var4] + Client.rootWidgetHeights[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field827[var4] = true;
			}
		}

	}
}

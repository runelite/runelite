import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("dk")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("n")
	static int[] field1529;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2033716223
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1107292427
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -23532387
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = -3787059622854517303L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1744299723
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("c")
	static double method2836(double var0) {
		return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "-128"
	)
	static int method2834(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.ADD) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SUB) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == ScriptOpcodes.MULTIPLY) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4 * var3;
			return 1;
		} else if (var0 == ScriptOpcodes.DIV) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOM) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOMINC) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == ScriptOpcodes.INTERPOLATE) {
			class320.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
			return 1;
		} else if (var0 == ScriptOpcodes.ADDPERCENT) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
			return 1;
		} else if (var0 == ScriptOpcodes.SETBIT) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == ScriptOpcodes.CLEARBIT) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == ScriptOpcodes.TESTBIT) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.MOD) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == ScriptOpcodes.POW) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.INVPOW) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == ScriptOpcodes.AND) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == ScriptOpcodes.OR) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SCALE) {
			class320.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (int)(var9 * var13 / var11);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "182557525"
	)
	static final void method2835() {
		Client.field759 = 0;
		int var0 = Messages.baseX * 64 + (class192.localPlayer.x >> 7);
		int var1 = Language.baseY * 64 + (class192.localPlayer.y >> 7);
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field759 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field759 = 1;
		}

		if (Client.field759 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field759 = 0;
		}

	}
}

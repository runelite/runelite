import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fm")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("e")
	@Export("JagexCache_locationFile")
	static File JagexCache_locationFile;
	@ObfuscatedName("i")
	@Export("cacheDir")
	public static File cacheDir;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -27692753
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lme;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lme;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lme;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("gs")
	@Export("xteaKeys")
	static int[][] xteaKeys;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-462100671"
	)
	static int method3566(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		int var11;
		if (var0 == ScriptOpcodes.CC_SETOP) {
			var11 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize]);
				return 1;
			} else {
				--Message.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == ScriptOpcodes.CC_SETDRAGGABLE) {
				class320.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				var4.parent = SpriteMask.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGGABLEBEHAVIOR) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADZONE) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADTIME) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOPBASE) {
				var4.dataText = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTARGETVERB) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_CLEAROPS) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.field2713 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1309) {
				--class320.Interpreter_intStackSize;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != ScriptOpcodes.CC_SETOPKEY) {
					byte var5;
					if (var0 == ScriptOpcodes.CC_SETOPTKEY) {
						class320.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]};
						ClanChat.Widget_setKey(var4, var5, var9, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYRATE) {
						class320.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							GrandExchangeOfferWorldComparator.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYRATE) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						GrandExchangeOfferWorldComparator.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYIGNOREHELD) {
						--class320.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							class192.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYIGNOREHELD) {
						var5 = 10;
						class192.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						class320.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + class320.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class320.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class320.Interpreter_intStackSize + 1];
							}
						}
					} else {
						class320.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						ClanChat.Widget_setKey(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}
}

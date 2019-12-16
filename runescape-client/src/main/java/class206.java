import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gg")
public class class206 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	@Export("huffman")
	static Huffman huffman;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("am")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-2034421458"
	)
	public static int method3926(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var1;
		} else if (var2 == 1) {
			return 7 - var0;
		} else {
			return var2 == 2 ? 7 - var1 : var0;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-2142702532"
	)
	static int method3919(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CLIENTCLOCK) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == ScriptOpcodes.INV_GETOBJ) {
				class188.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = MilliClock.method3447(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_GETNUM) {
				class188.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeEvents.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_TOTAL) {
				class188.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.method118(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_SIZE) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class197.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == ScriptOpcodes.STAT) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_BASE) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_XP) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == ScriptOpcodes.COORD) {
					var3 = UrlRequest.Client_plane;
					var4 = MusicPatchPcmStream.baseX * 64 + (Message.localPlayer.x >> 7);
					var5 = ScriptEvent.baseY * 64 + (Message.localPlayer.y >> 7);
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == ScriptOpcodes.COORDX) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDZ) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDY) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
					class188.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = MilliClock.method3447(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
					class188.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeEvents.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
					class188.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.method118(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.REBOOTTIMER) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_WORLD) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == ScriptOpcodes.PLAYERMOD) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDFLAGS) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == ScriptOpcodes.MOVECOORD) {
					class188.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(Lbv;II)V",
		garbageValue = "-1115818539"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		KeyHandler.worldToScreen(var0.x, var0.y, var1);
	}
}

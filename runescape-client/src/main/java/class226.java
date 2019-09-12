import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hv")
public class class226 {
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "-1604203626"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(class16.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public static void method4108() {
		class197.midiPcmStream.clear();
		class197.field2376 = 1;
		class197.musicTrackArchive = null;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1401808695"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "1"
	)
	static int method4109(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CLIENTCLOCK) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == ScriptOpcodes.INV_GETOBJ) {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = MusicPatch.method3877(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_GETNUM) {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Varcs.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_TOTAL) {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = PendingSpawn.method1683(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_SIZE) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Players.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == ScriptOpcodes.STAT) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_BASE) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_XP) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == ScriptOpcodes.COORD) {
					var3 = MouseRecorder.plane;
					var4 = class4.baseX * 64 + (Varps.localPlayer.x * -78439701 >> 7);
					var5 = (Varps.localPlayer.y >> 7) + ScriptEvent.baseY;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == ScriptOpcodes.COORDX) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDZ) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDY) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
					class160.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = MusicPatch.method3877(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
					class160.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Varcs.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
					class160.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = PendingSpawn.method1683(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.REBOOTTIMER) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_WORLD) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == ScriptOpcodes.PLAYERMOD) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDFLAGS) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == ScriptOpcodes.MOVECOORD) {
					class160.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}

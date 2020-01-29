import java.lang.management.GarbageCollectorMXBean;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cm")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("an")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("c")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("t")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-884286176"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1065937119"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "519596197"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var2) {
			return class51.method896();
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lhu;",
		garbageValue = "44"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_normal, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_ironman};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ZZI)Lli;",
		garbageValue = "-1201437930"
	)
	static IndexedSprite method2171(boolean var0, boolean var1) {
		return var0 ? (var1 ? VertexNormal.field1753 : DirectByteArrayCopier.options_buttons_2Sprite) : (var1 ? ItemContainer.field547 : WorldMapSprite.options_buttons_0Sprite);
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1704416266"
	)
	static int method2169(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CLIENTCLOCK) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == ScriptOpcodes.INV_GETOBJ) {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Varps.method4043(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_GETNUM) {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = UserComparator3.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_TOTAL) {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.method340(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_SIZE) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = SpotAnimationDefinition.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == ScriptOpcodes.STAT) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_BASE) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_XP) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == ScriptOpcodes.COORD) {
					var3 = Clock.Client_plane;
					var4 = Messages.baseX * 64 + (class192.localPlayer.x >> 7);
					var5 = Language.baseY * 64 + (class192.localPlayer.y >> 7);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == ScriptOpcodes.COORDX) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDZ) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDY) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
					class320.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Varps.method4043(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
					class320.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = UserComparator3.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
					class320.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.method340(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.REBOOTTIMER) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_WORLD) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == ScriptOpcodes.PLAYERMOD) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDFLAGS) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == ScriptOpcodes.MOVECOORD) {
					class320.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}

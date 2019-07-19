import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ag")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("rx")
	@ObfuscatedGetter(
		intValue = -1345253721
	)
	static int field268;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final WorldMapID field272;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final WorldMapID field269;
	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "[Lly;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -976208545
	)
	@Export("value")
	final int value;

	static {
		field272 = new WorldMapID(0);
		field269 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-37"
	)
	static final void method541(String var0) {
		StringBuilder var10000 = new StringBuilder();
		Object var10001 = null;
		var10000 = var10000.append("Please remove ").append(var0);
		var10001 = null;
		String var1 = var10000.append(" from your friend list first").toString();
		ScriptEvent.addGameMessage(30, "", var1);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-216787124"
	)
	static int method540(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CLIENTCLOCK) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == ScriptOpcodes.INV_GETOBJ) {
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = AbstractWorldMapData.method274(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_GETNUM) {
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class2.method27(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_TOTAL) {
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = BufferedFile.method6528(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_SIZE) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = NetSocket.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == ScriptOpcodes.STAT) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_BASE) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_XP) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == ScriptOpcodes.COORD) {
					var3 = class42.plane;
					var4 = MusicPatchNode2.baseX * 64 + (Client.localPlayer.x >> 7);
					var5 = class1.baseY * 64 + (Client.localPlayer.y >> 7);
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == ScriptOpcodes.COORDX) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDZ) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDY) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
					HealthBarUpdate.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = AbstractWorldMapData.method274(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
					HealthBarUpdate.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class2.method27(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
					HealthBarUpdate.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = BufferedFile.method6528(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.REBOOTTIMER) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_WORLD) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == ScriptOpcodes.PLAYERMOD) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDFLAGS) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == ScriptOpcodes.MOVECOORD) {
					HealthBarUpdate.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "(I)Llw;",
		garbageValue = "-1838562089"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return BoundaryObject.worldMap;
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-456020317"
	)
	static void method542() {
		if (Client.isSpellSelected) {
			Widget var0 = Client.getWidgetChild(WorldMapEvent.field359, Client.field848);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				LoginPacket.runScriptEvent(var1);
			}

			Client.isSpellSelected = false;
			Strings.method4120(var0);
		}
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "([Lhj;IS)V",
		garbageValue = "28886"
	)
	static final void method539(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						method539(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						WorldMapLabelSize.method175(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					LoginPacket.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = class80.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					LoginPacket.runScriptEvent(var5);
				}
			}
		}

	}
}

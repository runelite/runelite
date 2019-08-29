import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bm")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 520550313
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1382168131
	)
	@Export("type")
	int type;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1841764773
	)
	@Export("x")
	int x;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -677953367
	)
	@Export("y")
	int y;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1218871691
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1853437901
	)
	int field907;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1490063309
	)
	int field903;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1310509737
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1509033293
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1964885807
	)
	int field911;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 679658845
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2126284793
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1879382681"
	)
	static void method1661() {
		Login.loginIndex = 24;
		GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "You were disconnected from the server.", "");
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "1685357339"
	)
	static int method1660(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CLIENTCLOCK) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == ScriptOpcodes.INV_GETOBJ) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Language.method3605(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_GETNUM) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Decimator.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_TOTAL) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class43.method761(var3, var4);
				return 1;
			} else if (var0 == ScriptOpcodes.INV_SIZE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Actor.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == ScriptOpcodes.STAT) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_BASE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == ScriptOpcodes.STAT_XP) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == ScriptOpcodes.COORD) {
					var3 = ItemContainer.plane;
					var4 = PacketWriter.baseX * 64 + (WorldMapIcon_1.localPlayer.x >> 7);
					var5 = RouteStrategy.baseY * 64 + (WorldMapIcon_1.localPlayer.y >> 7);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == ScriptOpcodes.COORDX) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDZ) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == ScriptOpcodes.COORDY) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Language.method3605(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Decimator.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class43.method761(var3, var4);
					return 1;
				} else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.REBOOTTIMER) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == ScriptOpcodes.MAP_WORLD) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == ScriptOpcodes.PLAYERMOD) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDFLAGS) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == ScriptOpcodes.MOVECOORD) {
					Interpreter.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(ZLkx;B)V",
		garbageValue = "4"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var2;
		int var3;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			var2 = var1.method5447();
			var3 = var1.method5446();
			int var4 = var1.readUnsignedShort();
			ModelData0.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					ModelData0.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			class186.regions = new int[var4];
			MouseHandler.regionMapArchiveIds = new int[var4];
			ClanChat.regionLandArchiveIds = new int[var4];
			GraphicsObject.regionLandArchives = new byte[var4][];
			Messages.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
				var16 = true;
			}

			if (var3 / 8 == 48 && var2 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						class186.regions[var4] = var8;
						MouseHandler.regionMapArchiveIds[var4] = WorldMapDecoration.archive5.getGroupId("m" + var6 + "_" + var7);
						ClanChat.regionLandArchiveIds[var4] = WorldMapDecoration.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			ModelData0.method3198(var3, var2, true);
		} else {
			var2 = var1.method5446();
			var3 = var1.method5447();
			boolean var15 = var1.readUnsignedByte() == 1;
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			ModelData0.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					ModelData0.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			class186.regions = new int[var5];
			MouseHandler.regionMapArchiveIds = new int[var5];
			ClanChat.regionLandArchiveIds = new int[var5];
			GraphicsObject.regionLandArchives = new byte[var5][];
			Messages.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (class186.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								class186.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								MouseHandler.regionMapArchiveIds[var5] = WorldMapDecoration.archive5.getGroupId("m" + var13 + "_" + var14);
								ClanChat.regionLandArchiveIds[var5] = WorldMapDecoration.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			ModelData0.method3198(var3, var2, !var15);
		}

	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "215444906"
	)
	@Export("isWidgetMenuOpcode")
	static boolean isWidgetMenuOpcode(int var0) {
		return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
	}
}

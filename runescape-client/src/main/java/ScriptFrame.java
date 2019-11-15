import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bx")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("m")
	@Export("musicTrackBoolean")
	public static boolean musicTrackBoolean;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lcj;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -692629101
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("n")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("q")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILcj;ZB)I",
		garbageValue = "2"
	)
	static int method1218(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return class65.method1321(var0, var1, var2);
		} else if (var0 < 1100) {
			return GrandExchangeOfferTotalQuantityComparator.method134(var0, var1, var2);
		} else if (var0 < 1200) {
			return class185.method3772(var0, var1, var2);
		} else if (var0 < 1300) {
			return TaskHandler.method3605(var0, var1, var2);
		} else if (var0 < 1400) {
			return PacketBufferNode.method3784(var0, var1, var2);
		} else if (var0 < 1500) {
			return class42.method873(var0, var1, var2);
		} else if (var0 < 1600) {
			return class185.method3773(var0, var1, var2);
		} else if (var0 < 1700) {
			return WorldMapRegion.method574(var0, var1, var2);
		} else if (var0 < 1800) {
			return AbstractByteArrayCopier.method4093(var0, var1, var2);
		} else if (var0 < 1900) {
			return ScriptEvent.method1263(var0, var1, var2);
		} else if (var0 < 2000) {
			return GameShell.method1142(var0, var1, var2);
		} else if (var0 < 2100) {
			return GrandExchangeOfferTotalQuantityComparator.method134(var0, var1, var2);
		} else if (var0 < 2200) {
			return class185.method3772(var0, var1, var2);
		} else if (var0 < 2300) {
			return TaskHandler.method3605(var0, var1, var2);
		} else if (var0 < 2400) {
			return PacketBufferNode.method3784(var0, var1, var2);
		} else if (var0 < 2500) {
			return class42.method873(var0, var1, var2);
		} else if (var0 < 2600) {
			return PacketWriter.method2426(var0, var1, var2);
		} else if (var0 < 2700) {
			return class49.method938(var0, var1, var2);
		} else if (var0 < 2800) {
			return class2.method32(var0, var1, var2);
		} else if (var0 < 2900) {
			return SoundCache.method2673(var0, var1, var2);
		} else if (var0 < 3000) {
			return GameShell.method1142(var0, var1, var2);
		} else if (var0 < 3200) {
			return class189.method3796(var0, var1, var2);
		} else if (var0 < 3300) {
			return class16.method224(var0, var1, var2);
		} else if (var0 < 3400) {
			return DevicePcmPlayerProvider.method916(var0, var1, var2);
		} else if (var0 < 3500) {
			return Message.method1310(var0, var1, var2);
		} else if (var0 < 3700) {
			return class30.method605(var0, var1, var2);
		} else if (var0 < 4000) {
			return class216.method4196(var0, var1, var2);
		} else if (var0 < 4100) {
			return SecureRandomCallable.method1226(var0, var1, var2);
		} else if (var0 < 4200) {
			return GrandExchangeOfferAgeComparator.method196(var0, var1, var2);
		} else if (var0 < 4300) {
			return method1217(var0, var1, var2);
		} else if (var0 < 5100) {
			return class40.method837(var0, var1, var2);
		} else if (var0 < 5400) {
			return ArchiveLoader.method1245(var0, var1, var2);
		} else if (var0 < 5600) {
			return Tiles.method1215(var0, var1, var2);
		} else if (var0 < 5700) {
			return GraphicsDefaults.method6006(var0, var1, var2);
		} else if (var0 < 6300) {
			return MouseHandler.method1176(var0, var1, var2);
		} else if (var0 < 6600) {
			return ArchiveDiskAction.method4296(var0, var1, var2);
		} else {
			return var0 < 6700 ? class43.method877(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lbk;Lbk;IZI)I",
		garbageValue = "697850759"
	)
	@Export("compareWorlds")
	static int compareWorlds(World var0, World var1, int var2, boolean var3) {
		if (var2 == 1) {
			int var4 = var0.population;
			int var5 = var1.population;
			if (!var3) {
				if (var4 == -1) {
					var4 = 2001;
				}

				if (var5 == -1) {
					var5 = 2001;
				}
			}

			return var4 - var5;
		} else if (var2 == 2) {
			return var0.location - var1.location;
		} else if (var2 == 3) {
			if (var0.activity.equals("-")) {
				if (var1.activity.equals("-")) {
					return 0;
				} else {
					return var3 ? -1 : 1;
				}
			} else if (var1.activity.equals("-")) {
				return var3 ? 1 : -1;
			} else {
				return var0.activity.compareTo(var1.activity);
			}
		} else if (var2 == 4) {
			return var0.method1885() ? (var1.method1885() ? 0 : 1) : (var1.method1885() ? -1 : 0);
		} else if (var2 == 5) {
			return var0.method1917() ? (var1.method1917() ? 0 : 1) : (var1.method1917() ? -1 : 0);
		} else if (var2 == 6) {
			return var0.isPvp() ? (var1.isPvp() ? 0 : 1) : (var1.isPvp() ? -1 : 0);
		} else if (var2 == 7) {
			return var0.isMembersOnly() ? (var1.isMembersOnly() ? 0 : 1) : (var1.isMembersOnly() ? -1 : 0);
		} else {
			return var0.id - var1.id;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1066655429"
	)
	static int method1217(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.OC_NAME) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = class222.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == ScriptOpcodes.OC_OP) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = class222.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_IOP) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = class222.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_COST) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class222.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == ScriptOpcodes.OC_STACKABLE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class222.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == ScriptOpcodes.OC_CERT) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = class222.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNCERT) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = class222.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_MEMBERS) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class222.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.OC_PLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = class222.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNPLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = class222.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_FIND) {
					String var7 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					BoundaryObject.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = MouseHandler.foundItemIdCount;
					return 1;
				} else if (var0 != ScriptOpcodes.OC_FINDNEXT) {
					if (var0 == ScriptOpcodes.OC_FINDRESET) {
						WorldMapManager.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (UserComparator4.foundItemIds != null && WorldMapManager.foundItemIndex < MouseHandler.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator4.foundItemIds[++WorldMapManager.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "256"
	)
	static final void method1219() {
		if (Player.Client_plane != Client.field856) {
			Client.field856 = Player.Client_plane;
			int var0 = Player.Client_plane;
			int[] var1 = FloorDecoration.sceneMinimapSprite.pixels;
			int var2 = var1.length;

			int var3;
			for (var3 = 0; var3 < var2; ++var3) {
				var1[var3] = 0;
			}

			int var4;
			int var5;
			for (var3 = 1; var3 < 103; ++var3) {
				var4 = (103 - var3) * 2048 + 24628;

				for (var5 = 1; var5 < 103; ++var5) {
					if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
						WorldMapArea.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
					}

					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
						WorldMapArea.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
					}

					var4 += 4;
				}
			}

			var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
			var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
			FloorDecoration.sceneMinimapSprite.setRaster();

			int var6;
			for (var5 = 1; var5 < 103; ++var5) {
				for (var6 = 1; var6 < 103; ++var6) {
					if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
						WorldMapLabel.drawObject(var0, var6, var5, var3, var4);
					}

					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
						WorldMapLabel.drawObject(var0 + 1, var6, var5, var3, var4);
					}
				}
			}

			Client.mapIconCount = 0;

			for (var5 = 0; var5 < 104; ++var5) {
				for (var6 = 0; var6 < 104; ++var6) {
					long var7 = WorldMapArea.scene.getFloorDecorationTag(Player.Client_plane, var5, var6);
					if (0L != var7) {
						int var9 = UserComparator8.Entity_unpackID(var7);
						int var10 = WorldMapDecorationType.getObjectDefinition(var9).mapIconId;
						if (var10 >= 0) {
							Client.mapIcons[Client.mapIconCount] = class65.WorldMapElement_get(var10).getSpriteBool(false);
							Client.mapIconXs[Client.mapIconCount] = var5;
							Client.mapIconYs[Client.mapIconCount] = var6;
							++Client.mapIconCount;
						}
					}
				}
			}

			AbstractWorldMapData.rasterProvider.apply();
		}

	}
}

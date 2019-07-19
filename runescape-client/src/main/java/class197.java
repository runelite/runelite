import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gf")
public class class197 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -865740165
	)
	public static int field2402;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 713445849
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 924642041
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1197525527
	)
	public static int field2404;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive0")
	static Archive archive0;

	static {
		field2402 = 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "-75"
	)
	public static int method3702(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-1"
	)
	@Export("FloorUnderlayDefinition_clearCached")
	public static void FloorUnderlayDefinition_clearCached() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-1023115268"
	)
	static int method3703(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.WORLDLIST_FETCH) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = UserComparator3.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == ScriptOpcodes.WORLDLIST_START) {
				var3 = DynamicObject.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.WORLDLIST_NEXT) {
				var3 = Canvas.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == ScriptOpcodes.WORLDLIST_SPECIFIC) {
					var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.worldsCount; ++var5) {
						if (var7 == World.worlds[var5].id) {
							var4 = World.worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDLIST_SORT) {
					HealthBarUpdate.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3] == 1;
					WorldMapLabelSize.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != ScriptOpcodes.GETWORLDINFO) {
					if (var0 == ScriptOpcodes.SETFOLLOWEROPSLOWPRIORITY) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == ScriptOpcodes.NC_PARAM) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_0.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = GameShell.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = GameShell.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.LC_PARAM) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_0.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = ViewportMouse.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ViewportMouse.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.OC_PARAM) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_0.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = WorldMapArea.getItemDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WorldMapArea.getItemDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.STRUCT_PARAM) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_0.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = ParamDefinition.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ParamDefinition.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ON_MOBILE) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CLIENTTYPE) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == ScriptOpcodes.MOBILE_KEYBOARDHIDE) {
							return 1;
						} else if (var0 == 6522) {
							--Skills.Interpreter_stringStackSize;
							--HealthBarUpdate.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--Skills.Interpreter_stringStackSize;
							--HealthBarUpdate.Interpreter_intStackSize;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYLEVEL) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYCHARGING) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == ScriptOpcodes.WIFIAVAILABLE) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.worldsCount) {
						var4 = World.worlds[var7];
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		signature = "(Lbo;ZI)V",
		garbageValue = "391006565"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		int var5;
		if (var1 && var2 != -1 && ViewportMouse.loadedInterfaces[var2]) {
			Widget.Widget_archive.clearFilesGroup(var2);
			if (Widget.Widget_interfaceComponents[var2] != null) {
				boolean var7 = true;

				for (var5 = 0; var5 < Widget.Widget_interfaceComponents[var2].length; ++var5) {
					if (Widget.Widget_interfaceComponents[var2][var5] != null) {
						if (Widget.Widget_interfaceComponents[var2][var5].type != 2) {
							Widget.Widget_interfaceComponents[var2][var5] = null;
						} else {
							var7 = false;
						}
					}
				}

				if (var7) {
					Widget.Widget_interfaceComponents[var2] = null;
				}

				ViewportMouse.loadedInterfaces[var2] = false;
			}
		}

		for (IntegerNode var4 = (IntegerNode)Client.widgetClickMasks.first(); var4 != null; var4 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((var4.key >> 48 & 65535L) == (long)var2) {
				var4.remove();
			}
		}

		Widget var8 = class80.getWidget(var3);
		if (var8 != null) {
			Strings.method4120(var8);
		}

		for (var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			if (class1.isWidgetMenuOpcode(Client.menuOpcodes[var5])) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
						Client.menuActions[var6] = Client.menuActions[var6 + 1];
						Client.menuTargetNames[var6] = Client.menuTargetNames[var6 + 1];
						Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
						Client.menuArguments0[var6] = Client.menuArguments0[var6 + 1];
						Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
						Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
						Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		GrandExchangeOfferAgeComparator.method145();
		if (Client.rootInterface != -1) {
			WorldMapLabelSize.method175(Client.rootInterface, 1);
		}

	}
}

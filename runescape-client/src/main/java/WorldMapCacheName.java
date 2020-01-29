import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("as")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	public static final WorldMapCacheName field313;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	public static final WorldMapCacheName field309;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	public static final WorldMapCacheName field310;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	static final WorldMapCacheName field311;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	public static final WorldMapCacheName field312;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static Bounds field315;
	@ObfuscatedName("g")
	@Export("name")
	public final String name;

	static {
		field313 = new WorldMapCacheName("details");
		field309 = new WorldMapCacheName("compositemap");
		field310 = new WorldMapCacheName("compositetexture");
		field311 = new WorldMapCacheName("area");
		field312 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1252673540"
	)
	public static void method635() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Lbg;",
		garbageValue = "-1273347213"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return DefaultsGroup.getNextWorldListWorld();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1459366503"
	)
	static void method634() {
		Login.loginIndex = 24;
		Tiles.setLoginResponseString("", "You were disconnected from the server.", "");
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "8"
	)
	static int method633(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.WORLDLIST_FETCH) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = UserComparator8.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == ScriptOpcodes.WORLDLIST_START) {
				var3 = worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.WORLDLIST_NEXT) {
				var3 = DefaultsGroup.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == ScriptOpcodes.WORLDLIST_SPECIFIC) {
					var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == class96.World_worlds[var5].id) {
							var4 = class96.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDLIST_SORT) {
					class320.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3] == 1;
					WorldMapDecoration.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != ScriptOpcodes.GETWORLDINFO) {
					if (var0 == ScriptOpcodes.SETFOLLOWEROPSLOWPRIORITY) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == ScriptOpcodes.NC_PARAM) {
							class320.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var9 = PacketBufferNode.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = NetCache.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = NetCache.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.LC_PARAM) {
							class320.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var9 = PacketBufferNode.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = Occluder.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Occluder.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.OC_PARAM) {
							class320.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var9 = PacketBufferNode.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.STRUCT_PARAM) {
							class320.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var9 = PacketBufferNode.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = Fonts.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Fonts.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ON_MOBILE) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CLIENTTYPE) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == ScriptOpcodes.MOBILE_KEYBOARDHIDE) {
							return 1;
						} else if (var0 == 6522) {
							--Message.Interpreter_stringStackSize;
							--class320.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--Message.Interpreter_stringStackSize;
							--class320.Interpreter_intStackSize;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYLEVEL) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYCHARGING) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == ScriptOpcodes.WIFIAVAILABLE) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = class96.World_worlds[var7];
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1758289835"
	)
	@Export("formatItemStacks")
	static final String formatItemStacks(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + PacketWriter.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + PacketWriter.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + PacketWriter.colorStartTag(16776960) + var1 + "</col>";
		}
	}

	@ObfuscatedName("lj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1011989365"
	)
	static void method636() {
		if (Client.oculusOrbState == 1) {
			Client.field728 = true;
		}

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ec")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = 1884490031
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1455468639
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1625268339
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1008616069
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1888618101
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1426689619
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1112566739
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1176154873
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = -7342954740036986227L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 798817733
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
		garbageValue = "-147056838"
	)
	@Export("shortenStackTrace")
	static String shortenStackTrace(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = (RunException)var0;
			var1 = var2.message + " | ";
			var0 = var2.throwable;
		} else {
			var1 = "";
		}

		StringWriter var12 = new StringWriter();
		PrintWriter var3 = new PrintWriter(var12);
		var0.printStackTrace(var3);
		var3.close();
		String var4 = var12.toString();
		BufferedReader var5 = new BufferedReader(new StringReader(var4));
		String var6 = var5.readLine();

		while (true) {
			while (true) {
				String var7 = var5.readLine();
				if (var7 == null) {
					var1 = var1 + "| " + var6;
					return var1;
				}

				int var8 = var7.indexOf(40);
				int var9 = var7.indexOf(41, var8 + 1);
				if (var8 >= 0 && var9 >= 0) {
					String var10 = var7.substring(var8 + 1, var9);
					int var11 = var10.indexOf(".java:");
					if (var11 >= 0) {
						var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
						var1 = var1 + var10 + ' ';
						continue;
					}

					var7 = var7.substring(0, var8);
				}

				var7 = var7.trim();
				var7 = var7.substring(var7.lastIndexOf(32) + 1);
				var7 = var7.substring(var7.lastIndexOf(9) + 1);
				var1 = var1 + var7 + ' ';
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "42"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return Ignored.parseIntCustomRadix(var0, 10, true);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "1"
	)
	public static int method3245(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "234217690"
	)
	static int method3243(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.WORLDLIST_FETCH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class173.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == ScriptOpcodes.WORLDLIST_START) {
				var3 = DevicePcmPlayerProvider.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.WORLDLIST_NEXT) {
				var3 = GrandExchangeOfferAgeComparator.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == ScriptOpcodes.WORLDLIST_SPECIFIC) {
					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == ChatChannel.World_worlds[var5].id) {
							var4 = ChatChannel.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDLIST_SORT) {
					Interpreter.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3] == 1;
					MouseHandler.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != ScriptOpcodes.GETWORLDINFO) {
					if (var0 == ScriptOpcodes.SETFOLLOWEROPSLOWPRIORITY) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == ScriptOpcodes.NC_PARAM) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = VarcInt.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ViewportMouse.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ViewportMouse.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.LC_PARAM) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = VarcInt.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class215.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class215.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.OC_PARAM) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = VarcInt.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = WorldMapData_0.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapData_0.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.STRUCT_PARAM) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = VarcInt.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class43.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class43.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ON_MOBILE) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CLIENTTYPE) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == ScriptOpcodes.MOBILE_KEYBOARDHIDE) {
							return 1;
						} else if (var0 == 6522) {
							--Interpreter.Interpreter_stringStackSize;
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--Interpreter.Interpreter_stringStackSize;
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYLEVEL) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYCHARGING) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == ScriptOpcodes.WIFIAVAILABLE) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = ChatChannel.World_worlds[var7];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}
}

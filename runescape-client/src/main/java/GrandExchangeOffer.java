import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("z")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("d")
	static int[] field67;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("c")
	@Export("state")
	byte state;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 742288721
	)
	@Export("id")
	public int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -900885629
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 915947343
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1696571551
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 737013101
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkz;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "639881605"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1620696399"
	)
	void method98(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-417146285"
	)
	void method92(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1743615056"
	)
	static int method103(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.WORLDLIST_FETCH) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ClientPacket.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == ScriptOpcodes.WORLDLIST_START) {
				var3 = class185.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.WORLDLIST_NEXT) {
				var3 = Frames.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == ScriptOpcodes.WORLDLIST_SPECIFIC) {
					var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == World.World_worlds[var5].id) {
							var4 = World.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDLIST_SORT) {
					class160.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3] == 1;
					WorldMapID.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != ScriptOpcodes.GETWORLDINFO) {
					if (var0 == ScriptOpcodes.SETFOLLOWEROPSLOWPRIORITY) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == ScriptOpcodes.NC_PARAM) {
							class160.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var9 = GrandExchangeOfferTotalQuantityComparator.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = FontName.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = FontName.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.LC_PARAM) {
							class160.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var9 = GrandExchangeOfferTotalQuantityComparator.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = WallDecoration.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = WallDecoration.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.OC_PARAM) {
							class160.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var9 = GrandExchangeOfferTotalQuantityComparator.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = Player.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Player.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.STRUCT_PARAM) {
							class160.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var9 = GrandExchangeOfferTotalQuantityComparator.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = class225.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class225.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ON_MOBILE) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CLIENTTYPE) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == ScriptOpcodes.MOBILE_KEYBOARDHIDE) {
							return 1;
						} else if (var0 == 6522) {
							--TextureProvider.Interpreter_stringStackSize;
							--class160.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--TextureProvider.Interpreter_stringStackSize;
							--class160.Interpreter_intStackSize;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYLEVEL) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYCHARGING) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == ScriptOpcodes.WIFIAVAILABLE) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = World.World_worlds[var7];
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}
}

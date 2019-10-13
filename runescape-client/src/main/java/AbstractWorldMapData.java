import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("f")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = 742897815
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 461674944
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 278884352
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -317022193
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 796055175
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 804294653
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 593055761
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1864196889
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -644572197
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("y")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("i")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("c")
	byte[][][] field164;
	@ObfuscatedName("b")
	byte[][][] field152;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "[[[[Lk;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("a")
	boolean field165;
	@ObfuscatedName("e")
	boolean field166;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field165 = false;
		this.field166 = false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "1549979331"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1858482709"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field165 && this.field166;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "-1207518623"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field165 = true;
				this.field166 = true;
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1757437769"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field164 = null;
		this.field152 = null;
		this.decorations = null;
		this.field165 = false;
		this.field166 = false;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IILkl;B)V",
		garbageValue = "10"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method262(var1, var2, var3, var4);
			} else {
				this.method268(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IILkl;II)V",
		garbageValue = "2059676399"
	)
	void method262(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IILkl;IB)V",
		garbageValue = "-56"
	)
	void method268(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field164[var9][var1][var2] = (byte)(var11 >> 2);
					this.field152[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5453();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-929324026"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2009466013"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)Liq;",
		garbageValue = "1"
	)
	public static VarpDefinition method288(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIIZIZI)V",
		garbageValue = "-1516072397"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = World.World_worlds[var6];
			World.World_worlds[var6] = World.World_worlds[var1];
			World.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				if (ArchiveLoader.method1174(World.World_worlds[var9], var8, var2, var3, var4, var5) <= 0) {
					World var10 = World.World_worlds[var9];
					World.World_worlds[var9] = World.World_worlds[var7];
					World.World_worlds[var7++] = var10;
				}
			}

			World.World_worlds[var1] = World.World_worlds[var7];
			World.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1561238800"
	)
	static int method289(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERTYPE) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERITEM) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERPRICE) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFEREMPTY) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERSTABLE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERFINISHED) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERADDING) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_NAME) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (TileItem.grandExchangeEvents != null) {
						TileItem.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_PRICE) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (TileItem.grandExchangeEvents != null) {
						TileItem.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					Interpreter.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
					if (TileItem.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						TileItem.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_AGE) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (TileItem.grandExchangeEvents != null) {
						TileItem.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_COUNT) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (TileItem.grandExchangeEvents != null) {
						TileItem.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_GETTOTALOFFERS) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.grandExchangeEvents == null ? 0 : TileItem.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERWORLD) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERNAME) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.getOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERAGE) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						long var5 = class30.currentTimeMillis() - class81.field1135 - var11.age;
						int var7 = (int)(var5 / 3600000L);
						int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
						int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERCOUNT) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPRICE) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERITEM) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)TileItem.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "35"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (WorldMapData_0.loadInterface(var0)) {
			MusicPatchNode.updateInterface(UserComparator5.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}

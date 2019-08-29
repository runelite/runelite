import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
	WorldMapData_0() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1629688583"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field260.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			super.groupId = var1.method5602();
			super.fileId = var1.method5602();
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "120"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field145 = new byte[super.planes][64][64];
		super.field156 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field251.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY) {
				for (int var5 = 0; var5 < 64; ++var5) {
					for (int var6 = 0; var6 < 64; ++var6) {
						this.readTile(var5, var6, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_0)) {
			return false;
		} else {
			WorldMapData_0 var2 = (WorldMapData_0)var1;
			return var2.regionX == super.regionX && var2.regionY == super.regionY;
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IS)Liq;",
		garbageValue = "-23193"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Liu;",
		garbageValue = "-1815953126"
	)
	@Export("ItemDefinition_get")
	public static ItemDefinition ItemDefinition_get(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class65.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!UrlRequester.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = VarcInt.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2096168309"
	)
	public static void method177() {
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-503004443"
	)
	@Export("getHighestVisiblePlane")
	static final int getHighestVisiblePlane() {
		if (GrandExchangeOffer.clientPreferences.roofsHidden) {
			return ItemContainer.plane;
		} else {
			int var0 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(WallDecoration.cameraX, UserComparator7.cameraZ, ItemContainer.plane);
			return var0 - Coord.cameraY < 800 && (Tiles.Tiles_renderFlags[ItemContainer.plane][WallDecoration.cameraX >> 7][UserComparator7.cameraZ >> 7] & 4) != 0 ? ItemContainer.plane : 3;
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-28266"
	)
	static final void method176() {
		int var0 = MilliClock.menuX;
		int var1 = class96.menuY;
		int var2 = World.menuWidth;
		int var3 = class1.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		class43.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			int var8 = var1 + (Client.menuOptionsCount - 1 - var7) * 15 + 31;
			int var9 = 16777215;
			if (var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			Font var10 = class43.fontBold12;
			String var11;
			if (var7 < 0) {
				var11 = "";
			} else if (Client.menuTargets[var7].length() > 0) {
				var11 = Client.menuActions[var7] + " " + Client.menuTargets[var7];
			} else {
				var11 = Client.menuActions[var7];
			}

			var10.draw(var11, var0 + 3, var8, var9, 0);
		}

		FriendsList.method5102(MilliClock.menuX, class96.menuY, World.menuWidth, class1.menuHeight);
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
		garbageValue = "400023400"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		NetCache.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}
}

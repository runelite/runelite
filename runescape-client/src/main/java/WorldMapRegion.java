import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfe;"
	)
	@Export("WorldMapRegion_cachedSprites")
	public static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1375036887
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1046641901
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ll;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("a")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1010803547
	)
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -401497597
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("o")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("v")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("k")
	@Export("fonts")
	final HashMap fonts;

	static {
		WorldMapRegion_cachedSprites = new DemotingHashTable(37748736, 256);
	}

	WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
		this.regionX = var1;
		this.regionY = var2;
		this.worldMapData1List = new LinkedList();
		this.icon0List = new LinkedList();
		this.iconMap = new HashMap();
		this.backgroundColor = var3 | -16777216;
		this.fonts = var4;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-29"
	)
	void method417(int var1, int var2, int var3) {
		Sprite var4 = WorldMapArea.method381(this.regionX, this.regionY, this.pixelsPerTile);
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.drawScaledWorldmap(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ll;Ljava/util/List;B)V",
		garbageValue = "14"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
		garbageValue = "-203983545"
	)
	@Export("initWorldMapData1")
	void initWorldMapData1(HashSet var1, List var2) {
		this.iconMap.clear();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			WorldMapData_1 var4 = (WorldMapData_1)var3.next();
			if (var4.getRegionX() == this.regionX && var4.getRegionY() == this.regionY) {
				this.worldMapData1List.add(var4);
			}
		}

		this.addAllToIconList(var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIILh;I)V",
		garbageValue = "-860745153"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label51:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							WorldMapDecoration var12 = var10[var11];
							ObjectDefinition var13 = Coord.getObjectDefinition(var12.objectDefinitionId);
							if (FontName.method5377(var13)) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label51;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lig;IIILh;I)V",
		garbageValue = "-992347084"
	)
	@Export("getIcon")
	void getIcon(ObjectDefinition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 4096, var4 + this.worldMapData_0.regionYLow * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.minPlane, var8.regionXLow * 4096 + var3 + var8.getChunkXLow() * 8, var4 + var8.regionYLow * 64 + var8.getChunkYLow() * 8);
		}

		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			WorldMapElement var9 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		this.iconMap.put(new Coord(0, var3, var4), var10);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-128030675"
	)
	@Export("initWorldMapIcon1s")
	void initWorldMapIcon1s() {
		Iterator var1 = this.iconMap.values().iterator();

		while (var1.hasNext()) {
			AbstractWorldMapIcon var2 = (AbstractWorldMapIcon)var1.next();
			if (var2 instanceof WorldMapIcon_1) {
				((WorldMapIcon_1)var2).init();
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/util/List;I)V",
		garbageValue = "1280170698"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method445(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "29290"
	)
	void method424() {
		if (this.worldMapData_0 != null) {
			this.worldMapData_0.reset();
		} else {
			Iterator var1 = this.worldMapData1List.iterator();

			while (var1.hasNext()) {
				WorldMapData_1 var2 = (WorldMapData_1)var1.next();
				var2.reset();
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;B)Z",
		garbageValue = "8"
	)
	@Export("loadGeography")
	boolean loadGeography(AbstractArchive var1) {
		this.iconMap.clear();
		if (this.worldMapData_0 != null) {
			this.worldMapData_0.loadGeography(var1);
			if (this.worldMapData_0.isFullyLoaded()) {
				this.getIconsForTiles(0, 0, 64, 64, this.worldMapData_0);
				return true;
			} else {
				return false;
			}
		} else {
			boolean var2 = true;

			Iterator var3;
			WorldMapData_1 var4;
			for (var3 = this.worldMapData1List.iterator(); var3.hasNext(); var2 &= var4.isFullyLoaded()) {
				var4 = (WorldMapData_1)var3.next();
				var4.loadGeography(var1);
			}

			if (var2) {
				var3 = this.worldMapData1List.iterator();

				while (var3.hasNext()) {
					var4 = (WorldMapData_1)var3.next();
					this.getIconsForTiles(var4.getChunkX() * 8, var4.getChunkY() * 8, 8, 8, var4);
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILac;[Lli;Lhz;Lhz;I)V",
		garbageValue = "907616954"
	)
	@Export("drawTile")
	void drawTile(int var1, class40 var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			if (WorldMapArea.method381(this.regionX, this.regionY, var1) == null) {
				boolean var6 = true;
				var6 &= this.loadGeography(var4);
				int var8;
				if (this.worldMapData_0 != null) {
					var8 = this.worldMapData_0.groupId;
				} else {
					var8 = ((AbstractWorldMapData)this.worldMapData1List.getFirst()).groupId;
				}

				var6 &= var5.tryLoadGroup(var8);
				if (var6) {
					byte[] var7 = var5.takeFileFlat(var8);
					WorldMapSprite var9 = WorldMapDecoration.method325(var7);
					Sprite var10 = new Sprite(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var10.setRaster();
					if (this.worldMapData_0 != null) {
						this.method475(var2, var3, var9);
					} else {
						this.method430(var2, var3, var9);
					}

					WorldMapData_0.method169(var10, this.regionX, this.regionY, this.pixelsPerTile);
					this.method424();
				}
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIILjava/util/HashSet;B)V",
		garbageValue = "91"
	)
	void method427(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "-575920930"
	)
	@Export("flashElements")
	void flashElements(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var6);
					this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method436(var1, var2, var3);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lac;[Lli;Lav;B)V",
		garbageValue = "121"
	)
	void method475(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method435(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method457(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lac;[Lli;Lav;I)V",
		garbageValue = "11820226"
	)
	void method430(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method435(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method457(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IILh;Lac;[Lli;I)V",
		garbageValue = "-2005670242"
	)
	void method457(int var1, int var2, AbstractWorldMapData var3, class40 var4, IndexedSprite[] var5) {
		this.method451(var1, var2, var3);
		this.method434(var1, var2, var3, var5);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IILh;Lac;Lav;I)V",
		garbageValue = "-1238267730"
	)
	@Export("drawTileGround")
	void drawTileGround(int var1, int var2, AbstractWorldMapData var3, class40 var4, WorldMapSprite var5) {
		int var6 = var3.floorUnderlayIds[0][var1][var2] - 1;
		int var7 = var3.floorOverlayIds[0][var1][var2] - 1;
		if (var6 == -1 && var7 == -1) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.backgroundColor);
		}

		int var8 = 16711935;
		if (var7 != -1) {
			var8 = Language.method3627(var7, this.backgroundColor);
		}

		if (var7 > -1 && var3.field150[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			int var9 = this.method433(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method736(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field150[0][var1][var2], var3.field149[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IILh;Lac;I)V",
		garbageValue = "-1735440961"
	)
	void method435(int var1, int var2, AbstractWorldMapData var3, class40 var4) {
		for (int var5 = 1; var5 < var3.planes; ++var5) {
			int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
			if (var6 > -1) {
				int var7 = Language.method3627(var6, this.backgroundColor);
				if (var3.field150[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method736(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field150[var5][var1][var2], var3.field149[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IILh;Lav;I)I",
		garbageValue = "-1005034743"
	)
	int method433(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(IILh;[Lli;I)V",
		garbageValue = "843307323"
	)
	void method434(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					int var11 = var9.decoration;
					boolean var10 = var11 >= WorldMapDecorationType.field2725.id && var11 <= WorldMapDecorationType.field2726.id;
					if (!var10) {
						int var13 = var9.decoration;
						boolean var12 = var13 == WorldMapDecorationType.field2727.id;
						if (!var12) {
							continue;
						}
					}

					ObjectDefinition var14 = Coord.getObjectDefinition(var9.objectDefinitionId);
					if (var14.mapSceneId != -1) {
						if (var14.mapSceneId != 46 && var14.mapSceneId != 52) {
							var4[var14.mapSceneId].method6124(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
						} else {
							var4[var14.mapSceneId].method6124(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IILh;I)V",
		garbageValue = "-2096863892"
	)
	void method451(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					if (Messages.method2240(var8.decoration)) {
						ObjectDefinition var9 = Coord.getObjectDefinition(var8.objectDefinitionId);
						int var10 = var9.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field2719.id) {
							this.method449(var1, var2, var8.rotation, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field2710.id) {
							this.method449(var1, var2, var8.rotation, -3355444);
							this.method449(var1, var2, var8.rotation + 1, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field2708.id) {
							if (var8.rotation == 0) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 1) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 2) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}

							if (var8.rotation == 3) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}
						}

						if (var8.decoration == WorldMapDecorationType.field2707.id) {
							int var11 = var8.rotation % 2;
							int var12;
							if (var11 == 0) {
								for (var12 = 0; var12 < this.pixelsPerTile; ++var12) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var12 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var12, 1, var10);
								}
							} else {
								for (var12 = 0; var12 < this.pixelsPerTile; ++var12) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var12 + this.pixelsPerTile * var1, var12 + this.pixelsPerTile * (63 - var2), 1, var10);
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1722827665"
	)
	@Export("drawNonLinkMapIcons")
	void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
		float var5 = (float)var4 / 64.0F;
		float var6 = var5 / 2.0F;
		Iterator var7 = this.iconMap.entrySet().iterator();

		while (var7.hasNext()) {
			Entry var8 = (Entry)var7.next();
			Coord var9 = (Coord)var8.getKey();
			int var10 = (int)((float)var1 + (float)var9.x * var5 - var6);
			int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.y - var6);
			AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
			if (var12 != null && var12.hasValidElement()) {
				var12.screenX = var10;
				var12.screenY = var11;
				WorldMapElement var13 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method439(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "-750214661"
	)
	void method436(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Lit;IIIII)V",
		garbageValue = "1151123929"
	)
	@Export("drawBackgroundCircle")
	void drawBackgroundCircle(WorldMapElement var1, int var2, int var3, int var4, int var5) {
		Sprite var6 = var1.getSpriteBool(false);
		if (var6 != null) {
			var6.drawTransBgAt(var2 - var6.subWidth / 2, var3 - var6.subHeight / 2);
			if (var4 % var5 < var5 / 2) {
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 15, 16776960, 128);
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 7, 16777215, 256);
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Lao;IIFB)V",
		garbageValue = "22"
	)
	void method439(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var1.getElement());
		this.method440(var5, var2, var3);
		this.method507(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lit;III)V",
		garbageValue = "-1270354763"
	)
	void method440(WorldMapElement var1, int var2, int var3) {
		Sprite var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method443(var4, var1.horizontalAlignment);
			int var6 = this.method444(var4, var1.verticalAlignment);
			var4.drawTransBgAt(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Lao;Lit;IIFB)V",
		garbageValue = "55"
	)
	void method507(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method183(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field3195, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1968496200"
	)
	@Export("drawMapLinks")
	void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
		float var5 = (float)var4 / 64.0F;
		Iterator var6 = this.icon0List.iterator();

		while (var6.hasNext()) {
			AbstractWorldMapIcon var7 = (AbstractWorldMapIcon)var6.next();
			if (var7.hasValidElement()) {
				int var8 = var7.coord2.x % 64;
				int var9 = var7.coord2.y % 64;
				var7.screenX = (int)((float)var8 * var5 + (float)var1);
				var7.screenY = (int)(var5 * (float)(63 - var9) + (float)var2);
				if (!var3.contains(var7.getElement())) {
					this.method439(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Lls;Liz;B)I",
		garbageValue = "43"
	)
	int method443(Sprite var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 2:
			return -var1.subWidth / 2;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Lls;Lia;I)I",
		garbageValue = "1222469421"
	)
	int method444(Sprite var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 1:
			return -var1.subHeight / 2;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(II)Law;",
		garbageValue = "-1275303691"
	)
	WorldMapLabel method445(int var1) {
		WorldMapElement var2 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(Lit;B)Law;",
		garbageValue = "87"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			WorldMapLabelSize var2 = WorldMapLabelSize.method182(var1.textSize);
			if (var2 == null) {
				return null;
			} else {
				Font var3 = (Font)this.fonts.get(var2);
				if (var3 == null) {
					return null;
				} else {
					int var4 = var3.lineCount(var1.name, 1000000);
					String[] var5 = new String[var4];
					var3.breakLines(var1.name, (int[])null, var5);
					int var6 = var5.length * var3.ascent / 2;
					int var7 = 0;
					String[] var8 = var5;

					for (int var9 = 0; var9 < var8.length; ++var9) {
						String var10 = var8[var9];
						int var11 = var3.stringWidth(var10);
						if (var11 > var7) {
							var7 = var11;
						}
					}

					return new WorldMapLabel(var1.name, var7, var6, var2);
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(IIIIII)Ljava/util/List;",
		garbageValue = "-1417348490"
	)
	List method498(int var1, int var2, int var3, int var4, int var5) {
		LinkedList var6 = new LinkedList();
		if (var4 >= var1 && var5 >= var2) {
			if (var4 < var3 + var1 && var5 < var3 + var2) {
				Iterator var7 = this.iconMap.values().iterator();

				AbstractWorldMapIcon var8;
				while (var7.hasNext()) {
					var8 = (AbstractWorldMapIcon)var7.next();
					if (var8.hasValidElement() && var8.fitsScreen(var4, var5)) {
						var6.add(var8);
					}
				}

				var7 = this.icon0List.iterator();

				while (var7.hasNext()) {
					var8 = (AbstractWorldMapIcon)var7.next();
					if (var8.hasValidElement() && var8.fitsScreen(var4, var5)) {
						var6.add(var8);
					}
				}

				return var6;
			} else {
				return var6;
			}
		} else {
			return var6;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)Ljava/util/List;",
		garbageValue = "-989883641"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "899248185"
	)
	void method449(int var1, int var2, int var3, int var4) {
		var3 %= 4;
		if (var3 == 0) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 1) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 2) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 3) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIS)V",
		garbageValue = "-3328"
	)
	public static void method504(String var0, String var1, int var2, int var3) throws IOException {
		JagexCache.idxCount = var3;
		VertexNormal.cacheGamebuild = var2;

		try {
			StudioGame.field3092 = System.getProperty("os.name");
		} catch (Exception var14) {
			StudioGame.field3092 = "Unknown";
		}

		class81.field1129 = StudioGame.field3092.toLowerCase();

		try {
			ReflectionCheck.userHomeDirectory = System.getProperty("user.home");
			if (ReflectionCheck.userHomeDirectory != null) {
				ReflectionCheck.userHomeDirectory = ReflectionCheck.userHomeDirectory + "/";
			}
		} catch (Exception var13) {
		}

		try {
			if (class81.field1129.startsWith("win")) {
				if (ReflectionCheck.userHomeDirectory == null) {
					ReflectionCheck.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (ReflectionCheck.userHomeDirectory == null) {
				ReflectionCheck.userHomeDirectory = System.getenv("HOME");
			}

			if (ReflectionCheck.userHomeDirectory != null) {
				ReflectionCheck.userHomeDirectory = ReflectionCheck.userHomeDirectory + "/";
			}
		} catch (Exception var12) {
		}

		if (ReflectionCheck.userHomeDirectory == null) {
			ReflectionCheck.userHomeDirectory = "~/";
		}

		JagexCache.field2024 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", ReflectionCheck.userHomeDirectory, "/tmp/", ""};
		WorldMapSprite.field219 = new String[]{".jagex_cache_" + VertexNormal.cacheGamebuild, ".file_store_" + VertexNormal.cacheGamebuild};
		int var9 = 0;

		int var7;
		File var8;
		label132:
		while (var9 < 4) {
			JagexCache.cacheDir = class81.method2064(var0, var1, var9);
			if (!JagexCache.cacheDir.exists()) {
				JagexCache.cacheDir.mkdirs();
			}

			File[] var5 = JagexCache.cacheDir.listFiles();
			if (var5 == null) {
				break;
			}

			File[] var6 = var5;
			var7 = 0;

			while (true) {
				if (var7 >= var6.length) {
					break label132;
				}

				var8 = var6[var7];
				if (!class173.method3561(var8, false)) {
					++var9;
					break;
				}

				++var7;
			}
		}

		File var4 = JagexCache.cacheDir;
		GrandExchangeOfferNameComparator.FileSystem_cacheDir = var4;
		if (!GrandExchangeOfferNameComparator.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;

			try {
				File var16 = new File(ReflectionCheck.userHomeDirectory, "random.dat");
				if (var16.exists()) {
					JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var16, "rw", 25L), 24, 0);
				} else {
					label112:
					for (int var10 = 0; var10 < WorldMapSprite.field219.length; ++var10) {
						for (var7 = 0; var7 < JagexCache.field2024.length; ++var7) {
							var8 = new File(JagexCache.field2024[var7] + WorldMapSprite.field219[var10] + File.separatorChar + "random.dat");
							if (var8.exists()) {
								JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var8, "rw", 25L), 24, 0);
								break label112;
							}
						}
					}
				}

				if (JagexCache.JagexCache_randomDat == null) {
					RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
					var7 = var17.read();
					var17.seek(0L);
					var17.write(var7);
					var17.seek(0L);
					var17.close();
					JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var16, "rw", 25L), 24, 0);
				}
			} catch (IOException var15) {
			}

			JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(Message.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(Message.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			AttackOption.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

			for (int var11 = 0; var11 < JagexCache.idxCount; ++var11) {
				AttackOption.JagexCache_idxFiles[var11] = new BufferedFile(new AccessFile(Message.getFile("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "5"
	)
	static final void method446() {
		Tiles.method1143("Your friend list is full. Max of 200 for free users, and 400 for members");
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "65535"
	)
	static final int method536(int var0, int var1) {
		int var2 = var1 * 57 + var0;
		var2 ^= var2 << 13;
		int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-106"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			class14.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			Language.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			ClientPacket.archive0 = class48.newArchive(0, false, true, true);
			ItemDefinition.archive1 = class48.newArchive(1, false, true, true);
			class2.archive2 = class48.newArchive(2, true, false, true);
			WorldMapData_1.archive3 = class48.newArchive(3, false, true, true);
			FloorDecoration.archive4 = class48.newArchive(4, false, true, true);
			AbstractWorldMapData.archive5 = class48.newArchive(5, true, true, true);
			GrandExchangeOfferWorldComparator.archive6 = class48.newArchive(6, true, true, true);
			MouseRecorder.archive7 = class48.newArchive(7, false, true, true);
			class3.archive8 = class48.newArchive(8, false, true, true);
			WorldMapManager.archive9 = class48.newArchive(9, false, true, true);
			ServerBuild.archive10 = class48.newArchive(10, false, true, true);
			class48.archive11 = class48.newArchive(11, false, true, true);
			SoundSystem.archive12 = class48.newArchive(12, false, true, true);
			WorldMapSection1.archive13 = class48.newArchive(13, true, false, true);
			class117.archive14 = class48.newArchive(14, false, true, true);
			GrandExchangeOfferTotalQuantityComparator.archive15 = class48.newArchive(15, false, true, true);
			GrandExchangeOfferNameComparator.archive17 = class48.newArchive(17, true, true, true);
			AbstractWorldMapData.archive18 = class48.newArchive(18, false, true, true);
			MusicPatchNode2.archive19 = class48.newArchive(19, false, true, true);
			UserComparator9.archive20 = class48.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var29 = 0;
			var0 = var29 + ClientPacket.archive0.percentage() * 4 / 100;
			var0 += ItemDefinition.archive1.percentage() * 4 / 100;
			var0 += class2.archive2.percentage() * 2 / 100;
			var0 += WorldMapData_1.archive3.percentage() * 2 / 100;
			var0 += FloorDecoration.archive4.percentage() * 6 / 100;
			var0 += AbstractWorldMapData.archive5.percentage() * 4 / 100;
			var0 += GrandExchangeOfferWorldComparator.archive6.percentage() * 2 / 100;
			var0 += MouseRecorder.archive7.percentage() * 56 / 100;
			var0 += class3.archive8.percentage() * 2 / 100;
			var0 += WorldMapManager.archive9.percentage() * 2 / 100;
			var0 += ServerBuild.archive10.percentage() * 2 / 100;
			var0 += class48.archive11.percentage() * 2 / 100;
			var0 += SoundSystem.archive12.percentage() * 2 / 100;
			var0 += WorldMapSection1.archive13.percentage() * 2 / 100;
			var0 += class117.archive14.percentage() * 2 / 100;
			var0 += GrandExchangeOfferTotalQuantityComparator.archive15.percentage() * 2 / 100;
			var0 += MusicPatchNode2.archive19.percentage() / 100;
			var0 += AbstractWorldMapData.archive18.percentage() / 100;
			var0 += UserComparator9.archive20.percentage() / 100;
			var0 += GrandExchangeOfferNameComparator.archive17.method4246() && GrandExchangeOfferNameComparator.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				BufferedSource.method5925(ClientPacket.archive0, "Animations");
				BufferedSource.method5925(ItemDefinition.archive1, "Skeletons");
				BufferedSource.method5925(FloorDecoration.archive4, "Sound FX");
				BufferedSource.method5925(AbstractWorldMapData.archive5, "Maps");
				BufferedSource.method5925(GrandExchangeOfferWorldComparator.archive6, "Music Tracks");
				BufferedSource.method5925(MouseRecorder.archive7, "Models");
				BufferedSource.method5925(class3.archive8, "Sprites");
				BufferedSource.method5925(class48.archive11, "Music Jingles");
				BufferedSource.method5925(class117.archive14, "Music Samples");
				BufferedSource.method5925(GrandExchangeOfferTotalQuantityComparator.archive15, "Music Patches");
				BufferedSource.method5925(MusicPatchNode2.archive19, "World Map");
				BufferedSource.method5925(AbstractWorldMapData.archive18, "World Map Geography");
				BufferedSource.method5925(UserComparator9.archive20, "World Map Ground");
				SecureRandomCallable.spriteIds = new GraphicsDefaults();
				SecureRandomCallable.spriteIds.decode(GrandExchangeOfferNameComparator.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else {
			Archive var2;
			Archive var3;
			if (Client.titleLoadingStage == 45) {
				boolean var27 = !Client.isLowDetail;
				DirectByteArrayCopier.field2490 = 22050;
				SoundCache.PcmPlayer_stereo = var27;
				NPC.field1103 = 2;
				MidiPcmStream var26 = new MidiPcmStream();
				var26.method3765(9, 128);
				UserComparator6.pcmPlayer0 = WorldMapEvent.method763(GameShell.taskHandler, 0, 22050);
				UserComparator6.pcmPlayer0.setStream(var26);
				var2 = GrandExchangeOfferTotalQuantityComparator.archive15;
				var3 = class117.archive14;
				Archive var4 = FloorDecoration.archive4;
				class197.musicPatchesArchive = var2;
				class197.musicSamplesArchive = var3;
				class197.soundEffectsArchive = var4;
				GZipDecompressor.midiPcmStream = var26;
				NetSocket.pcmPlayer1 = WorldMapEvent.method763(GameShell.taskHandler, 1, 2048);
				Tiles.pcmStreamMixer = new PcmStreamMixer();
				NetSocket.pcmPlayer1.setStream(Tiles.pcmStreamMixer);
				ClientPreferences.decimator = new Decimator(22050, DirectByteArrayCopier.field2490 * -168449264);
				Login.Login_loadingText = "Prepared sound engine";
				Login.Login_loadingPercent = 35;
				Client.titleLoadingStage = 50;
				class65.WorldMapElement_fonts = new Fonts(class3.archive8, WorldMapSection1.archive13);
			} else {
				int var17;
				if (Client.titleLoadingStage == 50) {
					FontName[] var31 = new FontName[]{FontName.FontName_plain11, FontName.FontName_verdana13, FontName.FontName_verdana15, FontName.FontName_verdana11, FontName.FontName_plain12, FontName.FontName_bold12};
					var17 = var31.length;
					Fonts var24 = class65.WorldMapElement_fonts;
					FontName[] var23 = new FontName[]{FontName.FontName_plain11, FontName.FontName_verdana13, FontName.FontName_verdana15, FontName.FontName_verdana11, FontName.FontName_plain12, FontName.FontName_bold12};
					Client.fontsMap = var24.createMap(var23);
					if (Client.fontsMap.size() < var17) {
						Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var17 + "%";
						Login.Login_loadingPercent = 40;
					} else {
						class3.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
						ScriptFrame.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
						GrandExchangeOffer.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
						class42.platformInfo = Client.platformInfoProvider.get();
						Login.Login_loadingText = "Loaded fonts";
						Login.Login_loadingPercent = 40;
						Client.titleLoadingStage = 60;
					}
				} else {
					int var18;
					Archive var25;
					if (Client.titleLoadingStage == 60) {
						var25 = ServerBuild.archive10;
						var2 = class3.archive8;
						var18 = 0;
						if (var25.tryLoadFileByNames("title.jpg", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("logo", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("logo_deadman_mode", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("logo_seasonal_mode", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("titlebox", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("titlebutton", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("runes", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("title_mute", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("options_radio_buttons,0", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("options_radio_buttons,2", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("options_radio_buttons,4", "")) {
							++var18;
						}

						if (var2.tryLoadFileByNames("options_radio_buttons,6", "")) {
							++var18;
						}

						var2.tryLoadFileByNames("sl_back", "");
						var2.tryLoadFileByNames("sl_flags", "");
						var2.tryLoadFileByNames("sl_arrows", "");
						var2.tryLoadFileByNames("sl_stars", "");
						var2.tryLoadFileByNames("sl_button", "");
						byte var33 = 12;
						if (var18 < var33) {
							Login.Login_loadingText = "Loading title screen - " + var18 * 100 / var33 + "%";
							Login.Login_loadingPercent = 50;
						} else {
							Login.Login_loadingText = "Loaded title screen";
							Login.Login_loadingPercent = 50;
							class195.updateGameState(5);
							Client.titleLoadingStage = 70;
						}
					} else if (Client.titleLoadingStage == 70) {
						if (!class2.archive2.isFullyLoaded()) {
							Login.Login_loadingText = "Loading config - " + class2.archive2.loadPercent() + "%";
							Login.Login_loadingPercent = 60;
						} else {
							FillMode.method6117(class2.archive2);
							WorldMapDecorationType.method4079(class2.archive2);
							Archive var30 = class2.archive2;
							var25 = MouseRecorder.archive7;
							KitDefinition.KitDefinition_archive = var30;
							KitDefinition.KitDefinition_modelsArchive = var25;
							GrandExchangeOfferUnitPriceComparator.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
							var2 = class2.archive2;
							var3 = MouseRecorder.archive7;
							boolean var32 = Client.isLowDetail;
							ObjectDefinition.ObjectDefinition_archive = var2;
							ObjectDefinition.ObjectDefinition_modelsArchive = var3;
							ObjectDefinition.ObjectDefinition_isLowDetail = var32;
							Archive var34 = class2.archive2;
							Archive var22 = MouseRecorder.archive7;
							NPCDefinition.NpcDefinition_archive = var34;
							NPCDefinition.NpcDefinition_modelArchive = var22;
							Messages.method2227(class2.archive2);
							class65.method1232(class2.archive2, MouseRecorder.archive7, Client.isMembersWorld, class3.fontPlain11);
							Archive var28 = class2.archive2;
							Archive var8 = ClientPacket.archive0;
							Archive var9 = ItemDefinition.archive1;
							SequenceDefinition.SequenceDefinition_archive = var28;
							SequenceDefinition.SequenceDefinition_animationsArchive = var8;
							SequenceDefinition.SequenceDefinition_skeletonsArchive = var9;
							ClientPacket.method3570(class2.archive2, MouseRecorder.archive7);
							Archive var10 = class2.archive2;
							VarbitDefinition.VarbitDefinition_archive = var10;
							WorldMapID.method545(class2.archive2);
							DevicePcmPlayerProvider.method842(WorldMapData_1.archive3, MouseRecorder.archive7, class3.archive8, WorldMapSection1.archive13);
							UserComparator10.method3335(class2.archive2);
							DirectByteArrayCopier.method3940(class2.archive2);
							Archive var11 = class2.archive2;
							VarcInt.VarcInt_archive = var11;
							Archive var12 = class2.archive2;
							ParamDefinition.ParamDefinition_archive = var12;
							MilliClock.varcs = new Varcs();
							Archive var13 = class2.archive2;
							Archive var14 = class3.archive8;
							Archive var15 = WorldMapSection1.archive13;
							HitSplatDefinition.HitSplatDefinition_archive = var13;
							HitSplatDefinition.field3290 = var14;
							class206.HitSplatDefinition_fontsArchive = var15;
							UserComparator10.method3336(class2.archive2, class3.archive8);
							BuddyRankComparator.method3363(class2.archive2, class3.archive8);
							Login.Login_loadingText = "Loaded config";
							Login.Login_loadingPercent = 60;
							Client.titleLoadingStage = 80;
						}
					} else if (Client.titleLoadingStage == 80) {
						var0 = 0;
						if (GrandExchangeOfferTotalQuantityComparator.compass == null) {
							GrandExchangeOfferTotalQuantityComparator.compass = FloorUnderlayDefinition.SpriteBuffer_getSprite(class3.archive8, SecureRandomCallable.spriteIds.compass, 0);
						} else {
							++var0;
						}

						if (class40.redHintArrowSprite == null) {
							class40.redHintArrowSprite = FloorUnderlayDefinition.SpriteBuffer_getSprite(class3.archive8, SecureRandomCallable.spriteIds.field3803, 0);
						} else {
							++var0;
						}

						IndexedSprite[] var1;
						int var6;
						IndexedSprite var7;
						IndexedSprite[] var21;
						if (class162.mapSceneSprites == null) {
							var2 = class3.archive8;
							var18 = SecureRandomCallable.spriteIds.mapScenes;
							if (!HitSplatDefinition.method4586(var2, var18, 0)) {
								var1 = null;
							} else {
								var21 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

								for (var6 = 0; var6 < class325.SpriteBuffer_spriteCount; ++var6) {
									var7 = var21[var6] = new IndexedSprite();
									var7.width = class325.SpriteBuffer_spriteWidth;
									var7.height = class325.SpriteBuffer_spriteHeight;
									var7.xOffset = class325.SpriteBuffer_xOffsets[var6];
									var7.yOffset = class325.SpriteBuffer_yOffsets[var6];
									var7.subWidth = UserComparator1.SpriteBuffer_spriteWidths[var6];
									var7.subHeight = class325.SpriteBuffer_spriteHeights[var6];
									var7.palette = class268.SpriteBuffer_spritePalette;
									var7.pixels = class290.SpriteBuffer_pixels[var6];
								}

								Message.method1223();
								var1 = var21;
							}

							class162.mapSceneSprites = var1;
						} else {
							++var0;
						}

						if (class222.headIconPkSprites == null) {
							class222.headIconPkSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.headIconsPk, 0);
						} else {
							++var0;
						}

						if (GraphicsObject.headIconPrayerSprites == null) {
							GraphicsObject.headIconPrayerSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.field3798, 0);
						} else {
							++var0;
						}

						if (WorldMapData_0.headIconHintSprites == null) {
							WorldMapData_0.headIconHintSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.field3807, 0);
						} else {
							++var0;
						}

						if (Varps.mapMarkerSprites == null) {
							Varps.mapMarkerSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.field3804, 0);
						} else {
							++var0;
						}

						if (ObjectDefinition.crossSprites == null) {
							ObjectDefinition.crossSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.field3805, 0);
						} else {
							++var0;
						}

						if (WorldMapLabel.mapDotSprites == null) {
							WorldMapLabel.mapDotSprites = GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(class3.archive8, SecureRandomCallable.spriteIds.field3806, 0);
						} else {
							++var0;
						}

						if (class60.scrollBarSprites == null) {
							var2 = class3.archive8;
							var18 = SecureRandomCallable.spriteIds.field3799;
							if (!HitSplatDefinition.method4586(var2, var18, 0)) {
								var1 = null;
							} else {
								var21 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

								for (var6 = 0; var6 < class325.SpriteBuffer_spriteCount; ++var6) {
									var7 = var21[var6] = new IndexedSprite();
									var7.width = class325.SpriteBuffer_spriteWidth;
									var7.height = class325.SpriteBuffer_spriteHeight;
									var7.xOffset = class325.SpriteBuffer_xOffsets[var6];
									var7.yOffset = class325.SpriteBuffer_yOffsets[var6];
									var7.subWidth = UserComparator1.SpriteBuffer_spriteWidths[var6];
									var7.subHeight = class325.SpriteBuffer_spriteHeights[var6];
									var7.palette = class268.SpriteBuffer_spritePalette;
									var7.pixels = class290.SpriteBuffer_pixels[var6];
								}

								Message.method1223();
								var1 = var21;
							}

							class60.scrollBarSprites = var1;
						} else {
							++var0;
						}

						if (WorldMapEvent.modIconSprites == null) {
							var2 = class3.archive8;
							var18 = SecureRandomCallable.spriteIds.field3808;
							if (!HitSplatDefinition.method4586(var2, var18, 0)) {
								var1 = null;
							} else {
								var21 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

								for (var6 = 0; var6 < class325.SpriteBuffer_spriteCount; ++var6) {
									var7 = var21[var6] = new IndexedSprite();
									var7.width = class325.SpriteBuffer_spriteWidth;
									var7.height = class325.SpriteBuffer_spriteHeight;
									var7.xOffset = class325.SpriteBuffer_xOffsets[var6];
									var7.yOffset = class325.SpriteBuffer_yOffsets[var6];
									var7.subWidth = UserComparator1.SpriteBuffer_spriteWidths[var6];
									var7.subHeight = class325.SpriteBuffer_spriteHeights[var6];
									var7.palette = class268.SpriteBuffer_spritePalette;
									var7.pixels = class290.SpriteBuffer_pixels[var6];
								}

								Message.method1223();
								var1 = var21;
							}

							WorldMapEvent.modIconSprites = var1;
						} else {
							++var0;
						}

						if (var0 < 11) {
							Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
							Login.Login_loadingPercent = 70;
						} else {
							AbstractFont.AbstractFont_modIconSprites = WorldMapEvent.modIconSprites;
							class40.redHintArrowSprite.normalize();
							var17 = (int)(Math.random() * 21.0D) - 10;
							int var20 = (int)(Math.random() * 21.0D) - 10;
							var18 = (int)(Math.random() * 21.0D) - 10;
							int var19 = (int)(Math.random() * 41.0D) - 20;
							class162.mapSceneSprites[0].shiftColors(var19 + var17, var19 + var20, var18 + var19);
							Login.Login_loadingText = "Loaded sprites";
							Login.Login_loadingPercent = 70;
							Client.titleLoadingStage = 90;
						}
					} else if (Client.titleLoadingStage == 90) {
						if (!WorldMapManager.archive9.isFullyLoaded()) {
							Login.Login_loadingText = "Loading textures - " + "0%";
							Login.Login_loadingPercent = 90;
						} else {
							class14.textureProvider = new TextureProvider(WorldMapManager.archive9, class3.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
							Rasterizer3D.Rasterizer3D_setTextureLoader(class14.textureProvider);
							Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
							Client.titleLoadingStage = 100;
						}
					} else if (Client.titleLoadingStage == 100) {
						var0 = class14.textureProvider.getLoadedPercentage();
						if (var0 < 100) {
							Login.Login_loadingText = "Loading textures - " + var0 + "%";
							Login.Login_loadingPercent = 90;
						} else {
							Login.Login_loadingText = "Loaded textures";
							Login.Login_loadingPercent = 90;
							Client.titleLoadingStage = 110;
						}
					} else if (Client.titleLoadingStage == 110) {
						class173.mouseRecorder = new MouseRecorder();
						GameShell.taskHandler.newThreadTask(class173.mouseRecorder, 10);
						Login.Login_loadingText = "Loaded input handler";
						Login.Login_loadingPercent = 92;
						Client.titleLoadingStage = 120;
					} else if (Client.titleLoadingStage == 120) {
						if (!ServerBuild.archive10.tryLoadFileByNames("huffman", "")) {
							Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
							Login.Login_loadingPercent = 94;
						} else {
							Huffman var16 = new Huffman(ServerBuild.archive10.takeFileByNames("huffman", ""));
							GameObject.method3296(var16);
							Login.Login_loadingText = "Loaded wordpack";
							Login.Login_loadingPercent = 94;
							Client.titleLoadingStage = 130;
						}
					} else if (Client.titleLoadingStage == 130) {
						if (!WorldMapData_1.archive3.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + WorldMapData_1.archive3.loadPercent() * 4 / 5 + "%";
							Login.Login_loadingPercent = 96;
						} else if (!SoundSystem.archive12.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (80 + SoundSystem.archive12.loadPercent() / 6) + "%";
							Login.Login_loadingPercent = 96;
						} else if (!WorldMapSection1.archive13.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (96 + WorldMapSection1.archive13.loadPercent() / 50) + "%";
							Login.Login_loadingPercent = 96;
						} else {
							Login.Login_loadingText = "Loaded interfaces";
							Login.Login_loadingPercent = 98;
							Client.titleLoadingStage = 140;
						}
					} else if (Client.titleLoadingStage == 140) {
						Login.Login_loadingPercent = 100;
						if (!MusicPatchNode2.archive19.tryLoadGroupByName(WorldMapCacheName.field291.name)) {
							Login.Login_loadingText = "Loading world map - " + MusicPatchNode2.archive19.groupLoadPercentByName(WorldMapCacheName.field291.name) / 10 + "%";
						} else {
							if (GrandExchangeEvent.worldMap == null) {
								GrandExchangeEvent.worldMap = new WorldMap();
								GrandExchangeEvent.worldMap.init(MusicPatchNode2.archive19, AbstractWorldMapData.archive18, UserComparator9.archive20, GrandExchangeOffer.fontBold12, Client.fontsMap, class162.mapSceneSprites);
							}

							Login.Login_loadingText = "Loaded world map";
							Client.titleLoadingStage = 150;
						}
					} else if (Client.titleLoadingStage == 150) {
						class195.updateGameState(10);
					}
				}
			}
		}
	}
}

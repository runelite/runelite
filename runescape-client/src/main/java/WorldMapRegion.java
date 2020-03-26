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

@ObfuscatedName("ao")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("ss")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfl;"
	)
	@Export("WorldMapRegion_cachedSprites")
	public static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1197836781
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1627893231
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ly;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("t")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 594891015
	)
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -411328267
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("p")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("n")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("u")
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "800782831"
	)
	void method519(int var1, int var2, int var3) {
		int var5 = this.regionX;
		int var6 = this.regionY;
		int var7 = this.pixelsPerTile;
		Sprite var4 = (Sprite)WorldMapRegion_cachedSprites.get(HorizontalAlignment.method4777(var5, var6, var7));
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.drawScaledWorldmap(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ly;Ljava/util/List;I)V",
		garbageValue = "1320723450"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
		garbageValue = "-1524913173"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIILab;S)V",
		garbageValue = "-7361"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label50:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							WorldMapDecoration var12 = var10[var11];
							ObjectDefinition var13 = WorldMapSection2.getObjectDefinition(var12.objectDefinitionId);
							if (Tiles.method1239(var13)) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label50;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljw;IIILab;I)V",
		garbageValue = "-332727967"
	)
	@Export("getIcon")
	void getIcon(ObjectDefinition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 64, var4 + this.worldMapData_0.regionYLow * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.minPlane, var3 + var8.regionXLow * 64 + var8.getChunkXLow() * 8, var8.regionYLow * 64 + var4 + var8.getChunkYLow() * 8);
		}

		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			WorldMapElement var9 = class25.WorldMapElement_get(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		this.iconMap.put(new Coord(0, var3, var4), var10);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "128"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/util/List;I)V",
		garbageValue = "-2024138363"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method548(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-949994571"
	)
	void method526() {
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Liy;I)Z",
		garbageValue = "155508897"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILah;[Lle;Liy;Liy;I)V",
		garbageValue = "828020907"
	)
	@Export("drawTile")
	void drawTile(int var1, class49 var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			int var7 = this.regionX;
			int var8 = this.regionY;
			Sprite var6 = (Sprite)WorldMapRegion_cachedSprites.get(HorizontalAlignment.method4777(var7, var8, var1));
			if (var6 == null) {
				boolean var9 = true;
				var9 &= this.loadGeography(var4);
				int var11;
				if (this.worldMapData_0 != null) {
					var11 = this.worldMapData_0.groupId;
				} else {
					var11 = ((AbstractWorldMapData)this.worldMapData1List.getFirst()).groupId;
				}

				var9 &= var5.tryLoadGroup(var11);
				if (var9) {
					byte[] var10 = var5.takeFileFlat(var11);
					WorldMapSprite var12;
					if (var10 == null) {
						var12 = new WorldMapSprite();
					} else {
						var12 = new WorldMapSprite(class200.convertJpgToSprite(var10).pixels);
					}

					Sprite var14 = new Sprite(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var14.setRaster();
					if (this.worldMapData_0 != null) {
						this.method531(var2, var3, var12);
					} else {
						this.method532(var2, var3, var12);
					}

					int var15 = this.regionX;
					int var16 = this.regionY;
					int var17 = this.pixelsPerTile;
					WorldMapRegion_cachedSprites.put(var14, HorizontalAlignment.method4777(var15, var16, var17), var14.pixels.length * 4);
					this.method526();
				}
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIILjava/util/HashSet;B)V",
		garbageValue = "-19"
	)
	void method529(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;IIB)V",
		garbageValue = "-1"
	)
	@Export("flashElements")
	void flashElements(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = class25.WorldMapElement_get(var6);
					this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method540(var1, var2, var3);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lah;[Lle;Lam;I)V",
		garbageValue = "-1199825986"
	)
	void method531(class49 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method535(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method533(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lah;[Lle;Lam;B)V",
		garbageValue = "-33"
	)
	void method532(class49 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method535(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method533(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IILab;Lah;[Lle;I)V",
		garbageValue = "642220126"
	)
	void method533(int var1, int var2, AbstractWorldMapData var3, class49 var4, IndexedSprite[] var5) {
		this.method527(var1, var2, var3);
		this.method518(var1, var2, var3, var5);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IILab;Lah;Lam;I)V",
		garbageValue = "700550528"
	)
	@Export("drawTileGround")
	void drawTileGround(int var1, int var2, AbstractWorldMapData var3, class49 var4, WorldMapSprite var5) {
		int var6 = var3.floorUnderlayIds[0][var1][var2] - 1;
		int var7 = var3.floorOverlayIds[0][var1][var2] - 1;
		if (var6 == -1 && var7 == -1) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.backgroundColor);
		}

		int var8 = 16711935;
		if (var7 != -1) {
			var8 = class169.method3545(var7, this.backgroundColor);
		}

		if (var7 > -1 && var3.field205[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			int var9 = this.method536(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method818(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field205[0][var1][var2], var3.field206[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IILab;Lah;B)V",
		garbageValue = "7"
	)
	void method535(int var1, int var2, AbstractWorldMapData var3, class49 var4) {
		for (int var5 = 1; var5 < var3.planes; ++var5) {
			int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
			if (var6 > -1) {
				int var7 = class169.method3545(var6, this.backgroundColor);
				if (var3.field205[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method818(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field205[var5][var1][var2], var3.field206[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IILab;Lam;I)I",
		garbageValue = "1185225383"
	)
	int method536(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IILab;[Lle;I)V",
		garbageValue = "-2109478496"
	)
	void method518(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					if (!Entity.method3374(var9.decoration)) {
						int var11 = var9.decoration;
						boolean var10 = var11 == WorldMapDecorationType.field2740.id;
						if (!var10) {
							continue;
						}
					}

					ObjectDefinition var12 = WorldMapSection2.getObjectDefinition(var9.objectDefinitionId);
					if (var12.mapSceneId != -1) {
						if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
							var4[var12.mapSceneId].method6211(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
						} else {
							var4[var12.mapSceneId].method6211(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(IILab;B)V",
		garbageValue = "-16"
	)
	void method527(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					int var10 = var8.decoration;
					boolean var9 = var10 >= WorldMapDecorationType.field2732.id && var10 <= WorldMapDecorationType.field2742.id || var10 == WorldMapDecorationType.field2722.id;
					if (var9) {
						ObjectDefinition var11 = WorldMapSection2.getObjectDefinition(var8.objectDefinitionId);
						int var12 = var11.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field2732.id) {
							this.method552(var1, var2, var8.rotation, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2728.id) {
							this.method552(var1, var2, var8.rotation, -3355444);
							this.method552(var1, var2, var8.rotation + 1, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2742.id) {
							if (var8.rotation == 0) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var12);
							}

							if (var8.rotation == 1) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), 1, var12);
							}

							if (var8.rotation == 2) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
							}

							if (var8.rotation == 3) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
							}
						}

						if (var8.decoration == WorldMapDecorationType.field2722.id) {
							int var13 = var8.rotation % 2;
							int var14;
							if (var13 == 0) {
								for (var14 = 0; var14 < this.pixelsPerTile; ++var14) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var14, 1, var12);
								}
							} else {
								for (var14 = 0; var14 < this.pixelsPerTile; ++var14) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.pixelsPerTile * var1, var14 + this.pixelsPerTile * (63 - var2), 1, var12);
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1793934594"
	)
	@Export("drawNonLinkMapIcons")
	void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
		float var5 = (float)var4 / 64.0F;
		float var6 = var5 / 2.0F;
		Iterator var7 = this.iconMap.entrySet().iterator();

		while (var7.hasNext()) {
			Entry var8 = (Entry)var7.next();
			Coord var9 = (Coord)var8.getKey();
			int var10 = (int)((float)var1 + var5 * (float)var9.x - var6);
			int var11 = (int)((float)(var2 + var4) - (float)var9.y * var5 - var6);
			AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
			if (var12 != null && var12.hasValidElement()) {
				var12.screenX = var10;
				var12.screenY = var11;
				WorldMapElement var13 = class25.WorldMapElement_get(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method542(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "1080849523"
	)
	void method540(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = class25.WorldMapElement_get(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Lio;IIIIS)V",
		garbageValue = "4032"
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Lax;IIFI)V",
		garbageValue = "1195952860"
	)
	void method542(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = class25.WorldMapElement_get(var1.getElement());
		this.method543(var5, var2, var3);
		this.method544(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Lio;IIB)V",
		garbageValue = "15"
	)
	void method543(WorldMapElement var1, int var2, int var3) {
		Sprite var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method546(var4, var1.horizontalAlignment);
			int var6 = this.method547(var4, var1.verticalAlignment);
			var4.drawTransBgAt(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Lax;Lio;IIFI)V",
		garbageValue = "630638914"
	)
	void method544(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method289(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field3216, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1206739508"
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
				var7.screenY = (int)((float)var2 + (float)(63 - var9) * var5);
				if (!var3.contains(var7.getElement())) {
					this.method542(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Lla;Lje;B)I",
		garbageValue = "1"
	)
	int method546(Sprite var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 0:
			return -var1.subWidth / 2;
		case 2:
			return 0;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Lla;Lie;B)I",
		garbageValue = "-110"
	)
	int method547(Sprite var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 1:
			return -var1.subHeight / 2;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(II)Lau;",
		garbageValue = "1415397741"
	)
	WorldMapLabel method548(int var1) {
		WorldMapElement var2 = class25.WorldMapElement_get(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Lio;B)Lau;",
		garbageValue = "93"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			int var3 = var1.textSize;
			WorldMapLabelSize[] var4 = WorldMapLabelSize.method284();
			int var5 = 0;

			WorldMapLabelSize var2;
			while (true) {
				if (var5 >= var4.length) {
					var2 = null;
					break;
				}

				WorldMapLabelSize var6 = var4[var5];
				if (var3 == var6.field155) {
					var2 = var6;
					break;
				}

				++var5;
			}

			if (var2 == null) {
				return null;
			} else {
				Font var14 = (Font)this.fonts.get(var2);
				if (var14 == null) {
					return null;
				} else {
					int var15 = var14.lineCount(var1.name, 1000000);
					String[] var7 = new String[var15];
					var14.breakLines(var1.name, (int[])null, var7);
					int var8 = var7.length * var14.ascent / 2;
					int var9 = 0;
					String[] var10 = var7;

					for (int var11 = 0; var11 < var10.length; ++var11) {
						String var12 = var10[var11];
						int var13 = var14.stringWidth(var12);
						if (var13 > var9) {
							var9 = var13;
						}
					}

					return new WorldMapLabel(var1.name, var9, var8, var2);
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IIIIII)Ljava/util/List;",
		garbageValue = "-1740751209"
	)
	List method606(int var1, int var2, int var3, int var4, int var5) {
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

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)Ljava/util/List;",
		garbageValue = "-1911332956"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-23"
	)
	void method552(int var1, int var2, int var3, int var4) {
		var3 %= 4;
		if (var3 == 0) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 1) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 2) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 3) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
		}

	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "294809885"
	)
	static final void method630() {
		int[] var0 = Players.Players_indices;

		int var1;
		for (var1 = 0; var1 < Players.Players_count; ++var1) {
			Player var2 = Client.players[var0[var1]];
			if (var2 != null && var2.overheadTextCyclesRemaining > 0) {
				--var2.overheadTextCyclesRemaining;
				if (var2.overheadTextCyclesRemaining == 0) {
					var2.overheadText = null;
				}
			}
		}

		for (var1 = 0; var1 < Client.npcCount; ++var1) {
			int var4 = Client.npcIndices[var1];
			NPC var3 = Client.npcs[var4];
			if (var3 != null && var3.overheadTextCyclesRemaining > 0) {
				--var3.overheadTextCyclesRemaining;
				if (var3.overheadTextCyclesRemaining == 0) {
					var3.overheadText = null;
				}
			}
		}

	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(Ljj;IIII)V",
		garbageValue = "-283435223"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null) {
				if (var0.isInteractable) {
					if (!var0.isFollower || Client.followerIndex == var1) {
						String var4 = var0.name;
						int var7;
						int var8;
						if (var0.combatLevel != 0) {
							var7 = var0.combatLevel;
							var8 = ByteArrayPool.localPlayer.combatLevel;
							int var9 = var8 - var7;
							String var6;
							if (var9 < -9) {
								var6 = class297.colorStartTag(16711680);
							} else if (var9 < -6) {
								var6 = class297.colorStartTag(16723968);
							} else if (var9 < -3) {
								var6 = class297.colorStartTag(16740352);
							} else if (var9 < 0) {
								var6 = class297.colorStartTag(16756736);
							} else if (var9 > 9) {
								var6 = class297.colorStartTag(65280);
							} else if (var9 > 6) {
								var6 = class297.colorStartTag(4259584);
							} else if (var9 > 3) {
								var6 = class297.colorStartTag(8453888);
							} else if (var9 > 0) {
								var6 = class297.colorStartTag(12648192);
							} else {
								var6 = class297.colorStartTag(16776960);
							}

							var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							IgnoreList.insertMenuItemNoShift("Examine", class297.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							IgnoreList.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class297.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((AbstractWorldMapIcon.selectedSpellFlags & 2) == 2) {
								IgnoreList.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class297.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var10 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var11 = var0.actions;
							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var10 + 9;
										}

										if (var7 == 1) {
											var8 = var10 + 10;
										}

										if (var7 == 2) {
											var8 = var10 + 11;
										}

										if (var7 == 3) {
											var8 = var10 + 12;
										}

										if (var7 == 4) {
											var8 = var10 + 13;
										}

										IgnoreList.insertMenuItemNoShift(var11[var7], class297.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
										short var12 = 0;
										if (Client.npcAttackOption != AttackOption.AttackOption_hidden) {
											if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > ByteArrayPool.localPlayer.combatLevel) {
												var12 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var12 + 9;
											}

											if (var7 == 1) {
												var8 = var12 + 10;
											}

											if (var7 == 2) {
												var8 = var12 + 11;
											}

											if (var7 == 3) {
												var8 = var12 + 12;
											}

											if (var7 == 4) {
												var8 = var12 + 13;
											}

											IgnoreList.insertMenuItemNoShift(var11[var7], class297.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								IgnoreList.insertMenuItemNoShift("Examine", class297.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-59"
	)
	static final void method537() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsInClanChat();
		}

	}
}

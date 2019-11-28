import java.io.IOException;
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

@ObfuscatedName("ai")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("sx")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("WorldMapRegion_cachedSprites")
	public static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1644673379
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 155602153
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lr;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("w")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1389068533
	)
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -342949877
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("x")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("o")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("e")
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-684564280"
	)
	void method460(int var1, int var2, int var3) {
		int var5 = this.regionX;
		int var6 = this.regionY;
		int var7 = this.pixelsPerTile;
		DemotingHashTable var8 = WorldMapRegion_cachedSprites;
		long var9 = (long)(var7 << 16 | var5 << 8 | var6);
		Sprite var4 = (Sprite)var8.get(var9);
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.drawScaledWorldmap(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lr;Ljava/util/List;I)V",
		garbageValue = "-1835968904"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
		garbageValue = "4"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIILm;I)V",
		garbageValue = "-1966744518"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label75:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							ObjectDefinition var13;
							boolean var14;
							label66: {
								WorldMapDecoration var12 = var10[var11];
								var13 = Occluder.getObjectDefinition(var12.objectDefinitionId);
								if (var13.transforms != null) {
									int[] var15 = var13.transforms;

									for (int var16 = 0; var16 < var15.length; ++var16) {
										int var17 = var15[var16];
										ObjectDefinition var18 = Occluder.getObjectDefinition(var17);
										if (var18.mapIconId != -1) {
											var14 = true;
											break label66;
										}
									}
								} else if (var13.mapIconId != -1) {
									var14 = true;
									break label66;
								}

								var14 = false;
							}

							if (var14) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label75;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lil;IIILm;I)V",
		garbageValue = "-1396744194"
	)
	@Export("getIcon")
	void getIcon(ObjectDefinition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 4096, var4 + this.worldMapData_0.regionYLow * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.minPlane, var3 + var8.regionXLow * 4096 + var8.getChunkXLow() * 8, var4 + var8.regionYLow * 64 + var8.getChunkYLow() * 8);
		}

		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			WorldMapElement var9 = Varcs.WorldMapElement_get(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		this.iconMap.put(new Coord(0, var3, var4), var10);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1299616517"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/util/List;I)V",
		garbageValue = "-679191042"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method465(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "18"
	)
	void method443() {
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lhf;I)Z",
		garbageValue = "-1443826552"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILaz;[Llm;Lhf;Lhf;S)V",
		garbageValue = "2800"
	)
	@Export("drawTile")
	void drawTile(int var1, class40 var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			int var7 = this.regionX;
			int var8 = this.regionY;
			DemotingHashTable var9 = WorldMapRegion_cachedSprites;
			long var10 = (long)(var1 << 16 | var7 << 8 | var8);
			Sprite var6 = (Sprite)var9.get(var10);
			if (var6 == null) {
				boolean var15 = true;
				var15 &= this.loadGeography(var4);
				int var11;
				if (this.worldMapData_0 != null) {
					var11 = this.worldMapData_0.groupId;
				} else {
					var11 = ((AbstractWorldMapData)this.worldMapData1List.getFirst()).groupId;
				}

				var15 &= var5.tryLoadGroup(var11);
				if (var15) {
					byte[] var16 = var5.takeFileFlat(var11);
					WorldMapSprite var12;
					if (var16 == null) {
						var12 = new WorldMapSprite();
					} else {
						var12 = new WorldMapSprite(MouseHandler.convertJpgToSprite(var16).pixels);
					}

					Sprite var14 = new Sprite(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var14.setRaster();
					if (this.worldMapData_0 != null) {
						this.method454(var2, var3, var12);
					} else {
						this.method449(var2, var3, var12);
					}

					class43.method822(var14, this.regionX, this.regionY, this.pixelsPerTile);
					this.method443();
				}
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIILjava/util/HashSet;I)V",
		garbageValue = "-617331188"
	)
	void method446(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;IIB)V",
		garbageValue = "-80"
	)
	@Export("flashElements")
	void flashElements(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = Varcs.WorldMapElement_get(var6);
					this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method457(var1, var2, var3);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Laz;[Llm;Lad;I)V",
		garbageValue = "-795524086"
	)
	void method454(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method510(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method557(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Laz;[Llm;Lad;I)V",
		garbageValue = "-847322953"
	)
	void method449(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method510(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method557(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IILm;Laz;[Llm;S)V",
		garbageValue = "23091"
	)
	void method557(int var1, int var2, AbstractWorldMapData var3, class40 var4, IndexedSprite[] var5) {
		this.method455(var1, var2, var3);
		this.method450(var1, var2, var3, var5);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IILm;Laz;Lad;I)V",
		garbageValue = "1713363945"
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
			var8 = class288.method5383(var7, this.backgroundColor);
		}

		if (var7 > -1 && var3.field166[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			int var9 = this.method453(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method740(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field166[0][var1][var2], var3.field160[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IILm;Laz;I)V",
		garbageValue = "-1210019678"
	)
	void method510(int var1, int var2, AbstractWorldMapData var3, class40 var4) {
		for (int var5 = 1; var5 < var3.planes; ++var5) {
			int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
			if (var6 > -1) {
				int var7 = class288.method5383(var6, this.backgroundColor);
				if (var3.field166[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method740(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field166[var5][var1][var2], var3.field160[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IILm;Lad;B)I",
		garbageValue = "-55"
	)
	int method453(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IILm;[Llm;I)V",
		garbageValue = "-179738925"
	)
	void method450(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					int var11 = var9.decoration;
					boolean var10 = var11 >= WorldMapDecorationType.field2747.id && var11 <= WorldMapDecorationType.field2728.id;
					if (var10 || class195.method3743(var9.decoration)) {
						ObjectDefinition var12 = Occluder.getObjectDefinition(var9.objectDefinitionId);
						if (var12.mapSceneId != -1) {
							if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
								var4[var12.mapSceneId].method6182(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
							} else {
								var4[var12.mapSceneId].method6182(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IILm;B)V",
		garbageValue = "56"
	)
	void method455(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					if (class81.method2086(var8.decoration)) {
						ObjectDefinition var9 = Occluder.getObjectDefinition(var8.objectDefinitionId);
						int var10 = var9.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field2748.id) {
							this.method469(var1, var2, var8.rotation, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field2727.id) {
							this.method469(var1, var2, var8.rotation, -3355444);
							this.method469(var1, var2, var8.rotation + 1, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field2730.id) {
							if (var8.rotation == 0) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 1) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 2) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}

							if (var8.rotation == 3) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}
						}

						if (var8.decoration == WorldMapDecorationType.field2731.id) {
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-2128075696"
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
			int var11 = (int)((float)(var2 + var4) - (float)var9.y * var5 - var6);
			AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
			if (var12 != null && var12.hasValidElement()) {
				var12.screenX = var10;
				var12.screenY = var11;
				WorldMapElement var13 = Varcs.WorldMapElement_get(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method459(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "693286159"
	)
	void method457(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = Varcs.WorldMapElement_get(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Lis;IIIIB)V",
		garbageValue = "57"
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Laa;IIFI)V",
		garbageValue = "1357516657"
	)
	void method459(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = Varcs.WorldMapElement_get(var1.getElement());
		this.method535(var5, var2, var3);
		this.method461(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(Lis;III)V",
		garbageValue = "-682100464"
	)
	void method535(WorldMapElement var1, int var2, int var3) {
		Sprite var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method463(var4, var1.horizontalAlignment);
			int var6 = this.method464(var4, var1.verticalAlignment);
			var4.drawTransBgAt(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Laa;Lis;IIFI)V",
		garbageValue = "-383988054"
	)
	void method461(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method199(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field3227, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1649887990"
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
				var7.screenX = (int)(var5 * (float)var8 + (float)var1);
				var7.screenY = (int)((float)(63 - var9) * var5 + (float)var2);
				if (!var3.contains(var7.getElement())) {
					this.method459(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Lln;Lip;B)I",
		garbageValue = "14"
	)
	int method463(Sprite var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 1:
			return 0;
		case 2:
			return -var1.subWidth / 2;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Lln;Lik;B)I",
		garbageValue = "68"
	)
	int method464(Sprite var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 1:
			return -var1.subHeight / 2;
		case 2:
			return 0;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(II)Lam;",
		garbageValue = "1821689800"
	)
	WorldMapLabel method465(int var1) {
		WorldMapElement var2 = Varcs.WorldMapElement_get(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Lis;I)Lam;",
		garbageValue = "1746984480"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			WorldMapLabelSize var2 = WorldMapLabelSize.method209(var1.textSize);
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IIIIII)Ljava/util/List;",
		garbageValue = "-950431739"
	)
	List method467(int var1, int var2, int var3, int var4, int var5) {
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

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)Ljava/util/List;",
		garbageValue = "-907071447"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1544292788"
	)
	void method469(int var1, int var2, int var3, int var4) {
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lir;",
		garbageValue = "1453408926"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;ZII)V",
		garbageValue = "347974889"
	)
	static void method505(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1194) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			AbstractByteArrayCopier.leftTitleSprite = MouseHandler.convertJpgToSprite(var4);
			class319.rightTitleSprite = AbstractByteArrayCopier.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				Decimator.logoSprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else if ((Client.worldProperties & 1073741824) != 0) {
				Decimator.logoSprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "logo_seasonal_mode", "");
			} else {
				Decimator.logoSprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			int var6 = var1.getGroupId("runes");
			int var7 = var1.getFileId(var6, "");
			IndexedSprite[] var8;
			if (!GraphicsObject.method2030(var1, var6, var7)) {
				var8 = null;
			} else {
				var8 = WallDecoration.method3341();
			}

			StructDefinition.runesSprite = var8;
			var7 = var1.getGroupId("title_mute");
			int var10 = var1.getFileId(var7, "");
			IndexedSprite[] var9;
			if (!GraphicsObject.method2030(var1, var7, var10)) {
				var9 = null;
			} else {
				var9 = WallDecoration.method3341();
			}

			Login.title_muteSprite = var9;
			InterfaceParent.options_buttons_0Sprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			Login.field1179 = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Varps.options_buttons_2Sprite = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			StructDefinition.field3315 = BZip2State.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			HealthBar.field1115 = InterfaceParent.options_buttons_0Sprite.subWidth;
			class40.field348 = InterfaceParent.options_buttons_0Sprite.subHeight;
			DynamicObject.loginScreenRunesAnimation = new LoginScreenAnimation(StructDefinition.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			class192.field2395 = 0;
			WorldMapSection0.otp = "";
			Login.field1196 = true;
			Login.worldSelectOpen = false;
			if (!UserComparator10.clientPreferences.titleMusicDisabled) {
				Archive var12 = AbstractWorldMapData.archive6;
				var10 = var12.getGroupId("scape main");
				int var13 = var12.getFileId(var10, "");
				World.method1819(2, var12, var10, var13, 255, false);
			} else {
				UrlRequest.method3358(2);
			}

			if (NetCache.NetCache_socket != null) {
				try {
					Buffer var16 = new Buffer(4);
					var16.writeByte(3);
					var16.writeMedium(0);
					NetCache.NetCache_socket.write(var16.array, 0, 4);
				} catch (IOException var15) {
					try {
						NetCache.NetCache_socket.close();
					} catch (Exception var14) {
					}

					++NetCache.NetCache_ioExceptions;
					NetCache.NetCache_socket = null;
				}
			}

			Login.field1194 = true;
			Login.xPadding = (BoundaryObject.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			GrandExchangeOfferOwnWorldComparator.loginBoxCenter = Login.loginBoxX + 180;
			AbstractByteArrayCopier.leftTitleSprite.drawAt(Login.xPadding, 0);
			class319.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Decimator.logoSprite.drawAt(Login.xPadding + 382 - Decimator.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(ZLkj;B)V",
		garbageValue = "0"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var2;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			var2 = var1.method5640();
			int var3 = var1.method5641();
			var4 = var1.readUnsignedShort();
			WorldMapIcon_0.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					WorldMapIcon_0.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			class226.regions = new int[var4];
			BuddyRankComparator.regionMapArchiveIds = new int[var4];
			GrandExchangeOfferAgeComparator.regionLandArchiveIds = new int[var4];
			VerticalAlignment.regionLandArchives = new byte[var4][];
			UrlRequest.regionMapArchives = new byte[var4][];
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
						class226.regions[var4] = var8;
						BuddyRankComparator.regionMapArchiveIds[var4] = DirectByteArrayCopier.archive5.getGroupId("m" + var6 + "_" + var7);
						GrandExchangeOfferAgeComparator.regionLandArchiveIds[var4] = DirectByteArrayCopier.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			WorldMapSection0.method259(var3, var2, true);
		} else {
			var2 = var1.method5719();
			boolean var15 = var1.method5631() == 1;
			var4 = var1.method5719();
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
			WorldMapIcon_0.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					WorldMapIcon_0.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			class226.regions = new int[var5];
			BuddyRankComparator.regionMapArchiveIds = new int[var5];
			GrandExchangeOfferAgeComparator.regionLandArchiveIds = new int[var5];
			VerticalAlignment.regionLandArchives = new byte[var5][];
			UrlRequest.regionMapArchives = new byte[var5][];
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
								if (class226.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								class226.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								BuddyRankComparator.regionMapArchiveIds[var5] = DirectByteArrayCopier.archive5.getGroupId("m" + var13 + "_" + var14);
								GrandExchangeOfferAgeComparator.regionLandArchiveIds[var5] = DirectByteArrayCopier.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			WorldMapSection0.method259(var4, var2, !var15);
		}

	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(Lhl;Liu;IIZI)V",
		garbageValue = "-1451067375"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			class14.insertMenuItem(var7, class222.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}

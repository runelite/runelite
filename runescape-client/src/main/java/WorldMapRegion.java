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
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("aa")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Leu;"
	)
	@Export("WorldMapRegion_cachedSprites")
	public static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1498517863
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1147165053
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lw;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("y")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1662535699
	)
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1749313949
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("b")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("o")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("a")
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-65"
	)
	void method441(int var1, int var2, int var3) {
		int var5 = this.regionX;
		int var6 = this.regionY;
		int var7 = this.pixelsPerTile;
		Sprite var4 = (Sprite)WorldMapRegion_cachedSprites.get(SecureRandomCallable.method1165(var5, var6, var7));
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.drawScaledWorldmap(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lw;Ljava/util/List;I)V",
		garbageValue = "934044689"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;Ljava/util/List;S)V",
		garbageValue = "-12839"
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
		signature = "(IIIILf;B)V",
		garbageValue = "16"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label73:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							ObjectDefinition var13;
							boolean var14;
							label64: {
								WorldMapDecoration var12 = var10[var11];
								var13 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var12.objectDefinitionId);
								if (var13.transforms != null) {
									int[] var15 = var13.transforms;

									for (int var16 = 0; var16 < var15.length; ++var16) {
										int var17 = var15[var16];
										ObjectDefinition var18 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var17);
										if (var18.mapIconId != -1) {
											var14 = true;
											break label64;
										}
									}
								} else if (var13.mapIconId != -1) {
									var14 = true;
									break label64;
								}

								var14 = false;
							}

							if (var14) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label73;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Liz;IIILf;I)V",
		garbageValue = "-1603765403"
	)
	@Export("getIcon")
	void getIcon(ObjectDefinition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 64, var4 + this.worldMapData_0.regionYLow * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.minPlane, var8.regionXLow * 64 + var3 + var8.getChunkXLow() * 8, var8.regionYLow * 64 + var4 + var8.getChunkYLow() * 8);
		}

		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			WorldMapElement var9 = Decimator.WorldMapElement_get(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		this.iconMap.put(new Coord(0, var3, var4), var10);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2006660895"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/util/List;I)V",
		garbageValue = "-831141503"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method470(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2077260689"
	)
	void method448() {
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
		signature = "(Lhp;I)Z",
		garbageValue = "1582385284"
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILak;[Llp;Lhp;Lhp;I)V",
		garbageValue = "1768425388"
	)
	@Export("drawTile")
	void drawTile(int var1, class40 var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			int var7 = this.regionX;
			int var8 = this.regionY;
			Sprite var6 = (Sprite)WorldMapRegion_cachedSprites.get(SecureRandomCallable.method1165(var7, var8, var1));
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
						var12 = new WorldMapSprite(class40.convertJpgToSprite(var10).pixels);
					}

					Sprite var14 = new Sprite(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var14.setRaster();
					if (this.worldMapData_0 != null) {
						this.method543(var2, var3, var12);
					} else {
						this.method454(var2, var3, var12);
					}

					int var15 = this.regionX;
					int var16 = this.regionY;
					int var17 = this.pixelsPerTile;
					WorldMapRegion_cachedSprites.put(var14, SecureRandomCallable.method1165(var15, var16, var17), var14.pixels.length * 4);
					this.method448();
				}
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIILjava/util/HashSet;B)V",
		garbageValue = "62"
	)
	void method451(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "-1219088991"
	)
	@Export("flashElements")
	void flashElements(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = Decimator.WorldMapElement_get(var6);
					this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method462(var1, var2, var3);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lak;[Llp;Laz;I)V",
		garbageValue = "-2022635387"
	)
	void method543(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method457(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method455(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lak;[Llp;Laz;B)V",
		garbageValue = "70"
	)
	void method454(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method457(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method455(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IILf;Lak;[Llp;I)V",
		garbageValue = "-1519610368"
	)
	void method455(int var1, int var2, AbstractWorldMapData var3, class40 var4, IndexedSprite[] var5) {
		this.method460(var1, var2, var3);
		this.method521(var1, var2, var3, var5);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IILf;Lak;Laz;I)V",
		garbageValue = "-1375655341"
	)
	@Export("drawTileGround")
	void drawTileGround(int var1, int var2, AbstractWorldMapData var3, class40 var4, WorldMapSprite var5) {
		int var6 = var3.floorUnderlayIds[0][var1][var2] - 1;
		int var7 = var3.floorOverlayIds[0][var1][var2] - 1;
		if (var6 == -1 && var7 == -1) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.backgroundColor);
		}

		int var8 = 16711935;
		int var9;
		if (var7 != -1) {
			int var10 = this.backgroundColor;
			FloorOverlayDefinition var12 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var7);
			FloorOverlayDefinition var11;
			if (var12 != null) {
				var11 = var12;
			} else {
				byte[] var13 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var7);
				var12 = new FloorOverlayDefinition();
				if (var13 != null) {
					var12.decode(new Buffer(var13), var7);
				}

				var12.postDecode();
				FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var12, (long)var7);
				var11 = var12;
			}

			if (var11 == null) {
				var9 = var10;
			} else if (var11.secondaryRgb >= 0) {
				var9 = var11.secondaryRgb | -16777216;
			} else {
				int var14;
				byte var15;
				int var17;
				int var18;
				if (var11.texture >= 0) {
					var14 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var11.texture);
					var15 = 96;
					if (var14 == -2) {
						var17 = 12345678;
					} else if (var14 == -1) {
						if (var15 < 0) {
							var15 = 0;
						} else if (var15 > 127) {
							var15 = 127;
						}

						var18 = 127 - var15;
						var17 = var18;
					} else {
						var18 = var15 * (var14 & 127) / 128;
						if (var18 < 2) {
							var18 = 2;
						} else if (var18 > 126) {
							var18 = 126;
						}

						var17 = var18 + (var14 & 65408);
					}

					var9 = Rasterizer3D.Rasterizer3D_colorPalette[var17] | -16777216;
				} else if (var11.primaryRgb == 16711935) {
					var9 = var10;
				} else {
					var17 = class65.method1245(var11.hue, var11.saturation, var11.lightness);
					var15 = 96;
					if (var17 == -2) {
						var14 = 12345678;
					} else if (var17 == -1) {
						if (var15 < 0) {
							var15 = 0;
						} else if (var15 > 127) {
							var15 = 127;
						}

						var18 = 127 - var15;
						var14 = var18;
					} else {
						var18 = var15 * (var17 & 127) / 128;
						if (var18 < 2) {
							var18 = 2;
						} else if (var18 > 126) {
							var18 = 126;
						}

						var14 = var18 + (var17 & 65408);
					}

					var9 = Rasterizer3D.Rasterizer3D_colorPalette[var14] | -16777216;
				}
			}

			var8 = var9;
		}

		if (var7 > -1 && var3.field164[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			var9 = this.method458(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method751(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field164[0][var1][var2], var3.field152[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IILf;Lak;B)V",
		garbageValue = "1"
	)
	void method457(int var1, int var2, AbstractWorldMapData var3, class40 var4) {
		for (int var5 = 1; var5 < var3.planes; ++var5) {
			int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
			if (var6 > -1) {
				int var8 = this.backgroundColor;
				FloorOverlayDefinition var10 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var6);
				FloorOverlayDefinition var9;
				if (var10 != null) {
					var9 = var10;
				} else {
					byte[] var11 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var6);
					var10 = new FloorOverlayDefinition();
					if (var11 != null) {
						var10.decode(new Buffer(var11), var6);
					}

					var10.postDecode();
					FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var10, (long)var6);
					var9 = var10;
				}

				int var7;
				if (var9 == null) {
					var7 = var8;
				} else if (var9.secondaryRgb >= 0) {
					var7 = var9.secondaryRgb | -16777216;
				} else {
					int var12;
					byte var13;
					int var16;
					int var17;
					if (var9.texture >= 0) {
						var12 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var9.texture);
						var13 = 96;
						if (var12 == -2) {
							var16 = 12345678;
						} else if (var12 == -1) {
							if (var13 < 0) {
								var13 = 0;
							} else if (var13 > 127) {
								var13 = 127;
							}

							var17 = 127 - var13;
							var16 = var17;
						} else {
							var17 = var13 * (var12 & 127) / 128;
							if (var17 < 2) {
								var17 = 2;
							} else if (var17 > 126) {
								var17 = 126;
							}

							var16 = var17 + (var12 & 65408);
						}

						var7 = Rasterizer3D.Rasterizer3D_colorPalette[var16] | -16777216;
					} else if (var9.primaryRgb == 16711935) {
						var7 = var8;
					} else {
						var16 = class65.method1245(var9.hue, var9.saturation, var9.lightness);
						var13 = 96;
						if (var16 == -2) {
							var12 = 12345678;
						} else if (var16 == -1) {
							if (var13 < 0) {
								var13 = 0;
							} else if (var13 > 127) {
								var13 = 127;
							}

							var17 = 127 - var13;
							var12 = var17;
						} else {
							var17 = var13 * (var16 & 127) / 128;
							if (var17 < 2) {
								var17 = 2;
							} else if (var17 > 126) {
								var17 = 126;
							}

							var12 = var17 + (var16 & 65408);
						}

						var7 = Rasterizer3D.Rasterizer3D_colorPalette[var12] | -16777216;
					}
				}

				if (var3.field164[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method751(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field164[var5][var1][var2], var3.field152[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IILf;Laz;B)I",
		garbageValue = "-62"
	)
	int method458(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IILf;[Llp;I)V",
		garbageValue = "-1752440652"
	)
	void method521(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					if (!Strings.method4091(var9.decoration)) {
						int var11 = var9.decoration;
						boolean var10 = var11 == WorldMapDecorationType.field2721.id;
						if (!var10) {
							continue;
						}
					}

					ObjectDefinition var12 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var9.objectDefinitionId);
					if (var12.mapSceneId != -1) {
						if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
							var4[var12.mapSceneId].method6042(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
						} else {
							var4[var12.mapSceneId].method6042(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IILf;B)V",
		garbageValue = "-71"
	)
	void method460(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					int var10 = var8.decoration;
					boolean var9 = var10 >= WorldMapDecorationType.field2710.id && var10 <= WorldMapDecorationType.field2702.id || var10 == WorldMapDecorationType.field2708.id;
					if (var9) {
						ObjectDefinition var11 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var8.objectDefinitionId);
						int var12 = var11.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field2710.id) {
							this.method474(var1, var2, var8.rotation, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2701.id) {
							this.method474(var1, var2, var8.rotation, -3355444);
							this.method474(var1, var2, var8.rotation + 1, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2702.id) {
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

						if (var8.decoration == WorldMapDecorationType.field2708.id) {
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-2102994892"
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
			int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.y - var6);
			AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
			if (var12 != null && var12.hasValidElement()) {
				var12.screenX = var10;
				var12.screenY = var11;
				WorldMapElement var13 = Decimator.WorldMapElement_get(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method464(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;III)V",
		garbageValue = "1749313949"
	)
	void method462(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = Decimator.WorldMapElement_get(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Lij;IIIII)V",
		garbageValue = "-828139741"
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Las;IIFI)V",
		garbageValue = "-1297733559"
	)
	void method464(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = Decimator.WorldMapElement_get(var1.getElement());
		this.method546(var5, var2, var3);
		this.method553(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Lij;III)V",
		garbageValue = "972289630"
	)
	void method546(WorldMapElement var1, int var2, int var3) {
		Sprite var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method468(var4, var1.horizontalAlignment);
			int var6 = this.method480(var4, var1.verticalAlignment);
			var4.drawTransBgAt(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Las;Lij;IIFB)V",
		garbageValue = "-47"
	)
	void method553(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method198(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field3195, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "786229933"
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
				var7.screenY = (int)((float)var2 + (float)(63 - var9) * var5);
				if (!var3.contains(var7.getElement())) {
					this.method464(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Llf;Lin;I)I",
		garbageValue = "864808689"
	)
	int method468(Sprite var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 1:
			return 0;
		case 2:
			return -var1.subWidth / 2;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Llf;Lim;I)I",
		garbageValue = "-1390115279"
	)
	int method480(Sprite var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 2:
			return -var1.subHeight / 2;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(IB)Law;",
		garbageValue = "101"
	)
	WorldMapLabel method470(int var1) {
		WorldMapElement var2 = Decimator.WorldMapElement_get(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Lij;I)Law;",
		garbageValue = "1073905876"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			int var3 = var1.textSize;
			WorldMapLabelSize[] var4 = WorldMapLabelSize.method196();
			int var5 = 0;

			WorldMapLabelSize var2;
			while (true) {
				if (var5 >= var4.length) {
					var2 = null;
					break;
				}

				WorldMapLabelSize var6 = var4[var5];
				if (var3 == var6.field108) {
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(IIIIII)Ljava/util/List;",
		garbageValue = "1652888752"
	)
	List method472(int var1, int var2, int var3, int var4, int var5) {
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)Ljava/util/List;",
		garbageValue = "-1073519222"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1671492545"
	)
	void method474(int var1, int var2, int var3, int var4) {
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;II)Lgk;",
		garbageValue = "-470288420"
	)
	static MusicPatch method519(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		return var2 == null ? null : new MusicPatch(var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
		garbageValue = "2074983607"
	)
	@Export("getCacheDir")
	public static File getCacheDir(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		JagexCache.JagexCache_locationFile = new File(JagexCache.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		Buffer var8;
		int var11;
		File var27;
		if (JagexCache.JagexCache_locationFile.exists()) {
			try {
				AccessFile var7 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

				int var9;
				for (var8 = new Buffer((int)var7.length()); var8.offset < var8.array.length; var8.offset += var9) {
					var9 = var7.read(var8.array, var8.offset, var8.array.length - var8.offset);
					if (var9 == -1) {
						throw new IOException();
					}
				}

				var8.offset = 0;
				var9 = var8.readUnsignedByte();
				if (var9 < 1 || var9 > 3) {
					throw new IOException("" + var9);
				}

				int var10 = 0;
				if (var9 > 1) {
					var10 = var8.readUnsignedByte();
				}

				if (var9 <= 2) {
					var4 = var8.readStringCp1252NullCircumfixed();
					if (var10 == 1) {
						var5 = var8.readStringCp1252NullCircumfixed();
					}
				} else {
					var4 = var8.readCESU8();
					if (var10 == 1) {
						var5 = var8.readCESU8();
					}
				}

				var7.close();
			} catch (IOException var25) {
				var25.printStackTrace();
			}

			if (var4 != null) {
				var27 = new File(var4);
				if (!var27.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var27 = new File(var4, "test.dat");

				boolean var28;
				try {
					RandomAccessFile var15 = new RandomAccessFile(var27, "rw");
					var11 = var15.read();
					var15.seek(0L);
					var15.write(var11);
					var15.seek(0L);
					var15.close();
					var27.delete();
					var28 = true;
				} catch (Exception var23) {
					var28 = false;
				}

				if (!var28) {
					var4 = null;
				}
			}
		}

		if (var4 == null && var2 == 0) {
			label159:
			for (int var16 = 0; var16 < class266.field3537.length; ++var16) {
				for (int var17 = 0; var17 < UserComparator4.field1948.length; ++var17) {
					File var18 = new File(UserComparator4.field1948[var17] + class266.field3537[var16] + File.separatorChar + var0 + File.separatorChar);
					if (var18.exists()) {
						File var19 = new File(var18, "test.dat");

						boolean var29;
						try {
							RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
							int var13 = var12.read();
							var12.seek(0L);
							var12.write(var13);
							var12.seek(0L);
							var12.close();
							var19.delete();
							var29 = true;
						} catch (Exception var22) {
							var29 = false;
						}

						if (var29) {
							var4 = var18.toString();
							var6 = true;
							break label159;
						}
					}
				}
			}
		}

		if (var4 == null) {
			var4 = JagexCache.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		File var26;
		if (var5 != null) {
			var26 = new File(var5);
			var27 = new File(var4);

			try {
				File[] var33 = var26.listFiles();
				File[] var31 = var33;

				for (var11 = 0; var11 < var31.length; ++var11) {
					File var30 = var31[var11];
					File var20 = new File(var27, var30.getName());
					boolean var14 = var30.renameTo(var20);
					if (!var14) {
						throw new IOException();
					}
				}
			} catch (Exception var24) {
				var24.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			var26 = new File(var4);
			var8 = null;

			try {
				AccessFile var34 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
				Buffer var32 = new Buffer(500);
				var32.writeByte(3);
				var32.writeByte(var8 != null ? 1 : 0);
				var32.writeCESU8(var26.getPath());
				if (var8 != null) {
					var32.writeCESU8("");
				}

				var34.write(var32.array, 0, var32.offset);
				var34.close();
			} catch (IOException var21) {
				var21.printStackTrace();
			}
		}

		return new File(var4);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1776528190"
	)
	static int method506(int var0, Script var1, boolean var2) {
		Widget var3 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class2.method30(class2.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.IF_GETOP) {
			if (var0 == ScriptOpcodes.IF_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}

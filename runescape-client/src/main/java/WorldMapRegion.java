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

@ObfuscatedName("aw")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Led;"
	)
	@Export("WorldMapRegion_cachedSprites")
	public static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	static StudioGame field248;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("gb")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -862345975
	)
	@Export("regionx")
	int regionx;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -908569217
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ly;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("c")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1971368251
	)
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 2110263181
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("u")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("x")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("r")
	@Export("fonts")
	final HashMap fonts;

	static {
		WorldMapRegion_cachedSprites = new DemotingHashTable(37748736, 256);
	}

	WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
		this.regionx = var1;
		this.regionY = var2;
		this.worldMapData1List = new LinkedList();
		this.icon0List = new LinkedList();
		this.iconMap = new HashMap();
		this.backgroundColor = var3 | -16777216;
		this.fonts = var4;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1947241845"
	)
	void method506(int var1, int var2, int var3) {
		Sprite var4 = PlayerType.getWorldMapRegionCachedSprite(this.regionx, this.regionY, this.pixelsPerTile);
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.method6144(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ly;Ljava/util/List;I)V",
		garbageValue = "1340237556"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
		garbageValue = "-523355957"
	)
	@Export("initWorldMapData1")
	void initWorldMapData1(HashSet var1, List var2) {
		this.iconMap.clear();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			WorldMapData_1 var4 = (WorldMapData_1)var3.next();
			if (var4.getRegionX() == this.regionx && var4.getRegionY() == this.regionY) {
				this.worldMapData1List.add(var4);
			}
		}

		this.addAllToIconList(var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIILo;I)V",
		garbageValue = "585564692"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label72:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							ObjectDefinition var13;
							boolean var14;
							label63: {
								WorldMapDecoration var12 = var10[var11];
								var13 = ViewportMouse.getObjectDefinition(var12.objectDefinitionId);
								if (var13.transforms != null) {
									int[] var15 = var13.transforms;

									for (int var16 = 0; var16 < var15.length; ++var16) {
										int var17 = var15[var16];
										ObjectDefinition var18 = ViewportMouse.getObjectDefinition(var17);
										if (var18.mapIconId != -1) {
											var14 = true;
											break label63;
										}
									}
								} else if (var13.mapIconId != -1) {
									var14 = true;
									break label63;
								}

								var14 = false;
							}

							if (var14) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label72;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Liy;IIILo;I)V",
		garbageValue = "-1363155739"
	)
	@Export("getIcon")
	void getIcon(ObjectDefinition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionx * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 64, var4 + this.worldMapData_0.regionYLow * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.minPlane, var3 + var8.regionXLow * 64 + var8.getChunkXLow() * 8, var4 + var8.regionYLow * 64 + var8.getChunkYLow() * 8);
		}

		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			WorldMapElement var9 = class222.getWorldMapElement(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		this.iconMap.put(new Coord(0, var3, var4), var10);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "106"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/util/List;I)V",
		garbageValue = "-1298217436"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (var3.coord2.x >> 6 == this.regionx && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method502(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "30233"
	)
	void method429() {
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lhp;B)Z",
		garbageValue = "96"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILap;[Llx;Lhp;Lhp;I)V",
		garbageValue = "-1781579709"
	)
	@Export("drawTile")
	void drawTile(int var1, class40 var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			if (PlayerType.getWorldMapRegionCachedSprite(this.regionx, this.regionY, var1) == null) {
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
					WorldMapSprite var9;
					if (var7 == null) {
						var9 = new WorldMapSprite();
					} else {
						var9 = new WorldMapSprite(BuddyRankComparator.convertJpgToSprite(var7).pixels);
					}

					Sprite var11 = new Sprite(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var11.setRaster();
					if (this.worldMapData_0 != null) {
						this.method434(var2, var3, var9);
					} else {
						this.method435(var2, var3, var9);
					}

					int var12 = this.regionx;
					int var13 = this.regionY;
					int var14 = this.pixelsPerTile;
					WorldMapRegion_cachedSprites.put(var11, Widget.getWorldMapSpriteHash(var12, var13, var14), var11.pixels.length * 4);
					this.method429();
				}
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIILjava/util/HashSet;B)V",
		garbageValue = "67"
	)
	void method432(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;IIB)V",
		garbageValue = "82"
	)
	void method433(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = class222.getWorldMapElement(var6);
					this.method493(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method443(var1, var2, var3);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lap;[Llx;Lav;I)V",
		garbageValue = "-5287364"
	)
	void method434(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method520(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method436(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lap;[Llx;Lav;I)V",
		garbageValue = "1494661478"
	)
	void method435(class40 var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method520(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method436(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IILo;Lap;[Llx;I)V",
		garbageValue = "1019894341"
	)
	void method436(int var1, int var2, AbstractWorldMapData var3, class40 var4, IndexedSprite[] var5) {
		this.method472(var1, var2, var3);
		this.method463(var1, var2, var3, var5);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IILo;Lap;Lav;I)V",
		garbageValue = "-1409851959"
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
					var17 = class192.method3679(var11.hue, var11.saturation, var11.lightness);
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

		if (var7 > -1 && var3.field165[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			var9 = this.method439(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method698(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field165[0][var1][var2], var3.field166[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IILo;Lap;I)V",
		garbageValue = "-272085910"
	)
	void method520(int var1, int var2, AbstractWorldMapData var3, class40 var4) {
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
						var16 = class192.method3679(var9.hue, var9.saturation, var9.lightness);
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

				if (var3.field165[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method698(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field165[var5][var1][var2], var3.field166[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IILo;Lav;I)I",
		garbageValue = "23103860"
	)
	int method439(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(IILo;[Llx;I)V",
		garbageValue = "111952884"
	)
	void method463(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					int var11 = var9.decoration;
					boolean var10 = var11 >= WorldMapDecorationType.field2733.id && var11 <= WorldMapDecorationType.field2722.id;
					if (!var10) {
						int var13 = var9.decoration;
						boolean var12 = var13 == WorldMapDecorationType.field2741.id;
						if (!var12) {
							continue;
						}
					}

					ObjectDefinition var14 = ViewportMouse.getObjectDefinition(var9.objectDefinitionId);
					if (var14.mapSceneId != -1) {
						if (var14.mapSceneId != 46 && var14.mapSceneId != 52) {
							var4[var14.mapSceneId].method6093(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
						} else {
							var4[var14.mapSceneId].method6093(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IILo;S)V",
		garbageValue = "4754"
	)
	void method472(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					int var10 = var8.decoration;
					boolean var9 = var10 >= WorldMapDecorationType.field2725.id && var10 <= WorldMapDecorationType.field2721.id || var10 == WorldMapDecorationType.field2739.id;
					if (var9) {
						ObjectDefinition var11 = ViewportMouse.getObjectDefinition(var8.objectDefinitionId);
						int var12 = var11.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field2725.id) {
							this.method454(var1, var2, var8.rotation, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2720.id) {
							this.method454(var1, var2, var8.rotation, -3355444);
							this.method454(var1, var2, var8.rotation + 1, var12);
						}

						if (var8.decoration == WorldMapDecorationType.field2721.id) {
							if (var8.rotation == 0) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var12);
							}

							if (var8.rotation == 1) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), 1, var12);
							}

							if (var8.rotation == 2) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
							}

							if (var8.rotation == 3) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
							}
						}

						if (var8.decoration == WorldMapDecorationType.field2739.id) {
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

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "-1887424608"
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
				WorldMapElement var13 = class222.getWorldMapElement(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method445(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Ljava/util/HashSet;IIB)V",
		garbageValue = "-45"
	)
	void method443(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = class222.getWorldMapElement(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.method493(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Liw;IIIIB)V",
		garbageValue = "14"
	)
	void method493(WorldMapElement var1, int var2, int var3, int var4, int var5) {
		Sprite var6 = var1.getSpriteBool(false);
		if (var6 != null) {
			var6.drawAt2(var2 - var6.subWidth / 2, var3 - var6.subHeight / 2);
			if (var4 % var5 < var5 / 2) {
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 15, 16776960, 128);
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 7, 16777215, 256);
			}

		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(Laz;IIFB)V",
		garbageValue = "-89"
	)
	void method445(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = class222.getWorldMapElement(var1.getElement());
		this.method446(var5, var2, var3);
		this.method447(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Liw;III)V",
		garbageValue = "1065739105"
	)
	void method446(WorldMapElement var1, int var2, int var3) {
		Sprite var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method455(var4, var1.horizontalAlignment);
			int var6 = this.method450(var4, var1.verticalAlignment);
			var4.drawAt2(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Laz;Liw;IIFI)V",
		garbageValue = "-1918014118"
	)
	void method447(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method184(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field3217, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(IILjava/util/HashSet;II)V",
		garbageValue = "1861626297"
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
					this.method445(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Lly;Liz;I)I",
		garbageValue = "406251697"
	)
	int method455(Sprite var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 2:
			return -var1.subWidth / 2;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Lly;Lif;B)I",
		garbageValue = "36"
	)
	int method450(Sprite var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 0:
			return -var1.subHeight / 2;
		case 1:
			return 0;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(II)Las;",
		garbageValue = "1732767815"
	)
	WorldMapLabel method502(int var1) {
		WorldMapElement var2 = class222.getWorldMapElement(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(Liw;I)Las;",
		garbageValue = "1686665284"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			WorldMapLabelSize var2 = WorldMapLabelSize.method177(var1.textSize);
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
		garbageValue = "-1946741699"
	)
	List method440(int var1, int var2, int var3, int var4, int var5) {
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(B)Ljava/util/List;",
		garbageValue = "37"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-255594504"
	)
	void method454(int var1, int var2, int var3, int var4) {
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILhp;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "-2137956496"
	)
	public static void method533(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.getGroupId(var2);
		int var7 = var1.getFileId(var6, var3);
		class197.field2402 = 1;
		GrandExchangeOfferNameComparator.musicTrackArchive = var1;
		class197.musicTrackGroupId = var6;
		class197.musicTrackFileId = var7;
		ScriptFrame.field529 = var4;
		BuddyRankComparator.musicTrackBoolean = var5;
		class197.field2404 = var0;
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "878790252"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.size * 784322703 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = Tile.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.drawEntity(class42.plane, var2.x, var2.y, ScriptEvent.getTileHeight(var2.size * -1342954560 - 64 + var2.x, var2.size * -1342954560 - 64 + var2.y, class42.plane), var2.size * -1342954560 - 64 + 60, var2, var2.field950, var5, var2.field967);
				}
			}
		}

	}
}

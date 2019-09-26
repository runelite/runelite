import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapManager")
public final class WorldMapManager {
	@ObfuscatedName("ai")
	@Export("null_string")
	protected static String null_string;
	@ObfuscatedName("z")
	@Export("loaded")
	boolean loaded;
	@ObfuscatedName("n")
	@Export("loadStarted")
	boolean loadStarted;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	@Export("mapAreaData")
	WorldMapAreaData mapAreaData;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("compositeTextureSprite")
	Sprite compositeTextureSprite;
	@ObfuscatedName("r")
	@Export("icons")
	HashMap icons;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[[Laa;"
	)
	@Export("regions")
	WorldMapRegion[][] regions;
	@ObfuscatedName("q")
	HashMap field301;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("geographyArchive")
	final AbstractArchive geographyArchive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("groundArchive")
	final AbstractArchive groundArchive;
	@ObfuscatedName("c")
	@Export("fonts")
	final HashMap fonts;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -753174201
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 16562041
	)
	@Export("tileY")
	int tileY;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2004318801
	)
	@Export("tileWidth")
	int tileWidth;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -933992128
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1390818345
	)
	@Export("pixelsPerTile")
	public int pixelsPerTile;

	@ObfuscatedSignature(
		signature = "([Llp;Ljava/util/HashMap;Lhp;Lhp;)V"
	)
	public WorldMapManager(IndexedSprite[] var1, HashMap var2, AbstractArchive var3, AbstractArchive var4) {
		this.loaded = false;
		this.loadStarted = false;
		this.field301 = new HashMap();
		this.pixelsPerTile = 0;
		this.mapSceneSprites = var1;
		this.fonts = var2;
		this.geographyArchive = var3;
		this.groundArchive = var4;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Ljava/lang/String;ZS)V",
		garbageValue = "8475"
	)
	@Export("load")
	public void load(AbstractArchive var1, String var2, boolean var3) {
		if (!this.loadStarted) {
			this.loaded = false;
			this.loadStarted = true;
			System.nanoTime();
			int var4 = var1.getGroupId(WorldMapCacheName.field284.name);
			int var5 = var1.getFileId(var4, var2);
			Buffer var6 = new Buffer(var1.takeFileByNames(WorldMapCacheName.field284.name, var2));
			Buffer var7 = new Buffer(var1.takeFileByNames(WorldMapCacheName.field289.name, var2));
			System.nanoTime();
			System.nanoTime();
			this.mapAreaData = new WorldMapAreaData();

			try {
				this.mapAreaData.init(var6, var7, var5, var3);
			} catch (IllegalStateException var19) {
				return;
			}

			this.mapAreaData.getOriginX();
			this.mapAreaData.getOriginPlane();
			this.mapAreaData.getOriginY();
			this.tileX = this.mapAreaData.getRegionLowX() * 64;
			this.tileY = this.mapAreaData.getRegionLowY() * 64;
			this.tileWidth = (this.mapAreaData.getRegionHighX() - this.mapAreaData.getRegionLowX() + 1) * 64;
			this.tileHeight = (this.mapAreaData.getRegionHighY() - this.mapAreaData.getRegionLowY() + 1) * 4096;
			int var16 = this.mapAreaData.getRegionHighX() - this.mapAreaData.getRegionLowX() + 1;
			int var9 = this.mapAreaData.getRegionHighY() - this.mapAreaData.getRegionLowY() + 1;
			System.nanoTime();
			System.nanoTime();
			class3.WorldMapRegion_clearCachedSprites();
			this.regions = new WorldMapRegion[var16][var9];
			Iterator var10 = this.mapAreaData.worldMapData0Set.iterator();

			while (var10.hasNext()) {
				WorldMapData_0 var11 = (WorldMapData_0)var10.next();
				int var12 = var11.regionX;
				int var13 = var11.regionY;
				int var14 = var12 - this.mapAreaData.getRegionLowX();
				int var15 = var13 - this.mapAreaData.getRegionLowY();
				this.regions[var14][var15] = new WorldMapRegion(var12, var13, this.mapAreaData.getBackGroundColor(), this.fonts);
				this.regions[var14][var15].initWorldMapData0(var11, this.mapAreaData.iconList);
			}

			for (int var17 = 0; var17 < var16; ++var17) {
				for (int var18 = 0; var18 < var9; ++var18) {
					if (this.regions[var17][var18] == null) {
						this.regions[var17][var18] = new WorldMapRegion(this.mapAreaData.getRegionLowX() + var17, this.mapAreaData.getRegionLowY() + var18, this.mapAreaData.getBackGroundColor(), this.fonts);
						this.regions[var17][var18].initWorldMapData1(this.mapAreaData.worldMapData1Set, this.mapAreaData.iconList);
					}
				}
			}

			System.nanoTime();
			System.nanoTime();
			if (var1.isValidFileName(WorldMapCacheName.field283.name, var2)) {
				byte[] var20 = var1.takeFileByNames(WorldMapCacheName.field283.name, var2);
				this.compositeTextureSprite = class40.convertJpgToSprite(var20);
			}

			System.nanoTime();
			var1.clearGroups();
			var1.clearFiles();
			this.loaded = true;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1715469054"
	)
	@Export("clearIcons")
	public final void clearIcons() {
		this.icons = null;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-99829048"
	)
	@Export("drawTiles")
	public final void drawTiles(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int[] var9 = Rasterizer2D.Rasterizer2D_pixels;
		int var10 = Rasterizer2D.Rasterizer2D_width;
		int var11 = Rasterizer2D.Rasterizer2D_height;
		int[] var12 = new int[4];
		Rasterizer2D.Rasterizer2D_getClipArray(var12);
		WorldMapRectangle var13 = this.createWorldMapRectangle(var1, var2, var3, var4);
		float var14 = this.getPixelsPerTile(var7 - var5, var3 - var1);
		int var15 = (int)Math.ceil((double)var14);
		this.pixelsPerTile = var15;
		if (!this.field301.containsKey(var15)) {
			class40 var16 = new class40(var15);
			var16.init();
			this.field301.put(var15, var16);
		}

		int var23 = var13.width + var13.x - 1;
		int var17 = var13.y + var13.height - 1;

		int var18;
		int var19;
		for (var18 = var13.x; var18 <= var23; ++var18) {
			for (var19 = var13.y; var19 <= var17; ++var19) {
				this.regions[var18][var19].drawTile(var15, (class40)this.field301.get(var15), this.mapSceneSprites, this.geographyArchive, this.groundArchive);
			}
		}

		Rasterizer2D.Rasterizer2D_replace(var9, var10, var11);
		Rasterizer2D.Rasterizer2D_setClipArray(var12);
		var18 = (int)(var14 * 64.0F);
		var19 = this.tileX * 4096 + var1;
		int var20 = this.tileY * 4096 + var2;

		for (int var21 = var13.x; var21 < var13.width + var13.x; ++var21) {
			for (int var22 = var13.y; var22 < var13.y + var13.height; ++var22) {
				this.regions[var21][var22].method441(var5 + var18 * (this.regions[var21][var22].regionX * 64 - var19) / 64, var8 - var18 * (this.regions[var21][var22].regionY * 64 - var20 + 64) / 64, var18);
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
		garbageValue = "-1410717760"
	)
	@Export("drawElements")
	public final void drawElements(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
		WorldMapRectangle var14 = this.createWorldMapRectangle(var1, var2, var3, var4);
		float var15 = this.getPixelsPerTile(var7 - var5, var3 - var1);
		int var16 = (int)(64.0F * var15);
		int var17 = this.tileX * 4096 + var1;
		int var18 = this.tileY * 4096 + var2;

		int var19;
		int var20;
		for (var19 = var14.x; var19 < var14.x + var14.width; ++var19) {
			for (var20 = var14.y; var20 < var14.y + var14.height; ++var20) {
				if (var13) {
					this.regions[var19][var20].initWorldMapIcon1s();
				}

				this.regions[var19][var20].method451(var5 + var16 * (this.regions[var19][var20].regionX * 64 - var17) / 64, var8 - var16 * (this.regions[var19][var20].regionY * 64 - var18 + 64) / 64, var16, var9);
			}
		}

		if (var10 != null && var11 > 0) {
			for (var19 = var14.x; var19 < var14.x + var14.width; ++var19) {
				for (var20 = var14.y; var20 < var14.height + var14.y; ++var20) {
					this.regions[var19][var20].flashElements(var10, var11, var12);
				}
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIIILjava/util/HashSet;IIB)V",
		garbageValue = "-113"
	)
	@Export("drawOverview")
	public void drawOverview(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
		if (this.compositeTextureSprite != null) {
			this.compositeTextureSprite.drawScaledAt(var1, var2, var3, var4);
			if (var6 > 0 && var6 % var7 < var7 / 2) {
				if (this.icons == null) {
					this.buildIcons0();
				}

				Iterator var8 = var5.iterator();

				while (true) {
					List var10;
					do {
						if (!var8.hasNext()) {
							return;
						}

						int var9 = (Integer)var8.next();
						var10 = (List)this.icons.get(var9);
					} while(var10 == null);

					Iterator var11 = var10.iterator();

					while (var11.hasNext()) {
						AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var11.next();
						int var13 = var3 * (var12.coord2.x - this.tileX * 4096) / (this.tileWidth * 4096);
						int var14 = var4 - (var12.coord2.y - this.tileY * 4096) * var4 / (this.tileHeight * 64);
						Rasterizer2D.Rasterizer2D_drawCircleAlpha(var13 + var1, var14 + var2, 2, 16776960, 256);
					}
				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIIII)Ljava/util/List;",
		garbageValue = "642627718"
	)
	public List method664(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		LinkedList var11 = new LinkedList();
		if (!this.loaded) {
			return var11;
		} else {
			WorldMapRectangle var12 = this.createWorldMapRectangle(var1, var2, var3, var4);
			float var13 = this.getPixelsPerTile(var7, var3 - var1);
			int var14 = (int)(var13 * 64.0F);
			int var15 = this.tileX * 4096 + var1;
			int var16 = this.tileY * 4096 + var2;

			for (int var17 = var12.x; var17 < var12.x + var12.width; ++var17) {
				for (int var18 = var12.y; var18 < var12.y + var12.height; ++var18) {
					List var19 = this.regions[var17][var18].method472(var5 + var14 * (this.regions[var17][var18].regionX * 64 - var15) / 64, var8 + var6 - var14 * (this.regions[var17][var18].regionY * 64 - var16 + 64) / 64, var14, var9, var10);
					if (!var19.isEmpty()) {
						var11.addAll(var19);
					}
				}
			}

			return var11;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIII)Lj;",
		garbageValue = "1969728750"
	)
	@Export("createWorldMapRectangle")
	WorldMapRectangle createWorldMapRectangle(int var1, int var2, int var3, int var4) {
		WorldMapRectangle var5 = new WorldMapRectangle(this);
		int var6 = this.tileX * 4096 + var1;
		int var7 = this.tileY * 4096 + var2;
		int var8 = var3 + this.tileX * 4096;
		int var9 = this.tileY * 4096 + var4;
		int var10 = var6 / 64;
		int var11 = var7 / 64;
		int var12 = var8 / 64;
		int var13 = var9 / 64;
		var5.width = var12 - var10 + 1;
		var5.height = var13 - var11 + 1;
		var5.x = var10 - this.mapAreaData.getRegionLowX();
		var5.y = var11 - this.mapAreaData.getRegionLowY();
		if (var5.x < 0) {
			var5.width += var5.x;
			var5.x = 0;
		}

		if (var5.x > this.regions.length - var5.width) {
			var5.width = this.regions.length - var5.x;
		}

		if (var5.y < 0) {
			var5.height += var5.y;
			var5.y = 0;
		}

		if (var5.y > this.regions[0].length - var5.height) {
			var5.height = this.regions[0].length - var5.y;
		}

		var5.width = Math.min(var5.width, this.regions.length);
		var5.height = Math.min(var5.height, this.regions[0].length);
		return var5;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1274702917"
	)
	@Export("isLoaded")
	public boolean isLoaded() {
		return this.loaded;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Ljava/util/HashMap;",
		garbageValue = "1690655537"
	)
	@Export("buildIcons")
	public HashMap buildIcons() {
		this.buildIcons0();
		return this.icons;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-273211151"
	)
	@Export("buildIcons0")
	void buildIcons0() {
		if (this.icons == null) {
			this.icons = new HashMap();
		}

		this.icons.clear();

		for (int var1 = 0; var1 < this.regions.length; ++var1) {
			for (int var2 = 0; var2 < this.regions[var1].length; ++var2) {
				List var3 = this.regions[var1][var2].icons();
				Iterator var4 = var3.iterator();

				while (var4.hasNext()) {
					AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
					if (var5.hasValidElement()) {
						int var6 = var5.getElement();
						if (!this.icons.containsKey(var6)) {
							LinkedList var7 = new LinkedList();
							var7.add(var5);
							this.icons.put(var6, var7);
						} else {
							List var8 = (List)this.icons.get(var6);
							var8.add(var5);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)F",
		garbageValue = "-1120188290"
	)
	@Export("getPixelsPerTile")
	float getPixelsPerTile(int var1, int var2) {
		float var3 = (float)var1 / (float)var2;
		if (var3 > 8.0F) {
			return 8.0F;
		} else if (var3 < 1.0F) {
			return 1.0F;
		} else {
			int var4 = Math.round(var3);
			return Math.abs((float)var4 - var3) < 0.05F ? (float)var4 : var3;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "74"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		int var3 = 0;
		var0.importIndex();

		int var4;
		int var5;
		int var6;
		int var8;
		int var9;
		byte[] var10000;
		for (var4 = 0; var4 < Players.Players_count; ++var4) {
			var5 = Players.Players_indices[var4];
			if ((Players.field1244[var5] & 1) == 0) {
				if (var3 > 0) {
					--var3;
					var10000 = Players.field1244;
					var10000[var5] = (byte)(var10000[var5] | 2);
				} else {
					var6 = var0.readBits(1);
					if (var6 == 0) {
						var8 = var0.readBits(2);
						if (var8 == 0) {
							var9 = 0;
						} else if (var8 == 1) {
							var9 = var0.readBits(5);
						} else if (var8 == 2) {
							var9 = var0.readBits(8);
						} else {
							var9 = var0.readBits(11);
						}

						var3 = var9;
						var10000 = Players.field1244;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						UrlRequest.readPlayerUpdate(var0, var5);
					}
				}
			}
		}

		var0.exportIndex();
		if (var3 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var4 = 0; var4 < Players.Players_count; ++var4) {
				var5 = Players.Players_indices[var4];
				if ((Players.field1244[var5] & 1) != 0) {
					if (var3 > 0) {
						--var3;
						var10000 = Players.field1244;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						var6 = var0.readBits(1);
						if (var6 == 0) {
							var8 = var0.readBits(2);
							if (var8 == 0) {
								var9 = 0;
							} else if (var8 == 1) {
								var9 = var0.readBits(5);
							} else if (var8 == 2) {
								var9 = var0.readBits(8);
							} else {
								var9 = var0.readBits(11);
							}

							var3 = var9;
							var10000 = Players.field1244;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							UrlRequest.readPlayerUpdate(var0, var5);
						}
					}
				}
			}

			var0.exportIndex();
			if (var3 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
					var5 = Players.Players_emptyIndices[var4];
					if ((Players.field1244[var5] & 1) != 0) {
						if (var3 > 0) {
							--var3;
							var10000 = Players.field1244;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							var6 = var0.readBits(1);
							if (var6 == 0) {
								var8 = var0.readBits(2);
								if (var8 == 0) {
									var9 = 0;
								} else if (var8 == 1) {
									var9 = var0.readBits(5);
								} else if (var8 == 2) {
									var9 = var0.readBits(8);
								} else {
									var9 = var0.readBits(11);
								}

								var3 = var9;
								var10000 = Players.field1244;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else if (class290.updateExternalPlayer(var0, var5)) {
								var10000 = Players.field1244;
								var10000[var5] = (byte)(var10000[var5] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var3 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
						var5 = Players.Players_emptyIndices[var4];
						if ((Players.field1244[var5] & 1) == 0) {
							if (var3 > 0) {
								--var3;
								var10000 = Players.field1244;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else {
								var6 = var0.readBits(1);
								if (var6 == 0) {
									var8 = var0.readBits(2);
									if (var8 == 0) {
										var9 = 0;
									} else if (var8 == 1) {
										var9 = var0.readBits(5);
									} else if (var8 == 2) {
										var9 = var0.readBits(8);
									} else {
										var9 = var0.readBits(11);
									}

									var3 = var9;
									var10000 = Players.field1244;
									var10000[var5] = (byte)(var10000[var5] | 2);
								} else if (class290.updateExternalPlayer(var0, var5)) {
									var10000 = Players.field1244;
									var10000[var5] = (byte)(var10000[var5] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var3 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						Player var16;
						for (var4 = 1; var4 < 2048; ++var4) {
							var10000 = Players.field1244;
							var10000[var4] = (byte)(var10000[var4] >> 1);
							var16 = Client.players[var4];
							if (var16 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var4;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var4;
							}
						}

						for (var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
							var4 = Players.Players_pendingUpdateIndices[var3];
							var16 = Client.players[var4];
							var6 = var0.readUnsignedByte();
							if ((var6 & 1) != 0) {
								var6 += var0.readUnsignedByte() << 8;
							}

							byte var7 = -1;
							if ((var6 & 256) != 0) {
								for (var8 = 0; var8 < 3; ++var8) {
									var16.actions[var8] = var0.readStringCp1252NullTerminated();
								}
							}

							if ((var6 & 2048) != 0) {
								var16.spotAnimation = var0.readUnsignedShort();
								var8 = var0.readInt();
								var16.heightOffset = var8 >> 16;
								var16.field969 = (var8 & 65535) + Client.cycle;
								var16.spotAnimationFrame = 0;
								var16.spotAnimationFrameCycle = 0;
								if (var16.field969 > Client.cycle) {
									var16.spotAnimationFrame = -1;
								}

								if (var16.spotAnimation == 65535) {
									var16.spotAnimation = -1;
								}
							}

							if ((var6 & 2) != 0) {
								var16.overheadText = var0.readStringCp1252NullTerminated();
								if (var16.overheadText.charAt(0) == '~') {
									var16.overheadText = var16.overheadText.substring(1);
									class210.addGameMessage(2, var16.username.getName(), var16.overheadText);
								} else if (var16 == class223.localPlayer) {
									class210.addGameMessage(2, var16.username.getName(), var16.overheadText);
								}

								var16.isAutoChatting = false;
								var16.overheadTextColor = 0;
								var16.overheadTextEffect = 0;
								var16.overheadTextCyclesRemaining = 150;
							}

							if ((var6 & 8) != 0) {
								var8 = var0.method5456();
								byte[] var17 = new byte[var8];
								Buffer var10 = new Buffer(var17);
								var0.method5479(var17, 0, var8);
								Players.field1236[var4] = var10;
								var16.read(var10);
							}

							int var11;
							int var12;
							int var15;
							if ((var6 & 128) != 0) {
								var8 = var0.readUnsignedShort();
								PlayerType var22 = (PlayerType)NetSocket.findEnumerated(class226.PlayerType_values(), var0.readUnsignedByte());
								boolean var18 = var0.method5456() == 1;
								var11 = var0.method5456();
								var12 = var0.offset;
								if (var16.username != null && var16.appearance != null) {
									boolean var13 = false;
									if (var22.isUser && Tiles.friendSystem.isIgnored(var16.username)) {
										var13 = true;
									}

									if (!var13 && Client.field634 == 0 && !var16.isHidden) {
										Players.field1246.offset = 0;
										var0.method5478(Players.field1246.array, 0, var11);
										Players.field1246.offset = 0;
										String var14 = AbstractFont.escapeBrackets(NetSocket.method3467(class65.method1250(Players.field1246)));
										var16.overheadText = var14.trim();
										var16.overheadTextColor = var8 >> 8;
										var16.overheadTextEffect = var8 & 255;
										var16.overheadTextCyclesRemaining = 150;
										var16.isAutoChatting = var18;
										var16.field944 = var16 != class223.localPlayer && var22.isUser && "" != Client.field907 && var14.toLowerCase().indexOf(Client.field907) == -1;
										if (var22.isPrivileged) {
											var15 = var18 ? 91 : 1;
										} else {
											var15 = var18 ? 90 : 2;
										}

										if (var22.modIcon != -1) {
											class210.addGameMessage(var15, class247.method4443(var22.modIcon) + var16.username.getName(), var14);
										} else {
											class210.addGameMessage(var15, var16.username.getName(), var14);
										}
									}
								}

								var0.offset = var11 + var12;
							}

							if ((var6 & 4096) != 0) {
								Players.field1235[var4] = var0.readByte();
							}

							if ((var6 & 16) != 0) {
								var8 = var0.method5632();
								if (var8 == 65535) {
									var8 = -1;
								}

								var9 = var0.readUnsignedByte();
								LoginPacket.performPlayerAnimation(var16, var8, var9);
							}

							if ((var6 & 512) != 0) {
								var7 = var0.readByte();
							}

							if ((var6 & 1024) != 0) {
								var16.field971 = var0.method5458();
								var16.field973 = var0.method5460();
								var16.field972 = var0.method5458();
								var16.field974 = var0.method5458();
								var16.field948 = var0.readUnsignedShort() + Client.cycle;
								var16.field976 = var0.method5632() + Client.cycle;
								var16.field977 = var0.method5465();
								if (var16.field621) {
									var16.field971 += var16.tileX;
									var16.field973 += var16.tileY;
									var16.field972 += var16.tileX;
									var16.field974 += var16.tileY;
									var16.pathLength = 0;
								} else {
									var16.field971 += var16.pathX[0];
									var16.field973 += var16.pathY[0];
									var16.field972 += var16.pathX[0];
									var16.field974 += var16.pathY[0];
									var16.pathLength = 1;
								}

								var16.field988 = 0;
							}

							if ((var6 & 4) != 0) {
								var8 = var0.method5455();
								int var19;
								int var21;
								int var23;
								if (var8 > 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var11 = -1;
										var12 = -1;
										var21 = -1;
										var23 = var0.readUShortSmart();
										if (var23 == 32767) {
											var23 = var0.readUShortSmart();
											var12 = var0.readUShortSmart();
											var11 = var0.readUShortSmart();
											var21 = var0.readUShortSmart();
										} else if (var23 != 32766) {
											var12 = var0.readUShortSmart();
										} else {
											var23 = -1;
										}

										var19 = var0.readUShortSmart();
										var16.addHitSplat(var23, var12, var11, var21, Client.cycle, var19);
									}
								}

								var9 = var0.method5496();
								if (var9 > 0) {
									for (var23 = 0; var23 < var9; ++var23) {
										var11 = var0.readUShortSmart();
										var12 = var0.readUShortSmart();
										if (var12 != 32767) {
											var21 = var0.readUShortSmart();
											var19 = var0.method5455();
											var15 = var12 > 0 ? var0.method5455() : var19;
											var16.addHealthBar(var11, Client.cycle, var12, var21, var19, var15);
										} else {
											var16.removeHealthBar(var11);
										}
									}
								}
							}

							if ((var6 & 64) != 0) {
								var16.targetIndex = var0.method5632();
								if (var16.targetIndex == 65535) {
									var16.targetIndex = -1;
								}
							}

							if ((var6 & 32) != 0) {
								var16.field957 = var0.readUnsignedShort();
								if (var16.pathLength == 0) {
									var16.orientation = var16.field957;
									var16.field957 = -1;
								}
							}

							if (var16.field621) {
								if (var7 == 127) {
									var16.resetPath(var16.tileX, var16.tileY);
								} else {
									byte var20;
									if (var7 != -1) {
										var20 = var7;
									} else {
										var20 = Players.field1235[var4];
									}

									var16.method1274(var16.tileX, var16.tileY, var20);
								}
							}
						}

						if (var0.offset - var2 != var1) {
							throw new RuntimeException(var0.offset - var2 + " " + var1);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
		garbageValue = "4"
	)
	static String method685(Throwable var0) throws IOException {
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

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "938839327"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (WorldMapData_0.loadInterface(var0)) {
			Widget[] var1 = UserComparator5.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "(IIII)Lbk;",
		garbageValue = "1688623868"
	)
	static final InterfaceParent method679(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		Widget_resetModelFrames(var1);
		Widget var4 = Canvas.getWidget(var0);
		WorldMapSectionType.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			WorldMapSectionType.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		SecureRandomFuture.method2134();
		GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var0 >> 16], var4, false);
		class186.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			class40.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}

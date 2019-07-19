import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Scene")
public class Scene {
	@ObfuscatedName("q")
	@Export("Scene_isLowDetail")
	public static boolean Scene_isLowDetail;
	@ObfuscatedName("v")
	@Export("tileUpdateCount")
	static int tileUpdateCount;
	@ObfuscatedName("y")
	@Export("Scene_plane")
	static int Scene_plane;
	@ObfuscatedName("g")
	@Export("Scene_drawnCount")
	static int Scene_drawnCount;
	@ObfuscatedName("a")
	@Export("Scene_cameraXTileMin")
	static int Scene_cameraXTileMin;
	@ObfuscatedName("j")
	@Export("Scene_cameraXTileMax")
	static int Scene_cameraXTileMax;
	@ObfuscatedName("t")
	@Export("Scene_cameraYTileMin")
	static int Scene_cameraYTileMin;
	@ObfuscatedName("h")
	@Export("Scene_cameraYTileMax")
	static int Scene_cameraYTileMax;
	@ObfuscatedName("o")
	@Export("Scene_cameraXTile")
	static int Scene_cameraXTile;
	@ObfuscatedName("n")
	@Export("Scene_cameraYTile")
	static int Scene_cameraYTile;
	@ObfuscatedName("d")
	@Export("Scene_cameraX")
	static int Scene_cameraX;
	@ObfuscatedName("s")
	@Export("Scene_cameraY")
	static int Scene_cameraY;
	@ObfuscatedName("z")
	@Export("Scene_cameraZ")
	static int Scene_cameraZ;
	@ObfuscatedName("al")
	@Export("Scene_cameraPitchSine")
	static int Scene_cameraPitchSine;
	@ObfuscatedName("av")
	@Export("Scene_cameraPitchCosine")
	static int Scene_cameraPitchCosine;
	@ObfuscatedName("as")
	@Export("Scene_cameraYawSine")
	static int Scene_cameraYawSine;
	@ObfuscatedName("aw")
	@Export("Scene_cameraYawCosine")
	static int Scene_cameraYawCosine;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "[Les;"
	)
	@Export("gameObjects")
	static GameObject[] gameObjects;
	@ObfuscatedName("ag")
	@Export("checkClick")
	static boolean checkClick;
	@ObfuscatedName("ar")
	@Export("Scene_selectedPlane")
	static int Scene_selectedPlane;
	@ObfuscatedName("ax")
	@Export("Scene_selectedScreenX")
	static int Scene_selectedScreenX;
	@ObfuscatedName("az")
	@Export("Scene_selectedScreenY")
	static int Scene_selectedScreenY;
	@ObfuscatedName("ae")
	@Export("Scene_selectedX")
	public static int Scene_selectedX;
	@ObfuscatedName("ao")
	@Export("Scene_selectedY")
	public static int Scene_selectedY;
	@ObfuscatedName("aj")
	@Export("viewportWalking")
	static boolean viewportWalking;
	@ObfuscatedName("ap")
	@Export("Scene_planesCount")
	static int Scene_planesCount;
	@ObfuscatedName("aq")
	@Export("Scene_planeOccluderCounts")
	static int[] Scene_planeOccluderCounts;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "[[Leg;"
	)
	@Export("Scene_planeOccluders")
	static Occluder[][] Scene_planeOccluders;
	@ObfuscatedName("an")
	@Export("Scene_currentOccludersCount")
	static int Scene_currentOccludersCount;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "[Leg;"
	)
	@Export("Scene_currentOccluders")
	static Occluder[] Scene_currentOccluders;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("Scene_tilesDeque")
	static NodeDeque Scene_tilesDeque;
	@ObfuscatedName("ak")
	static final int[] field1847;
	@ObfuscatedName("ah")
	static final int[] field1815;
	@ObfuscatedName("am")
	static final int[] field1809;
	@ObfuscatedName("ay")
	static final int[] field1844;
	@ObfuscatedName("af")
	static final int[] field1828;
	@ObfuscatedName("ab")
	static final int[] field1852;
	@ObfuscatedName("bp")
	static final int[] field1842;
	@ObfuscatedName("bc")
	@Export("visibilityMap")
	static boolean[][][][] visibilityMap;
	@ObfuscatedName("bx")
	@Export("visibleTiles")
	static boolean[][] visibleTiles;
	@ObfuscatedName("bo")
	@Export("Scene_viewportXCenter")
	static int Scene_viewportXCenter;
	@ObfuscatedName("bb")
	@Export("Scene_viewportYCenter")
	static int Scene_viewportYCenter;
	@ObfuscatedName("bs")
	@Export("Scene_viewportXMin")
	static int Scene_viewportXMin;
	@ObfuscatedName("bj")
	@Export("Scene_viewportYMin")
	static int Scene_viewportYMin;
	@ObfuscatedName("bl")
	@Export("Scene_viewportXMax")
	static int Scene_viewportXMax;
	@ObfuscatedName("bd")
	@Export("Scene_viewportYMax")
	static int Scene_viewportYMax;
	@ObfuscatedName("w")
	@Export("planes")
	int planes;
	@ObfuscatedName("e")
	@Export("xSize")
	int xSize;
	@ObfuscatedName("p")
	@Export("ySize")
	int ySize;
	@ObfuscatedName("k")
	@Export("tileHeights")
	int[][][] tileHeights;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "[[[Ldv;"
	)
	@Export("tiles")
	Tile[][][] tiles;
	@ObfuscatedName("b")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("i")
	@Export("tempGameObjectsCount")
	int tempGameObjectsCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Les;"
	)
	@Export("tempGameObjects")
	GameObject[] tempGameObjects;
	@ObfuscatedName("f")
	int[][][] field1810;
	@ObfuscatedName("bm")
	@Export("tileShape2D")
	int[][] tileShape2D;
	@ObfuscatedName("bn")
	@Export("tileRotation2D")
	int[][] tileRotation2D;

	static {
		Scene_isLowDetail = true;
		tileUpdateCount = 0;
		Scene_plane = 0;
		gameObjects = new GameObject[100];
		checkClick = false;
		Scene_selectedPlane = 0;
		Scene_selectedScreenX = 0;
		Scene_selectedScreenY = 0;
		Scene_selectedX = -1;
		Scene_selectedY = -1;
		viewportWalking = false;
		Scene_planesCount = 4;
		Scene_planeOccluderCounts = new int[Scene_planesCount];
		Scene_planeOccluders = new Occluder[Scene_planesCount][500];
		Scene_currentOccludersCount = 0;
		Scene_currentOccluders = new Occluder[500];
		Scene_tilesDeque = new NodeDeque();
		field1847 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
		field1815 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
		field1809 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
		field1844 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
		field1828 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
		field1852 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
		field1842 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
		visibilityMap = new boolean[8][32][51][51];
	}

	public Scene(int var1, int var2, int var3, int[][][] var4) {
		this.minPlane = 0;
		this.tempGameObjectsCount = 0;
		this.tempGameObjects = new GameObject[5000];
		this.tileShape2D = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
		this.tileRotation2D = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
		this.planes = var1;
		this.xSize = var2;
		this.ySize = var3;
		this.tiles = new Tile[var1][var2][var3];
		this.field1810 = new int[var1][var2 + 1][var3 + 1];
		this.tileHeights = var4;
		this.clear();
	}

	@ObfuscatedName("q")
	@Export("clear")
	public void clear() {
		int var1;
		int var2;
		for (var1 = 0; var1 < this.planes; ++var1) {
			for (var2 = 0; var2 < this.xSize; ++var2) {
				for (int var3 = 0; var3 < this.ySize; ++var3) {
					this.tiles[var1][var2][var3] = null;
				}
			}
		}

		for (var1 = 0; var1 < Scene_planesCount; ++var1) {
			for (var2 = 0; var2 < Scene_planeOccluderCounts[var1]; ++var2) {
				Scene_planeOccluders[var1][var2] = null;
			}

			Scene_planeOccluderCounts[var1] = 0;
		}

		for (var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
			this.tempGameObjects[var1] = null;
		}

		this.tempGameObjectsCount = 0;

		for (var1 = 0; var1 < gameObjects.length; ++var1) {
			gameObjects[var1] = null;
		}

	}

	@ObfuscatedName("w")
	@Export("init")
	public void init(int var1) {
		this.minPlane = var1;

		for (int var2 = 0; var2 < this.xSize; ++var2) {
			for (int var3 = 0; var3 < this.ySize; ++var3) {
				if (this.tiles[var1][var2][var3] == null) {
					this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("e")
	@Export("setLinkBelow")
	public void setLinkBelow(int var1, int var2) {
		Tile var3 = this.tiles[0][var1][var2];

		for (int var4 = 0; var4 < 3; ++var4) {
			Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
			if (var5 != null) {
				--var5.plane;

				for (int var6 = 0; var6 < var5.gameObjectsCount; ++var6) {
					GameObject var7 = var5.gameObjects[var6];
					long var9 = var7.tag;
					boolean var8 = WorldMapLabel.method420(var9) == 2;
					if (var8 && var7.startX == var1 && var2 == var7.startY) {
						--var7.plane;
					}
				}
			}
		}

		if (this.tiles[0][var1][var2] == null) {
			this.tiles[0][var1][var2] = new Tile(0, var1, var2);
		}

		this.tiles[0][var1][var2].linkedBelowTile = var3;
		this.tiles[3][var1][var2] = null;
	}

	@ObfuscatedName("k")
	@Export("setTileMinPlane")
	public void setTileMinPlane(int var1, int var2, int var3, int var4) {
		Tile var5 = this.tiles[var1][var2][var3];
		if (var5 != null) {
			this.tiles[var1][var2][var3].minPlane = var4;
		}
	}

	@ObfuscatedName("l")
	@Export("addTile")
	public void addTile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
		TilePaint var21;
		int var22;
		if (var4 == 0) {
			var21 = new TilePaint(var11, var12, var13, var14, -1, var19, false);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.tiles[var22][var2][var3] == null) {
					this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
				}
			}

			this.tiles[var1][var2][var3].paint = var21;
		} else if (var4 != 1) {
			TileModel var23 = new TileModel(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.tiles[var22][var2][var3] == null) {
					this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
				}
			}

			this.tiles[var1][var2][var3].model = var23;
		} else {
			var21 = new TilePaint(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.tiles[var22][var2][var3] == null) {
					this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
				}
			}

			this.tiles[var1][var2][var3].paint = var21;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIILeo;JI)V"
	)
	@Export("newFloorDecoration")
	public void newFloorDecoration(int var1, int var2, int var3, int var4, Entity var5, long var6, int var8) {
		if (var5 != null) {
			FloorDecoration var9 = new FloorDecoration();
			var9.entity = var5;
			var9.x = var2 * 128 + 64;
			var9.y = var3 * 128 + 64;
			var9.tileHeight = var4;
			var9.tag = var6;
			var9.flags = var8;
			if (this.tiles[var1][var2][var3] == null) {
				this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
			}

			this.tiles[var1][var2][var3].floorDecoration = var9;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIILeo;JLeo;Leo;)V"
	)
	@Export("newGroundItemPile")
	public void newGroundItemPile(int var1, int var2, int var3, int var4, Entity var5, long var6, Entity var8, Entity var9) {
		GroundItemPile var10 = new GroundItemPile();
		var10.first = var5;
		var10.x = var2 * 128 + 64;
		var10.y = var3 * 128 + 64;
		var10.tileHeight = var4;
		var10.tag = var6;
		var10.second = var8;
		var10.third = var9;
		int var11 = 0;
		Tile var12 = this.tiles[var1][var2][var3];
		if (var12 != null) {
			for (int var13 = 0; var13 < var12.gameObjectsCount; ++var13) {
				if ((var12.gameObjects[var13].flags & 256) == 256 && var12.gameObjects[var13].entity instanceof Model) {
					Model var14 = (Model)var12.gameObjects[var13].entity;
					var14.calculateBoundsCylinder();
					if (var14.height > var11) {
						var11 = var14.height;
					}
				}
			}
		}

		var10.height = var11;
		if (this.tiles[var1][var2][var3] == null) {
			this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
		}

		this.tiles[var1][var2][var3].groundItemPile = var10;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIILeo;Leo;IIJI)V"
	)
	@Export("newBoundaryObject")
	public void newBoundaryObject(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, long var9, int var11) {
		if (var5 != null || var6 != null) {
			BoundaryObject var12 = new BoundaryObject();
			var12.tag = var9;
			var12.flags = var11;
			var12.x = var2 * 128 + 64;
			var12.y = var3 * 128 + 64;
			var12.tileHeight = var4;
			var12.entity1 = var5;
			var12.entity2 = var6;
			var12.orientationA = var7;
			var12.orientationB = var8;

			for (int var13 = var1; var13 >= 0; --var13) {
				if (this.tiles[var13][var2][var3] == null) {
					this.tiles[var13][var2][var3] = new Tile(var13, var2, var3);
				}
			}

			this.tiles[var1][var2][var3].boundaryObject = var12;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIILeo;Leo;IIIIJI)V"
	)
	@Export("newWallDecoration")
	public void newWallDecoration(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long var11, int var13) {
		if (var5 != null) {
			WallDecoration var14 = new WallDecoration();
			var14.tag = var11;
			var14.flags = var13;
			var14.x = var2 * 128 + 64;
			var14.y = var3 * 128 + 64;
			var14.tileHeight = var4;
			var14.entity1 = var5;
			var14.entity2 = var6;
			var14.orientation = var7;
			var14.orientation2 = var8;
			var14.xOffset = var9;
			var14.yOffset = var10;

			for (int var15 = var1; var15 >= 0; --var15) {
				if (this.tiles[var15][var2][var3] == null) {
					this.tiles[var15][var2][var3] = new Tile(var15, var2, var3);
				}
			}

			this.tiles[var1][var2][var3].wallDecoration = var14;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIIIILeo;IJI)Z"
	)
	public boolean method3076(int var1, int var2, int var3, int var4, int var5, int var6, Entity var7, int var8, long var9, int var11) {
		if (var7 == null) {
			return true;
		} else {
			int var12 = var5 * 64 + var2 * 128;
			int var13 = var6 * 64 + var3 * 128;
			return this.newGameObject(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIIIILeo;IJZ)Z"
	)
	@Export("drawEntity")
	public boolean drawEntity(int var1, int var2, int var3, int var4, int var5, Entity var6, int var7, long var8, boolean var10) {
		if (var6 == null) {
			return true;
		} else {
			int var11 = var2 - var5;
			int var12 = var3 - var5;
			int var13 = var5 + var2;
			int var14 = var3 + var5;
			if (var10) {
				if (var7 > 640 && var7 < 1408) {
					var14 += 128;
				}

				if (var7 > 1152 && var7 < 1920) {
					var13 += 128;
				}

				if (var7 > 1664 || var7 < 384) {
					var12 -= 128;
				}

				if (var7 > 128 && var7 < 896) {
					var11 -= 128;
				}
			}

			var11 /= 128;
			var12 /= 128;
			var13 /= 128;
			var14 /= 128;
			return this.newGameObject(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIIILeo;IJIIII)Z"
	)
	public boolean method3079(int var1, int var2, int var3, int var4, int var5, Entity var6, int var7, long var8, int var10, int var11, int var12, int var13) {
		return var6 == null ? true : this.newGameObject(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIIIIIILeo;IZJI)Z"
	)
	@Export("newGameObject")
	boolean newGameObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Entity var9, int var10, boolean var11, long var12, int var14) {
		int var16;
		for (int var15 = var2; var15 < var2 + var4; ++var15) {
			for (var16 = var3; var16 < var3 + var5; ++var16) {
				if (var15 < 0 || var16 < 0 || var15 >= this.xSize || var16 >= this.ySize) {
					return false;
				}

				Tile var22 = this.tiles[var1][var15][var16];
				if (var22 != null && var22.gameObjectsCount >= 5) {
					return false;
				}
			}
		}

		GameObject var21 = new GameObject();
		var21.tag = var12;
		var21.flags = var14;
		var21.plane = var1;
		var21.centerX = var6;
		var21.centerY = var7;
		var21.height = var8;
		var21.entity = var9;
		var21.orientation = var10;
		var21.startX = var2;
		var21.startY = var3;
		var21.endX = var2 + var4 - 1;
		var21.endY = var3 + var5 - 1;

		for (var16 = var2; var16 < var2 + var4; ++var16) {
			for (int var17 = var3; var17 < var3 + var5; ++var17) {
				int var18 = 0;
				if (var16 > var2) {
					++var18;
				}

				if (var16 < var2 + var4 - 1) {
					var18 += 4;
				}

				if (var17 > var3) {
					var18 += 8;
				}

				if (var17 < var3 + var5 - 1) {
					var18 += 2;
				}

				for (int var19 = var1; var19 >= 0; --var19) {
					if (this.tiles[var19][var16][var17] == null) {
						this.tiles[var19][var16][var17] = new Tile(var19, var16, var17);
					}
				}

				Tile var23 = this.tiles[var1][var16][var17];
				var23.gameObjects[var23.gameObjectsCount] = var21;
				var23.gameObjectEdgeMasks[var23.gameObjectsCount] = var18;
				var23.gameObjectsEdgeMask |= var18;
				++var23.gameObjectsCount;
			}
		}

		if (var11) {
			this.tempGameObjects[this.tempGameObjectsCount++] = var21;
		}

		return true;
	}

	@ObfuscatedName("g")
	@Export("clearTempGameObjects")
	public void clearTempGameObjects() {
		for (int var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
			GameObject var2 = this.tempGameObjects[var1];
			this.removeGameObject(var2);
			this.tempGameObjects[var1] = null;
		}

		this.tempGameObjectsCount = 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Les;)V"
	)
	@Export("removeGameObject")
	void removeGameObject(GameObject var1) {
		for (int var2 = var1.startX; var2 <= var1.endX; ++var2) {
			for (int var3 = var1.startY; var3 <= var1.endY; ++var3) {
				Tile var4 = this.tiles[var1.plane][var2][var3];
				if (var4 != null) {
					int var5;
					for (var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
						if (var4.gameObjects[var5] == var1) {
							--var4.gameObjectsCount;

							for (int var6 = var5; var6 < var4.gameObjectsCount; ++var6) {
								var4.gameObjects[var6] = var4.gameObjects[var6 + 1];
								var4.gameObjectEdgeMasks[var6] = var4.gameObjectEdgeMasks[var6 + 1];
							}

							var4.gameObjects[var4.gameObjectsCount] = null;
							break;
						}
					}

					var4.gameObjectsEdgeMask = 0;

					for (var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
						var4.gameObjectsEdgeMask |= var4.gameObjectEdgeMasks[var5];
					}
				}
			}
		}

	}

	@ObfuscatedName("j")
	public void method3082(int var1, int var2, int var3, int var4) {
		Tile var5 = this.tiles[var1][var2][var3];
		if (var5 != null) {
			WallDecoration var6 = var5.wallDecoration;
			if (var6 != null) {
				var6.xOffset = var4 * var6.xOffset / 16;
				var6.yOffset = var4 * var6.yOffset / 16;
			}
		}
	}

	@ObfuscatedName("o")
	@Export("removeBoundaryObject")
	public void removeBoundaryObject(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 != null) {
			var4.boundaryObject = null;
		}
	}

	@ObfuscatedName("d")
	@Export("removeWallDecoration")
	public void removeWallDecoration(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 != null) {
			var4.wallDecoration = null;
		}
	}

	@ObfuscatedName("s")
	public void method3154(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 != null) {
			for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
				GameObject var6 = var4.gameObjects[var5];
				long var8 = var6.tag;
				boolean var7 = WorldMapLabel.method420(var8) == 2;
				if (var7 && var2 == var6.startX && var3 == var6.startY) {
					this.removeGameObject(var6);
					return;
				}
			}

		}
	}

	@ObfuscatedName("z")
	@Export("removeFloorDecoration")
	public void removeFloorDecoration(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 != null) {
			var4.floorDecoration = null;
		}
	}

	@ObfuscatedName("al")
	@Export("removeGroundItemPile")
	public void removeGroundItemPile(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 != null) {
			var4.groundItemPile = null;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(III)Lem;"
	)
	public BoundaryObject method3088(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 == null ? null : var4.boundaryObject;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(III)Lei;"
	)
	public WallDecoration method3118(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 == null ? null : var4.wallDecoration;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(III)Les;"
	)
	public GameObject method3195(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 == null) {
			return null;
		} else {
			for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
				GameObject var6 = var4.gameObjects[var5];
				long var8 = var6.tag;
				boolean var7 = WorldMapLabel.method420(var8) == 2;
				if (var7 && var2 == var6.startX && var3 == var6.startY) {
					return var6;
				}
			}

			return null;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(III)Ldq;"
	)
	@Export("getFloorDecoration")
	public FloorDecoration getFloorDecoration(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 != null && var4.floorDecoration != null ? var4.floorDecoration : null;
	}

	@ObfuscatedName("ag")
	@Export("getBoundaryObjectTag")
	public long getBoundaryObjectTag(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 != null && var4.boundaryObject != null ? var4.boundaryObject.tag : 0L;
	}

	@ObfuscatedName("ar")
	@Export("getWallDecorationTag")
	public long getWallDecorationTag(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 != null && var4.wallDecoration != null ? var4.wallDecoration.tag : 0L;
	}

	@ObfuscatedName("ax")
	@Export("getGameObjectTag")
	public long getGameObjectTag(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		if (var4 == null) {
			return 0L;
		} else {
			for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
				GameObject var6 = var4.gameObjects[var5];
				long var8 = var6.tag;
				boolean var7 = WorldMapLabel.method420(var8) == 2;
				if (var7 && var2 == var6.startX && var3 == var6.startY) {
					return var6.tag;
				}
			}

			return 0L;
		}
	}

	@ObfuscatedName("az")
	@Export("getFloorDecorationTag")
	public long getFloorDecorationTag(int var1, int var2, int var3) {
		Tile var4 = this.tiles[var1][var2][var3];
		return var4 != null && var4.floorDecoration != null ? var4.floorDecoration.tag : 0L;
	}

	@ObfuscatedName("ae")
	@Export("getObjectFlags")
	public int getObjectFlags(int var1, int var2, int var3, long var4) {
		Tile var6 = this.tiles[var1][var2][var3];
		if (var6 == null) {
			return -1;
		} else if (var6.boundaryObject != null && var6.boundaryObject.tag == var4) {
			return var6.boundaryObject.flags & 255;
		} else if (var6.wallDecoration != null && var6.wallDecoration.tag == var4) {
			return var6.wallDecoration.flags & 255;
		} else if (var6.floorDecoration != null && var6.floorDecoration.tag == var4) {
			return var6.floorDecoration.flags & 255;
		} else {
			for (int var7 = 0; var7 < var6.gameObjectsCount; ++var7) {
				if (var6.gameObjects[var7].tag == var4) {
					return var6.gameObjects[var7].flags & 255;
				}
			}

			return -1;
		}
	}

	@ObfuscatedName("ao")
	public void method3097(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.planes; ++var4) {
			for (int var5 = 0; var5 < this.xSize; ++var5) {
				for (int var6 = 0; var6 < this.ySize; ++var6) {
					Tile var7 = this.tiles[var4][var5][var6];
					if (var7 != null) {
						BoundaryObject var8 = var7.boundaryObject;
						ModelData var10;
						if (var8 != null && var8.entity1 instanceof ModelData) {
							ModelData var9 = (ModelData)var8.entity1;
							this.method3099(var9, var4, var5, var6, 1, 1);
							if (var8.entity2 instanceof ModelData) {
								var10 = (ModelData)var8.entity2;
								this.method3099(var10, var4, var5, var6, 1, 1);
								ModelData.method2790(var9, var10, 0, 0, 0, false);
								var8.entity2 = var10.toModel(var10.field1580, var10.field1577, var1, var2, var3);
							}

							var8.entity1 = var9.toModel(var9.field1580, var9.field1577, var1, var2, var3);
						}

						for (int var12 = 0; var12 < var7.gameObjectsCount; ++var12) {
							GameObject var14 = var7.gameObjects[var12];
							if (var14 != null && var14.entity instanceof ModelData) {
								ModelData var11 = (ModelData)var14.entity;
								this.method3099(var11, var4, var5, var6, var14.endX - var14.startX + 1, var14.endY - var14.startY + 1);
								var14.entity = var11.toModel(var11.field1580, var11.field1577, var1, var2, var3);
							}
						}

						FloorDecoration var13 = var7.floorDecoration;
						if (var13 != null && var13.entity instanceof ModelData) {
							var10 = (ModelData)var13.entity;
							this.method3120(var10, var4, var5, var6);
							var13.entity = var10.toModel(var10.field1580, var10.field1577, var1, var2, var3);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Lds;III)V"
	)
	void method3120(ModelData var1, int var2, int var3, int var4) {
		Tile var5;
		ModelData var6;
		if (var3 < this.xSize) {
			var5 = this.tiles[var2][var3 + 1][var4];
			if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
				var6 = (ModelData)var5.floorDecoration.entity;
				ModelData.method2790(var1, var6, 128, 0, 0, true);
			}
		}

		if (var4 < this.xSize) {
			var5 = this.tiles[var2][var3][var4 + 1];
			if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
				var6 = (ModelData)var5.floorDecoration.entity;
				ModelData.method2790(var1, var6, 0, 0, 128, true);
			}
		}

		if (var3 < this.xSize && var4 < this.ySize) {
			var5 = this.tiles[var2][var3 + 1][var4 + 1];
			if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
				var6 = (ModelData)var5.floorDecoration.entity;
				ModelData.method2790(var1, var6, 128, 0, 128, true);
			}
		}

		if (var3 < this.xSize && var4 > 0) {
			var5 = this.tiles[var2][var3 + 1][var4 - 1];
			if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
				var6 = (ModelData)var5.floorDecoration.entity;
				ModelData.method2790(var1, var6, 128, 0, -128, true);
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(Lds;IIIII)V"
	)
	void method3099(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		int var8 = var3;
		int var9 = var3 + var5;
		int var10 = var4 - 1;
		int var11 = var4 + var6;

		for (int var12 = var2; var12 <= var2 + 1; ++var12) {
			if (var12 != this.planes) {
				for (int var13 = var8; var13 <= var9; ++var13) {
					if (var13 >= 0 && var13 < this.xSize) {
						for (int var14 = var10; var14 <= var11; ++var14) {
							if (var14 >= 0 && var14 < this.ySize && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
								Tile var15 = this.tiles[var12][var13][var14];
								if (var15 != null) {
									int var16 = (this.tileHeights[var12][var13 + 1][var14] + this.tileHeights[var12][var13 + 1][var14 + 1] + this.tileHeights[var12][var13][var14] + this.tileHeights[var12][var13][var14 + 1]) / 4 - (this.tileHeights[var2][var3 + 1][var4] + this.tileHeights[var2][var3][var4] + this.tileHeights[var2][var3 + 1][var4 + 1] + this.tileHeights[var2][var3][var4 + 1]) / 4;
									BoundaryObject var17 = var15.boundaryObject;
									if (var17 != null) {
										ModelData var18;
										if (var17.entity1 instanceof ModelData) {
											var18 = (ModelData)var17.entity1;
											ModelData.method2790(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
										}

										if (var17.entity2 instanceof ModelData) {
											var18 = (ModelData)var17.entity2;
											ModelData.method2790(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
										}
									}

									for (int var23 = 0; var23 < var15.gameObjectsCount; ++var23) {
										GameObject var19 = var15.gameObjects[var23];
										if (var19 != null && var19.entity instanceof ModelData) {
											ModelData var20 = (ModelData)var19.entity;
											int var21 = var19.endX - var19.startX + 1;
											int var22 = var19.endY - var19.startY + 1;
											ModelData.method2790(var1, var20, (var21 - var5) * 64 + (var19.startX - var3) * 128, var16, (var19.startY - var4) * 128 + (var22 - var6) * 64, var7);
										}
									}
								}
							}
						}
					}
				}

				--var8;
				var7 = false;
			}
		}

	}

	@ObfuscatedName("ac")
	@Export("drawTileMinimap")
	public void drawTileMinimap(int[] var1, int var2, int var3, int var4, int var5, int var6) {
		Tile var7 = this.tiles[var4][var5][var6];
		if (var7 != null) {
			TilePaint var8 = var7.paint;
			int var10;
			if (var8 != null) {
				int var9 = var8.rgb;
				if (var9 != 0) {
					for (var10 = 0; var10 < 4; ++var10) {
						var1[var2] = var9;
						var1[var2 + 1] = var9;
						var1[var2 + 2] = var9;
						var1[var2 + 3] = var9;
						var2 += var3;
					}

				}
			} else {
				TileModel var18 = var7.model;
				if (var18 != null) {
					var10 = var18.shape;
					int var11 = var18.rotation;
					int var12 = var18.underlayRgb;
					int var13 = var18.overlayRgb;
					int[] var14 = this.tileShape2D[var10];
					int[] var15 = this.tileRotation2D[var11];
					int var16 = 0;
					int var17;
					if (var12 != 0) {
						for (var17 = 0; var17 < 4; ++var17) {
							var1[var2] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 1] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 2] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 3] = var14[var15[var16++]] == 0 ? var12 : var13;
							var2 += var3;
						}
					} else {
						for (var17 = 0; var17 < 4; ++var17) {
							if (var14[var15[var16++]] != 0) {
								var1[var2] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 1] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 2] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 3] = var13;
							}

							var2 += var3;
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("aa")
	@Export("menuOpen")
	public void menuOpen(int var1, int var2, int var3, boolean var4) {
		if (!method3105() || var4) {
			checkClick = true;
			viewportWalking = var4;
			Scene_selectedPlane = var1;
			Scene_selectedScreenX = var2;
			Scene_selectedScreenY = var3;
			Scene_selectedX = -1;
			Scene_selectedY = -1;
		}
	}

	@ObfuscatedName("an")
	public void method3104() {
		viewportWalking = true;
	}

	@ObfuscatedName("ak")
	@Export("draw")
	public void draw(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 < 0) {
			var1 = 0;
		} else if (var1 >= this.xSize * 128) {
			var1 = this.xSize * 128 - 1;
		}

		if (var3 < 0) {
			var3 = 0;
		} else if (var3 >= this.ySize * 128) {
			var3 = this.ySize * 128 - 1;
		}

		if (var4 < 128) {
			var4 = 128;
		} else if (var4 > 383) {
			var4 = 383;
		}

		++Scene_drawnCount;
		Scene_cameraPitchSine = Rasterizer3D.Rasterizer3D_sine[var4];
		Scene_cameraPitchCosine = Rasterizer3D.Rasterizer3D_cosine[var4];
		Scene_cameraYawSine = Rasterizer3D.Rasterizer3D_sine[var5];
		Scene_cameraYawCosine = Rasterizer3D.Rasterizer3D_cosine[var5];
		visibleTiles = visibilityMap[(var4 - 128) / 32][var5 / 64];
		Scene_cameraX = var1;
		Scene_cameraY = var2;
		Scene_cameraZ = var3;
		Scene_cameraXTile = var1 / 128;
		Scene_cameraYTile = var3 / 128;
		Scene_plane = var6;
		Scene_cameraXTileMin = Scene_cameraXTile - 25;
		if (Scene_cameraXTileMin < 0) {
			Scene_cameraXTileMin = 0;
		}

		Scene_cameraYTileMin = Scene_cameraYTile - 25;
		if (Scene_cameraYTileMin < 0) {
			Scene_cameraYTileMin = 0;
		}

		Scene_cameraXTileMax = Scene_cameraXTile + 25;
		if (Scene_cameraXTileMax > this.xSize) {
			Scene_cameraXTileMax = this.xSize;
		}

		Scene_cameraYTileMax = Scene_cameraYTile + 25;
		if (Scene_cameraYTileMax > this.ySize) {
			Scene_cameraYTileMax = this.ySize;
		}

		this.occlude();
		tileUpdateCount = 0;

		int var7;
		Tile[][] var8;
		int var9;
		int var10;
		for (var7 = this.minPlane; var7 < this.planes; ++var7) {
			var8 = this.tiles[var7];

			for (var9 = Scene_cameraXTileMin; var9 < Scene_cameraXTileMax; ++var9) {
				for (var10 = Scene_cameraYTileMin; var10 < Scene_cameraYTileMax; ++var10) {
					Tile var11 = var8[var9][var10];
					if (var11 != null) {
						if (var11.minPlane > var6 || !visibleTiles[var9 - Scene_cameraXTile + 25][var10 - Scene_cameraYTile + 25] && this.tileHeights[var7][var9][var10] - var2 < 2000) {
							var11.drawPrimary = false;
							var11.drawSecondary = false;
							var11.drawGameObjectEdges = 0;
						} else {
							var11.drawPrimary = true;
							var11.drawSecondary = true;
							if (var11.gameObjectsCount > 0) {
								var11.drawGameObjects = true;
							} else {
								var11.drawGameObjects = false;
							}

							++tileUpdateCount;
						}
					}
				}
			}
		}

		int var12;
		int var13;
		int var14;
		Tile var15;
		int var16;
		for (var7 = this.minPlane; var7 < this.planes; ++var7) {
			var8 = this.tiles[var7];

			for (var9 = -25; var9 <= 0; ++var9) {
				var10 = var9 + Scene_cameraXTile;
				var16 = Scene_cameraXTile - var9;
				if (var10 >= Scene_cameraXTileMin || var16 < Scene_cameraXTileMax) {
					for (var12 = -25; var12 <= 0; ++var12) {
						var13 = var12 + Scene_cameraYTile;
						var14 = Scene_cameraYTile - var12;
						if (var10 >= Scene_cameraXTileMin) {
							if (var13 >= Scene_cameraYTileMin) {
								var15 = var8[var10][var13];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, true);
								}
							}

							if (var14 < Scene_cameraYTileMax) {
								var15 = var8[var10][var14];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, true);
								}
							}
						}

						if (var16 < Scene_cameraXTileMax) {
							if (var13 >= Scene_cameraYTileMin) {
								var15 = var8[var16][var13];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, true);
								}
							}

							if (var14 < Scene_cameraYTileMax) {
								var15 = var8[var16][var14];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, true);
								}
							}
						}

						if (tileUpdateCount == 0) {
							checkClick = false;
							return;
						}
					}
				}
			}
		}

		for (var7 = this.minPlane; var7 < this.planes; ++var7) {
			var8 = this.tiles[var7];

			for (var9 = -25; var9 <= 0; ++var9) {
				var10 = var9 + Scene_cameraXTile;
				var16 = Scene_cameraXTile - var9;
				if (var10 >= Scene_cameraXTileMin || var16 < Scene_cameraXTileMax) {
					for (var12 = -25; var12 <= 0; ++var12) {
						var13 = var12 + Scene_cameraYTile;
						var14 = Scene_cameraYTile - var12;
						if (var10 >= Scene_cameraXTileMin) {
							if (var13 >= Scene_cameraYTileMin) {
								var15 = var8[var10][var13];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, false);
								}
							}

							if (var14 < Scene_cameraYTileMax) {
								var15 = var8[var10][var14];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, false);
								}
							}
						}

						if (var16 < Scene_cameraXTileMax) {
							if (var13 >= Scene_cameraYTileMin) {
								var15 = var8[var16][var13];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, false);
								}
							}

							if (var14 < Scene_cameraYTileMax) {
								var15 = var8[var16][var14];
								if (var15 != null && var15.drawPrimary) {
									this.drawTile(var15, false);
								}
							}
						}

						if (tileUpdateCount == 0) {
							checkClick = false;
							return;
						}
					}
				}
			}
		}

		checkClick = false;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Ldv;Z)V"
	)
	@Export("drawTile")
	void drawTile(Tile var1, boolean var2) {
		Scene_tilesDeque.addFirst(var1);

		while (true) {
			Tile var3;
			int var4;
			int var5;
			int var6;
			int var7;
			Tile[][] var8;
			Tile var9;
			int var11;
			int var14;
			int var15;
			int var16;
			int var24;
			int var25;
			do {
				do {
					do {
						do {
							do {
								do {
									while (true) {
										BoundaryObject var10;
										GameObject var12;
										int var17;
										int var18;
										boolean var20;
										int var21;
										Tile var36;
										while (true) {
											do {
												var3 = (Tile)Scene_tilesDeque.removeLast();
												if (var3 == null) {
													return;
												}
											} while(!var3.drawSecondary);

											var4 = var3.x;
											var5 = var3.y;
											var6 = var3.plane;
											var7 = var3.originalPlane;
											var8 = this.tiles[var6];
											if (!var3.drawPrimary) {
												break;
											}

											if (var2) {
												if (var6 > 0) {
													var9 = this.tiles[var6 - 1][var4][var5];
													if (var9 != null && var9.drawSecondary) {
														continue;
													}
												}

												if (var4 <= Scene_cameraXTile && var4 > Scene_cameraXTileMin) {
													var9 = var8[var4 - 1][var5];
													if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 1) == 0)) {
														continue;
													}
												}

												if (var4 >= Scene_cameraXTile && var4 < Scene_cameraXTileMax - 1) {
													var9 = var8[var4 + 1][var5];
													if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 4) == 0)) {
														continue;
													}
												}

												if (var5 <= Scene_cameraYTile && var5 > Scene_cameraYTileMin) {
													var9 = var8[var4][var5 - 1];
													if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 8) == 0)) {
														continue;
													}
												}

												if (var5 >= Scene_cameraYTile && var5 < Scene_cameraYTileMax - 1) {
													var9 = var8[var4][var5 + 1];
													if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 2) == 0)) {
														continue;
													}
												}
											} else {
												var2 = true;
											}

											var3.drawPrimary = false;
											if (var3.linkedBelowTile != null) {
												var9 = var3.linkedBelowTile;
												if (var9.paint != null) {
													if (!this.method3181(0, var4, var5)) {
														this.drawTileUnderlay(var9.paint, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
													}
												} else if (var9.model != null && !this.method3181(0, var4, var5)) {
													this.drawTileOverlay(var9.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
												}

												var10 = var9.boundaryObject;
												if (var10 != null) {
													var10.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x * 4096 - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y * 4096 - Scene_cameraZ, var10.tag);
												}

												for (var11 = 0; var11 < var9.gameObjectsCount; ++var11) {
													var12 = var9.gameObjects[var11];
													if (var12 != null) {
														var12.entity.draw(var12.orientation, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var12.centerX - Scene_cameraX, var12.height - Scene_cameraY, var12.centerY - Scene_cameraZ, var12.tag);
													}
												}
											}

											var20 = false;
											if (var3.paint != null) {
												if (!this.method3181(var7, var4, var5)) {
													var20 = true;
													if (var3.paint.neColor != 12345678 || checkClick && var6 <= Scene_selectedPlane) {
														this.drawTileUnderlay(var3.paint, var7, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
													}
												}
											} else if (var3.model != null && !this.method3181(var7, var4, var5)) {
												var20 = true;
												this.drawTileOverlay(var3.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
											}

											var21 = 0;
											var11 = 0;
											BoundaryObject var31 = var3.boundaryObject;
											WallDecoration var13 = var3.wallDecoration;
											if (var31 != null || var13 != null) {
												if (var4 == Scene_cameraXTile) {
													++var21;
												} else if (Scene_cameraXTile < var4) {
													var21 += 2;
												}

												if (var5 == Scene_cameraYTile) {
													var21 += 3;
												} else if (Scene_cameraYTile > var5) {
													var21 += 6;
												}

												var11 = field1847[var21];
												var3.field1666 = field1809[var21];
											}

											if (var31 != null) {
												if ((var31.orientationA & field1815[var21]) != 0) {
													if (var31.orientationA == 16) {
														var3.drawGameObjectEdges = 3;
														var3.field1651 = field1844[var21];
														var3.field1665 = 3 - var3.field1651;
													} else if (var31.orientationA == 32) {
														var3.drawGameObjectEdges = 6;
														var3.field1651 = field1828[var21];
														var3.field1665 = 6 - var3.field1651;
													} else if (var31.orientationA == 64) {
														var3.drawGameObjectEdges = 12;
														var3.field1651 = field1852[var21];
														var3.field1665 = 12 - var3.field1651;
													} else {
														var3.drawGameObjectEdges = 9;
														var3.field1651 = field1842[var21];
														var3.field1665 = 9 - var3.field1651;
													}
												} else {
													var3.drawGameObjectEdges = 0;
												}

												if ((var31.orientationA & var11) != 0 && !this.method3194(var7, var4, var5, var31.orientationA)) {
													var31.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x * 4096 - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y * 4096 - Scene_cameraZ, var31.tag);
												}

												if ((var31.orientationB & var11) != 0 && !this.method3194(var7, var4, var5, var31.orientationB)) {
													var31.entity2.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x * 4096 - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y * 4096 - Scene_cameraZ, var31.tag);
												}
											}

											if (var13 != null && !this.method3116(var7, var4, var5, var13.entity1.height)) {
												if ((var13.orientation & var11) != 0) {
													var13.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var13.xOffset + (var13.x * 4096 - Scene_cameraX), var13.tileHeight - Scene_cameraY, var13.yOffset + (var13.y * 4096 - Scene_cameraZ), var13.tag);
												} else if (var13.orientation == 256) {
													var14 = var13.x * 4096 - Scene_cameraX;
													var15 = var13.tileHeight - Scene_cameraY;
													var16 = var13.y * 4096 - Scene_cameraZ;
													var17 = var13.orientation2;
													if (var17 != 1 && var17 != 2) {
														var18 = var14;
													} else {
														var18 = -var14;
													}

													int var19;
													if (var17 != 2 && var17 != 3) {
														var19 = var16;
													} else {
														var19 = -var16;
													}

													if (var19 < var18) {
														var13.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14 + var13.xOffset, var15, var16 + var13.yOffset, var13.tag);
													} else if (var13.entity2 != null) {
														var13.entity2.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14, var15, var16, var13.tag);
													}
												}
											}

											if (var20) {
												FloorDecoration var22 = var3.floorDecoration;
												if (var22 != null) {
													var22.entity.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var22.x * 4096 - Scene_cameraX, var22.tileHeight - Scene_cameraY, var22.y * 4096 - Scene_cameraZ, var22.tag);
												}

												GroundItemPile var23 = var3.groundItemPile;
												if (var23 != null && var23.height == 0) {
													if (var23.second != null) {
														var23.second.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 4096 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 4096 - Scene_cameraZ, var23.tag);
													}

													if (var23.third != null) {
														var23.third.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 4096 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 4096 - Scene_cameraZ, var23.tag);
													}

													if (var23.first != null) {
														var23.first.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 4096 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 4096 - Scene_cameraZ, var23.tag);
													}
												}
											}

											var14 = var3.gameObjectsEdgeMask;
											if (var14 != 0) {
												if (var4 < Scene_cameraXTile && (var14 & 4) != 0) {
													var36 = var8[var4 + 1][var5];
													if (var36 != null && var36.drawSecondary) {
														Scene_tilesDeque.addFirst(var36);
													}
												}

												if (var5 < Scene_cameraYTile && (var14 & 2) != 0) {
													var36 = var8[var4][var5 + 1];
													if (var36 != null && var36.drawSecondary) {
														Scene_tilesDeque.addFirst(var36);
													}
												}

												if (var4 > Scene_cameraXTile && (var14 & 1) != 0) {
													var36 = var8[var4 - 1][var5];
													if (var36 != null && var36.drawSecondary) {
														Scene_tilesDeque.addFirst(var36);
													}
												}

												if (var5 > Scene_cameraYTile && (var14 & 8) != 0) {
													var36 = var8[var4][var5 - 1];
													if (var36 != null && var36.drawSecondary) {
														Scene_tilesDeque.addFirst(var36);
													}
												}
											}
											break;
										}

										if (var3.drawGameObjectEdges != 0) {
											var20 = true;

											for (var21 = 0; var21 < var3.gameObjectsCount; ++var21) {
												if (var3.gameObjects[var21].lastDrawn != Scene_drawnCount && (var3.gameObjectEdgeMasks[var21] & var3.drawGameObjectEdges) == var3.field1651) {
													var20 = false;
													break;
												}
											}

											if (var20) {
												var10 = var3.boundaryObject;
												if (!this.method3194(var7, var4, var5, var10.orientationA)) {
													var10.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x * 4096 - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y * 4096 - Scene_cameraZ, var10.tag);
												}

												var3.drawGameObjectEdges = 0;
											}
										}

										if (!var3.drawGameObjects) {
											break;
										}

										try {
											int var34 = var3.gameObjectsCount;
											var3.drawGameObjects = false;
											var21 = 0;

											label563:
											for (var11 = 0; var11 < var34; ++var11) {
												var12 = var3.gameObjects[var11];
												if (var12.lastDrawn != Scene_drawnCount) {
													for (var24 = var12.startX; var24 <= var12.endX; ++var24) {
														for (var14 = var12.startY; var14 <= var12.endY; ++var14) {
															var36 = var8[var24][var14];
															if (var36.drawPrimary) {
																var3.drawGameObjects = true;
																continue label563;
															}

															if (var36.drawGameObjectEdges != 0) {
																var16 = 0;
																if (var24 > var12.startX) {
																	++var16;
																}

																if (var24 < var12.endX) {
																	var16 += 4;
																}

																if (var14 > var12.startY) {
																	var16 += 8;
																}

																if (var14 < var12.endY) {
																	var16 += 2;
																}

																if ((var16 & var36.drawGameObjectEdges) == var3.field1665) {
																	var3.drawGameObjects = true;
																	continue label563;
																}
															}
														}
													}

													gameObjects[var21++] = var12;
													var24 = Scene_cameraXTile - var12.startX;
													var14 = var12.endX - Scene_cameraXTile;
													if (var14 > var24) {
														var24 = var14;
													}

													var15 = Scene_cameraYTile - var12.startY;
													var16 = var12.endY - Scene_cameraYTile;
													if (var16 > var15) {
														var12.field1939 = var24 + var16;
													} else {
														var12.field1939 = var24 + var15;
													}
												}
											}

											while (var21 > 0) {
												var11 = -50;
												var25 = -1;

												for (var24 = 0; var24 < var21; ++var24) {
													GameObject var35 = gameObjects[var24];
													if (var35.lastDrawn != Scene_drawnCount) {
														if (var35.field1939 > var11) {
															var11 = var35.field1939;
															var25 = var24;
														} else if (var11 == var35.field1939) {
															var15 = var35.centerX - Scene_cameraX;
															var16 = var35.centerY - Scene_cameraZ;
															var17 = gameObjects[var25].centerX - Scene_cameraX;
															var18 = gameObjects[var25].centerY - Scene_cameraZ;
															if (var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
																var25 = var24;
															}
														}
													}
												}

												if (var25 == -1) {
													break;
												}

												GameObject var33 = gameObjects[var25];
												var33.lastDrawn = Scene_drawnCount;
												if (!this.method3117(var7, var33.startX, var33.endX, var33.startY, var33.endY, var33.entity.height)) {
													var33.entity.draw(var33.orientation, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var33.centerX - Scene_cameraX, var33.height - Scene_cameraY, var33.centerY - Scene_cameraZ, var33.tag);
												}

												for (var14 = var33.startX; var14 <= var33.endX; ++var14) {
													for (var15 = var33.startY; var15 <= var33.endY; ++var15) {
														Tile var26 = var8[var14][var15];
														if (var26.drawGameObjectEdges != 0) {
															Scene_tilesDeque.addFirst(var26);
														} else if ((var14 != var4 || var15 != var5) && var26.drawSecondary) {
															Scene_tilesDeque.addFirst(var26);
														}
													}
												}
											}

											if (!var3.drawGameObjects) {
												break;
											}
										} catch (Exception var28) {
											var3.drawGameObjects = false;
											break;
										}
									}
								} while(!var3.drawSecondary);
							} while(var3.drawGameObjectEdges != 0);

							if (var4 > Scene_cameraXTile || var4 <= Scene_cameraXTileMin) {
								break;
							}

							var9 = var8[var4 - 1][var5];
						} while(var9 != null && var9.drawSecondary);

						if (var4 < Scene_cameraXTile || var4 >= Scene_cameraXTileMax - 1) {
							break;
						}

						var9 = var8[var4 + 1][var5];
					} while(var9 != null && var9.drawSecondary);

					if (var5 > Scene_cameraYTile || var5 <= Scene_cameraYTileMin) {
						break;
					}

					var9 = var8[var4][var5 - 1];
				} while(var9 != null && var9.drawSecondary);

				if (var5 < Scene_cameraYTile || var5 >= Scene_cameraYTileMax - 1) {
					break;
				}

				var9 = var8[var4][var5 + 1];
			} while(var9 != null && var9.drawSecondary);

			var3.drawSecondary = false;
			--tileUpdateCount;
			GroundItemPile var32 = var3.groundItemPile;
			if (var32 != null && var32.height != 0) {
				if (var32.second != null) {
					var32.second.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 4096 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 4096 - Scene_cameraZ, var32.tag);
				}

				if (var32.third != null) {
					var32.third.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 4096 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 4096 - Scene_cameraZ, var32.tag);
				}

				if (var32.first != null) {
					var32.first.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 4096 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 4096 - Scene_cameraZ, var32.tag);
				}
			}

			if (var3.field1666 != 0) {
				WallDecoration var29 = var3.wallDecoration;
				if (var29 != null && !this.method3116(var7, var4, var5, var29.entity1.height)) {
					if ((var29.orientation & var3.field1666) != 0) {
						var29.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var29.xOffset + (var29.x * 4096 - Scene_cameraX), var29.tileHeight - Scene_cameraY, var29.yOffset + (var29.y * 4096 - Scene_cameraZ), var29.tag);
					} else if (var29.orientation == 256) {
						var11 = var29.x * 4096 - Scene_cameraX;
						var25 = var29.tileHeight - Scene_cameraY;
						var24 = var29.y * 4096 - Scene_cameraZ;
						var14 = var29.orientation2;
						if (var14 != 1 && var14 != 2) {
							var15 = var11;
						} else {
							var15 = -var11;
						}

						if (var14 != 2 && var14 != 3) {
							var16 = var24;
						} else {
							var16 = -var24;
						}

						if (var16 >= var15) {
							var29.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11 + var29.xOffset, var25, var24 + var29.yOffset, var29.tag);
						} else if (var29.entity2 != null) {
							var29.entity2.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11, var25, var24, var29.tag);
						}
					}
				}

				BoundaryObject var27 = var3.boundaryObject;
				if (var27 != null) {
					if ((var27.orientationB & var3.field1666) != 0 && !this.method3194(var7, var4, var5, var27.orientationB)) {
						var27.entity2.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x * 4096 - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y * 4096 - Scene_cameraZ, var27.tag);
					}

					if ((var27.orientationA & var3.field1666) != 0 && !this.method3194(var7, var4, var5, var27.orientationA)) {
						var27.entity1.draw(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x * 4096 - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y * 4096 - Scene_cameraZ, var27.tag);
					}
				}
			}

			Tile var30;
			if (var6 < this.planes - 1) {
				var30 = this.tiles[var6 + 1][var4][var5];
				if (var30 != null && var30.drawSecondary) {
					Scene_tilesDeque.addFirst(var30);
				}
			}

			if (var4 < Scene_cameraXTile) {
				var30 = var8[var4 + 1][var5];
				if (var30 != null && var30.drawSecondary) {
					Scene_tilesDeque.addFirst(var30);
				}
			}

			if (var5 < Scene_cameraYTile) {
				var30 = var8[var4][var5 + 1];
				if (var30 != null && var30.drawSecondary) {
					Scene_tilesDeque.addFirst(var30);
				}
			}

			if (var4 > Scene_cameraXTile) {
				var30 = var8[var4 - 1][var5];
				if (var30 != null && var30.drawSecondary) {
					Scene_tilesDeque.addFirst(var30);
				}
			}

			if (var5 > Scene_cameraYTile) {
				var30 = var8[var4][var5 - 1];
				if (var30 != null && var30.drawSecondary) {
					Scene_tilesDeque.addFirst(var30);
				}
			}
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Let;IIIIIII)V"
	)
	@Export("drawTileUnderlay")
	void drawTileUnderlay(TilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9;
		int var10 = var9 = (var7 << 7) - Scene_cameraX;
		int var11;
		int var12 = var11 = (var8 << 7) - Scene_cameraZ;
		int var13;
		int var14 = var13 = var10 + 128;
		int var15;
		int var16 = var15 = var12 + 128;
		int var17 = this.tileHeights[var2][var7][var8] - Scene_cameraY;
		int var18 = this.tileHeights[var2][var7 + 1][var8] - Scene_cameraY;
		int var19 = this.tileHeights[var2][var7 + 1][var8 + 1] - Scene_cameraY;
		int var20 = this.tileHeights[var2][var7][var8 + 1] - Scene_cameraY;
		int var21 = var10 * var6 + var5 * var12 >> 16;
		var12 = var12 * var6 - var5 * var10 >> 16;
		var10 = var21;
		var21 = var17 * var4 - var3 * var12 >> 16;
		var12 = var3 * var17 + var12 * var4 >> 16;
		var17 = var21;
		if (var12 >= 50) {
			var21 = var14 * var6 + var5 * var11 >> 16;
			var11 = var11 * var6 - var5 * var14 >> 16;
			var14 = var21;
			var21 = var18 * var4 - var3 * var11 >> 16;
			var11 = var3 * var18 + var11 * var4 >> 16;
			var18 = var21;
			if (var11 >= 50) {
				var21 = var13 * var6 + var5 * var16 >> 16;
				var16 = var16 * var6 - var5 * var13 >> 16;
				var13 = var21;
				var21 = var19 * var4 - var3 * var16 >> 16;
				var16 = var3 * var19 + var16 * var4 >> 16;
				var19 = var21;
				if (var16 >= 50) {
					var21 = var9 * var6 + var5 * var15 >> 16;
					var15 = var15 * var6 - var5 * var9 >> 16;
					var9 = var21;
					var21 = var20 * var4 - var3 * var15 >> 16;
					var15 = var3 * var20 + var15 * var4 >> 16;
					if (var15 >= 50) {
						int var22 = var10 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
						int var23 = var17 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
						int var24 = var14 * Rasterizer3D.Rasterizer3D_zoom / var11 + Rasterizer3D.Rasterizer3D_clipMidX;
						int var25 = var18 * Rasterizer3D.Rasterizer3D_zoom / var11 + Rasterizer3D.Rasterizer3D_clipMidY;
						int var26 = var13 * Rasterizer3D.Rasterizer3D_zoom / var16 + Rasterizer3D.Rasterizer3D_clipMidX;
						int var27 = var19 * Rasterizer3D.Rasterizer3D_zoom / var16 + Rasterizer3D.Rasterizer3D_clipMidY;
						int var28 = var9 * Rasterizer3D.Rasterizer3D_zoom / var15 + Rasterizer3D.Rasterizer3D_clipMidX;
						int var29 = var21 * Rasterizer3D.Rasterizer3D_zoom / var15 + Rasterizer3D.Rasterizer3D_clipMidY;
						Rasterizer3D.Rasterizer3D_alpha = 0;
						int var30;
						if ((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
							Rasterizer3D.field1763 = false;
							if (var26 < 0 || var28 < 0 || var24 < 0 || var26 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth) {
								Rasterizer3D.field1763 = true;
							}

							if (checkClick && containsBounds(Scene_selectedScreenX, Scene_selectedScreenY, var27, var29, var25, var26, var28, var24)) {
								Scene_selectedX = var7;
								Scene_selectedY = var8;
							}

							if (var1.texture == -1) {
								if (var1.neColor != 12345678) {
									Rasterizer3D.method3020(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor);
								}
							} else if (!Scene_isLowDetail) {
								if (var1.isFlat) {
									Rasterizer3D.method2988(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
								} else {
									Rasterizer3D.method2988(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
								}
							} else {
								var30 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var1.texture);
								Rasterizer3D.method3020(var27, var29, var25, var26, var28, var24, method3111(var30, var1.neColor), method3111(var30, var1.nwColor), method3111(var30, var1.seColor));
							}
						}

						if ((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
							Rasterizer3D.field1763 = false;
							if (var22 < 0 || var24 < 0 || var28 < 0 || var22 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth) {
								Rasterizer3D.field1763 = true;
							}

							if (checkClick && containsBounds(Scene_selectedScreenX, Scene_selectedScreenY, var23, var25, var29, var22, var24, var28)) {
								Scene_selectedX = var7;
								Scene_selectedY = var8;
							}

							if (var1.texture == -1) {
								if (var1.swColor != 12345678) {
									Rasterizer3D.method3020(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor);
								}
							} else if (!Scene_isLowDetail) {
								Rasterizer3D.method2988(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
							} else {
								var30 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var1.texture);
								Rasterizer3D.method3020(var23, var25, var29, var22, var24, var28, method3111(var30, var1.swColor), method3111(var30, var1.seColor), method3111(var30, var1.nwColor));
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Ldk;IIIIII)V"
	)
	@Export("drawTileOverlay")
	void drawTileOverlay(TileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		int var8 = var1.vertexX.length;

		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		for (var9 = 0; var9 < var8; ++var9) {
			var10 = var1.vertexX[var9] - Scene_cameraX;
			var11 = var1.vertexY[var9] - Scene_cameraY;
			var12 = var1.vertexZ[var9] - Scene_cameraZ;
			var13 = var12 * var4 + var5 * var10 >> 16;
			var12 = var5 * var12 - var10 * var4 >> 16;
			var10 = var13;
			var13 = var3 * var11 - var12 * var2 >> 16;
			var12 = var11 * var2 + var3 * var12 >> 16;
			if (var12 < 50) {
				return;
			}

			if (var1.triangleTextureId != null) {
				TileModel.field1594[var9] = var10;
				TileModel.field1607[var9] = var13;
				TileModel.field1608[var9] = var12;
			}

			TileModel.field1606[var9] = var10 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
			TileModel.field1605[var9] = var13 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
		}

		Rasterizer3D.Rasterizer3D_alpha = 0;
		var8 = var1.faceX.length;

		for (var9 = 0; var9 < var8; ++var9) {
			var10 = var1.faceX[var9];
			var11 = var1.faceY[var9];
			var12 = var1.faceZ[var9];
			var13 = TileModel.field1606[var10];
			int var14 = TileModel.field1606[var11];
			int var15 = TileModel.field1606[var12];
			int var16 = TileModel.field1605[var10];
			int var17 = TileModel.field1605[var11];
			int var18 = TileModel.field1605[var12];
			if ((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
				Rasterizer3D.field1763 = false;
				if (var13 < 0 || var14 < 0 || var15 < 0 || var13 > Rasterizer3D.Rasterizer3D_clipWidth || var14 > Rasterizer3D.Rasterizer3D_clipWidth || var15 > Rasterizer3D.Rasterizer3D_clipWidth) {
					Rasterizer3D.field1763 = true;
				}

				if (checkClick && containsBounds(Scene_selectedScreenX, Scene_selectedScreenY, var16, var17, var18, var13, var14, var15)) {
					Scene_selectedX = var6;
					Scene_selectedY = var7;
				}

				if (var1.triangleTextureId != null && var1.triangleTextureId[var9] != -1) {
					if (!Scene_isLowDetail) {
						if (var1.isFlat) {
							Rasterizer3D.method2988(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], TileModel.field1594[0], TileModel.field1594[1], TileModel.field1594[3], TileModel.field1607[0], TileModel.field1607[1], TileModel.field1607[3], TileModel.field1608[0], TileModel.field1608[1], TileModel.field1608[3], var1.triangleTextureId[var9]);
						} else {
							Rasterizer3D.method2988(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], TileModel.field1594[var10], TileModel.field1594[var11], TileModel.field1594[var12], TileModel.field1607[var10], TileModel.field1607[var11], TileModel.field1607[var12], TileModel.field1608[var10], TileModel.field1608[var11], TileModel.field1608[var12], var1.triangleTextureId[var9]);
						}
					} else {
						int var19 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var1.triangleTextureId[var9]);
						Rasterizer3D.method3020(var16, var17, var18, var13, var14, var15, method3111(var19, var1.triangleColorA[var9]), method3111(var19, var1.triangleColorB[var9]), method3111(var19, var1.triangleColorC[var9]));
					}
				} else if (var1.triangleColorA[var9] != 12345678) {
					Rasterizer3D.method3020(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9]);
				}
			}
		}

	}

	@ObfuscatedName("bp")
	@Export("occlude")
	void occlude() {
		int var1 = Scene_planeOccluderCounts[Scene_plane];
		Occluder[] var2 = Scene_planeOccluders[Scene_plane];
		Scene_currentOccludersCount = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			Occluder var4 = var2[var3];
			int var5;
			int var6;
			int var7;
			int var9;
			boolean var13;
			if (var4.type == 1) {
				var5 = var4.minTileX - Scene_cameraXTile + 25;
				if (var5 >= 0 && var5 <= 50) {
					var6 = var4.minTileY - Scene_cameraYTile + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.maxTileY - Scene_cameraYTile + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					var13 = false;

					while (var6 <= var7) {
						if (visibleTiles[var5][var6++]) {
							var13 = true;
							break;
						}
					}

					if (var13) {
						var9 = Scene_cameraX - var4.minX;
						if (var9 > 32) {
							var4.field1910 = 1;
						} else {
							if (var9 >= -32) {
								continue;
							}

							var4.field1910 = 2;
							var9 = -var9;
						}

						var4.field1900 = (var4.minZ - Scene_cameraZ << 8) / var9;
						var4.field1911 = (var4.maxZ - Scene_cameraZ << 8) / var9;
						var4.field1912 = (var4.minY - Scene_cameraY << 8) / var9;
						var4.field1913 = (var4.maxY - Scene_cameraY << 8) / var9;
						Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
					}
				}
			} else if (var4.type == 2) {
				var5 = var4.minTileY - Scene_cameraYTile + 25;
				if (var5 >= 0 && var5 <= 50) {
					var6 = var4.minTileX - Scene_cameraXTile + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.maxTileX - Scene_cameraXTile + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					var13 = false;

					while (var6 <= var7) {
						if (visibleTiles[var6++][var5]) {
							var13 = true;
							break;
						}
					}

					if (var13) {
						var9 = Scene_cameraZ - var4.minZ;
						if (var9 > 32) {
							var4.field1910 = 3;
						} else {
							if (var9 >= -32) {
								continue;
							}

							var4.field1910 = 4;
							var9 = -var9;
						}

						var4.field1907 = (var4.minX - Scene_cameraX << 8) / var9;
						var4.field1909 = (var4.maxX - Scene_cameraX << 8) / var9;
						var4.field1912 = (var4.minY - Scene_cameraY << 8) / var9;
						var4.field1913 = (var4.maxY - Scene_cameraY << 8) / var9;
						Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
					}
				}
			} else if (var4.type == 4) {
				var5 = var4.minY - Scene_cameraY;
				if (var5 > 128) {
					var6 = var4.minTileY - Scene_cameraYTile + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.maxTileY - Scene_cameraYTile + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					if (var6 <= var7) {
						int var8 = var4.minTileX - Scene_cameraXTile + 25;
						if (var8 < 0) {
							var8 = 0;
						}

						var9 = var4.maxTileX - Scene_cameraXTile + 25;
						if (var9 > 50) {
							var9 = 50;
						}

						boolean var10 = false;

						label144:
						for (int var11 = var8; var11 <= var9; ++var11) {
							for (int var12 = var6; var12 <= var7; ++var12) {
								if (visibleTiles[var11][var12]) {
									var10 = true;
									break label144;
								}
							}
						}

						if (var10) {
							var4.field1910 = 5;
							var4.field1907 = (var4.minX - Scene_cameraX << 8) / var5;
							var4.field1909 = (var4.maxX - Scene_cameraX << 8) / var5;
							var4.field1900 = (var4.minZ - Scene_cameraZ << 8) / var5;
							var4.field1911 = (var4.maxZ - Scene_cameraZ << 8) / var5;
							Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("bz")
	boolean method3181(int var1, int var2, int var3) {
		int var4 = this.field1810[var1][var2][var3];
		if (var4 == -Scene_drawnCount) {
			return false;
		} else if (var4 == Scene_drawnCount) {
			return true;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			if (this.method3102(var5 + 1, this.tileHeights[var1][var2][var3], var6 + 1) && this.method3102(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3], var6 + 1) && this.method3102(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method3102(var5 + 1, this.tileHeights[var1][var2][var3 + 1], var6 + 128 - 1)) {
				this.field1810[var1][var2][var3] = Scene_drawnCount;
				return true;
			} else {
				this.field1810[var1][var2][var3] = -Scene_drawnCount;
				return false;
			}
		}
	}

	@ObfuscatedName("bi")
	boolean method3194(int var1, int var2, int var3, int var4) {
		if (!this.method3181(var1, var2, var3)) {
			return false;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			int var7 = this.tileHeights[var1][var2][var3] - 1;
			int var8 = var7 - 120;
			int var9 = var7 - 230;
			int var10 = var7 - 238;
			if (var4 < 16) {
				if (var4 == 1) {
					if (var5 > Scene_cameraX) {
						if (!this.method3102(var5, var7, var6)) {
							return false;
						}

						if (!this.method3102(var5, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method3102(var5, var8, var6)) {
							return false;
						}

						if (!this.method3102(var5, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method3102(var5, var9, var6)) {
						return false;
					}

					if (!this.method3102(var5, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 2) {
					if (var6 < Scene_cameraZ) {
						if (!this.method3102(var5, var7, var6 + 128)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method3102(var5, var8, var6 + 128)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method3102(var5, var9, var6 + 128)) {
						return false;
					}

					if (!this.method3102(var5 + 128, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 4) {
					if (var5 < Scene_cameraX) {
						if (!this.method3102(var5 + 128, var7, var6)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method3102(var5 + 128, var8, var6)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method3102(var5 + 128, var9, var6)) {
						return false;
					}

					if (!this.method3102(var5 + 128, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 8) {
					if (var6 > Scene_cameraZ) {
						if (!this.method3102(var5, var7, var6)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var7, var6)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method3102(var5, var8, var6)) {
							return false;
						}

						if (!this.method3102(var5 + 128, var8, var6)) {
							return false;
						}
					}

					if (!this.method3102(var5, var9, var6)) {
						return false;
					}

					if (!this.method3102(var5 + 128, var9, var6)) {
						return false;
					}

					return true;
				}
			}

			if (!this.method3102(var5 + 64, var10, var6 + 64)) {
				return false;
			} else if (var4 == 16) {
				return this.method3102(var5, var9, var6 + 128);
			} else if (var4 == 32) {
				return this.method3102(var5 + 128, var9, var6 + 128);
			} else if (var4 == 64) {
				return this.method3102(var5 + 128, var9, var6);
			} else if (var4 == 128) {
				return this.method3102(var5, var9, var6);
			} else {
				return true;
			}
		}
	}

	@ObfuscatedName("bg")
	boolean method3116(int var1, int var2, int var3, int var4) {
		if (!this.method3181(var1, var2, var3)) {
			return false;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			return this.method3102(var5 + 1, this.tileHeights[var1][var2][var3] - var4, var6 + 1) && this.method3102(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3] - var4, var6 + 1) && this.method3102(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method3102(var5 + 1, this.tileHeights[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
		}
	}

	@ObfuscatedName("bh")
	boolean method3117(int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		int var8;
		if (var3 == var2 && var5 == var4) {
			if (!this.method3181(var1, var2, var4)) {
				return false;
			} else {
				var7 = var2 << 7;
				var8 = var4 << 7;
				return this.method3102(var7 + 1, this.tileHeights[var1][var2][var4] - var6, var8 + 1) && this.method3102(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4] - var6, var8 + 1) && this.method3102(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method3102(var7 + 1, this.tileHeights[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
			}
		} else {
			for (var7 = var2; var7 <= var3; ++var7) {
				for (var8 = var4; var8 <= var5; ++var8) {
					if (this.field1810[var1][var7][var8] == -Scene_drawnCount) {
						return false;
					}
				}
			}

			var7 = (var2 << 7) + 1;
			var8 = (var4 << 7) + 2;
			int var9 = this.tileHeights[var1][var2][var4] - var6;
			if (!this.method3102(var7, var9, var8)) {
				return false;
			} else {
				int var10 = (var3 << 7) - 1;
				if (!this.method3102(var10, var9, var8)) {
					return false;
				} else {
					int var11 = (var5 << 7) - 1;
					if (!this.method3102(var7, var9, var11)) {
						return false;
					} else if (!this.method3102(var10, var9, var11)) {
						return false;
					} else {
						return true;
					}
				}
			}
		}
	}

	@ObfuscatedName("bm")
	boolean method3102(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Scene_currentOccludersCount; ++var4) {
			Occluder var5 = Scene_currentOccluders[var4];
			int var6;
			int var7;
			int var8;
			int var9;
			int var10;
			if (var5.field1910 == 1) {
				var6 = var5.minX - var1;
				if (var6 > 0) {
					var7 = (var6 * var5.field1900 >> 8) + var5.minZ;
					var8 = (var6 * var5.field1911 >> 8) + var5.maxZ;
					var9 = (var6 * var5.field1912 >> 8) + var5.minY;
					var10 = (var6 * var5.field1913 >> 8) + var5.maxY;
					if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field1910 == 2) {
				var6 = var1 - var5.minX;
				if (var6 > 0) {
					var7 = (var6 * var5.field1900 >> 8) + var5.minZ;
					var8 = (var6 * var5.field1911 >> 8) + var5.maxZ;
					var9 = (var6 * var5.field1912 >> 8) + var5.minY;
					var10 = (var6 * var5.field1913 >> 8) + var5.maxY;
					if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field1910 == 3) {
				var6 = var5.minZ - var3;
				if (var6 > 0) {
					var7 = (var6 * var5.field1907 >> 8) + var5.minX;
					var8 = (var6 * var5.field1909 >> 8) + var5.maxX;
					var9 = (var6 * var5.field1912 >> 8) + var5.minY;
					var10 = (var6 * var5.field1913 >> 8) + var5.maxY;
					if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field1910 == 4) {
				var6 = var3 - var5.minZ;
				if (var6 > 0) {
					var7 = (var6 * var5.field1907 >> 8) + var5.minX;
					var8 = (var6 * var5.field1909 >> 8) + var5.maxX;
					var9 = (var6 * var5.field1912 >> 8) + var5.minY;
					var10 = (var6 * var5.field1913 >> 8) + var5.maxY;
					if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field1910 == 5) {
				var6 = var2 - var5.minY;
				if (var6 > 0) {
					var7 = (var6 * var5.field1907 >> 8) + var5.minX;
					var8 = (var6 * var5.field1909 >> 8) + var5.maxX;
					var9 = (var6 * var5.field1900 >> 8) + var5.minZ;
					var10 = (var6 * var5.field1911 >> 8) + var5.maxZ;
					if (var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@ObfuscatedName("p")
	@Export("Scene_addOccluder")
	public static void Scene_addOccluder(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		Occluder var8 = new Occluder();
		var8.minTileX = var2 / 128;
		var8.maxTileX = var3 / 128;
		var8.minTileY = var4 / 128;
		var8.maxTileY = var5 / 128;
		var8.type = var1;
		var8.minX = var2;
		var8.maxX = var3;
		var8.minZ = var4;
		var8.maxZ = var5;
		var8.minY = var6;
		var8.maxY = var7;
		Scene_planeOccluders[var0][Scene_planeOccluderCounts[var0]++] = var8;
	}

	@ObfuscatedName("ap")
	@Export("Scene_buildVisiblityMap")
	public static void Scene_buildVisiblityMap(int[] var0, int var1, int var2, int var3, int var4) {
		Scene_viewportXMin = 0;
		Scene_viewportYMin = 0;
		Scene_viewportXMax = var3;
		Scene_viewportYMax = var4;
		Scene_viewportXCenter = var3 / 2;
		Scene_viewportYCenter = var4 / 2;
		boolean[][][][] var5 = new boolean[var0.length][32][53][53];

		int var6;
		int var7;
		int var8;
		int var9;
		int var11;
		int var12;
		for (var6 = 128; var6 <= 383; var6 += 32) {
			for (var7 = 0; var7 < 2048; var7 += 64) {
				Scene_cameraPitchSine = Rasterizer3D.Rasterizer3D_sine[var6];
				Scene_cameraPitchCosine = Rasterizer3D.Rasterizer3D_cosine[var6];
				Scene_cameraYawSine = Rasterizer3D.Rasterizer3D_sine[var7];
				Scene_cameraYawCosine = Rasterizer3D.Rasterizer3D_cosine[var7];
				var8 = (var6 - 128) / 32;
				var9 = var7 / 64;

				for (int var10 = -26; var10 < 26; ++var10) {
					for (var11 = -26; var11 < 26; ++var11) {
						var12 = var10 * 128;
						int var13 = var11 * 128;
						boolean var14 = false;

						for (int var15 = -var1; var15 <= var2; var15 += 128) {
							if (method3187(var12, var0[var8] + var15, var13)) {
								var14 = true;
								break;
							}
						}

						var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
					}
				}
			}
		}

		for (var6 = 0; var6 < 8; ++var6) {
			for (var7 = 0; var7 < 32; ++var7) {
				for (var8 = -25; var8 < 25; ++var8) {
					for (var9 = -25; var9 < 25; ++var9) {
						boolean var16 = false;

						label76:
						for (var11 = -1; var11 <= 1; ++var11) {
							for (var12 = -1; var12 <= 1; ++var12) {
								if (var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
									var16 = true;
									break label76;
								}

								if (var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
									var16 = true;
									break label76;
								}

								if (var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
									var16 = true;
									break label76;
								}

								if (var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
									var16 = true;
									break label76;
								}
							}
						}

						visibilityMap[var6][var7][var8 + 25][var9 + 25] = var16;
					}
				}
			}
		}

	}

	@ObfuscatedName("aq")
	static boolean method3187(int var0, int var1, int var2) {
		int var3 = var0 * Scene_cameraYawCosine + var2 * Scene_cameraYawSine >> 16;
		int var4 = var2 * Scene_cameraYawCosine - var0 * Scene_cameraYawSine >> 16;
		int var5 = var4 * Scene_cameraPitchCosine + Scene_cameraPitchSine * var1 >> 16;
		int var6 = Scene_cameraPitchCosine * var1 - var4 * Scene_cameraPitchSine >> 16;
		if (var5 >= 50 && var5 <= 3500) {
			int var7 = var3 * 128 / var5 + Scene_viewportXCenter;
			int var8 = var6 * 128 / var5 + Scene_viewportYCenter;
			return var7 >= Scene_viewportXMin && var7 <= Scene_viewportXMax && var8 >= Scene_viewportYMin && var8 <= Scene_viewportYMax;
		} else {
			return false;
		}
	}

	@ObfuscatedName("au")
	public static boolean method3105() {
		return viewportWalking && Scene_selectedX != -1;
	}

	@ObfuscatedName("ai")
	public static void method3222() {
		Scene_selectedX = -1;
		viewportWalking = false;
	}

	@ObfuscatedName("af")
	static final int method3111(int var0, int var1) {
		var1 = (var0 & 127) * var1 >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}

	@ObfuscatedName("ab")
	@Export("containsBounds")
	static boolean containsBounds(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 < var2 && var1 < var3 && var1 < var4) {
			return false;
		} else if (var1 > var2 && var1 > var3 && var1 > var4) {
			return false;
		} else if (var0 < var5 && var0 < var6 && var0 < var7) {
			return false;
		} else if (var0 > var5 && var0 > var6 && var0 > var7) {
			return false;
		} else {
			int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
			int var9 = (var7 - var6) * (var1 - var3) - (var0 - var6) * (var4 - var3);
			int var10 = (var5 - var7) * (var1 - var4) - (var2 - var4) * (var0 - var7);
			if (var8 == 0) {
				if (var9 != 0) {
					return var9 < 0 ? var10 <= 0 : var10 >= 0;
				} else {
					return true;
				}
			} else {
				return var8 < 0 ? var9 <= 0 && var10 <= 0 : var9 >= 0 && var10 >= 0;
			}
		}
	}
}

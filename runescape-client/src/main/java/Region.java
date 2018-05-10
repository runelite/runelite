import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("Region")
public class Region {
   @ObfuscatedName("w")
   @Export("regionLowMemory")
   public static boolean regionLowMemory;
   @ObfuscatedName("g")
   @Export("tileUpdateCount")
   static int tileUpdateCount;
   @ObfuscatedName("y")
   @Export("Scene_plane")
   static int Scene_plane;
   @ObfuscatedName("c")
   @Export("cycle")
   static int cycle;
   @ObfuscatedName("e")
   @Export("minTileX")
   static int minTileX;
   @ObfuscatedName("t")
   @Export("maxTileX")
   static int maxTileX;
   @ObfuscatedName("u")
   @Export("minTileZ")
   static int minTileZ;
   @ObfuscatedName("i")
   @Export("maxTileZ")
   static int maxTileZ;
   @ObfuscatedName("z")
   @Export("screenCenterX")
   static int screenCenterX;
   @ObfuscatedName("k")
   @Export("screenCenterZ")
   static int screenCenterZ;
   @ObfuscatedName("r")
   @Export("cameraX2")
   static int cameraX2;
   @ObfuscatedName("v")
   @Export("cameraY2")
   static int cameraY2;
   @ObfuscatedName("o")
   @Export("cameraZ2")
   static int cameraZ2;
   @ObfuscatedName("ai")
   @Export("pitchSin")
   static int pitchSin;
   @ObfuscatedName("at")
   @Export("pitchCos")
   static int pitchCos;
   @ObfuscatedName("ad")
   @Export("yawSin")
   static int yawSin;
   @ObfuscatedName("ac")
   @Export("yawCos")
   static int yawCos;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "[Leg;"
   )
   @Export("entityBuffer")
   static GameObject[] entityBuffer;
   @ObfuscatedName("an")
   @Export("checkClick")
   static boolean checkClick;
   @ObfuscatedName("as")
   static int field1773;
   @ObfuscatedName("aw")
   @Export("mouseX2")
   static int mouseX2;
   @ObfuscatedName("ag")
   @Export("mouseY2")
   static int mouseY2;
   @ObfuscatedName("ah")
   @Export("selectedRegionTileX")
   public static int selectedRegionTileX;
   @ObfuscatedName("az")
   @Export("selectedRegionTileY")
   public static int selectedRegionTileY;
   @ObfuscatedName("ao")
   @Export("viewportWalking")
   static boolean viewportWalking;
   @ObfuscatedName("am")
   @Export("MAX_OCCLUDER_LEVELS")
   static int MAX_OCCLUDER_LEVELS;
   @ObfuscatedName("aq")
   @Export("levelOccluderCount")
   static int[] levelOccluderCount;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "[[Lef;"
   )
   @Export("levelOccluders")
   static Occluder[][] levelOccluders;
   @ObfuscatedName("ae")
   static int field1783;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "[Lef;"
   )
   static Occluder[] field1785;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("tileDeque")
   static Deque tileDeque;
   @ObfuscatedName("ab")
   static final int[] field1787;
   @ObfuscatedName("aa")
   static final int[] field1788;
   @ObfuscatedName("ar")
   @Export("TILE_WALL_DRAW_FLAGS_1")
   static final int[] TILE_WALL_DRAW_FLAGS_1;
   @ObfuscatedName("ax")
   @Export("WALL_UNCULL_FLAGS_0")
   static final int[] WALL_UNCULL_FLAGS_0;
   @ObfuscatedName("al")
   @Export("WALL_UNCULL_FLAGS_1")
   static final int[] WALL_UNCULL_FLAGS_1;
   @ObfuscatedName("ak")
   @Export("WALL_UNCULL_FLAGS_2")
   static final int[] WALL_UNCULL_FLAGS_2;
   @ObfuscatedName("bc")
   @Export("WALL_UNCULL_FLAGS_3")
   static final int[] WALL_UNCULL_FLAGS_3;
   @ObfuscatedName("be")
   @Export("visibilityMaps")
   static boolean[][][][] visibilityMaps;
   @ObfuscatedName("br")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("bk")
   static int field1798;
   @ObfuscatedName("bn")
   static int field1799;
   @ObfuscatedName("bp")
   static int field1800;
   @ObfuscatedName("bu")
   static int field1801;
   @ObfuscatedName("by")
   static int field1802;
   @ObfuscatedName("bl")
   static int field1803;
   @ObfuscatedName("m")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("q")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("b")
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("f")
   @Export("tileHeights")
   int[][][] tileHeights;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[[[Ldh;"
   )
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("h")
   @Export("minLevel")
   int minLevel;
   @ObfuscatedName("x")
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Leg;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("a")
   @Export("tileCycles")
   int[][][] tileCycles;
   @ObfuscatedName("bo")
   @Export("TILE_MASK_2D")
   int[][] TILE_MASK_2D;
   @ObfuscatedName("bx")
   @Export("TILE_ROTATION_2D")
   int[][] TILE_ROTATION_2D;

   static {
      regionLowMemory = true;
      tileUpdateCount = 0;
      Scene_plane = 0;
      entityBuffer = new GameObject[100];
      checkClick = false;
      field1773 = 0;
      mouseX2 = 0;
      mouseY2 = 0;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
      viewportWalking = false;
      MAX_OCCLUDER_LEVELS = 4;
      levelOccluderCount = new int[MAX_OCCLUDER_LEVELS];
      levelOccluders = new Occluder[MAX_OCCLUDER_LEVELS][500];
      field1783 = 0;
      field1785 = new Occluder[500];
      tileDeque = new Deque();
      field1787 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field1788 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      TILE_WALL_DRAW_FLAGS_1 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      WALL_UNCULL_FLAGS_0 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      WALL_UNCULL_FLAGS_1 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      WALL_UNCULL_FLAGS_2 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      WALL_UNCULL_FLAGS_3 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      visibilityMaps = new boolean[8][32][51][51];
   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.minLevel = 0;
      this.entityCount = 0;
      this.objects = new GameObject[5000];
      this.TILE_MASK_2D = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.TILE_ROTATION_2D = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.maxY = var1;
      this.maxX = var2;
      this.maxZ = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.tileCycles = new int[var1][var2 + 1][var3 + 1];
      this.tileHeights = var4;
      this.reset();
   }

   @ObfuscatedName("w")
   @Export("reset")
   public void reset() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.maxY; ++var1) {
         for(var2 = 0; var2 < this.maxX; ++var2) {
            for(int var3 = 0; var3 < this.maxZ; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < MAX_OCCLUDER_LEVELS; ++var1) {
         for(var2 = 0; var2 < levelOccluderCount[var1]; ++var2) {
            levelOccluders[var1][var2] = null;
         }

         levelOccluderCount[var1] = 0;
      }

      for(var1 = 0; var1 < this.entityCount; ++var1) {
         this.objects[var1] = null;
      }

      this.entityCount = 0;

      for(var1 = 0; var1 < entityBuffer.length; ++var1) {
         entityBuffer[var1] = null;
      }

   }

   @ObfuscatedName("m")
   @Export("setup")
   public void setup(int var1) {
      this.minLevel = var1;

      for(int var2 = 0; var2 < this.maxX; ++var2) {
         for(int var3 = 0; var3 < this.maxZ; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @Export("setBridge")
   public void setBridge(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.entityCount; ++var6) {
               GameObject var7 = var5.objects[var6];
               long var9 = var7.hash;
               int var11 = (int)(var9 >>> 14 & 3L);
               boolean var8 = var11 == 2;
               if(var8 && var7.relativeX == var1 && var2 == var7.relativeY) {
                  --var7.plane;
               }
            }
         }
      }

      if(this.tiles[0][var1][var2] == null) {
         this.tiles[0][var1][var2] = new Tile(0, var1, var2);
      }

      this.tiles[0][var1][var2].bridge = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("j")
   @Export("setPhysicalLevel")
   public void setPhysicalLevel(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].physicalLevel = var4;
      }
   }

   @ObfuscatedName("a")
   @Export("addTile")
   public void addTile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      SceneTilePaint var21;
      int var22;
      if(var4 == 0) {
         var21 = new SceneTilePaint(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].paint = var21;
      } else if(var4 != 1) {
         SceneTileModel var23 = new SceneTileModel(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].overlay = var23;
      } else {
         var21 = new SceneTilePaint(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].paint = var21;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIILdz;JI)V"
   )
   @Export("groundObjectSpawned")
   public void groundObjectSpawned(int var1, int var2, int var3, int var4, Renderable var5, long var6, int var8) {
      if(var5 != null) {
         GroundObject var9 = new GroundObject();
         var9.renderable = var5;
         var9.x = var2 * 128 + 64;
         var9.y = var3 * 128 + 64;
         var9.floor = var4;
         var9.hash = var6;
         var9.renderInfoBitPacked = var8;
         if(this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
         }

         this.tiles[var1][var2][var3].groundObject = var9;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIILdz;JLdz;Ldz;)V"
   )
   @Export("addItemPile")
   public void addItemPile(int var1, int var2, int var3, int var4, Renderable var5, long var6, Renderable var8, Renderable var9) {
      ItemLayer var10 = new ItemLayer();
      var10.bottom = var5;
      var10.x = var2 * 128 + 64;
      var10.y = var3 * 128 + 64;
      var10.tileHeight = var4;
      var10.hash = var6;
      var10.middle = var8;
      var10.top = var9;
      int var11 = 0;
      Tile var12 = this.tiles[var1][var2][var3];
      if(var12 != null) {
         for(int var13 = 0; var13 < var12.entityCount; ++var13) {
            if((var12.objects[var13].flags & 256) == 256 && var12.objects[var13].renderable instanceof Model) {
               Model var14 = (Model)var12.objects[var13].renderable;
               var14.calculateBoundsCylinder();
               if(var14.modelHeight > var11) {
                  var11 = var14.modelHeight;
               }
            }
         }
      }

      var10.height = var11;
      if(this.tiles[var1][var2][var3] == null) {
         this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
      }

      this.tiles[var1][var2][var3].itemLayer = var10;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIILdz;Ldz;IIJI)V"
   )
   @Export("addBoundary")
   public void addBoundary(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, long var9, int var11) {
      if(var5 != null || var6 != null) {
         WallObject var12 = new WallObject();
         var12.hash = var9;
         var12.config = var11;
         var12.x = var2 * 128 + 64;
         var12.y = var3 * 128 + 64;
         var12.floor = var4;
         var12.renderable1 = var5;
         var12.renderable2 = var6;
         var12.orientationA = var7;
         var12.orientationB = var8;

         for(int var13 = var1; var13 >= 0; --var13) {
            if(this.tiles[var13][var2][var3] == null) {
               this.tiles[var13][var2][var3] = new Tile(var13, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var12;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIILdz;Ldz;IIIIJI)V"
   )
   @Export("addBoundaryDecoration")
   public void addBoundaryDecoration(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, long var11, int var13) {
      if(var5 != null) {
         DecorativeObject var14 = new DecorativeObject();
         var14.hash = var11;
         var14.renderInfoBitPacked = var13;
         var14.x = var2 * 128 + 64;
         var14.y = var3 * 128 + 64;
         var14.floor = var4;
         var14.renderable1 = var5;
         var14.renderable2 = var6;
         var14.renderFlag = var7;
         var14.rotation = var8;
         var14.offsetX = var9;
         var14.offsetY = var10;

         for(int var15 = var1; var15 >= 0; --var15) {
            if(this.tiles[var15][var2][var3] == null) {
               this.tiles[var15][var2][var3] = new Tile(var15, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].decorativeObject = var14;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIILdz;IJI)Z"
   )
   public boolean method2911(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, long var9, int var11) {
      if(var7 == null) {
         return true;
      } else {
         int var12 = var5 * 64 + var2 * 128;
         int var13 = var6 * 64 + var3 * 128;
         return this.addEntityMarker(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIILdz;IJZ)Z"
   )
   public boolean method2945(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, long var8, boolean var10) {
      if(var6 == null) {
         return true;
      } else {
         int var11 = var2 - var5;
         int var12 = var3 - var5;
         int var13 = var5 + var2;
         int var14 = var3 + var5;
         if(var10) {
            if(var7 > 640 && var7 < 1408) {
               var14 += 128;
            }

            if(var7 > 1152 && var7 < 1920) {
               var13 += 128;
            }

            if(var7 > 1664 || var7 < 384) {
               var12 -= 128;
            }

            if(var7 > 128 && var7 < 896) {
               var11 -= 128;
            }
         }

         var11 /= 128;
         var12 /= 128;
         var13 /= 128;
         var14 /= 128;
         return this.addEntityMarker(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIILdz;IJIIII)Z"
   )
   public boolean method2971(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, long var8, int var10, int var11, int var12, int var13) {
      return var6 == null?true:this.addEntityMarker(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILdz;IZJI)Z"
   )
   @Export("addEntityMarker")
   boolean addEntityMarker(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, long var12, int var14) {
      int var16;
      for(int var15 = var2; var15 < var2 + var4; ++var15) {
         for(var16 = var3; var16 < var3 + var5; ++var16) {
            if(var15 < 0 || var16 < 0 || var15 >= this.maxX || var16 >= this.maxZ) {
               return false;
            }

            Tile var17 = this.tiles[var1][var15][var16];
            if(var17 != null && var17.entityCount >= 5) {
               return false;
            }
         }
      }

      GameObject var21 = new GameObject();
      var21.hash = var12;
      var21.flags = var14;
      var21.plane = var1;
      var21.x = var6;
      var21.y = var7;
      var21.height = var8;
      var21.renderable = var9;
      var21.orientation = var10;
      var21.relativeX = var2;
      var21.relativeY = var3;
      var21.offsetX = var2 + var4 - 1;
      var21.offsetY = var3 + var5 - 1;

      for(var16 = var2; var16 < var2 + var4; ++var16) {
         for(int var22 = var3; var22 < var3 + var5; ++var22) {
            int var18 = 0;
            if(var16 > var2) {
               ++var18;
            }

            if(var16 < var2 + var4 - 1) {
               var18 += 4;
            }

            if(var22 > var3) {
               var18 += 8;
            }

            if(var22 < var3 + var5 - 1) {
               var18 += 2;
            }

            for(int var19 = var1; var19 >= 0; --var19) {
               if(this.tiles[var19][var16][var22] == null) {
                  this.tiles[var19][var16][var22] = new Tile(var19, var16, var22);
               }
            }

            Tile var23 = this.tiles[var1][var16][var22];
            var23.objects[var23.entityCount] = var21;
            var23.entityFlags[var23.entityCount] = var18;
            var23.flags |= var18;
            ++var23.entityCount;
         }
      }

      if(var11) {
         this.objects[this.entityCount++] = var21;
      }

      return true;
   }

   @ObfuscatedName("t")
   @Export("clearEntities")
   public void clearEntities() {
      for(int var1 = 0; var1 < this.entityCount; ++var1) {
         GameObject var2 = this.objects[var1];
         this.removeEntity(var2);
         this.objects[var1] = null;
      }

      this.entityCount = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Leg;)V"
   )
   @Export("removeEntity")
   void removeEntity(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.entityCount; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.entityCount;

                     for(int var6 = var5; var6 < var4.entityCount; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.entityFlags[var6] = var4.entityFlags[var6 + 1];
                     }

                     var4.objects[var4.entityCount] = null;
                     break;
                  }
               }

               var4.flags = 0;

               for(var5 = 0; var5 < var4.entityCount; ++var5) {
                  var4.flags |= var4.entityFlags[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   public void method3030(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var4 * var6.offsetX / 16;
            var6.offsetY = var4 * var6.offsetY / 16;
         }
      }
   }

   @ObfuscatedName("r")
   public void method2954(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   @ObfuscatedName("v")
   public void method2919(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("o")
   public void method3013(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            long var8 = var6.hash;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.relativeX && var3 == var6.relativeY) {
               this.removeEntity(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("ai")
   public void method2921(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("at")
   @Export("removeGroundItemPile")
   public void removeGroundItemPile(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)Ldq;"
   )
   public WallObject method3049(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(III)Leo;"
   )
   public DecorativeObject method2924(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(III)Leg;"
   )
   public GameObject method2925(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            long var8 = var6.hash;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.relativeX && var3 == var6.relativeY) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)Ldj;"
   )
   @Export("getFloorDecoration")
   public GroundObject getFloorDecoration(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("as")
   public long method2927(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash :0L;
   }

   @ObfuscatedName("aw")
   public long method2928(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash :0L;
   }

   @ObfuscatedName("ag")
   public long method3045(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0L;
      } else {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            long var8 = var6.hash;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.relativeX && var3 == var6.relativeY) {
               return var6.hash;
            }
         }

         return 0L;
      }
   }

   @ObfuscatedName("ah")
   public long method2930(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash :0L;
   }

   @ObfuscatedName("az")
   public int method2931(int var1, int var2, int var3, long var4) {
      Tile var6 = this.tiles[var1][var2][var3];
      if(var6 == null) {
         return -1;
      } else if(var6.wallObject != null && var6.wallObject.hash == var4) {
         return var6.wallObject.config & 255;
      } else if(var6.decorativeObject != null && var6.decorativeObject.hash == var4) {
         return var6.decorativeObject.renderInfoBitPacked & 255;
      } else if(var6.groundObject != null && var6.groundObject.hash == var4) {
         return var6.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var7 = 0; var7 < var6.entityCount; ++var7) {
            if(var6.objects[var7].hash == var4) {
               return var6.objects[var7].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ao")
   @Export("applyLighting")
   public void applyLighting(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.maxY; ++var4) {
         for(int var5 = 0; var5 < this.maxX; ++var5) {
            for(int var6 = 0; var6 < this.maxZ; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method3061(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method3061(var10, var4, var5, var6, 1, 1);
                        ModelData.method2660(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.light(var10.field1515, var10.contrast, var1, var2, var3);
                     }

                     var8.renderable1 = var9.light(var9.field1515, var9.contrast, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.entityCount; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method3061(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.light(var11.field1515, var11.contrast, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method2978(var10, var4, var5, var6);
                     var13.renderable = var10.light(var10.field1515, var10.contrast, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ldo;III)V"
   )
   void method2978(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.maxX) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2660(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.maxX) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2660(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.maxX && var4 < this.maxZ) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2660(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.maxX && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2660(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ldo;IIIII)V"
   )
   void method3061(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.maxY) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.maxX) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.maxZ && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.tileHeights[var12][var13 + 1][var14] + this.tileHeights[var12][var13 + 1][var14 + 1] + this.tileHeights[var12][var13][var14] + this.tileHeights[var12][var13][var14 + 1]) / 4 - (this.tileHeights[var2][var3 + 1][var4] + this.tileHeights[var2][var3][var4] + this.tileHeights[var2][var3 + 1][var4 + 1] + this.tileHeights[var2][var3][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method2660(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method2660(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.entityCount; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2660(var1, var20, (var21 - var5) * 64 + (var19.relativeX - var3) * 128, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("am")
   @Export("drawTile")
   public void drawTile(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         SceneTilePaint var8 = var7.paint;
         int var10;
         if(var8 != null) {
            int var9 = var8.rgb;
            if(var9 != 0) {
               for(var10 = 0; var10 < 4; ++var10) {
                  var1[var2] = var9;
                  var1[var2 + 1] = var9;
                  var1[var2 + 2] = var9;
                  var1[var2 + 3] = var9;
                  var2 += var3;
               }

            }
         } else {
            SceneTileModel var18 = var7.overlay;
            if(var18 != null) {
               var10 = var18.shape;
               int var11 = var18.rotation;
               int var12 = var18.underlay;
               int var13 = var18.overlay;
               int[] var14 = this.TILE_MASK_2D[var10];
               int[] var15 = this.TILE_ROTATION_2D[var11];
               int var16 = 0;
               int var17;
               if(var12 != 0) {
                  for(var17 = 0; var17 < 4; ++var17) {
                     var1[var2] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 1] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 2] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 3] = var14[var15[var16++]] == 0?var12:var13;
                     var2 += var3;
                  }
               } else {
                  for(var17 = 0; var17 < 4; ++var17) {
                     if(var14[var15[var16++]] != 0) {
                        var1[var2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 1] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 3] = var13;
                     }

                     var2 += var3;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("ae")
   public void method2938(int var1, int var2, int var3, boolean var4) {
      if(!method2940() || var4) {
         checkClick = true;
         viewportWalking = var4;
         field1773 = var1;
         mouseX2 = var2;
         mouseY2 = var3;
         selectedRegionTileX = -1;
         selectedRegionTileY = -1;
      }
   }

   @ObfuscatedName("au")
   public void method2939() {
      viewportWalking = true;
   }

   @ObfuscatedName("aa")
   @Export("drawRegion")
   @Hook(
      value = "drawRegion",
      end = true
   )
   public void drawRegion(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.maxX * 128) {
         var1 = this.maxX * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.maxZ * 128) {
         var3 = this.maxZ * 128 - 1;
      }

      if(var4 < 128) {
         var4 = 128;
      } else if(var4 > 383) {
         var4 = 383;
      }

      ++cycle;
      pitchSin = Graphics3D.SINE[var4];
      pitchCos = Graphics3D.COSINE[var4];
      yawSin = Graphics3D.SINE[var5];
      yawCos = Graphics3D.COSINE[var5];
      renderArea = visibilityMaps[(var4 - 128) / 32][var5 / 64];
      cameraX2 = var1;
      cameraY2 = var2;
      cameraZ2 = var3;
      screenCenterX = var1 / 128;
      screenCenterZ = var3 / 128;
      Scene_plane = var6;
      minTileX = screenCenterX - 25;
      if(minTileX < 0) {
         minTileX = 0;
      }

      minTileZ = screenCenterZ - 25;
      if(minTileZ < 0) {
         minTileZ = 0;
      }

      maxTileX = screenCenterX + 25;
      if(maxTileX > this.maxX) {
         maxTileX = this.maxX;
      }

      maxTileZ = screenCenterZ + 25;
      if(maxTileZ > this.maxZ) {
         maxTileZ = this.maxZ;
      }

      this.updateOccluders();
      tileUpdateCount = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.minLevel; var7 < this.maxY; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = minTileX; var9 < maxTileX; ++var9) {
            for(var10 = minTileZ; var10 < maxTileZ; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.physicalLevel > var6 || !renderArea[var9 - screenCenterX + 25][var10 - screenCenterZ + 25] && this.tileHeights[var7][var9][var10] - var2 < 2000) {
                     var11.draw = false;
                     var11.visible = false;
                     var11.wallCullDirection = 0;
                  } else {
                     var11.draw = true;
                     var11.visible = true;
                     if(var11.entityCount > 0) {
                        var11.drawEntities = true;
                     } else {
                        var11.drawEntities = false;
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
      for(var7 = this.minLevel; var7 < this.maxY; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = var9 + screenCenterX;
            var16 = screenCenterX - var9;
            if(var10 >= minTileX || var16 < maxTileX) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = var12 + screenCenterZ;
                  var14 = screenCenterZ - var12;
                  if(var10 >= minTileX) {
                     if(var13 >= minTileZ) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, true);
                        }
                     }

                     if(var14 < maxTileZ) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, true);
                        }
                     }
                  }

                  if(var16 < maxTileX) {
                     if(var13 >= minTileZ) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, true);
                        }
                     }

                     if(var14 < maxTileZ) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, true);
                        }
                     }
                  }

                  if(tileUpdateCount == 0) {
                     checkClick = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.minLevel; var7 < this.maxY; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = var9 + screenCenterX;
            var16 = screenCenterX - var9;
            if(var10 >= minTileX || var16 < maxTileX) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = var12 + screenCenterZ;
                  var14 = screenCenterZ - var12;
                  if(var10 >= minTileX) {
                     if(var13 >= minTileZ) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, false);
                        }
                     }

                     if(var14 < maxTileZ) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, false);
                        }
                     }
                  }

                  if(var16 < maxTileX) {
                     if(var13 >= minTileZ) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, false);
                        }
                     }

                     if(var14 < maxTileZ) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.draw) {
                           this.draw(var15, false);
                        }
                     }
                  }

                  if(tileUpdateCount == 0) {
                     checkClick = false;
                     return;
                  }
               }
            }
         }
      }

      checkClick = false;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ldh;Z)V"
   )
   @Export("draw")
   void draw(Tile var1, boolean var2) {
      tileDeque.addFront(var1);

      while(true) {
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
                           while(true) {
                              WallObject var10;
                              GameObject var12;
                              int var17;
                              int var18;
                              boolean var20;
                              int var21;
                              Tile var36;
                              while(true) {
                                 do {
                                    var3 = (Tile)tileDeque.popFront();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.visible);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.renderLevel;
                                 var8 = this.tiles[var6];
                                 if(!var3.draw) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.visible) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= screenCenterX && var4 > minTileX) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.visible && (var9.draw || (var3.flags & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= screenCenterX && var4 < maxTileX - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.visible && (var9.draw || (var3.flags & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= screenCenterZ && var5 > minTileZ) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.visible && (var9.draw || (var3.flags & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= screenCenterZ && var5 < maxTileZ - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.visible && (var9.draw || (var3.flags & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.draw = false;
                                 if(var3.bridge != null) {
                                    var9 = var3.bridge;
                                    if(var9.paint != null) {
                                       if(!this.isTileOccluded(0, var4, var5)) {
                                          this.drawTileUnderlay(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                       }
                                    } else if(var9.overlay != null && !this.isTileOccluded(0, var4, var5)) {
                                       this.drawTileOverlay(var9.overlay, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var10.x - cameraX2, var10.floor - cameraY2, var10.y - cameraZ2, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.entityCount; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.draw(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.x - cameraX2, var12.height - cameraY2, var12.y - cameraZ2, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.paint != null) {
                                    if(!this.isTileOccluded(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.paint.neColor != 12345678 || checkClick && var6 <= field1773) {
                                          this.drawTileUnderlay(var3.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                       }
                                    }
                                 } else if(var3.overlay != null && !this.isTileOccluded(var7, var4, var5)) {
                                    var20 = true;
                                    this.drawTileOverlay(var3.overlay, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(var4 == screenCenterX) {
                                       ++var21;
                                    } else if(screenCenterX < var4) {
                                       var21 += 2;
                                    }

                                    if(var5 == screenCenterZ) {
                                       var21 += 3;
                                    } else if(screenCenterZ > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field1787[var21];
                                    var3.wallDrawFlags = TILE_WALL_DRAW_FLAGS_1[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.orientationA & field1788[var21]) != 0) {
                                       if(var31.orientationA == 16) {
                                          var3.wallCullDirection = 3;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_0[var21];
                                          var3.wallCullOppositeDirection = 3 - var3.wallUncullDirection;
                                       } else if(var31.orientationA == 32) {
                                          var3.wallCullDirection = 6;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_1[var21];
                                          var3.wallCullOppositeDirection = 6 - var3.wallUncullDirection;
                                       } else if(var31.orientationA == 64) {
                                          var3.wallCullDirection = 12;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_2[var21];
                                          var3.wallCullOppositeDirection = 12 - var3.wallUncullDirection;
                                       } else {
                                          var3.wallCullDirection = 9;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_3[var21];
                                          var3.wallCullOppositeDirection = 9 - var3.wallUncullDirection;
                                       }
                                    } else {
                                       var3.wallCullDirection = 0;
                                    }

                                    if((var31.orientationA & var11) != 0 && !this.isWallOccluded(var7, var4, var5, var31.orientationA)) {
                                       var31.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var31.x - cameraX2, var31.floor - cameraY2, var31.y - cameraZ2, var31.hash);
                                    }

                                    if((var31.orientationB & var11) != 0 && !this.isWallOccluded(var7, var4, var5, var31.orientationB)) {
                                       var31.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var31.x - cameraX2, var31.floor - cameraY2, var31.y - cameraZ2, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.isOccluded(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.renderFlag & var11) != 0) {
                                       var13.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var13.x - cameraX2 + var13.offsetX, var13.floor - cameraY2, var13.y - cameraZ2 + var13.offsetY, var13.hash);
                                    } else if(var13.renderFlag == 256) {
                                       var14 = var13.x - cameraX2;
                                       var15 = var13.floor - cameraY2;
                                       var16 = var13.y - cameraZ2;
                                       var17 = var13.rotation;
                                       if(var17 != 1 && var17 != 2) {
                                          var18 = var14;
                                       } else {
                                          var18 = -var14;
                                       }

                                       int var19;
                                       if(var17 != 2 && var17 != 3) {
                                          var19 = var16;
                                       } else {
                                          var19 = -var16;
                                       }

                                       if(var19 < var18) {
                                          var13.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var14 + var13.offsetX, var15, var16 + var13.offsetY, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, var22.x - cameraX2, var22.floor - cameraY2, var22.y - cameraZ2, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, var23.x - cameraX2, var23.tileHeight - cameraY2, var23.y - cameraZ2, var23.hash);
                                       }

                                       if(var23.top != null) {
                                          var23.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, var23.x - cameraX2, var23.tileHeight - cameraY2, var23.y - cameraZ2, var23.hash);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, var23.x - cameraX2, var23.tileHeight - cameraY2, var23.y - cameraZ2, var23.hash);
                                       }
                                    }
                                 }

                                 var14 = var3.flags;
                                 if(var14 != 0) {
                                    if(var4 < screenCenterX && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.visible) {
                                          tileDeque.addFront(var36);
                                       }
                                    }

                                    if(var5 < screenCenterZ && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.visible) {
                                          tileDeque.addFront(var36);
                                       }
                                    }

                                    if(var4 > screenCenterX && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.visible) {
                                          tileDeque.addFront(var36);
                                       }
                                    }

                                    if(var5 > screenCenterZ && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.visible) {
                                          tileDeque.addFront(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.wallCullDirection != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.entityCount; ++var21) {
                                    if(var3.objects[var21].cycle != cycle && (var3.entityFlags[var21] & var3.wallCullDirection) == var3.wallUncullDirection) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.isWallOccluded(var7, var4, var5, var10.orientationA)) {
                                       var10.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var10.x - cameraX2, var10.floor - cameraY2, var10.y - cameraZ2, var10.hash);
                                    }

                                    var3.wallCullDirection = 0;
                                 }
                              }

                              if(!var3.drawEntities) {
                                 break;
                              }

                              try {
                                 int var34 = var3.entityCount;
                                 var3.drawEntities = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.cycle != cycle) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.draw) {
                                                var3.drawEntities = true;
                                                continue label563;
                                             }

                                             if(var36.wallCullDirection != 0) {
                                                var16 = 0;
                                                if(var24 > var12.relativeX) {
                                                   ++var16;
                                                }

                                                if(var24 < var12.offsetX) {
                                                   var16 += 4;
                                                }

                                                if(var14 > var12.relativeY) {
                                                   var16 += 8;
                                                }

                                                if(var14 < var12.offsetY) {
                                                   var16 += 2;
                                                }

                                                if((var16 & var36.wallCullDirection) == var3.wallCullOppositeDirection) {
                                                   var3.drawEntities = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       entityBuffer[var21++] = var12;
                                       var24 = screenCenterX - var12.relativeX;
                                       var14 = var12.offsetX - screenCenterX;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = screenCenterZ - var12.relativeY;
                                       var16 = var12.offsetY - screenCenterZ;
                                       if(var16 > var15) {
                                          var12.drawPriority = var24 + var16;
                                       } else {
                                          var12.drawPriority = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = entityBuffer[var24];
                                       if(var35.cycle != cycle) {
                                          if(var35.drawPriority > var11) {
                                             var11 = var35.drawPriority;
                                             var25 = var24;
                                          } else if(var11 == var35.drawPriority) {
                                             var15 = var35.x - cameraX2;
                                             var16 = var35.y - cameraZ2;
                                             var17 = entityBuffer[var25].x - cameraX2;
                                             var18 = entityBuffer[var25].y - cameraZ2;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = entityBuffer[var25];
                                    var33.cycle = cycle;
                                    if(!this.isAreaOccluded(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.draw(var33.orientation, pitchSin, pitchCos, yawSin, yawCos, var33.x - cameraX2, var33.height - cameraY2, var33.y - cameraZ2, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.wallCullDirection != 0) {
                                             tileDeque.addFront(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.visible) {
                                             tileDeque.addFront(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.drawEntities) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.drawEntities = false;
                                 break;
                              }
                           }
                        } while(!var3.visible);
                     } while(var3.wallCullDirection != 0);

                     if(var4 > screenCenterX || var4 <= minTileX) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.visible);

                  if(var4 < screenCenterX || var4 >= maxTileX - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.visible);

               if(var5 > screenCenterZ || var5 <= minTileZ) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.visible);

            if(var5 < screenCenterZ || var5 >= maxTileZ - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.visible);

         var3.visible = false;
         --tileUpdateCount;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, var32.x - cameraX2, var32.tileHeight - cameraY2 - var32.height, var32.y - cameraZ2, var32.hash);
            }

            if(var32.top != null) {
               var32.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, var32.x - cameraX2, var32.tileHeight - cameraY2 - var32.height, var32.y - cameraZ2, var32.hash);
            }

            if(var32.bottom != null) {
               var32.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, var32.x - cameraX2, var32.tileHeight - cameraY2 - var32.height, var32.y - cameraZ2, var32.hash);
            }
         }

         if(var3.wallDrawFlags != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.isOccluded(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.wallDrawFlags) != 0) {
                  var29.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var29.x - cameraX2 + var29.offsetX, var29.floor - cameraY2, var29.y - cameraZ2 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - cameraX2;
                  var25 = var29.floor - cameraY2;
                  var24 = var29.y - cameraZ2;
                  var14 = var29.rotation;
                  if(var14 != 1 && var14 != 2) {
                     var15 = var11;
                  } else {
                     var15 = -var11;
                  }

                  if(var14 != 2 && var14 != 3) {
                     var16 = var24;
                  } else {
                     var16 = -var24;
                  }

                  if(var16 >= var15) {
                     var29.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.orientationB & var3.wallDrawFlags) != 0 && !this.isWallOccluded(var7, var4, var5, var27.orientationB)) {
                  var27.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var27.x - cameraX2, var27.floor - cameraY2, var27.y - cameraZ2, var27.hash);
               }

               if((var27.orientationA & var3.wallDrawFlags) != 0 && !this.isWallOccluded(var7, var4, var5, var27.orientationA)) {
                  var27.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var27.x - cameraX2, var27.floor - cameraY2, var27.y - cameraZ2, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.maxY - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.visible) {
               tileDeque.addFront(var30);
            }
         }

         if(var4 < screenCenterX) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.visible) {
               tileDeque.addFront(var30);
            }
         }

         if(var5 < screenCenterZ) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.visible) {
               tileDeque.addFront(var30);
            }
         }

         if(var4 > screenCenterX) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.visible) {
               tileDeque.addFront(var30);
            }
         }

         if(var5 > screenCenterZ) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.visible) {
               tileDeque.addFront(var30);
            }
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ldi;IIIIIII)V"
   )
   @Export("drawTileUnderlay")
   void drawTileUnderlay(SceneTilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - cameraX2;
      int var11;
      int var12 = var11 = (var8 << 7) - cameraZ2;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.tileHeights[var2][var7][var8] - cameraY2;
      int var18 = this.tileHeights[var2][var7 + 1][var8] - cameraY2;
      int var19 = this.tileHeights[var2][var7 + 1][var8 + 1] - cameraY2;
      int var20 = this.tileHeights[var2][var7][var8 + 1] - cameraY2;
      int var21 = var10 * var6 + var5 * var12 >> 16;
      var12 = var12 * var6 - var5 * var10 >> 16;
      var10 = var21;
      var21 = var17 * var4 - var3 * var12 >> 16;
      var12 = var3 * var17 + var12 * var4 >> 16;
      var17 = var21;
      if(var12 >= 50) {
         var21 = var14 * var6 + var5 * var11 >> 16;
         var11 = var11 * var6 - var5 * var14 >> 16;
         var14 = var21;
         var21 = var18 * var4 - var3 * var11 >> 16;
         var11 = var3 * var18 + var11 * var4 >> 16;
         var18 = var21;
         if(var11 >= 50) {
            var21 = var13 * var6 + var5 * var16 >> 16;
            var16 = var16 * var6 - var5 * var13 >> 16;
            var13 = var21;
            var21 = var19 * var4 - var3 * var16 >> 16;
            var16 = var3 * var19 + var16 * var4 >> 16;
            var19 = var21;
            if(var16 >= 50) {
               var21 = var9 * var6 + var5 * var15 >> 16;
               var15 = var15 * var6 - var5 * var9 >> 16;
               var9 = var21;
               var21 = var20 * var4 - var3 * var15 >> 16;
               var15 = var3 * var20 + var15 * var4 >> 16;
               if(var15 >= 50) {
                  int var22 = var10 * Graphics3D.Rasterizer3D_zoom / var12 + Graphics3D.centerX;
                  int var23 = var17 * Graphics3D.Rasterizer3D_zoom / var12 + Graphics3D.centerY;
                  int var24 = var14 * Graphics3D.Rasterizer3D_zoom / var11 + Graphics3D.centerX;
                  int var25 = var18 * Graphics3D.Rasterizer3D_zoom / var11 + Graphics3D.centerY;
                  int var26 = var13 * Graphics3D.Rasterizer3D_zoom / var16 + Graphics3D.centerX;
                  int var27 = var19 * Graphics3D.Rasterizer3D_zoom / var16 + Graphics3D.centerY;
                  int var28 = var9 * Graphics3D.Rasterizer3D_zoom / var15 + Graphics3D.centerX;
                  int var29 = var21 * Graphics3D.Rasterizer3D_zoom / var15 + Graphics3D.centerY;
                  Graphics3D.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > Graphics3D.rasterClipX || var28 > Graphics3D.rasterClipX || var24 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if(checkClick && method2947(mouseX2, mouseY2, var27, var29, var25, var26, var28, var24)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.neColor != 12345678) {
                           Graphics3D.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor);
                        }
                     } else if(!regionLowMemory) {
                        if(var1.flatShade) {
                           Graphics3D.rasterTexture(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                        } else {
                           Graphics3D.rasterTexture(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                        }
                     } else {
                        var30 = Graphics3D.textureLoader.getAverageTextureRGB(var1.texture);
                        Graphics3D.rasterGouraud(var27, var29, var25, var26, var28, var24, method2946(var30, var1.neColor), method2946(var30, var1.nwColor), method2946(var30, var1.seColor));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > Graphics3D.rasterClipX || var24 > Graphics3D.rasterClipX || var28 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if(checkClick && method2947(mouseX2, mouseY2, var23, var25, var29, var22, var24, var28)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.swColor != 12345678) {
                           Graphics3D.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor);
                        }
                     } else if(!regionLowMemory) {
                        Graphics3D.rasterTexture(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                     } else {
                        var30 = Graphics3D.textureLoader.getAverageTextureRGB(var1.texture);
                        Graphics3D.rasterGouraud(var23, var25, var29, var22, var24, var28, method2946(var30, var1.swColor), method2946(var30, var1.seColor), method2946(var30, var1.nwColor));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lde;IIIIII)V"
   )
   @Export("drawTileOverlay")
   void drawTileOverlay(SceneTileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.vertexX.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.vertexX[var9] - cameraX2;
         var11 = var1.vertexY[var9] - cameraY2;
         var12 = var1.vertexZ[var9] - cameraZ2;
         var13 = var12 * var4 + var5 * var10 >> 16;
         var12 = var5 * var12 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var3 * var11 - var12 * var2 >> 16;
         var12 = var11 * var2 + var3 * var12 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.triangleTextureId != null) {
            SceneTileModel.vertexSceneX[var9] = var10;
            SceneTileModel.vertexSceneY[var9] = var13;
            SceneTileModel.vertexSceneZ[var9] = var12;
         }

         SceneTileModel.tmpScreenX[var9] = var10 * Graphics3D.Rasterizer3D_zoom / var12 + Graphics3D.centerX;
         SceneTileModel.tmpScreenY[var9] = var13 * Graphics3D.Rasterizer3D_zoom / var12 + Graphics3D.centerY;
      }

      Graphics3D.rasterAlpha = 0;
      var8 = var1.field1534.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1534[var9];
         var11 = var1.field1535[var9];
         var12 = var1.field1536[var9];
         var13 = SceneTileModel.tmpScreenX[var10];
         int var14 = SceneTileModel.tmpScreenX[var11];
         int var15 = SceneTileModel.tmpScreenX[var12];
         int var16 = SceneTileModel.tmpScreenY[var10];
         int var17 = SceneTileModel.tmpScreenY[var11];
         int var18 = SceneTileModel.tmpScreenY[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            Graphics3D.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > Graphics3D.rasterClipX || var14 > Graphics3D.rasterClipX || var15 > Graphics3D.rasterClipX) {
               Graphics3D.rasterClipEnable = true;
            }

            if(checkClick && method2947(mouseX2, mouseY2, var16, var17, var18, var13, var14, var15)) {
               selectedRegionTileX = var6;
               selectedRegionTileY = var7;
            }

            if(var1.triangleTextureId != null && var1.triangleTextureId[var9] != -1) {
               if(!regionLowMemory) {
                  if(var1.flatShade) {
                     Graphics3D.rasterTexture(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.vertexSceneX[0], SceneTileModel.vertexSceneX[1], SceneTileModel.vertexSceneX[3], SceneTileModel.vertexSceneY[0], SceneTileModel.vertexSceneY[1], SceneTileModel.vertexSceneY[3], SceneTileModel.vertexSceneZ[0], SceneTileModel.vertexSceneZ[1], SceneTileModel.vertexSceneZ[3], var1.triangleTextureId[var9]);
                  } else {
                     Graphics3D.rasterTexture(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.vertexSceneX[var10], SceneTileModel.vertexSceneX[var11], SceneTileModel.vertexSceneX[var12], SceneTileModel.vertexSceneY[var10], SceneTileModel.vertexSceneY[var11], SceneTileModel.vertexSceneY[var12], SceneTileModel.vertexSceneZ[var10], SceneTileModel.vertexSceneZ[var11], SceneTileModel.vertexSceneZ[var12], var1.triangleTextureId[var9]);
                  }
               } else {
                  int var19 = Graphics3D.textureLoader.getAverageTextureRGB(var1.triangleTextureId[var9]);
                  Graphics3D.rasterGouraud(var16, var17, var18, var13, var14, var15, method2946(var19, var1.triangleColorA[var9]), method2946(var19, var1.triangleColorB[var9]), method2946(var19, var1.triangleColorC[var9]));
               }
            } else if(var1.triangleColorA[var9] != 12345678) {
               Graphics3D.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9]);
            }
         }
      }

   }

   @ObfuscatedName("bo")
   @Export("updateOccluders")
   void updateOccluders() {
      int var1 = levelOccluderCount[Scene_plane];
      Occluder[] var2 = levelOccluders[Scene_plane];
      field1783 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         Occluder var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.type == 1) {
            var5 = var4.minTileX - screenCenterX + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.minTileZ - screenCenterZ + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTileZ - screenCenterZ + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(renderArea[var5][var6++]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = cameraX2 - var4.minX;
                  if(var9 > 32) {
                     var4.testDirection = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.testDirection = 2;
                     var9 = -var9;
                  }

                  var4.minNormalX = (var4.minZ - cameraZ2 << 8) / var9;
                  var4.maxNormalX = (var4.maxZ - cameraZ2 << 8) / var9;
                  var4.minNormalY = (var4.minY - cameraY2 << 8) / var9;
                  var4.maxNormalY = (var4.maxY - cameraY2 << 8) / var9;
                  field1785[field1783++] = var4;
               }
            }
         } else if(var4.type == 2) {
            var5 = var4.minTileZ - screenCenterZ + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.minTileX - screenCenterX + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTIleX - screenCenterX + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(renderArea[var6++][var5]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = cameraZ2 - var4.minZ;
                  if(var9 > 32) {
                     var4.testDirection = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.testDirection = 4;
                     var9 = -var9;
                  }

                  var4.field1827 = (var4.minX - cameraX2 << 8) / var9;
                  var4.field1839 = (var4.maxX - cameraX2 << 8) / var9;
                  var4.minNormalY = (var4.minY - cameraY2 << 8) / var9;
                  var4.maxNormalY = (var4.maxY - cameraY2 << 8) / var9;
                  field1785[field1783++] = var4;
               }
            }
         } else if(var4.type == 4) {
            var5 = var4.minY - cameraY2;
            if(var5 > 128) {
               var6 = var4.minTileZ - screenCenterZ + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTileZ - screenCenterZ + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.minTileX - screenCenterX + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.maxTIleX - screenCenterX + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label165:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label165;
                        }
                     }
                  }

                  if(var10) {
                     var4.testDirection = 5;
                     var4.field1827 = (var4.minX - cameraX2 << 8) / var5;
                     var4.field1839 = (var4.maxX - cameraX2 << 8) / var5;
                     var4.minNormalX = (var4.minZ - cameraZ2 << 8) / var5;
                     var4.maxNormalX = (var4.maxZ - cameraZ2 << 8) / var5;
                     field1785[field1783++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bx")
   @Export("isTileOccluded")
   boolean isTileOccluded(int var1, int var2, int var3) {
      int var4 = this.tileCycles[var1][var2][var3];
      if(var4 == -cycle) {
         return false;
      } else if(var4 == cycle) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.isOccluded(var5 + 1, this.tileHeights[var1][var2][var3], var6 + 1) && this.isOccluded(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3], var6 + 1) && this.isOccluded(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.isOccluded(var5 + 1, this.tileHeights[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.tileCycles[var1][var2][var3] = cycle;
            return true;
         } else {
            this.tileCycles[var1][var2][var3] = -cycle;
            return false;
         }
      }
   }

   @ObfuscatedName("be")
   @Export("isWallOccluded")
   boolean isWallOccluded(int var1, int var2, int var3, int var4) {
      if(!this.isTileOccluded(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.tileHeights[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > cameraX2) {
                  if(!this.isOccluded(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.isOccluded(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.isOccluded(var5, var9, var6)) {
                  return false;
               }

               if(!this.isOccluded(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < cameraZ2) {
                  if(!this.isOccluded(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.isOccluded(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.isOccluded(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.isOccluded(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < cameraX2) {
                  if(!this.isOccluded(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.isOccluded(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.isOccluded(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.isOccluded(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > cameraZ2) {
                  if(!this.isOccluded(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.isOccluded(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.isOccluded(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.isOccluded(var5, var9, var6)) {
                  return false;
               }

               if(!this.isOccluded(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.isOccluded(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.isOccluded(var5, var9, var6 + 128):(var4 == 32?this.isOccluded(var5 + 128, var9, var6 + 128):(var4 == 64?this.isOccluded(var5 + 128, var9, var6):(var4 == 128?this.isOccluded(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("br")
   @Export("isOccluded")
   boolean isOccluded(int var1, int var2, int var3, int var4) {
      if(!this.isTileOccluded(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.isOccluded(var5 + 1, this.tileHeights[var1][var2][var3] - var4, var6 + 1) && this.isOccluded(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3] - var4, var6 + 1) && this.isOccluded(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.isOccluded(var5 + 1, this.tileHeights[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bk")
   @Export("isAreaOccluded")
   boolean isAreaOccluded(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var3 == var2 && var5 == var4) {
         if(!this.isTileOccluded(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.isOccluded(var7 + 1, this.tileHeights[var1][var2][var4] - var6, var8 + 1) && this.isOccluded(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4] - var6, var8 + 1) && this.isOccluded(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.isOccluded(var7 + 1, this.tileHeights[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.tileCycles[var1][var7][var8] == -cycle) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.tileHeights[var1][var2][var4] - var6;
         if(!this.isOccluded(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.isOccluded(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.isOccluded(var7, var9, var11)) {
                  return false;
               } else if(!this.isOccluded(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("bn")
   @Export("isOccluded")
   boolean isOccluded(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1783; ++var4) {
         Occluder var5 = field1785[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.testDirection == 1) {
            var6 = var5.minX - var1;
            if(var6 > 0) {
               var7 = (var6 * var5.minNormalX >> 8) + var5.minZ;
               var8 = (var6 * var5.maxNormalX >> 8) + var5.maxZ;
               var9 = (var6 * var5.minNormalY >> 8) + var5.minY;
               var10 = (var6 * var5.maxNormalY >> 8) + var5.maxY;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 2) {
            var6 = var1 - var5.minX;
            if(var6 > 0) {
               var7 = (var6 * var5.minNormalX >> 8) + var5.minZ;
               var8 = (var6 * var5.maxNormalX >> 8) + var5.maxZ;
               var9 = (var6 * var5.minNormalY >> 8) + var5.minY;
               var10 = (var6 * var5.maxNormalY >> 8) + var5.maxY;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 3) {
            var6 = var5.minZ - var3;
            if(var6 > 0) {
               var7 = (var6 * var5.field1827 >> 8) + var5.minX;
               var8 = (var6 * var5.field1839 >> 8) + var5.maxX;
               var9 = (var6 * var5.minNormalY >> 8) + var5.minY;
               var10 = (var6 * var5.maxNormalY >> 8) + var5.maxY;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 4) {
            var6 = var3 - var5.minZ;
            if(var6 > 0) {
               var7 = (var6 * var5.field1827 >> 8) + var5.minX;
               var8 = (var6 * var5.field1839 >> 8) + var5.maxX;
               var9 = (var6 * var5.minNormalY >> 8) + var5.minY;
               var10 = (var6 * var5.maxNormalY >> 8) + var5.maxY;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 5) {
            var6 = var2 - var5.minY;
            if(var6 > 0) {
               var7 = (var6 * var5.field1827 >> 8) + var5.minX;
               var8 = (var6 * var5.field1839 >> 8) + var5.maxX;
               var9 = (var6 * var5.minNormalX >> 8) + var5.minZ;
               var10 = (var6 * var5.maxNormalX >> 8) + var5.maxZ;
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("x")
   @Export("addOcclude")
   public static void addOcclude(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      Occluder var8 = new Occluder();
      var8.minTileX = var2 / 128;
      var8.maxTIleX = var3 / 128;
      var8.minTileZ = var4 / 128;
      var8.maxTileZ = var5 / 128;
      var8.type = var1;
      var8.minX = var2;
      var8.maxX = var3;
      var8.minZ = var4;
      var8.maxZ = var5;
      var8.minY = var6;
      var8.maxY = var7;
      levelOccluders[var0][levelOccluderCount[var0]++] = var8;
   }

   @ObfuscatedName("aq")
   @Export("buildVisibilityMaps")
   public static void buildVisibilityMaps(int[] var0, int var1, int var2, int var3, int var4) {
      field1800 = 0;
      field1801 = 0;
      field1802 = var3;
      field1803 = var4;
      field1798 = var3 / 2;
      field1799 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            pitchSin = Graphics3D.SINE[var6];
            pitchCos = Graphics3D.COSINE[var6];
            yawSin = Graphics3D.SINE[var7];
            yawCos = Graphics3D.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2937(var12, var0[var8] + var15, var13)) {
                        var14 = true;
                        break;
                     }
                  }

                  var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
               }
            }
         }
      }

      for(var6 = 0; var6 < 8; ++var6) {
         for(var7 = 0; var7 < 32; ++var7) {
            for(var8 = -25; var8 < 25; ++var8) {
               for(var9 = -25; var9 < 25; ++var9) {
                  boolean var16 = false;

                  label76:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }
                     }
                  }

                  visibilityMaps[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("aj")
   static boolean method2937(int var0, int var1, int var2) {
      int var3 = var0 * yawCos + var2 * yawSin >> 16;
      int var4 = var2 * yawCos - var0 * yawSin >> 16;
      int var5 = var4 * pitchCos + pitchSin * var1 >> 16;
      int var6 = pitchCos * var1 - var4 * pitchSin >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = var3 * 390 / var5 + field1798;
         int var8 = var6 * 390 / var5 + field1799;
         return var7 >= field1800 && var7 <= field1802 && var8 >= field1801 && var8 <= field1803;
      } else {
         return false;
      }
   }

   @ObfuscatedName("av")
   public static boolean method2940() {
      return viewportWalking && selectedRegionTileX != -1;
   }

   @ObfuscatedName("ab")
   public static void method2941() {
      selectedRegionTileX = -1;
      viewportWalking = false;
   }

   @ObfuscatedName("ak")
   static final int method2946(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }

   @ObfuscatedName("bc")
   static boolean method2947(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 < var2 && var1 < var3 && var1 < var4) {
         return false;
      } else if(var1 > var2 && var1 > var3 && var1 > var4) {
         return false;
      } else if(var0 < var5 && var0 < var6 && var0 < var7) {
         return false;
      } else if(var0 > var5 && var0 > var6 && var0 > var7) {
         return false;
      } else {
         int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
         int var9 = (var7 - var6) * (var1 - var3) - (var0 - var6) * (var4 - var3);
         int var10 = (var5 - var7) * (var1 - var4) - (var2 - var4) * (var0 - var7);
         return var8 == 0?(var9 != 0?(var9 < 0?var10 <= 0:var10 >= 0):true):(var8 < 0?var9 <= 0 && var10 <= 0:var9 >= 0 && var10 >= 0);
      }
   }
}

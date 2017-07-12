import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Region")
public class Region {
   @ObfuscatedName("y")
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("af")
   @Export("WALL_UNCULL_FLAGS_1")
   static final int[] WALL_UNCULL_FLAGS_1;
   @ObfuscatedName("a")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("t")
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("s")
   @Export("tileHeights")
   int[][][] tileHeights;
   @ObfuscatedName("r")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("au")
   @Export("checkClick")
   static boolean checkClick;
   @ObfuscatedName("ai")
   @Export("yawCos")
   static int yawCos;
   @ObfuscatedName("j")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("k")
   @Export("tileCycles")
   int[][][] tileCycles;
   @ObfuscatedName("bg")
   static int field2078;
   @ObfuscatedName("h")
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("m")
   static int field2083;
   @ObfuscatedName("b")
   @Export("cycle")
   static int cycle;
   @ObfuscatedName("f")
   @Export("minTileX")
   static int minTileX;
   @ObfuscatedName("n")
   @Export("maxTileX")
   static int maxTileX;
   @ObfuscatedName("u")
   @Export("minTileZ")
   static int minTileZ;
   @ObfuscatedName("bt")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("w")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("d")
   @Export("screenCenterZ")
   static int screenCenterZ;
   @ObfuscatedName("ae")
   static final int[] field2091;
   @ObfuscatedName("an")
   @Export("entityBuffer")
   static GameObject[] entityBuffer;
   @ObfuscatedName("aa")
   @Export("levelOccluders")
   static Occluder[][] levelOccluders;
   @ObfuscatedName("i")
   @Export("lowMemory")
   public static boolean lowMemory;
   @ObfuscatedName("ab")
   @Export("pitchCos")
   static int pitchCos;
   @ObfuscatedName("br")
   static int field2096;
   @ObfuscatedName("x")
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("q")
   @Export("screenCenterX")
   static int screenCenterX;
   @ObfuscatedName("al")
   @Export("tileDeque")
   static Deque tileDeque;
   @ObfuscatedName("ar")
   static int field2100;
   @ObfuscatedName("ay")
   @Export("mouseX")
   static int mouseX;
   @ObfuscatedName("ao")
   @Export("mouseY")
   static int mouseY;
   @ObfuscatedName("as")
   @Export("selectedRegionTileX")
   public static int selectedRegionTileX;
   @ObfuscatedName("ak")
   @Export("selectedRegionTileY")
   public static int selectedRegionTileY;
   @ObfuscatedName("aq")
   @Export("viewportWalking")
   static boolean viewportWalking;
   @ObfuscatedName("at")
   @Export("MAX_OCCLUDER_LEVELS")
   static int MAX_OCCLUDER_LEVELS;
   @ObfuscatedName("av")
   @Export("levelOccluderCount")
   static int[] levelOccluderCount;
   @ObfuscatedName("ag")
   @Export("TILE_WALL_DRAW_FLAGS_1")
   static final int[] TILE_WALL_DRAW_FLAGS_1;
   @ObfuscatedName("am")
   static int field2111;
   @ObfuscatedName("az")
   static Occluder[] field2112;
   @ObfuscatedName("ap")
   @Export("WALL_UNCULL_FLAGS_0")
   static final int[] WALL_UNCULL_FLAGS_0;
   @ObfuscatedName("ad")
   static final int[] field2114;
   @ObfuscatedName("ah")
   @Export("pitchSin")
   static int pitchSin;
   @ObfuscatedName("bp")
   static int field2117;
   @ObfuscatedName("p")
   @Export("maxTileZ")
   static int maxTileZ;
   @ObfuscatedName("aj")
   @Export("WALL_UNCULL_FLAGS_2")
   static final int[] WALL_UNCULL_FLAGS_2;
   @ObfuscatedName("bb")
   @Export("WALL_UNCULL_FLAGS_3")
   static final int[] WALL_UNCULL_FLAGS_3;
   @ObfuscatedName("bc")
   @Export("TILE_MASK_2D")
   int[][] TILE_MASK_2D;
   @ObfuscatedName("be")
   @Export("TILE_ROTATION_2D")
   int[][] TILE_ROTATION_2D;
   @ObfuscatedName("bv")
   @Export("visibilityMaps")
   static boolean[][][][] visibilityMaps;
   @ObfuscatedName("aw")
   @Export("yawSin")
   static int yawSin;
   @ObfuscatedName("bl")
   static int field2125;
   @ObfuscatedName("g")
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("v")
   @Export("minLevel")
   int minLevel;
   @ObfuscatedName("c")
   @Export("tileUpdateCount")
   static int tileUpdateCount;
   @ObfuscatedName("bo")
   static int field2129;
   @ObfuscatedName("bw")
   static int field2130;

   @ObfuscatedName("d")
   public void method2666(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }

   }

   @ObfuscatedName("i")
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

   @ObfuscatedName("r")
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

   @ObfuscatedName("t")
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

   @ObfuscatedName("s")
   @Export("setPhysicalLevel")
   public void setPhysicalLevel(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].physicalLevel = var4;
      }

   }

   @ObfuscatedName("aa")
   public void method2672() {
      viewportWalking = true;
   }

   @ObfuscatedName("v")
   @Export("groundObjectSpawned")
   public void groundObjectSpawned(int var1, int var2, int var3, int var4, Renderable var5, int var6, int var7) {
      if(var5 != null) {
         GroundObject var8 = new GroundObject();
         var8.renderable = var5;
         var8.x = var2 * 128 + 64;
         var8.y = var3 * 128 + 64;
         var8.floor = var4;
         var8.hash = var6;
         var8.renderInfoBitPacked = var7;
         if(this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
         }

         this.tiles[var1][var2][var3].groundObject = var8;
      }

   }

   @ObfuscatedName("j")
   @Export("addBoundary")
   public void addBoundary(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.config = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.orientationA = var7;
         var11.orientationB = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }

   }

   @ObfuscatedName("k")
   @Export("addBoundaryDecoration")
   public void addBoundaryDecoration(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      if(var5 != null) {
         DecorativeObject var13 = new DecorativeObject();
         var13.hash = var11;
         var13.renderInfoBitPacked = var12;
         var13.x = var2 * 128 + 64;
         var13.y = var3 * 128 + 64;
         var13.floor = var4;
         var13.renderable1 = var5;
         var13.renderable2 = var6;
         var13.renderFlag = var7;
         var13.rotation = var8;
         var13.offsetX = var9;
         var13.offsetY = var10;

         for(int var14 = var1; var14 >= 0; --var14) {
            if(this.tiles[var14][var2][var3] == null) {
               this.tiles[var14][var2][var3] = new Tile(var14, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].decorativeObject = var13;
      }

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

   @ObfuscatedName("o")
   public boolean method2677(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
      if(var6 == null) {
         return true;
      } else {
         int var10 = var2 - var5;
         int var11 = var3 - var5;
         int var12 = var5 + var2;
         int var13 = var3 + var5;
         if(var9) {
            if(var7 > 640 && var7 < 1408) {
               var13 += 128;
            }

            if(var7 > 1152 && var7 < 1920) {
               var12 += 128;
            }

            if(var7 > 1664 || var7 < 384) {
               var11 -= 128;
            }

            if(var7 > 128 && var7 < 896) {
               var10 -= 128;
            }
         }

         var10 /= 128;
         var11 /= 128;
         var12 /= 128;
         var13 /= 128;
         return this.addEntityMarker(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("z")
   public boolean method2678(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.addEntityMarker(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("e")
   public boolean method2679(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = 64 * var5 + var2 * 128;
         int var12 = var6 * 64 + var3 * 128;
         return this.addEntityMarker(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("c")
   @Export("clearEntities")
   public void clearEntities() {
      for(int var1 = 0; var1 < this.entityCount; ++var1) {
         GameObject var2 = this.objects[var1];
         this.removeEntity(var2);
         this.objects[var1] = null;
      }

      this.entityCount = 0;
   }

   @ObfuscatedName("b")
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

   @ObfuscatedName("p")
   public void method2685(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var3 == var6.relativeY) {
               this.removeEntity(var6);
               return;
            }
         }
      }

   }

   @ObfuscatedName("q")
   public void method2686(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }

   }

   @ObfuscatedName("h")
   public WallObject method2688(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("g")
   public DecorativeObject method2689(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("x")
   public GameObject method2690(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var3 == var6.relativeY) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ai")
   public GroundObject method2691(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("an")
   public int method2692(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("n")
   public void method2693(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }

   }

   @ObfuscatedName("ar")
   public int method2694(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.entityCount; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var3 == var6.relativeY) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("ay")
   public int method2695(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("ao")
   public int method2696(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.config & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.entityCount; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   @Export("applyLighting")
   public void applyLighting(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.maxY; ++var4) {
         for(int var5 = 0; var5 < this.maxX; ++var5) {
            for(int var6 = 0; var6 < this.maxZ; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var9;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var10 = (ModelData)var8.renderable1;
                     this.method2699(var10, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var9 = (ModelData)var8.renderable2;
                        this.method2699(var9, var4, var5, var6, 1, 1);
                        ModelData.method2423(var10, var9, 0, 0, 0, false);
                        var8.renderable2 = var9.light(var9.field1801, var9.contrast, var1, var2, var3);
                     }

                     var8.renderable1 = var10.light(var10.field1801, var10.contrast, var1, var2, var3);
                  }

                  for(int var13 = 0; var13 < var7.entityCount; ++var13) {
                     GameObject var11 = var7.objects[var13];
                     if(var11 != null && var11.renderable instanceof ModelData) {
                        ModelData var12 = (ModelData)var11.renderable;
                        this.method2699(var12, var4, var5, var6, var11.offsetX - var11.relativeX + 1, var11.offsetY - var11.relativeY + 1);
                        var11.renderable = var12.light(var12.field1801, var12.contrast, var1, var2, var3);
                     }
                  }

                  GroundObject var14 = var7.groundObject;
                  if(var14 != null && var14.renderable instanceof ModelData) {
                     var9 = (ModelData)var14.renderable;
                     this.method2698(var9, var4, var5, var6);
                     var14.renderable = var9.light(var9.field1801, var9.contrast, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ak")
   void method2698(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.maxX) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.maxX) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.maxX && var4 < this.maxZ) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.maxX && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("aq")
   void method2699(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(this.maxY != var12) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.maxX) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.maxZ && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.tileHeights[var12][var13][var14 + 1] + this.tileHeights[var12][var13 + 1][var14] + this.tileHeights[var12][var13][var14] + this.tileHeights[var12][var13 + 1][var14 + 1]) / 4 - (this.tileHeights[var2][var3 + 1][var4 + 1] + this.tileHeights[var2][var3][var4] + this.tileHeights[var2][var3 + 1][var4] + this.tileHeights[var2][var3][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method2423(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (1 - var6) * 64 + (var14 - var4) * 128, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method2423(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (1 - var6) * 64 + (var14 - var4) * 128, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.entityCount; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2423(var1, var20, (var21 - var5) * 64 + (var19.relativeX - var3) * 128, var16, (var22 - var6) * 64 + (var19.relativeY - var4) * 128, var7);
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
   public static void method2701(int[] var0, int var1, int var2, int var3, int var4) {
      field2096 = 0;
      field2078 = 0;
      field2129 = var3;
      field2130 = var4;
      field2125 = var3 / 2;
      field2117 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            pitchSin = Graphics3D.SINE[var6];
            pitchCos = Graphics3D.COSINE[var6];
            yawSin = Graphics3D.SINE[var7];
            yawCos = Graphics3D.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var12 = -26; var12 <= 26; ++var12) {
               for(var10 = -26; var10 <= 26; ++var10) {
                  var11 = var12 * 128;
                  int var13 = var10 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2702(var11, var15 + var0[var8], var13)) {
                        var14 = true;
                        break;
                     }
                  }

                  var5[var8][var9][var12 + 25 + 1][var10 + 25 + 1] = var14;
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
                  for(var10 = -1; var10 <= 1; ++var10) {
                     for(var11 = -1; var11 <= 1; ++var11) {
                        if(var5[var6][var7][var10 + var8 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6][(var7 + 1) % 31][var10 + var8 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][var7][var10 + var8 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var10 + var8 + 25 + 1][var9 + var11 + 25 + 1]) {
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

   @ObfuscatedName("at")
   static boolean method2702(int var0, int var1, int var2) {
      int var3 = var0 * yawCos + var2 * yawSin >> 16;
      int var4 = var2 * yawCos - var0 * yawSin >> 16;
      int var5 = var4 * pitchCos + pitchSin * var1 >> 16;
      int var6 = pitchCos * var1 - var4 * pitchSin >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = var3 * 390 / var5 + field2125;
         int var8 = var6 * 390 / var5 + field2117;
         return var7 >= field2096 && var7 <= field2129 && var8 >= field2078 && var8 <= field2130;
      } else {
         return false;
      }
   }

   @ObfuscatedName("av")
   public void method2703(int var1, int var2, int var3, boolean var4) {
      if(!method2705() || var4) {
         checkClick = true;
         viewportWalking = var4;
         field2100 = var1;
         mouseX = var2;
         mouseY = var3;
         selectedRegionTileX = -1;
         selectedRegionTileY = -1;
      }

   }

   @ObfuscatedName("am")
   public static boolean method2705() {
      return viewportWalking && selectedRegionTileX != -1;
   }

   @ObfuscatedName("al")
   @Export("draw")
   public void draw(int var1, int var2, int var3, int var4, int var5, int var6) {
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

      ++cycle;
      pitchSin = Graphics3D.SINE[var4];
      pitchCos = Graphics3D.COSINE[var4];
      yawSin = Graphics3D.SINE[var5];
      yawCos = Graphics3D.COSINE[var5];
      renderArea = visibilityMaps[(var4 - 128) / 32][var5 / 64];
      cameraX = var1;
      cameraY = var2;
      cameraZ = var3;
      screenCenterX = var1 / 128;
      screenCenterZ = var3 / 128;
      field2083 = var6;
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
      Tile var14;
      int var15;
      int var16;
      for(var7 = this.minLevel; var7 < this.maxY; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = var9 + screenCenterX;
            var15 = screenCenterX - var9;
            if(var10 >= minTileX || var15 < maxTileX) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = var16 + screenCenterZ;
                  var13 = screenCenterZ - var16;
                  if(var10 >= minTileX) {
                     if(var12 >= minTileZ) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, true);
                        }
                     }

                     if(var13 < maxTileZ) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, true);
                        }
                     }
                  }

                  if(var15 < maxTileX) {
                     if(var12 >= minTileZ) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, true);
                        }
                     }

                     if(var13 < maxTileZ) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, true);
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
            var15 = screenCenterX - var9;
            if(var10 >= minTileX || var15 < maxTileX) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = var16 + screenCenterZ;
                  var13 = screenCenterZ - var16;
                  if(var10 >= minTileX) {
                     if(var12 >= minTileZ) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, false);
                        }
                     }

                     if(var13 < maxTileZ) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, false);
                        }
                     }
                  }

                  if(var15 < maxTileX) {
                     if(var12 >= minTileZ) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, false);
                        }
                     }

                     if(var13 < maxTileZ) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.draw) {
                           this.draw(var14, false);
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

   @ObfuscatedName("ad")
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
         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         do {
            do {
               do {
                  do {
                     do {
                        do {
                           while(true) {
                              WallObject var16;
                              GameObject var17;
                              int var18;
                              int var19;
                              boolean var20;
                              int var21;
                              Tile var22;
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

                                    var16 = var9.wallObject;
                                    if(var16 != null) {
                                       var16.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var16.x - cameraX, var16.floor - cameraY, var16.y - cameraZ, var16.hash);
                                    }

                                    for(var10 = 0; var10 < var9.entityCount; ++var10) {
                                       var17 = var9.objects[var10];
                                       if(var17 != null) {
                                          var17.renderable.draw(var17.orientation, pitchSin, pitchCos, yawSin, yawCos, var17.x - cameraX, var17.height - cameraY, var17.y - cameraZ, var17.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.paint != null) {
                                    if(!this.isTileOccluded(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.paint.neColor != 12345678 || checkClick && var6 <= field2100) {
                                          this.drawTileUnderlay(var3.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                       }
                                    }
                                 } else if(var3.overlay != null && !this.isTileOccluded(var7, var4, var5)) {
                                    var20 = true;
                                    this.drawTileOverlay(var3.overlay, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                 }

                                 var21 = 0;
                                 var10 = 0;
                                 WallObject var23 = var3.wallObject;
                                 DecorativeObject var24 = var3.decorativeObject;
                                 if(var23 != null || var24 != null) {
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

                                    var10 = field2114[var21];
                                    var3.wallDrawFlags = TILE_WALL_DRAW_FLAGS_1[var21];
                                 }

                                 if(var23 != null) {
                                    if((var23.orientationA & field2091[var21]) != 0) {
                                       if(var23.orientationA == 16) {
                                          var3.wallCullDirection = 3;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_0[var21];
                                          var3.wallCullOppositeDirection = 3 - var3.wallUncullDirection;
                                       } else if(var23.orientationA == 32) {
                                          var3.wallCullDirection = 6;
                                          var3.wallUncullDirection = WALL_UNCULL_FLAGS_1[var21];
                                          var3.wallCullOppositeDirection = 6 - var3.wallUncullDirection;
                                       } else if(var23.orientationA == 64) {
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

                                    if((var23.orientationA & var10) != 0 && !this.isWallOccluded(var7, var4, var5, var23.orientationA)) {
                                       var23.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var23.x - cameraX, var23.floor - cameraY, var23.y - cameraZ, var23.hash);
                                    }

                                    if((var23.orientationB & var10) != 0 && !this.isWallOccluded(var7, var4, var5, var23.orientationB)) {
                                       var23.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var23.x - cameraX, var23.floor - cameraY, var23.y - cameraZ, var23.hash);
                                    }
                                 }

                                 if(var24 != null && !this.isOccluded(var7, var4, var5, var24.renderable1.modelHeight)) {
                                    if((var24.renderFlag & var10) != 0) {
                                       var24.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var24.offsetX + (var24.x - cameraX), var24.floor - cameraY, var24.offsetY + (var24.y - cameraZ), var24.hash);
                                    } else if(var24.renderFlag == 256) {
                                       var12 = var24.x - cameraX;
                                       var14 = var24.floor - cameraY;
                                       var13 = var24.y - cameraZ;
                                       var18 = var24.rotation;
                                       if(var18 != 1 && var18 != 2) {
                                          var19 = var12;
                                       } else {
                                          var19 = -var12;
                                       }

                                       int var25;
                                       if(var18 != 2 && var18 != 3) {
                                          var25 = var13;
                                       } else {
                                          var25 = -var13;
                                       }

                                       if(var25 < var19) {
                                          var24.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var24.offsetX + var12, var14, var24.offsetY + var13, var24.hash);
                                       } else if(var24.renderable2 != null) {
                                          var24.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var12, var14, var13, var24.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var34 = var3.groundObject;
                                    if(var34 != null) {
                                       var34.renderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, var34.x - cameraX, var34.floor - cameraY, var34.y - cameraZ, var34.hash);
                                    }

                                    ItemLayer var26 = var3.itemLayer;
                                    if(var26 != null && var26.height == 0) {
                                       if(var26.middle != null) {
                                          var26.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, var26.x - cameraX, var26.hash - cameraY, var26.y - cameraZ, var26.flags);
                                       }

                                       if(var26.top != null) {
                                          var26.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, var26.x - cameraX, var26.hash - cameraY, var26.y - cameraZ, var26.flags);
                                       }

                                       if(var26.bottom != null) {
                                          var26.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, var26.x - cameraX, var26.hash - cameraY, var26.y - cameraZ, var26.flags);
                                       }
                                    }
                                 }

                                 var12 = var3.flags;
                                 if(var12 != 0) {
                                    if(var4 < screenCenterX && (var12 & 4) != 0) {
                                       var22 = var8[var4 + 1][var5];
                                       if(var22 != null && var22.visible) {
                                          tileDeque.addFront(var22);
                                       }
                                    }

                                    if(var5 < screenCenterZ && (var12 & 2) != 0) {
                                       var22 = var8[var4][var5 + 1];
                                       if(var22 != null && var22.visible) {
                                          tileDeque.addFront(var22);
                                       }
                                    }

                                    if(var4 > screenCenterX && (var12 & 1) != 0) {
                                       var22 = var8[var4 - 1][var5];
                                       if(var22 != null && var22.visible) {
                                          tileDeque.addFront(var22);
                                       }
                                    }

                                    if(var5 > screenCenterZ && (var12 & 8) != 0) {
                                       var22 = var8[var4][var5 - 1];
                                       if(var22 != null && var22.visible) {
                                          tileDeque.addFront(var22);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.wallCullDirection != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.entityCount; ++var21) {
                                    if(cycle != var3.objects[var21].cycle && var3.wallUncullDirection == (var3.entityFlags[var21] & var3.wallCullDirection)) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var16 = var3.wallObject;
                                    if(!this.isWallOccluded(var7, var4, var5, var16.orientationA)) {
                                       var16.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var16.x - cameraX, var16.floor - cameraY, var16.y - cameraZ, var16.hash);
                                    }

                                    var3.wallCullDirection = 0;
                                 }
                              }

                              if(!var3.drawEntities) {
                                 break;
                              }

                              try {
                                 int var32 = var3.entityCount;
                                 var3.drawEntities = false;
                                 var21 = 0;

                                 label562:
                                 for(var10 = 0; var10 < var32; ++var10) {
                                    var17 = var3.objects[var10];
                                    if(var17.cycle != cycle) {
                                       for(var11 = var17.relativeX; var11 <= var17.offsetX; ++var11) {
                                          for(var12 = var17.relativeY; var12 <= var17.offsetY; ++var12) {
                                             var22 = var8[var11][var12];
                                             if(var22.draw) {
                                                var3.drawEntities = true;
                                                continue label562;
                                             }

                                             if(var22.wallCullDirection != 0) {
                                                var13 = 0;
                                                if(var11 > var17.relativeX) {
                                                   ++var13;
                                                }

                                                if(var11 < var17.offsetX) {
                                                   var13 += 4;
                                                }

                                                if(var12 > var17.relativeY) {
                                                   var13 += 8;
                                                }

                                                if(var12 < var17.offsetY) {
                                                   var13 += 2;
                                                }

                                                if(var3.wallCullOppositeDirection == (var13 & var22.wallCullDirection)) {
                                                   var3.drawEntities = true;
                                                   continue label562;
                                                }
                                             }
                                          }
                                       }

                                       entityBuffer[var21++] = var17;
                                       var11 = screenCenterX - var17.relativeX;
                                       var12 = var17.offsetX - screenCenterX;
                                       if(var12 > var11) {
                                          var11 = var12;
                                       }

                                       var14 = screenCenterZ - var17.relativeY;
                                       var13 = var17.offsetY - screenCenterZ;
                                       if(var13 > var14) {
                                          var17.drawPriority = var11 + var13;
                                       } else {
                                          var17.drawPriority = var11 + var14;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var10 = -50;
                                    var15 = -1;

                                    GameObject var33;
                                    for(var11 = 0; var11 < var21; ++var11) {
                                       var33 = entityBuffer[var11];
                                       if(var33.cycle != cycle) {
                                          if(var33.drawPriority > var10) {
                                             var10 = var33.drawPriority;
                                             var15 = var11;
                                          } else if(var10 == var33.drawPriority) {
                                             var14 = var33.x - cameraX;
                                             var13 = var33.y - cameraZ;
                                             var18 = entityBuffer[var15].x - cameraX;
                                             var19 = entityBuffer[var15].y - cameraZ;
                                             if(var13 * var13 + var14 * var14 > var18 * var18 + var19 * var19) {
                                                var15 = var11;
                                             }
                                          }
                                       }
                                    }

                                    if(var15 == -1) {
                                       break;
                                    }

                                    var33 = entityBuffer[var15];
                                    var33.cycle = cycle;
                                    if(!this.isAreaOccluded(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.draw(var33.orientation, pitchSin, pitchCos, yawSin, yawCos, var33.x - cameraX, var33.height - cameraY, var33.y - cameraZ, var33.hash);
                                    }

                                    for(var12 = var33.relativeX; var12 <= var33.offsetX; ++var12) {
                                       for(var14 = var33.relativeY; var14 <= var33.offsetY; ++var14) {
                                          Tile var35 = var8[var12][var14];
                                          if(var35.wallCullDirection != 0) {
                                             tileDeque.addFront(var35);
                                          } else if((var4 != var12 || var5 != var14) && var35.visible) {
                                             tileDeque.addFront(var35);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.drawEntities) {
                                    break;
                                 }
                              } catch (Exception var27) {
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
         ItemLayer var28 = var3.itemLayer;
         if(var28 != null && var28.height != 0) {
            if(var28.middle != null) {
               var28.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, var28.x - cameraX, var28.hash - cameraY - var28.height, var28.y - cameraZ, var28.flags);
            }

            if(var28.top != null) {
               var28.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, var28.x - cameraX, var28.hash - cameraY - var28.height, var28.y - cameraZ, var28.flags);
            }

            if(var28.bottom != null) {
               var28.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, var28.x - cameraX, var28.hash - cameraY - var28.height, var28.y - cameraZ, var28.flags);
            }
         }

         if(var3.wallDrawFlags != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.isOccluded(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.wallDrawFlags) != 0) {
                  var29.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var29.x - cameraX + var29.offsetX, var29.floor - cameraY, var29.y - cameraZ + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var10 = var29.x - cameraX;
                  var15 = var29.floor - cameraY;
                  var11 = var29.y - cameraZ;
                  var12 = var29.rotation;
                  if(var12 != 1 && var12 != 2) {
                     var14 = var10;
                  } else {
                     var14 = -var10;
                  }

                  if(var12 != 2 && var12 != 3) {
                     var13 = var11;
                  } else {
                     var13 = -var11;
                  }

                  if(var13 >= var14) {
                     var29.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var10 + var29.offsetX, var15, var11 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var10, var15, var11, var29.hash);
                  }
               }
            }

            WallObject var31 = var3.wallObject;
            if(var31 != null) {
               if((var31.orientationB & var3.wallDrawFlags) != 0 && !this.isWallOccluded(var7, var4, var5, var31.orientationB)) {
                  var31.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, var31.x - cameraX, var31.floor - cameraY, var31.y - cameraZ, var31.hash);
               }

               if((var31.orientationA & var3.wallDrawFlags) != 0 && !this.isWallOccluded(var7, var4, var5, var31.orientationA)) {
                  var31.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, var31.x - cameraX, var31.floor - cameraY, var31.y - cameraZ, var31.hash);
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

   @ObfuscatedName("ap")
   static final int method2711(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("af")
   @Export("withinTriangle")
   boolean withinTriangle(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var2 < var3 && var2 < var4 && var2 < var5) {
         return false;
      } else if(var2 > var3 && var2 > var4 && var2 > var5) {
         return false;
      } else if(var1 < var6 && var1 < var7 && var1 < var8) {
         return false;
      } else if(var1 > var6 && var1 > var7 && var1 > var8) {
         return false;
      } else {
         int var9 = (var2 - var3) * (var7 - var6) - (var1 - var6) * (var4 - var3);
         int var10 = (var6 - var8) * (var2 - var5) - (var1 - var8) * (var3 - var5);
         int var11 = (var8 - var7) * (var2 - var4) - (var1 - var7) * (var5 - var4);
         return var11 * var9 > 0 && var11 * var10 > 0;
      }
   }

   @ObfuscatedName("aj")
   @Export("updateOccluders")
   void updateOccluders() {
      int var1 = levelOccluderCount[field2083];
      Occluder[] var2 = levelOccluders[field2083];
      field2111 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         Occluder var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var8;
         boolean var9;
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

               var9 = false;

               while(var6 <= var7) {
                  if(renderArea[var5][var6++]) {
                     var9 = true;
                     break;
                  }
               }

               if(var9) {
                  var8 = cameraX - var4.minX;
                  if(var8 > 32) {
                     var4.testDirection = 1;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.testDirection = 2;
                     var8 = -var8;
                  }

                  var4.minNormalX = (var4.minZ - cameraZ << 8) / var8;
                  var4.maxNormalX = (var4.maxZ - cameraZ << 8) / var8;
                  var4.minNormalY = (var4.minY - cameraY << 8) / var8;
                  var4.maxNormalY = (var4.maxY - cameraY << 8) / var8;
                  field2112[field2111++] = var4;
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

               var9 = false;

               while(var6 <= var7) {
                  if(renderArea[var6++][var5]) {
                     var9 = true;
                     break;
                  }
               }

               if(var9) {
                  var8 = cameraZ - var4.minZ;
                  if(var8 > 32) {
                     var4.testDirection = 3;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.testDirection = 4;
                     var8 = -var8;
                  }

                  var4.field2163 = (var4.minX - cameraX << 8) / var8;
                  var4.field2176 = (var4.maxX - cameraX << 8) / var8;
                  var4.minNormalY = (var4.minY - cameraY << 8) / var8;
                  var4.maxNormalY = (var4.maxY - cameraY << 8) / var8;
                  field2112[field2111++] = var4;
               }
            }
         } else if(var4.type == 4) {
            var5 = var4.minY - cameraY;
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
                  int var10 = var4.minTileX - screenCenterX + 25;
                  if(var10 < 0) {
                     var10 = 0;
                  }

                  var8 = var4.maxTIleX - screenCenterX + 25;
                  if(var8 > 50) {
                     var8 = 50;
                  }

                  boolean var11 = false;

                  label140:
                  for(int var12 = var10; var12 <= var8; ++var12) {
                     for(int var13 = var6; var13 <= var7; ++var13) {
                        if(renderArea[var12][var13]) {
                           var11 = true;
                           break label140;
                        }
                     }
                  }

                  if(var11) {
                     var4.testDirection = 5;
                     var4.field2163 = (var4.minX - cameraX << 8) / var5;
                     var4.field2176 = (var4.maxX - cameraX << 8) / var5;
                     var4.minNormalX = (var4.minZ - cameraZ << 8) / var5;
                     var4.maxNormalX = (var4.maxZ - cameraZ << 8) / var5;
                     field2112[field2111++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bb")
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

   @ObfuscatedName("bt")
   @Export("isOccluded")
   boolean isOccluded(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2111; ++var4) {
         Occluder var5 = field2112[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.testDirection == 1) {
            var6 = var5.minX - var1;
            if(var6 > 0) {
               var7 = var5.minZ + (var5.minNormalX * var6 >> 8);
               var8 = var5.maxZ + (var5.maxNormalX * var6 >> 8);
               var9 = var5.minY + (var5.minNormalY * var6 >> 8);
               var10 = var5.maxY + (var5.maxNormalY * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 2) {
            var6 = var1 - var5.minX;
            if(var6 > 0) {
               var7 = var5.minZ + (var5.minNormalX * var6 >> 8);
               var8 = var5.maxZ + (var5.maxNormalX * var6 >> 8);
               var9 = var5.minY + (var5.minNormalY * var6 >> 8);
               var10 = var5.maxY + (var5.maxNormalY * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 3) {
            var6 = var5.minZ - var3;
            if(var6 > 0) {
               var7 = var5.minX + (var5.field2163 * var6 >> 8);
               var8 = var5.maxX + (var5.field2176 * var6 >> 8);
               var9 = var5.minY + (var5.minNormalY * var6 >> 8);
               var10 = var5.maxY + (var5.maxNormalY * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 4) {
            var6 = var3 - var5.minZ;
            if(var6 > 0) {
               var7 = var5.minX + (var5.field2163 * var6 >> 8);
               var8 = var5.maxX + (var5.field2176 * var6 >> 8);
               var9 = var5.minY + (var5.minNormalY * var6 >> 8);
               var10 = var5.maxY + (var5.maxNormalY * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.testDirection == 5) {
            var6 = var2 - var5.minY;
            if(var6 > 0) {
               var7 = var5.minX + (var5.field2163 * var6 >> 8);
               var8 = var5.maxX + (var5.field2176 * var6 >> 8);
               var9 = var5.minZ + (var5.minNormalX * var6 >> 8);
               var10 = var5.maxZ + (var5.maxNormalX * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("w")
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

   @ObfuscatedName("bv")
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

   @ObfuscatedName("ae")
   @Export("drawTileUnderlay")
   void drawTileUnderlay(SceneTilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - cameraX;
      int var11;
      int var12 = var11 = (var8 << 7) - cameraZ;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.tileHeights[var2][var7][var8] - cameraY;
      int var18 = this.tileHeights[var2][var7 + 1][var8] - cameraY;
      int var19 = this.tileHeights[var2][var7 + 1][var8 + 1] - cameraY;
      int var20 = this.tileHeights[var2][var7][var8 + 1] - cameraY;
      int var21 = var5 * var12 + var10 * var6 >> 16;
      var12 = var12 * var6 - var5 * var10 >> 16;
      var10 = var21;
      var21 = var17 * var4 - var3 * var12 >> 16;
      var12 = var4 * var12 + var3 * var17 >> 16;
      var17 = var21;
      if(var12 >= 50) {
         var21 = var11 * var5 + var14 * var6 >> 16;
         var11 = var11 * var6 - var5 * var14 >> 16;
         var14 = var21;
         var21 = var18 * var4 - var3 * var11 >> 16;
         var11 = var11 * var4 + var18 * var3 >> 16;
         var18 = var21;
         if(var11 >= 50) {
            var21 = var5 * var16 + var13 * var6 >> 16;
            var16 = var16 * var6 - var13 * var5 >> 16;
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
                  int var22 = var10 * Graphics3D.field2031 / var12 + Graphics3D.centerX;
                  int var23 = var17 * Graphics3D.field2031 / var12 + Graphics3D.centerY;
                  int var24 = var14 * Graphics3D.field2031 / var11 + Graphics3D.centerX;
                  int var25 = var18 * Graphics3D.field2031 / var11 + Graphics3D.centerY;
                  int var26 = var13 * Graphics3D.field2031 / var16 + Graphics3D.centerX;
                  int var27 = Graphics3D.centerY + var19 * Graphics3D.field2031 / var16;
                  int var28 = var9 * Graphics3D.field2031 / var15 + Graphics3D.centerX;
                  int var29 = Graphics3D.centerY + var21 * Graphics3D.field2031 / var15;
                  Graphics3D.rasterAlpha = 0;
                  int var30;
                  if((var25 - var29) * (var26 - var28) - (var24 - var28) * (var27 - var29) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > Graphics3D.rasterClipX || var28 > Graphics3D.rasterClipX || var24 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if(checkClick && this.withinTriangle(mouseX, mouseY, var27, var29, var25, var26, var28, var24)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.neColor != 12345678) {
                           Graphics3D.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor);
                        }
                     } else if(!lowMemory) {
                        if(var1.flatShade) {
                           Graphics3D.rasterTexture(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                        } else {
                           Graphics3D.rasterTexture(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                        }
                     } else {
                        var30 = Graphics3D.textureLoader.getAverageTextureRGB(var1.texture);
                        Graphics3D.rasterGouraud(var27, var29, var25, var26, var28, var24, method2711(var30, var1.neColor), method2711(var30, var1.nwColor), method2711(var30, var1.seColor));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var28 - var24) * (var23 - var25) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > Graphics3D.rasterClipX || var24 > Graphics3D.rasterClipX || var28 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if(checkClick && this.withinTriangle(mouseX, mouseY, var23, var25, var29, var22, var24, var28)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.swColor != 12345678) {
                           Graphics3D.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor);
                        }
                     } else if(!lowMemory) {
                        Graphics3D.rasterTexture(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                     } else {
                        var30 = Graphics3D.textureLoader.getAverageTextureRGB(var1.texture);
                        Graphics3D.rasterGouraud(var23, var25, var29, var22, var24, var28, method2711(var30, var1.swColor), method2711(var30, var1.seColor), method2711(var30, var1.nwColor));
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @Export("drawTileOverlay")
   void drawTileOverlay(SceneTileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.vertexX.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.vertexX[var9] - cameraX;
         var11 = var1.vertexY[var9] - cameraY;
         var12 = var1.vertexZ[var9] - cameraZ;
         var13 = var10 * var5 + var12 * var4 >> 16;
         var12 = var5 * var12 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var3 * var11 - var2 * var12 >> 16;
         var12 = var12 * var3 + var11 * var2 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.triangleTextureId != null) {
            SceneTileModel.vertexSceneX[var9] = var10;
            SceneTileModel.vertexSceneY[var9] = var13;
            SceneTileModel.vertexSceneZ[var9] = var12;
         }

         SceneTileModel.tmpScreenX[var9] = var10 * Graphics3D.field2031 / var12 + Graphics3D.centerX;
         SceneTileModel.tmpScreenY[var9] = Graphics3D.centerY + var13 * Graphics3D.field2031 / var12;
      }

      Graphics3D.rasterAlpha = 0;
      var8 = var1.field1864.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1864[var9];
         var11 = var1.field1859[var9];
         var12 = var1.field1856[var9];
         var13 = SceneTileModel.tmpScreenX[var10];
         int var14 = SceneTileModel.tmpScreenX[var11];
         int var15 = SceneTileModel.tmpScreenX[var12];
         int var16 = SceneTileModel.tmpScreenY[var10];
         int var17 = SceneTileModel.tmpScreenY[var11];
         int var18 = SceneTileModel.tmpScreenY[var12];
         if((var18 - var17) * (var13 - var14) - (var15 - var14) * (var16 - var17) > 0) {
            Graphics3D.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > Graphics3D.rasterClipX || var14 > Graphics3D.rasterClipX || var15 > Graphics3D.rasterClipX) {
               Graphics3D.rasterClipEnable = true;
            }

            if(checkClick && this.withinTriangle(mouseX, mouseY, var16, var17, var18, var13, var14, var15)) {
               selectedRegionTileX = var6;
               selectedRegionTileY = var7;
            }

            if(var1.triangleTextureId != null && var1.triangleTextureId[var9] != -1) {
               if(!lowMemory) {
                  if(var1.flatShade) {
                     Graphics3D.rasterTexture(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.vertexSceneX[0], SceneTileModel.vertexSceneX[1], SceneTileModel.vertexSceneX[3], SceneTileModel.vertexSceneY[0], SceneTileModel.vertexSceneY[1], SceneTileModel.vertexSceneY[3], SceneTileModel.vertexSceneZ[0], SceneTileModel.vertexSceneZ[1], SceneTileModel.vertexSceneZ[3], var1.triangleTextureId[var9]);
                  } else {
                     Graphics3D.rasterTexture(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.vertexSceneX[var10], SceneTileModel.vertexSceneX[var11], SceneTileModel.vertexSceneX[var12], SceneTileModel.vertexSceneY[var10], SceneTileModel.vertexSceneY[var11], SceneTileModel.vertexSceneY[var12], SceneTileModel.vertexSceneZ[var10], SceneTileModel.vertexSceneZ[var11], SceneTileModel.vertexSceneZ[var12], var1.triangleTextureId[var9]);
                  }
               } else {
                  int var19 = Graphics3D.textureLoader.getAverageTextureRGB(var1.triangleTextureId[var9]);
                  Graphics3D.rasterGouraud(var16, var17, var18, var13, var14, var15, method2711(var19, var1.triangleColorA[var9]), method2711(var19, var1.triangleColorB[var9]), method2711(var19, var1.triangleColorC[var9]));
               }
            } else if(var1.triangleColorA[var9] != 12345678) {
               Graphics3D.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9]);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @Export("setBridge")
   public void setBridge(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.entityCount; ++var6) {
               GameObject var7 = var5.objects[var6];
               if((var7.hash >> 29 & 3) == 2 && var7.relativeX == var1 && var2 == var7.relativeY) {
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

   @ObfuscatedName("ax")
   public void method2788(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         SceneTilePaint var8 = var7.paint;
         int var9;
         if(var8 != null) {
            int var10 = var8.rgb;
            if(var10 != 0) {
               for(var9 = 0; var9 < 4; ++var9) {
                  var1[var2] = var10;
                  var1[var2 + 1] = var10;
                  var1[var2 + 2] = var10;
                  var1[var2 + 3] = var10;
                  var2 += var3;
               }
            }
         } else {
            SceneTileModel var18 = var7.overlay;
            if(var18 != null) {
               var9 = var18.shape;
               int var11 = var18.rotation;
               int var12 = var18.underlay;
               int var13 = var18.overlay;
               int[] var14 = this.TILE_MASK_2D[var9];
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

   @ObfuscatedName("l")
   @Export("addEntityMarker")
   boolean addEntityMarker(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var14;
      for(int var15 = var2; var15 < var2 + var4; ++var15) {
         for(var14 = var3; var14 < var3 + var5; ++var14) {
            if(var15 < 0 || var14 < 0 || var15 >= this.maxX || var14 >= this.maxZ) {
               return false;
            }

            Tile var16 = this.tiles[var1][var15][var14];
            if(var16 != null && var16.entityCount >= 5) {
               return false;
            }
         }
      }

      GameObject var19 = new GameObject();
      var19.hash = var12;
      var19.flags = var13;
      var19.plane = var1;
      var19.x = var6;
      var19.y = var7;
      var19.height = var8;
      var19.renderable = var9;
      var19.orientation = var10;
      var19.relativeX = var2;
      var19.relativeY = var3;
      var19.offsetX = var2 + var4 - 1;
      var19.offsetY = var3 + var5 - 1;

      for(var14 = var2; var14 < var2 + var4; ++var14) {
         for(int var20 = var3; var20 < var3 + var5; ++var20) {
            int var17 = 0;
            if(var14 > var2) {
               ++var17;
            }

            if(var14 < var2 + var4 - 1) {
               var17 += 4;
            }

            if(var20 > var3) {
               var17 += 8;
            }

            if(var20 < var3 + var5 - 1) {
               var17 += 2;
            }

            for(int var18 = var1; var18 >= 0; --var18) {
               if(this.tiles[var18][var14][var20] == null) {
                  this.tiles[var18][var14][var20] = new Tile(var18, var14, var20);
               }
            }

            Tile var21 = this.tiles[var1][var14][var20];
            var21.objects[var21.entityCount] = var19;
            var21.entityFlags[var21.entityCount] = var17;
            var21.flags |= var17;
            ++var21.entityCount;
         }
      }

      if(var11) {
         this.objects[this.entityCount++] = var19;
      }

      return true;
   }

   @ObfuscatedName("au")
   public int method2794(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("bl")
   public static final int[] method2796(int var0, int var1, int var2) {
      int var3 = var0 * yawCos + var2 * yawSin >> 16;
      var2 = var2 * yawCos - var0 * yawSin >> 16;
      var0 = var3;
      var3 = pitchCos * var1 - var2 * pitchSin >> 16;
      var2 = pitchSin * var1 + var2 * pitchCos >> 16;
      var2 |= 1;
      int var4 = var0 * Graphics3D.field2031 / var2 + Graphics3D.centerX + Rasterizer2D.draw_region_x;
      int var5 = Graphics3D.field2031 * var3 / var2 + Graphics3D.centerY + Rasterizer2D.drawingAreaTop;
      return new int[]{var4, var5};
   }

   @ObfuscatedName("bc")
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
               if(var5 > cameraX) {
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
               if(var6 < cameraZ) {
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
               if(var5 < cameraX) {
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
               if(var6 > cameraZ) {
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

   @ObfuscatedName("u")
   public void method2812(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }

   }

   @ObfuscatedName("y")
   @Export("addItemPile")
   public void addItemPile(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
      ItemLayer var9 = new ItemLayer();
      var9.bottom = var5;
      var9.x = var2 * 128 + 64;
      var9.y = var3 * 128 + 64;
      var9.hash = var4;
      var9.flags = var6;
      var9.middle = var7;
      var9.top = var8;
      int var10 = 0;
      Tile var11 = this.tiles[var1][var2][var3];
      if(var11 != null) {
         for(int var12 = 0; var12 < var11.entityCount; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2493();
               if(var13.modelHeight > var10) {
                  var10 = var13.modelHeight;
               }
            }
         }
      }

      var9.height = var10;
      if(this.tiles[var1][var2][var3] == null) {
         this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
      }

      this.tiles[var1][var2][var3].itemLayer = var9;
   }

   @ObfuscatedName("az")
   public static void method2832() {
      selectedRegionTileX = -1;
      viewportWalking = false;
   }

   @ObfuscatedName("f")
   public void method2845(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }

   }

   static {
      lowMemory = true;
      tileUpdateCount = 0;
      field2083 = 0;
      entityBuffer = new GameObject[100];
      checkClick = false;
      field2100 = 0;
      mouseX = 0;
      mouseY = 0;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
      viewportWalking = false;
      MAX_OCCLUDER_LEVELS = 4;
      levelOccluderCount = new int[MAX_OCCLUDER_LEVELS];
      levelOccluders = new Occluder[MAX_OCCLUDER_LEVELS][500];
      field2111 = 0;
      field2112 = new Occluder[500];
      tileDeque = new Deque();
      field2114 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2091 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      TILE_WALL_DRAW_FLAGS_1 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      WALL_UNCULL_FLAGS_0 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      WALL_UNCULL_FLAGS_1 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      WALL_UNCULL_FLAGS_2 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      WALL_UNCULL_FLAGS_3 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      visibilityMaps = new boolean[8][32][51][51];
   }
}

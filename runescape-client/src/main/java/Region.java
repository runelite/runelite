import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Region")
public class Region {
   @ObfuscatedName("y")
   int field2068;
   @ObfuscatedName("af")
   static final int[] field2069;
   @ObfuscatedName("a")
   int field2070;
   @ObfuscatedName("t")
   int field2071;
   @ObfuscatedName("s")
   int[][][] field2072;
   @ObfuscatedName("r")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("au")
   static boolean field2074;
   @ObfuscatedName("ai")
   static int field2075;
   @ObfuscatedName("j")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("k")
   int[][][] field2077;
   @ObfuscatedName("bg")
   static int field2078;
   @ObfuscatedName("h")
   static int field2082;
   @ObfuscatedName("m")
   static int field2083;
   @ObfuscatedName("b")
   static int field2084;
   @ObfuscatedName("f")
   static int field2085;
   @ObfuscatedName("n")
   static int field2086;
   @ObfuscatedName("u")
   static int field2087;
   @ObfuscatedName("bt")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("w")
   int field2089;
   @ObfuscatedName("d")
   static int field2090;
   @ObfuscatedName("ae")
   static final int[] field2091;
   @ObfuscatedName("an")
   static GameObject[] field2092;
   @ObfuscatedName("aa")
   static class146[][] field2093;
   @ObfuscatedName("i")
   public static boolean field2094;
   @ObfuscatedName("ab")
   static int field2095;
   @ObfuscatedName("br")
   static int field2096;
   @ObfuscatedName("x")
   static int field2097;
   @ObfuscatedName("q")
   static int field2098;
   @ObfuscatedName("al")
   static Deque field2099;
   @ObfuscatedName("ar")
   static int field2100;
   @ObfuscatedName("ay")
   static int field2101;
   @ObfuscatedName("ao")
   static int field2102;
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
   static int field2108;
   @ObfuscatedName("av")
   static int[] field2109;
   @ObfuscatedName("ag")
   static final int[] field2110;
   @ObfuscatedName("am")
   static int field2111;
   @ObfuscatedName("az")
   static class146[] field2112;
   @ObfuscatedName("ap")
   static final int[] field2113;
   @ObfuscatedName("ad")
   static final int[] field2114;
   @ObfuscatedName("ah")
   static int field2115;
   @ObfuscatedName("bp")
   static int field2117;
   @ObfuscatedName("p")
   static int field2118;
   @ObfuscatedName("aj")
   static final int[] field2119;
   @ObfuscatedName("bb")
   static final int[] field2120;
   @ObfuscatedName("bc")
   int[][] field2121;
   @ObfuscatedName("be")
   int[][] field2122;
   @ObfuscatedName("bv")
   static boolean[][][][] field2123;
   @ObfuscatedName("aw")
   static int field2124;
   @ObfuscatedName("bl")
   static int field2125;
   @ObfuscatedName("g")
   static int field2126;
   @ObfuscatedName("v")
   int field2127;
   @ObfuscatedName("c")
   static int field2128;
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
   public void method2667() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field2089; ++var1) {
         for(var2 = 0; var2 < this.field2070; ++var2) {
            for(int var3 = 0; var3 < this.field2071; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field2108; ++var1) {
         for(var2 = 0; var2 < field2109[var1]; ++var2) {
            field2093[var1][var2] = null;
         }

         field2109[var1] = 0;
      }

      for(var1 = 0; var1 < this.field2068; ++var1) {
         this.objects[var1] = null;
      }

      this.field2068 = 0;

      for(var1 = 0; var1 < field2092.length; ++var1) {
         field2092[var1] = null;
      }

   }

   @ObfuscatedName("r")
   public void method2668(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
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

         this.tiles[var1][var2][var3].field1910 = var23;
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
   public static void method2670(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class146 var8 = new class146();
      var8.field2172 = var2 / 128;
      var8.field2164 = var3 / 128;
      var8.field2180 = var4 / 128;
      var8.field2166 = var5 / 128;
      var8.field2167 = var1;
      var8.field2182 = var2;
      var8.field2169 = var3;
      var8.field2170 = var4;
      var8.field2168 = var5;
      var8.field2177 = var6;
      var8.field2173 = var7;
      field2093[var0][field2109[var0]++] = var8;
   }

   @ObfuscatedName("s")
   public void method2671(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1919 = var4;
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
   public void method2675(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field2144 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field2147 = var7;
         var11.field2149 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   @ObfuscatedName("k")
   public void method2676(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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
      this.field2127 = 0;
      this.field2068 = 0;
      this.objects = new GameObject[5000];
      this.field2121 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.field2122 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.field2089 = var1;
      this.field2070 = var2;
      this.field2071 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field2077 = new int[var1][var2 + 1][var3 + 1];
      this.field2072 = var4;
      this.method2667();
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
         return this.method2789(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("z")
   public boolean method2678(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method2789(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("e")
   public boolean method2679(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = 64 * var5 + var2 * 128;
         int var12 = var6 * 64 + var3 * 128;
         return this.method2789(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("c")
   public void method2680() {
      for(int var1 = 0; var1 < this.field2068; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method2681(var2);
         this.objects[var1] = null;
      }

      this.field2068 = 0;
   }

   @ObfuscatedName("b")
   void method2681(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1915; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1915;

                     for(int var6 = var5; var6 < var4.field1915; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1905[var6] = var4.field1905[var6 + 1];
                     }

                     var4.objects[var4.field1915] = null;
                     break;
                  }
               }

               var4.field1918 = 0;

               for(var5 = 0; var5 < var4.field1915; ++var5) {
                  var4.field1918 |= var4.field1905[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   public void method2685(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1915; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var3 == var6.relativeY) {
               this.method2681(var6);
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
         for(int var5 = 0; var5 < var4.field1915; ++var5) {
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
         for(int var5 = 0; var5 < var4.field1915; ++var5) {
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
         return var5.wallObject.field2144 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1915; ++var6) {
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
   public void method2697(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field2089; ++var4) {
         for(int var5 = 0; var5 < this.field2070; ++var5) {
            for(int var6 = 0; var6 < this.field2071; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method2699(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method2699(var10, var4, var5, var6, 1, 1);
                        ModelData.method2423(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.light(var10.field1801, var10.field1836, var1, var2, var3);
                     }

                     var8.renderable1 = var9.light(var9.field1801, var9.field1836, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1915; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method2699(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.light(var11.field1801, var11.field1836, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method2698(var10, var4, var5, var6);
                     var13.renderable = var10.light(var10.field1801, var10.field1836, var1, var2, var3);
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
      if(var3 < this.field2070) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field2070) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field2070 && var4 < this.field2071) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2423(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field2070 && var4 > 0) {
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
         if(this.field2089 != var12) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field2070) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field2071 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field2072[var12][var13][var14 + 1] + this.field2072[var12][var13 + 1][var14] + this.field2072[var12][var13][var14] + this.field2072[var12][var13 + 1][var14 + 1]) / 4 - (this.field2072[var2][var3 + 1][var4 + 1] + this.field2072[var2][var3][var4] + this.field2072[var2][var3 + 1][var4] + this.field2072[var2][var3][var4 + 1]) / 4;
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

                           for(int var23 = 0; var23 < var15.field1915; ++var23) {
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
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field2115 = class136.SINE[var6];
            field2095 = class136.COSINE[var6];
            field2124 = class136.SINE[var7];
            field2075 = class136.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2702(var12, var15 + var0[var8], var13)) {
                        var14 = true;
                        break;
                     }
                  }

                  var5[var8][var9][var10 + 25 + 1][var11 + 25 + 1] = var14;
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
                        if(var5[var6][var7][var11 + var8 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6][(var7 + 1) % 31][var11 + var8 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][var7][var11 + var8 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var11 + var8 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }
                     }
                  }

                  field2123[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   static boolean method2702(int var0, int var1, int var2) {
      int var3 = var0 * field2075 + var2 * field2124 >> 16;
      int var4 = var2 * field2075 - var0 * field2124 >> 16;
      int var5 = var4 * field2095 + field2115 * var1 >> 16;
      int var6 = field2095 * var1 - var4 * field2115 >> 16;
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
         field2074 = true;
         viewportWalking = var4;
         field2100 = var1;
         field2101 = var2;
         field2102 = var3;
         selectedRegionTileX = -1;
         selectedRegionTileY = -1;
      }
   }

   @ObfuscatedName("am")
   public static boolean method2705() {
      return viewportWalking && selectedRegionTileX != -1;
   }

   @ObfuscatedName("al")
   public void method2707(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field2070 * 128) {
         var1 = this.field2070 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field2071 * 128) {
         var3 = this.field2071 * 128 - 1;
      }

      ++field2084;
      field2115 = class136.SINE[var4];
      field2095 = class136.COSINE[var4];
      field2124 = class136.SINE[var5];
      field2075 = class136.COSINE[var5];
      renderArea = field2123[(var4 - 128) / 32][var5 / 64];
      field2082 = var1;
      field2126 = var2;
      field2097 = var3;
      field2098 = var1 / 128;
      field2090 = var3 / 128;
      field2083 = var6;
      field2085 = field2098 - 25;
      if(field2085 < 0) {
         field2085 = 0;
      }

      field2087 = field2090 - 25;
      if(field2087 < 0) {
         field2087 = 0;
      }

      field2086 = field2098 + 25;
      if(field2086 > this.field2070) {
         field2086 = this.field2070;
      }

      field2118 = field2090 + 25;
      if(field2118 > this.field2071) {
         field2118 = this.field2071;
      }

      this.method2713();
      field2128 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field2127; var7 < this.field2089; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field2085; var9 < field2086; ++var9) {
            for(var10 = field2087; var10 < field2118; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1919 <= var6 && (renderArea[var9 - field2098 + 25][var10 - field2090 + 25] || this.field2072[var7][var9][var10] - var2 >= 2000)) {
                     var11.field1920 = true;
                     var11.field1923 = true;
                     if(var11.field1915 > 0) {
                        var11.field1921 = true;
                     } else {
                        var11.field1921 = false;
                     }

                     ++field2128;
                  } else {
                     var11.field1920 = false;
                     var11.field1923 = false;
                     var11.field1907 = 0;
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
      for(var7 = this.field2127; var7 < this.field2089; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = var9 + field2098;
            var16 = field2098 - var9;
            if(var10 >= field2085 || var16 < field2086) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = var12 + field2090;
                  var14 = field2090 - var12;
                  if(var10 >= field2085) {
                     if(var13 >= field2087) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, true);
                        }
                     }

                     if(var14 < field2118) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, true);
                        }
                     }
                  }

                  if(var16 < field2086) {
                     if(var13 >= field2087) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, true);
                        }
                     }

                     if(var14 < field2118) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, true);
                        }
                     }
                  }

                  if(field2128 == 0) {
                     field2074 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field2127; var7 < this.field2089; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = var9 + field2098;
            var16 = field2098 - var9;
            if(var10 >= field2085 || var16 < field2086) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = var12 + field2090;
                  var14 = field2090 - var12;
                  if(var10 >= field2085) {
                     if(var13 >= field2087) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, false);
                        }
                     }

                     if(var14 < field2118) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, false);
                        }
                     }
                  }

                  if(var16 < field2086) {
                     if(var13 >= field2087) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, false);
                        }
                     }

                     if(var14 < field2118) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1920) {
                           this.method2708(var15, false);
                        }
                     }
                  }

                  if(field2128 == 0) {
                     field2074 = false;
                     return;
                  }
               }
            }
         }
      }

      field2074 = false;
   }

   @ObfuscatedName("ad")
   void method2708(Tile var1, boolean var2) {
      field2099.method3603(var1);

      while(true) {
         Tile var3;
         int var4;
         int var5;
         int var6;
         int var7;
         Tile[][] var8;
         Tile var9;
         int var11;
         int var13;
         int var14;
         int var16;
         int var22;
         int var23;
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
                              Tile var33;
                              while(true) {
                                 do {
                                    var3 = (Tile)field2099.method3587();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1923);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1908;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1920) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1923) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field2098 && var4 > field2085) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1923 && (var9.field1920 || (var3.field1918 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field2098 && var4 < field2086 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1923 && (var9.field1920 || (var3.field1918 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field2090 && var5 > field2087) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1923 && (var9.field1920 || (var3.field1918 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field2090 && var5 < field2118 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1923 && (var9.field1920 || (var3.field1918 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1920 = false;
                                 if(var3.field1927 != null) {
                                    var9 = var3.field1927;
                                    if(var9.paint != null) {
                                       if(!this.method2714(0, var4, var5)) {
                                          this.method2757(var9.paint, 0, field2115, field2095, field2124, field2075, var4, var5);
                                       }
                                    } else if(var9.field1910 != null && !this.method2714(0, var4, var5)) {
                                       this.method2758(var9.field1910, field2115, field2095, field2124, field2075, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var10.x - field2082, var10.floor - field2126, var10.y - field2097, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1915; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod2859(var12.orientation, field2115, field2095, field2124, field2075, var12.x - field2082, var12.height - field2126, var12.y - field2097, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.paint != null) {
                                    if(!this.method2714(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.paint.field2049 != 12345678 || field2074 && var6 <= field2100) {
                                          this.method2757(var3.paint, var7, field2115, field2095, field2124, field2075, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1910 != null && !this.method2714(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2758(var3.field1910, field2115, field2095, field2124, field2075, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var25 = var3.decorativeObject;
                                 if(var31 != null || var25 != null) {
                                    if(var4 == field2098) {
                                       ++var21;
                                    } else if(field2098 < var4) {
                                       var21 += 2;
                                    }

                                    if(var5 == field2090) {
                                       var21 += 3;
                                    } else if(field2090 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field2114[var21];
                                    var3.field1914 = field2110[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field2147 & field2091[var21]) != 0) {
                                       if(var31.field2147 == 16) {
                                          var3.field1907 = 3;
                                          var3.field1924 = field2113[var21];
                                          var3.field1925 = 3 - var3.field1924;
                                       } else if(var31.field2147 == 32) {
                                          var3.field1907 = 6;
                                          var3.field1924 = field2069[var21];
                                          var3.field1925 = 6 - var3.field1924;
                                       } else if(var31.field2147 == 64) {
                                          var3.field1907 = 12;
                                          var3.field1924 = field2119[var21];
                                          var3.field1925 = 12 - var3.field1924;
                                       } else {
                                          var3.field1907 = 9;
                                          var3.field1924 = field2120[var21];
                                          var3.field1925 = 9 - var3.field1924;
                                       }
                                    } else {
                                       var3.field1907 = 0;
                                    }

                                    if((var31.field2147 & var11) != 0 && !this.method2811(var7, var4, var5, var31.field2147)) {
                                       var31.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var31.x - field2082, var31.floor - field2126, var31.y - field2097, var31.hash);
                                    }

                                    if((var31.field2149 & var11) != 0 && !this.method2811(var7, var4, var5, var31.field2149)) {
                                       var31.renderable2.vmethod2859(0, field2115, field2095, field2124, field2075, var31.x - field2082, var31.floor - field2126, var31.y - field2097, var31.hash);
                                    }
                                 }

                                 if(var25 != null && !this.method2716(var7, var4, var5, var25.renderable1.modelHeight)) {
                                    if((var25.renderFlag & var11) != 0) {
                                       var25.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var25.offsetX + (var25.x - field2082), var25.floor - field2126, var25.offsetY + (var25.y - field2097), var25.hash);
                                    } else if(var25.renderFlag == 256) {
                                       var14 = var25.x - field2082;
                                       var22 = var25.floor - field2126;
                                       var16 = var25.y - field2097;
                                       var17 = var25.rotation;
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
                                          var25.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var25.offsetX + var14, var22, var25.offsetY + var16, var25.hash);
                                       } else if(var25.renderable2 != null) {
                                          var25.renderable2.vmethod2859(0, field2115, field2095, field2124, field2075, var14, var22, var16, var25.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var24 = var3.groundObject;
                                    if(var24 != null) {
                                       var24.renderable.vmethod2859(0, field2115, field2095, field2124, field2075, var24.x - field2082, var24.floor - field2126, var24.y - field2097, var24.hash);
                                    }

                                    ItemLayer var15 = var3.itemLayer;
                                    if(var15 != null && var15.height == 0) {
                                       if(var15.middle != null) {
                                          var15.middle.vmethod2859(0, field2115, field2095, field2124, field2075, var15.x - field2082, var15.hash - field2126, var15.y - field2097, var15.flags);
                                       }

                                       if(var15.top != null) {
                                          var15.top.vmethod2859(0, field2115, field2095, field2124, field2075, var15.x - field2082, var15.hash - field2126, var15.y - field2097, var15.flags);
                                       }

                                       if(var15.bottom != null) {
                                          var15.bottom.vmethod2859(0, field2115, field2095, field2124, field2075, var15.x - field2082, var15.hash - field2126, var15.y - field2097, var15.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1918;
                                 if(var14 != 0) {
                                    if(var4 < field2098 && (var14 & 4) != 0) {
                                       var33 = var8[var4 + 1][var5];
                                       if(var33 != null && var33.field1923) {
                                          field2099.method3603(var33);
                                       }
                                    }

                                    if(var5 < field2090 && (var14 & 2) != 0) {
                                       var33 = var8[var4][var5 + 1];
                                       if(var33 != null && var33.field1923) {
                                          field2099.method3603(var33);
                                       }
                                    }

                                    if(var4 > field2098 && (var14 & 1) != 0) {
                                       var33 = var8[var4 - 1][var5];
                                       if(var33 != null && var33.field1923) {
                                          field2099.method3603(var33);
                                       }
                                    }

                                    if(var5 > field2090 && (var14 & 8) != 0) {
                                       var33 = var8[var4][var5 - 1];
                                       if(var33 != null && var33.field1923) {
                                          field2099.method3603(var33);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1907 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1915; ++var21) {
                                    if(field2084 != var3.objects[var21].field2208 && var3.field1924 == (var3.field1905[var21] & var3.field1907)) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method2811(var7, var4, var5, var10.field2147)) {
                                       var10.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var10.x - field2082, var10.floor - field2126, var10.y - field2097, var10.hash);
                                    }

                                    var3.field1907 = 0;
                                 }
                              }

                              if(!var3.field1921) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1915;
                                 var3.field1921 = false;
                                 var21 = 0;

                                 label583:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field2208 != field2084) {
                                       for(var13 = var12.relativeX; var13 <= var12.offsetX; ++var13) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var33 = var8[var13][var14];
                                             if(var33.field1920) {
                                                var3.field1921 = true;
                                                continue label583;
                                             }

                                             if(var33.field1907 != 0) {
                                                var16 = 0;
                                                if(var13 > var12.relativeX) {
                                                   ++var16;
                                                }

                                                if(var13 < var12.offsetX) {
                                                   var16 += 4;
                                                }

                                                if(var14 > var12.relativeY) {
                                                   var16 += 8;
                                                }

                                                if(var14 < var12.offsetY) {
                                                   var16 += 2;
                                                }

                                                if(var3.field1925 == (var16 & var33.field1907)) {
                                                   var3.field1921 = true;
                                                   continue label583;
                                                }
                                             }
                                          }
                                       }

                                       field2092[var21++] = var12;
                                       var13 = field2098 - var12.relativeX;
                                       var14 = var12.offsetX - field2098;
                                       if(var14 > var13) {
                                          var13 = var14;
                                       }

                                       var22 = field2090 - var12.relativeY;
                                       var16 = var12.offsetY - field2090;
                                       if(var16 > var22) {
                                          var12.field2201 = var13 + var16;
                                       } else {
                                          var12.field2201 = var13 + var22;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var23 = -1;

                                    for(var13 = 0; var13 < var21; ++var13) {
                                       GameObject var35 = field2092[var13];
                                       if(var35.field2208 != field2084) {
                                          if(var35.field2201 > var11) {
                                             var11 = var35.field2201;
                                             var23 = var13;
                                          } else if(var11 == var35.field2201) {
                                             var22 = var35.x - field2082;
                                             var16 = var35.y - field2097;
                                             var17 = field2092[var23].x - field2082;
                                             var18 = field2092[var23].y - field2097;
                                             if(var16 * var16 + var22 * var22 > var17 * var17 + var18 * var18) {
                                                var23 = var13;
                                             }
                                          }
                                       }
                                    }

                                    if(var23 == -1) {
                                       break;
                                    }

                                    GameObject var36 = field2092[var23];
                                    var36.field2208 = field2084;
                                    if(!this.method2745(var7, var36.relativeX, var36.offsetX, var36.relativeY, var36.offsetY, var36.renderable.modelHeight)) {
                                       var36.renderable.vmethod2859(var36.orientation, field2115, field2095, field2124, field2075, var36.x - field2082, var36.height - field2126, var36.y - field2097, var36.hash);
                                    }

                                    for(var14 = var36.relativeX; var14 <= var36.offsetX; ++var14) {
                                       for(var22 = var36.relativeY; var22 <= var36.offsetY; ++var22) {
                                          Tile var26 = var8[var14][var22];
                                          if(var26.field1907 != 0) {
                                             field2099.method3603(var26);
                                          } else if((var4 != var14 || var5 != var22) && var26.field1923) {
                                             field2099.method3603(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1921) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1921 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1923);
                     } while(var3.field1907 != 0);

                     if(var4 > field2098 || var4 <= field2085) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1923);

                  if(var4 < field2098 || var4 >= field2086 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1923);

               if(var5 > field2090 || var5 <= field2087) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1923);

            if(var5 < field2090 || var5 >= field2118 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1923);

         var3.field1923 = false;
         --field2128;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod2859(0, field2115, field2095, field2124, field2075, var32.x - field2082, var32.hash - field2126 - var32.height, var32.y - field2097, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod2859(0, field2115, field2095, field2124, field2075, var32.x - field2082, var32.hash - field2126 - var32.height, var32.y - field2097, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod2859(0, field2115, field2095, field2124, field2075, var32.x - field2082, var32.hash - field2126 - var32.height, var32.y - field2097, var32.flags);
            }
         }

         if(var3.field1914 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method2716(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1914) != 0) {
                  var29.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var29.x - field2082 + var29.offsetX, var29.floor - field2126, var29.y - field2097 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - field2082;
                  var23 = var29.floor - field2126;
                  var13 = var29.y - field2097;
                  var14 = var29.rotation;
                  if(var14 != 1 && var14 != 2) {
                     var22 = var11;
                  } else {
                     var22 = -var11;
                  }

                  if(var14 != 2 && var14 != 3) {
                     var16 = var13;
                  } else {
                     var16 = -var13;
                  }

                  if(var16 >= var22) {
                     var29.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var11 + var29.offsetX, var23, var13 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2859(0, field2115, field2095, field2124, field2075, var11, var23, var13, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field2149 & var3.field1914) != 0 && !this.method2811(var7, var4, var5, var27.field2149)) {
                  var27.renderable2.vmethod2859(0, field2115, field2095, field2124, field2075, var27.x - field2082, var27.floor - field2126, var27.y - field2097, var27.hash);
               }

               if((var27.field2147 & var3.field1914) != 0 && !this.method2811(var7, var4, var5, var27.field2147)) {
                  var27.renderable1.vmethod2859(0, field2115, field2095, field2124, field2075, var27.x - field2082, var27.floor - field2126, var27.y - field2097, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field2089 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1923) {
               field2099.method3603(var30);
            }
         }

         if(var4 < field2098) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1923) {
               field2099.method3603(var30);
            }
         }

         if(var5 < field2090) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1923) {
               field2099.method3603(var30);
            }
         }

         if(var4 > field2098) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1923) {
               field2099.method3603(var30);
            }
         }

         if(var5 > field2090) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1923) {
               field2099.method3603(var30);
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
   boolean method2712(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
   void method2713() {
      int var1 = field2109[field2083];
      class146[] var2 = field2093[field2083];
      field2111 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class146 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field2167 == 1) {
            var5 = var4.field2172 - field2098 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2180 - field2090 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2166 - field2090 + 25;
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
                  var9 = field2082 - var4.field2182;
                  if(var9 > 32) {
                     var4.field2174 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2174 = 2;
                     var9 = -var9;
                  }

                  var4.field2171 = (var4.field2170 - field2097 << 8) / var9;
                  var4.field2175 = (var4.field2168 - field2097 << 8) / var9;
                  var4.field2179 = (var4.field2177 - field2126 << 8) / var9;
                  var4.field2178 = (var4.field2173 - field2126 << 8) / var9;
                  field2112[field2111++] = var4;
               }
            }
         } else if(var4.field2167 == 2) {
            var5 = var4.field2180 - field2090 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2172 - field2098 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2164 - field2098 + 25;
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
                  var9 = field2097 - var4.field2170;
                  if(var9 > 32) {
                     var4.field2174 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2174 = 4;
                     var9 = -var9;
                  }

                  var4.field2163 = (var4.field2182 - field2082 << 8) / var9;
                  var4.field2176 = (var4.field2169 - field2082 << 8) / var9;
                  var4.field2179 = (var4.field2177 - field2126 << 8) / var9;
                  var4.field2178 = (var4.field2173 - field2126 << 8) / var9;
                  field2112[field2111++] = var4;
               }
            }
         } else if(var4.field2167 == 4) {
            var5 = var4.field2177 - field2126;
            if(var5 > 128) {
               var6 = var4.field2180 - field2090 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2166 - field2090 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field2172 - field2098 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field2164 - field2098 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label152:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label152;
                        }
                     }
                  }

                  if(var10) {
                     var4.field2174 = 5;
                     var4.field2163 = (var4.field2182 - field2082 << 8) / var5;
                     var4.field2176 = (var4.field2169 - field2082 << 8) / var5;
                     var4.field2171 = (var4.field2170 - field2097 << 8) / var5;
                     var4.field2175 = (var4.field2168 - field2097 << 8) / var5;
                     field2112[field2111++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bb")
   boolean method2714(int var1, int var2, int var3) {
      int var4 = this.field2077[var1][var2][var3];
      if(var4 == -field2084) {
         return false;
      } else if(var4 == field2084) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2718(var5 + 1, this.field2072[var1][var2][var3], var6 + 1) && this.method2718(var5 + 128 - 1, this.field2072[var1][var2 + 1][var3], var6 + 1) && this.method2718(var5 + 128 - 1, this.field2072[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2718(var5 + 1, this.field2072[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field2077[var1][var2][var3] = field2084;
            return true;
         } else {
            this.field2077[var1][var2][var3] = -field2084;
            return false;
         }
      }
   }

   @ObfuscatedName("be")
   boolean method2716(int var1, int var2, int var3, int var4) {
      if(!this.method2714(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2718(var5 + 1, this.field2072[var1][var2][var3] - var4, var6 + 1) && this.method2718(var5 + 128 - 1, this.field2072[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2718(var5 + 128 - 1, this.field2072[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2718(var5 + 1, this.field2072[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bt")
   boolean method2718(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2111; ++var4) {
         class146 var5 = field2112[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field2174 == 1) {
            var6 = var5.field2182 - var1;
            if(var6 > 0) {
               var7 = var5.field2170 + (var5.field2171 * var6 >> 8);
               var8 = var5.field2168 + (var5.field2175 * var6 >> 8);
               var9 = var5.field2177 + (var5.field2179 * var6 >> 8);
               var10 = var5.field2173 + (var5.field2178 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2174 == 2) {
            var6 = var1 - var5.field2182;
            if(var6 > 0) {
               var7 = var5.field2170 + (var5.field2171 * var6 >> 8);
               var8 = var5.field2168 + (var5.field2175 * var6 >> 8);
               var9 = var5.field2177 + (var5.field2179 * var6 >> 8);
               var10 = var5.field2173 + (var5.field2178 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2174 == 3) {
            var6 = var5.field2170 - var3;
            if(var6 > 0) {
               var7 = var5.field2182 + (var5.field2163 * var6 >> 8);
               var8 = var5.field2169 + (var5.field2176 * var6 >> 8);
               var9 = var5.field2177 + (var5.field2179 * var6 >> 8);
               var10 = var5.field2173 + (var5.field2178 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2174 == 4) {
            var6 = var3 - var5.field2170;
            if(var6 > 0) {
               var7 = var5.field2182 + (var5.field2163 * var6 >> 8);
               var8 = var5.field2169 + (var5.field2176 * var6 >> 8);
               var9 = var5.field2177 + (var5.field2179 * var6 >> 8);
               var10 = var5.field2173 + (var5.field2178 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2174 == 5) {
            var6 = var2 - var5.field2177;
            if(var6 > 0) {
               var7 = var5.field2182 + (var5.field2163 * var6 >> 8);
               var8 = var5.field2169 + (var5.field2176 * var6 >> 8);
               var9 = var5.field2170 + (var5.field2171 * var6 >> 8);
               var10 = var5.field2168 + (var5.field2175 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   static {
      field2094 = true;
      field2128 = 0;
      field2083 = 0;
      field2092 = new GameObject[100];
      field2074 = false;
      field2100 = 0;
      field2101 = 0;
      field2102 = 0;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
      viewportWalking = false;
      field2108 = 4;
      field2109 = new int[field2108];
      field2093 = new class146[field2108][500];
      field2111 = 0;
      field2112 = new class146[500];
      field2099 = new Deque();
      field2114 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2091 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field2110 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field2113 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field2069 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field2119 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field2120 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field2123 = new boolean[8][32][51][51];
   }

   @ObfuscatedName("w")
   public void method2733(int var1) {
      this.field2127 = var1;

      for(int var2 = 0; var2 < this.field2070; ++var2) {
         for(int var3 = 0; var3 < this.field2071; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("bv")
   boolean method2745(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var3 == var2 && var5 == var4) {
         if(!this.method2714(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2718(var7 + 1, this.field2072[var1][var2][var4] - var6, var8 + 1) && this.method2718(var7 + 128 - 1, this.field2072[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2718(var7 + 128 - 1, this.field2072[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2718(var7 + 1, this.field2072[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field2077[var1][var7][var8] == -field2084) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field2072[var1][var2][var4] - var6;
         if(!this.method2718(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2718(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2718(var7, var9, var11)) {
                  return false;
               } else if(!this.method2718(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("ae")
   void method2757(SceneTilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field2082;
      int var11;
      int var12 = var11 = (var8 << 7) - field2097;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field2072[var2][var7][var8] - field2126;
      int var18 = this.field2072[var2][var7 + 1][var8] - field2126;
      int var19 = this.field2072[var2][var7 + 1][var8 + 1] - field2126;
      int var20 = this.field2072[var2][var7][var8 + 1] - field2126;
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
                  int var22 = var10 * class136.field2031 / var12 + class136.field2034;
                  int var23 = var17 * class136.field2031 / var12 + class136.field2033;
                  int var24 = var14 * class136.field2031 / var11 + class136.field2034;
                  int var25 = var18 * class136.field2031 / var11 + class136.field2033;
                  int var26 = var13 * class136.field2031 / var16 + class136.field2034;
                  int var27 = class136.field2033 + var19 * class136.field2031 / var16;
                  int var28 = var9 * class136.field2031 / var15 + class136.field2034;
                  int var29 = class136.field2033 + var21 * class136.field2031 / var15;
                  class136.rasterAlpha = 0;
                  int var30;
                  if((var25 - var29) * (var26 - var28) - (var24 - var28) * (var27 - var29) > 0) {
                     class136.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class136.rasterClipX || var28 > class136.rasterClipX || var24 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2074 && this.method2712(field2101, field2102, var27, var29, var25, var26, var28, var24)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.field2049 != 12345678) {
                           class136.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field2049, var1.field2047, var1.field2055);
                        }
                     } else if(!field2094) {
                        if(var1.flatShade) {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2049, var1.field2047, var1.field2055, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                        } else {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2049, var1.field2047, var1.field2055, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                        }
                     } else {
                        var30 = class136.field2028.vmethod2876(var1.texture);
                        class136.rasterGouraud(var27, var29, var25, var26, var28, var24, method2711(var30, var1.field2049), method2711(var30, var1.field2047), method2711(var30, var1.field2055));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var28 - var24) * (var23 - var25) > 0) {
                     class136.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class136.rasterClipX || var24 > class136.rasterClipX || var28 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2074 && this.method2712(field2101, field2102, var23, var25, var29, var22, var24, var28)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.field2050 != 12345678) {
                           class136.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field2050, var1.field2055, var1.field2047);
                        }
                     } else if(!field2094) {
                        class136.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field2050, var1.field2055, var1.field2047, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                     } else {
                        var30 = class136.field2028.vmethod2876(var1.texture);
                        class136.rasterGouraud(var23, var25, var29, var22, var24, var28, method2711(var30, var1.field2050), method2711(var30, var1.field2055), method2711(var30, var1.field2047));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ag")
   void method2758(SceneTileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1854.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1854[var9] - field2082;
         var11 = var1.field1868[var9] - field2126;
         var12 = var1.field1850[var9] - field2097;
         var13 = var10 * var5 + var12 * var4 >> 16;
         var12 = var5 * var12 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var3 * var11 - var2 * var12 >> 16;
         var12 = var12 * var3 + var11 * var2 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1863 != null) {
            SceneTileModel.field1865[var9] = var10;
            SceneTileModel.field1866[var9] = var13;
            SceneTileModel.field1867[var9] = var12;
         }

         SceneTileModel.field1848[var9] = var10 * class136.field2031 / var12 + class136.field2034;
         SceneTileModel.field1855[var9] = class136.field2033 + var13 * class136.field2031 / var12;
      }

      class136.rasterAlpha = 0;
      var8 = var1.field1864.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1864[var9];
         var11 = var1.field1859[var9];
         var12 = var1.field1856[var9];
         var13 = SceneTileModel.field1848[var10];
         int var14 = SceneTileModel.field1848[var11];
         int var15 = SceneTileModel.field1848[var12];
         int var16 = SceneTileModel.field1855[var10];
         int var17 = SceneTileModel.field1855[var11];
         int var18 = SceneTileModel.field1855[var12];
         if((var18 - var17) * (var13 - var14) - (var15 - var14) * (var16 - var17) > 0) {
            class136.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class136.rasterClipX || var14 > class136.rasterClipX || var15 > class136.rasterClipX) {
               class136.rasterClipEnable = true;
            }

            if(field2074 && this.method2712(field2101, field2102, var16, var17, var18, var13, var14, var15)) {
               selectedRegionTileX = var6;
               selectedRegionTileY = var7;
            }

            if(var1.field1863 != null && var1.field1863[var9] != -1) {
               if(!field2094) {
                  if(var1.flatShade) {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1851[var9], var1.field1852[var9], var1.field1849[var9], SceneTileModel.field1865[0], SceneTileModel.field1865[1], SceneTileModel.field1865[3], SceneTileModel.field1866[0], SceneTileModel.field1866[1], SceneTileModel.field1866[3], SceneTileModel.field1867[0], SceneTileModel.field1867[1], SceneTileModel.field1867[3], var1.field1863[var9]);
                  } else {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1851[var9], var1.field1852[var9], var1.field1849[var9], SceneTileModel.field1865[var10], SceneTileModel.field1865[var11], SceneTileModel.field1865[var12], SceneTileModel.field1866[var10], SceneTileModel.field1866[var11], SceneTileModel.field1866[var12], SceneTileModel.field1867[var10], SceneTileModel.field1867[var11], SceneTileModel.field1867[var12], var1.field1863[var9]);
                  }
               } else {
                  int var19 = class136.field2028.vmethod2876(var1.field1863[var9]);
                  class136.rasterGouraud(var16, var17, var18, var13, var14, var15, method2711(var19, var1.field1851[var9]), method2711(var19, var1.field1852[var9]), method2711(var19, var1.field1849[var9]));
               }
            } else if(var1.field1851[var9] != 12345678) {
               class136.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1851[var9], var1.field1852[var9], var1.field1849[var9]);
            }
         }
      }

   }

   @ObfuscatedName("a")
   public void method2766(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1915; ++var6) {
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

      this.tiles[0][var1][var2].field1927 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("ax")
   public void method2788(int[] var1, int var2, int var3, int var4, int var5, int var6) {
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
            SceneTileModel var18 = var7.field1910;
            if(var18 != null) {
               var10 = var18.shape;
               int var11 = var18.rotation;
               int var12 = var18.underlay;
               int var13 = var18.overlay;
               int[] var14 = this.field2121[var10];
               int[] var15 = this.field2122[var11];
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
   boolean method2789(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field2070 || var15 >= this.field2071) {
               return false;
            }

            Tile var16 = this.tiles[var1][var14][var15];
            if(var16 != null && var16.field1915 >= 5) {
               return false;
            }
         }
      }

      GameObject var20 = new GameObject();
      var20.hash = var12;
      var20.flags = var13;
      var20.plane = var1;
      var20.x = var6;
      var20.y = var7;
      var20.height = var8;
      var20.renderable = var9;
      var20.orientation = var10;
      var20.relativeX = var2;
      var20.relativeY = var3;
      var20.offsetX = var2 + var4 - 1;
      var20.offsetY = var3 + var5 - 1;

      for(var15 = var2; var15 < var2 + var4; ++var15) {
         for(int var21 = var3; var21 < var3 + var5; ++var21) {
            int var17 = 0;
            if(var15 > var2) {
               ++var17;
            }

            if(var15 < var2 + var4 - 1) {
               var17 += 4;
            }

            if(var21 > var3) {
               var17 += 8;
            }

            if(var21 < var3 + var5 - 1) {
               var17 += 2;
            }

            for(int var18 = var1; var18 >= 0; --var18) {
               if(this.tiles[var18][var15][var21] == null) {
                  this.tiles[var18][var15][var21] = new Tile(var18, var15, var21);
               }
            }

            Tile var22 = this.tiles[var1][var15][var21];
            var22.objects[var22.field1915] = var20;
            var22.field1905[var22.field1915] = var17;
            var22.field1918 |= var17;
            ++var22.field1915;
         }
      }

      if(var11) {
         this.objects[this.field2068++] = var20;
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
      int var3 = var0 * field2075 + var2 * field2124 >> 16;
      var2 = var2 * field2075 - var0 * field2124 >> 16;
      var0 = var3;
      var3 = field2095 * var1 - var2 * field2115 >> 16;
      var2 = field2115 * var1 + var2 * field2095 >> 16;
      var2 |= 1;
      int var4 = var0 * class136.field2031 / var2 + class136.field2034 + Rasterizer2D.field3761;
      int var5 = class136.field2031 * var3 / var2 + class136.field2033 + Rasterizer2D.drawingAreaTop;
      return new int[]{var4, var5};
   }

   @ObfuscatedName("bc")
   boolean method2811(int var1, int var2, int var3, int var4) {
      if(!this.method2714(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field2072[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field2082) {
                  if(!this.method2718(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2718(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2718(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2718(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field2097) {
                  if(!this.method2718(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2718(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2718(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2718(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field2082) {
                  if(!this.method2718(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2718(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2718(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2718(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field2097) {
                  if(!this.method2718(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2718(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2718(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2718(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2718(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2718(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method2718(var5, var9, var6 + 128):(var4 == 32?this.method2718(var5 + 128, var9, var6 + 128):(var4 == 64?this.method2718(var5 + 128, var9, var6):(var4 == 128?this.method2718(var5, var9, var6):true))));
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
   public void method2822(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1915; ++var12) {
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
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("Region")
public class Region {
   @ObfuscatedName("ai")
   static int field2074;
   @ObfuscatedName("bh")
   static int field2075;
   @ObfuscatedName("aq")
   static final int[] field2077;
   @ObfuscatedName("k")
   static int field2078;
   @ObfuscatedName("y")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("h")
   int field2080;
   @ObfuscatedName("bu")
   int[][] field2081;
   @ObfuscatedName("f")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("n")
   int[][][] field2083;
   @ObfuscatedName("p")
   static int field2086;
   @ObfuscatedName("j")
   static int field2088;
   @ObfuscatedName("x")
   int field2089;
   @ObfuscatedName("w")
   static int field2090;
   @ObfuscatedName("m")
   static int field2091;
   @ObfuscatedName("d")
   static int field2092;
   @ObfuscatedName("ak")
   static final int[] field2093;
   @ObfuscatedName("v")
   int field2094;
   @ObfuscatedName("ad")
   static int field2095;
   @ObfuscatedName("c")
   int field2096;
   @ObfuscatedName("l")
   static int field2097;
   @ObfuscatedName("u")
   static int field2098;
   @ObfuscatedName("t")
   static int field2099;
   @ObfuscatedName("i")
   public static boolean field2100;
   @ObfuscatedName("aa")
   public static int field2101;
   @ObfuscatedName("b")
   int[][][] field2102;
   @ObfuscatedName("ac")
   static int field2103;
   @ObfuscatedName("at")
   static GameObject[] field2104;
   @ObfuscatedName("ah")
   static boolean field2105;
   @ObfuscatedName("r")
   static int field2106;
   @ObfuscatedName("aw")
   static int field2107;
   @ObfuscatedName("al")
   static int field2108;
   @ObfuscatedName("ab")
   public static int field2109;
   @ObfuscatedName("g")
   static int field2110;
   @ObfuscatedName("ap")
   static boolean field2111;
   @ObfuscatedName("av")
   static int field2114;
   @ObfuscatedName("ag")
   static int[] field2115;
   @ObfuscatedName("az")
   static class146[][] field2116;
   @ObfuscatedName("s")
   static int field2117;
   @ObfuscatedName("ax")
   static class146[] field2118;
   @ObfuscatedName("au")
   static Deque field2119;
   @ObfuscatedName("aj")
   static final int[] field2120;
   @ObfuscatedName("an")
   static int field2121;
   @ObfuscatedName("ay")
   static final int[] field2122;
   @ObfuscatedName("bj")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("ao")
   static final int[] field2124;
   @ObfuscatedName("am")
   static final int[] field2125;
   @ObfuscatedName("be")
   static final int[] field2126;
   @ObfuscatedName("bs")
   int[][] field2127;
   @ObfuscatedName("af")
   static int field2128;
   @ObfuscatedName("e")
   int field2129;
   @ObfuscatedName("ar")
   static int field2130;
   @ObfuscatedName("bo")
   static boolean[][][][] field2131;
   @ObfuscatedName("bf")
   static int field2132;
   @ObfuscatedName("bg")
   static int field2133;
   @ObfuscatedName("bl")
   static int field2134;
   @ObfuscatedName("bz")
   static int field2135;
   @ObfuscatedName("bq")
   static int field2136;

   @ObfuscatedName("i")
   public void method2674() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field2096; ++var1) {
         for(var2 = 0; var2 < this.field2129; ++var2) {
            for(int var3 = 0; var3 < this.field2094; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field2114; ++var1) {
         for(var2 = 0; var2 < field2115[var1]; ++var2) {
            field2116[var1][var2] = null;
         }

         field2115[var1] = 0;
      }

      for(var1 = 0; var1 < this.field2089; ++var1) {
         this.objects[var1] = null;
      }

      this.field2089 = 0;

      for(var1 = 0; var1 < field2104.length; ++var1) {
         field2104[var1] = null;
      }

   }

   @ObfuscatedName("e")
   public void method2676(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1914; ++var6) {
               GameObject var7 = var5.objects[var6];
               if((var7.hash >> 29 & 3) == 2 && var7.relativeX == var1 && var7.relativeY == var2) {
                  --var7.plane;
               }
            }
         }
      }

      if(this.tiles[0][var1][var2] == null) {
         this.tiles[0][var1][var2] = new Tile(0, var1, var2);
      }

      this.tiles[0][var1][var2].field1936 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("v")
   public static void method2677(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class146 var8 = new class146();
      var8.field2176 = var2 / 128;
      var8.field2165 = var3 / 128;
      var8.field2166 = var4 / 128;
      var8.field2164 = var5 / 128;
      var8.field2180 = var1;
      var8.field2169 = var2;
      var8.field2170 = var3;
      var8.field2171 = var4;
      var8.field2172 = var5;
      var8.field2173 = var6;
      var8.field2174 = var7;
      field2116[var0][field2115[var0]++] = var8;
   }

   @ObfuscatedName("b")
   public void method2678(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1935 = var4;
      }
   }

   @ObfuscatedName("y")
   public void method2679(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class137 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class137(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1918 = var21;
      } else if(var4 != 1) {
         class128 var23 = new class128(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1919 = var23;
      } else {
         var21 = new class137(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1918 = var21;
      }
   }

   @ObfuscatedName("h")
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

   @ObfuscatedName("x")
   public void method2681(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1914; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2496();
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

   @ObfuscatedName("f")
   public void method2682(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field2149 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field2144 = var7;
         var11.field2145 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   @ObfuscatedName("o")
   public boolean method2685(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
      if(var6 == null) {
         return true;
      } else {
         int var10 = var2 - var5;
         int var11 = var3 - var5;
         int var12 = var2 + var5;
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
         return this.method2687(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("z")
   public boolean method2686(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method2687(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("q")
   boolean method2687(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field2129 || var15 >= this.field2094) {
               return false;
            }

            Tile var21 = this.tiles[var1][var14][var15];
            if(var21 != null && var21.field1914 >= 5) {
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
         for(int var16 = var3; var16 < var3 + var5; ++var16) {
            int var17 = 0;
            if(var15 > var2) {
               ++var17;
            }

            if(var15 < var2 + var4 - 1) {
               var17 += 4;
            }

            if(var16 > var3) {
               var17 += 8;
            }

            if(var16 < var3 + var5 - 1) {
               var17 += 2;
            }

            for(int var22 = var1; var22 >= 0; --var22) {
               if(this.tiles[var22][var15][var16] == null) {
                  this.tiles[var22][var15][var16] = new Tile(var22, var15, var16);
               }
            }

            Tile var18 = this.tiles[var1][var15][var16];
            var18.objects[var18.field1914] = var20;
            var18.field1926[var18.field1914] = var17;
            var18.field1921 |= var17;
            ++var18.field1914;
         }
      }

      if(var11) {
         this.objects[this.field2089++] = var20;
      }

      return true;
   }

   @ObfuscatedName("ad")
   public void method2692(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("an")
   public void method2694(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("af")
   public void method2695(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("at")
   public WallObject method2696(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("ai")
   public GameObject method2698(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1914; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("aw")
   public GroundObject method2699(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("ab")
   public int method2701(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("aa")
   public int method2702(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1914; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("ap")
   public int method2703(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("al")
   public int method2704(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method2705(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field2096; ++var4) {
         for(int var5 = 0; var5 < this.field2129; ++var5) {
            for(int var6 = 0; var6 < this.field2094; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method2707(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method2707(var10, var4, var5, var6, 1, 1);
                        ModelData.method2416(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.method2417(var10.field1841, var10.field1844, var1, var2, var3);
                     }

                     var8.renderable1 = var9.method2417(var9.field1841, var9.field1844, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1914; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method2707(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.method2417(var11.field1841, var11.field1844, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method2706(var10, var4, var5, var6);
                     var13.renderable = var10.method2417(var10.field1841, var10.field1844, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   void method2706(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field2129) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2416(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field2129) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2416(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field2129 && var4 < this.field2094) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2416(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field2129 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2416(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("ag")
   void method2707(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field2096) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field2129) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field2094 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field2102[var12][var13][var14] + this.field2102[var12][var13 + 1][var14] + this.field2102[var12][var13][var14 + 1] + this.field2102[var12][var13 + 1][var14 + 1]) / 4 - (this.field2102[var2][var3][var4] + this.field2102[var2][var3 + 1][var4] + this.field2102[var2][var3][var4 + 1] + this.field2102[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var23;
                              if(var17.renderable1 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable1;
                                 ModelData.method2416(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable2;
                                 ModelData.method2416(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var18 = 0; var18 < var15.field1914; ++var18) {
                              GameObject var19 = var15.objects[var18];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2416(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("az")
   public void method2708(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class137 var8 = var7.field1918;
         int var10;
         if(var8 != null) {
            int var9 = var8.field2060;
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
            class128 var18 = var7.field1919;
            if(var18 != null) {
               var10 = var18.field1867;
               int var11 = var18.field1871;
               int var12 = var18.field1869;
               int var13 = var18.field1859;
               int[] var14 = this.field2127[var10];
               int[] var15 = this.field2081[var11];
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

   @ObfuscatedName("ax")
   static boolean method2710(int var0, int var1, int var2) {
      int var3 = var2 * field2121 + var0 * field2128 >> 16;
      int var4 = var2 * field2128 - var0 * field2121 >> 16;
      int var5 = var1 * field2095 + var4 * field2130 >> 16;
      int var6 = var1 * field2130 - var4 * field2095 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field2075 + var3 * class136.field2038 / var5;
         int var8 = field2132 + var6 * class136.field2038 / var5;
         return var7 >= field2133 && var7 <= field2135 && var8 >= field2134 && var8 <= field2136;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   public void method2712() {
      field2111 = true;
   }

   @ObfuscatedName("c")
   public void method2713(int var1) {
      this.field2080 = var1;

      for(int var2 = 0; var2 < this.field2129; ++var2) {
         for(int var3 = 0; var3 < this.field2094; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("ay")
   public static void method2714() {
      field2109 = -1;
      field2111 = false;
   }

   @ObfuscatedName("ao")
   void method2716(Tile var1, boolean var2) {
      field2119.method3571(var1);

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
                                    var3 = (Tile)field2119.method3595();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1930);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1917;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1929) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1930) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field2090 && var4 > field2091) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1930 && (var9.field1929 || (var3.field1921 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field2090 && var4 < field2092 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1930 && (var9.field1929 || (var3.field1921 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field2086 && var5 > field2117) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1930 && (var9.field1929 || (var3.field1921 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field2086 && var5 < field2110 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1930 && (var9.field1929 || (var3.field1921 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1929 = false;
                                 if(var3.field1936 != null) {
                                    var9 = var3.field1936;
                                    if(var9.field1918 != null) {
                                       if(!this.method2722(0, var4, var5)) {
                                          this.method2717(var9.field1918, 0, field2095, field2130, field2121, field2128, var4, var5);
                                       }
                                    } else if(var9.field1919 != null && !this.method2722(0, var4, var5)) {
                                       this.method2718(var9.field1919, field2095, field2130, field2121, field2128, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var10.x - field2097, var10.floor - field2098, var10.y - field2099, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1914; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod2855(var12.orientation, field2095, field2130, field2121, field2128, var12.x - field2097, var12.height - field2098, var12.y - field2099, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1918 != null) {
                                    if(!this.method2722(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1918.field2056 != 12345678 || field2105 && var6 <= field2074) {
                                          this.method2717(var3.field1918, var7, field2095, field2130, field2121, field2128, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1919 != null && !this.method2722(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2718(var3.field1919, field2095, field2130, field2121, field2128, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(field2090 == var4) {
                                       ++var21;
                                    } else if(field2090 < var4) {
                                       var21 += 2;
                                    }

                                    if(field2086 == var5) {
                                       var21 += 3;
                                    } else if(field2086 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field2120[var21];
                                    var3.field1920 = field2122[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field2144 & field2077[var21]) != 0) {
                                       if(var31.field2144 == 16) {
                                          var3.field1932 = 3;
                                          var3.field1933 = field2093[var21];
                                          var3.field1934 = 3 - var3.field1933;
                                       } else if(var31.field2144 == 32) {
                                          var3.field1932 = 6;
                                          var3.field1933 = field2124[var21];
                                          var3.field1934 = 6 - var3.field1933;
                                       } else if(var31.field2144 == 64) {
                                          var3.field1932 = 12;
                                          var3.field1933 = field2125[var21];
                                          var3.field1934 = 12 - var3.field1933;
                                       } else {
                                          var3.field1932 = 9;
                                          var3.field1933 = field2126[var21];
                                          var3.field1934 = 9 - var3.field1933;
                                       }
                                    } else {
                                       var3.field1932 = 0;
                                    }

                                    if((var31.field2144 & var11) != 0 && !this.method2723(var7, var4, var5, var31.field2144)) {
                                       var31.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var31.x - field2097, var31.floor - field2098, var31.y - field2099, var31.hash);
                                    }

                                    if((var31.field2145 & var11) != 0 && !this.method2723(var7, var4, var5, var31.field2145)) {
                                       var31.renderable2.vmethod2855(0, field2095, field2130, field2121, field2128, var31.x - field2097, var31.floor - field2098, var31.y - field2099, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.method2724(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.renderFlag & var11) != 0) {
                                       var13.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var13.x - field2097 + var13.offsetX, var13.floor - field2098, var13.y - field2099 + var13.offsetY, var13.hash);
                                    } else if(var13.renderFlag == 256) {
                                       var14 = var13.x - field2097;
                                       var15 = var13.floor - field2098;
                                       var16 = var13.y - field2099;
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
                                          var13.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var14 + var13.offsetX, var15, var16 + var13.offsetY, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.vmethod2855(0, field2095, field2130, field2121, field2128, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.vmethod2855(0, field2095, field2130, field2121, field2128, var22.x - field2097, var22.floor - field2098, var22.y - field2099, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.vmethod2855(0, field2095, field2130, field2121, field2128, var23.x - field2097, var23.hash - field2098, var23.y - field2099, var23.flags);
                                       }

                                       if(var23.top != null) {
                                          var23.top.vmethod2855(0, field2095, field2130, field2121, field2128, var23.x - field2097, var23.hash - field2098, var23.y - field2099, var23.flags);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.vmethod2855(0, field2095, field2130, field2121, field2128, var23.x - field2097, var23.hash - field2098, var23.y - field2099, var23.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1921;
                                 if(var14 != 0) {
                                    if(var4 < field2090 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1930) {
                                          field2119.method3571(var36);
                                       }
                                    }

                                    if(var5 < field2086 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1930) {
                                          field2119.method3571(var36);
                                       }
                                    }

                                    if(var4 > field2090 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1930) {
                                          field2119.method3571(var36);
                                       }
                                    }

                                    if(var5 > field2086 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1930) {
                                          field2119.method3571(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1932 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1914; ++var21) {
                                    if(var3.objects[var21].field2207 != field2106 && (var3.field1926[var21] & var3.field1932) == var3.field1933) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method2723(var7, var4, var5, var10.field2144)) {
                                       var10.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var10.x - field2097, var10.floor - field2098, var10.y - field2099, var10.hash);
                                    }

                                    var3.field1932 = 0;
                                 }
                              }

                              if(!var3.field1931) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1914;
                                 var3.field1931 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field2207 != field2106) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1929) {
                                                var3.field1931 = true;
                                                continue label563;
                                             }

                                             if(var36.field1932 != 0) {
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

                                                if((var16 & var36.field1932) == var3.field1934) {
                                                   var3.field1931 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field2104[var21++] = var12;
                                       var24 = field2090 - var12.relativeX;
                                       var14 = var12.offsetX - field2090;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field2086 - var12.relativeY;
                                       var16 = var12.offsetY - field2086;
                                       if(var16 > var15) {
                                          var12.field2206 = var24 + var16;
                                       } else {
                                          var12.field2206 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = field2104[var24];
                                       if(var35.field2207 != field2106) {
                                          if(var35.field2206 > var11) {
                                             var11 = var35.field2206;
                                             var25 = var24;
                                          } else if(var35.field2206 == var11) {
                                             var15 = var35.x - field2097;
                                             var16 = var35.y - field2099;
                                             var17 = field2104[var25].x - field2097;
                                             var18 = field2104[var25].y - field2099;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = field2104[var25];
                                    var33.field2207 = field2106;
                                    if(!this.method2728(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod2855(var33.orientation, field2095, field2130, field2121, field2128, var33.x - field2097, var33.height - field2098, var33.y - field2099, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.field1932 != 0) {
                                             field2119.method3571(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1930) {
                                             field2119.method3571(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1931) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1931 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1930);
                     } while(var3.field1932 != 0);

                     if(var4 > field2090 || var4 <= field2091) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1930);

                  if(var4 < field2090 || var4 >= field2092 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1930);

               if(var5 > field2086 || var5 <= field2117) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1930);

            if(var5 < field2086 || var5 >= field2110 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1930);

         var3.field1930 = false;
         --field2088;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod2855(0, field2095, field2130, field2121, field2128, var32.x - field2097, var32.hash - field2098 - var32.height, var32.y - field2099, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod2855(0, field2095, field2130, field2121, field2128, var32.x - field2097, var32.hash - field2098 - var32.height, var32.y - field2099, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod2855(0, field2095, field2130, field2121, field2128, var32.x - field2097, var32.hash - field2098 - var32.height, var32.y - field2099, var32.flags);
            }
         }

         if(var3.field1920 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method2724(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1920) != 0) {
                  var29.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var29.x - field2097 + var29.offsetX, var29.floor - field2098, var29.y - field2099 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - field2097;
                  var25 = var29.floor - field2098;
                  var24 = var29.y - field2099;
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
                     var29.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2855(0, field2095, field2130, field2121, field2128, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field2145 & var3.field1920) != 0 && !this.method2723(var7, var4, var5, var27.field2145)) {
                  var27.renderable2.vmethod2855(0, field2095, field2130, field2121, field2128, var27.x - field2097, var27.floor - field2098, var27.y - field2099, var27.hash);
               }

               if((var27.field2144 & var3.field1920) != 0 && !this.method2723(var7, var4, var5, var27.field2144)) {
                  var27.renderable1.vmethod2855(0, field2095, field2130, field2121, field2128, var27.x - field2097, var27.floor - field2098, var27.y - field2099, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field2096 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1930) {
               field2119.method3571(var30);
            }
         }

         if(var4 < field2090) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1930) {
               field2119.method3571(var30);
            }
         }

         if(var5 < field2086) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1930) {
               field2119.method3571(var30);
            }
         }

         if(var4 > field2090) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1930) {
               field2119.method3571(var30);
            }
         }

         if(var5 > field2086) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1930) {
               field2119.method3571(var30);
            }
         }
      }
   }

   @ObfuscatedName("am")
   void method2717(class137 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field2097;
      int var11;
      int var12 = var11 = (var8 << 7) - field2099;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field2102[var2][var7][var8] - field2098;
      int var18 = this.field2102[var2][var7 + 1][var8] - field2098;
      int var19 = this.field2102[var2][var7 + 1][var8 + 1] - field2098;
      int var20 = this.field2102[var2][var7][var8 + 1] - field2098;
      int var21 = var12 * var5 + var10 * var6 >> 16;
      var12 = var12 * var6 - var10 * var5 >> 16;
      var10 = var21;
      var21 = var17 * var4 - var12 * var3 >> 16;
      var12 = var17 * var3 + var12 * var4 >> 16;
      var17 = var21;
      if(var12 >= 50) {
         var21 = var11 * var5 + var14 * var6 >> 16;
         var11 = var11 * var6 - var14 * var5 >> 16;
         var14 = var21;
         var21 = var18 * var4 - var11 * var3 >> 16;
         var11 = var18 * var3 + var11 * var4 >> 16;
         var18 = var21;
         if(var11 >= 50) {
            var21 = var16 * var5 + var13 * var6 >> 16;
            var16 = var16 * var6 - var13 * var5 >> 16;
            var13 = var21;
            var21 = var19 * var4 - var16 * var3 >> 16;
            var16 = var19 * var3 + var16 * var4 >> 16;
            var19 = var21;
            if(var16 >= 50) {
               var21 = var15 * var5 + var9 * var6 >> 16;
               var15 = var15 * var6 - var9 * var5 >> 16;
               var9 = var21;
               var21 = var20 * var4 - var15 * var3 >> 16;
               var15 = var20 * var3 + var15 * var4 >> 16;
               if(var15 >= 50) {
                  int var22 = class136.field2032 + var10 * class136.field2038 / var12;
                  int var23 = class136.field2046 + var17 * class136.field2038 / var12;
                  int var24 = class136.field2032 + var14 * class136.field2038 / var11;
                  int var25 = class136.field2046 + var18 * class136.field2038 / var11;
                  int var26 = class136.field2032 + var13 * class136.field2038 / var16;
                  int var27 = class136.field2046 + var19 * class136.field2038 / var16;
                  int var28 = class136.field2032 + var9 * class136.field2038 / var15;
                  int var29 = class136.field2046 + var21 * class136.field2038 / var15;
                  class136.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class136.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class136.rasterClipX || var28 > class136.rasterClipX || var24 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2105 && this.method2720(field2107, field2108, var27, var29, var25, var26, var28, var24)) {
                        field2109 = var7;
                        field2101 = var8;
                     }

                     if(var1.field2054 == -1) {
                        if(var1.field2056 != 12345678) {
                           class136.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field2056, var1.field2057, var1.field2058);
                        }
                     } else if(!field2100) {
                        if(var1.field2059) {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2056, var1.field2057, var1.field2058, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2054);
                        } else {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2056, var1.field2057, var1.field2058, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field2054);
                        }
                     } else {
                        var30 = class136.field2049.vmethod2887(var1.field2054);
                        class136.rasterGouraud(var27, var29, var25, var26, var28, var24, method2719(var30, var1.field2056), method2719(var30, var1.field2057), method2719(var30, var1.field2058));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class136.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class136.rasterClipX || var24 > class136.rasterClipX || var28 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2105 && this.method2720(field2107, field2108, var23, var25, var29, var22, var24, var28)) {
                        field2109 = var7;
                        field2101 = var8;
                     }

                     if(var1.field2054 == -1) {
                        if(var1.field2062 != 12345678) {
                           class136.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field2062, var1.field2058, var1.field2057);
                        }
                     } else if(!field2100) {
                        class136.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field2062, var1.field2058, var1.field2057, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2054);
                     } else {
                        var30 = class136.field2049.vmethod2887(var1.field2054);
                        class136.rasterGouraud(var23, var25, var29, var22, var24, var28, method2719(var30, var1.field2062), method2719(var30, var1.field2058), method2719(var30, var1.field2057));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("be")
   void method2718(class128 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1870.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1870[var9] - field2097;
         var11 = var1.field1857[var9] - field2098;
         var12 = var1.field1858[var9] - field2099;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1862 != null) {
            class128.field1873[var9] = var10;
            class128.field1874[var9] = var13;
            class128.field1875[var9] = var12;
         }

         class128.field1864[var9] = class136.field2032 + var10 * class136.field2038 / var12;
         class128.field1872[var9] = class136.field2046 + var13 * class136.field2038 / var12;
      }

      class136.rasterAlpha = 0;
      var8 = var1.field1860.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1860[var9];
         var11 = var1.field1863[var9];
         var12 = var1.field1865[var9];
         var13 = class128.field1864[var10];
         int var14 = class128.field1864[var11];
         int var15 = class128.field1864[var12];
         int var16 = class128.field1872[var10];
         int var17 = class128.field1872[var11];
         int var18 = class128.field1872[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class136.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class136.rasterClipX || var14 > class136.rasterClipX || var15 > class136.rasterClipX) {
               class136.rasterClipEnable = true;
            }

            if(field2105 && this.method2720(field2107, field2108, var16, var17, var18, var13, var14, var15)) {
               field2109 = var6;
               field2101 = var7;
            }

            if(var1.field1862 != null && var1.field1862[var9] != -1) {
               if(!field2100) {
                  if(var1.field1866) {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1856[var9], var1.field1868[var9], var1.field1861[var9], class128.field1873[0], class128.field1873[1], class128.field1873[3], class128.field1874[0], class128.field1874[1], class128.field1874[3], class128.field1875[0], class128.field1875[1], class128.field1875[3], var1.field1862[var9]);
                  } else {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1856[var9], var1.field1868[var9], var1.field1861[var9], class128.field1873[var10], class128.field1873[var11], class128.field1873[var12], class128.field1874[var10], class128.field1874[var11], class128.field1874[var12], class128.field1875[var10], class128.field1875[var11], class128.field1875[var12], var1.field1862[var9]);
                  }
               } else {
                  int var19 = class136.field2049.vmethod2887(var1.field1862[var9]);
                  class136.rasterGouraud(var16, var17, var18, var13, var14, var15, method2719(var19, var1.field1856[var9]), method2719(var19, var1.field1868[var9]), method2719(var19, var1.field1861[var9]));
               }
            } else if(var1.field1856[var9] != 12345678) {
               class136.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1856[var9], var1.field1868[var9], var1.field1861[var9]);
            }
         }
      }

   }

   @ObfuscatedName("bs")
   static final int method2719(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("bu")
   boolean method2720(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
         int var10 = (var2 - var5) * (var6 - var8) - (var1 - var8) * (var3 - var5);
         int var11 = (var2 - var4) * (var8 - var7) - (var1 - var7) * (var5 - var4);
         return var9 * var11 > 0 && var11 * var10 > 0;
      }
   }

   @ObfuscatedName("bo")
   void method2721() {
      int var1 = field2115[field2078];
      class146[] var2 = field2116[field2078];
      field2103 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class146 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field2180 == 1) {
            var5 = var4.field2176 - field2090 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2166 - field2086 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2164 - field2086 + 25;
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
                  var9 = field2097 - var4.field2169;
                  if(var9 > 32) {
                     var4.field2175 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2175 = 2;
                     var9 = -var9;
                  }

                  var4.field2168 = (var4.field2171 - field2099 << 8) / var9;
                  var4.field2177 = (var4.field2172 - field2099 << 8) / var9;
                  var4.field2167 = (var4.field2173 - field2098 << 8) / var9;
                  var4.field2181 = (var4.field2174 - field2098 << 8) / var9;
                  field2118[field2103++] = var4;
               }
            }
         } else if(var4.field2180 == 2) {
            var5 = var4.field2166 - field2086 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2176 - field2090 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2165 - field2090 + 25;
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
                  var9 = field2099 - var4.field2171;
                  if(var9 > 32) {
                     var4.field2175 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2175 = 4;
                     var9 = -var9;
                  }

                  var4.field2178 = (var4.field2169 - field2097 << 8) / var9;
                  var4.field2179 = (var4.field2170 - field2097 << 8) / var9;
                  var4.field2167 = (var4.field2173 - field2098 << 8) / var9;
                  var4.field2181 = (var4.field2174 - field2098 << 8) / var9;
                  field2118[field2103++] = var4;
               }
            }
         } else if(var4.field2180 == 4) {
            var5 = var4.field2173 - field2098;
            if(var5 > 128) {
               var6 = var4.field2166 - field2086 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2164 - field2086 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field2176 - field2090 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field2165 - field2090 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label189:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label189;
                        }
                     }
                  }

                  if(var10) {
                     var4.field2175 = 5;
                     var4.field2178 = (var4.field2169 - field2097 << 8) / var5;
                     var4.field2179 = (var4.field2170 - field2097 << 8) / var5;
                     var4.field2168 = (var4.field2171 - field2099 << 8) / var5;
                     var4.field2177 = (var4.field2172 - field2099 << 8) / var5;
                     field2118[field2103++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bj")
   boolean method2722(int var1, int var2, int var3) {
      int var4 = this.field2083[var1][var2][var3];
      if(var4 == -field2106) {
         return false;
      } else if(var4 == field2106) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2726(var5 + 1, this.field2102[var1][var2][var3], var6 + 1) && this.method2726(var5 + 128 - 1, this.field2102[var1][var2 + 1][var3], var6 + 1) && this.method2726(var5 + 128 - 1, this.field2102[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2726(var5 + 1, this.field2102[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field2083[var1][var2][var3] = field2106;
            return true;
         } else {
            this.field2083[var1][var2][var3] = -field2106;
            return false;
         }
      }
   }

   @ObfuscatedName("bh")
   boolean method2723(int var1, int var2, int var3, int var4) {
      if(!this.method2722(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field2102[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field2097) {
                  if(!this.method2726(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2726(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2726(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2726(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field2099) {
                  if(!this.method2726(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2726(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2726(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2726(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field2097) {
                  if(!this.method2726(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2726(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2726(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2726(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field2099) {
                  if(!this.method2726(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2726(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2726(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2726(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2726(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2726(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method2726(var5, var9, var6 + 128):(var4 == 32?this.method2726(var5 + 128, var9, var6 + 128):(var4 == 64?this.method2726(var5 + 128, var9, var6):(var4 == 128?this.method2726(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("bf")
   boolean method2724(int var1, int var2, int var3, int var4) {
      if(!this.method2722(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2726(var5 + 1, this.field2102[var1][var2][var3] - var4, var6 + 1) && this.method2726(var5 + 128 - 1, this.field2102[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2726(var5 + 128 - 1, this.field2102[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2726(var5 + 1, this.field2102[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bl")
   boolean method2726(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2103; ++var4) {
         class146 var5 = field2118[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field2175 == 1) {
            var6 = var5.field2169 - var1;
            if(var6 > 0) {
               var7 = var5.field2171 + (var5.field2168 * var6 >> 8);
               var8 = var5.field2172 + (var5.field2177 * var6 >> 8);
               var9 = var5.field2173 + (var5.field2167 * var6 >> 8);
               var10 = var5.field2174 + (var5.field2181 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2175 == 2) {
            var6 = var1 - var5.field2169;
            if(var6 > 0) {
               var7 = var5.field2171 + (var5.field2168 * var6 >> 8);
               var8 = var5.field2172 + (var5.field2177 * var6 >> 8);
               var9 = var5.field2173 + (var5.field2167 * var6 >> 8);
               var10 = var5.field2174 + (var5.field2181 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2175 == 3) {
            var6 = var5.field2171 - var3;
            if(var6 > 0) {
               var7 = var5.field2169 + (var5.field2178 * var6 >> 8);
               var8 = var5.field2170 + (var5.field2179 * var6 >> 8);
               var9 = var5.field2173 + (var5.field2167 * var6 >> 8);
               var10 = var5.field2174 + (var5.field2181 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2175 == 4) {
            var6 = var3 - var5.field2171;
            if(var6 > 0) {
               var7 = var5.field2169 + (var5.field2178 * var6 >> 8);
               var8 = var5.field2170 + (var5.field2179 * var6 >> 8);
               var9 = var5.field2173 + (var5.field2167 * var6 >> 8);
               var10 = var5.field2174 + (var5.field2181 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2175 == 5) {
            var6 = var2 - var5.field2173;
            if(var6 > 0) {
               var7 = var5.field2169 + (var5.field2178 * var6 >> 8);
               var8 = var5.field2170 + (var5.field2179 * var6 >> 8);
               var9 = var5.field2171 + (var5.field2168 * var6 >> 8);
               var10 = var5.field2172 + (var5.field2177 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("bz")
   public static final int[] method2727(int var0, int var1, int var2) {
      int var3 = var2 * field2121 + var0 * field2128 >> 16;
      var2 = var2 * field2128 - var0 * field2121 >> 16;
      var0 = var3;
      var3 = var1 * field2130 - var2 * field2095 >> 16;
      var2 = var1 * field2095 + var2 * field2130 >> 16;
      var2 |= 1;
      int var4 = class136.field2032 + var0 * class136.field2038 / var2 + Rasterizer2D.field3757;
      int var5 = class136.field2046 + var3 * class136.field2038 / var2 + Rasterizer2D.field3752;
      return new int[]{var4, var5};
   }

   @ObfuscatedName("bg")
   boolean method2728(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method2722(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2726(var7 + 1, this.field2102[var1][var2][var4] - var6, var8 + 1) && this.method2726(var7 + 128 - 1, this.field2102[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2726(var7 + 128 - 1, this.field2102[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2726(var7 + 1, this.field2102[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field2083[var1][var7][var8] == -field2106) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field2102[var1][var2][var4] - var6;
         if(!this.method2726(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2726(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2726(var7, var9, var11)) {
                  return false;
               } else if(!this.method2726(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("a")
   public boolean method2735(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + var5 * 64;
         int var12 = var3 * 128 + var6 * 64;
         return this.method2687(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("l")
   void method2737(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1914; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1914;

                     for(int var6 = var5; var6 < var4.field1914; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1926[var6] = var4.field1926[var6 + 1];
                     }

                     var4.objects[var4.field1914] = null;
                     break;
                  }
               }

               var4.field1921 = 0;

               for(var5 = 0; var5 < var4.field1914; ++var5) {
                  var4.field1921 |= var4.field1926[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("au")
   public void method2746(int var1, int var2, int var3, boolean var4) {
      if(!method2821() || var4) {
         field2105 = true;
         field2111 = var4;
         field2074 = var1;
         field2107 = var2;
         field2108 = var3;
         field2109 = -1;
         field2101 = -1;
      }
   }

   @ObfuscatedName("u")
   public void method2748(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }
   }

   @ObfuscatedName("t")
   public void method2772(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   @ObfuscatedName("ah")
   public DecorativeObject method2774(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("j")
   public void method2783() {
      for(int var1 = 0; var1 < this.field2089; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method2737(var2);
         this.objects[var1] = null;
      }

      this.field2089 = 0;
   }

   @ObfuscatedName("ac")
   public static void method2806(int[] var0, int var1, int var2, int var3, int var4) {
      field2133 = 0;
      field2134 = 0;
      field2135 = var3;
      field2136 = var4;
      field2075 = var3 / 2;
      field2132 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field2095 = class136.SINE[var6];
            field2130 = class136.COSINE[var6];
            field2121 = class136.SINE[var7];
            field2128 = class136.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2710(var12, var0[var8] + var15, var13)) {
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

                  label100:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label100;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label100;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label100;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label100;
                        }
                     }
                  }

                  field2131[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field2080 = 0;
      this.field2089 = 0;
      this.objects = new GameObject[5000];
      this.field2127 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.field2081 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.field2096 = var1;
      this.field2129 = var2;
      this.field2094 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field2083 = new int[var1][var2 + 1][var3 + 1];
      this.field2102 = var4;
      this.method2674();
   }

   @ObfuscatedName("ak")
   public void method2817(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field2129 * 128) {
         var1 = this.field2129 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field2094 * 128) {
         var3 = this.field2094 * 128 - 1;
      }

      ++field2106;
      field2095 = class136.SINE[var4];
      field2130 = class136.COSINE[var4];
      field2121 = class136.SINE[var5];
      field2128 = class136.COSINE[var5];
      renderArea = field2131[(var4 - 128) / 32][var5 / 64];
      field2097 = var1;
      field2098 = var2;
      field2099 = var3;
      field2090 = var1 / 128;
      field2086 = var3 / 128;
      field2078 = var6;
      field2091 = field2090 - 25;
      if(field2091 < 0) {
         field2091 = 0;
      }

      field2117 = field2086 - 25;
      if(field2117 < 0) {
         field2117 = 0;
      }

      field2092 = field2090 + 25;
      if(field2092 > this.field2129) {
         field2092 = this.field2129;
      }

      field2110 = field2086 + 25;
      if(field2110 > this.field2094) {
         field2110 = this.field2094;
      }

      this.method2721();
      field2088 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field2080; var7 < this.field2096; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field2091; var9 < field2092; ++var9) {
            for(var10 = field2117; var10 < field2110; ++var10) {
               Tile var16 = var8[var9][var10];
               if(var16 != null) {
                  if(var16.field1935 <= var6 && (renderArea[var9 - field2090 + 25][var10 - field2086 + 25] || this.field2102[var7][var9][var10] - var2 >= 2000)) {
                     var16.field1929 = true;
                     var16.field1930 = true;
                     if(var16.field1914 > 0) {
                        var16.field1931 = true;
                     } else {
                        var16.field1931 = false;
                     }

                     ++field2088;
                  } else {
                     var16.field1929 = false;
                     var16.field1930 = false;
                     var16.field1932 = 0;
                  }
               }
            }
         }
      }

      int var11;
      int var12;
      int var13;
      int var14;
      Tile var15;
      for(var7 = this.field2080; var7 < this.field2096; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2090 + var9;
            var11 = field2090 - var9;
            if(var10 >= field2091 || var11 < field2092) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2086 + var12;
                  var14 = field2086 - var12;
                  if(var10 >= field2091) {
                     if(var13 >= field2117) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, true);
                        }
                     }

                     if(var14 < field2110) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, true);
                        }
                     }
                  }

                  if(var11 < field2092) {
                     if(var13 >= field2117) {
                        var15 = var8[var11][var13];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, true);
                        }
                     }

                     if(var14 < field2110) {
                        var15 = var8[var11][var14];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, true);
                        }
                     }
                  }

                  if(field2088 == 0) {
                     field2105 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field2080; var7 < this.field2096; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2090 + var9;
            var11 = field2090 - var9;
            if(var10 >= field2091 || var11 < field2092) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2086 + var12;
                  var14 = field2086 - var12;
                  if(var10 >= field2091) {
                     if(var13 >= field2117) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, false);
                        }
                     }

                     if(var14 < field2110) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, false);
                        }
                     }
                  }

                  if(var11 < field2092) {
                     if(var13 >= field2117) {
                        var15 = var8[var11][var13];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, false);
                        }
                     }

                     if(var14 < field2110) {
                        var15 = var8[var11][var14];
                        if(var15 != null && var15.field1929) {
                           this.method2716(var15, false);
                        }
                     }
                  }

                  if(field2088 == 0) {
                     field2105 = false;
                     return;
                  }
               }
            }
         }
      }

      field2105 = false;
   }

   @ObfuscatedName("n")
   public void method2820(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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

   @ObfuscatedName("aq")
   public static boolean method2821() {
      return field2111 && field2109 != -1;
   }

   @ObfuscatedName("ar")
   public void method2822(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1914; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method2737(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("ae")
   public int method2835(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field2149 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1914; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   static {
      field2100 = true;
      field2088 = 0;
      field2078 = 0;
      field2104 = new GameObject[100];
      field2105 = false;
      field2074 = 0;
      field2107 = 0;
      field2108 = 0;
      field2109 = -1;
      field2101 = -1;
      field2111 = false;
      field2114 = 4;
      field2115 = new int[field2114];
      field2116 = new class146[field2114][500];
      field2103 = 0;
      field2118 = new class146[500];
      field2119 = new Deque();
      field2120 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2077 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field2122 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field2093 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field2124 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field2125 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field2126 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field2131 = new boolean[8][32][51][51];
   }
}

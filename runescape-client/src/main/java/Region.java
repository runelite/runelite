import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Region")
public class Region {
   @ObfuscatedName("g")
   static int field2058;
   @ObfuscatedName("m")
   int field2059;
   @ObfuscatedName("e")
   int field2060;
   @ObfuscatedName("au")
   static final int[] field2062;
   @ObfuscatedName("az")
   static Deque field2063;
   @ObfuscatedName("j")
   int field2064;
   @ObfuscatedName("i")
   int field2065;
   @ObfuscatedName("f")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("c")
   int[][][] field2067;
   @ObfuscatedName("ag")
   static int[] field2068;
   @ObfuscatedName("p")
   public static boolean field2072;
   @ObfuscatedName("v")
   static int field2073;
   @ObfuscatedName("aq")
   static class146[][] field2074;
   @ObfuscatedName("k")
   static int field2075;
   @ObfuscatedName("am")
   static int field2076;
   @ObfuscatedName("l")
   static int field2077;
   @ObfuscatedName("w")
   int[][][] field2078;
   @ObfuscatedName("av")
   static int field2079;
   @ObfuscatedName("x")
   static int field2080;
   @ObfuscatedName("b")
   static int field2081;
   @ObfuscatedName("y")
   static int field2082;
   @ObfuscatedName("u")
   static int field2083;
   @ObfuscatedName("r")
   static int field2084;
   @ObfuscatedName("ax")
   static int field2085;
   @ObfuscatedName("bp")
   static int field2086;
   @ObfuscatedName("ae")
   static int field2087;
   @ObfuscatedName("ap")
   static GameObject[] field2088;
   @ObfuscatedName("s")
   static int field2089;
   @ObfuscatedName("al")
   static int field2090;
   @ObfuscatedName("ab")
   static int field2091;
   @ObfuscatedName("z")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("ar")
   @Export("selectedRegionTileX")
   public static int selectedRegionTileX;
   @ObfuscatedName("h")
   static int field2094;
   @ObfuscatedName("ac")
   @Export("viewportWalking")
   static boolean viewportWalking;
   @ObfuscatedName("d")
   static int field2096;
   @ObfuscatedName("aj")
   static int field2098;
   @ObfuscatedName("bc")
   static int field2099;
   @ObfuscatedName("aw")
   static final int[] field2100;
   @ObfuscatedName("as")
   static int field2101;
   @ObfuscatedName("an")
   static class146[] field2102;
   @ObfuscatedName("ao")
   @Export("selectedRegionTileY")
   public static int selectedRegionTileY;
   @ObfuscatedName("ai")
   static final int[] field2104;
   @ObfuscatedName("bf")
   int[][] field2105;
   @ObfuscatedName("af")
   static int field2106;
   @ObfuscatedName("ah")
   static final int[] field2107;
   @ObfuscatedName("ad")
   static final int[] field2108;
   @ObfuscatedName("t")
   int field2109;
   @ObfuscatedName("bg")
   static final int[] field2110;
   @ObfuscatedName("bi")
   int[][] field2112;
   @ObfuscatedName("bv")
   static boolean[][][][] field2113;
   @ObfuscatedName("bz")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("ba")
   static int field2115;
   @ObfuscatedName("ak")
   static boolean field2116;
   @ObfuscatedName("bn")
   static int field2117;
   @ObfuscatedName("br")
   static int field2118;
   @ObfuscatedName("at")
   static final int[] field2119;
   @ObfuscatedName("bw")
   static int field2120;

   @ObfuscatedName("bz")
   public static final int[] method2579(int var0, int var1, int var2) {
      int var3 = var2 * field2106 + var0 * field2087 >> 16;
      var2 = var2 * field2087 - var0 * field2106 >> 16;
      var0 = var3;
      var3 = var1 * field2085 - var2 * field2079 >> 16;
      var2 = var1 * field2079 + var2 * field2085 >> 16;
      var2 |= 1;
      int var4 = class136.field2025 + var0 * class136.field2024 / var2 + Rasterizer2D.field3752;
      int var5 = class136.field2026 + var3 * class136.field2024 / var2 + Rasterizer2D.drawingAreaTop;
      return new int[]{var4, var5};
   }

   @ObfuscatedName("e")
   public void method2580(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1907; ++var6) {
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

      this.tiles[0][var1][var2].field1902 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("t")
   public static void method2581(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class146 var8 = new class146();
      var8.field2153 = var2 / 128;
      var8.field2163 = var3 / 128;
      var8.field2164 = var4 / 128;
      var8.field2155 = var5 / 128;
      var8.field2158 = var1;
      var8.field2157 = var2;
      var8.field2154 = var3;
      var8.field2170 = var4;
      var8.field2160 = var5;
      var8.field2161 = var6;
      var8.field2156 = var7;
      field2074[var0][field2068[var0]++] = var8;
   }

   @ObfuscatedName("w")
   public void method2582(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1922 = var4;
      }

   }

   @ObfuscatedName("z")
   public void method2583(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
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

         this.tiles[var1][var2][var3].field1901 = var23;
      } else {
         var21 = new SceneTilePaint(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].paint = var21;
      }

   }

   @ObfuscatedName("ae")
   public int method2584(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("c")
   public void method2585(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1907; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2397();
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

   @ObfuscatedName("o")
   public void method2586(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field2134 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field2142 = var7;
         var11.field2130 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }

   }

   @ObfuscatedName("g")
   public boolean method2587(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method2591(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("n")
   public boolean method2588(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + var5 * 64;
         int var12 = var3 * 128 + var6 * 64;
         return this.method2591(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("p")
   public void method2589() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field2059; ++var1) {
         for(var2 = 0; var2 < this.field2060; ++var2) {
            for(int var3 = 0; var3 < this.field2109; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field2098; ++var1) {
         for(var2 = 0; var2 < field2068[var1]; ++var2) {
            field2074[var1][var2] = null;
         }

         field2068[var1] = 0;
      }

      for(var1 = 0; var1 < this.field2065; ++var1) {
         this.objects[var1] = null;
      }

      this.field2065 = 0;

      for(var1 = 0; var1 < field2088.length; ++var1) {
         field2088[var1] = null;
      }

   }

   @ObfuscatedName("ax")
   public GameObject method2590(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1907; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("v")
   boolean method2591(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var14;
      for(int var15 = var2; var15 < var2 + var4; ++var15) {
         for(var14 = var3; var14 < var3 + var5; ++var14) {
            if(var15 < 0 || var14 < 0 || var15 >= this.field2060 || var14 >= this.field2109) {
               return false;
            }

            Tile var16 = this.tiles[var1][var15][var14];
            if(var16 != null && var16.field1907 >= 5) {
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
            var21.objects[var21.field1907] = var19;
            var21.field1909[var21.field1907] = var17;
            var21.field1910 |= var17;
            ++var21.field1907;
         }
      }

      if(var11) {
         this.objects[this.field2065++] = var19;
      }

      return true;
   }

   @ObfuscatedName("r")
   public void method2594(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }

   }

   @ObfuscatedName("d")
   public void method2596(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }

   }

   @ObfuscatedName("x")
   public void method2597(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1907; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method2724(var6);
               return;
            }
         }
      }

   }

   @ObfuscatedName("y")
   public void method2599(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }

   }

   @ObfuscatedName("u")
   public WallObject method2600(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("av")
   public DecorativeObject method2601(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("af")
   public GroundObject method2603(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("ap")
   public int method2605(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("ak")
   public int method2606(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1907; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method2609(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field2059; ++var4) {
         for(int var5 = 0; var5 < this.field2060; ++var5) {
            for(int var6 = 0; var6 < this.field2109; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var9;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var10 = (ModelData)var8.renderable1;
                     this.method2663(var10, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var9 = (ModelData)var8.renderable2;
                        this.method2663(var9, var4, var5, var6, 1, 1);
                        ModelData.method2354(var10, var9, 0, 0, 0, false);
                        var8.renderable2 = var9.light(var9.field1819, var9.field1829, var1, var2, var3);
                     }

                     var8.renderable1 = var10.light(var10.field1819, var10.field1829, var1, var2, var3);
                  }

                  for(int var13 = 0; var13 < var7.field1907; ++var13) {
                     GameObject var11 = var7.objects[var13];
                     if(var11 != null && var11.renderable instanceof ModelData) {
                        ModelData var12 = (ModelData)var11.renderable;
                        this.method2663(var12, var4, var5, var6, var11.offsetX - var11.relativeX + 1, var11.offsetY - var11.relativeY + 1);
                        var11.renderable = var12.light(var12.field1819, var12.field1829, var1, var2, var3);
                     }
                  }

                  GroundObject var14 = var7.groundObject;
                  if(var14 != null && var14.renderable instanceof ModelData) {
                     var9 = (ModelData)var14.renderable;
                     this.method2680(var9, var4, var5, var6);
                     var14.renderable = var9.light(var9.field1819, var9.field1829, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   public boolean method2610(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method2591(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("ac")
   public void method2612(int[] var1, int var2, int var3, int var4, int var5, int var6) {
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
            SceneTileModel var18 = var7.field1901;
            if(var18 != null) {
               var9 = var18.shape;
               int var11 = var18.rotation;
               int var12 = var18.underlay;
               int var13 = var18.overlay;
               int[] var14 = this.field2105[var9];
               int[] var15 = this.field2112[var11];
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

   @ObfuscatedName("ah")
   boolean method2613(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ay")
   static boolean method2614(int var0, int var1, int var2) {
      int var3 = var2 * field2106 + var0 * field2087 >> 16;
      int var4 = var2 * field2087 - var0 * field2106 >> 16;
      int var5 = var1 * field2079 + var4 * field2085 >> 16;
      int var6 = var1 * field2085 - var4 * field2079 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field2115 + var3 * 390 / var5;
         int var8 = field2086 + var6 * 390 / var5;
         return var7 >= field2117 && var7 <= field2099 && var8 >= field2118 && var8 <= field2120;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   public void method2615(int var1, int var2, int var3, boolean var4) {
      if(!method2617() || var4) {
         field2116 = true;
         viewportWalking = var4;
         field2090 = var1;
         field2091 = var2;
         field2076 = var3;
         selectedRegionTileX = -1;
         selectedRegionTileY = -1;
      }

   }

   @ObfuscatedName("ag")
   public void method2616() {
      viewportWalking = true;
   }

   @ObfuscatedName("aq")
   public static boolean method2617() {
      return viewportWalking && selectedRegionTileX != -1;
   }

   @ObfuscatedName("as")
   public static void method2618() {
      selectedRegionTileX = -1;
      viewportWalking = false;
   }

   @ObfuscatedName("an")
   public void method2619(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field2060 * 128) {
         var1 = this.field2060 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field2109 * 128) {
         var3 = this.field2109 * 128 - 1;
      }

      ++field2089;
      field2079 = class136.SINE[var4];
      field2085 = class136.COSINE[var4];
      field2106 = class136.SINE[var5];
      field2087 = class136.COSINE[var5];
      renderArea = field2113[(var4 - 128) / 32][var5 / 64];
      field2081 = var1;
      field2082 = var2;
      field2083 = var3;
      field2096 = var1 / 128;
      field2080 = var3 / 128;
      field2073 = var6;
      field2075 = field2096 - 25;
      if(field2075 < 0) {
         field2075 = 0;
      }

      field2077 = field2080 - 25;
      if(field2077 < 0) {
         field2077 = 0;
      }

      field2084 = field2096 + 25;
      if(field2084 > this.field2060) {
         field2084 = this.field2060;
      }

      field2094 = field2080 + 25;
      if(field2094 > this.field2109) {
         field2094 = this.field2109;
      }

      this.method2624();
      field2058 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field2064; var7 < this.field2059; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field2075; var9 < field2084; ++var9) {
            for(var10 = field2077; var10 < field2094; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1922 > var6 || !renderArea[var9 - field2096 + 25][var10 - field2080 + 25] && this.field2078[var7][var9][var10] - var2 < 2000) {
                     var11.field1912 = false;
                     var11.field1913 = false;
                     var11.field1904 = 0;
                  } else {
                     var11.field1912 = true;
                     var11.field1913 = true;
                     if(var11.field1907 > 0) {
                        var11.field1914 = true;
                     } else {
                        var11.field1914 = false;
                     }

                     ++field2058;
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
      for(var7 = this.field2064; var7 < this.field2059; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2096 + var9;
            var15 = field2096 - var9;
            if(var10 >= field2075 || var15 < field2084) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = field2080 + var16;
                  var13 = field2080 - var16;
                  if(var10 >= field2075) {
                     if(var12 >= field2077) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, true);
                        }
                     }

                     if(var13 < field2094) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, true);
                        }
                     }
                  }

                  if(var15 < field2084) {
                     if(var12 >= field2077) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, true);
                        }
                     }

                     if(var13 < field2094) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, true);
                        }
                     }
                  }

                  if(field2058 == 0) {
                     field2116 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field2064; var7 < this.field2059; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2096 + var9;
            var15 = field2096 - var9;
            if(var10 >= field2075 || var15 < field2084) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = field2080 + var16;
                  var13 = field2080 - var16;
                  if(var10 >= field2075) {
                     if(var12 >= field2077) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, false);
                        }
                     }

                     if(var13 < field2094) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, false);
                        }
                     }
                  }

                  if(var15 < field2084) {
                     if(var12 >= field2077) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, false);
                        }
                     }

                     if(var13 < field2094) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.field1912) {
                           this.method2693(var14, false);
                        }
                     }
                  }

                  if(field2058 == 0) {
                     field2116 = false;
                     return;
                  }
               }
            }
         }
      }

      field2116 = false;
   }

   @ObfuscatedName("ai")
   void method2621(SceneTilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field2081;
      int var11;
      int var12 = var11 = (var8 << 7) - field2083;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field2078[var2][var7][var8] - field2082;
      int var18 = this.field2078[var2][var7 + 1][var8] - field2082;
      int var19 = this.field2078[var2][var7 + 1][var8 + 1] - field2082;
      int var20 = this.field2078[var2][var7][var8 + 1] - field2082;
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
                  int var22 = class136.field2025 + var10 * class136.field2024 / var12;
                  int var23 = class136.field2026 + var17 * class136.field2024 / var12;
                  int var24 = class136.field2025 + var14 * class136.field2024 / var11;
                  int var25 = class136.field2026 + var18 * class136.field2024 / var11;
                  int var26 = class136.field2025 + var13 * class136.field2024 / var16;
                  int var27 = class136.field2026 + var19 * class136.field2024 / var16;
                  int var28 = class136.field2025 + var9 * class136.field2024 / var15;
                  int var29 = class136.field2026 + var21 * class136.field2024 / var15;
                  class136.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class136.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class136.rasterClipX || var28 > class136.rasterClipX || var24 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2116 && this.method2613(field2091, field2076, var27, var29, var25, var26, var28, var24)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.field2042 != 12345678) {
                           class136.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field2042, var1.field2043, var1.field2041);
                        }
                     } else if(!field2072) {
                        if(var1.flatShade) {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2042, var1.field2043, var1.field2041, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                        } else {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2042, var1.field2043, var1.field2041, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                        }
                     } else {
                        var30 = class136.field2028.vmethod2771(var1.texture);
                        class136.rasterGouraud(var27, var29, var25, var26, var28, var24, method2623(var30, var1.field2042), method2623(var30, var1.field2043), method2623(var30, var1.field2041));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class136.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class136.rasterClipX || var24 > class136.rasterClipX || var28 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2116 && this.method2613(field2091, field2076, var23, var25, var29, var22, var24, var28)) {
                        selectedRegionTileX = var7;
                        selectedRegionTileY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.field2040 != 12345678) {
                           class136.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field2040, var1.field2041, var1.field2043);
                        }
                     } else if(!field2072) {
                        class136.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field2040, var1.field2041, var1.field2043, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                     } else {
                        var30 = class136.field2028.vmethod2771(var1.texture);
                        class136.rasterGouraud(var23, var25, var29, var22, var24, var28, method2623(var30, var1.field2040), method2623(var30, var1.field2041), method2623(var30, var1.field2043));
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aw")
   void method2622(SceneTileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1857.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1857[var9] - field2081;
         var11 = var1.field1842[var9] - field2082;
         var12 = var1.field1843[var9] - field2083;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1850 != null) {
            SceneTileModel.field1858[var9] = var10;
            SceneTileModel.field1845[var9] = var13;
            SceneTileModel.field1860[var9] = var12;
         }

         SceneTileModel.field1856[var9] = class136.field2025 + var10 * class136.field2024 / var12;
         SceneTileModel.field1853[var9] = class136.field2026 + var13 * class136.field2024 / var12;
      }

      class136.rasterAlpha = 0;
      var8 = var1.field1851.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1851[var9];
         var11 = var1.field1848[var9];
         var12 = var1.field1849[var9];
         var13 = SceneTileModel.field1856[var10];
         int var14 = SceneTileModel.field1856[var11];
         int var15 = SceneTileModel.field1856[var12];
         int var16 = SceneTileModel.field1853[var10];
         int var17 = SceneTileModel.field1853[var11];
         int var18 = SceneTileModel.field1853[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class136.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class136.rasterClipX || var14 > class136.rasterClipX || var15 > class136.rasterClipX) {
               class136.rasterClipEnable = true;
            }

            if(field2116 && this.method2613(field2091, field2076, var16, var17, var18, var13, var14, var15)) {
               selectedRegionTileX = var6;
               selectedRegionTileY = var7;
            }

            if(var1.field1850 != null && var1.field1850[var9] != -1) {
               if(!field2072) {
                  if(var1.flatShade) {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1844[var9], var1.field1841[var9], var1.field1846[var9], SceneTileModel.field1858[0], SceneTileModel.field1858[1], SceneTileModel.field1858[3], SceneTileModel.field1845[0], SceneTileModel.field1845[1], SceneTileModel.field1845[3], SceneTileModel.field1860[0], SceneTileModel.field1860[1], SceneTileModel.field1860[3], var1.field1850[var9]);
                  } else {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1844[var9], var1.field1841[var9], var1.field1846[var9], SceneTileModel.field1858[var10], SceneTileModel.field1858[var11], SceneTileModel.field1858[var12], SceneTileModel.field1845[var10], SceneTileModel.field1845[var11], SceneTileModel.field1845[var12], SceneTileModel.field1860[var10], SceneTileModel.field1860[var11], SceneTileModel.field1860[var12], var1.field1850[var9]);
                  }
               } else {
                  int var19 = class136.field2028.vmethod2771(var1.field1850[var9]);
                  class136.rasterGouraud(var16, var17, var18, var13, var14, var15, method2623(var19, var1.field1844[var9]), method2623(var19, var1.field1841[var9]), method2623(var19, var1.field1846[var9]));
               }
            } else if(var1.field1844[var9] != 12345678) {
               class136.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1844[var9], var1.field1841[var9], var1.field1846[var9]);
            }
         }
      }

   }

   @ObfuscatedName("au")
   static final int method2623(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ad")
   void method2624() {
      int var1 = field2068[field2073];
      class146[] var2 = field2074[field2073];
      field2101 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class146 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var8;
         boolean var9;
         if(var4.field2158 == 1) {
            var5 = var4.field2153 - field2096 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2164 - field2080 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2155 - field2080 + 25;
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
                  var8 = field2081 - var4.field2157;
                  if(var8 > 32) {
                     var4.field2159 = 1;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.field2159 = 2;
                     var8 = -var8;
                  }

                  var4.field2166 = (var4.field2170 - field2083 << 8) / var8;
                  var4.field2167 = (var4.field2160 - field2083 << 8) / var8;
                  var4.field2168 = (var4.field2161 - field2082 << 8) / var8;
                  var4.field2169 = (var4.field2156 - field2082 << 8) / var8;
                  field2102[field2101++] = var4;
               }
            }
         } else if(var4.field2158 == 2) {
            var5 = var4.field2164 - field2080 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2153 - field2096 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2163 - field2096 + 25;
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
                  var8 = field2083 - var4.field2170;
                  if(var8 > 32) {
                     var4.field2159 = 3;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.field2159 = 4;
                     var8 = -var8;
                  }

                  var4.field2152 = (var4.field2157 - field2081 << 8) / var8;
                  var4.field2165 = (var4.field2154 - field2081 << 8) / var8;
                  var4.field2168 = (var4.field2161 - field2082 << 8) / var8;
                  var4.field2169 = (var4.field2156 - field2082 << 8) / var8;
                  field2102[field2101++] = var4;
               }
            }
         } else if(var4.field2158 == 4) {
            var5 = var4.field2161 - field2082;
            if(var5 > 128) {
               var6 = var4.field2164 - field2080 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2155 - field2080 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var10 = var4.field2153 - field2096 + 25;
                  if(var10 < 0) {
                     var10 = 0;
                  }

                  var8 = var4.field2163 - field2096 + 25;
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
                     var4.field2159 = 5;
                     var4.field2152 = (var4.field2157 - field2081 << 8) / var5;
                     var4.field2165 = (var4.field2154 - field2081 << 8) / var5;
                     var4.field2166 = (var4.field2170 - field2083 << 8) / var5;
                     var4.field2167 = (var4.field2160 - field2083 << 8) / var5;
                     field2102[field2101++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   boolean method2626(int var1, int var2, int var3) {
      int var4 = this.field2067[var1][var2][var3];
      if(var4 == -field2089) {
         return false;
      } else if(var4 == field2089) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2630(var5 + 1, this.field2078[var1][var2][var3], var6 + 1) && this.method2630(var5 + 128 - 1, this.field2078[var1][var2 + 1][var3], var6 + 1) && this.method2630(var5 + 128 - 1, this.field2078[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2630(var5 + 1, this.field2078[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field2067[var1][var2][var3] = field2089;
            return true;
         } else {
            this.field2067[var1][var2][var3] = -field2089;
            return false;
         }
      }
   }

   @ObfuscatedName("bg")
   boolean method2627(int var1, int var2, int var3, int var4) {
      if(!this.method2626(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field2078[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field2081) {
                  if(!this.method2630(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2630(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2630(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2630(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field2083) {
                  if(!this.method2630(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2630(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2630(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2630(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field2081) {
                  if(!this.method2630(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2630(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2630(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2630(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field2083) {
                  if(!this.method2630(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2630(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2630(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2630(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2630(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2630(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method2630(var5, var9, var6 + 128):(var4 == 32?this.method2630(var5 + 128, var9, var6 + 128):(var4 == 64?this.method2630(var5 + 128, var9, var6):(var4 == 128?this.method2630(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("bf")
   boolean method2628(int var1, int var2, int var3, int var4) {
      if(!this.method2626(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2630(var5 + 1, this.field2078[var1][var2][var3] - var4, var6 + 1) && this.method2630(var5 + 128 - 1, this.field2078[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2630(var5 + 128 - 1, this.field2078[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2630(var5 + 1, this.field2078[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bv")
   boolean method2630(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2101; ++var4) {
         class146 var5 = field2102[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field2159 == 1) {
            var6 = var5.field2157 - var1;
            if(var6 > 0) {
               var7 = var5.field2170 + (var5.field2166 * var6 >> 8);
               var8 = var5.field2160 + (var5.field2167 * var6 >> 8);
               var9 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var10 = var5.field2156 + (var5.field2169 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2159 == 2) {
            var6 = var1 - var5.field2157;
            if(var6 > 0) {
               var7 = var5.field2170 + (var5.field2166 * var6 >> 8);
               var8 = var5.field2160 + (var5.field2167 * var6 >> 8);
               var9 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var10 = var5.field2156 + (var5.field2169 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2159 == 3) {
            var6 = var5.field2170 - var3;
            if(var6 > 0) {
               var7 = var5.field2157 + (var5.field2152 * var6 >> 8);
               var8 = var5.field2154 + (var5.field2165 * var6 >> 8);
               var9 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var10 = var5.field2156 + (var5.field2169 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2159 == 4) {
            var6 = var3 - var5.field2170;
            if(var6 > 0) {
               var7 = var5.field2157 + (var5.field2152 * var6 >> 8);
               var8 = var5.field2154 + (var5.field2165 * var6 >> 8);
               var9 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var10 = var5.field2156 + (var5.field2169 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2159 == 5) {
            var6 = var2 - var5.field2161;
            if(var6 > 0) {
               var7 = var5.field2157 + (var5.field2152 * var6 >> 8);
               var8 = var5.field2154 + (var5.field2165 * var6 >> 8);
               var9 = var5.field2170 + (var5.field2166 * var6 >> 8);
               var10 = var5.field2160 + (var5.field2167 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("m")
   public void method2631(int var1) {
      this.field2064 = var1;

      for(int var2 = 0; var2 < this.field2060; ++var2) {
         for(int var3 = 0; var3 < this.field2109; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("j")
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

   @ObfuscatedName("b")
   public void method2646(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }

   }

   @ObfuscatedName("al")
   public int method2659(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("ao")
   void method2663(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field2059) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field2060) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field2109 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field2078[var12][var13][var14] + this.field2078[var12][var13 + 1][var14] + this.field2078[var12][var13][var14 + 1] + this.field2078[var12][var13 + 1][var14 + 1]) / 4 - (this.field2078[var2][var3][var4] + this.field2078[var2][var3 + 1][var4] + this.field2078[var2][var3][var4 + 1] + this.field2078[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method2354(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method2354(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.field1907; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2354(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("ar")
   void method2680(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field2060) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2354(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field2060) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2354(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field2060 && var4 < this.field2109) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2354(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field2060 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2354(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("az")
   void method2693(Tile var1, boolean var2) {
      field2063.method3505(var1);

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
                                    var3 = (Tile)field2063.method3485();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1913);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1917;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1912) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1913) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field2096 && var4 > field2075) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1913 && (var9.field1912 || (var3.field1910 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field2096 && var4 < field2084 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1913 && (var9.field1912 || (var3.field1910 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field2080 && var5 > field2077) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1913 && (var9.field1912 || (var3.field1910 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field2080 && var5 < field2094 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1913 && (var9.field1912 || (var3.field1910 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1912 = false;
                                 if(var3.field1902 != null) {
                                    var9 = var3.field1902;
                                    if(var9.paint != null) {
                                       if(!this.method2626(0, var4, var5)) {
                                          this.method2621(var9.paint, 0, field2079, field2085, field2106, field2087, var4, var5);
                                       }
                                    } else if(var9.field1901 != null && !this.method2626(0, var4, var5)) {
                                       this.method2622(var9.field1901, field2079, field2085, field2106, field2087, var4, var5);
                                    }

                                    var16 = var9.wallObject;
                                    if(var16 != null) {
                                       var16.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var16.x - field2081, var16.floor - field2082, var16.y - field2083, var16.hash);
                                    }

                                    for(var10 = 0; var10 < var9.field1907; ++var10) {
                                       var17 = var9.objects[var10];
                                       if(var17 != null) {
                                          var17.renderable.vmethod2753(var17.orientation, field2079, field2085, field2106, field2087, var17.x - field2081, var17.height - field2082, var17.y - field2083, var17.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.paint != null) {
                                    if(!this.method2626(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.paint.field2042 != 12345678 || field2116 && var6 <= field2090) {
                                          this.method2621(var3.paint, var7, field2079, field2085, field2106, field2087, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1901 != null && !this.method2626(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2622(var3.field1901, field2079, field2085, field2106, field2087, var4, var5);
                                 }

                                 var21 = 0;
                                 var10 = 0;
                                 WallObject var23 = var3.wallObject;
                                 DecorativeObject var24 = var3.decorativeObject;
                                 if(var23 != null || var24 != null) {
                                    if(field2096 == var4) {
                                       ++var21;
                                    } else if(field2096 < var4) {
                                       var21 += 2;
                                    }

                                    if(field2080 == var5) {
                                       var21 += 3;
                                    } else if(field2080 > var5) {
                                       var21 += 6;
                                    }

                                    var10 = field2104[var21];
                                    var3.field1899 = field2062[var21];
                                 }

                                 if(var23 != null) {
                                    if((var23.field2142 & field2100[var21]) != 0) {
                                       if(var23.field2142 == 16) {
                                          var3.field1904 = 3;
                                          var3.field1916 = field2107[var21];
                                          var3.field1897 = 3 - var3.field1916;
                                       } else if(var23.field2142 == 32) {
                                          var3.field1904 = 6;
                                          var3.field1916 = field2108[var21];
                                          var3.field1897 = 6 - var3.field1916;
                                       } else if(var23.field2142 == 64) {
                                          var3.field1904 = 12;
                                          var3.field1916 = field2119[var21];
                                          var3.field1897 = 12 - var3.field1916;
                                       } else {
                                          var3.field1904 = 9;
                                          var3.field1916 = field2110[var21];
                                          var3.field1897 = 9 - var3.field1916;
                                       }
                                    } else {
                                       var3.field1904 = 0;
                                    }

                                    if((var23.field2142 & var10) != 0 && !this.method2627(var7, var4, var5, var23.field2142)) {
                                       var23.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var23.x - field2081, var23.floor - field2082, var23.y - field2083, var23.hash);
                                    }

                                    if((var23.field2130 & var10) != 0 && !this.method2627(var7, var4, var5, var23.field2130)) {
                                       var23.renderable2.vmethod2753(0, field2079, field2085, field2106, field2087, var23.x - field2081, var23.floor - field2082, var23.y - field2083, var23.hash);
                                    }
                                 }

                                 if(var24 != null && !this.method2628(var7, var4, var5, var24.renderable1.modelHeight)) {
                                    if((var24.renderFlag & var10) != 0) {
                                       var24.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var24.x - field2081 + var24.offsetX, var24.floor - field2082, var24.y - field2083 + var24.offsetY, var24.hash);
                                    } else if(var24.renderFlag == 256) {
                                       var12 = var24.x - field2081;
                                       var14 = var24.floor - field2082;
                                       var13 = var24.y - field2083;
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
                                          var24.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var12 + var24.offsetX, var14, var13 + var24.offsetY, var24.hash);
                                       } else if(var24.renderable2 != null) {
                                          var24.renderable2.vmethod2753(0, field2079, field2085, field2106, field2087, var12, var14, var13, var24.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var34 = var3.groundObject;
                                    if(var34 != null) {
                                       var34.renderable.vmethod2753(0, field2079, field2085, field2106, field2087, var34.x - field2081, var34.floor - field2082, var34.y - field2083, var34.hash);
                                    }

                                    ItemLayer var26 = var3.itemLayer;
                                    if(var26 != null && var26.height == 0) {
                                       if(var26.middle != null) {
                                          var26.middle.vmethod2753(0, field2079, field2085, field2106, field2087, var26.x - field2081, var26.hash - field2082, var26.y - field2083, var26.flags);
                                       }

                                       if(var26.top != null) {
                                          var26.top.vmethod2753(0, field2079, field2085, field2106, field2087, var26.x - field2081, var26.hash - field2082, var26.y - field2083, var26.flags);
                                       }

                                       if(var26.bottom != null) {
                                          var26.bottom.vmethod2753(0, field2079, field2085, field2106, field2087, var26.x - field2081, var26.hash - field2082, var26.y - field2083, var26.flags);
                                       }
                                    }
                                 }

                                 var12 = var3.field1910;
                                 if(var12 != 0) {
                                    if(var4 < field2096 && (var12 & 4) != 0) {
                                       var22 = var8[var4 + 1][var5];
                                       if(var22 != null && var22.field1913) {
                                          field2063.method3505(var22);
                                       }
                                    }

                                    if(var5 < field2080 && (var12 & 2) != 0) {
                                       var22 = var8[var4][var5 + 1];
                                       if(var22 != null && var22.field1913) {
                                          field2063.method3505(var22);
                                       }
                                    }

                                    if(var4 > field2096 && (var12 & 1) != 0) {
                                       var22 = var8[var4 - 1][var5];
                                       if(var22 != null && var22.field1913) {
                                          field2063.method3505(var22);
                                       }
                                    }

                                    if(var5 > field2080 && (var12 & 8) != 0) {
                                       var22 = var8[var4][var5 - 1];
                                       if(var22 != null && var22.field1913) {
                                          field2063.method3505(var22);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1904 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1907; ++var21) {
                                    if(var3.objects[var21].field2199 != field2089 && (var3.field1909[var21] & var3.field1904) == var3.field1916) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var16 = var3.wallObject;
                                    if(!this.method2627(var7, var4, var5, var16.field2142)) {
                                       var16.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var16.x - field2081, var16.floor - field2082, var16.y - field2083, var16.hash);
                                    }

                                    var3.field1904 = 0;
                                 }
                              }

                              if(!var3.field1914) {
                                 break;
                              }

                              try {
                                 int var32 = var3.field1907;
                                 var3.field1914 = false;
                                 var21 = 0;

                                 label562:
                                 for(var10 = 0; var10 < var32; ++var10) {
                                    var17 = var3.objects[var10];
                                    if(var17.field2199 != field2089) {
                                       for(var11 = var17.relativeX; var11 <= var17.offsetX; ++var11) {
                                          for(var12 = var17.relativeY; var12 <= var17.offsetY; ++var12) {
                                             var22 = var8[var11][var12];
                                             if(var22.field1912) {
                                                var3.field1914 = true;
                                                continue label562;
                                             }

                                             if(var22.field1904 != 0) {
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

                                                if((var13 & var22.field1904) == var3.field1897) {
                                                   var3.field1914 = true;
                                                   continue label562;
                                                }
                                             }
                                          }
                                       }

                                       field2088[var21++] = var17;
                                       var11 = field2096 - var17.relativeX;
                                       var12 = var17.offsetX - field2096;
                                       if(var12 > var11) {
                                          var11 = var12;
                                       }

                                       var14 = field2080 - var17.relativeY;
                                       var13 = var17.offsetY - field2080;
                                       if(var13 > var14) {
                                          var17.field2198 = var11 + var13;
                                       } else {
                                          var17.field2198 = var11 + var14;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var10 = -50;
                                    var15 = -1;

                                    GameObject var33;
                                    for(var11 = 0; var11 < var21; ++var11) {
                                       var33 = field2088[var11];
                                       if(var33.field2199 != field2089) {
                                          if(var33.field2198 > var10) {
                                             var10 = var33.field2198;
                                             var15 = var11;
                                          } else if(var33.field2198 == var10) {
                                             var14 = var33.x - field2081;
                                             var13 = var33.y - field2083;
                                             var18 = field2088[var15].x - field2081;
                                             var19 = field2088[var15].y - field2083;
                                             if(var14 * var14 + var13 * var13 > var18 * var18 + var19 * var19) {
                                                var15 = var11;
                                             }
                                          }
                                       }
                                    }

                                    if(var15 == -1) {
                                       break;
                                    }

                                    var33 = field2088[var15];
                                    var33.field2199 = field2089;
                                    if(!this.method2723(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod2753(var33.orientation, field2079, field2085, field2106, field2087, var33.x - field2081, var33.height - field2082, var33.y - field2083, var33.hash);
                                    }

                                    for(var12 = var33.relativeX; var12 <= var33.offsetX; ++var12) {
                                       for(var14 = var33.relativeY; var14 <= var33.offsetY; ++var14) {
                                          Tile var35 = var8[var12][var14];
                                          if(var35.field1904 != 0) {
                                             field2063.method3505(var35);
                                          } else if((var12 != var4 || var14 != var5) && var35.field1913) {
                                             field2063.method3505(var35);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1914) {
                                    break;
                                 }
                              } catch (Exception var27) {
                                 var3.field1914 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1913);
                     } while(var3.field1904 != 0);

                     if(var4 > field2096 || var4 <= field2075) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1913);

                  if(var4 < field2096 || var4 >= field2084 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1913);

               if(var5 > field2080 || var5 <= field2077) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1913);

            if(var5 < field2080 || var5 >= field2094 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1913);

         var3.field1913 = false;
         --field2058;
         ItemLayer var28 = var3.itemLayer;
         if(var28 != null && var28.height != 0) {
            if(var28.middle != null) {
               var28.middle.vmethod2753(0, field2079, field2085, field2106, field2087, var28.x - field2081, var28.hash - field2082 - var28.height, var28.y - field2083, var28.flags);
            }

            if(var28.top != null) {
               var28.top.vmethod2753(0, field2079, field2085, field2106, field2087, var28.x - field2081, var28.hash - field2082 - var28.height, var28.y - field2083, var28.flags);
            }

            if(var28.bottom != null) {
               var28.bottom.vmethod2753(0, field2079, field2085, field2106, field2087, var28.x - field2081, var28.hash - field2082 - var28.height, var28.y - field2083, var28.flags);
            }
         }

         if(var3.field1899 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method2628(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1899) != 0) {
                  var29.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var29.x - field2081 + var29.offsetX, var29.floor - field2082, var29.y - field2083 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var10 = var29.x - field2081;
                  var15 = var29.floor - field2082;
                  var11 = var29.y - field2083;
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
                     var29.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var10 + var29.offsetX, var15, var11 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2753(0, field2079, field2085, field2106, field2087, var10, var15, var11, var29.hash);
                  }
               }
            }

            WallObject var31 = var3.wallObject;
            if(var31 != null) {
               if((var31.field2130 & var3.field1899) != 0 && !this.method2627(var7, var4, var5, var31.field2130)) {
                  var31.renderable2.vmethod2753(0, field2079, field2085, field2106, field2087, var31.x - field2081, var31.floor - field2082, var31.y - field2083, var31.hash);
               }

               if((var31.field2142 & var3.field1899) != 0 && !this.method2627(var7, var4, var5, var31.field2142)) {
                  var31.renderable1.vmethod2753(0, field2079, field2085, field2106, field2087, var31.x - field2081, var31.floor - field2082, var31.y - field2083, var31.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field2059 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1913) {
               field2063.method3505(var30);
            }
         }

         if(var4 < field2096) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1913) {
               field2063.method3505(var30);
            }
         }

         if(var5 < field2080) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1913) {
               field2063.method3505(var30);
            }
         }

         if(var4 > field2096) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1913) {
               field2063.method3505(var30);
            }
         }

         if(var5 > field2080) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1913) {
               field2063.method3505(var30);
            }
         }
      }
   }

   @ObfuscatedName("s")
   public void method2694() {
      for(int var1 = 0; var1 < this.field2065; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method2724(var2);
         this.objects[var1] = null;
      }

      this.field2065 = 0;
   }

   @ObfuscatedName("q")
   public void method2700(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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

   @ObfuscatedName("bi")
   boolean method2723(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method2626(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2630(var7 + 1, this.field2078[var1][var2][var4] - var6, var8 + 1) && this.method2630(var7 + 128 - 1, this.field2078[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2630(var7 + 128 - 1, this.field2078[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2630(var7 + 1, this.field2078[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field2067[var1][var7][var8] == -field2089) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field2078[var1][var2][var4] - var6;
         if(!this.method2630(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2630(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2630(var7, var9, var11)) {
                  return false;
               } else if(!this.method2630(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("k")
   void method2724(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1907; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1907;

                     for(int var6 = var5; var6 < var4.field1907; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1909[var6] = var4.field1909[var6 + 1];
                     }

                     var4.objects[var4.field1907] = null;
                     break;
                  }
               }

               var4.field1910 = 0;

               for(var5 = 0; var5 < var4.field1907; ++var5) {
                  var4.field1910 |= var4.field1909[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   public int method2727(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field2134 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1907; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("aa")
   public static void method2738(int[] var0, int var1, int var2, int var3, int var4) {
      field2117 = 0;
      field2118 = 0;
      field2099 = var3;
      field2120 = var4;
      field2115 = var3 / 2;
      field2086 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field2079 = class136.SINE[var6];
            field2085 = class136.COSINE[var6];
            field2106 = class136.SINE[var7];
            field2087 = class136.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var12 = -26; var12 <= 26; ++var12) {
               for(var10 = -26; var10 <= 26; ++var10) {
                  var11 = var12 * 128;
                  int var13 = var10 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2614(var11, var0[var8] + var15, var13)) {
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
                        if(var5[var6][var7][var8 + var10 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var10 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][var7][var8 + var10 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var10 + 25 + 1][var9 + var11 + 25 + 1]) {
                           var16 = true;
                           break label76;
                        }
                     }
                  }

                  field2113[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field2064 = 0;
      this.field2065 = 0;
      this.objects = new GameObject[5000];
      this.field2105 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.field2112 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.field2059 = var1;
      this.field2060 = var2;
      this.field2109 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field2067 = new int[var1][var2 + 1][var3 + 1];
      this.field2078 = var4;
      this.method2589();
   }

   @ObfuscatedName("l")
   public void method2750(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }

   }

   static {
      field2072 = true;
      field2058 = 0;
      field2073 = 0;
      field2088 = new GameObject[100];
      field2116 = false;
      field2090 = 0;
      field2091 = 0;
      field2076 = 0;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
      viewportWalking = false;
      field2098 = 4;
      field2068 = new int[field2098];
      field2074 = new class146[field2098][500];
      field2101 = 0;
      field2102 = new class146[500];
      field2063 = new Deque();
      field2104 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2100 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field2062 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field2107 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field2108 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field2119 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field2110 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field2113 = new boolean[8][32][51][51];
   }
}

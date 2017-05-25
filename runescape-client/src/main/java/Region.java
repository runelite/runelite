import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("Region")
public class Region {
   @ObfuscatedName("bb")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("h")
   int field2038;
   @ObfuscatedName("u")
   int field2039;
   @ObfuscatedName("q")
   int field2040;
   @ObfuscatedName("f")
   static int field2041;
   @ObfuscatedName("v")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("t")
   int field2043;
   @ObfuscatedName("p")
   int field2044;
   @ObfuscatedName("l")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("a")
   int[][][] field2046;
   @ObfuscatedName("au")
   static final int[] field2047;
   @ObfuscatedName("bz")
   static final int[] field2051;
   @ObfuscatedName("g")
   int[][][] field2052;
   @ObfuscatedName("ae")
   public static int field2053;
   @ObfuscatedName("n")
   static int field2054;
   @ObfuscatedName("e")
   static int field2055;
   @ObfuscatedName("s")
   static int field2056;
   @ObfuscatedName("ai")
   static int field2057;
   @ObfuscatedName("y")
   static int field2058;
   @ObfuscatedName("w")
   static int field2059;
   @ObfuscatedName("ar")
   static boolean field2060;
   @ObfuscatedName("c")
   static int field2061;
   @ObfuscatedName("z")
   static int field2062;
   @ObfuscatedName("ay")
   static int field2063;
   @ObfuscatedName("ah")
   static int field2064;
   @ObfuscatedName("az")
   static int field2065;
   @ObfuscatedName("aa")
   static final int[] field2066;
   @ObfuscatedName("aq")
   static GameObject[] field2067;
   @ObfuscatedName("af")
   static boolean field2068;
   @ObfuscatedName("aj")
   static int field2069;
   @ObfuscatedName("ax")
   static int field2070;
   @ObfuscatedName("ad")
   static int field2071;
   @ObfuscatedName("av")
   public static int field2072;
   @ObfuscatedName("ap")
   static int field2073;
   @ObfuscatedName("j")
   static int field2074;
   @ObfuscatedName("an")
   static final int[] field2077;
   @ObfuscatedName("ab")
   static final int[] field2078;
   @ObfuscatedName("am")
   static class146[][] field2079;
   @ObfuscatedName("as")
   static class146[] field2080;
   @ObfuscatedName("ak")
   static final int[] field2081;
   @ObfuscatedName("aw")
   static Deque field2082;
   @ObfuscatedName("al")
   static final int[] field2083;
   @ObfuscatedName("ao")
   static int[] field2084;
   @ObfuscatedName("ac")
   static int field2085;
   @ObfuscatedName("i")
   public static boolean field2087;
   @ObfuscatedName("m")
   static int field2088;
   @ObfuscatedName("o")
   static int field2089;
   @ObfuscatedName("bd")
   int[][] field2090;
   @ObfuscatedName("bp")
   int[][] field2091;
   @ObfuscatedName("bf")
   static boolean[][][][] field2092;
   @ObfuscatedName("d")
   static int field2093;
   @ObfuscatedName("bw")
   static int field2094;
   @ObfuscatedName("bh")
   static int field2095;
   @ObfuscatedName("bl")
   static int field2096;
   @ObfuscatedName("bi")
   static int field2097;
   @ObfuscatedName("bq")
   static int field2098;
   @ObfuscatedName("bn")
   static int field2099;

   @ObfuscatedName("i")
   public void method2709() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field2038; ++var1) {
         for(var2 = 0; var2 < this.field2039; ++var2) {
            for(int var3 = 0; var3 < this.field2040; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field2057; ++var1) {
         for(var2 = 0; var2 < field2084[var1]; ++var2) {
            field2079[var1][var2] = null;
         }

         field2084[var1] = 0;
      }

      for(var1 = 0; var1 < this.field2044; ++var1) {
         this.objects[var1] = null;
      }

      this.field2044 = 0;

      for(var1 = 0; var1 < field2067.length; ++var1) {
         field2067[var1] = null;
      }

   }

   @ObfuscatedName("h")
   public void method2710(int var1) {
      this.field2043 = var1;

      for(int var2 = 0; var2 < this.field2039; ++var2) {
         for(int var3 = 0; var3 < this.field2040; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("q")
   public static void method2712(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class146 var8 = new class146();
      var8.field2131 = var2 / 128;
      var8.field2128 = var3 / 128;
      var8.field2139 = var4 / 128;
      var8.field2135 = var5 / 128;
      var8.field2132 = var1;
      var8.field2133 = var2;
      var8.field2129 = var3;
      var8.field2137 = var4;
      var8.field2136 = var5;
      var8.field2130 = var6;
      var8.field2138 = var7;
      field2079[var0][field2084[var0]++] = var8;
   }

   @ObfuscatedName("t")
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

   @ObfuscatedName("p")
   public void method2716(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1895; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2575();
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

   @ObfuscatedName("l")
   public void method2717(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field2112 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field2115 = var7;
         var11.field2114 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   static {
      field2087 = true;
      field2089 = 0;
      field2074 = 0;
      field2067 = new GameObject[100];
      field2068 = false;
      field2069 = 0;
      field2070 = 0;
      field2071 = 0;
      field2072 = -1;
      field2053 = -1;
      field2060 = false;
      field2057 = 4;
      field2084 = new int[field2057];
      field2079 = new class146[field2057][500];
      field2073 = 0;
      field2080 = new class146[500];
      field2082 = new Deque();
      field2083 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2081 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field2066 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field2077 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field2047 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field2078 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field2051 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field2092 = new boolean[8][32][51][51];
   }

   @ObfuscatedName("ae")
   void method2718(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field2038) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field2039) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field2040 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field2052[var12][var13][var14] + this.field2052[var12][var13 + 1][var14] + this.field2052[var12][var13][var14 + 1] + this.field2052[var12][var13 + 1][var14 + 1]) / 4 - (this.field2052[var2][var3][var4] + this.field2052[var2][var3 + 1][var4] + this.field2052[var2][var3][var4 + 1] + this.field2052[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var23;
                              if(var17.renderable1 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable1;
                                 ModelData.method2464(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable2;
                                 ModelData.method2464(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var18 = 0; var18 < var15.field1895; ++var18) {
                              GameObject var19 = var15.objects[var18];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2464(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("bf")
   boolean method2719(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2073; ++var4) {
         class146 var5 = field2080[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field2134 == 1) {
            var6 = var5.field2133 - var1;
            if(var6 > 0) {
               var7 = var5.field2137 + (var5.field2142 * var6 >> 8);
               var8 = var5.field2136 + (var5.field2143 * var6 >> 8);
               var9 = var5.field2130 + (var5.field2144 * var6 >> 8);
               var10 = var5.field2138 + (var5.field2145 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2134 == 2) {
            var6 = var1 - var5.field2133;
            if(var6 > 0) {
               var7 = var5.field2137 + (var5.field2142 * var6 >> 8);
               var8 = var5.field2136 + (var5.field2143 * var6 >> 8);
               var9 = var5.field2130 + (var5.field2144 * var6 >> 8);
               var10 = var5.field2138 + (var5.field2145 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2134 == 3) {
            var6 = var5.field2137 - var3;
            if(var6 > 0) {
               var7 = var5.field2133 + (var5.field2140 * var6 >> 8);
               var8 = var5.field2129 + (var5.field2141 * var6 >> 8);
               var9 = var5.field2130 + (var5.field2144 * var6 >> 8);
               var10 = var5.field2138 + (var5.field2145 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2134 == 4) {
            var6 = var3 - var5.field2137;
            if(var6 > 0) {
               var7 = var5.field2133 + (var5.field2140 * var6 >> 8);
               var8 = var5.field2129 + (var5.field2141 * var6 >> 8);
               var9 = var5.field2130 + (var5.field2144 * var6 >> 8);
               var10 = var5.field2138 + (var5.field2145 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2134 == 5) {
            var6 = var2 - var5.field2130;
            if(var6 > 0) {
               var7 = var5.field2133 + (var5.field2140 * var6 >> 8);
               var8 = var5.field2129 + (var5.field2141 * var6 >> 8);
               var9 = var5.field2137 + (var5.field2142 * var6 >> 8);
               var10 = var5.field2136 + (var5.field2143 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("x")
   public boolean method2720(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method2721(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("o")
   boolean method2721(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field2039 || var15 >= this.field2040) {
               return false;
            }

            Tile var20 = this.tiles[var1][var14][var15];
            if(var20 != null && var20.field1895 >= 5) {
               return false;
            }
         }
      }

      GameObject var21 = new GameObject();
      var21.hash = var12;
      var21.flags = var13;
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

            for(int var18 = var1; var18 >= 0; --var18) {
               if(this.tiles[var18][var15][var16] == null) {
                  this.tiles[var18][var15][var16] = new Tile(var18, var15, var16);
               }
            }

            Tile var22 = this.tiles[var1][var15][var16];
            var22.objects[var22.field1895] = var21;
            var22.field1897[var22.field1895] = var17;
            var22.field1898 |= var17;
            ++var22.field1895;
         }
      }

      if(var11) {
         this.objects[this.field2044++] = var21;
      }

      return true;
   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field2043 = 0;
      this.field2044 = 0;
      this.objects = new GameObject[5000];
      this.field2090 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.field2091 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.field2038 = var1;
      this.field2039 = var2;
      this.field2040 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field2046 = new int[var1][var2 + 1][var3 + 1];
      this.field2052 = var4;
      this.method2709();
   }

   @ObfuscatedName("m")
   void method2722(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1895; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1895;

                     for(int var6 = var5; var6 < var4.field1895; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1897[var6] = var4.field1897[var6 + 1];
                     }

                     var4.objects[var4.field1895] = null;
                     break;
                  }
               }

               var4.field1898 = 0;

               for(var5 = 0; var5 < var4.field1895; ++var5) {
                  var4.field1898 |= var4.field1897[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   public void method2723(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }
   }

   @ObfuscatedName("n")
   public void method2724(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   @ObfuscatedName("f")
   public void method2727(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("c")
   public void method2728(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("ay")
   public DecorativeObject method2730(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("ah")
   public GameObject method2731(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1895; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("az")
   public GroundObject method2732(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("ac")
   public int method2733(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("aq")
   public int method2734(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("aj")
   public int method2736(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method2738(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field2038; ++var4) {
         for(int var5 = 0; var5 < this.field2039; ++var5) {
            for(int var6 = 0; var6 < this.field2040; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var12 = (ModelData)var8.renderable1;
                     this.method2718(var12, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method2718(var10, var4, var5, var6, 1, 1);
                        ModelData.method2464(var12, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.method2487(var10.field1810, var10.field1782, var1, var2, var3);
                     }

                     var8.renderable1 = var12.method2487(var12.field1810, var12.field1782, var1, var2, var3);
                  }

                  for(int var9 = 0; var9 < var7.field1895; ++var9) {
                     GameObject var13 = var7.objects[var9];
                     if(var13 != null && var13.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var13.renderable;
                        this.method2718(var11, var4, var5, var6, var13.offsetX - var13.relativeX + 1, var13.offsetY - var13.relativeY + 1);
                        var13.renderable = var11.method2487(var11.field1810, var11.field1782, var1, var2, var3);
                     }
                  }

                  GroundObject var14 = var7.groundObject;
                  if(var14 != null && var14.renderable instanceof ModelData) {
                     var10 = (ModelData)var14.renderable;
                     this.method2739(var10, var4, var5, var6);
                     var14.renderable = var10.method2487(var10.field1810, var10.field1782, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   void method2739(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field2039) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2464(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field2039) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2464(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field2039 && var4 < this.field2040) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2464(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field2039 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2464(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("y")
   public void method2740(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("at")
   static boolean method2743(int var0, int var1, int var2) {
      int var3 = var2 * field2065 + var0 * field2085 >> 16;
      int var4 = var2 * field2085 - var0 * field2065 >> 16;
      int var5 = var1 * field2063 + var4 * field2064 >> 16;
      int var6 = var1 * field2064 - var4 * field2063 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field2094 + var3 * class136.field1998 / var5;
         int var8 = field2095 + var6 * class136.field1998 / var5;
         return var7 >= field2096 && var7 <= field2098 && var8 >= field2097 && var8 <= field2099;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ai")
   public void method2744(int var1, int var2, int var3, boolean var4) {
      if(!method2786() || var4) {
         field2068 = true;
         field2060 = var4;
         field2069 = var1;
         field2070 = var2;
         field2071 = var3;
         field2072 = -1;
         field2053 = -1;
      }
   }

   @ObfuscatedName("ao")
   public void method2745() {
      field2060 = true;
   }

   @ObfuscatedName("ap")
   public static void method2747() {
      field2072 = -1;
      field2060 = false;
   }

   @ObfuscatedName("as")
   public void method2748(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field2039 * 128) {
         var1 = this.field2039 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field2040 * 128) {
         var3 = this.field2040 * 128 - 1;
      }

      ++field2088;
      field2063 = class136.SINE[var4];
      field2064 = class136.COSINE[var4];
      field2065 = class136.SINE[var5];
      field2085 = class136.COSINE[var5];
      renderArea = field2092[(var4 - 128) / 32][var5 / 64];
      field2041 = var1;
      field2061 = var2;
      field2062 = var3;
      field2058 = var1 / 128;
      field2059 = var3 / 128;
      field2074 = var6;
      field2093 = field2058 - 25;
      if(field2093 < 0) {
         field2093 = 0;
      }

      field2056 = field2059 - 25;
      if(field2056 < 0) {
         field2056 = 0;
      }

      field2055 = field2058 + 25;
      if(field2055 > this.field2039) {
         field2055 = this.field2039;
      }

      field2054 = field2059 + 25;
      if(field2054 > this.field2040) {
         field2054 = this.field2040;
      }

      this.method2754();
      field2089 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field2043; var7 < this.field2038; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field2093; var9 < field2055; ++var9) {
            for(var10 = field2056; var10 < field2054; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1891 <= var6 && (renderArea[var9 - field2058 + 25][var10 - field2059 + 25] || this.field2052[var7][var9][var10] - var2 >= 2000)) {
                     var11.field1900 = true;
                     var11.field1901 = true;
                     if(var11.field1895 > 0) {
                        var11.field1885 = true;
                     } else {
                        var11.field1885 = false;
                     }

                     ++field2089;
                  } else {
                     var11.field1900 = false;
                     var11.field1901 = false;
                     var11.field1903 = 0;
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
      for(var7 = this.field2043; var7 < this.field2038; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2058 + var9;
            var16 = field2058 - var9;
            if(var10 >= field2093 || var16 < field2055) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2059 + var12;
                  var14 = field2059 - var12;
                  if(var10 >= field2093) {
                     if(var13 >= field2056) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, true);
                        }
                     }

                     if(var14 < field2054) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, true);
                        }
                     }
                  }

                  if(var16 < field2055) {
                     if(var13 >= field2056) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, true);
                        }
                     }

                     if(var14 < field2054) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, true);
                        }
                     }
                  }

                  if(field2089 == 0) {
                     field2068 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field2043; var7 < this.field2038; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2058 + var9;
            var16 = field2058 - var9;
            if(var10 >= field2093 || var16 < field2055) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2059 + var12;
                  var14 = field2059 - var12;
                  if(var10 >= field2093) {
                     if(var13 >= field2056) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, false);
                        }
                     }

                     if(var14 < field2054) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, false);
                        }
                     }
                  }

                  if(var16 < field2055) {
                     if(var13 >= field2056) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, false);
                        }
                     }

                     if(var14 < field2054) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1900) {
                           this.method2818(var15, false);
                        }
                     }
                  }

                  if(field2089 == 0) {
                     field2068 = false;
                     return;
                  }
               }
            }
         }
      }

      field2068 = false;
   }

   @ObfuscatedName("al")
   void method2750(class137 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field2041;
      int var11;
      int var12 = var11 = (var8 << 7) - field2062;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field2052[var2][var7][var8] - field2061;
      int var18 = this.field2052[var2][var7 + 1][var8] - field2061;
      int var19 = this.field2052[var2][var7 + 1][var8 + 1] - field2061;
      int var20 = this.field2052[var2][var7][var8 + 1] - field2061;
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
                  int var22 = class136.field2007 + var10 * class136.field1998 / var12;
                  int var23 = class136.field2008 + var17 * class136.field1998 / var12;
                  int var24 = class136.field2007 + var14 * class136.field1998 / var11;
                  int var25 = class136.field2008 + var18 * class136.field1998 / var11;
                  int var26 = class136.field2007 + var13 * class136.field1998 / var16;
                  int var27 = class136.field2008 + var19 * class136.field1998 / var16;
                  int var28 = class136.field2007 + var9 * class136.field1998 / var15;
                  int var29 = class136.field2008 + var21 * class136.field1998 / var15;
                  class136.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class136.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class136.rasterClipX || var28 > class136.rasterClipX || var24 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2068 && this.method2773(field2070, field2071, var27, var29, var25, var26, var28, var24)) {
                        field2072 = var7;
                        field2053 = var8;
                     }

                     if(var1.field2027 == -1) {
                        if(var1.field2024 != 12345678) {
                           class136.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field2024, var1.field2025, var1.field2023);
                        }
                     } else if(!field2087) {
                        if(var1.field2029) {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2024, var1.field2025, var1.field2023, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2027);
                        } else {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2024, var1.field2025, var1.field2023, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field2027);
                        }
                     } else {
                        var30 = class136.field2017.vmethod2918(var1.field2027);
                        class136.rasterGouraud(var27, var29, var25, var26, var28, var24, method2752(var30, var1.field2024), method2752(var30, var1.field2025), method2752(var30, var1.field2023));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class136.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class136.rasterClipX || var24 > class136.rasterClipX || var28 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2068 && this.method2773(field2070, field2071, var23, var25, var29, var22, var24, var28)) {
                        field2072 = var7;
                        field2053 = var8;
                     }

                     if(var1.field2027 == -1) {
                        if(var1.field2026 != 12345678) {
                           class136.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field2026, var1.field2023, var1.field2025);
                        }
                     } else if(!field2087) {
                        class136.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field2026, var1.field2023, var1.field2025, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2027);
                     } else {
                        var30 = class136.field2017.vmethod2918(var1.field2027);
                        class136.rasterGouraud(var23, var25, var29, var22, var24, var28, method2752(var30, var1.field2026), method2752(var30, var1.field2023), method2752(var30, var1.field2025));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ak")
   void method2751(class128 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1824.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1824[var9] - field2041;
         var11 = var1.field1839[var9] - field2061;
         var12 = var1.field1825[var9] - field2062;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1832 != null) {
            class128.field1840[var9] = var10;
            class128.field1841[var9] = var13;
            class128.field1842[var9] = var12;
         }

         class128.field1838[var9] = class136.field2007 + var10 * class136.field1998 / var12;
         class128.field1844[var9] = class136.field2008 + var13 * class136.field1998 / var12;
      }

      class136.rasterAlpha = 0;
      var8 = var1.field1829.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1829[var9];
         var11 = var1.field1830[var9];
         var12 = var1.field1826[var9];
         var13 = class128.field1838[var10];
         int var14 = class128.field1838[var11];
         int var15 = class128.field1838[var12];
         int var16 = class128.field1844[var10];
         int var17 = class128.field1844[var11];
         int var18 = class128.field1844[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class136.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class136.rasterClipX || var14 > class136.rasterClipX || var15 > class136.rasterClipX) {
               class136.rasterClipEnable = true;
            }

            if(field2068 && this.method2773(field2070, field2071, var16, var17, var18, var13, var14, var15)) {
               field2072 = var6;
               field2053 = var7;
            }

            if(var1.field1832 != null && var1.field1832[var9] != -1) {
               if(!field2087) {
                  if(var1.field1823) {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1831[var9], var1.field1827[var9], var1.field1828[var9], class128.field1840[0], class128.field1840[1], class128.field1840[3], class128.field1841[0], class128.field1841[1], class128.field1841[3], class128.field1842[0], class128.field1842[1], class128.field1842[3], var1.field1832[var9]);
                  } else {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1831[var9], var1.field1827[var9], var1.field1828[var9], class128.field1840[var10], class128.field1840[var11], class128.field1840[var12], class128.field1841[var10], class128.field1841[var11], class128.field1841[var12], class128.field1842[var10], class128.field1842[var11], class128.field1842[var12], var1.field1832[var9]);
                  }
               } else {
                  int var19 = class136.field2017.vmethod2918(var1.field1832[var9]);
                  class136.rasterGouraud(var16, var17, var18, var13, var14, var15, method2752(var19, var1.field1831[var9]), method2752(var19, var1.field1827[var9]), method2752(var19, var1.field1828[var9]));
               }
            } else if(var1.field1831[var9] != 12345678) {
               class136.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1831[var9], var1.field1827[var9], var1.field1828[var9]);
            }
         }
      }

   }

   @ObfuscatedName("aa")
   static final int method2752(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("au")
   void method2754() {
      int var1 = field2084[field2074];
      class146[] var2 = field2079[field2074];
      field2073 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class146 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field2132 == 1) {
            var5 = var4.field2131 - field2058 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2139 - field2059 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2135 - field2059 + 25;
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
                  var9 = field2041 - var4.field2133;
                  if(var9 > 32) {
                     var4.field2134 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2134 = 2;
                     var9 = -var9;
                  }

                  var4.field2142 = (var4.field2137 - field2062 << 8) / var9;
                  var4.field2143 = (var4.field2136 - field2062 << 8) / var9;
                  var4.field2144 = (var4.field2130 - field2061 << 8) / var9;
                  var4.field2145 = (var4.field2138 - field2061 << 8) / var9;
                  field2080[field2073++] = var4;
               }
            }
         } else if(var4.field2132 == 2) {
            var5 = var4.field2139 - field2059 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2131 - field2058 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2128 - field2058 + 25;
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
                  var9 = field2062 - var4.field2137;
                  if(var9 > 32) {
                     var4.field2134 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2134 = 4;
                     var9 = -var9;
                  }

                  var4.field2140 = (var4.field2133 - field2041 << 8) / var9;
                  var4.field2141 = (var4.field2129 - field2041 << 8) / var9;
                  var4.field2144 = (var4.field2130 - field2061 << 8) / var9;
                  var4.field2145 = (var4.field2138 - field2061 << 8) / var9;
                  field2080[field2073++] = var4;
               }
            }
         } else if(var4.field2132 == 4) {
            var5 = var4.field2130 - field2061;
            if(var5 > 128) {
               var6 = var4.field2139 - field2059 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2135 - field2059 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field2131 - field2058 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field2128 - field2058 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label183:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label183;
                        }
                     }
                  }

                  if(var10) {
                     var4.field2134 = 5;
                     var4.field2140 = (var4.field2133 - field2041 << 8) / var5;
                     var4.field2141 = (var4.field2129 - field2041 << 8) / var5;
                     var4.field2142 = (var4.field2137 - field2062 << 8) / var5;
                     var4.field2143 = (var4.field2136 - field2062 << 8) / var5;
                     field2080[field2073++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   boolean method2755(int var1, int var2, int var3) {
      int var4 = this.field2046[var1][var2][var3];
      if(var4 == -field2088) {
         return false;
      } else if(var4 == field2088) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2719(var5 + 1, this.field2052[var1][var2][var3], var6 + 1) && this.method2719(var5 + 128 - 1, this.field2052[var1][var2 + 1][var3], var6 + 1) && this.method2719(var5 + 128 - 1, this.field2052[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2719(var5 + 1, this.field2052[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field2046[var1][var2][var3] = field2088;
            return true;
         } else {
            this.field2046[var1][var2][var3] = -field2088;
            return false;
         }
      }
   }

   @ObfuscatedName("bz")
   boolean method2756(int var1, int var2, int var3, int var4) {
      if(!this.method2755(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field2052[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field2041) {
                  if(!this.method2719(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2719(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2719(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2719(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field2062) {
                  if(!this.method2719(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2719(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2719(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2719(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field2041) {
                  if(!this.method2719(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2719(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2719(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2719(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field2062) {
                  if(!this.method2719(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2719(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2719(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2719(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2719(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2719(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method2719(var5, var9, var6 + 128):(var4 == 32?this.method2719(var5 + 128, var9, var6 + 128):(var4 == 64?this.method2719(var5 + 128, var9, var6):(var4 == 128?this.method2719(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("bp")
   boolean method2758(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method2755(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2719(var7 + 1, this.field2052[var1][var2][var4] - var6, var8 + 1) && this.method2719(var7 + 128 - 1, this.field2052[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2719(var7 + 128 - 1, this.field2052[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2719(var7 + 1, this.field2052[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field2046[var1][var7][var8] == -field2088) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field2052[var1][var2][var4] - var6;
         if(!this.method2719(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2719(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2719(var7, var9, var11)) {
                  return false;
               } else if(!this.method2719(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   public boolean method2771(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method2721(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("an")
   boolean method2773(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("a")
   public void method2777(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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

   @ObfuscatedName("j")
   public void method2779() {
      for(int var1 = 0; var1 < this.field2044; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method2722(var2);
         this.objects[var1] = null;
      }

      this.field2044 = 0;
   }

   @ObfuscatedName("am")
   public static boolean method2786() {
      return field2060 && field2072 != -1;
   }

   @ObfuscatedName("k")
   public boolean method2787(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + var5 * 64;
         int var12 = var3 * 128 + var6 * 64;
         return this.method2721(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("ag")
   public static void method2788(int[] var0, int var1, int var2, int var3, int var4) {
      field2096 = 0;
      field2097 = 0;
      field2098 = var3;
      field2099 = var4;
      field2094 = var3 / 2;
      field2095 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field2063 = class136.SINE[var6];
            field2064 = class136.COSINE[var6];
            field2065 = class136.SINE[var7];
            field2085 = class136.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2743(var12, var0[var8] + var15, var13)) {
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

                  label104:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label104;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label104;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label104;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label104;
                        }
                     }
                  }

                  field2092[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("bd")
   boolean method2792(int var1, int var2, int var3, int var4) {
      if(!this.method2755(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2719(var5 + 1, this.field2052[var1][var2][var3] - var4, var6 + 1) && this.method2719(var5 + 128 - 1, this.field2052[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2719(var5 + 128 - 1, this.field2052[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2719(var5 + 1, this.field2052[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("v")
   public void method2793(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class137 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class137(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1890 = var21;
      } else if(var4 != 1) {
         class128 var23 = new class128(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1889 = var23;
      } else {
         var21 = new class137(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1890 = var21;
      }
   }

   @ObfuscatedName("w")
   public void method2800(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1895; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method2722(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("ar")
   public void method2806(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class137 var8 = var7.field1890;
         int var10;
         if(var8 != null) {
            int var9 = var8.field2028;
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
            class128 var18 = var7.field1889;
            if(var18 != null) {
               var10 = var18.field1834;
               int var11 = var18.field1835;
               int var12 = var18.field1836;
               int var13 = var18.field1837;
               int[] var14 = this.field2090[var10];
               int[] var15 = this.field2091[var11];
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

   @ObfuscatedName("aw")
   void method2818(Tile var1, boolean var2) {
      field2082.method3655(var1);

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
                                    var3 = (Tile)field2082.method3658();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1901);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1888;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1900) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1901) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field2058 && var4 > field2093) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1901 && (var9.field1900 || (var3.field1898 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field2058 && var4 < field2055 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1901 && (var9.field1900 || (var3.field1898 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field2059 && var5 > field2056) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1901 && (var9.field1900 || (var3.field1898 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field2059 && var5 < field2054 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1901 && (var9.field1900 || (var3.field1898 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1900 = false;
                                 if(var3.field1902 != null) {
                                    var9 = var3.field1902;
                                    if(var9.field1890 != null) {
                                       if(!this.method2755(0, var4, var5)) {
                                          this.method2750(var9.field1890, 0, field2063, field2064, field2065, field2085, var4, var5);
                                       }
                                    } else if(var9.field1889 != null && !this.method2755(0, var4, var5)) {
                                       this.method2751(var9.field1889, field2063, field2064, field2065, field2085, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var10.x - field2041, var10.floor - field2061, var10.y - field2062, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1895; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod2903(var12.orientation, field2063, field2064, field2065, field2085, var12.x - field2041, var12.height - field2061, var12.y - field2062, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1890 != null) {
                                    if(!this.method2755(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1890.field2024 != 12345678 || field2068 && var6 <= field2069) {
                                          this.method2750(var3.field1890, var7, field2063, field2064, field2065, field2085, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1889 != null && !this.method2755(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2751(var3.field1889, field2063, field2064, field2065, field2085, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(field2058 == var4) {
                                       ++var21;
                                    } else if(field2058 < var4) {
                                       var21 += 2;
                                    }

                                    if(field2059 == var5) {
                                       var21 += 3;
                                    } else if(field2059 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field2083[var21];
                                    var3.field1907 = field2066[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field2115 & field2081[var21]) != 0) {
                                       if(var31.field2115 == 16) {
                                          var3.field1903 = 3;
                                          var3.field1904 = field2077[var21];
                                          var3.field1905 = 3 - var3.field1904;
                                       } else if(var31.field2115 == 32) {
                                          var3.field1903 = 6;
                                          var3.field1904 = field2047[var21];
                                          var3.field1905 = 6 - var3.field1904;
                                       } else if(var31.field2115 == 64) {
                                          var3.field1903 = 12;
                                          var3.field1904 = field2078[var21];
                                          var3.field1905 = 12 - var3.field1904;
                                       } else {
                                          var3.field1903 = 9;
                                          var3.field1904 = field2051[var21];
                                          var3.field1905 = 9 - var3.field1904;
                                       }
                                    } else {
                                       var3.field1903 = 0;
                                    }

                                    if((var31.field2115 & var11) != 0 && !this.method2756(var7, var4, var5, var31.field2115)) {
                                       var31.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var31.x - field2041, var31.floor - field2061, var31.y - field2062, var31.hash);
                                    }

                                    if((var31.field2114 & var11) != 0 && !this.method2756(var7, var4, var5, var31.field2114)) {
                                       var31.renderable2.vmethod2903(0, field2063, field2064, field2065, field2085, var31.x - field2041, var31.floor - field2061, var31.y - field2062, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.method2792(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.renderFlag & var11) != 0) {
                                       var13.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var13.x - field2041 + var13.offsetX, var13.floor - field2061, var13.y - field2062 + var13.offsetY, var13.hash);
                                    } else if(var13.renderFlag == 256) {
                                       var14 = var13.x - field2041;
                                       var15 = var13.floor - field2061;
                                       var16 = var13.y - field2062;
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
                                          var13.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var14 + var13.offsetX, var15, var16 + var13.offsetY, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.vmethod2903(0, field2063, field2064, field2065, field2085, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.vmethod2903(0, field2063, field2064, field2065, field2085, var22.x - field2041, var22.floor - field2061, var22.y - field2062, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.vmethod2903(0, field2063, field2064, field2065, field2085, var23.x - field2041, var23.hash - field2061, var23.y - field2062, var23.flags);
                                       }

                                       if(var23.top != null) {
                                          var23.top.vmethod2903(0, field2063, field2064, field2065, field2085, var23.x - field2041, var23.hash - field2061, var23.y - field2062, var23.flags);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.vmethod2903(0, field2063, field2064, field2065, field2085, var23.x - field2041, var23.hash - field2061, var23.y - field2062, var23.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1898;
                                 if(var14 != 0) {
                                    if(var4 < field2058 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1901) {
                                          field2082.method3655(var36);
                                       }
                                    }

                                    if(var5 < field2059 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1901) {
                                          field2082.method3655(var36);
                                       }
                                    }

                                    if(var4 > field2058 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1901) {
                                          field2082.method3655(var36);
                                       }
                                    }

                                    if(var5 > field2059 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1901) {
                                          field2082.method3655(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1903 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1895; ++var21) {
                                    if(var3.objects[var21].field2170 != field2088 && (var3.field1897[var21] & var3.field1903) == var3.field1904) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method2756(var7, var4, var5, var10.field2115)) {
                                       var10.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var10.x - field2041, var10.floor - field2061, var10.y - field2062, var10.hash);
                                    }

                                    var3.field1903 = 0;
                                 }
                              }

                              if(!var3.field1885) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1895;
                                 var3.field1885 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field2170 != field2088) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1900) {
                                                var3.field1885 = true;
                                                continue label563;
                                             }

                                             if(var36.field1903 != 0) {
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

                                                if((var16 & var36.field1903) == var3.field1905) {
                                                   var3.field1885 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field2067[var21++] = var12;
                                       var24 = field2058 - var12.relativeX;
                                       var14 = var12.offsetX - field2058;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field2059 - var12.relativeY;
                                       var16 = var12.offsetY - field2059;
                                       if(var16 > var15) {
                                          var12.field2169 = var24 + var16;
                                       } else {
                                          var12.field2169 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = field2067[var24];
                                       if(var35.field2170 != field2088) {
                                          if(var35.field2169 > var11) {
                                             var11 = var35.field2169;
                                             var25 = var24;
                                          } else if(var35.field2169 == var11) {
                                             var15 = var35.x - field2041;
                                             var16 = var35.y - field2062;
                                             var17 = field2067[var25].x - field2041;
                                             var18 = field2067[var25].y - field2062;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = field2067[var25];
                                    var33.field2170 = field2088;
                                    if(!this.method2758(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod2903(var33.orientation, field2063, field2064, field2065, field2085, var33.x - field2041, var33.height - field2061, var33.y - field2062, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.field1903 != 0) {
                                             field2082.method3655(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1901) {
                                             field2082.method3655(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1885) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1885 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1901);
                     } while(var3.field1903 != 0);

                     if(var4 > field2058 || var4 <= field2093) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1901);

                  if(var4 < field2058 || var4 >= field2055 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1901);

               if(var5 > field2059 || var5 <= field2056) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1901);

            if(var5 < field2059 || var5 >= field2054 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1901);

         var3.field1901 = false;
         --field2089;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod2903(0, field2063, field2064, field2065, field2085, var32.x - field2041, var32.hash - field2061 - var32.height, var32.y - field2062, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod2903(0, field2063, field2064, field2065, field2085, var32.x - field2041, var32.hash - field2061 - var32.height, var32.y - field2062, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod2903(0, field2063, field2064, field2065, field2085, var32.x - field2041, var32.hash - field2061 - var32.height, var32.y - field2062, var32.flags);
            }
         }

         if(var3.field1907 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method2792(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1907) != 0) {
                  var29.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var29.x - field2041 + var29.offsetX, var29.floor - field2061, var29.y - field2062 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - field2041;
                  var25 = var29.floor - field2061;
                  var24 = var29.y - field2062;
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
                     var29.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2903(0, field2063, field2064, field2065, field2085, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field2114 & var3.field1907) != 0 && !this.method2756(var7, var4, var5, var27.field2114)) {
                  var27.renderable2.vmethod2903(0, field2063, field2064, field2065, field2085, var27.x - field2041, var27.floor - field2061, var27.y - field2062, var27.hash);
               }

               if((var27.field2115 & var3.field1907) != 0 && !this.method2756(var7, var4, var5, var27.field2115)) {
                  var27.renderable1.vmethod2903(0, field2063, field2064, field2065, field2085, var27.x - field2041, var27.floor - field2061, var27.y - field2062, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field2038 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1901) {
               field2082.method3655(var30);
            }
         }

         if(var4 < field2058) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1901) {
               field2082.method3655(var30);
            }
         }

         if(var5 < field2059) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1901) {
               field2082.method3655(var30);
            }
         }

         if(var4 > field2058) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1901) {
               field2082.method3655(var30);
            }
         }

         if(var5 > field2059) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1901) {
               field2082.method3655(var30);
            }
         }
      }
   }

   @ObfuscatedName("af")
   public int method2821(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1895; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("g")
   public void method2827(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1891 = var4;
      }
   }

   @ObfuscatedName("bb")
   public static final int[] method2854(int var0, int var1, int var2) {
      int var3 = var2 * field2065 + var0 * field2085 >> 16;
      var2 = var2 * field2085 - var0 * field2065 >> 16;
      var0 = var3;
      var3 = var1 * field2064 - var2 * field2063 >> 16;
      var2 = var1 * field2063 + var2 * field2064 >> 16;
      var2 |= 1;
      int var4 = class136.field2007 + var0 * class136.field1998 / var2 + Rasterizer2D.field3749;
      int var5 = class136.field2008 + var3 * class136.field1998 / var2 + Rasterizer2D.field3746;
      return new int[]{var4, var5};
   }

   @ObfuscatedName("z")
   public WallObject method2879(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("u")
   public void method2889(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1895; ++var6) {
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

   @ObfuscatedName("ax")
   public int method2896(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field2112 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1895; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }
}

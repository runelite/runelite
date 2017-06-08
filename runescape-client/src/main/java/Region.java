import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("Region")
public class Region {
   @ObfuscatedName("bx")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("p")
   int field2061;
   @ObfuscatedName("bj")
   static boolean[][][][] field2062;
   @ObfuscatedName("j")
   int field2063;
   @ObfuscatedName("f")
   int[][][] field2064;
   @ObfuscatedName("bo")
   static int field2065;
   @ObfuscatedName("c")
   int field2066;
   @ObfuscatedName("az")
   static final int[] field2067;
   @ObfuscatedName("at")
   static int field2069;
   @ObfuscatedName("bm")
   static int field2073;
   @ObfuscatedName("y")
   static int field2074;
   @ObfuscatedName("r")
   static int field2075;
   @ObfuscatedName("b")
   static int field2076;
   @ObfuscatedName("bv")
   static final int[] field2077;
   @ObfuscatedName("v")
   static int field2078;
   @ObfuscatedName("t")
   static int field2079;
   @ObfuscatedName("w")
   static int field2080;
   @ObfuscatedName("l")
   static int field2081;
   @ObfuscatedName("aj")
   static final int[] field2082;
   @ObfuscatedName("k")
   static int field2083;
   @ObfuscatedName("d")
   static int field2084;
   @ObfuscatedName("u")
   static int field2085;
   @ObfuscatedName("ae")
   static int field2086;
   @ObfuscatedName("h")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("ad")
   static int field2088;
   @ObfuscatedName("m")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("aw")
   static GameObject[] field2090;
   @ObfuscatedName("ax")
   static int[] field2091;
   @ObfuscatedName("al")
   static int field2092;
   @ObfuscatedName("s")
   static int field2093;
   @ObfuscatedName("au")
   static int field2094;
   @ObfuscatedName("ak")
   public static int field2095;
   @ObfuscatedName("as")
   public static int field2096;
   @ObfuscatedName("ah")
   static boolean field2097;
   @ObfuscatedName("q")
   static int field2098;
   @ObfuscatedName("aa")
   static int field2099;
   @ObfuscatedName("ac")
   static int field2100;
   @ObfuscatedName("bc")
   int[][] field2101;
   @ObfuscatedName("av")
   static class146[][] field2102;
   @ObfuscatedName("aq")
   static int field2103;
   @ObfuscatedName("af")
   static class146[] field2104;
   @ObfuscatedName("ag")
   static Deque field2105;
   @ObfuscatedName("ar")
   static final int[] field2106;
   @ObfuscatedName("an")
   static boolean field2107;
   @ObfuscatedName("ay")
   static final int[] field2108;
   @ObfuscatedName("ap")
   static final int[] field2109;
   @ObfuscatedName("ai")
   static final int[] field2110;
   @ObfuscatedName("bn")
   static int field2111;
   @ObfuscatedName("i")
   int field2112;
   @ObfuscatedName("bd")
   int[][] field2113;
   @ObfuscatedName("ao")
   static int field2114;
   @ObfuscatedName("n")
   public static boolean field2115;
   @ObfuscatedName("z")
   int field2118;
   @ObfuscatedName("bh")
   static int field2119;
   @ObfuscatedName("g")
   int[][][] field2120;
   @ObfuscatedName("bs")
   static int field2121;
   @ObfuscatedName("bf")
   static int field2122;

   @ObfuscatedName("n")
   public void method2675() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field2061; ++var1) {
         for(var2 = 0; var2 < this.field2112; ++var2) {
            for(int var3 = 0; var3 < this.field2063; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field2100; ++var1) {
         for(var2 = 0; var2 < field2091[var1]; ++var2) {
            field2102[var1][var2] = null;
         }

         field2091[var1] = 0;
      }

      for(var1 = 0; var1 < this.field2118; ++var1) {
         this.objects[var1] = null;
      }

      this.field2118 = 0;

      for(var1 = 0; var1 < field2090.length; ++var1) {
         field2090[var1] = null;
      }

   }

   @ObfuscatedName("i")
   public void method2677(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1925; ++var6) {
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

      this.tiles[0][var1][var2].field1929 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("af")
   public void method2678(int var1, int var2, int var3, boolean var4) {
      if(!method2714() || var4) {
         field2107 = true;
         field2097 = var4;
         field2092 = var1;
         field2069 = var2;
         field2094 = var3;
         field2095 = -1;
         field2096 = -1;
      }
   }

   @ObfuscatedName("f")
   public void method2679(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1921 = var4;
      }
   }

   @ObfuscatedName("m")
   public void method2680(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class137 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class137(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1911 = var21;
      } else if(var4 != 1) {
         class128 var23 = new class128(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1912 = var23;
      } else {
         var21 = new class137(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1911 = var21;
      }
   }

   @ObfuscatedName("c")
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

   @ObfuscatedName("z")
   public void method2682(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1925; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2515();
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

   @ObfuscatedName("h")
   public void method2683(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field2138 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field2133 = var7;
         var11.field2134 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   @ObfuscatedName("g")
   public void method2684(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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

   @ObfuscatedName("e")
   public boolean method2685(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + var5 * 64;
         int var12 = var3 * 128 + var6 * 64;
         return this.method2688(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("o")
   public boolean method2686(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method2688(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("x")
   public boolean method2687(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method2688(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("a")
   boolean method2688(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field2112 || var15 >= this.field2063) {
               return false;
            }

            Tile var21 = this.tiles[var1][var14][var15];
            if(var21 != null && var21.field1925 >= 5) {
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
            var18.objects[var18.field1925] = var20;
            var18.field1919[var18.field1925] = var17;
            var18.field1908 |= var17;
            ++var18.field1925;
         }
      }

      if(var11) {
         this.objects[this.field2118++] = var20;
      }

      return true;
   }

   @ObfuscatedName("y")
   public void method2689() {
      for(int var1 = 0; var1 < this.field2118; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method2741(var2);
         this.objects[var1] = null;
      }

      this.field2118 = 0;
   }

   @ObfuscatedName("v")
   public void method2693(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("an")
   public GameObject method2699(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1925; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("at")
   public int method2701(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("au")
   public int method2702(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("ak")
   public int method2703(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1925; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("as")
   public int method2704(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("bx")
   boolean method2705(int var1, int var2, int var3, int var4) {
      if(!this.method2723(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field2064[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field2083) {
                  if(!this.method2727(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2727(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2727(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2727(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field2085) {
                  if(!this.method2727(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2727(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2727(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2727(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field2083) {
                  if(!this.method2727(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2727(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2727(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2727(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field2085) {
                  if(!this.method2727(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2727(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2727(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2727(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2727(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2727(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method2727(var5, var9, var6 + 128):(var4 == 32?this.method2727(var5 + 128, var9, var6 + 128):(var4 == 64?this.method2727(var5 + 128, var9, var6):(var4 == 128?this.method2727(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method2706(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field2061; ++var4) {
         for(int var5 = 0; var5 < this.field2112; ++var5) {
            for(int var6 = 0; var6 < this.field2063; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method2845(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method2845(var10, var4, var5, var6, 1, 1);
                        ModelData.method2485(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.method2437(var10.field1802, var10.field1835, var1, var2, var3);
                     }

                     var8.renderable1 = var9.method2437(var9.field1802, var9.field1835, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1925; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method2845(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.method2437(var11.field1802, var11.field1835, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method2707(var10, var4, var5, var6);
                     var13.renderable = var10.method2437(var10.field1802, var10.field1835, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   void method2707(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field2112) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2485(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field2112) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2485(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field2112 && var4 < this.field2063) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2485(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field2112 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2485(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("p")
   public void method2708(int var1) {
      this.field2066 = var1;

      for(int var2 = 0; var2 < this.field2112; ++var2) {
         for(int var3 = 0; var3 < this.field2063; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("av")
   public static void method2710(int[] var0, int var1, int var2, int var3, int var4) {
      field2119 = 0;
      field2073 = 0;
      field2121 = var3;
      field2065 = var4;
      field2122 = var3 / 2;
      field2111 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field2086 = class136.SINE[var6];
            field2114 = class136.COSINE[var6];
            field2088 = class136.SINE[var7];
            field2099 = class136.COSINE[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2711(var12, var0[var8] + var15, var13)) {
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

                  label107:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label107;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label107;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label107;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label107;
                        }
                     }
                  }

                  field2062[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("aq")
   static boolean method2711(int var0, int var1, int var2) {
      int var3 = var2 * field2088 + var0 * field2099 >> 16;
      int var4 = var2 * field2099 - var0 * field2088 >> 16;
      int var5 = var1 * field2086 + var4 * field2114 >> 16;
      int var6 = var1 * field2114 - var4 * field2086 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field2122 + var3 * class136.field2028 / var5;
         int var8 = field2111 + var6 * class136.field2028 / var5;
         return var7 >= field2119 && var7 <= field2121 && var8 >= field2073 && var8 <= field2065;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ag")
   public void method2713() {
      field2097 = true;
   }

   @ObfuscatedName("ar")
   public static boolean method2714() {
      return field2097 && field2095 != -1;
   }

   @ObfuscatedName("j")
   public static void method2715(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class146 var8 = new class146();
      var8.field2174 = var2 / 128;
      var8.field2164 = var3 / 128;
      var8.field2158 = var4 / 128;
      var8.field2170 = var5 / 128;
      var8.field2160 = var1;
      var8.field2161 = var2;
      var8.field2162 = var3;
      var8.field2169 = var4;
      var8.field2171 = var5;
      var8.field2165 = var6;
      var8.field2166 = var7;
      field2102[var0][field2091[var0]++] = var8;
   }

   @ObfuscatedName("ay")
   public void method2716(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field2112 * 128) {
         var1 = this.field2112 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field2063 * 128) {
         var3 = this.field2063 * 128 - 1;
      }

      ++field2076;
      field2086 = class136.SINE[var4];
      field2114 = class136.COSINE[var4];
      field2088 = class136.SINE[var5];
      field2099 = class136.COSINE[var5];
      renderArea = field2062[(var4 - 128) / 32][var5 / 64];
      field2083 = var1;
      field2084 = var2;
      field2085 = var3;
      field2081 = var1 / 128;
      field2098 = var3 / 128;
      field2075 = var6;
      field2093 = field2081 - 25;
      if(field2093 < 0) {
         field2093 = 0;
      }

      field2079 = field2098 - 25;
      if(field2079 < 0) {
         field2079 = 0;
      }

      field2078 = field2081 + 25;
      if(field2078 > this.field2112) {
         field2078 = this.field2112;
      }

      field2080 = field2098 + 25;
      if(field2080 > this.field2063) {
         field2080 = this.field2063;
      }

      this.method2722();
      field2074 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field2066; var7 < this.field2061; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field2093; var9 < field2078; ++var9) {
            for(var10 = field2079; var10 < field2080; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1921 <= var6 && (renderArea[var9 - field2081 + 25][var10 - field2098 + 25] || this.field2064[var7][var9][var10] - var2 >= 2000)) {
                     var11.field1915 = true;
                     var11.field1923 = true;
                     if(var11.field1925 > 0) {
                        var11.field1924 = true;
                     } else {
                        var11.field1924 = false;
                     }

                     ++field2074;
                  } else {
                     var11.field1915 = false;
                     var11.field1923 = false;
                     var11.field1910 = 0;
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
      for(var7 = this.field2066; var7 < this.field2061; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2081 + var9;
            var16 = field2081 - var9;
            if(var10 >= field2093 || var16 < field2078) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2098 + var12;
                  var14 = field2098 - var12;
                  if(var10 >= field2093) {
                     if(var13 >= field2079) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, true);
                        }
                     }

                     if(var14 < field2080) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, true);
                        }
                     }
                  }

                  if(var16 < field2078) {
                     if(var13 >= field2079) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, true);
                        }
                     }

                     if(var14 < field2080) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, true);
                        }
                     }
                  }

                  if(field2074 == 0) {
                     field2107 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field2066; var7 < this.field2061; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field2081 + var9;
            var16 = field2081 - var9;
            if(var10 >= field2093 || var16 < field2078) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field2098 + var12;
                  var14 = field2098 - var12;
                  if(var10 >= field2093) {
                     if(var13 >= field2079) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, false);
                        }
                     }

                     if(var14 < field2080) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, false);
                        }
                     }
                  }

                  if(var16 < field2078) {
                     if(var13 >= field2079) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, false);
                        }
                     }

                     if(var14 < field2080) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1915) {
                           this.method2717(var15, false);
                        }
                     }
                  }

                  if(field2074 == 0) {
                     field2107 = false;
                     return;
                  }
               }
            }
         }
      }

      field2107 = false;
   }

   @ObfuscatedName("ap")
   void method2717(Tile var1, boolean var2) {
      field2105.method3634(var1);

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
                                    var3 = (Tile)field2105.method3604();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1923);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1907;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1915) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1923) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field2081 && var4 > field2093) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1923 && (var9.field1915 || (var3.field1908 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field2081 && var4 < field2078 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1923 && (var9.field1915 || (var3.field1908 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field2098 && var5 > field2079) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1923 && (var9.field1915 || (var3.field1908 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field2098 && var5 < field2080 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1923 && (var9.field1915 || (var3.field1908 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1915 = false;
                                 if(var3.field1929 != null) {
                                    var9 = var3.field1929;
                                    if(var9.field1911 != null) {
                                       if(!this.method2723(0, var4, var5)) {
                                          this.method2718(var9.field1911, 0, field2086, field2114, field2088, field2099, var4, var5);
                                       }
                                    } else if(var9.field1912 != null && !this.method2723(0, var4, var5)) {
                                       this.method2791(var9.field1912, field2086, field2114, field2088, field2099, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var10.x - field2083, var10.floor - field2084, var10.y - field2085, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1925; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod2870(var12.orientation, field2086, field2114, field2088, field2099, var12.x - field2083, var12.height - field2084, var12.y - field2085, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1911 != null) {
                                    if(!this.method2723(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1911.field2046 != 12345678 || field2107 && var6 <= field2092) {
                                          this.method2718(var3.field1911, var7, field2086, field2114, field2088, field2099, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1912 != null && !this.method2723(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2791(var3.field1912, field2086, field2114, field2088, field2099, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(field2081 == var4) {
                                       ++var21;
                                    } else if(field2081 < var4) {
                                       var21 += 2;
                                    }

                                    if(field2098 == var5) {
                                       var21 += 3;
                                    } else if(field2098 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field2106[var21];
                                    var3.field1928 = field2108[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field2133 & field2082[var21]) != 0) {
                                       if(var31.field2133 == 16) {
                                          var3.field1910 = 3;
                                          var3.field1926 = field2109[var21];
                                          var3.field1927 = 3 - var3.field1926;
                                       } else if(var31.field2133 == 32) {
                                          var3.field1910 = 6;
                                          var3.field1926 = field2110[var21];
                                          var3.field1927 = 6 - var3.field1926;
                                       } else if(var31.field2133 == 64) {
                                          var3.field1910 = 12;
                                          var3.field1926 = field2067[var21];
                                          var3.field1927 = 12 - var3.field1926;
                                       } else {
                                          var3.field1910 = 9;
                                          var3.field1926 = field2077[var21];
                                          var3.field1927 = 9 - var3.field1926;
                                       }
                                    } else {
                                       var3.field1910 = 0;
                                    }

                                    if((var31.field2133 & var11) != 0 && !this.method2705(var7, var4, var5, var31.field2133)) {
                                       var31.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var31.x - field2083, var31.floor - field2084, var31.y - field2085, var31.hash);
                                    }

                                    if((var31.field2134 & var11) != 0 && !this.method2705(var7, var4, var5, var31.field2134)) {
                                       var31.renderable2.vmethod2870(0, field2086, field2114, field2088, field2099, var31.x - field2083, var31.floor - field2084, var31.y - field2085, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.method2730(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.renderFlag & var11) != 0) {
                                       var13.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var13.x - field2083 + var13.offsetX, var13.floor - field2084, var13.y - field2085 + var13.offsetY, var13.hash);
                                    } else if(var13.renderFlag == 256) {
                                       var14 = var13.x - field2083;
                                       var15 = var13.floor - field2084;
                                       var16 = var13.y - field2085;
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
                                          var13.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var14 + var13.offsetX, var15, var16 + var13.offsetY, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.vmethod2870(0, field2086, field2114, field2088, field2099, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.vmethod2870(0, field2086, field2114, field2088, field2099, var22.x - field2083, var22.floor - field2084, var22.y - field2085, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.vmethod2870(0, field2086, field2114, field2088, field2099, var23.x - field2083, var23.hash - field2084, var23.y - field2085, var23.flags);
                                       }

                                       if(var23.top != null) {
                                          var23.top.vmethod2870(0, field2086, field2114, field2088, field2099, var23.x - field2083, var23.hash - field2084, var23.y - field2085, var23.flags);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.vmethod2870(0, field2086, field2114, field2088, field2099, var23.x - field2083, var23.hash - field2084, var23.y - field2085, var23.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1908;
                                 if(var14 != 0) {
                                    if(var4 < field2081 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1923) {
                                          field2105.method3634(var36);
                                       }
                                    }

                                    if(var5 < field2098 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1923) {
                                          field2105.method3634(var36);
                                       }
                                    }

                                    if(var4 > field2081 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1923) {
                                          field2105.method3634(var36);
                                       }
                                    }

                                    if(var5 > field2098 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1923) {
                                          field2105.method3634(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1910 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1925; ++var21) {
                                    if(var3.objects[var21].field2200 != field2076 && (var3.field1919[var21] & var3.field1910) == var3.field1926) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method2705(var7, var4, var5, var10.field2133)) {
                                       var10.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var10.x - field2083, var10.floor - field2084, var10.y - field2085, var10.hash);
                                    }

                                    var3.field1910 = 0;
                                 }
                              }

                              if(!var3.field1924) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1925;
                                 var3.field1924 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field2200 != field2076) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1915) {
                                                var3.field1924 = true;
                                                continue label563;
                                             }

                                             if(var36.field1910 != 0) {
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

                                                if((var16 & var36.field1910) == var3.field1927) {
                                                   var3.field1924 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field2090[var21++] = var12;
                                       var24 = field2081 - var12.relativeX;
                                       var14 = var12.offsetX - field2081;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field2098 - var12.relativeY;
                                       var16 = var12.offsetY - field2098;
                                       if(var16 > var15) {
                                          var12.field2194 = var24 + var16;
                                       } else {
                                          var12.field2194 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = field2090[var24];
                                       if(var35.field2200 != field2076) {
                                          if(var35.field2194 > var11) {
                                             var11 = var35.field2194;
                                             var25 = var24;
                                          } else if(var35.field2194 == var11) {
                                             var15 = var35.x - field2083;
                                             var16 = var35.y - field2085;
                                             var17 = field2090[var25].x - field2083;
                                             var18 = field2090[var25].y - field2085;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = field2090[var25];
                                    var33.field2200 = field2076;
                                    if(!this.method2726(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod2870(var33.orientation, field2086, field2114, field2088, field2099, var33.x - field2083, var33.height - field2084, var33.y - field2085, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.field1910 != 0) {
                                             field2105.method3634(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1923) {
                                             field2105.method3634(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1924) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1924 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1923);
                     } while(var3.field1910 != 0);

                     if(var4 > field2081 || var4 <= field2093) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1923);

                  if(var4 < field2081 || var4 >= field2078 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1923);

               if(var5 > field2098 || var5 <= field2079) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1923);

            if(var5 < field2098 || var5 >= field2080 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1923);

         var3.field1923 = false;
         --field2074;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod2870(0, field2086, field2114, field2088, field2099, var32.x - field2083, var32.hash - field2084 - var32.height, var32.y - field2085, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod2870(0, field2086, field2114, field2088, field2099, var32.x - field2083, var32.hash - field2084 - var32.height, var32.y - field2085, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod2870(0, field2086, field2114, field2088, field2099, var32.x - field2083, var32.hash - field2084 - var32.height, var32.y - field2085, var32.flags);
            }
         }

         if(var3.field1928 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method2730(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1928) != 0) {
                  var29.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var29.x - field2083 + var29.offsetX, var29.floor - field2084, var29.y - field2085 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - field2083;
                  var25 = var29.floor - field2084;
                  var24 = var29.y - field2085;
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
                     var29.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2870(0, field2086, field2114, field2088, field2099, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field2134 & var3.field1928) != 0 && !this.method2705(var7, var4, var5, var27.field2134)) {
                  var27.renderable2.vmethod2870(0, field2086, field2114, field2088, field2099, var27.x - field2083, var27.floor - field2084, var27.y - field2085, var27.hash);
               }

               if((var27.field2133 & var3.field1928) != 0 && !this.method2705(var7, var4, var5, var27.field2133)) {
                  var27.renderable1.vmethod2870(0, field2086, field2114, field2088, field2099, var27.x - field2083, var27.floor - field2084, var27.y - field2085, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field2061 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1923) {
               field2105.method3634(var30);
            }
         }

         if(var4 < field2081) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1923) {
               field2105.method3634(var30);
            }
         }

         if(var5 < field2098) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1923) {
               field2105.method3634(var30);
            }
         }

         if(var4 > field2081) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1923) {
               field2105.method3634(var30);
            }
         }

         if(var5 > field2098) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1923) {
               field2105.method3634(var30);
            }
         }
      }
   }

   @ObfuscatedName("ai")
   void method2718(class137 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field2083;
      int var11;
      int var12 = var11 = (var8 << 7) - field2085;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field2064[var2][var7][var8] - field2084;
      int var18 = this.field2064[var2][var7 + 1][var8] - field2084;
      int var19 = this.field2064[var2][var7 + 1][var8 + 1] - field2084;
      int var20 = this.field2064[var2][var7][var8 + 1] - field2084;
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
                  int var22 = class136.field2029 + var10 * class136.field2028 / var12;
                  int var23 = class136.field2030 + var17 * class136.field2028 / var12;
                  int var24 = class136.field2029 + var14 * class136.field2028 / var11;
                  int var25 = class136.field2030 + var18 * class136.field2028 / var11;
                  int var26 = class136.field2029 + var13 * class136.field2028 / var16;
                  int var27 = class136.field2030 + var19 * class136.field2028 / var16;
                  int var28 = class136.field2029 + var9 * class136.field2028 / var15;
                  int var29 = class136.field2030 + var21 * class136.field2028 / var15;
                  class136.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class136.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class136.rasterClipX || var28 > class136.rasterClipX || var24 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2107 && this.method2721(field2069, field2094, var27, var29, var25, var26, var28, var24)) {
                        field2095 = var7;
                        field2096 = var8;
                     }

                     if(var1.field2048 == -1) {
                        if(var1.field2046 != 12345678) {
                           class136.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field2046, var1.field2047, var1.field2045);
                        }
                     } else if(!field2115) {
                        if(var1.field2049) {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2046, var1.field2047, var1.field2045, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2048);
                        } else {
                           class136.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field2046, var1.field2047, var1.field2045, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field2048);
                        }
                     } else {
                        var30 = class136.field2039.vmethod2887(var1.field2048);
                        class136.rasterGouraud(var27, var29, var25, var26, var28, var24, method2751(var30, var1.field2046), method2751(var30, var1.field2047), method2751(var30, var1.field2045));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class136.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class136.rasterClipX || var24 > class136.rasterClipX || var28 > class136.rasterClipX) {
                        class136.rasterClipEnable = true;
                     }

                     if(field2107 && this.method2721(field2069, field2094, var23, var25, var29, var22, var24, var28)) {
                        field2095 = var7;
                        field2096 = var8;
                     }

                     if(var1.field2048 == -1) {
                        if(var1.field2050 != 12345678) {
                           class136.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field2050, var1.field2045, var1.field2047);
                        }
                     } else if(!field2115) {
                        class136.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field2050, var1.field2045, var1.field2047, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2048);
                     } else {
                        var30 = class136.field2039.vmethod2887(var1.field2048);
                        class136.rasterGouraud(var23, var25, var29, var22, var24, var28, method2751(var30, var1.field2050), method2751(var30, var1.field2045), method2751(var30, var1.field2047));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("bd")
   boolean method2721(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("bc")
   void method2722() {
      int var1 = field2091[field2075];
      class146[] var2 = field2102[field2075];
      field2103 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class146 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field2160 == 1) {
            var5 = var4.field2174 - field2081 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2158 - field2098 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2170 - field2098 + 25;
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
                  var9 = field2083 - var4.field2161;
                  if(var9 > 32) {
                     var4.field2163 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2163 = 2;
                     var9 = -var9;
                  }

                  var4.field2167 = (var4.field2169 - field2085 << 8) / var9;
                  var4.field2173 = (var4.field2171 - field2085 << 8) / var9;
                  var4.field2172 = (var4.field2165 - field2084 << 8) / var9;
                  var4.field2157 = (var4.field2166 - field2084 << 8) / var9;
                  field2104[field2103++] = var4;
               }
            }
         } else if(var4.field2160 == 2) {
            var5 = var4.field2158 - field2098 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field2174 - field2081 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2164 - field2081 + 25;
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
                  var9 = field2085 - var4.field2169;
                  if(var9 > 32) {
                     var4.field2163 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field2163 = 4;
                     var9 = -var9;
                  }

                  var4.field2168 = (var4.field2161 - field2083 << 8) / var9;
                  var4.field2156 = (var4.field2162 - field2083 << 8) / var9;
                  var4.field2172 = (var4.field2165 - field2084 << 8) / var9;
                  var4.field2157 = (var4.field2166 - field2084 << 8) / var9;
                  field2104[field2103++] = var4;
               }
            }
         } else if(var4.field2160 == 4) {
            var5 = var4.field2165 - field2084;
            if(var5 > 128) {
               var6 = var4.field2158 - field2098 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field2170 - field2098 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field2174 - field2081 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field2164 - field2081 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label194:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label194;
                        }
                     }
                  }

                  if(var10) {
                     var4.field2163 = 5;
                     var4.field2168 = (var4.field2161 - field2083 << 8) / var5;
                     var4.field2156 = (var4.field2162 - field2083 << 8) / var5;
                     var4.field2167 = (var4.field2169 - field2085 << 8) / var5;
                     var4.field2173 = (var4.field2171 - field2085 << 8) / var5;
                     field2104[field2103++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bj")
   boolean method2723(int var1, int var2, int var3) {
      int var4 = this.field2120[var1][var2][var3];
      if(var4 == -field2076) {
         return false;
      } else if(var4 == field2076) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2727(var5 + 1, this.field2064[var1][var2][var3], var6 + 1) && this.method2727(var5 + 128 - 1, this.field2064[var1][var2 + 1][var3], var6 + 1) && this.method2727(var5 + 128 - 1, this.field2064[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2727(var5 + 1, this.field2064[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field2120[var1][var2][var3] = field2076;
            return true;
         } else {
            this.field2120[var1][var2][var3] = -field2076;
            return false;
         }
      }
   }

   @ObfuscatedName("bn")
   boolean method2726(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method2723(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2727(var7 + 1, this.field2064[var1][var2][var4] - var6, var8 + 1) && this.method2727(var7 + 128 - 1, this.field2064[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2727(var7 + 128 - 1, this.field2064[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2727(var7 + 1, this.field2064[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field2120[var1][var7][var8] == -field2076) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field2064[var1][var2][var4] - var6;
         if(!this.method2727(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2727(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2727(var7, var9, var11)) {
                  return false;
               } else if(!this.method2727(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("bh")
   boolean method2727(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field2103; ++var4) {
         class146 var5 = field2104[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field2163 == 1) {
            var6 = var5.field2161 - var1;
            if(var6 > 0) {
               var7 = var5.field2169 + (var5.field2167 * var6 >> 8);
               var8 = var5.field2171 + (var5.field2173 * var6 >> 8);
               var9 = var5.field2165 + (var5.field2172 * var6 >> 8);
               var10 = var5.field2166 + (var5.field2157 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2163 == 2) {
            var6 = var1 - var5.field2161;
            if(var6 > 0) {
               var7 = var5.field2169 + (var5.field2167 * var6 >> 8);
               var8 = var5.field2171 + (var5.field2173 * var6 >> 8);
               var9 = var5.field2165 + (var5.field2172 * var6 >> 8);
               var10 = var5.field2166 + (var5.field2157 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2163 == 3) {
            var6 = var5.field2169 - var3;
            if(var6 > 0) {
               var7 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var8 = var5.field2162 + (var5.field2156 * var6 >> 8);
               var9 = var5.field2165 + (var5.field2172 * var6 >> 8);
               var10 = var5.field2166 + (var5.field2157 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2163 == 4) {
            var6 = var3 - var5.field2169;
            if(var6 > 0) {
               var7 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var8 = var5.field2162 + (var5.field2156 * var6 >> 8);
               var9 = var5.field2165 + (var5.field2172 * var6 >> 8);
               var10 = var5.field2166 + (var5.field2157 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field2163 == 5) {
            var6 = var2 - var5.field2165;
            if(var6 > 0) {
               var7 = var5.field2161 + (var5.field2168 * var6 >> 8);
               var8 = var5.field2162 + (var5.field2156 * var6 >> 8);
               var9 = var5.field2169 + (var5.field2167 * var6 >> 8);
               var10 = var5.field2171 + (var5.field2173 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("bm")
   public static final int[] method2728(int var0, int var1, int var2) {
      int var3 = var2 * field2088 + var0 * field2099 >> 16;
      var2 = var2 * field2099 - var0 * field2088 >> 16;
      var0 = var3;
      var3 = var1 * field2114 - var2 * field2086 >> 16;
      var2 = var1 * field2086 + var2 * field2114 >> 16;
      var2 |= 1;
      int var4 = class136.field2029 + var0 * class136.field2028 / var2 + Rasterizer2D.field3754;
      int var5 = class136.field2030 + var3 * class136.field2028 / var2 + Rasterizer2D.field3755;
      return new int[]{var4, var5};
   }

   static {
      field2115 = true;
      field2074 = 0;
      field2075 = 0;
      field2090 = new GameObject[100];
      field2107 = false;
      field2092 = 0;
      field2069 = 0;
      field2094 = 0;
      field2095 = -1;
      field2096 = -1;
      field2097 = false;
      field2100 = 4;
      field2091 = new int[field2100];
      field2102 = new class146[field2100][500];
      field2103 = 0;
      field2104 = new class146[500];
      field2105 = new Deque();
      field2106 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field2082 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field2108 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field2109 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field2110 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field2067 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field2077 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field2062 = new boolean[8][32][51][51];
   }

   @ObfuscatedName("bf")
   boolean method2730(int var1, int var2, int var3, int var4) {
      if(!this.method2723(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2727(var5 + 1, this.field2064[var1][var2][var3] - var4, var6 + 1) && this.method2727(var5 + 128 - 1, this.field2064[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2727(var5 + 128 - 1, this.field2064[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2727(var5 + 1, this.field2064[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field2066 = 0;
      this.field2118 = 0;
      this.objects = new GameObject[5000];
      this.field2113 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.field2101 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.field2061 = var1;
      this.field2112 = var2;
      this.field2063 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field2120 = new int[var1][var2 + 1][var3 + 1];
      this.field2064 = var4;
      this.method2675();
   }

   @ObfuscatedName("r")
   void method2741(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1925; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1925;

                     for(int var6 = var5; var6 < var4.field1925; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1919[var6] = var4.field1919[var6 + 1];
                     }

                     var4.objects[var4.field1925] = null;
                     break;
                  }
               }

               var4.field1908 = 0;

               for(var5 = 0; var5 < var4.field1925; ++var5) {
                  var4.field1908 |= var4.field1919[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   public void method2747(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("aw")
   public DecorativeObject method2748(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("bv")
   static final int method2751(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("al")
   public GroundObject method2759(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("ah")
   public int method2770(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field2138 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1925; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("t")
   public void method2772(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1925; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method2741(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("aj")
   public static void method2784() {
      field2095 = -1;
      field2097 = false;
   }

   @ObfuscatedName("az")
   void method2791(class128 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1866.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1866[var9] - field2083;
         var11 = var1.field1848[var9] - field2084;
         var12 = var1.field1868[var9] - field2085;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1856 != null) {
            class128.field1864[var9] = var10;
            class128.field1865[var9] = var13;
            class128.field1855[var9] = var12;
         }

         class128.field1862[var9] = class136.field2029 + var10 * class136.field2028 / var12;
         class128.field1863[var9] = class136.field2030 + var13 * class136.field2028 / var12;
      }

      class136.rasterAlpha = 0;
      var8 = var1.field1853.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1853[var9];
         var11 = var1.field1854[var9];
         var12 = var1.field1852[var9];
         var13 = class128.field1862[var10];
         int var14 = class128.field1862[var11];
         int var15 = class128.field1862[var12];
         int var16 = class128.field1863[var10];
         int var17 = class128.field1863[var11];
         int var18 = class128.field1863[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class136.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class136.rasterClipX || var14 > class136.rasterClipX || var15 > class136.rasterClipX) {
               class136.rasterClipEnable = true;
            }

            if(field2107 && this.method2721(field2069, field2094, var16, var17, var18, var13, var14, var15)) {
               field2095 = var6;
               field2096 = var7;
            }

            if(var1.field1856 != null && var1.field1856[var9] != -1) {
               if(!field2115) {
                  if(var1.field1857) {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1858[var9], var1.field1851[var9], var1.field1849[var9], class128.field1864[0], class128.field1864[1], class128.field1864[3], class128.field1865[0], class128.field1865[1], class128.field1865[3], class128.field1855[0], class128.field1855[1], class128.field1855[3], var1.field1856[var9]);
                  } else {
                     class136.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1858[var9], var1.field1851[var9], var1.field1849[var9], class128.field1864[var10], class128.field1864[var11], class128.field1864[var12], class128.field1865[var10], class128.field1865[var11], class128.field1865[var12], class128.field1855[var10], class128.field1855[var11], class128.field1855[var12], var1.field1856[var9]);
                  }
               } else {
                  int var19 = class136.field2039.vmethod2887(var1.field1856[var9]);
                  class136.rasterGouraud(var16, var17, var18, var13, var14, var15, method2751(var19, var1.field1858[var9]), method2751(var19, var1.field1851[var9]), method2751(var19, var1.field1849[var9]));
               }
            } else if(var1.field1858[var9] != 12345678) {
               class136.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1858[var9], var1.field1851[var9], var1.field1849[var9]);
            }
         }
      }

   }

   @ObfuscatedName("ax")
   public void method2793(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class137 var8 = var7.field1911;
         int var10;
         if(var8 != null) {
            int var9 = var8.field2051;
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
            class128 var18 = var7.field1912;
            if(var18 != null) {
               var10 = var18.field1867;
               int var11 = var18.field1859;
               int var12 = var18.field1860;
               int var13 = var18.field1861;
               int[] var14 = this.field2113[var10];
               int[] var15 = this.field2101[var11];
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

   @ObfuscatedName("s")
   public void method2832(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   @ObfuscatedName("w")
   public void method2840(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("ac")
   void method2845(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field2061) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field2112) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field2063 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field2064[var12][var13][var14] + this.field2064[var12][var13 + 1][var14] + this.field2064[var12][var13][var14 + 1] + this.field2064[var12][var13 + 1][var14 + 1]) / 4 - (this.field2064[var2][var3][var4] + this.field2064[var2][var3 + 1][var4] + this.field2064[var2][var3][var4 + 1] + this.field2064[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method2485(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method2485(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.field1925; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2485(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("b")
   public void method2850(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }
   }

   @ObfuscatedName("aa")
   public WallObject method2862(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }
}

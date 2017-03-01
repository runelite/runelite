import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Region")
public class Region {
   @ObfuscatedName("bi")
   static boolean[][][][] field1477;
   @ObfuscatedName("n")
   int field1478;
   @ObfuscatedName("g")
   int field1479;
   @ObfuscatedName("v")
   int field1480;
   @ObfuscatedName("p")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("c")
   static int field1483 = 0;
   @ObfuscatedName("m")
   int field1484 = 0;
   @ObfuscatedName("a")
   @Export("objects")
   GameObject[] objects = new GameObject[5000];
   @ObfuscatedName("i")
   int[][][] field1486;
   @ObfuscatedName("y")
   int[][][] field1487;
   @ObfuscatedName("q")
   static int field1491 = 0;
   @ObfuscatedName("aa")
   static int field1492 = 0;
   @ObfuscatedName("br")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("bx")
   static int field1494;
   @ObfuscatedName("l")
   static int field1495;
   @ObfuscatedName("r")
   static int field1496;
   @ObfuscatedName("b")
   static int field1497;
   @ObfuscatedName("e")
   static int field1498;
   @ObfuscatedName("h")
   static int field1499;
   @ObfuscatedName("ao")
   public static int field1501 = -1;
   @ObfuscatedName("t")
   static int field1502;
   @ObfuscatedName("ab")
   static int field1503;
   @ObfuscatedName("ac")
   static int field1504;
   @ObfuscatedName("au")
   static int field1505;
   @ObfuscatedName("al")
   static int field1506;
   @ObfuscatedName("ae")
   static GameObject[] field1507 = new GameObject[100];
   @ObfuscatedName("ad")
   static boolean field1508 = false;
   @ObfuscatedName("u")
   static int field1509;
   @ObfuscatedName("d")
   static int field1510;
   @ObfuscatedName("af")
   static int field1511 = 0;
   @ObfuscatedName("av")
   static int field1512;
   @ObfuscatedName("as")
   public static int field1513 = -1;
   @ObfuscatedName("ax")
   static boolean field1514 = false;
   @ObfuscatedName("bv")
   static int field1515;
   @ObfuscatedName("z")
   static int field1516;
   @ObfuscatedName("bf")
   int[][] field1517 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   @ObfuscatedName("aj")
   static int field1518 = 4;
   @ObfuscatedName("az")
   static class94[][] field1519;
   @ObfuscatedName("w")
   static int field1520;
   @ObfuscatedName("ap")
   static class94[] field1521;
   @ObfuscatedName("aw")
   static Deque field1522;
   @ObfuscatedName("ar")
   static int[] field1523;
   @ObfuscatedName("at")
   static final int[] field1525;
   @ObfuscatedName("ah")
   static final int[] field1526;
   @ObfuscatedName("am")
   static final int[] field1527;
   @ObfuscatedName("ak")
   static final int[] field1528;
   @ObfuscatedName("by")
   static final int[] field1529;
   @ObfuscatedName("j")
   int field1530 = 0;
   @ObfuscatedName("bj")
   int[][] field1531 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
   @ObfuscatedName("x")
   public static boolean field1532 = true;
   @ObfuscatedName("aq")
   static int field1533 = 0;
   @ObfuscatedName("bn")
   static int field1534;
   @ObfuscatedName("ay")
   static final int[] field1535;
   @ObfuscatedName("bl")
   static int field1536;
   @ObfuscatedName("be")
   static int field1537;
   @ObfuscatedName("ai")
   static final int[] field1538;
   @ObfuscatedName("bu")
   static int field1539;

   @ObfuscatedName("x")
   public void method1790() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field1478; ++var1) {
         for(var2 = 0; var2 < this.field1479; ++var2) {
            for(int var3 = 0; var3 < this.field1480; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field1518; ++var1) {
         for(var2 = 0; var2 < field1523[var1]; ++var2) {
            field1519[var1][var2] = null;
         }

         field1523[var1] = 0;
      }

      for(var1 = 0; var1 < this.field1484; ++var1) {
         this.objects[var1] = null;
      }

      this.field1484 = 0;

      for(var1 = 0; var1 < field1507.length; ++var1) {
         field1507[var1] = null;
      }

   }

   @ObfuscatedName("n")
   public void method1791(int var1) {
      this.field1530 = var1;

      for(int var2 = 0; var2 < this.field1479; ++var2) {
         for(int var3 = 0; var3 < this.field1480; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("v")
   public static void method1793(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class94 var8 = new class94();
      var8.field1586 = var2 / 128;
      var8.field1583 = var3 / 128;
      var8.field1584 = var4 / 128;
      var8.field1585 = var5 / 128;
      var8.field1596 = var1;
      var8.field1582 = var2;
      var8.field1600 = var3;
      var8.field1589 = var4;
      var8.field1599 = var5;
      var8.field1591 = var6;
      var8.field1592 = var7;
      field1519[var0][field1523[var0]++] = var8;
   }

   @ObfuscatedName("y")
   public void method1794(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1361 = var4;
      }
   }

   @ObfuscatedName("p")
   public void method1795(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class85 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class85(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1342 = var21;
      } else if(var4 != 1) {
         class77 var23 = new class77(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1343 = var23;
      } else {
         var21 = new class85(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1342 = var21;
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

   @ObfuscatedName("e")
   public void method1797(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("f")
   public void method1799(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
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

   @ObfuscatedName("ah")
   boolean method1800(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("c")
   public boolean method1802(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method1803(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("b")
   boolean method1803(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field1479 || var15 >= this.field1480) {
               return false;
            }

            Tile var16 = this.tiles[var1][var14][var15];
            if(var16 != null && var16.field1351 >= 5) {
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
            var22.objects[var22.field1351] = var20;
            var22.field1350[var22.field1351] = var17;
            var22.field1364 |= var17;
            ++var22.field1351;
         }
      }

      if(var11) {
         this.objects[this.field1484++] = var20;
      }

      return true;
   }

   @ObfuscatedName("w")
   public void method1804() {
      for(int var1 = 0; var1 < this.field1484; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method1837(var2);
         this.objects[var1] = null;
      }

      this.field1484 = 0;
   }

   @ObfuscatedName("r")
   public void method1806(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.offsetX = var6.offsetX * var4 / 16;
            var6.offsetY = var6.offsetY * var4 / 16;
         }
      }
   }

   @ObfuscatedName("u")
   public void method1807(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   static {
      field1523 = new int[field1518];
      field1519 = new class94[field1518][500];
      field1512 = 0;
      field1521 = new class94[500];
      field1522 = new Deque();
      field1535 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field1538 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field1525 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field1526 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field1527 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field1528 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field1529 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field1477 = new boolean[8][32][51][51];
   }

   @ObfuscatedName("s")
   public void method1808(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1351; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method1649();
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

   @ObfuscatedName("ao")
   void method1809(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field1478) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field1479) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field1480 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field1487[var12][var13][var14] + this.field1487[var12][var13 + 1][var14] + this.field1487[var12][var13][var14 + 1] + this.field1487[var12][var13 + 1][var14 + 1]) / 4 - (this.field1487[var2][var3][var4] + this.field1487[var2][var3 + 1][var4] + this.field1487[var2][var3][var4 + 1] + this.field1487[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var23;
                              if(var17.renderable1 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable1;
                                 ModelData.method1616(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var23 = (ModelData)var17.renderable2;
                                 ModelData.method1616(var1, var23, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var18 = 0; var18 < var15.field1351; ++var18) {
                              GameObject var19 = var15.objects[var18];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method1616(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("z")
   public void method1810(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("t")
   public WallObject method1811(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("ar")
   public void method1812() {
      field1514 = true;
   }

   @ObfuscatedName("au")
   public GroundObject method1814(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("al")
   public int method1815(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method1820(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1478; ++var4) {
         for(int var5 = 0; var5 < this.field1479; ++var5) {
            for(int var6 = 0; var6 < this.field1480; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method1809(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method1809(var10, var4, var5, var6, 1, 1);
                        ModelData.method1616(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.method1624(var10.field1267, var10.field1268, var1, var2, var3);
                     }

                     var8.renderable1 = var9.method1624(var9.field1267, var9.field1268, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1351; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method1809(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.method1624(var11.field1267, var11.field1268, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method1821(var10, var4, var5, var6);
                     var13.renderable = var10.method1624(var10.field1267, var10.field1268, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("as")
   void method1821(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field1479) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1616(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field1479) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1616(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field1479 && var4 < this.field1480) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1616(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field1479 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1616(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("ax")
   public void method1823(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class85 var8 = var7.field1342;
         int var10;
         if(var8 != null) {
            int var18 = var8.field1468;
            if(var18 != 0) {
               for(var10 = 0; var10 < 4; ++var10) {
                  var1[var2] = var18;
                  var1[var2 + 1] = var18;
                  var1[var2 + 2] = var18;
                  var1[var2 + 3] = var18;
                  var2 += var3;
               }

            }
         } else {
            class77 var9 = var7.field1343;
            if(var9 != null) {
               var10 = var9.field1295;
               int var11 = var9.field1284;
               int var12 = var9.field1293;
               int var13 = var9.field1294;
               int[] var14 = this.field1517[var10];
               int[] var15 = this.field1531[var11];
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

   @ObfuscatedName("an")
   public static void method1824(int[] var0, int var1, int var2, int var3, int var4) {
      field1536 = 0;
      field1537 = 0;
      field1515 = var3;
      field1539 = var4;
      field1534 = var3 / 2;
      field1494 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field1503 = class84.field1460[var6];
            field1504 = class84.field1446[var6];
            field1505 = class84.field1460[var7];
            field1506 = class84.field1446[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method1825(var12, var0[var8] + var15, var13)) {
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

                  label103:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label103;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label103;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label103;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label103;
                        }
                     }
                  }

                  field1477[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   static boolean method1825(int var0, int var1, int var2) {
      int var3 = var2 * field1505 + var0 * field1506 >> 16;
      int var4 = var2 * field1506 - var0 * field1505 >> 16;
      int var5 = var1 * field1503 + var4 * field1504 >> 16;
      int var6 = var1 * field1504 - var4 * field1503 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field1534 + var3 * class84.field1453 / var5;
         int var8 = field1494 + var6 * class84.field1453 / var5;
         return var7 >= field1536 && var7 <= field1515 && var8 >= field1537 && var8 <= field1539;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   public void method1826(int var1, int var2, int var3, boolean var4) {
      if(!method1959() || var4) {
         field1508 = true;
         field1514 = var4;
         field1533 = var1;
         field1492 = var2;
         field1511 = var3;
         field1513 = -1;
         field1501 = -1;
      }
   }

   @ObfuscatedName("o")
   public boolean method1828(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + 64 * var5;
         int var12 = var3 * 128 + 64 * var6;
         return this.method1803(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("ap")
   public void method1830(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field1479 * 128) {
         var1 = this.field1479 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field1480 * 128) {
         var3 = this.field1480 * 128 - 1;
      }

      ++field1497;
      field1503 = class84.field1460[var4];
      field1504 = class84.field1446[var4];
      field1505 = class84.field1460[var5];
      field1506 = class84.field1446[var5];
      renderArea = field1477[(var4 - 128) / 32][var5 / 64];
      field1510 = var1;
      field1516 = var2;
      field1502 = var3;
      field1498 = var1 / 128;
      field1499 = var3 / 128;
      field1483 = var6;
      field1520 = field1498 - 25;
      if(field1520 < 0) {
         field1520 = 0;
      }

      field1496 = field1499 - 25;
      if(field1496 < 0) {
         field1496 = 0;
      }

      field1495 = field1498 + 25;
      if(field1495 > this.field1479) {
         field1495 = this.field1479;
      }

      field1509 = field1499 + 25;
      if(field1509 > this.field1480) {
         field1509 = this.field1480;
      }

      this.method1836();
      field1491 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field1530; var7 < this.field1478; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field1520; var9 < field1495; ++var9) {
            for(var10 = field1496; var10 < field1509; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1361 > var6 || !renderArea[var9 - field1498 + 25][var10 - field1499 + 25] && this.field1487[var7][var9][var10] - var2 < 2000) {
                     var11.field1353 = false;
                     var11.field1354 = false;
                     var11.field1357 = 0;
                  } else {
                     var11.field1353 = true;
                     var11.field1354 = true;
                     if(var11.field1351 > 0) {
                        var11.field1355 = true;
                     } else {
                        var11.field1355 = false;
                     }

                     ++field1491;
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
      for(var7 = this.field1530; var7 < this.field1478; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1498 + var9;
            var16 = field1498 - var9;
            if(var10 >= field1520 || var16 < field1495) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field1499 + var12;
                  var14 = field1499 - var12;
                  if(var10 >= field1520) {
                     if(var13 >= field1496) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, true);
                        }
                     }

                     if(var14 < field1509) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, true);
                        }
                     }
                  }

                  if(var16 < field1495) {
                     if(var13 >= field1496) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, true);
                        }
                     }

                     if(var14 < field1509) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, true);
                        }
                     }
                  }

                  if(field1491 == 0) {
                     field1508 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field1530; var7 < this.field1478; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1498 + var9;
            var16 = field1498 - var9;
            if(var10 >= field1520 || var16 < field1495) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field1499 + var12;
                  var14 = field1499 - var12;
                  if(var10 >= field1520) {
                     if(var13 >= field1496) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, false);
                        }
                     }

                     if(var14 < field1509) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, false);
                        }
                     }
                  }

                  if(var16 < field1495) {
                     if(var13 >= field1496) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, false);
                        }
                     }

                     if(var14 < field1509) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1353) {
                           this.method1833(var15, false);
                        }
                     }
                  }

                  if(field1491 == 0) {
                     field1508 = false;
                     return;
                  }
               }
            }
         }
      }

      field1508 = false;
   }

   @ObfuscatedName("aq")
   public int method1831(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("ay")
   void method1832(class85 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field1510;
      int var11;
      int var12 = var11 = (var8 << 7) - field1502;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field1487[var2][var7][var8] - field1516;
      int var18 = this.field1487[var2][var7 + 1][var8] - field1516;
      int var19 = this.field1487[var2][var7 + 1][var8 + 1] - field1516;
      int var20 = this.field1487[var2][var7][var8 + 1] - field1516;
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
                  int var22 = class84.field1447 + var10 * class84.field1453 / var12;
                  int var23 = class84.field1448 + var17 * class84.field1453 / var12;
                  int var24 = class84.field1447 + var14 * class84.field1453 / var11;
                  int var25 = class84.field1448 + var18 * class84.field1453 / var11;
                  int var26 = class84.field1447 + var13 * class84.field1453 / var16;
                  int var27 = class84.field1448 + var19 * class84.field1453 / var16;
                  int var28 = class84.field1447 + var9 * class84.field1453 / var15;
                  int var29 = class84.field1448 + var21 * class84.field1453 / var15;
                  class84.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class84.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class84.rasterClipX || var28 > class84.rasterClipX || var24 > class84.rasterClipX) {
                        class84.rasterClipEnable = true;
                     }

                     if(field1508 && this.method1800(field1492, field1511, var27, var29, var25, var26, var28, var24)) {
                        field1513 = var7;
                        field1501 = var8;
                     }

                     if(var1.field1464 == -1) {
                        if(var1.field1469 != 12345678) {
                           class84.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field1469, var1.field1465, var1.field1463);
                        }
                     } else if(!field1532) {
                        if(var1.field1462) {
                           class84.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1469, var1.field1465, var1.field1463, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1464);
                        } else {
                           class84.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1469, var1.field1465, var1.field1463, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field1464);
                        }
                     } else {
                        var30 = class84.field1457.vmethod1999(var1.field1464);
                        class84.rasterGouraud(var27, var29, var25, var26, var28, var24, method1834(var30, var1.field1469), method1834(var30, var1.field1465), method1834(var30, var1.field1463));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class84.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class84.rasterClipX || var24 > class84.rasterClipX || var28 > class84.rasterClipX) {
                        class84.rasterClipEnable = true;
                     }

                     if(field1508 && this.method1800(field1492, field1511, var23, var25, var29, var22, var24, var28)) {
                        field1513 = var7;
                        field1501 = var8;
                     }

                     if(var1.field1464 == -1) {
                        if(var1.field1467 != 12345678) {
                           class84.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field1467, var1.field1463, var1.field1465);
                        }
                     } else if(!field1532) {
                        class84.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field1467, var1.field1463, var1.field1465, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1464);
                     } else {
                        var30 = class84.field1457.vmethod1999(var1.field1464);
                        class84.rasterGouraud(var23, var25, var29, var22, var24, var28, method1834(var30, var1.field1467), method1834(var30, var1.field1463), method1834(var30, var1.field1465));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("aw")
   void method1833(Tile var1, boolean var2) {
      field1522.method2511(var1);

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
                                    var3 = (Tile)field1522.method2488();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1354);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1341;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1353) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1354) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field1498 && var4 > field1520) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1354 && (var9.field1353 || (var3.field1364 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field1498 && var4 < field1495 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1354 && (var9.field1353 || (var3.field1364 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field1499 && var5 > field1496) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1354 && (var9.field1353 || (var3.field1364 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field1499 && var5 < field1509 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1354 && (var9.field1353 || (var3.field1364 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1353 = false;
                                 if(var3.field1360 != null) {
                                    var9 = var3.field1360;
                                    if(var9.field1342 != null) {
                                       if(!this.method1847(0, var4, var5)) {
                                          this.method1832(var9.field1342, 0, field1503, field1504, field1505, field1506, var4, var5);
                                       }
                                    } else if(var9.field1343 != null && !this.method1847(0, var4, var5)) {
                                       this.method1875(var9.field1343, field1503, field1504, field1505, field1506, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var10.x - field1510, var10.floor - field1516, var10.y - field1502, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1351; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod1972(var12.orientation, field1503, field1504, field1505, field1506, var12.x - field1510, var12.height - field1516, var12.y - field1502, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1342 != null) {
                                    if(!this.method1847(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1342.field1469 != 12345678 || field1508 && var6 <= field1533) {
                                          this.method1832(var3.field1342, var7, field1503, field1504, field1505, field1506, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1343 != null && !this.method1847(var7, var4, var5)) {
                                    var20 = true;
                                    this.method1875(var3.field1343, field1503, field1504, field1505, field1506, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(field1498 == var4) {
                                       ++var21;
                                    } else if(field1498 < var4) {
                                       var21 += 2;
                                    }

                                    if(field1499 == var5) {
                                       var21 += 3;
                                    } else if(field1499 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field1535[var21];
                                    var3.field1356 = field1525[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field1551 & field1538[var21]) != 0) {
                                       if(var31.field1551 == 16) {
                                          var3.field1357 = 3;
                                          var3.field1352 = field1526[var21];
                                          var3.field1345 = 3 - var3.field1352;
                                       } else if(var31.field1551 == 32) {
                                          var3.field1357 = 6;
                                          var3.field1352 = field1527[var21];
                                          var3.field1345 = 6 - var3.field1352;
                                       } else if(var31.field1551 == 64) {
                                          var3.field1357 = 12;
                                          var3.field1352 = field1528[var21];
                                          var3.field1345 = 12 - var3.field1352;
                                       } else {
                                          var3.field1357 = 9;
                                          var3.field1352 = field1529[var21];
                                          var3.field1345 = 9 - var3.field1352;
                                       }
                                    } else {
                                       var3.field1357 = 0;
                                    }

                                    if((var31.field1551 & var11) != 0 && !this.method1838(var7, var4, var5, var31.field1551)) {
                                       var31.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var31.x - field1510, var31.floor - field1516, var31.y - field1502, var31.hash);
                                    }

                                    if((var31.field1555 & var11) != 0 && !this.method1838(var7, var4, var5, var31.field1555)) {
                                       var31.renderable2.vmethod1972(0, field1503, field1504, field1505, field1506, var31.x - field1510, var31.floor - field1516, var31.y - field1502, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.method1839(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.renderFlag & var11) != 0) {
                                       var13.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var13.x - field1510 + var13.offsetX, var13.floor - field1516, var13.y - field1502 + var13.offsetY, var13.hash);
                                    } else if(var13.renderFlag == 256) {
                                       var14 = var13.x - field1510;
                                       var15 = var13.floor - field1516;
                                       var16 = var13.y - field1502;
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
                                          var13.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var14 + var13.offsetX, var15, var16 + var13.offsetY, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.vmethod1972(0, field1503, field1504, field1505, field1506, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.vmethod1972(0, field1503, field1504, field1505, field1506, var22.x - field1510, var22.floor - field1516, var22.y - field1502, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.vmethod1972(0, field1503, field1504, field1505, field1506, var23.x - field1510, var23.hash - field1516, var23.y - field1502, var23.flags);
                                       }

                                       if(var23.top != null) {
                                          var23.top.vmethod1972(0, field1503, field1504, field1505, field1506, var23.x - field1510, var23.hash - field1516, var23.y - field1502, var23.flags);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.vmethod1972(0, field1503, field1504, field1505, field1506, var23.x - field1510, var23.hash - field1516, var23.y - field1502, var23.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1364;
                                 if(var14 != 0) {
                                    if(var4 < field1498 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1354) {
                                          field1522.method2511(var36);
                                       }
                                    }

                                    if(var5 < field1499 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1354) {
                                          field1522.method2511(var36);
                                       }
                                    }

                                    if(var4 > field1498 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1354) {
                                          field1522.method2511(var36);
                                       }
                                    }

                                    if(var5 > field1499 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1354) {
                                          field1522.method2511(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1357 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1351; ++var21) {
                                    if(var3.objects[var21].field1628 != field1497 && (var3.field1350[var21] & var3.field1357) == var3.field1352) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method1838(var7, var4, var5, var10.field1551)) {
                                       var10.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var10.x - field1510, var10.floor - field1516, var10.y - field1502, var10.hash);
                                    }

                                    var3.field1357 = 0;
                                 }
                              }

                              if(!var3.field1355) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1351;
                                 var3.field1355 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field1628 != field1497) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1353) {
                                                var3.field1355 = true;
                                                continue label563;
                                             }

                                             if(var36.field1357 != 0) {
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

                                                if((var16 & var36.field1357) == var3.field1345) {
                                                   var3.field1355 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field1507[var21++] = var12;
                                       var24 = field1498 - var12.relativeX;
                                       var14 = var12.offsetX - field1498;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field1499 - var12.relativeY;
                                       var16 = var12.offsetY - field1499;
                                       if(var16 > var15) {
                                          var12.field1623 = var24 + var16;
                                       } else {
                                          var12.field1623 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = field1507[var24];
                                       if(var35.field1628 != field1497) {
                                          if(var35.field1623 > var11) {
                                             var11 = var35.field1623;
                                             var25 = var24;
                                          } else if(var35.field1623 == var11) {
                                             var15 = var35.x - field1510;
                                             var16 = var35.y - field1502;
                                             var17 = field1507[var25].x - field1510;
                                             var18 = field1507[var25].y - field1502;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = field1507[var25];
                                    var33.field1628 = field1497;
                                    if(!this.method1840(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod1972(var33.orientation, field1503, field1504, field1505, field1506, var33.x - field1510, var33.height - field1516, var33.y - field1502, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.field1357 != 0) {
                                             field1522.method2511(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1354) {
                                             field1522.method2511(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1355) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1355 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1354);
                     } while(var3.field1357 != 0);

                     if(var4 > field1498 || var4 <= field1520) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1354);

                  if(var4 < field1498 || var4 >= field1495 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1354);

               if(var5 > field1499 || var5 <= field1496) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1354);

            if(var5 < field1499 || var5 >= field1509 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1354);

         var3.field1354 = false;
         --field1491;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod1972(0, field1503, field1504, field1505, field1506, var32.x - field1510, var32.hash - field1516 - var32.height, var32.y - field1502, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod1972(0, field1503, field1504, field1505, field1506, var32.x - field1510, var32.hash - field1516 - var32.height, var32.y - field1502, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod1972(0, field1503, field1504, field1505, field1506, var32.x - field1510, var32.hash - field1516 - var32.height, var32.y - field1502, var32.flags);
            }
         }

         if(var3.field1356 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method1839(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.renderFlag & var3.field1356) != 0) {
                  var29.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var29.x - field1510 + var29.offsetX, var29.floor - field1516, var29.y - field1502 + var29.offsetY, var29.hash);
               } else if(var29.renderFlag == 256) {
                  var11 = var29.x - field1510;
                  var25 = var29.floor - field1516;
                  var24 = var29.y - field1502;
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
                     var29.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod1972(0, field1503, field1504, field1505, field1506, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field1555 & var3.field1356) != 0 && !this.method1838(var7, var4, var5, var27.field1555)) {
                  var27.renderable2.vmethod1972(0, field1503, field1504, field1505, field1506, var27.x - field1510, var27.floor - field1516, var27.y - field1502, var27.hash);
               }

               if((var27.field1551 & var3.field1356) != 0 && !this.method1838(var7, var4, var5, var27.field1551)) {
                  var27.renderable1.vmethod1972(0, field1503, field1504, field1505, field1506, var27.x - field1510, var27.floor - field1516, var27.y - field1502, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field1478 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1354) {
               field1522.method2511(var30);
            }
         }

         if(var4 < field1498) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1354) {
               field1522.method2511(var30);
            }
         }

         if(var5 < field1499) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1354) {
               field1522.method2511(var30);
            }
         }

         if(var4 > field1498) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1354) {
               field1522.method2511(var30);
            }
         }

         if(var5 > field1499) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1354) {
               field1522.method2511(var30);
            }
         }
      }
   }

   @ObfuscatedName("at")
   static final int method1834(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("am")
   void method1836() {
      int var1 = field1523[field1483];
      class94[] var2 = field1519[field1483];
      field1512 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class94 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field1596 == 1) {
            var5 = var4.field1586 - field1498 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1584 - field1499 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1585 - field1499 + 25;
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
                  var9 = field1510 - var4.field1582;
                  if(var9 > 32) {
                     var4.field1593 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1593 = 2;
                     var9 = -var9;
                  }

                  var4.field1587 = (var4.field1589 - field1502 << 8) / var9;
                  var4.field1597 = (var4.field1599 - field1502 << 8) / var9;
                  var4.field1598 = (var4.field1591 - field1516 << 8) / var9;
                  var4.field1588 = (var4.field1592 - field1516 << 8) / var9;
                  field1521[field1512++] = var4;
               }
            }
         } else if(var4.field1596 == 2) {
            var5 = var4.field1584 - field1499 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1586 - field1498 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1583 - field1498 + 25;
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
                  var9 = field1502 - var4.field1589;
                  if(var9 > 32) {
                     var4.field1593 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1593 = 4;
                     var9 = -var9;
                  }

                  var4.field1594 = (var4.field1582 - field1510 << 8) / var9;
                  var4.field1595 = (var4.field1600 - field1510 << 8) / var9;
                  var4.field1598 = (var4.field1591 - field1516 << 8) / var9;
                  var4.field1588 = (var4.field1592 - field1516 << 8) / var9;
                  field1521[field1512++] = var4;
               }
            }
         } else if(var4.field1596 == 4) {
            var5 = var4.field1591 - field1516;
            if(var5 > 128) {
               var6 = var4.field1584 - field1499 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1585 - field1499 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field1586 - field1498 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field1583 - field1498 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label190:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(renderArea[var11][var12]) {
                           var10 = true;
                           break label190;
                        }
                     }
                  }

                  if(var10) {
                     var4.field1593 = 5;
                     var4.field1594 = (var4.field1582 - field1510 << 8) / var5;
                     var4.field1595 = (var4.field1600 - field1510 << 8) / var5;
                     var4.field1587 = (var4.field1589 - field1502 << 8) / var5;
                     var4.field1597 = (var4.field1599 - field1502 << 8) / var5;
                     field1521[field1512++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   void method1837(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1351; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1351;

                     for(int var6 = var5; var6 < var4.field1351; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1350[var6] = var4.field1350[var6 + 1];
                     }

                     var4.objects[var4.field1351] = null;
                     break;
                  }
               }

               var4.field1364 = 0;

               for(var5 = 0; var5 < var4.field1351; ++var5) {
                  var4.field1364 |= var4.field1350[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("by")
   boolean method1838(int var1, int var2, int var3, int var4) {
      if(!this.method1847(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field1487[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field1510) {
                  if(!this.method1963(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1963(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1963(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1963(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field1502) {
                  if(!this.method1963(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1963(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1963(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method1963(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field1510) {
                  if(!this.method1963(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1963(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1963(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method1963(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field1502) {
                  if(!this.method1963(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1963(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1963(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method1963(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1963(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method1963(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method1963(var5, var9, var6 + 128):(var4 == 32?this.method1963(var5 + 128, var9, var6 + 128):(var4 == 64?this.method1963(var5 + 128, var9, var6):(var4 == 128?this.method1963(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("bf")
   boolean method1839(int var1, int var2, int var3, int var4) {
      if(!this.method1847(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method1963(var5 + 1, this.field1487[var1][var2][var3] - var4, var6 + 1) && this.method1963(var5 + 128 - 1, this.field1487[var1][var2 + 1][var3] - var4, var6 + 1) && this.method1963(var5 + 128 - 1, this.field1487[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method1963(var5 + 1, this.field1487[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bj")
   boolean method1840(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method1847(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method1963(var7 + 1, this.field1487[var1][var2][var4] - var6, var8 + 1) && this.method1963(var7 + 128 - 1, this.field1487[var1][var2 + 1][var4] - var6, var8 + 1) && this.method1963(var7 + 128 - 1, this.field1487[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method1963(var7 + 1, this.field1487[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field1486[var1][var7][var8] == -field1497) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field1487[var1][var2][var4] - var6;
         if(!this.method1963(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method1963(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method1963(var7, var9, var11)) {
                  return false;
               } else if(!this.method1963(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("ak")
   boolean method1847(int var1, int var2, int var3) {
      int var4 = this.field1486[var1][var2][var3];
      if(var4 == -field1497) {
         return false;
      } else if(var4 == field1497) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method1963(var5 + 1, this.field1487[var1][var2][var3], var6 + 1) && this.method1963(var5 + 128 - 1, this.field1487[var1][var2 + 1][var3], var6 + 1) && this.method1963(var5 + 128 - 1, this.field1487[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method1963(var5 + 1, this.field1487[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field1486[var1][var2][var3] = field1497;
            return true;
         } else {
            this.field1486[var1][var2][var3] = -field1497;
            return false;
         }
      }
   }

   @ObfuscatedName("ai")
   void method1875(class77 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1287.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1287[var9] - field1510;
         var11 = var1.field1281[var9] - field1516;
         var12 = var1.field1282[var9] - field1502;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1283 != null) {
            class77.field1297[var9] = var10;
            class77.field1298[var9] = var13;
            class77.field1299[var9] = var12;
         }

         class77.field1286[var9] = class84.field1447 + var10 * class84.field1453 / var12;
         class77.field1292[var9] = class84.field1448 + var13 * class84.field1453 / var12;
      }

      class84.rasterAlpha = 0;
      var8 = var1.field1280.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1280[var9];
         var11 = var1.field1289[var9];
         var12 = var1.field1288[var9];
         var13 = class77.field1286[var10];
         int var14 = class77.field1286[var11];
         int var15 = class77.field1286[var12];
         int var16 = class77.field1292[var10];
         int var17 = class77.field1292[var11];
         int var18 = class77.field1292[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class84.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class84.rasterClipX || var14 > class84.rasterClipX || var15 > class84.rasterClipX) {
               class84.rasterClipEnable = true;
            }

            if(field1508 && this.method1800(field1492, field1511, var16, var17, var18, var13, var14, var15)) {
               field1513 = var6;
               field1501 = var7;
            }

            if(var1.field1283 != null && var1.field1283[var9] != -1) {
               if(!field1532) {
                  if(var1.field1290) {
                     class84.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1296[var9], var1.field1291[var9], var1.field1285[var9], class77.field1297[0], class77.field1297[1], class77.field1297[3], class77.field1298[0], class77.field1298[1], class77.field1298[3], class77.field1299[0], class77.field1299[1], class77.field1299[3], var1.field1283[var9]);
                  } else {
                     class84.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1296[var9], var1.field1291[var9], var1.field1285[var9], class77.field1297[var10], class77.field1297[var11], class77.field1297[var12], class77.field1298[var10], class77.field1298[var11], class77.field1298[var12], class77.field1299[var10], class77.field1299[var11], class77.field1299[var12], var1.field1283[var9]);
                  }
               } else {
                  int var19 = class84.field1457.vmethod1999(var1.field1283[var9]);
                  class84.rasterGouraud(var16, var17, var18, var13, var14, var15, method1834(var19, var1.field1296[var9]), method1834(var19, var1.field1291[var9]), method1834(var19, var1.field1285[var9]));
               }
            } else if(var1.field1296[var9] != 12345678) {
               class84.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1296[var9], var1.field1291[var9], var1.field1285[var9]);
            }
         }
      }

   }

   @ObfuscatedName("q")
   public boolean method1878(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method1803(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field1478 = var1;
      this.field1479 = var2;
      this.field1480 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field1486 = new int[var1][var2 + 1][var3 + 1];
      this.field1487 = var4;
      this.method1790();
   }

   @ObfuscatedName("k")
   public void method1899(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field1562 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field1551 = var7;
         var11.field1555 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   @ObfuscatedName("h")
   public void method1912(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1351; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method1837(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("g")
   public void method1917(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1351; ++var6) {
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

      this.tiles[0][var1][var2].field1360 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("aa")
   public int method1924(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field1562 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.renderInfoBitPacked & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.renderInfoBitPacked & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1351; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ad")
   public int method1925(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1351; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("av")
   public static void method1929() {
      field1513 = -1;
      field1514 = false;
   }

   @ObfuscatedName("ac")
   public GameObject method1944(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1351; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("d")
   public void method1956(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("az")
   public static boolean method1959() {
      return field1514 && field1513 != -1;
   }

   @ObfuscatedName("bi")
   boolean method1963(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1512; ++var4) {
         class94 var5 = field1521[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field1593 == 1) {
            var6 = var5.field1582 - var1;
            if(var6 > 0) {
               var7 = var5.field1589 + (var5.field1587 * var6 >> 8);
               var8 = var5.field1599 + (var5.field1597 * var6 >> 8);
               var9 = var5.field1591 + (var5.field1598 * var6 >> 8);
               var10 = var5.field1592 + (var5.field1588 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1593 == 2) {
            var6 = var1 - var5.field1582;
            if(var6 > 0) {
               var7 = var5.field1589 + (var5.field1587 * var6 >> 8);
               var8 = var5.field1599 + (var5.field1597 * var6 >> 8);
               var9 = var5.field1591 + (var5.field1598 * var6 >> 8);
               var10 = var5.field1592 + (var5.field1588 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1593 == 3) {
            var6 = var5.field1589 - var3;
            if(var6 > 0) {
               var7 = var5.field1582 + (var5.field1594 * var6 >> 8);
               var8 = var5.field1600 + (var5.field1595 * var6 >> 8);
               var9 = var5.field1591 + (var5.field1598 * var6 >> 8);
               var10 = var5.field1592 + (var5.field1588 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1593 == 4) {
            var6 = var3 - var5.field1589;
            if(var6 > 0) {
               var7 = var5.field1582 + (var5.field1594 * var6 >> 8);
               var8 = var5.field1600 + (var5.field1595 * var6 >> 8);
               var9 = var5.field1591 + (var5.field1598 * var6 >> 8);
               var10 = var5.field1592 + (var5.field1588 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1593 == 5) {
            var6 = var2 - var5.field1591;
            if(var6 > 0) {
               var7 = var5.field1582 + (var5.field1594 * var6 >> 8);
               var8 = var5.field1600 + (var5.field1595 * var6 >> 8);
               var9 = var5.field1589 + (var5.field1587 * var6 >> 8);
               var10 = var5.field1599 + (var5.field1597 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("ae")
   public int method1966(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("ab")
   public DecorativeObject method1967(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }
}

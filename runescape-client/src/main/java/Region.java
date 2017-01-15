import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Region")
public class Region {
   @ObfuscatedName("w")
   static int field1468;
   @ObfuscatedName("x")
   int field1469;
   @ObfuscatedName("av")
   public static int field1470 = -1;
   @ObfuscatedName("a")
   int field1471;
   @ObfuscatedName("f")
   int[][][] field1472;
   @ObfuscatedName("c")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("l")
   int field1474 = 0;
   @ObfuscatedName("b")
   static int field1475;
   @ObfuscatedName("g")
   @Export("objects")
   GameObject[] objects = new GameObject[5000];
   @ObfuscatedName("z")
   int[][][] field1477;
   @ObfuscatedName("d")
   int field1478 = 0;
   @ObfuscatedName("ap")
   static final int[] field1480;
   @ObfuscatedName("v")
   static int field1482 = 0;
   @ObfuscatedName("j")
   static int field1483 = 0;
   @ObfuscatedName("p")
   static int field1484;
   @ObfuscatedName("k")
   static int field1485;
   @ObfuscatedName("al")
   static int field1486;
   @ObfuscatedName("y")
   static int field1487;
   @ObfuscatedName("h")
   static int field1488;
   @ObfuscatedName("s")
   static int field1489;
   @ObfuscatedName("ai")
   static int field1490 = 0;
   @ObfuscatedName("n")
   static int field1491;
   @ObfuscatedName("o")
   static int field1492;
   @ObfuscatedName("as")
   static final int[] field1493;
   @ObfuscatedName("aj")
   static int field1494;
   @ObfuscatedName("ag")
   static int field1495;
   @ObfuscatedName("ak")
   static int[] field1496;
   @ObfuscatedName("an")
   static int field1497;
   @ObfuscatedName("af")
   static GameObject[] field1498 = new GameObject[100];
   @ObfuscatedName("aa")
   static boolean field1499 = false;
   @ObfuscatedName("ah")
   static int field1502 = 0;
   @ObfuscatedName("i")
   int field1503;
   @ObfuscatedName("at")
   public static int field1504 = -1;
   @ObfuscatedName("ax")
   static int field1505 = 0;
   @ObfuscatedName("ar")
   static final int[] field1506;
   @ObfuscatedName("aw")
   static int field1507 = 4;
   @ObfuscatedName("ac")
   static int field1508;
   @ObfuscatedName("r")
   static int field1509;
   @ObfuscatedName("bm")
   static int field1510;
   @ObfuscatedName("am")
   static class94[] field1511;
   @ObfuscatedName("ay")
   static Deque field1512;
   @ObfuscatedName("by")
   static int field1513;
   @ObfuscatedName("ab")
   static final int[] field1514;
   @ObfuscatedName("bb")
   static int field1516;
   @ObfuscatedName("ae")
   static final int[] field1517;
   @ObfuscatedName("ao")
   static final int[] field1518;
   @ObfuscatedName("au")
   static final int[] field1519;
   @ObfuscatedName("bw")
   int[][] field1520 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   @ObfuscatedName("bv")
   int[][] field1521 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
   @ObfuscatedName("u")
   public static boolean field1522 = true;
   @ObfuscatedName("be")
   @Export("renderArea")
   static boolean[][] renderArea;
   @ObfuscatedName("bz")
   static boolean[][][][] field1524;
   @ObfuscatedName("bt")
   static int field1526;
   @ObfuscatedName("bu")
   static int field1527;
   @ObfuscatedName("bn")
   static int field1528;
   @ObfuscatedName("aq")
   static class94[][] field1529;

   @ObfuscatedName("w")
   public void method1672(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1337; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method1691(var6);
               return;
            }
         }
      }

   }

   @ObfuscatedName("a")
   public static void method1673(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class94 var8 = new class94();
      var8.field1580 = var2 / 128;
      var8.field1575 = var3 / 128;
      var8.field1565 = var4 / 128;
      var8.field1582 = var5 / 128;
      var8.field1574 = var1;
      var8.field1568 = var2;
      var8.field1569 = var3;
      var8.field1566 = var4;
      var8.field1571 = var5;
      var8.field1572 = var6;
      var8.field1563 = var7;
      field1529[var0][field1496[var0]++] = var8;
   }

   @ObfuscatedName("g")
   public void method1675(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class85 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class85(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1331 = var21;
      } else if(var4 != 1) {
         class77 var23 = new class77(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1332 = var23;
      } else {
         var21 = new class85(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1331 = var21;
      }

   }

   @ObfuscatedName("t")
   public void method1677(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1337; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method1532();
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

   @ObfuscatedName("m")
   public void method1678(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field1550 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field1545 = var7;
         var11.field1548 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }

   }

   @ObfuscatedName("e")
   public boolean method1680(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + 64 * var5;
         int var12 = var3 * 128 + 64 * var6;
         return this.method1683(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("p")
   boolean method1683(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var14;
      for(int var15 = var2; var15 < var2 + var4; ++var15) {
         for(var14 = var3; var14 < var3 + var5; ++var14) {
            if(var15 < 0 || var14 < 0 || var15 >= this.field1503 || var14 >= this.field1471) {
               return false;
            }

            Tile var16 = this.tiles[var1][var15][var14];
            if(var16 != null && var16.field1337 >= 5) {
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
            var21.objects[var21.field1337] = var19;
            var21.field1333[var21.field1337] = var17;
            var21.field1340 |= var17;
            ++var21.field1337;
         }
      }

      if(var11) {
         this.objects[this.field1474++] = var19;
      }

      return true;
   }

   @ObfuscatedName("k")
   public void method1684() {
      for(int var1 = 0; var1 < this.field1474; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method1691(var2);
         this.objects[var1] = null;
      }

      this.field1474 = 0;
   }

   @ObfuscatedName("v")
   public boolean method1686(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method1683(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("bw")
   boolean method1687(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1508; ++var4) {
         class94 var5 = field1511[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field1564 == 1) {
            var6 = var5.field1568 - var1;
            if(var6 > 0) {
               var7 = var5.field1566 + (var5.field1577 * var6 >> 8);
               var8 = var5.field1571 + (var5.field1578 * var6 >> 8);
               var9 = var5.field1572 + (var5.field1579 * var6 >> 8);
               var10 = var5.field1563 + (var5.field1567 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1564 == 2) {
            var6 = var1 - var5.field1568;
            if(var6 > 0) {
               var7 = var5.field1566 + (var5.field1577 * var6 >> 8);
               var8 = var5.field1571 + (var5.field1578 * var6 >> 8);
               var9 = var5.field1572 + (var5.field1579 * var6 >> 8);
               var10 = var5.field1563 + (var5.field1567 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1564 == 3) {
            var6 = var5.field1566 - var3;
            if(var6 > 0) {
               var7 = var5.field1568 + (var5.field1570 * var6 >> 8);
               var8 = var5.field1569 + (var5.field1576 * var6 >> 8);
               var9 = var5.field1572 + (var5.field1579 * var6 >> 8);
               var10 = var5.field1563 + (var5.field1567 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1564 == 4) {
            var6 = var3 - var5.field1566;
            if(var6 > 0) {
               var7 = var5.field1568 + (var5.field1570 * var6 >> 8);
               var8 = var5.field1569 + (var5.field1576 * var6 >> 8);
               var9 = var5.field1572 + (var5.field1579 * var6 >> 8);
               var10 = var5.field1563 + (var5.field1567 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1564 == 5) {
            var6 = var2 - var5.field1572;
            if(var6 > 0) {
               var7 = var5.field1568 + (var5.field1570 * var6 >> 8);
               var8 = var5.field1569 + (var5.field1576 * var6 >> 8);
               var9 = var5.field1566 + (var5.field1577 * var6 >> 8);
               var10 = var5.field1571 + (var5.field1578 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedName("s")
   public void method1688(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }

   }

   @ObfuscatedName("r")
   void method1691(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1337; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1337;

                     for(int var6 = var5; var6 < var4.field1337; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1333[var6] = var4.field1333[var6 + 1];
                     }

                     var4.objects[var4.field1337] = null;
                     break;
                  }
               }

               var4.field1340 = 0;

               for(var5 = 0; var5 < var4.field1337; ++var5) {
                  var4.field1340 |= var4.field1333[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   public void method1692(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }

   }

   @ObfuscatedName("al")
   public GroundObject method1695(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("an")
   public int method1696(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("af")
   public int method1697(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("aa")
   public int method1698(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1337; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("ax")
   public int method1699(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method1701(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1469; ++var4) {
         for(int var5 = 0; var5 < this.field1503; ++var5) {
            for(int var6 = 0; var6 < this.field1471; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var9;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var10 = (ModelData)var8.renderable1;
                     this.method1794(var10, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var9 = (ModelData)var8.renderable2;
                        this.method1794(var9, var4, var5, var6, 1, 1);
                        ModelData.method1429(var10, var9, 0, 0, 0, false);
                        var8.renderable2 = var9.method1486(var9.field1242, var9.field1256, var1, var2, var3);
                     }

                     var8.renderable1 = var10.method1486(var10.field1242, var10.field1256, var1, var2, var3);
                  }

                  for(int var13 = 0; var13 < var7.field1337; ++var13) {
                     GameObject var11 = var7.objects[var13];
                     if(var11 != null && var11.renderable instanceof ModelData) {
                        ModelData var12 = (ModelData)var11.renderable;
                        this.method1794(var12, var4, var5, var6, var11.offsetX - var11.relativeX + 1, var11.offsetY - var11.relativeY + 1);
                        var11.renderable = var12.method1486(var12.field1242, var12.field1256, var1, var2, var3);
                     }
                  }

                  GroundObject var14 = var7.groundObject;
                  if(var14 != null && var14.renderable instanceof ModelData) {
                     var9 = (ModelData)var14.renderable;
                     this.method1702(var9, var4, var5, var6);
                     var14.renderable = var9.method1486(var9.field1242, var9.field1256, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   void method1702(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field1503) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1429(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field1503) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1429(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field1503 && var4 < this.field1471) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1429(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field1503 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method1429(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("az")
   public void method1704(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class85 var8 = var7.field1331;
         int var9;
         if(var8 != null) {
            int var10 = var8.field1456;
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
            class77 var18 = var7.field1332;
            if(var18 != null) {
               var9 = var18.field1265;
               int var11 = var18.field1273;
               int var12 = var18.field1278;
               int var13 = var18.field1279;
               int[] var14 = this.field1520[var9];
               int[] var15 = this.field1521[var11];
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

   @ObfuscatedName("ad")
   public static void method1705(int[] var0, int var1, int var2, int var3, int var4) {
      field1516 = 0;
      field1527 = 0;
      field1528 = var3;
      field1513 = var4;
      field1526 = var3 / 2;
      field1510 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field1494 = class84.field1438[var6];
            field1495 = class84.field1428[var6];
            field1486 = class84.field1438[var7];
            field1497 = class84.field1428[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var12 = -26; var12 <= 26; ++var12) {
               for(var10 = -26; var10 <= 26; ++var10) {
                  var11 = var12 * 128;
                  int var13 = var10 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method1706(var11, var0[var8] + var15, var13)) {
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

                  field1524[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("aw")
   static boolean method1706(int var0, int var1, int var2) {
      int var3 = var2 * field1486 + var0 * field1497 >> 16;
      int var4 = var2 * field1497 - var0 * field1486 >> 16;
      int var5 = var1 * field1494 + var4 * field1495 >> 16;
      int var6 = var1 * field1495 - var4 * field1494 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field1526 + var3 * class84.field1437 / var5;
         int var8 = field1510 + var6 * class84.field1437 / var5;
         return var7 >= field1516 && var7 <= field1528 && var8 >= field1527 && var8 <= field1513;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ak")
   public void method1707(int var1, int var2, int var3) {
      field1499 = true;
      field1505 = var1;
      field1490 = var2;
      field1502 = var3;
      field1470 = -1;
      field1504 = -1;
   }

   @ObfuscatedName("aq")
   public void method1708(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field1503 * 128) {
         var1 = this.field1503 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field1471 * 128) {
         var3 = this.field1471 * 128 - 1;
      }

      ++field1484;
      field1494 = class84.field1438[var4];
      field1495 = class84.field1428[var4];
      field1486 = class84.field1438[var5];
      field1497 = class84.field1428[var5];
      renderArea = field1524[(var4 - 128) / 32][var5 / 64];
      field1491 = var1;
      field1492 = var2;
      field1475 = var3;
      field1489 = var1 / 128;
      field1468 = var3 / 128;
      field1483 = var6;
      field1485 = field1489 - 25;
      if(field1485 < 0) {
         field1485 = 0;
      }

      field1487 = field1468 - 25;
      if(field1487 < 0) {
         field1487 = 0;
      }

      field1509 = field1489 + 25;
      if(field1509 > this.field1503) {
         field1509 = this.field1503;
      }

      field1488 = field1468 + 25;
      if(field1488 > this.field1471) {
         field1488 = this.field1471;
      }

      this.method1710();
      field1482 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field1478; var7 < this.field1469; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field1485; var9 < field1509; ++var9) {
            for(var10 = field1487; var10 < field1488; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1341 > var6 || !renderArea[var9 - field1489 + 25][var10 - field1468 + 25] && this.field1472[var7][var9][var10] - var2 < 2000) {
                     var11.field1329 = false;
                     var11.field1343 = false;
                     var11.field1353 = 0;
                  } else {
                     var11.field1329 = true;
                     var11.field1343 = true;
                     if(var11.field1337 > 0) {
                        var11.field1344 = true;
                     } else {
                        var11.field1344 = false;
                     }

                     ++field1482;
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
      for(var7 = this.field1478; var7 < this.field1469; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1489 + var9;
            var15 = field1489 - var9;
            if(var10 >= field1485 || var15 < field1509) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = field1468 + var16;
                  var13 = field1468 - var16;
                  if(var10 >= field1485) {
                     if(var12 >= field1487) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, true);
                        }
                     }

                     if(var13 < field1488) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, true);
                        }
                     }
                  }

                  if(var15 < field1509) {
                     if(var12 >= field1487) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, true);
                        }
                     }

                     if(var13 < field1488) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, true);
                        }
                     }
                  }

                  if(field1482 == 0) {
                     field1499 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field1478; var7 < this.field1469; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1489 + var9;
            var15 = field1489 - var9;
            if(var10 >= field1485 || var15 < field1509) {
               for(var16 = -25; var16 <= 0; ++var16) {
                  var12 = field1468 + var16;
                  var13 = field1468 - var16;
                  if(var10 >= field1485) {
                     if(var12 >= field1487) {
                        var14 = var8[var10][var12];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, false);
                        }
                     }

                     if(var13 < field1488) {
                        var14 = var8[var10][var13];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, false);
                        }
                     }
                  }

                  if(var15 < field1509) {
                     if(var12 >= field1487) {
                        var14 = var8[var15][var12];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, false);
                        }
                     }

                     if(var13 < field1488) {
                        var14 = var8[var15][var13];
                        if(var14 != null && var14.field1329) {
                           this.method1709(var14, false);
                        }
                     }
                  }

                  if(field1482 == 0) {
                     field1499 = false;
                     return;
                  }
               }
            }
         }
      }

      field1499 = false;
   }

   @ObfuscatedName("ac")
   void method1709(Tile var1, boolean var2) {
      field1512.method2394(var1);

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
                                    var3 = (Tile)field1512.method2389();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1343);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1330;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1329) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1343) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field1489 && var4 > field1485) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1343 && (var9.field1329 || (var3.field1340 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field1489 && var4 < field1509 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1343 && (var9.field1329 || (var3.field1340 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field1468 && var5 > field1487) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1343 && (var9.field1329 || (var3.field1340 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field1468 && var5 < field1488 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1343 && (var9.field1329 || (var3.field1340 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1329 = false;
                                 if(var3.field1349 != null) {
                                    var9 = var3.field1349;
                                    if(var9.field1331 != null) {
                                       if(!this.method1769(0, var4, var5)) {
                                          this.method1722(var9.field1331, 0, field1494, field1495, field1486, field1497, var4, var5);
                                       }
                                    } else if(var9.field1332 != null && !this.method1769(0, var4, var5)) {
                                       this.method1711(var9.field1332, field1494, field1495, field1486, field1497, var4, var5);
                                    }

                                    var16 = var9.wallObject;
                                    if(var16 != null) {
                                       var16.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var16.x - field1491, var16.floor - field1492, var16.y - field1475, var16.hash);
                                    }

                                    for(var10 = 0; var10 < var9.field1337; ++var10) {
                                       var17 = var9.objects[var10];
                                       if(var17 != null) {
                                          var17.renderable.vmethod1842(var17.orientation, field1494, field1495, field1486, field1497, var17.x - field1491, var17.height - field1492, var17.y - field1475, var17.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1331 != null) {
                                    if(!this.method1769(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1331.field1455 != 12345678 || field1499 && var6 <= field1505) {
                                          this.method1722(var3.field1331, var7, field1494, field1495, field1486, field1497, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1332 != null && !this.method1769(var7, var4, var5)) {
                                    var20 = true;
                                    this.method1711(var3.field1332, field1494, field1495, field1486, field1497, var4, var5);
                                 }

                                 var21 = 0;
                                 var10 = 0;
                                 WallObject var23 = var3.wallObject;
                                 DecorativeObject var24 = var3.decorativeObject;
                                 if(var23 != null || var24 != null) {
                                    if(field1489 == var4) {
                                       ++var21;
                                    } else if(field1489 < var4) {
                                       var21 += 2;
                                    }

                                    if(field1468 == var5) {
                                       var21 += 3;
                                    } else if(field1468 > var5) {
                                       var21 += 6;
                                    }

                                    var10 = field1506[var21];
                                    var3.field1348 = field1493[var21];
                                 }

                                 if(var23 != null) {
                                    if((var23.field1545 & field1514[var21]) != 0) {
                                       if(var23.field1545 == 16) {
                                          var3.field1353 = 3;
                                          var3.field1334 = field1480[var21];
                                          var3.field1338 = 3 - var3.field1334;
                                       } else if(var23.field1545 == 32) {
                                          var3.field1353 = 6;
                                          var3.field1334 = field1517[var21];
                                          var3.field1338 = 6 - var3.field1334;
                                       } else if(var23.field1545 == 64) {
                                          var3.field1353 = 12;
                                          var3.field1334 = field1518[var21];
                                          var3.field1338 = 12 - var3.field1334;
                                       } else {
                                          var3.field1353 = 9;
                                          var3.field1334 = field1519[var21];
                                          var3.field1338 = 9 - var3.field1334;
                                       }
                                    } else {
                                       var3.field1353 = 0;
                                    }

                                    if((var23.field1545 & var10) != 0 && !this.method1716(var7, var4, var5, var23.field1545)) {
                                       var23.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var23.x - field1491, var23.floor - field1492, var23.y - field1475, var23.hash);
                                    }

                                    if((var23.field1548 & var10) != 0 && !this.method1716(var7, var4, var5, var23.field1548)) {
                                       var23.renderable2.vmethod1842(0, field1494, field1495, field1486, field1497, var23.x - field1491, var23.floor - field1492, var23.y - field1475, var23.hash);
                                    }
                                 }

                                 if(var24 != null && !this.method1717(var7, var4, var5, var24.renderable1.modelHeight)) {
                                    if((var24.field1588 & var10) != 0) {
                                       var24.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var24.x - field1491 + var24.field1584, var24.floor - field1492, var24.y - field1475 + var24.field1590, var24.hash);
                                    } else if(var24.field1588 == 256) {
                                       var11 = var24.x - field1491;
                                       var12 = var24.floor - field1492;
                                       var13 = var24.y - field1475;
                                       var18 = var24.field1585;
                                       if(var18 != 1 && var18 != 2) {
                                          var19 = var11;
                                       } else {
                                          var19 = -var11;
                                       }

                                       int var25;
                                       if(var18 != 2 && var18 != 3) {
                                          var25 = var13;
                                       } else {
                                          var25 = -var13;
                                       }

                                       if(var25 < var19) {
                                          var24.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var11 + var24.field1584, var12, var13 + var24.field1590, var24.hash);
                                       } else if(var24.renderable2 != null) {
                                          var24.renderable2.vmethod1842(0, field1494, field1495, field1486, field1497, var11, var12, var13, var24.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var34 = var3.groundObject;
                                    if(var34 != null) {
                                       var34.renderable.vmethod1842(0, field1494, field1495, field1486, field1497, var34.x - field1491, var34.floor - field1492, var34.y - field1475, var34.hash);
                                    }

                                    ItemLayer var26 = var3.itemLayer;
                                    if(var26 != null && var26.height == 0) {
                                       if(var26.middle != null) {
                                          var26.middle.vmethod1842(0, field1494, field1495, field1486, field1497, var26.x - field1491, var26.hash - field1492, var26.y - field1475, var26.flags);
                                       }

                                       if(var26.top != null) {
                                          var26.top.vmethod1842(0, field1494, field1495, field1486, field1497, var26.x - field1491, var26.hash - field1492, var26.y - field1475, var26.flags);
                                       }

                                       if(var26.bottom != null) {
                                          var26.bottom.vmethod1842(0, field1494, field1495, field1486, field1497, var26.x - field1491, var26.hash - field1492, var26.y - field1475, var26.flags);
                                       }
                                    }
                                 }

                                 var11 = var3.field1340;
                                 if(var11 != 0) {
                                    if(var4 < field1489 && (var11 & 4) != 0) {
                                       var22 = var8[var4 + 1][var5];
                                       if(var22 != null && var22.field1343) {
                                          field1512.method2394(var22);
                                       }
                                    }

                                    if(var5 < field1468 && (var11 & 2) != 0) {
                                       var22 = var8[var4][var5 + 1];
                                       if(var22 != null && var22.field1343) {
                                          field1512.method2394(var22);
                                       }
                                    }

                                    if(var4 > field1489 && (var11 & 1) != 0) {
                                       var22 = var8[var4 - 1][var5];
                                       if(var22 != null && var22.field1343) {
                                          field1512.method2394(var22);
                                       }
                                    }

                                    if(var5 > field1468 && (var11 & 8) != 0) {
                                       var22 = var8[var4][var5 - 1];
                                       if(var22 != null && var22.field1343) {
                                          field1512.method2394(var22);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1353 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1337; ++var21) {
                                    if(var3.objects[var21].field1610 != field1484 && (var3.field1333[var21] & var3.field1353) == var3.field1334) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var16 = var3.wallObject;
                                    if(!this.method1716(var7, var4, var5, var16.field1545)) {
                                       var16.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var16.x - field1491, var16.floor - field1492, var16.y - field1475, var16.hash);
                                    }

                                    var3.field1353 = 0;
                                 }
                              }

                              if(!var3.field1344) {
                                 break;
                              }

                              try {
                                 int var32 = var3.field1337;
                                 var3.field1344 = false;
                                 var21 = 0;

                                 label563:
                                 for(var10 = 0; var10 < var32; ++var10) {
                                    var17 = var3.objects[var10];
                                    if(var17.field1610 != field1484) {
                                       for(var14 = var17.relativeX; var14 <= var17.offsetX; ++var14) {
                                          for(var11 = var17.relativeY; var11 <= var17.offsetY; ++var11) {
                                             var22 = var8[var14][var11];
                                             if(var22.field1329) {
                                                var3.field1344 = true;
                                                continue label563;
                                             }

                                             if(var22.field1353 != 0) {
                                                var13 = 0;
                                                if(var14 > var17.relativeX) {
                                                   ++var13;
                                                }

                                                if(var14 < var17.offsetX) {
                                                   var13 += 4;
                                                }

                                                if(var11 > var17.relativeY) {
                                                   var13 += 8;
                                                }

                                                if(var11 < var17.offsetY) {
                                                   var13 += 2;
                                                }

                                                if((var13 & var22.field1353) == var3.field1338) {
                                                   var3.field1344 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field1498[var21++] = var17;
                                       var14 = field1489 - var17.relativeX;
                                       var11 = var17.offsetX - field1489;
                                       if(var11 > var14) {
                                          var14 = var11;
                                       }

                                       var12 = field1468 - var17.relativeY;
                                       var13 = var17.offsetY - field1468;
                                       if(var13 > var12) {
                                          var17.field1601 = var14 + var13;
                                       } else {
                                          var17.field1601 = var14 + var12;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var10 = -50;
                                    var15 = -1;

                                    GameObject var33;
                                    for(var14 = 0; var14 < var21; ++var14) {
                                       var33 = field1498[var14];
                                       if(var33.field1610 != field1484) {
                                          if(var33.field1601 > var10) {
                                             var10 = var33.field1601;
                                             var15 = var14;
                                          } else if(var33.field1601 == var10) {
                                             var12 = var33.x - field1491;
                                             var13 = var33.y - field1475;
                                             var18 = field1498[var15].x - field1491;
                                             var19 = field1498[var15].y - field1475;
                                             if(var12 * var12 + var13 * var13 > var18 * var18 + var19 * var19) {
                                                var15 = var14;
                                             }
                                          }
                                       }
                                    }

                                    if(var15 == -1) {
                                       break;
                                    }

                                    var33 = field1498[var15];
                                    var33.field1610 = field1484;
                                    if(!this.method1756(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod1842(var33.orientation, field1494, field1495, field1486, field1497, var33.x - field1491, var33.height - field1492, var33.y - field1475, var33.hash);
                                    }

                                    for(var11 = var33.relativeX; var11 <= var33.offsetX; ++var11) {
                                       for(var12 = var33.relativeY; var12 <= var33.offsetY; ++var12) {
                                          Tile var35 = var8[var11][var12];
                                          if(var35.field1353 != 0) {
                                             field1512.method2394(var35);
                                          } else if((var11 != var4 || var12 != var5) && var35.field1343) {
                                             field1512.method2394(var35);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1344) {
                                    break;
                                 }
                              } catch (Exception var27) {
                                 var3.field1344 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1343);
                     } while(var3.field1353 != 0);

                     if(var4 > field1489 || var4 <= field1485) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1343);

                  if(var4 < field1489 || var4 >= field1509 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1343);

               if(var5 > field1468 || var5 <= field1487) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1343);

            if(var5 < field1468 || var5 >= field1488 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1343);

         var3.field1343 = false;
         --field1482;
         ItemLayer var28 = var3.itemLayer;
         if(var28 != null && var28.height != 0) {
            if(var28.middle != null) {
               var28.middle.vmethod1842(0, field1494, field1495, field1486, field1497, var28.x - field1491, var28.hash - field1492 - var28.height, var28.y - field1475, var28.flags);
            }

            if(var28.top != null) {
               var28.top.vmethod1842(0, field1494, field1495, field1486, field1497, var28.x - field1491, var28.hash - field1492 - var28.height, var28.y - field1475, var28.flags);
            }

            if(var28.bottom != null) {
               var28.bottom.vmethod1842(0, field1494, field1495, field1486, field1497, var28.x - field1491, var28.hash - field1492 - var28.height, var28.y - field1475, var28.flags);
            }
         }

         if(var3.field1348 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method1717(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.field1588 & var3.field1348) != 0) {
                  var29.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var29.x - field1491 + var29.field1584, var29.floor - field1492, var29.y - field1475 + var29.field1590, var29.hash);
               } else if(var29.field1588 == 256) {
                  var10 = var29.x - field1491;
                  var15 = var29.floor - field1492;
                  var14 = var29.y - field1475;
                  var11 = var29.field1585;
                  if(var11 != 1 && var11 != 2) {
                     var12 = var10;
                  } else {
                     var12 = -var10;
                  }

                  if(var11 != 2 && var11 != 3) {
                     var13 = var14;
                  } else {
                     var13 = -var14;
                  }

                  if(var13 >= var12) {
                     var29.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var10 + var29.field1584, var15, var14 + var29.field1590, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod1842(0, field1494, field1495, field1486, field1497, var10, var15, var14, var29.hash);
                  }
               }
            }

            WallObject var31 = var3.wallObject;
            if(var31 != null) {
               if((var31.field1548 & var3.field1348) != 0 && !this.method1716(var7, var4, var5, var31.field1548)) {
                  var31.renderable2.vmethod1842(0, field1494, field1495, field1486, field1497, var31.x - field1491, var31.floor - field1492, var31.y - field1475, var31.hash);
               }

               if((var31.field1545 & var3.field1348) != 0 && !this.method1716(var7, var4, var5, var31.field1545)) {
                  var31.renderable1.vmethod1842(0, field1494, field1495, field1486, field1497, var31.x - field1491, var31.floor - field1492, var31.y - field1475, var31.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field1469 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1343) {
               field1512.method2394(var30);
            }
         }

         if(var4 < field1489) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1343) {
               field1512.method2394(var30);
            }
         }

         if(var5 < field1468) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1343) {
               field1512.method2394(var30);
            }
         }

         if(var4 > field1489) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1343) {
               field1512.method2394(var30);
            }
         }

         if(var5 > field1468) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1343) {
               field1512.method2394(var30);
            }
         }
      }
   }

   @ObfuscatedName("as")
   void method1710() {
      int var1 = field1496[field1483];
      class94[] var2 = field1529[field1483];
      field1508 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class94 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var8;
         boolean var9;
         if(var4.field1574 == 1) {
            var5 = var4.field1580 - field1489 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1565 - field1468 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1582 - field1468 + 25;
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
                  var8 = field1491 - var4.field1568;
                  if(var8 > 32) {
                     var4.field1564 = 1;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.field1564 = 2;
                     var8 = -var8;
                  }

                  var4.field1577 = (var4.field1566 - field1475 << 8) / var8;
                  var4.field1578 = (var4.field1571 - field1475 << 8) / var8;
                  var4.field1579 = (var4.field1572 - field1492 << 8) / var8;
                  var4.field1567 = (var4.field1563 - field1492 << 8) / var8;
                  field1511[field1508++] = var4;
               }
            }
         } else if(var4.field1574 == 2) {
            var5 = var4.field1565 - field1468 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1580 - field1489 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1575 - field1489 + 25;
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
                  var8 = field1475 - var4.field1566;
                  if(var8 > 32) {
                     var4.field1564 = 3;
                  } else {
                     if(var8 >= -32) {
                        continue;
                     }

                     var4.field1564 = 4;
                     var8 = -var8;
                  }

                  var4.field1570 = (var4.field1568 - field1491 << 8) / var8;
                  var4.field1576 = (var4.field1569 - field1491 << 8) / var8;
                  var4.field1579 = (var4.field1572 - field1492 << 8) / var8;
                  var4.field1567 = (var4.field1563 - field1492 << 8) / var8;
                  field1511[field1508++] = var4;
               }
            }
         } else if(var4.field1574 == 4) {
            var5 = var4.field1572 - field1492;
            if(var5 > 128) {
               var6 = var4.field1565 - field1468 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1582 - field1468 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var10 = var4.field1580 - field1489 + 25;
                  if(var10 < 0) {
                     var10 = 0;
                  }

                  var8 = var4.field1575 - field1489 + 25;
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
                     var4.field1564 = 5;
                     var4.field1570 = (var4.field1568 - field1491 << 8) / var5;
                     var4.field1576 = (var4.field1569 - field1491 << 8) / var5;
                     var4.field1577 = (var4.field1566 - field1475 << 8) / var5;
                     var4.field1578 = (var4.field1571 - field1475 << 8) / var5;
                     field1511[field1508++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   void method1711(class77 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1281.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1281[var9] - field1491;
         var11 = var1.field1266[var9] - field1492;
         var12 = var1.field1267[var9] - field1475;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1274 != null) {
            class77.field1272[var9] = var10;
            class77.field1283[var9] = var13;
            class77.field1284[var9] = var12;
         }

         class77.field1282[var9] = class84.field1443 + var10 * class84.field1437 / var12;
         class77.field1277[var9] = class84.field1439 + var13 * class84.field1437 / var12;
      }

      class84.rasterAlpha = 0;
      var8 = var1.field1271.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1271[var9];
         var11 = var1.field1276[var9];
         var12 = var1.field1275[var9];
         var13 = class77.field1282[var10];
         int var14 = class77.field1282[var11];
         int var15 = class77.field1282[var12];
         int var16 = class77.field1277[var10];
         int var17 = class77.field1277[var11];
         int var18 = class77.field1277[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class84.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class84.rasterClipX || var14 > class84.rasterClipX || var15 > class84.rasterClipX) {
               class84.rasterClipEnable = true;
            }

            if(field1499 && this.method1713(field1490, field1502, var16, var17, var18, var13, var14, var15)) {
               field1470 = var6;
               field1504 = var7;
            }

            if(var1.field1274 != null && var1.field1274[var9] != -1) {
               if(!field1522) {
                  if(var1.field1280) {
                     class84.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1268[var9], var1.field1269[var9], var1.field1270[var9], class77.field1272[0], class77.field1272[1], class77.field1272[3], class77.field1283[0], class77.field1283[1], class77.field1283[3], class77.field1284[0], class77.field1284[1], class77.field1284[3], var1.field1274[var9]);
                  } else {
                     class84.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1268[var9], var1.field1269[var9], var1.field1270[var9], class77.field1272[var10], class77.field1272[var11], class77.field1272[var12], class77.field1283[var10], class77.field1283[var11], class77.field1283[var12], class77.field1284[var10], class77.field1284[var11], class77.field1284[var12], var1.field1274[var9]);
                  }
               } else {
                  int var19 = class84.field1434.vmethod1854(var1.field1274[var9]);
                  class84.rasterGouraud(var16, var17, var18, var13, var14, var15, method1712(var19, var1.field1268[var9]), method1712(var19, var1.field1269[var9]), method1712(var19, var1.field1270[var9]));
               }
            } else if(var1.field1268[var9] != 12345678) {
               class84.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1268[var9], var1.field1269[var9], var1.field1270[var9]);
            }
         }
      }

   }

   @ObfuscatedName("ar")
   static final int method1712(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ab")
   boolean method1713(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ai")
   public int method1714(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field1550 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.field1594 & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.field1292 & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1337; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ag")
   public GameObject method1715(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1337; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ae")
   boolean method1716(int var1, int var2, int var3, int var4) {
      if(!this.method1769(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field1472[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field1491) {
                  if(!this.method1687(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1687(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1687(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1687(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field1475) {
                  if(!this.method1687(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1687(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1687(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method1687(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field1491) {
                  if(!this.method1687(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1687(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1687(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method1687(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field1475) {
                  if(!this.method1687(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1687(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1687(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method1687(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1687(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method1687(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method1687(var5, var9, var6 + 128):(var4 == 32?this.method1687(var5 + 128, var9, var6 + 128):(var4 == 64?this.method1687(var5 + 128, var9, var6):(var4 == 128?this.method1687(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("ao")
   boolean method1717(int var1, int var2, int var3, int var4) {
      if(!this.method1769(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method1687(var5 + 1, this.field1472[var1][var2][var3] - var4, var6 + 1) && this.method1687(var5 + 128 - 1, this.field1472[var1][var2 + 1][var3] - var4, var6 + 1) && this.method1687(var5 + 128 - 1, this.field1472[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method1687(var5 + 1, this.field1472[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("o")
   public void method1718(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }

   }

   @ObfuscatedName("am")
   void method1722(class85 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field1491;
      int var11;
      int var12 = var11 = (var8 << 7) - field1475;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field1472[var2][var7][var8] - field1492;
      int var18 = this.field1472[var2][var7 + 1][var8] - field1492;
      int var19 = this.field1472[var2][var7 + 1][var8 + 1] - field1492;
      int var20 = this.field1472[var2][var7][var8 + 1] - field1492;
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
                  int var22 = class84.field1443 + var10 * class84.field1437 / var12;
                  int var23 = class84.field1439 + var17 * class84.field1437 / var12;
                  int var24 = class84.field1443 + var14 * class84.field1437 / var11;
                  int var25 = class84.field1439 + var18 * class84.field1437 / var11;
                  int var26 = class84.field1443 + var13 * class84.field1437 / var16;
                  int var27 = class84.field1439 + var19 * class84.field1437 / var16;
                  int var28 = class84.field1443 + var9 * class84.field1437 / var15;
                  int var29 = class84.field1439 + var21 * class84.field1437 / var15;
                  class84.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class84.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class84.rasterClipX || var28 > class84.rasterClipX || var24 > class84.rasterClipX) {
                        class84.rasterClipEnable = true;
                     }

                     if(field1499 && this.method1713(field1490, field1502, var27, var29, var25, var26, var28, var24)) {
                        field1470 = var7;
                        field1504 = var8;
                     }

                     if(var1.field1457 == -1) {
                        if(var1.field1455 != 12345678) {
                           class84.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field1455, var1.field1453, var1.field1454);
                        }
                     } else if(!field1522) {
                        if(var1.field1458) {
                           class84.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1455, var1.field1453, var1.field1454, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1457);
                        } else {
                           class84.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1455, var1.field1453, var1.field1454, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field1457);
                        }
                     } else {
                        var30 = class84.field1434.vmethod1854(var1.field1457);
                        class84.rasterGouraud(var27, var29, var25, var26, var28, var24, method1712(var30, var1.field1455), method1712(var30, var1.field1453), method1712(var30, var1.field1454));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class84.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class84.rasterClipX || var24 > class84.rasterClipX || var28 > class84.rasterClipX) {
                        class84.rasterClipEnable = true;
                     }

                     if(field1499 && this.method1713(field1490, field1502, var23, var25, var29, var22, var24, var28)) {
                        field1470 = var7;
                        field1504 = var8;
                     }

                     if(var1.field1457 == -1) {
                        if(var1.field1459 != 12345678) {
                           class84.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field1459, var1.field1454, var1.field1453);
                        }
                     } else if(!field1522) {
                        class84.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field1459, var1.field1454, var1.field1453, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1457);
                     } else {
                        var30 = class84.field1434.vmethod1854(var1.field1457);
                        class84.rasterGouraud(var23, var25, var29, var22, var24, var28, method1712(var30, var1.field1459), method1712(var30, var1.field1454), method1712(var30, var1.field1453));
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   public void method1726(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1341 = var4;
      }

   }

   @ObfuscatedName("y")
   public void method1731(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.field1584 = var6.field1584 * var4 / 16;
            var6.field1590 = var6.field1590 * var4 / 16;
         }
      }

   }

   @ObfuscatedName("j")
   public boolean method1741(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method1683(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("i")
   public void method1747(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1337; ++var6) {
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

      this.tiles[0][var1][var2].field1349 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("au")
   boolean method1756(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method1769(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method1687(var7 + 1, this.field1472[var1][var2][var4] - var6, var8 + 1) && this.method1687(var7 + 128 - 1, this.field1472[var1][var2 + 1][var4] - var6, var8 + 1) && this.method1687(var7 + 128 - 1, this.field1472[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method1687(var7 + 1, this.field1472[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field1477[var1][var7][var8] == -field1484) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field1472[var1][var2][var4] - var6;
         if(!this.method1687(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method1687(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method1687(var7, var9, var11)) {
                  return false;
               } else if(!this.method1687(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("aj")
   public DecorativeObject method1758(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("b")
   public WallObject method1760(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("ap")
   boolean method1769(int var1, int var2, int var3) {
      int var4 = this.field1477[var1][var2][var3];
      if(var4 == -field1484) {
         return false;
      } else if(var4 == field1484) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method1687(var5 + 1, this.field1472[var1][var2][var3], var6 + 1) && this.method1687(var5 + 128 - 1, this.field1472[var1][var2 + 1][var3], var6 + 1) && this.method1687(var5 + 128 - 1, this.field1472[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method1687(var5 + 1, this.field1472[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field1477[var1][var2][var3] = field1484;
            return true;
         } else {
            this.field1477[var1][var2][var3] = -field1484;
            return false;
         }
      }
   }

   @ObfuscatedName("u")
   public void method1775() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field1469; ++var1) {
         for(var2 = 0; var2 < this.field1503; ++var2) {
            for(int var3 = 0; var3 < this.field1471; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field1507; ++var1) {
         for(var2 = 0; var2 < field1496[var1]; ++var2) {
            field1529[var1][var2] = null;
         }

         field1496[var1] = 0;
      }

      for(var1 = 0; var1 < this.field1474; ++var1) {
         this.objects[var1] = null;
      }

      this.field1474 = 0;

      for(var1 = 0; var1 < field1498.length; ++var1) {
         field1498[var1] = null;
      }

   }

   @ObfuscatedName("at")
   void method1794(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field1469) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field1503) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field1471 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field1472[var12][var13][var14] + this.field1472[var12][var13 + 1][var14] + this.field1472[var12][var13][var14 + 1] + this.field1472[var12][var13 + 1][var14 + 1]) / 4 - (this.field1472[var2][var3][var4] + this.field1472[var2][var3 + 1][var4] + this.field1472[var2][var3][var4 + 1] + this.field1472[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method1429(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method1429(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.field1337; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method1429(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("q")
   public void method1807(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      if(var5 != null) {
         DecorativeObject var13 = new DecorativeObject();
         var13.hash = var11;
         var13.field1594 = var12;
         var13.x = var2 * 128 + 64;
         var13.y = var3 * 128 + 64;
         var13.floor = var4;
         var13.renderable1 = var5;
         var13.renderable2 = var6;
         var13.field1588 = var7;
         var13.field1585 = var8;
         var13.field1584 = var9;
         var13.field1590 = var10;

         for(int var14 = var1; var14 >= 0; --var14) {
            if(this.tiles[var14][var2][var3] == null) {
               this.tiles[var14][var2][var3] = new Tile(var14, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].decorativeObject = var13;
      }

   }

   @ObfuscatedName("x")
   public void method1813(int var1) {
      this.field1478 = var1;

      for(int var2 = 0; var2 < this.field1503; ++var2) {
         for(int var3 = 0; var3 < this.field1471; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field1469 = var1;
      this.field1503 = var2;
      this.field1471 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field1477 = new int[var1][var2 + 1][var3 + 1];
      this.field1472 = var4;
      this.method1775();
   }

   @ObfuscatedName("h")
   public void method1829(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }

   }

   @ObfuscatedName("z")
   @Export("groundObjectSpawned")
   public void groundObjectSpawned(int var1, int var2, int var3, int var4, Renderable var5, int var6, int var7) {
      if(var5 != null) {
         GroundObject var8 = new GroundObject();
         var8.renderable = var5;
         var8.x = var2 * 128 + 64;
         var8.y = var3 * 128 + 64;
         var8.floor = var4;
         var8.hash = var6;
         var8.field1292 = var7;
         if(this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
         }

         this.tiles[var1][var2][var3].groundObject = var8;
      }

   }

   static {
      field1496 = new int[field1507];
      field1529 = new class94[field1507][500];
      field1508 = 0;
      field1511 = new class94[500];
      field1512 = new Deque();
      field1506 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field1514 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field1493 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field1480 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field1517 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field1518 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field1519 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field1524 = new boolean[8][32][51][51];
   }
}

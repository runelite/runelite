import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Region")
public class Region {
   @ObfuscatedName("m")
   int field1506 = 0;
   @ObfuscatedName("r")
   int field1507;
   @ObfuscatedName("j")
   int field1508;
   @ObfuscatedName("g")
   static int field1509 = 0;
   @ObfuscatedName("l")
   int field1510 = 0;
   @ObfuscatedName("b")
   @Export("tiles")
   Tile[][][] tiles;
   @ObfuscatedName("ac")
   static int field1512;
   @ObfuscatedName("ar")
   static final int[] field1513;
   @ObfuscatedName("p")
   @Export("objects")
   GameObject[] objects = new GameObject[5000];
   @ObfuscatedName("f")
   int[][][] field1515;
   @ObfuscatedName("ag")
   static int field1519;
   @ObfuscatedName("s")
   static int field1520 = 0;
   @ObfuscatedName("i")
   int[][][] field1521;
   @ObfuscatedName("h")
   static int field1522;
   @ObfuscatedName("u")
   static int field1523;
   @ObfuscatedName("a")
   static int field1524;
   @ObfuscatedName("bw")
   static boolean[][] field1525;
   @ObfuscatedName("bu")
   static int field1526;
   @ObfuscatedName("n")
   static int field1527;
   @ObfuscatedName("y")
   static int field1528;
   @ObfuscatedName("k")
   static int field1529;
   @ObfuscatedName("w")
   static int field1530;
   @ObfuscatedName("o")
   static int field1531;
   @ObfuscatedName("z")
   int field1532;
   @ObfuscatedName("an")
   static int field1533;
   @ObfuscatedName("e")
   static int field1534;
   @ObfuscatedName("c")
   static int field1535;
   @ObfuscatedName("aq")
   static GameObject[] field1536 = new GameObject[100];
   @ObfuscatedName("bf")
   int[][] field1537 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   @ObfuscatedName("az")
   static int field1538 = 0;
   @ObfuscatedName("ap")
   static int field1539 = 0;
   @ObfuscatedName("ao")
   static int field1540 = 0;
   @ObfuscatedName("af")
   public static int field1541 = -1;
   @ObfuscatedName("au")
   public static int field1542 = -1;
   @ObfuscatedName("bg")
   static int field1543;
   @ObfuscatedName("ax")
   static boolean field1544 = false;
   @ObfuscatedName("ay")
   static int field1545 = 4;
   @ObfuscatedName("ad")
   static int[] field1546;
   @ObfuscatedName("bz")
   static int field1547;
   @ObfuscatedName("aj")
   static final int[] field1548;
   @ObfuscatedName("aw")
   static class107[] field1549;
   @ObfuscatedName("ah")
   static int field1550;
   @ObfuscatedName("ak")
   static Deque field1551;
   @ObfuscatedName("aa")
   static final int[] field1552;
   @ObfuscatedName("ae")
   static final int[] field1554;
   @ObfuscatedName("al")
   static final int[] field1555;
   @ObfuscatedName("ai")
   static final int[] field1556;
   @ObfuscatedName("as")
   static int field1557;
   @ObfuscatedName("av")
   static final int[] field1558;
   @ObfuscatedName("bx")
   int[][] field1559 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
   @ObfuscatedName("bh")
   static boolean[][][][] field1560;
   @ObfuscatedName("am")
   static class107[][] field1561;
   @ObfuscatedName("x")
   public static boolean field1562 = true;
   @ObfuscatedName("bq")
   static int field1564;
   @ObfuscatedName("bb")
   static int field1565;
   @ObfuscatedName("bk")
   static int field1567;

   @ObfuscatedName("x")
   public void method1948() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field1507; ++var1) {
         for(var2 = 0; var2 < this.field1508; ++var2) {
            for(int var3 = 0; var3 < this.field1532; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field1545; ++var1) {
         for(var2 = 0; var2 < field1546[var1]; ++var2) {
            field1561[var1][var2] = null;
         }

         field1546[var1] = 0;
      }

      for(var1 = 0; var1 < this.field1506; ++var1) {
         this.objects[var1] = null;
      }

      this.field1506 = 0;

      for(var1 = 0; var1 < field1536.length; ++var1) {
         field1536[var1] = null;
      }

   }

   @ObfuscatedName("r")
   public void method1949(int var1) {
      this.field1510 = var1;

      for(int var2 = 0; var2 < this.field1508; ++var2) {
         for(int var3 = 0; var3 < this.field1532; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("j")
   public void method1950(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.field1797; ++var6) {
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

      this.tiles[0][var1][var2].field1809 = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("b")
   public void method1953(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class92 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class92(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1791 = var21;
      } else if(var4 != 1) {
         class100 var23 = new class100(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1796 = var23;
      } else {
         var21 = new class92(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].field1791 = var21;
      }
   }

   @ObfuscatedName("m")
   public void method1955(int var1, int var2, int var3, int var4, Renderable var5, int var6, Renderable var7, Renderable var8) {
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
         for(int var12 = 0; var12 < var11.field1797; ++var12) {
            if((var11.objects[var12].flags & 256) == 256 && var11.objects[var12].renderable instanceof Model) {
               Model var13 = (Model)var11.objects[var12].renderable;
               var13.method2391();
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
   public void method1957(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      if(var5 != null) {
         DecorativeObject var13 = new DecorativeObject();
         var13.hash = var11;
         var13.field1659 = var12;
         var13.x = var2 * 128 + 64;
         var13.y = var3 * 128 + 64;
         var13.floor = var4;
         var13.renderable1 = var5;
         var13.renderable2 = var6;
         var13.field1655 = var7;
         var13.field1656 = var8;
         var13.field1662 = var9;
         var13.field1658 = var10;

         for(int var14 = var1; var14 >= 0; --var14) {
            if(this.tiles[var14][var2][var3] == null) {
               this.tiles[var14][var2][var3] = new Tile(var14, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].decorativeObject = var13;
      }
   }

   @ObfuscatedName("d")
   public boolean method1958(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
      if(var7 == null) {
         return true;
      } else {
         int var11 = var2 * 128 + 64 * var5;
         int var12 = var3 * 128 + 64 * var6;
         return this.method1961(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
      }
   }

   @ObfuscatedName("l")
   @Export("groundObjectSpawned")
   public void groundObjectSpawned(int var1, int var2, int var3, int var4, Renderable var5, int var6, int var7) {
      if(var5 != null) {
         GroundObject var8 = new GroundObject();
         var8.renderable = var5;
         var8.x = var2 * 128 + 64;
         var8.y = var3 * 128 + 64;
         var8.floor = var4;
         var8.hash = var6;
         var8.field1646 = var7;
         if(this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
         }

         this.tiles[var1][var2][var3].groundObject = var8;
      }
   }

   @ObfuscatedName("q")
   public boolean method1960(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      return var6 == null?true:this.method1961(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("t")
   boolean method1961(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
      int var15;
      for(int var14 = var2; var14 < var2 + var4; ++var14) {
         for(var15 = var3; var15 < var3 + var5; ++var15) {
            if(var14 < 0 || var15 < 0 || var14 >= this.field1508 || var15 >= this.field1532) {
               return false;
            }

            Tile var16 = this.tiles[var1][var14][var15];
            if(var16 != null && var16.field1797 >= 5) {
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

            for(int var22 = var1; var22 >= 0; --var22) {
               if(this.tiles[var22][var15][var21] == null) {
                  this.tiles[var22][var15][var21] = new Tile(var22, var15, var21);
               }
            }

            Tile var18 = this.tiles[var1][var15][var21];
            var18.objects[var18.field1797] = var20;
            var18.field1799[var18.field1797] = var17;
            var18.field1800 |= var17;
            ++var18.field1797;
         }
      }

      if(var11) {
         this.objects[this.field1506++] = var20;
      }

      return true;
   }

   @ObfuscatedName("s")
   void method1963(GameObject var1) {
      for(int var2 = var1.relativeX; var2 <= var1.offsetX; ++var2) {
         for(int var3 = var1.relativeY; var3 <= var1.offsetY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1797; ++var5) {
                  if(var4.objects[var5] == var1) {
                     --var4.field1797;

                     for(int var6 = var5; var6 < var4.field1797; ++var6) {
                        var4.objects[var6] = var4.objects[var6 + 1];
                        var4.field1799[var6] = var4.field1799[var6 + 1];
                     }

                     var4.objects[var4.field1797] = null;
                     break;
                  }
               }

               var4.field1800 = 0;

               for(var5 = 0; var5 < var4.field1797; ++var5) {
                  var4.field1800 |= var4.field1799[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   public void method1964(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         DecorativeObject var6 = var5.decorativeObject;
         if(var6 != null) {
            var6.field1662 = var6.field1662 * var4 / 16;
            var6.field1658 = var6.field1658 * var4 / 16;
         }
      }
   }

   @ObfuscatedName("u")
   public void method1965(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallObject = null;
      }
   }

   @ObfuscatedName("a")
   public void method1966(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.decorativeObject = null;
      }
   }

   @ObfuscatedName("e")
   public void method1967(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1797; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               this.method1963(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("c")
   public void method1968(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.groundObject = null;
      }
   }

   @ObfuscatedName("n")
   public void method1969(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.itemLayer = null;
      }
   }

   @ObfuscatedName("y")
   public WallObject method1970(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallObject;
   }

   @ObfuscatedName("k")
   public DecorativeObject method1971(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.decorativeObject;
   }

   @ObfuscatedName("ac")
   static final int method1973(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ah")
   public int method1974(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallObject != null?var4.wallObject.hash:0;
   }

   @ObfuscatedName("aq")
   public int method1978(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 == null) {
         return -1;
      } else if(var5.wallObject != null && var5.wallObject.hash == var4) {
         return var5.wallObject.field1571 & 255;
      } else if(var5.decorativeObject != null && var5.decorativeObject.hash == var4) {
         return var5.decorativeObject.field1659 & 255;
      } else if(var5.groundObject != null && var5.groundObject.hash == var4) {
         return var5.groundObject.field1646 & 255;
      } else {
         for(int var6 = 0; var6 < var5.field1797; ++var6) {
            if(var5.objects[var6].hash == var4) {
               return var5.objects[var6].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-50"
   )
   public void method1979(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1507; ++var4) {
         for(int var5 = 0; var5 < this.field1508; ++var5) {
            for(int var6 = 0; var6 < this.field1532; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  WallObject var8 = var7.wallObject;
                  ModelData var10;
                  if(var8 != null && var8.renderable1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.renderable1;
                     this.method2092(var9, var4, var5, var6, 1, 1);
                     if(var8.renderable2 instanceof ModelData) {
                        var10 = (ModelData)var8.renderable2;
                        this.method2092(var10, var4, var5, var6, 1, 1);
                        ModelData.method2281(var9, var10, 0, 0, 0, false);
                        var8.renderable2 = var10.method2290(var10.field1784, var10.field1741, var1, var2, var3);
                     }

                     var8.renderable1 = var9.method2290(var9.field1784, var9.field1741, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1797; ++var12) {
                     GameObject var14 = var7.objects[var12];
                     if(var14 != null && var14.renderable instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.renderable;
                        this.method2092(var11, var4, var5, var6, var14.offsetX - var14.relativeX + 1, var14.offsetY - var14.relativeY + 1);
                        var14.renderable = var11.method2290(var11.field1784, var11.field1741, var1, var2, var3);
                     }
                  }

                  GroundObject var13 = var7.groundObject;
                  if(var13 != null && var13.renderable instanceof ModelData) {
                     var10 = (ModelData)var13.renderable;
                     this.method1980(var10, var4, var5, var6);
                     var13.renderable = var10.method2290(var10.field1784, var10.field1741, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("az")
   void method1980(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.field1508) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2281(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field1508) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2281(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field1508 && var4 < this.field1532) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2281(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field1508 && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.groundObject != null && var5.groundObject.renderable instanceof ModelData) {
            var6 = (ModelData)var5.groundObject.renderable;
            ModelData.method2281(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("ao")
   public void method1982(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         class92 var8 = var7.field1791;
         int var10;
         if(var8 != null) {
            int var18 = var8.field1603;
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
            class100 var9 = var7.field1796;
            if(var9 != null) {
               var10 = var9.field1702;
               int var11 = var9.field1699;
               int var12 = var9.field1700;
               int var13 = var9.field1701;
               int[] var14 = this.field1537[var10];
               int[] var15 = this.field1559[var11];
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

   @ObfuscatedName("af")
   public static void method1983(int[] var0, int var1, int var2, int var3, int var4) {
      field1564 = 0;
      field1565 = 0;
      field1547 = var3;
      field1567 = var4;
      field1543 = var3 / 2;
      field1526 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field1550 = class94.field1639[var6];
            field1533 = class94.field1640[var6];
            field1519 = class94.field1639[var7];
            field1557 = class94.field1640[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; ++var10) {
               for(var11 = -26; var11 <= 26; ++var11) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method1984(var12, var0[var8] + var15, var13)) {
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

                  label99:
                  for(var11 = -1; var11 <= 1; ++var11) {
                     for(var12 = -1; var12 <= 1; ++var12) {
                        if(var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label99;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label99;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label99;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
                           var16 = true;
                           break label99;
                        }
                     }
                  }

                  field1560[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   @ObfuscatedName("au")
   static boolean method1984(int var0, int var1, int var2) {
      int var3 = var2 * field1519 + var0 * field1557 >> 16;
      int var4 = var2 * field1557 - var0 * field1519 >> 16;
      int var5 = var1 * field1550 + var4 * field1533 >> 16;
      int var6 = var1 * field1533 - var4 * field1550 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = field1543 + var3 * class94.field1626 / var5;
         int var8 = field1526 + var6 * class94.field1626 / var5;
         return var7 >= field1564 && var7 <= field1547 && var8 >= field1565 && var8 <= field1567;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   public void method1985(int var1, int var2, int var3) {
      field1544 = true;
      field1538 = var1;
      field1539 = var2;
      field1540 = var3;
      field1541 = -1;
      field1542 = -1;
   }

   @ObfuscatedName("at")
   public void method1986(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field1508 * 128) {
         var1 = this.field1508 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field1532 * 128) {
         var3 = this.field1532 * 128 - 1;
      }

      ++field1522;
      field1550 = class94.field1639[var4];
      field1533 = class94.field1640[var4];
      field1519 = class94.field1639[var5];
      field1557 = class94.field1640[var5];
      field1525 = field1560[(var4 - 128) / 32][var5 / 64];
      field1529 = var1;
      field1530 = var2;
      field1531 = var3;
      field1527 = var1 / 128;
      field1528 = var3 / 128;
      field1520 = var6;
      field1523 = field1527 - 25;
      if(field1523 < 0) {
         field1523 = 0;
      }

      field1534 = field1528 - 25;
      if(field1534 < 0) {
         field1534 = 0;
      }

      field1524 = field1527 + 25;
      if(field1524 > this.field1508) {
         field1524 = this.field1508;
      }

      field1535 = field1528 + 25;
      if(field1535 > this.field1532) {
         field1535 = this.field1532;
      }

      this.method1992();
      field1509 = 0;

      int var7;
      Tile[][] var8;
      int var9;
      int var10;
      for(var7 = this.field1510; var7 < this.field1507; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = field1523; var9 < field1524; ++var9) {
            for(var10 = field1534; var10 < field1535; ++var10) {
               Tile var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1801 <= var6 && (field1525[var9 - field1527 + 25][var10 - field1528 + 25] || this.field1521[var7][var9][var10] - var2 >= 2000)) {
                     var11.field1802 = true;
                     var11.field1803 = true;
                     if(var11.field1797 > 0) {
                        var11.field1795 = true;
                     } else {
                        var11.field1795 = false;
                     }

                     ++field1509;
                  } else {
                     var11.field1802 = false;
                     var11.field1803 = false;
                     var11.field1788 = 0;
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
      for(var7 = this.field1510; var7 < this.field1507; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1527 + var9;
            var16 = field1527 - var9;
            if(var10 >= field1523 || var16 < field1524) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field1528 + var12;
                  var14 = field1528 - var12;
                  if(var10 >= field1523) {
                     if(var13 >= field1534) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, true);
                        }
                     }

                     if(var14 < field1535) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, true);
                        }
                     }
                  }

                  if(var16 < field1524) {
                     if(var13 >= field1534) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, true);
                        }
                     }

                     if(var14 < field1535) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, true);
                        }
                     }
                  }

                  if(field1509 == 0) {
                     field1544 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field1510; var7 < this.field1507; ++var7) {
         var8 = this.tiles[var7];

         for(var9 = -25; var9 <= 0; ++var9) {
            var10 = field1527 + var9;
            var16 = field1527 - var9;
            if(var10 >= field1523 || var16 < field1524) {
               for(var12 = -25; var12 <= 0; ++var12) {
                  var13 = field1528 + var12;
                  var14 = field1528 - var12;
                  if(var10 >= field1523) {
                     if(var13 >= field1534) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, false);
                        }
                     }

                     if(var14 < field1535) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, false);
                        }
                     }
                  }

                  if(var16 < field1524) {
                     if(var13 >= field1534) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, false);
                        }
                     }

                     if(var14 < field1535) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1802) {
                           this.method2000(var15, false);
                        }
                     }
                  }

                  if(field1509 == 0) {
                     field1544 = false;
                     return;
                  }
               }
            }
         }
      }

      field1544 = false;
   }

   @ObfuscatedName("i")
   public void method1987(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].field1801 = var4;
      }
   }

   @ObfuscatedName("ad")
   void method1988(class92 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field1529;
      int var11;
      int var12 = var11 = (var8 << 7) - field1531;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field1521[var2][var7][var8] - field1530;
      int var18 = this.field1521[var2][var7 + 1][var8] - field1530;
      int var19 = this.field1521[var2][var7 + 1][var8 + 1] - field1530;
      int var20 = this.field1521[var2][var7][var8 + 1] - field1530;
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
                  int var22 = class94.field1617 + var10 * class94.field1626 / var12;
                  int var23 = class94.field1627 + var17 * class94.field1626 / var12;
                  int var24 = class94.field1617 + var14 * class94.field1626 / var11;
                  int var25 = class94.field1627 + var18 * class94.field1626 / var11;
                  int var26 = class94.field1617 + var13 * class94.field1626 / var16;
                  int var27 = class94.field1627 + var19 * class94.field1626 / var16;
                  int var28 = class94.field1617 + var9 * class94.field1626 / var15;
                  int var29 = class94.field1627 + var21 * class94.field1626 / var15;
                  class94.rasterAlpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class94.rasterClipEnable = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class94.rasterClipX || var28 > class94.rasterClipX || var24 > class94.rasterClipX) {
                        class94.rasterClipEnable = true;
                     }

                     if(field1544 && this.method1991(field1539, field1540, var27, var29, var25, var26, var28, var24)) {
                        field1541 = var7;
                        field1542 = var8;
                     }

                     if(var1.field1601 == -1) {
                        if(var1.field1599 != 12345678) {
                           class94.rasterGouraud(var27, var29, var25, var26, var28, var24, var1.field1599, var1.field1600, var1.field1606);
                        }
                     } else if(!field1562) {
                        if(var1.field1598) {
                           class94.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1599, var1.field1600, var1.field1606, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1601);
                        } else {
                           class94.rasterTexture(var27, var29, var25, var26, var28, var24, var1.field1599, var1.field1600, var1.field1606, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field1601);
                        }
                     } else {
                        var30 = class94.field1636.vmethod2226(var1.field1601);
                        class94.rasterGouraud(var27, var29, var25, var26, var28, var24, method1973(var30, var1.field1599), method1973(var30, var1.field1600), method1973(var30, var1.field1606));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class94.rasterClipEnable = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class94.rasterClipX || var24 > class94.rasterClipX || var28 > class94.rasterClipX) {
                        class94.rasterClipEnable = true;
                     }

                     if(field1544 && this.method1991(field1539, field1540, var23, var25, var29, var22, var24, var28)) {
                        field1541 = var7;
                        field1542 = var8;
                     }

                     if(var1.field1601 == -1) {
                        if(var1.field1602 != 12345678) {
                           class94.rasterGouraud(var23, var25, var29, var22, var24, var28, var1.field1602, var1.field1606, var1.field1600);
                        }
                     } else if(!field1562) {
                        class94.rasterTexture(var23, var25, var29, var22, var24, var28, var1.field1602, var1.field1606, var1.field1600, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1601);
                     } else {
                        var30 = class94.field1636.vmethod2226(var1.field1601);
                        class94.rasterGouraud(var23, var25, var29, var22, var24, var28, method1973(var30, var1.field1602), method1973(var30, var1.field1606), method1973(var30, var1.field1600));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("am")
   void method1989(class100 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1705.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1705[var9] - field1529;
         var11 = var1.field1688[var9] - field1530;
         var12 = var1.field1689[var9] - field1531;
         var13 = var12 * var4 + var10 * var5 >> 16;
         var12 = var12 * var5 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var11 * var3 - var12 * var2 >> 16;
         var12 = var11 * var2 + var12 * var3 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1706 != null) {
            class100.field1704[var9] = var10;
            class100.field1698[var9] = var13;
            class100.field1694[var9] = var12;
         }

         class100.field1687[var9] = class94.field1617 + var10 * class94.field1626 / var12;
         class100.field1703[var9] = class94.field1627 + var13 * class94.field1626 / var12;
      }

      class94.rasterAlpha = 0;
      var8 = var1.field1696.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.field1696[var9];
         var11 = var1.field1693[var9];
         var12 = var1.field1695[var9];
         var13 = class100.field1687[var10];
         int var14 = class100.field1687[var11];
         int var15 = class100.field1687[var12];
         int var16 = class100.field1703[var10];
         int var17 = class100.field1703[var11];
         int var18 = class100.field1703[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class94.rasterClipEnable = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class94.rasterClipX || var14 > class94.rasterClipX || var15 > class94.rasterClipX) {
               class94.rasterClipEnable = true;
            }

            if(field1544 && this.method1991(field1539, field1540, var16, var17, var18, var13, var14, var15)) {
               field1541 = var6;
               field1542 = var7;
            }

            if(var1.field1706 != null && var1.field1706[var9] != -1) {
               if(!field1562) {
                  if(var1.field1697) {
                     class94.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1690[var9], var1.field1691[var9], var1.field1692[var9], class100.field1704[0], class100.field1704[1], class100.field1704[3], class100.field1698[0], class100.field1698[1], class100.field1698[3], class100.field1694[0], class100.field1694[1], class100.field1694[3], var1.field1706[var9]);
                  } else {
                     class94.rasterTexture(var16, var17, var18, var13, var14, var15, var1.field1690[var9], var1.field1691[var9], var1.field1692[var9], class100.field1704[var10], class100.field1704[var11], class100.field1704[var12], class100.field1698[var10], class100.field1698[var11], class100.field1698[var12], class100.field1694[var10], class100.field1694[var11], class100.field1694[var12], var1.field1706[var9]);
                  }
               } else {
                  int var19 = class94.field1636.vmethod2226(var1.field1706[var9]);
                  class94.rasterGouraud(var16, var17, var18, var13, var14, var15, method1973(var19, var1.field1690[var9]), method1973(var19, var1.field1691[var9]), method1973(var19, var1.field1692[var9]));
               }
            } else if(var1.field1690[var9] != 12345678) {
               class94.rasterGouraud(var16, var17, var18, var13, var14, var15, var1.field1690[var9], var1.field1691[var9], var1.field1692[var9]);
            }
         }
      }

   }

   @ObfuscatedName("aw")
   boolean method1991(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ak")
   void method1992() {
      int var1 = field1546[field1520];
      class107[] var2 = field1561[field1520];
      field1512 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         class107 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field1841 == 1) {
            var5 = var4.field1844 - field1527 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1839 - field1528 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1840 - field1528 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(field1525[var5][var6++]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = field1529 - var4.field1842;
                  if(var9 > 32) {
                     var4.field1852 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1852 = 2;
                     var9 = -var9;
                  }

                  var4.field1848 = (var4.field1837 - field1531 << 8) / var9;
                  var4.field1854 = (var4.field1851 - field1531 << 8) / var9;
                  var4.field1853 = (var4.field1846 - field1530 << 8) / var9;
                  var4.field1845 = (var4.field1847 - field1530 << 8) / var9;
                  field1549[field1512++] = var4;
               }
            }
         } else if(var4.field1841 == 2) {
            var5 = var4.field1839 - field1528 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1844 - field1527 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1850 - field1527 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(field1525[var6++][var5]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = field1531 - var4.field1837;
                  if(var9 > 32) {
                     var4.field1852 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1852 = 4;
                     var9 = -var9;
                  }

                  var4.field1849 = (var4.field1842 - field1529 << 8) / var9;
                  var4.field1838 = (var4.field1843 - field1529 << 8) / var9;
                  var4.field1853 = (var4.field1846 - field1530 << 8) / var9;
                  var4.field1845 = (var4.field1847 - field1530 << 8) / var9;
                  field1549[field1512++] = var4;
               }
            }
         } else if(var4.field1841 == 4) {
            var5 = var4.field1846 - field1530;
            if(var5 > 128) {
               var6 = var4.field1839 - field1528 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1840 - field1528 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field1844 - field1527 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field1850 - field1527 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label194:
                  for(int var11 = var8; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(field1525[var11][var12]) {
                           var10 = true;
                           break label194;
                        }
                     }
                  }

                  if(var10) {
                     var4.field1852 = 5;
                     var4.field1849 = (var4.field1842 - field1529 << 8) / var5;
                     var4.field1838 = (var4.field1843 - field1529 << 8) / var5;
                     var4.field1848 = (var4.field1837 - field1531 << 8) / var5;
                     var4.field1854 = (var4.field1851 - field1531 << 8) / var5;
                     field1549[field1512++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ar")
   boolean method1993(int var1, int var2, int var3) {
      int var4 = this.field1515[var1][var2][var3];
      if(var4 == -field1522) {
         return false;
      } else if(var4 == field1522) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method1997(var5 + 1, this.field1521[var1][var2][var3], var6 + 1) && this.method1997(var5 + 128 - 1, this.field1521[var1][var2 + 1][var3], var6 + 1) && this.method1997(var5 + 128 - 1, this.field1521[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method1997(var5 + 1, this.field1521[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field1515[var1][var2][var3] = field1522;
            return true;
         } else {
            this.field1515[var1][var2][var3] = -field1522;
            return false;
         }
      }
   }

   @ObfuscatedName("av")
   boolean method1995(int var1, int var2, int var3, int var4) {
      if(!this.method1993(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method1997(var5 + 1, this.field1521[var1][var2][var3] - var4, var6 + 1) && this.method1997(var5 + 128 - 1, this.field1521[var1][var2 + 1][var3] - var4, var6 + 1) && this.method1997(var5 + 128 - 1, this.field1521[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method1997(var5 + 1, this.field1521[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("aj")
   boolean method1996(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var2 == var3 && var4 == var5) {
         if(!this.method1993(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method1997(var7 + 1, this.field1521[var1][var2][var4] - var6, var8 + 1) && this.method1997(var7 + 128 - 1, this.field1521[var1][var2 + 1][var4] - var6, var8 + 1) && this.method1997(var7 + 128 - 1, this.field1521[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method1997(var7 + 1, this.field1521[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field1515[var1][var7][var8] == -field1522) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field1521[var1][var2][var4] - var6;
         if(!this.method1997(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method1997(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method1997(var7, var9, var11)) {
                  return false;
               } else if(!this.method1997(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("al")
   boolean method1997(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1512; ++var4) {
         class107 var5 = field1549[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field1852 == 1) {
            var6 = var5.field1842 - var1;
            if(var6 > 0) {
               var7 = var5.field1837 + (var5.field1848 * var6 >> 8);
               var8 = var5.field1851 + (var5.field1854 * var6 >> 8);
               var9 = var5.field1846 + (var5.field1853 * var6 >> 8);
               var10 = var5.field1847 + (var5.field1845 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1852 == 2) {
            var6 = var1 - var5.field1842;
            if(var6 > 0) {
               var7 = var5.field1837 + (var5.field1848 * var6 >> 8);
               var8 = var5.field1851 + (var5.field1854 * var6 >> 8);
               var9 = var5.field1846 + (var5.field1853 * var6 >> 8);
               var10 = var5.field1847 + (var5.field1845 * var6 >> 8);
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1852 == 3) {
            var6 = var5.field1837 - var3;
            if(var6 > 0) {
               var7 = var5.field1842 + (var5.field1849 * var6 >> 8);
               var8 = var5.field1843 + (var5.field1838 * var6 >> 8);
               var9 = var5.field1846 + (var5.field1853 * var6 >> 8);
               var10 = var5.field1847 + (var5.field1845 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1852 == 4) {
            var6 = var3 - var5.field1837;
            if(var6 > 0) {
               var7 = var5.field1842 + (var5.field1849 * var6 >> 8);
               var8 = var5.field1843 + (var5.field1838 * var6 >> 8);
               var9 = var5.field1846 + (var5.field1853 * var6 >> 8);
               var10 = var5.field1847 + (var5.field1845 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1852 == 5) {
            var6 = var2 - var5.field1846;
            if(var6 > 0) {
               var7 = var5.field1842 + (var5.field1849 * var6 >> 8);
               var8 = var5.field1843 + (var5.field1838 * var6 >> 8);
               var9 = var5.field1837 + (var5.field1848 * var6 >> 8);
               var10 = var5.field1851 + (var5.field1854 * var6 >> 8);
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   static {
      field1546 = new int[field1545];
      field1561 = new class107[field1545][500];
      field1512 = 0;
      field1549 = new class107[500];
      field1551 = new Deque();
      field1513 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field1552 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field1558 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field1548 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field1555 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field1556 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field1554 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field1560 = new boolean[8][32][51][51];
   }

   @ObfuscatedName("ay")
   void method2000(Tile var1, boolean var2) {
      field1551.method3844(var1);

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
                                    var3 = (Tile)field1551.method3848();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1803);

                                 var4 = var3.x;
                                 var5 = var3.y;
                                 var6 = var3.plane;
                                 var7 = var3.field1790;
                                 var8 = this.tiles[var6];
                                 if(!var3.field1802) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.tiles[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1803) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field1527 && var4 > field1523) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1803 && (var9.field1802 || (var3.field1800 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field1527 && var4 < field1524 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1803 && (var9.field1802 || (var3.field1800 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field1528 && var5 > field1534) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1803 && (var9.field1802 || (var3.field1800 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field1528 && var5 < field1535 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1803 && (var9.field1802 || (var3.field1800 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1802 = false;
                                 if(var3.field1809 != null) {
                                    var9 = var3.field1809;
                                    if(var9.field1791 != null) {
                                       if(!this.method1993(0, var4, var5)) {
                                          this.method1988(var9.field1791, 0, field1550, field1533, field1519, field1557, var4, var5);
                                       }
                                    } else if(var9.field1796 != null && !this.method1993(0, var4, var5)) {
                                       this.method1989(var9.field1796, field1550, field1533, field1519, field1557, var4, var5);
                                    }

                                    var10 = var9.wallObject;
                                    if(var10 != null) {
                                       var10.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var10.x - field1529, var10.floor - field1530, var10.y - field1531, var10.hash);
                                    }

                                    for(var11 = 0; var11 < var9.field1797; ++var11) {
                                       var12 = var9.objects[var11];
                                       if(var12 != null) {
                                          var12.renderable.vmethod2412(var12.orientation, field1550, field1533, field1519, field1557, var12.x - field1529, var12.height - field1530, var12.y - field1531, var12.hash);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1791 != null) {
                                    if(!this.method1993(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1791.field1599 != 12345678 || field1544 && var6 <= field1538) {
                                          this.method1988(var3.field1791, var7, field1550, field1533, field1519, field1557, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1796 != null && !this.method1993(var7, var4, var5)) {
                                    var20 = true;
                                    this.method1989(var3.field1796, field1550, field1533, field1519, field1557, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 WallObject var31 = var3.wallObject;
                                 DecorativeObject var13 = var3.decorativeObject;
                                 if(var31 != null || var13 != null) {
                                    if(field1527 == var4) {
                                       ++var21;
                                    } else if(field1527 < var4) {
                                       var21 += 2;
                                    }

                                    if(field1528 == var5) {
                                       var21 += 3;
                                    } else if(field1528 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field1513[var21];
                                    var3.field1808 = field1558[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field1576 & field1552[var21]) != 0) {
                                       if(var31.field1576 == 16) {
                                          var3.field1788 = 3;
                                          var3.field1798 = field1548[var21];
                                          var3.field1810 = 3 - var3.field1798;
                                       } else if(var31.field1576 == 32) {
                                          var3.field1788 = 6;
                                          var3.field1798 = field1555[var21];
                                          var3.field1810 = 6 - var3.field1798;
                                       } else if(var31.field1576 == 64) {
                                          var3.field1788 = 12;
                                          var3.field1798 = field1556[var21];
                                          var3.field1810 = 12 - var3.field1798;
                                       } else {
                                          var3.field1788 = 9;
                                          var3.field1798 = field1554[var21];
                                          var3.field1810 = 9 - var3.field1798;
                                       }
                                    } else {
                                       var3.field1788 = 0;
                                    }

                                    if((var31.field1576 & var11) != 0 && !this.method2112(var7, var4, var5, var31.field1576)) {
                                       var31.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var31.x - field1529, var31.floor - field1530, var31.y - field1531, var31.hash);
                                    }

                                    if((var31.field1572 & var11) != 0 && !this.method2112(var7, var4, var5, var31.field1572)) {
                                       var31.renderable2.vmethod2412(0, field1550, field1533, field1519, field1557, var31.x - field1529, var31.floor - field1530, var31.y - field1531, var31.hash);
                                    }
                                 }

                                 if(var13 != null && !this.method1995(var7, var4, var5, var13.renderable1.modelHeight)) {
                                    if((var13.field1655 & var11) != 0) {
                                       var13.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var13.x - field1529 + var13.field1662, var13.floor - field1530, var13.y - field1531 + var13.field1658, var13.hash);
                                    } else if(var13.field1655 == 256) {
                                       var14 = var13.x - field1529;
                                       var15 = var13.floor - field1530;
                                       var16 = var13.y - field1531;
                                       var17 = var13.field1656;
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
                                          var13.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var14 + var13.field1662, var15, var16 + var13.field1658, var13.hash);
                                       } else if(var13.renderable2 != null) {
                                          var13.renderable2.vmethod2412(0, field1550, field1533, field1519, field1557, var14, var15, var16, var13.hash);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    GroundObject var22 = var3.groundObject;
                                    if(var22 != null) {
                                       var22.renderable.vmethod2412(0, field1550, field1533, field1519, field1557, var22.x - field1529, var22.floor - field1530, var22.y - field1531, var22.hash);
                                    }

                                    ItemLayer var23 = var3.itemLayer;
                                    if(var23 != null && var23.height == 0) {
                                       if(var23.middle != null) {
                                          var23.middle.vmethod2412(0, field1550, field1533, field1519, field1557, var23.x - field1529, var23.hash - field1530, var23.y - field1531, var23.flags);
                                       }

                                       if(var23.top != null) {
                                          var23.top.vmethod2412(0, field1550, field1533, field1519, field1557, var23.x - field1529, var23.hash - field1530, var23.y - field1531, var23.flags);
                                       }

                                       if(var23.bottom != null) {
                                          var23.bottom.vmethod2412(0, field1550, field1533, field1519, field1557, var23.x - field1529, var23.hash - field1530, var23.y - field1531, var23.flags);
                                       }
                                    }
                                 }

                                 var14 = var3.field1800;
                                 if(var14 != 0) {
                                    if(var4 < field1527 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1803) {
                                          field1551.method3844(var36);
                                       }
                                    }

                                    if(var5 < field1528 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1803) {
                                          field1551.method3844(var36);
                                       }
                                    }

                                    if(var4 > field1527 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1803) {
                                          field1551.method3844(var36);
                                       }
                                    }

                                    if(var5 > field1528 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1803) {
                                          field1551.method3844(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1788 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1797; ++var21) {
                                    if(var3.objects[var21].field1720 != field1522 && (var3.field1799[var21] & var3.field1788) == var3.field1798) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.wallObject;
                                    if(!this.method2112(var7, var4, var5, var10.field1576)) {
                                       var10.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var10.x - field1529, var10.floor - field1530, var10.y - field1531, var10.hash);
                                    }

                                    var3.field1788 = 0;
                                 }
                              }

                              if(!var3.field1795) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1797;
                                 var3.field1795 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; ++var11) {
                                    var12 = var3.objects[var11];
                                    if(var12.field1720 != field1522) {
                                       for(var24 = var12.relativeX; var24 <= var12.offsetX; ++var24) {
                                          for(var14 = var12.relativeY; var14 <= var12.offsetY; ++var14) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1802) {
                                                var3.field1795 = true;
                                                continue label563;
                                             }

                                             if(var36.field1788 != 0) {
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

                                                if((var16 & var36.field1788) == var3.field1810) {
                                                   var3.field1795 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field1536[var21++] = var12;
                                       var24 = field1527 - var12.relativeX;
                                       var14 = var12.offsetX - field1527;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field1528 - var12.relativeY;
                                       var16 = var12.offsetY - field1528;
                                       if(var16 > var15) {
                                          var12.field1711 = var24 + var16;
                                       } else {
                                          var12.field1711 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; ++var24) {
                                       GameObject var35 = field1536[var24];
                                       if(var35.field1720 != field1522) {
                                          if(var35.field1711 > var11) {
                                             var11 = var35.field1711;
                                             var25 = var24;
                                          } else if(var35.field1711 == var11) {
                                             var15 = var35.x - field1529;
                                             var16 = var35.y - field1531;
                                             var17 = field1536[var25].x - field1529;
                                             var18 = field1536[var25].y - field1531;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    GameObject var33 = field1536[var25];
                                    var33.field1720 = field1522;
                                    if(!this.method1996(var7, var33.relativeX, var33.offsetX, var33.relativeY, var33.offsetY, var33.renderable.modelHeight)) {
                                       var33.renderable.vmethod2412(var33.orientation, field1550, field1533, field1519, field1557, var33.x - field1529, var33.height - field1530, var33.y - field1531, var33.hash);
                                    }

                                    for(var14 = var33.relativeX; var14 <= var33.offsetX; ++var14) {
                                       for(var15 = var33.relativeY; var15 <= var33.offsetY; ++var15) {
                                          Tile var26 = var8[var14][var15];
                                          if(var26.field1788 != 0) {
                                             field1551.method3844(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1803) {
                                             field1551.method3844(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1795) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1795 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1803);
                     } while(var3.field1788 != 0);

                     if(var4 > field1527 || var4 <= field1523) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1803);

                  if(var4 < field1527 || var4 >= field1524 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1803);

               if(var5 > field1528 || var5 <= field1534) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1803);

            if(var5 < field1528 || var5 >= field1535 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1803);

         var3.field1803 = false;
         --field1509;
         ItemLayer var32 = var3.itemLayer;
         if(var32 != null && var32.height != 0) {
            if(var32.middle != null) {
               var32.middle.vmethod2412(0, field1550, field1533, field1519, field1557, var32.x - field1529, var32.hash - field1530 - var32.height, var32.y - field1531, var32.flags);
            }

            if(var32.top != null) {
               var32.top.vmethod2412(0, field1550, field1533, field1519, field1557, var32.x - field1529, var32.hash - field1530 - var32.height, var32.y - field1531, var32.flags);
            }

            if(var32.bottom != null) {
               var32.bottom.vmethod2412(0, field1550, field1533, field1519, field1557, var32.x - field1529, var32.hash - field1530 - var32.height, var32.y - field1531, var32.flags);
            }
         }

         if(var3.field1808 != 0) {
            DecorativeObject var29 = var3.decorativeObject;
            if(var29 != null && !this.method1995(var7, var4, var5, var29.renderable1.modelHeight)) {
               if((var29.field1655 & var3.field1808) != 0) {
                  var29.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var29.x - field1529 + var29.field1662, var29.floor - field1530, var29.y - field1531 + var29.field1658, var29.hash);
               } else if(var29.field1655 == 256) {
                  var11 = var29.x - field1529;
                  var25 = var29.floor - field1530;
                  var24 = var29.y - field1531;
                  var14 = var29.field1656;
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
                     var29.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var11 + var29.field1662, var25, var24 + var29.field1658, var29.hash);
                  } else if(var29.renderable2 != null) {
                     var29.renderable2.vmethod2412(0, field1550, field1533, field1519, field1557, var11, var25, var24, var29.hash);
                  }
               }
            }

            WallObject var27 = var3.wallObject;
            if(var27 != null) {
               if((var27.field1572 & var3.field1808) != 0 && !this.method2112(var7, var4, var5, var27.field1572)) {
                  var27.renderable2.vmethod2412(0, field1550, field1533, field1519, field1557, var27.x - field1529, var27.floor - field1530, var27.y - field1531, var27.hash);
               }

               if((var27.field1576 & var3.field1808) != 0 && !this.method2112(var7, var4, var5, var27.field1576)) {
                  var27.renderable1.vmethod2412(0, field1550, field1533, field1519, field1557, var27.x - field1529, var27.floor - field1530, var27.y - field1531, var27.hash);
               }
            }
         }

         Tile var30;
         if(var6 < this.field1507 - 1) {
            var30 = this.tiles[var6 + 1][var4][var5];
            if(var30 != null && var30.field1803) {
               field1551.method3844(var30);
            }
         }

         if(var4 < field1527) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1803) {
               field1551.method3844(var30);
            }
         }

         if(var5 < field1528) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1803) {
               field1551.method3844(var30);
            }
         }

         if(var4 > field1527) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1803) {
               field1551.method3844(var30);
            }
         }

         if(var5 > field1528) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1803) {
               field1551.method3844(var30);
            }
         }
      }
   }

   @ObfuscatedName("p")
   public void method2010(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
      if(var5 != null || var6 != null) {
         WallObject var11 = new WallObject();
         var11.hash = var9;
         var11.field1571 = var10;
         var11.x = var2 * 128 + 64;
         var11.y = var3 * 128 + 64;
         var11.floor = var4;
         var11.renderable1 = var5;
         var11.renderable2 = var6;
         var11.field1576 = var7;
         var11.field1572 = var8;

         for(int var12 = var1; var12 >= 0; --var12) {
            if(this.tiles[var12][var2][var3] == null) {
               this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallObject = var11;
      }
   }

   @ObfuscatedName("ag")
   public int method2014(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.field1797; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6.hash;
            }
         }

         return 0;
      }
   }

   public Region(int var1, int var2, int var3, int[][][] var4) {
      this.field1507 = var1;
      this.field1508 = var2;
      this.field1532 = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field1515 = new int[var1][var2 + 1][var3 + 1];
      this.field1521 = var4;
      this.method1948();
   }

   @ObfuscatedName("o")
   public GroundObject method2037(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject:null;
   }

   @ObfuscatedName("g")
   public void method2073() {
      for(int var1 = 0; var1 < this.field1506; ++var1) {
         GameObject var2 = this.objects[var1];
         this.method1963(var2);
         this.objects[var1] = null;
      }

      this.field1506 = 0;
   }

   @ObfuscatedName("w")
   public GameObject method2084(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1797; ++var5) {
            GameObject var6 = var4.objects[var5];
            if((var6.hash >> 29 & 3) == 2 && var6.relativeX == var2 && var6.relativeY == var3) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ap")
   void method2092(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.field1507) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.field1508) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.field1532 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field1521[var12][var13][var14] + this.field1521[var12][var13 + 1][var14] + this.field1521[var12][var13][var14 + 1] + this.field1521[var12][var13 + 1][var14 + 1]) / 4 - (this.field1521[var2][var3][var4] + this.field1521[var2][var3 + 1][var4] + this.field1521[var2][var3][var4 + 1] + this.field1521[var2][var3 + 1][var4 + 1]) / 4;
                           WallObject var17 = var15.wallObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.renderable1 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable1;
                                 ModelData.method2281(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.renderable2 instanceof ModelData) {
                                 var18 = (ModelData)var17.renderable2;
                                 ModelData.method2281(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.field1797; ++var23) {
                              GameObject var19 = var15.objects[var23];
                              if(var19 != null && var19.renderable instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.renderable;
                                 int var21 = var19.offsetX - var19.relativeX + 1;
                                 int var22 = var19.offsetY - var19.relativeY + 1;
                                 ModelData.method2281(var1, var20, (var19.relativeX - var3) * 128 + (var21 - var5) * 64, var16, (var19.relativeY - var4) * 128 + (var22 - var6) * 64, var7);
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

   @ObfuscatedName("an")
   public int method2096(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.decorativeObject != null?var4.decorativeObject.hash:0;
   }

   @ObfuscatedName("z")
   public static void method2098(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class107 var8 = new class107();
      var8.field1844 = var2 / 128;
      var8.field1850 = var3 / 128;
      var8.field1839 = var4 / 128;
      var8.field1840 = var5 / 128;
      var8.field1841 = var1;
      var8.field1842 = var2;
      var8.field1843 = var3;
      var8.field1837 = var4;
      var8.field1851 = var5;
      var8.field1846 = var6;
      var8.field1847 = var7;
      field1561[var0][field1546[var0]++] = var8;
   }

   @ObfuscatedName("v")
   public boolean method2110(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
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
         return this.method1961(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("as")
   public int method2111(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.groundObject != null?var4.groundObject.hash:0;
   }

   @ObfuscatedName("aa")
   boolean method2112(int var1, int var2, int var3, int var4) {
      if(!this.method1993(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field1521[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field1529) {
                  if(!this.method1997(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1997(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1997(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1997(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field1531) {
                  if(!this.method1997(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1997(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1997(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method1997(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field1529) {
                  if(!this.method1997(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1997(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method1997(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method1997(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field1531) {
                  if(!this.method1997(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method1997(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method1997(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method1997(var5, var9, var6)) {
                  return false;
               }

               if(!this.method1997(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method1997(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method1997(var5, var9, var6 + 128):(var4 == 32?this.method1997(var5 + 128, var9, var6 + 128):(var4 == 64?this.method1997(var5 + 128, var9, var6):(var4 == 128?this.method1997(var5, var9, var6):true))));
      }
   }
}

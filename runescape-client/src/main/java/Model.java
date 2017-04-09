import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("s")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("p")
   int[] field1377;
   @ObfuscatedName("u")
   static Model field1378 = new Model();
   @ObfuscatedName("h")
   static byte[] field1379 = new byte[1];
   @ObfuscatedName("r")
   int field1380 = 0;
   @ObfuscatedName("ap")
   static int[] field1381 = new int[4700];
   @ObfuscatedName("l")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("n")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("m")
   int field1384 = 0;
   @ObfuscatedName("w")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("x")
   byte field1386 = 0;
   @ObfuscatedName("v")
   byte[] field1387;
   @ObfuscatedName("q")
   int[] field1388;
   @ObfuscatedName("d")
   int[] field1389;
   @ObfuscatedName("f")
   static Model field1390 = new Model();
   @ObfuscatedName("a")
   byte[] field1392;
   @ObfuscatedName("au")
   static int[] field1393 = new int[4700];
   @ObfuscatedName("at")
   static int[] field1394 = new int[4700];
   @ObfuscatedName("as")
   static int[] field1395 = new int[2000];
   @ObfuscatedName("an")
   int field1396;
   @ObfuscatedName("b")
   int[] field1397;
   @ObfuscatedName("k")
   int[] field1398;
   @ObfuscatedName("z")
   short[] field1399;
   @ObfuscatedName("c")
   int[][] field1400;
   @ObfuscatedName("g")
   int field1401 = 0;
   @ObfuscatedName("y")
   byte[] field1403;
   @ObfuscatedName("aq")
   int field1404;
   @ObfuscatedName("e")
   int[][] field1405;
   @ObfuscatedName("t")
   int[] field1406;
   @ObfuscatedName("ab")
   int field1407;
   @ObfuscatedName("bk")
   public static int field1408 = 0;
   @ObfuscatedName("am")
   public boolean field1409 = false;
   @ObfuscatedName("ar")
   static boolean[] field1410 = new boolean[4700];
   @ObfuscatedName("ak")
   static int[] field1411 = new int[4700];
   @ObfuscatedName("ai")
   static int[] field1412 = new int[4700];
   @ObfuscatedName("j")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("aj")
   static int[] field1415 = new int[4700];
   @ObfuscatedName("ah")
   int field1416;
   @ObfuscatedName("aa")
   static int[][] field1417 = new int[12][2000];
   @ObfuscatedName("av")
   static int[] field1418 = new int[1600];
   @ObfuscatedName("ao")
   static int[][] field1419 = new int[1600][512];
   @ObfuscatedName("ae")
   static int[] field1420 = new int[12];
   @ObfuscatedName("by")
   public static int field1421 = 0;
   @ObfuscatedName("bq")
   static int[] field1422;
   @ObfuscatedName("al")
   static int[] field1423 = new int[2000];
   @ObfuscatedName("az")
   static int[] field1424 = new int[12];
   @ObfuscatedName("ay")
   static int[] field1425 = new int[10];
   @ObfuscatedName("ac")
   static int[] field1426 = new int[10];
   @ObfuscatedName("af")
   static int[] field1427 = new int[10];
   @ObfuscatedName("bc")
   static int field1428;
   @ObfuscatedName("bh")
   static int field1429;
   @ObfuscatedName("bj")
   static int field1430;
   @ObfuscatedName("br")
   public static boolean field1431 = false;
   @ObfuscatedName("o")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("bu")
   public static int field1433 = 0;
   @ObfuscatedName("i")
   static byte[] field1434 = new byte[1];
   @ObfuscatedName("bl")
   public static int[] field1435 = new int[1000];
   @ObfuscatedName("bv")
   static int[] field1436;
   @ObfuscatedName("bb")
   static int[] field1437;
   @ObfuscatedName("ax")
   static boolean[] field1438 = new boolean[4700];
   @ObfuscatedName("bf")
   static int[] field1439;
   @ObfuscatedName("ag")
   int field1440;

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1380 = 0;
      this.field1384 = 0;
      this.field1401 = 0;
      this.field1386 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1380 += var8.field1380;
            this.field1384 += var8.field1384;
            this.field1401 += var8.field1401;
            if(var8.field1403 != null) {
               var3 = true;
            } else {
               if(this.field1386 == -1) {
                  this.field1386 = var8.field1386;
               }

               if(this.field1386 != var8.field1386) {
                  var3 = true;
               }
            }

            var4 |= var8.field1392 != null;
            var5 |= var8.field1399 != null;
            var6 |= var8.field1387 != null;
         }
      }

      this.verticesX = new int[this.field1380];
      this.verticesY = new int[this.field1380];
      this.verticesZ = new int[this.field1380];
      this.indices1 = new int[this.field1384];
      this.indices2 = new int[this.field1384];
      this.indices3 = new int[this.field1384];
      this.field1388 = new int[this.field1384];
      this.field1389 = new int[this.field1384];
      this.field1377 = new int[this.field1384];
      if(var3) {
         this.field1403 = new byte[this.field1384];
      }

      if(var4) {
         this.field1392 = new byte[this.field1384];
      }

      if(var5) {
         this.field1399 = new short[this.field1384];
      }

      if(var6) {
         this.field1387 = new byte[this.field1384];
      }

      if(this.field1401 > 0) {
         this.field1397 = new int[this.field1401];
         this.field1398 = new int[this.field1401];
         this.field1406 = new int[this.field1401];
      }

      this.field1380 = 0;
      this.field1384 = 0;
      this.field1401 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1384; ++var9) {
               this.indices1[this.field1384] = var8.indices1[var9] + this.field1380;
               this.indices2[this.field1384] = var8.indices2[var9] + this.field1380;
               this.indices3[this.field1384] = var8.indices3[var9] + this.field1380;
               this.field1388[this.field1384] = var8.field1388[var9];
               this.field1389[this.field1384] = var8.field1389[var9];
               this.field1377[this.field1384] = var8.field1377[var9];
               if(var3) {
                  if(var8.field1403 != null) {
                     this.field1403[this.field1384] = var8.field1403[var9];
                  } else {
                     this.field1403[this.field1384] = var8.field1386;
                  }
               }

               if(var4 && var8.field1392 != null) {
                  this.field1392[this.field1384] = var8.field1392[var9];
               }

               if(var5) {
                  if(var8.field1399 != null) {
                     this.field1399[this.field1384] = var8.field1399[var9];
                  } else {
                     this.field1399[this.field1384] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1387 != null && var8.field1387[var9] != -1) {
                     this.field1387[this.field1384] = (byte)(var8.field1387[var9] + this.field1401);
                  } else {
                     this.field1387[this.field1384] = -1;
                  }
               }

               ++this.field1384;
            }

            for(var9 = 0; var9 < var8.field1401; ++var9) {
               this.field1397[this.field1401] = var8.field1397[var9] + this.field1380;
               this.field1398[this.field1401] = var8.field1398[var9] + this.field1380;
               this.field1406[this.field1401] = var8.field1406[var9] + this.field1380;
               ++this.field1401;
            }

            for(var9 = 0; var9 < var8.field1380; ++var9) {
               this.verticesX[this.field1380] = var8.verticesX[var9];
               this.verticesY[this.field1380] = var8.verticesY[var9];
               this.verticesZ[this.field1380] = var8.verticesZ[var9];
               ++this.field1380;
            }
         }
      }

   }

   @ObfuscatedName("f")
   public Model method1583(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1643();
      int var7 = var2 - this.field1416;
      int var8 = var2 + this.field1416;
      int var9 = var4 - this.field1416;
      int var10 = var4 + this.field1416;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            Model var11;
            if(var5) {
               var11 = new Model();
               var11.field1380 = this.field1380;
               var11.field1384 = this.field1384;
               var11.field1401 = this.field1401;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1388 = this.field1388;
               var11.field1389 = this.field1389;
               var11.field1377 = this.field1377;
               var11.field1403 = this.field1403;
               var11.field1392 = this.field1392;
               var11.field1387 = this.field1387;
               var11.field1399 = this.field1399;
               var11.field1386 = this.field1386;
               var11.field1397 = this.field1397;
               var11.field1398 = this.field1398;
               var11.field1406 = this.field1406;
               var11.field1400 = this.field1400;
               var11.field1405 = this.field1405;
               var11.field1409 = this.field1409;
               var11.verticesY = new int[var11.field1380];
            } else {
               var11 = this;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.field1380; ++var12) {
                  var13 = this.verticesX[var12] + var2;
                  var14 = this.verticesZ[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = this.verticesY[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1380; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = this.verticesX[var12] + var2;
                     var15 = this.verticesZ[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = this.verticesY[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1396 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("i")
   public Model method1584(boolean var1) {
      if(!var1 && field1434.length < this.field1384) {
         field1434 = new byte[this.field1384 + 100];
      }

      return this.method1586(var1, field1390, field1434);
   }

   @ObfuscatedName("r")
   public Model method1585(boolean var1) {
      if(!var1 && field1379.length < this.field1384) {
         field1379 = new byte[this.field1384 + 100];
      }

      return this.method1586(var1, field1378, field1379);
   }

   @ObfuscatedName("o")
   Model method1586(boolean var1, Model var2, byte[] var3) {
      var2.field1380 = this.field1380;
      var2.field1384 = this.field1384;
      var2.field1401 = this.field1401;
      if(var2.verticesX == null || var2.verticesX.length < this.field1380) {
         var2.verticesX = new int[this.field1380 + 100];
         var2.verticesY = new int[this.field1380 + 100];
         var2.verticesZ = new int[this.field1380 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1380; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1392 = this.field1392;
      } else {
         var2.field1392 = var3;
         if(this.field1392 == null) {
            for(var4 = 0; var4 < this.field1384; ++var4) {
               var2.field1392[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1384; ++var4) {
               var2.field1392[var4] = this.field1392[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1388 = this.field1388;
      var2.field1389 = this.field1389;
      var2.field1377 = this.field1377;
      var2.field1403 = this.field1403;
      var2.field1387 = this.field1387;
      var2.field1399 = this.field1399;
      var2.field1386 = this.field1386;
      var2.field1397 = this.field1397;
      var2.field1398 = this.field1398;
      var2.field1406 = this.field1406;
      var2.field1400 = this.field1400;
      var2.field1405 = this.field1405;
      var2.field1409 = this.field1409;
      var2.field1396 = 0;
      return var2;
   }

   @ObfuscatedName("bt")
   void vmethod1925(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1418[0] = -1;
      if(this.field1396 != 1) {
         this.method1643();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1416 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1416) * class84.field1461;
         if(var15 / var13 < class84.field1452) {
            int var16 = (var14 + this.field1416) * class84.field1461;
            if(var16 / var13 > class84.field1462) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1416 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1461;
               if(var19 / var13 > class84.field1468) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1461;
                  if(var21 / var13 < class84.field1453) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1401 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1431) {
                        var27 = var11 - var12;
                        if(var27 <= 50) {
                           var27 = 50;
                        }

                        if(var14 > 0) {
                           var15 /= var13;
                           var16 /= var27;
                        } else {
                           var16 /= var13;
                           var15 /= var27;
                        }

                        if(var17 > 0) {
                           var21 /= var13;
                           var19 /= var27;
                        } else {
                           var19 /= var13;
                           var21 /= var27;
                        }

                        var28 = field1408 - class84.field1456;
                        var29 = field1433 - class84.field1455;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1409) {
                              field1435[field1421++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1456;
                     var28 = class84.field1455;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1436[var1];
                        var30 = field1437[var1];
                     }

                     for(int var31 = 0; var31 < this.field1380; ++var31) {
                        int var32 = this.verticesX[var31];
                        int var33 = this.verticesY[var31];
                        int var34 = this.verticesZ[var31];
                        int var35;
                        if(var1 != 0) {
                           var35 = var34 * var29 + var32 * var30 >> 16;
                           var34 = var34 * var30 - var32 * var29 >> 16;
                           var32 = var35;
                        }

                        var32 += var6;
                        var33 += var7;
                        var34 += var8;
                        var35 = var34 * var4 + var32 * var5 >> 16;
                        var34 = var34 * var5 - var32 * var4 >> 16;
                        var32 = var35;
                        var35 = var33 * var3 - var34 * var2 >> 16;
                        var34 = var33 * var2 + var34 * var3 >> 16;
                        field1381[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1411[var31] = var27 + var32 * class84.field1461 / var34;
                           field1412[var31] = var28 + var35 * class84.field1461 / var34;
                        } else {
                           field1411[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1393[var31] = var32;
                           field1415[var31] = var35;
                           field1394[var31] = var34;
                        }
                     }

                     try {
                        this.method1601(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   public void method1588(Frames var1, int var2) {
      if(this.field1400 != null && var2 != -1) {
         Frame var3 = var1.field1595[var2];
         FrameMap var4 = var3.field1342;
         field1428 = 0;
         field1429 = 0;
         field1430 = 0;

         for(int var5 = 0; var5 < var3.field1343; ++var5) {
            int var6 = var3.field1341[var5];
            this.method1661(var4.field1489[var6], var4.field1490[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
         }

         this.field1396 = 0;
      }

   }

   @ObfuscatedName("m")
   public int method1589() {
      this.method1643();
      return this.field1416;
   }

   @ObfuscatedName("v")
   public void method1592(int var1) {
      int var2 = field1436[var1];
      int var3 = field1437[var1];

      for(int var4 = 0; var4 < this.field1380; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("y")
   public void method1594() {
      for(int var1 = 0; var1 < this.field1380; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("a")
   public void method1595() {
      for(int var1 = 0; var1 < this.field1380; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("z")
   public void method1597(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1380; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("g")
   public final void method1599(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1418[0] = -1;
      if(this.field1396 != 2 && this.field1396 != 1) {
         this.method1658();
      }

      int var8 = class84.field1456;
      int var9 = class84.field1455;
      int var10000 = field1436[var1];
      var10000 = field1437[var1];
      int var11 = field1436[var2];
      int var12 = field1437[var2];
      int var13 = field1436[var3];
      int var14 = field1437[var3];
      int var15 = field1436[var4];
      int var16 = field1437[var4];
      int var17 = var6 * var15 + var7 * var16 >> 16;

      for(int var18 = 0; var18 < this.field1380; ++var18) {
         int var19 = this.verticesX[var18];
         int var20 = this.verticesY[var18];
         int var21 = this.verticesZ[var18];
         int var22;
         if(var3 != 0) {
            var22 = var20 * var13 + var19 * var14 >> 16;
            var20 = var20 * var14 - var19 * var13 >> 16;
            var19 = var22;
         }

         if(var2 != 0) {
            var22 = var21 * var11 + var19 * var12 >> 16;
            var21 = var21 * var12 - var19 * var11 >> 16;
            var19 = var22;
         }

         var19 += var5;
         var20 += var6;
         var21 += var7;
         var22 = var20 * var16 - var21 * var15 >> 16;
         var21 = var20 * var15 + var21 * var16 >> 16;
         field1381[var18] = var21 - var17;
         field1411[var18] = var8 + var19 * class84.field1461 / var21;
         field1412[var18] = var9 + var22 * class84.field1461 / var21;
         if(this.field1401 > 0) {
            field1393[var18] = var19;
            field1415[var18] = var22;
            field1394[var18] = var21;
         }
      }

      try {
         this.method1601(false, false, 0);
      } catch (Exception var23) {
         ;
      }

   }

   @ObfuscatedName("b")
   public final void method1600(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1418[0] = -1;
      if(this.field1396 != 2 && this.field1396 != 1) {
         this.method1658();
      }

      int var9 = class84.field1456;
      int var10 = class84.field1455;
      int var10000 = field1436[var1];
      var10000 = field1437[var1];
      int var12 = field1436[var2];
      int var13 = field1437[var2];
      int var14 = field1436[var3];
      int var15 = field1437[var3];
      int var16 = field1436[var4];
      int var17 = field1437[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1380; ++var19) {
         int var20 = this.verticesX[var19];
         int var21 = this.verticesY[var19];
         int var22 = this.verticesZ[var19];
         int var23;
         if(var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if(var2 != 0) {
            var23 = var22 * var12 + var20 * var13 >> 16;
            var22 = var22 * var13 - var20 * var12 >> 16;
            var20 = var23;
         }

         var20 += var5;
         var21 += var6;
         var22 += var7;
         var23 = var21 * var17 - var22 * var16 >> 16;
         var22 = var21 * var16 + var22 * var17 >> 16;
         field1381[var19] = var22 - var18;
         field1411[var19] = var9 + var20 * class84.field1461 / var8;
         field1412[var19] = var10 + var23 * class84.field1461 / var8;
         if(this.field1401 > 0) {
            field1393[var19] = var20;
            field1415[var19] = var23;
            field1394[var19] = var22;
         }
      }

      try {
         this.method1601(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("k")
   final void method1601(boolean var1, boolean var2, int var3) {
      if(this.field1440 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1440; ++var4) {
            field1418[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         for(var4 = 0; var4 < this.field1384; ++var4) {
            if(this.field1377[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1411[var5];
               var9 = field1411[var6];
               var13 = field1411[var7];
               int var14;
               if(!var1 || var8 != -5000 && var9 != -5000 && var13 != -5000) {
                  if(var2 && this.method1604(field1408, field1433, field1412[var5], field1412[var6], field1412[var7], var8, var9, var13)) {
                     field1435[field1421++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1412[var7] - field1412[var6]) - (field1412[var5] - field1412[var6]) * (var13 - var9) > 0) {
                     field1410[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var13 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var13 <= class84.rasterClipX) {
                        field1438[var4] = false;
                     } else {
                        field1438[var4] = true;
                     }

                     var14 = (field1381[var5] + field1381[var6] + field1381[var7]) / 3 + this.field1407;
                     field1419[var14][field1418[var14]++] = var4;
                  }
               } else {
                  var14 = field1393[var5];
                  var10 = field1393[var6];
                  var11 = field1393[var7];
                  int var15 = field1415[var5];
                  var12 = field1415[var6];
                  int var16 = field1415[var7];
                  int var17 = field1394[var5];
                  int var18 = field1394[var6];
                  int var19 = field1394[var7];
                  var14 -= var10;
                  var11 -= var10;
                  var15 -= var12;
                  var16 -= var12;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var15 * var19 - var17 * var16;
                  int var21 = var17 * var11 - var14 * var19;
                  int var22 = var14 * var16 - var15 * var11;
                  if(var10 * var20 + var12 * var21 + var18 * var22 > 0) {
                     field1410[var4] = true;
                     int var23 = (field1381[var5] + field1381[var6] + field1381[var7]) / 3 + this.field1407;
                     field1419[var23][field1418[var23]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1403 == null) {
            for(var4 = this.field1440 - 1; var4 >= 0; --var4) {
               var5 = field1418[var4];
               if(var5 > 0) {
                  var24 = field1419[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1602(var24[var7]);
                  }
               }
            }
         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1420[var4] = 0;
               field1424[var4] = 0;
            }

            for(var4 = this.field1440 - 1; var4 >= 0; --var4) {
               var5 = field1418[var4];
               if(var5 > 0) {
                  var24 = field1419[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1403[var8];
                     var13 = field1420[var25]++;
                     field1417[var25][var13] = var8;
                     if(var25 < 10) {
                        field1424[var25] += var4;
                     } else if(var25 == 10) {
                        field1395[var13] = var4;
                     } else {
                        field1423[var13] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1420[1] > 0 || field1420[2] > 0) {
               var4 = (field1424[1] + field1424[2]) / (field1420[1] + field1420[2]);
            }

            var5 = 0;
            if(field1420[3] > 0 || field1420[4] > 0) {
               var5 = (field1424[3] + field1424[4]) / (field1420[3] + field1420[4]);
            }

            var6 = 0;
            if(field1420[6] > 0 || field1420[8] > 0) {
               var6 = (field1424[6] + field1424[8]) / (field1420[6] + field1420[8]);
            }

            var8 = 0;
            var9 = field1420[10];
            int[] var26 = field1417[10];
            int[] var27 = field1395;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1420[11];
               var26 = field1417[11];
               var27 = field1423;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var10 = 0; var10 < 10; ++var10) {
               while(var10 == 0 && var7 > var4) {
                  this.method1602(var26[var8++]);
                  if(var8 == var9 && var26 != field1417[11]) {
                     var8 = 0;
                     var9 = field1420[11];
                     var26 = field1417[11];
                     var27 = field1423;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var10 == 3 && var7 > var5) {
                  this.method1602(var26[var8++]);
                  if(var8 == var9 && var26 != field1417[11]) {
                     var8 = 0;
                     var9 = field1420[11];
                     var26 = field1417[11];
                     var27 = field1423;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var10 == 5 && var7 > var6) {
                  this.method1602(var26[var8++]);
                  if(var8 == var9 && var26 != field1417[11]) {
                     var8 = 0;
                     var9 = field1420[11];
                     var26 = field1417[11];
                     var27 = field1423;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var11 = field1420[var10];
               int[] var28 = field1417[var10];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.method1602(var28[var12]);
               }
            }

            while(var7 != -1000) {
               this.method1602(var26[var8++]);
               if(var8 == var9 && var26 != field1417[11]) {
                  var8 = 0;
                  var26 = field1417[11];
                  var9 = field1420[11];
                  var27 = field1423;
               }

               if(var8 < var9) {
                  var7 = var27[var8];
               } else {
                  var7 = -1000;
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   final void method1602(int var1) {
      if(field1410[var1]) {
         this.method1603(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1438[var1];
         if(this.field1392 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1392[var1] & 255;
         }

         if(this.field1399 != null && this.field1399[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1387 != null && this.field1387[var1] != -1) {
               int var8 = this.field1387[var1] & 255;
               var5 = this.field1397[var8];
               var6 = this.field1398[var8];
               var7 = this.field1406[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1377[var1] == -1) {
               class84.rasterTextureAffine(field1412[var2], field1412[var3], field1412[var4], field1411[var2], field1411[var3], field1411[var4], this.field1388[var1], this.field1388[var1], this.field1388[var1], field1393[var5], field1393[var6], field1393[var7], field1415[var5], field1415[var6], field1415[var7], field1394[var5], field1394[var6], field1394[var7], this.field1399[var1]);
            } else {
               class84.rasterTextureAffine(field1412[var2], field1412[var3], field1412[var4], field1411[var2], field1411[var3], field1411[var4], this.field1388[var1], this.field1389[var1], this.field1377[var1], field1393[var5], field1393[var6], field1393[var7], field1415[var5], field1415[var6], field1415[var7], field1394[var5], field1394[var6], field1394[var7], this.field1399[var1]);
            }
         } else if(this.field1377[var1] == -1) {
            class84.rasterFlat(field1412[var2], field1412[var3], field1412[var4], field1411[var2], field1411[var3], field1411[var4], field1422[this.field1388[var1]]);
         } else {
            class84.rasterGouraud(field1412[var2], field1412[var3], field1412[var4], field1411[var2], field1411[var3], field1411[var4], this.field1388[var1], this.field1389[var1], this.field1377[var1]);
         }
      }

   }

   @ObfuscatedName("c")
   final void method1603(int var1) {
      int var2 = class84.field1456;
      int var3 = class84.field1455;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1394[var5];
      int var9 = field1394[var6];
      int var10 = field1394[var7];
      if(this.field1392 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1392[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1425[var4] = field1411[var5];
         field1426[var4] = field1412[var5];
         field1427[var4++] = this.field1388[var1];
      } else {
         var11 = field1393[var5];
         var12 = field1415[var5];
         var13 = this.field1388[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1439[var10 - var8];
            field1425[var4] = var2 + (var11 + ((field1393[var7] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var7] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1377[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1439[var9 - var8];
            field1425[var4] = var2 + (var11 + ((field1393[var6] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var6] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1389[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1425[var4] = field1411[var6];
         field1426[var4] = field1412[var6];
         field1427[var4++] = this.field1389[var1];
      } else {
         var11 = field1393[var6];
         var12 = field1415[var6];
         var13 = this.field1389[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1439[var8 - var9];
            field1425[var4] = var2 + (var11 + ((field1393[var5] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var5] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1388[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1439[var10 - var9];
            field1425[var4] = var2 + (var11 + ((field1393[var7] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var7] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1377[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1425[var4] = field1411[var7];
         field1426[var4] = field1412[var7];
         field1427[var4++] = this.field1377[var1];
      } else {
         var11 = field1393[var7];
         var12 = field1415[var7];
         var13 = this.field1377[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1439[var9 - var10];
            field1425[var4] = var2 + (var11 + ((field1393[var6] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var6] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1389[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1439[var8 - var10];
            field1425[var4] = var2 + (var11 + ((field1393[var5] - var11) * var14 >> 16)) * class84.field1461 / 50;
            field1426[var4] = var3 + (var12 + ((field1415[var5] - var12) * var14 >> 16)) * class84.field1461 / 50;
            field1427[var4++] = var13 + ((this.field1388[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1425[0];
      var12 = field1425[1];
      var13 = field1425[2];
      var14 = field1426[0];
      int var15 = field1426[1];
      int var16 = field1426[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1399 != null && this.field1399[var1] != -1) {
            if(this.field1387 != null && this.field1387[var1] != -1) {
               var20 = this.field1387[var1] & 255;
               var17 = this.field1397[var20];
               var18 = this.field1398[var20];
               var19 = this.field1406[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1377[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1388[var1], this.field1388[var1], this.field1388[var1], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], this.field1399[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1427[0], field1427[1], field1427[2], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], this.field1399[var1]);
            }
         } else if(this.field1377[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1422[this.field1388[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1427[0], field1427[1], field1427[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1425[3] < 0 || field1425[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1399 != null && this.field1399[var1] != -1) {
            if(this.field1387 != null && this.field1387[var1] != -1) {
               var20 = this.field1387[var1] & 255;
               var17 = this.field1397[var20];
               var18 = this.field1398[var20];
               var19 = this.field1406[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1399[var1];
            if(this.field1377[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1388[var1], this.field1388[var1], this.field1388[var1], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1426[3], var11, var13, field1425[3], this.field1388[var1], this.field1388[var1], this.field1388[var1], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1427[0], field1427[1], field1427[2], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1426[3], var11, var13, field1425[3], field1427[0], field1427[2], field1427[3], field1393[var17], field1393[var18], field1393[var19], field1415[var17], field1415[var18], field1415[var19], field1394[var17], field1394[var18], field1394[var19], var21);
            }
         } else if(this.field1377[var1] == -1) {
            var17 = field1422[this.field1388[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1426[3], var11, var13, field1425[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1427[0], field1427[1], field1427[2]);
            class84.rasterGouraud(var14, var16, field1426[3], var11, var13, field1425[3], field1427[0], field1427[2], field1427[3]);
         }
      }

   }

   @ObfuscatedName("e")
   final boolean method1604(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("x")
   public void method1614(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1380; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1396 = 0;
   }

   Model() {
   }

   @ObfuscatedName("l")
   public void method1643() {
      if(this.field1396 != 1) {
         this.field1396 = 1;
         super.modelHeight = 0;
         this.field1404 = 0;
         this.field1416 = 0;

         for(int var1 = 0; var1 < this.field1380; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1404) {
               this.field1404 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1416) {
               this.field1416 = var5;
            }
         }

         this.field1416 = (int)(Math.sqrt((double)this.field1416) + 0.99D);
         this.field1407 = (int)(Math.sqrt((double)(this.field1416 * this.field1416 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1440 = this.field1407 + (int)(Math.sqrt((double)(this.field1416 * this.field1416 + this.field1404 * this.field1404)) + 0.99D);
      }

   }

   @ObfuscatedName("j")
   public void method1646(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1595[var2];
            Frame var7 = var3.field1595[var4];
            FrameMap var8 = var6.field1342;
            field1428 = 0;
            field1429 = 0;
            field1430 = 0;
            byte var9 = 0;
            int var10 = var9 + 1;
            int var11 = var5[var9];

            int var12;
            int var13;
            for(var12 = 0; var12 < var6.field1343; ++var12) {
               for(var13 = var6.field1341[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 != var11 || var8.field1489[var13] == 0) {
                  this.method1661(var8.field1489[var13], var8.field1490[var13], var6.translator_x[var12], var6.translator_y[var12], var6.translator_z[var12]);
               }
            }

            field1428 = 0;
            field1429 = 0;
            field1430 = 0;
            var9 = 0;
            var10 = var9 + 1;
            var11 = var5[var9];

            for(var12 = 0; var12 < var7.field1343; ++var12) {
               for(var13 = var7.field1341[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 == var11 || var8.field1489[var13] == 0) {
                  this.method1661(var8.field1489[var13], var8.field1490[var13], var7.translator_x[var12], var7.translator_y[var12], var7.translator_z[var12]);
               }
            }

            this.field1396 = 0;
         } else {
            this.method1588(var1, var2);
         }
      }

   }

   @ObfuscatedName("q")
   public void method1656() {
      for(int var1 = 0; var1 < this.field1380; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("n")
   void method1658() {
      if(this.field1396 != 2) {
         this.field1396 = 2;
         this.field1416 = 0;

         for(int var1 = 0; var1 < this.field1380; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1416) {
               this.field1416 = var5;
            }
         }

         this.field1416 = (int)(Math.sqrt((double)this.field1416) + 0.99D);
         this.field1407 = this.field1416;
         this.field1440 = this.field1416 + this.field1416;
      }

   }

   @ObfuscatedName("s")
   void method1661(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int[] var12;
      if(var1 == 0) {
         var7 = 0;
         field1428 = 0;
         field1429 = 0;
         field1430 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            var11 = var2[var8];
            if(var11 < this.field1400.length) {
               var12 = this.field1400[var11];

               for(var9 = 0; var9 < var12.length; ++var9) {
                  var10 = var12[var9];
                  field1428 += this.verticesX[var10];
                  field1429 += this.verticesY[var10];
                  field1430 += this.verticesZ[var10];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1428 = field1428 / var7 + var3;
            field1429 = field1429 / var7 + var4;
            field1430 = field1430 / var7 + var5;
         } else {
            field1428 = var3;
            field1429 = var4;
            field1430 = var5;
         }
      } else if(var1 == 1) {
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2[var7];
            if(var8 < this.field1400.length) {
               var12 = this.field1400[var8];

               for(var11 = 0; var11 < var12.length; ++var11) {
                  var9 = var12[var11];
                  this.verticesX[var9] += var3;
                  this.verticesY[var9] += var4;
                  this.verticesZ[var9] += var5;
               }
            }
         }
      } else if(var1 == 2) {
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2[var7];
            if(var8 < this.field1400.length) {
               var12 = this.field1400[var8];

               for(var11 = 0; var11 < var12.length; ++var11) {
                  var9 = var12[var11];
                  this.verticesX[var9] -= field1428;
                  this.verticesY[var9] -= field1429;
                  this.verticesZ[var9] -= field1430;
                  var10 = (var3 & 255) * 8;
                  int var13 = (var4 & 255) * 8;
                  int var14 = (var5 & 255) * 8;
                  int var15;
                  int var16;
                  int var17;
                  if(var14 != 0) {
                     var15 = field1436[var14];
                     var16 = field1437[var14];
                     var17 = this.verticesY[var9] * var15 + this.verticesX[var9] * var16 >> 16;
                     this.verticesY[var9] = this.verticesY[var9] * var16 - this.verticesX[var9] * var15 >> 16;
                     this.verticesX[var9] = var17;
                  }

                  if(var10 != 0) {
                     var15 = field1436[var10];
                     var16 = field1437[var10];
                     var17 = this.verticesY[var9] * var16 - this.verticesZ[var9] * var15 >> 16;
                     this.verticesZ[var9] = this.verticesY[var9] * var15 + this.verticesZ[var9] * var16 >> 16;
                     this.verticesY[var9] = var17;
                  }

                  if(var13 != 0) {
                     var15 = field1436[var13];
                     var16 = field1437[var13];
                     var17 = this.verticesZ[var9] * var15 + this.verticesX[var9] * var16 >> 16;
                     this.verticesZ[var9] = this.verticesZ[var9] * var16 - this.verticesX[var9] * var15 >> 16;
                     this.verticesX[var9] = var17;
                  }

                  this.verticesX[var9] += field1428;
                  this.verticesY[var9] += field1429;
                  this.verticesZ[var9] += field1430;
               }
            }
         }
      } else if(var1 == 3) {
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2[var7];
            if(var8 < this.field1400.length) {
               var12 = this.field1400[var8];

               for(var11 = 0; var11 < var12.length; ++var11) {
                  var9 = var12[var11];
                  this.verticesX[var9] -= field1428;
                  this.verticesY[var9] -= field1429;
                  this.verticesZ[var9] -= field1430;
                  this.verticesX[var9] = this.verticesX[var9] * var3 / 128;
                  this.verticesY[var9] = this.verticesY[var9] * var4 / 128;
                  this.verticesZ[var9] = this.verticesZ[var9] * var5 / 128;
                  this.verticesX[var9] += field1428;
                  this.verticesY[var9] += field1429;
                  this.verticesZ[var9] += field1430;
               }
            }
         }
      } else if(var1 == 5 && this.field1405 != null && this.field1392 != null) {
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2[var7];
            if(var8 < this.field1405.length) {
               var12 = this.field1405[var8];

               for(var11 = 0; var11 < var12.length; ++var11) {
                  var9 = var12[var11];
                  var10 = (this.field1392[var9] & 255) + var3 * 8;
                  if(var10 < 0) {
                     var10 = 0;
                  } else if(var10 > 255) {
                     var10 = 255;
                  }

                  this.field1392[var9] = (byte)var10;
               }
            }
         }
      }

   }

   static {
      field1436 = class84.field1475;
      field1437 = class84.field1469;
      field1422 = class84.colorPalette;
      field1439 = class84.field1474;
   }
}

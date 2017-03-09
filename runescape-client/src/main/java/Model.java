import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ar")
   int field1364;
   @ObfuscatedName("u")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("p")
   int[] field1366;
   @ObfuscatedName("d")
   static byte[] field1367 = new byte[1];
   @ObfuscatedName("w")
   int field1368 = 0;
   @ObfuscatedName("h")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("ai")
   static int[][] field1370 = new int[1600][512];
   @ObfuscatedName("af")
   int field1371;
   @ObfuscatedName("c")
   static Model field1372 = new Model();
   @ObfuscatedName("y")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("e")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("ad")
   static int[] field1375 = new int[10];
   @ObfuscatedName("v")
   int[] field1376;
   @ObfuscatedName("n")
   int[] field1377;
   @ObfuscatedName("s")
   int[] field1378;
   @ObfuscatedName("bq")
   static int[] field1379;
   @ObfuscatedName("m")
   byte[] field1380;
   @ObfuscatedName("bd")
   static int field1381;
   @ObfuscatedName("f")
   short[] field1382;
   @ObfuscatedName("b")
   byte field1383 = 0;
   @ObfuscatedName("ak")
   static int[] field1384 = new int[4700];
   @ObfuscatedName("bk")
   static int[] field1385;
   @ObfuscatedName("k")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("t")
   int field1387 = 0;
   @ObfuscatedName("a")
   int[][] field1388;
   @ObfuscatedName("o")
   int[][] field1389;
   @ObfuscatedName("an")
   public boolean field1390 = false;
   @ObfuscatedName("aq")
   static int[] field1391 = new int[4700];
   @ObfuscatedName("aa")
   int field1392;
   @ObfuscatedName("ax")
   int field1394;
   @ObfuscatedName("ah")
   int field1395;
   @ObfuscatedName("bp")
   static int[] field1396;
   @ObfuscatedName("at")
   static boolean[] field1397 = new boolean[4700];
   @ObfuscatedName("ab")
   static boolean[] field1398 = new boolean[4700];
   @ObfuscatedName("ae")
   static int[] field1399 = new int[4700];
   @ObfuscatedName("ao")
   static int[] field1400 = new int[4700];
   @ObfuscatedName("am")
   static int[] field1401 = new int[4700];
   @ObfuscatedName("i")
   byte[] field1402;
   @ObfuscatedName("ay")
   static int[] field1403 = new int[4700];
   @ObfuscatedName("ac")
   static int[] field1404 = new int[12];
   @ObfuscatedName("q")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("ap")
   static int[] field1406 = new int[1600];
   @ObfuscatedName("be")
   static int[] field1407;
   @ObfuscatedName("j")
   static byte[] field1408 = new byte[1];
   @ObfuscatedName("as")
   static int[] field1410 = new int[2000];
   @ObfuscatedName("al")
   static int[] field1411 = new int[2000];
   @ObfuscatedName("ag")
   static int[] field1412 = new int[12];
   @ObfuscatedName("aw")
   static int[] field1413 = new int[10];
   @ObfuscatedName("r")
   byte[] field1414;
   @ObfuscatedName("au")
   static int[] field1415 = new int[10];
   @ObfuscatedName("bj")
   static int field1416;
   @ObfuscatedName("av")
   static int[][] field1417 = new int[12][2000];
   @ObfuscatedName("bb")
   static int field1418;
   @ObfuscatedName("bt")
   public static boolean field1419 = false;
   @ObfuscatedName("bl")
   public static int field1420 = 0;
   @ObfuscatedName("bv")
   public static int field1421 = 0;
   @ObfuscatedName("bm")
   public static int field1422 = 0;
   @ObfuscatedName("bc")
   public static int[] field1423 = new int[1000];
   @ObfuscatedName("l")
   int[] field1424;
   @ObfuscatedName("x")
   static Model field1425 = new Model();
   @ObfuscatedName("z")
   int[] field1426;
   @ObfuscatedName("g")
   int field1427 = 0;

   @ObfuscatedName("cb")
   void vmethod1948(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1406[0] = -1;
      if(this.field1364 != 1) {
         this.method1617();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1371 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1371) * class84.field1447;
         if(var15 / var13 < class84.field1444) {
            int var16 = (var14 + this.field1371) * class84.field1447;
            if(var16 / var13 > class84.field1452) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1371 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1447;
               if(var19 / var13 > class84.field1454) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1447;
                  if(var21 / var13 < class84.field1455) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1387 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1419) {
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

                        var28 = field1420 - class84.field1451;
                        var29 = field1421 - class84.field1460;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1390) {
                              field1423[field1422++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1451;
                     var28 = class84.field1460;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1407[var1];
                        var30 = field1385[var1];
                     }

                     for(int var31 = 0; var31 < this.field1368; ++var31) {
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
                        field1401[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1399[var31] = var27 + var32 * class84.field1447 / var34;
                           field1400[var31] = var28 + var35 * class84.field1447 / var34;
                        } else {
                           field1399[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1384[var31] = var32;
                           field1403[var31] = var35;
                           field1391[var31] = var34;
                        }
                     }

                     try {
                        this.method1632(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   public Model method1613(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1617();
      int var7 = var2 - this.field1371;
      int var8 = var2 + this.field1371;
      int var9 = var4 - this.field1371;
      int var10 = var4 + this.field1371;
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
               var11.field1368 = this.field1368;
               var11.field1427 = this.field1427;
               var11.field1387 = this.field1387;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1376 = this.field1376;
               var11.field1424 = this.field1424;
               var11.field1378 = this.field1378;
               var11.field1414 = this.field1414;
               var11.field1380 = this.field1380;
               var11.field1402 = this.field1402;
               var11.field1382 = this.field1382;
               var11.field1383 = this.field1383;
               var11.field1426 = this.field1426;
               var11.field1366 = this.field1366;
               var11.field1377 = this.field1377;
               var11.field1388 = this.field1388;
               var11.field1389 = this.field1389;
               var11.field1390 = this.field1390;
               var11.verticesY = new int[var11.field1368];
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
               for(var12 = 0; var12 < var11.field1368; ++var12) {
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
               for(var12 = 0; var12 < var11.field1368; ++var12) {
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

            var11.field1364 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("j")
   public Model method1614(boolean var1) {
      if(!var1 && field1408.length < this.field1427) {
         field1408 = new byte[this.field1427 + 100];
      }

      return this.method1616(var1, field1425, field1408);
   }

   @ObfuscatedName("d")
   public Model method1615(boolean var1) {
      if(!var1 && field1367.length < this.field1427) {
         field1367 = new byte[this.field1427 + 100];
      }

      return this.method1616(var1, field1372, field1367);
   }

   @ObfuscatedName("w")
   Model method1616(boolean var1, Model var2, byte[] var3) {
      var2.field1368 = this.field1368;
      var2.field1427 = this.field1427;
      var2.field1387 = this.field1387;
      if(var2.verticesX == null || var2.verticesX.length < this.field1368) {
         var2.verticesX = new int[this.field1368 + 100];
         var2.verticesY = new int[this.field1368 + 100];
         var2.verticesZ = new int[this.field1368 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1368; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1380 = this.field1380;
      } else {
         var2.field1380 = var3;
         if(this.field1380 == null) {
            for(var4 = 0; var4 < this.field1427; ++var4) {
               var2.field1380[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1427; ++var4) {
               var2.field1380[var4] = this.field1380[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1376 = this.field1376;
      var2.field1424 = this.field1424;
      var2.field1378 = this.field1378;
      var2.field1414 = this.field1414;
      var2.field1402 = this.field1402;
      var2.field1382 = this.field1382;
      var2.field1383 = this.field1383;
      var2.field1426 = this.field1426;
      var2.field1366 = this.field1366;
      var2.field1377 = this.field1377;
      var2.field1388 = this.field1388;
      var2.field1389 = this.field1389;
      var2.field1390 = this.field1390;
      var2.field1364 = 0;
      return var2;
   }

   @ObfuscatedName("u")
   public void method1617() {
      if(this.field1364 != 1) {
         this.field1364 = 1;
         super.modelHeight = 0;
         this.field1392 = 0;
         this.field1371 = 0;

         for(int var1 = 0; var1 < this.field1368; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1392) {
               this.field1392 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1371) {
               this.field1371 = var5;
            }
         }

         this.field1371 = (int)(Math.sqrt((double)this.field1371) + 0.99D);
         this.field1395 = (int)(Math.sqrt((double)(this.field1371 * this.field1371 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1394 = this.field1395 + (int)(Math.sqrt((double)(this.field1371 * this.field1371 + this.field1392 * this.field1392)) + 0.99D);
      }
   }

   @ObfuscatedName("y")
   void method1618() {
      if(this.field1364 != 2) {
         this.field1364 = 2;
         this.field1371 = 0;

         for(int var1 = 0; var1 < this.field1368; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1371) {
               this.field1371 = var5;
            }
         }

         this.field1371 = (int)(Math.sqrt((double)this.field1371) + 0.99D);
         this.field1395 = this.field1371;
         this.field1394 = this.field1371 + this.field1371;
      }
   }

   @ObfuscatedName("e")
   public int method1619() {
      this.method1617();
      return this.field1371;
   }

   @ObfuscatedName("v")
   public void method1621(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1580[var2];
            Frame var7 = var3.field1580[var4];
            FrameMap var8 = var6.field1331;
            field1416 = 0;
            field1381 = 0;
            field1418 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1332; ++var11) {
               for(var12 = var6.field1333[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1478[var12] == 0) {
                  this.method1622(var8.field1478[var12], var8.field1479[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1416 = 0;
            field1381 = 0;
            field1418 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1332; ++var11) {
               for(var12 = var7.field1333[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1478[var12] == 0) {
                  this.method1622(var8.field1478[var12], var8.field1479[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1364 = 0;
         } else {
            this.method1631(var1, var2);
         }
      }
   }

   @ObfuscatedName("l")
   void method1622(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1416 = 0;
         field1381 = 0;
         field1418 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1388.length) {
               int[] var10 = this.field1388[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1416 += this.verticesX[var12];
                  field1381 += this.verticesY[var12];
                  field1418 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1416 = field1416 / var7 + var3;
            field1381 = field1381 / var7 + var4;
            field1418 = field1418 / var7 + var5;
         } else {
            field1416 = var3;
            field1381 = var4;
            field1418 = var5;
         }

      } else {
         int var18;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1388.length) {
                  var19 = this.field1388[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1388.length) {
                  var19 = this.field1388[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] -= field1416;
                     this.verticesY[var11] -= field1381;
                     this.verticesZ[var11] -= field1418;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1407[var14];
                        var16 = field1385[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1407[var12];
                        var16 = field1385[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1407[var13];
                        var16 = field1385[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1416;
                     this.verticesY[var11] += field1381;
                     this.verticesZ[var11] += field1418;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1388.length) {
                  var19 = this.field1388[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] -= field1416;
                     this.verticesY[var11] -= field1381;
                     this.verticesZ[var11] -= field1418;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1416;
                     this.verticesY[var11] += field1381;
                     this.verticesZ[var11] += field1418;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1389 != null && this.field1380 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1389.length) {
                     var19 = this.field1389[var8];

                     for(var18 = 0; var18 < var19.length; ++var18) {
                        var11 = var19[var18];
                        var12 = (this.field1380[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1380[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public void method1624() {
      for(int var1 = 0; var1 < this.field1368; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1364 = 0;
   }

   @ObfuscatedName("z")
   public void method1626(int var1) {
      int var2 = field1407[var1];
      int var3 = field1385[var1];

      for(int var4 = 0; var4 < this.field1368; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1364 = 0;
   }

   @ObfuscatedName("n")
   public void method1627(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1368; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1364 = 0;
   }

   @ObfuscatedName("a")
   public final void method1629(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1406[0] = -1;
      if(this.field1364 != 2 && this.field1364 != 1) {
         this.method1618();
      }

      int var8 = class84.field1451;
      int var9 = class84.field1460;
      int var10000 = field1407[var1];
      var10000 = field1385[var1];
      int var12 = field1407[var2];
      int var13 = field1385[var2];
      int var14 = field1407[var3];
      int var15 = field1385[var3];
      int var16 = field1407[var4];
      int var17 = field1385[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1368; ++var19) {
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
         field1401[var19] = var22 - var18;
         field1399[var19] = var8 + var20 * class84.field1447 / var22;
         field1400[var19] = var9 + var23 * class84.field1447 / var22;
         if(this.field1387 > 0) {
            field1384[var19] = var20;
            field1403[var19] = var23;
            field1391[var19] = var22;
         }
      }

      try {
         this.method1632(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("p")
   public void method1630(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1368; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1364 = 0;
   }

   @ObfuscatedName("q")
   public void method1631(Frames var1, int var2) {
      if(this.field1388 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1580[var2];
            FrameMap var4 = var3.field1331;
            field1416 = 0;
            field1381 = 0;
            field1418 = 0;

            for(int var5 = 0; var5 < var3.field1332; ++var5) {
               int var6 = var3.field1333[var5];
               this.method1622(var4.field1478[var6], var4.field1479[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1364 = 0;
         }
      }
   }

   @ObfuscatedName("an")
   final void method1632(boolean var1, boolean var2, int var3) {
      if(this.field1394 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1394; ++var4) {
            field1406[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var12;
         int var13;
         int var15;
         for(var4 = 0; var4 < this.field1427; ++var4) {
            if(this.field1378[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1399[var5];
               var9 = field1399[var6];
               var10 = field1399[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method1650(field1420, field1421, field1400[var5], field1400[var6], field1400[var7], var8, var9, var10)) {
                     field1423[field1422++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1400[var7] - field1400[var6]) - (field1400[var5] - field1400[var6]) * (var10 - var9) > 0) {
                     field1398[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1397[var4] = false;
                     } else {
                        field1397[var4] = true;
                     }

                     var11 = (field1401[var5] + field1401[var6] + field1401[var7]) / 3 + this.field1395;
                     field1370[var11][field1406[var11]++] = var4;
                  }
               } else {
                  var11 = field1384[var5];
                  var12 = field1384[var6];
                  var13 = field1384[var7];
                  int var24 = field1403[var5];
                  var15 = field1403[var6];
                  int var16 = field1403[var7];
                  int var17 = field1391[var5];
                  int var18 = field1391[var6];
                  int var19 = field1391[var7];
                  var11 -= var12;
                  var13 -= var12;
                  var24 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var24 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var11 * var19;
                  int var22 = var11 * var16 - var24 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1398[var4] = true;
                     int var23 = (field1401[var5] + field1401[var6] + field1401[var7]) / 3 + this.field1395;
                     field1370[var23][field1406[var23]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1414 == null) {
            for(var4 = this.field1394 - 1; var4 >= 0; --var4) {
               var5 = field1406[var4];
               if(var5 > 0) {
                  var26 = field1370[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1633(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1404[var4] = 0;
               field1412[var4] = 0;
            }

            for(var4 = this.field1394 - 1; var4 >= 0; --var4) {
               var5 = field1406[var4];
               if(var5 > 0) {
                  var26 = field1370[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1414[var8];
                     var10 = field1404[var28]++;
                     field1417[var28][var10] = var8;
                     if(var28 < 10) {
                        field1412[var28] += var4;
                     } else if(var28 == 10) {
                        field1410[var10] = var4;
                     } else {
                        field1411[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1404[1] > 0 || field1404[2] > 0) {
               var4 = (field1412[1] + field1412[2]) / (field1404[1] + field1404[2]);
            }

            var5 = 0;
            if(field1404[3] > 0 || field1404[4] > 0) {
               var5 = (field1412[3] + field1412[4]) / (field1404[3] + field1404[4]);
            }

            var6 = 0;
            if(field1404[6] > 0 || field1404[8] > 0) {
               var6 = (field1412[6] + field1412[8]) / (field1404[6] + field1404[8]);
            }

            var8 = 0;
            var9 = field1404[10];
            int[] var25 = field1417[10];
            int[] var27 = field1410;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1404[11];
               var25 = field1417[11];
               var27 = field1411;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1633(var25[var8++]);
                  if(var8 == var9 && var25 != field1417[11]) {
                     var8 = 0;
                     var9 = field1404[11];
                     var25 = field1417[11];
                     var27 = field1411;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1633(var25[var8++]);
                  if(var8 == var9 && var25 != field1417[11]) {
                     var8 = 0;
                     var9 = field1404[11];
                     var25 = field1417[11];
                     var27 = field1411;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1633(var25[var8++]);
                  if(var8 == var9 && var25 != field1417[11]) {
                     var8 = 0;
                     var9 = field1404[11];
                     var25 = field1417[11];
                     var27 = field1411;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1404[var12];
               int[] var14 = field1417[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1633(var14[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1633(var25[var8++]);
               if(var8 == var9 && var25 != field1417[11]) {
                  var8 = 0;
                  var25 = field1417[11];
                  var9 = field1404[11];
                  var27 = field1411;
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

   @ObfuscatedName("ar")
   final void method1633(int var1) {
      if(field1398[var1]) {
         this.method1634(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1397[var1];
         if(this.field1380 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1380[var1] & 255;
         }

         if(this.field1382 != null && this.field1382[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1402 != null && this.field1402[var1] != -1) {
               int var8 = this.field1402[var1] & 255;
               var5 = this.field1426[var8];
               var6 = this.field1366[var8];
               var7 = this.field1377[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1378[var1] == -1) {
               class84.rasterTextureAffine(field1400[var2], field1400[var3], field1400[var4], field1399[var2], field1399[var3], field1399[var4], this.field1376[var1], this.field1376[var1], this.field1376[var1], field1384[var5], field1384[var6], field1384[var7], field1403[var5], field1403[var6], field1403[var7], field1391[var5], field1391[var6], field1391[var7], this.field1382[var1]);
            } else {
               class84.rasterTextureAffine(field1400[var2], field1400[var3], field1400[var4], field1399[var2], field1399[var3], field1399[var4], this.field1376[var1], this.field1424[var1], this.field1378[var1], field1384[var5], field1384[var6], field1384[var7], field1403[var5], field1403[var6], field1403[var7], field1391[var5], field1391[var6], field1391[var7], this.field1382[var1]);
            }
         } else if(this.field1378[var1] == -1) {
            class84.rasterFlat(field1400[var2], field1400[var3], field1400[var4], field1399[var2], field1399[var3], field1399[var4], field1379[this.field1376[var1]]);
         } else {
            class84.rasterGouraud(field1400[var2], field1400[var3], field1400[var4], field1399[var2], field1399[var3], field1399[var4], this.field1376[var1], this.field1424[var1], this.field1378[var1]);
         }

      }
   }

   @ObfuscatedName("aa")
   final void method1634(int var1) {
      int var2 = class84.field1451;
      int var3 = class84.field1460;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1391[var5];
      int var9 = field1391[var6];
      int var10 = field1391[var7];
      if(this.field1380 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1380[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1413[var4] = field1399[var5];
         field1375[var4] = field1400[var5];
         field1415[var4++] = this.field1376[var1];
      } else {
         var11 = field1384[var5];
         var12 = field1403[var5];
         var13 = this.field1376[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1396[var10 - var8];
            field1413[var4] = var2 + (var11 + ((field1384[var7] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var7] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1378[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1396[var9 - var8];
            field1413[var4] = var2 + (var11 + ((field1384[var6] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var6] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1424[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1413[var4] = field1399[var6];
         field1375[var4] = field1400[var6];
         field1415[var4++] = this.field1424[var1];
      } else {
         var11 = field1384[var6];
         var12 = field1403[var6];
         var13 = this.field1424[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1396[var8 - var9];
            field1413[var4] = var2 + (var11 + ((field1384[var5] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var5] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1376[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1396[var10 - var9];
            field1413[var4] = var2 + (var11 + ((field1384[var7] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var7] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1378[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1413[var4] = field1399[var7];
         field1375[var4] = field1400[var7];
         field1415[var4++] = this.field1378[var1];
      } else {
         var11 = field1384[var7];
         var12 = field1403[var7];
         var13 = this.field1378[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1396[var9 - var10];
            field1413[var4] = var2 + (var11 + ((field1384[var6] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var6] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1424[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1396[var8 - var10];
            field1413[var4] = var2 + (var11 + ((field1384[var5] - var11) * var14 >> 16)) * class84.field1447 / 50;
            field1375[var4] = var3 + (var12 + ((field1403[var5] - var12) * var14 >> 16)) * class84.field1447 / 50;
            field1415[var4++] = var13 + ((this.field1376[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1413[0];
      var12 = field1413[1];
      var13 = field1413[2];
      var14 = field1375[0];
      int var15 = field1375[1];
      int var16 = field1375[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1382 != null && this.field1382[var1] != -1) {
            if(this.field1402 != null && this.field1402[var1] != -1) {
               var20 = this.field1402[var1] & 255;
               var17 = this.field1426[var20];
               var18 = this.field1366[var20];
               var19 = this.field1377[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1378[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1376[var1], this.field1376[var1], this.field1376[var1], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], this.field1382[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1415[0], field1415[1], field1415[2], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], this.field1382[var1]);
            }
         } else if(this.field1378[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1379[this.field1376[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1415[0], field1415[1], field1415[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1413[3] < 0 || field1413[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1382 != null && this.field1382[var1] != -1) {
            if(this.field1402 != null && this.field1402[var1] != -1) {
               var20 = this.field1402[var1] & 255;
               var17 = this.field1426[var20];
               var18 = this.field1366[var20];
               var19 = this.field1377[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1382[var1];
            if(this.field1378[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1376[var1], this.field1376[var1], this.field1376[var1], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1375[3], var11, var13, field1413[3], this.field1376[var1], this.field1376[var1], this.field1376[var1], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1415[0], field1415[1], field1415[2], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1375[3], var11, var13, field1413[3], field1415[0], field1415[2], field1415[3], field1384[var17], field1384[var18], field1384[var19], field1403[var17], field1403[var18], field1403[var19], field1391[var17], field1391[var18], field1391[var19], var21);
            }
         } else if(this.field1378[var1] == -1) {
            var17 = field1379[this.field1376[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1375[3], var11, var13, field1413[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1415[0], field1415[1], field1415[2]);
            class84.rasterGouraud(var14, var16, field1375[3], var11, var13, field1413[3], field1415[0], field1415[2], field1415[3]);
         }
      }

   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1368 = 0;
      this.field1427 = 0;
      this.field1387 = 0;
      this.field1383 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1368 += var8.field1368;
            this.field1427 += var8.field1427;
            this.field1387 += var8.field1387;
            if(var8.field1414 != null) {
               var3 = true;
            } else {
               if(this.field1383 == -1) {
                  this.field1383 = var8.field1383;
               }

               if(this.field1383 != var8.field1383) {
                  var3 = true;
               }
            }

            var4 |= var8.field1380 != null;
            var5 |= var8.field1382 != null;
            var6 |= var8.field1402 != null;
         }
      }

      this.verticesX = new int[this.field1368];
      this.verticesY = new int[this.field1368];
      this.verticesZ = new int[this.field1368];
      this.indices1 = new int[this.field1427];
      this.indices2 = new int[this.field1427];
      this.indices3 = new int[this.field1427];
      this.field1376 = new int[this.field1427];
      this.field1424 = new int[this.field1427];
      this.field1378 = new int[this.field1427];
      if(var3) {
         this.field1414 = new byte[this.field1427];
      }

      if(var4) {
         this.field1380 = new byte[this.field1427];
      }

      if(var5) {
         this.field1382 = new short[this.field1427];
      }

      if(var6) {
         this.field1402 = new byte[this.field1427];
      }

      if(this.field1387 > 0) {
         this.field1426 = new int[this.field1387];
         this.field1366 = new int[this.field1387];
         this.field1377 = new int[this.field1387];
      }

      this.field1368 = 0;
      this.field1427 = 0;
      this.field1387 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1427; ++var9) {
               this.indices1[this.field1427] = var8.indices1[var9] + this.field1368;
               this.indices2[this.field1427] = var8.indices2[var9] + this.field1368;
               this.indices3[this.field1427] = var8.indices3[var9] + this.field1368;
               this.field1376[this.field1427] = var8.field1376[var9];
               this.field1424[this.field1427] = var8.field1424[var9];
               this.field1378[this.field1427] = var8.field1378[var9];
               if(var3) {
                  if(var8.field1414 != null) {
                     this.field1414[this.field1427] = var8.field1414[var9];
                  } else {
                     this.field1414[this.field1427] = var8.field1383;
                  }
               }

               if(var4 && var8.field1380 != null) {
                  this.field1380[this.field1427] = var8.field1380[var9];
               }

               if(var5) {
                  if(var8.field1382 != null) {
                     this.field1382[this.field1427] = var8.field1382[var9];
                  } else {
                     this.field1382[this.field1427] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1402 != null && var8.field1402[var9] != -1) {
                     this.field1402[this.field1427] = (byte)(var8.field1402[var9] + this.field1387);
                  } else {
                     this.field1402[this.field1427] = -1;
                  }
               }

               ++this.field1427;
            }

            for(var9 = 0; var9 < var8.field1387; ++var9) {
               this.field1426[this.field1387] = var8.field1426[var9] + this.field1368;
               this.field1366[this.field1387] = var8.field1366[var9] + this.field1368;
               this.field1377[this.field1387] = var8.field1377[var9] + this.field1368;
               ++this.field1387;
            }

            for(var9 = 0; var9 < var8.field1368; ++var9) {
               this.verticesX[this.field1368] = var8.verticesX[var9];
               this.verticesY[this.field1368] = var8.verticesY[var9];
               this.verticesZ[this.field1368] = var8.verticesZ[var9];
               ++this.field1368;
            }
         }
      }

   }

   @ObfuscatedName("t")
   public void method1635() {
      for(int var1 = 0; var1 < this.field1368; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1364 = 0;
   }

   Model() {
   }

   @ObfuscatedName("s")
   public void method1647() {
      for(int var1 = 0; var1 < this.field1368; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1364 = 0;
   }

   @ObfuscatedName("af")
   final boolean method1650(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1407 = class84.field1441;
      field1385 = class84.field1462;
      field1379 = class84.colorPalette;
      field1396 = class84.field1453;
   }

   @ObfuscatedName("o")
   public final void method1689(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1406[0] = -1;
      if(this.field1364 != 2 && this.field1364 != 1) {
         this.method1618();
      }

      int var9 = class84.field1451;
      int var10 = class84.field1460;
      int var10000 = field1407[var1];
      var10000 = field1385[var1];
      int var13 = field1407[var2];
      int var14 = field1385[var2];
      int var15 = field1407[var3];
      int var16 = field1385[var3];
      int var17 = field1407[var4];
      int var18 = field1385[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1368; ++var20) {
         int var21 = this.verticesX[var20];
         int var22 = this.verticesY[var20];
         int var23 = this.verticesZ[var20];
         int var24;
         if(var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if(var2 != 0) {
            var24 = var23 * var13 + var21 * var14 >> 16;
            var23 = var23 * var14 - var21 * var13 >> 16;
            var21 = var24;
         }

         var21 += var5;
         var22 += var6;
         var23 += var7;
         var24 = var22 * var18 - var23 * var17 >> 16;
         var23 = var22 * var17 + var23 * var18 >> 16;
         field1401[var20] = var23 - var19;
         field1399[var20] = var9 + var21 * class84.field1447 / var8;
         field1400[var20] = var10 + var24 * class84.field1447 / var8;
         if(this.field1387 > 0) {
            field1384[var20] = var21;
            field1403[var20] = var24;
            field1391[var20] = var23;
         }
      }

      try {
         this.method1632(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }
}

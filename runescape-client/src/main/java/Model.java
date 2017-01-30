import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("h")
   int[] field1354;
   @ObfuscatedName("g")
   static byte[] field1355 = new byte[1];
   @ObfuscatedName("x")
   static Model field1356 = new Model();
   @ObfuscatedName("q")
   static byte[] field1357 = new byte[1];
   @ObfuscatedName("d")
   int field1358 = 0;
   @ObfuscatedName("k")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("bu")
   static int field1360;
   @ObfuscatedName("s")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("a")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("bl")
   public static int field1363 = 0;
   @ObfuscatedName("p")
   static Model field1364 = new Model();
   @ObfuscatedName("m")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("o")
   int field1366 = 0;
   @ObfuscatedName("r")
   int[] field1367;
   @ObfuscatedName("be")
   static int field1368;
   @ObfuscatedName("u")
   int[] field1369;
   @ObfuscatedName("z")
   byte[] field1370;
   @ObfuscatedName("n")
   byte[] field1371;
   @ObfuscatedName("w")
   short[] field1372;
   @ObfuscatedName("y")
   byte field1373 = 0;
   @ObfuscatedName("v")
   int field1374 = 0;
   @ObfuscatedName("j")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ah")
   int field1376;
   @ObfuscatedName("t")
   int[] field1377;
   @ObfuscatedName("b")
   int[][] field1378;
   @ObfuscatedName("f")
   int[] field1379;
   @ObfuscatedName("ai")
   public boolean field1380 = false;
   @ObfuscatedName("ad")
   int field1382;
   @ObfuscatedName("aq")
   static int[] field1383 = new int[12];
   @ObfuscatedName("aj")
   int field1384;
   @ObfuscatedName("an")
   static int[] field1385 = new int[1600];
   @ObfuscatedName("av")
   static int[] field1386 = new int[4700];
   @ObfuscatedName("as")
   static int[] field1387 = new int[10];
   @ObfuscatedName("ag")
   static int[] field1388 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1389 = new int[4700];
   @ObfuscatedName("af")
   static int[] field1390 = new int[4700];
   @ObfuscatedName("bf")
   public static int[] field1391 = new int[1000];
   @ObfuscatedName("aa")
   static int[] field1392 = new int[4700];
   @ObfuscatedName("e")
   int[][] field1393;
   @ObfuscatedName("ao")
   static int[] field1394 = new int[4700];
   @ObfuscatedName("am")
   int field1396;
   @ObfuscatedName("ac")
   static int[][] field1397 = new int[1600][512];
   @ObfuscatedName("al")
   static int[] field1398 = new int[12];
   @ObfuscatedName("ae")
   static int[][] field1399 = new int[12][2000];
   @ObfuscatedName("ar")
   static boolean[] field1400 = new boolean[4700];
   @ObfuscatedName("au")
   static int[] field1401 = new int[2000];
   @ObfuscatedName("at")
   static int[] field1403 = new int[10];
   @ObfuscatedName("az")
   static int[] field1404 = new int[10];
   @ObfuscatedName("ax")
   int field1405;
   @ObfuscatedName("l")
   int[] field1406;
   @ObfuscatedName("aw")
   static boolean[] field1407 = new boolean[4700];
   @ObfuscatedName("bo")
   static int field1408;
   @ObfuscatedName("br")
   public static boolean field1409 = false;
   @ObfuscatedName("bb")
   public static int field1410 = 0;
   @ObfuscatedName("c")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("bm")
   public static int field1412 = 0;
   @ObfuscatedName("ap")
   static int[] field1413 = new int[2000];
   @ObfuscatedName("bg")
   static int[] field1414;
   @ObfuscatedName("i")
   byte[] field1415;
   @ObfuscatedName("bj")
   static int[] field1416;
   @ObfuscatedName("bx")
   static int[] field1417;
   @ObfuscatedName("bp")
   static int[] field1419;

   @ObfuscatedName("p")
   public Model method1554(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1602();
      int var7 = var2 - this.field1376;
      int var8 = var2 + this.field1376;
      int var9 = var4 - this.field1376;
      int var10 = var4 + this.field1376;
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
               var11.field1358 = this.field1358;
               var11.field1366 = this.field1366;
               var11.field1374 = this.field1374;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1354 = this.field1354;
               var11.field1367 = this.field1367;
               var11.field1369 = this.field1369;
               var11.field1415 = this.field1415;
               var11.field1370 = this.field1370;
               var11.field1371 = this.field1371;
               var11.field1372 = this.field1372;
               var11.field1373 = this.field1373;
               var11.field1379 = this.field1379;
               var11.field1406 = this.field1406;
               var11.field1377 = this.field1377;
               var11.field1378 = this.field1378;
               var11.field1393 = this.field1393;
               var11.field1380 = this.field1380;
               var11.verticesY = new int[var11.field1358];
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
               for(var12 = 0; var12 < var11.field1358; ++var12) {
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
               for(var12 = 0; var12 < var11.field1358; ++var12) {
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

   @ObfuscatedName("g")
   public Model method1555(boolean var1) {
      if(!var1 && field1355.length < this.field1366) {
         field1355 = new byte[this.field1366 + 100];
      }

      return this.method1557(var1, field1364, field1355);
   }

   @ObfuscatedName("q")
   public Model method1556(boolean var1) {
      if(!var1 && field1357.length < this.field1366) {
         field1357 = new byte[this.field1366 + 100];
      }

      return this.method1557(var1, field1356, field1357);
   }

   @ObfuscatedName("d")
   Model method1557(boolean var1, Model var2, byte[] var3) {
      var2.field1358 = this.field1358;
      var2.field1366 = this.field1366;
      var2.field1374 = this.field1374;
      if(var2.verticesX == null || var2.verticesX.length < this.field1358) {
         var2.verticesX = new int[this.field1358 + 100];
         var2.verticesY = new int[this.field1358 + 100];
         var2.verticesZ = new int[this.field1358 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1358; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1370 = this.field1370;
      } else {
         var2.field1370 = var3;
         if(this.field1370 == null) {
            for(var4 = 0; var4 < this.field1366; ++var4) {
               var2.field1370[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1366; ++var4) {
               var2.field1370[var4] = this.field1370[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1354 = this.field1354;
      var2.field1367 = this.field1367;
      var2.field1369 = this.field1369;
      var2.field1415 = this.field1415;
      var2.field1371 = this.field1371;
      var2.field1372 = this.field1372;
      var2.field1373 = this.field1373;
      var2.field1379 = this.field1379;
      var2.field1406 = this.field1406;
      var2.field1377 = this.field1377;
      var2.field1378 = this.field1378;
      var2.field1393 = this.field1393;
      var2.field1380 = this.field1380;
      var2.field1396 = 0;
      return var2;
   }

   @ObfuscatedName("j")
   void method1559() {
      if(this.field1396 != 2) {
         this.field1396 = 2;
         this.field1376 = 0;

         for(int var1 = 0; var1 < this.field1358; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1376) {
               this.field1376 = var5;
            }
         }

         this.field1376 = (int)(Math.sqrt((double)this.field1376) + 0.99D);
         this.field1405 = this.field1376;
         this.field1384 = this.field1376 + this.field1376;
      }
   }

   @ObfuscatedName("s")
   public int method1560() {
      this.method1602();
      return this.field1376;
   }

   @ObfuscatedName("ad")
   final void method1561(int var1) {
      int var2 = class84.field1440;
      int var3 = class84.field1441;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1394[var5];
      int var9 = field1394[var6];
      int var10 = field1394[var7];
      if(this.field1370 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1370[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1403[var4] = field1389[var5];
         field1404[var4] = field1390[var5];
         field1387[var4++] = this.field1354[var1];
      } else {
         var11 = field1392[var5];
         var12 = field1388[var5];
         var13 = this.field1354[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1417[var10 - var8];
            field1403[var4] = var2 + (var11 + ((field1392[var7] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var7] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1369[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1417[var9 - var8];
            field1403[var4] = var2 + (var11 + ((field1392[var6] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var6] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1367[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1403[var4] = field1389[var6];
         field1404[var4] = field1390[var6];
         field1387[var4++] = this.field1367[var1];
      } else {
         var11 = field1392[var6];
         var12 = field1388[var6];
         var13 = this.field1367[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1417[var8 - var9];
            field1403[var4] = var2 + (var11 + ((field1392[var5] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var5] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1354[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1417[var10 - var9];
            field1403[var4] = var2 + (var11 + ((field1392[var7] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var7] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1369[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1403[var4] = field1389[var7];
         field1404[var4] = field1390[var7];
         field1387[var4++] = this.field1369[var1];
      } else {
         var11 = field1392[var7];
         var12 = field1388[var7];
         var13 = this.field1369[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1417[var9 - var10];
            field1403[var4] = var2 + (var11 + ((field1392[var6] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var6] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1367[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1417[var8 - var10];
            field1403[var4] = var2 + (var11 + ((field1392[var5] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1404[var4] = var3 + (var12 + ((field1388[var5] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1387[var4++] = var13 + ((this.field1354[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1403[0];
      var12 = field1403[1];
      var13 = field1403[2];
      var14 = field1404[0];
      int var15 = field1404[1];
      int var16 = field1404[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1372 != null && this.field1372[var1] != -1) {
            if(this.field1371 != null && this.field1371[var1] != -1) {
               var20 = this.field1371[var1] & 255;
               var17 = this.field1379[var20];
               var18 = this.field1406[var20];
               var19 = this.field1377[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1369[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1354[var1], this.field1354[var1], this.field1354[var1], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], this.field1372[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1387[0], field1387[1], field1387[2], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], this.field1372[var1]);
            }
         } else if(this.field1369[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1416[this.field1354[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1387[0], field1387[1], field1387[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1403[3] < 0 || field1403[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1372 != null && this.field1372[var1] != -1) {
            if(this.field1371 != null && this.field1371[var1] != -1) {
               var20 = this.field1371[var1] & 255;
               var17 = this.field1379[var20];
               var18 = this.field1406[var20];
               var19 = this.field1377[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1372[var1];
            if(this.field1369[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1354[var1], this.field1354[var1], this.field1354[var1], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1404[3], var11, var13, field1403[3], this.field1354[var1], this.field1354[var1], this.field1354[var1], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1387[0], field1387[1], field1387[2], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1404[3], var11, var13, field1403[3], field1387[0], field1387[2], field1387[3], field1392[var17], field1392[var18], field1392[var19], field1388[var17], field1388[var18], field1388[var19], field1394[var17], field1394[var18], field1394[var19], var21);
            }
         } else if(this.field1369[var1] == -1) {
            var17 = field1416[this.field1354[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1404[3], var11, var13, field1403[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1387[0], field1387[1], field1387[2]);
            class84.rasterGouraud(var14, var16, field1404[3], var11, var13, field1403[3], field1387[0], field1387[2], field1387[3]);
         }
      }

   }

   @ObfuscatedName("a")
   public void method1562(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1570[var2];
            Frame var7 = var3.field1570[var4];
            FrameMap var8 = var6.field1319;
            field1368 = 0;
            field1360 = 0;
            field1408 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1320; ++var11) {
               for(var12 = var6.field1316[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1469[var12] == 0) {
                  this.method1563(var8.field1469[var12], var8.field1466[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1368 = 0;
            field1360 = 0;
            field1408 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1320; ++var11) {
               for(var12 = var7.field1316[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1469[var12] == 0) {
                  this.method1563(var8.field1469[var12], var8.field1466[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1396 = 0;
         } else {
            this.method1566(var1, var2);
         }
      }
   }

   @ObfuscatedName("c")
   void method1563(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1368 = 0;
         field1360 = 0;
         field1408 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1378.length) {
               int[] var19 = this.field1378[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1368 += this.verticesX[var12];
                  field1360 += this.verticesY[var12];
                  field1408 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1368 = field1368 / var7 + var3;
            field1360 = field1360 / var7 + var4;
            field1408 = field1408 / var7 + var5;
         } else {
            field1368 = var3;
            field1360 = var4;
            field1408 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1378.length) {
                  var9 = this.field1378[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1378.length) {
                  var9 = this.field1378[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1368;
                     this.verticesY[var11] -= field1360;
                     this.verticesZ[var11] -= field1408;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1414[var14];
                        var16 = field1419[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1414[var12];
                        var16 = field1419[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1414[var13];
                        var16 = field1419[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1368;
                     this.verticesY[var11] += field1360;
                     this.verticesZ[var11] += field1408;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1378.length) {
                  var9 = this.field1378[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1368;
                     this.verticesY[var11] -= field1360;
                     this.verticesZ[var11] -= field1408;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1368;
                     this.verticesY[var11] += field1360;
                     this.verticesZ[var11] += field1408;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1393 != null && this.field1370 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1393.length) {
                     var9 = this.field1393[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1370[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1370[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   public void method1565() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("o")
   public void method1566(Frames var1, int var2) {
      if(this.field1378 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1570[var2];
            FrameMap var4 = var3.field1319;
            field1368 = 0;
            field1360 = 0;
            field1408 = 0;

            for(int var5 = 0; var5 < var3.field1320; ++var5) {
               int var6 = var3.field1316[var5];
               this.method1563(var4.field1469[var6], var4.field1466[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1396 = 0;
         }
      }
   }

   @ObfuscatedName("n")
   public void method1567(int var1) {
      int var2 = field1414[var1];
      int var3 = field1419[var1];

      for(int var4 = 0; var4 < this.field1358; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1396 = 0;
   }

   Model() {
   }

   @ObfuscatedName("u")
   public void method1568() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("cs")
   void vmethod1886(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1385[0] = -1;
      if(this.field1396 != 1) {
         this.method1602();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1376 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1376) * class84.field1437;
         if(var15 / var13 < class84.field1443) {
            int var16 = (var14 + this.field1376) * class84.field1437;
            if(var16 / var13 > class84.field1436) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1376 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1437;
               if(var19 / var13 > class84.field1432) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1437;
                  if(var21 / var13 < class84.field1445) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1374 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1409) {
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

                        var28 = field1410 - class84.field1440;
                        var29 = field1363 - class84.field1441;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1380) {
                              field1391[field1412++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1440;
                     var28 = class84.field1441;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1414[var1];
                        var30 = field1419[var1];
                     }

                     for(int var31 = 0; var31 < this.field1358; ++var31) {
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
                        field1386[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1389[var31] = var27 + var32 * class84.field1437 / var34;
                           field1390[var31] = var28 + var35 * class84.field1437 / var34;
                        } else {
                           field1389[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1392[var31] = var32;
                           field1388[var31] = var35;
                           field1394[var31] = var34;
                        }
                     }

                     try {
                        this.method1577(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   public final void method1572(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1385[0] = -1;
      if(this.field1396 != 2 && this.field1396 != 1) {
         this.method1559();
      }

      int var9 = class84.field1440;
      int var10 = class84.field1441;
      int var10000 = field1414[var1];
      var10000 = field1419[var1];
      int var13 = field1414[var2];
      int var14 = field1419[var2];
      int var15 = field1414[var3];
      int var16 = field1419[var3];
      int var17 = field1414[var4];
      int var18 = field1419[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1358; ++var20) {
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
         field1386[var20] = var23 - var19;
         field1389[var20] = var9 + var21 * class84.field1437 / var8;
         field1390[var20] = var10 + var24 * class84.field1437 / var8;
         if(this.field1374 > 0) {
            field1392[var20] = var21;
            field1388[var20] = var24;
            field1394[var20] = var23;
         }
      }

      try {
         this.method1577(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ah")
   final boolean method1575(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1414 = class84.field1438;
      field1419 = class84.field1452;
      field1416 = class84.colorPalette;
      field1417 = class84.field1450;
   }

   @ObfuscatedName("ai")
   final void method1577(boolean var1, boolean var2, int var3) {
      if(this.field1384 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1384; ++var4) {
            field1385[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var12;
         int var13;
         int var15;
         int var24;
         for(var4 = 0; var4 < this.field1366; ++var4) {
            if(this.field1369[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1389[var5];
               var9 = field1389[var6];
               var24 = field1389[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var24 != -5000) {
                  if(var2 && this.method1575(field1410, field1363, field1390[var5], field1390[var6], field1390[var7], var8, var9, var24)) {
                     field1391[field1412++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1390[var7] - field1390[var6]) - (field1390[var5] - field1390[var6]) * (var24 - var9) > 0) {
                     field1407[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var24 <= class84.rasterClipX) {
                        field1400[var4] = false;
                     } else {
                        field1400[var4] = true;
                     }

                     var11 = (field1386[var5] + field1386[var6] + field1386[var7]) / 3 + this.field1405;
                     field1397[var11][field1385[var11]++] = var4;
                  }
               } else {
                  var11 = field1392[var5];
                  var12 = field1392[var6];
                  var13 = field1392[var7];
                  int var14 = field1388[var5];
                  var15 = field1388[var6];
                  int var16 = field1388[var7];
                  int var17 = field1394[var5];
                  int var18 = field1394[var6];
                  int var19 = field1394[var7];
                  var11 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var11 * var19;
                  int var22 = var11 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1407[var4] = true;
                     int var23 = (field1386[var5] + field1386[var6] + field1386[var7]) / 3 + this.field1405;
                     field1397[var23][field1385[var23]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1415 == null) {
            for(var4 = this.field1384 - 1; var4 >= 0; --var4) {
               var5 = field1385[var4];
               if(var5 > 0) {
                  var26 = field1397[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1596(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1398[var4] = 0;
               field1383[var4] = 0;
            }

            for(var4 = this.field1384 - 1; var4 >= 0; --var4) {
               var5 = field1385[var4];
               if(var5 > 0) {
                  var26 = field1397[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1415[var8];
                     var24 = field1398[var28]++;
                     field1399[var28][var24] = var8;
                     if(var28 < 10) {
                        field1383[var28] += var4;
                     } else if(var28 == 10) {
                        field1413[var24] = var4;
                     } else {
                        field1401[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1398[1] > 0 || field1398[2] > 0) {
               var4 = (field1383[1] + field1383[2]) / (field1398[1] + field1398[2]);
            }

            var5 = 0;
            if(field1398[3] > 0 || field1398[4] > 0) {
               var5 = (field1383[3] + field1383[4]) / (field1398[3] + field1398[4]);
            }

            var6 = 0;
            if(field1398[6] > 0 || field1398[8] > 0) {
               var6 = (field1383[6] + field1383[8]) / (field1398[6] + field1398[8]);
            }

            var8 = 0;
            var9 = field1398[10];
            int[] var10 = field1399[10];
            int[] var25 = field1413;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1398[11];
               var10 = field1399[11];
               var25 = field1401;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1596(var10[var8++]);
                  if(var8 == var9 && var10 != field1399[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var10 = field1399[11];
                     var25 = field1401;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1596(var10[var8++]);
                  if(var8 == var9 && var10 != field1399[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var10 = field1399[11];
                     var25 = field1401;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1596(var10[var8++]);
                  if(var8 == var9 && var10 != field1399[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var10 = field1399[11];
                     var25 = field1401;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1398[var12];
               int[] var27 = field1399[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1596(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1596(var10[var8++]);
               if(var8 == var9 && var10 != field1399[11]) {
                  var8 = 0;
                  var10 = field1399[11];
                  var9 = field1398[11];
                  var25 = field1401;
               }

               if(var8 < var9) {
                  var7 = var25[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public final void method1583(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1385[0] = -1;
      if(this.field1396 != 2 && this.field1396 != 1) {
         this.method1559();
      }

      int var8 = class84.field1440;
      int var9 = class84.field1441;
      int var10000 = field1414[var1];
      var10000 = field1419[var1];
      int var12 = field1414[var2];
      int var13 = field1419[var2];
      int var14 = field1414[var3];
      int var15 = field1419[var3];
      int var16 = field1414[var4];
      int var17 = field1419[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1358; ++var19) {
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
         field1386[var19] = var22 - var18;
         field1389[var19] = var8 + var20 * class84.field1437 / var22;
         field1390[var19] = var9 + var23 * class84.field1437 / var22;
         if(this.field1374 > 0) {
            field1392[var19] = var20;
            field1388[var19] = var23;
            field1394[var19] = var22;
         }
      }

      try {
         this.method1577(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("z")
   public void method1588() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("l")
   public void method1590(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1358; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1396 = 0;
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1358 = 0;
      this.field1366 = 0;
      this.field1374 = 0;
      this.field1373 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1358 += var8.field1358;
            this.field1366 += var8.field1366;
            this.field1374 += var8.field1374;
            if(var8.field1415 != null) {
               var3 = true;
            } else {
               if(this.field1373 == -1) {
                  this.field1373 = var8.field1373;
               }

               if(this.field1373 != var8.field1373) {
                  var3 = true;
               }
            }

            var4 |= var8.field1370 != null;
            var5 |= var8.field1372 != null;
            var6 |= var8.field1371 != null;
         }
      }

      this.verticesX = new int[this.field1358];
      this.verticesY = new int[this.field1358];
      this.verticesZ = new int[this.field1358];
      this.indices1 = new int[this.field1366];
      this.indices2 = new int[this.field1366];
      this.indices3 = new int[this.field1366];
      this.field1354 = new int[this.field1366];
      this.field1367 = new int[this.field1366];
      this.field1369 = new int[this.field1366];
      if(var3) {
         this.field1415 = new byte[this.field1366];
      }

      if(var4) {
         this.field1370 = new byte[this.field1366];
      }

      if(var5) {
         this.field1372 = new short[this.field1366];
      }

      if(var6) {
         this.field1371 = new byte[this.field1366];
      }

      if(this.field1374 > 0) {
         this.field1379 = new int[this.field1374];
         this.field1406 = new int[this.field1374];
         this.field1377 = new int[this.field1374];
      }

      this.field1358 = 0;
      this.field1366 = 0;
      this.field1374 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1366; ++var9) {
               this.indices1[this.field1366] = var8.indices1[var9] + this.field1358;
               this.indices2[this.field1366] = var8.indices2[var9] + this.field1358;
               this.indices3[this.field1366] = var8.indices3[var9] + this.field1358;
               this.field1354[this.field1366] = var8.field1354[var9];
               this.field1367[this.field1366] = var8.field1367[var9];
               this.field1369[this.field1366] = var8.field1369[var9];
               if(var3) {
                  if(var8.field1415 != null) {
                     this.field1415[this.field1366] = var8.field1415[var9];
                  } else {
                     this.field1415[this.field1366] = var8.field1373;
                  }
               }

               if(var4 && var8.field1370 != null) {
                  this.field1370[this.field1366] = var8.field1370[var9];
               }

               if(var5) {
                  if(var8.field1372 != null) {
                     this.field1372[this.field1366] = var8.field1372[var9];
                  } else {
                     this.field1372[this.field1366] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1371 != null && var8.field1371[var9] != -1) {
                     this.field1371[this.field1366] = (byte)(var8.field1371[var9] + this.field1374);
                  } else {
                     this.field1371[this.field1366] = -1;
                  }
               }

               ++this.field1366;
            }

            for(var9 = 0; var9 < var8.field1374; ++var9) {
               this.field1379[this.field1374] = var8.field1379[var9] + this.field1358;
               this.field1406[this.field1374] = var8.field1406[var9] + this.field1358;
               this.field1377[this.field1374] = var8.field1377[var9] + this.field1358;
               ++this.field1374;
            }

            for(var9 = 0; var9 < var8.field1358; ++var9) {
               this.verticesX[this.field1358] = var8.verticesX[var9];
               this.verticesY[this.field1358] = var8.verticesY[var9];
               this.verticesZ[this.field1358] = var8.verticesZ[var9];
               ++this.field1358;
            }
         }
      }

   }

   @ObfuscatedName("am")
   final void method1596(int var1) {
      if(field1407[var1]) {
         this.method1561(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1400[var1];
         if(this.field1370 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1370[var1] & 255;
         }

         if(this.field1372 != null && this.field1372[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1371 != null && this.field1371[var1] != -1) {
               int var8 = this.field1371[var1] & 255;
               var5 = this.field1379[var8];
               var6 = this.field1406[var8];
               var7 = this.field1377[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1369[var1] == -1) {
               class84.rasterTextureAffine(field1390[var2], field1390[var3], field1390[var4], field1389[var2], field1389[var3], field1389[var4], this.field1354[var1], this.field1354[var1], this.field1354[var1], field1392[var5], field1392[var6], field1392[var7], field1388[var5], field1388[var6], field1388[var7], field1394[var5], field1394[var6], field1394[var7], this.field1372[var1]);
            } else {
               class84.rasterTextureAffine(field1390[var2], field1390[var3], field1390[var4], field1389[var2], field1389[var3], field1389[var4], this.field1354[var1], this.field1367[var1], this.field1369[var1], field1392[var5], field1392[var6], field1392[var7], field1388[var5], field1388[var6], field1388[var7], field1394[var5], field1394[var6], field1394[var7], this.field1372[var1]);
            }
         } else if(this.field1369[var1] == -1) {
            class84.rasterFlat(field1390[var2], field1390[var3], field1390[var4], field1389[var2], field1389[var3], field1389[var4], field1416[this.field1354[var1]]);
         } else {
            class84.rasterGouraud(field1390[var2], field1390[var3], field1390[var4], field1389[var2], field1389[var3], field1389[var4], this.field1354[var1], this.field1367[var1], this.field1369[var1]);
         }

      }
   }

   @ObfuscatedName("t")
   public void method1601(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1358; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1396 = 0;
   }

   @ObfuscatedName("k")
   public void method1602() {
      if(this.field1396 != 1) {
         this.field1396 = 1;
         super.modelHeight = 0;
         this.field1382 = 0;
         this.field1376 = 0;

         for(int var1 = 0; var1 < this.field1358; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1382) {
               this.field1382 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1376) {
               this.field1376 = var5;
            }
         }

         this.field1376 = (int)(Math.sqrt((double)this.field1376) + 0.99D);
         this.field1405 = (int)(Math.sqrt((double)(this.field1376 * this.field1376 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1384 = this.field1405 + (int)(Math.sqrt((double)(this.field1376 * this.field1376 + this.field1382 * this.field1382)) + 0.99D);
      }
   }
}

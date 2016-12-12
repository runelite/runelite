import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("k")
   static byte[] field1355 = new byte[1];
   @ObfuscatedName("e")
   static byte[] field1356 = new byte[1];
   @ObfuscatedName("bh")
   static int field1357;
   @ObfuscatedName("i")
   static Model field1358 = new Model();
   @ObfuscatedName("m")
   int[] field1359;
   @ObfuscatedName("n")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("a")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("av")
   static int[] field1362 = new int[4700];
   @ObfuscatedName("w")
   int field1363 = 0;
   @ObfuscatedName("v")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("aa")
   static int[] field1365 = new int[4700];
   @ObfuscatedName("p")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("l")
   int[] field1367;
   @ObfuscatedName("c")
   int[] field1368;
   @ObfuscatedName("bp")
   static int[] field1369;
   @ObfuscatedName("r")
   byte[] field1370;
   @ObfuscatedName("x")
   short[] field1371;
   @ObfuscatedName("z")
   int[] field1372;
   @ObfuscatedName("at")
   static int[] field1373 = new int[12];
   @ObfuscatedName("d")
   byte field1374 = 0;
   @ObfuscatedName("y")
   int field1375 = 0;
   @ObfuscatedName("s")
   int[] field1376;
   @ObfuscatedName("az")
   static int[] field1377 = new int[4700];
   @ObfuscatedName("bw")
   static int field1378;
   @ObfuscatedName("ar")
   static int[][] field1379 = new int[1600][512];
   @ObfuscatedName("o")
   int[][] field1380;
   @ObfuscatedName("ak")
   public boolean field1381 = false;
   @ObfuscatedName("h")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("aq")
   int field1383;
   @ObfuscatedName("an")
   int field1384;
   @ObfuscatedName("ay")
   int field1385;
   @ObfuscatedName("ap")
   int field1386;
   @ObfuscatedName("aw")
   static boolean[] field1388 = new boolean[4700];
   @ObfuscatedName("am")
   static boolean[] field1389 = new boolean[4700];
   @ObfuscatedName("f")
   static Model field1390 = new Model();
   @ObfuscatedName("af")
   static int[] field1391 = new int[4700];
   @ObfuscatedName("be")
   public static int field1392 = 0;
   @ObfuscatedName("q")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("ad")
   static int[] field1394 = new int[4700];
   @ObfuscatedName("bs")
   public static int field1395 = 0;
   @ObfuscatedName("as")
   static int[] field1397 = new int[1600];
   @ObfuscatedName("ai")
   int field1398;
   @ObfuscatedName("ab")
   static int[] field1399 = new int[4700];
   @ObfuscatedName("bq")
   static int field1400;
   @ObfuscatedName("ao")
   static int[] field1401 = new int[2000];
   @ObfuscatedName("ah")
   static int[] field1402 = new int[2000];
   @ObfuscatedName("ac")
   static int[] field1403 = new int[12];
   @ObfuscatedName("ae")
   static int[] field1404 = new int[10];
   @ObfuscatedName("u")
   byte[] field1405;
   @ObfuscatedName("j")
   byte[] field1406;
   @ObfuscatedName("ag")
   static int[] field1407 = new int[10];
   @ObfuscatedName("t")
   int[] field1408;
   @ObfuscatedName("au")
   static int[] field1409 = new int[10];
   @ObfuscatedName("ba")
   public static boolean field1410 = false;
   @ObfuscatedName("b")
   int[][] field1411;
   @ObfuscatedName("g")
   int field1412 = 0;
   @ObfuscatedName("ax")
   static int[][] field1413 = new int[12][2000];
   @ObfuscatedName("bd")
   public static int[] field1414 = new int[1000];
   @ObfuscatedName("bm")
   static int[] field1415;
   @ObfuscatedName("bk")
   static int[] field1416;
   @ObfuscatedName("br")
   static int[] field1417;
   @ObfuscatedName("bx")
   public static int field1418 = 0;

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1412 = 0;
      this.field1363 = 0;
      this.field1375 = 0;
      this.field1374 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1412 += var8.field1412;
            this.field1363 += var8.field1363;
            this.field1375 += var8.field1375;
            if(var8.field1370 != null) {
               var3 = true;
            } else {
               if(this.field1374 == -1) {
                  this.field1374 = var8.field1374;
               }

               if(this.field1374 != var8.field1374) {
                  var3 = true;
               }
            }

            var4 |= var8.field1405 != null;
            var5 |= var8.field1371 != null;
            var6 |= var8.field1406 != null;
         }
      }

      this.verticesX = new int[this.field1412];
      this.verticesY = new int[this.field1412];
      this.verticesZ = new int[this.field1412];
      this.indices1 = new int[this.field1363];
      this.indices2 = new int[this.field1363];
      this.indices3 = new int[this.field1363];
      this.field1367 = new int[this.field1363];
      this.field1368 = new int[this.field1363];
      this.field1359 = new int[this.field1363];
      if(var3) {
         this.field1370 = new byte[this.field1363];
      }

      if(var4) {
         this.field1405 = new byte[this.field1363];
      }

      if(var5) {
         this.field1371 = new short[this.field1363];
      }

      if(var6) {
         this.field1406 = new byte[this.field1363];
      }

      if(this.field1375 > 0) {
         this.field1376 = new int[this.field1375];
         this.field1408 = new int[this.field1375];
         this.field1372 = new int[this.field1375];
      }

      this.field1412 = 0;
      this.field1363 = 0;
      this.field1375 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1363; ++var9) {
               this.indices1[this.field1363] = var8.indices1[var9] + this.field1412;
               this.indices2[this.field1363] = var8.indices2[var9] + this.field1412;
               this.indices3[this.field1363] = var8.indices3[var9] + this.field1412;
               this.field1367[this.field1363] = var8.field1367[var9];
               this.field1368[this.field1363] = var8.field1368[var9];
               this.field1359[this.field1363] = var8.field1359[var9];
               if(var3) {
                  if(var8.field1370 != null) {
                     this.field1370[this.field1363] = var8.field1370[var9];
                  } else {
                     this.field1370[this.field1363] = var8.field1374;
                  }
               }

               if(var4 && var8.field1405 != null) {
                  this.field1405[this.field1363] = var8.field1405[var9];
               }

               if(var5) {
                  if(var8.field1371 != null) {
                     this.field1371[this.field1363] = var8.field1371[var9];
                  } else {
                     this.field1371[this.field1363] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1406 != null && var8.field1406[var9] != -1) {
                     this.field1406[this.field1363] = (byte)(var8.field1406[var9] + this.field1375);
                  } else {
                     this.field1406[this.field1363] = -1;
                  }
               }

               ++this.field1363;
            }

            for(var9 = 0; var9 < var8.field1375; ++var9) {
               this.field1376[this.field1375] = var8.field1376[var9] + this.field1412;
               this.field1408[this.field1375] = var8.field1408[var9] + this.field1412;
               this.field1372[this.field1375] = var8.field1372[var9] + this.field1412;
               ++this.field1375;
            }

            for(var9 = 0; var9 < var8.field1412; ++var9) {
               this.verticesX[this.field1412] = var8.verticesX[var9];
               this.verticesY[this.field1412] = var8.verticesY[var9];
               this.verticesZ[this.field1412] = var8.verticesZ[var9];
               ++this.field1412;
            }
         }
      }

   }

   @ObfuscatedName("i")
   public Model method1540(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1546();
      int var7 = var2 - this.field1384;
      int var8 = var2 + this.field1384;
      int var9 = var4 - this.field1384;
      int var10 = var4 + this.field1384;
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
               var11.field1412 = this.field1412;
               var11.field1363 = this.field1363;
               var11.field1375 = this.field1375;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1367 = this.field1367;
               var11.field1368 = this.field1368;
               var11.field1359 = this.field1359;
               var11.field1370 = this.field1370;
               var11.field1405 = this.field1405;
               var11.field1406 = this.field1406;
               var11.field1371 = this.field1371;
               var11.field1374 = this.field1374;
               var11.field1376 = this.field1376;
               var11.field1408 = this.field1408;
               var11.field1372 = this.field1372;
               var11.field1411 = this.field1411;
               var11.field1380 = this.field1380;
               var11.field1381 = this.field1381;
               var11.verticesY = new int[var11.field1412];
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
               for(var12 = 0; var12 < var11.field1412; ++var12) {
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
               for(var12 = 0; var12 < var11.field1412; ++var12) {
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

            var11.field1398 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("e")
   public Model method1541(boolean var1) {
      if(!var1 && field1356.length < this.field1363) {
         field1356 = new byte[this.field1363 + 100];
      }

      return this.method1543(var1, field1358, field1356);
   }

   @ObfuscatedName("k")
   public Model method1542(boolean var1) {
      if(!var1 && field1355.length < this.field1363) {
         field1355 = new byte[this.field1363 + 100];
      }

      return this.method1543(var1, field1390, field1355);
   }

   @ObfuscatedName("a")
   Model method1543(boolean var1, Model var2, byte[] var3) {
      var2.field1412 = this.field1412;
      var2.field1363 = this.field1363;
      var2.field1375 = this.field1375;
      if(var2.verticesX == null || var2.verticesX.length < this.field1412) {
         var2.verticesX = new int[this.field1412 + 100];
         var2.verticesY = new int[this.field1412 + 100];
         var2.verticesZ = new int[this.field1412 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1412; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1405 = this.field1405;
      } else {
         var2.field1405 = var3;
         if(this.field1405 == null) {
            for(var4 = 0; var4 < this.field1363; ++var4) {
               var2.field1405[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1363; ++var4) {
               var2.field1405[var4] = this.field1405[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1367 = this.field1367;
      var2.field1368 = this.field1368;
      var2.field1359 = this.field1359;
      var2.field1370 = this.field1370;
      var2.field1406 = this.field1406;
      var2.field1371 = this.field1371;
      var2.field1374 = this.field1374;
      var2.field1376 = this.field1376;
      var2.field1408 = this.field1408;
      var2.field1372 = this.field1372;
      var2.field1411 = this.field1411;
      var2.field1380 = this.field1380;
      var2.field1381 = this.field1381;
      var2.field1398 = 0;
      return var2;
   }

   @ObfuscatedName("q")
   public void method1546() {
      if(this.field1398 != 1) {
         this.field1398 = 1;
         super.modelHeight = 0;
         this.field1383 = 0;
         this.field1384 = 0;

         for(int var1 = 0; var1 < this.field1412; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1383) {
               this.field1383 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1384) {
               this.field1384 = var5;
            }
         }

         this.field1384 = (int)(Math.sqrt((double)this.field1384) + 0.99D);
         this.field1386 = (int)(Math.sqrt((double)(this.field1384 * this.field1384 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1385 = this.field1386 + (int)(Math.sqrt((double)(this.field1384 * this.field1384 + this.field1383 * this.field1383)) + 0.99D);
      }
   }

   @ObfuscatedName("h")
   public void method1547(Frames var1, int var2) {
      if(this.field1411 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1562[var2];
            FrameMap var4 = var3.field1327;
            field1400 = 0;
            field1357 = 0;
            field1378 = 0;

            for(int var5 = 0; var5 < var3.field1323; ++var5) {
               int var6 = var3.field1324[var5];
               this.method1549(var4.field1468[var6], var4.field1467[var6], var3.field1321[var5], var3.field1318[var5], var3.field1325[var5]);
            }

            this.field1398 = 0;
         }
      }
   }

   @ObfuscatedName("p")
   public void method1548(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1562[var2];
            Frame var7 = var3.field1562[var4];
            FrameMap var8 = var6.field1327;
            field1400 = 0;
            field1357 = 0;
            field1378 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1323; ++var11) {
               for(var12 = var6.field1324[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1468[var12] == 0) {
                  this.method1549(var8.field1468[var12], var8.field1467[var12], var6.field1321[var11], var6.field1318[var11], var6.field1325[var11]);
               }
            }

            field1400 = 0;
            field1357 = 0;
            field1378 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1323; ++var11) {
               for(var12 = var7.field1324[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1468[var12] == 0) {
                  this.method1549(var8.field1468[var12], var8.field1467[var12], var7.field1321[var11], var7.field1318[var11], var7.field1325[var11]);
               }
            }

            this.field1398 = 0;
         } else {
            this.method1547(var1, var2);
         }
      }
   }

   @ObfuscatedName("l")
   void method1549(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1400 = 0;
         field1357 = 0;
         field1378 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1411.length) {
               int[] var19 = this.field1411[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1400 += this.verticesX[var12];
                  field1357 += this.verticesY[var12];
                  field1378 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1400 = field1400 / var7 + var3;
            field1357 = field1357 / var7 + var4;
            field1378 = field1378 / var7 + var5;
         } else {
            field1400 = var3;
            field1357 = var4;
            field1378 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1411.length) {
                  var9 = this.field1411[var8];

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
               if(var8 < this.field1411.length) {
                  var9 = this.field1411[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1400;
                     this.verticesY[var11] -= field1357;
                     this.verticesZ[var11] -= field1378;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1415[var14];
                        var16 = field1416[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1415[var12];
                        var16 = field1416[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1415[var13];
                        var16 = field1416[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1400;
                     this.verticesY[var11] += field1357;
                     this.verticesZ[var11] += field1378;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1411.length) {
                  var9 = this.field1411[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1400;
                     this.verticesY[var11] -= field1357;
                     this.verticesZ[var11] -= field1378;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1400;
                     this.verticesY[var11] += field1357;
                     this.verticesZ[var11] += field1378;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1380 != null && this.field1405 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1380.length) {
                     var9 = this.field1380[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1405[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1405[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   public void method1550() {
      for(int var1 = 0; var1 < this.field1412; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("r")
   public void method1551() {
      for(int var1 = 0; var1 < this.field1412; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("u")
   public void method1552() {
      for(int var1 = 0; var1 < this.field1412; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("j")
   public void method1553(int var1) {
      int var2 = field1415[var1];
      int var3 = field1416[var1];

      for(int var4 = 0; var4 < this.field1412; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("x")
   public void method1554(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1412; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("d")
   public void method1555(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1412; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1398 = 0;
   }

   @ObfuscatedName("y")
   public final void method1556(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1397[0] = -1;
      if(this.field1398 != 2 && this.field1398 != 1) {
         this.method1614();
      }

      int var8 = class84.field1440;
      int var9 = class84.field1441;
      int var10000 = field1415[var1];
      var10000 = field1416[var1];
      int var12 = field1415[var2];
      int var13 = field1416[var2];
      int var14 = field1415[var3];
      int var15 = field1416[var3];
      int var16 = field1415[var4];
      int var17 = field1416[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1412; ++var19) {
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
         field1377[var19] = var22 - var18;
         field1362[var19] = var8 + var20 * class84.field1439 / var22;
         field1391[var19] = var9 + var23 * class84.field1439 / var22;
         if(this.field1375 > 0) {
            field1365[var19] = var20;
            field1394[var19] = var23;
            field1399[var19] = var22;
         }
      }

      try {
         this.method1559(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("t")
   final void method1559(boolean var1, boolean var2, int var3) {
      if(this.field1385 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1385; ++var4) {
            field1397[var4] = 0;
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
         for(var4 = 0; var4 < this.field1363; ++var4) {
            if(this.field1359[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1362[var5];
               var9 = field1362[var6];
               var10 = field1362[var7];
               int var25;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method1562(field1392, field1418, field1391[var5], field1391[var6], field1391[var7], var8, var9, var10)) {
                     field1414[field1395++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1391[var7] - field1391[var6]) - (field1391[var5] - field1391[var6]) * (var10 - var9) > 0) {
                     field1389[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1388[var4] = false;
                     } else {
                        field1388[var4] = true;
                     }

                     var25 = (field1377[var5] + field1377[var6] + field1377[var7]) / 3 + this.field1386;
                     field1379[var25][field1397[var25]++] = var4;
                  }
               } else {
                  var25 = field1365[var5];
                  var12 = field1365[var6];
                  var13 = field1365[var7];
                  int var14 = field1394[var5];
                  var15 = field1394[var6];
                  int var16 = field1394[var7];
                  int var17 = field1399[var5];
                  int var18 = field1399[var6];
                  int var19 = field1399[var7];
                  var25 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var25 * var19;
                  int var22 = var25 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1389[var4] = true;
                     int var23 = (field1377[var5] + field1377[var6] + field1377[var7]) / 3 + this.field1386;
                     field1379[var23][field1397[var23]++] = var4;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1370 == null) {
            for(var4 = this.field1385 - 1; var4 >= 0; --var4) {
               var5 = field1397[var4];
               if(var5 > 0) {
                  var27 = field1379[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1623(var27[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1373[var4] = 0;
               field1403[var4] = 0;
            }

            for(var4 = this.field1385 - 1; var4 >= 0; --var4) {
               var5 = field1397[var4];
               if(var5 > 0) {
                  var27 = field1379[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var27[var7];
                     byte var28 = this.field1370[var8];
                     var10 = field1373[var28]++;
                     field1413[var28][var10] = var8;
                     if(var28 < 10) {
                        field1403[var28] += var4;
                     } else if(var28 == 10) {
                        field1401[var10] = var4;
                     } else {
                        field1402[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1373[1] > 0 || field1373[2] > 0) {
               var4 = (field1403[1] + field1403[2]) / (field1373[1] + field1373[2]);
            }

            var5 = 0;
            if(field1373[3] > 0 || field1373[4] > 0) {
               var5 = (field1403[3] + field1403[4]) / (field1373[3] + field1373[4]);
            }

            var6 = 0;
            if(field1373[6] > 0 || field1373[8] > 0) {
               var6 = (field1403[6] + field1403[8]) / (field1373[6] + field1373[8]);
            }

            var8 = 0;
            var9 = field1373[10];
            int[] var24 = field1413[10];
            int[] var11 = field1401;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1373[11];
               var24 = field1413[11];
               var11 = field1402;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1623(var24[var8++]);
                  if(var8 == var9 && var24 != field1413[11]) {
                     var8 = 0;
                     var9 = field1373[11];
                     var24 = field1413[11];
                     var11 = field1402;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1623(var24[var8++]);
                  if(var8 == var9 && var24 != field1413[11]) {
                     var8 = 0;
                     var9 = field1373[11];
                     var24 = field1413[11];
                     var11 = field1402;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1623(var24[var8++]);
                  if(var8 == var9 && var24 != field1413[11]) {
                     var8 = 0;
                     var9 = field1373[11];
                     var24 = field1413[11];
                     var11 = field1402;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1373[var12];
               int[] var26 = field1413[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1623(var26[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1623(var24[var8++]);
               if(var8 == var9 && var24 != field1413[11]) {
                  var8 = 0;
                  var24 = field1413[11];
                  var9 = field1373[11];
                  var11 = field1402;
               }

               if(var8 < var9) {
                  var7 = var11[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   public final void method1560(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1397[0] = -1;
      if(this.field1398 != 2 && this.field1398 != 1) {
         this.method1614();
      }

      int var9 = class84.field1440;
      int var10 = class84.field1441;
      int var10000 = field1415[var1];
      var10000 = field1416[var1];
      int var13 = field1415[var2];
      int var14 = field1416[var2];
      int var15 = field1415[var3];
      int var16 = field1416[var3];
      int var17 = field1415[var4];
      int var18 = field1416[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1412; ++var20) {
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
         field1377[var20] = var23 - var19;
         field1362[var20] = var9 + var21 * class84.field1439 / var8;
         field1391[var20] = var10 + var24 * class84.field1439 / var8;
         if(this.field1375 > 0) {
            field1365[var20] = var21;
            field1394[var20] = var24;
            field1399[var20] = var23;
         }
      }

      try {
         this.method1559(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("o")
   final boolean method1562(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1415 = class84.field1453;
      field1416 = class84.field1454;
      field1417 = class84.colorPalette;
      field1369 = class84.field1452;
   }

   @ObfuscatedName("v")
   public int method1580() {
      this.method1546();
      return this.field1384;
   }

   @ObfuscatedName("b")
   final void method1584(int var1) {
      int var2 = class84.field1440;
      int var3 = class84.field1441;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1399[var5];
      int var9 = field1399[var6];
      int var10 = field1399[var7];
      if(this.field1405 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1405[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1404[var4] = field1362[var5];
         field1409[var4] = field1391[var5];
         field1407[var4++] = this.field1367[var1];
      } else {
         var11 = field1365[var5];
         var12 = field1394[var5];
         var13 = this.field1367[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1369[var10 - var8];
            field1404[var4] = var2 + (var11 + ((field1365[var7] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var7] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1359[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1369[var9 - var8];
            field1404[var4] = var2 + (var11 + ((field1365[var6] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var6] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1368[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1404[var4] = field1362[var6];
         field1409[var4] = field1391[var6];
         field1407[var4++] = this.field1368[var1];
      } else {
         var11 = field1365[var6];
         var12 = field1394[var6];
         var13 = this.field1368[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1369[var8 - var9];
            field1404[var4] = var2 + (var11 + ((field1365[var5] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var5] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1367[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1369[var10 - var9];
            field1404[var4] = var2 + (var11 + ((field1365[var7] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var7] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1359[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1404[var4] = field1362[var7];
         field1409[var4] = field1391[var7];
         field1407[var4++] = this.field1359[var1];
      } else {
         var11 = field1365[var7];
         var12 = field1394[var7];
         var13 = this.field1359[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1369[var9 - var10];
            field1404[var4] = var2 + (var11 + ((field1365[var6] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var6] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1368[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1369[var8 - var10];
            field1404[var4] = var2 + (var11 + ((field1365[var5] - var11) * var14 >> 16)) * class84.field1439 / 50;
            field1409[var4] = var3 + (var12 + ((field1394[var5] - var12) * var14 >> 16)) * class84.field1439 / 50;
            field1407[var4++] = var13 + ((this.field1367[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1404[0];
      var12 = field1404[1];
      var13 = field1404[2];
      var14 = field1409[0];
      int var15 = field1409[1];
      int var16 = field1409[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1371 != null && this.field1371[var1] != -1) {
            if(this.field1406 != null && this.field1406[var1] != -1) {
               var20 = this.field1406[var1] & 255;
               var17 = this.field1376[var20];
               var18 = this.field1408[var20];
               var19 = this.field1372[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1359[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1367[var1], this.field1367[var1], this.field1367[var1], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], this.field1371[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], this.field1371[var1]);
            }
         } else if(this.field1359[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1417[this.field1367[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1404[3] < 0 || field1404[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1371 != null && this.field1371[var1] != -1) {
            if(this.field1406 != null && this.field1406[var1] != -1) {
               var20 = this.field1406[var1] & 255;
               var17 = this.field1376[var20];
               var18 = this.field1408[var20];
               var19 = this.field1372[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1371[var1];
            if(this.field1359[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1367[var1], this.field1367[var1], this.field1367[var1], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1409[3], var11, var13, field1404[3], this.field1367[var1], this.field1367[var1], this.field1367[var1], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1409[3], var11, var13, field1404[3], field1407[0], field1407[2], field1407[3], field1365[var17], field1365[var18], field1365[var19], field1394[var17], field1394[var18], field1394[var19], field1399[var17], field1399[var18], field1399[var19], var21);
            }
         } else if(this.field1359[var1] == -1) {
            var17 = field1417[this.field1367[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1409[3], var11, var13, field1404[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2]);
            class84.rasterGouraud(var14, var16, field1409[3], var11, var13, field1404[3], field1407[0], field1407[2], field1407[3]);
         }
      }

   }

   Model() {
   }

   @ObfuscatedName("cz")
   void vmethod1859(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1397[0] = -1;
      if(this.field1398 != 1) {
         this.method1546();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1384 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1384) * class84.field1439;
         if(var15 / var13 < class84.field1432) {
            int var16 = (var14 + this.field1384) * class84.field1439;
            if(var16 / var13 > class84.field1442) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1384 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1439;
               if(var19 / var13 > class84.field1446) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1439;
                  if(var21 / var13 < class84.field1447) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1375 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1410) {
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

                        var28 = field1392 - class84.field1440;
                        var29 = field1418 - class84.field1441;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1381) {
                              field1414[field1395++] = var9;
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
                        var29 = field1415[var1];
                        var30 = field1416[var1];
                     }

                     for(int var31 = 0; var31 < this.field1412; ++var31) {
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
                        field1377[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1362[var31] = var27 + var32 * class84.field1439 / var34;
                           field1391[var31] = var28 + var35 * class84.field1439 / var34;
                        } else {
                           field1362[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1365[var31] = var32;
                           field1394[var31] = var35;
                           field1399[var31] = var34;
                        }
                     }

                     try {
                        this.method1559(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("w")
   void method1614() {
      if(this.field1398 != 2) {
         this.field1398 = 2;
         this.field1384 = 0;

         for(int var1 = 0; var1 < this.field1412; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1384) {
               this.field1384 = var5;
            }
         }

         this.field1384 = (int)(Math.sqrt((double)this.field1384) + 0.99D);
         this.field1386 = this.field1384;
         this.field1385 = this.field1384 + this.field1384;
      }
   }

   @ObfuscatedName("z")
   final void method1623(int var1) {
      if(field1389[var1]) {
         this.method1584(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1388[var1];
         if(this.field1405 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1405[var1] & 255;
         }

         if(this.field1371 != null && this.field1371[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1406 != null && this.field1406[var1] != -1) {
               int var8 = this.field1406[var1] & 255;
               var5 = this.field1376[var8];
               var6 = this.field1408[var8];
               var7 = this.field1372[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1359[var1] == -1) {
               class84.rasterTextureAffine(field1391[var2], field1391[var3], field1391[var4], field1362[var2], field1362[var3], field1362[var4], this.field1367[var1], this.field1367[var1], this.field1367[var1], field1365[var5], field1365[var6], field1365[var7], field1394[var5], field1394[var6], field1394[var7], field1399[var5], field1399[var6], field1399[var7], this.field1371[var1]);
            } else {
               class84.rasterTextureAffine(field1391[var2], field1391[var3], field1391[var4], field1362[var2], field1362[var3], field1362[var4], this.field1367[var1], this.field1368[var1], this.field1359[var1], field1365[var5], field1365[var6], field1365[var7], field1394[var5], field1394[var6], field1394[var7], field1399[var5], field1399[var6], field1399[var7], this.field1371[var1]);
            }
         } else if(this.field1359[var1] == -1) {
            class84.rasterFlat(field1391[var2], field1391[var3], field1391[var4], field1362[var2], field1362[var3], field1362[var4], field1417[this.field1367[var1]]);
         } else {
            class84.rasterGouraud(field1391[var2], field1391[var3], field1391[var4], field1362[var2], field1362[var3], field1362[var4], this.field1367[var1], this.field1368[var1], this.field1359[var1]);
         }

      }
   }
}

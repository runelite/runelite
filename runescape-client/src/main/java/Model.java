import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ab")
   static int[] field1373 = new int[2000];
   @ObfuscatedName("q")
   static Model field1375 = new Model();
   @ObfuscatedName("bd")
   public static int field1376 = 0;
   @ObfuscatedName("j")
   int field1377 = 0;
   @ObfuscatedName("n")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("bm")
   static int[] field1379;
   @ObfuscatedName("x")
   int[] field1380;
   @ObfuscatedName("c")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("bo")
   public static int[] field1382 = new int[1000];
   @ObfuscatedName("m")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("s")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("u")
   int[] field1385;
   @ObfuscatedName("r")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ar")
   static int[][] field1387 = new int[12][2000];
   @ObfuscatedName("i")
   int field1388 = 0;
   @ObfuscatedName("z")
   byte[] field1389;
   @ObfuscatedName("t")
   byte[] field1390;
   @ObfuscatedName("d")
   static byte[] field1391 = new byte[1];
   @ObfuscatedName("w")
   byte field1392 = 0;
   @ObfuscatedName("a")
   int field1393 = 0;
   @ObfuscatedName("k")
   int[] field1394;
   @ObfuscatedName("l")
   int[] field1395;
   @ObfuscatedName("av")
   static int[] field1396 = new int[10];
   @ObfuscatedName("g")
   int[][] field1397;
   @ObfuscatedName("e")
   int[][] field1398;
   @ObfuscatedName("p")
   static byte[] field1399 = new byte[1];
   @ObfuscatedName("aq")
   int field1400;
   @ObfuscatedName("ap")
   static int[] field1401 = new int[4700];
   @ObfuscatedName("ae")
   public boolean field1402 = false;
   @ObfuscatedName("am")
   int field1403;
   @ObfuscatedName("ad")
   int field1404;
   @ObfuscatedName("ac")
   static boolean[] field1406 = new boolean[4700];
   @ObfuscatedName("ao")
   static boolean[] field1407 = new boolean[4700];
   @ObfuscatedName("as")
   static int[] field1408 = new int[4700];
   @ObfuscatedName("aa")
   static int[] field1409 = new int[4700];
   @ObfuscatedName("ah")
   static int[] field1410 = new int[4700];
   @ObfuscatedName("aj")
   static int[] field1411 = new int[4700];
   @ObfuscatedName("at")
   int field1412;
   @ObfuscatedName("v")
   int[] field1413;
   @ObfuscatedName("ag")
   static int[] field1415 = new int[1600];
   @ObfuscatedName("f")
   byte[] field1416;
   @ObfuscatedName("an")
   static int[] field1417 = new int[12];
   @ObfuscatedName("aw")
   static int[] field1418 = new int[4700];
   @ObfuscatedName("o")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("az")
   static int[] field1420 = new int[2000];
   @ObfuscatedName("ay")
   static int[] field1421 = new int[12];
   @ObfuscatedName("bu")
   public static int field1422 = 0;
   @ObfuscatedName("af")
   static int[] field1423 = new int[10];
   @ObfuscatedName("ax")
   static int[] field1424 = new int[10];
   @ObfuscatedName("bn")
   static int field1425;
   @ObfuscatedName("bp")
   static int field1426;
   @ObfuscatedName("bt")
   static int field1427;
   @ObfuscatedName("bj")
   public static boolean field1428 = false;
   @ObfuscatedName("bw")
   public static int field1429 = 0;
   @ObfuscatedName("au")
   int field1430;
   @ObfuscatedName("al")
   static int[][] field1431 = new int[1600][512];
   @ObfuscatedName("y")
   short[] field1432;
   @ObfuscatedName("bc")
   static int[] field1433;
   @ObfuscatedName("h")
   static Model field1434 = new Model();
   @ObfuscatedName("be")
   static int[] field1435;
   @ObfuscatedName("bb")
   static int[] field1436;
   @ObfuscatedName("b")
   int[] field1437;

   @ObfuscatedName("y")
   public void method1611(int var1) {
      int var2 = field1433[var1];
      int var3 = field1379[var1];

      for(int var4 = 0; var4 < this.field1377; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("q")
   public Model method1613(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1647();
      int var7 = var2 - this.field1430;
      int var8 = var2 + this.field1430;
      int var9 = var4 - this.field1430;
      int var10 = var4 + this.field1430;
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
               var11.field1377 = this.field1377;
               var11.field1388 = this.field1388;
               var11.field1393 = this.field1393;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1385 = this.field1385;
               var11.field1437 = this.field1437;
               var11.field1413 = this.field1413;
               var11.field1416 = this.field1416;
               var11.field1389 = this.field1389;
               var11.field1390 = this.field1390;
               var11.field1432 = this.field1432;
               var11.field1392 = this.field1392;
               var11.field1394 = this.field1394;
               var11.field1395 = this.field1395;
               var11.field1380 = this.field1380;
               var11.field1397 = this.field1397;
               var11.field1398 = this.field1398;
               var11.field1402 = this.field1402;
               var11.verticesY = new int[var11.field1377];
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
               for(var12 = 0; var12 < var11.field1377; ++var12) {
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
               for(var12 = 0; var12 < var11.field1377; ++var12) {
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

            var11.field1400 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("d")
   public Model method1614(boolean var1) {
      if(!var1 && field1391.length < this.field1388) {
         field1391 = new byte[this.field1388 + 100];
      }

      return this.method1616(var1, field1375, field1391);
   }

   @ObfuscatedName("p")
   public Model method1615(boolean var1) {
      if(!var1 && field1399.length < this.field1388) {
         field1399 = new byte[this.field1388 + 100];
      }

      return this.method1616(var1, field1434, field1399);
   }

   @ObfuscatedName("j")
   Model method1616(boolean var1, Model var2, byte[] var3) {
      var2.field1377 = this.field1377;
      var2.field1388 = this.field1388;
      var2.field1393 = this.field1393;
      if(var2.verticesX == null || var2.verticesX.length < this.field1377) {
         var2.verticesX = new int[this.field1377 + 100];
         var2.verticesY = new int[this.field1377 + 100];
         var2.verticesZ = new int[this.field1377 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1377; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1389 = this.field1389;
      } else {
         var2.field1389 = var3;
         if(this.field1389 == null) {
            for(var4 = 0; var4 < this.field1388; ++var4) {
               var2.field1389[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1388; ++var4) {
               var2.field1389[var4] = this.field1389[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1385 = this.field1385;
      var2.field1437 = this.field1437;
      var2.field1413 = this.field1413;
      var2.field1416 = this.field1416;
      var2.field1390 = this.field1390;
      var2.field1432 = this.field1432;
      var2.field1392 = this.field1392;
      var2.field1394 = this.field1394;
      var2.field1395 = this.field1395;
      var2.field1380 = this.field1380;
      var2.field1397 = this.field1397;
      var2.field1398 = this.field1398;
      var2.field1402 = this.field1402;
      var2.field1400 = 0;
      return var2;
   }

   @ObfuscatedName("g")
   final void method1618(int var1) {
      if(field1407[var1]) {
         this.method1634(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1406[var1];
         if(this.field1389 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1389[var1] & 255;
         }

         if(this.field1432 != null && this.field1432[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1390 != null && this.field1390[var1] != -1) {
               int var8 = this.field1390[var1] & 255;
               var5 = this.field1394[var8];
               var6 = this.field1395[var8];
               var7 = this.field1380[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1413[var1] == -1) {
               class84.rasterTextureAffine(field1409[var2], field1409[var3], field1409[var4], field1408[var2], field1408[var3], field1408[var4], this.field1385[var1], this.field1385[var1], this.field1385[var1], field1411[var5], field1411[var6], field1411[var7], field1418[var5], field1418[var6], field1418[var7], field1401[var5], field1401[var6], field1401[var7], this.field1432[var1]);
            } else {
               class84.rasterTextureAffine(field1409[var2], field1409[var3], field1409[var4], field1408[var2], field1408[var3], field1408[var4], this.field1385[var1], this.field1437[var1], this.field1413[var1], field1411[var5], field1411[var6], field1411[var7], field1418[var5], field1418[var6], field1418[var7], field1401[var5], field1401[var6], field1401[var7], this.field1432[var1]);
            }
         } else if(this.field1413[var1] == -1) {
            class84.rasterFlat(field1409[var2], field1409[var3], field1409[var4], field1408[var2], field1408[var3], field1408[var4], field1435[this.field1385[var1]]);
         } else {
            class84.rasterGouraud(field1409[var2], field1409[var3], field1409[var4], field1408[var2], field1408[var3], field1408[var4], this.field1385[var1], this.field1437[var1], this.field1413[var1]);
         }

      }
   }

   @ObfuscatedName("o")
   public int method1619() {
      this.method1647();
      return this.field1430;
   }

   @ObfuscatedName("u")
   public void method1621(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1579[var2];
            Frame var7 = var3.field1579[var4];
            FrameMap var8 = var6.field1343;
            field1425 = 0;
            field1426 = 0;
            field1427 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1342; ++var11) {
               for(var12 = var6.field1340[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1484[var12] == 0) {
                  this.method1622(var8.field1484[var12], var8.field1482[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1425 = 0;
            field1426 = 0;
            field1427 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1342; ++var11) {
               for(var12 = var7.field1340[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1484[var12] == 0) {
                  this.method1622(var8.field1484[var12], var8.field1482[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1400 = 0;
         } else {
            this.method1660(var1, var2);
         }
      }
   }

   @ObfuscatedName("b")
   void method1622(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1425 = 0;
         field1426 = 0;
         field1427 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1397.length) {
               int[] var18 = this.field1397[var9];

               for(var11 = 0; var11 < var18.length; ++var11) {
                  var12 = var18[var11];
                  field1425 += this.verticesX[var12];
                  field1426 += this.verticesY[var12];
                  field1427 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1425 = field1425 / var7 + var3;
            field1426 = field1426 / var7 + var4;
            field1427 = field1427 / var7 + var5;
         } else {
            field1425 = var3;
            field1426 = var4;
            field1427 = var5;
         }

      } else {
         int var10;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1397.length) {
                  var19 = this.field1397[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1397.length) {
                  var19 = this.field1397[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1425;
                     this.verticesY[var11] -= field1426;
                     this.verticesZ[var11] -= field1427;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1433[var14];
                        var16 = field1379[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1433[var12];
                        var16 = field1379[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1433[var13];
                        var16 = field1379[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1425;
                     this.verticesY[var11] += field1426;
                     this.verticesZ[var11] += field1427;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1397.length) {
                  var19 = this.field1397[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1425;
                     this.verticesY[var11] -= field1426;
                     this.verticesZ[var11] -= field1427;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1425;
                     this.verticesY[var11] += field1426;
                     this.verticesZ[var11] += field1427;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1398 != null && this.field1389 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1398.length) {
                     var19 = this.field1398[var8];

                     for(var10 = 0; var10 < var19.length; ++var10) {
                        var11 = var19[var10];
                        var12 = (this.field1389[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1389[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   public void method1623() {
      for(int var1 = 0; var1 < this.field1377; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("z")
   public void method1624() {
      for(int var1 = 0; var1 < this.field1377; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("t")
   public void method1625() {
      for(int var1 = 0; var1 < this.field1377; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("c")
   void method1626() {
      if(this.field1400 != 2) {
         this.field1400 = 2;
         this.field1430 = 0;

         for(int var1 = 0; var1 < this.field1377; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1430) {
               this.field1430 = var5;
            }
         }

         this.field1430 = (int)(Math.sqrt((double)this.field1430) + 0.99D);
         this.field1404 = this.field1430;
         this.field1403 = this.field1430 + this.field1430;
      }
   }

   @ObfuscatedName("w")
   public void method1627(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1377; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("a")
   public void method1628(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1377; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1400 = 0;
   }

   @ObfuscatedName("k")
   public final void method1629(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1415[0] = -1;
      if(this.field1400 != 2 && this.field1400 != 1) {
         this.method1626();
      }

      int var8 = class84.field1455;
      int var9 = class84.field1456;
      int var10000 = field1433[var1];
      var10000 = field1379[var1];
      int var12 = field1433[var2];
      int var13 = field1379[var2];
      int var14 = field1433[var3];
      int var15 = field1379[var3];
      int var16 = field1433[var4];
      int var17 = field1379[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1377; ++var19) {
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
         field1410[var19] = var22 - var18;
         field1408[var19] = var8 + var20 * class84.field1445 / var22;
         field1409[var19] = var9 + var23 * class84.field1445 / var22;
         if(this.field1393 > 0) {
            field1411[var19] = var20;
            field1418[var19] = var23;
            field1401[var19] = var22;
         }
      }

      try {
         this.method1632(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("l")
   public final void method1630(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1415[0] = -1;
      if(this.field1400 != 2 && this.field1400 != 1) {
         this.method1626();
      }

      int var9 = class84.field1455;
      int var10 = class84.field1456;
      int var10000 = field1433[var1];
      var10000 = field1379[var1];
      int var13 = field1433[var2];
      int var14 = field1379[var2];
      int var15 = field1433[var3];
      int var16 = field1379[var3];
      int var17 = field1433[var4];
      int var18 = field1379[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1377; ++var20) {
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
         field1410[var20] = var23 - var19;
         field1408[var20] = var9 + var21 * class84.field1445 / var8;
         field1409[var20] = var10 + var24 * class84.field1445 / var8;
         if(this.field1393 > 0) {
            field1411[var20] = var21;
            field1418[var20] = var24;
            field1401[var20] = var23;
         }
      }

      try {
         this.method1632(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("cj")
   void vmethod1948(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1415[0] = -1;
      if(this.field1400 != 1) {
         this.method1647();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1430 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1430) * class84.field1445;
         if(var15 / var13 < class84.field1459) {
            int var16 = (var14 + this.field1430) * class84.field1445;
            if(var16 / var13 > class84.field1453) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1430 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1445;
               if(var19 / var13 > class84.field1461) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1445;
                  if(var21 / var13 < class84.field1452) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1393 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1428) {
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

                        var28 = field1429 - class84.field1455;
                        var29 = field1376 - class84.field1456;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1402) {
                              field1382[field1422++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1455;
                     var28 = class84.field1456;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1433[var1];
                        var30 = field1379[var1];
                     }

                     for(int var31 = 0; var31 < this.field1377; ++var31) {
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
                        field1410[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1408[var31] = var27 + var32 * class84.field1445 / var34;
                           field1409[var31] = var28 + var35 * class84.field1445 / var34;
                        } else {
                           field1408[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1411[var31] = var32;
                           field1418[var31] = var35;
                           field1401[var31] = var34;
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
   final void method1632(boolean var1, boolean var2, int var3) {
      if(this.field1403 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1403; ++var4) {
            field1415[var4] = 0;
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
         for(var4 = 0; var4 < this.field1388; ++var4) {
            if(this.field1413[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1408[var5];
               var9 = field1408[var6];
               var24 = field1408[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var24 != -5000) {
                  if(var2 && this.method1635(field1429, field1376, field1409[var5], field1409[var6], field1409[var7], var8, var9, var24)) {
                     field1382[field1422++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1409[var7] - field1409[var6]) - (field1409[var5] - field1409[var6]) * (var24 - var9) > 0) {
                     field1407[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var24 <= class84.rasterClipX) {
                        field1406[var4] = false;
                     } else {
                        field1406[var4] = true;
                     }

                     var11 = (field1410[var5] + field1410[var6] + field1410[var7]) / 3 + this.field1404;
                     field1431[var11][field1415[var11]++] = var4;
                  }
               } else {
                  var11 = field1411[var5];
                  var12 = field1411[var6];
                  var13 = field1411[var7];
                  int var14 = field1418[var5];
                  var15 = field1418[var6];
                  int var16 = field1418[var7];
                  int var17 = field1401[var5];
                  int var18 = field1401[var6];
                  int var19 = field1401[var7];
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
                     int var23 = (field1410[var5] + field1410[var6] + field1410[var7]) / 3 + this.field1404;
                     field1431[var23][field1415[var23]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1416 == null) {
            for(var4 = this.field1403 - 1; var4 >= 0; --var4) {
               var5 = field1415[var4];
               if(var5 > 0) {
                  var26 = field1431[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1618(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1417[var4] = 0;
               field1421[var4] = 0;
            }

            for(var4 = this.field1403 - 1; var4 >= 0; --var4) {
               var5 = field1415[var4];
               if(var5 > 0) {
                  var26 = field1431[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1416[var8];
                     var24 = field1417[var28]++;
                     field1387[var28][var24] = var8;
                     if(var28 < 10) {
                        field1421[var28] += var4;
                     } else if(var28 == 10) {
                        field1373[var24] = var4;
                     } else {
                        field1420[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1417[1] > 0 || field1417[2] > 0) {
               var4 = (field1421[1] + field1421[2]) / (field1417[1] + field1417[2]);
            }

            var5 = 0;
            if(field1417[3] > 0 || field1417[4] > 0) {
               var5 = (field1421[3] + field1421[4]) / (field1417[3] + field1417[4]);
            }

            var6 = 0;
            if(field1417[6] > 0 || field1417[8] > 0) {
               var6 = (field1421[6] + field1421[8]) / (field1417[6] + field1417[8]);
            }

            var8 = 0;
            var9 = field1417[10];
            int[] var10 = field1387[10];
            int[] var25 = field1373;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1417[11];
               var10 = field1387[11];
               var25 = field1420;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1618(var10[var8++]);
                  if(var8 == var9 && var10 != field1387[11]) {
                     var8 = 0;
                     var9 = field1417[11];
                     var10 = field1387[11];
                     var25 = field1420;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1618(var10[var8++]);
                  if(var8 == var9 && var10 != field1387[11]) {
                     var8 = 0;
                     var9 = field1417[11];
                     var10 = field1387[11];
                     var25 = field1420;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1618(var10[var8++]);
                  if(var8 == var9 && var10 != field1387[11]) {
                     var8 = 0;
                     var9 = field1417[11];
                     var10 = field1387[11];
                     var25 = field1420;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1417[var12];
               int[] var27 = field1387[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1618(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1618(var10[var8++]);
               if(var8 == var9 && var10 != field1387[11]) {
                  var8 = 0;
                  var10 = field1387[11];
                  var9 = field1417[11];
                  var25 = field1420;
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

   @ObfuscatedName("e")
   final void method1634(int var1) {
      int var2 = class84.field1455;
      int var3 = class84.field1456;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1401[var5];
      int var9 = field1401[var6];
      int var10 = field1401[var7];
      if(this.field1389 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1389[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1396[var4] = field1408[var5];
         field1423[var4] = field1409[var5];
         field1424[var4++] = this.field1385[var1];
      } else {
         var11 = field1411[var5];
         var12 = field1418[var5];
         var13 = this.field1385[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1436[var10 - var8];
            field1396[var4] = var2 + (var11 + ((field1411[var7] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var7] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1413[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1436[var9 - var8];
            field1396[var4] = var2 + (var11 + ((field1411[var6] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var6] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1437[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1396[var4] = field1408[var6];
         field1423[var4] = field1409[var6];
         field1424[var4++] = this.field1437[var1];
      } else {
         var11 = field1411[var6];
         var12 = field1418[var6];
         var13 = this.field1437[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1436[var8 - var9];
            field1396[var4] = var2 + (var11 + ((field1411[var5] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var5] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1385[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1436[var10 - var9];
            field1396[var4] = var2 + (var11 + ((field1411[var7] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var7] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1413[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1396[var4] = field1408[var7];
         field1423[var4] = field1409[var7];
         field1424[var4++] = this.field1413[var1];
      } else {
         var11 = field1411[var7];
         var12 = field1418[var7];
         var13 = this.field1413[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1436[var9 - var10];
            field1396[var4] = var2 + (var11 + ((field1411[var6] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var6] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1437[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1436[var8 - var10];
            field1396[var4] = var2 + (var11 + ((field1411[var5] - var11) * var14 >> 16)) * class84.field1445 / 50;
            field1423[var4] = var3 + (var12 + ((field1418[var5] - var12) * var14 >> 16)) * class84.field1445 / 50;
            field1424[var4++] = var13 + ((this.field1385[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1396[0];
      var12 = field1396[1];
      var13 = field1396[2];
      var14 = field1423[0];
      int var15 = field1423[1];
      int var16 = field1423[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1432 != null && this.field1432[var1] != -1) {
            if(this.field1390 != null && this.field1390[var1] != -1) {
               var20 = this.field1390[var1] & 255;
               var17 = this.field1394[var20];
               var18 = this.field1395[var20];
               var19 = this.field1380[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1413[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1385[var1], this.field1385[var1], this.field1385[var1], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], this.field1432[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1424[0], field1424[1], field1424[2], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], this.field1432[var1]);
            }
         } else if(this.field1413[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1435[this.field1385[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1424[0], field1424[1], field1424[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1396[3] < 0 || field1396[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1432 != null && this.field1432[var1] != -1) {
            if(this.field1390 != null && this.field1390[var1] != -1) {
               var20 = this.field1390[var1] & 255;
               var17 = this.field1394[var20];
               var18 = this.field1395[var20];
               var19 = this.field1380[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1432[var1];
            if(this.field1413[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1385[var1], this.field1385[var1], this.field1385[var1], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1423[3], var11, var13, field1396[3], this.field1385[var1], this.field1385[var1], this.field1385[var1], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1424[0], field1424[1], field1424[2], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1423[3], var11, var13, field1396[3], field1424[0], field1424[2], field1424[3], field1411[var17], field1411[var18], field1411[var19], field1418[var17], field1418[var18], field1418[var19], field1401[var17], field1401[var18], field1401[var19], var21);
            }
         } else if(this.field1413[var1] == -1) {
            var17 = field1435[this.field1385[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1423[3], var11, var13, field1396[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1424[0], field1424[1], field1424[2]);
            class84.rasterGouraud(var14, var16, field1423[3], var11, var13, field1396[3], field1424[0], field1424[2], field1424[3]);
         }
      }

   }

   @ObfuscatedName("ae")
   final boolean method1635(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("n")
   public void method1647() {
      if(this.field1400 != 1) {
         this.field1400 = 1;
         super.modelHeight = 0;
         this.field1412 = 0;
         this.field1430 = 0;

         for(int var1 = 0; var1 < this.field1377; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1412) {
               this.field1412 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1430) {
               this.field1430 = var5;
            }
         }

         this.field1430 = (int)(Math.sqrt((double)this.field1430) + 0.99D);
         this.field1404 = (int)(Math.sqrt((double)(this.field1430 * this.field1430 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1403 = this.field1404 + (int)(Math.sqrt((double)(this.field1430 * this.field1430 + this.field1412 * this.field1412)) + 0.99D);
      }
   }

   static {
      field1433 = class84.field1468;
      field1379 = class84.field1462;
      field1435 = class84.colorPalette;
      field1436 = class84.field1467;
   }

   @ObfuscatedName("s")
   public void method1660(Frames var1, int var2) {
      if(this.field1397 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1579[var2];
            FrameMap var4 = var3.field1343;
            field1425 = 0;
            field1426 = 0;
            field1427 = 0;

            for(int var5 = 0; var5 < var3.field1342; ++var5) {
               int var6 = var3.field1340[var5];
               this.method1622(var4.field1484[var6], var4.field1482[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1400 = 0;
         }
      }
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1377 = 0;
      this.field1388 = 0;
      this.field1393 = 0;
      this.field1392 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1377 += var8.field1377;
            this.field1388 += var8.field1388;
            this.field1393 += var8.field1393;
            if(var8.field1416 != null) {
               var3 = true;
            } else {
               if(this.field1392 == -1) {
                  this.field1392 = var8.field1392;
               }

               if(this.field1392 != var8.field1392) {
                  var3 = true;
               }
            }

            var4 |= var8.field1389 != null;
            var5 |= var8.field1432 != null;
            var6 |= var8.field1390 != null;
         }
      }

      this.verticesX = new int[this.field1377];
      this.verticesY = new int[this.field1377];
      this.verticesZ = new int[this.field1377];
      this.indices1 = new int[this.field1388];
      this.indices2 = new int[this.field1388];
      this.indices3 = new int[this.field1388];
      this.field1385 = new int[this.field1388];
      this.field1437 = new int[this.field1388];
      this.field1413 = new int[this.field1388];
      if(var3) {
         this.field1416 = new byte[this.field1388];
      }

      if(var4) {
         this.field1389 = new byte[this.field1388];
      }

      if(var5) {
         this.field1432 = new short[this.field1388];
      }

      if(var6) {
         this.field1390 = new byte[this.field1388];
      }

      if(this.field1393 > 0) {
         this.field1394 = new int[this.field1393];
         this.field1395 = new int[this.field1393];
         this.field1380 = new int[this.field1393];
      }

      this.field1377 = 0;
      this.field1388 = 0;
      this.field1393 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1388; ++var9) {
               this.indices1[this.field1388] = var8.indices1[var9] + this.field1377;
               this.indices2[this.field1388] = var8.indices2[var9] + this.field1377;
               this.indices3[this.field1388] = var8.indices3[var9] + this.field1377;
               this.field1385[this.field1388] = var8.field1385[var9];
               this.field1437[this.field1388] = var8.field1437[var9];
               this.field1413[this.field1388] = var8.field1413[var9];
               if(var3) {
                  if(var8.field1416 != null) {
                     this.field1416[this.field1388] = var8.field1416[var9];
                  } else {
                     this.field1416[this.field1388] = var8.field1392;
                  }
               }

               if(var4 && var8.field1389 != null) {
                  this.field1389[this.field1388] = var8.field1389[var9];
               }

               if(var5) {
                  if(var8.field1432 != null) {
                     this.field1432[this.field1388] = var8.field1432[var9];
                  } else {
                     this.field1432[this.field1388] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1390 != null && var8.field1390[var9] != -1) {
                     this.field1390[this.field1388] = (byte)(var8.field1390[var9] + this.field1393);
                  } else {
                     this.field1390[this.field1388] = -1;
                  }
               }

               ++this.field1388;
            }

            for(var9 = 0; var9 < var8.field1393; ++var9) {
               this.field1394[this.field1393] = var8.field1394[var9] + this.field1377;
               this.field1395[this.field1393] = var8.field1395[var9] + this.field1377;
               this.field1380[this.field1393] = var8.field1380[var9] + this.field1377;
               ++this.field1393;
            }

            for(var9 = 0; var9 < var8.field1377; ++var9) {
               this.verticesX[this.field1377] = var8.verticesX[var9];
               this.verticesY[this.field1377] = var8.verticesY[var9];
               this.verticesZ[this.field1377] = var8.verticesZ[var9];
               ++this.field1377;
            }
         }
      }

   }

   Model() {
   }
}

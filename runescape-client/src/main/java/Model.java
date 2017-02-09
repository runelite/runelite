import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cu")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("az")
   static int[] field1352 = new int[12];
   @ObfuscatedName("y")
   static byte[] field1353 = new byte[1];
   @ObfuscatedName("o")
   static Model field1354 = new Model();
   @ObfuscatedName("bh")
   public static int field1355 = 0;
   @ObfuscatedName("ay")
   static int[] field1356 = new int[4700];
   @ObfuscatedName("k")
   static Model field1357 = new Model();
   @ObfuscatedName("q")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("af")
   static boolean[] field1359 = new boolean[4700];
   @ObfuscatedName("n")
   int field1360 = 0;
   @ObfuscatedName("ar")
   static int[] field1361 = new int[4700];
   @ObfuscatedName("g")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("i")
   int[] field1364;
   @ObfuscatedName("d")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("a")
   int[] field1366;
   @ObfuscatedName("s")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("p")
   byte[] field1368;
   @ObfuscatedName("t")
   byte[] field1369;
   @ObfuscatedName("z")
   byte field1370 = 0;
   @ObfuscatedName("r")
   static byte[] field1371 = new byte[1];
   @ObfuscatedName("u")
   int field1372 = 0;
   @ObfuscatedName("b")
   int[] field1373;
   @ObfuscatedName("m")
   int[] field1374;
   @ObfuscatedName("e")
   int[] field1375;
   @ObfuscatedName("c")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("x")
   int[][] field1377;
   @ObfuscatedName("ap")
   public boolean field1378 = false;
   @ObfuscatedName("aq")
   int field1379;
   @ObfuscatedName("aw")
   int field1380;
   @ObfuscatedName("ah")
   int field1382;
   @ObfuscatedName("aa")
   int field1383;
   @ObfuscatedName("al")
   static int[] field1385 = new int[2000];
   @ObfuscatedName("aj")
   static boolean[] field1386 = new boolean[4700];
   @ObfuscatedName("w")
   int field1387 = 0;
   @ObfuscatedName("f")
   short[] field1388;
   @ObfuscatedName("j")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("v")
   int[] field1390;
   @ObfuscatedName("ao")
   static int[] field1391 = new int[4700];
   @ObfuscatedName("h")
   byte[] field1392;
   @ObfuscatedName("bp")
   static int[] field1393;
   @ObfuscatedName("at")
   static int[] field1394 = new int[1600];
   @ObfuscatedName("au")
   static int[][] field1395 = new int[1600][512];
   @ObfuscatedName("ax")
   static int[] field1396 = new int[12];
   @ObfuscatedName("ae")
   static int[][] field1397 = new int[12][2000];
   @ObfuscatedName("ab")
   static int[] field1398 = new int[2000];
   @ObfuscatedName("bx")
   public static int field1399 = 0;
   @ObfuscatedName("as")
   int field1400;
   @ObfuscatedName("bb")
   static int field1401;
   @ObfuscatedName("ak")
   static int[] field1402 = new int[10];
   @ObfuscatedName("an")
   static int[] field1403 = new int[10];
   @ObfuscatedName("bz")
   static int field1404;
   @ObfuscatedName("bm")
   static int field1405;
   @ObfuscatedName("ad")
   static int[] field1406 = new int[4700];
   @ObfuscatedName("bl")
   public static boolean field1407 = false;
   @ObfuscatedName("ac")
   static int[] field1408 = new int[4700];
   @ObfuscatedName("bc")
   public static int field1409 = 0;
   @ObfuscatedName("av")
   static int[] field1410 = new int[10];
   @ObfuscatedName("bi")
   public static int[] field1411 = new int[1000];
   @ObfuscatedName("bf")
   static int[] field1412;
   @ObfuscatedName("bk")
   static int[] field1413;
   @ObfuscatedName("bd")
   static int[] field1414;
   @ObfuscatedName("am")
   static int[] field1415 = new int[4700];
   @ObfuscatedName("l")
   int[][] field1417;

   @ObfuscatedName("k")
   public Model method1564(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1568();
      int var7 = var2 - this.field1400;
      int var8 = var2 + this.field1400;
      int var9 = var4 - this.field1400;
      int var10 = var4 + this.field1400;
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
               var11.field1387 = this.field1387;
               var11.field1360 = this.field1360;
               var11.field1372 = this.field1372;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1364 = this.field1364;
               var11.field1390 = this.field1390;
               var11.field1366 = this.field1366;
               var11.field1392 = this.field1392;
               var11.field1368 = this.field1368;
               var11.field1369 = this.field1369;
               var11.field1388 = this.field1388;
               var11.field1370 = this.field1370;
               var11.field1373 = this.field1373;
               var11.field1374 = this.field1374;
               var11.field1375 = this.field1375;
               var11.field1417 = this.field1417;
               var11.field1377 = this.field1377;
               var11.field1378 = this.field1378;
               var11.verticesY = new int[var11.field1387];
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
               for(var12 = 0; var12 < var11.field1387; ++var12) {
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
               for(var12 = 0; var12 < var11.field1387; ++var12) {
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

            var11.field1379 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("y")
   public Model method1565(boolean var1) {
      if(!var1 && field1353.length < this.field1360) {
         field1353 = new byte[this.field1360 + 100];
      }

      return this.method1624(var1, field1357, field1353);
   }

   @ObfuscatedName("j")
   public void method1568() {
      if(this.field1379 != 1) {
         this.field1379 = 1;
         super.modelHeight = 0;
         this.field1380 = 0;
         this.field1400 = 0;

         for(int var1 = 0; var1 < this.field1387; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1380) {
               this.field1380 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1400) {
               this.field1400 = var5;
            }
         }

         this.field1400 = (int)(Math.sqrt((double)this.field1400) + 0.99D);
         this.field1383 = (int)(Math.sqrt((double)(this.field1400 * this.field1400 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1382 = this.field1383 + (int)(Math.sqrt((double)(this.field1400 * this.field1400 + this.field1380 * this.field1380)) + 0.99D);
      }
   }

   @ObfuscatedName("g")
   public int method1570() {
      this.method1568();
      return this.field1400;
   }

   @ObfuscatedName("i")
   public void method1571(Frames var1, int var2) {
      if(this.field1417 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1568[var2];
            FrameMap var4 = var3.field1320;
            field1401 = 0;
            field1405 = 0;
            field1404 = 0;

            for(int var5 = 0; var5 < var3.field1321; ++var5) {
               int var6 = var3.field1326[var5];
               this.method1573(var4.field1471[var6], var4.field1468[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1379 = 0;
         }
      }
   }

   @ObfuscatedName("v")
   public void method1572(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1568[var2];
            Frame var7 = var3.field1568[var4];
            FrameMap var8 = var6.field1320;
            field1401 = 0;
            field1405 = 0;
            field1404 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1321; ++var11) {
               for(var12 = var6.field1326[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1471[var12] == 0) {
                  this.method1573(var8.field1471[var12], var8.field1468[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1401 = 0;
            field1405 = 0;
            field1404 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1321; ++var11) {
               for(var12 = var7.field1326[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1471[var12] == 0) {
                  this.method1573(var8.field1471[var12], var8.field1468[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1379 = 0;
         } else {
            this.method1571(var1, var2);
         }
      }
   }

   @ObfuscatedName("a")
   void method1573(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1401 = 0;
         field1405 = 0;
         field1404 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1417.length) {
               int[] var18 = this.field1417[var9];

               for(var11 = 0; var11 < var18.length; ++var11) {
                  var12 = var18[var11];
                  field1401 += this.verticesX[var12];
                  field1405 += this.verticesY[var12];
                  field1404 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1401 = field1401 / var7 + var3;
            field1405 = field1405 / var7 + var4;
            field1404 = field1404 / var7 + var5;
         } else {
            field1401 = var3;
            field1405 = var4;
            field1404 = var5;
         }

      } else {
         int var10;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1417.length) {
                  var19 = this.field1417[var8];

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
               if(var8 < this.field1417.length) {
                  var19 = this.field1417[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1401;
                     this.verticesY[var11] -= field1405;
                     this.verticesZ[var11] -= field1404;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1412[var14];
                        var16 = field1413[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1412[var12];
                        var16 = field1413[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1412[var13];
                        var16 = field1413[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1401;
                     this.verticesY[var11] += field1405;
                     this.verticesZ[var11] += field1404;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1417.length) {
                  var19 = this.field1417[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1401;
                     this.verticesY[var11] -= field1405;
                     this.verticesZ[var11] -= field1404;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1401;
                     this.verticesY[var11] += field1405;
                     this.verticesZ[var11] += field1404;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1377 != null && this.field1368 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1377.length) {
                     var19 = this.field1377[var8];

                     for(var10 = 0; var10 < var19.length; ++var10) {
                        var11 = var19[var10];
                        var12 = (this.field1368[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1368[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   public void method1574() {
      for(int var1 = 0; var1 < this.field1387; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("p")
   public void method1575() {
      for(int var1 = 0; var1 < this.field1387; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("ap")
   final void method1576(boolean var1, boolean var2, int var3) {
      if(this.field1382 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1382; ++var4) {
            field1394[var4] = 0;
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
         for(var4 = 0; var4 < this.field1360; ++var4) {
            if(this.field1366[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1415[var5];
               var9 = field1415[var6];
               var24 = field1415[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var24 == -5000)) {
                  var11 = field1356[var5];
                  var12 = field1356[var6];
                  var13 = field1356[var7];
                  int var14 = field1391[var5];
                  var15 = field1391[var6];
                  int var16 = field1391[var7];
                  int var17 = field1408[var5];
                  int var18 = field1408[var6];
                  int var19 = field1408[var7];
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
                     field1386[var4] = true;
                     int var23 = (field1406[var5] + field1406[var6] + field1406[var7]) / 3 + this.field1383;
                     field1395[var23][field1394[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method1585(field1355, field1409, field1361[var5], field1361[var6], field1361[var7], var8, var9, var24)) {
                     field1411[field1399++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1361[var7] - field1361[var6]) - (field1361[var5] - field1361[var6]) * (var24 - var9) > 0) {
                     field1386[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var24 <= class84.rasterClipX) {
                        field1359[var4] = false;
                     } else {
                        field1359[var4] = true;
                     }

                     var11 = (field1406[var5] + field1406[var6] + field1406[var7]) / 3 + this.field1383;
                     field1395[var11][field1394[var11]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1392 == null) {
            for(var4 = this.field1382 - 1; var4 >= 0; --var4) {
               var5 = field1394[var4];
               if(var5 > 0) {
                  var26 = field1395[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1584(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1396[var4] = 0;
               field1352[var4] = 0;
            }

            for(var4 = this.field1382 - 1; var4 >= 0; --var4) {
               var5 = field1394[var4];
               if(var5 > 0) {
                  var26 = field1395[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1392[var8];
                     var24 = field1396[var28]++;
                     field1397[var28][var24] = var8;
                     if(var28 < 10) {
                        field1352[var28] += var4;
                     } else if(var28 == 10) {
                        field1398[var24] = var4;
                     } else {
                        field1385[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1396[1] > 0 || field1396[2] > 0) {
               var4 = (field1352[1] + field1352[2]) / (field1396[1] + field1396[2]);
            }

            var5 = 0;
            if(field1396[3] > 0 || field1396[4] > 0) {
               var5 = (field1352[3] + field1352[4]) / (field1396[3] + field1396[4]);
            }

            var6 = 0;
            if(field1396[6] > 0 || field1396[8] > 0) {
               var6 = (field1352[6] + field1352[8]) / (field1396[6] + field1396[8]);
            }

            var8 = 0;
            var9 = field1396[10];
            int[] var10 = field1397[10];
            int[] var25 = field1398;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1396[11];
               var10 = field1397[11];
               var25 = field1385;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1584(var10[var8++]);
                  if(var8 == var9 && var10 != field1397[11]) {
                     var8 = 0;
                     var9 = field1396[11];
                     var10 = field1397[11];
                     var25 = field1385;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1584(var10[var8++]);
                  if(var8 == var9 && var10 != field1397[11]) {
                     var8 = 0;
                     var9 = field1396[11];
                     var10 = field1397[11];
                     var25 = field1385;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1584(var10[var8++]);
                  if(var8 == var9 && var10 != field1397[11]) {
                     var8 = 0;
                     var9 = field1396[11];
                     var10 = field1397[11];
                     var25 = field1385;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1396[var12];
               int[] var27 = field1397[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1584(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1584(var10[var8++]);
               if(var8 == var9 && var10 != field1397[11]) {
                  var8 = 0;
                  var10 = field1397[11];
                  var9 = field1396[11];
                  var25 = field1385;
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
   public void method1577(int var1) {
      int var2 = field1412[var1];
      int var3 = field1413[var1];

      for(int var4 = 0; var4 < this.field1387; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("m")
   public void method1578(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1387; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("l")
   public final void method1580(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1394[0] = -1;
      if(this.field1379 != 2 && this.field1379 != 1) {
         this.method1641();
      }

      int var8 = class84.field1438;
      int var9 = class84.field1442;
      int var10000 = field1412[var1];
      var10000 = field1413[var1];
      int var12 = field1412[var2];
      int var13 = field1413[var2];
      int var14 = field1412[var3];
      int var15 = field1413[var3];
      int var16 = field1412[var4];
      int var17 = field1413[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1387; ++var19) {
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
         field1406[var19] = var22 - var18;
         field1415[var19] = var8 + var20 * class84.field1437 / var22;
         field1361[var19] = var9 + var23 * class84.field1437 / var22;
         if(this.field1372 > 0) {
            field1356[var19] = var20;
            field1391[var19] = var23;
            field1408[var19] = var22;
         }
      }

      try {
         this.method1576(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("x")
   public final void method1581(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1394[0] = -1;
      if(this.field1379 != 2 && this.field1379 != 1) {
         this.method1641();
      }

      int var9 = class84.field1438;
      int var10 = class84.field1442;
      int var10000 = field1412[var1];
      var10000 = field1413[var1];
      int var13 = field1412[var2];
      int var14 = field1413[var2];
      int var15 = field1412[var3];
      int var16 = field1413[var3];
      int var17 = field1412[var4];
      int var18 = field1413[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1387; ++var20) {
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
         field1406[var20] = var23 - var19;
         field1415[var20] = var9 + var21 * class84.field1437 / var8;
         field1361[var20] = var10 + var24 * class84.field1437 / var8;
         if(this.field1372 > 0) {
            field1356[var20] = var21;
            field1391[var20] = var24;
            field1408[var20] = var23;
         }
      }

      try {
         this.method1576(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("aq")
   final void method1584(int var1) {
      if(field1386[var1]) {
         this.method1587(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1359[var1];
         if(this.field1368 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1368[var1] & 255;
         }

         if(this.field1388 != null && this.field1388[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1369 != null && this.field1369[var1] != -1) {
               int var8 = this.field1369[var1] & 255;
               var5 = this.field1373[var8];
               var6 = this.field1374[var8];
               var7 = this.field1375[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1366[var1] == -1) {
               class84.rasterTextureAffine(field1361[var2], field1361[var3], field1361[var4], field1415[var2], field1415[var3], field1415[var4], this.field1364[var1], this.field1364[var1], this.field1364[var1], field1356[var5], field1356[var6], field1356[var7], field1391[var5], field1391[var6], field1391[var7], field1408[var5], field1408[var6], field1408[var7], this.field1388[var1]);
            } else {
               class84.rasterTextureAffine(field1361[var2], field1361[var3], field1361[var4], field1415[var2], field1415[var3], field1415[var4], this.field1364[var1], this.field1390[var1], this.field1366[var1], field1356[var5], field1356[var6], field1356[var7], field1391[var5], field1391[var6], field1391[var7], field1408[var5], field1408[var6], field1408[var7], this.field1388[var1]);
            }
         } else if(this.field1366[var1] == -1) {
            class84.rasterFlat(field1361[var2], field1361[var3], field1361[var4], field1415[var2], field1415[var3], field1415[var4], field1414[this.field1364[var1]]);
         } else {
            class84.rasterGouraud(field1361[var2], field1361[var3], field1361[var4], field1415[var2], field1415[var3], field1415[var4], this.field1364[var1], this.field1390[var1], this.field1366[var1]);
         }

      }
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1387 = 0;
      this.field1360 = 0;
      this.field1372 = 0;
      this.field1370 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1387 += var8.field1387;
            this.field1360 += var8.field1360;
            this.field1372 += var8.field1372;
            if(var8.field1392 != null) {
               var3 = true;
            } else {
               if(this.field1370 == -1) {
                  this.field1370 = var8.field1370;
               }

               if(this.field1370 != var8.field1370) {
                  var3 = true;
               }
            }

            var4 |= var8.field1368 != null;
            var5 |= var8.field1388 != null;
            var6 |= var8.field1369 != null;
         }
      }

      this.verticesX = new int[this.field1387];
      this.verticesY = new int[this.field1387];
      this.verticesZ = new int[this.field1387];
      this.indices1 = new int[this.field1360];
      this.indices2 = new int[this.field1360];
      this.indices3 = new int[this.field1360];
      this.field1364 = new int[this.field1360];
      this.field1390 = new int[this.field1360];
      this.field1366 = new int[this.field1360];
      if(var3) {
         this.field1392 = new byte[this.field1360];
      }

      if(var4) {
         this.field1368 = new byte[this.field1360];
      }

      if(var5) {
         this.field1388 = new short[this.field1360];
      }

      if(var6) {
         this.field1369 = new byte[this.field1360];
      }

      if(this.field1372 > 0) {
         this.field1373 = new int[this.field1372];
         this.field1374 = new int[this.field1372];
         this.field1375 = new int[this.field1372];
      }

      this.field1387 = 0;
      this.field1360 = 0;
      this.field1372 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1360; ++var9) {
               this.indices1[this.field1360] = var8.indices1[var9] + this.field1387;
               this.indices2[this.field1360] = var8.indices2[var9] + this.field1387;
               this.indices3[this.field1360] = var8.indices3[var9] + this.field1387;
               this.field1364[this.field1360] = var8.field1364[var9];
               this.field1390[this.field1360] = var8.field1390[var9];
               this.field1366[this.field1360] = var8.field1366[var9];
               if(var3) {
                  if(var8.field1392 != null) {
                     this.field1392[this.field1360] = var8.field1392[var9];
                  } else {
                     this.field1392[this.field1360] = var8.field1370;
                  }
               }

               if(var4 && var8.field1368 != null) {
                  this.field1368[this.field1360] = var8.field1368[var9];
               }

               if(var5) {
                  if(var8.field1388 != null) {
                     this.field1388[this.field1360] = var8.field1388[var9];
                  } else {
                     this.field1388[this.field1360] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1369 != null && var8.field1369[var9] != -1) {
                     this.field1369[this.field1360] = (byte)(var8.field1369[var9] + this.field1372);
                  } else {
                     this.field1369[this.field1360] = -1;
                  }
               }

               ++this.field1360;
            }

            for(var9 = 0; var9 < var8.field1372; ++var9) {
               this.field1373[this.field1372] = var8.field1373[var9] + this.field1387;
               this.field1374[this.field1372] = var8.field1374[var9] + this.field1387;
               this.field1375[this.field1372] = var8.field1375[var9] + this.field1387;
               ++this.field1372;
            }

            for(var9 = 0; var9 < var8.field1387; ++var9) {
               this.verticesX[this.field1387] = var8.verticesX[var9];
               this.verticesY[this.field1387] = var8.verticesY[var9];
               this.verticesZ[this.field1387] = var8.verticesZ[var9];
               ++this.field1387;
            }
         }
      }

   }

   @ObfuscatedName("as")
   final boolean method1585(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1412 = class84.field1428;
      field1413 = class84.field1452;
      field1414 = class84.colorPalette;
      field1393 = class84.field1450;
   }

   @ObfuscatedName("aw")
   final void method1587(int var1) {
      int var2 = class84.field1438;
      int var3 = class84.field1442;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1408[var5];
      int var9 = field1408[var6];
      int var10 = field1408[var7];
      if(this.field1368 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1368[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1410[var4] = field1415[var5];
         field1402[var4] = field1361[var5];
         field1403[var4++] = this.field1364[var1];
      } else {
         var11 = field1356[var5];
         var12 = field1391[var5];
         var13 = this.field1364[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1393[var10 - var8];
            field1410[var4] = var2 + (var11 + ((field1356[var7] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var7] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1366[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1393[var9 - var8];
            field1410[var4] = var2 + (var11 + ((field1356[var6] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var6] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1390[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1410[var4] = field1415[var6];
         field1402[var4] = field1361[var6];
         field1403[var4++] = this.field1390[var1];
      } else {
         var11 = field1356[var6];
         var12 = field1391[var6];
         var13 = this.field1390[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1393[var8 - var9];
            field1410[var4] = var2 + (var11 + ((field1356[var5] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var5] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1364[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1393[var10 - var9];
            field1410[var4] = var2 + (var11 + ((field1356[var7] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var7] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1366[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1410[var4] = field1415[var7];
         field1402[var4] = field1361[var7];
         field1403[var4++] = this.field1366[var1];
      } else {
         var11 = field1356[var7];
         var12 = field1391[var7];
         var13 = this.field1366[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1393[var9 - var10];
            field1410[var4] = var2 + (var11 + ((field1356[var6] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var6] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1390[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1393[var8 - var10];
            field1410[var4] = var2 + (var11 + ((field1356[var5] - var11) * var14 >> 16)) * class84.field1437 / 50;
            field1402[var4] = var3 + (var12 + ((field1391[var5] - var12) * var14 >> 16)) * class84.field1437 / 50;
            field1403[var4++] = var13 + ((this.field1364[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1410[0];
      var12 = field1410[1];
      var13 = field1410[2];
      var14 = field1402[0];
      int var15 = field1402[1];
      int var16 = field1402[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1388 != null && this.field1388[var1] != -1) {
            if(this.field1369 != null && this.field1369[var1] != -1) {
               var20 = this.field1369[var1] & 255;
               var17 = this.field1373[var20];
               var18 = this.field1374[var20];
               var19 = this.field1375[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1366[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1364[var1], this.field1364[var1], this.field1364[var1], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], this.field1388[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1403[0], field1403[1], field1403[2], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], this.field1388[var1]);
            }
         } else if(this.field1366[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1414[this.field1364[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1403[0], field1403[1], field1403[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1410[3] < 0 || field1410[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1388 != null && this.field1388[var1] != -1) {
            if(this.field1369 != null && this.field1369[var1] != -1) {
               var20 = this.field1369[var1] & 255;
               var17 = this.field1373[var20];
               var18 = this.field1374[var20];
               var19 = this.field1375[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1388[var1];
            if(this.field1366[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1364[var1], this.field1364[var1], this.field1364[var1], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1402[3], var11, var13, field1410[3], this.field1364[var1], this.field1364[var1], this.field1364[var1], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1403[0], field1403[1], field1403[2], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1402[3], var11, var13, field1410[3], field1403[0], field1403[2], field1403[3], field1356[var17], field1356[var18], field1356[var19], field1391[var17], field1391[var18], field1391[var19], field1408[var17], field1408[var18], field1408[var19], var21);
            }
         } else if(this.field1366[var1] == -1) {
            var17 = field1414[this.field1364[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1402[3], var11, var13, field1410[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1403[0], field1403[1], field1403[2]);
            class84.rasterGouraud(var14, var16, field1402[3], var11, var13, field1410[3], field1403[0], field1403[2], field1403[3]);
         }
      }

   }

   Model() {
   }

   @ObfuscatedName("u")
   public void method1602() {
      for(int var1 = 0; var1 < this.field1387; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("r")
   public Model method1607(boolean var1) {
      if(!var1 && field1371.length < this.field1360) {
         field1371 = new byte[this.field1360 + 100];
      }

      return this.method1624(var1, field1354, field1371);
   }

   @ObfuscatedName("co")
   void vmethod1879(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1394[0] = -1;
      if(this.field1379 != 1) {
         this.method1568();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1400 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1400) * class84.field1437;
         if(var15 / var13 < class84.field1443) {
            int var16 = (var14 + this.field1400) * class84.field1437;
            if(var16 / var13 > class84.field1449) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1400 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1437;
               if(var19 / var13 > class84.field1434) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1437;
                  if(var21 / var13 < class84.field1445) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1372 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1407) {
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

                        var28 = field1355 - class84.field1438;
                        var29 = field1409 - class84.field1442;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1378) {
                              field1411[field1399++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1438;
                     var28 = class84.field1442;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1412[var1];
                        var30 = field1413[var1];
                     }

                     for(int var31 = 0; var31 < this.field1387; ++var31) {
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
                        field1406[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1415[var31] = var27 + var32 * class84.field1437 / var34;
                           field1361[var31] = var28 + var35 * class84.field1437 / var34;
                        } else {
                           field1415[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1356[var31] = var32;
                           field1391[var31] = var35;
                           field1408[var31] = var34;
                        }
                     }

                     try {
                        this.method1576(var23, var26, var9);
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
   public void method1621(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1387; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1379 = 0;
   }

   @ObfuscatedName("w")
   Model method1624(boolean var1, Model var2, byte[] var3) {
      var2.field1387 = this.field1387;
      var2.field1360 = this.field1360;
      var2.field1372 = this.field1372;
      if(var2.verticesX == null || var2.verticesX.length < this.field1387) {
         var2.verticesX = new int[this.field1387 + 100];
         var2.verticesY = new int[this.field1387 + 100];
         var2.verticesZ = new int[this.field1387 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1387; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1368 = this.field1368;
      } else {
         var2.field1368 = var3;
         if(this.field1368 == null) {
            for(var4 = 0; var4 < this.field1360; ++var4) {
               var2.field1368[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1360; ++var4) {
               var2.field1368[var4] = this.field1368[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1364 = this.field1364;
      var2.field1390 = this.field1390;
      var2.field1366 = this.field1366;
      var2.field1392 = this.field1392;
      var2.field1369 = this.field1369;
      var2.field1388 = this.field1388;
      var2.field1370 = this.field1370;
      var2.field1373 = this.field1373;
      var2.field1374 = this.field1374;
      var2.field1375 = this.field1375;
      var2.field1417 = this.field1417;
      var2.field1377 = this.field1377;
      var2.field1378 = this.field1378;
      var2.field1379 = 0;
      return var2;
   }

   @ObfuscatedName("c")
   void method1641() {
      if(this.field1379 != 2) {
         this.field1379 = 2;
         this.field1400 = 0;

         for(int var1 = 0; var1 < this.field1387; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1400) {
               this.field1400 = var5;
            }
         }

         this.field1400 = (int)(Math.sqrt((double)this.field1400) + 0.99D);
         this.field1383 = this.field1400;
         this.field1382 = this.field1400 + this.field1400;
      }
   }
}

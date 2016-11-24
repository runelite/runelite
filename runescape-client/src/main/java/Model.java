import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ca")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("bd")
   public static boolean field1348 = false;
   @ObfuscatedName("d")
   static byte[] field1349 = new byte[1];
   @ObfuscatedName("l")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("w")
   int field1351 = 0;
   @ObfuscatedName("h")
   static byte[] field1352 = new byte[1];
   @ObfuscatedName("r")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("c")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("k")
   int[] field1355;
   @ObfuscatedName("g")
   int field1356 = 0;
   @ObfuscatedName("z")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("n")
   static Model field1358 = new Model();
   @ObfuscatedName("m")
   static Model field1359 = new Model();
   @ObfuscatedName("y")
   int[] field1360;
   @ObfuscatedName("e")
   int[] field1361;
   @ObfuscatedName("x")
   int[] field1362;
   @ObfuscatedName("s")
   byte[] field1364;
   @ObfuscatedName("o")
   byte[] field1365;
   @ObfuscatedName("i")
   short[] field1366;
   @ObfuscatedName("a")
   byte field1367 = 0;
   @ObfuscatedName("b")
   int field1368 = 0;
   @ObfuscatedName("t")
   int[][] field1369;
   @ObfuscatedName("ao")
   static int[] field1370 = new int[10];
   @ObfuscatedName("v")
   int[] field1371;
   @ObfuscatedName("u")
   int[][] field1372;
   @ObfuscatedName("ag")
   static boolean[] field1373 = new boolean[4700];
   @ObfuscatedName("q")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("ay")
   int field1376;
   @ObfuscatedName("p")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("as")
   int field1378;
   @ObfuscatedName("aq")
   int field1379;
   @ObfuscatedName("ae")
   static boolean[] field1381 = new boolean[4700];
   @ObfuscatedName("by")
   public static int[] field1382 = new int[1000];
   @ObfuscatedName("am")
   static int[] field1383 = new int[4700];
   @ObfuscatedName("af")
   static int[] field1384 = new int[4700];
   @ObfuscatedName("aw")
   int field1385;
   @ObfuscatedName("az")
   static int[] field1386 = new int[4700];
   @ObfuscatedName("ab")
   static int[] field1387 = new int[4700];
   @ObfuscatedName("ax")
   static int[] field1388 = new int[4700];
   @ObfuscatedName("ai")
   int field1389;
   @ObfuscatedName("ah")
   static int[] field1390 = new int[1600];
   @ObfuscatedName("al")
   static int[][] field1391 = new int[1600][512];
   @ObfuscatedName("aa")
   static int[] field1392 = new int[12];
   @ObfuscatedName("an")
   static int[][] field1393 = new int[12][2000];
   @ObfuscatedName("at")
   static int[] field1394 = new int[2000];
   @ObfuscatedName("au")
   static int[] field1395 = new int[2000];
   @ObfuscatedName("ak")
   static int[] field1396 = new int[12];
   @ObfuscatedName("ar")
   static int[] field1397 = new int[10];
   @ObfuscatedName("aj")
   static int[] field1398 = new int[10];
   @ObfuscatedName("av")
   public boolean field1399 = false;
   @ObfuscatedName("bn")
   static int field1400;
   @ObfuscatedName("bt")
   static int field1401;
   @ObfuscatedName("bv")
   static int field1402;
   @ObfuscatedName("ap")
   static int[] field1403 = new int[4700];
   @ObfuscatedName("bl")
   public static int field1404 = 0;
   @ObfuscatedName("be")
   static int[] field1405;
   @ObfuscatedName("j")
   int[] field1406;
   @ObfuscatedName("bo")
   public static int field1407 = 0;
   @ObfuscatedName("br")
   static int[] field1408;
   @ObfuscatedName("bi")
   static int[] field1409;
   @ObfuscatedName("f")
   byte[] field1410;
   @ObfuscatedName("ba")
   static int[] field1411;
   @ObfuscatedName("bm")
   public static int field1413 = 0;

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1351 = 0;
      this.field1356 = 0;
      this.field1368 = 0;
      this.field1367 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1351 += var8.field1351;
            this.field1356 += var8.field1356;
            this.field1368 += var8.field1368;
            if(var8.field1410 != null) {
               var3 = true;
            } else {
               if(this.field1367 == -1) {
                  this.field1367 = var8.field1367;
               }

               if(this.field1367 != var8.field1367) {
                  var3 = true;
               }
            }

            var4 |= var8.field1364 != null;
            var5 |= var8.field1366 != null;
            var6 |= var8.field1365 != null;
         }
      }

      this.verticesX = new int[this.field1351];
      this.verticesY = new int[this.field1351];
      this.verticesZ = new int[this.field1351];
      this.indices1 = new int[this.field1356];
      this.indices2 = new int[this.field1356];
      this.indices3 = new int[this.field1356];
      this.field1360 = new int[this.field1356];
      this.field1361 = new int[this.field1356];
      this.field1362 = new int[this.field1356];
      if(var3) {
         this.field1410 = new byte[this.field1356];
      }

      if(var4) {
         this.field1364 = new byte[this.field1356];
      }

      if(var5) {
         this.field1366 = new short[this.field1356];
      }

      if(var6) {
         this.field1365 = new byte[this.field1356];
      }

      if(this.field1368 > 0) {
         this.field1406 = new int[this.field1368];
         this.field1355 = new int[this.field1368];
         this.field1371 = new int[this.field1368];
      }

      this.field1351 = 0;
      this.field1356 = 0;
      this.field1368 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1356; ++var9) {
               this.indices1[this.field1356] = var8.indices1[var9] + this.field1351;
               this.indices2[this.field1356] = var8.indices2[var9] + this.field1351;
               this.indices3[this.field1356] = var8.indices3[var9] + this.field1351;
               this.field1360[this.field1356] = var8.field1360[var9];
               this.field1361[this.field1356] = var8.field1361[var9];
               this.field1362[this.field1356] = var8.field1362[var9];
               if(var3) {
                  if(var8.field1410 != null) {
                     this.field1410[this.field1356] = var8.field1410[var9];
                  } else {
                     this.field1410[this.field1356] = var8.field1367;
                  }
               }

               if(var4 && var8.field1364 != null) {
                  this.field1364[this.field1356] = var8.field1364[var9];
               }

               if(var5) {
                  if(var8.field1366 != null) {
                     this.field1366[this.field1356] = var8.field1366[var9];
                  } else {
                     this.field1366[this.field1356] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1365 != null && var8.field1365[var9] != -1) {
                     this.field1365[this.field1356] = (byte)(var8.field1365[var9] + this.field1368);
                  } else {
                     this.field1365[this.field1356] = -1;
                  }
               }

               ++this.field1356;
            }

            for(var9 = 0; var9 < var8.field1368; ++var9) {
               this.field1406[this.field1368] = var8.field1406[var9] + this.field1351;
               this.field1355[this.field1368] = var8.field1355[var9] + this.field1351;
               this.field1371[this.field1368] = var8.field1371[var9] + this.field1351;
               ++this.field1368;
            }

            for(var9 = 0; var9 < var8.field1351; ++var9) {
               this.verticesX[this.field1351] = var8.verticesX[var9];
               this.verticesY[this.field1351] = var8.verticesY[var9];
               this.verticesZ[this.field1351] = var8.verticesZ[var9];
               ++this.field1351;
            }
         }
      }

   }

   @ObfuscatedName("n")
   public Model method1581(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1584();
      int var7 = var2 - this.field1378;
      int var8 = var2 + this.field1378;
      int var9 = var4 - this.field1378;
      int var10 = var4 + this.field1378;
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
               var11.field1351 = this.field1351;
               var11.field1356 = this.field1356;
               var11.field1368 = this.field1368;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1360 = this.field1360;
               var11.field1361 = this.field1361;
               var11.field1362 = this.field1362;
               var11.field1410 = this.field1410;
               var11.field1364 = this.field1364;
               var11.field1365 = this.field1365;
               var11.field1366 = this.field1366;
               var11.field1367 = this.field1367;
               var11.field1406 = this.field1406;
               var11.field1355 = this.field1355;
               var11.field1371 = this.field1371;
               var11.field1372 = this.field1372;
               var11.field1369 = this.field1369;
               var11.field1399 = this.field1399;
               var11.verticesY = new int[var11.field1351];
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
               for(var12 = 0; var12 < var11.field1351; ++var12) {
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
               for(var12 = 0; var12 < var11.field1351; ++var12) {
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

            var11.field1385 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("d")
   public Model method1582(boolean var1) {
      if(!var1 && field1349.length < this.field1356) {
         field1349 = new byte[this.field1356 + 100];
      }

      return this.method1607(var1, field1358, field1349);
   }

   @ObfuscatedName("h")
   public Model method1583(boolean var1) {
      if(!var1 && field1352.length < this.field1356) {
         field1352 = new byte[this.field1356 + 100];
      }

      return this.method1607(var1, field1359, field1352);
   }

   Model() {
   }

   @ObfuscatedName("r")
   public void method1584() {
      if(this.field1385 != 1) {
         this.field1385 = 1;
         super.modelHeight = 0;
         this.field1376 = 0;
         this.field1378 = 0;

         for(int var1 = 0; var1 < this.field1351; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1376) {
               this.field1376 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1378) {
               this.field1378 = var5;
            }
         }

         this.field1378 = (int)(Math.sqrt((double)this.field1378) + 0.99D);
         this.field1379 = (int)(Math.sqrt((double)(this.field1378 * this.field1378 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1389 = this.field1379 + (int)(Math.sqrt((double)(this.field1378 * this.field1378 + this.field1376 * this.field1376)) + 0.99D);
      }
   }

   @ObfuscatedName("o")
   public void method1588(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1351; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("x")
   public void method1589() {
      for(int var1 = 0; var1 < this.field1351; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("e")
   public void method1590() {
      for(int var1 = 0; var1 < this.field1351; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("f")
   public void method1592() {
      for(int var1 = 0; var1 < this.field1351; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("s")
   public void method1593(int var1) {
      int var2 = field1408[var1];
      int var3 = field1409[var1];

      for(int var4 = 0; var4 < this.field1351; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("t")
   final void method1594(boolean var1, boolean var2, int var3) {
      if(this.field1389 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1389; ++var4) {
            field1390[var4] = 0;
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
         for(var4 = 0; var4 < this.field1356; ++var4) {
            if(this.field1362[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1383[var5];
               var9 = field1383[var6];
               var24 = field1383[var7];
               int var25;
               if(var1 && (var8 == -5000 || var9 == -5000 || var24 == -5000)) {
                  var25 = field1386[var5];
                  var12 = field1386[var6];
                  var13 = field1386[var7];
                  int var14 = field1387[var5];
                  var15 = field1387[var6];
                  int var16 = field1387[var7];
                  int var17 = field1388[var5];
                  int var18 = field1388[var6];
                  int var19 = field1388[var7];
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
                     field1373[var4] = true;
                     int var23 = (field1403[var5] + field1403[var6] + field1403[var7]) / 3 + this.field1379;
                     field1391[var23][field1390[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method1602(field1413, field1404, field1384[var5], field1384[var6], field1384[var7], var8, var9, var24)) {
                     field1382[field1407++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1384[var7] - field1384[var6]) - (field1384[var5] - field1384[var6]) * (var24 - var9) > 0) {
                     field1373[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var24 <= class84.rasterClipX) {
                        field1381[var4] = false;
                     } else {
                        field1381[var4] = true;
                     }

                     var25 = (field1403[var5] + field1403[var6] + field1403[var7]) / 3 + this.field1379;
                     field1391[var25][field1390[var25]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1410 == null) {
            for(var4 = this.field1389 - 1; var4 >= 0; --var4) {
               var5 = field1390[var4];
               if(var5 > 0) {
                  var26 = field1391[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1600(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1392[var4] = 0;
               field1396[var4] = 0;
            }

            for(var4 = this.field1389 - 1; var4 >= 0; --var4) {
               var5 = field1390[var4];
               if(var5 > 0) {
                  var26 = field1391[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1410[var8];
                     var24 = field1392[var28]++;
                     field1393[var28][var24] = var8;
                     if(var28 < 10) {
                        field1396[var28] += var4;
                     } else if(var28 == 10) {
                        field1394[var24] = var4;
                     } else {
                        field1395[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1392[1] > 0 || field1392[2] > 0) {
               var4 = (field1396[1] + field1396[2]) / (field1392[1] + field1392[2]);
            }

            var5 = 0;
            if(field1392[3] > 0 || field1392[4] > 0) {
               var5 = (field1396[3] + field1396[4]) / (field1392[3] + field1392[4]);
            }

            var6 = 0;
            if(field1392[6] > 0 || field1392[8] > 0) {
               var6 = (field1396[6] + field1396[8]) / (field1392[6] + field1392[8]);
            }

            var8 = 0;
            var9 = field1392[10];
            int[] var10 = field1393[10];
            int[] var11 = field1394;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1392[11];
               var10 = field1393[11];
               var11 = field1395;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1600(var10[var8++]);
                  if(var8 == var9 && var10 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var10 = field1393[11];
                     var11 = field1395;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1600(var10[var8++]);
                  if(var8 == var9 && var10 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var10 = field1393[11];
                     var11 = field1395;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1600(var10[var8++]);
                  if(var8 == var9 && var10 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var10 = field1393[11];
                     var11 = field1395;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1392[var12];
               int[] var27 = field1393[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1600(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1600(var10[var8++]);
               if(var8 == var9 && var10 != field1393[11]) {
                  var8 = 0;
                  var10 = field1393[11];
                  var9 = field1392[11];
                  var11 = field1395;
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

   @ObfuscatedName("k")
   public void method1595(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1351; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1385 = 0;
   }

   @ObfuscatedName("v")
   public final void method1596(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1390[0] = -1;
      if(this.field1385 != 2 && this.field1385 != 1) {
         this.method1644();
      }

      int var8 = class84.field1431;
      int var9 = class84.field1435;
      int var10000 = field1408[var1];
      var10000 = field1409[var1];
      int var12 = field1408[var2];
      int var13 = field1409[var2];
      int var14 = field1408[var3];
      int var15 = field1409[var3];
      int var16 = field1408[var4];
      int var17 = field1409[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1351; ++var19) {
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
         field1403[var19] = var22 - var18;
         field1383[var19] = var8 + var20 * class84.field1430 / var22;
         field1384[var19] = var9 + var23 * class84.field1430 / var22;
         if(this.field1368 > 0) {
            field1386[var19] = var20;
            field1387[var19] = var23;
            field1388[var19] = var22;
         }
      }

      try {
         this.method1594(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("u")
   public final void method1597(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1390[0] = -1;
      if(this.field1385 != 2 && this.field1385 != 1) {
         this.method1644();
      }

      int var9 = class84.field1431;
      int var10 = class84.field1435;
      int var10000 = field1408[var1];
      var10000 = field1409[var1];
      int var13 = field1408[var2];
      int var14 = field1409[var2];
      int var15 = field1408[var3];
      int var16 = field1409[var3];
      int var17 = field1408[var4];
      int var18 = field1409[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1351; ++var20) {
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
         field1403[var20] = var23 - var19;
         field1383[var20] = var9 + var21 * class84.field1430 / var8;
         field1384[var20] = var10 + var24 * class84.field1430 / var8;
         if(this.field1368 > 0) {
            field1386[var20] = var21;
            field1387[var20] = var24;
            field1388[var20] = var23;
         }
      }

      try {
         this.method1594(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("av")
   final void method1600(int var1) {
      if(field1373[var1]) {
         this.method1601(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1381[var1];
         if(this.field1364 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1364[var1] & 255;
         }

         if(this.field1366 != null && this.field1366[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1365 != null && this.field1365[var1] != -1) {
               int var8 = this.field1365[var1] & 255;
               var5 = this.field1406[var8];
               var6 = this.field1355[var8];
               var7 = this.field1371[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var5], field1386[var6], field1386[var7], field1387[var5], field1387[var6], field1387[var7], field1388[var5], field1388[var6], field1388[var7], this.field1366[var1]);
            } else {
               class84.rasterTextureAffine(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1361[var1], this.field1362[var1], field1386[var5], field1386[var6], field1386[var7], field1387[var5], field1387[var6], field1387[var7], field1388[var5], field1388[var6], field1388[var7], this.field1366[var1]);
            }
         } else if(this.field1362[var1] == -1) {
            class84.rasterFlat(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], field1405[this.field1360[var1]]);
         } else {
            class84.rasterGouraud(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1361[var1], this.field1362[var1]);
         }

      }
   }

   @ObfuscatedName("aw")
   final void method1601(int var1) {
      int var2 = class84.field1431;
      int var3 = class84.field1435;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1388[var5];
      int var9 = field1388[var6];
      int var10 = field1388[var7];
      if(this.field1364 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1364[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1397[var4] = field1383[var5];
         field1398[var4] = field1384[var5];
         field1370[var4++] = this.field1360[var1];
      } else {
         var11 = field1386[var5];
         var12 = field1387[var5];
         var13 = this.field1360[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1411[var10 - var8];
            field1397[var4] = var2 + (var11 + ((field1386[var7] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var7] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1362[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1411[var9 - var8];
            field1397[var4] = var2 + (var11 + ((field1386[var6] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var6] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1397[var4] = field1383[var6];
         field1398[var4] = field1384[var6];
         field1370[var4++] = this.field1361[var1];
      } else {
         var11 = field1386[var6];
         var12 = field1387[var6];
         var13 = this.field1361[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1411[var8 - var9];
            field1397[var4] = var2 + (var11 + ((field1386[var5] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var5] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1360[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1411[var10 - var9];
            field1397[var4] = var2 + (var11 + ((field1386[var7] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var7] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1362[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1397[var4] = field1383[var7];
         field1398[var4] = field1384[var7];
         field1370[var4++] = this.field1362[var1];
      } else {
         var11 = field1386[var7];
         var12 = field1387[var7];
         var13 = this.field1362[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1411[var9 - var10];
            field1397[var4] = var2 + (var11 + ((field1386[var6] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var6] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1411[var8 - var10];
            field1397[var4] = var2 + (var11 + ((field1386[var5] - var11) * var14 >> 16)) * class84.field1430 / 50;
            field1398[var4] = var3 + (var12 + ((field1387[var5] - var12) * var14 >> 16)) * class84.field1430 / 50;
            field1370[var4++] = var13 + ((this.field1360[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1397[0];
      var12 = field1397[1];
      var13 = field1397[2];
      var14 = field1398[0];
      int var15 = field1398[1];
      int var16 = field1398[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1366 != null && this.field1366[var1] != -1) {
            if(this.field1365 != null && this.field1365[var1] != -1) {
               var20 = this.field1365[var1] & 255;
               var17 = this.field1406[var20];
               var18 = this.field1355[var20];
               var19 = this.field1371[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], this.field1366[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1370[0], field1370[1], field1370[2], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], this.field1366[var1]);
            }
         } else if(this.field1362[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1405[this.field1360[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1370[0], field1370[1], field1370[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1397[3] < 0 || field1397[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1366 != null && this.field1366[var1] != -1) {
            if(this.field1365 != null && this.field1365[var1] != -1) {
               var20 = this.field1365[var1] & 255;
               var17 = this.field1406[var20];
               var18 = this.field1355[var20];
               var19 = this.field1371[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1366[var1];
            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1398[3], var11, var13, field1397[3], this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1370[0], field1370[1], field1370[2], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1398[3], var11, var13, field1397[3], field1370[0], field1370[2], field1370[3], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
            }
         } else if(this.field1362[var1] == -1) {
            var17 = field1405[this.field1360[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1398[3], var11, var13, field1397[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1370[0], field1370[1], field1370[2]);
            class84.rasterGouraud(var14, var16, field1398[3], var11, var13, field1397[3], field1370[0], field1370[2], field1370[3]);
         }
      }

   }

   @ObfuscatedName("ay")
   final boolean method1602(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1408 = class84.field1444;
      field1409 = class84.field1445;
      field1405 = class84.colorPalette;
      field1411 = class84.field1443;
   }

   @ObfuscatedName("w")
   Model method1607(boolean var1, Model var2, byte[] var3) {
      var2.field1351 = this.field1351;
      var2.field1356 = this.field1356;
      var2.field1368 = this.field1368;
      if(var2.verticesX == null || var2.verticesX.length < this.field1351) {
         var2.verticesX = new int[this.field1351 + 100];
         var2.verticesY = new int[this.field1351 + 100];
         var2.verticesZ = new int[this.field1351 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1351; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1364 = this.field1364;
      } else {
         var2.field1364 = var3;
         if(this.field1364 == null) {
            for(var4 = 0; var4 < this.field1356; ++var4) {
               var2.field1364[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1356; ++var4) {
               var2.field1364[var4] = this.field1364[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1360 = this.field1360;
      var2.field1361 = this.field1361;
      var2.field1362 = this.field1362;
      var2.field1410 = this.field1410;
      var2.field1365 = this.field1365;
      var2.field1366 = this.field1366;
      var2.field1367 = this.field1367;
      var2.field1406 = this.field1406;
      var2.field1355 = this.field1355;
      var2.field1371 = this.field1371;
      var2.field1372 = this.field1372;
      var2.field1369 = this.field1369;
      var2.field1399 = this.field1399;
      var2.field1385 = 0;
      return var2;
   }

   @ObfuscatedName("z")
   public int method1609() {
      this.method1584();
      return this.field1378;
   }

   @ObfuscatedName("l")
   public void method1629(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1567[var2];
            Frame var7 = var3.field1567[var4];
            FrameMap var8 = var6.field1315;
            field1400 = 0;
            field1401 = 0;
            field1402 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1314; ++var11) {
               for(var12 = var6.field1310[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1467[var12] == 0) {
                  this.method1651(var8.field1467[var12], var8.field1462[var12], var6.field1316[var11], var6.field1317[var11], var6.field1318[var11]);
               }
            }

            field1400 = 0;
            field1401 = 0;
            field1402 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1314; ++var11) {
               for(var12 = var7.field1310[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1467[var12] == 0) {
                  this.method1651(var8.field1467[var12], var8.field1462[var12], var7.field1316[var11], var7.field1317[var11], var7.field1318[var11]);
               }
            }

            this.field1385 = 0;
         } else {
            this.method1653(var1, var2);
         }
      }
   }

   @ObfuscatedName("c")
   void method1644() {
      if(this.field1385 != 2) {
         this.field1385 = 2;
         this.field1378 = 0;

         for(int var1 = 0; var1 < this.field1351; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1378) {
               this.field1378 = var5;
            }
         }

         this.field1378 = (int)(Math.sqrt((double)this.field1378) + 0.99D);
         this.field1379 = this.field1378;
         this.field1389 = this.field1378 + this.field1378;
      }
   }

   @ObfuscatedName("y")
   void method1651(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1400 = 0;
         field1401 = 0;
         field1402 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1372.length) {
               int[] var19 = this.field1372[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1400 += this.verticesX[var12];
                  field1401 += this.verticesY[var12];
                  field1402 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1400 = field1400 / var7 + var3;
            field1401 = field1401 / var7 + var4;
            field1402 = field1402 / var7 + var5;
         } else {
            field1400 = var3;
            field1401 = var4;
            field1402 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1372.length) {
                  var9 = this.field1372[var8];

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
               if(var8 < this.field1372.length) {
                  var9 = this.field1372[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1400;
                     this.verticesY[var11] -= field1401;
                     this.verticesZ[var11] -= field1402;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1408[var14];
                        var16 = field1409[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1408[var12];
                        var16 = field1409[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1408[var13];
                        var16 = field1409[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1400;
                     this.verticesY[var11] += field1401;
                     this.verticesZ[var11] += field1402;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1372.length) {
                  var9 = this.field1372[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1400;
                     this.verticesY[var11] -= field1401;
                     this.verticesZ[var11] -= field1402;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1400;
                     this.verticesY[var11] += field1401;
                     this.verticesZ[var11] += field1402;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1369 != null && this.field1364 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1369.length) {
                     var9 = this.field1369[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1364[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1364[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("q")
   public void method1653(Frames var1, int var2) {
      if(this.field1372 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1567[var2];
            FrameMap var4 = var3.field1315;
            field1400 = 0;
            field1401 = 0;
            field1402 = 0;

            for(int var5 = 0; var5 < var3.field1314; ++var5) {
               int var6 = var3.field1310[var5];
               this.method1651(var4.field1467[var6], var4.field1462[var6], var3.field1316[var5], var3.field1317[var5], var3.field1318[var5]);
            }

            this.field1385 = 0;
         }
      }
   }

   @ObfuscatedName("cu")
   void vmethod1908(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1390[0] = -1;
      if(this.field1385 != 1) {
         this.method1584();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1378 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1378) * class84.field1430;
         if(var15 / var13 < class84.field1436) {
            int var16 = (var14 + this.field1378) * class84.field1430;
            if(var16 / var13 > class84.field1439) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1378 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1430;
               if(var19 / var13 > class84.field1437) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1430;
                  if(var21 / var13 < class84.field1438) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1368 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1348) {
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

                        var28 = field1413 - class84.field1431;
                        var29 = field1404 - class84.field1435;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1399) {
                              field1382[field1407++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1431;
                     var28 = class84.field1435;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1408[var1];
                        var30 = field1409[var1];
                     }

                     for(int var31 = 0; var31 < this.field1351; ++var31) {
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
                        field1403[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1383[var31] = var27 + var32 * class84.field1430 / var34;
                           field1384[var31] = var28 + var35 * class84.field1430 / var34;
                        } else {
                           field1383[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1386[var31] = var32;
                           field1387[var31] = var35;
                           field1388[var31] = var34;
                        }
                     }

                     try {
                        this.method1594(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}

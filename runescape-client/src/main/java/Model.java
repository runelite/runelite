import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cy")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("s")
   byte[] field1348;
   @ObfuscatedName("m")
   static byte[] field1349 = new byte[1];
   @ObfuscatedName("bk")
   static int[] field1350;
   @ObfuscatedName("g")
   static byte[] field1351 = new byte[1];
   @ObfuscatedName("h")
   int field1352 = 0;
   @ObfuscatedName("v")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("z")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("c")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("x")
   byte[] field1356;
   @ObfuscatedName("am")
   public boolean field1357 = false;
   @ObfuscatedName("d")
   short[] field1358;
   @ObfuscatedName("bv")
   public static int field1359 = 0;
   @ObfuscatedName("j")
   int[] field1360;
   @ObfuscatedName("f")
   int[] field1361;
   @ObfuscatedName("p")
   int[] field1362;
   @ObfuscatedName("i")
   byte[] field1363;
   @ObfuscatedName("l")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("y")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("e")
   int[][] field1366;
   @ObfuscatedName("w")
   byte field1367 = 0;
   @ObfuscatedName("ad")
   static int[] field1368 = new int[10];
   @ObfuscatedName("q")
   int[] field1369;
   @ObfuscatedName("t")
   int[] field1370;
   @ObfuscatedName("r")
   int[] field1371;
   @ObfuscatedName("a")
   int[][] field1372;
   @ObfuscatedName("k")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("as")
   static int[] field1374 = new int[10];
   @ObfuscatedName("ag")
   int field1375;
   @ObfuscatedName("au")
   int field1376;
   @ObfuscatedName("av")
   int field1377;
   @ObfuscatedName("ae")
   int field1378;
   @ObfuscatedName("bm")
   static int field1379;
   @ObfuscatedName("ah")
   static boolean[] field1381 = new boolean[4700];
   @ObfuscatedName("ak")
   static boolean[] field1382 = new boolean[4700];
   @ObfuscatedName("ab")
   static int[] field1383 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1384 = new int[4700];
   @ObfuscatedName("al")
   static int[][] field1385 = new int[1600][512];
   @ObfuscatedName("aw")
   static int[] field1386 = new int[4700];
   @ObfuscatedName("af")
   static int[] field1387 = new int[4700];
   @ObfuscatedName("ac")
   static int[] field1388 = new int[4700];
   @ObfuscatedName("ap")
   static int[] field1389 = new int[2000];
   @ObfuscatedName("at")
   static int[] field1390 = new int[1600];
   @ObfuscatedName("br")
   static int field1391;
   @ObfuscatedName("ax")
   static int[] field1392 = new int[12];
   @ObfuscatedName("az")
   static int[][] field1393 = new int[12][2000];
   @ObfuscatedName("ai")
   static int[] field1394 = new int[2000];
   @ObfuscatedName("bf")
   public static int field1395 = 0;
   @ObfuscatedName("aj")
   static int[] field1396 = new int[12];
   @ObfuscatedName("an")
   static int[] field1397 = new int[4700];
   @ObfuscatedName("b")
   static Model field1398 = new Model();
   @ObfuscatedName("aa")
   int field1399;
   @ObfuscatedName("u")
   int field1400 = 0;
   @ObfuscatedName("n")
   int field1401 = 0;
   @ObfuscatedName("bo")
   static int[] field1402;
   @ObfuscatedName("bh")
   public static boolean field1403 = false;
   @ObfuscatedName("be")
   static int[] field1404;
   @ObfuscatedName("o")
   static Model field1405 = new Model();
   @ObfuscatedName("bu")
   public static int field1406 = 0;
   @ObfuscatedName("bp")
   public static int[] field1407 = new int[1000];
   @ObfuscatedName("aq")
   static int[] field1408 = new int[10];
   @ObfuscatedName("bd")
   static int field1409;
   @ObfuscatedName("ba")
   static int[] field1411;

   @ObfuscatedName("c")
   public void method1521() {
      if(this.field1375 != 1) {
         this.field1375 = 1;
         super.modelHeight = 0;
         this.field1376 = 0;
         this.field1399 = 0;

         for(int var1 = 0; var1 < this.field1352; ++var1) {
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
            if(var5 > this.field1399) {
               this.field1399 = var5;
            }
         }

         this.field1399 = (int)(Math.sqrt((double)this.field1399) + 0.99D);
         this.field1377 = (int)(Math.sqrt((double)(this.field1399 * this.field1399 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1378 = this.field1377 + (int)(Math.sqrt((double)(this.field1399 * this.field1399 + this.field1376 * this.field1376)) + 0.99D);
      }
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1352 = 0;
      this.field1400 = 0;
      this.field1401 = 0;
      this.field1367 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1352 += var8.field1352;
            this.field1400 += var8.field1400;
            this.field1401 += var8.field1401;
            if(var8.field1363 != null) {
               var3 = true;
            } else {
               if(this.field1367 == -1) {
                  this.field1367 = var8.field1367;
               }

               if(this.field1367 != var8.field1367) {
                  var3 = true;
               }
            }

            var4 |= var8.field1348 != null;
            var5 |= var8.field1358 != null;
            var6 |= var8.field1356 != null;
         }
      }

      this.verticesX = new int[this.field1352];
      this.verticesY = new int[this.field1352];
      this.verticesZ = new int[this.field1352];
      this.indices1 = new int[this.field1400];
      this.indices2 = new int[this.field1400];
      this.indices3 = new int[this.field1400];
      this.field1360 = new int[this.field1400];
      this.field1361 = new int[this.field1400];
      this.field1362 = new int[this.field1400];
      if(var3) {
         this.field1363 = new byte[this.field1400];
      }

      if(var4) {
         this.field1348 = new byte[this.field1400];
      }

      if(var5) {
         this.field1358 = new short[this.field1400];
      }

      if(var6) {
         this.field1356 = new byte[this.field1400];
      }

      if(this.field1401 > 0) {
         this.field1369 = new int[this.field1401];
         this.field1370 = new int[this.field1401];
         this.field1371 = new int[this.field1401];
      }

      this.field1352 = 0;
      this.field1400 = 0;
      this.field1401 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1400; ++var9) {
               this.indices1[this.field1400] = var8.indices1[var9] + this.field1352;
               this.indices2[this.field1400] = var8.indices2[var9] + this.field1352;
               this.indices3[this.field1400] = var8.indices3[var9] + this.field1352;
               this.field1360[this.field1400] = var8.field1360[var9];
               this.field1361[this.field1400] = var8.field1361[var9];
               this.field1362[this.field1400] = var8.field1362[var9];
               if(var3) {
                  if(var8.field1363 != null) {
                     this.field1363[this.field1400] = var8.field1363[var9];
                  } else {
                     this.field1363[this.field1400] = var8.field1367;
                  }
               }

               if(var4 && var8.field1348 != null) {
                  this.field1348[this.field1400] = var8.field1348[var9];
               }

               if(var5) {
                  if(var8.field1358 != null) {
                     this.field1358[this.field1400] = var8.field1358[var9];
                  } else {
                     this.field1358[this.field1400] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1356 != null && var8.field1356[var9] != -1) {
                     this.field1356[this.field1400] = (byte)(var8.field1356[var9] + this.field1401);
                  } else {
                     this.field1356[this.field1400] = -1;
                  }
               }

               ++this.field1400;
            }

            for(var9 = 0; var9 < var8.field1401; ++var9) {
               this.field1369[this.field1401] = var8.field1369[var9] + this.field1352;
               this.field1370[this.field1401] = var8.field1370[var9] + this.field1352;
               this.field1371[this.field1401] = var8.field1371[var9] + this.field1352;
               ++this.field1401;
            }

            for(var9 = 0; var9 < var8.field1352; ++var9) {
               this.verticesX[this.field1352] = var8.verticesX[var9];
               this.verticesY[this.field1352] = var8.verticesY[var9];
               this.verticesZ[this.field1352] = var8.verticesZ[var9];
               ++this.field1352;
            }
         }
      }

   }

   @ObfuscatedName("o")
   public Model method1522(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1521();
      int var7 = var2 - this.field1399;
      int var8 = var2 + this.field1399;
      int var9 = var4 - this.field1399;
      int var10 = var4 + this.field1399;
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
               var11.field1352 = this.field1352;
               var11.field1400 = this.field1400;
               var11.field1401 = this.field1401;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1360 = this.field1360;
               var11.field1361 = this.field1361;
               var11.field1362 = this.field1362;
               var11.field1363 = this.field1363;
               var11.field1348 = this.field1348;
               var11.field1356 = this.field1356;
               var11.field1358 = this.field1358;
               var11.field1367 = this.field1367;
               var11.field1369 = this.field1369;
               var11.field1370 = this.field1370;
               var11.field1371 = this.field1371;
               var11.field1372 = this.field1372;
               var11.field1366 = this.field1366;
               var11.field1357 = this.field1357;
               var11.verticesY = new int[var11.field1352];
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
               for(var12 = 0; var12 < var11.field1352; ++var12) {
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
               for(var12 = 0; var12 < var11.field1352; ++var12) {
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

            var11.field1375 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("g")
   public Model method1524(boolean var1) {
      if(!var1 && field1351.length < this.field1400) {
         field1351 = new byte[this.field1400 + 100];
      }

      return this.method1525(var1, field1398, field1351);
   }

   @ObfuscatedName("l")
   Model method1525(boolean var1, Model var2, byte[] var3) {
      var2.field1352 = this.field1352;
      var2.field1400 = this.field1400;
      var2.field1401 = this.field1401;
      if(var2.verticesX == null || var2.verticesX.length < this.field1352) {
         var2.verticesX = new int[this.field1352 + 100];
         var2.verticesY = new int[this.field1352 + 100];
         var2.verticesZ = new int[this.field1352 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1352; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1348 = this.field1348;
      } else {
         var2.field1348 = var3;
         if(this.field1348 == null) {
            for(var4 = 0; var4 < this.field1400; ++var4) {
               var2.field1348[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1400; ++var4) {
               var2.field1348[var4] = this.field1348[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1360 = this.field1360;
      var2.field1361 = this.field1361;
      var2.field1362 = this.field1362;
      var2.field1363 = this.field1363;
      var2.field1356 = this.field1356;
      var2.field1358 = this.field1358;
      var2.field1367 = this.field1367;
      var2.field1369 = this.field1369;
      var2.field1370 = this.field1370;
      var2.field1371 = this.field1371;
      var2.field1372 = this.field1372;
      var2.field1366 = this.field1366;
      var2.field1357 = this.field1357;
      var2.field1375 = 0;
      return var2;
   }

   @ObfuscatedName("z")
   public void method1526(Frames var1, int var2) {
      if(this.field1372 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1562[var2];
            FrameMap var4 = var3.field1316;
            field1379 = 0;
            field1409 = 0;
            field1391 = 0;

            for(int var5 = 0; var5 < var3.field1314; ++var5) {
               int var6 = var3.field1318[var5];
               this.method1570(var4.field1456[var6], var4.field1460[var6], var3.field1319[var5], var3.field1317[var5], var3.field1320[var5]);
            }

            this.field1375 = 0;
         }
      }
   }

   @ObfuscatedName("k")
   public int method1528() {
      this.method1521();
      return this.field1399;
   }

   @ObfuscatedName("y")
   public void method1530(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1562[var2];
            Frame var7 = var3.field1562[var4];
            FrameMap var8 = var6.field1316;
            field1379 = 0;
            field1409 = 0;
            field1391 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1314; ++var11) {
               for(var12 = var6.field1318[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1456[var12] == 0) {
                  this.method1570(var8.field1456[var12], var8.field1460[var12], var6.field1319[var11], var6.field1317[var11], var6.field1320[var11]);
               }
            }

            field1379 = 0;
            field1409 = 0;
            field1391 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1314; ++var11) {
               for(var12 = var7.field1318[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1456[var12] == 0) {
                  this.method1570(var8.field1456[var12], var8.field1460[var12], var7.field1319[var11], var7.field1317[var11], var7.field1320[var11]);
               }
            }

            this.field1375 = 0;
         } else {
            this.method1526(var1, var2);
         }
      }
   }

   @ObfuscatedName("x")
   public void method1531() {
      for(int var1 = 0; var1 < this.field1352; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("i")
   public void method1532() {
      for(int var1 = 0; var1 < this.field1352; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("s")
   public void method1533() {
      for(int var1 = 0; var1 < this.field1352; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("m")
   public Model method1534(boolean var1) {
      if(!var1 && field1349.length < this.field1400) {
         field1349 = new byte[this.field1400 + 100];
      }

      return this.method1525(var1, field1405, field1349);
   }

   @ObfuscatedName("w")
   public void method1536(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1352; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("n")
   public void method1537(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1352; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("q")
   public final void method1538(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1390[0] = -1;
      if(this.field1375 != 2 && this.field1375 != 1) {
         this.method1551();
      }

      int var8 = class84.field1432;
      int var9 = class84.field1433;
      int var10000 = field1404[var1];
      var10000 = field1402[var1];
      int var12 = field1404[var2];
      int var13 = field1402[var2];
      int var14 = field1404[var3];
      int var15 = field1402[var3];
      int var16 = field1404[var4];
      int var17 = field1402[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1352; ++var19) {
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
         field1397[var19] = var22 - var18;
         field1383[var19] = var8 + var20 * class84.field1441 / var22;
         field1384[var19] = var9 + var23 * class84.field1441 / var22;
         if(this.field1401 > 0) {
            field1386[var19] = var20;
            field1387[var19] = var23;
            field1388[var19] = var22;
         }
      }

      try {
         this.method1541(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("t")
   public final void method1539(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1390[0] = -1;
      if(this.field1375 != 2 && this.field1375 != 1) {
         this.method1551();
      }

      int var9 = class84.field1432;
      int var10 = class84.field1433;
      int var10000 = field1404[var1];
      var10000 = field1402[var1];
      int var13 = field1404[var2];
      int var14 = field1402[var2];
      int var15 = field1404[var3];
      int var16 = field1402[var3];
      int var17 = field1404[var4];
      int var18 = field1402[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1352; ++var20) {
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
         field1397[var20] = var23 - var19;
         field1383[var20] = var9 + var21 * class84.field1441 / var8;
         field1384[var20] = var10 + var24 * class84.field1441 / var8;
         if(this.field1401 > 0) {
            field1386[var20] = var21;
            field1387[var20] = var24;
            field1388[var20] = var23;
         }
      }

      try {
         this.method1541(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("r")
   final void method1541(boolean var1, boolean var2, int var3) {
      if(this.field1378 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1378; ++var4) {
            field1390[var4] = 0;
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
         for(var4 = 0; var4 < this.field1400; ++var4) {
            if(this.field1362[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1383[var5];
               var9 = field1383[var6];
               var10 = field1383[var7];
               int var25;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
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
                     field1382[var4] = true;
                     int var23 = (field1397[var5] + field1397[var6] + field1397[var7]) / 3 + this.field1377;
                     field1385[var23][field1390[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method1544(field1359, field1395, field1384[var5], field1384[var6], field1384[var7], var8, var9, var10)) {
                     field1407[field1406++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1384[var7] - field1384[var6]) - (field1384[var5] - field1384[var6]) * (var10 - var9) > 0) {
                     field1382[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1381[var4] = false;
                     } else {
                        field1381[var4] = true;
                     }

                     var25 = (field1397[var5] + field1397[var6] + field1397[var7]) / 3 + this.field1377;
                     field1385[var25][field1390[var25]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1363 == null) {
            for(var4 = this.field1378 - 1; var4 >= 0; --var4) {
               var5 = field1390[var4];
               if(var5 > 0) {
                  var26 = field1385[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1590(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1392[var4] = 0;
               field1396[var4] = 0;
            }

            for(var4 = this.field1378 - 1; var4 >= 0; --var4) {
               var5 = field1390[var4];
               if(var5 > 0) {
                  var26 = field1385[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1363[var8];
                     var10 = field1392[var28]++;
                     field1393[var28][var10] = var8;
                     if(var28 < 10) {
                        field1396[var28] += var4;
                     } else if(var28 == 10) {
                        field1394[var10] = var4;
                     } else {
                        field1389[var10] = var4;
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
            int[] var24 = field1393[10];
            int[] var11 = field1394;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1392[11];
               var24 = field1393[11];
               var11 = field1389;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1590(var24[var8++]);
                  if(var8 == var9 && var24 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var24 = field1393[11];
                     var11 = field1389;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1590(var24[var8++]);
                  if(var8 == var9 && var24 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var24 = field1393[11];
                     var11 = field1389;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1590(var24[var8++]);
                  if(var8 == var9 && var24 != field1393[11]) {
                     var8 = 0;
                     var9 = field1392[11];
                     var24 = field1393[11];
                     var11 = field1389;
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
                  this.method1590(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1590(var24[var8++]);
               if(var8 == var9 && var24 != field1393[11]) {
                  var8 = 0;
                  var24 = field1393[11];
                  var9 = field1392[11];
                  var11 = field1389;
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

   @ObfuscatedName("d")
   public void method1542(int var1) {
      int var2 = field1404[var1];
      int var3 = field1402[var1];

      for(int var4 = 0; var4 < this.field1352; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1375 = 0;
   }

   @ObfuscatedName("am")
   final boolean method1544(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1404 = class84.field1435;
      field1402 = class84.field1446;
      field1350 = class84.colorPalette;
      field1411 = class84.field1444;
   }

   @ObfuscatedName("ct")
   void vmethod1830(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1390[0] = -1;
      if(this.field1375 != 1) {
         this.method1521();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1399 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1399) * class84.field1441;
         if(var15 / var13 < class84.field1445) {
            int var16 = (var14 + this.field1399) * class84.field1441;
            if(var16 / var13 > class84.field1436) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1399 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1441;
               if(var19 / var13 > class84.field1438) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1441;
                  if(var21 / var13 < class84.field1439) {
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
                     if(var9 > 0 && field1403) {
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

                        var28 = field1359 - class84.field1432;
                        var29 = field1395 - class84.field1433;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1357) {
                              field1407[field1406++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1432;
                     var28 = class84.field1433;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1404[var1];
                        var30 = field1402[var1];
                     }

                     for(int var31 = 0; var31 < this.field1352; ++var31) {
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
                        field1397[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1383[var31] = var27 + var32 * class84.field1441 / var34;
                           field1384[var31] = var28 + var35 * class84.field1441 / var34;
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
                        this.method1541(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   void method1551() {
      if(this.field1375 != 2) {
         this.field1375 = 2;
         this.field1399 = 0;

         for(int var1 = 0; var1 < this.field1352; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1399) {
               this.field1399 = var5;
            }
         }

         this.field1399 = (int)(Math.sqrt((double)this.field1399) + 0.99D);
         this.field1377 = this.field1399;
         this.field1378 = this.field1399 + this.field1399;
      }
   }

   Model() {
   }

   @ObfuscatedName("j")
   void method1570(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1379 = 0;
         field1409 = 0;
         field1391 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1372.length) {
               int[] var19 = this.field1372[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1379 += this.verticesX[var12];
                  field1409 += this.verticesY[var12];
                  field1391 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1379 = field1379 / var7 + var3;
            field1409 = field1409 / var7 + var4;
            field1391 = field1391 / var7 + var5;
         } else {
            field1379 = var3;
            field1409 = var4;
            field1391 = var5;
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
                     this.verticesX[var11] -= field1379;
                     this.verticesY[var11] -= field1409;
                     this.verticesZ[var11] -= field1391;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1404[var14];
                        var16 = field1402[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1404[var12];
                        var16 = field1402[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1404[var13];
                        var16 = field1402[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1379;
                     this.verticesY[var11] += field1409;
                     this.verticesZ[var11] += field1391;
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
                     this.verticesX[var11] -= field1379;
                     this.verticesY[var11] -= field1409;
                     this.verticesZ[var11] -= field1391;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1379;
                     this.verticesY[var11] += field1409;
                     this.verticesZ[var11] += field1391;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1366 != null && this.field1348 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1366.length) {
                     var9 = this.field1366[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1348[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1348[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   final void method1572(int var1) {
      int var2 = class84.field1432;
      int var3 = class84.field1433;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1388[var5];
      int var9 = field1388[var6];
      int var10 = field1388[var7];
      if(this.field1348 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1348[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1408[var4] = field1383[var5];
         field1374[var4] = field1384[var5];
         field1368[var4++] = this.field1360[var1];
      } else {
         var11 = field1386[var5];
         var12 = field1387[var5];
         var13 = this.field1360[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1411[var10 - var8];
            field1408[var4] = var2 + (var11 + ((field1386[var7] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var7] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1362[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1411[var9 - var8];
            field1408[var4] = var2 + (var11 + ((field1386[var6] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var6] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1408[var4] = field1383[var6];
         field1374[var4] = field1384[var6];
         field1368[var4++] = this.field1361[var1];
      } else {
         var11 = field1386[var6];
         var12 = field1387[var6];
         var13 = this.field1361[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1411[var8 - var9];
            field1408[var4] = var2 + (var11 + ((field1386[var5] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var5] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1360[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1411[var10 - var9];
            field1408[var4] = var2 + (var11 + ((field1386[var7] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var7] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1362[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1408[var4] = field1383[var7];
         field1374[var4] = field1384[var7];
         field1368[var4++] = this.field1362[var1];
      } else {
         var11 = field1386[var7];
         var12 = field1387[var7];
         var13 = this.field1362[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1411[var9 - var10];
            field1408[var4] = var2 + (var11 + ((field1386[var6] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var6] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1411[var8 - var10];
            field1408[var4] = var2 + (var11 + ((field1386[var5] - var11) * var14 >> 16)) * class84.field1441 / 50;
            field1374[var4] = var3 + (var12 + ((field1387[var5] - var12) * var14 >> 16)) * class84.field1441 / 50;
            field1368[var4++] = var13 + ((this.field1360[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1408[0];
      var12 = field1408[1];
      var13 = field1408[2];
      var14 = field1374[0];
      int var15 = field1374[1];
      int var16 = field1374[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1358 != null && this.field1358[var1] != -1) {
            if(this.field1356 != null && this.field1356[var1] != -1) {
               var20 = this.field1356[var1] & 255;
               var17 = this.field1369[var20];
               var18 = this.field1370[var20];
               var19 = this.field1371[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], this.field1358[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1368[0], field1368[1], field1368[2], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], this.field1358[var1]);
            }
         } else if(this.field1362[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1350[this.field1360[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1368[0], field1368[1], field1368[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1408[3] < 0 || field1408[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1358 != null && this.field1358[var1] != -1) {
            if(this.field1356 != null && this.field1356[var1] != -1) {
               var20 = this.field1356[var1] & 255;
               var17 = this.field1369[var20];
               var18 = this.field1370[var20];
               var19 = this.field1371[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1358[var1];
            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1374[3], var11, var13, field1408[3], this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1368[0], field1368[1], field1368[2], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1374[3], var11, var13, field1408[3], field1368[0], field1368[2], field1368[3], field1386[var17], field1386[var18], field1386[var19], field1387[var17], field1387[var18], field1387[var19], field1388[var17], field1388[var18], field1388[var19], var21);
            }
         } else if(this.field1362[var1] == -1) {
            var17 = field1350[this.field1360[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1374[3], var11, var13, field1408[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1368[0], field1368[1], field1368[2]);
            class84.rasterGouraud(var14, var16, field1374[3], var11, var13, field1408[3], field1368[0], field1368[2], field1368[3]);
         }
      }

   }

   @ObfuscatedName("a")
   final void method1590(int var1) {
      if(field1382[var1]) {
         this.method1572(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1381[var1];
         if(this.field1348 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1348[var1] & 255;
         }

         if(this.field1358 != null && this.field1358[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1356 != null && this.field1356[var1] != -1) {
               int var8 = this.field1356[var1] & 255;
               var5 = this.field1369[var8];
               var6 = this.field1370[var8];
               var7 = this.field1371[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1362[var1] == -1) {
               class84.rasterTextureAffine(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1360[var1], this.field1360[var1], field1386[var5], field1386[var6], field1386[var7], field1387[var5], field1387[var6], field1387[var7], field1388[var5], field1388[var6], field1388[var7], this.field1358[var1]);
            } else {
               class84.rasterTextureAffine(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1361[var1], this.field1362[var1], field1386[var5], field1386[var6], field1386[var7], field1387[var5], field1387[var6], field1387[var7], field1388[var5], field1388[var6], field1388[var7], this.field1358[var1]);
            }
         } else if(this.field1362[var1] == -1) {
            class84.rasterFlat(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], field1350[this.field1360[var1]]);
         } else {
            class84.rasterGouraud(field1384[var2], field1384[var3], field1384[var4], field1383[var2], field1383[var3], field1383[var4], this.field1360[var1], this.field1361[var1], this.field1362[var1]);
         }

      }
   }
}

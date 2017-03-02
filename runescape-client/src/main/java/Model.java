import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("aq")
   static int[] field1336 = new int[10];
   @ObfuscatedName("l")
   static byte[] field1337 = new byte[1];
   @ObfuscatedName("i")
   static Model field1338 = new Model();
   @ObfuscatedName("bg")
   static int field1339;
   @ObfuscatedName("k")
   int field1340 = 0;
   @ObfuscatedName("at")
   static int[] field1341 = new int[4700];
   @ObfuscatedName("d")
   int[][] field1342;
   @ObfuscatedName("ax")
   static int[] field1343 = new int[2000];
   @ObfuscatedName("a")
   int field1344 = 0;
   @ObfuscatedName("r")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("x")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("z")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("p")
   int[] field1348;
   @ObfuscatedName("s")
   int[] field1349;
   @ObfuscatedName("o")
   int[] field1350;
   @ObfuscatedName("w")
   byte[] field1352;
   @ObfuscatedName("m")
   byte[] field1353;
   @ObfuscatedName("u")
   short[] field1354;
   @ObfuscatedName("q")
   byte field1355 = 0;
   @ObfuscatedName("y")
   byte[] field1356;
   @ObfuscatedName("am")
   static int[] field1357 = new int[4700];
   @ObfuscatedName("e")
   int[] field1358;
   @ObfuscatedName("j")
   int[] field1359;
   @ObfuscatedName("ap")
   public boolean field1360 = false;
   @ObfuscatedName("g")
   int[][] field1361;
   @ObfuscatedName("bk")
   static int[] field1362;
   @ObfuscatedName("bm")
   static int[] field1363;
   @ObfuscatedName("ab")
   int field1364;
   @ObfuscatedName("af")
   int field1365;
   @ObfuscatedName("n")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ac")
   int field1367;
   @ObfuscatedName("ae")
   static boolean[] field1369 = new boolean[4700];
   @ObfuscatedName("au")
   static boolean[] field1370 = new boolean[4700];
   @ObfuscatedName("f")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("as")
   static int[] field1372 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1373 = new int[4700];
   @ObfuscatedName("ah")
   static int[][] field1374 = new int[12][2000];
   @ObfuscatedName("aj")
   int field1376;
   @ObfuscatedName("aa")
   static int[] field1377 = new int[4700];
   @ObfuscatedName("ag")
   static int[] field1378 = new int[1600];
   @ObfuscatedName("ad")
   static int[][] field1379 = new int[1600][512];
   @ObfuscatedName("al")
   static int[] field1380 = new int[12];
   @ObfuscatedName("t")
   static byte[] field1381 = new byte[1];
   @ObfuscatedName("ak")
   static int[] field1382 = new int[2000];
   @ObfuscatedName("b")
   static Model field1383 = new Model();
   @ObfuscatedName("av")
   static int[] field1384 = new int[12];
   @ObfuscatedName("az")
   static int[] field1385 = new int[10];
   @ObfuscatedName("ao")
   static int[] field1386 = new int[10];
   @ObfuscatedName("h")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("by")
   static int field1388;
   @ObfuscatedName("bj")
   static int field1389;
   @ObfuscatedName("ai")
   static int[] field1390 = new int[4700];
   @ObfuscatedName("bl")
   public static boolean field1391 = false;
   @ObfuscatedName("ba")
   public static int field1392 = 0;
   @ObfuscatedName("bi")
   public static int field1393 = 0;
   @ObfuscatedName("bf")
   public static int field1394 = 0;
   @ObfuscatedName("bd")
   public static int[] field1395 = new int[1000];
   @ObfuscatedName("v")
   int[] field1396;
   @ObfuscatedName("c")
   int field1397 = 0;
   @ObfuscatedName("bv")
   static int[] field1398;
   @ObfuscatedName("be")
   static int[] field1399;
   @ObfuscatedName("aw")
   int field1401;

   @ObfuscatedName("c")
   public void method1608() {
      for(int var1 = 0; var1 < this.field1340; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1376 = 0;
   }

   @ObfuscatedName("l")
   public Model method1610(boolean var1) {
      if(!var1 && field1337.length < this.field1344) {
         field1337 = new byte[this.field1344 + 100];
      }

      return this.method1617(var1, field1383, field1337);
   }

   @ObfuscatedName("e")
   public void method1612(int var1) {
      int var2 = field1362[var1];
      int var3 = field1363[var1];

      for(int var4 = 0; var4 < this.field1340; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1376 = 0;
   }

   @ObfuscatedName("s")
   public void method1614(Frames var1, int var2) {
      if(this.field1342 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1563[var2];
            FrameMap var4 = var3.field1305;
            field1388 = 0;
            field1389 = 0;
            field1339 = 0;

            for(int var5 = 0; var5 < var3.field1301; ++var5) {
               int var6 = var3.field1307[var5];
               this.method1657(var4.field1456[var6], var4.field1454[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1376 = 0;
         }
      }
   }

   @ObfuscatedName("z")
   void method1615() {
      if(this.field1376 != 2) {
         this.field1376 = 2;
         this.field1365 = 0;

         for(int var1 = 0; var1 < this.field1340; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1365) {
               this.field1365 = var5;
            }
         }

         this.field1365 = (int)(Math.sqrt((double)this.field1365) + 0.99D);
         this.field1367 = this.field1365;
         this.field1401 = this.field1365 + this.field1365;
      }
   }

   @ObfuscatedName("k")
   Model method1617(boolean var1, Model var2, byte[] var3) {
      var2.field1340 = this.field1340;
      var2.field1344 = this.field1344;
      var2.field1397 = this.field1397;
      if(var2.verticesX == null || var2.verticesX.length < this.field1340) {
         var2.verticesX = new int[this.field1340 + 100];
         var2.verticesY = new int[this.field1340 + 100];
         var2.verticesZ = new int[this.field1340 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1340; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1352 = this.field1352;
      } else {
         var2.field1352 = var3;
         if(this.field1352 == null) {
            for(var4 = 0; var4 < this.field1344; ++var4) {
               var2.field1352[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1344; ++var4) {
               var2.field1352[var4] = this.field1352[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1348 = this.field1348;
      var2.field1349 = this.field1349;
      var2.field1350 = this.field1350;
      var2.field1356 = this.field1356;
      var2.field1353 = this.field1353;
      var2.field1354 = this.field1354;
      var2.field1355 = this.field1355;
      var2.field1396 = this.field1396;
      var2.field1358 = this.field1358;
      var2.field1359 = this.field1359;
      var2.field1342 = this.field1342;
      var2.field1361 = this.field1361;
      var2.field1360 = this.field1360;
      var2.field1376 = 0;
      return var2;
   }

   @ObfuscatedName("o")
   public void method1618(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1563[var2];
            Frame var7 = var3.field1563[var4];
            FrameMap var8 = var6.field1305;
            field1388 = 0;
            field1389 = 0;
            field1339 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1301; ++var11) {
               for(var12 = var6.field1307[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1456[var12] == 0) {
                  this.method1657(var8.field1456[var12], var8.field1454[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1388 = 0;
            field1389 = 0;
            field1339 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1301; ++var11) {
               for(var12 = var7.field1307[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1456[var12] == 0) {
                  this.method1657(var8.field1456[var12], var8.field1454[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1376 = 0;
         } else {
            this.method1614(var1, var2);
         }
      }
   }

   @ObfuscatedName("v")
   public void method1622() {
      for(int var1 = 0; var1 < this.field1340; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1376 = 0;
   }

   @ObfuscatedName("b")
   public Model method1623(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1684();
      int var7 = var2 - this.field1365;
      int var8 = var2 + this.field1365;
      int var9 = var4 - this.field1365;
      int var10 = var4 + this.field1365;
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
               var11.field1340 = this.field1340;
               var11.field1344 = this.field1344;
               var11.field1397 = this.field1397;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1348 = this.field1348;
               var11.field1349 = this.field1349;
               var11.field1350 = this.field1350;
               var11.field1356 = this.field1356;
               var11.field1352 = this.field1352;
               var11.field1353 = this.field1353;
               var11.field1354 = this.field1354;
               var11.field1355 = this.field1355;
               var11.field1396 = this.field1396;
               var11.field1358 = this.field1358;
               var11.field1359 = this.field1359;
               var11.field1342 = this.field1342;
               var11.field1361 = this.field1361;
               var11.field1360 = this.field1360;
               var11.verticesY = new int[var11.field1340];
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
               for(var12 = 0; var12 < var11.field1340; ++var12) {
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
               for(var12 = 0; var12 < var11.field1340; ++var12) {
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

            var11.field1376 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("j")
   public void method1624(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1340; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1376 = 0;
   }

   @ObfuscatedName("ap")
   public final void method1627(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1378[0] = -1;
      if(this.field1376 != 2 && this.field1376 != 1) {
         this.method1615();
      }

      int var9 = class84.field1422;
      int var10 = class84.field1423;
      int var10000 = field1362[var1];
      var10000 = field1363[var1];
      int var13 = field1362[var2];
      int var14 = field1363[var2];
      int var15 = field1362[var3];
      int var16 = field1363[var3];
      int var17 = field1362[var4];
      int var18 = field1363[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1340; ++var20) {
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
         field1373[var20] = var23 - var19;
         field1357[var20] = var9 + var21 * class84.field1421 / var8;
         field1372[var20] = var10 + var24 * class84.field1421 / var8;
         if(this.field1397 > 0) {
            field1341[var20] = var21;
            field1390[var20] = var24;
            field1377[var20] = var23;
         }
      }

      try {
         this.method1629(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("cl")
   void vmethod1940(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1378[0] = -1;
      if(this.field1376 != 1) {
         this.method1684();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1365 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1365) * class84.field1421;
         if(var15 / var13 < class84.field1427) {
            int var16 = (var14 + this.field1365) * class84.field1421;
            if(var16 / var13 > class84.field1426) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1365 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1421;
               if(var19 / var13 > class84.field1416) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1421;
                  if(var21 / var13 < class84.field1431) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1397 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1391) {
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

                        var28 = field1392 - class84.field1422;
                        var29 = field1393 - class84.field1423;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1360) {
                              field1395[field1394++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1422;
                     var28 = class84.field1423;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1362[var1];
                        var30 = field1363[var1];
                     }

                     for(int var31 = 0; var31 < this.field1340; ++var31) {
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
                        field1373[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1357[var31] = var27 + var32 * class84.field1421 / var34;
                           field1372[var31] = var28 + var35 * class84.field1421 / var34;
                        } else {
                           field1357[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1341[var31] = var32;
                           field1390[var31] = var35;
                           field1377[var31] = var34;
                        }
                     }

                     try {
                        this.method1629(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("aj")
   final void method1629(boolean var1, boolean var2, int var3) {
      if(this.field1401 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1401; ++var4) {
            field1378[var4] = 0;
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
         for(var4 = 0; var4 < this.field1344; ++var4) {
            if(this.field1350[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1357[var5];
               var9 = field1357[var6];
               var10 = field1357[var7];
               int var25;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method1632(field1392, field1393, field1372[var5], field1372[var6], field1372[var7], var8, var9, var10)) {
                     field1395[field1394++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1372[var7] - field1372[var6]) - (field1372[var5] - field1372[var6]) * (var10 - var9) > 0) {
                     field1370[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1369[var4] = false;
                     } else {
                        field1369[var4] = true;
                     }

                     var25 = (field1373[var5] + field1373[var6] + field1373[var7]) / 3 + this.field1367;
                     field1379[var25][field1378[var25]++] = var4;
                  }
               } else {
                  var25 = field1341[var5];
                  var12 = field1341[var6];
                  var13 = field1341[var7];
                  int var14 = field1390[var5];
                  var15 = field1390[var6];
                  int var16 = field1390[var7];
                  int var17 = field1377[var5];
                  int var18 = field1377[var6];
                  int var19 = field1377[var7];
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
                     field1370[var4] = true;
                     int var23 = (field1373[var5] + field1373[var6] + field1373[var7]) / 3 + this.field1367;
                     field1379[var23][field1378[var23]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1356 == null) {
            for(var4 = this.field1401 - 1; var4 >= 0; --var4) {
               var5 = field1378[var4];
               if(var5 > 0) {
                  var24 = field1379[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1630(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1380[var4] = 0;
               field1384[var4] = 0;
            }

            for(var4 = this.field1401 - 1; var4 >= 0; --var4) {
               var5 = field1378[var4];
               if(var5 > 0) {
                  var24 = field1379[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var28 = this.field1356[var8];
                     var10 = field1380[var28]++;
                     field1374[var28][var10] = var8;
                     if(var28 < 10) {
                        field1384[var28] += var4;
                     } else if(var28 == 10) {
                        field1382[var10] = var4;
                     } else {
                        field1343[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1380[1] > 0 || field1380[2] > 0) {
               var4 = (field1384[1] + field1384[2]) / (field1380[1] + field1380[2]);
            }

            var5 = 0;
            if(field1380[3] > 0 || field1380[4] > 0) {
               var5 = (field1384[3] + field1384[4]) / (field1380[3] + field1380[4]);
            }

            var6 = 0;
            if(field1380[6] > 0 || field1380[8] > 0) {
               var6 = (field1384[6] + field1384[8]) / (field1380[6] + field1380[8]);
            }

            var8 = 0;
            var9 = field1380[10];
            int[] var26 = field1374[10];
            int[] var11 = field1382;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1380[11];
               var26 = field1374[11];
               var11 = field1343;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1630(var26[var8++]);
                  if(var8 == var9 && var26 != field1374[11]) {
                     var8 = 0;
                     var9 = field1380[11];
                     var26 = field1374[11];
                     var11 = field1343;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1630(var26[var8++]);
                  if(var8 == var9 && var26 != field1374[11]) {
                     var8 = 0;
                     var9 = field1380[11];
                     var26 = field1374[11];
                     var11 = field1343;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1630(var26[var8++]);
                  if(var8 == var9 && var26 != field1374[11]) {
                     var8 = 0;
                     var9 = field1380[11];
                     var26 = field1374[11];
                     var11 = field1343;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1380[var12];
               int[] var27 = field1374[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1630(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1630(var26[var8++]);
               if(var8 == var9 && var26 != field1374[11]) {
                  var8 = 0;
                  var26 = field1374[11];
                  var9 = field1380[11];
                  var11 = field1343;
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

   @ObfuscatedName("ab")
   final void method1630(int var1) {
      if(field1370[var1]) {
         this.method1631(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1369[var1];
         if(this.field1352 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1352[var1] & 255;
         }

         if(this.field1354 != null && this.field1354[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1353 != null && this.field1353[var1] != -1) {
               int var8 = this.field1353[var1] & 255;
               var5 = this.field1396[var8];
               var6 = this.field1358[var8];
               var7 = this.field1359[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1350[var1] == -1) {
               class84.rasterTextureAffine(field1372[var2], field1372[var3], field1372[var4], field1357[var2], field1357[var3], field1357[var4], this.field1348[var1], this.field1348[var1], this.field1348[var1], field1341[var5], field1341[var6], field1341[var7], field1390[var5], field1390[var6], field1390[var7], field1377[var5], field1377[var6], field1377[var7], this.field1354[var1]);
            } else {
               class84.rasterTextureAffine(field1372[var2], field1372[var3], field1372[var4], field1357[var2], field1357[var3], field1357[var4], this.field1348[var1], this.field1349[var1], this.field1350[var1], field1341[var5], field1341[var6], field1341[var7], field1390[var5], field1390[var6], field1390[var7], field1377[var5], field1377[var6], field1377[var7], this.field1354[var1]);
            }
         } else if(this.field1350[var1] == -1) {
            class84.rasterFlat(field1372[var2], field1372[var3], field1372[var4], field1357[var2], field1357[var3], field1357[var4], field1398[this.field1348[var1]]);
         } else {
            class84.rasterGouraud(field1372[var2], field1372[var3], field1372[var4], field1357[var2], field1357[var3], field1357[var4], this.field1348[var1], this.field1349[var1], this.field1350[var1]);
         }

      }
   }

   @ObfuscatedName("af")
   final void method1631(int var1) {
      int var2 = class84.field1422;
      int var3 = class84.field1423;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1377[var5];
      int var9 = field1377[var6];
      int var10 = field1377[var7];
      if(this.field1352 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1352[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1385[var4] = field1357[var5];
         field1386[var4] = field1372[var5];
         field1336[var4++] = this.field1348[var1];
      } else {
         var11 = field1341[var5];
         var12 = field1390[var5];
         var13 = this.field1348[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1399[var10 - var8];
            field1385[var4] = var2 + (var11 + ((field1341[var7] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var7] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1350[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1399[var9 - var8];
            field1385[var4] = var2 + (var11 + ((field1341[var6] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var6] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1349[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1385[var4] = field1357[var6];
         field1386[var4] = field1372[var6];
         field1336[var4++] = this.field1349[var1];
      } else {
         var11 = field1341[var6];
         var12 = field1390[var6];
         var13 = this.field1349[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1399[var8 - var9];
            field1385[var4] = var2 + (var11 + ((field1341[var5] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var5] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1348[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1399[var10 - var9];
            field1385[var4] = var2 + (var11 + ((field1341[var7] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var7] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1350[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1385[var4] = field1357[var7];
         field1386[var4] = field1372[var7];
         field1336[var4++] = this.field1350[var1];
      } else {
         var11 = field1341[var7];
         var12 = field1390[var7];
         var13 = this.field1350[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1399[var9 - var10];
            field1385[var4] = var2 + (var11 + ((field1341[var6] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var6] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1349[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1399[var8 - var10];
            field1385[var4] = var2 + (var11 + ((field1341[var5] - var11) * var14 >> 16)) * class84.field1421 / 50;
            field1386[var4] = var3 + (var12 + ((field1390[var5] - var12) * var14 >> 16)) * class84.field1421 / 50;
            field1336[var4++] = var13 + ((this.field1348[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1385[0];
      var12 = field1385[1];
      var13 = field1385[2];
      var14 = field1386[0];
      int var15 = field1386[1];
      int var16 = field1386[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1354 != null && this.field1354[var1] != -1) {
            if(this.field1353 != null && this.field1353[var1] != -1) {
               var20 = this.field1353[var1] & 255;
               var17 = this.field1396[var20];
               var18 = this.field1358[var20];
               var19 = this.field1359[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1350[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1348[var1], this.field1348[var1], this.field1348[var1], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], this.field1354[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1336[0], field1336[1], field1336[2], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], this.field1354[var1]);
            }
         } else if(this.field1350[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1398[this.field1348[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1336[0], field1336[1], field1336[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1385[3] < 0 || field1385[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1354 != null && this.field1354[var1] != -1) {
            if(this.field1353 != null && this.field1353[var1] != -1) {
               var20 = this.field1353[var1] & 255;
               var17 = this.field1396[var20];
               var18 = this.field1358[var20];
               var19 = this.field1359[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1354[var1];
            if(this.field1350[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1348[var1], this.field1348[var1], this.field1348[var1], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1386[3], var11, var13, field1385[3], this.field1348[var1], this.field1348[var1], this.field1348[var1], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1336[0], field1336[1], field1336[2], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1386[3], var11, var13, field1385[3], field1336[0], field1336[2], field1336[3], field1341[var17], field1341[var18], field1341[var19], field1390[var17], field1390[var18], field1390[var19], field1377[var17], field1377[var18], field1377[var19], var21);
            }
         } else if(this.field1350[var1] == -1) {
            var17 = field1398[this.field1348[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1386[3], var11, var13, field1385[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1336[0], field1336[1], field1336[2]);
            class84.rasterGouraud(var14, var16, field1386[3], var11, var13, field1385[3], field1336[0], field1336[2], field1336[3]);
         }
      }

   }

   @ObfuscatedName("aw")
   final boolean method1632(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1362 = class84.field1435;
      field1363 = class84.field1432;
      field1398 = class84.colorPalette;
      field1399 = class84.field1429;
   }

   @ObfuscatedName("g")
   public final void method1633(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1378[0] = -1;
      if(this.field1376 != 2 && this.field1376 != 1) {
         this.method1615();
      }

      int var8 = class84.field1422;
      int var9 = class84.field1423;
      int var10000 = field1362[var1];
      var10000 = field1363[var1];
      int var12 = field1362[var2];
      int var13 = field1363[var2];
      int var14 = field1362[var3];
      int var15 = field1363[var3];
      int var16 = field1362[var4];
      int var17 = field1363[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1340; ++var19) {
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
         field1373[var19] = var22 - var18;
         field1357[var19] = var8 + var20 * class84.field1421 / var22;
         field1372[var19] = var9 + var23 * class84.field1421 / var22;
         if(this.field1397 > 0) {
            field1341[var19] = var20;
            field1390[var19] = var23;
            field1377[var19] = var22;
         }
      }

      try {
         this.method1629(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("d")
   public void method1648(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1340; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1376 = 0;
   }

   @ObfuscatedName("w")
   public void method1655() {
      for(int var1 = 0; var1 < this.field1340; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1376 = 0;
   }

   Model() {
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1340 = 0;
      this.field1344 = 0;
      this.field1397 = 0;
      this.field1355 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1340 += var8.field1340;
            this.field1344 += var8.field1344;
            this.field1397 += var8.field1397;
            if(var8.field1356 != null) {
               var3 = true;
            } else {
               if(this.field1355 == -1) {
                  this.field1355 = var8.field1355;
               }

               if(this.field1355 != var8.field1355) {
                  var3 = true;
               }
            }

            var4 |= var8.field1352 != null;
            var5 |= var8.field1354 != null;
            var6 |= var8.field1353 != null;
         }
      }

      this.verticesX = new int[this.field1340];
      this.verticesY = new int[this.field1340];
      this.verticesZ = new int[this.field1340];
      this.indices1 = new int[this.field1344];
      this.indices2 = new int[this.field1344];
      this.indices3 = new int[this.field1344];
      this.field1348 = new int[this.field1344];
      this.field1349 = new int[this.field1344];
      this.field1350 = new int[this.field1344];
      if(var3) {
         this.field1356 = new byte[this.field1344];
      }

      if(var4) {
         this.field1352 = new byte[this.field1344];
      }

      if(var5) {
         this.field1354 = new short[this.field1344];
      }

      if(var6) {
         this.field1353 = new byte[this.field1344];
      }

      if(this.field1397 > 0) {
         this.field1396 = new int[this.field1397];
         this.field1358 = new int[this.field1397];
         this.field1359 = new int[this.field1397];
      }

      this.field1340 = 0;
      this.field1344 = 0;
      this.field1397 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1344; ++var9) {
               this.indices1[this.field1344] = var8.indices1[var9] + this.field1340;
               this.indices2[this.field1344] = var8.indices2[var9] + this.field1340;
               this.indices3[this.field1344] = var8.indices3[var9] + this.field1340;
               this.field1348[this.field1344] = var8.field1348[var9];
               this.field1349[this.field1344] = var8.field1349[var9];
               this.field1350[this.field1344] = var8.field1350[var9];
               if(var3) {
                  if(var8.field1356 != null) {
                     this.field1356[this.field1344] = var8.field1356[var9];
                  } else {
                     this.field1356[this.field1344] = var8.field1355;
                  }
               }

               if(var4 && var8.field1352 != null) {
                  this.field1352[this.field1344] = var8.field1352[var9];
               }

               if(var5) {
                  if(var8.field1354 != null) {
                     this.field1354[this.field1344] = var8.field1354[var9];
                  } else {
                     this.field1354[this.field1344] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1353 != null && var8.field1353[var9] != -1) {
                     this.field1353[this.field1344] = (byte)(var8.field1353[var9] + this.field1397);
                  } else {
                     this.field1353[this.field1344] = -1;
                  }
               }

               ++this.field1344;
            }

            for(var9 = 0; var9 < var8.field1397; ++var9) {
               this.field1396[this.field1397] = var8.field1396[var9] + this.field1340;
               this.field1358[this.field1397] = var8.field1358[var9] + this.field1340;
               this.field1359[this.field1397] = var8.field1359[var9] + this.field1340;
               ++this.field1397;
            }

            for(var9 = 0; var9 < var8.field1340; ++var9) {
               this.verticesX[this.field1340] = var8.verticesX[var9];
               this.verticesY[this.field1340] = var8.verticesY[var9];
               this.verticesZ[this.field1340] = var8.verticesZ[var9];
               ++this.field1340;
            }
         }
      }

   }

   @ObfuscatedName("y")
   void method1657(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1388 = 0;
         field1389 = 0;
         field1339 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1342.length) {
               int[] var19 = this.field1342[var9];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1388 += this.verticesX[var12];
                  field1389 += this.verticesY[var12];
                  field1339 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1388 = field1388 / var7 + var3;
            field1389 = field1389 / var7 + var4;
            field1339 = field1339 / var7 + var5;
         } else {
            field1388 = var3;
            field1389 = var4;
            field1339 = var5;
         }

      } else {
         int var10;
         int[] var18;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1342.length) {
                  var18 = this.field1342[var8];

                  for(var10 = 0; var10 < var18.length; ++var10) {
                     var11 = var18[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1342.length) {
                  var18 = this.field1342[var8];

                  for(var10 = 0; var10 < var18.length; ++var10) {
                     var11 = var18[var10];
                     this.verticesX[var11] -= field1388;
                     this.verticesY[var11] -= field1389;
                     this.verticesZ[var11] -= field1339;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1362[var14];
                        var16 = field1363[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1362[var12];
                        var16 = field1363[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1362[var13];
                        var16 = field1363[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1388;
                     this.verticesY[var11] += field1389;
                     this.verticesZ[var11] += field1339;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1342.length) {
                  var18 = this.field1342[var8];

                  for(var10 = 0; var10 < var18.length; ++var10) {
                     var11 = var18[var10];
                     this.verticesX[var11] -= field1388;
                     this.verticesY[var11] -= field1389;
                     this.verticesZ[var11] -= field1339;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1388;
                     this.verticesY[var11] += field1389;
                     this.verticesZ[var11] += field1339;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1361 != null && this.field1352 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1361.length) {
                     var18 = this.field1361[var8];

                     for(var10 = 0; var10 < var18.length; ++var10) {
                        var11 = var18[var10];
                        var12 = (this.field1352[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1352[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   public Model method1672(boolean var1) {
      if(!var1 && field1381.length < this.field1344) {
         field1381 = new byte[this.field1344 + 100];
      }

      return this.method1617(var1, field1338, field1381);
   }

   @ObfuscatedName("p")
   public int method1683() {
      this.method1684();
      return this.field1365;
   }

   @ObfuscatedName("x")
   public void method1684() {
      if(this.field1376 != 1) {
         this.field1376 = 1;
         super.modelHeight = 0;
         this.field1364 = 0;
         this.field1365 = 0;

         for(int var1 = 0; var1 < this.field1340; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1364) {
               this.field1364 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1365) {
               this.field1365 = var5;
            }
         }

         this.field1365 = (int)(Math.sqrt((double)this.field1365) + 0.99D);
         this.field1367 = (int)(Math.sqrt((double)(this.field1365 * this.field1365 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1401 = this.field1367 + (int)(Math.sqrt((double)(this.field1365 * this.field1365 + this.field1364 * this.field1364)) + 0.99D);
      }
   }
}

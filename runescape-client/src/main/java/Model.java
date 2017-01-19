import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ai")
   int field1356;
   @ObfuscatedName("c")
   static byte[] field1357 = new byte[1];
   @ObfuscatedName("a")
   int field1358 = 0;
   @ObfuscatedName("h")
   static byte[] field1359 = new byte[1];
   @ObfuscatedName("i")
   byte[] field1360;
   @ObfuscatedName("j")
   int[] field1361;
   @ObfuscatedName("as")
   static int[] field1362 = new int[4700];
   @ObfuscatedName("ap")
   static int[][] field1363 = new int[1600][512];
   @ObfuscatedName("f")
   static Model field1364 = new Model();
   @ObfuscatedName("x")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("d")
   int field1366 = 0;
   @ObfuscatedName("n")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("m")
   int[] field1368;
   @ObfuscatedName("b")
   int field1369 = 0;
   @ObfuscatedName("aj")
   static int[] field1370 = new int[1600];
   @ObfuscatedName("p")
   byte[] field1371;
   @ObfuscatedName("o")
   byte[] field1372;
   @ObfuscatedName("bx")
   static int[] field1373;
   @ObfuscatedName("l")
   int[][] field1374;
   @ObfuscatedName("e")
   byte field1375 = 0;
   @ObfuscatedName("ao")
   int field1376;
   @ObfuscatedName("t")
   int[] field1377;
   @ObfuscatedName("q")
   int[] field1378;
   @ObfuscatedName("r")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("w")
   int[] field1380;
   @ObfuscatedName("v")
   int[][] field1381;
   @ObfuscatedName("az")
   public boolean field1382 = false;
   @ObfuscatedName("k")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ad")
   int field1384;
   @ObfuscatedName("g")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("bp")
   public static int[] field1386 = new int[1000];
   @ObfuscatedName("u")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("ax")
   int field1388;
   @ObfuscatedName("al")
   static boolean[] field1389 = new boolean[4700];
   @ObfuscatedName("an")
   static boolean[] field1390 = new boolean[4700];
   @ObfuscatedName("aw")
   static int[] field1391 = new int[4700];
   @ObfuscatedName("ah")
   static int[] field1392 = new int[4700];
   @ObfuscatedName("ar")
   static int[] field1393 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1394 = new int[4700];
   @ObfuscatedName("y")
   int[] field1395;
   @ObfuscatedName("aq")
   static int[] field1396 = new int[4700];
   @ObfuscatedName("s")
   static Model field1398 = new Model();
   @ObfuscatedName("aa")
   int field1399;
   @ObfuscatedName("ac")
   static int[] field1400 = new int[12];
   @ObfuscatedName("at")
   static int[][] field1401 = new int[12][2000];
   @ObfuscatedName("av")
   static int[] field1402 = new int[2000];
   @ObfuscatedName("am")
   static int[] field1403 = new int[2000];
   @ObfuscatedName("ak")
   static int[] field1404 = new int[12];
   @ObfuscatedName("au")
   static int[] field1405 = new int[10];
   @ObfuscatedName("ag")
   static int[] field1406 = new int[10];
   @ObfuscatedName("ab")
   static int[] field1407 = new int[10];
   @ObfuscatedName("bt")
   static int field1408;
   @ObfuscatedName("bw")
   static int field1409;
   @ObfuscatedName("bd")
   static int field1410;
   @ObfuscatedName("bs")
   public static boolean field1411 = false;
   @ObfuscatedName("bm")
   public static int field1412 = 0;
   @ObfuscatedName("bb")
   public static int field1413 = 0;
   @ObfuscatedName("bl")
   public static int field1414 = 0;
   @ObfuscatedName("z")
   short[] field1415;
   @ObfuscatedName("bh")
   static int[] field1416;
   @ObfuscatedName("bo")
   static int[] field1417;
   @ObfuscatedName("bj")
   static int[] field1419;

   @ObfuscatedName("e")
   public void method1517(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1358; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1356 = 0;
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1358 = 0;
      this.field1369 = 0;
      this.field1366 = 0;
      this.field1375 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1358 += var8.field1358;
            this.field1369 += var8.field1369;
            this.field1366 += var8.field1366;
            if(var8.field1371 != null) {
               var3 = true;
            } else {
               if(this.field1375 == -1) {
                  this.field1375 = var8.field1375;
               }

               if(this.field1375 != var8.field1375) {
                  var3 = true;
               }
            }

            var4 |= var8.field1372 != null;
            var5 |= var8.field1415 != null;
            var6 |= var8.field1360 != null;
         }
      }

      this.verticesX = new int[this.field1358];
      this.verticesY = new int[this.field1358];
      this.verticesZ = new int[this.field1358];
      this.indices1 = new int[this.field1369];
      this.indices2 = new int[this.field1369];
      this.indices3 = new int[this.field1369];
      this.field1368 = new int[this.field1369];
      this.field1361 = new int[this.field1369];
      this.field1380 = new int[this.field1369];
      if(var3) {
         this.field1371 = new byte[this.field1369];
      }

      if(var4) {
         this.field1372 = new byte[this.field1369];
      }

      if(var5) {
         this.field1415 = new short[this.field1369];
      }

      if(var6) {
         this.field1360 = new byte[this.field1369];
      }

      if(this.field1366 > 0) {
         this.field1377 = new int[this.field1366];
         this.field1378 = new int[this.field1366];
         this.field1395 = new int[this.field1366];
      }

      this.field1358 = 0;
      this.field1369 = 0;
      this.field1366 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1369; ++var9) {
               this.indices1[this.field1369] = var8.indices1[var9] + this.field1358;
               this.indices2[this.field1369] = var8.indices2[var9] + this.field1358;
               this.indices3[this.field1369] = var8.indices3[var9] + this.field1358;
               this.field1368[this.field1369] = var8.field1368[var9];
               this.field1361[this.field1369] = var8.field1361[var9];
               this.field1380[this.field1369] = var8.field1380[var9];
               if(var3) {
                  if(var8.field1371 != null) {
                     this.field1371[this.field1369] = var8.field1371[var9];
                  } else {
                     this.field1371[this.field1369] = var8.field1375;
                  }
               }

               if(var4 && var8.field1372 != null) {
                  this.field1372[this.field1369] = var8.field1372[var9];
               }

               if(var5) {
                  if(var8.field1415 != null) {
                     this.field1415[this.field1369] = var8.field1415[var9];
                  } else {
                     this.field1415[this.field1369] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1360 != null && var8.field1360[var9] != -1) {
                     this.field1360[this.field1369] = (byte)(var8.field1360[var9] + this.field1366);
                  } else {
                     this.field1360[this.field1369] = -1;
                  }
               }

               ++this.field1369;
            }

            for(var9 = 0; var9 < var8.field1366; ++var9) {
               this.field1377[this.field1366] = var8.field1377[var9] + this.field1358;
               this.field1378[this.field1366] = var8.field1378[var9] + this.field1358;
               this.field1395[this.field1366] = var8.field1395[var9] + this.field1358;
               ++this.field1366;
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

   @ObfuscatedName("u")
   public void method1518() {
      if(this.field1356 != 1) {
         this.field1356 = 1;
         super.modelHeight = 0;
         this.field1384 = 0;
         this.field1399 = 0;

         for(int var1 = 0; var1 < this.field1358; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1384) {
               this.field1384 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1399) {
               this.field1399 = var5;
            }
         }

         this.field1399 = (int)(Math.sqrt((double)this.field1399) + 0.99D);
         this.field1388 = (int)(Math.sqrt((double)(this.field1399 * this.field1399 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1376 = this.field1388 + (int)(Math.sqrt((double)(this.field1399 * this.field1399 + this.field1384 * this.field1384)) + 0.99D);
      }
   }

   @ObfuscatedName("c")
   public Model method1519(boolean var1) {
      if(!var1 && field1357.length < this.field1369) {
         field1357 = new byte[this.field1369 + 100];
      }

      return this.method1521(var1, field1398, field1357);
   }

   @ObfuscatedName("g")
   public Model method1520(boolean var1) {
      if(!var1 && field1359.length < this.field1369) {
         field1359 = new byte[this.field1369 + 100];
      }

      return this.method1521(var1, field1364, field1359);
   }

   @ObfuscatedName("k")
   Model method1521(boolean var1, Model var2, byte[] var3) {
      var2.field1358 = this.field1358;
      var2.field1369 = this.field1369;
      var2.field1366 = this.field1366;
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
         var2.field1372 = this.field1372;
      } else {
         var2.field1372 = var3;
         if(this.field1372 == null) {
            for(var4 = 0; var4 < this.field1369; ++var4) {
               var2.field1372[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1369; ++var4) {
               var2.field1372[var4] = this.field1372[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1368 = this.field1368;
      var2.field1361 = this.field1361;
      var2.field1380 = this.field1380;
      var2.field1371 = this.field1371;
      var2.field1360 = this.field1360;
      var2.field1415 = this.field1415;
      var2.field1375 = this.field1375;
      var2.field1377 = this.field1377;
      var2.field1378 = this.field1378;
      var2.field1395 = this.field1395;
      var2.field1374 = this.field1374;
      var2.field1381 = this.field1381;
      var2.field1382 = this.field1382;
      var2.field1356 = 0;
      return var2;
   }

   @ObfuscatedName("b")
   void method1523() {
      if(this.field1356 != 2) {
         this.field1356 = 2;
         this.field1399 = 0;

         for(int var1 = 0; var1 < this.field1358; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1399) {
               this.field1399 = var5;
            }
         }

         this.field1399 = (int)(Math.sqrt((double)this.field1399) + 0.99D);
         this.field1388 = this.field1399;
         this.field1376 = this.field1399 + this.field1399;
      }
   }

   @ObfuscatedName("n")
   public void method1526(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1568[var2];
            Frame var7 = var3.field1568[var4];
            FrameMap var8 = var6.field1323;
            field1408 = 0;
            field1409 = 0;
            field1410 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1324; ++var11) {
               for(var12 = var6.field1328[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1469[var12] == 0) {
                  this.method1527(var8.field1469[var12], var8.field1471[var12], var6.field1326[var11], var6.field1327[var11], var6.field1319[var11]);
               }
            }

            field1408 = 0;
            field1409 = 0;
            field1410 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1324; ++var11) {
               for(var12 = var7.field1328[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1469[var12] == 0) {
                  this.method1527(var8.field1469[var12], var8.field1471[var12], var7.field1326[var11], var7.field1327[var11], var7.field1319[var11]);
               }
            }

            this.field1356 = 0;
         } else {
            this.method1528(var1, var2);
         }
      }
   }

   @ObfuscatedName("m")
   void method1527(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1408 = 0;
         field1409 = 0;
         field1410 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1374.length) {
               int[] var19 = this.field1374[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1408 += this.verticesX[var12];
                  field1409 += this.verticesY[var12];
                  field1410 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1408 = field1408 / var7 + var3;
            field1409 = field1409 / var7 + var4;
            field1410 = field1410 / var7 + var5;
         } else {
            field1408 = var3;
            field1409 = var4;
            field1410 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1374.length) {
                  var9 = this.field1374[var8];

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
               if(var8 < this.field1374.length) {
                  var9 = this.field1374[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1408;
                     this.verticesY[var11] -= field1409;
                     this.verticesZ[var11] -= field1410;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1416[var14];
                        var16 = field1417[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1416[var12];
                        var16 = field1417[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1416[var13];
                        var16 = field1417[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1408;
                     this.verticesY[var11] += field1409;
                     this.verticesZ[var11] += field1410;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1374.length) {
                  var9 = this.field1374[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1408;
                     this.verticesY[var11] -= field1409;
                     this.verticesZ[var11] -= field1410;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1408;
                     this.verticesY[var11] += field1409;
                     this.verticesZ[var11] += field1410;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1381 != null && this.field1372 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1381.length) {
                     var9 = this.field1381[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1372[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1372[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public void method1528(Frames var1, int var2) {
      if(this.field1374 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1568[var2];
            FrameMap var4 = var3.field1323;
            field1408 = 0;
            field1409 = 0;
            field1410 = 0;

            for(int var5 = 0; var5 < var3.field1324; ++var5) {
               int var6 = var3.field1328[var5];
               this.method1527(var4.field1469[var6], var4.field1471[var6], var3.field1326[var5], var3.field1327[var5], var3.field1319[var5]);
            }

            this.field1356 = 0;
         }
      }
   }

   @ObfuscatedName("l")
   final void method1529(int var1) {
      if(field1390[var1]) {
         this.method1539(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1389[var1];
         if(this.field1372 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1372[var1] & 255;
         }

         if(this.field1415 != null && this.field1415[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1360 != null && this.field1360[var1] != -1) {
               int var8 = this.field1360[var1] & 255;
               var5 = this.field1377[var8];
               var6 = this.field1378[var8];
               var7 = this.field1395[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1380[var1] == -1) {
               class84.rasterTextureAffine(field1392[var2], field1392[var3], field1392[var4], field1391[var2], field1391[var3], field1391[var4], this.field1368[var1], this.field1368[var1], this.field1368[var1], field1394[var5], field1394[var6], field1394[var7], field1362[var5], field1362[var6], field1362[var7], field1396[var5], field1396[var6], field1396[var7], this.field1415[var1]);
            } else {
               class84.rasterTextureAffine(field1392[var2], field1392[var3], field1392[var4], field1391[var2], field1391[var3], field1391[var4], this.field1368[var1], this.field1361[var1], this.field1380[var1], field1394[var5], field1394[var6], field1394[var7], field1362[var5], field1362[var6], field1362[var7], field1396[var5], field1396[var6], field1396[var7], this.field1415[var1]);
            }
         } else if(this.field1380[var1] == -1) {
            class84.rasterFlat(field1392[var2], field1392[var3], field1392[var4], field1391[var2], field1391[var3], field1391[var4], field1373[this.field1368[var1]]);
         } else {
            class84.rasterGouraud(field1392[var2], field1392[var3], field1392[var4], field1391[var2], field1391[var3], field1391[var4], this.field1368[var1], this.field1361[var1], this.field1380[var1]);
         }

      }
   }

   @ObfuscatedName("p")
   public void method1530() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1356 = 0;
   }

   @ObfuscatedName("z")
   public void method1531(int var1) {
      int var2 = field1416[var1];
      int var3 = field1417[var1];

      for(int var4 = 0; var4 < this.field1358; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1356 = 0;
   }

   @ObfuscatedName("t")
   public final void method1534(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1370[0] = -1;
      if(this.field1356 != 2 && this.field1356 != 1) {
         this.method1523();
      }

      int var8 = class84.field1431;
      int var9 = class84.field1449;
      int var10000 = field1416[var1];
      var10000 = field1417[var1];
      int var12 = field1416[var2];
      int var13 = field1417[var2];
      int var14 = field1416[var3];
      int var15 = field1417[var3];
      int var16 = field1416[var4];
      int var17 = field1417[var4];
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
         field1393[var19] = var22 - var18;
         field1391[var19] = var8 + var20 * class84.field1435 / var22;
         field1392[var19] = var9 + var23 * class84.field1435 / var22;
         if(this.field1366 > 0) {
            field1394[var19] = var20;
            field1362[var19] = var23;
            field1396[var19] = var22;
         }
      }

      try {
         this.method1537(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("q")
   public final void method1535(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1370[0] = -1;
      if(this.field1356 != 2 && this.field1356 != 1) {
         this.method1523();
      }

      int var9 = class84.field1431;
      int var10 = class84.field1449;
      int var10000 = field1416[var1];
      var10000 = field1417[var1];
      int var13 = field1416[var2];
      int var14 = field1417[var2];
      int var15 = field1416[var3];
      int var16 = field1417[var3];
      int var17 = field1416[var4];
      int var18 = field1417[var4];
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
         field1393[var20] = var23 - var19;
         field1391[var20] = var9 + var21 * class84.field1435 / var8;
         field1392[var20] = var10 + var24 * class84.field1435 / var8;
         if(this.field1366 > 0) {
            field1394[var20] = var21;
            field1362[var20] = var24;
            field1396[var20] = var23;
         }
      }

      try {
         this.method1537(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ca")
   void vmethod1823(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1370[0] = -1;
      if(this.field1356 != 1) {
         this.method1518();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1399 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1399) * class84.field1435;
         if(var15 / var13 < class84.field1439) {
            int var16 = (var14 + this.field1399) * class84.field1435;
            if(var16 / var13 > class84.field1441) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1399 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1435;
               if(var19 / var13 > class84.field1445) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1435;
                  if(var21 / var13 < class84.field1446) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1366 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1411) {
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

                        var28 = field1412 - class84.field1431;
                        var29 = field1413 - class84.field1449;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1382) {
                              field1386[field1414++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1431;
                     var28 = class84.field1449;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1416[var1];
                        var30 = field1417[var1];
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
                        field1393[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1391[var31] = var27 + var32 * class84.field1435 / var34;
                           field1392[var31] = var28 + var35 * class84.field1435 / var34;
                        } else {
                           field1391[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1394[var31] = var32;
                           field1362[var31] = var35;
                           field1396[var31] = var34;
                        }
                     }

                     try {
                        this.method1537(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("y")
   final void method1537(boolean var1, boolean var2, int var3) {
      if(this.field1376 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1376; ++var4) {
            field1370[var4] = 0;
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
         for(var4 = 0; var4 < this.field1369; ++var4) {
            if(this.field1380[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1391[var5];
               var9 = field1391[var6];
               var10 = field1391[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1394[var5];
                  var12 = field1394[var6];
                  var13 = field1394[var7];
                  int var14 = field1362[var5];
                  var15 = field1362[var6];
                  int var16 = field1362[var7];
                  int var17 = field1396[var5];
                  int var18 = field1396[var6];
                  int var19 = field1396[var7];
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
                     field1390[var4] = true;
                     int var23 = (field1393[var5] + field1393[var6] + field1393[var7]) / 3 + this.field1388;
                     field1363[var23][field1370[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method1540(field1412, field1413, field1392[var5], field1392[var6], field1392[var7], var8, var9, var10)) {
                     field1386[field1414++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1392[var7] - field1392[var6]) - (field1392[var5] - field1392[var6]) * (var10 - var9) > 0) {
                     field1390[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1389[var4] = false;
                     } else {
                        field1389[var4] = true;
                     }

                     var11 = (field1393[var5] + field1393[var6] + field1393[var7]) / 3 + this.field1388;
                     field1363[var11][field1370[var11]++] = var4;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1371 == null) {
            for(var4 = this.field1376 - 1; var4 >= 0; --var4) {
               var5 = field1370[var4];
               if(var5 > 0) {
                  var27 = field1363[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1529(var27[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1400[var4] = 0;
               field1404[var4] = 0;
            }

            for(var4 = this.field1376 - 1; var4 >= 0; --var4) {
               var5 = field1370[var4];
               if(var5 > 0) {
                  var27 = field1363[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var27[var7];
                     byte var28 = this.field1371[var8];
                     var10 = field1400[var28]++;
                     field1401[var28][var10] = var8;
                     if(var28 < 10) {
                        field1404[var28] += var4;
                     } else if(var28 == 10) {
                        field1402[var10] = var4;
                     } else {
                        field1403[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1400[1] > 0 || field1400[2] > 0) {
               var4 = (field1404[1] + field1404[2]) / (field1400[1] + field1400[2]);
            }

            var5 = 0;
            if(field1400[3] > 0 || field1400[4] > 0) {
               var5 = (field1404[3] + field1404[4]) / (field1400[3] + field1400[4]);
            }

            var6 = 0;
            if(field1400[6] > 0 || field1400[8] > 0) {
               var6 = (field1404[6] + field1404[8]) / (field1400[6] + field1400[8]);
            }

            var8 = 0;
            var9 = field1400[10];
            int[] var26 = field1401[10];
            int[] var24 = field1402;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1400[11];
               var26 = field1401[11];
               var24 = field1403;
            }

            if(var8 < var9) {
               var7 = var24[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1529(var26[var8++]);
                  if(var8 == var9 && var26 != field1401[11]) {
                     var8 = 0;
                     var9 = field1400[11];
                     var26 = field1401[11];
                     var24 = field1403;
                  }

                  if(var8 < var9) {
                     var7 = var24[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1529(var26[var8++]);
                  if(var8 == var9 && var26 != field1401[11]) {
                     var8 = 0;
                     var9 = field1400[11];
                     var26 = field1401[11];
                     var24 = field1403;
                  }

                  if(var8 < var9) {
                     var7 = var24[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1529(var26[var8++]);
                  if(var8 == var9 && var26 != field1401[11]) {
                     var8 = 0;
                     var9 = field1400[11];
                     var26 = field1401[11];
                     var24 = field1403;
                  }

                  if(var8 < var9) {
                     var7 = var24[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1400[var12];
               int[] var25 = field1401[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1529(var25[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1529(var26[var8++]);
               if(var8 == var9 && var26 != field1401[11]) {
                  var8 = 0;
                  var26 = field1401[11];
                  var9 = field1400[11];
                  var24 = field1403;
               }

               if(var8 < var9) {
                  var7 = var24[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("v")
   final void method1539(int var1) {
      int var2 = class84.field1431;
      int var3 = class84.field1449;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1396[var5];
      int var9 = field1396[var6];
      int var10 = field1396[var7];
      if(this.field1372 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1372[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1405[var4] = field1391[var5];
         field1406[var4] = field1392[var5];
         field1407[var4++] = this.field1368[var1];
      } else {
         var11 = field1394[var5];
         var12 = field1362[var5];
         var13 = this.field1368[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1419[var10 - var8];
            field1405[var4] = var2 + (var11 + ((field1394[var7] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var7] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1380[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1419[var9 - var8];
            field1405[var4] = var2 + (var11 + ((field1394[var6] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var6] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1405[var4] = field1391[var6];
         field1406[var4] = field1392[var6];
         field1407[var4++] = this.field1361[var1];
      } else {
         var11 = field1394[var6];
         var12 = field1362[var6];
         var13 = this.field1361[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1419[var8 - var9];
            field1405[var4] = var2 + (var11 + ((field1394[var5] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var5] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1368[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1419[var10 - var9];
            field1405[var4] = var2 + (var11 + ((field1394[var7] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var7] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1380[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1405[var4] = field1391[var7];
         field1406[var4] = field1392[var7];
         field1407[var4++] = this.field1380[var1];
      } else {
         var11 = field1394[var7];
         var12 = field1362[var7];
         var13 = this.field1380[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1419[var9 - var10];
            field1405[var4] = var2 + (var11 + ((field1394[var6] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var6] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1361[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1419[var8 - var10];
            field1405[var4] = var2 + (var11 + ((field1394[var5] - var11) * var14 >> 16)) * class84.field1435 / 50;
            field1406[var4] = var3 + (var12 + ((field1362[var5] - var12) * var14 >> 16)) * class84.field1435 / 50;
            field1407[var4++] = var13 + ((this.field1368[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1405[0];
      var12 = field1405[1];
      var13 = field1405[2];
      var14 = field1406[0];
      int var15 = field1406[1];
      int var16 = field1406[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1415 != null && this.field1415[var1] != -1) {
            if(this.field1360 != null && this.field1360[var1] != -1) {
               var20 = this.field1360[var1] & 255;
               var17 = this.field1377[var20];
               var18 = this.field1378[var20];
               var19 = this.field1395[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1380[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1368[var1], this.field1368[var1], this.field1368[var1], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], this.field1415[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], this.field1415[var1]);
            }
         } else if(this.field1380[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1373[this.field1368[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1405[3] < 0 || field1405[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1415 != null && this.field1415[var1] != -1) {
            if(this.field1360 != null && this.field1360[var1] != -1) {
               var20 = this.field1360[var1] & 255;
               var17 = this.field1377[var20];
               var18 = this.field1378[var20];
               var19 = this.field1395[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1415[var1];
            if(this.field1380[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1368[var1], this.field1368[var1], this.field1368[var1], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1406[3], var11, var13, field1405[3], this.field1368[var1], this.field1368[var1], this.field1368[var1], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1406[3], var11, var13, field1405[3], field1407[0], field1407[2], field1407[3], field1394[var17], field1394[var18], field1394[var19], field1362[var17], field1362[var18], field1362[var19], field1396[var17], field1396[var18], field1396[var19], var21);
            }
         } else if(this.field1380[var1] == -1) {
            var17 = field1373[this.field1368[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1406[3], var11, var13, field1405[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1407[0], field1407[1], field1407[2]);
            class84.rasterGouraud(var14, var16, field1406[3], var11, var13, field1405[3], field1407[0], field1407[2], field1407[3]);
         }
      }

   }

   @ObfuscatedName("az")
   final boolean method1540(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1416 = class84.field1444;
      field1417 = class84.field1453;
      field1373 = class84.colorPalette;
      field1419 = class84.field1451;
   }

   @ObfuscatedName("w")
   public void method1543() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1356 = 0;
   }

   @ObfuscatedName("d")
   public void method1546(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1358; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1356 = 0;
   }

   @ObfuscatedName("s")
   public Model method1558(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1518();
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
               var11.field1358 = this.field1358;
               var11.field1369 = this.field1369;
               var11.field1366 = this.field1366;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1368 = this.field1368;
               var11.field1361 = this.field1361;
               var11.field1380 = this.field1380;
               var11.field1371 = this.field1371;
               var11.field1372 = this.field1372;
               var11.field1360 = this.field1360;
               var11.field1415 = this.field1415;
               var11.field1375 = this.field1375;
               var11.field1377 = this.field1377;
               var11.field1378 = this.field1378;
               var11.field1395 = this.field1395;
               var11.field1374 = this.field1374;
               var11.field1381 = this.field1381;
               var11.field1382 = this.field1382;
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

            var11.field1356 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("x")
   public int method1569() {
      this.method1518();
      return this.field1399;
   }

   Model() {
   }

   @ObfuscatedName("j")
   public void method1589() {
      for(int var1 = 0; var1 < this.field1358; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1356 = 0;
   }
}

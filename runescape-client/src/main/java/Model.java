import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("az")
   static int[] field1365 = new int[1600];
   @ObfuscatedName("n")
   static byte[] field1366 = new byte[1];
   @ObfuscatedName("g")
   static Model field1367 = new Model();
   @ObfuscatedName("bn")
   public static int field1368 = 0;
   @ObfuscatedName("y")
   int field1369 = 0;
   @ObfuscatedName("be")
   static int[] field1370;
   @ObfuscatedName("j")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("m")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("bi")
   public static boolean field1373 = false;
   @ObfuscatedName("l")
   short[] field1374;
   @ObfuscatedName("s")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("aw")
   static int[][] field1376 = new int[12][2000];
   @ObfuscatedName("x")
   static Model field1377 = new Model();
   @ObfuscatedName("ax")
   static int[] field1378 = new int[4700];
   @ObfuscatedName("q")
   int[] field1379;
   @ObfuscatedName("d")
   int[] field1380;
   @ObfuscatedName("b")
   byte[] field1381;
   @ObfuscatedName("w")
   byte[] field1382;
   @ObfuscatedName("c")
   byte[] field1383;
   @ObfuscatedName("a")
   int field1384 = 0;
   @ObfuscatedName("u")
   int field1385 = 0;
   @ObfuscatedName("e")
   int[] field1386;
   @ObfuscatedName("h")
   int[] field1387;
   @ObfuscatedName("ab")
   public boolean field1388 = false;
   @ObfuscatedName("z")
   int[][] field1389;
   @ObfuscatedName("t")
   int[][] field1390;
   @ObfuscatedName("ai")
   static int[] field1391 = new int[2000];
   @ObfuscatedName("ac")
   int field1392;
   @ObfuscatedName("au")
   int field1393;
   @ObfuscatedName("al")
   int field1394;
   @ObfuscatedName("ae")
   int field1395;
   @ObfuscatedName("r")
   byte field1396 = 0;
   @ObfuscatedName("ap")
   static int[] field1398 = new int[12];
   @ObfuscatedName("af")
   static boolean[] field1399 = new boolean[4700];
   @ObfuscatedName("as")
   static int[] field1400 = new int[4700];
   @ObfuscatedName("ao")
   static int[] field1401 = new int[4700];
   @ObfuscatedName("p")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("an")
   static int[] field1403 = new int[4700];
   @ObfuscatedName("ag")
   static int[] field1404 = new int[4700];
   @ObfuscatedName("aj")
   static int[] field1405 = new int[4700];
   @ObfuscatedName("k")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("av")
   static int[][] field1408 = new int[1600][512];
   @ObfuscatedName("br")
   public static int field1410 = 0;
   @ObfuscatedName("ay")
   static int[] field1411 = new int[2000];
   @ObfuscatedName("f")
   int[] field1412;
   @ObfuscatedName("at")
   static int[] field1413 = new int[12];
   @ObfuscatedName("ah")
   static int[] field1414 = new int[10];
   @ObfuscatedName("am")
   static int[] field1415 = new int[10];
   @ObfuscatedName("o")
   int[] field1416;
   @ObfuscatedName("by")
   static int field1417;
   @ObfuscatedName("bf")
   static int field1418;
   @ObfuscatedName("bj")
   static int field1419;
   @ObfuscatedName("bl")
   public static int[] field1420 = new int[1000];
   @ObfuscatedName("ak")
   static int[] field1421 = new int[10];
   @ObfuscatedName("aa")
   static boolean[] field1422 = new boolean[4700];
   @ObfuscatedName("bx")
   public static int field1423 = 0;
   @ObfuscatedName("i")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ad")
   int field1425;
   @ObfuscatedName("bv")
   static int[] field1426;
   @ObfuscatedName("bu")
   static int[] field1427;
   @ObfuscatedName("bb")
   static int[] field1428;
   @ObfuscatedName("v")
   static byte[] field1430 = new byte[1];

   @ObfuscatedName("ca")
   void vmethod1972(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1365[0] = -1;
      if(this.field1392 != 1) {
         this.method1649();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1394 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1394) * class84.field1453;
         if(var15 / var13 < class84.field1452) {
            int var16 = (var14 + this.field1394) * class84.field1453;
            if(var16 / var13 > class84.field1450) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1394 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1453;
               if(var19 / var13 > class84.field1451) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1453;
                  if(var21 / var13 < class84.field1458) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1385 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1373) {
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

                        var28 = field1410 - class84.field1447;
                        var29 = field1368 - class84.field1448;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1388) {
                              field1420[field1423++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1447;
                     var28 = class84.field1448;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1370[var1];
                        var30 = field1426[var1];
                     }

                     for(int var31 = 0; var31 < this.field1369; ++var31) {
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
                        field1378[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1400[var31] = var27 + var32 * class84.field1453 / var34;
                           field1401[var31] = var28 + var35 * class84.field1453 / var34;
                        } else {
                           field1400[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1403[var31] = var32;
                           field1404[var31] = var35;
                           field1405[var31] = var34;
                        }
                     }

                     try {
                        this.method1678(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   public Model method1647(boolean var1) {
      if(!var1 && field1430.length < this.field1384) {
         field1430 = new byte[this.field1384 + 100];
      }

      return this.method1664(var1, field1367, field1430);
   }

   @ObfuscatedName("p")
   public void method1649() {
      if(this.field1392 != 1) {
         this.field1392 = 1;
         super.modelHeight = 0;
         this.field1393 = 0;
         this.field1394 = 0;

         for(int var1 = 0; var1 < this.field1369; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1393) {
               this.field1393 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1394) {
               this.field1394 = var5;
            }
         }

         this.field1394 = (int)(Math.sqrt((double)this.field1394) + 0.99D);
         this.field1425 = (int)(Math.sqrt((double)(this.field1394 * this.field1394 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1395 = this.field1425 + (int)(Math.sqrt((double)(this.field1394 * this.field1394 + this.field1393 * this.field1393)) + 0.99D);
      }
   }

   @ObfuscatedName("j")
   void method1650() {
      if(this.field1392 != 2) {
         this.field1392 = 2;
         this.field1394 = 0;

         for(int var1 = 0; var1 < this.field1369; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1394) {
               this.field1394 = var5;
            }
         }

         this.field1394 = (int)(Math.sqrt((double)this.field1394) + 0.99D);
         this.field1425 = this.field1394;
         this.field1395 = this.field1394 + this.field1394;
      }
   }

   @ObfuscatedName("s")
   public int method1651() {
      this.method1649();
      return this.field1394;
   }

   @ObfuscatedName("k")
   public void method1652(Frames var1, int var2) {
      if(this.field1389 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1581[var2];
            FrameMap var4 = var3.field1327;
            field1417 = 0;
            field1418 = 0;
            field1419 = 0;

            for(int var5 = 0; var5 < var3.field1331; ++var5) {
               int var6 = var3.field1329[var5];
               this.method1659(var4.field1471[var6], var4.field1473[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1392 = 0;
         }
      }
   }

   @ObfuscatedName("f")
   public void method1653(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1581[var2];
            Frame var7 = var3.field1581[var4];
            FrameMap var8 = var6.field1327;
            field1417 = 0;
            field1418 = 0;
            field1419 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1331; ++var11) {
               for(var12 = var6.field1329[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1471[var12] == 0) {
                  this.method1659(var8.field1471[var12], var8.field1473[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1417 = 0;
            field1418 = 0;
            field1419 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1331; ++var11) {
               for(var12 = var7.field1329[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1471[var12] == 0) {
                  this.method1659(var8.field1471[var12], var8.field1473[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1392 = 0;
         } else {
            this.method1652(var1, var2);
         }
      }
   }

   @ObfuscatedName("x")
   public Model method1654(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1649();
      int var7 = var2 - this.field1394;
      int var8 = var2 + this.field1394;
      int var9 = var4 - this.field1394;
      int var10 = var4 + this.field1394;
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
               var11.field1369 = this.field1369;
               var11.field1384 = this.field1384;
               var11.field1385 = this.field1385;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1412 = this.field1412;
               var11.field1416 = this.field1416;
               var11.field1379 = this.field1379;
               var11.field1383 = this.field1383;
               var11.field1381 = this.field1381;
               var11.field1382 = this.field1382;
               var11.field1374 = this.field1374;
               var11.field1396 = this.field1396;
               var11.field1386 = this.field1386;
               var11.field1387 = this.field1387;
               var11.field1380 = this.field1380;
               var11.field1389 = this.field1389;
               var11.field1390 = this.field1390;
               var11.field1388 = this.field1388;
               var11.verticesY = new int[var11.field1369];
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
               for(var12 = 0; var12 < var11.field1369; ++var12) {
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
               for(var12 = 0; var12 < var11.field1369; ++var12) {
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

            var11.field1392 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("o")
   void method1659(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1417 = 0;
         field1418 = 0;
         field1419 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1389.length) {
               int[] var10 = this.field1389[var18];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1417 += this.verticesX[var12];
                  field1418 += this.verticesY[var12];
                  field1419 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1417 = field1417 / var7 + var3;
            field1418 = field1418 / var7 + var4;
            field1419 = field1419 / var7 + var5;
         } else {
            field1417 = var3;
            field1418 = var4;
            field1419 = var5;
         }

      } else {
         int[] var9;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1389.length) {
                  var9 = this.field1389[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1389.length) {
                  var9 = this.field1389[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] -= field1417;
                     this.verticesY[var11] -= field1418;
                     this.verticesZ[var11] -= field1419;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1370[var14];
                        var16 = field1426[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1370[var12];
                        var16 = field1426[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1370[var13];
                        var16 = field1426[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1417;
                     this.verticesY[var11] += field1418;
                     this.verticesZ[var11] += field1419;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1389.length) {
                  var9 = this.field1389[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] -= field1417;
                     this.verticesY[var11] -= field1418;
                     this.verticesZ[var11] -= field1419;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1417;
                     this.verticesY[var11] += field1418;
                     this.verticesZ[var11] += field1419;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1390 != null && this.field1381 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1390.length) {
                     var9 = this.field1390[var8];

                     for(var19 = 0; var19 < var9.length; ++var19) {
                        var11 = var9[var19];
                        var12 = (this.field1381[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1381[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   public void method1660(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1369; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1392 = 0;
   }

   @ObfuscatedName("h")
   public final void method1661(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1365[0] = -1;
      if(this.field1392 != 2 && this.field1392 != 1) {
         this.method1650();
      }

      int var8 = class84.field1447;
      int var9 = class84.field1448;
      int var10000 = field1370[var1];
      var10000 = field1426[var1];
      int var12 = field1370[var2];
      int var13 = field1426[var2];
      int var14 = field1370[var3];
      int var15 = field1426[var3];
      int var16 = field1370[var4];
      int var17 = field1426[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1369; ++var19) {
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
         field1378[var19] = var22 - var18;
         field1400[var19] = var8 + var20 * class84.field1453 / var22;
         field1401[var19] = var9 + var23 * class84.field1453 / var22;
         if(this.field1385 > 0) {
            field1403[var19] = var20;
            field1404[var19] = var23;
            field1405[var19] = var22;
         }
      }

      try {
         this.method1678(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("d")
   public final void method1662(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1365[0] = -1;
      if(this.field1392 != 2 && this.field1392 != 1) {
         this.method1650();
      }

      int var9 = class84.field1447;
      int var10 = class84.field1448;
      int var10000 = field1370[var1];
      var10000 = field1426[var1];
      int var13 = field1370[var2];
      int var14 = field1426[var2];
      int var15 = field1370[var3];
      int var16 = field1426[var3];
      int var17 = field1370[var4];
      int var18 = field1426[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1369; ++var20) {
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
         field1378[var20] = var23 - var19;
         field1400[var20] = var9 + var21 * class84.field1453 / var8;
         field1401[var20] = var10 + var24 * class84.field1453 / var8;
         if(this.field1385 > 0) {
            field1403[var20] = var21;
            field1404[var20] = var24;
            field1405[var20] = var23;
         }
      }

      try {
         this.method1678(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("y")
   Model method1664(boolean var1, Model var2, byte[] var3) {
      var2.field1369 = this.field1369;
      var2.field1384 = this.field1384;
      var2.field1385 = this.field1385;
      if(var2.verticesX == null || var2.verticesX.length < this.field1369) {
         var2.verticesX = new int[this.field1369 + 100];
         var2.verticesY = new int[this.field1369 + 100];
         var2.verticesZ = new int[this.field1369 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1369; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1381 = this.field1381;
      } else {
         var2.field1381 = var3;
         if(this.field1381 == null) {
            for(var4 = 0; var4 < this.field1384; ++var4) {
               var2.field1381[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1384; ++var4) {
               var2.field1381[var4] = this.field1381[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1412 = this.field1412;
      var2.field1416 = this.field1416;
      var2.field1379 = this.field1379;
      var2.field1383 = this.field1383;
      var2.field1382 = this.field1382;
      var2.field1374 = this.field1374;
      var2.field1396 = this.field1396;
      var2.field1386 = this.field1386;
      var2.field1387 = this.field1387;
      var2.field1380 = this.field1380;
      var2.field1389 = this.field1389;
      var2.field1390 = this.field1390;
      var2.field1388 = this.field1388;
      var2.field1392 = 0;
      return var2;
   }

   @ObfuscatedName("t")
   final void method1665(int var1) {
      if(field1399[var1]) {
         this.method1717(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1422[var1];
         if(this.field1381 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1381[var1] & 255;
         }

         if(this.field1374 != null && this.field1374[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1382 != null && this.field1382[var1] != -1) {
               int var8 = this.field1382[var1] & 255;
               var5 = this.field1386[var8];
               var6 = this.field1387[var8];
               var7 = this.field1380[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1379[var1] == -1) {
               class84.rasterTextureAffine(field1401[var2], field1401[var3], field1401[var4], field1400[var2], field1400[var3], field1400[var4], this.field1412[var1], this.field1412[var1], this.field1412[var1], field1403[var5], field1403[var6], field1403[var7], field1404[var5], field1404[var6], field1404[var7], field1405[var5], field1405[var6], field1405[var7], this.field1374[var1]);
            } else {
               class84.rasterTextureAffine(field1401[var2], field1401[var3], field1401[var4], field1400[var2], field1400[var3], field1400[var4], this.field1412[var1], this.field1416[var1], this.field1379[var1], field1403[var5], field1403[var6], field1403[var7], field1404[var5], field1404[var6], field1404[var7], field1405[var5], field1405[var6], field1405[var7], this.field1374[var1]);
            }
         } else if(this.field1379[var1] == -1) {
            class84.rasterFlat(field1401[var2], field1401[var3], field1401[var4], field1400[var2], field1400[var3], field1400[var4], field1427[this.field1412[var1]]);
         } else {
            class84.rasterGouraud(field1401[var2], field1401[var3], field1401[var4], field1400[var2], field1400[var3], field1400[var4], this.field1412[var1], this.field1416[var1], this.field1379[var1]);
         }

      }
   }

   @ObfuscatedName("ac")
   final boolean method1667(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1370 = class84.field1460;
      field1426 = class84.field1446;
      field1427 = class84.colorPalette;
      field1428 = class84.field1459;
   }

   @ObfuscatedName("r")
   public void method1676(int var1) {
      int var2 = field1370[var1];
      int var3 = field1426[var1];

      for(int var4 = 0; var4 < this.field1369; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1392 = 0;
   }

   @ObfuscatedName("z")
   final void method1678(boolean var1, boolean var2, int var3) {
      if(this.field1395 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1395; ++var4) {
            field1365[var4] = 0;
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
         for(var4 = 0; var4 < this.field1384; ++var4) {
            if(this.field1379[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1400[var5];
               var9 = field1400[var6];
               var10 = field1400[var7];
               int var25;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method1667(field1410, field1368, field1401[var5], field1401[var6], field1401[var7], var8, var9, var10)) {
                     field1420[field1423++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1401[var7] - field1401[var6]) - (field1401[var5] - field1401[var6]) * (var10 - var9) > 0) {
                     field1399[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1422[var4] = false;
                     } else {
                        field1422[var4] = true;
                     }

                     var25 = (field1378[var5] + field1378[var6] + field1378[var7]) / 3 + this.field1425;
                     field1408[var25][field1365[var25]++] = var4;
                  }
               } else {
                  var25 = field1403[var5];
                  var12 = field1403[var6];
                  var13 = field1403[var7];
                  int var14 = field1404[var5];
                  var15 = field1404[var6];
                  int var16 = field1404[var7];
                  int var17 = field1405[var5];
                  int var18 = field1405[var6];
                  int var19 = field1405[var7];
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
                     field1399[var4] = true;
                     int var23 = (field1378[var5] + field1378[var6] + field1378[var7]) / 3 + this.field1425;
                     field1408[var23][field1365[var23]++] = var4;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1383 == null) {
            for(var4 = this.field1395 - 1; var4 >= 0; --var4) {
               var5 = field1365[var4];
               if(var5 > 0) {
                  var27 = field1408[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1665(var27[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1398[var4] = 0;
               field1413[var4] = 0;
            }

            for(var4 = this.field1395 - 1; var4 >= 0; --var4) {
               var5 = field1365[var4];
               if(var5 > 0) {
                  var27 = field1408[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var27[var7];
                     byte var28 = this.field1383[var8];
                     var10 = field1398[var28]++;
                     field1376[var28][var10] = var8;
                     if(var28 < 10) {
                        field1413[var28] += var4;
                     } else if(var28 == 10) {
                        field1411[var10] = var4;
                     } else {
                        field1391[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1398[1] > 0 || field1398[2] > 0) {
               var4 = (field1413[1] + field1413[2]) / (field1398[1] + field1398[2]);
            }

            var5 = 0;
            if(field1398[3] > 0 || field1398[4] > 0) {
               var5 = (field1413[3] + field1413[4]) / (field1398[3] + field1398[4]);
            }

            var6 = 0;
            if(field1398[6] > 0 || field1398[8] > 0) {
               var6 = (field1413[6] + field1413[8]) / (field1398[6] + field1398[8]);
            }

            var8 = 0;
            var9 = field1398[10];
            int[] var26 = field1376[10];
            int[] var11 = field1411;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1398[11];
               var26 = field1376[11];
               var11 = field1391;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1665(var26[var8++]);
                  if(var8 == var9 && var26 != field1376[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var26 = field1376[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1665(var26[var8++]);
                  if(var8 == var9 && var26 != field1376[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var26 = field1376[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1665(var26[var8++]);
                  if(var8 == var9 && var26 != field1376[11]) {
                     var8 = 0;
                     var9 = field1398[11];
                     var26 = field1376[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1398[var12];
               int[] var24 = field1376[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1665(var24[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1665(var26[var8++]);
               if(var8 == var9 && var26 != field1376[11]) {
                  var8 = 0;
                  var26 = field1376[11];
                  var9 = field1398[11];
                  var11 = field1391;
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

   @ObfuscatedName("u")
   public void method1694(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1369; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1392 = 0;
   }

   @ObfuscatedName("n")
   public Model method1697(boolean var1) {
      if(!var1 && field1366.length < this.field1384) {
         field1366 = new byte[this.field1384 + 100];
      }

      return this.method1664(var1, field1377, field1366);
   }

   @ObfuscatedName("c")
   public void method1700() {
      for(int var1 = 0; var1 < this.field1369; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1392 = 0;
   }

   Model() {
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1369 = 0;
      this.field1384 = 0;
      this.field1385 = 0;
      this.field1396 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1369 += var8.field1369;
            this.field1384 += var8.field1384;
            this.field1385 += var8.field1385;
            if(var8.field1383 != null) {
               var3 = true;
            } else {
               if(this.field1396 == -1) {
                  this.field1396 = var8.field1396;
               }

               if(this.field1396 != var8.field1396) {
                  var3 = true;
               }
            }

            var4 |= var8.field1381 != null;
            var5 |= var8.field1374 != null;
            var6 |= var8.field1382 != null;
         }
      }

      this.verticesX = new int[this.field1369];
      this.verticesY = new int[this.field1369];
      this.verticesZ = new int[this.field1369];
      this.indices1 = new int[this.field1384];
      this.indices2 = new int[this.field1384];
      this.indices3 = new int[this.field1384];
      this.field1412 = new int[this.field1384];
      this.field1416 = new int[this.field1384];
      this.field1379 = new int[this.field1384];
      if(var3) {
         this.field1383 = new byte[this.field1384];
      }

      if(var4) {
         this.field1381 = new byte[this.field1384];
      }

      if(var5) {
         this.field1374 = new short[this.field1384];
      }

      if(var6) {
         this.field1382 = new byte[this.field1384];
      }

      if(this.field1385 > 0) {
         this.field1386 = new int[this.field1385];
         this.field1387 = new int[this.field1385];
         this.field1380 = new int[this.field1385];
      }

      this.field1369 = 0;
      this.field1384 = 0;
      this.field1385 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1384; ++var9) {
               this.indices1[this.field1384] = var8.indices1[var9] + this.field1369;
               this.indices2[this.field1384] = var8.indices2[var9] + this.field1369;
               this.indices3[this.field1384] = var8.indices3[var9] + this.field1369;
               this.field1412[this.field1384] = var8.field1412[var9];
               this.field1416[this.field1384] = var8.field1416[var9];
               this.field1379[this.field1384] = var8.field1379[var9];
               if(var3) {
                  if(var8.field1383 != null) {
                     this.field1383[this.field1384] = var8.field1383[var9];
                  } else {
                     this.field1383[this.field1384] = var8.field1396;
                  }
               }

               if(var4 && var8.field1381 != null) {
                  this.field1381[this.field1384] = var8.field1381[var9];
               }

               if(var5) {
                  if(var8.field1374 != null) {
                     this.field1374[this.field1384] = var8.field1374[var9];
                  } else {
                     this.field1374[this.field1384] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1382 != null && var8.field1382[var9] != -1) {
                     this.field1382[this.field1384] = (byte)(var8.field1382[var9] + this.field1385);
                  } else {
                     this.field1382[this.field1384] = -1;
                  }
               }

               ++this.field1384;
            }

            for(var9 = 0; var9 < var8.field1385; ++var9) {
               this.field1386[this.field1385] = var8.field1386[var9] + this.field1369;
               this.field1387[this.field1385] = var8.field1387[var9] + this.field1369;
               this.field1380[this.field1385] = var8.field1380[var9] + this.field1369;
               ++this.field1385;
            }

            for(var9 = 0; var9 < var8.field1369; ++var9) {
               this.verticesX[this.field1369] = var8.verticesX[var9];
               this.verticesY[this.field1369] = var8.verticesY[var9];
               this.verticesZ[this.field1369] = var8.verticesZ[var9];
               ++this.field1369;
            }
         }
      }

   }

   @ObfuscatedName("ab")
   final void method1717(int var1) {
      int var2 = class84.field1447;
      int var3 = class84.field1448;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1405[var5];
      int var9 = field1405[var6];
      int var10 = field1405[var7];
      if(this.field1381 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1381[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1414[var4] = field1400[var5];
         field1415[var4] = field1401[var5];
         field1421[var4++] = this.field1412[var1];
      } else {
         var11 = field1403[var5];
         var12 = field1404[var5];
         var13 = this.field1412[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1428[var10 - var8];
            field1414[var4] = var2 + (var11 + ((field1403[var7] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var7] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1379[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1428[var9 - var8];
            field1414[var4] = var2 + (var11 + ((field1403[var6] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var6] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1416[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1414[var4] = field1400[var6];
         field1415[var4] = field1401[var6];
         field1421[var4++] = this.field1416[var1];
      } else {
         var11 = field1403[var6];
         var12 = field1404[var6];
         var13 = this.field1416[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1428[var8 - var9];
            field1414[var4] = var2 + (var11 + ((field1403[var5] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var5] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1412[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1428[var10 - var9];
            field1414[var4] = var2 + (var11 + ((field1403[var7] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var7] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1379[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1414[var4] = field1400[var7];
         field1415[var4] = field1401[var7];
         field1421[var4++] = this.field1379[var1];
      } else {
         var11 = field1403[var7];
         var12 = field1404[var7];
         var13 = this.field1379[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1428[var9 - var10];
            field1414[var4] = var2 + (var11 + ((field1403[var6] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var6] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1416[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1428[var8 - var10];
            field1414[var4] = var2 + (var11 + ((field1403[var5] - var11) * var14 >> 16)) * class84.field1453 / 50;
            field1415[var4] = var3 + (var12 + ((field1404[var5] - var12) * var14 >> 16)) * class84.field1453 / 50;
            field1421[var4++] = var13 + ((this.field1412[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1414[0];
      var12 = field1414[1];
      var13 = field1414[2];
      var14 = field1415[0];
      int var15 = field1415[1];
      int var16 = field1415[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1374 != null && this.field1374[var1] != -1) {
            if(this.field1382 != null && this.field1382[var1] != -1) {
               var20 = this.field1382[var1] & 255;
               var17 = this.field1386[var20];
               var18 = this.field1387[var20];
               var19 = this.field1380[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1379[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1412[var1], this.field1412[var1], this.field1412[var1], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], this.field1374[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1421[0], field1421[1], field1421[2], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], this.field1374[var1]);
            }
         } else if(this.field1379[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1427[this.field1412[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1421[0], field1421[1], field1421[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1414[3] < 0 || field1414[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1374 != null && this.field1374[var1] != -1) {
            if(this.field1382 != null && this.field1382[var1] != -1) {
               var20 = this.field1382[var1] & 255;
               var17 = this.field1386[var20];
               var18 = this.field1387[var20];
               var19 = this.field1380[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1374[var1];
            if(this.field1379[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1412[var1], this.field1412[var1], this.field1412[var1], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1415[3], var11, var13, field1414[3], this.field1412[var1], this.field1412[var1], this.field1412[var1], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1421[0], field1421[1], field1421[2], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1415[3], var11, var13, field1414[3], field1421[0], field1421[2], field1421[3], field1403[var17], field1403[var18], field1403[var19], field1404[var17], field1404[var18], field1404[var19], field1405[var17], field1405[var18], field1405[var19], var21);
            }
         } else if(this.field1379[var1] == -1) {
            var17 = field1427[this.field1412[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1415[3], var11, var13, field1414[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1421[0], field1421[1], field1421[2]);
            class84.rasterGouraud(var14, var16, field1415[3], var11, var13, field1414[3], field1421[0], field1421[2], field1421[3]);
         }
      }

   }

   @ObfuscatedName("q")
   public void method1718() {
      for(int var1 = 0; var1 < this.field1369; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1392 = 0;
   }

   @ObfuscatedName("l")
   public void method1719() {
      for(int var1 = 0; var1 < this.field1369; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1392 = 0;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ag")
   static int[] field1344;
   @ObfuscatedName("a")
   short[] field1345;
   @ObfuscatedName("n")
   static Model field1346;
   @ObfuscatedName("q")
   static byte[] field1347;
   @ObfuscatedName("h")
   int field1348;
   @ObfuscatedName("p")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("u")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ak")
   int field1351;
   @ObfuscatedName("l")
   int field1352;
   @ObfuscatedName("bf")
   //@Export("COSINE2")
   static int[] COSINE2;
   @ObfuscatedName("bw")
   public static int field1354;
   @ObfuscatedName("w")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("r")
   int[] field1356;
   @ObfuscatedName("s")
   int[] field1357;
   @ObfuscatedName("f")
   int[] field1358;
   @ObfuscatedName("e")
   byte[] field1359;
   @ObfuscatedName("j")
   byte[] field1360;
   @ObfuscatedName("i")
   byte[] field1361;
   @ObfuscatedName("an")
   static int[] field1362;
   @ObfuscatedName("c")
   static byte[] field1363;
   @ObfuscatedName("k")
   int[] field1364;
   @ObfuscatedName("bv")
   //@Export("SINE2")
   static int[] SINE2;
   @ObfuscatedName("at")
   static int[] field1366;
   @ObfuscatedName("ac")
   int field1367;
   @ObfuscatedName("m")
   int[][] field1368;
   @ObfuscatedName("y")
   int[][] field1369;
   @ObfuscatedName("am")
   public boolean field1370;
   @ObfuscatedName("ab")
   static int[] field1371;
   @ObfuscatedName("o")
   int[] field1372;
   @ObfuscatedName("az")
   int field1373;
   @ObfuscatedName("ao")
   int field1374;
   @ObfuscatedName("aj")
   static boolean[] field1375;
   @ObfuscatedName("g")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("d")
   static Model field1377;
   @ObfuscatedName("ay")
   static boolean[] field1378;
   @ObfuscatedName("ae")
   static int[] field1379;
   @ObfuscatedName("ax")
   int field1380;
   @ObfuscatedName("av")
   static int[] field1381;
   @ObfuscatedName("aw")
   static int[] field1382;
   @ObfuscatedName("b")
   int[] field1383;
   @ObfuscatedName("af")
   static int[] field1384;
   @ObfuscatedName("aq")
   static int[] field1386;
   @ObfuscatedName("v")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ai")
   static int[] field1388;
   @ObfuscatedName("ad")
   static int[][] field1389;
   @ObfuscatedName("z")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("al")
   static int[] field1391;
   @ObfuscatedName("ah")
   static int[] field1393;
   @ObfuscatedName("ap")
   static int[] field1394;
   @ObfuscatedName("au")
   static int[] field1395;
   @ObfuscatedName("bu")
   static int field1396;
   @ObfuscatedName("br")
   static int field1397;
   @ObfuscatedName("bk")
   static int field1398;
   @ObfuscatedName("bo")
   public static boolean field1399;
   @ObfuscatedName("t")
   int field1400;
   @ObfuscatedName("bi")
   public static int field1401;
   @ObfuscatedName("bl")
   public static int field1402;
   @ObfuscatedName("by")
   public static int[] field1403;
   @ObfuscatedName("x")
   byte field1404;
   @ObfuscatedName("as")
   static int[][] field1405;
   @ObfuscatedName("be")
   static int[] field1406;
   @ObfuscatedName("bm")
   static int[] field1407;

   Model() {
      this.field1400 = 0;
      this.field1352 = 0;
      this.field1404 = 0;
      this.field1348 = 0;
      this.field1370 = false;
   }

   @ObfuscatedName("c")
   public Model method1571(boolean var1) {
      if(!var1 && field1363.length < this.field1352) {
         field1363 = new byte[this.field1352 + 100];
      }

      return this.method1573(var1, field1377, field1363);
   }

   @ObfuscatedName("q")
   public Model method1572(boolean var1) {
      if(!var1 && field1347.length < this.field1352) {
         field1347 = new byte[this.field1352 + 100];
      }

      return this.method1573(var1, field1346, field1347);
   }

   @ObfuscatedName("t")
   Model method1573(boolean var1, Model var2, byte[] var3) {
      var2.field1400 = this.field1400;
      var2.field1352 = this.field1352;
      var2.field1348 = this.field1348;
      if(var2.verticesX == null || var2.verticesX.length < this.field1400) {
         var2.verticesX = new int[this.field1400 + 100];
         var2.verticesY = new int[this.field1400 + 100];
         var2.verticesZ = new int[this.field1400 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1400; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1360 = this.field1360;
      } else {
         var2.field1360 = var3;
         if(this.field1360 == null) {
            for(var4 = 0; var4 < this.field1352; ++var4) {
               var2.field1360[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1352; ++var4) {
               var2.field1360[var4] = this.field1360[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1356 = this.field1356;
      var2.field1357 = this.field1357;
      var2.field1364 = this.field1364;
      var2.field1359 = this.field1359;
      var2.field1361 = this.field1361;
      var2.field1345 = this.field1345;
      var2.field1404 = this.field1404;
      var2.field1383 = this.field1383;
      var2.field1358 = this.field1358;
      var2.field1372 = this.field1372;
      var2.field1368 = this.field1368;
      var2.field1369 = this.field1369;
      var2.field1370 = this.field1370;
      var2.field1380 = 0;
      return var2;
   }

   @ObfuscatedName("p")
   public void method1574() {
      if(this.field1380 != 1) {
         this.field1380 = 1;
         super.modelHeight = 0;
         this.field1367 = 0;
         this.field1373 = 0;

         for(int var1 = 0; var1 < this.field1400; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1367) {
               this.field1367 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1373) {
               this.field1373 = var5;
            }
         }

         this.field1373 = (int)(Math.sqrt((double)this.field1373) + 0.99D);
         this.field1351 = (int)(Math.sqrt((double)(this.field1373 * this.field1373 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1374 = this.field1351 + (int)(Math.sqrt((double)(this.field1373 * this.field1373 + this.field1367 * this.field1367)) + 0.99D);
      }
   }

   @ObfuscatedName("u")
   void method1576() {
      if(this.field1380 != 2) {
         this.field1380 = 2;
         this.field1373 = 0;

         for(int var1 = 0; var1 < this.field1400; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1373) {
               this.field1373 = var5;
            }
         }

         this.field1373 = (int)(Math.sqrt((double)this.field1373) + 0.99D);
         this.field1351 = this.field1373;
         this.field1374 = this.field1373 + this.field1373;
      }
   }

   @ObfuscatedName("r")
   public void method1577(Frames var1, int var2) {
      if(this.field1368 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1558[var2];
            FrameMap var4 = var3.field1309;
            field1396 = 0;
            field1397 = 0;
            field1398 = 0;

            for(int var5 = 0; var5 < var3.field1310; ++var5) {
               int var6 = var3.field1311[var5];
               this.method1579(var4.field1456[var6], var4.field1457[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.field1380 = 0;
         }
      }
   }

   @ObfuscatedName("s")
   public void method1578(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1558[var2];
            Frame var7 = var3.field1558[var4];
            FrameMap var8 = var6.field1309;
            field1396 = 0;
            field1397 = 0;
            field1398 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1310; ++var11) {
               for(var12 = var6.field1311[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1456[var12] == 0) {
                  this.method1579(var8.field1456[var12], var8.field1457[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1396 = 0;
            field1397 = 0;
            field1398 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1310; ++var11) {
               for(var12 = var7.field1311[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1456[var12] == 0) {
                  this.method1579(var8.field1456[var12], var8.field1457[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.field1380 = 0;
         } else {
            this.method1577(var1, var2);
         }
      }
   }

   @ObfuscatedName("a")
   void method1579(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1396 = 0;
         field1397 = 0;
         field1398 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1368.length) {
               int[] var19 = this.field1368[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1396 += this.verticesX[var12];
                  field1397 += this.verticesY[var12];
                  field1398 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1396 = field1396 / var7 + var3;
            field1397 = field1397 / var7 + var4;
            field1398 = field1398 / var7 + var5;
         } else {
            field1396 = var3;
            field1397 = var4;
            field1398 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1368.length) {
                  var9 = this.field1368[var8];

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
               if(var8 < this.field1368.length) {
                  var9 = this.field1368[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1396;
                     this.verticesY[var11] -= field1397;
                     this.verticesZ[var11] -= field1398;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = SINE2[var14];
                        var16 = COSINE2[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = SINE2[var12];
                        var16 = COSINE2[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = SINE2[var13];
                        var16 = COSINE2[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1396;
                     this.verticesY[var11] += field1397;
                     this.verticesZ[var11] += field1398;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1368.length) {
                  var9 = this.field1368[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1396;
                     this.verticesY[var11] -= field1397;
                     this.verticesZ[var11] -= field1398;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1396;
                     this.verticesY[var11] += field1397;
                     this.verticesZ[var11] += field1398;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1369 != null && this.field1360 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1369.length) {
                     var9 = this.field1369[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1360[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1360[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public void method1580() {
      for(int var1 = 0; var1 < this.field1400; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("f")
   public void method1581(int var1) {
      int var2 = SINE2[var1];
      int var3 = COSINE2[var1];

      for(int var4 = 0; var4 < this.field1400; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("m")
   public void method1582(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1400; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("o")
   public void method1584(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1400; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("y")
   public final void method1586(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1371[0] = -1;
      if(this.field1380 != 2 && this.field1380 != 1) {
         this.method1576();
      }

      int var8 = class84.field1427;
      int var9 = class84.field1420;
      int var10000 = SINE2[var1];
      var10000 = COSINE2[var1];
      int var12 = SINE2[var2];
      int var13 = COSINE2[var2];
      int var14 = SINE2[var3];
      int var15 = COSINE2[var3];
      int var16 = SINE2[var4];
      int var17 = COSINE2[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1400; ++var19) {
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
         field1381[var19] = var22 - var18;
         field1379[var19] = var8 + var20 * class84.field1426 / var22;
         field1386[var19] = var9 + var23 * class84.field1426 / var22;
         if(this.field1348 > 0) {
            field1382[var19] = var20;
            field1344[var19] = var23;
            field1384[var19] = var22;
         }
      }

      try {
         this.method1629(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ct")
   void vmethod1902(int orientation, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1371[0] = -1;
      if(this.field1380 != 1) {
         this.method1574();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1373 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1373) * class84.field1426;
         if(var15 / var13 < class84.field1432) {
            int var16 = (var14 + this.field1373) * class84.field1426;
            if(var16 / var13 > class84.field1419) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1373 * var2 >> 16;
               int var19 = (var17 + var18) * class84.field1426;
               if(var19 / var13 > class84.field1424) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class84.field1426;
                  if(var21 / var13 < class84.field1434) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1348 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int sin;
                     if(var9 > 0 && field1399) {
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

                        var28 = field1354 - class84.field1427;
                        sin = field1401 - class84.field1420;
                        if(var28 > var15 && var28 < var16 && sin > var21 && sin < var19) {
                           if(this.field1370) {
                              field1403[field1402++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class84.field1427;
                     var28 = class84.field1420;
                     sin = 0;
                     int cos = 0;
                     if(orientation != 0) {
                        sin = SINE2[orientation];
                        cos = COSINE2[orientation];
                     }

                     for(int var31 = 0; var31 < this.field1400; ++var31) {
                        int vertexX = this.verticesX[var31];
                        int vertexY = this.verticesY[var31];
                        int vertexZ = this.verticesZ[var31];
                        int var35;
                        if(orientation != 0) {
                           var35 = vertexZ * sin + vertexX * cos >> 16;
                           vertexZ = vertexZ * cos - vertexX * sin >> 16;
                           vertexX = var35;
                        }

                        vertexX += var6;
                        vertexY += var7;
                        vertexZ += var8;
                        var35 = vertexZ * var4 + vertexX * var5 >> 16;
                        vertexZ = vertexZ * var5 - vertexX * var4 >> 16;
                        vertexX = var35;
                        var35 = vertexY * var3 - vertexZ * var2 >> 16;
                        vertexZ = vertexY * var2 + vertexZ * var3 >> 16;
                        field1381[var31] = vertexZ - var11;
                        if(vertexZ >= 50) {
                           field1379[var31] = var27 + vertexX * class84.field1426 / vertexZ;
                           field1386[var31] = var28 + var35 * class84.field1426 / vertexZ;
                        } else {
                           field1379[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1382[var31] = vertexX;
                           field1344[var31] = var35;
                           field1384[var31] = vertexZ;
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

   @ObfuscatedName("am")
   public final void method1589(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1371[0] = -1;
      if(this.field1380 != 2 && this.field1380 != 1) {
         this.method1576();
      }

      int var9 = class84.field1427;
      int var10 = class84.field1420;
      int var10000 = SINE2[var1];
      var10000 = COSINE2[var1];
      int var13 = SINE2[var2];
      int var14 = COSINE2[var2];
      int var15 = SINE2[var3];
      int var16 = COSINE2[var3];
      int var17 = SINE2[var4];
      int var18 = COSINE2[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1400; ++var20) {
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
         field1381[var20] = var23 - var19;
         field1379[var20] = var9 + var21 * class84.field1426 / var8;
         field1386[var20] = var10 + var24 * class84.field1426 / var8;
         if(this.field1348 > 0) {
            field1382[var20] = var21;
            field1344[var20] = var24;
            field1384[var20] = var23;
         }
      }

      try {
         this.method1629(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ac")
   final void method1590(int var1) {
      if(field1378[var1]) {
         this.method1591(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class84.rasterClipEnable = field1375[var1];
         if(this.field1360 == null) {
            class84.rasterAlpha = 0;
         } else {
            class84.rasterAlpha = this.field1360[var1] & 255;
         }

         if(this.field1345 != null && this.field1345[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1361 != null && this.field1361[var1] != -1) {
               int var8 = this.field1361[var1] & 255;
               var5 = this.field1383[var8];
               var6 = this.field1358[var8];
               var7 = this.field1372[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1364[var1] == -1) {
               class84.rasterTextureAffine(field1386[var2], field1386[var3], field1386[var4], field1379[var2], field1379[var3], field1379[var4], this.field1356[var1], this.field1356[var1], this.field1356[var1], field1382[var5], field1382[var6], field1382[var7], field1344[var5], field1344[var6], field1344[var7], field1384[var5], field1384[var6], field1384[var7], this.field1345[var1]);
            } else {
               class84.rasterTextureAffine(field1386[var2], field1386[var3], field1386[var4], field1379[var2], field1379[var3], field1379[var4], this.field1356[var1], this.field1357[var1], this.field1364[var1], field1382[var5], field1382[var6], field1382[var7], field1344[var5], field1344[var6], field1344[var7], field1384[var5], field1384[var6], field1384[var7], this.field1345[var1]);
            }
         } else if(this.field1364[var1] == -1) {
            class84.rasterFlat(field1386[var2], field1386[var3], field1386[var4], field1379[var2], field1379[var3], field1379[var4], field1406[this.field1356[var1]]);
         } else {
            class84.rasterGouraud(field1386[var2], field1386[var3], field1386[var4], field1379[var2], field1379[var3], field1379[var4], this.field1356[var1], this.field1357[var1], this.field1364[var1]);
         }

      }
   }

   @ObfuscatedName("az")
   final void method1591(int var1) {
      int var2 = class84.field1427;
      int var3 = class84.field1420;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1384[var5];
      int var9 = field1384[var6];
      int var10 = field1384[var7];
      if(this.field1360 == null) {
         class84.rasterAlpha = 0;
      } else {
         class84.rasterAlpha = this.field1360[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1393[var4] = field1379[var5];
         field1394[var4] = field1386[var5];
         field1395[var4++] = this.field1356[var1];
      } else {
         var11 = field1382[var5];
         var12 = field1344[var5];
         var13 = this.field1356[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1407[var10 - var8];
            field1393[var4] = var2 + (var11 + ((field1382[var7] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var7] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1364[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1407[var9 - var8];
            field1393[var4] = var2 + (var11 + ((field1382[var6] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var6] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1357[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1393[var4] = field1379[var6];
         field1394[var4] = field1386[var6];
         field1395[var4++] = this.field1357[var1];
      } else {
         var11 = field1382[var6];
         var12 = field1344[var6];
         var13 = this.field1357[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1407[var8 - var9];
            field1393[var4] = var2 + (var11 + ((field1382[var5] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var5] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1356[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1407[var10 - var9];
            field1393[var4] = var2 + (var11 + ((field1382[var7] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var7] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1364[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1393[var4] = field1379[var7];
         field1394[var4] = field1386[var7];
         field1395[var4++] = this.field1364[var1];
      } else {
         var11 = field1382[var7];
         var12 = field1344[var7];
         var13 = this.field1364[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1407[var9 - var10];
            field1393[var4] = var2 + (var11 + ((field1382[var6] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var6] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1357[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1407[var8 - var10];
            field1393[var4] = var2 + (var11 + ((field1382[var5] - var11) * var14 >> 16)) * class84.field1426 / 50;
            field1394[var4] = var3 + (var12 + ((field1344[var5] - var12) * var14 >> 16)) * class84.field1426 / 50;
            field1395[var4++] = var13 + ((this.field1356[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1393[0];
      var12 = field1393[1];
      var13 = field1393[2];
      var14 = field1394[0];
      int var15 = field1394[1];
      int var16 = field1394[2];
      class84.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1345 != null && this.field1345[var1] != -1) {
            if(this.field1361 != null && this.field1361[var1] != -1) {
               var20 = this.field1361[var1] & 255;
               var17 = this.field1383[var20];
               var18 = this.field1358[var20];
               var19 = this.field1372[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1364[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1356[var1], this.field1356[var1], this.field1356[var1], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], this.field1345[var1]);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1395[0], field1395[1], field1395[2], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], this.field1345[var1]);
            }
         } else if(this.field1364[var1] == -1) {
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, field1406[this.field1356[var1]]);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1395[0], field1395[1], field1395[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class84.rasterClipX || var12 > class84.rasterClipX || var13 > class84.rasterClipX || field1393[3] < 0 || field1393[3] > class84.rasterClipX) {
            class84.rasterClipEnable = true;
         }

         if(this.field1345 != null && this.field1345[var1] != -1) {
            if(this.field1361 != null && this.field1361[var1] != -1) {
               var20 = this.field1361[var1] & 255;
               var17 = this.field1383[var20];
               var18 = this.field1358[var20];
               var19 = this.field1372[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1345[var1];
            if(this.field1364[var1] == -1) {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1356[var1], this.field1356[var1], this.field1356[var1], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1394[3], var11, var13, field1393[3], this.field1356[var1], this.field1356[var1], this.field1356[var1], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], var21);
            } else {
               class84.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1395[0], field1395[1], field1395[2], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], var21);
               class84.rasterTextureAffine(var14, var16, field1394[3], var11, var13, field1393[3], field1395[0], field1395[2], field1395[3], field1382[var17], field1382[var18], field1382[var19], field1344[var17], field1344[var18], field1344[var19], field1384[var17], field1384[var18], field1384[var19], var21);
            }
         } else if(this.field1364[var1] == -1) {
            var17 = field1406[this.field1356[var1]];
            class84.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class84.rasterFlat(var14, var16, field1394[3], var11, var13, field1393[3], var17);
         } else {
            class84.rasterGouraud(var14, var15, var16, var11, var12, var13, field1395[0], field1395[1], field1395[2]);
            class84.rasterGouraud(var14, var16, field1394[3], var11, var13, field1393[3], field1395[0], field1395[2], field1395[3]);
         }
      }

   }

   @ObfuscatedName("h")
   public void method1593() {
      for(int var1 = 0; var1 < this.field1400; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("w")
   public int method1594() {
      this.method1574();
      return this.field1373;
   }

   @ObfuscatedName("x")
   public void method1598() {
      for(int var1 = 0; var1 < this.field1400; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1380 = 0;
   }

   @ObfuscatedName("d")
   public Model method1613(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1574();
      int var7 = var2 - this.field1373;
      int var8 = var2 + this.field1373;
      int var9 = var4 - this.field1373;
      int var10 = var4 + this.field1373;
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
               var11.field1400 = this.field1400;
               var11.field1352 = this.field1352;
               var11.field1348 = this.field1348;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1356 = this.field1356;
               var11.field1357 = this.field1357;
               var11.field1364 = this.field1364;
               var11.field1359 = this.field1359;
               var11.field1360 = this.field1360;
               var11.field1361 = this.field1361;
               var11.field1345 = this.field1345;
               var11.field1404 = this.field1404;
               var11.field1383 = this.field1383;
               var11.field1358 = this.field1358;
               var11.field1372 = this.field1372;
               var11.field1368 = this.field1368;
               var11.field1369 = this.field1369;
               var11.field1370 = this.field1370;
               var11.verticesY = new int[var11.field1400];
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
               for(var12 = 0; var12 < var11.field1400; ++var12) {
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
               for(var12 = 0; var12 < var11.field1400; ++var12) {
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

            var11.field1380 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("ao")
   final boolean method1618(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1377 = new Model();
      field1363 = new byte[1];
      field1346 = new Model();
      field1347 = new byte[1];
      field1375 = new boolean[4700];
      field1378 = new boolean[4700];
      field1379 = new int[4700];
      field1386 = new int[4700];
      field1381 = new int[4700];
      field1382 = new int[4700];
      field1344 = new int[4700];
      field1384 = new int[4700];
      field1371 = new int[1600];
      field1405 = new int[1600][512];
      field1388 = new int[12];
      field1389 = new int[12][2000];
      field1362 = new int[2000];
      field1391 = new int[2000];
      field1366 = new int[12];
      field1393 = new int[10];
      field1394 = new int[10];
      field1395 = new int[10];
      field1399 = false;
      field1354 = 0;
      field1401 = 0;
      field1402 = 0;
      field1403 = new int[1000];
      SINE2 = class84.SINE;
      COSINE2 = class84.COSINE;
      field1406 = class84.colorPalette;
      field1407 = class84.field1439;
   }

   public Model(Model[] var1, int var2) {
      this.field1400 = 0;
      this.field1352 = 0;
      this.field1404 = 0;
      this.field1348 = 0;
      this.field1370 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1400 = 0;
      this.field1352 = 0;
      this.field1348 = 0;
      this.field1404 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1400 += var8.field1400;
            this.field1352 += var8.field1352;
            this.field1348 += var8.field1348;
            if(var8.field1359 != null) {
               var3 = true;
            } else {
               if(this.field1404 == -1) {
                  this.field1404 = var8.field1404;
               }

               if(this.field1404 != var8.field1404) {
                  var3 = true;
               }
            }

            var4 |= var8.field1360 != null;
            var5 |= var8.field1345 != null;
            var6 |= var8.field1361 != null;
         }
      }

      this.verticesX = new int[this.field1400];
      this.verticesY = new int[this.field1400];
      this.verticesZ = new int[this.field1400];
      this.indices1 = new int[this.field1352];
      this.indices2 = new int[this.field1352];
      this.indices3 = new int[this.field1352];
      this.field1356 = new int[this.field1352];
      this.field1357 = new int[this.field1352];
      this.field1364 = new int[this.field1352];
      if(var3) {
         this.field1359 = new byte[this.field1352];
      }

      if(var4) {
         this.field1360 = new byte[this.field1352];
      }

      if(var5) {
         this.field1345 = new short[this.field1352];
      }

      if(var6) {
         this.field1361 = new byte[this.field1352];
      }

      if(this.field1348 > 0) {
         this.field1383 = new int[this.field1348];
         this.field1358 = new int[this.field1348];
         this.field1372 = new int[this.field1348];
      }

      this.field1400 = 0;
      this.field1352 = 0;
      this.field1348 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1352; ++var9) {
               this.indices1[this.field1352] = var8.indices1[var9] + this.field1400;
               this.indices2[this.field1352] = var8.indices2[var9] + this.field1400;
               this.indices3[this.field1352] = var8.indices3[var9] + this.field1400;
               this.field1356[this.field1352] = var8.field1356[var9];
               this.field1357[this.field1352] = var8.field1357[var9];
               this.field1364[this.field1352] = var8.field1364[var9];
               if(var3) {
                  if(var8.field1359 != null) {
                     this.field1359[this.field1352] = var8.field1359[var9];
                  } else {
                     this.field1359[this.field1352] = var8.field1404;
                  }
               }

               if(var4 && var8.field1360 != null) {
                  this.field1360[this.field1352] = var8.field1360[var9];
               }

               if(var5) {
                  if(var8.field1345 != null) {
                     this.field1345[this.field1352] = var8.field1345[var9];
                  } else {
                     this.field1345[this.field1352] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1361 != null && var8.field1361[var9] != -1) {
                     this.field1361[this.field1352] = (byte)(var8.field1361[var9] + this.field1348);
                  } else {
                     this.field1361[this.field1352] = -1;
                  }
               }

               ++this.field1352;
            }

            for(var9 = 0; var9 < var8.field1348; ++var9) {
               this.field1383[this.field1348] = var8.field1383[var9] + this.field1400;
               this.field1358[this.field1348] = var8.field1358[var9] + this.field1400;
               this.field1372[this.field1348] = var8.field1372[var9] + this.field1400;
               ++this.field1348;
            }

            for(var9 = 0; var9 < var8.field1400; ++var9) {
               this.verticesX[this.field1400] = var8.verticesX[var9];
               this.verticesY[this.field1400] = var8.verticesY[var9];
               this.verticesZ[this.field1400] = var8.verticesZ[var9];
               ++this.field1400;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   final void method1629(boolean var1, boolean var2, int var3) {
      if(this.field1374 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1374; ++var4) {
            field1371[var4] = 0;
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
         for(var4 = 0; var4 < this.field1352; ++var4) {
            if(this.field1364[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1379[var5];
               var9 = field1379[var6];
               var10 = field1379[var7];
               int var24;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var24 = field1382[var5];
                  var12 = field1382[var6];
                  var13 = field1382[var7];
                  int var14 = field1344[var5];
                  var15 = field1344[var6];
                  int var16 = field1344[var7];
                  int var17 = field1384[var5];
                  int var18 = field1384[var6];
                  int var19 = field1384[var7];
                  var24 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var24 * var19;
                  int var22 = var24 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1378[var4] = true;
                     int var23 = (field1381[var5] + field1381[var6] + field1381[var7]) / 3 + this.field1351;
                     field1405[var23][field1371[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method1618(field1354, field1401, field1386[var5], field1386[var6], field1386[var7], var8, var9, var10)) {
                     field1403[field1402++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1386[var7] - field1386[var6]) - (field1386[var5] - field1386[var6]) * (var10 - var9) > 0) {
                     field1378[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class84.rasterClipX && var9 <= class84.rasterClipX && var10 <= class84.rasterClipX) {
                        field1375[var4] = false;
                     } else {
                        field1375[var4] = true;
                     }

                     var24 = (field1381[var5] + field1381[var6] + field1381[var7]) / 3 + this.field1351;
                     field1405[var24][field1371[var24]++] = var4;
                  }
               }
            }
         }

         int[] var25;
         if(this.field1359 == null) {
            for(var4 = this.field1374 - 1; var4 >= 0; --var4) {
               var5 = field1371[var4];
               if(var5 > 0) {
                  var25 = field1405[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method1590(var25[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1388[var4] = 0;
               field1366[var4] = 0;
            }

            for(var4 = this.field1374 - 1; var4 >= 0; --var4) {
               var5 = field1371[var4];
               if(var5 > 0) {
                  var25 = field1405[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var25[var7];
                     byte var28 = this.field1359[var8];
                     var10 = field1388[var28]++;
                     field1389[var28][var10] = var8;
                     if(var28 < 10) {
                        field1366[var28] += var4;
                     } else if(var28 == 10) {
                        field1362[var10] = var4;
                     } else {
                        field1391[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1388[1] > 0 || field1388[2] > 0) {
               var4 = (field1366[1] + field1366[2]) / (field1388[1] + field1388[2]);
            }

            var5 = 0;
            if(field1388[3] > 0 || field1388[4] > 0) {
               var5 = (field1366[3] + field1366[4]) / (field1388[3] + field1388[4]);
            }

            var6 = 0;
            if(field1388[6] > 0 || field1388[8] > 0) {
               var6 = (field1366[6] + field1366[8]) / (field1388[6] + field1388[8]);
            }

            var8 = 0;
            var9 = field1388[10];
            int[] var26 = field1389[10];
            int[] var11 = field1362;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1388[11];
               var26 = field1389[11];
               var11 = field1391;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method1590(var26[var8++]);
                  if(var8 == var9 && var26 != field1389[11]) {
                     var8 = 0;
                     var9 = field1388[11];
                     var26 = field1389[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method1590(var26[var8++]);
                  if(var8 == var9 && var26 != field1389[11]) {
                     var8 = 0;
                     var9 = field1388[11];
                     var26 = field1389[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method1590(var26[var8++]);
                  if(var8 == var9 && var26 != field1389[11]) {
                     var8 = 0;
                     var9 = field1388[11];
                     var26 = field1389[11];
                     var11 = field1391;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1388[var12];
               int[] var27 = field1389[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method1590(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method1590(var26[var8++]);
               if(var8 == var9 && var26 != field1389[11]) {
                  var8 = 0;
                  var26 = field1389[11];
                  var9 = field1388[11];
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
}

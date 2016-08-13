import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class73 extends Node {
   @ObfuscatedName("aq")
   byte[] field1358;
   @ObfuscatedName("g")
   int field1359;
   @ObfuscatedName("r")
   int field1360;
   @ObfuscatedName("e")
   int field1361;
   @ObfuscatedName("p")
   static class70[] field1362;
   @ObfuscatedName("z")
   static boolean field1363 = false;
   @ObfuscatedName("k")
   static byte[] field1364;
   @ObfuscatedName("q")
   static class76[] field1365;
   @ObfuscatedName("t")
   static float[] field1366;
   @ObfuscatedName("b")
   static int field1367;
   @ObfuscatedName("m")
   static int field1368;
   @ObfuscatedName("az")
   int field1369;
   @ObfuscatedName("v")
   int field1370;
   @ObfuscatedName("w")
   static class63[] field1371;
   @ObfuscatedName("y")
   static float[] field1372;
   @ObfuscatedName("d")
   static boolean[] field1373;
   @ObfuscatedName("f")
   static int[] field1374;
   @ObfuscatedName("o")
   static class71[] field1375;
   @ObfuscatedName("i")
   float[] field1376;
   @ObfuscatedName("n")
   static int field1377;
   @ObfuscatedName("j")
   int field1378;
   @ObfuscatedName("x")
   boolean field1379;
   @ObfuscatedName("l")
   byte[][] field1380;
   @ObfuscatedName("s")
   boolean field1381;
   @ObfuscatedName("a")
   static float[] field1382;
   @ObfuscatedName("c")
   static float[] field1383;
   @ObfuscatedName("ad")
   static float[] field1384;
   @ObfuscatedName("ac")
   static float[] field1385;
   @ObfuscatedName("h")
   int field1386;
   @ObfuscatedName("ah")
   static int[] field1387;
   @ObfuscatedName("am")
   static int[] field1388;
   @ObfuscatedName("u")
   static int field1389;
   @ObfuscatedName("as")
   static float[] field1390;
   @ObfuscatedName("ak")
   int field1391;

   @ObfuscatedName("l")
   static float method1645(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   static int method1646() {
      int var0 = field1364[field1389] >> field1377 & 1;
      ++field1377;
      field1389 += field1377 >> 3;
      field1377 &= 7;
      return var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1647(byte[] var0, int var1) {
      field1364 = var0;
      field1389 = var1;
      field1377 = 0;
   }

   @ObfuscatedName("h")
   void method1648(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1359 = var2.method2620();
      this.field1360 = var2.method2620();
      this.field1361 = var2.method2620();
      this.field1386 = var2.method2620();
      if(this.field1386 < 0) {
         this.field1386 = ~this.field1386;
         this.field1381 = true;
      }

      int var3 = var2.method2620();
      this.field1380 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2633();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2754(var7, 0, var5);
         this.field1380[var4] = var7;
      }

   }

   @ObfuscatedName("s")
   static void method1649(byte[] var0) {
      method1647(var0, 0);
      field1367 = 1 << method1668(4);
      field1368 = 1 << method1668(4);
      field1366 = new float[field1368];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1368:field1367;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var16 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var16[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var16[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var17 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var17[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var17[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var18 = new int[var5];
         int var10 = class50.method1067(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var12 = var11;
            int var13 = var10;

            int var14;
            for(var14 = 0; var13 > 0; --var13) {
               var14 = var14 << 1 | var12 & 1;
               var12 >>>= 1;
            }

            var18[var11] = var14;
         }

         if(var1 != 0) {
            field1384 = var6;
            field1390 = var16;
            field1385 = var17;
            field1388 = var18;
         } else {
            field1372 = var6;
            field1382 = var16;
            field1383 = var17;
            field1387 = var18;
         }
      }

      var1 = method1668(8) + 1;
      field1365 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1365[var2] = new class76();
      }

      var2 = method1668(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1668(16);
      }

      var2 = method1668(6) + 1;
      field1362 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1362[var3] = new class70();
      }

      var3 = method1668(6) + 1;
      field1371 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1371[var4] = new class63();
      }

      var4 = method1668(6) + 1;
      field1375 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1375[var5] = new class71();
      }

      var5 = method1668(6) + 1;
      field1373 = new boolean[var5];
      field1374 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1373[var15] = method1646() != 0;
         method1668(16);
         method1668(16);
         field1374[var15] = method1668(8);
      }

   }

   @ObfuscatedName("u")
   static boolean method1651(class170 var0) {
      if(!field1363) {
         byte[] var1 = var0.method3411(0, 0);
         if(var1 == null) {
            return false;
         }

         method1649(var1);
         field1363 = true;
      }

      return true;
   }

   @ObfuscatedName("n")
   static class73 method1652(class170 var0, int var1, int var2) {
      if(!method1651(var0)) {
         var0.method3453(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3411(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1648(var1);
   }

   @ObfuscatedName("b")
   class65 method1653(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1358 == null) {
            this.field1370 = 0;
            this.field1376 = new float[field1368];
            this.field1358 = new byte[this.field1360];
            this.field1369 = 0;
            this.field1391 = 0;
         }

         for(; this.field1391 < this.field1380.length; ++this.field1391) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1662(this.field1391);
            if(var2 != null) {
               int var3 = this.field1369;
               int var4 = var2.length;
               if(var4 > this.field1360 - var3) {
                  var4 = this.field1360 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1358[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1369;
               }

               this.field1369 = var3;
            }
         }

         this.field1376 = null;
         byte[] var7 = this.field1358;
         this.field1358 = null;
         return new class65(this.field1359, var7, this.field1361, this.field1386, this.field1381);
      }
   }

   @ObfuscatedName("k")
   float[] method1662(int var1) {
      method1647(this.field1380[var1], 0);
      method1646();
      int var2 = method1668(class50.method1067(field1374.length - 1));
      boolean var3 = field1373[var2];
      int var4 = var3?field1368:field1367;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1646() != 0;
         var6 = method1646() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1367 >> 2);
         var9 = (var4 >> 2) + (field1367 >> 2);
         var10 = field1367 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1367 >> 2);
         var12 = var4 - (var4 >> 2) + (field1367 >> 2);
         var13 = field1367 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1375[field1374[var2]];
      int var15 = var14.field1352;
      int var16 = var14.field1353[var15];
      boolean var17 = !field1362[var16].method1609();
      boolean var18 = var17;

      for(var16 = 0; var16 < var14.field1351; ++var16) {
         class63 var19 = field1371[var14.field1350[var16]];
         float[] var20 = field1366;
         var19.method1398(var20, var4 >> 1, var18);
      }

      int var48;
      if(!var17) {
         var16 = var14.field1352;
         var48 = var14.field1353[var16];
         field1362[var48].method1604(field1366, var4 >> 1);
      }

      float[] var21;
      int var22;
      int var49;
      if(var17) {
         for(var16 = var4 >> 1; var16 < var4; ++var16) {
            field1366[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var49 = var4 >> 3;
         var21 = field1366;

         for(var22 = 0; var22 < var16; ++var22) {
            var21[var22] *= 0.5F;
         }

         for(var22 = var16; var22 < var4; ++var22) {
            var21[var22] = -var21[var4 - var22 - 1];
         }

         float[] var23 = var3?field1384:field1372;
         float[] var24 = var3?field1390:field1382;
         float[] var25 = var3?field1385:field1383;
         int[] var26 = var3?field1388:field1387;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for(var27 = 0; var27 < var48; ++var27) {
            var28 = var21[4 * var27] - var21[var4 - 4 * var27 - 1];
            var29 = var21[4 * var27 + 2] - var21[var4 - 4 * var27 - 3];
            var30 = var23[2 * var27];
            var31 = var23[2 * var27 + 1];
            var21[var4 - 4 * var27 - 1] = var28 * var30 - var29 * var31;
            var21[var4 - 4 * var27 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for(var27 = 0; var27 < var49; ++var27) {
            var28 = var21[var16 + 3 + 4 * var27];
            var29 = var21[var16 + 1 + 4 * var27];
            var30 = var21[4 * var27 + 3];
            var31 = var21[4 * var27 + 1];
            var21[var16 + 3 + 4 * var27] = var28 + var30;
            var21[var16 + 1 + 4 * var27] = var29 + var31;
            var32 = var23[var16 - 4 - 4 * var27];
            var33 = var23[var16 - 3 - 4 * var27];
            var21[4 * var27 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var21[4 * var27 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = class50.method1067(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for(var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for(var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * 2 * var37;
               int var39 = var4 - var35 * (2 * var37 + 1);

               for(int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = 4 * var40;
                  float var42 = var21[var38 - 1 - var41];
                  float var43 = var21[var38 - 3 - var41];
                  float var44 = var21[var39 - 1 - var41];
                  float var45 = var21[var39 - 3 - var41];
                  var21[var38 - 1 - var41] = var42 + var44;
                  var21[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var21[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var21[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for(var34 = 1; var34 < var49 - 1; ++var34) {
            var35 = var26[var34];
            if(var34 < var35) {
               var36 = 8 * var34;
               var37 = 8 * var35;
               var32 = var21[var36 + 1];
               var21[var36 + 1] = var21[var37 + 1];
               var21[var37 + 1] = var32;
               var32 = var21[var36 + 3];
               var21[var36 + 3] = var21[var37 + 3];
               var21[var37 + 3] = var32;
               var32 = var21[var36 + 5];
               var21[var36 + 5] = var21[var37 + 5];
               var21[var37 + 5] = var32;
               var32 = var21[var36 + 7];
               var21[var36 + 7] = var21[var37 + 7];
               var21[var37 + 7] = var32;
            }
         }

         for(var34 = 0; var34 < var16; ++var34) {
            var21[var34] = var21[2 * var34 + 1];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var21[var4 - 1 - 2 * var34] = var21[4 * var34];
            var21[var4 - 2 - 2 * var34] = var21[4 * var34 + 1];
            var21[var4 - var48 - 1 - 2 * var34] = var21[4 * var34 + 2];
            var21[var4 - var48 - 2 - 2 * var34] = var21[4 * var34 + 3];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var29 = var25[2 * var34];
            var30 = var25[2 * var34 + 1];
            var31 = var21[var16 + 2 * var34];
            var32 = var21[var16 + 2 * var34 + 1];
            var33 = var21[var4 - 2 - 2 * var34];
            float var51 = var21[var4 - 1 - 2 * var34];
            float var52 = var30 * (var31 - var33) + var29 * (var32 + var51);
            var21[var16 + 2 * var34] = (var31 + var33 + var52) * 0.5F;
            var21[var4 - 2 - 2 * var34] = (var31 + var33 - var52) * 0.5F;
            var52 = var30 * (var32 + var51) - var29 * (var31 - var33);
            var21[var16 + 2 * var34 + 1] = (var32 - var51 + var52) * 0.5F;
            var21[var4 - 1 - 2 * var34] = (-var32 + var51 + var52) * 0.5F;
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[2 * var34 + var16] * var24[2 * var34] + var21[2 * var34 + 1 + var16] * var24[2 * var34 + 1];
            var21[var16 - 1 - var34] = var21[2 * var34 + var16] * var24[2 * var34 + 1] - var21[2 * var34 + 1 + var16] * var24[2 * var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var4 - var48 + var34] = -var21[var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[var48 + var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var48 + var34] = -var21[var48 - var34 - 1];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var16 + var34] = var21[var4 - var34 - 1];
         }

         for(var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1366[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for(var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1366[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var21 = null;
      if(this.field1370 > 0) {
         var48 = this.field1370 + var4 >> 2;
         var21 = new float[var48];
         if(!this.field1379) {
            for(var49 = 0; var49 < this.field1378; ++var49) {
               var22 = (this.field1370 >> 1) + var49;
               var21[var49] += this.field1376[var22];
            }
         }

         if(!var17) {
            for(var49 = var8; var49 < var4 >> 1; ++var49) {
               var22 = var21.length - (var4 >> 1) + var49;
               var21[var22] += field1366[var49];
            }
         }
      }

      float[] var50 = this.field1376;
      this.field1376 = field1366;
      field1366 = var50;
      this.field1370 = var4;
      this.field1378 = var12 - (var4 >> 1);
      this.field1379 = var17;
      return var21;
   }

   @ObfuscatedName("e")
   static int method1668(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1377; var0 -= var3) {
         var3 = 8 - field1377;
         int var4 = (1 << var3) - 1;
         var1 += (field1364[field1389] >> field1377 & var4) << var2;
         field1377 = 0;
         ++field1389;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1364[field1389] >> field1377 & var3) << var2;
         field1377 += var0;
      }

      return var1;
   }
}

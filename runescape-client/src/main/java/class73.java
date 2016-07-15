import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class73 extends class211 {
   @ObfuscatedName("j")
   static class63[] field1357;
   @ObfuscatedName("l")
   int field1358;
   @ObfuscatedName("c")
   int field1359;
   @ObfuscatedName("f")
   static int[] field1360;
   @ObfuscatedName("k")
   static float[] field1361;
   @ObfuscatedName("ap")
   int field1362;
   @ObfuscatedName("b")
   static byte[] field1363;
   @ObfuscatedName("u")
   static int field1364;
   @ObfuscatedName("o")
   static int field1365;
   @ObfuscatedName("p")
   static int field1366;
   @ObfuscatedName("ao")
   static int[] field1367;
   @ObfuscatedName("q")
   static class76[] field1368;
   @ObfuscatedName("av")
   byte[] field1369;
   @ObfuscatedName("g")
   static class70[] field1370;
   @ObfuscatedName("w")
   static class71[] field1371;
   @ObfuscatedName("x")
   static boolean[] field1372;
   @ObfuscatedName("d")
   static float[] field1373;
   @ObfuscatedName("h")
   int field1374;
   @ObfuscatedName("z")
   float[] field1375;
   @ObfuscatedName("y")
   int field1376;
   @ObfuscatedName("m")
   int field1377;
   @ObfuscatedName("ah")
   static float[] field1378;
   @ObfuscatedName("i")
   static int field1379;
   @ObfuscatedName("n")
   static float[] field1380;
   @ObfuscatedName("r")
   int field1381;
   @ObfuscatedName("s")
   static float[] field1382;
   @ObfuscatedName("a")
   boolean field1383;
   @ObfuscatedName("ak")
   static float[] field1384;
   @ObfuscatedName("as")
   static float[] field1385;
   @ObfuscatedName("ae")
   static int[] field1386;
   @ObfuscatedName("e")
   byte[][] field1387;
   @ObfuscatedName("t")
   static boolean field1388 = false;
   @ObfuscatedName("al")
   int field1389;
   @ObfuscatedName("v")
   boolean field1390;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1622(byte[] var0, int var1) {
      field1363 = var0;
      field1364 = var1;
      field1365 = 0;
   }

   @ObfuscatedName("h")
   static int method1624(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1365; var0 -= var3) {
         var3 = 8 - field1365;
         int var4 = (1 << var3) - 1;
         var1 += (field1363[field1364] >> field1365 & var4) << var2;
         field1365 = 0;
         ++field1364;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1363[field1364] >> field1365 & var3) << var2;
         field1365 += var0;
      }

      return var1;
   }

   @ObfuscatedName("a")
   static void method1626(byte[] var0) {
      method1622(var0, 0);
      field1366 = 1 << method1624(4);
      field1379 = 1 << method1624(4);
      field1361 = new float[field1379];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1379:field1366;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var14 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var14[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var14[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var15 = new float[var4];

         for(int var13 = 0; var13 < var5; ++var13) {
            var15[2 * var13] = (float)Math.cos((double)(4 * var13 + 2) * 3.141592653589793D / (double)var2);
            var15[2 * var13 + 1] = -((float)Math.sin((double)(4 * var13 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class39.method802(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = class51.method1120(var11, var10);
         }

         if(var1 != 0) {
            field1378 = var6;
            field1384 = var14;
            field1385 = var15;
            field1367 = var9;
         } else {
            field1380 = var6;
            field1373 = var14;
            field1382 = var15;
            field1386 = var9;
         }
      }

      var1 = method1624(8) + 1;
      field1368 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1368[var2] = new class76();
      }

      var2 = method1624(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1624(16);
      }

      var2 = method1624(6) + 1;
      field1370 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1370[var3] = new class70();
      }

      var3 = method1624(6) + 1;
      field1357 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1357[var4] = new class63();
      }

      var4 = method1624(6) + 1;
      field1371 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1371[var5] = new class71();
      }

      var5 = method1624(6) + 1;
      field1372 = new boolean[var5];
      field1360 = new int[var5];

      for(int var12 = 0; var12 < var5; ++var12) {
         field1372[var12] = method1628() != 0;
         method1624(16);
         method1624(16);
         field1360[var12] = method1624(8);
      }

   }

   @ObfuscatedName("b")
   float[] method1627(int var1) {
      method1622(this.field1387[var1], 0);
      method1628();
      int var2 = method1624(class39.method802(field1360.length - 1));
      boolean var3 = field1372[var2];
      int var4 = var3?field1379:field1366;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1628() != 0;
         var6 = method1628() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1366 >> 2);
         var9 = (var4 >> 2) + (field1366 >> 2);
         var10 = field1366 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1366 >> 2);
         var12 = var4 - (var4 >> 2) + (field1366 >> 2);
         var13 = field1366 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1371[field1360[var2]];
      int var16 = var14.field1349;
      int var17 = var14.field1351[var16];
      boolean var15 = !field1370[var17].method1592();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1350; ++var17) {
         class63 var40 = field1357[var14.field1352[var17]];
         float[] var19 = field1361;
         var40.method1371(var19, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1349;
         var18 = var14.field1351[var17];
         field1370[var18].method1580(field1361, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1361[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1361;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1378:field1380;
         float[] var22 = var3?field1384:field1373;
         float[] var23 = var3?field1385:field1382;
         int[] var24 = var3?field1367:field1386;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var21[2 * var25];
            var29 = var21[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var21[var17 - 4 - 4 * var25];
            var31 = var21[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class39.method802(var4 - 1);

         int var46;
         int var47;
         int var48;
         int var49;
         for(var46 = 0; var46 < var25 - 3; ++var46) {
            var47 = var4 >> var46 + 2;
            var48 = 8 << var46;

            for(var49 = 0; var49 < 2 << var46; ++var49) {
               int var50 = var4 - var47 * 2 * var49;
               int var51 = var4 - var47 * (2 * var49 + 1);

               for(int var32 = 0; var32 < var4 >> var46 + 4; ++var32) {
                  int var33 = 4 * var32;
                  float var34 = var20[var50 - 1 - var33];
                  float var35 = var20[var50 - 3 - var33];
                  float var36 = var20[var51 - 1 - var33];
                  float var37 = var20[var51 - 3 - var33];
                  var20[var50 - 1 - var33] = var34 + var36;
                  var20[var50 - 3 - var33] = var35 + var37;
                  float var38 = var21[var32 * var48];
                  float var39 = var21[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var41 - 1; ++var46) {
            var47 = var24[var46];
            if(var46 < var47) {
               var48 = 8 * var46;
               var49 = 8 * var47;
               var30 = var20[var48 + 1];
               var20[var48 + 1] = var20[var49 + 1];
               var20[var49 + 1] = var30;
               var30 = var20[var48 + 3];
               var20[var48 + 3] = var20[var49 + 3];
               var20[var49 + 3] = var30;
               var30 = var20[var48 + 5];
               var20[var48 + 5] = var20[var49 + 5];
               var20[var49 + 5] = var30;
               var30 = var20[var48 + 7];
               var20[var48 + 7] = var20[var49 + 7];
               var20[var49 + 7] = var30;
            }
         }

         for(var46 = 0; var46 < var17; ++var46) {
            var20[var46] = var20[2 * var46 + 1];
         }

         for(var46 = 0; var46 < var41; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var41; ++var46) {
            var27 = var23[2 * var46];
            var28 = var23[2 * var46 + 1];
            var29 = var20[var17 + 2 * var46];
            var30 = var20[var17 + 2 * var46 + 1];
            var31 = var20[var4 - 2 - 2 * var46];
            float var52 = var20[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var20[var17 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var20[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var20[var17 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var20[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[2 * var46 + var17] * var22[2 * var46] + var20[2 * var46 + 1 + var17] * var22[2 * var46 + 1];
            var20[var17 - 1 - var46] = var20[2 * var46 + var17] * var22[2 * var46 + 1] - var20[2 * var46 + 1 + var17] * var22[2 * var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var4 - var18 + var46] = -var20[var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[var18 + var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var18 + var46] = -var20[var18 - var46 - 1];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var17 + var46] = var20[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1361[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1361[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1376 > 0) {
         var18 = this.field1376 + var4 >> 2;
         var43 = new float[var18];
         int var44;
         if(!this.field1390) {
            for(var41 = 0; var41 < this.field1377; ++var41) {
               var44 = (this.field1376 >> 1) + var41;
               var43[var41] += this.field1375[var44];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var44 = var43.length - (var4 >> 1) + var41;
               var43[var44] += field1361[var41];
            }
         }
      }

      float[] var54 = this.field1375;
      this.field1375 = field1361;
      field1361 = var54;
      this.field1376 = var4;
      this.field1377 = var12 - (var4 >> 1);
      this.field1390 = var15;
      return var43;
   }

   @ObfuscatedName("c")
   static int method1628() {
      int var0 = field1363[field1364] >> field1365 & 1;
      ++field1365;
      field1364 += field1365 >> 3;
      field1365 &= 7;
      return var0;
   }

   class73(byte[] var1) {
      this.method1636(var1);
   }

   @ObfuscatedName("o")
   static class73 method1630(class170 var0, int var1, int var2) {
      if(!method1642(var0)) {
         var0.method3344(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3340(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   @ObfuscatedName("p")
   class65 method1631(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1369 == null) {
            this.field1376 = 0;
            this.field1375 = new float[field1379];
            this.field1369 = new byte[this.field1359];
            this.field1389 = 0;
            this.field1362 = 0;
         }

         for(; this.field1362 < this.field1387.length; ++this.field1362) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1627(this.field1362);
            if(var2 != null) {
               int var3 = this.field1389;
               int var4 = var2.length;
               if(var4 > this.field1359 - var3) {
                  var4 = this.field1359 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1369[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1389;
               }

               this.field1389 = var3;
            }
         }

         this.field1375 = null;
         byte[] var7 = this.field1369;
         this.field1369 = null;
         return new class65(this.field1358, var7, this.field1374, this.field1381, this.field1383);
      }
   }

   @ObfuscatedName("r")
   void method1636(byte[] var1) {
      class122 var2 = new class122(var1);
      this.field1358 = var2.method2614();
      this.field1359 = var2.method2614();
      this.field1374 = var2.method2614();
      this.field1381 = var2.method2614();
      if(this.field1381 < 0) {
         this.field1381 = ~this.field1381;
         this.field1383 = true;
      }

      int var3 = var2.method2614();
      this.field1387 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2610();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2737(var7, 0, var5);
         this.field1387[var4] = var7;
      }

   }

   @ObfuscatedName("e")
   static float method1641(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("u")
   static boolean method1642(class170 var0) {
      if(!field1388) {
         byte[] var1 = var0.method3340(0, 0);
         if(var1 == null) {
            return false;
         }

         method1626(var1);
         field1388 = true;
      }

      return true;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class73 extends Node {
   @ObfuscatedName("y")
   int field1359;
   @ObfuscatedName("w")
   static boolean[] field1360;
   @ObfuscatedName("v")
   int field1361;
   @ObfuscatedName("r")
   int field1362;
   @ObfuscatedName("a")
   byte[][] field1363;
   @ObfuscatedName("t")
   boolean field1364;
   @ObfuscatedName("n")
   static byte[] field1365;
   @ObfuscatedName("i")
   static int field1366;
   @ObfuscatedName("l")
   static float[] field1367;
   @ObfuscatedName("m")
   static int field1368;
   @ObfuscatedName("k")
   static int field1369;
   @ObfuscatedName("d")
   int field1370;
   @ObfuscatedName("u")
   static class70[] field1371;
   @ObfuscatedName("o")
   float[] field1372;
   @ObfuscatedName("q")
   static class71[] field1373;
   @ObfuscatedName("z")
   int field1374;
   @ObfuscatedName("b")
   static int[] field1375;
   @ObfuscatedName("p")
   static boolean field1376 = false;
   @ObfuscatedName("j")
   static class63[] field1377;
   @ObfuscatedName("x")
   static class76[] field1378;
   @ObfuscatedName("s")
   int field1379;
   @ObfuscatedName("g")
   static int field1380;
   @ObfuscatedName("h")
   static float[] field1381;
   @ObfuscatedName("ar")
   int field1382;
   @ObfuscatedName("c")
   static float[] field1383;
   @ObfuscatedName("f")
   static float[] field1384;
   @ObfuscatedName("ac")
   static float[] field1385;
   @ObfuscatedName("as")
   static float[] field1386;
   @ObfuscatedName("af")
   static float[] field1387;
   @ObfuscatedName("am")
   static int[] field1388;
   @ObfuscatedName("ap")
   static int[] field1389;
   @ObfuscatedName("aa")
   byte[] field1390;
   @ObfuscatedName("e")
   boolean field1391;
   @ObfuscatedName("av")
   int field1392;

   @ObfuscatedName("v")
   static int method1582() {
      int var0 = field1365[field1366] >> field1380 & 1;
      ++field1380;
      field1366 += field1380 >> 3;
      field1380 &= 7;
      return var0;
   }

   @ObfuscatedName("z")
   void method1586(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1370 = var2.method2533();
      this.field1361 = var2.method2533();
      this.field1362 = var2.method2533();
      this.field1374 = var2.method2533();
      if(this.field1374 < 0) {
         this.field1374 = ~this.field1374;
         this.field1364 = true;
      }

      int var3 = var2.method2533();
      this.field1363 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.method2528();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2726(var6, 0, var5);
         this.field1363[var4] = var6;
      }

   }

   @ObfuscatedName("t")
   static void method1587(byte[] var0) {
      method1595(var0, 0);
      field1368 = 1 << method1599(4);
      field1369 = 1 << method1599(4);
      field1381 = new float[field1369];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1369:field1368;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var12 = 0; var12 < var4; ++var12) {
            var6[2 * var12] = (float)Math.cos((double)(4 * var12) * 3.141592653589793D / (double)var2);
            var6[2 * var12 + 1] = -((float)Math.sin((double)(4 * var12) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var13 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var13[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var13[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = class92.method2113(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = class9.method130(var11, var10);
         }

         if(var1 != 0) {
            field1385 = var6;
            field1386 = var7;
            field1387 = var13;
            field1389 = var14;
         } else {
            field1367 = var6;
            field1383 = var7;
            field1384 = var13;
            field1388 = var14;
         }
      }

      var1 = method1599(8) + 1;
      field1378 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1378[var2] = new class76();
      }

      var2 = method1599(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1599(16);
      }

      var2 = method1599(6) + 1;
      field1371 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1371[var3] = new class70();
      }

      var3 = method1599(6) + 1;
      field1377 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1377[var4] = new class63();
      }

      var4 = method1599(6) + 1;
      field1373 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1373[var5] = new class71();
      }

      var5 = method1599(6) + 1;
      field1360 = new boolean[var5];
      field1375 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1360[var15] = method1582() != 0;
         method1599(16);
         method1599(16);
         field1375[var15] = method1599(8);
      }

   }

   @ObfuscatedName("n")
   float[] method1588(int var1) {
      method1595(this.field1363[var1], 0);
      method1582();
      int var2 = method1599(class92.method2113(field1375.length - 1));
      boolean var3 = field1360[var2];
      int var4 = var3?field1369:field1368;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1582() != 0;
         var6 = method1582() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1368 >> 2);
         var9 = (var4 >> 2) + (field1368 >> 2);
         var10 = field1368 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1368 >> 2);
         var12 = var4 - (var4 >> 2) + (field1368 >> 2);
         var13 = field1368 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1373[field1375[var2]];
      int var16 = var14.field1352;
      int var40 = var14.field1353[var16];
      boolean var15 = !field1371[var40].method1543();
      boolean var45 = var15;

      for(var40 = 0; var40 < var14.field1351; ++var40) {
         class63 var18 = field1377[var14.field1354[var40]];
         float[] var19 = field1381;
         var18.method1323(var19, var4 >> 1, var45);
      }

      int var42;
      if(!var15) {
         var40 = var14.field1352;
         var42 = var14.field1353[var40];
         field1371[var42].method1544(field1381, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var40 = var4 >> 1; var40 < var4; ++var40) {
            field1381[var40] = 0.0F;
         }
      } else {
         var40 = var4 >> 1;
         var42 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1381;

         int var43;
         for(var43 = 0; var43 < var40; ++var43) {
            var20[var43] *= 0.5F;
         }

         for(var43 = var40; var43 < var4; ++var43) {
            var20[var43] = -var20[var4 - var43 - 1];
         }

         float[] var21 = var3?field1385:field1367;
         float[] var22 = var3?field1386:field1383;
         float[] var23 = var3?field1387:field1384;
         int[] var24 = var3?field1389:field1388;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var42; ++var25) {
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
            var26 = var20[var40 + 3 + 4 * var25];
            var27 = var20[var40 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var40 + 3 + 4 * var25] = var26 + var28;
            var20[var40 + 1 + 4 * var25] = var27 + var29;
            var30 = var21[var40 - 4 - 4 * var25];
            var31 = var21[var40 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class92.method2113(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * 2 * var50;
               int var52 = var4 - var48 * (2 * var50 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = 4 * var32;
                  float var34 = var20[var51 - 1 - var33];
                  float var35 = var20[var51 - 3 - var33];
                  float var36 = var20[var52 - 1 - var33];
                  float var37 = var20[var52 - 3 - var33];
                  var20[var51 - 1 - var33] = var34 + var36;
                  var20[var51 - 3 - var33] = var35 + var37;
                  float var38 = var21[var32 * var49];
                  float var39 = var21[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var41 - 1; ++var47) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = 8 * var47;
               var50 = 8 * var48;
               var30 = var20[var49 + 1];
               var20[var49 + 1] = var20[var50 + 1];
               var20[var50 + 1] = var30;
               var30 = var20[var49 + 3];
               var20[var49 + 3] = var20[var50 + 3];
               var20[var50 + 3] = var30;
               var30 = var20[var49 + 5];
               var20[var49 + 5] = var20[var50 + 5];
               var20[var50 + 5] = var30;
               var30 = var20[var49 + 7];
               var20[var49 + 7] = var20[var50 + 7];
               var20[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var42 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var42 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var27 = var23[2 * var47];
            var28 = var23[2 * var47 + 1];
            var29 = var20[var40 + 2 * var47];
            var30 = var20[var40 + 2 * var47 + 1];
            var31 = var20[var4 - 2 - 2 * var47];
            float var53 = var20[var4 - 1 - 2 * var47];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var20[var40 + 2 * var47] = (var29 + var31 + var54) * 0.5F;
            var20[var4 - 2 - 2 * var47] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var20[var40 + 2 * var47 + 1] = (var30 - var53 + var54) * 0.5F;
            var20[var4 - 1 - 2 * var47] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var47] = var20[2 * var47 + var40] * var22[2 * var47] + var20[2 * var47 + 1 + var40] * var22[2 * var47 + 1];
            var20[var40 - 1 - var47] = var20[2 * var47 + var40] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var40] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var4 - var42 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var47] = var20[var42 + var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var42 + var47] = -var20[var42 - var47 - 1];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var40 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1381[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1381[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1359 > 0) {
         var42 = this.field1359 + var4 >> 2;
         var17 = new float[var42];
         int var44;
         if(!this.field1391) {
            for(var41 = 0; var41 < this.field1379; ++var41) {
               var44 = (this.field1359 >> 1) + var41;
               var17[var41] += this.field1372[var44];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var44 = var17.length - (var4 >> 1) + var41;
               var17[var44] += field1381[var41];
            }
         }
      }

      float[] var46 = this.field1372;
      this.field1372 = field1381;
      field1381 = var46;
      this.field1359 = var4;
      this.field1379 = var12 - (var4 >> 1);
      this.field1391 = var15;
      return var17;
   }

   @ObfuscatedName("g")
   static class73 method1590(class170 var0, int var1, int var2) {
      if(!method1593(var0)) {
         var0.method3351(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3309(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1586(var1);
   }

   @ObfuscatedName("m")
   class65 method1591(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1390 == null) {
            this.field1359 = 0;
            this.field1372 = new float[field1369];
            this.field1390 = new byte[this.field1361];
            this.field1382 = 0;
            this.field1392 = 0;
         }

         for(; this.field1392 < this.field1363.length; ++this.field1392) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1588(this.field1392);
            if(var2 != null) {
               int var3 = this.field1382;
               int var4 = var2.length;
               if(var4 > this.field1361 - var3) {
                  var4 = this.field1361 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1390[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1382;
               }

               this.field1382 = var3;
            }
         }

         this.field1372 = null;
         byte[] var7 = this.field1390;
         this.field1390 = null;
         return new class65(this.field1370, var7, this.field1362, this.field1374, this.field1364);
      }
   }

   @ObfuscatedName("i")
   static boolean method1593(class170 var0) {
      if(!field1376) {
         byte[] var1 = var0.method3309(0, 0);
         if(var1 == null) {
            return false;
         }

         method1587(var1);
         field1376 = true;
      }

      return true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1595(byte[] var0, int var1) {
      field1365 = var0;
      field1366 = var1;
      field1380 = 0;
   }

   @ObfuscatedName("a")
   static float method1596(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   static int method1599(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1380; var0 -= var3) {
         var3 = 8 - field1380;
         int var4 = (1 << var3) - 1;
         var1 += (field1365[field1366] >> field1380 & var4) << var2;
         field1380 = 0;
         ++field1366;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1365[field1366] >> field1380 & var3) << var2;
         field1380 += var0;
      }

      return var1;
   }
}

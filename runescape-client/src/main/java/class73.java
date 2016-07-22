import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class73 extends class211 {
   @ObfuscatedName("l")
   boolean field1361;
   @ObfuscatedName("w")
   int field1362;
   @ObfuscatedName("e")
   int field1363;
   @ObfuscatedName("v")
   static int field1364;
   @ObfuscatedName("g")
   int field1365;
   @ObfuscatedName("o")
   int field1366;
   @ObfuscatedName("j")
   static byte[] field1367;
   @ObfuscatedName("r")
   static int field1368;
   @ObfuscatedName("y")
   static class63[] field1369;
   @ObfuscatedName("t")
   int field1370;
   @ObfuscatedName("x")
   static int field1371;
   @ObfuscatedName("h")
   static class76[] field1372;
   @ObfuscatedName("u")
   static class70[] field1373;
   @ObfuscatedName("z")
   boolean field1374;
   @ObfuscatedName("p")
   static class71[] field1375;
   @ObfuscatedName("s")
   static boolean[] field1376;
   @ObfuscatedName("f")
   static int[] field1377;
   @ObfuscatedName("k")
   static int field1378;
   @ObfuscatedName("d")
   float[] field1379;
   @ObfuscatedName("q")
   static float[] field1380;
   @ObfuscatedName("c")
   int field1381;
   @ObfuscatedName("ax")
   int field1382;
   @ObfuscatedName("n")
   static float[] field1383;
   @ObfuscatedName("i")
   static boolean field1384 = false;
   @ObfuscatedName("aj")
   static float[] field1385;
   @ObfuscatedName("b")
   static float[] field1386;
   @ObfuscatedName("a")
   static float[] field1387;
   @ObfuscatedName("an")
   static float[] field1388;
   @ObfuscatedName("ap")
   static float[] field1389;
   @ObfuscatedName("ar")
   static int[] field1390;
   @ObfuscatedName("ab")
   static int[] field1391;
   @ObfuscatedName("m")
   byte[][] field1392;
   @ObfuscatedName("aa")
   int field1393;
   @ObfuscatedName("ai")
   byte[] field1394;

   @ObfuscatedName("e")
   static int method1616() {
      int var0 = field1367[field1368] >> field1371 & 1;
      ++field1371;
      field1368 += field1371 >> 3;
      field1371 &= 7;
      return var0;
   }

   @ObfuscatedName("r")
   static boolean method1617(class170 var0) {
      if(!field1384) {
         byte[] var1 = var0.method3304(0, 0);
         if(var1 == null) {
            return false;
         }

         method1620(var1);
         field1384 = true;
      }

      return true;
   }

   @ObfuscatedName("o")
   static int method1618(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1371; var0 -= var3) {
         var3 = 8 - field1371;
         int var4 = (1 << var3) - 1;
         var1 += (field1367[field1368] >> field1371 & var4) << var2;
         field1371 = 0;
         ++field1368;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1367[field1368] >> field1371 & var3) << var2;
         field1371 += var0;
      }

      return var1;
   }

   @ObfuscatedName("g")
   void method1619(byte[] var1) {
      class122 var2 = new class122(var1);
      this.field1362 = var2.method2577();
      this.field1363 = var2.method2577();
      this.field1366 = var2.method2577();
      this.field1365 = var2.method2577();
      if(this.field1365 < 0) {
         this.field1365 = ~this.field1365;
         this.field1361 = true;
      }

      int var3 = var2.method2577();
      this.field1392 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2556();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2583(var7, 0, var5);
         this.field1392[var4] = var7;
      }

   }

   @ObfuscatedName("l")
   static void method1620(byte[] var0) {
      method1642(var0, 0);
      field1378 = 1 << method1618(4);
      field1364 = 1 << method1618(4);
      field1383 = new float[field1364];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1364:field1378;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var13 = new float[var3];

         for(int var12 = 0; var12 < var4; ++var12) {
            var13[2 * var12] = (float)Math.cos((double)(4 * var12) * 3.141592653589793D / (double)var2);
            var13[2 * var12 + 1] = -((float)Math.sin((double)(4 * var12) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var14 = new float[var4];

         for(int var15 = 0; var15 < var5; ++var15) {
            var14[2 * var15] = (float)Math.cos((double)(4 * var15 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var15 + 1] = -((float)Math.sin((double)(4 * var15 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class113.method2487(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = class126.method2827(var11, var10);
         }

         if(var1 != 0) {
            field1385 = var13;
            field1388 = var7;
            field1389 = var14;
            field1391 = var9;
         } else {
            field1380 = var13;
            field1387 = var7;
            field1386 = var14;
            field1390 = var9;
         }
      }

      var1 = method1618(8) + 1;
      field1372 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1372[var2] = new class76();
      }

      var2 = method1618(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1618(16);
      }

      var2 = method1618(6) + 1;
      field1373 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1373[var3] = new class70();
      }

      var3 = method1618(6) + 1;
      field1369 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1369[var4] = new class63();
      }

      var4 = method1618(6) + 1;
      field1375 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1375[var5] = new class71();
      }

      var5 = method1618(6) + 1;
      field1376 = new boolean[var5];
      field1377 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field1376[var6] = method1616() != 0;
         method1618(16);
         method1618(16);
         field1377[var6] = method1618(8);
      }

   }

   @ObfuscatedName("j")
   float[] method1622(int var1) {
      method1642(this.field1392[var1], 0);
      method1616();
      int var2 = method1618(class113.method2487(field1377.length - 1));
      boolean var3 = field1376[var2];
      int var4 = var3?field1364:field1378;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1616() != 0;
         var6 = method1616() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1378 >> 2);
         var9 = (var4 >> 2) + (field1378 >> 2);
         var10 = field1378 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1378 >> 2);
         var12 = var4 - (var4 >> 2) + (field1378 >> 2);
         var13 = field1378 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1375[field1377[var2]];
      int var16 = var14.field1354;
      int var17 = var14.field1355[var16];
      boolean var15 = !field1373[var17].method1590();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1353; ++var17) {
         class63 var18 = field1369[var14.field1356[var17]];
         float[] var42 = field1383;
         var18.method1353(var42, var4 >> 1, var45);
      }

      int var43;
      if(!var15) {
         var17 = var14.field1354;
         var43 = var14.field1355[var17];
         field1373[var43].method1577(field1383, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1383[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var43 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1383;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1385:field1380;
         float[] var22 = var3?field1388:field1387;
         float[] var23 = var3?field1389:field1386;
         int[] var24 = var3?field1391:field1390;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var43; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var44[2 * var25];
            var29 = var44[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var44[var17 - 4 - 4 * var25];
            var31 = var44[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class113.method2487(var4 - 1);

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
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var19 - 1; ++var47) {
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

         for(var47 = 0; var47 < var17; ++var47) {
            var20[var47] = var20[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var19; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var43 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var43 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var19; ++var47) {
            var27 = var23[2 * var47];
            var28 = var23[2 * var47 + 1];
            var29 = var20[var17 + 2 * var47];
            var30 = var20[var17 + 2 * var47 + 1];
            var31 = var20[var4 - 2 - 2 * var47];
            float var53 = var20[var4 - 1 - 2 * var47];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var20[var17 + 2 * var47] = (var29 + var31 + var54) * 0.5F;
            var20[var4 - 2 - 2 * var47] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var20[var17 + 2 * var47 + 1] = (var30 - var53 + var54) * 0.5F;
            var20[var4 - 1 - 2 * var47] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var4 - var43 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var47] = var20[var43 + var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var43 + var47] = -var20[var43 - var47 - 1];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1383[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1383[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var40 = null;
      if(this.field1370 > 0) {
         var43 = this.field1370 + var4 >> 2;
         var40 = new float[var43];
         int var41;
         if(!this.field1374) {
            for(var19 = 0; var19 < this.field1381; ++var19) {
               var41 = (this.field1370 >> 1) + var19;
               var40[var19] += this.field1379[var41];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var41 = var40.length - (var4 >> 1) + var19;
               var40[var41] += field1383[var19];
            }
         }
      }

      float[] var46 = this.field1379;
      this.field1379 = field1383;
      field1383 = var46;
      this.field1370 = var4;
      this.field1381 = var12 - (var4 >> 1);
      this.field1374 = var15;
      return var40;
   }

   class73(byte[] var1) {
      this.method1619(var1);
   }

   @ObfuscatedName("m")
   static float method1629(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("x")
   static class73 method1631(class170 var0, int var1, int var2) {
      if(!method1617(var0)) {
         var0.method3359(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3304(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   @ObfuscatedName("k")
   class65 method1632(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1394 == null) {
            this.field1370 = 0;
            this.field1379 = new float[field1364];
            this.field1394 = new byte[this.field1363];
            this.field1393 = 0;
            this.field1382 = 0;
         }

         for(; this.field1382 < this.field1392.length; ++this.field1382) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1622(this.field1382);
            if(var2 != null) {
               int var3 = this.field1393;
               int var4 = var2.length;
               if(var4 > this.field1363 - var3) {
                  var4 = this.field1363 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1394[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1393;
               }

               this.field1393 = var3;
            }
         }

         this.field1379 = null;
         byte[] var7 = this.field1394;
         this.field1394 = null;
         return new class65(this.field1362, var7, this.field1366, this.field1365, this.field1361);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1642(byte[] var0, int var1) {
      field1367 = var0;
      field1368 = var1;
      field1371 = 0;
   }
}

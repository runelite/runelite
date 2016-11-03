import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class73 extends Node {
   @ObfuscatedName("am")
   int field1346;
   @ObfuscatedName("q")
   int field1347;
   @ObfuscatedName("k")
   byte[][] field1348;
   @ObfuscatedName("f")
   int field1349;
   @ObfuscatedName("y")
   static int field1350;
   @ObfuscatedName("j")
   boolean field1351;
   @ObfuscatedName("ad")
   static int[] field1352;
   @ObfuscatedName("at")
   static int[] field1353;
   @ObfuscatedName("u")
   static int field1354;
   @ObfuscatedName("h")
   static int field1355;
   @ObfuscatedName("l")
   static int field1356;
   @ObfuscatedName("b")
   static class76[] field1357;
   @ObfuscatedName("g")
   static class70[] field1358;
   @ObfuscatedName("e")
   static class63[] field1359;
   @ObfuscatedName("p")
   static class71[] field1360;
   @ObfuscatedName("s")
   static boolean[] field1361;
   @ObfuscatedName("w")
   static int[] field1362;
   @ObfuscatedName("i")
   static boolean field1363 = false;
   @ObfuscatedName("r")
   float[] field1364;
   @ObfuscatedName("a")
   int field1365;
   @ObfuscatedName("n")
   int field1366;
   @ObfuscatedName("c")
   int field1367;
   @ObfuscatedName("x")
   static float[] field1368;
   @ObfuscatedName("d")
   static float[] field1369;
   @ObfuscatedName("t")
   static float[] field1370;
   @ObfuscatedName("aq")
   static float[] field1371;
   @ObfuscatedName("al")
   static float[] field1372;
   @ObfuscatedName("aj")
   byte[] field1373;
   @ObfuscatedName("o")
   static float[] field1374;
   @ObfuscatedName("v")
   int field1375;
   @ObfuscatedName("z")
   boolean field1376;
   @ObfuscatedName("m")
   static byte[] field1377;
   @ObfuscatedName("av")
   static float[] field1378;
   @ObfuscatedName("ay")
   int field1379;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1586(byte[] var0, int var1) {
      field1377 = var0;
      field1350 = var1;
      field1354 = 0;
   }

   @ObfuscatedName("c")
   static int method1588(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1354; var0 -= var3) {
         var3 = 8 - field1354;
         int var4 = (1 << var3) - 1;
         var1 += (field1377[field1350] >> field1354 & var4) << var2;
         field1354 = 0;
         ++field1350;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1377[field1350] >> field1354 & var3) << var2;
         field1354 += var0;
      }

      return var1;
   }

   @ObfuscatedName("v")
   void method1589(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1347 = var2.method2576();
      this.field1349 = var2.method2576();
      this.field1367 = var2.method2576();
      this.field1375 = var2.method2576();
      if(this.field1375 < 0) {
         this.field1375 = ~this.field1375;
         this.field1351 = true;
      }

      int var3 = var2.method2576();
      this.field1348 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2571();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2582(var7, 0, var5);
         this.field1348[var4] = var7;
      }

   }

   @ObfuscatedName("m")
   float[] method1591(int var1) {
      method1586(this.field1348[var1], 0);
      method1606();
      int var2 = method1588(Client.method475(field1362.length - 1));
      boolean var3 = field1361[var2];
      int var4 = var3?field1356:field1355;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1606() != 0;
         var6 = method1606() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1355 >> 2);
         var9 = (var4 >> 2) + (field1355 >> 2);
         var10 = field1355 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1355 >> 2);
         var12 = var4 - (var4 >> 2) + (field1355 >> 2);
         var13 = field1355 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1360[field1362[var2]];
      int var16 = var14.field1340;
      int var41 = var14.field1339[var16];
      boolean var15 = !field1358[var41].method1541();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1338; ++var41) {
         class63 var42 = field1359[var14.field1341[var41]];
         float[] var43 = field1368;
         var42.method1310(var43, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var41 = var14.field1340;
         var18 = var14.field1339[var41];
         field1358[var18].method1554(field1368, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field1368[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field1368;

         int var21;
         for(var21 = 0; var21 < var41; ++var21) {
            var40[var21] *= 0.5F;
         }

         for(var21 = var41; var21 < var4; ++var21) {
            var40[var21] = -var40[var4 - var21 - 1];
         }

         float[] var44 = var3?field1371:field1369;
         float[] var22 = var3?field1372:field1370;
         float[] var23 = var3?field1378:field1374;
         int[] var24 = var3?field1353:field1352;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var40[4 * var25] - var40[var4 - 4 * var25 - 1];
            var27 = var40[4 * var25 + 2] - var40[var4 - 4 * var25 - 3];
            var28 = var44[2 * var25];
            var29 = var44[2 * var25 + 1];
            var40[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var40[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var40[var41 + 3 + 4 * var25];
            var27 = var40[var41 + 1 + 4 * var25];
            var28 = var40[4 * var25 + 3];
            var29 = var40[4 * var25 + 1];
            var40[var41 + 3 + 4 * var25] = var26 + var28;
            var40[var41 + 1 + 4 * var25] = var27 + var29;
            var30 = var44[var41 - 4 - 4 * var25];
            var31 = var44[var41 - 3 - 4 * var25];
            var40[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = Client.method475(var4 - 1);

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
                  float var34 = var40[var50 - 1 - var33];
                  float var35 = var40[var50 - 3 - var33];
                  float var36 = var40[var51 - 1 - var33];
                  float var37 = var40[var51 - 3 - var33];
                  var40[var50 - 1 - var33] = var34 + var36;
                  var40[var50 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var48];
                  float var39 = var44[var32 * var48 + 1];
                  var40[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var40[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var19 - 1; ++var46) {
            var47 = var24[var46];
            if(var46 < var47) {
               var48 = 8 * var46;
               var49 = 8 * var47;
               var30 = var40[var48 + 1];
               var40[var48 + 1] = var40[var49 + 1];
               var40[var49 + 1] = var30;
               var30 = var40[var48 + 3];
               var40[var48 + 3] = var40[var49 + 3];
               var40[var49 + 3] = var30;
               var30 = var40[var48 + 5];
               var40[var48 + 5] = var40[var49 + 5];
               var40[var49 + 5] = var30;
               var30 = var40[var48 + 7];
               var40[var48 + 7] = var40[var49 + 7];
               var40[var49 + 7] = var30;
            }
         }

         for(var46 = 0; var46 < var41; ++var46) {
            var40[var46] = var40[2 * var46 + 1];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var40[var4 - 1 - 2 * var46] = var40[4 * var46];
            var40[var4 - 2 - 2 * var46] = var40[4 * var46 + 1];
            var40[var4 - var18 - 1 - 2 * var46] = var40[4 * var46 + 2];
            var40[var4 - var18 - 2 - 2 * var46] = var40[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var27 = var23[2 * var46];
            var28 = var23[2 * var46 + 1];
            var29 = var40[var41 + 2 * var46];
            var30 = var40[var41 + 2 * var46 + 1];
            var31 = var40[var4 - 2 - 2 * var46];
            float var52 = var40[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var40[var41 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var40[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var40[var41 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var40[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[2 * var46 + var41] * var22[2 * var46] + var40[2 * var46 + 1 + var41] * var22[2 * var46 + 1];
            var40[var41 - 1 - var46] = var40[2 * var46 + var41] * var22[2 * var46 + 1] - var40[2 * var46 + 1 + var41] * var22[2 * var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var4 - var18 + var46] = -var40[var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[var18 + var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var18 + var46] = -var40[var18 - var46 - 1];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var41 + var46] = var40[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1368[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1368[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1365 > 0) {
         var18 = this.field1365 + var4 >> 2;
         var17 = new float[var18];
         int var20;
         if(!this.field1376) {
            for(var19 = 0; var19 < this.field1366; ++var19) {
               var20 = (this.field1365 >> 1) + var19;
               var17[var19] += this.field1364[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var17.length - (var4 >> 1) + var19;
               var17[var20] += field1368[var19];
            }
         }
      }

      float[] var54 = this.field1364;
      this.field1364 = field1368;
      field1368 = var54;
      this.field1365 = var4;
      this.field1366 = var12 - (var4 >> 1);
      this.field1376 = var15;
      return var17;
   }

   @ObfuscatedName("k")
   static float method1592(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("u")
   static class73 method1593(class170 var0, int var1, int var2) {
      if(!method1598(var0)) {
         var0.method3282(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3305(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1589(var1);
   }

   @ObfuscatedName("h")
   class65 method1594(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1373 == null) {
            this.field1365 = 0;
            this.field1364 = new float[field1356];
            this.field1373 = new byte[this.field1349];
            this.field1346 = 0;
            this.field1379 = 0;
         }

         for(; this.field1379 < this.field1348.length; ++this.field1379) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1591(this.field1379);
            if(var2 != null) {
               int var3 = this.field1346;
               int var4 = var2.length;
               if(var4 > this.field1349 - var3) {
                  var4 = this.field1349 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1373[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1346;
               }

               this.field1346 = var3;
            }
         }

         this.field1364 = null;
         byte[] var7 = this.field1373;
         this.field1373 = null;
         return new class65(this.field1347, var7, this.field1367, this.field1375, this.field1351);
      }
   }

   @ObfuscatedName("y")
   static boolean method1598(class170 var0) {
      if(!field1363) {
         byte[] var1 = var0.method3305(0, 0);
         if(var1 == null) {
            return false;
         }

         method1608(var1);
         field1363 = true;
      }

      return true;
   }

   @ObfuscatedName("f")
   static int method1606() {
      int var0 = field1377[field1350] >> field1354 & 1;
      ++field1354;
      field1350 += field1354 >> 3;
      field1354 &= 7;
      return var0;
   }

   @ObfuscatedName("j")
   static void method1608(byte[] var0) {
      method1586(var0, 0);
      field1355 = 1 << method1588(4);
      field1356 = 1 << method1588(4);
      field1368 = new float[field1356];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1356:field1355;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var12 = new float[var3];

         for(int var14 = 0; var14 < var4; ++var14) {
            var12[2 * var14] = (float)Math.cos((double)(2 * var14 + 1) * 3.141592653589793D / (double)(2 * var2));
            var12[2 * var14 + 1] = (float)Math.sin((double)(2 * var14 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var8 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var8[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var13 = new int[var5];
         int var10 = Client.method475(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var13[var11] = class193.method3777(var11, var10);
         }

         if(var1 != 0) {
            field1371 = var6;
            field1372 = var12;
            field1378 = var8;
            field1353 = var13;
         } else {
            field1369 = var6;
            field1370 = var12;
            field1374 = var8;
            field1352 = var13;
         }
      }

      var1 = method1588(8) + 1;
      field1357 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1357[var2] = new class76();
      }

      var2 = method1588(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1588(16);
      }

      var2 = method1588(6) + 1;
      field1358 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1358[var3] = new class70();
      }

      var3 = method1588(6) + 1;
      field1359 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1359[var4] = new class63();
      }

      var4 = method1588(6) + 1;
      field1360 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1360[var5] = new class71();
      }

      var5 = method1588(6) + 1;
      field1361 = new boolean[var5];
      field1362 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1361[var15] = method1606() != 0;
         method1588(16);
         method1588(16);
         field1362[var15] = method1588(8);
      }

   }
}

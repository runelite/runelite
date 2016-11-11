import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class73 extends Node {
   @ObfuscatedName("v")
   static class63[] field1341;
   @ObfuscatedName("h")
   int field1342;
   @ObfuscatedName("x")
   static boolean field1343 = false;
   @ObfuscatedName("g")
   int field1344;
   @ObfuscatedName("k")
   float[] field1345;
   @ObfuscatedName("as")
   static float[] field1346;
   @ObfuscatedName("d")
   static byte[] field1347;
   @ObfuscatedName("j")
   static int field1348;
   @ObfuscatedName("l")
   static int field1349;
   @ObfuscatedName("ak")
   static int[] field1350;
   @ObfuscatedName("y")
   static int field1351;
   @ObfuscatedName("s")
   static class76[] field1352;
   @ObfuscatedName("p")
   static class70[] field1353;
   @ObfuscatedName("e")
   int field1354;
   @ObfuscatedName("ag")
   int field1355;
   @ObfuscatedName("c")
   static boolean[] field1356;
   @ObfuscatedName("w")
   static int[] field1357;
   @ObfuscatedName("am")
   static float[] field1358;
   @ObfuscatedName("f")
   static float[] field1359;
   @ObfuscatedName("z")
   int field1360;
   @ObfuscatedName("q")
   int field1361;
   @ObfuscatedName("o")
   boolean field1362;
   @ObfuscatedName("m")
   static int field1363;
   @ObfuscatedName("b")
   static float[] field1364;
   @ObfuscatedName("t")
   static float[] field1365;
   @ObfuscatedName("a")
   static float[] field1366;
   @ObfuscatedName("u")
   boolean field1367;
   @ObfuscatedName("i")
   byte[][] field1368;
   @ObfuscatedName("ad")
   static float[] field1369;
   @ObfuscatedName("af")
   static int[] field1370;
   @ObfuscatedName("r")
   static class71[] field1371;
   @ObfuscatedName("aq")
   byte[] field1372;
   @ObfuscatedName("an")
   int field1373;
   @ObfuscatedName("n")
   int field1374;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1565(byte[] var0, int var1) {
      field1347 = var0;
      field1349 = var1;
      field1363 = 0;
   }

   @ObfuscatedName("e")
   static int method1566() {
      int var0 = field1347[field1349] >> field1363 & 1;
      ++field1363;
      field1349 += field1363 >> 3;
      field1363 &= 7;
      return var0;
   }

   @ObfuscatedName("g")
   static int method1567(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1363; var0 -= var3) {
         var3 = 8 - field1363;
         int var4 = (1 << var3) - 1;
         var1 += (field1347[field1349] >> field1363 & var4) << var2;
         field1363 = 0;
         ++field1349;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1347[field1349] >> field1363 & var3) << var2;
         field1363 += var0;
      }

      return var1;
   }

   @ObfuscatedName("u")
   static void method1569(byte[] var0) {
      method1565(var0, 0);
      field1348 = 1 << method1567(4);
      field1351 = 1 << method1567(4);
      field1359 = new float[field1351];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1351:field1348;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var19 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var19[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var19[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var18 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var18[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var18[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = Player.method45(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var21[var11] = var17;
         }

         if(var1 != 0) {
            field1358 = var6;
            field1346 = var19;
            field1369 = var18;
            field1350 = var21;
         } else {
            field1364 = var6;
            field1365 = var19;
            field1366 = var18;
            field1370 = var21;
         }
      }

      var1 = method1567(8) + 1;
      field1352 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1352[var2] = new class76();
      }

      var2 = method1567(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1567(16);
      }

      var2 = method1567(6) + 1;
      field1353 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1353[var3] = new class70();
      }

      var3 = method1567(6) + 1;
      field1341 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1341[var4] = new class63();
      }

      var4 = method1567(6) + 1;
      field1371 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1371[var5] = new class71();
      }

      var5 = method1567(6) + 1;
      field1356 = new boolean[var5];
      field1357 = new int[var5];

      for(int var20 = 0; var20 < var5; ++var20) {
         field1356[var20] = method1566() != 0;
         method1567(16);
         method1567(16);
         field1357[var20] = method1567(8);
      }

   }

   @ObfuscatedName("d")
   float[] method1570(int var1) {
      method1565(this.field1368[var1], 0);
      method1566();
      int var2 = method1567(Player.method45(field1357.length - 1));
      boolean var3 = field1356[var2];
      int var4 = var3?field1351:field1348;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1566() != 0;
         var6 = method1566() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1348 >> 2);
         var9 = (var4 >> 2) + (field1348 >> 2);
         var10 = field1348 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1348 >> 2);
         var12 = var4 - (var4 >> 2) + (field1348 >> 2);
         var13 = field1348 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1371[field1357[var2]];
      int var16 = var14.field1333;
      int var17 = var14.field1335[var16];
      boolean var15 = !field1353[var17].method1528();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1334; ++var17) {
         class63 var18 = field1341[var14.field1336[var17]];
         float[] var41 = field1359;
         var18.method1315(var41, var4 >> 1, var45);
      }

      int var42;
      if(!var15) {
         var17 = var14.field1333;
         var42 = var14.field1335[var17];
         field1353[var42].method1536(field1359, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1359[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var42 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1359;

         int var40;
         for(var40 = 0; var40 < var17; ++var40) {
            var20[var40] *= 0.5F;
         }

         for(var40 = var17; var40 < var4; ++var40) {
            var20[var40] = -var20[var4 - var40 - 1];
         }

         float[] var21 = var3?field1358:field1364;
         float[] var22 = var3?field1346:field1365;
         float[] var23 = var3?field1369:field1366;
         int[] var24 = var3?field1350:field1370;

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
         for(var25 = 0; var25 < var19; ++var25) {
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

         var25 = Player.method45(var4 - 1);

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
            var20[var4 - var42 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var42 - 2 - 2 * var47] = var20[4 * var47 + 3];
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

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
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
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1359[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1359[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1360 > 0) {
         var42 = this.field1360 + var4 >> 2;
         var43 = new float[var42];
         int var44;
         if(!this.field1362) {
            for(var19 = 0; var19 < this.field1361; ++var19) {
               var44 = (this.field1360 >> 1) + var19;
               var43[var19] += this.field1345[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var43.length - (var4 >> 1) + var19;
               var43[var44] += field1359[var19];
            }
         }
      }

      float[] var46 = this.field1345;
      this.field1345 = field1359;
      field1359 = var46;
      this.field1360 = var4;
      this.field1361 = var12 - (var4 >> 1);
      this.field1362 = var15;
      return var43;
   }

   @ObfuscatedName("l")
   static boolean method1571(class170 var0) {
      if(!field1343) {
         byte[] var1 = var0.method3292(0, 0);
         if(var1 == null) {
            return false;
         }

         method1569(var1);
         field1343 = true;
      }

      return true;
   }

   @ObfuscatedName("m")
   static class73 method1572(class170 var0, int var1, int var2) {
      if(!method1571(var0)) {
         var0.method3291(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3292(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1589(var1);
   }

   @ObfuscatedName("n")
   void method1589(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1342 = var2.method2549();
      this.field1354 = var2.method2549();
      this.field1344 = var2.method2549();
      this.field1374 = var2.method2549();
      if(this.field1374 < 0) {
         this.field1374 = ~this.field1374;
         this.field1367 = true;
      }

      int var3 = var2.method2549();
      this.field1368 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.method2544();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2555(var6, 0, var5);
         this.field1368[var4] = var6;
      }

   }

   @ObfuscatedName("j")
   class65 method1593(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1372 == null) {
            this.field1360 = 0;
            this.field1345 = new float[field1351];
            this.field1372 = new byte[this.field1354];
            this.field1373 = 0;
            this.field1355 = 0;
         }

         for(; this.field1355 < this.field1368.length; ++this.field1355) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1570(this.field1355);
            if(var2 != null) {
               int var3 = this.field1373;
               int var4 = var2.length;
               if(var4 > this.field1354 - var3) {
                  var4 = this.field1354 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1372[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1373;
               }

               this.field1373 = var3;
            }
         }

         this.field1345 = null;
         byte[] var7 = this.field1372;
         this.field1372 = null;
         return new class65(this.field1342, var7, this.field1344, this.field1374, this.field1367);
      }
   }

   @ObfuscatedName("i")
   static float method1594(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}

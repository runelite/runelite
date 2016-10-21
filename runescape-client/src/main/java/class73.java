import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class73 extends Node {
   @ObfuscatedName("a")
   int field1334;
   @ObfuscatedName("e")
   int field1335;
   @ObfuscatedName("n")
   int field1336;
   @ObfuscatedName("t")
   int field1337;
   @ObfuscatedName("v")
   int field1338;
   @ObfuscatedName("q")
   float[] field1339;
   @ObfuscatedName("m")
   static byte[] field1340;
   @ObfuscatedName("k")
   static int field1341;
   @ObfuscatedName("f")
   byte[][] field1342;
   @ObfuscatedName("w")
   static int field1343;
   @ObfuscatedName("l")
   static int field1344;
   @ObfuscatedName("y")
   static float[] field1345;
   @ObfuscatedName("i")
   static class70[] field1346;
   @ObfuscatedName("u")
   static class63[] field1347;
   @ObfuscatedName("o")
   static int[] field1348;
   @ObfuscatedName("d")
   static boolean[] field1349;
   @ObfuscatedName("j")
   static boolean field1350 = false;
   @ObfuscatedName("ah")
   static float[] field1351;
   @ObfuscatedName("x")
   static class71[] field1352;
   @ObfuscatedName("r")
   int field1353;
   @ObfuscatedName("ac")
   int field1354;
   @ObfuscatedName("z")
   boolean field1355;
   @ObfuscatedName("p")
   static float[] field1356;
   @ObfuscatedName("g")
   static float[] field1357;
   @ObfuscatedName("s")
   static float[] field1358;
   @ObfuscatedName("c")
   static int field1359;
   @ObfuscatedName("aj")
   static float[] field1360;
   @ObfuscatedName("ax")
   static int[] field1361;
   @ObfuscatedName("ae")
   byte[] field1362;
   @ObfuscatedName("b")
   boolean field1363;
   @ObfuscatedName("ar")
   static int[] field1364;
   @ObfuscatedName("ay")
   static float[] field1365;
   @ObfuscatedName("h")
   static class76[] field1366;
   @ObfuscatedName("aw")
   int field1367;

   @ObfuscatedName("n")
   static int method1581() {
      int var0 = field1340[field1341] >> field1359 & 1;
      ++field1359;
      field1341 += field1359 >> 3;
      field1359 &= 7;
      return var0;
   }

   @ObfuscatedName("t")
   static int method1584(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1359; var0 -= var3) {
         var3 = 8 - field1359;
         int var4 = (1 << var3) - 1;
         var1 += (field1340[field1341] >> field1359 & var4) << var2;
         field1359 = 0;
         ++field1341;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1340[field1341] >> field1359 & var3) << var2;
         field1359 += var0;
      }

      return var1;
   }

   @ObfuscatedName("v")
   void method1585(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1335 = var2.method2538();
      this.field1336 = var2.method2538();
      this.field1337 = var2.method2538();
      this.field1338 = var2.method2538();
      if(this.field1338 < 0) {
         this.field1338 = ~this.field1338;
         this.field1363 = true;
      }

      int var3 = var2.method2538();
      this.field1342 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.method2656();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2698(var6, 0, var5);
         this.field1342[var4] = var6;
      }

   }

   @ObfuscatedName("b")
   static void method1586(byte[] var0) {
      method1591(var0, 0);
      field1343 = 1 << method1584(4);
      field1344 = 1 << method1584(4);
      field1356 = new float[field1344];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1344:field1343;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var12 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var12[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var12[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var13 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var13[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var13[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = Projectile.method90(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = class21.method577(var11, var10);
         }

         if(var1 != 0) {
            field1360 = var6;
            field1365 = var12;
            field1351 = var13;
            field1364 = var14;
         } else {
            field1345 = var6;
            field1358 = var12;
            field1357 = var13;
            field1361 = var14;
         }
      }

      var1 = method1584(8) + 1;
      field1366 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1366[var2] = new class76();
      }

      var2 = method1584(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1584(16);
      }

      var2 = method1584(6) + 1;
      field1346 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1346[var3] = new class70();
      }

      var3 = method1584(6) + 1;
      field1347 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1347[var4] = new class63();
      }

      var4 = method1584(6) + 1;
      field1352 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1352[var5] = new class71();
      }

      var5 = method1584(6) + 1;
      field1349 = new boolean[var5];
      field1348 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1349[var15] = method1581() != 0;
         method1584(16);
         method1584(16);
         field1348[var15] = method1584(8);
      }

   }

   @ObfuscatedName("m")
   float[] method1587(int var1) {
      method1591(this.field1342[var1], 0);
      method1581();
      int var2 = method1584(Projectile.method90(field1348.length - 1));
      boolean var3 = field1349[var2];
      int var4 = var3?field1344:field1343;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1581() != 0;
         var6 = method1581() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1343 >> 2);
         var9 = (var4 >> 2) + (field1343 >> 2);
         var10 = field1343 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1343 >> 2);
         var12 = var4 - (var4 >> 2) + (field1343 >> 2);
         var13 = field1343 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1352[field1348[var2]];
      int var16 = var14.field1329;
      int var42 = var14.field1328[var16];
      boolean var15 = !field1346[var42].method1540();
      boolean var45 = var15;

      for(var42 = 0; var42 < var14.field1327; ++var42) {
         class63 var41 = field1347[var14.field1326[var42]];
         float[] var44 = field1356;
         var41.method1320(var44, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var42 = var14.field1329;
         var18 = var14.field1328[var42];
         field1346[var18].method1551(field1356, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var42 = var4 >> 1; var42 < var4; ++var42) {
            field1356[var42] = 0.0F;
         }
      } else {
         var42 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1356;

         int var21;
         for(var21 = 0; var21 < var42; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var42; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var40 = var3?field1360:field1345;
         float[] var22 = var3?field1365:field1358;
         float[] var23 = var3?field1351:field1357;
         int[] var24 = var3?field1364:field1361;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var40[2 * var25];
            var29 = var40[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var20[var42 + 3 + 4 * var25];
            var27 = var20[var42 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var42 + 3 + 4 * var25] = var26 + var28;
            var20[var42 + 1 + 4 * var25] = var27 + var29;
            var30 = var40[var42 - 4 - 4 * var25];
            var31 = var40[var42 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = Projectile.method90(var4 - 1);

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
                  float var38 = var40[var32 * var48];
                  float var39 = var40[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var19 - 1; ++var46) {
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

         for(var46 = 0; var46 < var42; ++var46) {
            var20[var46] = var20[2 * var46 + 1];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var27 = var23[2 * var46];
            var28 = var23[2 * var46 + 1];
            var29 = var20[var42 + 2 * var46];
            var30 = var20[var42 + 2 * var46 + 1];
            var31 = var20[var4 - 2 - 2 * var46];
            float var52 = var20[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var20[var42 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var20[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var20[var42 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var20[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[2 * var46 + var42] * var22[2 * var46] + var20[2 * var46 + 1 + var42] * var22[2 * var46 + 1];
            var20[var42 - 1 - var46] = var20[2 * var46 + var42] * var22[2 * var46 + 1] - var20[2 * var46 + 1 + var42] * var22[2 * var46];
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
            var20[var42 + var46] = var20[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1356[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1356[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1353 > 0) {
         var18 = this.field1353 + var4 >> 2;
         var17 = new float[var18];
         int var43;
         if(!this.field1355) {
            for(var19 = 0; var19 < this.field1334; ++var19) {
               var43 = (this.field1353 >> 1) + var19;
               var17[var19] += this.field1339[var43];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var43 = var17.length - (var4 >> 1) + var19;
               var17[var43] += field1356[var19];
            }
         }
      }

      float[] var54 = this.field1339;
      this.field1339 = field1356;
      field1356 = var54;
      this.field1353 = var4;
      this.field1334 = var12 - (var4 >> 1);
      this.field1355 = var15;
      return var17;
   }

   @ObfuscatedName("k")
   static boolean method1588(class170 var0) {
      if(!field1350) {
         byte[] var1 = var0.method3304(0, 0);
         if(var1 == null) {
            return false;
         }

         method1586(var1);
         field1350 = true;
      }

      return true;
   }

   @ObfuscatedName("c")
   static class73 method1589(class170 var0, int var1, int var2) {
      if(!method1588(var0)) {
         var0.method3353(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3304(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1585(var1);
   }

   @ObfuscatedName("f")
   static float method1590(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1591(byte[] var0, int var1) {
      field1340 = var0;
      field1341 = var1;
      field1359 = 0;
   }

   @ObfuscatedName("w")
   class65 method1594(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1362 == null) {
            this.field1353 = 0;
            this.field1339 = new float[field1344];
            this.field1362 = new byte[this.field1336];
            this.field1354 = 0;
            this.field1367 = 0;
         }

         for(; this.field1367 < this.field1342.length; ++this.field1367) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1587(this.field1367);
            if(var2 != null) {
               int var3 = this.field1354;
               int var4 = var2.length;
               if(var4 > this.field1336 - var3) {
                  var4 = this.field1336 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1362[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1354;
               }

               this.field1354 = var3;
            }
         }

         this.field1339 = null;
         byte[] var7 = this.field1362;
         this.field1362 = null;
         return new class65(this.field1335, var7, this.field1337, this.field1338, this.field1363);
      }
   }
}

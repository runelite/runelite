import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class73 extends Node {
   @ObfuscatedName("p")
   int field1329;
   @ObfuscatedName("z")
   int field1330;
   @ObfuscatedName("t")
   int field1331;
   @ObfuscatedName("y")
   int field1332;
   @ObfuscatedName("s")
   byte[][] field1333;
   @ObfuscatedName("g")
   boolean field1334;
   @ObfuscatedName("m")
   static byte[] field1335;
   @ObfuscatedName("ax")
   static int[] field1336;
   @ObfuscatedName("ar")
   int field1337;
   @ObfuscatedName("h")
   static int field1338;
   @ObfuscatedName("am")
   static float[] field1339;
   @ObfuscatedName("w")
   static class76[] field1340;
   @ObfuscatedName("aa")
   static int[] field1341;
   @ObfuscatedName("n")
   static class63[] field1342;
   @ObfuscatedName("d")
   static class71[] field1343;
   @ObfuscatedName("a")
   static boolean[] field1344;
   @ObfuscatedName("c")
   int field1345;
   @ObfuscatedName("q")
   static boolean field1346 = false;
   @ObfuscatedName("o")
   float[] field1347;
   @ObfuscatedName("an")
   int field1348;
   @ObfuscatedName("i")
   int field1349;
   @ObfuscatedName("x")
   boolean field1350;
   @ObfuscatedName("v")
   static float[] field1351;
   @ObfuscatedName("l")
   static float[] field1352;
   @ObfuscatedName("u")
   static class70[] field1353;
   @ObfuscatedName("f")
   static int field1354;
   @ObfuscatedName("ae")
   static float[] field1355;
   @ObfuscatedName("ah")
   static float[] field1356;
   @ObfuscatedName("b")
   static int[] field1357;
   @ObfuscatedName("r")
   static int field1358;
   @ObfuscatedName("k")
   static int field1359;
   @ObfuscatedName("ac")
   byte[] field1360;
   @ObfuscatedName("j")
   static float[] field1361;
   @ObfuscatedName("e")
   static float[] field1362;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1538(byte[] var0, int var1) {
      field1335 = var0;
      field1354 = var1;
      field1359 = 0;
   }

   @ObfuscatedName("t")
   static int method1539() {
      int var0 = field1335[field1354] >> field1359 & 1;
      ++field1359;
      field1354 += field1359 >> 3;
      field1359 &= 7;
      return var0;
   }

   @ObfuscatedName("y")
   static int method1540(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1359; var0 -= var3) {
         var3 = 8 - field1359;
         int var4 = (1 << var3) - 1;
         var1 += (field1335[field1354] >> field1359 & var4) << var2;
         field1359 = 0;
         ++field1354;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1335[field1354] >> field1359 & var3) << var2;
         field1359 += var0;
      }

      return var1;
   }

   @ObfuscatedName("g")
   static void method1542(byte[] var0) {
      method1538(var0, 0);
      field1338 = 1 << method1540(4);
      field1358 = 1 << method1540(4);
      field1351 = new float[field1358];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1358:field1338;
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

         float[] var14 = new float[var4];

         for(int var13 = 0; var13 < var5; ++var13) {
            var14[2 * var13] = (float)Math.cos((double)(4 * var13 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var13 + 1] = -((float)Math.sin((double)(4 * var13 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class10.method129(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = World.method643(var11, var10);
         }

         if(var1 != 0) {
            field1355 = var6;
            field1356 = var12;
            field1339 = var14;
            field1336 = var9;
         } else {
            field1352 = var6;
            field1362 = var12;
            field1361 = var14;
            field1341 = var9;
         }
      }

      var1 = method1540(8) + 1;
      field1340 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1340[var2] = new class76();
      }

      var2 = method1540(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1540(16);
      }

      var2 = method1540(6) + 1;
      field1353 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1353[var3] = new class70();
      }

      var3 = method1540(6) + 1;
      field1342 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1342[var4] = new class63();
      }

      var4 = method1540(6) + 1;
      field1343 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1343[var5] = new class71();
      }

      var5 = method1540(6) + 1;
      field1344 = new boolean[var5];
      field1357 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1344[var15] = method1539() != 0;
         method1540(16);
         method1540(16);
         field1357[var15] = method1540(8);
      }

   }

   @ObfuscatedName("k")
   static class73 method1545(class170 var0, int var1, int var2) {
      if(!method1561(var0)) {
         var0.method3252(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3272(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }

   class73(byte[] var1) {
      this.method1553(var1);
   }

   @ObfuscatedName("s")
   static float method1546(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("p")
   void method1553(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1330 = var2.method2526();
      this.field1331 = var2.method2526();
      this.field1332 = var2.method2526();
      this.field1329 = var2.method2526();
      if(this.field1329 < 0) {
         this.field1329 = ~this.field1329;
         this.field1334 = true;
      }

      int var3 = var2.method2526();
      this.field1333 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2481();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2492(var7, 0, var5);
         this.field1333[var4] = var7;
      }

   }

   @ObfuscatedName("h")
   class65 method1560(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1360 == null) {
            this.field1345 = 0;
            this.field1347 = new float[field1358];
            this.field1360 = new byte[this.field1331];
            this.field1337 = 0;
            this.field1348 = 0;
         }

         for(; this.field1348 < this.field1333.length; ++this.field1348) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1566(this.field1348);
            if(var2 != null) {
               int var3 = this.field1337;
               int var4 = var2.length;
               if(var4 > this.field1331 - var3) {
                  var4 = this.field1331 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1360[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1337;
               }

               this.field1337 = var3;
            }
         }

         this.field1347 = null;
         byte[] var7 = this.field1360;
         this.field1360 = null;
         return new class65(this.field1330, var7, this.field1332, this.field1329, this.field1334);
      }
   }

   @ObfuscatedName("f")
   static boolean method1561(class170 var0) {
      if(!field1346) {
         byte[] var1 = var0.method3272(0, 0);
         if(var1 == null) {
            return false;
         }

         method1542(var1);
         field1346 = true;
      }

      return true;
   }

   @ObfuscatedName("m")
   float[] method1566(int var1) {
      method1538(this.field1333[var1], 0);
      method1539();
      int var2 = method1540(class10.method129(field1357.length - 1));
      boolean var3 = field1344[var2];
      int var4 = var3?field1358:field1338;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1539() != 0;
         var6 = method1539() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1338 >> 2);
         var9 = (var4 >> 2) + (field1338 >> 2);
         var10 = field1338 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1338 >> 2);
         var12 = var4 - (var4 >> 2) + (field1338 >> 2);
         var13 = field1338 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1343[field1357[var2]];
      int var16 = var14.field1322;
      int var17 = var14.field1323[var16];
      boolean var15 = !field1353[var17].method1500();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1321; ++var17) {
         class63 var18 = field1342[var14.field1324[var17]];
         float[] var19 = field1351;
         var18.method1280(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1322;
         var40 = var14.field1323[var17];
         field1353[var40].method1501(field1351, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1351[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1351;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1355:field1352;
         float[] var22 = var3?field1356:field1362;
         float[] var23 = var3?field1339:field1361;
         int[] var24 = var3?field1336:field1341;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; ++var25) {
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

         var25 = class10.method129(var4 - 1);

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

         for(var47 = 0; var47 < var17; ++var47) {
            var20[var47] = var20[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var40 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var40 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var41; ++var47) {
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

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var4 - var40 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[var40 + var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var40 + var47] = -var20[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1351[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1351[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1345 > 0) {
         var40 = this.field1345 + var4 >> 2;
         var43 = new float[var40];
         int var44;
         if(!this.field1350) {
            for(var41 = 0; var41 < this.field1349; ++var41) {
               var44 = (this.field1345 >> 1) + var41;
               var43[var41] += this.field1347[var44];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var44 = var43.length - (var4 >> 1) + var41;
               var43[var44] += field1351[var41];
            }
         }
      }

      float[] var46 = this.field1347;
      this.field1347 = field1351;
      field1351 = var46;
      this.field1345 = var4;
      this.field1349 = var12 - (var4 >> 1);
      this.field1350 = var15;
      return var43;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class73 extends Node {
   @ObfuscatedName("g")
   static class71[] field1331;
   @ObfuscatedName("r")
   int field1332;
   @ObfuscatedName("j")
   int field1333;
   @ObfuscatedName("z")
   int field1334;
   @ObfuscatedName("v")
   static class76[] field1335;
   @ObfuscatedName("b")
   boolean field1336;
   @ObfuscatedName("l")
   static byte[] field1337;
   @ObfuscatedName("h")
   static int[] field1338;
   @ObfuscatedName("ag")
   static float[] field1339;
   @ObfuscatedName("an")
   static float[] field1340;
   @ObfuscatedName("d")
   static int field1341;
   @ObfuscatedName("t")
   static class63[] field1342;
   @ObfuscatedName("q")
   static class70[] field1343;
   @ObfuscatedName("ax")
   byte[] field1344;
   @ObfuscatedName("y")
   static float[] field1345;
   @ObfuscatedName("s")
   static boolean[] field1346;
   @ObfuscatedName("f")
   static int field1347;
   @ObfuscatedName("u")
   static boolean field1348 = false;
   @ObfuscatedName("a")
   float[] field1349;
   @ObfuscatedName("e")
   int field1350;
   @ObfuscatedName("c")
   int field1351;
   @ObfuscatedName("n")
   boolean field1352;
   @ObfuscatedName("x")
   byte[][] field1353;
   @ObfuscatedName("k")
   static float[] field1354;
   @ObfuscatedName("w")
   static float[] field1355;
   @ObfuscatedName("o")
   static float[] field1356;
   @ObfuscatedName("ah")
   static float[] field1357;
   @ObfuscatedName("az")
   int field1358;
   @ObfuscatedName("i")
   int field1359;
   @ObfuscatedName("as")
   static int[] field1360;
   @ObfuscatedName("aq")
   static int[] field1361;
   @ObfuscatedName("m")
   static int field1362;
   @ObfuscatedName("p")
   static int field1363;
   @ObfuscatedName("ap")
   int field1364;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1557(byte[] var0, int var1) {
      field1337 = var0;
      field1362 = var1;
      field1363 = 0;
   }

   @ObfuscatedName("j")
   static int method1558() {
      int var0 = field1337[field1362] >> field1363 & 1;
      ++field1363;
      field1362 += field1363 >> 3;
      field1363 &= 7;
      return var0;
   }

   @ObfuscatedName("i")
   void method1559(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1332 = var2.method2561();
      this.field1333 = var2.method2561();
      this.field1334 = var2.method2561();
      this.field1359 = var2.method2561();
      if(this.field1359 < 0) {
         this.field1359 = ~this.field1359;
         this.field1336 = true;
      }

      int var3 = var2.method2561();
      this.field1353 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2556();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2567(var7, 0, var5);
         this.field1353[var4] = var7;
      }

   }

   @ObfuscatedName("z")
   static int method1560(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1363; var0 -= var3) {
         var3 = 8 - field1363;
         int var4 = (1 << var3) - 1;
         var1 += (field1337[field1362] >> field1363 & var4) << var2;
         field1363 = 0;
         ++field1362;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1337[field1362] >> field1363 & var3) << var2;
         field1363 += var0;
      }

      return var1;
   }

   @ObfuscatedName("b")
   static void method1561(byte[] var0) {
      method1557(var0, 0);
      field1347 = 1 << method1560(4);
      field1341 = 1 << method1560(4);
      field1345 = new float[field1341];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1341:field1347;
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

         int[] var15 = new int[var5];
         int var10 = GameObject.method2259(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = GameEngine.method3159(var11, var10);
         }

         if(var1 != 0) {
            field1357 = var6;
            field1340 = var7;
            field1339 = var13;
            field1361 = var15;
         } else {
            field1354 = var6;
            field1355 = var7;
            field1356 = var13;
            field1360 = var15;
         }
      }

      var1 = method1560(8) + 1;
      field1335 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1335[var2] = new class76();
      }

      var2 = method1560(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1560(16);
      }

      var2 = method1560(6) + 1;
      field1343 = new class70[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1343[var3] = new class70();
      }

      var3 = method1560(6) + 1;
      field1342 = new class63[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1342[var4] = new class63();
      }

      var4 = method1560(6) + 1;
      field1331 = new class71[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1331[var5] = new class71();
      }

      var5 = method1560(6) + 1;
      field1346 = new boolean[var5];
      field1338 = new int[var5];

      for(int var14 = 0; var14 < var5; ++var14) {
         field1346[var14] = method1558() != 0;
         method1560(16);
         method1560(16);
         field1338[var14] = method1560(8);
      }

   }

   class73(byte[] var1) {
      this.method1559(var1);
   }

   @ObfuscatedName("m")
   static boolean method1562(class170 var0) {
      if(!field1348) {
         byte[] var1 = var0.method3290(0, 0);
         if(var1 == null) {
            return false;
         }

         method1561(var1);
         field1348 = true;
      }

      return true;
   }

   @ObfuscatedName("l")
   float[] method1563(int var1) {
      method1557(this.field1353[var1], 0);
      method1558();
      int var2 = method1560(GameObject.method2259(field1338.length - 1));
      boolean var3 = field1346[var2];
      int var4 = var3?field1341:field1347;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1558() != 0;
         var6 = method1558() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1347 >> 2);
         var9 = (var4 >> 2) + (field1347 >> 2);
         var10 = field1347 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1347 >> 2);
         var12 = var4 - (var4 >> 2) + (field1347 >> 2);
         var13 = field1347 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class71 var14 = field1331[field1338[var2]];
      int var16 = var14.field1326;
      int var41 = var14.field1323[var16];
      boolean var15 = !field1343[var41].method1518();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1324; ++var41) {
         class63 var42 = field1342[var14.field1325[var41]];
         float[] var40 = field1345;
         var42.method1314(var40, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var41 = var14.field1326;
         var18 = var14.field1323[var41];
         field1343[var18].method1519(field1345, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field1345[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1345;

         int var21;
         for(var21 = 0; var21 < var41; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var41; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var43 = var3?field1357:field1354;
         float[] var22 = var3?field1340:field1355;
         float[] var23 = var3?field1339:field1356;
         int[] var24 = var3?field1361:field1360;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var43[2 * var25];
            var29 = var43[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var20[var41 + 3 + 4 * var25];
            var27 = var20[var41 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var41 + 3 + 4 * var25] = var26 + var28;
            var20[var41 + 1 + 4 * var25] = var27 + var29;
            var30 = var43[var41 - 4 - 4 * var25];
            var31 = var43[var41 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = GameObject.method2259(var4 - 1);

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
                  float var38 = var43[var32 * var48];
                  float var39 = var43[var32 * var48 + 1];
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

         for(var46 = 0; var46 < var41; ++var46) {
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
            var29 = var20[var41 + 2 * var46];
            var30 = var20[var41 + 2 * var46 + 1];
            var31 = var20[var4 - 2 - 2 * var46];
            float var52 = var20[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var20[var41 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var20[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var20[var41 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var20[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[2 * var46 + var41] * var22[2 * var46] + var20[2 * var46 + 1 + var41] * var22[2 * var46 + 1];
            var20[var41 - 1 - var46] = var20[2 * var46 + var41] * var22[2 * var46 + 1] - var20[2 * var46 + 1 + var41] * var22[2 * var46];
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
            var20[var41 + var46] = var20[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1345[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1345[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1350 > 0) {
         var18 = this.field1350 + var4 >> 2;
         var17 = new float[var18];
         int var44;
         if(!this.field1352) {
            for(var19 = 0; var19 < this.field1351; ++var19) {
               var44 = (this.field1350 >> 1) + var19;
               var17[var19] += this.field1349[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var17.length - (var4 >> 1) + var19;
               var17[var44] += field1345[var19];
            }
         }
      }

      float[] var54 = this.field1349;
      this.field1349 = field1345;
      field1345 = var54;
      this.field1350 = var4;
      this.field1351 = var12 - (var4 >> 1);
      this.field1352 = var15;
      return var17;
   }

   @ObfuscatedName("x")
   static float method1564(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("f")
   class65 method1565(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1344 == null) {
            this.field1350 = 0;
            this.field1349 = new float[field1341];
            this.field1344 = new byte[this.field1333];
            this.field1358 = 0;
            this.field1364 = 0;
         }

         for(; this.field1364 < this.field1353.length; ++this.field1364) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1563(this.field1364);
            if(var2 != null) {
               int var3 = this.field1358;
               int var4 = var2.length;
               if(var4 > this.field1333 - var3) {
                  var4 = this.field1333 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1344[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1358;
               }

               this.field1358 = var3;
            }
         }

         this.field1349 = null;
         byte[] var7 = this.field1344;
         this.field1344 = null;
         return new class65(this.field1332, var7, this.field1334, this.field1359, this.field1336);
      }
   }

   @ObfuscatedName("p")
   static class73 method1581(class170 var0, int var1, int var2) {
      if(!method1562(var0)) {
         var0.method3292(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3290(var1, var2);
         return var3 == null?null:new class73(var3);
      }
   }
}

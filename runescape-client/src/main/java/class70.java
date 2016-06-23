import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class70 extends class208 {
   @ObfuscatedName("b")
   int field1303;
   @ObfuscatedName("u")
   int field1304;
   @ObfuscatedName("x")
   int field1305;
   @ObfuscatedName("ax")
   static float[] field1306;
   @ObfuscatedName("ag")
   static float[] field1307;
   @ObfuscatedName("d")
   boolean field1308;
   @ObfuscatedName("l")
   int field1309;
   @ObfuscatedName("m")
   static int field1310;
   @ObfuscatedName("g")
   static int field1311;
   @ObfuscatedName("s")
   static int field1312;
   @ObfuscatedName("r")
   static int field1313;
   @ObfuscatedName("as")
   int field1314;
   @ObfuscatedName("o")
   static class67[] field1315;
   @ObfuscatedName("an")
   byte[] field1316;
   @ObfuscatedName("p")
   static class68[] field1317;
   @ObfuscatedName("h")
   static boolean[] field1318;
   @ObfuscatedName("e")
   static int[] field1319;
   @ObfuscatedName("t")
   static boolean field1320 = false;
   @ObfuscatedName("w")
   float[] field1321;
   @ObfuscatedName("v")
   int field1322;
   @ObfuscatedName("y")
   int field1323;
   @ObfuscatedName("c")
   boolean field1324;
   @ObfuscatedName("i")
   static float[] field1325;
   @ObfuscatedName("a")
   static float[] field1326;
   @ObfuscatedName("z")
   static float[] field1327;
   @ObfuscatedName("j")
   static float[] field1328;
   @ObfuscatedName("n")
   static byte[] field1329;
   @ObfuscatedName("ao")
   static float[] field1330;
   @ObfuscatedName("k")
   static class73[] field1331;
   @ObfuscatedName("ac")
   static int[] field1332;
   @ObfuscatedName("aj")
   static int[] field1333;
   @ObfuscatedName("q")
   static class60[] field1334;
   @ObfuscatedName("al")
   int field1335;
   @ObfuscatedName("f")
   byte[][] field1336;

   @ObfuscatedName("d")
   static void method1586(byte[] var0) {
      method1587(var0, 0);
      field1312 = 1 << method1596(4);
      field1313 = 1 << method1596(4);
      field1325 = new float[field1313];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1313:field1312;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var13 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var13[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var13[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var12 = new float[var4];

         for(int var14 = 0; var14 < var5; ++var14) {
            var12[2 * var14] = (float)Math.cos((double)(4 * var14 + 2) * 3.141592653589793D / (double)var2);
            var12[2 * var14 + 1] = -((float)Math.sin((double)(4 * var14 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class15.method190(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = class34.method766(var11, var10);
         }

         if(var1 != 0) {
            field1307 = var6;
            field1306 = var13;
            field1330 = var12;
            field1333 = var9;
         } else {
            field1326 = var6;
            field1327 = var13;
            field1328 = var12;
            field1332 = var9;
         }
      }

      var1 = method1596(8) + 1;
      field1331 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1331[var2] = new class73();
      }

      var2 = method1596(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1596(16);
      }

      var2 = method1596(6) + 1;
      field1315 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1315[var3] = new class67();
      }

      var3 = method1596(6) + 1;
      field1334 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1334[var4] = new class60();
      }

      var4 = method1596(6) + 1;
      field1317 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1317[var5] = new class68();
      }

      var5 = method1596(6) + 1;
      field1318 = new boolean[var5];
      field1319 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1318[var15] = method1588() != 0;
         method1596(16);
         method1596(16);
         field1319[var15] = method1596(8);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1587(byte[] var0, int var1) {
      field1329 = var0;
      field1310 = var1;
      field1311 = 0;
   }

   @ObfuscatedName("x")
   static int method1588() {
      int var0 = field1329[field1310] >> field1311 & 1;
      ++field1311;
      field1310 += field1311 >> 3;
      field1311 &= 7;
      return var0;
   }

   @ObfuscatedName("l")
   void method1590(byte[] var1) {
      class119 var2 = new class119(var1);
      this.field1304 = var2.method2696();
      this.field1305 = var2.method2696();
      this.field1303 = var2.method2696();
      this.field1309 = var2.method2696();
      if(this.field1309 < 0) {
         this.field1309 = ~this.field1309;
         this.field1308 = true;
      }

      int var3 = var2.method2696();
      this.field1336 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.method2554();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2565(var6, 0, var5);
         this.field1336[var4] = var6;
      }

   }

   @ObfuscatedName("n")
   float[] method1592(int var1) {
      method1587(this.field1336[var1], 0);
      method1588();
      int var2 = method1596(class15.method190(field1319.length - 1));
      boolean var3 = field1318[var2];
      int var4 = var3?field1313:field1312;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1588() != 0;
         var6 = method1588() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1312 >> 2);
         var9 = (var4 >> 2) + (field1312 >> 2);
         var10 = field1312 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1312 >> 2);
         var12 = var4 - (var4 >> 2) + (field1312 >> 2);
         var13 = field1312 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1317[field1319[var2]];
      int var16 = var14.field1295;
      int var17 = var14.field1297[var16];
      boolean var15 = !field1315[var17].method1561();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1296; ++var17) {
         class60 var18 = field1334[var14.field1298[var17]];
         float[] var40 = field1325;
         var18.method1332(var40, var4 >> 1, var45);
      }

      int var43;
      if(!var15) {
         var17 = var14.field1295;
         var43 = var14.field1297[var17];
         field1315[var43].method1547(field1325, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1325[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var43 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1325;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1307:field1326;
         float[] var22 = var3?field1306:field1327;
         float[] var23 = var3?field1330:field1328;
         int[] var24 = var3?field1333:field1332;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var43; ++var25) {
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

         var25 = class15.method190(var4 - 1);

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
            field1325[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1325[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1322 > 0) {
         var43 = this.field1322 + var4 >> 2;
         var41 = new float[var43];
         int var44;
         if(!this.field1324) {
            for(var19 = 0; var19 < this.field1323; ++var19) {
               var44 = (this.field1322 >> 1) + var19;
               var41[var19] += this.field1321[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var41.length - (var4 >> 1) + var19;
               var41[var44] += field1325[var19];
            }
         }
      }

      float[] var46 = this.field1321;
      this.field1321 = field1325;
      field1325 = var46;
      this.field1322 = var4;
      this.field1323 = var12 - (var4 >> 1);
      this.field1324 = var15;
      return var41;
   }

   @ObfuscatedName("m")
   static boolean method1593(class167 var0) {
      if(!field1320) {
         byte[] var1 = var0.method3286(0, 0);
         if(var1 == null) {
            return false;
         }

         method1586(var1);
         field1320 = true;
      }

      return true;
   }

   @ObfuscatedName("g")
   static class70 method1594(class167 var0, int var1, int var2) {
      if(!method1593(var0)) {
         var0.method3288(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3286(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   @ObfuscatedName("b")
   static int method1596(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1311; var0 -= var3) {
         var3 = 8 - field1311;
         int var4 = (1 << var3) - 1;
         var1 += (field1329[field1310] >> field1311 & var4) << var2;
         field1311 = 0;
         ++field1310;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1329[field1310] >> field1311 & var3) << var2;
         field1311 += var0;
      }

      return var1;
   }

   @ObfuscatedName("f")
   static float method1607(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("s")
   class62 method1610(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1316 == null) {
            this.field1322 = 0;
            this.field1321 = new float[field1313];
            this.field1316 = new byte[this.field1305];
            this.field1335 = 0;
            this.field1314 = 0;
         }

         for(; this.field1314 < this.field1336.length; ++this.field1314) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1592(this.field1314);
            if(var2 != null) {
               int var3 = this.field1335;
               int var4 = var2.length;
               if(var4 > this.field1305 - var3) {
                  var4 = this.field1305 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1316[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1335;
               }

               this.field1335 = var3;
            }
         }

         this.field1321 = null;
         byte[] var7 = this.field1316;
         this.field1316 = null;
         return new class62(this.field1304, var7, this.field1303, this.field1309, this.field1308);
      }
   }

   class70(byte[] var1) {
      this.method1590(var1);
   }
}

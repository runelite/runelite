package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class70 extends class207 {
   @ObfuscatedName("t")
   static int field1275;
   @ObfuscatedName("m")
   int field1276;
   @ObfuscatedName("f")
   int field1277;
   @ObfuscatedName("s")
   static int field1278;
   @ObfuscatedName("aa")
   static float[] field1279;
   @ObfuscatedName("a")
   boolean field1280;
   @ObfuscatedName("h")
   static byte[] field1281;
   @ObfuscatedName("q")
   int field1282;
   @ObfuscatedName("c")
   static float[] field1283;
   @ObfuscatedName("k")
   static int field1284;
   @ObfuscatedName("e")
   static class67[] field1285;
   @ObfuscatedName("am")
   byte[] field1286;
   @ObfuscatedName("ax")
   int field1287;
   @ObfuscatedName("z")
   static class60[] field1288;
   @ObfuscatedName("p")
   static class68[] field1289;
   @ObfuscatedName("r")
   static boolean[] field1290;
   @ObfuscatedName("g")
   static int[] field1291;
   @ObfuscatedName("n")
   static boolean field1292 = false;
   @ObfuscatedName("y")
   float[] field1293;
   @ObfuscatedName("v")
   int field1294;
   @ObfuscatedName("l")
   int field1295;
   @ObfuscatedName("i")
   static int field1296;
   @ObfuscatedName("d")
   static float[] field1297;
   @ObfuscatedName("as")
   static float[] field1298;
   @ObfuscatedName("o")
   static float[] field1299;
   @ObfuscatedName("b")
   static float[] field1300;
   @ObfuscatedName("j")
   byte[][] field1301;
   @ObfuscatedName("ao")
   static float[] field1302;
   @ObfuscatedName("w")
   static class73[] field1303;
   @ObfuscatedName("ae")
   static int[] field1304;
   @ObfuscatedName("ai")
   static int[] field1305;
   @ObfuscatedName("x")
   boolean field1306;
   @ObfuscatedName("u")
   int field1307;
   @ObfuscatedName("ay")
   int field1308;

   @ObfuscatedName("f")
   static int method1554() {
      int var0 = field1281[field1296] >> field1275 & 1;
      ++field1275;
      field1296 += field1275 >> 3;
      field1275 &= 7;
      return var0;
   }

   @ObfuscatedName("l")
   static int method1556(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1275; var0 -= var3) {
         var3 = 8 - field1275;
         int var4 = (1 << var3) - 1;
         var1 += (field1281[field1296] >> field1275 & var4) << var2;
         field1275 = 0;
         ++field1296;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1281[field1296] >> field1275 & var3) << var2;
         field1275 += var0;
      }

      return var1;
   }

   @ObfuscatedName("a")
   static void method1557(byte[] var0) {
      method1562(var0, 0);
      field1284 = 1 << method1556(4);
      field1278 = 1 << method1556(4);
      field1297 = new float[field1278];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1278:field1284;
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

         float[] var14 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var14[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var15 = new int[var5];
         int var10 = class21.method608(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = class77.method1715(var11, var10);
         }

         if(var1 != 0) {
            field1279 = var6;
            field1302 = var13;
            field1298 = var14;
            field1305 = var15;
         } else {
            field1299 = var6;
            field1283 = var13;
            field1300 = var14;
            field1304 = var15;
         }
      }

      var1 = method1556(8) + 1;
      field1303 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1303[var2] = new class73();
      }

      var2 = method1556(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1556(16);
      }

      var2 = method1556(6) + 1;
      field1285 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1285[var3] = new class67();
      }

      var3 = method1556(6) + 1;
      field1288 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1288[var4] = new class60();
      }

      var4 = method1556(6) + 1;
      field1289 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1289[var5] = new class68();
      }

      var5 = method1556(6) + 1;
      field1290 = new boolean[var5];
      field1291 = new int[var5];

      for(int var12 = 0; var12 < var5; ++var12) {
         field1290[var12] = method1554() != 0;
         method1556(16);
         method1556(16);
         field1291[var12] = method1556(8);
      }

   }

   @ObfuscatedName("h")
   float[] method1558(int var1) {
      method1562(this.field1301[var1], 0);
      method1554();
      int var2 = method1556(class21.method608(field1291.length - 1));
      boolean var3 = field1290[var2];
      int var4 = var3?field1278:field1284;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1554() != 0;
         var6 = method1554() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1284 >> 2);
         var9 = (var4 >> 2) + (field1284 >> 2);
         var10 = field1284 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1284 >> 2);
         var12 = var4 - (var4 >> 2) + (field1284 >> 2);
         var13 = field1284 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1289[field1291[var2]];
      int var16 = var14.field1268;
      int var17 = var14.field1269[var16];
      boolean var15 = !field1285[var17].method1513();
      boolean var40 = var15;

      for(var17 = 0; var17 < var14.field1270; ++var17) {
         class60 var18 = field1288[var14.field1267[var17]];
         float[] var19 = field1297;
         var18.method1310(var19, var4 >> 1, var40);
      }

      int var41;
      if(!var15) {
         var17 = var14.field1268;
         var41 = var14.field1269[var17];
         field1285[var41].method1516(field1297, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1297[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1297;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var46 = var3?field1279:field1299;
         float[] var22 = var3?field1302:field1283;
         float[] var23 = var3?field1298:field1300;
         int[] var24 = var3?field1305:field1304;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var46[2 * var25];
            var29 = var46[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var42; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var46[var17 - 4 - 4 * var25];
            var31 = var46[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class21.method608(var4 - 1);

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
                  float var38 = var46[var32 * var49];
                  float var39 = var46[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var42 - 1; ++var47) {
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

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var41 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var41 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var42; ++var47) {
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

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - var41 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var47] = var20[var41 + var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var41 + var47] = -var20[var41 - var47 - 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1297[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1297[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1294 > 0) {
         var41 = this.field1294 + var4 >> 2;
         var43 = new float[var41];
         int var45;
         if(!this.field1306) {
            for(var42 = 0; var42 < this.field1282; ++var42) {
               var45 = (this.field1294 >> 1) + var42;
               var43[var42] += this.field1293[var45];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var45 = var43.length - (var4 >> 1) + var42;
               var43[var45] += field1297[var42];
            }
         }
      }

      float[] var44 = this.field1293;
      this.field1293 = field1297;
      field1297 = var44;
      this.field1294 = var4;
      this.field1282 = var12 - (var4 >> 1);
      this.field1306 = var15;
      return var43;
   }

   @ObfuscatedName("i")
   static boolean method1559(class166 var0) {
      if(!field1292) {
         byte[] var1 = var0.method3352(0, 0);
         if(var1 == null) {
            return false;
         }

         method1557(var1);
         field1292 = true;
      }

      return true;
   }

   @ObfuscatedName("t")
   static class70 method1560(class166 var0, int var1, int var2) {
      if(!method1559(var0)) {
         var0.method3314(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3352(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   @ObfuscatedName("j")
   static float method1561(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("m")
   static void method1562(byte[] var0, int var1) {
      field1281 = var0;
      field1296 = var1;
      field1275 = 0;
   }

   @ObfuscatedName("u")
   void method1567(byte[] var1) {
      class118 var2 = new class118(var1);
      this.field1276 = var2.method2541();
      this.field1277 = var2.method2541();
      this.field1295 = var2.method2541();
      this.field1307 = var2.method2541();
      if(this.field1307 < 0) {
         this.field1307 = ~this.field1307;
         this.field1280 = true;
      }

      int var3 = var2.method2541();
      this.field1301 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2536();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2546(var7, 0, var5);
         this.field1301[var4] = var7;
      }

   }

   class70(byte[] var1) {
      this.method1567(var1);
   }

   @ObfuscatedName("k")
   class62 method1577(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1286 == null) {
            this.field1294 = 0;
            this.field1293 = new float[field1278];
            this.field1286 = new byte[this.field1277];
            this.field1287 = 0;
            this.field1308 = 0;
         }

         for(; this.field1308 < this.field1301.length; ++this.field1308) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1558(this.field1308);
            if(var2 != null) {
               int var3 = this.field1287;
               int var4 = var2.length;
               if(var4 > this.field1277 - var3) {
                  var4 = this.field1277 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1286[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1287;
               }

               this.field1287 = var3;
            }
         }

         this.field1293 = null;
         byte[] var7 = this.field1286;
         this.field1286 = null;
         return new class62(this.field1276, var7, this.field1295, this.field1307, this.field1280);
      }
   }
}

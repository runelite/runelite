package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class70 extends class207 {
   @ObfuscatedName("i")
   int field1295;
   @ObfuscatedName("l")
   int field1296;
   @ObfuscatedName("a")
   int field1297;
   @ObfuscatedName("k")
   static int field1298;
   @ObfuscatedName("f")
   int field1299;
   @ObfuscatedName("b")
   static class73[] field1300;
   @ObfuscatedName("az")
   static int[] field1301;
   @ObfuscatedName("x")
   static float[] field1302;
   @ObfuscatedName("o")
   static byte[] field1303;
   @ObfuscatedName("n")
   static int field1304;
   @ObfuscatedName("r")
   static int field1305;
   @ObfuscatedName("p")
   int field1306;
   @ObfuscatedName("q")
   static class67[] field1307;
   @ObfuscatedName("u")
   static class60[] field1308;
   @ObfuscatedName("g")
   static class68[] field1309;
   @ObfuscatedName("j")
   byte[][] field1310;
   @ObfuscatedName("s")
   static int[] field1311;
   @ObfuscatedName("d")
   static boolean field1312 = false;
   @ObfuscatedName("z")
   float[] field1313;
   @ObfuscatedName("w")
   int field1314;
   @ObfuscatedName("ab")
   static float[] field1315;
   @ObfuscatedName("t")
   boolean field1316;
   @ObfuscatedName("c")
   static float[] field1317;
   @ObfuscatedName("h")
   static int field1318;
   @ObfuscatedName("e")
   static float[] field1319;
   @ObfuscatedName("v")
   static float[] field1320;
   @ObfuscatedName("y")
   static boolean[] field1321;
   @ObfuscatedName("ak")
   static float[] field1322;
   @ObfuscatedName("am")
   static float[] field1323;
   @ObfuscatedName("aw")
   static int[] field1324;
   @ObfuscatedName("ac")
   byte[] field1325;
   @ObfuscatedName("m")
   boolean field1326;
   @ObfuscatedName("ax")
   int field1327;
   @ObfuscatedName("ai")
   int field1328;

   @ObfuscatedName("l")
   static void method1523(byte[] var0, int var1) {
      field1303 = var0;
      field1318 = var1;
      field1304 = 0;
   }

   @ObfuscatedName("o")
   float[] method1524(int var1) {
      method1523(this.field1310[var1], 0);
      method1525();
      int var2 = method1547(class133.method2801(field1311.length - 1));
      boolean var3 = field1321[var2];
      int var4 = var3?field1305:field1298;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1525() != 0;
         var6 = method1525() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1298 >> 2);
         var9 = (var4 >> 2) + (field1298 >> 2);
         var10 = field1298 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1298 >> 2);
         var12 = var4 - (var4 >> 2) + (field1298 >> 2);
         var13 = field1298 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1309[field1311[var2]];
      int var16 = var14.field1288;
      int var17 = var14.field1289[var16];
      boolean var15 = !field1307[var17].method1483();
      boolean var40 = var15;

      for(var17 = 0; var17 < var14.field1287; ++var17) {
         class60 var18 = field1308[var14.field1290[var17]];
         float[] var19 = field1317;
         var18.method1269(var19, var4 >> 1, var40);
      }

      int var41;
      if(!var15) {
         var17 = var14.field1288;
         var41 = var14.field1289[var17];
         field1307[var41].method1480(field1317, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1317[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1317;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var46 = var3?field1315:field1302;
         float[] var22 = var3?field1322:field1319;
         float[] var23 = var3?field1323:field1320;
         int[] var24 = var3?field1301:field1324;

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

         var25 = class133.method2801(var4 - 1);

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
            field1317[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1317[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1306 > 0) {
         var41 = this.field1306 + var4 >> 2;
         var43 = new float[var41];
         int var45;
         if(!this.field1316) {
            for(var42 = 0; var42 < this.field1314; ++var42) {
               var45 = (this.field1306 >> 1) + var42;
               var43[var42] += this.field1313[var45];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var45 = var43.length - (var4 >> 1) + var42;
               var43[var45] += field1317[var42];
            }
         }
      }

      float[] var44 = this.field1313;
      this.field1313 = field1317;
      field1317 = var44;
      this.field1306 = var4;
      this.field1314 = var12 - (var4 >> 1);
      this.field1316 = var15;
      return var43;
   }

   @ObfuscatedName("a")
   static int method1525() {
      int var0 = field1303[field1318] >> field1304 & 1;
      ++field1304;
      field1318 += field1304 >> 3;
      field1304 &= 7;
      return var0;
   }

   @ObfuscatedName("f")
   void method1526(byte[] var1) {
      class118 var2 = new class118(var1);
      this.field1296 = var2.method2458();
      this.field1297 = var2.method2458();
      this.field1295 = var2.method2458();
      this.field1299 = var2.method2458();
      if(this.field1299 < 0) {
         this.field1299 = ~this.field1299;
         this.field1326 = true;
      }

      int var3 = var2.method2458();
      this.field1310 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2453();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2534(var7, 0, var5);
         this.field1310[var4] = var7;
      }

   }

   @ObfuscatedName("h")
   static boolean method1529(class166 var0) {
      if(!field1312) {
         byte[] var1 = var0.method3214(0, 0);
         if(var1 == null) {
            return false;
         }

         method1546(var1);
         field1312 = true;
      }

      return true;
   }

   @ObfuscatedName("n")
   static class70 method1530(class166 var0, int var1, int var2) {
      if(!method1529(var0)) {
         var0.method3216(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3214(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   @ObfuscatedName("k")
   class62 method1532(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1325 == null) {
            this.field1306 = 0;
            this.field1313 = new float[field1305];
            this.field1325 = new byte[this.field1297];
            this.field1327 = 0;
            this.field1328 = 0;
         }

         for(; this.field1328 < this.field1310.length; ++this.field1328) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1524(this.field1328);
            if(var2 != null) {
               int var3 = this.field1327;
               int var4 = var2.length;
               if(var4 > this.field1297 - var3) {
                  var4 = this.field1297 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1325[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1327;
               }

               this.field1327 = var3;
            }
         }

         this.field1313 = null;
         byte[] var7 = this.field1325;
         this.field1325 = null;
         return new class62(this.field1296, var7, this.field1295, this.field1299, this.field1326);
      }
   }

   @ObfuscatedName("j")
   static float method1536(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   class70(byte[] var1) {
      this.method1526(var1);
   }

   @ObfuscatedName("m")
   static void method1546(byte[] var0) {
      method1523(var0, 0);
      field1298 = 1 << method1547(4);
      field1305 = 1 << method1547(4);
      field1317 = new float[field1305];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1305:field1298;
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

         float[] var20 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var20[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var20[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = class133.method2801(var5 - 1);

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
            field1315 = var6;
            field1322 = var19;
            field1323 = var20;
            field1301 = var21;
         } else {
            field1302 = var6;
            field1319 = var19;
            field1320 = var20;
            field1324 = var21;
         }
      }

      var1 = method1547(8) + 1;
      field1300 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1300[var2] = new class73();
      }

      var2 = method1547(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1547(16);
      }

      var2 = method1547(6) + 1;
      field1307 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1307[var3] = new class67();
      }

      var3 = method1547(6) + 1;
      field1308 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1308[var4] = new class60();
      }

      var4 = method1547(6) + 1;
      field1309 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1309[var5] = new class68();
      }

      var5 = method1547(6) + 1;
      field1321 = new boolean[var5];
      field1311 = new int[var5];

      for(int var18 = 0; var18 < var5; ++var18) {
         field1321[var18] = method1525() != 0;
         method1547(16);
         method1547(16);
         field1311[var18] = method1547(8);
      }

   }

   @ObfuscatedName("i")
   static int method1547(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1304; var0 -= var3) {
         var3 = 8 - field1304;
         int var4 = (1 << var3) - 1;
         var1 += (field1303[field1318] >> field1304 & var4) << var2;
         field1304 = 0;
         ++field1318;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1303[field1318] >> field1304 & var3) << var2;
         field1304 += var0;
      }

      return var1;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class70 extends class208 {
   @ObfuscatedName("m")
   static class68[] field1293;
   @ObfuscatedName("j")
   int field1294;
   @ObfuscatedName("q")
   static float[] field1295;
   @ObfuscatedName("au")
   static int[] field1296;
   @ObfuscatedName("d")
   int field1297;
   @ObfuscatedName("u")
   boolean field1298;
   @ObfuscatedName("o")
   static byte[] field1299;
   @ObfuscatedName("t")
   static class73[] field1300;
   @ObfuscatedName("ae")
   int field1301;
   @ObfuscatedName("p")
   int field1302;
   @ObfuscatedName("l")
   static int field1303;
   @ObfuscatedName("v")
   static float[] field1304;
   @ObfuscatedName("i")
   static class67[] field1305;
   @ObfuscatedName("w")
   int field1306;
   @ObfuscatedName("e")
   static boolean[] field1307;
   @ObfuscatedName("k")
   static int field1308;
   @ObfuscatedName("b")
   static int field1309;
   @ObfuscatedName("z")
   static boolean field1310 = false;
   @ObfuscatedName("a")
   float[] field1311;
   @ObfuscatedName("x")
   int field1312;
   @ObfuscatedName("g")
   int field1313;
   @ObfuscatedName("y")
   boolean field1314;
   @ObfuscatedName("f")
   static float[] field1315;
   @ObfuscatedName("r")
   static class60[] field1316;
   @ObfuscatedName("n")
   static float[] field1317;
   @ObfuscatedName("s")
   byte[][] field1318;
   @ObfuscatedName("ab")
   static float[] field1319;
   @ObfuscatedName("ad")
   static float[] field1320;
   @ObfuscatedName("an")
   static float[] field1321;
   @ObfuscatedName("h")
   static int[] field1322;
   @ObfuscatedName("ap")
   static int[] field1323;
   @ObfuscatedName("am")
   byte[] field1324;
   @ObfuscatedName("c")
   static int field1325;
   @ObfuscatedName("ao")
   int field1326;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1513(byte[] var0, int var1) {
      field1299 = var0;
      field1309 = var1;
      field1308 = 0;
   }

   @ObfuscatedName("b")
   static boolean method1514(class167 var0) {
      if(!field1310) {
         byte[] var1 = var0.method3239(0, 0);
         if(var1 == null) {
            return false;
         }

         method1517(var1);
         field1310 = true;
      }

      return true;
   }

   @ObfuscatedName("x")
   static int method1515(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1308; var0 -= var3) {
         var3 = 8 - field1308;
         int var4 = (1 << var3) - 1;
         var1 += (field1299[field1309] >> field1308 & var4) << var2;
         field1308 = 0;
         ++field1309;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1299[field1309] >> field1308 & var3) << var2;
         field1308 += var0;
      }

      return var1;
   }

   @ObfuscatedName("d")
   void method1516(byte[] var1) {
      class119 var2 = new class119(var1);
      this.field1294 = var2.method2497();
      this.field1302 = var2.method2497();
      this.field1312 = var2.method2497();
      this.field1297 = var2.method2497();
      if(this.field1297 < 0) {
         this.field1297 = ~this.field1297;
         this.field1298 = true;
      }

      int var3 = var2.method2497();
      this.field1318 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2492();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2503(var7, 0, var5);
         this.field1318[var4] = var7;
      }

   }

   @ObfuscatedName("u")
   static void method1517(byte[] var0) {
      method1513(var0, 0);
      field1325 = 1 << method1515(4);
      field1303 = 1 << method1515(4);
      field1315 = new float[field1303];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1303:field1325;
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
         int var10 = class175.method3430(var5 - 1);

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
            field1319 = var6;
            field1320 = var19;
            field1321 = var20;
            field1323 = var21;
         } else {
            field1295 = var6;
            field1317 = var19;
            field1304 = var20;
            field1296 = var21;
         }
      }

      var1 = method1515(8) + 1;
      field1300 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1300[var2] = new class73();
      }

      var2 = method1515(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1515(16);
      }

      var2 = method1515(6) + 1;
      field1305 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1305[var3] = new class67();
      }

      var3 = method1515(6) + 1;
      field1316 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1316[var4] = new class60();
      }

      var4 = method1515(6) + 1;
      field1293 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1293[var5] = new class68();
      }

      var5 = method1515(6) + 1;
      field1307 = new boolean[var5];
      field1322 = new int[var5];

      for(int var18 = 0; var18 < var5; ++var18) {
         field1307[var18] = method1535() != 0;
         method1515(16);
         method1515(16);
         field1322[var18] = method1515(8);
      }

   }

   @ObfuscatedName("o")
   float[] method1518(int var1) {
      method1513(this.field1318[var1], 0);
      method1535();
      int var2 = method1515(class175.method3430(field1322.length - 1));
      boolean var3 = field1307[var2];
      int var4 = var3?field1303:field1325;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1535() != 0;
         var6 = method1535() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1325 >> 2);
         var9 = (var4 >> 2) + (field1325 >> 2);
         var10 = field1325 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1325 >> 2);
         var12 = var4 - (var4 >> 2) + (field1325 >> 2);
         var13 = field1325 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1293[field1322[var2]];
      int var16 = var14.field1287;
      int var17 = var14.field1286[var16];
      boolean var15 = !field1305[var17].method1469();
      boolean var40 = var15;

      for(var17 = 0; var17 < var14.field1285; ++var17) {
         class60 var18 = field1316[var14.field1288[var17]];
         float[] var19 = field1315;
         var18.method1243(var19, var4 >> 1, var40);
      }

      int var41;
      if(!var15) {
         var17 = var14.field1287;
         var41 = var14.field1286[var17];
         field1305[var41].method1470(field1315, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1315[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1315;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var46 = var3?field1319:field1295;
         float[] var22 = var3?field1320:field1317;
         float[] var23 = var3?field1321:field1304;
         int[] var24 = var3?field1323:field1296;

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

         var25 = class175.method3430(var4 - 1);

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
            field1315[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1315[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1306 > 0) {
         var41 = this.field1306 + var4 >> 2;
         var43 = new float[var41];
         int var45;
         if(!this.field1314) {
            for(var42 = 0; var42 < this.field1313; ++var42) {
               var45 = (this.field1306 >> 1) + var42;
               var43[var42] += this.field1311[var45];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var45 = var43.length - (var4 >> 1) + var42;
               var43[var45] += field1315[var42];
            }
         }
      }

      float[] var44 = this.field1311;
      this.field1311 = field1315;
      field1315 = var44;
      this.field1306 = var4;
      this.field1313 = var12 - (var4 >> 1);
      this.field1314 = var15;
      return var43;
   }

   @ObfuscatedName("c")
   class62 method1521(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1324 == null) {
            this.field1306 = 0;
            this.field1311 = new float[field1303];
            this.field1324 = new byte[this.field1302];
            this.field1301 = 0;
            this.field1326 = 0;
         }

         for(; this.field1326 < this.field1318.length; ++this.field1326) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1518(this.field1326);
            if(var2 != null) {
               int var3 = this.field1301;
               int var4 = var2.length;
               if(var4 > this.field1302 - var3) {
                  var4 = this.field1302 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1324[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1301;
               }

               this.field1301 = var3;
            }
         }

         this.field1311 = null;
         byte[] var7 = this.field1324;
         this.field1324 = null;
         return new class62(this.field1294, var7, this.field1312, this.field1297, this.field1298);
      }
   }

   @ObfuscatedName("k")
   static class70 method1522(class167 var0, int var1, int var2) {
      if(!method1514(var0)) {
         var0.method3272(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3239(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   @ObfuscatedName("s")
   static float method1527(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   class70(byte[] var1) {
      this.method1516(var1);
   }

   @ObfuscatedName("p")
   static int method1535() {
      int var0 = field1299[field1309] >> field1308 & 1;
      ++field1308;
      field1309 += field1308 >> 3;
      field1308 &= 7;
      return var0;
   }
}

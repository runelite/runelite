import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class70 extends class208 {
   @ObfuscatedName("s")
   int field1259;
   @ObfuscatedName("e")
   byte[][] field1260;
   @ObfuscatedName("f")
   int field1261;
   @ObfuscatedName("x")
   float[] field1262;
   @ObfuscatedName("p")
   int field1263;
   @ObfuscatedName("i")
   static class60[] field1264;
   @ObfuscatedName("w")
   int field1265;
   @ObfuscatedName("u")
   boolean field1266;
   @ObfuscatedName("r")
   static int field1267;
   @ObfuscatedName("q")
   int field1268;
   @ObfuscatedName("m")
   static int field1269;
   @ObfuscatedName("v")
   static float[] field1270;
   @ObfuscatedName("y")
   static class67[] field1271;
   @ObfuscatedName("ai")
   static float[] field1272;
   @ObfuscatedName("a")
   static int field1273;
   @ObfuscatedName("l")
   static boolean[] field1274;
   @ObfuscatedName("o")
   static int[] field1275;
   @ObfuscatedName("c")
   static boolean field1276 = false;
   @ObfuscatedName("k")
   static int field1277;
   @ObfuscatedName("b")
   int field1278;
   @ObfuscatedName("n")
   static class73[] field1279;
   @ObfuscatedName("aq")
   static float[] field1280;
   @ObfuscatedName("t")
   static float[] field1281;
   @ObfuscatedName("d")
   static float[] field1282;
   @ObfuscatedName("z")
   static float[] field1283;
   @ObfuscatedName("h")
   boolean field1284;
   @ObfuscatedName("g")
   static byte[] field1285;
   @ObfuscatedName("ap")
   static float[] field1286;
   @ObfuscatedName("az")
   static int[] field1287;
   @ObfuscatedName("ae")
   static int[] field1288;
   @ObfuscatedName("j")
   static class68[] field1289;
   @ObfuscatedName("ah")
   byte[] field1290;
   @ObfuscatedName("ar")
   int field1291;
   @ObfuscatedName("ab")
   int field1292;

   @ObfuscatedName("r")
   static class70 method1531(class167 var0, int var1, int var2) {
      if(!method1538(var0)) {
         var0.method3264(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3280(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   @ObfuscatedName("w")
   static void method1532(byte[] var0, int var1) {
      field1285 = var0;
      field1273 = var1;
      field1267 = 0;
   }

   @ObfuscatedName("p")
   void method1535(byte[] var1) {
      class119 var2 = new class119(var1);
      this.field1265 = var2.method2528();
      this.field1261 = var2.method2528();
      this.field1259 = var2.method2528();
      this.field1263 = var2.method2528();
      if(this.field1263 < 0) {
         this.field1263 = ~this.field1263;
         this.field1284 = true;
      }

      int var3 = var2.method2528();
      this.field1260 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2523();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2709(var7, 0, var5);
         this.field1260[var4] = var7;
      }

   }

   @ObfuscatedName("h")
   static void method1536(byte[] var0) {
      method1532(var0, 0);
      field1277 = 1 << method1555(4);
      field1269 = 1 << method1555(4);
      field1281 = new float[field1269];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1269:field1277;
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
         int var10 = class124.method2788(var5 - 1);

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
            field1280 = var6;
            field1286 = var19;
            field1272 = var20;
            field1287 = var21;
         } else {
            field1282 = var6;
            field1283 = var19;
            field1270 = var20;
            field1288 = var21;
         }
      }

      var1 = method1555(8) + 1;
      field1279 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1279[var2] = new class73();
      }

      var2 = method1555(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1555(16);
      }

      var2 = method1555(6) + 1;
      field1271 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1271[var3] = new class67();
      }

      var3 = method1555(6) + 1;
      field1264 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1264[var4] = new class60();
      }

      var4 = method1555(6) + 1;
      field1289 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1289[var5] = new class68();
      }

      var5 = method1555(6) + 1;
      field1274 = new boolean[var5];
      field1275 = new int[var5];

      for(int var18 = 0; var18 < var5; ++var18) {
         field1274[var18] = method1559() != 0;
         method1555(16);
         method1555(16);
         field1275[var18] = method1555(8);
      }

   }

   @ObfuscatedName("g")
   float[] method1537(int var1) {
      method1532(this.field1260[var1], 0);
      method1559();
      int var2 = method1555(class124.method2788(field1275.length - 1));
      boolean var3 = field1274[var2];
      int var4 = var3?field1269:field1277;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1559() != 0;
         var6 = method1559() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1277 >> 2);
         var9 = (var4 >> 2) + (field1277 >> 2);
         var10 = field1277 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1277 >> 2);
         var12 = var4 - (var4 >> 2) + (field1277 >> 2);
         var13 = field1277 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1289[field1275[var2]];
      int var16 = var14.field1252;
      int var17 = var14.field1253[var16];
      boolean var15 = !field1271[var17].method1492();
      boolean var40 = var15;

      for(var17 = 0; var17 < var14.field1254; ++var17) {
         class60 var18 = field1264[var14.field1251[var17]];
         float[] var19 = field1281;
         var18.method1267(var19, var4 >> 1, var40);
      }

      int var41;
      if(!var15) {
         var17 = var14.field1252;
         var41 = var14.field1253[var17];
         field1271[var41].method1493(field1281, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1281[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1281;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var46 = var3?field1280:field1282;
         float[] var22 = var3?field1286:field1283;
         float[] var23 = var3?field1272:field1270;
         int[] var24 = var3?field1287:field1288;

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

         var25 = class124.method2788(var4 - 1);

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
            field1281[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1281[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1278 > 0) {
         var41 = this.field1278 + var4 >> 2;
         var43 = new float[var41];
         int var45;
         if(!this.field1266) {
            for(var42 = 0; var42 < this.field1268; ++var42) {
               var45 = (this.field1278 >> 1) + var42;
               var43[var42] += this.field1262[var45];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var45 = var43.length - (var4 >> 1) + var42;
               var43[var45] += field1281[var42];
            }
         }
      }

      float[] var44 = this.field1262;
      this.field1262 = field1281;
      field1281 = var44;
      this.field1278 = var4;
      this.field1268 = var12 - (var4 >> 1);
      this.field1266 = var15;
      return var43;
   }

   @ObfuscatedName("a")
   static boolean method1538(class167 var0) {
      if(!field1276) {
         byte[] var1 = var0.method3280(0, 0);
         if(var1 == null) {
            return false;
         }

         method1536(var1);
         field1276 = true;
      }

      return true;
   }

   @ObfuscatedName("k")
   class62 method1541(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1290 == null) {
            this.field1278 = 0;
            this.field1262 = new float[field1269];
            this.field1290 = new byte[this.field1261];
            this.field1291 = 0;
            this.field1292 = 0;
         }

         for(; this.field1292 < this.field1260.length; ++this.field1292) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1537(this.field1292);
            if(var2 != null) {
               int var3 = this.field1291;
               int var4 = var2.length;
               if(var4 > this.field1261 - var3) {
                  var4 = this.field1261 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1290[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1291;
               }

               this.field1291 = var3;
            }
         }

         this.field1262 = null;
         byte[] var7 = this.field1290;
         this.field1290 = null;
         return new class62(this.field1265, var7, this.field1259, this.field1263, this.field1284);
      }
   }

   @ObfuscatedName("e")
   static float method1544(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   class70(byte[] var1) {
      this.method1535(var1);
   }

   @ObfuscatedName("s")
   static int method1555(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1267; var0 -= var3) {
         var3 = 8 - field1267;
         int var4 = (1 << var3) - 1;
         var1 += (field1285[field1273] >> field1267 & var4) << var2;
         field1267 = 0;
         ++field1273;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1285[field1273] >> field1267 & var3) << var2;
         field1267 += var0;
      }

      return var1;
   }

   @ObfuscatedName("f")
   static int method1559() {
      int var0 = field1285[field1273] >> field1267 & 1;
      ++field1267;
      field1273 += field1267 >> 3;
      field1267 &= 7;
      return var0;
   }
}

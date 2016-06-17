import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class70 extends class208 {
   @ObfuscatedName("s")
   static float[] field1255;
   @ObfuscatedName("g")
   int field1256;
   @ObfuscatedName("ae")
   static int[] field1257;
   @ObfuscatedName("d")
   int field1258;
   @ObfuscatedName("x")
   int field1259;
   @ObfuscatedName("y")
   boolean field1260;
   @ObfuscatedName("i")
   static float[] field1261;
   @ObfuscatedName("c")
   static int field1262;
   @ObfuscatedName("l")
   static int field1263;
   @ObfuscatedName("u")
   static int field1264;
   @ObfuscatedName("n")
   static class73[] field1265;
   @ObfuscatedName("j")
   int field1266;
   @ObfuscatedName("w")
   static class67[] field1267;
   @ObfuscatedName("z")
   static class60[] field1268;
   @ObfuscatedName("b")
   byte[][] field1269;
   @ObfuscatedName("r")
   static byte[] field1270;
   @ObfuscatedName("t")
   static int[] field1271;
   @ObfuscatedName("h")
   static boolean field1272 = false;
   @ObfuscatedName("v")
   float[] field1273;
   @ObfuscatedName("an")
   static float[] field1274;
   @ObfuscatedName("f")
   int field1275;
   @ObfuscatedName("a")
   int field1276;
   @ObfuscatedName("m")
   static float[] field1277;
   @ObfuscatedName("ag")
   static float[] field1278;
   @ObfuscatedName("o")
   static boolean[] field1279;
   @ObfuscatedName("e")
   static float[] field1280;
   @ObfuscatedName("aw")
   static float[] field1281;
   @ObfuscatedName("k")
   static class68[] field1282;
   @ObfuscatedName("q")
   boolean field1283;
   @ObfuscatedName("p")
   static int field1284;
   @ObfuscatedName("aj")
   static int[] field1285;
   @ObfuscatedName("ah")
   byte[] field1286;
   @ObfuscatedName("af")
   int field1287;
   @ObfuscatedName("az")
   int field1288;

   @ObfuscatedName("d")
   static int method1544(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1263; var0 -= var3) {
         var3 = 8 - field1263;
         int var4 = (1 << var3) - 1;
         var1 += (field1270[field1262] >> field1263 & var4) << var2;
         field1263 = 0;
         ++field1262;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1270[field1262] >> field1263 & var3) << var2;
         field1263 += var0;
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1545(byte[] var0, int var1) {
      field1270 = var0;
      field1262 = var1;
      field1263 = 0;
   }

   @ObfuscatedName("j")
   static int method1546() {
      int var0 = field1270[field1262] >> field1263 & 1;
      ++field1263;
      field1262 += field1263 >> 3;
      field1263 &= 7;
      return var0;
   }

   @ObfuscatedName("y")
   static void method1549(byte[] var0) {
      method1545(var0, 0);
      field1264 = 1 << method1544(4);
      field1284 = 1 << method1544(4);
      field1277 = new float[field1284];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1284:field1264;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var18 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var18[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var18[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var19 = new float[var4];

         for(int var20 = 0; var20 < var5; ++var20) {
            var19[2 * var20] = (float)Math.cos((double)(4 * var20 + 2) * 3.141592653589793D / (double)var2);
            var19[2 * var20 + 1] = -((float)Math.sin((double)(4 * var20 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class39.method795(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var9[var11] = var17;
         }

         if(var1 != 0) {
            field1281 = var6;
            field1274 = var18;
            field1278 = var19;
            field1285 = var9;
         } else {
            field1255 = var6;
            field1261 = var18;
            field1280 = var19;
            field1257 = var9;
         }
      }

      var1 = method1544(8) + 1;
      field1265 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1265[var2] = new class73();
      }

      var2 = method1544(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1544(16);
      }

      var2 = method1544(6) + 1;
      field1267 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1267[var3] = new class67();
      }

      var3 = method1544(6) + 1;
      field1268 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1268[var4] = new class60();
      }

      var4 = method1544(6) + 1;
      field1282 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1282[var5] = new class68();
      }

      var5 = method1544(6) + 1;
      field1279 = new boolean[var5];
      field1271 = new int[var5];

      for(int var21 = 0; var21 < var5; ++var21) {
         field1279[var21] = method1546() != 0;
         method1544(16);
         method1544(16);
         field1271[var21] = method1544(8);
      }

   }

   @ObfuscatedName("c")
   static boolean method1551(class167 var0) {
      if(!field1272) {
         byte[] var1 = var0.method3266(0, 0);
         if(var1 == null) {
            return false;
         }

         method1549(var1);
         field1272 = true;
      }

      return true;
   }

   @ObfuscatedName("l")
   static class70 method1552(class167 var0, int var1, int var2) {
      if(!method1551(var0)) {
         var0.method3268(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3266(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   class70(byte[] var1) {
      this.method1563(var1);
   }

   @ObfuscatedName("u")
   class62 method1553(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1286 == null) {
            this.field1276 = 0;
            this.field1273 = new float[field1284];
            this.field1286 = new byte[this.field1266];
            this.field1287 = 0;
            this.field1288 = 0;
         }

         for(; this.field1288 < this.field1269.length; ++this.field1288) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1578(this.field1288);
            if(var2 != null) {
               int var3 = this.field1287;
               int var4 = var2.length;
               if(var4 > this.field1266 - var3) {
                  var4 = this.field1266 - var3;
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

         this.field1273 = null;
         byte[] var7 = this.field1286;
         this.field1286 = null;
         return new class62(this.field1256, var7, this.field1258, this.field1259, this.field1260);
      }
   }

   @ObfuscatedName("x")
   void method1563(byte[] var1) {
      class119 var2 = new class119(var1);
      this.field1256 = var2.method2519();
      this.field1266 = var2.method2519();
      this.field1258 = var2.method2519();
      this.field1259 = var2.method2519();
      if(this.field1259 < 0) {
         this.field1259 = ~this.field1259;
         this.field1260 = true;
      }

      int var3 = var2.method2519();
      this.field1269 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.method2514();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2525(var6, 0, var5);
         this.field1269[var4] = var6;
      }

   }

   @ObfuscatedName("b")
   static float method1566(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   float[] method1578(int var1) {
      method1545(this.field1269[var1], 0);
      method1546();
      int var2 = method1544(class39.method795(field1271.length - 1));
      boolean var3 = field1279[var2];
      int var4 = var3?field1284:field1264;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1546() != 0;
         var6 = method1546() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1264 >> 2);
         var9 = (var4 >> 2) + (field1264 >> 2);
         var10 = field1264 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1264 >> 2);
         var12 = var4 - (var4 >> 2) + (field1264 >> 2);
         var13 = field1264 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1282[field1271[var2]];
      int var16 = var14.field1248;
      int var17 = var14.field1249[var16];
      boolean var15 = !field1267[var17].method1514();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1247; ++var17) {
         class60 var18 = field1268[var14.field1250[var17]];
         float[] var40 = field1277;
         var18.method1279(var40, var4 >> 1, var45);
      }

      int var41;
      if(!var15) {
         var17 = var14.field1248;
         var41 = var14.field1249[var17];
         field1267[var41].method1498(field1277, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1277[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1277;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var43 = var3?field1281:field1255;
         float[] var22 = var3?field1274:field1261;
         float[] var23 = var3?field1278:field1280;
         int[] var24 = var3?field1285:field1257;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var41; ++var25) {
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
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var43[var17 - 4 - 4 * var25];
            var31 = var43[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class39.method795(var4 - 1);

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
                  float var38 = var43[var32 * var49];
                  float var39 = var43[var32 * var49 + 1];
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
            var20[var4 - var41 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var41 - 2 - 2 * var47] = var20[4 * var47 + 3];
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
            field1277[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1277[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var42 = null;
      if(this.field1276 > 0) {
         var41 = this.field1276 + var4 >> 2;
         var42 = new float[var41];
         int var44;
         if(!this.field1283) {
            for(var19 = 0; var19 < this.field1275; ++var19) {
               var44 = (this.field1276 >> 1) + var19;
               var42[var19] += this.field1273[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var42.length - (var4 >> 1) + var19;
               var42[var44] += field1277[var19];
            }
         }
      }

      float[] var46 = this.field1273;
      this.field1273 = field1277;
      field1277 = var46;
      this.field1276 = var4;
      this.field1275 = var12 - (var4 >> 1);
      this.field1283 = var15;
      return var42;
   }
}

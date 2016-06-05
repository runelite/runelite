import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class70 extends class208 {
   @ObfuscatedName("u")
   static boolean field1291 = false;
   @ObfuscatedName("i")
   int field1292;
   @ObfuscatedName("o")
   static class60[] field1293;
   @ObfuscatedName("b")
   static class68[] field1294;
   @ObfuscatedName("h")
   int field1295;
   @ObfuscatedName("r")
   boolean field1296;
   @ObfuscatedName("f")
   static byte[] field1297;
   @ObfuscatedName("s")
   static int field1298;
   @ObfuscatedName("d")
   static int field1299;
   @ObfuscatedName("l")
   static int field1300;
   @ObfuscatedName("q")
   int field1301;
   @ObfuscatedName("p")
   static class73[] field1302;
   @ObfuscatedName("k")
   static class67[] field1303;
   @ObfuscatedName("aq")
   int field1304;
   @ObfuscatedName("x")
   boolean field1305;
   @ObfuscatedName("j")
   static boolean[] field1306;
   @ObfuscatedName("z")
   int field1307;
   @ObfuscatedName("ad")
   static float[] field1308;
   @ObfuscatedName("ay")
   int field1309;
   @ObfuscatedName("n")
   int field1310;
   @ObfuscatedName("av")
   static int[] field1311;
   @ObfuscatedName("c")
   float[] field1312;
   @ObfuscatedName("v")
   static float[] field1313;
   @ObfuscatedName("m")
   static float[] field1314;
   @ObfuscatedName("y")
   static int field1315;
   @ObfuscatedName("e")
   static float[] field1316;
   @ObfuscatedName("w")
   static float[] field1317;
   @ObfuscatedName("as")
   static float[] field1318;
   @ObfuscatedName("ag")
   static float[] field1319;
   @ObfuscatedName("al")
   static int[] field1320;
   @ObfuscatedName("a")
   static int[] field1321;
   @ObfuscatedName("ar")
   byte[] field1322;
   @ObfuscatedName("t")
   byte[][] field1323;
   @ObfuscatedName("g")
   int field1324;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1485(byte[] var0, int var1) {
      field1297 = var0;
      field1298 = var1;
      field1299 = 0;
   }

   @ObfuscatedName("l")
   class62 method1486(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1322 == null) {
            this.field1310 = 0;
            this.field1312 = new float[field1315];
            this.field1322 = new byte[this.field1324];
            this.field1309 = 0;
            this.field1304 = 0;
         }

         for(; this.field1304 < this.field1323.length; ++this.field1304) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1490(this.field1304);
            if(var2 != null) {
               int var3 = this.field1309;
               int var4 = var2.length;
               if(var4 > this.field1324 - var3) {
                  var4 = this.field1324 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1322[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1309;
               }

               this.field1309 = var3;
            }
         }

         this.field1312 = null;
         byte[] var7 = this.field1322;
         this.field1322 = null;
         return new class62(this.field1292, var7, this.field1295, this.field1307, this.field1296);
      }
   }

   @ObfuscatedName("h")
   static int method1487(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1299; var0 -= var3) {
         var3 = 8 - field1299;
         int var4 = (1 << var3) - 1;
         var1 += (field1297[field1298] >> field1299 & var4) << var2;
         field1299 = 0;
         ++field1298;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1297[field1298] >> field1299 & var3) << var2;
         field1299 += var0;
      }

      return var1;
   }

   @ObfuscatedName("r")
   static void method1489(byte[] var0) {
      method1485(var0, 0);
      field1300 = 1 << method1487(4);
      field1315 = 1 << method1487(4);
      field1313 = new float[field1315];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1315:field1300;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var12 = 0; var12 < var4; ++var12) {
            var6[2 * var12] = (float)Math.cos((double)(4 * var12) * 3.141592653589793D / (double)var2);
            var6[2 * var12 + 1] = -((float)Math.sin((double)(4 * var12) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var13 = 0; var13 < var4; ++var13) {
            var7[2 * var13] = (float)Math.cos((double)(2 * var13 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var13 + 1] = (float)Math.sin((double)(2 * var13 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var8 = new float[var4];

         for(int var14 = 0; var14 < var5; ++var14) {
            var8[2 * var14] = (float)Math.cos((double)(4 * var14 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var14 + 1] = -((float)Math.sin((double)(4 * var14 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class119.method2666(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = class39.method786(var11, var10);
         }

         if(var1 != 0) {
            field1308 = var6;
            field1318 = var7;
            field1319 = var8;
            field1311 = var9;
         } else {
            field1314 = var6;
            field1317 = var7;
            field1316 = var8;
            field1320 = var9;
         }
      }

      var1 = method1487(8) + 1;
      field1302 = new class73[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1302[var2] = new class73();
      }

      var2 = method1487(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1487(16);
      }

      var2 = method1487(6) + 1;
      field1303 = new class67[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1303[var3] = new class67();
      }

      var3 = method1487(6) + 1;
      field1293 = new class60[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1293[var4] = new class60();
      }

      var4 = method1487(6) + 1;
      field1294 = new class68[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1294[var5] = new class68();
      }

      var5 = method1487(6) + 1;
      field1306 = new boolean[var5];
      field1321 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1306[var15] = method1505() != 0;
         method1487(16);
         method1487(16);
         field1321[var15] = method1487(8);
      }

   }

   @ObfuscatedName("f")
   float[] method1490(int var1) {
      method1485(this.field1323[var1], 0);
      method1505();
      int var2 = method1487(class119.method2666(field1321.length - 1));
      boolean var3 = field1306[var2];
      int var4 = var3?field1315:field1300;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1505() != 0;
         var6 = method1505() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1300 >> 2);
         var9 = (var4 >> 2) + (field1300 >> 2);
         var10 = field1300 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1300 >> 2);
         var12 = var4 - (var4 >> 2) + (field1300 >> 2);
         var13 = field1300 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class68 var14 = field1294[field1321[var2]];
      int var16 = var14.field1284;
      int var17 = var14.field1285[var16];
      boolean var15 = !field1303[var17].method1449();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1286; ++var17) {
         class60 var43 = field1293[var14.field1283[var17]];
         float[] var42 = field1313;
         var43.method1229(var42, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1284;
         var18 = var14.field1285[var17];
         field1303[var18].method1445(field1313, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1313[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field1313;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var40[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var40[var21] = -var40[var4 - var21 - 1];
         }

         float[] var44 = var3?field1308:field1314;
         float[] var22 = var3?field1318:field1317;
         float[] var23 = var3?field1319:field1316;
         int[] var24 = var3?field1311:field1320;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var40[4 * var25] - var40[var4 - 4 * var25 - 1];
            var27 = var40[4 * var25 + 2] - var40[var4 - 4 * var25 - 3];
            var28 = var44[2 * var25];
            var29 = var44[2 * var25 + 1];
            var40[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var40[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var40[var17 + 3 + 4 * var25];
            var27 = var40[var17 + 1 + 4 * var25];
            var28 = var40[4 * var25 + 3];
            var29 = var40[4 * var25 + 1];
            var40[var17 + 3 + 4 * var25] = var26 + var28;
            var40[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var44[var17 - 4 - 4 * var25];
            var31 = var44[var17 - 3 - 4 * var25];
            var40[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class119.method2666(var4 - 1);

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
                  float var34 = var40[var50 - 1 - var33];
                  float var35 = var40[var50 - 3 - var33];
                  float var36 = var40[var51 - 1 - var33];
                  float var37 = var40[var51 - 3 - var33];
                  var40[var50 - 1 - var33] = var34 + var36;
                  var40[var50 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var48];
                  float var39 = var44[var32 * var48 + 1];
                  var40[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var40[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var19 - 1; ++var46) {
            var47 = var24[var46];
            if(var46 < var47) {
               var48 = 8 * var46;
               var49 = 8 * var47;
               var30 = var40[var48 + 1];
               var40[var48 + 1] = var40[var49 + 1];
               var40[var49 + 1] = var30;
               var30 = var40[var48 + 3];
               var40[var48 + 3] = var40[var49 + 3];
               var40[var49 + 3] = var30;
               var30 = var40[var48 + 5];
               var40[var48 + 5] = var40[var49 + 5];
               var40[var49 + 5] = var30;
               var30 = var40[var48 + 7];
               var40[var48 + 7] = var40[var49 + 7];
               var40[var49 + 7] = var30;
            }
         }

         for(var46 = 0; var46 < var17; ++var46) {
            var40[var46] = var40[2 * var46 + 1];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var40[var4 - 1 - 2 * var46] = var40[4 * var46];
            var40[var4 - 2 - 2 * var46] = var40[4 * var46 + 1];
            var40[var4 - var18 - 1 - 2 * var46] = var40[4 * var46 + 2];
            var40[var4 - var18 - 2 - 2 * var46] = var40[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var27 = var23[2 * var46];
            var28 = var23[2 * var46 + 1];
            var29 = var40[var17 + 2 * var46];
            var30 = var40[var17 + 2 * var46 + 1];
            var31 = var40[var4 - 2 - 2 * var46];
            float var52 = var40[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var40[var17 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var40[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var40[var17 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var40[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[2 * var46 + var17] * var22[2 * var46] + var40[2 * var46 + 1 + var17] * var22[2 * var46 + 1];
            var40[var17 - 1 - var46] = var40[2 * var46 + var17] * var22[2 * var46 + 1] - var40[2 * var46 + 1 + var17] * var22[2 * var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var4 - var18 + var46] = -var40[var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[var18 + var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var18 + var46] = -var40[var18 - var46 - 1];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var17 + var46] = var40[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1313[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1313[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1310 > 0) {
         var18 = this.field1310 + var4 >> 2;
         var41 = new float[var18];
         int var20;
         if(!this.field1305) {
            for(var19 = 0; var19 < this.field1301; ++var19) {
               var20 = (this.field1310 >> 1) + var19;
               var41[var19] += this.field1312[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var41.length - (var4 >> 1) + var19;
               var41[var20] += field1313[var19];
            }
         }
      }

      float[] var54 = this.field1312;
      this.field1312 = field1313;
      field1313 = var54;
      this.field1310 = var4;
      this.field1301 = var12 - (var4 >> 1);
      this.field1305 = var15;
      return var41;
   }

   @ObfuscatedName("t")
   static float method1491(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("d")
   static class70 method1492(class167 var0, int var1, int var2) {
      if(!method1497(var0)) {
         var0.method3259(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3221(var1, var2);
         return var3 == null?null:new class70(var3);
      }
   }

   class70(byte[] var1) {
      this.method1511(var1);
   }

   @ObfuscatedName("s")
   static boolean method1497(class167 var0) {
      if(!field1291) {
         byte[] var1 = var0.method3221(0, 0);
         if(var1 == null) {
            return false;
         }

         method1489(var1);
         field1291 = true;
      }

      return true;
   }

   @ObfuscatedName("g")
   static int method1505() {
      int var0 = field1297[field1298] >> field1299 & 1;
      ++field1299;
      field1298 += field1299 >> 3;
      field1299 &= 7;
      return var0;
   }

   @ObfuscatedName("z")
   void method1511(byte[] var1) {
      class119 var2 = new class119(var1);
      this.field1292 = var2.method2505();
      this.field1324 = var2.method2505();
      this.field1295 = var2.method2505();
      this.field1307 = var2.method2505();
      if(this.field1307 < 0) {
         this.field1307 = ~this.field1307;
         this.field1296 = true;
      }

      int var3 = var2.method2505();
      this.field1323 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method2494();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2479(var7, 0, var5);
         this.field1323[var4] = var7;
      }

   }
}

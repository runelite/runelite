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

         float[] var16 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var16[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var16[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var17 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var17[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var17[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var18 = new int[var5];
         int var10 = class175.method3430(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var12 = var11;
            int var13 = var10;

            int var14;
            for(var14 = 0; var13 > 0; --var13) {
               var14 = var14 << 1 | var12 & 1;
               var12 >>>= 1;
            }

            var18[var11] = var14;
         }

         if(var1 != 0) {
            field1319 = var6;
            field1320 = var16;
            field1321 = var17;
            field1323 = var18;
         } else {
            field1295 = var6;
            field1317 = var16;
            field1304 = var17;
            field1296 = var18;
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

      for(int var15 = 0; var15 < var5; ++var15) {
         field1307[var15] = method1535() != 0;
         method1515(16);
         method1515(16);
         field1322[var15] = method1515(8);
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
      int var15 = var14.field1287;
      int var16 = var14.field1286[var15];
      boolean var17 = !field1305[var16].method1469();
      boolean var18 = var17;

      for(var16 = 0; var16 < var14.field1285; ++var16) {
         class60 var19 = field1316[var14.field1288[var16]];
         float[] var20 = field1315;
         var19.method1243(var20, var4 >> 1, var18);
      }

      int var48;
      if(!var17) {
         var16 = var14.field1287;
         var48 = var14.field1286[var16];
         field1305[var48].method1470(field1315, var4 >> 1);
      }

      float[] var21;
      int var22;
      int var49;
      if(var17) {
         for(var16 = var4 >> 1; var16 < var4; ++var16) {
            field1315[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var49 = var4 >> 3;
         var21 = field1315;

         for(var22 = 0; var22 < var16; ++var22) {
            var21[var22] *= 0.5F;
         }

         for(var22 = var16; var22 < var4; ++var22) {
            var21[var22] = -var21[var4 - var22 - 1];
         }

         float[] var23 = var3?field1319:field1295;
         float[] var24 = var3?field1320:field1317;
         float[] var25 = var3?field1321:field1304;
         int[] var26 = var3?field1323:field1296;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for(var27 = 0; var27 < var48; ++var27) {
            var28 = var21[4 * var27] - var21[var4 - 4 * var27 - 1];
            var29 = var21[4 * var27 + 2] - var21[var4 - 4 * var27 - 3];
            var30 = var23[2 * var27];
            var31 = var23[2 * var27 + 1];
            var21[var4 - 4 * var27 - 1] = var28 * var30 - var29 * var31;
            var21[var4 - 4 * var27 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for(var27 = 0; var27 < var49; ++var27) {
            var28 = var21[var16 + 3 + 4 * var27];
            var29 = var21[var16 + 1 + 4 * var27];
            var30 = var21[4 * var27 + 3];
            var31 = var21[4 * var27 + 1];
            var21[var16 + 3 + 4 * var27] = var28 + var30;
            var21[var16 + 1 + 4 * var27] = var29 + var31;
            var32 = var23[var16 - 4 - 4 * var27];
            var33 = var23[var16 - 3 - 4 * var27];
            var21[4 * var27 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var21[4 * var27 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = class175.method3430(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for(var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for(var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * 2 * var37;
               int var39 = var4 - var35 * (2 * var37 + 1);

               for(int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = 4 * var40;
                  float var42 = var21[var38 - 1 - var41];
                  float var43 = var21[var38 - 3 - var41];
                  float var44 = var21[var39 - 1 - var41];
                  float var45 = var21[var39 - 3 - var41];
                  var21[var38 - 1 - var41] = var42 + var44;
                  var21[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var21[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var21[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for(var34 = 1; var34 < var49 - 1; ++var34) {
            var35 = var26[var34];
            if(var34 < var35) {
               var36 = 8 * var34;
               var37 = 8 * var35;
               var32 = var21[var36 + 1];
               var21[var36 + 1] = var21[var37 + 1];
               var21[var37 + 1] = var32;
               var32 = var21[var36 + 3];
               var21[var36 + 3] = var21[var37 + 3];
               var21[var37 + 3] = var32;
               var32 = var21[var36 + 5];
               var21[var36 + 5] = var21[var37 + 5];
               var21[var37 + 5] = var32;
               var32 = var21[var36 + 7];
               var21[var36 + 7] = var21[var37 + 7];
               var21[var37 + 7] = var32;
            }
         }

         for(var34 = 0; var34 < var16; ++var34) {
            var21[var34] = var21[2 * var34 + 1];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var21[var4 - 1 - 2 * var34] = var21[4 * var34];
            var21[var4 - 2 - 2 * var34] = var21[4 * var34 + 1];
            var21[var4 - var48 - 1 - 2 * var34] = var21[4 * var34 + 2];
            var21[var4 - var48 - 2 - 2 * var34] = var21[4 * var34 + 3];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var29 = var25[2 * var34];
            var30 = var25[2 * var34 + 1];
            var31 = var21[var16 + 2 * var34];
            var32 = var21[var16 + 2 * var34 + 1];
            var33 = var21[var4 - 2 - 2 * var34];
            float var51 = var21[var4 - 1 - 2 * var34];
            float var52 = var30 * (var31 - var33) + var29 * (var32 + var51);
            var21[var16 + 2 * var34] = (var31 + var33 + var52) * 0.5F;
            var21[var4 - 2 - 2 * var34] = (var31 + var33 - var52) * 0.5F;
            var52 = var30 * (var32 + var51) - var29 * (var31 - var33);
            var21[var16 + 2 * var34 + 1] = (var32 - var51 + var52) * 0.5F;
            var21[var4 - 1 - 2 * var34] = (-var32 + var51 + var52) * 0.5F;
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[2 * var34 + var16] * var24[2 * var34] + var21[2 * var34 + 1 + var16] * var24[2 * var34 + 1];
            var21[var16 - 1 - var34] = var21[2 * var34 + var16] * var24[2 * var34 + 1] - var21[2 * var34 + 1 + var16] * var24[2 * var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var4 - var48 + var34] = -var21[var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[var48 + var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var48 + var34] = -var21[var48 - var34 - 1];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var16 + var34] = var21[var4 - var34 - 1];
         }

         for(var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1315[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for(var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1315[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var21 = null;
      if(this.field1306 > 0) {
         var48 = this.field1306 + var4 >> 2;
         var21 = new float[var48];
         if(!this.field1314) {
            for(var49 = 0; var49 < this.field1313; ++var49) {
               var22 = (this.field1306 >> 1) + var49;
               var21[var49] += this.field1311[var22];
            }
         }

         if(!var17) {
            for(var49 = var8; var49 < var4 >> 1; ++var49) {
               var22 = var21.length - (var4 >> 1) + var49;
               var21[var22] += field1315[var49];
            }
         }
      }

      float[] var50 = this.field1311;
      this.field1311 = field1315;
      field1315 = var50;
      this.field1306 = var4;
      this.field1313 = var12 - (var4 >> 1);
      this.field1314 = var17;
      return var21;
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

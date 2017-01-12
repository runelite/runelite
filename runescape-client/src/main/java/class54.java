import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class54 extends Node {
   @ObfuscatedName("aa")
   byte[] field980;
   @ObfuscatedName("x")
   int field981;
   @ObfuscatedName("aj")
   static float[] field982;
   @ObfuscatedName("a")
   int field983;
   @ObfuscatedName("n")
   static float[] field984;
   @ObfuscatedName("f")
   int field985;
   @ObfuscatedName("d")
   static byte[] field986;
   @ObfuscatedName("al")
   static float[] field987;
   @ObfuscatedName("i")
   int field988;
   @ObfuscatedName("z")
   static int field989;
   @ObfuscatedName("t")
   static int field990;
   @ObfuscatedName("m")
   static class52[] field991;
   @ObfuscatedName("e")
   static class64[] field992;
   @ObfuscatedName("q")
   static class56[] field993;
   @ObfuscatedName("v")
   static class69[] field994;
   @ObfuscatedName("j")
   static boolean[] field995;
   @ObfuscatedName("p")
   static int[] field996;
   @ObfuscatedName("u")
   byte[][] field997;
   @ObfuscatedName("r")
   float[] field998;
   @ObfuscatedName("y")
   int field999;
   @ObfuscatedName("h")
   int field1000;
   @ObfuscatedName("s")
   boolean field1001;
   @ObfuscatedName("w")
   static float[] field1002;
   @ObfuscatedName("c")
   boolean field1003;
   @ObfuscatedName("o")
   static float[] field1004;
   @ObfuscatedName("k")
   static boolean field1005 = false;
   @ObfuscatedName("b")
   static float[] field1006;
   @ObfuscatedName("ag")
   static float[] field1007;
   @ObfuscatedName("g")
   static int field1008;
   @ObfuscatedName("l")
   static int field1009;
   @ObfuscatedName("af")
   static int[] field1010;
   @ObfuscatedName("an")
   static int[] field1011;
   @ObfuscatedName("ax")
   int field1012;
   @ObfuscatedName("ai")
   int field1013;

   @ObfuscatedName("m")
   static class54 method960(class182 var0, int var1, int var2) {
      if(!method966(var0)) {
         var0.method3264(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3272(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("i")
   static int method961() {
      int var0 = field986[field1009] >> field1008 & 1;
      ++field1008;
      field1009 += field1008 >> 3;
      field1008 &= 7;
      return var0;
   }

   @ObfuscatedName("a")
   static int method962(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1008; var0 -= var3) {
         var3 = 8 - field1008;
         int var4 = (1 << var3) - 1;
         var1 += (field986[field1009] >> field1008 & var4) << var2;
         field1008 = 0;
         ++field1009;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field986[field1009] >> field1008 & var3) << var2;
         field1008 += var0;
      }

      return var1;
   }

   @ObfuscatedName("c")
   void method963(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field981 = var2.method2780();
      this.field988 = var2.method2780();
      this.field983 = var2.method2780();
      this.field985 = var2.method2780();
      if(this.field985 < 0) {
         this.field985 = ~this.field985;
         this.field1003 = true;
      }

      int var3 = var2.method2780();
      this.field997 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2974(var6, 0, var5);
         this.field997[var4] = var6;
      }

   }

   @ObfuscatedName("g")
   static void method964(byte[] var0) {
      method977(var0, 0);
      field989 = 1 << method962(4);
      field990 = 1 << method962(4);
      field1002 = new float[field990];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field990:field989;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var13 = 0; var13 < var4; ++var13) {
            var6[2 * var13] = (float)Math.cos((double)(4 * var13) * 3.141592653589793D / (double)var2);
            var6[2 * var13 + 1] = -((float)Math.sin((double)(4 * var13) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var14 = 0; var14 < var4; ++var14) {
            var7[2 * var14] = (float)Math.cos((double)(2 * var14 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var14 + 1] = (float)Math.sin((double)(2 * var14 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var8 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var8[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var12 = new int[var5];
         int var10 = GameEngine.method2160(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var12[var11] = class5.method77(var11, var10);
         }

         if(var1 != 0) {
            field982 = var6;
            field1007 = var7;
            field987 = var8;
            field1010 = var12;
         } else {
            field984 = var6;
            field1004 = var7;
            field1006 = var8;
            field1011 = var12;
         }
      }

      var1 = method962(8) + 1;
      field991 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field991[var2] = new class52();
      }

      var2 = method962(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method962(16);
      }

      var2 = method962(6) + 1;
      field993 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field993[var3] = new class56();
      }

      var3 = method962(6) + 1;
      field992 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field992[var4] = new class64();
      }

      var4 = method962(6) + 1;
      field994 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field994[var5] = new class69();
      }

      var5 = method962(6) + 1;
      field995 = new boolean[var5];
      field996 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field995[var15] = method961() != 0;
         method962(16);
         method962(16);
         field996[var15] = method962(8);
      }

   }

   @ObfuscatedName("t")
   static boolean method966(class182 var0) {
      if(!field1005) {
         byte[] var1 = var0.method3272(0, 0);
         if(var1 == null) {
            return false;
         }

         method964(var1);
         field1005 = true;
      }

      return true;
   }

   @ObfuscatedName("q")
   class55 method969(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field980 == null) {
            this.field999 = 0;
            this.field998 = new float[field990];
            this.field980 = new byte[this.field988];
            this.field1012 = 0;
            this.field1013 = 0;
         }

         for(; this.field1013 < this.field997.length; ++this.field1013) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method983(this.field1013);
            if(var2 != null) {
               int var3 = this.field1012;
               int var4 = var2.length;
               if(var4 > this.field988 - var3) {
                  var4 = this.field988 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field980[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1012;
               }

               this.field1012 = var3;
            }
         }

         this.field998 = null;
         byte[] var7 = this.field980;
         this.field980 = null;
         return new class55(this.field981, var7, this.field983, this.field985, this.field1003);
      }
   }

   class54(byte[] var1) {
      this.method963(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method977(byte[] var0, int var1) {
      field986 = var0;
      field1009 = var1;
      field1008 = 0;
   }

   @ObfuscatedName("z")
   float[] method983(int var1) {
      method977(this.field997[var1], 0);
      method961();
      int var2 = method962(GameEngine.method2160(field996.length - 1));
      boolean var3 = field995[var2];
      int var4 = var3?field990:field989;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method961() != 0;
         var6 = method961() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field989 >> 2);
         var9 = (var4 >> 2) + (field989 >> 2);
         var10 = field989 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field989 >> 2);
         var12 = var4 - (var4 >> 2) + (field989 >> 2);
         var13 = field989 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field994[field996[var2]];
      int var16 = var14.field1137;
      int var17 = var14.field1138[var16];
      boolean var15 = !field993[var17].method1004();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1139; ++var17) {
         class64 var41 = field992[var14.field1140[var17]];
         float[] var19 = field1002;
         var41.method1111(var19, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1137;
         var18 = var14.field1138[var17];
         field993[var18].method1003(field1002, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1002[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1002;

         int var40;
         for(var40 = 0; var40 < var17; ++var40) {
            var20[var40] *= 0.5F;
         }

         for(var40 = var17; var40 < var4; ++var40) {
            var20[var40] = -var20[var4 - var40 - 1];
         }

         float[] var21 = var3?field982:field984;
         float[] var22 = var3?field1007:field1004;
         float[] var23 = var3?field987:field1006;
         int[] var24 = var3?field1010:field1011;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var21[2 * var25];
            var29 = var21[2 * var25 + 1];
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
            var30 = var21[var17 - 4 - 4 * var25];
            var31 = var21[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = GameEngine.method2160(var4 - 1);

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
                  float var38 = var21[var32 * var48];
                  float var39 = var21[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var42 - 1; ++var46) {
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

         for(var46 = 0; var46 < var17; ++var46) {
            var20[var46] = var20[2 * var46 + 1];
         }

         for(var46 = 0; var46 < var42; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var42; ++var46) {
            var27 = var23[2 * var46];
            var28 = var23[2 * var46 + 1];
            var29 = var20[var17 + 2 * var46];
            var30 = var20[var17 + 2 * var46 + 1];
            var31 = var20[var4 - 2 - 2 * var46];
            float var52 = var20[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var20[var17 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var20[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var20[var17 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var20[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[2 * var46 + var17] * var22[2 * var46] + var20[2 * var46 + 1 + var17] * var22[2 * var46 + 1];
            var20[var17 - 1 - var46] = var20[2 * var46 + var17] * var22[2 * var46 + 1] - var20[2 * var46 + 1 + var17] * var22[2 * var46];
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
            var20[var17 + var46] = var20[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1002[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1002[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field999 > 0) {
         var18 = this.field999 + var4 >> 2;
         var43 = new float[var18];
         int var44;
         if(!this.field1001) {
            for(var42 = 0; var42 < this.field1000; ++var42) {
               var44 = (this.field999 >> 1) + var42;
               var43[var42] += this.field998[var44];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var44 = var43.length - (var4 >> 1) + var42;
               var43[var44] += field1002[var42];
            }
         }
      }

      float[] var54 = this.field998;
      this.field998 = field1002;
      field1002 = var54;
      this.field999 = var4;
      this.field1000 = var12 - (var4 >> 1);
      this.field1001 = var15;
      return var43;
   }

   @ObfuscatedName("u")
   static float method986(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}

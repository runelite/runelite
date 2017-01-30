import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class54 extends Node {
   @ObfuscatedName("ak")
   int field989;
   @ObfuscatedName("g")
   int field990;
   @ObfuscatedName("x")
   int field991;
   @ObfuscatedName("q")
   int field992;
   @ObfuscatedName("f")
   boolean field993;
   @ObfuscatedName("i")
   static boolean[] field994;
   @ObfuscatedName("j")
   static byte[] field995;
   @ObfuscatedName("s")
   static int field996;
   @ObfuscatedName("o")
   static int field997;
   @ObfuscatedName("aj")
   static int[] field998;
   @ObfuscatedName("c")
   static int field999;
   @ObfuscatedName("m")
   static class52[] field1000;
   @ObfuscatedName("h")
   static class56[] field1001;
   @ObfuscatedName("r")
   static class64[] field1002;
   @ObfuscatedName("u")
   static class69[] field1003;
   @ObfuscatedName("t")
   static float[] field1004;
   @ObfuscatedName("z")
   static int[] field1005;
   @ObfuscatedName("n")
   static boolean field1006 = false;
   @ObfuscatedName("w")
   float[] field1007;
   @ObfuscatedName("y")
   int field1008;
   @ObfuscatedName("p")
   byte[][] field1009;
   @ObfuscatedName("a")
   static int field1010;
   @ObfuscatedName("l")
   static float[] field1011;
   @ObfuscatedName("am")
   static float[] field1012;
   @ObfuscatedName("b")
   static float[] field1013;
   @ObfuscatedName("e")
   static float[] field1014;
   @ObfuscatedName("ai")
   static float[] field1015;
   @ObfuscatedName("d")
   int field1016;
   @ObfuscatedName("ad")
   static float[] field1017;
   @ObfuscatedName("ah")
   static int[] field1018;
   @ObfuscatedName("k")
   boolean field1019;
   @ObfuscatedName("ax")
   byte[] field1020;
   @ObfuscatedName("ar")
   int field1021;
   @ObfuscatedName("v")
   int field1022;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method963(byte[] var0, int var1) {
      field995 = var0;
      field996 = var1;
      field997 = 0;
   }

   @ObfuscatedName("x")
   static int method964() {
      int var0 = field995[field996] >> field997 & 1;
      ++field997;
      field996 += field997 >> 3;
      field997 &= 7;
      return var0;
   }

   @ObfuscatedName("q")
   static int method965(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field997; var0 -= var3) {
         var3 = 8 - field997;
         int var4 = (1 << var3) - 1;
         var1 += (field995[field996] >> field997 & var4) << var2;
         field997 = 0;
         ++field996;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field995[field996] >> field997 & var3) << var2;
         field997 += var0;
      }

      return var1;
   }

   @ObfuscatedName("d")
   void method966(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field990 = var2.method2819();
      this.field991 = var2.method2819();
      this.field992 = var2.method2819();
      this.field1016 = var2.method2819();
      if(this.field1016 < 0) {
         this.field1016 = ~this.field1016;
         this.field1019 = true;
      }

      int var3 = var2.method2819();
      this.field1009 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2824(var7, 0, var5);
         this.field1009[var4] = var7;
      }

   }

   @ObfuscatedName("s")
   static boolean method969(class182 var0) {
      if(!field1006) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method984(var1);
         field1006 = true;
      }

      return true;
   }

   class54(byte[] var1) {
      this.method966(var1);
   }

   @ObfuscatedName("a")
   class55 method973(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1020 == null) {
            this.field1008 = 0;
            this.field1007 = new float[field999];
            this.field1020 = new byte[this.field991];
            this.field989 = 0;
            this.field1021 = 0;
         }

         for(; this.field1021 < this.field1009.length; ++this.field1021) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method980(this.field1021);
            if(var2 != null) {
               int var3 = this.field989;
               int var4 = var2.length;
               if(var4 > this.field991 - var3) {
                  var4 = this.field991 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1020[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field989;
               }

               this.field989 = var3;
            }
         }

         this.field1007 = null;
         byte[] var7 = this.field1020;
         this.field1020 = null;
         return new class55(this.field990, var7, this.field992, this.field1016, this.field1019);
      }
   }

   @ObfuscatedName("p")
   static float method978(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("j")
   float[] method980(int var1) {
      method963(this.field1009[var1], 0);
      method964();
      int var2 = method965(GameEngine.method2193(field1005.length - 1));
      boolean var3 = field994[var2];
      int var4 = var3?field999:field1010;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method964() != 0;
         var6 = method964() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1010 >> 2);
         var9 = (var4 >> 2) + (field1010 >> 2);
         var10 = field1010 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1010 >> 2);
         var12 = var4 - (var4 >> 2) + (field1010 >> 2);
         var13 = field1010 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1003[field1005[var2]];
      int var16 = var14.field1146;
      int var17 = var14.field1145[var16];
      boolean var15 = !field1001[var17].method1002();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1148; ++var17) {
         class64 var18 = field1002[var14.field1147[var17]];
         float[] var41 = field1011;
         var18.method1134(var41, var4 >> 1, var45);
      }

      int var42;
      if(!var15) {
         var17 = var14.field1146;
         var42 = var14.field1145[var17];
         field1001[var42].method1003(field1011, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1011[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var42 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1011;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var40 = var3?field1015:field1004;
         float[] var22 = var3?field1012:field1013;
         float[] var23 = var3?field1017:field1014;
         int[] var24 = var3?field998:field1018;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var42; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var40[2 * var25];
            var29 = var40[2 * var25 + 1];
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
            var30 = var40[var17 - 4 - 4 * var25];
            var31 = var40[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = GameEngine.method2193(var4 - 1);

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
                  float var38 = var40[var32 * var49];
                  float var39 = var40[var32 * var49 + 1];
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
            var20[var4 - var42 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var42 - 2 - 2 * var47] = var20[4 * var47 + 3];
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

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var4 - var42 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var47] = var20[var42 + var47];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var42 + var47] = -var20[var42 - var47 - 1];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1011[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1011[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1008 > 0) {
         var42 = this.field1008 + var4 >> 2;
         var43 = new float[var42];
         int var44;
         if(!this.field993) {
            for(var19 = 0; var19 < this.field1022; ++var19) {
               var44 = (this.field1008 >> 1) + var19;
               var43[var19] += this.field1007[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var43.length - (var4 >> 1) + var19;
               var43[var44] += field1011[var19];
            }
         }
      }

      float[] var46 = this.field1007;
      this.field1007 = field1011;
      field1011 = var46;
      this.field1008 = var4;
      this.field1022 = var12 - (var4 >> 1);
      this.field993 = var15;
      return var43;
   }

   @ObfuscatedName("o")
   static class54 method983(class182 var0, int var1, int var2) {
      if(!method969(var0)) {
         var0.method3326(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("k")
   static void method984(byte[] var0) {
      method963(var0, 0);
      field1010 = 1 << method965(4);
      field999 = 1 << method965(4);
      field1011 = new float[field999];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field999:field1010;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var18 = new float[var3];

         for(int var19 = 0; var19 < var4; ++var19) {
            var18[2 * var19] = (float)Math.cos((double)(4 * var19) * 3.141592653589793D / (double)var2);
            var18[2 * var19 + 1] = -((float)Math.sin((double)(4 * var19) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var21 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var21[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var21[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var20 = new int[var5];
         int var10 = GameEngine.method2193(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var20[var11] = var17;
         }

         if(var1 != 0) {
            field1015 = var18;
            field1012 = var7;
            field1017 = var21;
            field998 = var20;
         } else {
            field1004 = var18;
            field1013 = var7;
            field1014 = var21;
            field1018 = var20;
         }
      }

      var1 = method965(8) + 1;
      field1000 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1000[var2] = new class52();
      }

      var2 = method965(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method965(16);
      }

      var2 = method965(6) + 1;
      field1001 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1001[var3] = new class56();
      }

      var3 = method965(6) + 1;
      field1002 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1002[var4] = new class64();
      }

      var4 = method965(6) + 1;
      field1003 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1003[var5] = new class69();
      }

      var5 = method965(6) + 1;
      field994 = new boolean[var5];
      field1005 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field994[var6] = method964() != 0;
         method965(16);
         method965(16);
         field1005[var6] = method965(8);
      }

   }
}

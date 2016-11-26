import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class54 extends Node {
   @ObfuscatedName("d")
   int field979;
   @ObfuscatedName("r")
   boolean field980;
   @ObfuscatedName("m")
   int field981;
   @ObfuscatedName("h")
   int field982;
   @ObfuscatedName("ay")
   static float[] field983;
   @ObfuscatedName("u")
   static float[] field984;
   @ObfuscatedName("c")
   static byte[] field985;
   @ObfuscatedName("i")
   float[] field986;
   @ObfuscatedName("g")
   static int field987;
   @ObfuscatedName("z")
   static int field988;
   @ObfuscatedName("q")
   static int field989;
   @ObfuscatedName("y")
   static class56[] field990;
   @ObfuscatedName("k")
   static float[] field991;
   @ObfuscatedName("e")
   static class64[] field992;
   @ObfuscatedName("x")
   static class69[] field993;
   @ObfuscatedName("f")
   static boolean[] field994;
   @ObfuscatedName("s")
   static int[] field995;
   @ObfuscatedName("o")
   static boolean field996 = false;
   @ObfuscatedName("n")
   byte[][] field997;
   @ObfuscatedName("a")
   int field998;
   @ObfuscatedName("b")
   int field999;
   @ObfuscatedName("j")
   boolean field1000;
   @ObfuscatedName("as")
   static int[] field1001;
   @ObfuscatedName("v")
   static float[] field1002;
   @ObfuscatedName("w")
   int field1003;
   @ObfuscatedName("t")
   static float[] field1004;
   @ObfuscatedName("av")
   static float[] field1005;
   @ObfuscatedName("aw")
   static float[] field1006;
   @ObfuscatedName("aq")
   byte[] field1007;
   @ObfuscatedName("p")
   static int field1008;
   @ObfuscatedName("ai")
   static int[] field1009;
   @ObfuscatedName("l")
   static class52[] field1010;
   @ObfuscatedName("ac")
   int field1011;
   @ObfuscatedName("ae")
   int field1012;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method984(byte[] var0, int var1) {
      field985 = var0;
      field1008 = var1;
      field987 = 0;
   }

   @ObfuscatedName("m")
   static int method985() {
      int var0 = field985[field1008] >> field987 & 1;
      ++field987;
      field1008 += field987 >> 3;
      field987 &= 7;
      return var0;
   }

   @ObfuscatedName("r")
   static void method987(byte[] var0) {
      method984(var0, 0);
      field988 = 1 << method992(4);
      field989 = 1 << method992(4);
      field991 = new float[field989];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field989:field988;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var18 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var18[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var18[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var19 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var19[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var19[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var20 = new float[var4];

         for(int var21 = 0; var21 < var5; ++var21) {
            var20[2 * var21] = (float)Math.cos((double)(4 * var21 + 2) * 3.141592653589793D / (double)var2);
            var20[2 * var21 + 1] = -((float)Math.sin((double)(4 * var21 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class112.method2145(var5 - 1);

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
            field1005 = var18;
            field1006 = var19;
            field983 = var20;
            field1009 = var9;
         } else {
            field1002 = var18;
            field984 = var19;
            field1004 = var20;
            field1001 = var9;
         }
      }

      var1 = method992(8) + 1;
      field1010 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1010[var2] = new class52();
      }

      var2 = method992(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method992(16);
      }

      var2 = method992(6) + 1;
      field990 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field990[var3] = new class56();
      }

      var3 = method992(6) + 1;
      field992 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field992[var4] = new class64();
      }

      var4 = method992(6) + 1;
      field993 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field993[var5] = new class69();
      }

      var5 = method992(6) + 1;
      field994 = new boolean[var5];
      field995 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field994[var6] = method985() != 0;
         method992(16);
         method992(16);
         field995[var6] = method992(8);
      }

   }

   @ObfuscatedName("c")
   float[] method988(int var1) {
      method984(this.field997[var1], 0);
      method985();
      int var2 = method992(class112.method2145(field995.length - 1));
      boolean var3 = field994[var2];
      int var4 = var3?field989:field988;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method985() != 0;
         var6 = method985() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field988 >> 2);
         var9 = (var4 >> 2) + (field988 >> 2);
         var10 = field988 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field988 >> 2);
         var12 = var4 - (var4 >> 2) + (field988 >> 2);
         var13 = field988 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field993[field995[var2]];
      int var16 = var14.field1137;
      int var17 = var14.field1140[var16];
      boolean var15 = !field990[var17].method1025();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1139; ++var17) {
         class64 var40 = field992[var14.field1138[var17]];
         float[] var19 = field991;
         var40.method1152(var19, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1137;
         var18 = var14.field1140[var17];
         field990[var18].method1027(field991, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field991[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field991;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var42 = var3?field1005:field1002;
         float[] var22 = var3?field1006:field984;
         float[] var23 = var3?field983:field1004;
         int[] var24 = var3?field1009:field1001;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var42[2 * var25];
            var29 = var42[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var42[var17 - 4 - 4 * var25];
            var31 = var42[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class112.method2145(var4 - 1);

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
                  float var38 = var42[var32 * var48];
                  float var39 = var42[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var41 - 1; ++var46) {
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

         for(var46 = 0; var46 < var41; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var41; ++var46) {
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
            field991[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field991[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var44 = null;
      if(this.field998 > 0) {
         var18 = this.field998 + var4 >> 2;
         var44 = new float[var18];
         int var43;
         if(!this.field1000) {
            for(var41 = 0; var41 < this.field999; ++var41) {
               var43 = (this.field998 >> 1) + var41;
               var44[var41] += this.field986[var43];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var43 = var44.length - (var4 >> 1) + var41;
               var44[var43] += field991[var41];
            }
         }
      }

      float[] var54 = this.field986;
      this.field986 = field991;
      field991 = var54;
      this.field998 = var4;
      this.field999 = var12 - (var4 >> 1);
      this.field1000 = var15;
      return var44;
   }

   @ObfuscatedName("z")
   static boolean method989(class182 var0) {
      if(!field996) {
         byte[] var1 = var0.method3329(0, 0);
         if(var1 == null) {
            return false;
         }

         method987(var1);
         field996 = true;
      }

      return true;
   }

   @ObfuscatedName("q")
   static class54 method990(class182 var0, int var1, int var2) {
      if(!method989(var0)) {
         var0.method3347(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3329(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method1015(var1);
   }

   @ObfuscatedName("h")
   static int method992(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field987; var0 -= var3) {
         var3 = 8 - field987;
         int var4 = (1 << var3) - 1;
         var1 += (field985[field1008] >> field987 & var4) << var2;
         field987 = 0;
         ++field1008;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field985[field1008] >> field987 & var3) << var2;
         field987 += var0;
      }

      return var1;
   }

   @ObfuscatedName("n")
   static float method1005(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("l")
   class55 method1011(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1007 == null) {
            this.field998 = 0;
            this.field986 = new float[field989];
            this.field1007 = new byte[this.field981];
            this.field1011 = 0;
            this.field1012 = 0;
         }

         for(; this.field1012 < this.field997.length; ++this.field1012) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method988(this.field1012);
            if(var2 != null) {
               int var3 = this.field1011;
               int var4 = var2.length;
               if(var4 > this.field981 - var3) {
                  var4 = this.field981 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1007[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1011;
               }

               this.field1011 = var3;
            }
         }

         this.field986 = null;
         byte[] var7 = this.field1007;
         this.field1007 = null;
         return new class55(this.field979, var7, this.field982, this.field1003, this.field980);
      }
   }

   @ObfuscatedName("w")
   void method1015(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field979 = var2.method2995();
      this.field981 = var2.method2995();
      this.field982 = var2.method2995();
      this.field1003 = var2.method2995();
      if(this.field1003 < 0) {
         this.field1003 = ~this.field1003;
         this.field980 = true;
      }

      int var3 = var2.method2995();
      this.field997 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method3043(var7, 0, var5);
         this.field997[var4] = var7;
      }

   }
}

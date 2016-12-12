import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class54 extends Node {
   @ObfuscatedName("i")
   byte[][] field988;
   @ObfuscatedName("ap")
   byte[] field989;
   @ObfuscatedName("f")
   int field990;
   @ObfuscatedName("ay")
   static int[] field991;
   @ObfuscatedName("g")
   int field992;
   @ObfuscatedName("n")
   boolean field993;
   @ObfuscatedName("a")
   static byte[] field994;
   @ObfuscatedName("q")
   static int field995;
   @ObfuscatedName("aq")
   static float[] field996;
   @ObfuscatedName("v")
   static int field997;
   @ObfuscatedName("h")
   static int field998;
   @ObfuscatedName("p")
   static class52[] field999;
   @ObfuscatedName("l")
   static class56[] field1000;
   @ObfuscatedName("c")
   static class64[] field1001;
   @ObfuscatedName("m")
   static class69[] field1002;
   @ObfuscatedName("e")
   int field1003;
   @ObfuscatedName("u")
   static int[] field1004;
   @ObfuscatedName("j")
   static boolean field1005 = false;
   @ObfuscatedName("x")
   float[] field1006;
   @ObfuscatedName("ak")
   static float[] field1007;
   @ObfuscatedName("y")
   int field1008;
   @ObfuscatedName("s")
   boolean field1009;
   @ObfuscatedName("t")
   static float[] field1010;
   @ObfuscatedName("z")
   static float[] field1011;
   @ObfuscatedName("b")
   static float[] field1012;
   @ObfuscatedName("o")
   static float[] field1013;
   @ObfuscatedName("d")
   int field1014;
   @ObfuscatedName("aw")
   int field1015;
   @ObfuscatedName("k")
   int field1016;
   @ObfuscatedName("an")
   static int[] field1017;
   @ObfuscatedName("r")
   static boolean[] field1018;
   @ObfuscatedName("w")
   static int field1019;
   @ObfuscatedName("aj")
   int field1020;
   @ObfuscatedName("ai")
   static float[] field1021;

   @ObfuscatedName("a")
   void method951(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1003 = var2.method2844();
      this.field990 = var2.method2844();
      this.field1016 = var2.method2844();
      this.field992 = var2.method2844();
      if(this.field992 < 0) {
         this.field992 = ~this.field992;
         this.field993 = true;
      }

      int var3 = var2.method2844();
      this.field988 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2770(var6, 0, var5);
         this.field988[var4] = var6;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method952(byte[] var0, int var1) {
      field994 = var0;
      field995 = var1;
      field1019 = 0;
   }

   @ObfuscatedName("k")
   static int method953(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1019; var0 -= var3) {
         var3 = 8 - field1019;
         int var4 = (1 << var3) - 1;
         var1 += (field994[field995] >> field1019 & var4) << var2;
         field1019 = 0;
         ++field995;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field994[field995] >> field1019 & var3) << var2;
         field1019 += var0;
      }

      return var1;
   }

   @ObfuscatedName("i")
   static float method954(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("w")
   float[] method955(int var1) {
      method952(this.field988[var1], 0);
      method978();
      int var2 = method953(class45.method801(field1004.length - 1));
      boolean var3 = field1018[var2];
      int var4 = var3?field998:field997;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method978() != 0;
         var6 = method978() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field997 >> 2);
         var9 = (var4 >> 2) + (field997 >> 2);
         var10 = field997 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field997 >> 2);
         var12 = var4 - (var4 >> 2) + (field997 >> 2);
         var13 = field997 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1002[field1004[var2]];
      int var16 = var14.field1150;
      int var17 = var14.field1151[var16];
      boolean var15 = !field1000[var17].method998();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1152; ++var17) {
         class64 var18 = field1001[var14.field1149[var17]];
         float[] var19 = field1010;
         var18.method1142(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1150;
         var40 = var14.field1151[var17];
         field1000[var40].method1007(field1010, var4 >> 1);
      }

      int var43;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1010[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var43 = var4 >> 3;
         float[] var20 = field1010;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1007:field1011;
         float[] var22 = var3?field1021:field1012;
         float[] var23 = var3?field996:field1013;
         int[] var24 = var3?field991:field1017;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var21[2 * var25];
            var29 = var21[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var43; ++var25) {
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

         var25 = class45.method801(var4 - 1);

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
                  float var38 = var21[var32 * var49];
                  float var39 = var21[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var43 - 1; ++var47) {
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

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var40 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var40 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var43; ++var47) {
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

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var4 - var40 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[var40 + var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var40 + var47] = -var20[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1010[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1010[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1014 > 0) {
         var40 = this.field1014 + var4 >> 2;
         var41 = new float[var40];
         int var44;
         if(!this.field1009) {
            for(var43 = 0; var43 < this.field1008; ++var43) {
               var44 = (this.field1014 >> 1) + var43;
               var41[var43] += this.field1006[var44];
            }
         }

         if(!var15) {
            for(var43 = var8; var43 < var4 >> 1; ++var43) {
               var44 = var41.length - (var4 >> 1) + var43;
               var41[var44] += field1010[var43];
            }
         }
      }

      float[] var46 = this.field1006;
      this.field1006 = field1010;
      field1010 = var46;
      this.field1014 = var4;
      this.field1008 = var12 - (var4 >> 1);
      this.field1009 = var15;
      return var41;
   }

   @ObfuscatedName("v")
   static boolean method958(class182 var0) {
      if(!field1005) {
         byte[] var1 = var0.method3211(0, 0);
         if(var1 == null) {
            return false;
         }

         method964(var1);
         field1005 = true;
      }

      return true;
   }

   @ObfuscatedName("h")
   static class54 method959(class182 var0, int var1, int var2) {
      if(!method958(var0)) {
         var0.method3213(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3211(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method951(var1);
   }

   @ObfuscatedName("p")
   class55 method960(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field989 == null) {
            this.field1014 = 0;
            this.field1006 = new float[field998];
            this.field989 = new byte[this.field990];
            this.field1020 = 0;
            this.field1015 = 0;
         }

         for(; this.field1015 < this.field988.length; ++this.field1015) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method955(this.field1015);
            if(var2 != null) {
               int var3 = this.field1020;
               int var4 = var2.length;
               if(var4 > this.field990 - var3) {
                  var4 = this.field990 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field989[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1020;
               }

               this.field1020 = var3;
            }
         }

         this.field1006 = null;
         byte[] var7 = this.field989;
         this.field989 = null;
         return new class55(this.field1003, var7, this.field1016, this.field992, this.field993);
      }
   }

   @ObfuscatedName("q")
   static void method964(byte[] var0) {
      method952(var0, 0);
      field997 = 1 << method953(4);
      field998 = 1 << method953(4);
      field1010 = new float[field998];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field998:field997;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var18 = new float[var3];

         for(int var19 = 0; var19 < var4; ++var19) {
            var18[2 * var19] = (float)Math.cos((double)(2 * var19 + 1) * 3.141592653589793D / (double)(2 * var2));
            var18[2 * var19 + 1] = (float)Math.sin((double)(2 * var19 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var8 = new float[var4];

         for(int var20 = 0; var20 < var5; ++var20) {
            var8[2 * var20] = (float)Math.cos((double)(4 * var20 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var20 + 1] = -((float)Math.sin((double)(4 * var20 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class45.method801(var5 - 1);

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
            field1007 = var6;
            field1021 = var18;
            field996 = var8;
            field991 = var9;
         } else {
            field1011 = var6;
            field1012 = var18;
            field1013 = var8;
            field1017 = var9;
         }
      }

      var1 = method953(8) + 1;
      field999 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field999[var2] = new class52();
      }

      var2 = method953(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method953(16);
      }

      var2 = method953(6) + 1;
      field1000 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1000[var3] = new class56();
      }

      var3 = method953(6) + 1;
      field1001 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1001[var4] = new class64();
      }

      var4 = method953(6) + 1;
      field1002 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1002[var5] = new class69();
      }

      var5 = method953(6) + 1;
      field1018 = new boolean[var5];
      field1004 = new int[var5];

      for(int var21 = 0; var21 < var5; ++var21) {
         field1018[var21] = method978() != 0;
         method953(16);
         method953(16);
         field1004[var21] = method953(8);
      }

   }

   @ObfuscatedName("f")
   static int method978() {
      int var0 = field994[field995] >> field1019 & 1;
      ++field1019;
      field995 += field1019 >> 3;
      field1019 &= 7;
      return var0;
   }
}

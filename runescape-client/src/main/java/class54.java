import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class54 extends Node {
   @ObfuscatedName("d")
   static int field989;
   @ObfuscatedName("y")
   int field990;
   @ObfuscatedName("x")
   static float[] field991;
   @ObfuscatedName("r")
   int field992;
   @ObfuscatedName("w")
   int field993;
   @ObfuscatedName("j")
   boolean field994;
   @ObfuscatedName("k")
   byte[][] field995;
   @ObfuscatedName("t")
   static boolean field996 = false;
   @ObfuscatedName("ah")
   static int[] field997;
   @ObfuscatedName("af")
   int field998;
   @ObfuscatedName("s")
   static int field999;
   @ObfuscatedName("g")
   static class52[] field1000;
   @ObfuscatedName("i")
   static class56[] field1001;
   @ObfuscatedName("v")
   static class64[] field1002;
   @ObfuscatedName("o")
   int field1003;
   @ObfuscatedName("h")
   static boolean[] field1004;
   @ObfuscatedName("p")
   static int[] field1005;
   @ObfuscatedName("a")
   static class69[] field1006;
   @ObfuscatedName("f")
   float[] field1007;
   @ObfuscatedName("z")
   int field1008;
   @ObfuscatedName("u")
   int field1009;
   @ObfuscatedName("aq")
   static float[] field1010;
   @ObfuscatedName("m")
   static float[] field1011;
   @ObfuscatedName("e")
   static float[] field1012;
   @ObfuscatedName("l")
   static float[] field1013;
   @ObfuscatedName("c")
   static int field1014;
   @ObfuscatedName("ap")
   static float[] field1015;
   @ObfuscatedName("aw")
   static float[] field1016;
   @ObfuscatedName("ai")
   int field1017;
   @ObfuscatedName("as")
   static int[] field1018;
   @ObfuscatedName("b")
   boolean field1019;
   @ObfuscatedName("aa")
   byte[] field1020;
   @ObfuscatedName("n")
   static int field1021;
   @ObfuscatedName("q")
   static byte[] field1022;

   @ObfuscatedName("g")
   static boolean method994(class182 var0) {
      if(!field996) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method998(var1);
         field996 = true;
      }

      return true;
   }

   @ObfuscatedName("o")
   static int method996() {
      int var0 = field1022[field989] >> field1021 & 1;
      ++field1021;
      field989 += field1021 >> 3;
      field1021 &= 7;
      return var0;
   }

   @ObfuscatedName("w")
   void method997(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field990 = var2.method3062();
      this.field1003 = var2.method3062();
      this.field992 = var2.method3062();
      this.field993 = var2.method3062();
      if(this.field993 < 0) {
         this.field993 = ~this.field993;
         this.field994 = true;
      }

      int var3 = var2.method3062();
      this.field995 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method3095(var7, 0, var5);
         this.field995[var4] = var7;
      }

   }

   @ObfuscatedName("j")
   static void method998(byte[] var0) {
      method1022(var0, 0);
      field1014 = 1 << method1006(4);
      field999 = 1 << method1006(4);
      field1011 = new float[field999];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field999:field1014;
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
         int var10 = class104.method1989(var5 - 1);

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
            field1015 = var6;
            field1010 = var18;
            field1016 = var19;
            field997 = var9;
         } else {
            field1012 = var6;
            field1013 = var18;
            field991 = var19;
            field1018 = var9;
         }
      }

      var1 = method1006(8) + 1;
      field1000 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1000[var2] = new class52();
      }

      var2 = method1006(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1006(16);
      }

      var2 = method1006(6) + 1;
      field1001 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1001[var3] = new class56();
      }

      var3 = method1006(6) + 1;
      field1002 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1002[var4] = new class64();
      }

      var4 = method1006(6) + 1;
      field1006 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1006[var5] = new class69();
      }

      var5 = method1006(6) + 1;
      field1004 = new boolean[var5];
      field1005 = new int[var5];

      for(int var21 = 0; var21 < var5; ++var21) {
         field1004[var21] = method996() != 0;
         method1006(16);
         method1006(16);
         field1005[var21] = method1006(8);
      }

   }

   @ObfuscatedName("c")
   float[] method999(int var1) {
      method1022(this.field995[var1], 0);
      method996();
      int var2 = method1006(class104.method1989(field1005.length - 1));
      boolean var3 = field1004[var2];
      int var4 = var3?field999:field1014;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method996() != 0;
         var6 = method996() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1014 >> 2);
         var9 = (var4 >> 2) + (field1014 >> 2);
         var10 = field1014 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1014 >> 2);
         var12 = var4 - (var4 >> 2) + (field1014 >> 2);
         var13 = field1014 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1006[field1005[var2]];
      int var16 = var14.field1146;
      int var41 = var14.field1148[var16];
      boolean var15 = !field1001[var41].method1045();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1147; ++var41) {
         class64 var18 = field1002[var14.field1149[var41]];
         float[] var43 = field1011;
         var18.method1178(var43, var4 >> 1, var45);
      }

      int var44;
      if(!var15) {
         var41 = var14.field1146;
         var44 = var14.field1148[var41];
         field1001[var44].method1035(field1011, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field1011[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var44 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field1011;

         int var42;
         for(var42 = 0; var42 < var41; ++var42) {
            var40[var42] *= 0.5F;
         }

         for(var42 = var41; var42 < var4; ++var42) {
            var40[var42] = -var40[var4 - var42 - 1];
         }

         float[] var21 = var3?field1015:field1012;
         float[] var22 = var3?field1010:field1013;
         float[] var23 = var3?field1016:field991;
         int[] var24 = var3?field997:field1018;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var44; ++var25) {
            var26 = var40[4 * var25] - var40[var4 - 4 * var25 - 1];
            var27 = var40[4 * var25 + 2] - var40[var4 - 4 * var25 - 3];
            var28 = var21[2 * var25];
            var29 = var21[2 * var25 + 1];
            var40[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var40[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var40[var41 + 3 + 4 * var25];
            var27 = var40[var41 + 1 + 4 * var25];
            var28 = var40[4 * var25 + 3];
            var29 = var40[4 * var25 + 1];
            var40[var41 + 3 + 4 * var25] = var26 + var28;
            var40[var41 + 1 + 4 * var25] = var27 + var29;
            var30 = var21[var41 - 4 - 4 * var25];
            var31 = var21[var41 - 3 - 4 * var25];
            var40[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class104.method1989(var4 - 1);

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
                  float var34 = var40[var51 - 1 - var33];
                  float var35 = var40[var51 - 3 - var33];
                  float var36 = var40[var52 - 1 - var33];
                  float var37 = var40[var52 - 3 - var33];
                  var40[var51 - 1 - var33] = var34 + var36;
                  var40[var51 - 3 - var33] = var35 + var37;
                  float var38 = var21[var32 * var49];
                  float var39 = var21[var32 * var49 + 1];
                  var40[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var40[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var19 - 1; ++var47) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = 8 * var47;
               var50 = 8 * var48;
               var30 = var40[var49 + 1];
               var40[var49 + 1] = var40[var50 + 1];
               var40[var50 + 1] = var30;
               var30 = var40[var49 + 3];
               var40[var49 + 3] = var40[var50 + 3];
               var40[var50 + 3] = var30;
               var30 = var40[var49 + 5];
               var40[var49 + 5] = var40[var50 + 5];
               var40[var50 + 5] = var30;
               var30 = var40[var49 + 7];
               var40[var49 + 7] = var40[var50 + 7];
               var40[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var40[var47] = var40[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var19; ++var47) {
            var40[var4 - 1 - 2 * var47] = var40[4 * var47];
            var40[var4 - 2 - 2 * var47] = var40[4 * var47 + 1];
            var40[var4 - var44 - 1 - 2 * var47] = var40[4 * var47 + 2];
            var40[var4 - var44 - 2 - 2 * var47] = var40[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var19; ++var47) {
            var27 = var23[2 * var47];
            var28 = var23[2 * var47 + 1];
            var29 = var40[var41 + 2 * var47];
            var30 = var40[var41 + 2 * var47 + 1];
            var31 = var40[var4 - 2 - 2 * var47];
            float var53 = var40[var4 - 1 - 2 * var47];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var40[var41 + 2 * var47] = (var29 + var31 + var54) * 0.5F;
            var40[var4 - 2 - 2 * var47] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var40[var41 + 2 * var47 + 1] = (var30 - var53 + var54) * 0.5F;
            var40[var4 - 1 - 2 * var47] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var44; ++var47) {
            var40[var47] = var40[2 * var47 + var41] * var22[2 * var47] + var40[2 * var47 + 1 + var41] * var22[2 * var47 + 1];
            var40[var41 - 1 - var47] = var40[2 * var47 + var41] * var22[2 * var47 + 1] - var40[2 * var47 + 1 + var41] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var44; ++var47) {
            var40[var4 - var44 + var47] = -var40[var47];
         }

         for(var47 = 0; var47 < var44; ++var47) {
            var40[var47] = var40[var44 + var47];
         }

         for(var47 = 0; var47 < var44; ++var47) {
            var40[var44 + var47] = -var40[var44 - var47 - 1];
         }

         for(var47 = 0; var47 < var44; ++var47) {
            var40[var41 + var47] = var40[var4 - var47 - 1];
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

      float[] var17 = null;
      if(this.field1008 > 0) {
         var44 = this.field1008 + var4 >> 2;
         var17 = new float[var44];
         int var20;
         if(!this.field1019) {
            for(var19 = 0; var19 < this.field1009; ++var19) {
               var20 = (this.field1008 >> 1) + var19;
               var17[var19] += this.field1007[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var17.length - (var4 >> 1) + var19;
               var17[var20] += field1011[var19];
            }
         }
      }

      float[] var46 = this.field1007;
      this.field1007 = field1011;
      field1011 = var46;
      this.field1008 = var4;
      this.field1009 = var12 - (var4 >> 1);
      this.field1019 = var15;
      return var17;
   }

   @ObfuscatedName("v")
   class55 method1002(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1020 == null) {
            this.field1008 = 0;
            this.field1007 = new float[field999];
            this.field1020 = new byte[this.field1003];
            this.field1017 = 0;
            this.field998 = 0;
         }

         for(; this.field998 < this.field995.length; ++this.field998) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method999(this.field998);
            if(var2 != null) {
               int var3 = this.field1017;
               int var4 = var2.length;
               if(var4 > this.field1003 - var3) {
                  var4 = this.field1003 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1020[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1017;
               }

               this.field1017 = var3;
            }
         }

         this.field1007 = null;
         byte[] var7 = this.field1020;
         this.field1020 = null;
         return new class55(this.field990, var7, this.field992, this.field993, this.field994);
      }
   }

   @ObfuscatedName("i")
   static class54 method1003(class182 var0, int var1, int var2) {
      if(!method994(var0)) {
         var0.method3275(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("k")
   static float method1004(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   static int method1006(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1021; var0 -= var3) {
         var3 = 8 - field1021;
         int var4 = (1 << var3) - 1;
         var1 += (field1022[field989] >> field1021 & var4) << var2;
         field1021 = 0;
         ++field989;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1022[field989] >> field1021 & var3) << var2;
         field1021 += var0;
      }

      return var1;
   }

   class54(byte[] var1) {
      this.method997(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1022(byte[] var0, int var1) {
      field1022 = var0;
      field989 = var1;
      field1021 = 0;
   }
}

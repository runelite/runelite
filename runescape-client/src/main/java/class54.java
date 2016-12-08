import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class54 extends Node {
   @ObfuscatedName("am")
   static float[] field987;
   @ObfuscatedName("m")
   int field988;
   @ObfuscatedName("av")
   byte[] field989;
   @ObfuscatedName("g")
   int field990;
   @ObfuscatedName("h")
   int field991;
   @ObfuscatedName("v")
   boolean field992;
   @ObfuscatedName("s")
   static int[] field993;
   @ObfuscatedName("c")
   static int field994;
   @ObfuscatedName("u")
   static int field995;
   @ObfuscatedName("k")
   static int field996;
   @ObfuscatedName("z")
   static int field997;
   @ObfuscatedName("x")
   static boolean field998 = false;
   @ObfuscatedName("aa")
   static int[] field999;
   @ObfuscatedName("f")
   static class64[] field1000;
   @ObfuscatedName("p")
   static class69[] field1001;
   @ObfuscatedName("i")
   static boolean[] field1002;
   @ObfuscatedName("n")
   int field1003;
   @ObfuscatedName("ah")
   int field1004;
   @ObfuscatedName("d")
   float[] field1005;
   @ObfuscatedName("w")
   int field1006;
   @ObfuscatedName("b")
   int field1007;
   @ObfuscatedName("q")
   boolean field1008;
   @ObfuscatedName("y")
   static class52[] field1009;
   @ObfuscatedName("r")
   static float[] field1010;
   @ObfuscatedName("a")
   static float[] field1011;
   @ObfuscatedName("e")
   static float[] field1012;
   @ObfuscatedName("au")
   static float[] field1013;
   @ObfuscatedName("ag")
   static float[] field1014;
   @ObfuscatedName("o")
   byte[][] field1015;
   @ObfuscatedName("l")
   static byte[] field1016;
   @ObfuscatedName("t")
   static float[] field1017;
   @ObfuscatedName("ae")
   static int[] field1018;
   @ObfuscatedName("ao")
   int field1019;
   @ObfuscatedName("j")
   static class56[] field1020;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method957(byte[] var0, int var1) {
      field1016 = var0;
      field994 = var1;
      field995 = 0;
   }

   @ObfuscatedName("b")
   static int method958() {
      int var0 = field1016[field994] >> field995 & 1;
      ++field995;
      field994 += field995 >> 3;
      field995 &= 7;
      return var0;
   }

   @ObfuscatedName("g")
   static int method959(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field995; var0 -= var3) {
         var3 = 8 - field995;
         int var4 = (1 << var3) - 1;
         var1 += (field1016[field994] >> field995 & var4) << var2;
         field995 = 0;
         ++field994;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1016[field994] >> field995 & var3) << var2;
         field995 += var0;
      }

      return var1;
   }

   @ObfuscatedName("l")
   void method960(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field988 = var2.method2731();
      this.field1007 = var2.method2731();
      this.field990 = var2.method2731();
      this.field991 = var2.method2731();
      if(this.field991 < 0) {
         this.field991 = ~this.field991;
         this.field992 = true;
      }

      int var3 = var2.method2731();
      this.field1015 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2796(var7, 0, var5);
         this.field1015[var4] = var7;
      }

   }

   @ObfuscatedName("z")
   static class54 method961(class182 var0, int var1, int var2) {
      if(!method963(var0)) {
         var0.method3205(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3203(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("k")
   static boolean method963(class182 var0) {
      if(!field998) {
         byte[] var1 = var0.method3203(0, 0);
         if(var1 == null) {
            return false;
         }

         method973(var1);
         field998 = true;
      }

      return true;
   }

   @ObfuscatedName("y")
   class55 method966(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field989 == null) {
            this.field1006 = 0;
            this.field1005 = new float[field997];
            this.field989 = new byte[this.field1007];
            this.field1019 = 0;
            this.field1004 = 0;
         }

         for(; this.field1004 < this.field1015.length; ++this.field1004) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method978(this.field1004);
            if(var2 != null) {
               int var3 = this.field1019;
               int var4 = var2.length;
               if(var4 > this.field1007 - var3) {
                  var4 = this.field1007 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field989[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1019;
               }

               this.field1019 = var3;
            }
         }

         this.field1005 = null;
         byte[] var7 = this.field989;
         this.field989 = null;
         return new class55(this.field988, var7, this.field990, this.field991, this.field992);
      }
   }

   @ObfuscatedName("c")
   static void method973(byte[] var0) {
      method957(var0, 0);
      field996 = 1 << method959(4);
      field997 = 1 << method959(4);
      field1017 = new float[field997];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field997:field996;
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

         for(int var9 = 0; var9 < var5; ++var9) {
            var8[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = CombatInfo1.method592(var5 - 1);

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
            field987 = var6;
            field1014 = var18;
            field1013 = var8;
            field1018 = var21;
         } else {
            field1010 = var6;
            field1011 = var18;
            field1012 = var8;
            field999 = var21;
         }
      }

      var1 = method959(8) + 1;
      field1009 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1009[var2] = new class52();
      }

      var2 = method959(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method959(16);
      }

      var2 = method959(6) + 1;
      field1020 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1020[var3] = new class56();
      }

      var3 = method959(6) + 1;
      field1000 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1000[var4] = new class64();
      }

      var4 = method959(6) + 1;
      field1001 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1001[var5] = new class69();
      }

      var5 = method959(6) + 1;
      field1002 = new boolean[var5];
      field993 = new int[var5];

      for(int var20 = 0; var20 < var5; ++var20) {
         field1002[var20] = method958() != 0;
         method959(16);
         method959(16);
         field993[var20] = method959(8);
      }

   }

   class54(byte[] var1) {
      this.method960(var1);
   }

   @ObfuscatedName("u")
   float[] method978(int var1) {
      method957(this.field1015[var1], 0);
      method958();
      int var2 = method959(CombatInfo1.method592(field993.length - 1));
      boolean var3 = field1002[var2];
      int var4 = var3?field997:field996;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method958() != 0;
         var6 = method958() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field996 >> 2);
         var9 = (var4 >> 2) + (field996 >> 2);
         var10 = field996 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field996 >> 2);
         var12 = var4 - (var4 >> 2) + (field996 >> 2);
         var13 = field996 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1001[field993[var2]];
      int var16 = var14.field1148;
      int var41 = var14.field1147[var16];
      boolean var15 = !field1020[var41].method1001();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1149; ++var41) {
         class64 var42 = field1000[var14.field1150[var41]];
         float[] var43 = field1017;
         var42.method1147(var43, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var41 = var14.field1148;
         var18 = var14.field1147[var41];
         field1020[var18].method1000(field1017, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field1017[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field1017;

         int var21;
         for(var21 = 0; var21 < var41; ++var21) {
            var40[var21] *= 0.5F;
         }

         for(var21 = var41; var21 < var4; ++var21) {
            var40[var21] = -var40[var4 - var21 - 1];
         }

         float[] var44 = var3?field987:field1010;
         float[] var22 = var3?field1014:field1011;
         float[] var23 = var3?field1013:field1012;
         int[] var24 = var3?field1018:field999;

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
            var26 = var40[var41 + 3 + 4 * var25];
            var27 = var40[var41 + 1 + 4 * var25];
            var28 = var40[4 * var25 + 3];
            var29 = var40[4 * var25 + 1];
            var40[var41 + 3 + 4 * var25] = var26 + var28;
            var40[var41 + 1 + 4 * var25] = var27 + var29;
            var30 = var44[var41 - 4 - 4 * var25];
            var31 = var44[var41 - 3 - 4 * var25];
            var40[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = CombatInfo1.method592(var4 - 1);

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

         for(var46 = 0; var46 < var41; ++var46) {
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
            var29 = var40[var41 + 2 * var46];
            var30 = var40[var41 + 2 * var46 + 1];
            var31 = var40[var4 - 2 - 2 * var46];
            float var52 = var40[var4 - 1 - 2 * var46];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var40[var41 + 2 * var46] = (var29 + var31 + var53) * 0.5F;
            var40[var4 - 2 - 2 * var46] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var40[var41 + 2 * var46 + 1] = (var30 - var52 + var53) * 0.5F;
            var40[var4 - 1 - 2 * var46] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[2 * var46 + var41] * var22[2 * var46] + var40[2 * var46 + 1 + var41] * var22[2 * var46 + 1];
            var40[var41 - 1 - var46] = var40[2 * var46 + var41] * var22[2 * var46 + 1] - var40[2 * var46 + 1 + var41] * var22[2 * var46];
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
            var40[var41 + var46] = var40[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1017[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1017[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1006 > 0) {
         var18 = this.field1006 + var4 >> 2;
         var17 = new float[var18];
         int var20;
         if(!this.field1008) {
            for(var19 = 0; var19 < this.field1003; ++var19) {
               var20 = (this.field1006 >> 1) + var19;
               var17[var19] += this.field1005[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var17.length - (var4 >> 1) + var19;
               var17[var20] += field1017[var19];
            }
         }
      }

      float[] var54 = this.field1005;
      this.field1005 = field1017;
      field1017 = var54;
      this.field1006 = var4;
      this.field1003 = var12 - (var4 >> 1);
      this.field1008 = var15;
      return var17;
   }

   @ObfuscatedName("o")
   static float method979(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}

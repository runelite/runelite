import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class54 extends Node {
   @ObfuscatedName("c")
   static float[] field1010;
   @ObfuscatedName("z")
   float[] field1011;
   @ObfuscatedName("ah")
   static int[] field1012;
   @ObfuscatedName("u")
   int field1013;
   @ObfuscatedName("r")
   int field1014;
   @ObfuscatedName("h")
   int field1015;
   @ObfuscatedName("t")
   static float[] field1016;
   @ObfuscatedName("n")
   static int field1017;
   @ObfuscatedName("m")
   static int field1018;
   @ObfuscatedName("f")
   byte[][] field1019;
   @ObfuscatedName("d")
   static class64[] field1020;
   @ObfuscatedName("s")
   static class52[] field1021;
   @ObfuscatedName("q")
   static class56[] field1022;
   @ObfuscatedName("i")
   int field1023;
   @ObfuscatedName("p")
   static class69[] field1024;
   @ObfuscatedName("y")
   static boolean[] field1025;
   @ObfuscatedName("a")
   static int[] field1026;
   @ObfuscatedName("v")
   static boolean field1027 = false;
   @ObfuscatedName("j")
   static int field1028;
   @ObfuscatedName("x")
   int field1029;
   @ObfuscatedName("g")
   int field1030;
   @ObfuscatedName("b")
   boolean field1031;
   @ObfuscatedName("k")
   static float[] field1032;
   @ObfuscatedName("w")
   static int field1033;
   @ObfuscatedName("aw")
   int field1034;
   @ObfuscatedName("e")
   static float[] field1035;
   @ObfuscatedName("am")
   static float[] field1036;
   @ObfuscatedName("an")
   static float[] field1037;
   @ObfuscatedName("aq")
   static float[] field1038;
   @ObfuscatedName("l")
   static byte[] field1039;
   @ObfuscatedName("ag")
   static int[] field1040;
   @ObfuscatedName("ab")
   byte[] field1041;
   @ObfuscatedName("o")
   boolean field1042;
   @ObfuscatedName("ax")
   int field1043;

   @ObfuscatedName("u")
   static int method1020() {
      int var0 = field1039[field1017] >> field1018 & 1;
      ++field1018;
      field1017 += field1018 >> 3;
      field1018 &= 7;
      return var0;
   }

   @ObfuscatedName("r")
   static int method1021(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1018; var0 -= var3) {
         var3 = 8 - field1018;
         int var4 = (1 << var3) - 1;
         var1 += (field1039[field1017] >> field1018 & var4) << var2;
         field1018 = 0;
         ++field1017;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1039[field1017] >> field1018 & var3) << var2;
         field1018 += var0;
      }

      return var1;
   }

   @ObfuscatedName("o")
   void method1022(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1023 = var2.readInt();
      this.field1013 = var2.readInt();
      this.field1015 = var2.readInt();
      this.field1014 = var2.readInt();
      if(this.field1014 < 0) {
         this.field1014 = ~this.field1014;
         this.field1042 = true;
      }

      int var3 = var2.readInt();
      this.field1019 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1019[var4] = var7;
      }

   }

   @ObfuscatedName("l")
   static void method1023(byte[] var0) {
      method1039(var0, 0);
      field1033 = 1 << method1021(4);
      field1028 = 1 << method1021(4);
      field1032 = new float[field1028];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1028:field1033;
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

         float[] var20 = new float[var4];

         for(int var21 = 0; var21 < var5; ++var21) {
            var20[2 * var21] = (float)Math.cos((double)(4 * var21 + 2) * 3.141592653589793D / (double)var2);
            var20[2 * var21 + 1] = -((float)Math.sin((double)(4 * var21 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = RSCanvas.method2131(var5 - 1);

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
            field1036 = var6;
            field1037 = var18;
            field1038 = var20;
            field1040 = var9;
         } else {
            field1016 = var6;
            field1010 = var18;
            field1035 = var20;
            field1012 = var9;
         }
      }

      var1 = method1021(8) + 1;
      field1021 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1021[var2] = new class52();
      }

      var2 = method1021(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1021(16);
      }

      var2 = method1021(6) + 1;
      field1022 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1022[var3] = new class56();
      }

      var3 = method1021(6) + 1;
      field1020 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1020[var4] = new class64();
      }

      var4 = method1021(6) + 1;
      field1024 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1024[var5] = new class69();
      }

      var5 = method1021(6) + 1;
      field1025 = new boolean[var5];
      field1026 = new int[var5];

      for(int var19 = 0; var19 < var5; ++var19) {
         field1025[var19] = method1020() != 0;
         method1021(16);
         method1021(16);
         field1026[var19] = method1021(8);
      }

   }

   @ObfuscatedName("f")
   static float method1024(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("m")
   static boolean method1025(IndexDataBase var0) {
      if(!field1027) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1023(var1);
         field1027 = true;
      }

      return true;
   }

   @ObfuscatedName("w")
   static class54 method1026(IndexDataBase var0, int var1, int var2) {
      if(!method1025(var0)) {
         var0.method3338(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("j")
   class55 method1028(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1041 == null) {
            this.field1029 = 0;
            this.field1011 = new float[field1028];
            this.field1041 = new byte[this.field1013];
            this.field1034 = 0;
            this.field1043 = 0;
         }

         for(; this.field1043 < this.field1019.length; ++this.field1043) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1036(this.field1043);
            if(var2 != null) {
               int var3 = this.field1034;
               int var4 = var2.length;
               if(var4 > this.field1013 - var3) {
                  var4 = this.field1013 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1041[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1034;
               }

               this.field1034 = var3;
            }
         }

         this.field1011 = null;
         byte[] var7 = this.field1041;
         this.field1041 = null;
         return new class55(this.field1023, var7, this.field1015, this.field1014, this.field1042);
      }
   }

   @ObfuscatedName("n")
   float[] method1036(int var1) {
      method1039(this.field1019[var1], 0);
      method1020();
      int var2 = method1021(RSCanvas.method2131(field1026.length - 1));
      boolean var3 = field1025[var2];
      int var4 = var3?field1028:field1033;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1020() != 0;
         var6 = method1020() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1033 >> 2);
         var9 = (var4 >> 2) + (field1033 >> 2);
         var10 = field1033 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1033 >> 2);
         var12 = var4 - (var4 >> 2) + (field1033 >> 2);
         var13 = field1033 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1024[field1026[var2]];
      int var16 = var14.field1168;
      int var17 = var14.field1170[var16];
      boolean var15 = !field1022[var17].method1061();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1169; ++var17) {
         class64 var40 = field1020[var14.field1171[var17]];
         float[] var19 = field1032;
         var40.method1190(var19, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1168;
         var18 = var14.field1170[var17];
         field1022[var18].method1073(field1032, var4 >> 1);
      }

      int var44;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1032[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var44 = var4 >> 3;
         float[] var20 = field1032;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var41 = var3?field1036:field1016;
         float[] var22 = var3?field1037:field1010;
         float[] var23 = var3?field1038:field1035;
         int[] var24 = var3?field1040:field1012;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var41[2 * var25];
            var29 = var41[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var44; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var41[var17 - 4 - 4 * var25];
            var31 = var41[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = RSCanvas.method2131(var4 - 1);

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
                  float var38 = var41[var32 * var48];
                  float var39 = var41[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var44 - 1; ++var46) {
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

         for(var46 = 0; var46 < var44; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var44; ++var46) {
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
            field1032[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1032[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var42 = null;
      if(this.field1029 > 0) {
         var18 = this.field1029 + var4 >> 2;
         var42 = new float[var18];
         int var43;
         if(!this.field1031) {
            for(var44 = 0; var44 < this.field1030; ++var44) {
               var43 = (this.field1029 >> 1) + var44;
               var42[var44] += this.field1011[var43];
            }
         }

         if(!var15) {
            for(var44 = var8; var44 < var4 >> 1; ++var44) {
               var43 = var42.length - (var4 >> 1) + var44;
               var42[var43] += field1032[var44];
            }
         }
      }

      float[] var54 = this.field1011;
      this.field1011 = field1032;
      field1032 = var54;
      this.field1029 = var4;
      this.field1030 = var12 - (var4 >> 1);
      this.field1031 = var15;
      return var42;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1039(byte[] var0, int var1) {
      field1039 = var0;
      field1017 = var1;
      field1018 = 0;
   }

   class54(byte[] var1) {
      this.method1022(var1);
   }
}

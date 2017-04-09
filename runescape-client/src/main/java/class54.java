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
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var16 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var16[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var16[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var17 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var17[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var17[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var18 = new int[var5];
         int var10 = RSCanvas.method2131(var5 - 1);

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
            field1036 = var6;
            field1037 = var16;
            field1038 = var17;
            field1040 = var18;
         } else {
            field1016 = var6;
            field1010 = var16;
            field1035 = var17;
            field1012 = var18;
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

      for(int var15 = 0; var15 < var5; ++var15) {
         field1025[var15] = method1020() != 0;
         method1021(16);
         method1021(16);
         field1026[var15] = method1021(8);
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
      int var15 = var14.field1168;
      int var16 = var14.field1170[var15];
      boolean var17 = !field1022[var16].method1061();
      boolean var18 = var17;

      float[] var20;
      for(var16 = 0; var16 < var14.field1169; ++var16) {
         class64 var19 = field1020[var14.field1171[var16]];
         var20 = field1032;
         var19.method1190(var20, var4 >> 1, var18);
      }

      int var48;
      if(!var17) {
         var16 = var14.field1168;
         var48 = var14.field1170[var16];
         field1022[var48].method1073(field1032, var4 >> 1);
      }

      int var21;
      int var22;
      float[] var23;
      if(var17) {
         for(var16 = var4 >> 1; var16 < var4; ++var16) {
            field1032[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var22 = var4 >> 3;
         var20 = field1032;

         for(var21 = 0; var21 < var16; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var16; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         var23 = var3?field1036:field1016;
         float[] var24 = var3?field1037:field1010;
         float[] var25 = var3?field1038:field1035;
         int[] var26 = var3?field1040:field1012;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for(var27 = 0; var27 < var48; ++var27) {
            var28 = var20[var27 * 4] - var20[var4 - var27 * 4 - 1];
            var29 = var20[var27 * 4 + 2] - var20[var4 - var27 * 4 - 3];
            var30 = var23[var27 * 2];
            var31 = var23[var27 * 2 + 1];
            var20[var4 - var27 * 4 - 1] = var28 * var30 - var29 * var31;
            var20[var4 - var27 * 4 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for(var27 = 0; var27 < var22; ++var27) {
            var28 = var20[var16 + 3 + var27 * 4];
            var29 = var20[var16 + 1 + var27 * 4];
            var30 = var20[var27 * 4 + 3];
            var31 = var20[var27 * 4 + 1];
            var20[var16 + 3 + var27 * 4] = var28 + var30;
            var20[var16 + 1 + var27 * 4] = var29 + var31;
            var32 = var23[var16 - 4 - var27 * 4];
            var33 = var23[var16 - 3 - var27 * 4];
            var20[var27 * 4 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var20[var27 * 4 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = RSCanvas.method2131(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for(var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for(var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * 2 * var37;
               int var39 = var4 - var35 * (var37 * 2 + 1);

               for(int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = var40 * 4;
                  float var42 = var20[var38 - 1 - var41];
                  float var43 = var20[var38 - 3 - var41];
                  float var44 = var20[var39 - 1 - var41];
                  float var45 = var20[var39 - 3 - var41];
                  var20[var38 - 1 - var41] = var42 + var44;
                  var20[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var20[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var20[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for(var34 = 1; var34 < var22 - 1; ++var34) {
            var35 = var26[var34];
            if(var34 < var35) {
               var36 = var34 * 8;
               var37 = var35 * 8;
               var32 = var20[var36 + 1];
               var20[var36 + 1] = var20[var37 + 1];
               var20[var37 + 1] = var32;
               var32 = var20[var36 + 3];
               var20[var36 + 3] = var20[var37 + 3];
               var20[var37 + 3] = var32;
               var32 = var20[var36 + 5];
               var20[var36 + 5] = var20[var37 + 5];
               var20[var37 + 5] = var32;
               var32 = var20[var36 + 7];
               var20[var36 + 7] = var20[var37 + 7];
               var20[var37 + 7] = var32;
            }
         }

         for(var34 = 0; var34 < var16; ++var34) {
            var20[var34] = var20[var34 * 2 + 1];
         }

         for(var34 = 0; var34 < var22; ++var34) {
            var20[var4 - 1 - var34 * 2] = var20[var34 * 4];
            var20[var4 - 2 - var34 * 2] = var20[var34 * 4 + 1];
            var20[var4 - var48 - 1 - var34 * 2] = var20[var34 * 4 + 2];
            var20[var4 - var48 - 2 - var34 * 2] = var20[var34 * 4 + 3];
         }

         for(var34 = 0; var34 < var22; ++var34) {
            var29 = var25[var34 * 2];
            var30 = var25[var34 * 2 + 1];
            var31 = var20[var16 + var34 * 2];
            var32 = var20[var16 + var34 * 2 + 1];
            var33 = var20[var4 - 2 - var34 * 2];
            float var49 = var20[var4 - 1 - var34 * 2];
            float var50 = var30 * (var31 - var33) + var29 * (var32 + var49);
            var20[var16 + var34 * 2] = (var31 + var33 + var50) * 0.5F;
            var20[var4 - 2 - var34 * 2] = (var31 + var33 - var50) * 0.5F;
            var50 = var30 * (var32 + var49) - var29 * (var31 - var33);
            var20[var16 + var34 * 2 + 1] = (var32 - var49 + var50) * 0.5F;
            var20[var4 - 1 - var34 * 2] = (-var32 + var49 + var50) * 0.5F;
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var20[var34] = var20[var34 * 2 + var16] * var24[var34 * 2] + var20[var34 * 2 + 1 + var16] * var24[var34 * 2 + 1];
            var20[var16 - 1 - var34] = var20[var34 * 2 + var16] * var24[var34 * 2 + 1] - var20[var34 * 2 + 1 + var16] * var24[var34 * 2];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var20[var4 - var48 + var34] = -var20[var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var20[var34] = var20[var48 + var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var20[var48 + var34] = -var20[var48 - var34 - 1];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var20[var16 + var34] = var20[var4 - var34 - 1];
         }

         for(var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1032[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for(var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1032[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var20 = null;
      if(this.field1029 > 0) {
         var48 = this.field1029 + var4 >> 2;
         var20 = new float[var48];
         if(!this.field1031) {
            for(var22 = 0; var22 < this.field1030; ++var22) {
               var21 = (this.field1029 >> 1) + var22;
               var20[var22] += this.field1011[var21];
            }
         }

         if(!var17) {
            for(var22 = var8; var22 < var4 >> 1; ++var22) {
               var21 = var20.length - (var4 >> 1) + var22;
               var20[var21] += field1032[var22];
            }
         }
      }

      var23 = this.field1011;
      this.field1011 = field1032;
      field1032 = var23;
      this.field1029 = var4;
      this.field1030 = var12 - (var4 >> 1);
      this.field1031 = var17;
      return var20;
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

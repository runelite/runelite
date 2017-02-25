import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class54 extends Node {
   @ObfuscatedName("au")
   static int[] field1009;
   @ObfuscatedName("d")
   int field1010;
   @ObfuscatedName("aq")
   static float[] field1011;
   @ObfuscatedName("p")
   int field1012;
   @ObfuscatedName("j")
   int field1013;
   @ObfuscatedName("c")
   static int field1014;
   @ObfuscatedName("r")
   static byte[] field1015;
   @ObfuscatedName("t")
   static boolean field1016 = false;
   @ObfuscatedName("i")
   static int field1017;
   @ObfuscatedName("o")
   static int field1018;
   @ObfuscatedName("m")
   static int field1019;
   @ObfuscatedName("s")
   static class52[] field1020;
   @ObfuscatedName("u")
   static class56[] field1021;
   @ObfuscatedName("w")
   int field1022;
   @ObfuscatedName("v")
   static class69[] field1023;
   @ObfuscatedName("n")
   boolean field1024;
   @ObfuscatedName("z")
   static int[] field1025;
   @ObfuscatedName("b")
   static class64[] field1026;
   @ObfuscatedName("y")
   float[] field1027;
   @ObfuscatedName("ae")
   static float[] field1028;
   @ObfuscatedName("a")
   int field1029;
   @ObfuscatedName("f")
   static boolean[] field1030;
   @ObfuscatedName("l")
   static float[] field1031;
   @ObfuscatedName("at")
   static float[] field1032;
   @ObfuscatedName("g")
   static float[] field1033;
   @ObfuscatedName("e")
   static float[] field1034;
   @ObfuscatedName("q")
   byte[][] field1035;
   @ObfuscatedName("x")
   static float[] field1036;
   @ObfuscatedName("h")
   int field1037;
   @ObfuscatedName("k")
   boolean field1038;
   @ObfuscatedName("am")
   static int[] field1039;
   @ObfuscatedName("ad")
   byte[] field1040;
   @ObfuscatedName("ai")
   int field1041;
   @ObfuscatedName("ac")
   int field1042;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1049(byte[] var0, int var1) {
      field1015 = var0;
      field1014 = var1;
      field1017 = 0;
   }

   @ObfuscatedName("h")
   static int method1050() {
      int var0 = field1015[field1014] >> field1017 & 1;
      ++field1017;
      field1014 += field1017 >> 3;
      field1017 &= 7;
      return var0;
   }

   @ObfuscatedName("p")
   static int method1051(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1017; var0 -= var3) {
         var3 = 8 - field1017;
         int var4 = (1 << var3) - 1;
         var1 += (field1015[field1014] >> field1017 & var4) << var2;
         field1017 = 0;
         ++field1014;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1015[field1014] >> field1017 & var3) << var2;
         field1017 += var0;
      }

      return var1;
   }

   @ObfuscatedName("j")
   void method1052(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1010 = var2.readInt();
      this.field1037 = var2.readInt();
      this.field1012 = var2.readInt();
      this.field1013 = var2.readInt();
      if(this.field1013 < 0) {
         this.field1013 = ~this.field1013;
         this.field1024 = true;
      }

      int var3 = var2.readInt();
      this.field1035 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method3010(var6, 0, var5);
         this.field1035[var4] = var6;
      }

   }

   @ObfuscatedName("c")
   float[] method1054(int var1) {
      method1049(this.field1035[var1], 0);
      method1050();
      int var2 = method1051(class162.method3117(field1025.length - 1));
      boolean var3 = field1030[var2];
      int var4 = var3?field1019:field1018;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1050() != 0;
         var6 = method1050() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1018 >> 2);
         var9 = (var4 >> 2) + (field1018 >> 2);
         var10 = field1018 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1018 >> 2);
         var12 = var4 - (var4 >> 2) + (field1018 >> 2);
         var13 = field1018 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1023[field1025[var2]];
      int var16 = var14.field1161;
      int var17 = var14.field1162[var16];
      boolean var15 = !field1021[var17].method1091();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1163; ++var17) {
         class64 var41 = field1026[var14.field1160[var17]];
         float[] var19 = field1031;
         var41.method1217(var19, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1161;
         var18 = var14.field1162[var17];
         field1021[var18].method1092(field1031, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1031[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field1031;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var40 = var3?field1028:field1036;
         float[] var22 = var3?field1011:field1033;
         float[] var23 = var3?field1032:field1034;
         int[] var24 = var3?field1039:field1009;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var40[2 * var25];
            var29 = var40[2 * var25 + 1];
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
            var30 = var40[var17 - 4 - 4 * var25];
            var31 = var40[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class162.method3117(var4 - 1);

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
                  float var38 = var40[var32 * var48];
                  float var39 = var40[var32 * var48 + 1];
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
            field1031[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1031[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1022 > 0) {
         var18 = this.field1022 + var4 >> 2;
         var43 = new float[var18];
         int var44;
         if(!this.field1038) {
            for(var42 = 0; var42 < this.field1029; ++var42) {
               var44 = (this.field1022 >> 1) + var42;
               var43[var42] += this.field1027[var44];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var44 = var43.length - (var4 >> 1) + var42;
               var43[var44] += field1031[var42];
            }
         }
      }

      float[] var54 = this.field1027;
      this.field1027 = field1031;
      field1031 = var54;
      this.field1022 = var4;
      this.field1029 = var12 - (var4 >> 1);
      this.field1038 = var15;
      return var43;
   }

   @ObfuscatedName("o")
   static boolean method1055(class182 var0) {
      if(!field1016) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1071(var1);
         field1016 = true;
      }

      return true;
   }

   @ObfuscatedName("s")
   static class54 method1056(class182 var0, int var1, int var2) {
      if(!method1055(var0)) {
         var0.method3376(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method1052(var1);
   }

   @ObfuscatedName("u")
   class55 method1057(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1040 == null) {
            this.field1022 = 0;
            this.field1027 = new float[field1019];
            this.field1040 = new byte[this.field1037];
            this.field1041 = 0;
            this.field1042 = 0;
         }

         for(; this.field1042 < this.field1035.length; ++this.field1042) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1054(this.field1042);
            if(var2 != null) {
               int var3 = this.field1041;
               int var4 = var2.length;
               if(var4 > this.field1037 - var3) {
                  var4 = this.field1037 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1040[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1041;
               }

               this.field1041 = var3;
            }
         }

         this.field1027 = null;
         byte[] var7 = this.field1040;
         this.field1040 = null;
         return new class55(this.field1010, var7, this.field1012, this.field1013, this.field1024);
      }
   }

   @ObfuscatedName("n")
   static void method1071(byte[] var0) {
      method1049(var0, 0);
      field1018 = 1 << method1051(4);
      field1019 = 1 << method1051(4);
      field1031 = new float[field1019];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1019:field1018;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var13 = new float[var3];

         for(int var12 = 0; var12 < var4; ++var12) {
            var13[2 * var12] = (float)Math.cos((double)(4 * var12) * 3.141592653589793D / (double)var2);
            var13[2 * var12 + 1] = -((float)Math.sin((double)(4 * var12) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var14 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var14[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var15 = new int[var5];
         int var10 = class162.method3117(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = class57.method1156(var11, var10);
         }

         if(var1 != 0) {
            field1028 = var13;
            field1011 = var7;
            field1032 = var14;
            field1039 = var15;
         } else {
            field1036 = var13;
            field1033 = var7;
            field1034 = var14;
            field1009 = var15;
         }
      }

      var1 = method1051(8) + 1;
      field1020 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1020[var2] = new class52();
      }

      var2 = method1051(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1051(16);
      }

      var2 = method1051(6) + 1;
      field1021 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1021[var3] = new class56();
      }

      var3 = method1051(6) + 1;
      field1026 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1026[var4] = new class64();
      }

      var4 = method1051(6) + 1;
      field1023 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1023[var5] = new class69();
      }

      var5 = method1051(6) + 1;
      field1030 = new boolean[var5];
      field1025 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field1030[var6] = method1050() != 0;
         method1051(16);
         method1051(16);
         field1025[var6] = method1051(8);
      }

   }

   @ObfuscatedName("q")
   static float method1081(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}

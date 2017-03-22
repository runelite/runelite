import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class54 extends Node {
   @ObfuscatedName("l")
   static class64[] field999;
   @ObfuscatedName("j")
   int field1000;
   @ObfuscatedName("c")
   int field1001;
   @ObfuscatedName("d")
   int field1002;
   @ObfuscatedName("w")
   int field1003;
   @ObfuscatedName("az")
   int field1004;
   @ObfuscatedName("u")
   static byte[] field1005;
   @ObfuscatedName("k")
   static int field1006;
   @ObfuscatedName("m")
   static int[] field1007;
   @ObfuscatedName("y")
   static int field1008;
   @ObfuscatedName("h")
   boolean field1009;
   @ObfuscatedName("e")
   static int field1010;
   @ObfuscatedName("v")
   static class56[] field1011;
   @ObfuscatedName("f")
   float[] field1012;
   @ObfuscatedName("ah")
   byte[] field1013;
   @ObfuscatedName("r")
   static boolean[] field1014;
   @ObfuscatedName("z")
   boolean field1015;
   @ObfuscatedName("i")
   static boolean field1016 = false;
   @ObfuscatedName("x")
   byte[][] field1017;
   @ObfuscatedName("g")
   static int field1018;
   @ObfuscatedName("t")
   int field1019;
   @ObfuscatedName("at")
   int field1020;
   @ObfuscatedName("p")
   static float[] field1021;
   @ObfuscatedName("n")
   static float[] field1022;
   @ObfuscatedName("a")
   static float[] field1023;
   @ObfuscatedName("o")
   static float[] field1024;
   @ObfuscatedName("an")
   static float[] field1025;
   @ObfuscatedName("ar")
   static float[] field1026;
   @ObfuscatedName("aa")
   static float[] field1027;
   @ObfuscatedName("af")
   static int[] field1028;
   @ObfuscatedName("ax")
   static int[] field1029;
   @ObfuscatedName("b")
   int field1030;
   @ObfuscatedName("s")
   static class69[] field1031;
   @ObfuscatedName("q")
   static class52[] field1032;

   @ObfuscatedName("c")
   static int method1065() {
      int var0 = field1005[field1006] >> field1018 & 1;
      ++field1018;
      field1006 += field1018 >> 3;
      field1018 &= 7;
      return var0;
   }

   @ObfuscatedName("d")
   static int method1066(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1018; var0 -= var3) {
         var3 = 8 - field1018;
         int var4 = (1 << var3) - 1;
         var1 += (field1005[field1006] >> field1018 & var4) << var2;
         field1018 = 0;
         ++field1006;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1005[field1006] >> field1018 & var3) << var2;
         field1018 += var0;
      }

      return var1;
   }

   @ObfuscatedName("u")
   static void method1068(byte[] var0) {
      method1089(var0, 0);
      field1008 = 1 << method1066(4);
      field1010 = 1 << method1066(4);
      field1021 = new float[field1010];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1010:field1008;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var13 = 0; var13 < var4; ++var13) {
            var6[2 * var13] = (float)Math.cos((double)(4 * var13) * 3.141592653589793D / (double)var2);
            var6[2 * var13 + 1] = -((float)Math.sin((double)(4 * var13) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var7[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var12 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var12[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var12[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = class94.method1981(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = DecorativeObject.method1983(var11, var10);
         }

         if(var1 != 0) {
            field1025 = var6;
            field1026 = var7;
            field1027 = var12;
            field1029 = var14;
         } else {
            field1022 = var6;
            field1023 = var7;
            field1024 = var12;
            field1028 = var14;
         }
      }

      var1 = method1066(8) + 1;
      field1032 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1032[var2] = new class52();
      }

      var2 = method1066(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1066(16);
      }

      var2 = method1066(6) + 1;
      field1011 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1011[var3] = new class56();
      }

      var3 = method1066(6) + 1;
      field999 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field999[var4] = new class64();
      }

      var4 = method1066(6) + 1;
      field1031 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1031[var5] = new class69();
      }

      var5 = method1066(6) + 1;
      field1014 = new boolean[var5];
      field1007 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1014[var15] = method1065() != 0;
         method1066(16);
         method1066(16);
         field1007[var15] = method1066(8);
      }

   }

   @ObfuscatedName("y")
   float[] method1069(int var1) {
      method1089(this.field1017[var1], 0);
      method1065();
      int var2 = method1066(class94.method1981(field1007.length - 1));
      boolean var3 = field1014[var2];
      int var4 = var3?field1010:field1008;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1065() != 0;
         var6 = method1065() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1008 >> 2);
         var9 = (var4 >> 2) + (field1008 >> 2);
         var10 = field1008 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1008 >> 2);
         var12 = var4 - (var4 >> 2) + (field1008 >> 2);
         var13 = field1008 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1031[field1007[var2]];
      int var16 = var14.field1152;
      int var17 = var14.field1151[var16];
      boolean var15 = !field1011[var17].method1100();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1154; ++var17) {
         class64 var43 = field999[var14.field1153[var17]];
         float[] var44 = field1021;
         var43.method1236(var44, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1152;
         var18 = var14.field1151[var17];
         field1011[var18].method1101(field1021, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1021[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1021;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1025:field1022;
         float[] var22 = var3?field1026:field1023;
         float[] var23 = var3?field1027:field1024;
         int[] var24 = var3?field1029:field1028;

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
         for(var25 = 0; var25 < var19; ++var25) {
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

         var25 = class94.method1981(var4 - 1);

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

         for(var46 = 1; var46 < var19 - 1; ++var46) {
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

         for(var46 = 0; var46 < var19; ++var46) {
            var20[var4 - 1 - 2 * var46] = var20[4 * var46];
            var20[var4 - 2 - 2 * var46] = var20[4 * var46 + 1];
            var20[var4 - var18 - 1 - 2 * var46] = var20[4 * var46 + 2];
            var20[var4 - var18 - 2 - 2 * var46] = var20[4 * var46 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
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
            field1021[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1021[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1030 > 0) {
         var18 = this.field1030 + var4 >> 2;
         var41 = new float[var18];
         int var40;
         if(!this.field1015) {
            for(var19 = 0; var19 < this.field1019; ++var19) {
               var40 = (this.field1030 >> 1) + var19;
               var41[var19] += this.field1012[var40];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var40 = var41.length - (var4 >> 1) + var19;
               var41[var40] += field1021[var19];
            }
         }
      }

      float[] var54 = this.field1012;
      this.field1012 = field1021;
      field1021 = var54;
      this.field1030 = var4;
      this.field1019 = var12 - (var4 >> 1);
      this.field1015 = var15;
      return var41;
   }

   @ObfuscatedName("e")
   static boolean method1070(class182 var0) {
      if(!field1016) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1068(var1);
         field1016 = true;
      }

      return true;
   }

   @ObfuscatedName("q")
   static class54 method1071(class182 var0, int var1, int var2) {
      if(!method1070(var0)) {
         var0.method3374(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method1076(var1);
   }

   @ObfuscatedName("w")
   void method1076(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1000 = var2.readInt();
      this.field1001 = var2.readInt();
      this.field1002 = var2.readInt();
      this.field1003 = var2.readInt();
      if(this.field1003 < 0) {
         this.field1003 = ~this.field1003;
         this.field1009 = true;
      }

      int var3 = var2.readInt();
      this.field1017 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.readBytes(var6, 0, var5);
         this.field1017[var4] = var6;
      }

   }

   @ObfuscatedName("x")
   static float method1082(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("v")
   class55 method1088(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1013 == null) {
            this.field1030 = 0;
            this.field1012 = new float[field1010];
            this.field1013 = new byte[this.field1001];
            this.field1004 = 0;
            this.field1020 = 0;
         }

         for(; this.field1020 < this.field1017.length; ++this.field1020) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1069(this.field1020);
            if(var2 != null) {
               int var3 = this.field1004;
               int var4 = var2.length;
               if(var4 > this.field1001 - var3) {
                  var4 = this.field1001 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1013[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1004;
               }

               this.field1004 = var3;
            }
         }

         this.field1012 = null;
         byte[] var7 = this.field1013;
         this.field1013 = null;
         return new class55(this.field1000, var7, this.field1002, this.field1003, this.field1009);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1089(byte[] var0, int var1) {
      field1005 = var0;
      field1006 = var1;
      field1018 = 0;
   }
}

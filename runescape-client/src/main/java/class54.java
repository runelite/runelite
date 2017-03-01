import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class54 extends Node {
   @ObfuscatedName("y")
   int field999;
   @ObfuscatedName("r")
   int field1000;
   @ObfuscatedName("u")
   int field1001;
   @ObfuscatedName("g")
   int field1002;
   @ObfuscatedName("v")
   int field1003;
   @ObfuscatedName("p")
   boolean field1004;
   @ObfuscatedName("j")
   static byte[] field1005;
   @ObfuscatedName("m")
   static int field1006;
   @ObfuscatedName("a")
   static int field1007;
   @ObfuscatedName("n")
   int field1008;
   @ObfuscatedName("s")
   static int field1009;
   @ObfuscatedName("k")
   static class52[] field1010;
   @ObfuscatedName("f")
   static class56[] field1011;
   @ObfuscatedName("o")
   static class64[] field1012;
   @ObfuscatedName("ab")
   static float[] field1013;
   @ObfuscatedName("ad")
   byte[] field1014;
   @ObfuscatedName("h")
   static float[] field1015;
   @ObfuscatedName("w")
   static boolean field1016 = false;
   @ObfuscatedName("l")
   float[] field1017;
   @ObfuscatedName("aq")
   int field1018;
   @ObfuscatedName("i")
   static int field1019;
   @ObfuscatedName("e")
   boolean field1020;
   @ObfuscatedName("x")
   byte[][] field1021;
   @ObfuscatedName("d")
   static float[] field1022;
   @ObfuscatedName("z")
   static float[] field1023;
   @ObfuscatedName("t")
   static float[] field1024;
   @ObfuscatedName("c")
   static boolean[] field1025;
   @ObfuscatedName("ac")
   static float[] field1026;
   @ObfuscatedName("au")
   static float[] field1027;
   @ObfuscatedName("al")
   static int[] field1028;
   @ObfuscatedName("ae")
   static int[] field1029;
   @ObfuscatedName("b")
   static int[] field1030;
   @ObfuscatedName("q")
   static class69[] field1031;
   @ObfuscatedName("aa")
   int field1032;

   @ObfuscatedName("s")
   static boolean method1068(class182 var0) {
      if(!field1016) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1072(var1);
         field1016 = true;
      }

      return true;
   }

   @ObfuscatedName("v")
   static int method1070(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1007; var0 -= var3) {
         var3 = 8 - field1007;
         int var4 = (1 << var3) - 1;
         var1 += (field1005[field1006] >> field1007 & var4) << var2;
         field1007 = 0;
         ++field1006;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1005[field1006] >> field1007 & var3) << var2;
         field1007 += var0;
      }

      return var1;
   }

   @ObfuscatedName("y")
   void method1071(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1008 = var2.readInt();
      this.field1002 = var2.readInt();
      this.field1003 = var2.readInt();
      this.field999 = var2.readInt();
      if(this.field999 < 0) {
         this.field999 = ~this.field999;
         this.field1004 = true;
      }

      int var3 = var2.readInt();
      this.field1021 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2897(var6, 0, var5);
         this.field1021[var4] = var6;
      }

   }

   @ObfuscatedName("p")
   static void method1072(byte[] var0) {
      method1080(var0, 0);
      field1019 = 1 << method1070(4);
      field1009 = 1 << method1070(4);
      field1015 = new float[field1009];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1009:field1019;
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

         for(int var9 = 0; var9 < var5; ++var9) {
            var20[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var20[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = Player.method237(var5 - 1);

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
            field1013 = var18;
            field1026 = var19;
            field1027 = var20;
            field1029 = var21;
         } else {
            field1022 = var18;
            field1023 = var19;
            field1024 = var20;
            field1028 = var21;
         }
      }

      var1 = method1070(8) + 1;
      field1010 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1010[var2] = new class52();
      }

      var2 = method1070(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1070(16);
      }

      var2 = method1070(6) + 1;
      field1011 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1011[var3] = new class56();
      }

      var3 = method1070(6) + 1;
      field1012 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1012[var4] = new class64();
      }

      var4 = method1070(6) + 1;
      field1031 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1031[var5] = new class69();
      }

      var5 = method1070(6) + 1;
      field1025 = new boolean[var5];
      field1030 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field1025[var6] = method1090() != 0;
         method1070(16);
         method1070(16);
         field1030[var6] = method1070(8);
      }

   }

   @ObfuscatedName("j")
   float[] method1073(int var1) {
      method1080(this.field1021[var1], 0);
      method1090();
      int var2 = method1070(Player.method237(field1030.length - 1));
      boolean var3 = field1025[var2];
      int var4 = var3?field1009:field1019;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1090() != 0;
         var6 = method1090() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1019 >> 2);
         var9 = (var4 >> 2) + (field1019 >> 2);
         var10 = field1019 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1019 >> 2);
         var12 = var4 - (var4 >> 2) + (field1019 >> 2);
         var13 = field1019 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field1031[field1030[var2]];
      int var16 = var14.field1161;
      int var40 = var14.field1162[var16];
      boolean var15 = !field1011[var40].method1110();
      boolean var45 = var15;

      for(var40 = 0; var40 < var14.field1163; ++var40) {
         class64 var18 = field1012[var14.field1160[var40]];
         float[] var19 = field1015;
         var18.method1241(var19, var4 >> 1, var45);
      }

      int var43;
      if(!var15) {
         var40 = var14.field1161;
         var43 = var14.field1162[var40];
         field1011[var43].method1106(field1015, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var40 = var4 >> 1; var40 < var4; ++var40) {
            field1015[var40] = 0.0F;
         }
      } else {
         var40 = var4 >> 1;
         var43 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1015;

         int var21;
         for(var21 = 0; var21 < var40; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var40; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1013:field1022;
         float[] var22 = var3?field1026:field1023;
         float[] var23 = var3?field1027:field1024;
         int[] var24 = var3?field1029:field1028;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var43; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var44[2 * var25];
            var29 = var44[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[var40 + 3 + 4 * var25];
            var27 = var20[var40 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var40 + 3 + 4 * var25] = var26 + var28;
            var20[var40 + 1 + 4 * var25] = var27 + var29;
            var30 = var44[var40 - 4 - 4 * var25];
            var31 = var44[var40 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = Player.method237(var4 - 1);

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
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var41 - 1; ++var47) {
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

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var43 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var43 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var27 = var23[2 * var47];
            var28 = var23[2 * var47 + 1];
            var29 = var20[var40 + 2 * var47];
            var30 = var20[var40 + 2 * var47 + 1];
            var31 = var20[var4 - 2 - 2 * var47];
            float var53 = var20[var4 - 1 - 2 * var47];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var20[var40 + 2 * var47] = (var29 + var31 + var54) * 0.5F;
            var20[var4 - 2 - 2 * var47] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var20[var40 + 2 * var47 + 1] = (var30 - var53 + var54) * 0.5F;
            var20[var4 - 1 - 2 * var47] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var47] = var20[2 * var47 + var40] * var22[2 * var47] + var20[2 * var47 + 1 + var40] * var22[2 * var47 + 1];
            var20[var40 - 1 - var47] = var20[2 * var47 + var40] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var40] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var4 - var43 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var47] = var20[var43 + var47];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var43 + var47] = -var20[var43 - var47 - 1];
         }

         for(var47 = 0; var47 < var43; ++var47) {
            var20[var40 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1015[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1015[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field1000 > 0) {
         var43 = this.field1000 + var4 >> 2;
         var17 = new float[var43];
         int var42;
         if(!this.field1020) {
            for(var41 = 0; var41 < this.field1001; ++var41) {
               var42 = (this.field1000 >> 1) + var41;
               var17[var41] += this.field1017[var42];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var42 = var17.length - (var4 >> 1) + var41;
               var17[var42] += field1015[var41];
            }
         }
      }

      float[] var46 = this.field1017;
      this.field1017 = field1015;
      field1015 = var46;
      this.field1000 = var4;
      this.field1001 = var12 - (var4 >> 1);
      this.field1020 = var15;
      return var17;
   }

   class54(byte[] var1) {
      this.method1071(var1);
   }

   @ObfuscatedName("k")
   static class54 method1074(class182 var0, int var1, int var2) {
      if(!method1068(var0)) {
         var0.method3356(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("f")
   class55 method1076(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1014 == null) {
            this.field1000 = 0;
            this.field1017 = new float[field1009];
            this.field1014 = new byte[this.field1002];
            this.field1018 = 0;
            this.field1032 = 0;
         }

         for(; this.field1032 < this.field1021.length; ++this.field1032) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1073(this.field1032);
            if(var2 != null) {
               int var3 = this.field1018;
               int var4 = var2.length;
               if(var4 > this.field1002 - var3) {
                  var4 = this.field1002 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1014[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1018;
               }

               this.field1018 = var3;
            }
         }

         this.field1017 = null;
         byte[] var7 = this.field1014;
         this.field1014 = null;
         return new class55(this.field1008, var7, this.field1003, this.field999, this.field1004);
      }
   }

   @ObfuscatedName("x")
   static float method1077(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1080(byte[] var0, int var1) {
      field1005 = var0;
      field1006 = var1;
      field1007 = 0;
   }

   @ObfuscatedName("g")
   static int method1090() {
      int var0 = field1005[field1006] >> field1007 & 1;
      ++field1007;
      field1006 += field1007 >> 3;
      field1007 &= 7;
      return var0;
   }
}

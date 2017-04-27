import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class54 extends Node {
   @ObfuscatedName("k")
   static class69[] field977;
   @ObfuscatedName("c")
   int field978;
   @ObfuscatedName("n")
   int field979;
   @ObfuscatedName("ac")
   static float[] field980;
   @ObfuscatedName("t")
   int field981;
   @ObfuscatedName("p")
   boolean field982;
   @ObfuscatedName("u")
   static byte[] field983;
   @ObfuscatedName("aa")
   int field984;
   @ObfuscatedName("l")
   static int field985;
   @ObfuscatedName("v")
   static int field986;
   @ObfuscatedName("g")
   static int field987;
   @ObfuscatedName("w")
   static class52[] field988;
   @ObfuscatedName("r")
   static class56[] field989;
   @ObfuscatedName("ax")
   static float[] field990;
   @ObfuscatedName("aj")
   int field991;
   @ObfuscatedName("e")
   static boolean[] field992;
   @ObfuscatedName("j")
   static int[] field993;
   @ObfuscatedName("b")
   boolean field994;
   @ObfuscatedName("a")
   float[] field995;
   @ObfuscatedName("i")
   static boolean field996 = false;
   @ObfuscatedName("h")
   int field997;
   @ObfuscatedName("x")
   int field998;
   @ObfuscatedName("z")
   static int field999;
   @ObfuscatedName("o")
   static float[] field1000;
   @ObfuscatedName("m")
   static float[] field1001;
   @ObfuscatedName("y")
   static float[] field1002;
   @ObfuscatedName("am")
   static float[] field1003;
   @ObfuscatedName("q")
   int field1004;
   @ObfuscatedName("s")
   static class64[] field1005;
   @ObfuscatedName("az")
   static int[] field1006;
   @ObfuscatedName("ao")
   static int[] field1007;
   @ObfuscatedName("ak")
   byte[] field1008;
   @ObfuscatedName("d")
   byte[][] field1009;
   @ObfuscatedName("f")
   static float[] field1010;

   @ObfuscatedName("q")
   static int method1004(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field985; var0 -= var3) {
         var3 = 8 - field985;
         int var4 = (1 << var3) - 1;
         var1 += (field983[field999] >> field985 & var4) << var2;
         field985 = 0;
         ++field999;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field983[field999] >> field985 & var3) << var2;
         field985 += var0;
      }

      return var1;
   }

   @ObfuscatedName("n")
   static int method1005() {
      int var0 = field983[field999] >> field985 & 1;
      ++field985;
      field999 += field985 >> 3;
      field985 &= 7;
      return var0;
   }

   @ObfuscatedName("t")
   void method1007(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field978 = var2.readInt();
      this.field979 = var2.readInt();
      this.field1004 = var2.readInt();
      this.field981 = var2.readInt();
      if(this.field981 < 0) {
         this.field981 = ~this.field981;
         this.field982 = true;
      }

      int var3 = var2.readInt();
      this.field1009 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1009[var4] = var7;
      }

   }

   @ObfuscatedName("p")
   static void method1008(byte[] var0) {
      method1017(var0, 0);
      field986 = 1 << method1004(4);
      field987 = 1 << method1004(4);
      field1010 = new float[field987];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field987:field986;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var18 = new float[var3];

         for(int var19 = 0; var19 < var4; ++var19) {
            var18[var19 * 2] = (float)Math.cos((double)(var19 * 4) * 3.141592653589793D / (double)var2);
            var18[var19 * 2 + 1] = -((float)Math.sin((double)(var19 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var7[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var7[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var20 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var20[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var20[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = Friend.method183(var5 - 1);

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
            field1003 = var18;
            field990 = var7;
            field980 = var20;
            field1007 = var21;
         } else {
            field1000 = var18;
            field1001 = var7;
            field1002 = var20;
            field1006 = var21;
         }
      }

      var1 = method1004(8) + 1;
      field988 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field988[var2] = new class52();
      }

      var2 = method1004(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1004(16);
      }

      var2 = method1004(6) + 1;
      field989 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field989[var3] = new class56();
      }

      var3 = method1004(6) + 1;
      field1005 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1005[var4] = new class64();
      }

      var4 = method1004(6) + 1;
      field977 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field977[var5] = new class69();
      }

      var5 = method1004(6) + 1;
      field992 = new boolean[var5];
      field993 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field992[var6] = method1005() != 0;
         method1004(16);
         method1004(16);
         field993[var6] = method1004(8);
      }

   }

   @ObfuscatedName("u")
   float[] method1009(int var1) {
      method1017(this.field1009[var1], 0);
      method1005();
      int var2 = method1004(Friend.method183(field993.length - 1));
      boolean var3 = field992[var2];
      int var4 = var3?field987:field986;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1005() != 0;
         var6 = method1005() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field986 >> 2);
         var9 = (var4 >> 2) + (field986 >> 2);
         var10 = field986 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field986 >> 2);
         var12 = var4 - (var4 >> 2) + (field986 >> 2);
         var13 = field986 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field977[field993[var2]];
      int var16 = var14.field1127;
      int var41 = var14.field1128[var16];
      boolean var15 = !field989[var41].method1045();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1126; ++var41) {
         class64 var42 = field1005[var14.field1129[var41]];
         float[] var43 = field1010;
         var42.method1181(var43, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var41 = var14.field1127;
         var18 = var14.field1128[var41];
         field989[var18].method1050(field1010, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field1010[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field1010;

         int var44;
         for(var44 = 0; var44 < var41; ++var44) {
            var40[var44] *= 0.5F;
         }

         for(var44 = var41; var44 < var4; ++var44) {
            var40[var44] = -var40[var4 - var44 - 1];
         }

         float[] var21 = var3?field1003:field1000;
         float[] var22 = var3?field990:field1001;
         float[] var23 = var3?field980:field1002;
         int[] var24 = var3?field1007:field1006;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var40[var25 * 4] - var40[var4 - var25 * 4 - 1];
            var27 = var40[var25 * 4 + 2] - var40[var4 - var25 * 4 - 3];
            var28 = var21[var25 * 2];
            var29 = var21[var25 * 2 + 1];
            var40[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var40[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var40[var41 + 3 + var25 * 4];
            var27 = var40[var41 + 1 + var25 * 4];
            var28 = var40[var25 * 4 + 3];
            var29 = var40[var25 * 4 + 1];
            var40[var41 + 3 + var25 * 4] = var26 + var28;
            var40[var41 + 1 + var25 * 4] = var27 + var29;
            var30 = var21[var41 - 4 - var25 * 4];
            var31 = var21[var41 - 3 - var25 * 4];
            var40[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = Friend.method183(var4 - 1);

         int var46;
         int var47;
         int var48;
         int var49;
         for(var46 = 0; var46 < var25 - 3; ++var46) {
            var47 = var4 >> var46 + 2;
            var48 = 8 << var46;

            for(var49 = 0; var49 < 2 << var46; ++var49) {
               int var50 = var4 - var47 * 2 * var49;
               int var51 = var4 - var47 * (var49 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var46 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var40[var50 - 1 - var33];
                  float var35 = var40[var50 - 3 - var33];
                  float var36 = var40[var51 - 1 - var33];
                  float var37 = var40[var51 - 3 - var33];
                  var40[var50 - 1 - var33] = var34 + var36;
                  var40[var50 - 3 - var33] = var35 + var37;
                  float var38 = var21[var32 * var48];
                  float var39 = var21[var32 * var48 + 1];
                  var40[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var40[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var19 - 1; ++var46) {
            var47 = var24[var46];
            if(var46 < var47) {
               var48 = var46 * 8;
               var49 = var47 * 8;
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
            var40[var46] = var40[var46 * 2 + 1];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var40[var4 - 1 - var46 * 2] = var40[var46 * 4];
            var40[var4 - 2 - var46 * 2] = var40[var46 * 4 + 1];
            var40[var4 - var18 - 1 - var46 * 2] = var40[var46 * 4 + 2];
            var40[var4 - var18 - 2 - var46 * 2] = var40[var46 * 4 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var27 = var23[var46 * 2];
            var28 = var23[var46 * 2 + 1];
            var29 = var40[var41 + var46 * 2];
            var30 = var40[var41 + var46 * 2 + 1];
            var31 = var40[var4 - 2 - var46 * 2];
            float var52 = var40[var4 - 1 - var46 * 2];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var40[var41 + var46 * 2] = (var29 + var31 + var53) * 0.5F;
            var40[var4 - 2 - var46 * 2] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var40[var41 + var46 * 2 + 1] = (var30 - var52 + var53) * 0.5F;
            var40[var4 - 1 - var46 * 2] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var40[var46] = var40[var46 * 2 + var41] * var22[var46 * 2] + var40[var46 * 2 + 1 + var41] * var22[var46 * 2 + 1];
            var40[var41 - 1 - var46] = var40[var46 * 2 + var41] * var22[var46 * 2 + 1] - var40[var46 * 2 + 1 + var41] * var22[var46 * 2];
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
            field1010[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1010[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field998 > 0) {
         var18 = this.field998 + var4 >> 2;
         var17 = new float[var18];
         int var20;
         if(!this.field994) {
            for(var19 = 0; var19 < this.field997; ++var19) {
               var20 = (this.field998 >> 1) + var19;
               var17[var19] += this.field995[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var17.length - (var4 >> 1) + var19;
               var17[var20] += field1010[var19];
            }
         }
      }

      float[] var54 = this.field995;
      this.field995 = field1010;
      field1010 = var54;
      this.field998 = var4;
      this.field997 = var12 - (var4 >> 1);
      this.field994 = var15;
      return var17;
   }

   @ObfuscatedName("d")
   static float method1010(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   static class54 method1011(IndexDataBase var0, int var1, int var2) {
      if(!method1033(var0)) {
         var0.method3297(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("s")
   class55 method1013(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1008 == null) {
            this.field998 = 0;
            this.field995 = new float[field987];
            this.field1008 = new byte[this.field979];
            this.field984 = 0;
            this.field991 = 0;
         }

         for(; this.field991 < this.field1009.length; ++this.field991) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1009(this.field991);
            if(var2 != null) {
               int var3 = this.field984;
               int var4 = var2.length;
               if(var4 > this.field979 - var3) {
                  var4 = this.field979 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1008[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field984;
               }

               this.field984 = var3;
            }
         }

         this.field995 = null;
         byte[] var7 = this.field1008;
         this.field1008 = null;
         return new class55(this.field978, var7, this.field1004, this.field981, this.field982);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1017(byte[] var0, int var1) {
      field983 = var0;
      field999 = var1;
      field985 = 0;
   }

   class54(byte[] var1) {
      this.method1007(var1);
   }

   @ObfuscatedName("w")
   static boolean method1033(IndexDataBase var0) {
      if(!field996) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1008(var1);
         field996 = true;
      }

      return true;
   }
}

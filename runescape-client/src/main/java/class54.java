import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class54 extends Node {
   @ObfuscatedName("aa")
   byte[] field980;
   @ObfuscatedName("x")
   int field981;
   @ObfuscatedName("aj")
   static float[] field982;
   @ObfuscatedName("a")
   int field983;
   @ObfuscatedName("n")
   static float[] field984;
   @ObfuscatedName("f")
   int field985;
   @ObfuscatedName("d")
   static byte[] field986;
   @ObfuscatedName("al")
   static float[] field987;
   @ObfuscatedName("i")
   int field988;
   @ObfuscatedName("z")
   static int field989;
   @ObfuscatedName("t")
   static int field990;
   @ObfuscatedName("m")
   static class52[] field991;
   @ObfuscatedName("e")
   static class64[] field992;
   @ObfuscatedName("q")
   static class56[] field993;
   @ObfuscatedName("v")
   static class69[] field994;
   @ObfuscatedName("j")
   static boolean[] field995;
   @ObfuscatedName("p")
   static int[] field996;
   @ObfuscatedName("u")
   byte[][] field997;
   @ObfuscatedName("r")
   float[] field998;
   @ObfuscatedName("y")
   int field999;
   @ObfuscatedName("h")
   int field1000;
   @ObfuscatedName("s")
   boolean field1001;
   @ObfuscatedName("w")
   static float[] field1002;
   @ObfuscatedName("c")
   boolean field1003;
   @ObfuscatedName("o")
   static float[] field1004;
   @ObfuscatedName("k")
   static boolean field1005 = false;
   @ObfuscatedName("b")
   static float[] field1006;
   @ObfuscatedName("ag")
   static float[] field1007;
   @ObfuscatedName("g")
   static int field1008;
   @ObfuscatedName("l")
   static int field1009;
   @ObfuscatedName("af")
   static int[] field1010;
   @ObfuscatedName("an")
   static int[] field1011;
   @ObfuscatedName("ax")
   int field1012;
   @ObfuscatedName("ai")
   int field1013;

   @ObfuscatedName("m")
   static class54 method960(class182 var0, int var1, int var2) {
      if(!method966(var0)) {
         var0.method3264(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3272(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   @ObfuscatedName("i")
   static int method961() {
      int var0 = field986[field1009] >> field1008 & 1;
      ++field1008;
      field1009 += field1008 >> 3;
      field1008 &= 7;
      return var0;
   }

   @ObfuscatedName("a")
   static int method962(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1008; var0 -= var3) {
         var3 = 8 - field1008;
         int var4 = (1 << var3) - 1;
         var1 += (field986[field1009] >> field1008 & var4) << var2;
         field1008 = 0;
         ++field1009;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field986[field1009] >> field1008 & var3) << var2;
         field1008 += var0;
      }

      return var1;
   }

   @ObfuscatedName("c")
   void method963(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field981 = var2.method2780();
      this.field988 = var2.method2780();
      this.field983 = var2.method2780();
      this.field985 = var2.method2780();
      if(this.field985 < 0) {
         this.field985 = ~this.field985;
         this.field1003 = true;
      }

      int var3 = var2.method2780();
      this.field997 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method2974(var7, 0, var5);
         this.field997[var4] = var7;
      }

   }

   @ObfuscatedName("g")
   static void method964(byte[] var0) {
      method977(var0, 0);
      field989 = 1 << method962(4);
      field990 = 1 << method962(4);
      field1002 = new float[field990];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field990:field989;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var13 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var13[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var13[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var14 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var14[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var15 = new int[var5];
         int var10 = GameEngine.method2160(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = class5.method77(var11, var10);
         }

         if(var1 != 0) {
            field982 = var6;
            field1007 = var13;
            field987 = var14;
            field1010 = var15;
         } else {
            field984 = var6;
            field1004 = var13;
            field1006 = var14;
            field1011 = var15;
         }
      }

      var1 = method962(8) + 1;
      field991 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field991[var2] = new class52();
      }

      var2 = method962(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method962(16);
      }

      var2 = method962(6) + 1;
      field993 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field993[var3] = new class56();
      }

      var3 = method962(6) + 1;
      field992 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field992[var4] = new class64();
      }

      var4 = method962(6) + 1;
      field994 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field994[var5] = new class69();
      }

      var5 = method962(6) + 1;
      field995 = new boolean[var5];
      field996 = new int[var5];

      for(int var12 = 0; var12 < var5; ++var12) {
         field995[var12] = method961() != 0;
         method962(16);
         method962(16);
         field996[var12] = method962(8);
      }

   }

   @ObfuscatedName("t")
   static boolean method966(class182 var0) {
      if(!field1005) {
         byte[] var1 = var0.method3272(0, 0);
         if(var1 == null) {
            return false;
         }

         method964(var1);
         field1005 = true;
      }

      return true;
   }

   @ObfuscatedName("q")
   class55 method969(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field980 == null) {
            this.field999 = 0;
            this.field998 = new float[field990];
            this.field980 = new byte[this.field988];
            this.field1012 = 0;
            this.field1013 = 0;
         }

         for(; this.field1013 < this.field997.length; ++this.field1013) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method983(this.field1013);
            if(var2 != null) {
               int var3 = this.field1012;
               int var4 = var2.length;
               if(var4 > this.field988 - var3) {
                  var4 = this.field988 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field980[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1012;
               }

               this.field1012 = var3;
            }
         }

         this.field998 = null;
         byte[] var7 = this.field980;
         this.field980 = null;
         return new class55(this.field981, var7, this.field983, this.field985, this.field1003);
      }
   }

   class54(byte[] var1) {
      this.method963(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method977(byte[] var0, int var1) {
      field986 = var0;
      field1009 = var1;
      field1008 = 0;
   }

   @ObfuscatedName("z")
   float[] method983(int var1) {
      method977(this.field997[var1], 0);
      method961();
      int var2 = method962(GameEngine.method2160(field996.length - 1));
      boolean var3 = field995[var2];
      int var4 = var3?field990:field989;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method961() != 0;
         var6 = method961() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field989 >> 2);
         var9 = (var4 >> 2) + (field989 >> 2);
         var10 = field989 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field989 >> 2);
         var12 = var4 - (var4 >> 2) + (field989 >> 2);
         var13 = field989 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field994[field996[var2]];
      int var15 = var14.field1137;
      int var16 = var14.field1138[var15];
      boolean var17 = !field993[var16].method1004();
      boolean var18 = var17;

      for(var16 = 0; var16 < var14.field1139; ++var16) {
         class64 var19 = field992[var14.field1140[var16]];
         float[] var20 = field1002;
         var19.method1111(var20, var4 >> 1, var18);
      }

      int var48;
      if(!var17) {
         var16 = var14.field1137;
         var48 = var14.field1138[var16];
         field993[var48].method1003(field1002, var4 >> 1);
      }

      float[] var21;
      int var22;
      int var49;
      if(var17) {
         for(var16 = var4 >> 1; var16 < var4; ++var16) {
            field1002[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var49 = var4 >> 3;
         var21 = field1002;

         for(var22 = 0; var22 < var16; ++var22) {
            var21[var22] *= 0.5F;
         }

         for(var22 = var16; var22 < var4; ++var22) {
            var21[var22] = -var21[var4 - var22 - 1];
         }

         float[] var23 = var3?field982:field984;
         float[] var24 = var3?field1007:field1004;
         float[] var25 = var3?field987:field1006;
         int[] var26 = var3?field1010:field1011;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for(var27 = 0; var27 < var48; ++var27) {
            var28 = var21[4 * var27] - var21[var4 - 4 * var27 - 1];
            var29 = var21[4 * var27 + 2] - var21[var4 - 4 * var27 - 3];
            var30 = var23[2 * var27];
            var31 = var23[2 * var27 + 1];
            var21[var4 - 4 * var27 - 1] = var28 * var30 - var29 * var31;
            var21[var4 - 4 * var27 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for(var27 = 0; var27 < var49; ++var27) {
            var28 = var21[var16 + 3 + 4 * var27];
            var29 = var21[var16 + 1 + 4 * var27];
            var30 = var21[4 * var27 + 3];
            var31 = var21[4 * var27 + 1];
            var21[var16 + 3 + 4 * var27] = var28 + var30;
            var21[var16 + 1 + 4 * var27] = var29 + var31;
            var32 = var23[var16 - 4 - 4 * var27];
            var33 = var23[var16 - 3 - 4 * var27];
            var21[4 * var27 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var21[4 * var27 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = GameEngine.method2160(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for(var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for(var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * 2 * var37;
               int var39 = var4 - var35 * (2 * var37 + 1);

               for(int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = 4 * var40;
                  float var42 = var21[var38 - 1 - var41];
                  float var43 = var21[var38 - 3 - var41];
                  float var44 = var21[var39 - 1 - var41];
                  float var45 = var21[var39 - 3 - var41];
                  var21[var38 - 1 - var41] = var42 + var44;
                  var21[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var21[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var21[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for(var34 = 1; var34 < var49 - 1; ++var34) {
            var35 = var26[var34];
            if(var34 < var35) {
               var36 = 8 * var34;
               var37 = 8 * var35;
               var32 = var21[var36 + 1];
               var21[var36 + 1] = var21[var37 + 1];
               var21[var37 + 1] = var32;
               var32 = var21[var36 + 3];
               var21[var36 + 3] = var21[var37 + 3];
               var21[var37 + 3] = var32;
               var32 = var21[var36 + 5];
               var21[var36 + 5] = var21[var37 + 5];
               var21[var37 + 5] = var32;
               var32 = var21[var36 + 7];
               var21[var36 + 7] = var21[var37 + 7];
               var21[var37 + 7] = var32;
            }
         }

         for(var34 = 0; var34 < var16; ++var34) {
            var21[var34] = var21[2 * var34 + 1];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var21[var4 - 1 - 2 * var34] = var21[4 * var34];
            var21[var4 - 2 - 2 * var34] = var21[4 * var34 + 1];
            var21[var4 - var48 - 1 - 2 * var34] = var21[4 * var34 + 2];
            var21[var4 - var48 - 2 - 2 * var34] = var21[4 * var34 + 3];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var29 = var25[2 * var34];
            var30 = var25[2 * var34 + 1];
            var31 = var21[var16 + 2 * var34];
            var32 = var21[var16 + 2 * var34 + 1];
            var33 = var21[var4 - 2 - 2 * var34];
            float var51 = var21[var4 - 1 - 2 * var34];
            float var52 = var30 * (var31 - var33) + var29 * (var32 + var51);
            var21[var16 + 2 * var34] = (var31 + var33 + var52) * 0.5F;
            var21[var4 - 2 - 2 * var34] = (var31 + var33 - var52) * 0.5F;
            var52 = var30 * (var32 + var51) - var29 * (var31 - var33);
            var21[var16 + 2 * var34 + 1] = (var32 - var51 + var52) * 0.5F;
            var21[var4 - 1 - 2 * var34] = (-var32 + var51 + var52) * 0.5F;
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[2 * var34 + var16] * var24[2 * var34] + var21[2 * var34 + 1 + var16] * var24[2 * var34 + 1];
            var21[var16 - 1 - var34] = var21[2 * var34 + var16] * var24[2 * var34 + 1] - var21[2 * var34 + 1 + var16] * var24[2 * var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var4 - var48 + var34] = -var21[var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[var48 + var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var48 + var34] = -var21[var48 - var34 - 1];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var16 + var34] = var21[var4 - var34 - 1];
         }

         for(var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1002[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for(var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1002[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var21 = null;
      if(this.field999 > 0) {
         var48 = this.field999 + var4 >> 2;
         var21 = new float[var48];
         if(!this.field1001) {
            for(var49 = 0; var49 < this.field1000; ++var49) {
               var22 = (this.field999 >> 1) + var49;
               var21[var49] += this.field998[var22];
            }
         }

         if(!var17) {
            for(var49 = var8; var49 < var4 >> 1; ++var49) {
               var22 = var21.length - (var4 >> 1) + var49;
               var21[var22] += field1002[var49];
            }
         }
      }

      float[] var50 = this.field998;
      this.field998 = field1002;
      field1002 = var50;
      this.field999 = var4;
      this.field1000 = var12 - (var4 >> 1);
      this.field1001 = var17;
      return var21;
   }

   @ObfuscatedName("u")
   static float method986(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class54 extends Node {
   @ObfuscatedName("k")
   static byte[] field985;
   @ObfuscatedName("c")
   int field986;
   @ObfuscatedName("f")
   int field987;
   @ObfuscatedName("h")
   int field988;
   @ObfuscatedName("x")
   static int field989;
   @ObfuscatedName("g")
   boolean field990;
   @ObfuscatedName("q")
   static float[] field991;
   @ObfuscatedName("u")
   static int field992;
   @ObfuscatedName("o")
   static int[] field993;
   @ObfuscatedName("b")
   static int field994;
   @ObfuscatedName("r")
   static int field995;
   @ObfuscatedName("n")
   static class52[] field996;
   @ObfuscatedName("i")
   static boolean field997 = false;
   @ObfuscatedName("j")
   static class64[] field998;
   @ObfuscatedName("v")
   static float[] field999;
   @ObfuscatedName("al")
   int field1000;
   @ObfuscatedName("l")
   static float[] field1001;
   @ObfuscatedName("d")
   int field1002;
   @ObfuscatedName("z")
   float[] field1003;
   @ObfuscatedName("y")
   static float[] field1004;
   @ObfuscatedName("s")
   byte[][] field1005;
   @ObfuscatedName("t")
   boolean field1006;
   @ObfuscatedName("m")
   static class56[] field1007;
   @ObfuscatedName("e")
   int field1008;
   @ObfuscatedName("p")
   static boolean[] field1009;
   @ObfuscatedName("a")
   int field1010;
   @ObfuscatedName("az")
   static float[] field1011;
   @ObfuscatedName("ai")
   static float[] field1012;
   @ObfuscatedName("ad")
   static float[] field1013;
   @ObfuscatedName("aa")
   static int[] field1014;
   @ObfuscatedName("ao")
   static int[] field1015;
   @ObfuscatedName("ax")
   byte[] field1016;
   @ObfuscatedName("ae")
   int field1017;
   @ObfuscatedName("w")
   static class69[] field1018;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method925(byte[] var0, int var1) {
      field985 = var0;
      field992 = var1;
      field994 = 0;
   }

   @ObfuscatedName("f")
   static int method926() {
      int var0 = field985[field992] >> field994 & 1;
      ++field994;
      field992 += field994 >> 3;
      field994 &= 7;
      return var0;
   }

   @ObfuscatedName("g")
   static int method927(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field994; var0 -= var3) {
         var3 = 8 - field994;
         int var4 = (1 << var3) - 1;
         var1 += (field985[field992] >> field994 & var4) << var2;
         field994 = 0;
         ++field992;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field985[field992] >> field994 & var3) << var2;
         field994 += var0;
      }

      return var1;
   }

   @ObfuscatedName("k")
   void method928(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field986 = var2.method2727();
      this.field987 = var2.method2727();
      this.field988 = var2.method2727();
      this.field1010 = var2.method2727();
      if(this.field1010 < 0) {
         this.field1010 = ~this.field1010;
         this.field990 = true;
      }

      int var3 = var2.method2727();
      this.field1005 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2824(var6, 0, var5);
         this.field1005[var4] = var6;
      }

   }

   @ObfuscatedName("u")
   static void method929(byte[] var0) {
      method925(var0, 0);
      field989 = 1 << method927(4);
      field995 = 1 << method927(4);
      field991 = new float[field995];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field995:field989;
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

         int[] var20 = new int[var5];
         int var10 = Projectile.method763(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var20[var11] = var17;
         }

         if(var1 != 0) {
            field1011 = var6;
            field1012 = var18;
            field1013 = var8;
            field1015 = var20;
         } else {
            field1004 = var6;
            field1001 = var18;
            field999 = var8;
            field1014 = var20;
         }
      }

      var1 = method927(8) + 1;
      field996 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field996[var2] = new class52();
      }

      var2 = method927(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method927(16);
      }

      var2 = method927(6) + 1;
      field1007 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1007[var3] = new class56();
      }

      var3 = method927(6) + 1;
      field998 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field998[var4] = new class64();
      }

      var4 = method927(6) + 1;
      field1018 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1018[var5] = new class69();
      }

      var5 = method927(6) + 1;
      field1009 = new boolean[var5];
      field993 = new int[var5];

      for(int var21 = 0; var21 < var5; ++var21) {
         field1009[var21] = method926() != 0;
         method927(16);
         method927(16);
         field993[var21] = method927(8);
      }

   }

   @ObfuscatedName("b")
   float[] method930(int var1) {
      method925(this.field1005[var1], 0);
      method926();
      int var2 = method927(Projectile.method763(field993.length - 1));
      boolean var3 = field1009[var2];
      int var4 = var3?field995:field989;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method926() != 0;
         var6 = method926() != 0;
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

      class69 var14 = field1018[field993[var2]];
      int var16 = var14.field1144;
      int var17 = var14.field1145[var16];
      boolean var15 = !field1007[var17].method982();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1146; ++var17) {
         class64 var40 = field998[var14.field1143[var17]];
         float[] var41 = field991;
         var40.method1108(var41, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1144;
         var18 = var14.field1145[var17];
         field1007[var18].method972(field991, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field991[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field991;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var42 = var3?field1011:field1004;
         float[] var22 = var3?field1012:field1001;
         float[] var23 = var3?field1013:field999;
         int[] var24 = var3?field1015:field1014;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var42[2 * var25];
            var29 = var42[2 * var25 + 1];
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
            var30 = var42[var17 - 4 - 4 * var25];
            var31 = var42[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = Projectile.method763(var4 - 1);

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
                  float var38 = var42[var32 * var48];
                  float var39 = var42[var32 * var48 + 1];
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
            field991[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field991[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1008 > 0) {
         var18 = this.field1008 + var4 >> 2;
         var43 = new float[var18];
         int var44;
         if(!this.field1006) {
            for(var19 = 0; var19 < this.field1002; ++var19) {
               var44 = (this.field1008 >> 1) + var19;
               var43[var19] += this.field1003[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var43.length - (var4 >> 1) + var19;
               var43[var44] += field991[var19];
            }
         }
      }

      float[] var54 = this.field1003;
      this.field1003 = field991;
      field991 = var54;
      this.field1008 = var4;
      this.field1002 = var12 - (var4 >> 1);
      this.field1006 = var15;
      return var43;
   }

   @ObfuscatedName("x")
   static boolean method931(class182 var0) {
      if(!field997) {
         byte[] var1 = var0.method3182(0, 0);
         if(var1 == null) {
            return false;
         }

         method929(var1);
         field997 = true;
      }

      return true;
   }

   @ObfuscatedName("n")
   class55 method934(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1016 == null) {
            this.field1008 = 0;
            this.field1003 = new float[field995];
            this.field1016 = new byte[this.field987];
            this.field1017 = 0;
            this.field1000 = 0;
         }

         for(; this.field1000 < this.field1005.length; ++this.field1000) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method930(this.field1000);
            if(var2 != null) {
               int var3 = this.field1017;
               int var4 = var2.length;
               if(var4 > this.field987 - var3) {
                  var4 = this.field987 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1016[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1017;
               }

               this.field1017 = var3;
            }
         }

         this.field1003 = null;
         byte[] var7 = this.field1016;
         this.field1016 = null;
         return new class55(this.field986, var7, this.field988, this.field1010, this.field990);
      }
   }

   @ObfuscatedName("s")
   static float method937(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("r")
   static class54 method951(class182 var0, int var1, int var2) {
      if(!method931(var0)) {
         var0.method3184(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method3182(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method928(var1);
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class54 extends Node {
   @ObfuscatedName("v")
   boolean field974;
   @ObfuscatedName("l")
   int field975;
   @ObfuscatedName("i")
   int field976;
   @ObfuscatedName("t")
   int field977;
   @ObfuscatedName("af")
   static int[] field978;
   @ObfuscatedName("o")
   static class69[] field979;
   @ObfuscatedName("n")
   static byte[] field980;
   @ObfuscatedName("h")
   boolean field981;
   @ObfuscatedName("a")
   static int field982;
   @ObfuscatedName("s")
   static class64[] field983;
   @ObfuscatedName("x")
   static int field984;
   @ObfuscatedName("b")
   byte[][] field985;
   @ObfuscatedName("p")
   static class56[] field986;
   @ObfuscatedName("d")
   static float[] field987;
   @ObfuscatedName("q")
   int field988;
   @ObfuscatedName("y")
   static boolean[] field989;
   @ObfuscatedName("w")
   static int[] field990;
   @ObfuscatedName("m")
   static boolean field991 = false;
   @ObfuscatedName("u")
   float[] field992;
   @ObfuscatedName("f")
   static int field993;
   @ObfuscatedName("c")
   int field994;
   @ObfuscatedName("e")
   static float[] field995;
   @ObfuscatedName("ab")
   static float[] field996;
   @ObfuscatedName("j")
   static float[] field997;
   @ObfuscatedName("r")
   static int field998;
   @ObfuscatedName("g")
   static float[] field999;
   @ObfuscatedName("k")
   int field1000;
   @ObfuscatedName("aj")
   static float[] field1001;
   @ObfuscatedName("ap")
   static float[] field1002;
   @ObfuscatedName("z")
   static class52[] field1003;
   @ObfuscatedName("aw")
   static int[] field1004;
   @ObfuscatedName("ac")
   byte[] field1005;
   @ObfuscatedName("an")
   int field1006;
   @ObfuscatedName("ae")
   int field1007;

   @ObfuscatedName("b")
   static float method1059(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1060(byte[] var0, int var1) {
      field980 = var0;
      field993 = var1;
      field982 = 0;
   }

   @ObfuscatedName("t")
   static int method1062(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field982; var0 -= var3) {
         var3 = 8 - field982;
         int var4 = (1 << var3) - 1;
         var1 += (field980[field993] >> field982 & var4) << var2;
         field982 = 0;
         ++field993;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field980[field993] >> field982 & var3) << var2;
         field982 += var0;
      }

      return var1;
   }

   @ObfuscatedName("k")
   void method1063(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field975 = var2.readInt();
      this.field976 = var2.readInt();
      this.field977 = var2.readInt();
      this.field1000 = var2.readInt();
      if(this.field1000 < 0) {
         this.field1000 = ~this.field1000;
         this.field981 = true;
      }

      int var3 = var2.readInt();
      this.field985 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.method2867(var6, 0, var5);
         this.field985[var4] = var6;
      }

   }

   @ObfuscatedName("i")
   static int method1065() {
      int var0 = field980[field993] >> field982 & 1;
      ++field982;
      field993 += field982 >> 3;
      field982 &= 7;
      return var0;
   }

   @ObfuscatedName("p")
   static boolean method1066(class182 var0) {
      if(!field991) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1068(var1);
         field991 = true;
      }

      return true;
   }

   @ObfuscatedName("s")
   static class54 method1067(class182 var0, int var1, int var2) {
      if(!method1066(var0)) {
         var0.method3413(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class54(var3);
      }
   }

   class54(byte[] var1) {
      this.method1063(var1);
   }

   @ObfuscatedName("x")
   static void method1068(byte[] var0) {
      method1060(var0, 0);
      field998 = 1 << method1062(4);
      field984 = 1 << method1062(4);
      field995 = new float[field984];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field984:field998;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var13 = new float[var3];

         for(int var12 = 0; var12 < var4; ++var12) {
            var13[2 * var12] = (float)Math.cos((double)(2 * var12 + 1) * 3.141592653589793D / (double)(2 * var2));
            var13[2 * var12 + 1] = (float)Math.sin((double)(2 * var12 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var8 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var8[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var8[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = class154.method3076(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = class181.method3344(var11, var10);
         }

         if(var1 != 0) {
            field1002 = var6;
            field1001 = var13;
            field996 = var8;
            field1004 = var14;
         } else {
            field997 = var6;
            field987 = var13;
            field999 = var8;
            field978 = var14;
         }
      }

      var1 = method1062(8) + 1;
      field1003 = new class52[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1003[var2] = new class52();
      }

      var2 = method1062(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1062(16);
      }

      var2 = method1062(6) + 1;
      field986 = new class56[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field986[var3] = new class56();
      }

      var3 = method1062(6) + 1;
      field983 = new class64[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field983[var4] = new class64();
      }

      var4 = method1062(6) + 1;
      field979 = new class69[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field979[var5] = new class69();
      }

      var5 = method1062(6) + 1;
      field989 = new boolean[var5];
      field990 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field989[var15] = method1065() != 0;
         method1062(16);
         method1062(16);
         field990[var15] = method1062(8);
      }

   }

   @ObfuscatedName("o")
   class55 method1072(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1005 == null) {
            this.field988 = 0;
            this.field992 = new float[field984];
            this.field1005 = new byte[this.field976];
            this.field1006 = 0;
            this.field1007 = 0;
         }

         for(; this.field1007 < this.field985.length; ++this.field1007) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1074(this.field1007);
            if(var2 != null) {
               int var3 = this.field1006;
               int var4 = var2.length;
               if(var4 > this.field976 - var3) {
                  var4 = this.field976 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1005[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1006;
               }

               this.field1006 = var3;
            }
         }

         this.field992 = null;
         byte[] var7 = this.field1005;
         this.field1005 = null;
         return new class55(this.field975, var7, this.field977, this.field1000, this.field981);
      }
   }

   @ObfuscatedName("z")
   float[] method1074(int var1) {
      method1060(this.field985[var1], 0);
      method1065();
      int var2 = method1062(class154.method3076(field990.length - 1));
      boolean var3 = field989[var2];
      int var4 = var3?field984:field998;
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
         var8 = (var4 >> 2) - (field998 >> 2);
         var9 = (var4 >> 2) + (field998 >> 2);
         var10 = field998 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field998 >> 2);
         var12 = var4 - (var4 >> 2) + (field998 >> 2);
         var13 = field998 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class69 var14 = field979[field990[var2]];
      int var16 = var14.field1129;
      int var41 = var14.field1131[var16];
      boolean var15 = !field986[var41].method1108();
      boolean var45 = var15;

      for(var41 = 0; var41 < var14.field1130; ++var41) {
         class64 var18 = field983[var14.field1128[var41]];
         float[] var43 = field995;
         var18.method1219(var43, var4 >> 1, var45);
      }

      int var44;
      if(!var15) {
         var41 = var14.field1129;
         var44 = var14.field1131[var41];
         field986[var44].method1095(field995, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var41 = var4 >> 1; var41 < var4; ++var41) {
            field995[var41] = 0.0F;
         }
      } else {
         var41 = var4 >> 1;
         var44 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var40 = field995;

         int var21;
         for(var21 = 0; var21 < var41; ++var21) {
            var40[var21] *= 0.5F;
         }

         for(var21 = var41; var21 < var4; ++var21) {
            var40[var21] = -var40[var4 - var21 - 1];
         }

         float[] var42 = var3?field1002:field997;
         float[] var22 = var3?field1001:field987;
         float[] var23 = var3?field996:field999;
         int[] var24 = var3?field1004:field978;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var44; ++var25) {
            var26 = var40[4 * var25] - var40[var4 - 4 * var25 - 1];
            var27 = var40[4 * var25 + 2] - var40[var4 - 4 * var25 - 3];
            var28 = var42[2 * var25];
            var29 = var42[2 * var25 + 1];
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
            var30 = var42[var41 - 4 - 4 * var25];
            var31 = var42[var41 - 3 - 4 * var25];
            var40[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var40[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class154.method3076(var4 - 1);

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
                  float var38 = var42[var32 * var49];
                  float var39 = var42[var32 * var49 + 1];
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
            field995[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field995[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var17 = null;
      if(this.field988 > 0) {
         var44 = this.field988 + var4 >> 2;
         var17 = new float[var44];
         int var20;
         if(!this.field974) {
            for(var19 = 0; var19 < this.field994; ++var19) {
               var20 = (this.field988 >> 1) + var19;
               var17[var19] += this.field992[var20];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var20 = var17.length - (var4 >> 1) + var19;
               var17[var20] += field995[var19];
            }
         }
      }

      float[] var46 = this.field992;
      this.field992 = field995;
      field995 = var46;
      this.field988 = var4;
      this.field994 = var12 - (var4 >> 1);
      this.field974 = var15;
      return var17;
   }
}

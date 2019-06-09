import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("MusicSample")
public class MusicSample extends Node {
   @ObfuscatedName("g")
   @Export("__cd_g")
   static byte[] __cd_g;
   @ObfuscatedName("l")
   @Export("__cd_l")
   static int __cd_l;
   @ObfuscatedName("e")
   @Export("__cd_e")
   static int __cd_e;
   @ObfuscatedName("x")
   @Export("__cd_x")
   static int __cd_x;
   @ObfuscatedName("d")
   @Export("__cd_d")
   static int __cd_d;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lcc;"
   )
   static class98[] field1323;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lca;"
   )
   static class102[] field1324;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   static class109[] field1344;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Ldg;"
   )
   static class114[] field1326;
   @ObfuscatedName("z")
   @Export("__cd_z")
   static boolean[] __cd_z;
   @ObfuscatedName("j")
   @Export("__cd_j")
   static int[] __cd_j;
   @ObfuscatedName("s")
   @Export("__cd_s")
   static boolean __cd_s;
   @ObfuscatedName("c")
   @Export("__cd_c")
   static float[] __cd_c;
   @ObfuscatedName("r")
   @Export("__cd_r")
   static float[] __cd_r;
   @ObfuscatedName("p")
   @Export("__cd_p")
   static float[] __cd_p;
   @ObfuscatedName("v")
   @Export("__cd_v")
   static float[] __cd_v;
   @ObfuscatedName("ag")
   @Export("__cd_ag")
   static float[] __cd_ag;
   @ObfuscatedName("aq")
   @Export("__cd_aq")
   static float[] __cd_aq;
   @ObfuscatedName("aj")
   @Export("__cd_aj")
   static float[] __cd_aj;
   @ObfuscatedName("av")
   @Export("__cd_av")
   static int[] __cd_av;
   @ObfuscatedName("ar")
   @Export("__cd_ar")
   static int[] __cd_ar;
   @ObfuscatedName("m")
   @Export("__m")
   byte[][] __m;
   @ObfuscatedName("f")
   @Export("sampleRate")
   int sampleRate;
   @ObfuscatedName("q")
   @Export("sampleCount")
   int sampleCount;
   @ObfuscatedName("w")
   @Export("start")
   int start;
   @ObfuscatedName("o")
   @Export("end")
   int end;
   @ObfuscatedName("u")
   @Export("__u")
   boolean __u;
   @ObfuscatedName("t")
   @Export("__t")
   float[] __t;
   @ObfuscatedName("y")
   @Export("__y")
   int __y;
   @ObfuscatedName("h")
   @Export("__h")
   int __h;
   @ObfuscatedName("b")
   @Export("__b")
   boolean __b;
   @ObfuscatedName("ac")
   @Export("samples")
   byte[] samples;
   @ObfuscatedName("ay")
   @Export("__ay")
   int __ay;
   @ObfuscatedName("ah")
   @Export("__ah")
   int __ah;

   static {
      __cd_s = false;
   }

   MusicSample(byte[] var1) {
      this.read(var1);
   }

   @ObfuscatedName("o")
   @Export("read")
   void read(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.sampleRate = var2.readInt();
      this.sampleCount = var2.readInt();
      this.start = var2.readInt();
      this.end = var2.readInt();
      if(this.end < 0) {
         this.end = ~this.end;
         this.__u = true;
      }

      int var3 = var2.readInt();
      this.__m = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.__al_305(var7, 0, var5);
         this.__m[var4] = var7;
      }

   }

   @ObfuscatedName("g")
   @Export("__g_175")
   float[] __g_175(int var1) {
      method2337(this.__m[var1], 0);
      method2338();
      int var2 = method2352(WorldMapCacheName.method634(__cd_j.length - 1));
      boolean var3 = __cd_z[var2];
      int var4 = var3?__cd_d:__cd_x;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method2338() != 0;
         var6 = method2338() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (__cd_x >> 2);
         var9 = (__cd_x >> 2) + (var4 >> 2);
         var10 = __cd_x >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (__cd_x >> 2);
         var12 = (__cd_x >> 2) + (var4 - (var4 >> 2));
         var13 = __cd_x >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class114 var14 = field1326[__cd_j[var2]];
      int var16 = var14.field1454;
      int var17 = var14.field1452[var16];
      boolean var15 = !field1324[var17].method2367();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1453; ++var17) {
         class109 var18 = field1344[var14.field1455[var17]];
         float[] var19 = __cd_c;
         var18.method2473(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1454;
         var40 = var14.field1452[var17];
         field1324[var40].method2375(__cd_c, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            __cd_c[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var43 = __cd_c;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var43[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var43[var21] = -var43[var4 - var21 - 1];
         }

         float[] var44 = var3?__cd_ag:__cd_r;
         float[] var22 = var3?__cd_aq:__cd_p;
         float[] var23 = var3?__cd_aj:__cd_v;
         int[] var24 = var3?__cd_ar:__cd_av;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; ++var25) {
            var26 = var43[var25 * 4] - var43[var4 - var25 * 4 - 1];
            var27 = var43[var25 * 4 + 2] - var43[var4 - var25 * 4 - 3];
            var28 = var44[var25 * 2];
            var29 = var44[var25 * 2 + 1];
            var43[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var43[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var42; ++var25) {
            var26 = var43[var17 + var25 * 4 + 3];
            var27 = var43[var17 + var25 * 4 + 1];
            var28 = var43[var25 * 4 + 3];
            var29 = var43[var25 * 4 + 1];
            var43[var17 + var25 * 4 + 3] = var26 + var28;
            var43[var17 + var25 * 4 + 1] = var27 + var29;
            var30 = var44[var17 - 4 - var25 * 4];
            var31 = var44[var17 - 3 - var25 * 4];
            var43[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var43[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = WorldMapCacheName.method634(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * var50 * 2;
               int var52 = var4 - var48 * (var50 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var43[var51 - 1 - var33];
                  float var35 = var43[var51 - 3 - var33];
                  float var36 = var43[var52 - 1 - var33];
                  float var37 = var43[var52 - 3 - var33];
                  var43[var51 - 1 - var33] = var34 + var36;
                  var43[var51 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
                  var43[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var43[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var42 - 1; ++var47) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = var47 * 8;
               var50 = var48 * 8;
               var30 = var43[var49 + 1];
               var43[var49 + 1] = var43[var50 + 1];
               var43[var50 + 1] = var30;
               var30 = var43[var49 + 3];
               var43[var49 + 3] = var43[var50 + 3];
               var43[var50 + 3] = var30;
               var30 = var43[var49 + 5];
               var43[var49 + 5] = var43[var50 + 5];
               var43[var50 + 5] = var30;
               var30 = var43[var49 + 7];
               var43[var49 + 7] = var43[var50 + 7];
               var43[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var17; ++var47) {
            var43[var47] = var43[var47 * 2 + 1];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var43[var4 - 1 - var47 * 2] = var43[var47 * 4];
            var43[var4 - 2 - var47 * 2] = var43[var47 * 4 + 1];
            var43[var4 - var40 - 1 - var47 * 2] = var43[var47 * 4 + 2];
            var43[var4 - var40 - 2 - var47 * 2] = var43[var47 * 4 + 3];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var27 = var23[var47 * 2];
            var28 = var23[var47 * 2 + 1];
            var29 = var43[var17 + var47 * 2];
            var30 = var43[var17 + var47 * 2 + 1];
            var31 = var43[var4 - 2 - var47 * 2];
            float var53 = var43[var4 - 1 - var47 * 2];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var43[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
            var43[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var43[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
            var43[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47] = var43[var17 + var47 * 2] * var22[var47 * 2] + var43[var17 + var47 * 2 + 1] * var22[var47 * 2 + 1];
            var43[var17 - 1 - var47] = var43[var17 + var47 * 2] * var22[var47 * 2 + 1] - var43[var17 + var47 * 2 + 1] * var22[var47 * 2];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47 + (var4 - var40)] = -var43[var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47] = var43[var40 + var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var40 + var47] = -var43[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var17 + var47] = var43[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            __cd_c[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            __cd_c[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.__y > 0) {
         var40 = var4 + this.__y >> 2;
         var41 = new float[var40];
         int var20;
         if(!this.__b) {
            for(var42 = 0; var42 < this.__h; ++var42) {
               var20 = var42 + (this.__y >> 1);
               var41[var42] += this.__t[var20];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var20 = var41.length - (var4 >> 1) + var42;
               var41[var20] += __cd_c[var42];
            }
         }
      }

      float[] var46 = this.__t;
      this.__t = __cd_c;
      __cd_c = var46;
      this.__y = var4;
      this.__h = var12 - (var4 >> 1);
      this.__b = var15;
      return var41;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I)Lcx;"
   )
   @Export("toRawSound")
   RawSound toRawSound(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.samples == null) {
            this.__y = 0;
            this.__t = new float[__cd_d];
            this.samples = new byte[this.sampleCount];
            this.__ay = 0;
            this.__ah = 0;
         }

         for(; this.__ah < this.__m.length; ++this.__ah) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.__g_175(this.__ah);
            if(var2 != null) {
               int var3 = this.__ay;
               int var4 = var2.length;
               if(var4 > this.sampleCount - var3) {
                  var4 = this.sampleCount - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.samples[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.__ay;
               }

               this.__ay = var3;
            }
         }

         this.__t = null;
         byte[] var7 = this.samples;
         this.samples = null;
         return new RawSound(this.sampleRate, var7, this.start, this.end, this.__u);
      }
   }

   @ObfuscatedName("m")
   static float method2357(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("f")
   static void method2337(byte[] var0, int var1) {
      __cd_g = var0;
      __cd_l = var1;
      __cd_e = 0;
   }

   @ObfuscatedName("q")
   static int method2338() {
      int var0 = __cd_g[__cd_l] >> __cd_e & 1;
      ++__cd_e;
      __cd_l += __cd_e >> 3;
      __cd_e &= 7;
      return var0;
   }

   @ObfuscatedName("w")
   static int method2352(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - __cd_e; var0 -= var3) {
         var3 = 8 - __cd_e;
         int var4 = (1 << var3) - 1;
         var1 += (__cd_g[__cd_l] >> __cd_e & var4) << var2;
         __cd_e = 0;
         ++__cd_l;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (__cd_g[__cd_l] >> __cd_e & var3) << var2;
         __cd_e += var0;
      }

      return var1;
   }

   @ObfuscatedName("u")
   static void method2341(byte[] var0) {
      method2337(var0, 0);
      __cd_x = 1 << method2352(4);
      __cd_d = 1 << method2352(4);
      __cd_c = new float[__cd_d];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?__cd_d:__cd_x;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var12 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var12[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var12[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var13 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var13[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var13[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = WorldMapCacheName.method634(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = GrandExchangeEvent.method87(var11, var10);
         }

         if(var1 != 0) {
            __cd_ag = var6;
            __cd_aq = var12;
            __cd_aj = var13;
            __cd_ar = var14;
         } else {
            __cd_r = var6;
            __cd_p = var12;
            __cd_v = var13;
            __cd_av = var14;
         }
      }

      var1 = method2352(8) + 1;
      field1323 = new class98[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1323[var2] = new class98();
      }

      var2 = method2352(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method2352(16);
      }

      var2 = method2352(6) + 1;
      field1324 = new class102[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1324[var3] = new class102();
      }

      var3 = method2352(6) + 1;
      field1344 = new class109[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1344[var4] = new class109();
      }

      var4 = method2352(6) + 1;
      field1326 = new class114[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1326[var5] = new class114();
      }

      var5 = method2352(6) + 1;
      __cd_z = new boolean[var5];
      __cd_j = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         __cd_z[var15] = method2338() != 0;
         method2352(16);
         method2352(16);
         __cd_j[var15] = method2352(8);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lir;)Z"
   )
   static boolean method2343(AbstractIndexCache var0) {
      if(!__cd_s) {
         byte[] var1 = var0.takeRecord(0, 0);
         if(var1 == null) {
            return false;
         }

         method2341(var1);
         __cd_s = true;
      }

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lir;II)Lcd;"
   )
   @Export("readMusicSample")
   static MusicSample readMusicSample(AbstractIndexCache var0, int var1, int var2) {
      if(!method2343(var0)) {
         var0.tryLoadRecord(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.takeRecord(var1, var2);
         return var3 == null?null:new MusicSample(var3);
      }
   }
}

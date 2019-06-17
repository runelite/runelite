import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("MusicPatch")
public class MusicPatch extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 574200865
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lcx;"
   )
   @Export("rawSounds")
   RawSound[] rawSounds;
   @ObfuscatedName("q")
   @Export("__q")
   short[] __q;
   @ObfuscatedName("w")
   @Export("__w")
   byte[] __w;
   @ObfuscatedName("o")
   @Export("__o")
   byte[] __o;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lhd;"
   )
   @Export("__u")
   MusicPatchNode2[] __u;
   @ObfuscatedName("g")
   @Export("__g")
   byte[] __g;
   @ObfuscatedName("l")
   @Export("__l")
   int[] __l;

   MusicPatch(byte[] var1) {
      this.rawSounds = new RawSound[128];
      this.__q = new short[128];
      this.__w = new byte[128];
      this.__o = new byte[128];
      this.__u = new MusicPatchNode2[128];
      this.__g = new byte[128];
      this.__l = new int[128];
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.array[var3 + var2.index] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.readByte();
      }

      ++var2.index;
      ++var3;
      var5 = var2.index;
      var2.index += var3;

      int var6;
      for(var6 = 0; var2.array[var6 + var2.index] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.readByte();
      }

      ++var2.index;
      ++var6;
      var8 = var2.index;
      var2.index += var6;

      int var9;
      for(var9 = 0; var2.array[var9 + var2.index] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.index;
      ++var9;
      byte[] var42 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var42[1] = 1;
         int var14 = 1;
         var12 = 2;

         for(var13 = 2; var13 < var9; ++var13) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var14 = var12++;
            } else {
               if(var15 <= var14) {
                  --var15;
               }

               var14 = var15;
            }

            var42[var13] = (byte)var14;
         }
      } else {
         var12 = var9;
      }

      MusicPatchNode2[] var43 = new MusicPatchNode2[var12];

      MusicPatchNode2 var44;
      for(var13 = 0; var13 < var43.length; ++var13) {
         var44 = var43[var13] = new MusicPatchNode2();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var44.__m = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var44.__f = new byte[var16 * 2 + 2];
            var44.__f[1] = 64;
         }
      }

      var13 = var2.readUnsignedByte();
      byte[] var45 = var13 > 0?new byte[var13 * 2]:null;
      var13 = var2.readUnsignedByte();
      byte[] var17 = var13 > 0?new byte[var13 * 2]:null;

      int var18;
      for(var18 = 0; var2.array[var18 + var2.index] != 0; ++var18) {
         ;
      }

      byte[] var19 = new byte[var18];

      int var20;
      for(var20 = 0; var20 < var18; ++var20) {
         var19[var20] = var2.readByte();
      }

      ++var2.index;
      ++var18;
      var20 = 0;

      int var21;
      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.__q[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.__q[var21] = (short)(this.__q[var21] + (var20 << 8));
      }

      var21 = 0;
      int var22 = 0;
      int var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            var23 = var2.__as_311();
         }

         this.__q[var24] = (short)(this.__q[var24] + ((var23 - 1 & 2) << 14));
         this.__l[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.__l[var25] != 0) {
            if(var21 == 0) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.array[var5++] - 1;
            }

            this.__g[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.__l[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.array[var8++] + 16 << 2;
            }

            this.__o[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      MusicPatchNode2 var46 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.__l[var27] != 0) {
            if(var21 == 0) {
               var46 = var43[var42[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.__u[var27] = var46;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var27 = 0;

      int var28;
      for(var28 = 0; var28 < 128; ++var28) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            if(this.__l[var28] > 0) {
               var27 = var2.readUnsignedByte() + 1;
            }
         }

         this.__w[var28] = (byte)var27;
         --var21;
      }

      this.__m = var2.readUnsignedByte() + 1;

      MusicPatchNode2 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__m != null) {
            for(var30 = 1; var30 < var29.__m.length; var30 += 2) {
               var29.__m[var30] = var2.readByte();
            }
         }

         if(var29.__f != null) {
            for(var30 = 3; var30 < var29.__f.length - 2; var30 += 2) {
               var29.__f[var30] = var2.readByte();
            }
         }
      }

      if(var45 != null) {
         for(var28 = 1; var28 < var45.length; var28 += 2) {
            var45[var28] = var2.readByte();
         }
      }

      if(var17 != null) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.readByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__f != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.__f.length; var30 += 2) {
               var20 = 1 + var20 + var2.readUnsignedByte();
               var29.__f[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__m != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.__m.length; var30 += 2) {
               var20 = 1 + var20 + var2.readUnsignedByte();
               var29.__m[var30] = (byte)var20;
            }
         }
      }

      byte var31;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var37;
      byte var38;
      if(var45 != null) {
         var20 = var2.readUnsignedByte();
         var45[0] = (byte)var20;

         for(var28 = 2; var28 < var45.length; var28 += 2) {
            var20 = 1 + var20 + var2.readUnsignedByte();
            var45[var28] = (byte)var20;
         }

         var38 = var45[0];
         byte var39 = var45[1];

         for(var30 = 0; var30 < var38; ++var30) {
            this.__w[var30] = (byte)(var39 * this.__w[var30] + 32 >> 6);
         }

         for(var30 = 2; var30 < var45.length; var30 += 2) {
            var31 = var45[var30];
            byte var40 = var45[var30 + 1];
            var32 = var39 * (var31 - var38) + (var31 - var38) / 2;

            for(var33 = var38; var33 < var31; ++var33) {
               var35 = var31 - var38;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.__w[var33] = (byte)(var34 * this.__w[var33] + 32 >> 6);
               var32 += var40 - var39;
            }

            var38 = var31;
            var39 = var40;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            this.__w[var37] = (byte)(var39 * this.__w[var37] + 32 >> 6);
         }

         var44 = null;
      }

      if(var17 != null) {
         var20 = var2.readUnsignedByte();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = 1 + var20 + var2.readUnsignedByte();
            var17[var28] = (byte)var20;
         }

         var38 = var17[0];
         int var47 = var17[1] << 1;

         for(var30 = 0; var30 < var38; ++var30) {
            var37 = var47 + (this.__o[var30] & 255);
            if(var37 < 0) {
               var37 = 0;
            }

            if(var37 > 128) {
               var37 = 128;
            }

            this.__o[var30] = (byte)var37;
         }

         int var48;
         for(var30 = 2; var30 < var17.length; var30 += 2) {
            var31 = var17[var30];
            var48 = var17[var30 + 1] << 1;
            var32 = var47 * (var31 - var38) + (var31 - var38) / 2;

            for(var33 = var38; var33 < var31; ++var33) {
               var35 = var31 - var38;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var41 = var34 + (this.__o[var33] & 255);
               if(var41 < 0) {
                  var41 = 0;
               }

               if(var41 > 128) {
                  var41 = 128;
               }

               this.__o[var33] = (byte)var41;
               var32 += var48 - var47;
            }

            var38 = var31;
            var47 = var48;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            var48 = var47 + (this.__o[var37] & 255);
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.__o[var37] = (byte)var48;
         }

         Object var49 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].__q = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__m != null) {
            var29.__w = var2.readUnsignedByte();
         }

         if(var29.__f != null) {
            var29.__o = var2.readUnsignedByte();
         }

         if(var29.__q > 0) {
            var29.__u = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].__l = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__l > 0) {
            var29.__g = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.__g > 0) {
            var29.__e = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ldt;[B[II)Z",
      garbageValue = "1828768318"
   )
   @Export("__f_373")
   boolean __f_373(SoundCache var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      RawSound var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.__l[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.getSoundEffect(var8 >> 2, var3);
                  } else {
                     var6 = var1.getMusicSample(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.rawSounds[var7] = var6;
                  this.__l[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   @Export("clear")
   void clear() {
      this.__l = null;
   }
}

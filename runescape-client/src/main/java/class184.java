import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class184 extends Node {
   @ObfuscatedName("i")
   byte[] field2981 = new byte[128];
   @ObfuscatedName("r")
   class65[] field2982 = new class65[128];
   @ObfuscatedName("l")
   byte[] field2983 = new byte[128];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -756342569
   )
   int field2984;
   @ObfuscatedName("z")
   byte[] field2985 = new byte[128];
   @ObfuscatedName("b")
   class188[] field2986 = new class188[128];
   @ObfuscatedName("m")
   int[] field2988 = new int[128];
   @ObfuscatedName("j")
   short[] field2989 = new short[128];
   @ObfuscatedName("rs")
   protected static boolean field2991;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "210899753"
   )
   void method3541() {
      this.field2988 = null;
   }

   class184(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var2.offset + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2557();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var2.offset + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2557();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2557();
      }

      ++var2.offset;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var39 = var2.method2556();
            if(var39 == 0) {
               var13 = var12++;
            } else {
               if(var39 <= var13) {
                  --var39;
               }

               var13 = var39;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var41 = new class188[var12];

      class188 var15;
      for(var14 = 0; var14 < var41.length; ++var14) {
         var15 = var41[var14] = new class188();
         int var16 = var2.method2556();
         if(var16 > 0) {
            var15.field3047 = new byte[2 * var16];
         }

         var16 = var2.method2556();
         if(var16 > 0) {
            var15.field3046 = new byte[2 + var16 * 2];
            var15.field3046[1] = 64;
         }
      }

      var14 = var2.method2556();
      byte[] var44 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.method2556();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2557();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2556();
         this.field2989[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2556();
         this.field2989[var20] = (short)(this.field2989[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2737();
         }

         this.field2989[var23] = (short)(this.field2989[var23] + ((var22 - 1 & 2) << 14));
         this.field2988[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2988[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2983[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var43 = 0; var43 < 128; ++var43) {
         if(this.field2988[var43] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2981[var43] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2988[var26] != 0) {
            if(var20 == 0) {
               var25 = var41[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2986[var26] = var25;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2988[var27] > 0) {
               var26 = var2.method2556() + 1;
            }
         }

         this.field2985[var27] = (byte)var26;
         --var20;
      }

      this.field2984 = var2.method2556() + 1;

      int var29;
      class188 var40;
      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(var40.field3047 != null) {
            for(var29 = 1; var29 < var40.field3047.length; var29 += 2) {
               var40.field3047[var29] = var2.method2557();
            }
         }

         if(var40.field3046 != null) {
            for(var29 = 3; var29 < var40.field3046.length - 2; var29 += 2) {
               var40.field3046[var29] = var2.method2557();
            }
         }
      }

      if(null != var44) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.method2557();
         }
      }

      if(null != var42) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2557();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(var40.field3046 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var40.field3046.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2556();
               var40.field3046[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(null != var40.field3047) {
            var19 = 0;

            for(var29 = 2; var29 < var40.field3047.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2556();
               var40.field3047[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var46;
      byte var48;
      if(null != var44) {
         var19 = var2.method2556();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2556();
            var44[var27] = (byte)var19;
         }

         var48 = var44[0];
         byte var28 = var44[1];

         for(var29 = 0; var29 < var48; ++var29) {
            this.field2985[var29] = (byte)(this.field2985[var29] * var28 + 32 >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[var29 + 1];
            var32 = (var30 - var48) / 2 + var28 * (var30 - var48);

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2985[var33] = (byte)(32 + var34 * this.field2985[var33] >> 6);
               var32 += var31 - var28;
            }

            var48 = var30;
            var28 = var31;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            this.field2985[var46] = (byte)(var28 * this.field2985[var46] + 32 >> 6);
         }

         var15 = null;
      }

      if(null != var42) {
         var19 = var2.method2556();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2556();
            var42[var27] = (byte)var19;
         }

         var48 = var42[0];
         int var45 = var42[1] << 1;

         for(var29 = 0; var29 < var48; ++var29) {
            var46 = var45 + (this.field2981[var29] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2981[var29] = (byte)var46;
         }

         int var47;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var47 = var42[1 + var29] << 1;
            var32 = (var30 - var48) / 2 + var45 * (var30 - var48);

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field2981[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2981[var33] = (byte)var37;
               var32 += var47 - var45;
            }

            var48 = var30;
            var45 = var47;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            var47 = var45 + (this.field2981[var46] & 255);
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field2981[var46] = (byte)var47;
         }

         Object var49 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var41[var27].field3048 = var2.method2556();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(var40.field3047 != null) {
            var40.field3055 = var2.method2556();
         }

         if(var40.field3046 != null) {
            var40.field3050 = var2.method2556();
         }

         if(var40.field3048 > 0) {
            var40.field3051 = var2.method2556();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var41[var27].field3053 = var2.method2556();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(var40.field3053 > 0) {
            var40.field3052 = var2.method2556();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40 = var41[var27];
         if(var40.field3052 > 0) {
            var40.field3054 = var2.method2556();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[II)Z",
      garbageValue = "357273524"
   )
   boolean method3549(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2988[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1304(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1305(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2982[var7] = var6;
                  this.field2988[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-3"
   )
   public static String method3551(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }
}

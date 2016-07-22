import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class184 extends class211 {
   @ObfuscatedName("r")
   int[] field2979 = new int[128];
   @ObfuscatedName("w")
   class65[] field2980 = new class65[128];
   @ObfuscatedName("o")
   byte[] field2981 = new byte[128];
   @ObfuscatedName("g")
   byte[] field2982 = new byte[128];
   @ObfuscatedName("l")
   class188[] field2983 = new class188[128];
   @ObfuscatedName("j")
   byte[] field2984 = new byte[128];
   @ObfuscatedName("bt")
   static class171 field2985;
   @ObfuscatedName("e")
   short[] field2986 = new short[128];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1035890249
   )
   int field2989;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[IB)Z",
      garbageValue = "3"
   )
   boolean method3577(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2979[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1342(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1337(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2980[var7] = var6;
                  this.field2979[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class184(byte[] var1) {
      class122 var2 = new class122(var1);

      int var3;
      for(var3 = 0; var2.field2047[var2.field2045 + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2573();
      }

      ++var2.field2045;
      ++var3;
      var5 = var2.field2045;
      var2.field2045 += var3;

      int var6;
      for(var6 = 0; var2.field2047[var2.field2045 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2573();
      }

      ++var2.field2045;
      ++var6;
      var8 = var2.field2045;
      var2.field2045 += var6;

      int var9;
      for(var9 = 0; var2.field2047[var9 + var2.field2045] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2573();
      }

      ++var2.field2045;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var37 = var2.method2556();
            if(var37 == 0) {
               var13 = var12++;
            } else {
               if(var37 <= var13) {
                  --var37;
               }

               var13 = var37;
            }

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var39 = new class188[var12];

      class188 var15;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var15 = var39[var14] = new class188();
         int var40 = var2.method2556();
         if(var40 > 0) {
            var15.field3044 = new byte[var40 * 2];
         }

         var40 = var2.method2556();
         if(var40 > 0) {
            var15.field3048 = new byte[2 + 2 * var40];
            var15.field3048[1] = 64;
         }
      }

      var14 = var2.method2556();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2556();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.field2047[var2.field2045 + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2573();
      }

      ++var2.field2045;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2556();
         this.field2986[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2556();
         this.field2986[var20] = (short)(this.field2986[var20] + (var19 << 8));
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

            var22 = var2.method2687();
         }

         this.field2986[var23] = (short)(this.field2986[var23] + ((var22 - 1 & 2) << 14));
         this.field2979[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2979[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2047[var5++] - 1;
            }

            this.field2984[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2979[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2047[var8++] + 16 << 2;
            }

            this.field2982[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2979[var26] != 0) {
            if(var20 == 0) {
               var41 = var39[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2983[var26] = var41;
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

            if(this.field2979[var27] > 0) {
               var26 = var2.method2556() + 1;
            }
         }

         this.field2981[var27] = (byte)var26;
         --var20;
      }

      this.field2989 = var2.method2556() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3044 != null) {
            for(var29 = 1; var29 < var28.field3044.length; var29 += 2) {
               var28.field3044[var29] = var2.method2573();
            }
         }

         if(null != var28.field3048) {
            for(var29 = 3; var29 < var28.field3048.length - 2; var29 += 2) {
               var28.field3048[var29] = var2.method2573();
            }
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2573();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.method2573();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3048) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3048.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2556();
               var28.field3048[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3044) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3044.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2556();
               var28.field3044[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var44;
      byte var46;
      if(null != var42) {
         var19 = var2.method2556();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2556();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         byte var38 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2981[var29] = (byte)(32 + this.field2981[var29] * var38 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = var38 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class154.method3192(var32, var30 - var46);
               this.field2981[var33] = (byte)(var34 * this.field2981[var33] + 32 >> 6);
               var32 += var31 - var38;
            }

            var46 = var30;
            var38 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2981[var44] = (byte)(32 + this.field2981[var44] * var38 >> 6);
         }

         var15 = null;
      }

      if(var16 != null) {
         var19 = var2.method2556();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2556();
            var16[var27] = (byte)var19;
         }

         var46 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = (this.field2982[var29] & 255) + var47;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2982[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var45 = var16[1 + var29] << 1;
            var32 = var47 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class154.method3192(var32, var30 - var46);
               int var35 = var34 + (this.field2982[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2982[var33] = (byte)var35;
               var32 += var45 - var47;
            }

            var46 = var30;
            var47 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var47 + (this.field2982[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2982[var44] = (byte)var45;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3042 = var2.method2556();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3044) {
            var28.field3043 = var2.method2556();
         }

         if(null != var28.field3048) {
            var28.field3040 = var2.method2556();
         }

         if(var28.field3042 > 0) {
            var28.field3045 = var2.method2556();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3041 = var2.method2556();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3041 > 0) {
            var28.field3047 = var2.method2556();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3047 > 0) {
            var28.field3046 = var2.method2556();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2031187495"
   )
   void method3580() {
      this.field2979 = null;
   }
}

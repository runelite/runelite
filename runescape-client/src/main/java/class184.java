import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class184 extends Node {
   @ObfuscatedName("t")
   short[] field2972 = new short[128];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2048210013
   )
   int field2973;
   @ObfuscatedName("y")
   byte[] field2974 = new byte[128];
   @ObfuscatedName("p")
   byte[] field2975 = new byte[128];
   @ObfuscatedName("g")
   class188[] field2976 = new class188[128];
   @ObfuscatedName("m")
   byte[] field2977 = new byte[128];
   @ObfuscatedName("f")
   int[] field2978 = new int[128];
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1834819931
   )
   static int field2979;
   @ObfuscatedName("z")
   class65[] field2980 = new class65[128];

   class184(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var3 + var2.offset] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2601();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2601();
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
         var10[var11] = var2.method2601();
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
            int var15 = var2.method2481();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var40 = new class188[var12];

      class188 var36;
      for(var14 = 0; var14 < var40.length; ++var14) {
         var36 = var40[var14] = new class188();
         int var37 = var2.method2481();
         if(var37 > 0) {
            var36.field3050 = new byte[var37 * 2];
         }

         var37 = var2.method2481();
         if(var37 > 0) {
            var36.field3040 = new byte[2 * var37 + 2];
            var36.field3040[1] = 64;
         }
      }

      var14 = var2.method2481();
      byte[] var46 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.method2481();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2601();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2481();
         this.field2972[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2481();
         this.field2972[var20] = (short)(this.field2972[var20] + (var19 << 8));
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

            var22 = var2.method2497();
         }

         this.field2972[var23] = (short)(this.field2972[var23] + ((var22 - 1 & 2) << 14));
         this.field2978[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2978[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2977[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var41 = 0; var41 < 128; ++var41) {
         if(this.field2978[var41] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2975[var41] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2978[var26] != 0) {
            if(var20 == 0) {
               var25 = var40[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2976[var26] = var25;
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

            if(this.field2978[var27] > 0) {
               var26 = var2.method2481() + 1;
            }
         }

         this.field2974[var27] = (byte)var26;
         --var20;
      }

      this.field2973 = var2.method2481() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(null != var28.field3050) {
            for(var29 = 1; var29 < var28.field3050.length; var29 += 2) {
               var28.field3050[var29] = var2.method2601();
            }
         }

         if(var28.field3040 != null) {
            for(var29 = 3; var29 < var28.field3040.length - 2; var29 += 2) {
               var28.field3040[var29] = var2.method2601();
            }
         }
      }

      if(var46 != null) {
         for(var27 = 1; var27 < var46.length; var27 += 2) {
            var46[var27] = var2.method2601();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.method2601();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field3040 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3040.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2481();
               var28.field3040[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(null != var28.field3050) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3050.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2481();
               var28.field3050[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var43;
      byte var45;
      if(var46 != null) {
         var19 = var2.method2481();
         var46[0] = (byte)var19;

         for(var27 = 2; var27 < var46.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2481();
            var46[var27] = (byte)var19;
         }

         var45 = var46[0];
         byte var39 = var46[1];

         for(var29 = 0; var29 < var45; ++var29) {
            this.field2974[var29] = (byte)(this.field2974[var29] * var39 + 32 >> 6);
         }

         for(var29 = 2; var29 < var46.length; var29 += 2) {
            var30 = var46[var29];
            byte var31 = var46[var29 + 1];
            var32 = var39 * (var30 - var45) + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class77.method1600(var32, var30 - var45);
               this.field2974[var33] = (byte)(this.field2974[var33] * var34 + 32 >> 6);
               var32 += var31 - var39;
            }

            var45 = var30;
            var39 = var31;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            this.field2974[var43] = (byte)(var39 * this.field2974[var43] + 32 >> 6);
         }

         var36 = null;
      }

      if(null != var16) {
         var19 = var2.method2481();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2481();
            var16[var27] = (byte)var19;
         }

         var45 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var45; ++var29) {
            var43 = (this.field2975[var29] & 255) + var47;
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2975[var29] = (byte)var43;
         }

         int var44;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var44 = var16[var29 + 1] << 1;
            var32 = (var30 - var45) * var47 + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class77.method1600(var32, var30 - var45);
               int var35 = var34 + (this.field2975[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2975[var33] = (byte)var35;
               var32 += var44 - var47;
            }

            var45 = var30;
            var47 = var44;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            var44 = (this.field2975[var43] & 255) + var47;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2975[var43] = (byte)var44;
         }

         Object var42 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field3041 = var2.method2481();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field3050 != null) {
            var28.field3042 = var2.method2481();
         }

         if(var28.field3040 != null) {
            var28.field3043 = var2.method2481();
         }

         if(var28.field3041 > 0) {
            var28.field3044 = var2.method2481();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field3048 = var2.method2481();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field3048 > 0) {
            var28.field3045 = var2.method2481();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field3045 > 0) {
            var28.field3039 = var2.method2481();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method3512() {
      this.field2978 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[II)Z",
      garbageValue = "1889107240"
   )
   boolean method3515(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2978[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1261(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1262(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2980[var7] = var6;
                  this.field2978[var7] = 0;
               }
            }
         }
      }

      return var4;
   }
}

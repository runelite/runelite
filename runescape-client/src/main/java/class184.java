import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class184 extends class211 {
   @ObfuscatedName("k")
   byte[] field2984 = new byte[128];
   @ObfuscatedName("g")
   class65[] field2985 = new class65[128];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1433350541
   )
   int field2986;
   @ObfuscatedName("r")
   short[] field2987 = new short[128];
   @ObfuscatedName("h")
   byte[] field2988 = new byte[128];
   @ObfuscatedName("s")
   class188[] field2989 = new class188[128];
   @ObfuscatedName("u")
   int[] field2990 = new int[128];
   @ObfuscatedName("e")
   byte[] field2991 = new byte[128];

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-122156365"
   )
   void method3679() {
      this.field2990 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[IB)Z",
      garbageValue = "-49"
   )
   boolean method3683(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2990[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1386(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1387(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2985[var7] = var6;
                  this.field2990[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class184(byte[] var1) {
      class122 var2 = new class122(var1);

      int var3;
      for(var3 = 0; var2.field2051[var3 + var2.field2050] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2634();
      }

      ++var2.field2050;
      ++var3;
      var5 = var2.field2050;
      var2.field2050 += var3;

      int var6;
      for(var6 = 0; var2.field2051[var6 + var2.field2050] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2634();
      }

      ++var2.field2050;
      ++var6;
      var8 = var2.field2050;
      var2.field2050 += var6;

      int var9;
      for(var9 = 0; var2.field2051[var2.field2050 + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2634();
      }

      ++var2.field2050;
      ++var9;
      byte[] var41 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var41[1] = 1;
         int var38 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2633();
            if(var15 == 0) {
               var38 = var12++;
            } else {
               if(var15 <= var38) {
                  --var15;
               }

               var38 = var15;
            }

            var41[var14] = (byte)var38;
         }
      } else {
         var12 = var9;
      }

      class188[] var13 = new class188[var12];

      class188 var39;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var39 = var13[var14] = new class188();
         int var16 = var2.method2633();
         if(var16 > 0) {
            var39.field3050 = new byte[var16 * 2];
         }

         var16 = var2.method2633();
         if(var16 > 0) {
            var39.field3043 = new byte[2 * var16 + 2];
            var39.field3043[1] = 64;
         }
      }

      var14 = var2.method2633();
      byte[] var47 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2633();
      byte[] var43 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.field2051[var2.field2050 + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2634();
      }

      ++var2.field2050;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2633();
         this.field2987[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2633();
         this.field2987[var20] = (short)(this.field2987[var20] + (var19 << 8));
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

            var22 = var2.method2832();
         }

         this.field2987[var23] = (short)(this.field2987[var23] + ((var22 - 1 & 2) << 14));
         this.field2990[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2990[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2051[var5++] - 1;
            }

            this.field2984[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2990[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2051[var8++] + 16 << 2;
            }

            this.field2988[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2990[var26] != 0) {
            if(var20 == 0) {
               var42 = var13[var41[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2989[var26] = var42;
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

            if(this.field2990[var27] > 0) {
               var26 = var2.method2633() + 1;
            }
         }

         this.field2991[var27] = (byte)var26;
         --var20;
      }

      this.field2986 = var2.method2633() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3050 != null) {
            for(var29 = 1; var29 < var28.field3050.length; var29 += 2) {
               var28.field3050[var29] = var2.method2634();
            }
         }

         if(null != var28.field3043) {
            for(var29 = 3; var29 < var28.field3043.length - 2; var29 += 2) {
               var28.field3043[var29] = var2.method2634();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.method2634();
         }
      }

      if(null != var43) {
         for(var27 = 1; var27 < var43.length; var27 += 2) {
            var43[var27] = var2.method2634();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3043 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3043.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2633();
               var28.field3043[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3050 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3050.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2633();
               var28.field3050[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var44;
      byte var46;
      if(null != var47) {
         var19 = var2.method2633();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2633();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var40 = var47[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2991[var29] = (byte)(var40 * this.field2991[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[1 + var29];
            var32 = (var30 - var46) * var40 + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2991[var33] = (byte)(32 + this.field2991[var33] * var34 >> 6);
               var32 += var31 - var40;
            }

            var46 = var30;
            var40 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2991[var44] = (byte)(32 + var40 * this.field2991[var44] >> 6);
         }

         var39 = null;
      }

      if(var43 != null) {
         var19 = var2.method2633();
         var43[0] = (byte)var19;

         for(var27 = 2; var27 < var43.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2633();
            var43[var27] = (byte)var19;
         }

         var46 = var43[0];
         int var48 = var43[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = (this.field2988[var29] & 255) + var48;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2988[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var43.length; var29 += 2) {
            var30 = var43[var29];
            var45 = var43[1 + var29] << 1;
            var32 = var48 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field2988[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2988[var33] = (byte)var37;
               var32 += var45 - var48;
            }

            var46 = var30;
            var48 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var48 + (this.field2988[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2988[var44] = (byte)var45;
         }

         Object var49 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3044 = var2.method2633();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3050 != null) {
            var28.field3045 = var2.method2633();
         }

         if(var28.field3043 != null) {
            var28.field3042 = var2.method2633();
         }

         if(var28.field3044 > 0) {
            var28.field3047 = var2.method2633();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3049 = var2.method2633();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3049 > 0) {
            var28.field3048 = var2.method2633();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3048 > 0) {
            var28.field3054 = var2.method2633();
         }
      }

   }
}

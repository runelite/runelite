import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class181 extends class208 {
   @ObfuscatedName("f")
   byte[] field2950 = new byte[128];
   @ObfuscatedName("i")
   class62[] field2951 = new class62[128];
   @ObfuscatedName("g")
   short[] field2952 = new short[128];
   @ObfuscatedName("h")
   byte[] field2953 = new byte[128];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -463797641
   )
   int field2954;
   @ObfuscatedName("z")
   byte[] field2955 = new byte[128];
   @ObfuscatedName("s")
   int[] field2957 = new int[128];
   @ObfuscatedName("r")
   class185[] field2959 = new class185[128];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "7888"
   )
   void method3469() {
      this.field2957 = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass59;[B[IB)Z",
      garbageValue = "-104"
   )
   boolean method3475(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2957[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1219(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1220(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2951[var7] = var6;
                  this.field2957[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; var2.field2001[var2.field2000 + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2469();
      }

      ++var2.field2000;
      ++var3;
      var5 = var2.field2000;
      var2.field2000 += var3;

      int var6;
      for(var6 = 0; var2.field2001[var2.field2000 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2469();
      }

      ++var2.field2000;
      ++var6;
      var8 = var2.field2000;
      var2.field2000 += var6;

      int var9;
      for(var9 = 0; var2.field2001[var9 + var2.field2000] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2469();
      }

      ++var2.field2000;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var40 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var39 = var2.method2494();
            if(var39 == 0) {
               var40 = var12++;
            } else {
               if(var39 <= var40) {
                  --var39;
               }

               var40 = var39;
            }

            var38[var14] = (byte)var40;
         }
      } else {
         var12 = var9;
      }

      class185[] var13 = new class185[var12];

      class185 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class185();
         int var16 = var2.method2494();
         if(var16 > 0) {
            var15.field3011 = new byte[var16 * 2];
         }

         var16 = var2.method2494();
         if(var16 > 0) {
            var15.field3013 = new byte[var16 * 2 + 2];
            var15.field3013[1] = 64;
         }
      }

      var14 = var2.method2494();
      byte[] var44 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2494();
      byte[] var41 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.field2001[var17 + var2.field2000] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2469();
      }

      ++var2.field2000;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2494();
         this.field2952[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2494();
         this.field2952[var20] = (short)(this.field2952[var20] + (var19 << 8));
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

            var22 = var2.method2452();
         }

         this.field2952[var23] = (short)(this.field2952[var23] + ((var22 - 1 & 2) << 14));
         this.field2957[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2957[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2001[var5++] - 1;
            }

            this.field2950[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2957[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2001[var8++] + 16 << 2;
            }

            this.field2955[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class185 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2957[var26] != 0) {
            if(var20 == 0) {
               var43 = var13[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2959[var26] = var43;
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

            if(this.field2957[var27] > 0) {
               var26 = var2.method2494() + 1;
            }
         }

         this.field2953[var27] = (byte)var26;
         --var20;
      }

      this.field2954 = var2.method2494() + 1;

      class185 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3011) {
            for(var29 = 1; var29 < var28.field3011.length; var29 += 2) {
               var28.field3011[var29] = var2.method2469();
            }
         }

         if(var28.field3013 != null) {
            for(var29 = 3; var29 < var28.field3013.length - 2; var29 += 2) {
               var28.field3013[var29] = var2.method2469();
            }
         }
      }

      if(var44 != null) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.method2469();
         }
      }

      if(null != var41) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method2469();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3013 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3013.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2494();
               var28.field3013[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field3011) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3011.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2494();
               var28.field3011[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var45;
      byte var47;
      if(var44 != null) {
         var19 = var2.method2494();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2494();
            var44[var27] = (byte)var19;
         }

         var47 = var44[0];
         byte var42 = var44[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2953[var29] = (byte)(var42 * this.field2953[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[var29 + 1];
            var32 = var42 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2953[var33] = (byte)(var34 * this.field2953[var33] + 32 >> 6);
               var32 += var31 - var42;
            }

            var47 = var30;
            var42 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2953[var45] = (byte)(32 + this.field2953[var45] * var42 >> 6);
         }

         var15 = null;
      }

      if(null != var41) {
         var19 = var2.method2494();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2494();
            var41[var27] = (byte)var19;
         }

         var47 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2955[var29] & 255) + var49;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2955[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var46 = var41[1 + var29] << 1;
            var32 = (var30 - var47) / 2 + var49 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field2955[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2955[var33] = (byte)var37;
               var32 += var46 - var49;
            }

            var47 = var30;
            var49 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var49 + (this.field2955[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2955[var45] = (byte)var46;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3017 = var2.method2494();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3011 != null) {
            var28.field3014 = var2.method2494();
         }

         if(var28.field3013 != null) {
            var28.field3015 = var2.method2494();
         }

         if(var28.field3017 > 0) {
            var28.field3016 = var2.method2494();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3018 = var2.method2494();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3018 > 0) {
            var28.field3012 = var2.method2494();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field3012 > 0) {
            var28.field3019 = var2.method2494();
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1207125013"
   )
   static final void method3476(class37 var0) {
      int var1 = var0.field848 - client.field332;
      int var2 = var0.field813 * 128 + var0.field807 * 64;
      int var3 = var0.field807 * 64 + var0.field846 * 128;
      var0.field809 += (var2 - var0.field809) / var1;
      var0.field804 += (var3 - var0.field804) / var1;
      var0.field860 = 0;
      var0.field831 = var0.field850;
   }
}

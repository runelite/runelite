import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class181 extends class208 {
   @ObfuscatedName("w")
   class62[] field2936 = new class62[128];
   @ObfuscatedName("k")
   class185[] field2937 = new class185[128];
   @ObfuscatedName("c")
   byte[] field2938 = new byte[128];
   @ObfuscatedName("y")
   byte[] field2939 = new byte[128];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1888160513
   )
   int field2940;
   @ObfuscatedName("r")
   byte[] field2941 = new byte[128];
   @ObfuscatedName("bb")
   static class168 field2943;
   @ObfuscatedName("d")
   short[] field2944 = new short[128];
   @ObfuscatedName("p")
   int[] field2946 = new int[128];

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass59;[B[II)Z",
      garbageValue = "1246466737"
   )
   boolean method3598(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2946[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1344(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1353(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2936[var7] = var6;
                  this.field2946[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "773418990"
   )
   void method3600() {
      this.field2946 = null;
   }

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; 0 != var2.field1993[var2.field1992 + var3]; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2699();
      }

      ++var2.field1992;
      ++var3;
      var5 = var2.field1992;
      var2.field1992 += var3;

      int var6;
      for(var6 = 0; var2.field1993[var2.field1992 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2699();
      }

      ++var2.field1992;
      ++var6;
      var8 = var2.field1992;
      var2.field1992 += var6;

      int var9;
      for(var9 = 0; 0 != var2.field1993[var9 + var2.field1992]; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2699();
      }

      ++var2.field1992;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2613();
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

      class185[] var39 = new class185[var12];

      class185 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class185();
         int var16 = var2.method2613();
         if(var16 > 0) {
            var40.field3007 = new byte[var16 * 2];
         }

         var16 = var2.method2613();
         if(var16 > 0) {
            var40.field3016 = new byte[2 * var16 + 2];
            var40.field3016[1] = 64;
         }
      }

      var14 = var2.method2613();
      byte[] var41 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2613();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; 0 != var2.field1993[var2.field1992 + var17]; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2699();
      }

      ++var2.field1992;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2613();
         this.field2944[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2613();
         this.field2944[var20] = (short)(this.field2944[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(0 == var20) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2628();
         }

         this.field2944[var23] = (short)(this.field2944[var23] + ((var22 - 1 & 2) << 14));
         this.field2946[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2946[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field1993[var5++] - 1;
            }

            this.field2941[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(0 != this.field2946[var25]) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field1993[var8++] + 16 << 2;
            }

            this.field2939[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class185 var44 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(0 != this.field2946[var26]) {
            if(var20 == 0) {
               var44 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2937[var26] = var44;
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

            if(this.field2946[var27] > 0) {
               var26 = var2.method2613() + 1;
            }
         }

         this.field2938[var27] = (byte)var26;
         --var20;
      }

      this.field2940 = var2.method2613() + 1;

      class185 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3007 != null) {
            for(var29 = 1; var29 < var28.field3007.length; var29 += 2) {
               var28.field3007[var29] = var2.method2699();
            }
         }

         if(null != var28.field3016) {
            for(var29 = 3; var29 < var28.field3016.length - 2; var29 += 2) {
               var28.field3016[var29] = var2.method2699();
            }
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method2699();
         }
      }

      if(null != var42) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2699();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3016 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3016.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2613();
               var28.field3016[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3007 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3007.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2613();
               var28.field3007[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var47;
      byte var49;
      if(null != var41) {
         var19 = var2.method2613();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2613();
            var41[var27] = (byte)var19;
         }

         var49 = var41[0];
         byte var45 = var41[1];

         for(var29 = 0; var29 < var49; ++var29) {
            this.field2938[var29] = (byte)(32 + this.field2938[var29] * var45 >> 6);
         }

         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            byte var31 = var41[1 + var29];
            var32 = (var30 - var49) * var45 + (var30 - var49) / 2;

            for(var33 = var49; var33 < var30; ++var33) {
               var35 = var30 - var49;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2938[var33] = (byte)(32 + this.field2938[var33] * var34 >> 6);
               var32 += var31 - var45;
            }

            var49 = var30;
            var45 = var31;
         }

         for(var47 = var49; var47 < 128; ++var47) {
            this.field2938[var47] = (byte)(var45 * this.field2938[var47] + 32 >> 6);
         }

         var40 = null;
      }

      if(var42 != null) {
         var19 = var2.method2613();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2613();
            var42[var27] = (byte)var19;
         }

         var49 = var42[0];
         int var46 = var42[1] << 1;

         for(var29 = 0; var29 < var49; ++var29) {
            var47 = (this.field2939[var29] & 255) + var46;
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field2939[var29] = (byte)var47;
         }

         int var48;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var48 = var42[1 + var29] << 1;
            var32 = (var30 - var49) * var46 + (var30 - var49) / 2;

            for(var33 = var49; var33 < var30; ++var33) {
               var35 = var30 - var49;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = var34 + (this.field2939[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2939[var33] = (byte)var37;
               var32 += var48 - var46;
            }

            var49 = var30;
            var46 = var48;
         }

         for(var47 = var49; var47 < 128; ++var47) {
            var48 = var46 + (this.field2939[var47] & 255);
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.field2939[var47] = (byte)var48;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3009 = var2.method2613();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3007 != null) {
            var28.field3008 = var2.method2613();
         }

         if(null != var28.field3016) {
            var28.field3010 = var2.method2613();
         }

         if(var28.field3009 > 0) {
            var28.field3012 = var2.method2613();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3014 = var2.method2613();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3014 > 0) {
            var28.field3011 = var2.method2613();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3011 > 0) {
            var28.field3015 = var2.method2613();
         }
      }

   }
}

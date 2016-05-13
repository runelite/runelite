import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class181 extends class208 {
   @ObfuscatedName("cq")
   static class224 field2945;
   @ObfuscatedName("x")
   byte[] field2946 = new byte[128];
   @ObfuscatedName("p")
   short[] field2947 = new short[128];
   @ObfuscatedName("d")
   byte[] field2949 = new byte[128];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -642762271
   )
   int field2950;
   @ObfuscatedName("o")
   byte[] field2951 = new byte[128];
   @ObfuscatedName("u")
   class185[] field2952 = new class185[128];
   @ObfuscatedName("j")
   class62[] field2953 = new class62[128];
   @ObfuscatedName("b")
   int[] field2954 = new int[128];

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass59;[B[II)Z",
      garbageValue = "1802277992"
   )
   boolean method3506(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || 0 != var2[var7]) {
            int var8 = this.field2954[var7];
            if(0 != var8) {
               if(var5 != var8) {
                  var5 = var8--;
                  if(0 == (var8 & 1)) {
                     var6 = var1.method1234(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1238(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2953[var7] = var6;
                  this.field2954[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-554422076"
   )
   void method3508() {
      this.field2954 = null;
   }

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; 0 != var2.field2007[var2.field2005 + var3]; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2493();
      }

      ++var2.field2005;
      ++var3;
      var5 = var2.field2005;
      var2.field2005 += var3;

      int var6;
      for(var6 = 0; 0 != var2.field2007[var2.field2005 + var6]; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2493();
      }

      ++var2.field2005;
      ++var6;
      var8 = var2.field2005;
      var2.field2005 += var6;

      int var9;
      for(var9 = 0; var2.field2007[var9 + var2.field2005] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2493();
      }

      ++var2.field2005;
      ++var9;
      byte[] var42 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var42[1] = 1;
         int var14 = 1;
         var12 = 2;

         for(var13 = 2; var13 < var9; ++var13) {
            int var15 = var2.method2492();
            if(0 == var15) {
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

      class185[] var43 = new class185[var12];

      class185 var44;
      for(var13 = 0; var13 < var43.length; ++var13) {
         var44 = var43[var13] = new class185();
         int var16 = var2.method2492();
         if(var16 > 0) {
            var44.field3018 = new byte[2 * var16];
         }

         var16 = var2.method2492();
         if(var16 > 0) {
            var44.field3011 = new byte[2 + 2 * var16];
            var44.field3011[1] = 64;
         }
      }

      var13 = var2.method2492();
      byte[] var45 = var13 > 0?new byte[2 * var13]:null;
      var13 = var2.method2492();
      byte[] var17 = var13 > 0?new byte[2 * var13]:null;

      int var18;
      for(var18 = 0; 0 != var2.field2007[var18 + var2.field2005]; ++var18) {
         ;
      }

      byte[] var19 = new byte[var18];

      int var20;
      for(var20 = 0; var20 < var18; ++var20) {
         var19[var20] = var2.method2493();
      }

      ++var2.field2005;
      ++var18;
      var20 = 0;

      int var21;
      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.method2492();
         this.field2947[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.method2492();
         this.field2947[var21] = (short)(this.field2947[var21] + (var20 << 8));
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

            var23 = var2.method2507();
         }

         this.field2947[var24] = (short)(this.field2947[var24] + ((var23 - 1 & 2) << 14));
         this.field2954[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.field2954[var25] != 0) {
            if(0 == var21) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.field2007[var5++] - 1;
            }

            this.field2951[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.field2954[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.field2007[var8++] + 16 << 2;
            }

            this.field2949[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      class185 var46 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.field2954[var27] != 0) {
            if(0 == var21) {
               var46 = var43[var42[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.field2952[var27] = var46;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var27 = 0;

      int var28;
      for(var28 = 0; var28 < 128; ++var28) {
         if(0 == var21) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            if(this.field2954[var28] > 0) {
               var27 = var2.method2492() + 1;
            }
         }

         this.field2946[var28] = (byte)var27;
         --var21;
      }

      this.field2950 = var2.method2492() + 1;

      class185 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(null != var29.field3018) {
            for(var30 = 1; var30 < var29.field3018.length; var30 += 2) {
               var29.field3018[var30] = var2.method2493();
            }
         }

         if(null != var29.field3011) {
            for(var30 = 3; var30 < var29.field3011.length - 2; var30 += 2) {
               var29.field3011[var30] = var2.method2493();
            }
         }
      }

      if(var45 != null) {
         for(var28 = 1; var28 < var45.length; var28 += 2) {
            var45[var28] = var2.method2493();
         }
      }

      if(var17 != null) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.method2493();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(null != var29.field3011) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field3011.length; var30 += 2) {
               var20 = 1 + var20 + var2.method2492();
               var29.field3011[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3018 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field3018.length; var30 += 2) {
               var20 = 1 + var20 + var2.method2492();
               var29.field3018[var30] = (byte)var20;
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
         var20 = var2.method2492();
         var45[0] = (byte)var20;

         for(var28 = 2; var28 < var45.length; var28 += 2) {
            var20 = 1 + var20 + var2.method2492();
            var45[var28] = (byte)var20;
         }

         var38 = var45[0];
         byte var39 = var45[1];

         for(var30 = 0; var30 < var38; ++var30) {
            this.field2946[var30] = (byte)(32 + this.field2946[var30] * var39 >> 6);
         }

         for(var30 = 2; var30 < var45.length; var30 += 2) {
            var31 = var45[var30];
            byte var40 = var45[1 + var30];
            var32 = (var31 - var38) * var39 + (var31 - var38) / 2;

            for(var33 = var38; var33 < var31; ++var33) {
               var35 = var31 - var38;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2946[var33] = (byte)(32 + this.field2946[var33] * var34 >> 6);
               var32 += var40 - var39;
            }

            var38 = var31;
            var39 = var40;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            this.field2946[var37] = (byte)(32 + var39 * this.field2946[var37] >> 6);
         }

         var44 = null;
      }

      if(null != var17) {
         var20 = var2.method2492();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = var20 + 1 + var2.method2492();
            var17[var28] = (byte)var20;
         }

         var38 = var17[0];
         int var47 = var17[1] << 1;

         for(var30 = 0; var30 < var38; ++var30) {
            var37 = (this.field2949[var30] & 255) + var47;
            if(var37 < 0) {
               var37 = 0;
            }

            if(var37 > 128) {
               var37 = 128;
            }

            this.field2949[var30] = (byte)var37;
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
               int var41 = var34 + (this.field2949[var33] & 255);
               if(var41 < 0) {
                  var41 = 0;
               }

               if(var41 > 128) {
                  var41 = 128;
               }

               this.field2949[var33] = (byte)var41;
               var32 += var48 - var47;
            }

            var38 = var31;
            var47 = var48;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            var48 = var47 + (this.field2949[var37] & 255);
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.field2949[var37] = (byte)var48;
         }

         Object var49 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field3012 = var2.method2492();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3018 != null) {
            var29.field3013 = var2.method2492();
         }

         if(null != var29.field3011) {
            var29.field3014 = var2.method2492();
         }

         if(var29.field3012 > 0) {
            var29.field3010 = var2.method2492();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field3015 = var2.method2492();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3015 > 0) {
            var29.field3016 = var2.method2492();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3016 > 0) {
            var29.field3019 = var2.method2492();
         }
      }

   }
}

package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
public class class180 extends class207 {
   @ObfuscatedName("m")
   class62[] field2911 = new class62[128];
   @ObfuscatedName("h")
   byte[] field2912 = new byte[128];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -11052997
   )
   int field2913;
   @ObfuscatedName("f")
   short[] field2914 = new short[128];
   @ObfuscatedName("u")
   byte[] field2915 = new byte[128];
   @ObfuscatedName("a")
   class184[] field2916 = new class184[128];
   @ObfuscatedName("bj")
   static class167 field2917;
   @ObfuscatedName("i")
   int[] field2918 = new int[128];
   @ObfuscatedName("l")
   byte[] field2919 = new byte[128];

   class180(byte[] var1) {
      class118 var2 = new class118(var1);

      int var3;
      for(var3 = 0; 0 != var2.field1980[var3 + var2.field1981]; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2537();
      }

      ++var2.field1981;
      ++var3;
      var5 = var2.field1981;
      var2.field1981 += var3;

      int var6;
      for(var6 = 0; var2.field1980[var6 + var2.field1981] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2537();
      }

      ++var2.field1981;
      ++var6;
      var8 = var2.field1981;
      var2.field1981 += var6;

      int var9;
      for(var9 = 0; var2.field1980[var2.field1981 + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2537();
      }

      ++var2.field1981;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2536();
            if(0 == var15) {
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

      class184[] var39 = new class184[var12];

      class184 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class184();
         int var16 = var2.method2536();
         if(var16 > 0) {
            var40.field2981 = new byte[var16 * 2];
         }

         var16 = var2.method2536();
         if(var16 > 0) {
            var40.field2975 = new byte[2 * var16 + 2];
            var40.field2975[1] = 64;
         }
      }

      var14 = var2.method2536();
      byte[] var41 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2536();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; 0 != var2.field1980[var2.field1981 + var17]; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2537();
      }

      ++var2.field1981;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2536();
         this.field2914[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2536();
         this.field2914[var20] = (short)(this.field2914[var20] + (var19 << 8));
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

            var22 = var2.method2656();
         }

         this.field2914[var23] = (short)(this.field2914[var23] + ((var22 - 1 & 2) << 14));
         this.field2918[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2918[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field1980[var5++] - 1;
            }

            this.field2912[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2918[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field1980[var8++] + 16 << 2;
            }

            this.field2915[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class184 var44 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2918[var26] != 0) {
            if(0 == var20) {
               var44 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2916[var26] = var44;
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

            if(this.field2918[var27] > 0) {
               var26 = var2.method2536() + 1;
            }
         }

         this.field2919[var27] = (byte)var26;
         --var20;
      }

      this.field2913 = var2.method2536() + 1;

      class184 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field2981) {
            for(var29 = 1; var29 < var28.field2981.length; var29 += 2) {
               var28.field2981[var29] = var2.method2537();
            }
         }

         if(var28.field2975 != null) {
            for(var29 = 3; var29 < var28.field2975.length - 2; var29 += 2) {
               var28.field2975[var29] = var2.method2537();
            }
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method2537();
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2537();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2975 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2975.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2536();
               var28.field2975[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2981 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2981.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2536();
               var28.field2981[var29] = (byte)var19;
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
         var19 = var2.method2536();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2536();
            var41[var27] = (byte)var19;
         }

         var49 = var41[0];
         byte var45 = var41[1];

         for(var29 = 0; var29 < var49; ++var29) {
            this.field2919[var29] = (byte)(32 + var45 * this.field2919[var29] >> 6);
         }

         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            byte var31 = var41[var29 + 1];
            var32 = var45 * (var30 - var49) + (var30 - var49) / 2;

            for(var33 = var49; var33 < var30; ++var33) {
               var35 = var30 - var49;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2919[var33] = (byte)(32 + var34 * this.field2919[var33] >> 6);
               var32 += var31 - var45;
            }

            var49 = var30;
            var45 = var31;
         }

         for(var47 = var49; var47 < 128; ++var47) {
            this.field2919[var47] = (byte)(var45 * this.field2919[var47] + 32 >> 6);
         }

         var40 = null;
      }

      if(null != var42) {
         var19 = var2.method2536();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2536();
            var42[var27] = (byte)var19;
         }

         var49 = var42[0];
         int var46 = var42[1] << 1;

         for(var29 = 0; var29 < var49; ++var29) {
            var47 = (this.field2915[var29] & 255) + var46;
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field2915[var29] = (byte)var47;
         }

         int var48;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var48 = var42[1 + var29] << 1;
            var32 = (var30 - var49) / 2 + (var30 - var49) * var46;

            for(var33 = var49; var33 < var30; ++var33) {
               var35 = var30 - var49;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = (this.field2915[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2915[var33] = (byte)var37;
               var32 += var48 - var46;
            }

            var49 = var30;
            var46 = var48;
         }

         for(var47 = var49; var47 < 128; ++var47) {
            var48 = (this.field2915[var47] & 255) + var46;
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.field2915[var47] = (byte)var48;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2976 = var2.method2536();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field2981) {
            var28.field2984 = var2.method2536();
         }

         if(null != var28.field2975) {
            var28.field2978 = var2.method2536();
         }

         if(var28.field2976 > 0) {
            var28.field2979 = var2.method2536();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2974 = var2.method2536();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2974 > 0) {
            var28.field2977 = var2.method2536();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2977 > 0) {
            var28.field2982 = var2.method2536();
         }
      }

   }

   @ObfuscatedName("m")
   void method3580() {
      this.field2918 = null;
   }

   @ObfuscatedName("j")
   public static class50 method3581(int var0) {
      class50 var1 = (class50)class50.field1078.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class50.field1081.method3352(5, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1054(new class118(var2));
         }

         class50.field1078.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   boolean method3583(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2918[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1306(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1293(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2911[var7] = var6;
                  this.field2918[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("z")
   static class167 method3587(int var0, boolean var1, boolean var2, boolean var3) {
      class133 var4 = null;
      if(class148.field2221 != null) {
         var4 = new class133(var0, class148.field2221, class33.field747[var0], 1000000);
      }

      return new class167(var4, class44.field1022, var0, var1, var2, var3);
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class184 extends class211 {
   @ObfuscatedName("u")
   int[] field2968 = new int[128];
   @ObfuscatedName("h")
   byte[] field2969 = new byte[128];
   @ObfuscatedName("c")
   short[] field2970 = new short[128];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1077008167
   )
   int field2972;
   @ObfuscatedName("a")
   class188[] field2973 = new class188[128];
   @ObfuscatedName("b")
   byte[] field2974 = new byte[128];
   @ObfuscatedName("r")
   byte[] field2975 = new byte[128];
   @ObfuscatedName("en")
   static class81[] field2977;
   @ObfuscatedName("l")
   class65[] field2978 = new class65[128];

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[IB)Z",
      garbageValue = "60"
   )
   boolean method3612(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2968[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1360(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1361(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2978[var7] = var6;
                  this.field2968[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-464288253"
   )
   void method3613() {
      this.field2968 = null;
   }

   class184(byte[] var1) {
      class122 var2 = new class122(var1);

      int var3;
      for(var3 = 0; var2.field2054[var3 + var2.field2061] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2611();
      }

      ++var2.field2061;
      ++var3;
      var5 = var2.field2061;
      var2.field2061 += var3;

      int var6;
      for(var6 = 0; var2.field2054[var6 + var2.field2061] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2611();
      }

      ++var2.field2061;
      ++var6;
      var8 = var2.field2061;
      var2.field2061 += var6;

      int var9;
      for(var9 = 0; var2.field2054[var2.field2061 + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2611();
      }

      ++var2.field2061;
      ++var9;
      byte[] var37 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var37[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var36 = var2.method2610();
            if(var36 == 0) {
               var13 = var12++;
            } else {
               if(var36 <= var13) {
                  --var36;
               }

               var13 = var36;
            }

            var37[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var38 = new class188[var12];

      class188 var15;
      for(var14 = 0; var14 < var38.length; ++var14) {
         var15 = var38[var14] = new class188();
         int var16 = var2.method2610();
         if(var16 > 0) {
            var15.field3031 = new byte[2 * var16];
         }

         var16 = var2.method2610();
         if(var16 > 0) {
            var15.field3033 = new byte[var16 * 2 + 2];
            var15.field3033[1] = 64;
         }
      }

      var14 = var2.method2610();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2610();
      byte[] var40 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.field2054[var17 + var2.field2061] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2611();
      }

      ++var2.field2061;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2610();
         this.field2970[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2610();
         this.field2970[var20] = (short)(this.field2970[var20] + (var19 << 8));
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

            var22 = var2.method2625();
         }

         this.field2970[var23] = (short)(this.field2970[var23] + ((var22 - 1 & 2) << 14));
         this.field2968[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2968[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2054[var5++] - 1;
            }

            this.field2974[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2968[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2054[var8++] + 16 << 2;
            }

            this.field2975[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2968[var26] != 0) {
            if(var20 == 0) {
               var41 = var38[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2973[var26] = var41;
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

            if(this.field2968[var27] > 0) {
               var26 = var2.method2610() + 1;
            }
         }

         this.field2969[var27] = (byte)var26;
         --var20;
      }

      this.field2972 = var2.method2610() + 1;

      int var29;
      class188 var39;
      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(null != var39.field3031) {
            for(var29 = 1; var29 < var39.field3031.length; var29 += 2) {
               var39.field3031[var29] = var2.method2611();
            }
         }

         if(null != var39.field3033) {
            for(var29 = 3; var29 < var39.field3033.length - 2; var29 += 2) {
               var39.field3033[var29] = var2.method2611();
            }
         }
      }

      if(null != var42) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2611();
         }
      }

      if(null != var40) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method2611();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(null != var39.field3033) {
            var19 = 0;

            for(var29 = 2; var29 < var39.field3033.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2610();
               var39.field3033[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(var39.field3031 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var39.field3031.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2610();
               var39.field3031[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var44;
      byte var46;
      if(var42 != null) {
         var19 = var2.method2610();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2610();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         byte var28 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2969[var29] = (byte)(32 + this.field2969[var29] * var28 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[1 + var29];
            var32 = (var30 - var46) / 2 + var28 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class48.method1045(var32, var30 - var46);
               this.field2969[var33] = (byte)(32 + this.field2969[var33] * var34 >> 6);
               var32 += var31 - var28;
            }

            var46 = var30;
            var28 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2969[var44] = (byte)(32 + this.field2969[var44] * var28 >> 6);
         }

         var15 = null;
      }

      if(null != var40) {
         var19 = var2.method2610();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2610();
            var40[var27] = (byte)var19;
         }

         var46 = var40[0];
         int var43 = var40[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var43 + (this.field2975[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2975[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var45 = var40[1 + var29] << 1;
            var32 = (var30 - var46) / 2 + (var30 - var46) * var43;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class48.method1045(var32, var30 - var46);
               int var35 = (this.field2975[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2975[var33] = (byte)var35;
               var32 += var45 - var43;
            }

            var46 = var30;
            var43 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = (this.field2975[var44] & 255) + var43;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2975[var44] = (byte)var45;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field3039 = var2.method2610();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(null != var39.field3031) {
            var39.field3034 = var2.method2610();
         }

         if(var39.field3033 != null) {
            var39.field3035 = var2.method2610();
         }

         if(var39.field3039 > 0) {
            var39.field3036 = var2.method2610();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field3038 = var2.method2610();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(var39.field3038 > 0) {
            var39.field3037 = var2.method2610();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var38[var27];
         if(var39.field3037 > 0) {
            var39.field3032 = var2.method2610();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public static void method3619() {
      try {
         if(class186.field2993 == 1) {
            int var0 = class186.field2996.method3705();
            if(var0 > 0 && class186.field2996.method3690()) {
               var0 -= class186.field2999;
               if(var0 < 0) {
                  var0 = 0;
               }

               class186.field2996.method3683(var0);
               return;
            }

            class186.field2996.method3689();
            class186.field2996.method3798();
            if(class186.field2998 != null) {
               class186.field2993 = 2;
            } else {
               class186.field2993 = 0;
            }

            class186.field3000 = null;
            class98.field1695 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class186.field2996.method3689();
         class186.field2993 = 0;
         class186.field3000 = null;
         class98.field1695 = null;
         class186.field2998 = null;
      }

   }
}

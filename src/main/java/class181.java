import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
public class class181 extends class208 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -538676301
   )
   int field2938;
   @ObfuscatedName("x")
   class62[] field2939 = new class62[128];
   @ObfuscatedName("t")
   short[] field2940 = new short[128];
   @ObfuscatedName("p")
   byte[] field2942 = new byte[128];
   @ObfuscatedName("y")
   class185[] field2943 = new class185[128];
   @ObfuscatedName("m")
   byte[] field2944 = new byte[128];
   @ObfuscatedName("c")
   int[] field2947 = new int[128];
   @ObfuscatedName("e")
   byte[] field2949 = new byte[128];

   @ObfuscatedName("x")
   boolean method3538(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2947[var7];
            if(0 != var8) {
               if(var8 != var5) {
                  var5 = var8--;
                  if(0 == (var8 & 1)) {
                     var6 = var1.method1271(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1276(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2939[var7] = var6;
                  this.field2947[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("t")
   void method3539() {
      this.field2947 = null;
   }

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; var2.field2012[var2.field2011 + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2524();
      }

      ++var2.field2011;
      ++var3;
      var5 = var2.field2011;
      var2.field2011 += var3;

      int var6;
      for(var6 = 0; var2.field2012[var6 + var2.field2011] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2524();
      }

      ++var2.field2011;
      ++var6;
      var8 = var2.field2011;
      var2.field2011 += var6;

      int var9;
      for(var9 = 0; 0 != var2.field2012[var9 + var2.field2011]; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2524();
      }

      ++var2.field2011;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2506();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class185[] var37 = new class185[var12];

      class185 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class185();
         int var16 = var2.method2506();
         if(var16 > 0) {
            var38.field3003 = new byte[var16 * 2];
         }

         var16 = var2.method2506();
         if(var16 > 0) {
            var38.field3008 = new byte[2 + var16 * 2];
            var38.field3008[1] = 64;
         }
      }

      var14 = var2.method2506();
      byte[] var39 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2506();
      byte[] var40 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; 0 != var2.field2012[var2.field2011 + var17]; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2524();
      }

      ++var2.field2011;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2506();
         this.field2940[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2506();
         this.field2940[var20] = (short)(this.field2940[var20] + (var19 << 8));
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

            var22 = var2.method2521();
         }

         this.field2940[var23] = (short)(this.field2940[var23] + ((var22 - 1 & 2) << 14));
         this.field2947[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(0 != this.field2947[var24]) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2012[var5++] - 1;
            }

            this.field2944[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(0 != this.field2947[var25]) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2012[var8++] + 16 << 2;
            }

            this.field2949[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class185 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2947[var26] != 0) {
            if(var20 == 0) {
               var42 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2943[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(0 == var20) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2947[var27] > 0) {
               var26 = var2.method2506() + 1;
            }
         }

         this.field2942[var27] = (byte)var26;
         --var20;
      }

      this.field2938 = var2.method2506() + 1;

      class185 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field3003 != null) {
            for(var29 = 1; var29 < var28.field3003.length; var29 += 2) {
               var28.field3003[var29] = var2.method2524();
            }
         }

         if(null != var28.field3008) {
            for(var29 = 3; var29 < var28.field3008.length - 2; var29 += 2) {
               var28.field3008[var29] = var2.method2524();
            }
         }
      }

      if(var39 != null) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.method2524();
         }
      }

      if(var40 != null) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method2524();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field3008) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3008.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2506();
               var28.field3008[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field3003) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3003.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2506();
               var28.field3003[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if(null != var39) {
         var19 = var2.method2506();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2506();
            var39[var27] = (byte)var19;
         }

         var47 = var39[0];
         byte var43 = var39[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2942[var29] = (byte)(32 + var43 * this.field2942[var29] >> 6);
         }

         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            byte var31 = var39[var29 + 1];
            var32 = (var30 - var47) / 2 + var43 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class119.method2703(var32, var30 - var47);
               this.field2942[var33] = (byte)(this.field2942[var33] * var34 + 32 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2942[var45] = (byte)(32 + this.field2942[var45] * var43 >> 6);
         }

         var38 = null;
      }

      if(null != var40) {
         var19 = var2.method2506();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2506();
            var40[var27] = (byte)var19;
         }

         var47 = var40[0];
         int var44 = var40[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2949[var29] & 255) + var44;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2949[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var46 = var40[1 + var29] << 1;
            var32 = var44 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class119.method2703(var32, var30 - var47);
               int var35 = var34 + (this.field2949[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2949[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = (this.field2949[var45] & 255) + var44;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2949[var45] = (byte)var46;
         }

         Object var41 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field3004 = var2.method2506();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field3003 != null) {
            var28.field3005 = var2.method2506();
         }

         if(null != var28.field3008) {
            var28.field3006 = var2.method2506();
         }

         if(var28.field3004 > 0) {
            var28.field3007 = var2.method2506();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field3010 = var2.method2506();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field3010 > 0) {
            var28.field3009 = var2.method2506();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field3009 > 0) {
            var28.field3002 = var2.method2506();
         }
      }

   }

   @ObfuscatedName("t")
   public static void method3552(int var0) {
      if(0 != class183.field2968) {
         class183.field2970 = var0;
      } else {
         class183.field2967.method3615(var0);
      }

   }
}

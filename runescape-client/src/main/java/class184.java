import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class184 extends Node {
   @ObfuscatedName("n")
   byte[] field2989 = new byte[128];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1477073733
   )
   int field2991;
   @ObfuscatedName("d")
   class65[] field2992 = new class65[128];
   @ObfuscatedName("z")
   byte[] field2993 = new byte[128];
   @ObfuscatedName("t")
   class188[] field2994 = new class188[128];
   @ObfuscatedName("r")
   byte[] field2995 = new byte[128];
   @ObfuscatedName("i")
   int[] field2996 = new int[128];
   @ObfuscatedName("v")
   short[] field2997 = new short[128];

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[IB)Z",
      garbageValue = "120"
   )
   boolean method3554(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2996[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1314(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1312(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2992[var7] = var6;
                  this.field2996[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1571134361"
   )
   void method3555() {
      this.field2996 = null;
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
         var4[var5] = var2.method2529();
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
         var7[var8] = var2.method2529();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var2.offset + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2529();
      }

      ++var2.offset;
      ++var9;
      byte[] var40 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var40[1] = 1;
         int var38 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var39 = var2.method2528();
            if(var39 == 0) {
               var38 = var12++;
            } else {
               if(var39 <= var38) {
                  --var39;
               }

               var38 = var39;
            }

            var40[var14] = (byte)var38;
         }
      } else {
         var12 = var9;
      }

      class188[] var13 = new class188[var12];

      class188 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class188();
         int var16 = var2.method2528();
         if(var16 > 0) {
            var15.field3061 = new byte[2 * var16];
         }

         var16 = var2.method2528();
         if(var16 > 0) {
            var15.field3053 = new byte[2 + 2 * var16];
            var15.field3053[1] = 64;
         }
      }

      var14 = var2.method2528();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2528();
      byte[] var41 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2529();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2528();
         this.field2997[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2528();
         this.field2997[var20] = (short)(this.field2997[var20] + (var19 << 8));
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

            var22 = var2.method2689();
         }

         this.field2997[var23] = (short)(this.field2997[var23] + ((var22 - 1 & 2) << 14));
         this.field2996[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2996[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2989[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var37 = 0; var37 < 128; ++var37) {
         if(this.field2996[var37] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2993[var37] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2996[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var40[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2994[var26] = var25;
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

            if(this.field2996[var27] > 0) {
               var26 = var2.method2528() + 1;
            }
         }

         this.field2995[var27] = (byte)var26;
         --var20;
      }

      this.field2991 = var2.method2528() + 1;

      int var29;
      class188 var36;
      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(var36.field3061 != null) {
            for(var29 = 1; var29 < var36.field3061.length; var29 += 2) {
               var36.field3061[var29] = var2.method2529();
            }
         }

         if(null != var36.field3053) {
            for(var29 = 3; var29 < var36.field3053.length - 2; var29 += 2) {
               var36.field3053[var29] = var2.method2529();
            }
         }
      }

      if(null != var42) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.method2529();
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method2529();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(var36.field3053 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field3053.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2528();
               var36.field3053[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(null != var36.field3061) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field3061.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2528();
               var36.field3061[var29] = (byte)var19;
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
         var19 = var2.method2528();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2528();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         byte var28 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2995[var29] = (byte)(32 + var28 * this.field2995[var29] >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = var28 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = KitDefinition.method979(var32, var30 - var46);
               this.field2995[var33] = (byte)(this.field2995[var33] * var34 + 32 >> 6);
               var32 += var31 - var28;
            }

            var46 = var30;
            var28 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2995[var44] = (byte)(this.field2995[var44] * var28 + 32 >> 6);
         }

         var15 = null;
      }

      if(var41 != null) {
         var19 = var2.method2528();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2528();
            var41[var27] = (byte)var19;
         }

         var46 = var41[0];
         int var43 = var41[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var43 + (this.field2993[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2993[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = (var30 - var46) / 2 + var43 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = KitDefinition.method979(var32, var30 - var46);
               int var35 = var34 + (this.field2993[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2993[var33] = (byte)var35;
               var32 += var45 - var43;
            }

            var46 = var30;
            var43 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var43 + (this.field2993[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2993[var44] = (byte)var45;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3055 = var2.method2528();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(null != var36.field3061) {
            var36.field3059 = var2.method2528();
         }

         if(null != var36.field3053) {
            var36.field3052 = var2.method2528();
         }

         if(var36.field3055 > 0) {
            var36.field3054 = var2.method2528();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field3056 = var2.method2528();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(var36.field3056 > 0) {
            var36.field3058 = var2.method2528();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var13[var27];
         if(var36.field3058 > 0) {
            var36.field3060 = var2.method2528();
         }
      }

   }
}

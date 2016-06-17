import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class181 extends class208 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 513009425
   )
   int field2925;
   @ObfuscatedName("g")
   class62[] field2926 = new class62[128];
   @ObfuscatedName("j")
   short[] field2927 = new short[128];
   @ObfuscatedName("d")
   byte[] field2928 = new byte[128];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 463674285
   )
   public static int field2929;
   @ObfuscatedName("x")
   byte[] field2930 = new byte[128];
   @ObfuscatedName("r")
   byte[] field2931 = new byte[128];
   @ObfuscatedName("c")
   int[] field2932 = new int[128];
   @ObfuscatedName("y")
   class185[] field2933 = new class185[128];
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -563612805
   )
   static int field2934;

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; var2.field1982[var3 + var2.field1976] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2515();
      }

      ++var2.field1976;
      ++var3;
      var5 = var2.field1976;
      var2.field1976 += var3;

      int var6;
      for(var6 = 0; var2.field1982[var2.field1976 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2515();
      }

      ++var2.field1976;
      ++var6;
      var8 = var2.field1976;
      var2.field1976 += var6;

      int var9;
      for(var9 = 0; var2.field1982[var9 + var2.field1976] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2515();
      }

      ++var2.field1976;
      ++var9;
      byte[] var37 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var37[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2514();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var37[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class185[] var38 = new class185[var12];

      class185 var39;
      for(var14 = 0; var14 < var38.length; ++var14) {
         var39 = var38[var14] = new class185();
         int var16 = var2.method2514();
         if(var16 > 0) {
            var39.field2996 = new byte[2 * var16];
         }

         var16 = var2.method2514();
         if(var16 > 0) {
            var39.field2999 = new byte[var16 * 2 + 2];
            var39.field2999[1] = 64;
         }
      }

      var14 = var2.method2514();
      byte[] var46 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.method2514();
      byte[] var40 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.field1982[var2.field1976 + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2515();
      }

      ++var2.field1976;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2514();
         this.field2927[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2514();
         this.field2927[var20] = (short)(this.field2927[var20] + (var19 << 8));
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

            var22 = var2.method2529();
         }

         this.field2927[var23] = (short)(this.field2927[var23] + ((var22 - 1 & 2) << 14));
         this.field2932[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2932[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field1982[var5++] - 1;
            }

            this.field2931[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2932[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field1982[var8++] + 16 << 2;
            }

            this.field2930[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class185 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2932[var26] != 0) {
            if(var20 == 0) {
               var41 = var38[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2933[var26] = var41;
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

            if(this.field2932[var27] > 0) {
               var26 = var2.method2514() + 1;
            }
         }

         this.field2928[var27] = (byte)var26;
         --var20;
      }

      this.field2925 = var2.method2514() + 1;

      int var29;
      class185 var36;
      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(var36.field2996 != null) {
            for(var29 = 1; var29 < var36.field2996.length; var29 += 2) {
               var36.field2996[var29] = var2.method2515();
            }
         }

         if(null != var36.field2999) {
            for(var29 = 3; var29 < var36.field2999.length - 2; var29 += 2) {
               var36.field2999[var29] = var2.method2515();
            }
         }
      }

      if(null != var46) {
         for(var27 = 1; var27 < var46.length; var27 += 2) {
            var46[var27] = var2.method2515();
         }
      }

      if(null != var40) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method2515();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(null != var36.field2999) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field2999.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2514();
               var36.field2999[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(null != var36.field2996) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field2996.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2514();
               var36.field2996[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var43;
      byte var45;
      if(null != var46) {
         var19 = var2.method2514();
         var46[0] = (byte)var19;

         for(var27 = 2; var27 < var46.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2514();
            var46[var27] = (byte)var19;
         }

         var45 = var46[0];
         byte var28 = var46[1];

         for(var29 = 0; var29 < var45; ++var29) {
            this.field2928[var29] = (byte)(32 + this.field2928[var29] * var28 >> 6);
         }

         for(var29 = 2; var29 < var46.length; var29 += 2) {
            var30 = var46[var29];
            byte var31 = var46[1 + var29];
            var32 = var28 * (var30 - var45) + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class99.method2205(var32, var30 - var45);
               this.field2928[var33] = (byte)(var34 * this.field2928[var33] + 32 >> 6);
               var32 += var31 - var28;
            }

            var45 = var30;
            var28 = var31;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            this.field2928[var43] = (byte)(var28 * this.field2928[var43] + 32 >> 6);
         }

         var39 = null;
      }

      if(var40 != null) {
         var19 = var2.method2514();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2514();
            var40[var27] = (byte)var19;
         }

         var45 = var40[0];
         int var42 = var40[1] << 1;

         for(var29 = 0; var29 < var45; ++var29) {
            var43 = (this.field2930[var29] & 255) + var42;
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2930[var29] = (byte)var43;
         }

         int var44;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var44 = var40[1 + var29] << 1;
            var32 = var42 * (var30 - var45) + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class99.method2205(var32, var30 - var45);
               int var35 = var34 + (this.field2930[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2930[var33] = (byte)var35;
               var32 += var44 - var42;
            }

            var45 = var30;
            var42 = var44;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            var44 = (this.field2930[var43] & 255) + var42;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2930[var43] = (byte)var44;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field2997 = var2.method2514();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(null != var36.field2996) {
            var36.field2992 = var2.method2514();
         }

         if(var36.field2999 != null) {
            var36.field2993 = var2.method2514();
         }

         if(var36.field2997 > 0) {
            var36.field2994 = var2.method2514();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field2989 = var2.method2514();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(var36.field2989 > 0) {
            var36.field2995 = var2.method2514();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var38[var27];
         if(var36.field2995 > 0) {
            var36.field2990 = var2.method2514();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1115740420"
   )
   void method3534() {
      this.field2932 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass59;[B[IS)Z",
      garbageValue = "17281"
   )
   boolean method3535(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2932[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1275(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1265(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2926[var7] = var6;
                  this.field2932[var7] = 0;
               }
            }
         }
      }

      return var4;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class184 extends Node {
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
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var3 + var2.offset] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2634();
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
         var7[var8] = var2.method2634();
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
         var10[var11] = var2.method2634();
      }

      ++var2.offset;
      ++var9;
      byte[] var42 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var42[1] = 1;
         int var14 = 1;
         var12 = 2;

         for(var13 = 2; var13 < var9; ++var13) {
            int var15 = var2.method2633();
            if(var15 == 0) {
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

      class188[] var43 = new class188[var12];

      class188 var44;
      for(var13 = 0; var13 < var43.length; ++var13) {
         var44 = var43[var13] = new class188();
         int var16 = var2.method2633();
         if(var16 > 0) {
            var44.field3050 = new byte[var16 * 2];
         }

         var16 = var2.method2633();
         if(var16 > 0) {
            var44.field3043 = new byte[2 * var16 + 2];
            var44.field3043[1] = 64;
         }
      }

      var13 = var2.method2633();
      byte[] var45 = var13 > 0?new byte[2 * var13]:null;
      var13 = var2.method2633();
      byte[] var17 = var13 > 0?new byte[var13 * 2]:null;

      int var18;
      for(var18 = 0; var2.payload[var2.offset + var18] != 0; ++var18) {
         ;
      }

      byte[] var19 = new byte[var18];

      int var20;
      for(var20 = 0; var20 < var18; ++var20) {
         var19[var20] = var2.method2634();
      }

      ++var2.offset;
      ++var18;
      var20 = 0;

      int var21;
      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.method2633();
         this.field2987[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.method2633();
         this.field2987[var21] = (short)(this.field2987[var21] + (var20 << 8));
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

            var23 = var2.method2832();
         }

         this.field2987[var24] = (short)(this.field2987[var24] + ((var23 - 1 & 2) << 14));
         this.field2990[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.field2990[var25] != 0) {
            if(var21 == 0) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.payload[var5++] - 1;
            }

            this.field2984[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.field2990[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.payload[var8++] + 16 << 2;
            }

            this.field2988[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      class188 var46 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.field2990[var27] != 0) {
            if(var21 == 0) {
               var46 = var43[var42[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.field2989[var27] = var46;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var27 = 0;

      int var28;
      for(var28 = 0; var28 < 128; ++var28) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            if(this.field2990[var28] > 0) {
               var27 = var2.method2633() + 1;
            }
         }

         this.field2991[var28] = (byte)var27;
         --var21;
      }

      this.field2986 = var2.method2633() + 1;

      class188 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3050 != null) {
            for(var30 = 1; var30 < var29.field3050.length; var30 += 2) {
               var29.field3050[var30] = var2.method2634();
            }
         }

         if(null != var29.field3043) {
            for(var30 = 3; var30 < var29.field3043.length - 2; var30 += 2) {
               var29.field3043[var30] = var2.method2634();
            }
         }
      }

      if(var45 != null) {
         for(var28 = 1; var28 < var45.length; var28 += 2) {
            var45[var28] = var2.method2634();
         }
      }

      if(null != var17) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.method2634();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3043 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field3043.length; var30 += 2) {
               var20 = var20 + 1 + var2.method2633();
               var29.field3043[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3050 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field3050.length; var30 += 2) {
               var20 = var20 + 1 + var2.method2633();
               var29.field3050[var30] = (byte)var20;
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
      if(null != var45) {
         var20 = var2.method2633();
         var45[0] = (byte)var20;

         for(var28 = 2; var28 < var45.length; var28 += 2) {
            var20 = var20 + 1 + var2.method2633();
            var45[var28] = (byte)var20;
         }

         var38 = var45[0];
         byte var39 = var45[1];

         for(var30 = 0; var30 < var38; ++var30) {
            this.field2991[var30] = (byte)(var39 * this.field2991[var30] + 32 >> 6);
         }

         for(var30 = 2; var30 < var45.length; var30 += 2) {
            var31 = var45[var30];
            byte var40 = var45[1 + var30];
            var32 = (var31 - var38) * var39 + (var31 - var38) / 2;

            for(var33 = var38; var33 < var31; ++var33) {
               var35 = var31 - var38;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2991[var33] = (byte)(32 + this.field2991[var33] * var34 >> 6);
               var32 += var40 - var39;
            }

            var38 = var31;
            var39 = var40;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            this.field2991[var37] = (byte)(32 + var39 * this.field2991[var37] >> 6);
         }

         var44 = null;
      }

      if(var17 != null) {
         var20 = var2.method2633();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = 1 + var20 + var2.method2633();
            var17[var28] = (byte)var20;
         }

         var38 = var17[0];
         int var47 = var17[1] << 1;

         for(var30 = 0; var30 < var38; ++var30) {
            var37 = (this.field2988[var30] & 255) + var47;
            if(var37 < 0) {
               var37 = 0;
            }

            if(var37 > 128) {
               var37 = 128;
            }

            this.field2988[var30] = (byte)var37;
         }

         int var48;
         for(var30 = 2; var30 < var17.length; var30 += 2) {
            var31 = var17[var30];
            var48 = var17[1 + var30] << 1;
            var32 = var47 * (var31 - var38) + (var31 - var38) / 2;

            for(var33 = var38; var33 < var31; ++var33) {
               var35 = var31 - var38;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var41 = (this.field2988[var33] & 255) + var34;
               if(var41 < 0) {
                  var41 = 0;
               }

               if(var41 > 128) {
                  var41 = 128;
               }

               this.field2988[var33] = (byte)var41;
               var32 += var48 - var47;
            }

            var38 = var31;
            var47 = var48;
         }

         for(var37 = var38; var37 < 128; ++var37) {
            var48 = var47 + (this.field2988[var37] & 255);
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.field2988[var37] = (byte)var48;
         }

         Object var49 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field3044 = var2.method2633();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3050 != null) {
            var29.field3045 = var2.method2633();
         }

         if(var29.field3043 != null) {
            var29.field3042 = var2.method2633();
         }

         if(var29.field3044 > 0) {
            var29.field3047 = var2.method2633();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field3049 = var2.method2633();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3049 > 0) {
            var29.field3048 = var2.method2633();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field3048 > 0) {
            var29.field3054 = var2.method2633();
         }
      }

   }
}

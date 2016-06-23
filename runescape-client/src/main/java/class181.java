import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class181 extends class208 {
   @ObfuscatedName("d")
   class185[] field2926 = new class185[128];
   @ObfuscatedName("u")
   class62[] field2927 = new class62[128];
   @ObfuscatedName("b")
   byte[] field2929 = new byte[128];
   @ObfuscatedName("l")
   byte[] field2930 = new byte[128];
   @ObfuscatedName("x")
   short[] field2931 = new short[128];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 151417999
   )
   int field2932;
   @ObfuscatedName("m")
   int[] field2933 = new int[128];
   @ObfuscatedName("n")
   byte[] field2936 = new byte[128];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-430796963"
   )
   void method3558() {
      this.field2933 = null;
   }

   class181(byte[] var1) {
      class119 var2 = new class119(var1);

      int var3;
      for(var3 = 0; var2.field2000[var2.field1998 + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2538();
      }

      ++var2.field1998;
      ++var3;
      var5 = var2.field1998;
      var2.field1998 += var3;

      int var6;
      for(var6 = 0; var2.field2000[var2.field1998 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2538();
      }

      ++var2.field1998;
      ++var6;
      var8 = var2.field1998;
      var2.field1998 += var6;

      int var9;
      for(var9 = 0; var2.field2000[var9 + var2.field1998] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2538();
      }

      ++var2.field1998;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var39 = var2.method2554();
            if(var39 == 0) {
               var13 = var12++;
            } else {
               if(var39 <= var13) {
                  --var39;
               }

               var13 = var39;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class185[] var40 = new class185[var12];

      class185 var15;
      for(var14 = 0; var14 < var40.length; ++var14) {
         var15 = var40[var14] = new class185();
         int var16 = var2.method2554();
         if(var16 > 0) {
            var15.field2998 = new byte[var16 * 2];
         }

         var16 = var2.method2554();
         if(var16 > 0) {
            var15.field2989 = new byte[var16 * 2 + 2];
            var15.field2989[1] = 64;
         }
      }

      var14 = var2.method2554();
      byte[] var44 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2554();
      byte[] var41 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.field2000[var2.field1998 + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2538();
      }

      ++var2.field1998;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2554();
         this.field2931[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2554();
         this.field2931[var20] = (short)(this.field2931[var20] + (var19 << 8));
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

            var22 = var2.method2569();
         }

         this.field2931[var23] = (short)(this.field2931[var23] + ((var22 - 1 & 2) << 14));
         this.field2933[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2933[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2000[var5++] - 1;
            }

            this.field2936[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var43 = 0; var43 < 128; ++var43) {
         if(this.field2933[var43] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2000[var8++] + 16 << 2;
            }

            this.field2930[var43] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class185 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2933[var26] != 0) {
            if(var20 == 0) {
               var25 = var40[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2926[var26] = var25;
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

            if(this.field2933[var27] > 0) {
               var26 = var2.method2554() + 1;
            }
         }

         this.field2929[var27] = (byte)var26;
         --var20;
      }

      this.field2932 = var2.method2554() + 1;

      class185 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field2998 != null) {
            for(var29 = 1; var29 < var28.field2998.length; var29 += 2) {
               var28.field2998[var29] = var2.method2538();
            }
         }

         if(var28.field2989 != null) {
            for(var29 = 3; var29 < var28.field2989.length - 2; var29 += 2) {
               var28.field2989[var29] = var2.method2538();
            }
         }
      }

      if(null != var44) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.method2538();
         }
      }

      if(null != var41) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method2538();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(null != var28.field2989) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2989.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2554();
               var28.field2989[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field2998 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2998.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2554();
               var28.field2998[var29] = (byte)var19;
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
      if(null != var44) {
         var19 = var2.method2554();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2554();
            var44[var27] = (byte)var19;
         }

         var47 = var44[0];
         byte var42 = var44[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2929[var29] = (byte)(this.field2929[var29] * var42 + 32 >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[var29 + 1];
            var32 = var42 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2929[var33] = (byte)(32 + this.field2929[var33] * var34 >> 6);
               var32 += var31 - var42;
            }

            var47 = var30;
            var42 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2929[var45] = (byte)(32 + var42 * this.field2929[var45] >> 6);
         }

         var15 = null;
      }

      if(var41 != null) {
         var19 = var2.method2554();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2554();
            var41[var27] = (byte)var19;
         }

         var47 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = var49 + (this.field2930[var29] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2930[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var46 = var41[var29 + 1] << 1;
            var32 = (var30 - var47) / 2 + (var30 - var47) * var49;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = (this.field2930[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2930[var33] = (byte)var37;
               var32 += var46 - var49;
            }

            var47 = var30;
            var49 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var49 + (this.field2930[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2930[var45] = (byte)var46;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field2990 = var2.method2554();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(null != var28.field2998) {
            var28.field2991 = var2.method2554();
         }

         if(null != var28.field2989) {
            var28.field2992 = var2.method2554();
         }

         if(var28.field2990 > 0) {
            var28.field2993 = var2.method2554();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field2995 = var2.method2554();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field2995 > 0) {
            var28.field2994 = var2.method2554();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var40[var27];
         if(var28.field2994 > 0) {
            var28.field2996 = var2.method2554();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass59;[B[II)Z",
      garbageValue = "1914639849"
   )
   boolean method3560(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2933[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1319(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1321(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2927[var7] = var6;
                  this.field2933[var7] = 0;
               }
            }
         }
      }

      return var4;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class184 extends Node {
   @ObfuscatedName("b")
   class188[] field2969 = new class188[128];
   @ObfuscatedName("e")
   class65[] field2970 = new class65[128];
   @ObfuscatedName("n")
   short[] field2971 = new short[128];
   @ObfuscatedName("t")
   byte[] field2972 = new byte[128];
   @ObfuscatedName("m")
   byte[] field2973 = new byte[128];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 523747033
   )
   int field2974;
   @ObfuscatedName("v")
   byte[] field2975 = new byte[128];
   @ObfuscatedName("k")
   int[] field2976 = new int[128];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[II)Z",
      garbageValue = "324055810"
   )
   boolean method3582(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2976[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1319(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1305(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2970[var7] = var6;
                  this.field2976[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1955022083"
   )
   void method3583() {
      this.field2976 = null;
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
         var4[var5] = var2.method2534();
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
         var7[var8] = var2.method2534();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2534();
      }

      ++var2.offset;
      ++var9;
      byte[] var40 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var40[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2656();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var40[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var39 = new class188[var12];

      class188 var38;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var38 = var39[var14] = new class188();
         int var41 = var2.method2656();
         if(var41 > 0) {
            var38.field3044 = new byte[2 * var41];
         }

         var41 = var2.method2656();
         if(var41 > 0) {
            var38.field3047 = new byte[2 * var41 + 2];
            var38.field3047[1] = 64;
         }
      }

      var14 = var2.method2656();
      byte[] var48 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2656();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2534();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2656();
         this.field2971[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2656();
         this.field2971[var20] = (short)(this.field2971[var20] + (var19 << 8));
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

            var22 = var2.method2696();
         }

         this.field2971[var23] = (short)(this.field2971[var23] + ((var22 - 1 & 2) << 14));
         this.field2976[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2976[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2973[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2976[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2975[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2976[var26] != 0) {
            if(var20 == 0) {
               var43 = var39[var40[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2969[var26] = var43;
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

            if(this.field2976[var27] > 0) {
               var26 = var2.method2656() + 1;
            }
         }

         this.field2972[var27] = (byte)var26;
         --var20;
      }

      this.field2974 = var2.method2656() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3044) {
            for(var29 = 1; var29 < var28.field3044.length; var29 += 2) {
               var28.field3044[var29] = var2.method2534();
            }
         }

         if(var28.field3047 != null) {
            for(var29 = 3; var29 < var28.field3047.length - 2; var29 += 2) {
               var28.field3047[var29] = var2.method2534();
            }
         }
      }

      if(null != var48) {
         for(var27 = 1; var27 < var48.length; var27 += 2) {
            var48[var27] = var2.method2534();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.method2534();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3047) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3047.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2656();
               var28.field3047[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(null != var28.field3044) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3044.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2656();
               var28.field3044[var29] = (byte)var19;
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
      if(var48 != null) {
         var19 = var2.method2656();
         var48[0] = (byte)var19;

         for(var27 = 2; var27 < var48.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2656();
            var48[var27] = (byte)var19;
         }

         var47 = var48[0];
         byte var42 = var48[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2972[var29] = (byte)(var42 * this.field2972[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[1 + var29];
            var32 = (var30 - var47) / 2 + var42 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2972[var33] = (byte)(32 + var34 * this.field2972[var33] >> 6);
               var32 += var31 - var42;
            }

            var47 = var30;
            var42 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2972[var45] = (byte)(32 + this.field2972[var45] * var42 >> 6);
         }

         var38 = null;
      }

      if(null != var16) {
         var19 = var2.method2656();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2656();
            var16[var27] = (byte)var19;
         }

         var47 = var16[0];
         int var49 = var16[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = var49 + (this.field2975[var29] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2975[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var46 = var16[var29 + 1] << 1;
            var32 = (var30 - var47) * var49 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = var34 + (this.field2975[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2975[var33] = (byte)var37;
               var32 += var46 - var49;
            }

            var47 = var30;
            var49 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var49 + (this.field2975[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2975[var45] = (byte)var46;
         }

         Object var44 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3038 = var2.method2656();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3044 != null) {
            var28.field3040 = var2.method2656();
         }

         if(var28.field3047 != null) {
            var28.field3039 = var2.method2656();
         }

         if(var28.field3038 > 0) {
            var28.field3041 = var2.method2656();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field3043 = var2.method2656();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3043 > 0) {
            var28.field3037 = var2.method2656();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field3037 > 0) {
            var28.field3042 = var2.method2656();
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "55006611"
   )
   static void method3588(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class62.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field850 = 0;
            var0.actionAnimationDisable = var2;
            var0.field852 = 0;
         }

         if(var3 == 2) {
            var0.field852 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class62.getAnimation(var1).field1005 >= class62.getAnimation(var0.animation).field1005) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field850 = 0;
         var0.actionAnimationDisable = var2;
         var0.field852 = 0;
         var0.field875 = var0.field867;
      }

   }
}

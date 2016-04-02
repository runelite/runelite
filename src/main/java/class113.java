import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class113 {
   @ObfuscatedName("e")
   int[] field1944;
   @ObfuscatedName("w")
   byte[] field1945;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1743529331
   )
   static int field1947;
   @ObfuscatedName("rb")
   protected static boolean field1948;
   @ObfuscatedName("f")
   int[] field1950;

   @ObfuscatedName("w")
   public int method2453(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 64)) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 16)) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 8)) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 1)) {
               var6 = this.field1950[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1950[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1944 = new int[var2];
      this.field1945 = var1;
      int[] var3 = new int[33];
      this.field1950 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(0 != var6) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1944[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if(0 != (var11 & var12)) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(0 == this.field1950[var10]) {
                     this.field1950[var10] = var4;
                  }

                  var10 = this.field1950[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1950.length) {
                  int[] var13 = new int[2 * this.field1950.length];

                  for(int var14 = 0; var14 < this.field1950.length; ++var14) {
                     var13[var14] = this.field1950[var14];
                  }

                  this.field1950 = var13;
               }

               var12 >>>= 1;
            }

            this.field1950[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("e")
   public int method2458(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1944[var8];
         byte var10 = this.field1945[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var10 + var12 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1438826366"
   )
   static final void method2460(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class59.method1263(var0, var1, class48.field1063) - var2;
         var0 -= class19.field273;
         var3 -= class0.field12;
         var1 -= class5.field95;
         int var4 = class91.field1568[class216.field3156];
         int var5 = class91.field1554[class216.field3156];
         int var6 = class91.field1568[class10.field167];
         int var7 = class91.field1554[class10.field167];
         int var8 = var6 * var1 + var7 * var0 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            client.field300 = client.field544 * var0 / var1 + client.field371 / 2;
            client.field386 = var8 * client.field544 / var1 + client.field543 / 2;
         } else {
            client.field300 = -1;
            client.field386 = -1;
         }

      } else {
         client.field300 = -1;
         client.field386 = -1;
      }
   }

   @ObfuscatedName("w")
   static char method2461(char var0) {
      return 181 != var0 && 402 != var0?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("s")
   public static boolean method2462(int var0) {
      if(class173.field2745[var0]) {
         return true;
      } else if(!class173.field2746.method3258(var0)) {
         return false;
      } else {
         int var1 = class173.field2746.method3307(var0);
         if(0 == var1) {
            class173.field2745[var0] = true;
            return true;
         } else {
            if(null == class173.field2837[var0]) {
               class173.field2837[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class173.field2837[var0][var2] == null) {
                  byte[] var3 = class173.field2746.method3280(var0, var2);
                  if(null != var3) {
                     class173.field2837[var0][var2] = new class173();
                     class173.field2837[var0][var2].field2794 = var2 + (var0 << 16);
                     if(-1 == var3[0]) {
                        class173.field2837[var0][var2].method3386(new class119(var3));
                     } else {
                        class173.field2837[var0][var2].method3391(new class119(var3));
                     }
                  }
               }
            }

            class173.field2745[var0] = true;
            return true;
         }
      }
   }
}

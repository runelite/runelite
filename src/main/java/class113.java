import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class113 {
   @ObfuscatedName("w")
   byte[] field1954;
   @ObfuscatedName("a")
   int[] field1956;
   @ObfuscatedName("d")
   int[] field1957;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1315948357
   )
   @Export("cameraYaw")
   static int field1958;

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1956 = new int[var2];
      this.field1954 = var1;
      int[] var3 = new int[33];
      this.field1957 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(0 != var6) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1956[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if(0 != (var8 & var7)) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(0 == this.field1957[var10]) {
                     this.field1957[var10] = var4;
                  }

                  var10 = this.field1957[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1957.length) {
                  int[] var13 = new int[2 * this.field1957.length];

                  for(int var14 = 0; var14 < this.field1957.length; ++var14) {
                     var13[var14] = this.field1957[var14];
                  }

                  this.field1957 = var13;
               }

               var12 >>>= 1;
            }

            this.field1957[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "0"
   )
   public int method2535(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1956[var8];
         byte var10 = this.field1954[var8];
         if(0 == var10) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var12 + var10 - 1 >> 3);
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

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "0"
   )
   public int method2536(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(0 == var5) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 64)) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 4)) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1957[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1957[var6]) < 0) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-54"
   )
   public static int method2541(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "-1535964521"
   )
   static void method2542(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2773;
      int var5 = var0.field2774;
      if(0 == var0.field2881) {
         var0.field2773 = var0.field2827;
      } else if(var0.field2881 == 1) {
         var0.field2773 = var1 - var0.field2827;
      } else if(var0.field2881 == 2) {
         var0.field2773 = var0.field2827 * var1 >> 14;
      }

      if(0 == var0.field2880) {
         var0.field2774 = var0.field2809;
      } else if(1 == var0.field2880) {
         var0.field2774 = var2 - var0.field2809;
      } else if(2 == var0.field2880) {
         var0.field2774 = var0.field2809 * var2 >> 14;
      }

      if(var0.field2881 == 4) {
         var0.field2773 = var0.field2775 * var0.field2774 / var0.field2776;
      }

      if(var0.field2880 == 4) {
         var0.field2774 = var0.field2776 * var0.field2773 / var0.field2775;
      }

      if(client.field462 && 0 == var0.field2824) {
         if(var0.field2774 < 5 && var0.field2773 < 5) {
            var0.field2774 = 5;
            var0.field2773 = 5;
         } else {
            if(var0.field2774 <= 0) {
               var0.field2774 = 5;
            }

            if(var0.field2773 <= 0) {
               var0.field2773 = 5;
            }
         }
      }

      if(var0.field2762 == 1337) {
         client.field470 = var0;
      }

      if(var3 && null != var0.field2797 && (var4 != var0.field2773 || var5 != var0.field2774)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field4 = var0.field2797;
         client.field492.method3900(var6);
      }

   }
}

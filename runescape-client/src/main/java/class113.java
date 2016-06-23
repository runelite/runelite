import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class113 {
   @ObfuscatedName("o")
   public static boolean field1968;
   @ObfuscatedName("u")
   byte[] field1969;
   @ObfuscatedName("x")
   int[] field1970;
   @ObfuscatedName("bc")
   static class168 field1971;
   @ObfuscatedName("f")
   int[] field1972;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-32"
   )
   static String method2487(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "28"
   )
   public int method2488(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1970[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1970[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "5"
   )
   public int method2489(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1972[var8];
         byte var10 = this.field1969[var8];
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

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1972 = new int[var2];
      this.field1969 = var1;
      int[] var3 = new int[33];
      this.field1970 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1972[var5] = var8;
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
                  if(var8 != var11) {
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
                  if(this.field1970[var10] == 0) {
                     this.field1970[var10] = var4;
                  }

                  var10 = this.field1970[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1970.length) {
                  int[] var13 = new int[2 * this.field1970.length];

                  for(int var14 = 0; var14 < this.field1970.length; ++var14) {
                     var13[var14] = this.field1970[var14];
                  }

                  this.field1970 = var13;
               }

               var12 >>>= 1;
            }

            this.field1970[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2018195196"
   )
   public static void method2493() {
      if(null != class171.field2722) {
         class171.field2722.method3013();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass130;",
      garbageValue = "-1747730515"
   )
   public static class130[] method2495() {
      return new class130[]{class130.field2059, class130.field2060, class130.field2061};
   }
}

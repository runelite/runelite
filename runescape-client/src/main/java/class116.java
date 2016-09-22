import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class116 {
   @ObfuscatedName("pz")
   static class8 field2039;
   @ObfuscatedName("d")
   byte[] field2040;
   @ObfuscatedName("v")
   int[] field2041;
   @ObfuscatedName("a")
   int[] field2045;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "1745605515"
   )
   public int method2455(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2041[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2041[var6]) < 0) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "36"
   )
   public int method2456(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2045[var8];
         byte var10 = this.field2040[var8];
         if(var10 == 0) {
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

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2045 = new int[var2];
      this.field2040 = var1;
      int[] var3 = new int[33];
      this.field2041 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2045[var5] = var8;
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
                  if(this.field2041[var10] == 0) {
                     this.field2041[var10] = var4;
                  }

                  var10 = this.field2041[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2041.length) {
                  int[] var13 = new int[this.field2041.length * 2];

                  for(int var14 = 0; var14 < this.field2041.length; ++var14) {
                     var13[var14] = this.field2041[var14];
                  }

                  this.field2041 = var13;
               }

               var12 >>>= 1;
            }

            this.field2041[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "60"
   )
   static final int method2462(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class5.tileHeights[var5][var3 + 1][var4] + class5.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = class5.tileHeights[var5][1 + var3][var4 + 1] * var6 + class5.tileHeights[var5][var3][1 + var4] * (128 - var6) >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }
}

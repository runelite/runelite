import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class165 {
   @ObfuscatedName("p")
   byte[] field2329;
   @ObfuscatedName("i")
   int[] field2330;
   @ObfuscatedName("n")
   int[] field2331;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -4091419
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("pi")
   static class116 field2334;

   public class165(byte[] var1) {
      int var2 = var1.length;
      this.field2331 = new int[var2];
      this.field2329 = var1;
      int[] var3 = new int[33];
      this.field2330 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2331[var5] = var8;
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
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2330[var10] == 0) {
                     this.field2330[var10] = var4;
                  }

                  var10 = this.field2330[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2330.length) {
                  int[] var13 = new int[this.field2330.length * 2];

                  for(int var14 = 0; var14 < this.field2330.length; ++var14) {
                     var13[var14] = this.field2330[var14];
                  }

                  this.field2330 = var13;
               }

               var12 >>>= 1;
            }

            this.field2330[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZI)V",
      garbageValue = "-265770181"
   )
   static void method3072(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class234 var8 = (class234)class238.field3255.method3545(var6);
      if(var8 == null) {
         var8 = (class234)class238.field3268.method3545(var6);
         if(var8 == null) {
            var8 = (class234)class238.field3258.method3545(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3641();
                  class238.field3255.method3546(var8, var6);
                  --class238.field3259;
                  ++class238.field3254;
               }

            } else {
               if(!var5) {
                  var8 = (class234)class238.field3260.method3545(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class234();
               var8.field3213 = var0;
               var8.field3212 = var3;
               var8.field3210 = var4;
               if(var5) {
                  class238.field3255.method3546(var8, var6);
                  ++class238.field3254;
               } else {
                  class238.field3253.method3472(var8);
                  class238.field3258.method3546(var8, var6);
                  ++class238.field3259;
               }

            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1966828971"
   )
   public int method3075(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2331[var8];
         byte var10 = this.field2329[var8];
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

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "555828361"
   )
   public static int method3078(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "0"
   )
   public int method3079(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2330[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2330[var6]) < 0) {
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
}

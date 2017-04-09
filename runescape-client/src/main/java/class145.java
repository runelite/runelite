import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class145 {
   @ObfuscatedName("i")
   byte[] field2030;
   @ObfuscatedName("f")
   int[] field2031;
   @ObfuscatedName("u")
   int[] field2032;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1318174523
   )
   static int field2033;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1825781389"
   )
   public int method2793(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2031[var8];
         byte var10 = this.field2030[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
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

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field2031 = new int[var2];
      this.field2030 = var1;
      int[] var3 = new int[33];
      this.field2032 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2031[var5] = var8;
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
                  if(this.field2032[var10] == 0) {
                     this.field2032[var10] = var4;
                  }

                  var10 = this.field2032[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2032.length) {
                  int[] var13 = new int[this.field2032.length * 2];

                  for(int var14 = 0; var14 < this.field2032.length; ++var14) {
                     var13[var14] = this.field2032[var14];
                  }

                  this.field2032 = var13;
               }

               var12 >>>= 1;
            }

            this.field2032[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "55"
   )
   public int method2799(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2032[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2032[var6]) < 0) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LSpotanim;",
      garbageValue = "-64"
   )
   public static Spotanim method2800(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2804.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field2805.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2806 = var0;
         if(var2 != null) {
            var1.method3515(new Buffer(var2));
         }

         Spotanim.field2804.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass228;B)I",
      garbageValue = "-122"
   )
   static final int method2801(class228 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3256) {
         case 2:
            return 20;
         default:
            return 12;
         }
      }
   }
}

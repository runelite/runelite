import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class165 {
   @ObfuscatedName("i")
   int[] field2297;
   @ObfuscatedName("h")
   byte[] field2298;
   @ObfuscatedName("u")
   int[] field2299;
   @ObfuscatedName("t")
   public static IndexDataBase field2302;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-239507700"
   )
   public int method3119(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2299[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2299[var6]) < 0) {
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
      signature = "([BII[BIB)I",
      garbageValue = "-34"
   )
   public int method3124(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2297[var8];
         byte var10 = this.field2298[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var10 + var12 - 1 >> 3) + var11;
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

   public class165(byte[] var1) {
      int var2 = var1.length;
      this.field2297 = new int[var2];
      this.field2298 = var1;
      int[] var3 = new int[33];
      this.field2299 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2297[var5] = var8;
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
                  if(this.field2299[var10] == 0) {
                     this.field2299[var10] = var4;
                  }

                  var10 = this.field2299[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2299.length) {
                  int[] var13 = new int[this.field2299.length * 2];

                  for(int var14 = 0; var14 < this.field2299.length; ++var14) {
                     var13[var14] = this.field2299[var14];
                  }

                  this.field2299 = var13;
               }

               var12 >>>= 1;
            }

            this.field2299[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "190234959"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3596.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3601.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method4752(new Buffer(var2));
         }

         var1.method4772();
         Sequence.field3596.put(var1, (long)var0);
         return var1;
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class113 {
   @ObfuscatedName("g")
   byte[] field1944;
   @ObfuscatedName("j")
   int[] field1945;
   @ObfuscatedName("eq")
   static class78[] field1946;
   @ObfuscatedName("b")
   int[] field1947;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "0"
   )
   public int method2443(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1947[var8];
         byte var10 = this.field1944[var8];
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public static String method2444(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2657[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-1010289306"
   )
   public int method2448(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1945[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1945[var6]) < 0) {
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
      this.field1947 = new int[var2];
      this.field1944 = var1;
      int[] var3 = new int[33];
      this.field1945 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1947[var5] = var8;
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
                  if(this.field1945[var10] == 0) {
                     this.field1945[var10] = var4;
                  }

                  var10 = this.field1945[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1945.length) {
                  int[] var13 = new int[2 * this.field1945.length];

                  for(int var14 = 0; var14 < this.field1945.length; ++var14) {
                     var13[var14] = this.field1945[var14];
                  }

                  this.field1945 = var13;
               }

               var12 >>>= 1;
            }

            this.field1945[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "929329268"
   )
   static final String method2450(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1140000338"
   )
   static void method2451(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field221.method3807((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field221.method3797(var4, (long)var0);
      }

      if(var4.field216.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field216.length; ++var7) {
            var5[var7] = var4.field216[var7];
            var6[var7] = var4.field217[var7];
         }

         for(var7 = var4.field216.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field216 = var5;
         var4.field217 = var6;
      }

      var4.field216[var1] = var2;
      var4.field217[var1] = var3;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
public class class113 {
   @ObfuscatedName("x")
   byte[] field1971;
   @ObfuscatedName("t")
   int[] field1972;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -104731365
   )
   static int field1976;
   @ObfuscatedName("w")
   int[] field1977;

   @ObfuscatedName("x")
   public int method2442(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(0 == var5) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 64)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 32)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 16)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 8)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 4)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 1)) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
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
      this.field1977 = new int[var2];
      this.field1971 = var1;
      int[] var3 = new int[33];
      this.field1972 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(0 != var6) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1977[var5] = var8;
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

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(0 == this.field1972[var10]) {
                     this.field1972[var10] = var4;
                  }

                  var10 = this.field1972[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1972.length) {
                  int[] var13 = new int[this.field1972.length * 2];

                  for(int var14 = 0; var14 < this.field1972.length; ++var14) {
                     var13[var14] = this.field1972[var14];
                  }

                  this.field1972 = var13;
               }

               var12 >>>= 1;
            }

            this.field1972[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("ce")
   static void method2444(int var0) {
      class76.field1386 = new class30();
      class76.field1386.field713 = client.field436[var0];
      class76.field1386.field706 = client.field437[var0];
      class76.field1386.field710 = client.field448[var0];
      class76.field1386.field708 = client.field439[var0];
      class76.field1386.field709 = client.field440[var0];
   }

   @ObfuscatedName("w")
   public int method2446(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1977[var8];
         byte var10 = this.field1971[var8];
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

      return (7 + var7 >> 3) - var5;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class113 {
   @ObfuscatedName("p")
   int[] field1969;
   @ObfuscatedName("s")
   int[] field1970;
   @ObfuscatedName("j")
   byte[] field1974;

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1970 = new int[var2];
      this.field1974 = var1;
      int[] var3 = new int[33];
      this.field1969 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(0 != var6) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1970[var5] = var8;
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
                  if(var8 != var11) {
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

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if(0 != (var8 & var12)) {
                  if(this.field1969[var10] == 0) {
                     this.field1969[var10] = var4;
                  }

                  var10 = this.field1969[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1969.length) {
                  int[] var13 = new int[2 * this.field1969.length];

                  for(int var14 = 0; var14 < this.field1969.length; ++var14) {
                     var13[var14] = this.field1969[var14];
                  }

                  this.field1969 = var13;
               }

               var12 >>>= 1;
            }

            this.field1969[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "0"
   )
   public int method2429(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 64)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 32)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 16)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 8)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 1)) {
               var6 = this.field1969[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1969[var6]) < 0) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "0"
   )
   public int method2432(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1970[var8];
         byte var10 = this.field1974[var8];
         if(0 == var10) {
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

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-134882049"
   )
   static void method2434(int var0) {
      for(class201 var1 = (class201)client.field479.method3780(); var1 != null; var1 = (class201)client.field479.method3781()) {
         if((long)var0 == (var1.field3125 >> 48 & 65535L)) {
            var1.method3898();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-500009705"
   )
   public static void method2435() {
      class42.field984.method3750();
      class42.field982.method3750();
   }
}

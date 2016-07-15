import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class76 {
   @ObfuscatedName("r")
   float[][] field1426;
   @ObfuscatedName("l")
   int field1427;
   @ObfuscatedName("c")
   int[] field1428;
   @ObfuscatedName("a")
   int[] field1429;
   @ObfuscatedName("h")
   int[] field1430;
   @ObfuscatedName("e")
   int field1431;

   @ObfuscatedName("l")
   void method1671() {
      int[] var1 = new int[this.field1427];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1427; ++var3) {
         var4 = this.field1428[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var9;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var2[var8];
               if(var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1429 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field1427; ++var3) {
         var4 = this.field1428[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1429[var6] == 0) {
                     this.field1429[var6] = var12;
                  }

                  var6 = this.field1429[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1429.length) {
                  int[] var11 = new int[this.field1429.length * 2];

                  for(var10 = 0; var10 < this.field1429.length; ++var10) {
                     var11[var10] = this.field1429[var10];
                  }

                  this.field1429 = var11;
               }

               var8 >>>= 1;
            }

            this.field1429[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   class76() {
      class73.method1624(24);
      this.field1431 = class73.method1624(16);
      this.field1427 = class73.method1624(24);
      this.field1428 = new int[this.field1427];
      boolean var1 = class73.method1628() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1624(5) + 1; var2 < this.field1427; ++var3) {
            int var4 = class73.method1624(class39.method802(this.field1427 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1428[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1628() != 0;

         for(var3 = 0; var3 < this.field1427; ++var3) {
            if(var14 && class73.method1628() == 0) {
               this.field1428[var3] = 0;
            } else {
               this.field1428[var3] = class73.method1624(5) + 1;
            }
         }
      }

      this.method1671();
      var2 = class73.method1624(4);
      if(var2 > 0) {
         float var15 = class73.method1641(class73.method1624(32));
         float var16 = class73.method1641(class73.method1624(32));
         var5 = class73.method1624(4) + 1;
         boolean var6 = class73.method1628() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1674(this.field1427, this.field1431);
         } else {
            var7 = this.field1427 * this.field1431;
         }

         this.field1430 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1430[var8] = class73.method1624(var5);
         }

         this.field1426 = new float[this.field1427][this.field1431];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1427; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1431; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1430[var12] * var16 + var15 + var9;
                  this.field1426[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1427; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1431;

               for(var11 = 0; var11 < this.field1431; ++var11) {
                  float var17 = (float)this.field1430[var10] * var16 + var15 + var9;
                  this.field1426[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   float[] method1673() {
      return this.field1426[this.method1679()];
   }

   @ObfuscatedName("e")
   static int method1674(int var0, int var1) {
      int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

      while(true) {
         int var4 = var2;
         int var5 = var1;

         int var6;
         for(var6 = 1; var5 > 1; var5 >>= 1) {
            if((var5 & 1) != 0) {
               var6 *= var4;
            }

            var4 *= var4;
         }

         int var3;
         if(var5 == 1) {
            var3 = var6 * var4;
         } else {
            var3 = var6;
         }

         if(var3 <= var0) {
            return var2;
         }

         --var2;
      }
   }

   @ObfuscatedName("c")
   int method1679() {
      int var1;
      for(var1 = 0; this.field1429[var1] >= 0; var1 = class73.method1628() != 0?this.field1429[var1]:var1 + 1) {
         ;
      }

      return ~this.field1429[var1];
   }
}

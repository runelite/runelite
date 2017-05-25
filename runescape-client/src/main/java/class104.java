import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public class class104 {
   @ObfuscatedName("q")
   int[] field1557;
   @ObfuscatedName("h")
   int field1558;
   @ObfuscatedName("u")
   int[] field1559;
   @ObfuscatedName("g")
   float[][] field1560;
   @ObfuscatedName("i")
   int field1561;
   @ObfuscatedName("v")
   int[] field1562;

   class104() {
      class106.method1978(24);
      this.field1561 = class106.method1978(16);
      this.field1558 = class106.method1978(24);
      this.field1559 = new int[this.field1558];
      boolean var1 = class106.method1977() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class106.method1978(5) + 1; var2 < this.field1558; ++var3) {
            int var4 = class106.method1978(class25.method177(this.field1558 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1559[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class106.method1977() != 0;

         for(var3 = 0; var3 < this.field1558; ++var3) {
            if(var14 && class106.method1977() == 0) {
               this.field1559[var3] = 0;
            } else {
               this.field1559[var3] = class106.method1978(5) + 1;
            }
         }
      }

      this.method1949();
      var2 = class106.method1978(4);
      if(var2 > 0) {
         float var15 = class106.method1994(class106.method1978(32));
         float var16 = class106.method1994(class106.method1978(32));
         var5 = class106.method1978(4) + 1;
         boolean var6 = class106.method1977() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1958(this.field1558, this.field1561);
         } else {
            var7 = this.field1558 * this.field1561;
         }

         this.field1557 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1557[var8] = class106.method1978(var5);
         }

         this.field1560 = new float[this.field1558][this.field1561];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1558; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1561; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1557[var12] * var16 + var15 + var9;
                  this.field1560[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1558; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1561;

               for(var11 = 0; var11 < this.field1561; ++var11) {
                  float var17 = (float)this.field1557[var10] * var16 + var15 + var9;
                  this.field1560[var8][var11] = var17;
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
   void method1949() {
      int[] var1 = new int[this.field1558];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1558; ++var3) {
         var4 = this.field1559[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var11[var4];
            var1[var3] = var6;
            int var12;
            if((var6 & var5) != 0) {
               var7 = var11[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var12 = var11[var8];
                  if(var12 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var12 & var10) != 0) {
                     var11[var8] = var11[var8 - 1];
                     break;
                  }

                  var11[var8] = var12 | var10;
               }
            }

            var11[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var12 = var11[var8];
               if(var12 == var6) {
                  var11[var8] = var7;
               }
            }
         }
      }

      this.field1562 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1558; ++var3) {
         var4 = this.field1559[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1562[var6] == 0) {
                     this.field1562[var6] = var2;
                  }

                  var6 = this.field1562[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1562.length) {
                  int[] var9 = new int[this.field1562.length * 2];

                  for(var10 = 0; var10 < this.field1562.length; ++var10) {
                     var9[var10] = this.field1562[var10];
                  }

                  this.field1562 = var9;
               }

               var8 >>>= 1;
            }

            this.field1562[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("u")
   int method1950() {
      int var1;
      for(var1 = 0; this.field1562[var1] >= 0; var1 = class106.method1977() != 0?this.field1562[var1]:var1 + 1) {
         ;
      }

      return ~this.field1562[var1];
   }

   @ObfuscatedName("q")
   float[] method1951() {
      return this.field1560[this.method1950()];
   }

   @ObfuscatedName("i")
   static int method1958(int var0, int var1) {
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
            var3 = var4 * var6;
         } else {
            var3 = var6;
         }

         if(var3 <= var0) {
            return var2;
         }

         --var2;
      }
   }
}

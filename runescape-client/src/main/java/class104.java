import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
public class class104 {
   @ObfuscatedName("j")
   int[] field1568;
   @ObfuscatedName("p")
   int field1569;
   @ObfuscatedName("n")
   int field1570;
   @ObfuscatedName("i")
   int[] field1571;
   @ObfuscatedName("f")
   float[][] field1572;
   @ObfuscatedName("m")
   int[] field1573;

   @ObfuscatedName("i")
   int method1902() {
      int var1;
      for(var1 = 0; this.field1573[var1] >= 0; var1 = class106.method1935() != 0?this.field1573[var1]:var1 + 1) {
         ;
      }

      return ~this.field1573[var1];
   }

   class104() {
      class106.method1936(24);
      this.field1570 = class106.method1936(16);
      this.field1569 = class106.method1936(24);
      this.field1571 = new int[this.field1569];
      boolean var1 = class106.method1935() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class106.method1936(5) + 1; var2 < this.field1569; ++var3) {
            int var4 = class106.method1936(FrameMap.method2673(this.field1569 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1571[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class106.method1935() != 0;

         for(var3 = 0; var3 < this.field1569; ++var3) {
            if(var14 && class106.method1935() == 0) {
               this.field1571[var3] = 0;
            } else {
               this.field1571[var3] = class106.method1936(5) + 1;
            }
         }
      }

      this.method1903();
      var2 = class106.method1936(4);
      if(var2 > 0) {
         float var15 = class106.method1951(class106.method1936(32));
         float var16 = class106.method1951(class106.method1936(32));
         var5 = class106.method1936(4) + 1;
         boolean var6 = class106.method1935() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1913(this.field1569, this.field1570);
         } else {
            var7 = this.field1569 * this.field1570;
         }

         this.field1568 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1568[var8] = class106.method1936(var5);
         }

         this.field1572 = new float[this.field1569][this.field1570];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1569; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1570; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1568[var12] * var16 + var15 + var9;
                  this.field1572[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1569; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1570;

               for(var11 = 0; var11 < this.field1570; ++var11) {
                  float var17 = (float)this.field1568[var10] * var16 + var15 + var9;
                  this.field1572[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   void method1903() {
      int[] var1 = new int[this.field1569];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1569; ++var3) {
         var4 = this.field1571[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var11[var4];
            var1[var3] = var6;
            int var9;
            if((var6 & var5) != 0) {
               var7 = var11[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var11[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var11[var8] = var11[var8 - 1];
                     break;
                  }

                  var11[var8] = var9 | var10;
               }
            }

            var11[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var11[var8];
               if(var9 == var6) {
                  var11[var8] = var7;
               }
            }
         }
      }

      this.field1573 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1569; ++var3) {
         var4 = this.field1571[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1573[var6] == 0) {
                     this.field1573[var6] = var2;
                  }

                  var6 = this.field1573[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1573.length) {
                  int[] var12 = new int[this.field1573.length * 2];

                  for(var10 = 0; var10 < this.field1573.length; ++var10) {
                     var12[var10] = this.field1573[var10];
                  }

                  this.field1573 = var12;
               }

               var8 >>>= 1;
            }

            this.field1573[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("j")
   float[] method1905() {
      return this.field1572[this.method1902()];
   }

   @ObfuscatedName("n")
   static int method1913(int var0, int var1) {
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
}

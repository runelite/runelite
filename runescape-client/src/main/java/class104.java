import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dn")
public class class104 {
   @ObfuscatedName("i")
   int field1585;
   @ObfuscatedName("s")
   float[][] field1586;
   @ObfuscatedName("a")
   int[] field1587;
   @ObfuscatedName("w")
   int field1588;
   @ObfuscatedName("t")
   int[] field1589;
   @ObfuscatedName("r")
   int[] field1590;

   @ObfuscatedName("i")
   static int method1930(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class27.method209(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("w")
   void method1931() {
      int[] var1 = new int[this.field1588];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1588; ++var3) {
         var4 = this.field1587[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var12;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var12 = var2[var8];
                  if(var12 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var12 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var12 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var12 = var2[var8];
               if(var12 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1590 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field1588; ++var3) {
         var4 = this.field1587[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1590[var6] == 0) {
                     this.field1590[var6] = var11;
                  }

                  var6 = this.field1590[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1590.length) {
                  int[] var9 = new int[this.field1590.length * 2];

                  for(var10 = 0; var10 < this.field1590.length; ++var10) {
                     var9[var10] = this.field1590[var10];
                  }

                  this.field1590 = var9;
               }

               var8 >>>= 1;
            }

            this.field1590[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("t")
   float[] method1933() {
      return this.field1586[this.method1937()];
   }

   class104() {
      class106.method1973(24);
      this.field1585 = class106.method1973(16);
      this.field1588 = class106.method1973(24);
      this.field1587 = new int[this.field1588];
      boolean var1 = class106.method1958() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class106.method1973(5) + 1; var2 < this.field1588; ++var3) {
            int var4 = class106.method1973(class134.method2574(this.field1588 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1587[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class106.method1958() != 0;

         for(var3 = 0; var3 < this.field1588; ++var3) {
            if(var14 && class106.method1958() == 0) {
               this.field1587[var3] = 0;
            } else {
               this.field1587[var3] = class106.method1973(5) + 1;
            }
         }
      }

      this.method1931();
      var2 = class106.method1973(4);
      if(var2 > 0) {
         float var15 = class106.method1963(class106.method1973(32));
         float var16 = class106.method1963(class106.method1973(32));
         var5 = class106.method1973(4) + 1;
         boolean var6 = class106.method1958() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1930(this.field1588, this.field1585);
         } else {
            var7 = this.field1588 * this.field1585;
         }

         this.field1589 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1589[var8] = class106.method1973(var5);
         }

         this.field1586 = new float[this.field1588][this.field1585];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1588; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1585; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1589[var12] * var16 + var15 + var9;
                  this.field1586[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1588; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1585;

               for(var11 = 0; var11 < this.field1585; ++var11) {
                  float var17 = (float)this.field1589[var10] * var16 + var15 + var9;
                  this.field1586[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   int method1937() {
      int var1;
      for(var1 = 0; this.field1590[var1] >= 0; var1 = class106.method1958() != 0?this.field1590[var1]:var1 + 1) {
         ;
      }

      return ~this.field1590[var1];
   }
}

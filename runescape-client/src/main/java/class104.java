import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
public class class104 {
   @ObfuscatedName("v")
   int[] field1576;
   @ObfuscatedName("c")
   int field1577;
   @ObfuscatedName("e")
   int[] field1578;
   @ObfuscatedName("b")
   float[][] field1579;
   @ObfuscatedName("i")
   int field1580;
   @ObfuscatedName("y")
   int[] field1581;

   @ObfuscatedName("c")
   void method1917() {
      int[] var1 = new int[this.field1577];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1577; ++var3) {
         var4 = this.field1578[var3];
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

      this.field1581 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field1577; ++var3) {
         var4 = this.field1578[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1581[var6] == 0) {
                     this.field1581[var6] = var11;
                  }

                  var6 = this.field1581[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1581.length) {
                  int[] var12 = new int[this.field1581.length * 2];

                  for(var10 = 0; var10 < this.field1581.length; ++var10) {
                     var12[var10] = this.field1581[var10];
                  }

                  this.field1581 = var12;
               }

               var8 >>>= 1;
            }

            this.field1581[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   class104() {
      class106.method1950(24);
      this.field1580 = class106.method1950(16);
      this.field1577 = class106.method1950(24);
      this.field1578 = new int[this.field1577];
      boolean var1 = class106.method1949() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class106.method1950(5) + 1; var2 < this.field1577; ++var3) {
            int var4 = class106.method1950(class11.method50(this.field1577 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1578[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class106.method1949() != 0;

         for(var3 = 0; var3 < this.field1577; ++var3) {
            if(var14 && class106.method1949() == 0) {
               this.field1578[var3] = 0;
            } else {
               this.field1578[var3] = class106.method1950(5) + 1;
            }
         }
      }

      this.method1917();
      var2 = class106.method1950(4);
      if(var2 > 0) {
         float var15 = class106.method1976(class106.method1950(32));
         float var16 = class106.method1976(class106.method1950(32));
         var5 = class106.method1950(4) + 1;
         boolean var6 = class106.method1949() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1925(this.field1577, this.field1580);
         } else {
            var7 = this.field1577 * this.field1580;
         }

         this.field1576 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1576[var8] = class106.method1950(var5);
         }

         this.field1579 = new float[this.field1577][this.field1580];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1577; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1580; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1576[var12] * var16 + var15 + var9;
                  this.field1579[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1577; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1580;

               for(var11 = 0; var11 < this.field1580; ++var11) {
                  float var17 = (float)this.field1576[var10] * var16 + var15 + var9;
                  this.field1579[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   int method1920() {
      int var1;
      for(var1 = 0; this.field1581[var1] >= 0; var1 = class106.method1949() != 0?this.field1581[var1]:var1 + 1) {
         ;
      }

      return ~this.field1581[var1];
   }

   @ObfuscatedName("i")
   static int method1925(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class51.method760(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("v")
   float[] method1926() {
      return this.field1579[this.method1920()];
   }
}

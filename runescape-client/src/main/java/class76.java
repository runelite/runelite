import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class76 {
   @ObfuscatedName("a")
   int field1431;
   @ObfuscatedName("t")
   int[] field1432;
   @ObfuscatedName("v")
   int[] field1433;
   @ObfuscatedName("d")
   int field1434;
   @ObfuscatedName("z")
   float[][] field1435;
   @ObfuscatedName("r")
   int[] field1436;

   @ObfuscatedName("d")
   void method1626() {
      int[] var1 = new int[this.field1434];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1434; ++var3) {
         var4 = this.field1433[var3];
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

      this.field1432 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1434; ++var3) {
         var4 = this.field1433[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1432[var6] == 0) {
                     this.field1432[var6] = var2;
                  }

                  var6 = this.field1432[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1432.length) {
                  int[] var12 = new int[this.field1432.length * 2];

                  for(var10 = 0; var10 < this.field1432.length; ++var10) {
                     var12[var10] = this.field1432[var10];
                  }

                  this.field1432 = var12;
               }

               var8 >>>= 1;
            }

            this.field1432[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("a")
   static int method1627(int var0, int var1) {
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

   @ObfuscatedName("v")
   int method1628() {
      int var1;
      for(var1 = 0; this.field1432[var1] >= 0; var1 = class73.method1582() != 0?this.field1432[var1]:var1 + 1) {
         ;
      }

      return ~this.field1432[var1];
   }

   @ObfuscatedName("r")
   float[] method1629() {
      return this.field1435[this.method1628()];
   }

   class76() {
      class73.method1599(24);
      this.field1431 = class73.method1599(16);
      this.field1434 = class73.method1599(24);
      this.field1433 = new int[this.field1434];
      boolean var1 = class73.method1582() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1599(5) + 1; var2 < this.field1434; ++var3) {
            int var4 = class73.method1599(class92.method2113(this.field1434 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1433[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1582() != 0;

         for(var3 = 0; var3 < this.field1434; ++var3) {
            if(var14 && class73.method1582() == 0) {
               this.field1433[var3] = 0;
            } else {
               this.field1433[var3] = class73.method1599(5) + 1;
            }
         }
      }

      this.method1626();
      var2 = class73.method1599(4);
      if(var2 > 0) {
         float var15 = class73.method1596(class73.method1599(32));
         float var16 = class73.method1596(class73.method1599(32));
         var5 = class73.method1599(4) + 1;
         boolean var6 = class73.method1582() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1627(this.field1434, this.field1431);
         } else {
            var7 = this.field1434 * this.field1431;
         }

         this.field1436 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1436[var8] = class73.method1599(var5);
         }

         this.field1435 = new float[this.field1434][this.field1431];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1434; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1431; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1436[var12] * var16 + var15 + var9;
                  this.field1435[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1434; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1431;

               for(var11 = 0; var11 < this.field1431; ++var11) {
                  float var17 = (float)this.field1436[var10] * var16 + var15 + var9;
                  this.field1435[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }
}

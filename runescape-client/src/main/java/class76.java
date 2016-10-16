import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class76 {
   @ObfuscatedName("t")
   int[] field1400;
   @ObfuscatedName("z")
   int field1401;
   @ObfuscatedName("s")
   int field1402;
   @ObfuscatedName("y")
   int[] field1403;
   @ObfuscatedName("p")
   float[][] field1404;
   @ObfuscatedName("g")
   int[] field1405;

   class76() {
      class73.method1540(24);
      this.field1402 = class73.method1540(16);
      this.field1401 = class73.method1540(24);
      this.field1400 = new int[this.field1401];
      boolean var1 = class73.method1539() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1540(5) + 1; var2 < this.field1401; ++var3) {
            int var4 = class73.method1540(class10.method129(this.field1401 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1400[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1539() != 0;

         for(var3 = 0; var3 < this.field1401; ++var3) {
            if(var14 && class73.method1539() == 0) {
               this.field1400[var3] = 0;
            } else {
               this.field1400[var3] = class73.method1540(5) + 1;
            }
         }
      }

      this.method1587();
      var2 = class73.method1540(4);
      if(var2 > 0) {
         float var15 = class73.method1546(class73.method1540(32));
         float var16 = class73.method1546(class73.method1540(32));
         var5 = class73.method1540(4) + 1;
         boolean var6 = class73.method1539() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1597(this.field1401, this.field1402);
         } else {
            var7 = this.field1401 * this.field1402;
         }

         this.field1403 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1403[var8] = class73.method1540(var5);
         }

         this.field1404 = new float[this.field1401][this.field1402];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1401; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1402; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1403[var12] * var16 + var15 + var9;
                  this.field1404[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1401; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1402;

               for(var11 = 0; var11 < this.field1402; ++var11) {
                  float var17 = (float)this.field1403[var10] * var16 + var15 + var9;
                  this.field1404[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   void method1587() {
      int[] var1 = new int[this.field1401];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1401; ++var3) {
         var4 = this.field1400[var3];
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

      this.field1405 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field1401; ++var3) {
         var4 = this.field1400[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1405[var6] == 0) {
                     this.field1405[var6] = var12;
                  }

                  var6 = this.field1405[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1405.length) {
                  int[] var11 = new int[this.field1405.length * 2];

                  for(var10 = 0; var10 < this.field1405.length; ++var10) {
                     var11[var10] = this.field1405[var10];
                  }

                  this.field1405 = var11;
               }

               var8 >>>= 1;
            }

            this.field1405[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("y")
   float[] method1589() {
      return this.field1404[this.method1594()];
   }

   @ObfuscatedName("t")
   int method1594() {
      int var1;
      for(var1 = 0; this.field1405[var1] >= 0; var1 = class73.method1539() != 0?this.field1405[var1]:var1 + 1) {
         ;
      }

      return ~this.field1405[var1];
   }

   @ObfuscatedName("s")
   static int method1597(int var0, int var1) {
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

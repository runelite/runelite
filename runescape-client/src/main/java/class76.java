import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class76 {
   @ObfuscatedName("e")
   int[] field1429;
   @ObfuscatedName("s")
   int[] field1430;
   @ObfuscatedName("r")
   int[] field1431;
   @ObfuscatedName("g")
   int field1432;
   @ObfuscatedName("l")
   int field1433;
   @ObfuscatedName("h")
   float[][] field1434;

   class76() {
      class73.method1668(24);
      this.field1433 = class73.method1668(16);
      this.field1432 = class73.method1668(24);
      this.field1431 = new int[this.field1432];
      boolean var1 = class73.method1646() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1668(5) + 1; var2 < this.field1432; ++var3) {
            int var4 = class73.method1668(class50.method1067(this.field1432 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1431[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1646() != 0;

         for(var3 = 0; var3 < this.field1432; ++var3) {
            if(var14 && class73.method1646() == 0) {
               this.field1431[var3] = 0;
            } else {
               this.field1431[var3] = class73.method1668(5) + 1;
            }
         }
      }

      this.method1685();
      var2 = class73.method1668(4);
      if(var2 > 0) {
         float var15 = class73.method1645(class73.method1668(32));
         float var16 = class73.method1645(class73.method1668(32));
         var5 = class73.method1668(4) + 1;
         boolean var6 = class73.method1646() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1693(this.field1432, this.field1433);
         } else {
            var7 = this.field1432 * this.field1433;
         }

         this.field1429 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1429[var8] = class73.method1668(var5);
         }

         this.field1434 = new float[this.field1432][this.field1433];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1432; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1433; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1429[var12] * var16 + var15 + var9;
                  this.field1434[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1432; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1433;

               for(var11 = 0; var11 < this.field1433; ++var11) {
                  float var17 = (float)this.field1429[var10] * var16 + var15 + var9;
                  this.field1434[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   void method1685() {
      int[] var1 = new int[this.field1432];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1432; ++var3) {
         var4 = this.field1431[var3];
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

      this.field1430 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field1432; ++var3) {
         var4 = this.field1431[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1430[var6] == 0) {
                     this.field1430[var6] = var11;
                  }

                  var6 = this.field1430[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1430.length) {
                  int[] var12 = new int[this.field1430.length * 2];

                  for(var10 = 0; var10 < this.field1430.length; ++var10) {
                     var12[var10] = this.field1430[var10];
                  }

                  this.field1430 = var12;
               }

               var8 >>>= 1;
            }

            this.field1430[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("e")
   float[] method1687() {
      return this.field1434[this.method1695()];
   }

   @ObfuscatedName("l")
   static int method1693(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class90.method2159(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("r")
   int method1695() {
      int var1;
      for(var1 = 0; this.field1430[var1] >= 0; var1 = class73.method1646() != 0?this.field1430[var1]:var1 + 1) {
         ;
      }

      return ~this.field1430[var1];
   }
}

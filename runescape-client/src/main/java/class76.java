import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class76 {
   @ObfuscatedName("i")
   int field1414;
   @ObfuscatedName("n")
   float[][] field1415;
   @ObfuscatedName("e")
   int[] field1416;
   @ObfuscatedName("h")
   int field1417;
   @ObfuscatedName("g")
   int[] field1418;
   @ObfuscatedName("u")
   int[] field1419;

   class76() {
      class73.method1567(24);
      this.field1414 = class73.method1567(16);
      this.field1417 = class73.method1567(24);
      this.field1416 = new int[this.field1417];
      boolean var1 = class73.method1566() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1567(5) + 1; var2 < this.field1417; ++var3) {
            int var4 = class73.method1567(Player.method45(this.field1417 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1416[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1566() != 0;

         for(var3 = 0; var3 < this.field1417; ++var3) {
            if(var14 && class73.method1566() == 0) {
               this.field1416[var3] = 0;
            } else {
               this.field1416[var3] = class73.method1567(5) + 1;
            }
         }
      }

      this.method1615();
      var2 = class73.method1567(4);
      if(var2 > 0) {
         float var15 = class73.method1594(class73.method1567(32));
         float var16 = class73.method1594(class73.method1567(32));
         var5 = class73.method1567(4) + 1;
         boolean var6 = class73.method1566() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1627(this.field1417, this.field1414);
         } else {
            var7 = this.field1417 * this.field1414;
         }

         this.field1418 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1418[var8] = class73.method1567(var5);
         }

         this.field1415 = new float[this.field1417][this.field1414];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1417; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1414; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1418[var12] * var16 + var15 + var9;
                  this.field1415[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1417; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1414;

               for(var11 = 0; var11 < this.field1414; ++var11) {
                  float var17 = (float)this.field1418[var10] * var16 + var15 + var9;
                  this.field1415[var8][var11] = var17;
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
   void method1615() {
      int[] var1 = new int[this.field1417];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1417; ++var3) {
         var4 = this.field1416[var3];
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

      this.field1419 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field1417; ++var3) {
         var4 = this.field1416[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1419[var6] == 0) {
                     this.field1419[var6] = var12;
                  }

                  var6 = this.field1419[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1419.length) {
                  int[] var11 = new int[this.field1419.length * 2];

                  for(var10 = 0; var10 < this.field1419.length; ++var10) {
                     var11[var10] = this.field1419[var10];
                  }

                  this.field1419 = var11;
               }

               var8 >>>= 1;
            }

            this.field1419[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("e")
   int method1616() {
      int var1;
      for(var1 = 0; this.field1419[var1] >= 0; var1 = class73.method1566() != 0?this.field1419[var1]:var1 + 1) {
         ;
      }

      return ~this.field1419[var1];
   }

   @ObfuscatedName("g")
   float[] method1617() {
      return this.field1415[this.method1616()];
   }

   @ObfuscatedName("i")
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

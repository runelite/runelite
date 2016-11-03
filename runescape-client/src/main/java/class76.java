import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class76 {
   @ObfuscatedName("v")
   float[][] field1413;
   @ObfuscatedName("k")
   int field1414;
   @ObfuscatedName("f")
   int[] field1415;
   @ObfuscatedName("c")
   int[] field1416;
   @ObfuscatedName("q")
   int field1417;
   @ObfuscatedName("j")
   int[] field1418;

   @ObfuscatedName("q")
   void method1635() {
      int[] var1 = new int[this.field1417];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1417; ++var3) {
         var4 = this.field1415[var3];
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

      this.field1418 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1417; ++var3) {
         var4 = this.field1415[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1418[var6] == 0) {
                     this.field1418[var6] = var2;
                  }

                  var6 = this.field1418[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1418.length) {
                  int[] var12 = new int[this.field1418.length * 2];

                  for(var10 = 0; var10 < this.field1418.length; ++var10) {
                     var12[var10] = this.field1418[var10];
                  }

                  this.field1418 = var12;
               }

               var8 >>>= 1;
            }

            this.field1418[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("f")
   int method1636() {
      int var1;
      for(var1 = 0; this.field1418[var1] >= 0; var1 = class73.method1606() != 0?this.field1418[var1]:var1 + 1) {
         ;
      }

      return ~this.field1418[var1];
   }

   class76() {
      class73.method1588(24);
      this.field1414 = class73.method1588(16);
      this.field1417 = class73.method1588(24);
      this.field1415 = new int[this.field1417];
      boolean var1 = class73.method1606() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1588(5) + 1; var2 < this.field1417; ++var3) {
            int var4 = class73.method1588(Client.method475(this.field1417 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1415[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1606() != 0;

         for(var3 = 0; var3 < this.field1417; ++var3) {
            if(var14 && class73.method1606() == 0) {
               this.field1415[var3] = 0;
            } else {
               this.field1415[var3] = class73.method1588(5) + 1;
            }
         }
      }

      this.method1635();
      var2 = class73.method1588(4);
      if(var2 > 0) {
         float var15 = class73.method1592(class73.method1588(32));
         float var16 = class73.method1592(class73.method1588(32));
         var5 = class73.method1588(4) + 1;
         boolean var6 = class73.method1606() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1643(this.field1417, this.field1414);
         } else {
            var7 = this.field1417 * this.field1414;
         }

         this.field1416 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1416[var8] = class73.method1588(var5);
         }

         this.field1413 = new float[this.field1417][this.field1414];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1417; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1414; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1416[var12] * var16 + var15 + var9;
                  this.field1413[var8][var11] = var13;
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
                  float var17 = (float)this.field1416[var10] * var16 + var15 + var9;
                  this.field1413[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   float[] method1642() {
      return this.field1413[this.method1636()];
   }

   @ObfuscatedName("k")
   static int method1643(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class11.method138(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}

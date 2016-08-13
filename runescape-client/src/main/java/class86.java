import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cy")
public class class86 extends Node {
   @ObfuscatedName("p")
   int[] field1520;
   @ObfuscatedName("h")
   int field1522;
   @ObfuscatedName("s")
   boolean field1523;
   @ObfuscatedName("k")
   int[] field1524;
   @ObfuscatedName("u")
   int[] field1525;
   @ObfuscatedName("n")
   int[] field1526;
   @ObfuscatedName("b")
   int[] field1527;
   @ObfuscatedName("m")
   int field1528;
   @ObfuscatedName("q")
   int field1529;
   @ObfuscatedName("w")
   boolean field1531 = false;
   @ObfuscatedName("o")
   static int[] field1532;

   @ObfuscatedName("l")
   boolean method1978(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1524.length; ++var5) {
         if(var4.method3455(this.field1524[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1520 = new int[var5];

      for(int var6 = 0; var6 < this.field1524.length; ++var6) {
         ModIcon var7 = class119.method2573(var4, this.field1524[var6]);
         var7.method1952();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1527[var6];
         if((var10 & -16777216) == 16777216) {
            ;
         }

         if((var10 & -16777216) == 33554432) {
            ;
         }

         int var11;
         int var12;
         int var13;
         int var14;
         if((var10 & -16777216) == 50331648) {
            var11 = var10 & 16711935;
            var12 = var10 >> 8 & 255;

            for(var13 = 0; var13 < var9.length; ++var13) {
               var14 = var9[var13];
               if((var14 & '\uffff') == var14 >> 8) {
                  var14 &= 255;
                  var9[var13] = var11 * var14 >> 8 & 16711935 | var12 * var14 & '\uff00';
               }
            }
         }

         for(var11 = 0; var11 < var9.length; ++var11) {
            var9[var11] = class94.method2172(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1525[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.originalWidth == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1520[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1520[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1520[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var11 == 1) {
            ;
         }

         if(var11 == 2) {
            ;
         }

         if(var11 == 3) {
            ;
         }
      }

      return true;
   }

   @ObfuscatedName("g")
   void method1979() {
      this.field1520 = null;
   }

   @ObfuscatedName("r")
   void method1980(int var1) {
      if(this.field1520 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var8;
         if(this.field1528 == 1 || this.field1528 == 3) {
            if(field1532 == null || field1532.length < this.field1520.length) {
               field1532 = new int[this.field1520.length];
            }

            if(this.field1520.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1520.length;
            var4 = var2 * var1 * this.field1529;
            var5 = var3 - 1;
            if(this.field1528 == 1) {
               var4 = -var4;
            }

            for(var8 = 0; var8 < var3; ++var8) {
               var7 = var8 + var4 & var5;
               field1532[var8] = this.field1520[var7];
            }

            var6 = this.field1520;
            this.field1520 = field1532;
            field1532 = var6;
         }

         if(this.field1528 == 2 || this.field1528 == 4) {
            if(field1532 == null || field1532.length < this.field1520.length) {
               field1532 = new int[this.field1520.length];
            }

            if(this.field1520.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1520.length;
            var4 = var1 * this.field1529;
            var5 = var2 - 1;
            if(this.field1528 == 2) {
               var4 = -var4;
            }

            for(var8 = 0; var8 < var3; var8 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var9 = var8 + var7;
                  int var10 = var8 + (var7 + var4 & var5);
                  field1532[var9] = this.field1520[var10];
               }
            }

            var6 = this.field1520;
            this.field1520 = field1532;
            field1532 = var6;
         }
      }

   }

   class86(Buffer var1) {
      this.field1522 = var1.method2635();
      this.field1523 = var1.method2633() == 1;
      int var2 = var1.method2633();
      if(var2 >= 1 && var2 <= 4) {
         this.field1524 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1524[var3] = var1.method2635();
         }

         if(var2 > 1) {
            this.field1525 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1525[var3] = var1.method2633();
            }
         }

         if(var2 > 1) {
            this.field1526 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1526[var3] = var1.method2633();
            }
         }

         this.field1527 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1527[var3] = var1.method2620();
         }

         this.field1528 = var1.method2633();
         this.field1529 = var1.method2633();
         this.field1520 = null;
      } else {
         throw new RuntimeException();
      }
   }
}

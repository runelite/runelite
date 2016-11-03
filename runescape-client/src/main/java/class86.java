import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
public class class86 extends Node {
   @ObfuscatedName("b")
   int field1496;
   @ObfuscatedName("e")
   boolean field1500 = false;
   @ObfuscatedName("v")
   int field1501;
   @ObfuscatedName("m")
   int[] field1502;
   @ObfuscatedName("y")
   int[] field1503;
   @ObfuscatedName("g")
   int[] field1504;
   @ObfuscatedName("h")
   int[] field1505;
   @ObfuscatedName("l")
   int field1506;
   @ObfuscatedName("u")
   int[] field1507;
   @ObfuscatedName("j")
   boolean field1508;
   @ObfuscatedName("p")
   static int[] field1510;

   @ObfuscatedName("k")
   boolean method1940(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1502.length; ++var5) {
         if(var4.method3287(this.field1502[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1504 = new int[var5];

      for(int var6 = 0; var6 < this.field1502.length; ++var6) {
         ModIcon var7 = class112.method2483(var4, this.field1502[var6]);
         var7.method1921();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1505[var6];
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
            var9[var11] = class94.method2206(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1503[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.originalWidth == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1504[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1504[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1504[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

   class86(Buffer var1) {
      this.field1501 = var1.method2691();
      this.field1508 = var1.method2571() == 1;
      int var2 = var1.method2571();
      if(var2 >= 1 && var2 <= 4) {
         this.field1502 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1502[var3] = var1.method2691();
         }

         if(var2 > 1) {
            this.field1503 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1503[var3] = var1.method2571();
            }
         }

         if(var2 > 1) {
            this.field1507 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1507[var3] = var1.method2571();
            }
         }

         this.field1505 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1505[var3] = var1.method2576();
         }

         this.field1506 = var1.method2571();
         this.field1496 = var1.method2571();
         this.field1504 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("f")
   void method1941(int var1) {
      if(this.field1504 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1506 == 1 || this.field1506 == 3) {
            if(field1510 == null || field1510.length < this.field1504.length) {
               field1510 = new int[this.field1504.length];
            }

            if(this.field1504.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1504.length;
            var4 = var2 * var1 * this.field1496;
            var5 = var3 - 1;
            if(this.field1506 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1510[var10] = this.field1504[var7];
            }

            var6 = this.field1504;
            this.field1504 = field1510;
            field1510 = var6;
         }

         if(this.field1506 == 2 || this.field1506 == 4) {
            if(field1510 == null || field1510.length < this.field1504.length) {
               field1510 = new int[this.field1504.length];
            }

            if(this.field1504.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1504.length;
            var4 = var1 * this.field1496;
            var5 = var2 - 1;
            if(this.field1506 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1510[var8] = this.field1504[var9];
               }
            }

            var6 = this.field1504;
            this.field1504 = field1510;
            field1510 = var6;
         }

      }
   }

   @ObfuscatedName("q")
   void method1942() {
      this.field1504 = null;
   }
}

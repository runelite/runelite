import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
public class class86 extends Node {
   @ObfuscatedName("i")
   int field1481;
   @ObfuscatedName("m")
   int[] field1482;
   @ObfuscatedName("b")
   boolean field1483;
   @ObfuscatedName("f")
   int[] field1484;
   @ObfuscatedName("p")
   int[] field1485;
   @ObfuscatedName("d")
   int field1486;
   @ObfuscatedName("v")
   int field1487;
   @ObfuscatedName("q")
   int[] field1488;
   @ObfuscatedName("l")
   int[] field1489;
   @ObfuscatedName("t")
   boolean field1490 = false;
   @ObfuscatedName("g")
   static int[] field1491;

   @ObfuscatedName("x")
   boolean method1928(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1489.length; ++var5) {
         if(var4.method3327(this.field1489[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1488 = new int[var5];

      for(int var6 = 0; var6 < this.field1489.length; ++var6) {
         int var8 = this.field1489[var6];
         byte[] var10 = var4.method3352(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class43.method858(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            ModIcon var11 = new ModIcon();
            var11.width = class79.field1422;
            var11.originalHeight = class79.field1419;
            var11.offsetX = class79.field1421[0];
            var11.offsetY = class79.field1423[0];
            var11.originalWidth = class20.field567[0];
            var11.height = class79.field1424[0];
            var11.palette = class79.field1425;
            var11.pixels = class13.field191[0];
            Friend.method193();
            var7 = var11;
         }

         var7.method1895();
         var10 = var7.pixels;
         int[] var18 = var7.palette;
         int var12 = this.field1484[var6];
         if((var12 & -16777216) == 16777216) {
            ;
         }

         if((var12 & -16777216) == 33554432) {
            ;
         }

         int var13;
         int var14;
         int var15;
         int var16;
         if((var12 & -16777216) == 50331648) {
            var13 = var12 & 16711935;
            var14 = var12 >> 8 & 255;

            for(var15 = 0; var15 < var18.length; ++var15) {
               var16 = var18[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var18[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var18.length; ++var13) {
            var18[var13] = class94.method2138(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1482[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1488[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1488[var14++] = var18[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1488[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var13 == 1) {
            ;
         }

         if(var13 == 2) {
            ;
         }

         if(var13 == 3) {
            ;
         }
      }

      return true;
   }

   @ObfuscatedName("r")
   void method1929() {
      this.field1488 = null;
   }

   class86(Buffer var1) {
      this.field1481 = var1.method2551();
      this.field1483 = var1.method2556() == 1;
      int var2 = var1.method2556();
      if(var2 >= 1 && var2 <= 4) {
         this.field1489 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1489[var3] = var1.method2551();
         }

         if(var2 > 1) {
            this.field1482 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1482[var3] = var1.method2556();
            }
         }

         if(var2 > 1) {
            this.field1485 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1485[var3] = var1.method2556();
            }
         }

         this.field1484 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1484[var3] = var1.method2561();
         }

         this.field1486 = var1.method2556();
         this.field1487 = var1.method2556();
         this.field1488 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   void method1935(int var1) {
      if(this.field1488 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1486 == 1 || this.field1486 == 3) {
            if(field1491 == null || field1491.length < this.field1488.length) {
               field1491 = new int[this.field1488.length];
            }

            if(this.field1488.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1488.length;
            var4 = var2 * var1 * this.field1487;
            var5 = var3 - 1;
            if(this.field1486 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1491[var10] = this.field1488[var7];
            }

            var6 = this.field1488;
            this.field1488 = field1491;
            field1491 = var6;
         }

         if(this.field1486 == 2 || this.field1486 == 4) {
            if(field1491 == null || field1491.length < this.field1488.length) {
               field1491 = new int[this.field1488.length];
            }

            if(this.field1488.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1488.length;
            var4 = var1 * this.field1487;
            var5 = var2 - 1;
            if(this.field1486 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1491[var8] = this.field1488[var9];
               }
            }

            var6 = this.field1488;
            this.field1488 = field1491;
            field1491 = var6;
         }

      }
   }
}

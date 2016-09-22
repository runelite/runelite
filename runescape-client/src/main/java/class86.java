import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
public class class86 extends Node {
   @ObfuscatedName("q")
   static int[] field1518;
   @ObfuscatedName("i")
   int[] field1520;
   @ObfuscatedName("z")
   int field1522;
   @ObfuscatedName("t")
   boolean field1523;
   @ObfuscatedName("x")
   int field1524;
   @ObfuscatedName("u")
   int[] field1525;
   @ObfuscatedName("g")
   int[] field1526;
   @ObfuscatedName("m")
   int[] field1527;
   @ObfuscatedName("k")
   int field1528;
   @ObfuscatedName("n")
   int[] field1530;
   @ObfuscatedName("j")
   boolean field1531 = false;

   @ObfuscatedName("d")
   void method1929() {
      this.field1525 = null;
   }

   @ObfuscatedName("v")
   void method1930(int var1) {
      if(this.field1525 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1528 == 1 || this.field1528 == 3) {
            if(field1518 == null || field1518.length < this.field1525.length) {
               field1518 = new int[this.field1525.length];
            }

            if(this.field1525.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1525.length;
            var4 = var2 * var1 * this.field1524;
            var5 = var3 - 1;
            if(this.field1528 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1518[var10] = this.field1525[var7];
            }

            var6 = this.field1525;
            this.field1525 = field1518;
            field1518 = var6;
         }

         if(this.field1528 == 2 || this.field1528 == 4) {
            if(field1518 == null || field1518.length < this.field1525.length) {
               field1518 = new int[this.field1525.length];
            }

            if(this.field1525.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1525.length;
            var4 = var1 * this.field1524;
            var5 = var2 - 1;
            if(this.field1528 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1518[var8] = this.field1525[var9];
               }
            }

            var6 = this.field1525;
            this.field1525 = field1518;
            field1518 = var6;
         }

      }
   }

   @ObfuscatedName("a")
   boolean method1934(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1530.length; ++var5) {
         if(var4.method3349(this.field1530[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1525 = new int[var5];

      for(int var6 = 0; var6 < this.field1530.length; ++var6) {
         int var8 = this.field1530[var6];
         byte[] var10 = var4.method3323(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            ChatMessages.method238(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            ModIcon var11 = new ModIcon();
            var11.width = class79.field1460;
            var11.originalHeight = class79.field1456;
            var11.offsetX = class79.field1462[0];
            var11.offsetY = class79.field1458[0];
            var11.originalWidth = class59.field1268[0];
            var11.height = class79.field1461[0];
            var11.palette = class132.field2126;
            var11.pixels = class8.field139[0];
            class35.method747();
            var7 = var11;
         }

         var7.method1901();
         var10 = var7.pixels;
         int[] var18 = var7.palette;
         int var12 = this.field1527[var6];
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
            var18[var13] = class94.method2125(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1520[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1525[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1525[var14++] = var18[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1525[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   class86(Buffer var1) {
      this.field1522 = var1.method2717();
      this.field1523 = var1.method2528() == 1;
      int var2 = var1.method2528();
      if(var2 >= 1 && var2 <= 4) {
         this.field1530 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1530[var3] = var1.method2717();
         }

         if(var2 > 1) {
            this.field1520 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1520[var3] = var1.method2528();
            }
         }

         if(var2 > 1) {
            this.field1526 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1526[var3] = var1.method2528();
            }
         }

         this.field1527 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1527[var3] = var1.method2533();
         }

         this.field1528 = var1.method2528();
         this.field1524 = var1.method2528();
         this.field1525 = null;
      } else {
         throw new RuntimeException();
      }
   }
}

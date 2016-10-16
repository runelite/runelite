import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
public class class86 extends Node {
   @ObfuscatedName("k")
   int[] field1480;
   @ObfuscatedName("u")
   int[] field1481;
   @ObfuscatedName("p")
   int field1485;
   @ObfuscatedName("f")
   int[] field1487;
   @ObfuscatedName("m")
   int[] field1488;
   @ObfuscatedName("h")
   int[] field1489;
   @ObfuscatedName("g")
   boolean field1490;
   @ObfuscatedName("w")
   int field1491;
   @ObfuscatedName("r")
   int field1492;
   @ObfuscatedName("n")
   boolean field1493 = false;
   @ObfuscatedName("d")
   static int[] field1494;

   class86(Buffer var1) {
      this.field1485 = var1.method2668();
      this.field1490 = var1.method2481() == 1;
      int var2 = var1.method2481();
      if(var2 >= 1 && var2 <= 4) {
         this.field1488 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1488[var3] = var1.method2668();
         }

         if(var2 > 1) {
            this.field1487 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1487[var3] = var1.method2481();
            }
         }

         if(var2 > 1) {
            this.field1480 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1480[var3] = var1.method2481();
            }
         }

         this.field1489 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1489[var3] = var1.method2526();
         }

         this.field1492 = var1.method2481();
         this.field1491 = var1.method2481();
         this.field1481 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   boolean method1897(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1488.length; ++var5) {
         if(var4.method3257(this.field1488[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1481 = new int[var5];

      for(int var6 = 0; var6 < this.field1488.length; ++var6) {
         int var8 = this.field1488[var6];
         byte[] var10 = var4.method3302(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class0.method0(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            var7 = Frames.method2268();
         }

         var7.method1868();
         var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1489[var6];
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

            for(var15 = 0; var15 < var11.length; ++var15) {
               var16 = var11[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var11[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var11.length; ++var13) {
            var11[var13] = class94.method2099(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1487[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1481[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1481[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1481[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("t")
   void method1899(int var1) {
      if(this.field1481 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1492 == 1 || this.field1492 == 3) {
            if(field1494 == null || field1494.length < this.field1481.length) {
               field1494 = new int[this.field1481.length];
            }

            if(this.field1481.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1481.length;
            var4 = var2 * var1 * this.field1491;
            var5 = var3 - 1;
            if(this.field1492 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1494[var10] = this.field1481[var7];
            }

            var6 = this.field1481;
            this.field1481 = field1494;
            field1494 = var6;
         }

         if(this.field1492 == 2 || this.field1492 == 4) {
            if(field1494 == null || field1494.length < this.field1481.length) {
               field1494 = new int[this.field1481.length];
            }

            if(this.field1481.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1481.length;
            var4 = var1 * this.field1491;
            var5 = var2 - 1;
            if(this.field1492 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1494[var8] = this.field1481[var9];
               }
            }

            var6 = this.field1481;
            this.field1481 = field1494;
            field1494 = var6;
         }

      }
   }

   @ObfuscatedName("z")
   void method1901() {
      this.field1481 = null;
   }
}

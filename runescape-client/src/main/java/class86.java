import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
public class class86 extends Node {
   @ObfuscatedName("u")
   boolean field1490;
   @ObfuscatedName("v")
   boolean field1492 = false;
   @ObfuscatedName("y")
   int field1493;
   @ObfuscatedName("n")
   int field1494;
   @ObfuscatedName("m")
   int[] field1496;
   @ObfuscatedName("j")
   int[] field1497;
   @ObfuscatedName("d")
   int[] field1498;
   @ObfuscatedName("s")
   int field1499;
   @ObfuscatedName("p")
   int[] field1500;
   @ObfuscatedName("l")
   int[] field1501;
   @ObfuscatedName("r")
   static int[] field1502;

   @ObfuscatedName("e")
   void method1927(int var1) {
      if(this.field1500 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1493 == 1 || this.field1493 == 3) {
            if(field1502 == null || field1502.length < this.field1500.length) {
               field1502 = new int[this.field1500.length];
            }

            if(this.field1500.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1500.length;
            var4 = var2 * var1 * this.field1499;
            var5 = var3 - 1;
            if(this.field1493 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1502[var6] = this.field1500[var7];
            }

            var10 = this.field1500;
            this.field1500 = field1502;
            field1502 = var10;
         }

         if(this.field1493 == 2 || this.field1493 == 4) {
            if(field1502 == null || field1502.length < this.field1500.length) {
               field1502 = new int[this.field1500.length];
            }

            if(this.field1500.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1500.length;
            var4 = var1 * this.field1499;
            var5 = var2 - 1;
            if(this.field1493 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1502[var8] = this.field1500[var9];
               }
            }

            var10 = this.field1500;
            this.field1500 = field1502;
            field1502 = var10;
         }

      }
   }

   @ObfuscatedName("h")
   void method1929() {
      this.field1500 = null;
   }

   class86(Buffer var1) {
      this.field1494 = var1.method2546();
      this.field1490 = var1.method2544() == 1;
      int var2 = var1.method2544();
      if(var2 >= 1 && var2 <= 4) {
         this.field1498 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1498[var3] = var1.method2546();
         }

         if(var2 > 1) {
            this.field1501 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1501[var3] = var1.method2544();
            }
         }

         if(var2 > 1) {
            this.field1496 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1496[var3] = var1.method2544();
            }
         }

         this.field1497 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1497[var3] = var1.method2549();
         }

         this.field1493 = var1.method2544();
         this.field1499 = var1.method2544();
         this.field1500 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   boolean method1936(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1498.length; ++var5) {
         if(var4.method3319(this.field1498[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1500 = new int[var5];

      for(int var6 = 0; var6 < this.field1498.length; ++var6) {
         ModIcon var7 = class51.method1069(var4, this.field1498[var6]);
         var7.method1896();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1497[var6];
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
            var9[var11] = class94.method2150(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1501[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.originalWidth == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1500[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1500[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1500[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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
}

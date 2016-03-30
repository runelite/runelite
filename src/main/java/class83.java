import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
public class class83 extends class208 {
   @ObfuscatedName("q")
   boolean field1444 = false;
   @ObfuscatedName("c")
   int[] field1445;
   @ObfuscatedName("e")
   int field1446;
   @ObfuscatedName("y")
   boolean field1447;
   @ObfuscatedName("v")
   int[] field1449;
   @ObfuscatedName("l")
   int[] field1450;
   @ObfuscatedName("z")
   int field1451;
   @ObfuscatedName("s")
   int field1452;
   @ObfuscatedName("j")
   int[] field1453;
   @ObfuscatedName("m")
   int[] field1454;
   @ObfuscatedName("a")
   static int[] field1455;

   @ObfuscatedName("w")
   boolean method1887(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1454.length; ++var5) {
         if(var4.method3295(this.field1454[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1453 = new int[var5];

      for(int var6 = 0; var6 < this.field1454.length; ++var6) {
         class80 var7 = class16.method181(var4, this.field1454[var6]);
         var7.method1852();
         byte[] var8 = var7.field1427;
         int[] var9 = var7.field1421;
         int var10 = this.field1450[var6];
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
            var9[var11] = class91.method2089(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1445[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.field1425 == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1453[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.field1425 == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1453[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1425 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1453[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

   @ObfuscatedName("x")
   void method1889() {
      this.field1453 = null;
   }

   class83(class119 var1) {
      this.field1446 = var1.method2508();
      this.field1447 = var1.method2506() == 1;
      int var2 = var1.method2506();
      if(var2 >= 1 && var2 <= 4) {
         this.field1454 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1454[var3] = var1.method2508();
         }

         if(var2 > 1) {
            this.field1445 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1445[var3] = var1.method2506();
            }
         }

         if(var2 > 1) {
            this.field1449 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1449[var3] = var1.method2506();
            }
         }

         this.field1450 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1450[var3] = var1.method2511();
         }

         this.field1451 = var1.method2506();
         this.field1452 = var1.method2506();
         this.field1453 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   void method1894(int var1) {
      if(this.field1453 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1451 == 1 || this.field1451 == 3) {
            if(field1455 == null || field1455.length < this.field1453.length) {
               field1455 = new int[this.field1453.length];
            }

            if(this.field1453.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1453.length;
            var4 = var2 * var1 * this.field1452;
            var5 = var3 - 1;
            if(this.field1451 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1455[var6] = this.field1453[var7];
            }

            var10 = this.field1453;
            this.field1453 = field1455;
            field1455 = var10;
         }

         if(this.field1451 == 2 || this.field1451 == 4) {
            if(field1455 == null || field1455.length < this.field1453.length) {
               field1455 = new int[this.field1453.length];
            }

            if(this.field1453.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1453.length;
            var4 = var1 * this.field1452;
            var5 = var2 - 1;
            if(this.field1451 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1455[var8] = this.field1453[var9];
               }
            }

            var10 = this.field1453;
            this.field1453 = field1455;
            field1455 = var10;
         }

      }
   }
}

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
public class class83 extends class208 {
   @ObfuscatedName("k")
   int field1445;
   @ObfuscatedName("l")
   int field1449;
   @ObfuscatedName("d")
   boolean field1451;
   @ObfuscatedName("m")
   int[] field1452;
   @ObfuscatedName("g")
   int[] field1453;
   @ObfuscatedName("s")
   int[] field1454;
   @ObfuscatedName("r")
   int field1455;
   @ObfuscatedName("n")
   int[] field1456;
   @ObfuscatedName("o")
   int[] field1457;
   @ObfuscatedName("q")
   boolean field1458 = false;
   @ObfuscatedName("p")
   static int[] field1459;

   @ObfuscatedName("u")
   void method1949() {
      this.field1457 = null;
   }

   @ObfuscatedName("f")
   boolean method1950(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1456.length; ++var5) {
         if(var4.method3346(this.field1456[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1457 = new int[var5];

      for(int var6 = 0; var6 < this.field1456.length; ++var6) {
         int var8 = this.field1456[var6];
         byte[] var10 = var4.method3291(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class130.method2852(var10);
            var9 = true;
         }

         class80 var7;
         if(!var9) {
            var7 = null;
         } else {
            class80 var11 = new class80();
            var11.field1426 = class76.field1396;
            var11.field1432 = class76.field1398;
            var11.field1433 = class76.field1397[0];
            var11.field1431 = class52.field1178[0];
            var11.field1428 = class28.field690[0];
            var11.field1429 = class31.field744[0];
            var11.field1427 = class7.field135;
            var11.field1430 = class76.field1400[0];
            class33.method749();
            var7 = var11;
         }

         var7.method1924();
         var10 = var7.field1430;
         int[] var18 = var7.field1427;
         int var12 = this.field1454[var6];
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
            var18[var13] = class91.method2160(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1452[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1428 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1457[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.field1428 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1457[var14++] = var18[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1428 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1457[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("x")
   void method1951(int var1) {
      if(this.field1457 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1455 == 1 || this.field1455 == 3) {
            if(field1459 == null || field1459.length < this.field1457.length) {
               field1459 = new int[this.field1457.length];
            }

            if(this.field1457.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1457.length;
            var4 = var2 * var1 * this.field1445;
            var5 = var3 - 1;
            if(this.field1455 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1459[var6] = this.field1457[var7];
            }

            var10 = this.field1457;
            this.field1457 = field1459;
            field1459 = var10;
         }

         if(this.field1455 == 2 || this.field1455 == 4) {
            if(field1459 == null || field1459.length < this.field1457.length) {
               field1459 = new int[this.field1457.length];
            }

            if(this.field1457.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1457.length;
            var4 = var1 * this.field1445;
            var5 = var2 - 1;
            if(this.field1455 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1459[var8] = this.field1457[var9];
               }
            }

            var10 = this.field1457;
            this.field1457 = field1459;
            field1459 = var10;
         }

      }
   }

   class83(class119 var1) {
      this.field1449 = var1.method2556();
      this.field1451 = var1.method2554() == 1;
      int var2 = var1.method2554();
      if(var2 >= 1 && var2 <= 4) {
         this.field1456 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1456[var3] = var1.method2556();
         }

         if(var2 > 1) {
            this.field1452 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1452[var3] = var1.method2554();
            }
         }

         if(var2 > 1) {
            this.field1453 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1453[var3] = var1.method2554();
            }
         }

         this.field1454 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1454[var3] = var1.method2696();
         }

         this.field1455 = var1.method2554();
         this.field1445 = var1.method2554();
         this.field1457 = null;
      } else {
         throw new RuntimeException();
      }
   }
}

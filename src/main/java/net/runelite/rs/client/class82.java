package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
public class class82 extends class207 {
   @ObfuscatedName("h")
   int[] field1439;
   @ObfuscatedName("q")
   int[] field1442;
   @ObfuscatedName("m")
   boolean field1443;
   @ObfuscatedName("o")
   int[] field1444;
   @ObfuscatedName("f")
   int field1445;
   @ObfuscatedName("n")
   int[] field1446;
   @ObfuscatedName("k")
   int[] field1447;
   @ObfuscatedName("b")
   int field1449;
   @ObfuscatedName("u")
   boolean field1450 = false;
   @ObfuscatedName("r")
   int field1451;
   @ObfuscatedName("g")
   static int[] field1452;

   class82(class118 var1) {
      this.field1445 = var1.method2455();
      this.field1443 = var1.method2453() == 1;
      int var2 = var1.method2453();
      if(var2 >= 1 && var2 <= 4) {
         this.field1444 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1444[var3] = var1.method2455();
         }

         if(var2 > 1) {
            this.field1439 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1439[var3] = var1.method2453();
            }
         }

         if(var2 > 1) {
            this.field1446 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1446[var3] = var1.method2453();
            }
         }

         this.field1447 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1447[var3] = var1.method2458();
         }

         this.field1451 = var1.method2453();
         this.field1449 = var1.method2453();
         this.field1442 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   void method1852() {
      this.field1442 = null;
   }

   @ObfuscatedName("a")
   void method1853(int var1) {
      if(this.field1442 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1451 == 1 || this.field1451 == 3) {
            if(field1452 == null || field1452.length < this.field1442.length) {
               field1452 = new int[this.field1442.length];
            }

            if(this.field1442.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1442.length;
            var4 = var2 * var1 * this.field1449;
            var5 = var3 - 1;
            if(this.field1451 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1452[var6] = this.field1442[var7];
            }

            var10 = this.field1442;
            this.field1442 = field1452;
            field1452 = var10;
         }

         if(this.field1451 == 2 || this.field1451 == 4) {
            if(field1452 == null || field1452.length < this.field1442.length) {
               field1452 = new int[this.field1442.length];
            }

            if(this.field1442.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1442.length;
            var4 = var1 * this.field1449;
            var5 = var2 - 1;
            if(this.field1451 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1452[var8] = this.field1442[var9];
               }
            }

            var10 = this.field1442;
            this.field1442 = field1452;
            field1452 = var10;
         }

      }
   }

   @ObfuscatedName("j")
   boolean method1858(double var1, int var3, class166 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1444.length; ++var5) {
         if(var4.method3221(this.field1444[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1442 = new int[var5];

      for(int var6 = 0; var6 < this.field1444.length; ++var6) {
         class80 var7 = class171.method3349(var4, this.field1444[var6]);
         var7.method1831();
         byte[] var8 = var7.field1429;
         int[] var9 = var7.field1432;
         int var10 = this.field1447[var6];
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
            var9[var11] = class90.method2066(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1439[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.field1431 == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1442[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.field1431 == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1442[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1431 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1442[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

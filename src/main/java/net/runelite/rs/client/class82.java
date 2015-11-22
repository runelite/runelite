package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ca")
public class class82 extends class207 {
   @ObfuscatedName("t")
   int[] field1418;
   @ObfuscatedName("u")
   int field1420;
   @ObfuscatedName("a")
   boolean field1421;
   @ObfuscatedName("i")
   int[] field1422;
   @ObfuscatedName("p")
   static int[] field1423;
   @ObfuscatedName("e")
   int[] field1424;
   @ObfuscatedName("k")
   int[] field1425;
   @ObfuscatedName("s")
   int field1426;
   @ObfuscatedName("w")
   int field1427;
   @ObfuscatedName("z")
   boolean field1429 = false;
   @ObfuscatedName("h")
   int[] field1430;

   @ObfuscatedName("j")
   boolean method1907(double var1, int var3, class166 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1430.length; ++var5) {
         if(var4.method3319(this.field1430[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1424 = new int[var5];

      for(int var6 = 0; var6 < this.field1430.length; ++var6) {
         class80 var7 = class39.method843(var4, this.field1430[var6]);
         var7.method1879();
         byte[] var8 = var7.field1408;
         int[] var9 = var7.field1412;
         int var10 = this.field1425[var6];
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
            var9[var11] = class90.method2110(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1422[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.field1407 == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1424[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.field1407 == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1424[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1407 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1424[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

   @ObfuscatedName("f")
   void method1909(int var1) {
      if(this.field1424 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1426 == 1 || this.field1426 == 3) {
            if(field1423 == null || field1423.length < this.field1424.length) {
               field1423 = new int[this.field1424.length];
            }

            if(this.field1424.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1424.length;
            var4 = var2 * var1 * this.field1427;
            var5 = var3 - 1;
            if(this.field1426 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1423[var6] = this.field1424[var7];
            }

            var10 = this.field1424;
            this.field1424 = field1423;
            field1423 = var10;
         }

         if(this.field1426 == 2 || this.field1426 == 4) {
            if(field1423 == null || field1423.length < this.field1424.length) {
               field1423 = new int[this.field1424.length];
            }

            if(this.field1424.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1424.length;
            var4 = var1 * this.field1427;
            var5 = var2 - 1;
            if(this.field1426 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1423[var8] = this.field1424[var9];
               }
            }

            var10 = this.field1424;
            this.field1424 = field1423;
            field1423 = var10;
         }

      }
   }

   class82(class118 var1) {
      this.field1420 = var1.method2538();
      this.field1421 = var1.method2536() == 1;
      int var2 = var1.method2536();
      if(var2 >= 1 && var2 <= 4) {
         this.field1430 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1430[var3] = var1.method2538();
         }

         if(var2 > 1) {
            this.field1422 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1422[var3] = var1.method2536();
            }
         }

         if(var2 > 1) {
            this.field1418 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1418[var3] = var1.method2536();
            }
         }

         this.field1425 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1425[var3] = var1.method2541();
         }

         this.field1426 = var1.method2536();
         this.field1427 = var1.method2536();
         this.field1424 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   void method1911() {
      this.field1424 = null;
   }
}

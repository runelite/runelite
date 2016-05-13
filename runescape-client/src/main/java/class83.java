import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
public class class83 extends class208 {
   @ObfuscatedName("o")
   int[] field1443;
   @ObfuscatedName("r")
   boolean field1445 = false;
   @ObfuscatedName("l")
   int field1446;
   @ObfuscatedName("d")
   int field1447;
   @ObfuscatedName("u")
   boolean field1448;
   @ObfuscatedName("b")
   int[] field1449;
   @ObfuscatedName("k")
   int[] field1451;
   @ObfuscatedName("c")
   int[] field1453;
   @ObfuscatedName("t")
   int field1454;
   @ObfuscatedName("i")
   int[] field1455;
   @ObfuscatedName("m")
   static int[] field1457;

   class83(class119 var1) {
      this.field1447 = var1.method2584();
      this.field1448 = var1.method2492() == 1;
      int var2 = var1.method2492();
      if(var2 >= 1 && var2 <= 4) {
         this.field1443 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1443[var3] = var1.method2584();
         }

         if(var2 > 1) {
            this.field1449 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1449[var3] = var1.method2492();
            }
         }

         if(var2 > 1) {
            this.field1451 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1451[var3] = var1.method2492();
            }
         }

         this.field1453 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1453[var3] = var1.method2497();
         }

         this.field1446 = var1.method2492();
         this.field1454 = var1.method2492();
         this.field1455 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   void method1871() {
      this.field1455 = null;
   }

   @ObfuscatedName("p")
   void method1872(int var1) {
      if(this.field1455 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var8;
         if(this.field1446 == 1 || this.field1446 == 3) {
            if(field1457 == null || field1457.length < this.field1455.length) {
               field1457 = new int[this.field1455.length];
            }

            if(this.field1455.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1455.length;
            var4 = var2 * var1 * this.field1454;
            var5 = var3 - 1;
            if(this.field1446 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1457[var6] = this.field1455[var7];
            }

            var8 = this.field1455;
            this.field1455 = field1457;
            field1457 = var8;
         }

         if(this.field1446 == 2 || this.field1446 == 4) {
            if(field1457 == null || field1457.length < this.field1455.length) {
               field1457 = new int[this.field1455.length];
            }

            if(this.field1455.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1455.length;
            var4 = var1 * this.field1454;
            var5 = var2 - 1;
            if(this.field1446 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var9 = var6 + var7;
                  int var10 = var6 + (var7 + var4 & var5);
                  field1457[var9] = this.field1455[var10];
               }
            }

            var8 = this.field1455;
            this.field1455 = field1457;
            field1457 = var8;
         }
      }

   }

   @ObfuscatedName("s")
   boolean method1883(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1443.length; ++var5) {
         if(var4.method3290(this.field1443[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1455 = new int[var5];

      for(int var6 = 0; var6 < this.field1443.length; ++var6) {
         int var7 = this.field1443[var6];
         byte[] var8 = var4.method3244(var7);
         boolean var9;
         if(null == var8) {
            var9 = false;
         } else {
            class174.method3426(var8);
            var9 = true;
         }

         class80 var10;
         if(!var9) {
            var10 = null;
         } else {
            class80 var11 = new class80();
            var11.field1425 = class226.field3214;
            var11.field1432 = class76.field1386;
            var11.field1428 = class76.field1387[0];
            var11.field1431 = class76.field1390[0];
            var11.field1427 = class76.field1389[0];
            var11.field1429 = class9.field159[0];
            var11.field1426 = class76.field1396;
            var11.field1430 = class21.field575[0];
            class27.method633();
            var10 = var11;
         }

         var10.method1844();
         var8 = var10.field1430;
         int[] var17 = var10.field1426;
         int var12 = this.field1453[var6];
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

            for(var15 = 0; var15 < var17.length; ++var15) {
               var16 = var17[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var17[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var17.length; ++var13) {
            var17[var13] = class91.method2069(var17[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1449[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var10.field1427 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1455[var14] = var17[var8[var14] & 255];
               }
            } else if(var10.field1427 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1455[var14++] = var17[var8[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var10.field1427 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1455[var14++] = var17[var8[(var16 << 1) + (var15 << 1 << 7)] & 255];
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
}

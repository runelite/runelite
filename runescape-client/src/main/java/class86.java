import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ct")
public class class86 extends class211 {
   @ObfuscatedName("w")
   static int[] field1506;
   @ObfuscatedName("r")
   int field1509;
   @ObfuscatedName("a")
   boolean field1510;
   @ObfuscatedName("u")
   int[] field1512;
   @ObfuscatedName("o")
   int[] field1513;
   @ObfuscatedName("p")
   int[] field1514;
   @ObfuscatedName("i")
   int field1515;
   @ObfuscatedName("b")
   int[] field1516;
   @ObfuscatedName("g")
   int[] field1517;
   @ObfuscatedName("j")
   boolean field1518 = false;
   @ObfuscatedName("q")
   int field1519;

   class86(class122 var1) {
      this.field1509 = var1.method2612();
      this.field1510 = var1.method2610() == 1;
      int var2 = var1.method2610();
      if(var2 >= 1 && var2 <= 4) {
         this.field1516 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1516[var3] = var1.method2612();
         }

         if(var2 > 1) {
            this.field1512 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1512[var3] = var1.method2610();
            }
         }

         if(var2 > 1) {
            this.field1513 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1513[var3] = var1.method2610();
            }
         }

         this.field1514 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1514[var3] = var1.method2614();
         }

         this.field1515 = var1.method2610();
         this.field1519 = var1.method2610();
         this.field1517 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   void method1987() {
      this.field1517 = null;
   }

   @ObfuscatedName("c")
   void method1988(int var1) {
      if(this.field1517 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1515 == 1 || this.field1515 == 3) {
            if(field1506 == null || field1506.length < this.field1517.length) {
               field1506 = new int[this.field1517.length];
            }

            if(this.field1517.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1517.length;
            var4 = var2 * var1 * this.field1519;
            var5 = var3 - 1;
            if(this.field1515 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1506[var6] = this.field1517[var7];
            }

            var10 = this.field1517;
            this.field1517 = field1506;
            field1506 = var10;
         }

         if(this.field1515 == 2 || this.field1515 == 4) {
            if(field1506 == null || field1506.length < this.field1517.length) {
               field1506 = new int[this.field1517.length];
            }

            if(this.field1517.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1517.length;
            var4 = var1 * this.field1519;
            var5 = var2 - 1;
            if(this.field1515 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1506[var8] = this.field1517[var9];
               }
            }

            var10 = this.field1517;
            this.field1517 = field1506;
            field1506 = var10;
         }

      }
   }

   @ObfuscatedName("e")
   boolean method1992(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1516.length; ++var5) {
         if(var4.method3349(this.field1516[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1517 = new int[var5];

      for(int var6 = 0; var6 < this.field1516.length; ++var6) {
         int var8 = this.field1516[var6];
         class83 var7;
         if(!class22.method563(var4, var8)) {
            var7 = null;
         } else {
            class83 var10 = new class83();
            var10.field1485 = class79.field1458;
            var10.field1484 = class79.field1452;
            var10.field1488 = class79.field1449[0];
            var10.field1491 = class11.field192[0];
            var10.field1486 = class138.field2134[0];
            var10.field1489 = class169.field2703[0];
            var10.field1487 = class178.field2941;
            var10.field1490 = class93.field1626[0];
            class52.method1134();
            var7 = var10;
         }

         var7.method1951();
         byte[] var17 = var7.field1490;
         int[] var11 = var7.field1487;
         int var12 = this.field1514[var6];
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
            var11[var13] = class94.method2191(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1512[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1486 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1517[var14] = var11[var17[var14] & 255];
               }
            } else if(var7.field1486 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1517[var14++] = var11[var17[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1486 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1517[var14++] = var11[var17[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

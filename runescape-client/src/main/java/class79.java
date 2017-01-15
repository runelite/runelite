import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class79 extends Node {
   @ObfuscatedName("f")
   int field1301;
   @ObfuscatedName("d")
   int[] field1304;
   @ObfuscatedName("c")
   boolean field1306;
   @ObfuscatedName("l")
   int[] field1307;
   @ObfuscatedName("g")
   int[] field1309;
   @ObfuscatedName("z")
   int[] field1310;
   @ObfuscatedName("t")
   int field1311;
   @ObfuscatedName("m")
   int field1312;
   @ObfuscatedName("q")
   int[] field1313;
   @ObfuscatedName("e")
   boolean field1314 = false;
   @ObfuscatedName("v")
   static int[] field1315;

   @ObfuscatedName("x")
   void method1502() {
      this.field1313 = null;
   }

   @ObfuscatedName("i")
   void method1503(int var1) {
      if(this.field1313 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var8;
         if(this.field1311 == 1 || this.field1311 == 3) {
            if(field1315 == null || field1315.length < this.field1313.length) {
               field1315 = new int[this.field1313.length];
            }

            if(this.field1313.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1313.length;
            var4 = var2 * var1 * this.field1312;
            var5 = var3 - 1;
            if(this.field1311 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1315[var6] = this.field1313[var7];
            }

            var8 = this.field1313;
            this.field1313 = field1315;
            field1315 = var8;
         }

         if(this.field1311 == 2 || this.field1311 == 4) {
            if(field1315 == null || field1315.length < this.field1313.length) {
               field1315 = new int[this.field1313.length];
            }

            if(this.field1313.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1313.length;
            var4 = var1 * this.field1312;
            var5 = var2 - 1;
            if(this.field1311 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var9 = var6 + var7;
                  int var10 = var6 + (var7 + var4 & var5);
                  field1315[var9] = this.field1313[var10];
               }
            }

            var8 = this.field1313;
            this.field1313 = field1315;
            field1315 = var8;
         }
      }

   }

   @ObfuscatedName("u")
   boolean method1504(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1304.length; ++var5) {
         if(var4.method3311(this.field1304[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1313 = new int[var5];

      for(int var6 = 0; var6 < this.field1304.length; ++var6) {
         int var7 = this.field1304[var6];
         ModIcon var8;
         if(!class149.method2743(var4, var7)) {
            var8 = null;
         } else {
            var8 = class177.method3250();
         }

         var8.method4063();
         byte[] var9 = var8.pixels;
         int[] var10 = var8.palette;
         int var11 = this.field1310[var6];
         if((var11 & -16777216) == 16777216) {
            ;
         }

         if((var11 & -16777216) == 33554432) {
            ;
         }

         int var12;
         int var13;
         int var14;
         int var15;
         if((var11 & -16777216) == 50331648) {
            var12 = var11 & 16711935;
            var13 = var11 >> 8 & 255;

            for(var14 = 0; var14 < var10.length; ++var14) {
               var15 = var10[var14];
               if((var15 & '\uffff') == var15 >> 8) {
                  var15 &= 255;
                  var10[var14] = var12 * var15 >> 8 & 16711935 | var13 * var15 & '\uff00';
               }
            }
         }

         for(var12 = 0; var12 < var10.length; ++var12) {
            var10[var12] = class84.method1608(var10[var12], var1);
         }

         if(var6 == 0) {
            var12 = 0;
         } else {
            var12 = this.field1307[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var12 == 0) {
            if(var8.originalWidth == var3) {
               for(var13 = 0; var13 < var5; ++var13) {
                  this.field1313[var13] = var10[var9[var13] & 255];
               }
            } else if(var8.originalWidth == 64 && var3 == 128) {
               var13 = 0;

               for(var14 = 0; var14 < var3; ++var14) {
                  for(var15 = 0; var15 < var3; ++var15) {
                     this.field1313[var13++] = var10[var9[(var15 >> 1) + (var14 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var8.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var13 = 0;

               for(var14 = 0; var14 < var3; ++var14) {
                  for(var15 = 0; var15 < var3; ++var15) {
                     this.field1313[var13++] = var10[var9[(var15 << 1) + (var14 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var12 == 1) {
            ;
         }

         if(var12 == 2) {
            ;
         }

         if(var12 == 3) {
            ;
         }
      }

      return true;
   }

   class79(Buffer var1) {
      this.field1301 = var1.readUnsignedShort();
      this.field1306 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1304 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1304[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1307 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1307[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1309 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1309[var3] = var1.readUnsignedByte();
            }
         }

         this.field1310 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1310[var3] = var1.method2780();
         }

         this.field1311 = var1.readUnsignedByte();
         this.field1312 = var1.readUnsignedByte();
         this.field1313 = null;
      } else {
         throw new RuntimeException();
      }
   }
}

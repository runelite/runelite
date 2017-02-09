import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
public class class79 extends Node {
   @ObfuscatedName("d")
   int[] field1301;
   @ObfuscatedName("w")
   int field1304;
   @ObfuscatedName("c")
   int[] field1305;
   @ObfuscatedName("j")
   boolean field1306;
   @ObfuscatedName("q")
   int[] field1307;
   @ObfuscatedName("v")
   boolean field1308 = false;
   @ObfuscatedName("n")
   int[] field1309;
   @ObfuscatedName("s")
   int field1311;
   @ObfuscatedName("g")
   int field1312;
   @ObfuscatedName("i")
   int[] field1313;
   @ObfuscatedName("a")
   static int[] field1315;

   @ObfuscatedName("y")
   void method1550() {
      this.field1313 = null;
   }

   @ObfuscatedName("o")
   void method1551(int var1) {
      if(this.field1313 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
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

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1315[var10] = this.field1313[var7];
            }

            var6 = this.field1313;
            this.field1313 = field1315;
            field1315 = var6;
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

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1315[var8] = this.field1313[var9];
               }
            }

            var6 = this.field1313;
            this.field1313 = field1315;
            field1315 = var6;
         }

      }
   }

   class79(Buffer var1) {
      this.field1304 = var1.readUnsignedShort();
      this.field1306 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1307 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1307[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1301 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1301[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1309 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1309[var3] = var1.readUnsignedByte();
            }
         }

         this.field1305 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1305[var3] = var1.method3062();
         }

         this.field1311 = var1.readUnsignedByte();
         this.field1312 = var1.readUnsignedByte();
         this.field1313 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   boolean method1556(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1307.length; ++var5) {
         if(var4.method3280(this.field1307[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1313 = new int[var5];

      for(int var6 = 0; var6 < this.field1307.length; ++var6) {
         ModIcon var7 = class217.method3958(var4, this.field1307[var6]);
         var7.method4066();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1305[var6];
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
            var9[var11] = class84.method1650(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1301[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.originalWidth == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1313[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1313[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1313[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

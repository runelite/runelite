import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
public class class79 extends Node {
   @ObfuscatedName("b")
   boolean field1321 = false;
   @ObfuscatedName("j")
   int field1323;
   @ObfuscatedName("n")
   boolean field1326;
   @ObfuscatedName("r")
   int[] field1327;
   @ObfuscatedName("c")
   int[] field1328;
   @ObfuscatedName("i")
   int[] field1329;
   @ObfuscatedName("o")
   int[] field1330;
   @ObfuscatedName("m")
   int field1331;
   @ObfuscatedName("s")
   int field1332;
   @ObfuscatedName("u")
   int[] field1333;
   @ObfuscatedName("v")
   static int[] field1335;

   class79(Buffer var1) {
      this.field1323 = var1.readUnsignedShort();
      this.field1326 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1327 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1327[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1328 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1328[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1329 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1329[var3] = var1.readUnsignedByte();
            }
         }

         this.field1330 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1330[var3] = var1.readInt();
         }

         this.field1331 = var1.readUnsignedByte();
         this.field1332 = var1.readUnsignedByte();
         this.field1333 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   void method1598() {
      this.field1333 = null;
   }

   @ObfuscatedName("q")
   boolean method1600(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1327.length; ++var5) {
         if(var4.method3310(this.field1327[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1333 = new int[var5];

      for(int var6 = 0; var6 < this.field1327.length; ++var6) {
         ModIcon var7 = class145.method2754(var4, this.field1327[var6]);
         var7.method4117();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1330[var6];
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
            var9[var11] = class84.method1693(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1328[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.originalWidth == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1333[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1333[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1333[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

   @ObfuscatedName("h")
   void method1604(int var1) {
      if(this.field1333 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1331 == 1 || this.field1331 == 3) {
            if(field1335 == null || field1335.length < this.field1333.length) {
               field1335 = new int[this.field1333.length];
            }

            if(this.field1333.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1333.length;
            var4 = var2 * var1 * this.field1332;
            var5 = var3 - 1;
            if(this.field1331 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1335[var10] = this.field1333[var7];
            }

            var6 = this.field1333;
            this.field1333 = field1335;
            field1335 = var6;
         }

         if(this.field1331 == 2 || this.field1331 == 4) {
            if(field1335 == null || field1335.length < this.field1333.length) {
               field1335 = new int[this.field1333.length];
            }

            if(this.field1333.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1333.length;
            var4 = var1 * this.field1332;
            var5 = var2 - 1;
            if(this.field1331 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1335[var8] = this.field1333[var9];
               }
            }

            var6 = this.field1333;
            this.field1333 = field1335;
            field1335 = var6;
         }

      }
   }
}

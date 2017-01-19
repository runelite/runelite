import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cg")
public class class79 extends Node {
   @ObfuscatedName("b")
   int[] field1305;
   @ObfuscatedName("k")
   int[] field1306;
   @ObfuscatedName("a")
   int field1308;
   @ObfuscatedName("g")
   boolean field1309;
   @ObfuscatedName("u")
   int[] field1311;
   @ObfuscatedName("w")
   static int[] field1312;
   @ObfuscatedName("x")
   int[] field1313;
   @ObfuscatedName("r")
   int field1314;
   @ObfuscatedName("n")
   int field1315;
   @ObfuscatedName("j")
   boolean field1317 = false;
   @ObfuscatedName("m")
   int[] field1318;

   @ObfuscatedName("f")
   void method1506(int var1) {
      if(this.field1318 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1314 == 1 || this.field1314 == 3) {
            if(field1312 == null || field1312.length < this.field1318.length) {
               field1312 = new int[this.field1318.length];
            }

            if(this.field1318.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1318.length;
            var4 = var2 * var1 * this.field1315;
            var5 = var3 - 1;
            if(this.field1314 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1312[var10] = this.field1318[var7];
            }

            var6 = this.field1318;
            this.field1318 = field1312;
            field1312 = var6;
         }

         if(this.field1314 == 2 || this.field1314 == 4) {
            if(field1312 == null || field1312.length < this.field1318.length) {
               field1312 = new int[this.field1318.length];
            }

            if(this.field1318.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1318.length;
            var4 = var1 * this.field1315;
            var5 = var2 - 1;
            if(this.field1314 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1312[var8] = this.field1318[var9];
               }
            }

            var6 = this.field1318;
            this.field1318 = field1312;
            field1312 = var6;
         }

      }
   }

   @ObfuscatedName("s")
   boolean method1507(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1306.length; ++var5) {
         if(var4.method3189(this.field1306[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1318 = new int[var5];

      for(int var6 = 0; var6 < this.field1306.length; ++var6) {
         int var8 = this.field1306[var6];
         ModIcon var7;
         if(!class154.method2922(var4, var8)) {
            var7 = null;
         } else {
            ModIcon var10 = new ModIcon();
            var10.width = class225.field3218;
            var10.originalHeight = class225.field3219;
            var10.offsetX = class181.field2710[0];
            var10.offsetY = class225.field3220[0];
            var10.originalWidth = class119.field1865[0];
            var10.height = class109.field1742[0];
            var10.palette = class225.field3217;
            var10.pixels = class44.field888[0];
            class30.method648();
            var7 = var10;
         }

         var7.method3923();
         byte[] var17 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1313[var6];
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
            var11[var13] = class84.method1600(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1311[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1318[var14] = var11[var17[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1318[var14++] = var11[var17[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1318[var14++] = var11[var17[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   class79(Buffer var1) {
      this.field1308 = var1.readUnsignedShort();
      this.field1309 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1306 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1306[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1311 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1311[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1305 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1305[var3] = var1.readUnsignedByte();
            }
         }

         this.field1313 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1313[var3] = var1.method2727();
         }

         this.field1314 = var1.readUnsignedByte();
         this.field1315 = var1.readUnsignedByte();
         this.field1318 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   void method1509() {
      this.field1318 = null;
   }
}

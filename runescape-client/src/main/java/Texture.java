import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
@Implements("Texture")
public class Texture extends Node {
   @ObfuscatedName("k")
   int[] field1879;
   @ObfuscatedName("s")
   int field1883;
   @ObfuscatedName("j")
   int[] field1884;
   @ObfuscatedName("v")
   @Export("fileIds")
   int[] fileIds;
   @ObfuscatedName("y")
   int[] field1886;
   @ObfuscatedName("c")
   static int[] field1887;
   @ObfuscatedName("e")
   int field1888;
   @ObfuscatedName("r")
   boolean field1889;
   @ObfuscatedName("l")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("z")
   @Export("pixels")
   int[] pixels;
   @ObfuscatedName("o")
   int field1892;

   @ObfuscatedName("i")
   boolean method2475(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.fileIds.length; ++var5) {
         if(var4.method4122(this.fileIds[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.pixels = new int[var5];

      for(int var6 = 0; var6 < this.fileIds.length; ++var6) {
         int var7 = this.fileIds[var6];
         ModIcon var8;
         if(!class95.method1783(var4, var7)) {
            var8 = null;
         } else {
            var8 = class268.set();
         }

         var8.method5022();
         byte[] var9 = var8.pixels;
         int[] var10 = var8.palette;
         int var11 = this.field1879[var6];
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
               if(var15 >> 8 == (var15 & '\uffff')) {
                  var15 &= 255;
                  var10[var14] = var12 * var15 >> 8 & 16711935 | var15 * var13 & '\uff00';
               }
            }
         }

         for(var12 = 0; var12 < var10.length; ++var12) {
            var10[var12] = Graphics3D.adjustRGB(var10[var12], var1);
         }

         if(var6 == 0) {
            var12 = 0;
         } else {
            var12 = this.field1886[var6 - 1];
         }

         if(var12 == 0) {
            if(var3 == var8.originalWidth) {
               for(var13 = 0; var13 < var5; ++var13) {
                  this.pixels[var13] = var10[var9[var13] & 255];
               }
            } else if(var8.originalWidth == 64 && var3 == 128) {
               var13 = 0;

               for(var14 = 0; var14 < var3; ++var14) {
                  for(var15 = 0; var15 < var3; ++var15) {
                     this.pixels[var13++] = var10[var9[(var14 >> 1 << 6) + (var15 >> 1)] & 255];
                  }
               }
            } else {
               if(var8.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var13 = 0;

               for(var14 = 0; var14 < var3; ++var14) {
                  for(var15 = 0; var15 < var3; ++var15) {
                     this.pixels[var13++] = var10[var9[(var15 << 1) + (var14 << 1 << 7)] & 255];
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

   @ObfuscatedName("w")
   @Export("resetPixels")
   void resetPixels() {
      this.pixels = null;
   }

   @ObfuscatedName("a")
   void method2477(int var1) {
      if(this.pixels != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var8;
         if(this.field1888 == 1 || this.field1888 == 3) {
            if(field1887 == null || field1887.length < this.pixels.length) {
               field1887 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = var2 * var1 * this.field1892;
            var5 = var3 - 1;
            if(this.field1888 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var4 + var6 & var5;
               field1887[var6] = this.pixels[var7];
            }

            var8 = this.pixels;
            this.pixels = field1887;
            field1887 = var8;
         }

         if(this.field1888 == 2 || this.field1888 == 4) {
            if(field1887 == null || field1887.length < this.pixels.length) {
               field1887 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = this.field1892 * var1;
            var5 = var2 - 1;
            if(this.field1888 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var9 = var7 + var6;
                  int var10 = (var7 + var4 & var5) + var6;
                  field1887[var9] = this.pixels[var10];
               }
            }

            var8 = this.pixels;
            this.pixels = field1887;
            field1887 = var8;
         }
      }

   }

   Texture(Buffer var1) {
      this.loaded = false;
      this.field1883 = var1.readUnsignedShort();
      this.field1889 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.fileIds = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.fileIds[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1886 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1886[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1884 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1884[var3] = var1.readUnsignedByte();
            }
         }

         this.field1879 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1879[var3] = var1.readInt();
         }

         this.field1888 = var1.readUnsignedByte();
         this.field1892 = var1.readUnsignedByte();
         this.pixels = null;
      } else {
         throw new RuntimeException();
      }
   }
}

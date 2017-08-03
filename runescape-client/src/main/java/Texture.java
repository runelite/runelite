import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Texture")
public class Texture extends Node {
   @ObfuscatedName("u")
   static int[] field1855;
   @ObfuscatedName("v")
   @Export("fileIds")
   int[] fileIds;
   @ObfuscatedName("o")
   @Export("pixels")
   int[] pixels;
   @ObfuscatedName("f")
   boolean field1846;
   @ObfuscatedName("p")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("g")
   int field1851;
   @ObfuscatedName("e")
   int field1847;
   @ObfuscatedName("r")
   int[] field1852;
   @ObfuscatedName("s")
   int field1845;
   @ObfuscatedName("t")
   int[] field1841;
   @ObfuscatedName("i")
   int[] field1849;

   @ObfuscatedSignature(
      signature = "(Lfw;)V"
   )
   Texture(Buffer var1) {
      this.loaded = false;
      this.field1847 = var1.readUnsignedShort();
      this.field1846 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.fileIds = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.fileIds[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1841 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1841[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1849 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1849[var3] = var1.readUnsignedByte();
            }
         }

         this.field1852 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1852[var3] = var1.readInt();
         }

         this.field1851 = var1.readUnsignedByte();
         this.field1845 = var1.readUnsignedByte();
         this.pixels = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @Export("resetPixels")
   void resetPixels() {
      this.pixels = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(DILim;)Z"
   )
   boolean method2495(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.fileIds.length; ++var5) {
         if(var4.method4117(this.fileIds[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.pixels = new int[var5];

      for(int var6 = 0; var6 < this.fileIds.length; ++var6) {
         int var8 = this.fileIds[var6];
         IndexedSprite var7;
         if(!class276.method4911(var4, var8)) {
            var7 = null;
         } else {
            IndexedSprite var10 = new IndexedSprite();
            var10.width = class286.field3779;
            var10.originalHeight = class286.field3780;
            var10.offsetX = class270.field3666[0];
            var10.offsetY = class286.offsetsY[0];
            var10.originalWidth = class286.field3778[0];
            var10.height = class286.field3782[0];
            var10.palette = class286.field3783;
            var10.pixels = class177.spritePixels[0];
            class229.method4093();
            var7 = var10;
         }

         var7.method5032();
         byte[] var17 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1852[var6];
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
            var11[var13] = Graphics3D.adjustRGB(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1841[var6 - 1];
         }

         if(var13 == 0) {
            if(var3 == var7.originalWidth) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.pixels[var14] = var11[var17[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var11[var17[(var15 >> 1 << 6) + (var16 >> 1)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var11[var17[(var16 << 1) + (var15 << 1 << 7)] & 255];
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
   void method2497(int var1) {
      if(this.pixels != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1851 == 1 || this.field1851 == 3) {
            if(field1855 == null || field1855.length < this.pixels.length) {
               field1855 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = var2 * this.field1845 * var1;
            var5 = var3 - 1;
            if(this.field1851 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1855[var6] = this.pixels[var7];
            }

            var10 = this.pixels;
            this.pixels = field1855;
            field1855 = var10;
         }

         if(this.field1851 == 2 || this.field1851 == 4) {
            if(field1855 == null || field1855.length < this.pixels.length) {
               field1855 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = this.field1845 * var1;
            var5 = var2 - 1;
            if(this.field1851 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1855[var8] = this.pixels[var9];
               }
            }

            var10 = this.pixels;
            this.pixels = field1855;
            field1855 = var10;
         }

      }
   }
}

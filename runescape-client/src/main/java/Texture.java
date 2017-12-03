import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("Texture")
public class Texture extends Node {
   @ObfuscatedName("y")
   static int[] field1775;
   @ObfuscatedName("u")
   int field1770;
   @ObfuscatedName("z")
   boolean field1761;
   @ObfuscatedName("t")
   @Export("fileIds")
   int[] fileIds;
   @ObfuscatedName("f")
   int[] field1768;
   @ObfuscatedName("g")
   int[] field1765;
   @ObfuscatedName("j")
   int[] field1769;
   @ObfuscatedName("x")
   int field1771;
   @ObfuscatedName("c")
   int field1767;
   @ObfuscatedName("s")
   @Export("pixels")
   int[] pixels;
   @ObfuscatedName("n")
   @Export("loaded")
   boolean loaded;

   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   Texture(Buffer var1) {
      this.loaded = false;
      this.field1770 = var1.readUnsignedShort();
      this.field1761 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.fileIds = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.fileIds[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1768 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1768[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1765 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1765[var3] = var1.readUnsignedByte();
            }
         }

         this.field1769 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1769[var3] = var1.readInt();
         }

         this.field1771 = var1.readUnsignedByte();
         this.field1767 = var1.readUnsignedByte();
         this.pixels = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(DILib;)Z"
   )
   boolean method2495(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.fileIds.length; ++var5) {
         if(var4.getRecordFlat(this.fileIds[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.pixels = new int[var5];

      for(int var6 = 0; var6 < this.fileIds.length; ++var6) {
         int var8 = this.fileIds[var6];
         byte[] var10 = var4.takeRecordFlat(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            CacheFile.decodeSprite(var10);
            var9 = true;
         }

         IndexedSprite var7;
         if(!var9) {
            var7 = null;
         } else {
            var7 = MilliTimer.method2946();
         }

         var7.normalize();
         var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1769[var6];
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
               if(var16 >> 8 == (var16 & 65535)) {
                  var16 &= 255;
                  var11[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & 65280;
               }
            }
         }

         for(var13 = 0; var13 < var11.length; ++var13) {
            var11[var13] = Graphics3D.adjustRGB(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1768[var6 - 1];
         }

         if(var13 == 0) {
            if(var3 == var7.originalWidth) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.pixels[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var11[var10[(var15 >> 1 << 6) + (var16 >> 1)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("w")
   @Export("resetPixels")
   void resetPixels() {
      this.pixels = null;
   }

   @ObfuscatedName("e")
   void method2502(int var1) {
      if(this.pixels != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1771 == 1 || this.field1771 == 3) {
            if(field1775 == null || field1775.length < this.pixels.length) {
               field1775 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = var2 * this.field1767 * var1;
            var5 = var3 - 1;
            if(this.field1771 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1775[var6] = this.pixels[var7];
            }

            var10 = this.pixels;
            this.pixels = field1775;
            field1775 = var10;
         }

         if(this.field1771 == 2 || this.field1771 == 4) {
            if(field1775 == null || field1775.length < this.pixels.length) {
               field1775 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = this.field1767 * var1;
            var5 = var2 - 1;
            if(this.field1771 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1775[var8] = this.pixels[var9];
               }
            }

            var10 = this.pixels;
            this.pixels = field1775;
            field1775 = var10;
         }

      }
   }
}

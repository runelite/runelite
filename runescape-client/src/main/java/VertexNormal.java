import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field1966;
   @ObfuscatedName("ov")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("j")
   static int[] field1970;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1870301765
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2067580631
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -288502447
   )
   @Export("z")
   int z;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1826101339
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lec;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-28963"
   )
   static int method2522(int var0, int var1) {
      Overlay var2 = class157.method2908(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var4;
         int var5;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            byte var11 = 96;
            int var3;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var11 < 0) {
                  var11 = 0;
               } else if(var11 > 127) {
                  var11 = 127;
               }

               var5 = 127 - var11;
               var3 = var5;
            } else {
               var5 = var11 * (var4 & 127) / 128;
               if(var5 < 2) {
                  var5 = 2;
               } else if(var5 > 126) {
                  var5 = 126;
               }

               var3 = var5 + (var4 & 'ﾀ');
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var4 = var2.hue;
            var5 = var2.saturation;
            int var6 = var2.lightness;
            if(var6 > 179) {
               var5 /= 2;
            }

            if(var6 > 192) {
               var5 /= 2;
            }

            if(var6 > 217) {
               var5 /= 2;
            }

            if(var6 > 243) {
               var5 /= 2;
            }

            int var7 = (var4 / 4 << 10) + (var5 / 32 << 7) + var6 / 2;
            byte var9 = 96;
            int var8;
            if(var7 == -2) {
               var8 = 12345678;
            } else {
               int var12;
               if(var7 == -1) {
                  if(var9 < 0) {
                     var9 = 0;
                  } else if(var9 > 127) {
                     var9 = 127;
                  }

                  var12 = 127 - var9;
                  var8 = var12;
               } else {
                  var12 = var9 * (var7 & 127) / 128;
                  if(var12 < 2) {
                     var12 = 2;
                  } else if(var12 > 126) {
                     var12 = 126;
                  }

                  var8 = var12 + (var7 & 'ﾀ');
               }
            }

            return Graphics3D.colorPalette[var8] | -16777216;
         }
      }
   }
}

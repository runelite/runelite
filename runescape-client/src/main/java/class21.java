import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class21 {
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "3618"
   )
   static int method153(int var0, int var1) {
      Overlay var2 = class150.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = Permission.method4283(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
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

         int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         int var8 = Permission.method4283(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }
}

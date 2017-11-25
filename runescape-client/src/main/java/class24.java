import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class24 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field343;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field341;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field342;
   @ObfuscatedName("t")
   static ScheduledExecutorService field347;
   @ObfuscatedName("z")
   final String field344;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1574607425
   )
   final int field340;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1199930009
   )
   final int field345;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1168822369
   )
   final int field346;

   static {
      field343 = new class24("SMALL", 2, 0, 4);
      field341 = new class24("MEDIUM", 1, 1, 2);
      field342 = new class24("LARGE", 0, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field344 = var1;
      this.field340 = var2;
      this.field345 = var3;
      this.field346 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "608147523"
   )
   boolean method184(float var1) {
      return var1 >= (float)this.field346;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1845849971"
   )
   static int method182(int var0, int var1) {
      Overlay var2 = class41.method570(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = PacketNode.method3213(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
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
         int var8 = PacketNode.method3213(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }
}

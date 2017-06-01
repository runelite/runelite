import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1558709931
   )
   @Export("width")
   public int width;
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -355612887
   )
   @Export("height")
   public int height;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1972128247"
   )
   public final void method4998() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "8"
   )
   public abstract void vmethod5000(int var1, int var2, int var3, int var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2084057509"
   )
   public abstract void vmethod5008(int var1, int var2);
}

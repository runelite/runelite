import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("i")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1782271605
   )
   @Export("width")
   public int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1928173387
   )
   @Export("height")
   public int height;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "97"
   )
   public abstract void vmethod5235(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   public abstract void vmethod5233(int var1, int var2, int var3, int var4);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

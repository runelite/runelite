import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("f")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1709097729
   )
   @Export("width")
   public int width;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1289334111
   )
   @Export("height")
   public int height;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public abstract void vmethod5043(int var1, int var2);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "17301"
   )
   public abstract void vmethod5042(int var1, int var2, int var3, int var4);
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lf")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("i")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1381409071
   )
   @Export("width")
   public int width;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 34785573
   )
   @Export("height")
   public int height;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1238219303"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-703209304"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1061668708"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

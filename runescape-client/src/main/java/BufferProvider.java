import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("t")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1571207673
   )
   @Export("width")
   public int width;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1585092145
   )
   @Export("height")
   public int height;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1841567434"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "781723263"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-890771887"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

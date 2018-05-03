import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("b")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -203501949
   )
   @Export("width")
   public int width;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -918146377
   )
   @Export("height")
   public int height;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-360800952"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1782370233"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "862890977"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("q")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1635145089
   )
   @Export("width")
   public int width;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1906369409
   )
   @Export("height")
   public int height;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "31"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1328513548"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "753961560"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

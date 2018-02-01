import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("w")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -614518963
   )
   @Export("width")
   public int width;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 922823137
   )
   @Export("height")
   public int height;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "27"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "48"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1069739227"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

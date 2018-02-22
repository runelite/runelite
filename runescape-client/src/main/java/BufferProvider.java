import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("o")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1414319845
   )
   @Export("width")
   public int width;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -740140269
   )
   @Export("height")
   public int height;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "796344565"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-797323028"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-73518604"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

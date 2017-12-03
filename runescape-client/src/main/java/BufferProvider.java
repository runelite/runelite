import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1870118989
   )
   @Export("width")
   public int width;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 205368253
   )
   @Export("height")
   public int height;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1763504301"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-8"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1333475768"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

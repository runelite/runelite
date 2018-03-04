import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   public static Font field3959;
   @ObfuscatedName("n")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1830666447
   )
   @Export("width")
   public int width;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 426861077
   )
   @Export("height")
   public int height;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1823139136"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "13460"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "509015790"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

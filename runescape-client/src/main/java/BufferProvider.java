import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("m")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1657729671
   )
   @Export("width")
   public int width;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -43012475
   )
   @Export("height")
   public int height;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2021152832"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1217061868"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-36144488"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

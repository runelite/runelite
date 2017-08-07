import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("g")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -463104879
   )
   @Export("width")
   public int width;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1077256209
   )
   @Export("height")
   public int height;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "615807006"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1762876193"
   )
   public abstract void vmethod5051(int var1, int var2);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "956761948"
   )
   public abstract void vmethod5052(int var1, int var2, int var3, int var4);
}

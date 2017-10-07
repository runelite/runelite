import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("y")
   public static boolean field3778;
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -691802281
   )
   @Export("width")
   public int width;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1023163507
   )
   @Export("height")
   public int height;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "565405906"
   )
   public abstract void vmethod5136(int var1, int var2);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1475822132"
   )
   public abstract void vmethod5133(int var1, int var2, int var3, int var4);
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1489632629
   )
   static int field3744;
   @ObfuscatedName("x")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1304207463
   )
   @Export("width")
   public int width;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 954906915
   )
   @Export("height")
   public int height;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "837436557"
   )
   public abstract void vmethod5019(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1607621074"
   )
   public abstract void vmethod5018(int var1, int var2, int var3, int var4);
}

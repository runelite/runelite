import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("q")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -241308853
   )
   @Export("width")
   public int width;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -754284475
   )
   @Export("height")
   public int height;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1969740140"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1537713348"
   )
   public abstract void vmethod5121(int var1, int var2);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1204560851"
   )
   public abstract void vmethod5123(int var1, int var2, int var3, int var4);
}

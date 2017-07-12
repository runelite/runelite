import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("a")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2104431373
   )
   @Export("width")
   public int width;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 962047943
   )
   @Export("height")
   public int height;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1671840633"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "68"
   )
   public abstract void vmethod5007(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "119"
   )
   public abstract void vmethod5008(int var1, int var2, int var3, int var4);
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("n")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1741846837
   )
   @Export("width")
   public int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1131218591
   )
   @Export("height")
   public int height;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-454483166"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1528663056"
   )
   public abstract void vmethod4942(int var1, int var2);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "660661972"
   )
   public abstract void vmethod4935(int var1, int var2, int var3, int var4);
}

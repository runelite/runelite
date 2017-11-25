import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("k")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -741947281
   )
   @Export("width")
   public int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2089244745
   )
   @Export("height")
   public int height;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1675289646"
   )
   public abstract void vmethod5222(int var1, int var2);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1986712912"
   )
   public abstract void vmethod5225(int var1, int var2, int var3, int var4);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-213864549"
   )
   public static boolean method5233(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2126286277
   )
   @Export("width")
   public int width;
   @ObfuscatedName("u")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1796242355
   )
   @Export("height")
   public int height;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   public final void method5082() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1113058415"
   )
   public abstract void vmethod5083(int var1, int var2);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "128721490"
   )
   public abstract void vmethod5084(int var1, int var2, int var3, int var4);
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1946837041
   )
   @Export("height")
   public int height;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2132424597
   )
   @Export("width")
   public int width;
   @ObfuscatedName("i")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   public final void method5051() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1868232356"
   )
   public abstract void vmethod5052(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1263158463"
   )
   public abstract void vmethod5053(int var1, int var2, int var3, int var4);
}

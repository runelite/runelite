import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1792428687
   )
   static int field3759;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -428051575
   )
   @Export("width")
   public int width;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1908619845
   )
   @Export("height")
   public int height;
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   public abstract void vmethod4896(int var1, int var2, int var3, int var4);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "290843664"
   )
   public abstract void vmethod4897(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final void method4898() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}

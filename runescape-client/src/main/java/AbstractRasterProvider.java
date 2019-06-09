import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
   @ObfuscatedName("ca")
   @Export("__lp_ca")
   static boolean __lp_ca;
   @ObfuscatedName("q")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -560298363
   )
   @Export("width")
   public int width;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -239960145
   )
   @Export("height")
   public int height;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-430495007"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "18"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "152864133"
   )
   @Export("apply")
   public final void apply() {
      Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
   }
}

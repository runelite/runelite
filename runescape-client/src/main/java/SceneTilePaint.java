import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1794297805
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 442795009
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1836014679
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 659303565
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 752831123
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("f")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1329158355
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2144370116"
   )
   static final boolean method2684() {
      return class133.field1903;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)V",
      garbageValue = "255"
   )
   static final void method2685(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2757(var0, var1, var2);
      int[] var8 = Region.method2757(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-630723691"
   )
   static final int method2686(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}

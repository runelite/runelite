import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1347687077
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -18770937
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -448684097
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -319993733
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 940147599
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1768517335
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("x")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 897907373
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-178352703"
   )
   static int method2872() {
      return ++class95.field1435 - 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1551059774"
   )
   public static int method2873(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}

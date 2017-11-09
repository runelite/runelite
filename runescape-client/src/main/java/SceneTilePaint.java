import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 329415925
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1359823575
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1307430307
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1843697791
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -627951817
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("x")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 187024375
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "25"
   )
   public static String method2776(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}

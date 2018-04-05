import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lch;"
   )
   @Export("varcs")
   static Varcs varcs;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   public static class110 field1965;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -461502155
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1876354657
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 388623757
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1144265985
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1180059279
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("m")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2019336673
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
}
